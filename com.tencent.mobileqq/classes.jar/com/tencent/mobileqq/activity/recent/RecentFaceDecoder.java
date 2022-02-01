package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RecentFaceDecoder
{
  private static List<Integer> c = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(10004), Integer.valueOf(1020), Integer.valueOf(1003), Integer.valueOf(1005), Integer.valueOf(1004), Integer.valueOf(1008), Integer.valueOf(10005), Integer.valueOf(1009), Integer.valueOf(1021), Integer.valueOf(1022), Integer.valueOf(1023), Integer.valueOf(1024), Integer.valueOf(1025), Integer.valueOf(7400), Integer.valueOf(8112), Integer.valueOf(10008), Integer.valueOf(10010), Integer.valueOf(10013) });
  private static List<Integer> d = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1010), Integer.valueOf(10002) });
  private static HashMap<Integer, Integer> e = new HashMap();
  private static HashMap<Integer, Integer> f = new HashMap();
  public IFaceDecoder a;
  protected QQAppInterface b;
  private boolean g;
  private DecodeTaskCompletionListener h;
  private boolean i = false;
  private boolean j = false;
  
  static
  {
    d();
    e();
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.g = true;
    this.b = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this(paramQQAppInterface, paramDecodeTaskCompletionListener, false);
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, boolean paramBoolean)
  {
    this.a = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.a.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
    this.h = paramDecodeTaskCompletionListener;
    this.b = paramQQAppInterface;
    this.i = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 11)
        {
          if (paramInt != 32)
          {
            if (paramInt != 107)
            {
              if ((paramInt != 113) && (paramInt != 1001))
              {
                if (paramInt != 115) {
                  if (paramInt == 116) {}
                }
                switch (paramInt)
                {
                default: 
                  return null;
                case 103: 
                  return ImageUtil.d();
                case 102: 
                  return ImageUtil.d(102);
                  return Util.a(6);
                  return ImageUtil.a(true);
                }
              }
              return ImageUtil.h();
            }
            return ImageUtil.d(107);
          }
          return ImageUtil.j();
        }
        return ImageUtil.j();
      }
      return ImageUtil.f();
    }
    return ImageUtil.j();
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    boolean bool = e.containsKey(Integer.valueOf(paramInt));
    Integer localInteger = Integer.valueOf(-2147483648);
    if (bool) {
      return new Pair(e.get(Integer.valueOf(paramInt)), localInteger);
    }
    if (f.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(localInteger, f.get(Integer.valueOf(paramInt)));
    }
    if (c.contains(Integer.valueOf(paramInt))) {
      return b(paramString);
    }
    if (d.contains(Integer.valueOf(paramInt))) {
      return a(paramString);
    }
    return b(paramQQAppInterface, paramInt, paramString);
  }
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    boolean bool = String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString);
    int m = -2147483648;
    int k;
    if (bool)
    {
      k = 2130841177;
    }
    else if (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString))
    {
      k = 2130847121;
    }
    else if (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString))
    {
      k = 2130847120;
    }
    else if (AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString))
    {
      if (((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby()) {
        k = 2130847123;
      } else {
        k = 2130847122;
      }
    }
    else if (AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(paramString))
    {
      k = 2130847119;
    }
    else if (AppConstants.MSG_BOX_YANZHI_UIN.equals(paramString))
    {
      k = 2130847124;
    }
    else
    {
      k = -2147483648;
      m = 32;
    }
    return Pair.create(Integer.valueOf(m), Integer.valueOf(k));
  }
  
  public static boolean a(int paramInt, RecentBaseData paramRecentBaseData)
  {
    return (paramInt == 10005) && ((paramRecentBaseData instanceof RecentItemImaxADData)) && (!TextUtils.isEmpty(((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl));
  }
  
  private Drawable b(String paramString, int paramInt)
  {
    if (paramInt == 104) {
      return DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
    }
    if (paramInt == 105)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.b, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.c() != null)) {
        return paramString.c();
      }
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.b, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.c() != null)) {
        paramString = paramString.c();
      } else {
        paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 3);
      }
      return ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getSpecAggregateAvatarForKanDian(paramString);
    }
    if (paramInt == 106) {
      return EcShopAssistantManager.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((BlessManager)this.b.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).A();
    }
    if (paramInt == 110)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.b, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.c() != null)) {
        return paramString.c();
      }
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.g());
    }
    if (paramInt == 116) {
      return Util.a(this.b, paramString);
    }
    return null;
  }
  
  private static Pair<Integer, Integer> b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = 2130846430;
    int m = -2147483648;
    if (paramInt != 1)
    {
      if (paramInt != 1032)
      {
        if (paramInt != 7000)
        {
          if (paramInt != 7120)
          {
            if (paramInt != 7230)
            {
              if (paramInt != 9501)
              {
                if (paramInt != 10015)
                {
                  paramInt = -2147483648;
                  k = m;
                }
                else
                {
                  paramInt = 2130846694;
                  k = m;
                }
              }
              else
              {
                k = 104;
                paramInt = 2130839777;
              }
            }
            else
            {
              if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
                paramInt = ServiceAccountFolderManager.g();
              } else {
                paramInt = 2147483647;
              }
              k = 112;
            }
          }
          else
          {
            k = 106;
            paramInt = 2130848921;
          }
        }
        else if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
        {
          paramInt = 2130841183;
          k = m;
        }
        else
        {
          paramInt = -2147483648;
          k = 103;
        }
      }
      else if (TextUtils.equals(paramString, AppConstants.CONFESS_UIN))
      {
        paramInt = k;
        k = m;
      }
      else
      {
        paramInt = k;
        k = m;
        if (TextUtils.equals(paramString, AppConstants.CONFESS_FRD_REC_UIN))
        {
          paramInt = 2130846431;
          k = m;
        }
      }
    }
    else
    {
      HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
      if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
      {
        paramInt = HotChatManager.a(paramString, paramQQAppInterface);
        k = m;
      }
      else if (TroopUtils.b(paramString))
      {
        paramInt = -2147483648;
        k = 4;
      }
      else
      {
        paramInt = -2147483648;
        k = 113;
      }
    }
    return Pair.create(Integer.valueOf(k), Integer.valueOf(paramInt));
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    boolean bool = String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString);
    int k = 2130841184;
    int m = -2147483648;
    if ((!bool) && (!String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString))) {
      if (String.valueOf(AppConstants.SAME_STATE_BOX_UIN).equals(paramString))
      {
        k = 2130841187;
      }
      else if (AppConstants.VOTE_MSG_UIN.equals(paramString))
      {
        k = 2130841358;
      }
      else if (AppConstants.NEW_KANDIAN_UIN.equals(paramString))
      {
        k = -2147483648;
        m = 110;
      }
      else
      {
        k = -2147483648;
        m = 1;
      }
    }
    return Pair.create(Integer.valueOf(m), Integer.valueOf(k));
  }
  
  private Drawable c(int paramInt, String paramString)
  {
    if (((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempUinTypeList().contains(Integer.valueOf(paramInt)))
    {
      AbstractTempChatPlugin localAbstractTempChatPlugin = ((ITempChatPluginManager)this.b.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(paramInt);
      if (localAbstractTempChatPlugin != null) {
        return localAbstractTempChatPlugin.a(paramString, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
    }
    return null;
  }
  
  private static void d()
  {
    e.put(Integer.valueOf(6002), Integer.valueOf(104));
    e.put(Integer.valueOf(1006), Integer.valueOf(11));
    e.put(Integer.valueOf(3000), Integer.valueOf(101));
    e.put(Integer.valueOf(3002), Integer.valueOf(1001));
    e.put(Integer.valueOf(8113), Integer.valueOf(4));
    e.put(Integer.valueOf(9003), Integer.valueOf(108));
    e.put(Integer.valueOf(7210), Integer.valueOf(105));
    e.put(Integer.valueOf(7220), Integer.valueOf(111));
    HashMap localHashMap = e;
    Integer localInteger = Integer.valueOf(1);
    localHashMap.put(Integer.valueOf(1033), localInteger);
    e.put(Integer.valueOf(1044), localInteger);
    e.put(Integer.valueOf(1045), localInteger);
  }
  
  private static void e()
  {
    f.put(Integer.valueOf(6000), Integer.valueOf(2130845599));
    f.put(Integer.valueOf(6003), Integer.valueOf(2130845594));
    f.put(Integer.valueOf(4000), Integer.valueOf(2130841172));
    f.put(Integer.valueOf(9002), Integer.valueOf(2130846157));
    f.put(Integer.valueOf(5000), Integer.valueOf(2130841185));
    f.put(Integer.valueOf(5001), Integer.valueOf(2130843600));
    f.put(Integer.valueOf(7200), Integer.valueOf(2130841180));
    f.put(Integer.valueOf(9000), Integer.valueOf(2130841184));
    f.put(Integer.valueOf(9503), Integer.valueOf(2130841181));
    f.put(Integer.valueOf(9999), Integer.valueOf(2130840058));
    f.put(Integer.valueOf(1031), Integer.valueOf(2130841158));
    f.put(Integer.valueOf(6004), Integer.valueOf(2130852798));
    f.put(Integer.valueOf(10011), Integer.valueOf(2130852796));
    f.put(Integer.valueOf(10012), Integer.valueOf(2130840356));
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Drawable localDrawable = c(paramInt, paramString);
    if (localDrawable != null) {
      return localDrawable;
    }
    Object localObject = a(this.b, paramInt, paramString);
    int k = ((Integer)((Pair)localObject).first).intValue();
    int m = ((Integer)((Pair)localObject).second).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceDrawable uintype = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isGetResFace = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", faceType = ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", faceResId = ");
      ((StringBuilder)localObject).append(m);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if (m == 2147483647) {}
    try
    {
      paramString = b(k, paramString);
    }
    catch (Exception paramString)
    {
      label225:
      label232:
      break label225;
    }
    if (k != -2147483648)
    {
      paramString = a(paramString, k);
    }
    else if ((m != -2147483648) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(m);
      break label232;
      paramString.printStackTrace();
    }
    else
    {
      return localDrawable;
    }
    return paramString;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int m = paramRecentBaseData.getRecentUserType();
    int k;
    Object localObject;
    if (paramRecentBaseData.getRecentUserType() == 8)
    {
      k = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFaceDrawable type = ");
        ((StringBuilder)localObject).append(k);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      if (k != 0)
      {
        if (k == 25)
        {
          IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
          localObject = null;
          if (localIPhoneContactService != null) {
            localObject = localIPhoneContactService.queryContactByCodeNumber(paramRecentBaseData.mPhoneNumber);
          }
          if (localObject != null)
          {
            localObject = FaceDrawable.getMobileFaceDrawable(this.b, paramRecentBaseData.mPhoneNumber, (byte)3);
            paramRecentBaseData = (RecentBaseData)localObject;
            if (localObject != null) {
              break label484;
            }
            paramRecentBaseData = ImageUtil.j();
            break label484;
          }
          paramRecentBaseData = this.b.getFaceBitmap(16, paramRecentBaseData.getRecentUserUin(), (byte)3, true, 16);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.j();
            break label484;
          }
        }
        for (paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);; paramRecentBaseData = new BitmapDrawable(paramRecentBaseData))
        {
          break;
          paramRecentBaseData = this.b.getFaceBitmap(paramRecentBaseData.getRecentUserUin(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.j();
            break;
          }
        }
      }
      else
      {
        paramRecentBaseData = a(k, paramRecentBaseData.getRecentUserUin());
      }
    }
    else if (m == 26)
    {
      paramRecentBaseData = OpenSDKUtils.d(this.b, paramRecentBaseData.getRecentUserUin());
    }
    else if (m == 1034)
    {
      m = 2130846412;
      k = m;
      if ((paramRecentBaseData instanceof RecentItemConfessMsg))
      {
        k = m;
        if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
          k = 2130846413;
        }
      }
      paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(k);
    }
    else if (a(m, paramRecentBaseData))
    {
      paramRecentBaseData = b(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
    }
    else if (m == 10007)
    {
      localObject = ((IGameMsgBoxManager)this.b.getRuntimeService(IGameMsgBoxManager.class, "")).findGameBoxRecentUserInfo(paramRecentBaseData.getRecentUserUin());
      if (localObject != null) {
        paramRecentBaseData = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameUsrDrawable(BaseApplication.getContext(), this.b, ((GameBoxRecentUser)localObject).mToRoleId);
      } else {
        paramRecentBaseData = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getRecentGameMsgDrawable(this.b, paramRecentBaseData.getRecentUserUin());
      }
    }
    else
    {
      localObject = paramRecentBaseData.getRecentUserUin();
      k = m;
      if ((paramRecentBaseData instanceof RecentCallItem))
      {
        k = m;
        if (((RecentCallItem)paramRecentBaseData).a()) {
          k = 3002;
        }
      }
      paramRecentBaseData = a(k, (String)localObject);
    }
    label484:
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
    }
    return paramRecentBaseData;
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFaceDrawable facetype = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", uin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = b(paramString, paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    boolean bool = this.g;
    localObject1 = null;
    if (bool)
    {
      this.b.getFaceBitmap(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.i) && (!this.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return a(paramInt);
    }
    int k;
    if (paramInt == 103) {
      k = 1;
    } else {
      k = paramInt;
    }
    int m;
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString)) {
      m = 202;
    } else {
      m = 200;
    }
    Object localObject2 = this.a;
    if (localObject2 != null) {
      if (paramInt == 32) {
        localObject1 = ((IFaceDecoder)localObject2).getBitmapFromCache(k, paramString, m);
      } else {
        localObject1 = ((IFaceDecoder)localObject2).getBitmapFromCache(k, paramString);
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestDecodeFace| [");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("], isPausing=");
      localObject2 = this.a;
      if (localObject2 == null) {
        localObject2 = "null";
      } else {
        localObject2 = Boolean.valueOf(((IFaceDecoder)localObject2).isPausing());
      }
      localStringBuilder.append(localObject2);
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
    if (localObject1 == null)
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (!((IFaceDecoder)localObject1).isPausing())) {
        if (k == 32)
        {
          this.a.requestDecodeStrangeFace(paramString, m, true, false);
        }
        else
        {
          this.a.requestDecodeFace(paramString, k, true, (byte)0);
          if ((k == 1001) && (this.a.getBitmapFromCache(101, paramString) == null)) {
            this.a.requestDecodeFace(paramString, 101, true, (byte)0);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
      }
      return a(paramInt);
    }
    if (paramInt == 103)
    {
      localObject2 = BaseApplication.getContext().getResources().getDrawable(2130841165);
      if ((localObject2 instanceof SkinnableBitmapDrawable)) {
        ((SkinnableBitmapDrawable)localObject2).setGravity(81);
      }
      if ((localObject2 instanceof BitmapDrawable)) {
        ((BitmapDrawable)localObject2).setGravity(81);
      }
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject2 });
    }
    else
    {
      localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1);
    }
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) {
      return ((IKandianSubscribeManager)this.b.getRuntimeService(IKandianSubscribeManager.class)).getAggregateAvate((Drawable)localObject1, this.b);
    }
    return localObject1;
  }
  
  public Drawable a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = FaceDrawable.getUserFaceDrawable(this.b, paramString1, (byte)3);
    label298:
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAppletsFolderDrawable width = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", height = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", url = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", urlSimple = ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject).toString());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(paramInt1, this.b.getApp().getApplicationContext().getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(paramInt2, this.b.getApp().getApplicationContext().getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramString1;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramString1;
      if (QQTheme.isNowSimpleUI())
      {
        if (TextUtils.isEmpty(paramString3)) {
          break label298;
        }
        paramInt1 = Math.min(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight);
        paramString3 = URLDrawable.getDrawable(paramString3, (URLDrawable.URLDrawableOptions)localObject);
        paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
        paramString3.setDecodeHandler(URLDrawableDecodeHandler.j);
        return paramString3;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label298;
      }
      paramString3 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      return paramString3;
    }
    catch (Exception paramString3)
    {
      label254:
      break label254;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("getAppletsFolderDrawable illegal url format: ");
      paramString3.append(paramString2);
      QLog.e("RecentFaceDecoder", 2, paramString3.toString());
    }
    return paramString1;
  }
  
  public QQAppInterface a()
  {
    return this.b;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    IFaceDecoder localIFaceDecoder = this.a;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.setAppRuntime(paramQQAppInterface);
      this.a.setDecodeTaskCompletionListener(this.h);
    }
    this.b = paramQQAppInterface;
  }
  
  public URLDrawable b(int paramInt, String paramString)
  {
    if (paramInt != 112)
    {
      if (paramInt != 114)
      {
        if (paramInt != 1000) {
          return null;
        }
        paramString = ((HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramString);
        localDrawable = ImageUtil.f();
        return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
      }
      Drawable localDrawable = ImageUtil.j();
      paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
      paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
      return paramString;
    }
    paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.g());
    return URLDrawable.getDrawable(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), paramString, paramString);
  }
  
  public void b()
  {
    IFaceDecoder localIFaceDecoder = this.a;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.a = null;
    }
    this.h = null;
    this.b = null;
  }
  
  public void c()
  {
    this.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */