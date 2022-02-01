package com.tencent.ilivesdk.giftservice;

import android.content.Context;
import android.graphics.Point;
import com.google.protobuf.nano.MessageNano;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.CsTask;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.utils.StringUtil;
import com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnPresentGiftCallback;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryAllGiftsInfoCallback;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryGiftInfoCallback;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.ReceiveGiftMessageListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo.GiftNewEffect;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import com.tencent.ilivesdk.giftservice_interface.model.TabInfo;
import com.tencent.protobuf.iliveGiftInfoNew.nano.GiftInfoRsp;
import com.tencent.protobuf.iliveGiftInfoNew.nano.GiftNewEffect;
import com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftReq;
import com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewReq;
import com.tencent.protobuf.payGiftSvr.nano.GivePayGiftReq;
import com.tencent.protobuf.payGiftSvr.nano.ILiveGiftSite;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftService
  implements GiftServiceInterface
{
  private static final int SEND_GIFT_OVER_TYPE = 5;
  private static final int SEND_GIFT_TYPE = 4;
  private static final String TAG = "GiftService";
  private final int CSBROADCAST_AppID_HANDSELGIFT = 1011;
  private final int CSBROADCAST_AppID_NEWGIFT = 3011;
  private Map<Integer, GiftInfo> mAllGifts = new HashMap();
  private Context mContext;
  private GiftEffectResourceController mGiftEffectResourceController = new GiftEffectResourceController();
  private Map<Integer, Integer> mGiftID2Type = new HashMap();
  private String mGiftLogoFormatKey = "https://now8.gtimg.com/huayang/resource/%s?timastamp=%d";
  private PushReceiver mGiftPushReceiver;
  private long mGiftRoomId;
  private Map<Integer, List<GiftInfo>> mGiftsList;
  private Map<Integer, GiftInfo> mHeartGifts;
  private int mLastLeftBalance;
  private Set<GiftServiceInterface.ReceiveGiftMessageListener> mReceiveGiftMessageListeners = new HashSet();
  private List<GiftInfo> mRepositoryGiftsList;
  private GiftServiceAdapter mServiceAdapter;
  private List<TabInfo> mTabInfoList;
  
  private GiftInfo transRawDataToGiftInfo(GiftInfoRsp paramGiftInfoRsp)
  {
    GiftInfo localGiftInfo = new GiftInfo();
    localGiftInfo.mGiftId = paramGiftInfoRsp.giftId;
    localGiftInfo.mGiftName = new String(paramGiftInfoRsp.giftName, StandardCharsets.UTF_8);
    localGiftInfo.mPrice = paramGiftInfoRsp.price;
    localGiftInfo.mDefaultCount = paramGiftInfoRsp.defaultNum;
    localGiftInfo.mPriority = paramGiftInfoRsp.priority;
    localGiftInfo.mTimestamp = paramGiftInfoRsp.timestamp;
    localGiftInfo.mSmallIcon = new String(paramGiftInfoRsp.smallIcon, StandardCharsets.UTF_8);
    localGiftInfo.mMiddleIcon = new String(paramGiftInfoRsp.middleIcon, StandardCharsets.UTF_8);
    localGiftInfo.mBigIcon = new String(paramGiftInfoRsp.bigIcon, StandardCharsets.UTF_8);
    localGiftInfo.mGiftType = paramGiftInfoRsp.giftType;
    localGiftInfo.mApngUrl = new String(paramGiftInfoRsp.apngUrl, StandardCharsets.UTF_8);
    localGiftInfo.mEffectId = new String(paramGiftInfoRsp.effectId, StandardCharsets.UTF_8);
    localGiftInfo.mComment = new String(paramGiftInfoRsp.comment, StandardCharsets.UTF_8);
    localGiftInfo.mNobelType = paramGiftInfoRsp.nobelType;
    localGiftInfo.mEffectType = paramGiftInfoRsp.effectType;
    localGiftInfo.mGiftScene = paramGiftInfoRsp.giftScene;
    localGiftInfo.mActiveIcon = new String(paramGiftInfoRsp.activeIcon, StandardCharsets.UTF_8);
    localGiftInfo.mGiftComment = paramGiftInfoRsp.giftComment;
    localGiftInfo.mIsLocked = paramGiftInfoRsp.isLocked;
    localGiftInfo.mTagUrl = paramGiftInfoRsp.tagUrl;
    ArrayList localArrayList = new ArrayList();
    if (paramGiftInfoRsp.clickEffectList.length > 0)
    {
      paramGiftInfoRsp = paramGiftInfoRsp.clickEffectList;
      int j = paramGiftInfoRsp.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramGiftInfoRsp[i];
        localGiftInfo.getClass();
        GiftInfo.GiftNewEffect localGiftNewEffect = new GiftInfo.GiftNewEffect(localGiftInfo);
        localGiftNewEffect.mEffectNum = localObject.effectNum;
        localGiftNewEffect.mEffectId = new String(localObject.effectId, StandardCharsets.UTF_8);
        localGiftNewEffect.mEffectType = localObject.effectType;
        localGiftNewEffect.mEffectWord = new String(localObject.effectWord, StandardCharsets.UTF_8);
        localArrayList.add(localGiftNewEffect);
        getServiceAdapter().getLogger().d("GiftService", "giftid:%d,efffect_num:%d", new Object[] { Integer.valueOf(localGiftInfo.mGiftId), Integer.valueOf(localGiftNewEffect.mEffectNum) });
        i += 1;
      }
      Collections.sort(localArrayList, new GiftService.5(this));
      localGiftInfo.mClickEffectList = localArrayList;
    }
    return localGiftInfo;
  }
  
  public void addReceiveGiftMessageListener(GiftServiceInterface.ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    this.mReceiveGiftMessageListeners.add(paramReceiveGiftMessageListener);
  }
  
  public boolean canShowLuxuryAnimation(GiftMessage paramGiftMessage, GiftInfo paramGiftInfo)
  {
    if (paramGiftMessage != null)
    {
      if (paramGiftInfo == null) {
        return false;
      }
      if (paramGiftInfo.mClickEffectList != null)
      {
        if (paramGiftInfo.mClickEffectList.size() == 0) {
          return false;
        }
        if (paramGiftInfo.mClickEffectList.size() > 1)
        {
          Iterator localIterator = paramGiftInfo.mClickEffectList.iterator();
          while (localIterator.hasNext())
          {
            GiftInfo.GiftNewEffect localGiftNewEffect = (GiftInfo.GiftNewEffect)localIterator.next();
            if (localGiftNewEffect.mEffectNum > paramGiftMessage.mComboCount) {
              return false;
            }
            if ((paramGiftInfo.mGiftType != 106) || (localGiftNewEffect.mEffectNum == 0))
            {
              if (localGiftNewEffect.mEffectNum == 1) {
                return true;
              }
              if (paramGiftMessage.mComboCount == localGiftNewEffect.mEffectNum) {
                return true;
              }
            }
          }
          return false;
        }
        paramGiftInfo = (GiftInfo.GiftNewEffect)paramGiftInfo.mClickEffectList.get(0);
        do
        {
          if (paramGiftInfo.mEffectNum == 1) {
            return true;
          }
        } while (paramGiftMessage.mComboCount != paramGiftInfo.mEffectNum);
        return true;
      }
    }
    return false;
  }
  
  public void clearEventOutput()
  {
    this.mReceiveGiftMessageListeners.clear();
  }
  
  public void delReceiveGiftMessageListener(GiftServiceInterface.ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    this.mReceiveGiftMessageListeners.remove(paramReceiveGiftMessageListener);
  }
  
  public void downloadGiftEffectResource(Map<Integer, List<GiftInfo>> paramMap, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    int j = 0;
    if (paramMap == null)
    {
      getServiceAdapter().getLogger().e("GiftService", "query gifts list is null", new Object[0]);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      if (localObject1 != null)
      {
        localObject1 = (List)((Map.Entry)localObject1).getValue();
        if (localObject1 != null)
        {
          i = 0;
          while (i < ((List)localObject1).size())
          {
            if (((List)localObject1).get(i) != null)
            {
              Object localObject2 = (GiftInfo)((List)localObject1).get(i);
              if (StringUtil.isEmpty(((GiftInfo)localObject2).mEffectId))
              {
                if (((GiftInfo)localObject2).mNewEffectList != null)
                {
                  localObject2 = ((GiftInfo)localObject2).mNewEffectList.iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    GiftInfo.GiftNewEffect localGiftNewEffect = (GiftInfo.GiftNewEffect)((Iterator)localObject2).next();
                    if ((localGiftNewEffect != null) && (!StringUtil.isEmpty(localGiftNewEffect.mEffectId)) && (!localArrayList.contains(localGiftNewEffect.mEffectId))) {
                      localArrayList.add(localGiftNewEffect.mEffectId);
                    }
                  }
                }
              }
              else if (!localArrayList.contains(((GiftInfo)localObject2).mEffectId)) {
                localArrayList.add(((GiftInfo)localObject2).mEffectId);
              }
            }
            i += 1;
          }
        }
      }
    }
    paramMap = new ArrayList();
    int i = j;
    while (i < localArrayList.size())
    {
      paramMap.add(i, localArrayList.get(i));
      i += 1;
    }
    this.mGiftEffectResourceController.setGetGiftEffectResInfoListener(paramIGetGiftEffectResInfoListener);
    this.mGiftEffectResourceController.setGetGiftEffectResListener(paramIGetGiftEffectResListener);
    this.mGiftEffectResourceController.queryH264GiftInfo((ArrayList)localArrayList, null);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public GiftEffectResourceController getGiftEffectResourceController()
  {
    return this.mGiftEffectResourceController;
  }
  
  public GiftInfo getGiftInfo(int paramInt)
  {
    if (this.mAllGifts.get(Integer.valueOf(paramInt)) != null) {
      return (GiftInfo)this.mAllGifts.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public String getGiftLogoUrl(String paramString, long paramLong)
  {
    Object localObject3 = this.mServiceAdapter.updateGiftLogoFormatKey();
    StringBuilder localStringBuilder = null;
    Object localObject1 = localStringBuilder;
    if (localObject3 != null) {
      try
      {
        localObject3 = (String)this.mServiceAdapter.updateGiftLogoFormatKey().get("gift_logo_pic");
        boolean bool = StringUtil.isEmpty((String)localObject3);
        localObject1 = localStringBuilder;
        if (!bool) {
          localObject1 = localObject3;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = localStringBuilder;
      }
    }
    if (!StringUtil.isEmpty((String)localObject2)) {
      this.mGiftLogoFormatKey = ((String)localObject2);
    }
    paramString = String.format(this.mGiftLogoFormatKey, new Object[] { paramString, Long.valueOf(paramLong) });
    Object localObject2 = this.mServiceAdapter.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftLogoUrl urlString = \n");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject2).d("GiftService", localStringBuilder.toString(), new Object[0]);
    return paramString;
  }
  
  public GiftServiceAdapter getServiceAdapter()
  {
    return this.mServiceAdapter;
  }
  
  public void init(GiftServiceAdapter paramGiftServiceAdapter)
  {
    this.mServiceAdapter = paramGiftServiceAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
    this.mGiftEffectResourceController.init(this.mContext, this);
    paramContext = getServiceAdapter().createPushReceiver();
    if (paramContext != null) {
      this.mGiftPushReceiver = paramContext.init(48, new GiftService.1(this));
    }
  }
  
  public void onDestroy()
  {
    PushReceiver localPushReceiver = this.mGiftPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.unInit();
    }
    this.mGiftEffectResourceController.onDestroy();
  }
  
  public void presentGift(GiftMessage paramGiftMessage, GiftServiceInterface.OnPresentGiftCallback paramOnPresentGiftCallback)
  {
    getServiceAdapter().getLogger().i("GiftService", "presentGift", new Object[0]);
    GivePayGiftReq localGivePayGiftReq = new GivePayGiftReq();
    localGivePayGiftReq.anchorUin = paramGiftMessage.mAnchorId;
    localGivePayGiftReq.roomId = paramGiftMessage.mRoomId;
    localGivePayGiftReq.subRoomId = paramGiftMessage.mSubRoomId;
    localGivePayGiftReq.giftType = paramGiftMessage.mGiftType;
    localGivePayGiftReq.giftId = paramGiftMessage.mGiftId;
    localGivePayGiftReq.giftNum = paramGiftMessage.mGiftNum;
    localGivePayGiftReq.comboCount = paramGiftMessage.mComboCount;
    localGivePayGiftReq.comboSeq = ((int)paramGiftMessage.mComboSeq);
    localGivePayGiftReq.fromType = paramGiftMessage.mFromType;
    localGivePayGiftReq.playUid = paramGiftMessage.mPlayUid;
    Object localObject2 = paramGiftMessage.mCustomizedPoints;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Point localPoint = (Point)((Iterator)localObject2).next();
        ILiveGiftSite localILiveGiftSite = new ILiveGiftSite();
        localILiveGiftSite.x = localPoint.x;
        localILiveGiftSite.y = localPoint.y;
        ((List)localObject1).add(localILiveGiftSite);
      }
      localGivePayGiftReq.iLiveGiftSites = ((ILiveGiftSite[])((List)localObject1).toArray(new ILiveGiftSite[0]));
    }
    getServiceAdapter().getLogger().i("GiftService", "send gift...(giftId=%d, roomId=%d, subRoomId=%d, count=%d, comboCount=%d, fromType=%d)", new Object[] { Integer.valueOf(localGivePayGiftReq.giftId), Long.valueOf(localGivePayGiftReq.roomId), Long.valueOf(localGivePayGiftReq.subRoomId), Integer.valueOf(localGivePayGiftReq.giftNum), Integer.valueOf(localGivePayGiftReq.comboCount), Integer.valueOf(localGivePayGiftReq.fromType) });
    Object localObject1 = MessageNano.toByteArray(localGivePayGiftReq);
    getServiceAdapter().getChannel().send(1552, 1, (byte[])localObject1, new GiftService.3(this, paramOnPresentGiftCallback, paramGiftMessage, localGivePayGiftReq));
  }
  
  public void queryAllGiftsInfo(long paramLong, int paramInt, GiftServiceInterface.OnQueryAllGiftsInfoCallback paramOnQueryAllGiftsInfoCallback)
  {
    getServiceAdapter().getLogger().i("GiftService", "queryAllGiftsInfo", new Object[0]);
    Object localObject1 = new PersonGiftListNewReq();
    if (paramLong <= 0L)
    {
      Object localObject2 = getServiceAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryAllGiftsInfo roomId <= 0 is ");
      localStringBuilder.append(paramLong);
      ((LogInterface)localObject2).e("GiftService", localStringBuilder.toString(), new Object[0]);
      if (this.mServiceAdapter.getAppInfo().isDebug())
      {
        localObject2 = this.mServiceAdapter.getToastInterface();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryAllGiftsInfo roomid = ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("赶紧找开发onehuang看看");
        ((ToastInterface)localObject2).showToast(localStringBuilder.toString(), 1);
      }
    }
    ((PersonGiftListNewReq)localObject1).roomId = paramLong;
    ((PersonGiftListNewReq)localObject1).roomType = paramInt;
    localObject1 = MessageNano.toByteArray((MessageNano)localObject1);
    getServiceAdapter().getChannel().createCsTask().cmd(1511, 119).callback(new GiftService.2(this, paramLong, paramOnQueryAllGiftsInfoCallback)).send((byte[])localObject1).retryOnError(3);
  }
  
  public void queryGiftInfo(int paramInt, GiftServiceInterface.OnQueryGiftInfoCallback paramOnQueryGiftInfoCallback)
  {
    if (this.mAllGifts.get(Integer.valueOf(paramInt)) != null)
    {
      paramOnQueryGiftInfoCallback.onGetGiftInfo((GiftInfo)this.mAllGifts.get(Integer.valueOf(paramInt)));
      return;
    }
    Object localObject1 = new PersonGetGiftReq();
    ((PersonGetGiftReq)localObject1).giftId = paramInt;
    ((PersonGetGiftReq)localObject1).roomId = this.mServiceAdapter.getRoomId();
    if (((PersonGetGiftReq)localObject1).roomId <= 0L)
    {
      Object localObject2 = getServiceAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryGiftInfo roomId <= 0 is ");
      localStringBuilder.append(((PersonGetGiftReq)localObject1).roomId);
      ((LogInterface)localObject2).e("GiftService", localStringBuilder.toString(), new Object[0]);
      if (this.mServiceAdapter.getAppInfo().isDebug())
      {
        localObject2 = this.mServiceAdapter.getToastInterface();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryGiftInfo roomid = ");
        localStringBuilder.append(((PersonGetGiftReq)localObject1).roomId);
        localStringBuilder.append("赶紧找开发onehuang看看");
        ((ToastInterface)localObject2).showToast(localStringBuilder.toString(), 1);
      }
    }
    ((PersonGetGiftReq)localObject1).subRoomId = this.mServiceAdapter.getRoomId();
    localObject1 = MessageNano.toByteArray((MessageNano)localObject1);
    getServiceAdapter().getChannel().send(1511, 39, (byte[])localObject1, new GiftService.4(this, paramOnQueryGiftInfoCallback));
  }
  
  public void queryH264GiftInfo(ArrayList<String> paramArrayList, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener)
  {
    this.mGiftEffectResourceController.queryH264GiftInfo(paramArrayList, paramIGetGiftEffectResInfoListener);
  }
  
  public void queryH264GiftRes(List<GiftEffectResourceInfo> paramList, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    this.mGiftEffectResourceController.queryH264GiftRes(paramList, paramIGetGiftEffectResListener);
  }
  
  public void startPushListen() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService
 * JD-Core Version:    0.7.0.1
 */