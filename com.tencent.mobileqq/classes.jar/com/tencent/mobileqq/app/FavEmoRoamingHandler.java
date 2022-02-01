package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.IFavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.ResidParser;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.cs.faceroam_sso.faceroam_sso.PlatInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqUserInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyReq;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyRsp;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.OcrInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.PicInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ReqBody;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.RspBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove.PlatInfo;
import tencent.im.oidb.cmd0xdcf.EmotionMove.ReqBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FavEmoRoamingHandler
  extends CustomEmoRoamingBaseHandler<CustomEmotionData>
  implements IFavEmoRoamingHandler
{
  public static final String a = "com.tencent.mobileqq.app.FavEmoRoamingHandler";
  
  protected FavEmoRoamingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(int paramInt, List<FavEmotionOcr.OcrInfo> paramList, IFavroamingDBManagerService paramIFavroamingDBManagerService, List<CustomEmotionData> paramList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = 0;
      int i;
      for (int k = 0; j < paramList.size(); k = i)
      {
        FavEmotionOcr.OcrInfo localOcrInfo = (FavEmotionOcr.OcrInfo)paramList.get(j);
        Object localObject3 = localOcrInfo.pic_info;
        Object localObject1 = ((FavEmotionOcr.PicInfo)localObject3).string_pic_fileid.get();
        Object localObject2;
        if ((paramInt == 3) && (QLog.isColorLevel()))
        {
          localObject2 = localOcrInfo.string_pic_ocr.get();
          localObject3 = ((FavEmotionOcr.PicInfo)localObject3).string_pic_md5.get();
          String str = localOcrInfo.string_self_desc.get();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" resid=");
          localStringBuilder.append((String)localObject1);
          QLog.d("FavEmoRoamingHandler", 1, new Object[] { "handleOcrUpload words=", localObject2, " md5=", localObject3, " self_decs=", str, localStringBuilder.toString() });
        }
        localObject1 = paramIFavroamingDBManagerService.getCustomEmotionDataBYResId(paramList1, (String)localObject1);
        i = k;
        if (localObject1 != null)
        {
          if ((localOcrInfo.string_pic_ocr.get() != null) && ((((CustomEmotionData)localObject1).ocrWord == null) || (!((CustomEmotionData)localObject1).ocrWord.equals(localOcrInfo.string_pic_ocr.get()))))
          {
            ((CustomEmotionData)localObject1).ocrWord = localOcrInfo.string_pic_ocr.get();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleOcrUpload old ocrWord=");
              ((StringBuilder)localObject2).append(((CustomEmotionData)localObject1).ocrWord);
              ((StringBuilder)localObject2).append(" new ocrWord=");
              ((StringBuilder)localObject2).append(localOcrInfo.string_pic_ocr.get());
              QLog.d("FavEmoRoamingHandler", 1, ((StringBuilder)localObject2).toString());
            }
            i = 1;
          }
          else
          {
            i = 0;
          }
          int m = i;
          if (localOcrInfo.string_self_desc.get() != null) {
            if (((CustomEmotionData)localObject1).modifyWord != null)
            {
              m = i;
              if (((CustomEmotionData)localObject1).modifyWord.equals(localOcrInfo.string_self_desc.get())) {}
            }
            else
            {
              ((CustomEmotionData)localObject1).modifyWord = localOcrInfo.string_self_desc.get();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleOcrUpload old modifyWord=");
                ((StringBuilder)localObject2).append(((CustomEmotionData)localObject1).modifyWord);
                ((StringBuilder)localObject2).append(" new modifyWord=");
                ((StringBuilder)localObject2).append(localOcrInfo.string_self_desc.get());
                QLog.d("FavEmoRoamingHandler", 1, ((StringBuilder)localObject2).toString());
              }
              m = 1;
            }
          }
          i = k;
          if (m != 0)
          {
            paramIFavroamingDBManagerService.updateCustomEmotion((CustomEmotionData)localObject1);
            i = 1;
          }
        }
        j += 1;
      }
      if (k != 0)
      {
        StickerRecManagerImpl.get(this.b).updateKeywordForFavEmotion();
        return;
      }
    }
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    if (paramList2 != null)
    {
      if (paramList1 == null) {
        return;
      }
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < paramList2.size())
      {
        localObject2 = (String)paramList2.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = new ResidParser((String)localObject2);
          if ((((ResidParser)localObject3).a()) && (!TextUtils.isEmpty(((ResidParser)localObject3).c)) && (!TextUtils.isEmpty(((ResidParser)localObject3).d)))
          {
            ((List)localObject1).add(localObject3);
          }
          else if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("res id is not valid:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject3).toString());
          }
        }
        i += 1;
      }
      Object localObject2 = new ArrayList();
      i = 0;
      Object localObject4;
      while (i < paramList1.size())
      {
        localObject3 = (String)paramList1.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject4 = new ResidParser((String)localObject3);
          if ((((ResidParser)localObject4).a()) && (!TextUtils.isEmpty(((ResidParser)localObject4).c)) && (!TextUtils.isEmpty(((ResidParser)localObject4).d)))
          {
            ((List)localObject2).add(localObject4);
          }
          else if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("res id is not valid:");
            ((StringBuilder)localObject4).append((String)localObject3);
            QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject4).toString());
          }
        }
        i += 1;
      }
      Object localObject3 = new StringBuilder("");
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject4 = (ResidParser)((List)localObject1).get(i);
        int j = 0;
        while (j < ((List)localObject2).size())
        {
          ResidParser localResidParser = (ResidParser)((List)localObject2).get(j);
          if ((((ResidParser)localObject4).c.equals(localResidParser.c)) && (localResidParser.c.equals("0")) && (localResidParser.d.equals(((ResidParser)localObject4).d)))
          {
            paramList1.remove(localResidParser.a);
            ((StringBuilder)localObject3).append(localResidParser.a);
            ((StringBuilder)localObject3).append(", ");
          }
          j += 1;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("delList=");
        ((StringBuilder)localObject1).append(paramList1.size());
        ((StringBuilder)localObject1).append(", roamingList=");
        ((StringBuilder)localObject1).append(paramList2.size());
        ((StringBuilder)localObject1).append(", del resIds:");
        ((StringBuilder)localObject1).append(localObject3);
        QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void b(Object paramObject)
  {
    Object localObject;
    if (paramObject != null) {
      localObject = new EmotionMove.RspBody();
    }
    try
    {
      ((EmotionMove.RspBody)localObject).mergeFrom((byte[])paramObject);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onReceive FAV_REQ_MOVE fail ret = ");
        paramObject.append(((EmotionMove.RspBody)localObject).ret);
        paramObject.append(" ,errorMsg = ");
        paramObject.append(((EmotionMove.RspBody)localObject).errmsg);
        QLog.d("FavEmoRoamingHandler", 2, paramObject.toString());
        return;
      }
    }
    catch (Exception paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleEmotionMove exception : ");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("FavEmoRoamingHandler", 1, ((StringBuilder)localObject).toString());
      return;
      QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove oom");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleEmotionMove ends, errInfo:");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("FavEmoRoamingHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      label117:
      break label117;
    }
  }
  
  public void a()
  {
    Object localObject = new faceroam_sso.ReqUserInfo();
    faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
    localPlatInfo.implat.set(109L);
    localPlatInfo.mqqver.set("8.8.17");
    localPlatInfo.osver.set(Build.VERSION.RELEASE);
    faceroam_sso.ReqBody localReqBody = new faceroam_sso.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    localReqBody.reqcmd_0x01.set((MessageMicro)localObject);
    localReqBody.comm.set(localPlatInfo);
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "Faceroam.OpReq");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if (paramCustomEmotionData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "favEmoModifyOcr data = null");
      }
      return;
    }
    if ((this.b != null) && (this.b.getApp() != null))
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        notifyUI(3, false, this.b.getApp().getString(2131897781));
        return;
      }
      try
      {
        Object localObject1 = new FavEmotionOcr.ReqBody();
        ((FavEmotionOcr.ReqBody)localObject1).uint32_src_term.set(3);
        ((FavEmotionOcr.ReqBody)localObject1).uint32_cmd_type.set(3);
        ((FavEmotionOcr.ReqBody)localObject1).string_version.set("8.8.17");
        localObject2 = new FavEmotionOcr.ModifyReq();
        Object localObject3 = new FavEmotionOcr.PicInfo();
        ((FavEmotionOcr.PicInfo)localObject3).string_pic_md5.set(paramCustomEmotionData.md5);
        ((FavEmotionOcr.PicInfo)localObject3).string_pic_fileid.set(paramCustomEmotionData.resid);
        ((FavEmotionOcr.ModifyReq)localObject2).pic_info.set((MessageMicro)localObject3);
        ((FavEmotionOcr.ModifyReq)localObject2).string_self_desc_new.set(paramString);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        ((FavEmotionOcr.ReqBody)localObject1).list_modify_req.set((List)localObject3);
        localObject1 = makeOIDBPkg("OidbSvc.0xdc4", 3524, 1, ((FavEmotionOcr.ReqBody)localObject1).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putInt("cmd_fav_subcmd", 5);
        ((ToServiceMsg)localObject1).extraData.putString("fav_modify_word", paramString);
        ((ToServiceMsg)localObject1).extraData.putInt("fav_modify_emoid", paramCustomEmotionData.emoId);
        super.sendPbReq((ToServiceMsg)localObject1);
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("favEmoModifyOcr e=");
        ((StringBuilder)localObject2).append(localException);
        ((StringBuilder)localObject2).append(" modifyWord=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" CustomEmotionData=");
        ((StringBuilder)localObject2).append(paramCustomEmotionData.toString());
        QLog.e("FavEmoRoamingHandler", 1, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    QLog.e("FavEmoRoamingHandler", 1, "favEmoModifyOcr ocr fail, app is null");
    notifyUI(3, false, MobileQQ.getContext().getString(2131897761));
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      j = paramToServiceMsg.extraData.getInt("fav_modify_emoid", -1);
      paramToServiceMsg = paramToServiceMsg.extraData.getString("fav_modify_word");
      paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if (paramObject.uint32_result.get() != 0) {
        break label750;
      }
      i = 1;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      int j;
      Object localObject;
      notifyUI(3, false, this.b.getApplication().getString(2131897761));
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("func handleOcrModify ends, errInfo:");
      paramToServiceMsg.append(paramFromServiceMsg.getMessage());
      QLog.e("FavEmoRoamingHandler", 1, paramToServiceMsg.toString());
      return;
      notifyUI(3, false, this.b.getApplication().getString(2131897761));
      QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify error");
      return;
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      for (;;)
      {
        continue;
        i = 0;
        continue;
        paramFromServiceMsg = "0";
        continue;
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleOcrModify pkg.uint32_result=");
      paramFromServiceMsg.append(paramObject.uint32_result.get());
      QLog.d("FavEmoRoamingHandler", 1, paramFromServiceMsg.toString());
    }
    localObject = new HashMap();
    if (i != 0)
    {
      paramFromServiceMsg = "1";
      ((HashMap)localObject).put("param_succ_flag", paramFromServiceMsg);
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append(Build.VERSION.SDK_INT);
      paramFromServiceMsg.append("");
      ((HashMap)localObject).put("param_version", paramFromServiceMsg.toString());
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append(paramObject.uint32_result.get());
      paramFromServiceMsg.append("");
      ((HashMap)localObject).put("param_resultCode", paramFromServiceMsg.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "favEmoModifyOcrsSuc", false, 0L, 0L, (HashMap)localObject, null);
      if ((i != 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new FavEmotionOcr.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        i = paramFromServiceMsg.int32_result.get();
        if (i == 0)
        {
          paramFromServiceMsg = paramFromServiceMsg.list_modify_rsp.get();
          i = 0;
          if (i < paramFromServiceMsg.size())
          {
            if (QLog.isColorLevel())
            {
              paramObject = new StringBuilder();
              paramObject.append("handleOcrModify resModify.get(i).uint32_result=");
              paramObject.append(((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get());
              QLog.d("FavEmoRoamingHandler", 1, paramObject.toString());
            }
            if (((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get() == 0)
            {
              paramObject = ((IFavroamingDBManagerService)this.b.getRuntimeService(IFavroamingDBManagerService.class, "")).getEmoticonDataList();
              if (paramObject == null) {
                break label762;
              }
              paramObject = paramObject.iterator();
              do
              {
                if (!paramObject.hasNext()) {
                  break;
                }
                localObject = (CustomEmotionData)paramObject.next();
              } while (j != ((CustomEmotionData)localObject).emoId);
              ((CustomEmotionData)localObject).modifyWord = paramToServiceMsg;
              notifyUI(3, true, localObject);
              break label762;
            }
            notifyUI(3, false, this.b.getApplication().getString(2131897762));
            if (!QLog.isColorLevel()) {
              break label762;
            }
            paramObject = new StringBuilder();
            paramObject.append("handleOcrModify ret = ");
            paramObject.append(((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get());
            QLog.d("FavEmoRoamingHandler", 1, paramObject.toString());
            break label762;
          }
        }
        else
        {
          notifyUI(3, false, this.b.getApplication().getString(2131897761));
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleOcrModify ret = ");
            paramToServiceMsg.append(paramFromServiceMsg.int32_result.get());
            QLog.e("FavEmoRoamingHandler", 1, paramToServiceMsg.toString());
            return;
            notifyUI(3, false, this.b.getApplication().getString(2131897761));
            QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify oom");
            return;
          }
        }
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject, int paramInt)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = 0;
    int i;
    if ((bool) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      i = j;
      if (paramObject.uint32_result.get() == 0) {
        i = 1;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleOcrUpload pkg.uint32_result=");
        paramFromServiceMsg.append(paramObject.uint32_result.get());
        QLog.d("FavEmoRoamingHandler", 1, paramFromServiceMsg.toString());
      }
      localHashMap = new HashMap();
      if (i == 0) {
        break label433;
      }
      paramFromServiceMsg = "1";
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      HashMap localHashMap;
      paramObject = new StringBuilder();
      paramObject.append("func handleOcrUpload ends, errInfo:");
      paramObject.append(paramFromServiceMsg.getMessage());
      QLog.e("FavEmoRoamingHandler", 1, paramObject.toString());
      return;
      QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload ");
      return;
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      for (;;)
      {
        continue;
        paramFromServiceMsg = "0";
        continue;
        paramFromServiceMsg = null;
      }
    }
    localHashMap.put("param_succ_flag", paramFromServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(paramInt);
    paramFromServiceMsg.append("");
    localHashMap.put("param_cmd_type", paramFromServiceMsg.toString());
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(Build.VERSION.SDK_INT);
    paramFromServiceMsg.append("");
    localHashMap.put("param_version", paramFromServiceMsg.toString());
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(paramObject.uint32_result.get());
    paramFromServiceMsg.append("");
    localHashMap.put("param_resultCode", paramFromServiceMsg.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "favEmoGetOcrSuc", false, 0L, 0L, localHashMap, null);
    if ((i != 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
    {
      paramFromServiceMsg = new FavEmotionOcr.RspBody();
      paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.list_ocr_info.has())
      {
        paramFromServiceMsg = paramFromServiceMsg.list_ocr_info.get();
        paramObject = (IFavroamingDBManagerService)this.b.getRuntimeService(IFavroamingDBManagerService.class, "");
        a(paramInt, paramFromServiceMsg, paramObject, paramObject.getEmoticonDataList());
      }
    }
    else
    {
      return;
      QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload oom");
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    localObject = new faceroam_sso.RspBody();
    try
    {
      ((faceroam_sso.RspBody)localObject).mergeFrom((byte[])paramObject);
      paramObject = (faceroam_sso.RspUserInfo)((faceroam_sso.RspBody)localObject).rspcmd_0x01.get();
      long l = ((faceroam_sso.RspBody)localObject).ret.get();
      if (l != 0L)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleUserInfoGet ret = ");
        paramObject.append(l);
        QLog.e("FavEmoRoamingHandler", 1, paramObject.toString());
        return;
      }
      ThreadManagerV2.excute(new FavEmoRoamingHandler.1(this, paramObject, l), 32, null, true);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func handleUserInfoGet ends, errInfo:");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("FavEmoRoamingHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      label100:
      break label100;
    }
    QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom");
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    Object localObject2 = new faceroam_sso.RspBody();
    for (;;)
    {
      int i;
      try
      {
        ((faceroam_sso.RspBody)localObject2).mergeFrom((byte[])paramObject);
        localObject1 = (faceroam_sso.RspDeleteItem)((faceroam_sso.RspBody)localObject2).rspcmd_0x02.get();
        paramObject = ((faceroam_sso.RspDeleteItem)localObject1).ret.get();
        localObject1 = ((faceroam_sso.RspDeleteItem)localObject1).filename.get();
        localArrayList = new ArrayList();
        String str = ((faceroam_sso.RspBody)localObject2).errmsg.get();
        long l = ((faceroam_sso.RspBody)localObject2).ret.get();
        i = ((faceroam_sso.RspBody)localObject2).sub_cmd.get();
        if (!QLog.isColorLevel()) {
          break label456;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" handle ResId=");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("errMsg=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" ret=");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("subCmd=");
        ((StringBuilder)localObject2).append(i);
        QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject2).toString());
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        ArrayList localArrayList;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func handleDelMessage ends, errInfo:");
        ((StringBuilder)localObject1).append(paramObject.getMessage());
        QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      if (i < ((List)localObject1).size())
      {
        if (((Long)paramObject.get(i)).longValue() == 0L)
        {
          localArrayList.add(((List)localObject1).get(i));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(" delSuccess ResId=");
            ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
            QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" delFail ResId=");
          ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
          ((StringBuilder)localObject2).append("error code = ");
          ((StringBuilder)localObject2).append(paramObject.get(i));
          QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        ((IFavroamingDBManagerService)this.b.getRuntimeService(IFavroamingDBManagerService.class, "")).deleteDB(localArrayList);
        super.notifyUI(0, true, Boolean.valueOf(paramBoolean));
        EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", 1);
        b(localArrayList);
        return;
        label456:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        localObject = new EmotionMove.PlatInfo();
        ((EmotionMove.PlatInfo)localObject).implat.set(109);
        ((EmotionMove.PlatInfo)localObject).mqqver.set("8.8.17");
        ((EmotionMove.PlatInfo)localObject).osver.set(Build.VERSION.RELEASE);
        EmotionMove.ReqBody localReqBody = new EmotionMove.ReqBody();
        localReqBody.msg_comm_info.set((MessageMicro)localObject);
        localReqBody.str_req_filename.set(paramList);
        paramList = makeOIDBPkg("OidbSvc.0xdcf", 3535, 1, localReqBody.toByteArray());
        paramList.extraData.putInt("cmd_fav_subcmd", 6);
        super.sendPbReq(paramList);
        return;
      }
      catch (Exception paramList)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("moveEmotion exception = ");
          ((StringBuilder)localObject).append(paramList.getMessage());
          QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(List<CustomEmotionData> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new FavEmotionOcr.ReqBody();
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.get(i);
      if (!localCustomEmotionData.isMarkFace)
      {
        FavEmotionOcr.PicInfo localPicInfo = new FavEmotionOcr.PicInfo();
        localPicInfo.string_pic_md5.set(localCustomEmotionData.md5);
        localPicInfo.string_pic_fileid.set(localCustomEmotionData.resid);
        ((List)localObject1).add(localPicInfo);
      }
      i += 1;
    }
    if (((List)localObject1).size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "favEmoGetOcrs size=0");
      }
      return;
    }
    try
    {
      ((FavEmotionOcr.ReqBody)localObject2).uint32_src_term.set(3);
      ((FavEmotionOcr.ReqBody)localObject2).list_pic_info.set((List)localObject1);
      ((FavEmotionOcr.ReqBody)localObject2).uint32_cmd_type.set(paramInt);
      ((FavEmotionOcr.ReqBody)localObject2).string_version.set("8.8.17");
      localObject1 = makeOIDBPkg("OidbSvc.0xdc4", 3524, 1, ((FavEmotionOcr.ReqBody)localObject2).toByteArray());
      if (paramInt == 1) {
        ((ToServiceMsg)localObject1).extraData.putInt("cmd_fav_subcmd", 3);
      } else if (paramInt == 2) {
        ((ToServiceMsg)localObject1).extraData.putInt("cmd_fav_subcmd", 4);
      }
      super.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("favEmoGetOcrs error =");
      ((StringBuilder)localObject2).append(localException.toString());
      ((StringBuilder)localObject2).append(" cmdtype=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" size=");
      ((StringBuilder)localObject2).append(paramList.size());
      QLog.e("FavEmoRoamingHandler", 2, ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        paramInt = j;
        while (paramInt < paramList.size())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("favEmoGetOcrs data i=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" :=");
          localStringBuilder.append(paramList.get(paramInt));
          QLog.d("FavEmoRoamingHandler", 2, localStringBuilder.toString());
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      Object localObject = new faceroam_sso.ReqDeleteItem();
      ((faceroam_sso.ReqDeleteItem)localObject).filename.set(paramList);
      faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
      localPlatInfo.implat.set(109L);
      localPlatInfo.mqqver.set("8.8.17");
      localPlatInfo.osver.set(Build.VERSION.RELEASE);
      paramList = new faceroam_sso.ReqBody();
      paramList.uint32_sub_cmd.set(2);
      paramList.uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
      paramList.reqcmd_0x02.set((MessageMicro)localObject);
      paramList.comm.set(localPlatInfo);
      localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "Faceroam.OpReq");
      ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 2);
      ((ToServiceMsg)localObject).extraData.putBoolean("needSync", paramBoolean);
      ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResidParser localResidParser = new ResidParser((String)paramList.next());
        if (!TextUtils.isEmpty(localResidParser.d)) {
          localArrayList.add(localResidParser.d);
        }
      }
      if (localArrayList.size() > 0) {
        ((IVipComicMqqManagerService)this.b.getRuntimeService(IVipComicMqqManagerService.class, "")).delComicEmoticonList(localArrayList);
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return FavEmoRoamingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("cmd_fav_subcmd");
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      switch (i)
      {
      default: 
        return;
      case 6: 
        if (QLog.isColorLevel())
        {
          QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE success！");
          return;
        }
        break;
      case 5: 
        a(paramFromServiceMsg, paramToServiceMsg, paramObject);
        return;
      case 4: 
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_GET_OCR");
        }
        a(paramFromServiceMsg, paramObject, 4);
        return;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_DO_OCR_WHEN_UPLOAD");
        }
        a(paramFromServiceMsg, paramObject, 3);
        return;
      case 2: 
        a(paramObject, paramToServiceMsg.extraData.getBoolean("needSync"));
        return;
      case 1: 
        a(paramObject);
      }
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("fail to  not send command: ");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(" to server");
    QLog.e("FavEmoRoamingHandler", 1, paramToServiceMsg.toString());
    if (i == 1)
    {
      paramToServiceMsg = (IFavroamingManagerService)this.b.getRuntimeService(IFavroamingManagerService.class, "");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.resetSyncState();
      } else {
        QLog.e("FavEmoRoamingHandler", 1, "getRoamingManager return null");
      }
    }
    if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
    {
      if (i == 2)
      {
        EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("2006", 1);
        return;
      }
      if (i == 1)
      {
        EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("2005", 1);
        return;
      }
      if (i == 5)
      {
        notifyUI(3, false, this.b.getApplication().getString(2131897761));
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("modify ocr fail, errInfo:");
        paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailMsg());
        QLog.e("FavEmoRoamingHandler", 1, paramToServiceMsg.toString());
        return;
      }
      if (i == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE fail！");
        }
        b(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingHandler
 * JD-Core Version:    0.7.0.1
 */