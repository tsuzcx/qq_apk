package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ImgInfo;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ReqBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.RspBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadState;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UploadImgInfo;

public class CameraEmoRoamingHandler
  extends CustomEmoRoamingBaseHandler<CameraEmotionData>
  implements ICameraEmoRoamingHandler
{
  public static final String a = "com.tencent.mobileqq.app.CameraEmoRoamingHandler";
  private ConcurrentHashMap<Integer, CameraEmotionData> c = new ConcurrentHashMap();
  
  protected CameraEmoRoamingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    j = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest handlePrepareUploadInfo start, ", Integer.valueOf(j) });
    localCameraEmotionData = (CameraEmotionData)this.c.get(Integer.valueOf(j));
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      int i = -1;
      paramFromServiceMsg = paramToServiceMsg.bytes_fail_msg.get().toStringUtf8();
      if (paramToServiceMsg.upLoad_rsp.has())
      {
        paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadRsp)paramToServiceMsg.upLoad_rsp.get();
        i = paramToServiceMsg.int32_is_upload.get();
        if (i == 0)
        {
          localCameraEmotionData.resid = paramToServiceMsg.bytes_resource_id.get().toStringUtf8();
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("timtest handlePrepareUploadInfo success md5 = ");
          paramToServiceMsg.append(localCameraEmotionData.md5);
          paramToServiceMsg.append("| resid=");
          paramToServiceMsg.append(localCameraEmotionData.resid);
          paramToServiceMsg.append(" | msg = ");
          paramToServiceMsg.append(paramFromServiceMsg);
          paramToServiceMsg.append(", templateId:");
          paramToServiceMsg.append(localCameraEmotionData.templateId);
          QLog.d("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
          ((ICameraEmoRoamingManagerService)this.b.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).realUploadCustomEmoticon(localCameraEmotionData);
        }
        else if (i == 1)
        {
          a(1, false, Integer.valueOf(2), localCameraEmotionData);
          this.c.remove(Integer.valueOf(j));
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("func handlePrepareUploadInfo fail, nCanupload:");
          paramToServiceMsg.append(i);
          QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
        }
        else
        {
          a(1, false, Integer.valueOf(13), localCameraEmotionData);
          this.c.remove(Integer.valueOf(j));
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("func handlePrepareUploadInfo fail, nCanupload:");
          paramToServiceMsg.append(i);
          QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
        }
      }
      else
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("timtest handlePrepareUploadInfo end rspBody.upLoad_rsp no value msg = ");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.d("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.c.remove(Integer.valueOf(j));
      }
      paramObject = new HashMap();
      if (i == 0) {
        paramToServiceMsg = "1";
      } else {
        paramToServiceMsg = "0";
      }
      paramObject.put("sucFlag", paramToServiceMsg);
      paramObject.put("retCode", String.valueOf(i));
      paramToServiceMsg = paramFromServiceMsg;
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = "";
      }
      paramObject.put("errMsg", paramToServiceMsg);
      paramToServiceMsg = StatisticCollector.getInstance(BaseApplication.getContext());
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramToServiceMsg.collectPerformance(null, "CamEmoPrepareUpload", bool, 0L, 0L, paramObject, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("func handlePrepareUploadInfo ends, errInfo:");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.e("CameraEmoRoamingHandler", 1, paramFromServiceMsg.toString());
      a(1, false, Integer.valueOf(100), localCameraEmotionData);
      this.c.remove(Integer.valueOf(j));
      return;
      paramObject = new StringBuilder();
      paramObject.append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg != null) {
        break label659;
      }
      paramToServiceMsg = "null";
      break label667;
      paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
      paramObject.append(paramToServiceMsg);
      QLog.e("CameraEmoRoamingHandler", 1, paramObject.toString());
      a(1, false, Integer.valueOf(12), localCameraEmotionData);
      this.c.remove(Integer.valueOf(j));
      return;
    }
    catch (OutOfMemoryError paramToServiceMsg)
    {
      label537:
      break label537;
    }
    QLog.e("CameraEmoRoamingHandler", 1, "handlePrepareUploadInfo oom");
    a(1, false, Integer.valueOf(100), localCameraEmotionData);
    this.c.remove(Integer.valueOf(j));
  }
  
  private void a(List<CameraEmotionRoaming_sso.ImgInfo> paramList, List<CameraEmoImg> paramList1, List<String> paramList2)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList2 != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (CameraEmotionRoaming_sso.ImgInfo)localIterator.next();
        String str4 = paramList.bytes_resource_id.get().toStringUtf8();
        String str1 = ((ByteStringMicro)paramList.bytes_text.get(0)).toStringUtf8();
        String str2 = paramList.url.get().toStringUtf8();
        String str3 = paramList.bytes_md5.get().toStringUtf8();
        String str5 = paramList.bytes_widget_id.get().toStringUtf8();
        if (!StringUtil.isEmpty(str4))
        {
          CameraEmoImg localCameraEmoImg = new CameraEmoImg();
          localCameraEmoImg.a = str4;
          if (str1 == null) {
            paramList = "";
          } else {
            paramList = str1;
          }
          localCameraEmoImg.b = paramList;
          if (str2 == null) {
            paramList = "";
          } else {
            paramList = str2;
          }
          localCameraEmoImg.c = paramList;
          paramList = str3;
          if (str3 == null) {
            paramList = "";
          }
          localCameraEmoImg.d = paramList;
          localCameraEmoImg.e = str5;
          paramList = new StringBuilder();
          paramList.append("readSSoImgInfoList get CameraEmoImg content = ");
          paramList.append(str1);
          paramList.append("| url = ");
          paramList.append(str2);
          paramList.append(", templateId:");
          paramList.append(str5);
          QLog.e("CameraEmoRoamingHandler", 1, paramList.toString());
          paramList2.add(str4);
          paramList1.add(localCameraEmoImg);
        }
      }
      return;
    }
    QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList param error");
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleNotifyServerUploadStatus start");
    i = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    localCameraEmotionData = (CameraEmotionData)this.c.get(Integer.valueOf(i));
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadStateRet)((CameraEmotionRoaming_sso.UpLoadStateRsp)paramToServiceMsg.upLoad_state_rsp.get()).upload_state_ret.get(0);
      int j = paramToServiceMsg.int32_upload_state_ret.get();
      if (j == 0)
      {
        localCameraEmotionData.url = paramToServiceMsg.img_info.url.get().toStringUtf8();
        a(1, true, Integer.valueOf(0), localCameraEmotionData);
        this.c.remove(Integer.valueOf(i));
        QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus suc");
      }
      else
      {
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.c.remove(Integer.valueOf(i));
        QLog.e("CameraEmoRoamingHandler", 1, new Object[] { "func handleNotifyServerUploadStatus fail, result:", Integer.valueOf(j) });
      }
      paramFromServiceMsg = new HashMap();
      if (j == 0) {
        paramToServiceMsg = "1";
      } else {
        paramToServiceMsg = "0";
      }
      paramFromServiceMsg.put("sucFlag", paramToServiceMsg);
      paramFromServiceMsg.put("retCode", String.valueOf(j));
      paramToServiceMsg = StatisticCollector.getInstance(BaseApplication.getContext());
      boolean bool;
      if (j == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramToServiceMsg.collectPerformance(null, "CamEmoUpdateStat", bool, 0L, 0L, paramFromServiceMsg, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("func handleNotifyServerUploadStatus ends, errInfo:");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.e("CameraEmoRoamingHandler", 1, paramFromServiceMsg.toString());
      a(1, false, Integer.valueOf(100), localCameraEmotionData);
      this.c.remove(Integer.valueOf(i));
      return;
      paramObject = new StringBuilder();
      paramObject.append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg != null) {
        break label417;
      }
      paramToServiceMsg = "null";
      break label425;
      paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
      paramObject.append(paramToServiceMsg);
      QLog.e("CameraEmoRoamingHandler", 1, paramObject.toString());
      a(1, false, Integer.valueOf(12), localCameraEmotionData);
      this.c.remove(Integer.valueOf(i));
      return;
    }
    catch (OutOfMemoryError paramToServiceMsg)
    {
      label293:
      break label293;
    }
    QLog.e("CameraEmoRoamingHandler", 1, "handleNotifyServerUploadStatus oom");
    a(1, false, Integer.valueOf(100), localCameraEmotionData);
    this.c.remove(Integer.valueOf(i));
  }
  
  public void a()
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest queryUserEmoRoamingReq  start");
    String str = ((ICameraEmoRoamingManagerService)this.b.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).getListVersion();
    Object localObject = new CameraEmotionRoaming_sso.GetListReq();
    ((CameraEmotionRoaming_sso.GetListReq)localObject).client_timestamp_version.set(ByteStringMicro.copyFrom(str.getBytes()));
    CameraEmotionRoaming_sso.ReqBody localReqBody = new CameraEmotionRoaming_sso.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    localReqBody.uint32_cmd_type.set(3);
    localReqBody.uint32_src_term.set(3);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom("8.8.17".getBytes()));
    localReqBody.get_list_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 3);
    ((ToServiceMsg)localObject).extraData.putString("cmd_param_data_version", str);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    notifyUI(paramInt1, paramBoolean, Integer.valueOf(paramInt2), false);
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject, CameraEmotionData paramCameraEmotionData)
  {
    notifyUI(paramInt, paramBoolean, new Object[] { paramObject, paramCameraEmotionData }, false);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest prepareUploadEmoReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest prepareUploadEmoReq start, md5:", paramCameraEmotionData.md5, ", size:", Long.valueOf(paramLong), ", emoId:", Integer.valueOf(paramCameraEmotionData.emoId) });
    this.c.put(Integer.valueOf(paramCameraEmotionData.emoId), paramCameraEmotionData);
    Object localObject1 = new CameraEmotionRoaming_sso.UpLoadReq();
    Object localObject2 = new CameraEmotionRoaming_sso.UploadImgInfo();
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).bytes_img_md5.set(ByteStringMicro.copyFrom(paramCameraEmotionData.md5.getBytes()));
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_height.set(paramInt2);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_width.set(paramInt1);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint64_img_size.set(paramLong);
    ((CameraEmotionRoaming_sso.UpLoadReq)localObject1).img_info.set((MessageMicro)localObject2);
    localObject2 = new CameraEmotionRoaming_sso.ReqBody();
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint64_src_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_cmd_type.set(1);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_src_term.set(3);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).bytes_version.set(ByteStringMicro.copyFrom("8.8.17".getBytes()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).upLoad_req.set((MessageMicro)localObject1);
    localObject1 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject1).extraData.putInt("cmd_camera_emo_subcmd", 1);
    ((ToServiceMsg)localObject1).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
    ((ToServiceMsg)localObject1).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject2).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, net not support");
      a(1, false, Integer.valueOf(12), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start");
    CameraEmotionRoaming_sso.UpLoadStateReq localUpLoadStateReq = new CameraEmotionRoaming_sso.UpLoadStateReq();
    CameraEmotionRoaming_sso.UpLoadState localUpLoadState = new CameraEmotionRoaming_sso.UpLoadState();
    localUpLoadState.bytes_resource_id.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    Object localObject3 = localUpLoadState.bytes_text;
    Object localObject1 = paramCameraEmotionData.strContext;
    Object localObject2 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = paramCameraEmotionData.strContext;
    }
    ((PBRepeatField)localObject3).add(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    localUpLoadState.int32_upload_state.set(paramBoolean ^ true);
    localObject3 = localUpLoadState.bytes_widget_id;
    if (paramCameraEmotionData.templateId == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = paramCameraEmotionData.templateId;
    }
    ((PBBytesField)localObject3).set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    localUpLoadStateReq.upload_state.add(localUpLoadState);
    localObject1 = new CameraEmotionRoaming_sso.ReqBody();
    ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint64_src_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_cmd_type.set(2);
    ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_src_term.set(3);
    ((CameraEmotionRoaming_sso.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom("8.8.17".getBytes()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject1).upLoad_state_req.set(localUpLoadStateReq);
    localObject2 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject2).extraData.putInt("cmd_camera_emo_subcmd", 2);
    ((ToServiceMsg)localObject2).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
    ((ToServiceMsg)localObject2).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
  }
  
  protected void a(Object paramObject, String paramString)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet start");
    Object localObject = new CameraEmotionRoaming_sso.RspBody();
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.has())
      {
        localObject = (CameraEmotionRoaming_sso.GetListRsp)((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.get();
        paramObject = ((CameraEmotionRoaming_sso.GetListRsp)localObject).server_timestamp_version.get().toStringUtf8();
        if (paramString.equals(paramObject))
        {
          paramString = new StringBuilder();
          paramString.append("timtest handleUserInfoGet same version = ");
          paramString.append(paramObject);
          QLog.d("CameraEmoRoamingHandler", 1, paramString.toString());
          a(2, true, 0);
          return;
        }
        paramString = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (((CameraEmotionRoaming_sso.GetListRsp)localObject).rpt_img_info.has()) {
          a(((CameraEmotionRoaming_sso.GetListRsp)localObject).rpt_img_info.get(), paramString, localArrayList);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("timtest handleUserInfoGet cameraEmoImgs.size = ");
        ((StringBuilder)localObject).append(paramString.size());
        QLog.d("CameraEmoRoamingHandler", 1, ((StringBuilder)localObject).toString());
        ThreadManagerV2.excute(new CameraEmoRoamingHandler.2(this, paramObject, paramString, localArrayList), 32, null, true);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramString = new StringBuilder();
      paramString.append("func handleUserInfoGet ends, errInfo:");
      paramString.append(paramObject.getMessage());
      QLog.e("CameraEmoRoamingHandler", 1, paramString.toString());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      label218:
      break label218;
    }
    QLog.e("CameraEmoRoamingHandler", 1, "handleUserInfoGet oom");
  }
  
  protected void a(Object paramObject, boolean paramBoolean)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage start ");
    localObject1 = new CameraEmotionRoaming_sso.RspBody();
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject1).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject1).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.has())
      {
        Object localObject2 = (CameraEmotionRoaming_sso.DelRsp)((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.get();
        paramObject = ((CameraEmotionRoaming_sso.DelRsp)localObject2).client_timestamp_version.get().toStringUtf8();
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if (((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.has()) {
          a(((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.get(), (List)localObject1, localArrayList2);
        }
        if (((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.has())
        {
          localObject2 = ((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            CameraEmotionRoaming_sso.DelRet localDelRet = (CameraEmotionRoaming_sso.DelRet)((Iterator)localObject2).next();
            if (localDelRet.int32_del_ret.get() == 0) {
              localArrayList1.add(localDelRet.bytes_resource_id.get().toStringUtf8());
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("timtest handleDelMessage delResIDList.size = ");
        ((StringBuilder)localObject2).append(localArrayList1.size());
        ((StringBuilder)localObject2).append("| cameraEmoImgs.size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("CameraEmoRoamingHandler", 1, ((StringBuilder)localObject2).toString());
        ThreadManagerV2.excute(new CameraEmoRoamingHandler.1(this, paramObject, (List)localObject1, localArrayList2, localArrayList1), 32, null, true);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func handleDelMessage ends, errInfo:");
      ((StringBuilder)localObject1).append(paramObject.getMessage());
      QLog.e("CameraEmoRoamingHandler", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      label292:
      break label292;
    }
    QLog.e("CameraEmoRoamingHandler", 1, "handleDelMessage oom");
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("timtest delUserEmoRoamingReq start size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("CameraEmoRoamingHandler", 1, ((StringBuilder)localObject).toString());
      localObject = new CameraEmotionRoaming_sso.DelReq();
      int i = 0;
      while (i < paramList.size())
      {
        String str = (String)paramList.get(i);
        if (str != null) {
          ((CameraEmotionRoaming_sso.DelReq)localObject).bytes_resource_id.get().add(ByteStringMicro.copyFrom(str.getBytes()));
        }
        i += 1;
      }
      paramList = new CameraEmotionRoaming_sso.ReqBody();
      paramList.uint64_src_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
      paramList.uint32_cmd_type.set(4);
      paramList.uint32_src_term.set(3);
      paramList.bytes_version.set(ByteStringMicro.copyFrom("8.8.17".getBytes()));
      paramList.del_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "SelfGif.Op");
      ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 4);
      ((ToServiceMsg)localObject).extraData.putBoolean("cmd_param_need_sync", paramBoolean);
      ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return CameraEmoRoamingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "timtest onReceive error : ToServiceMsg is null");
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest onReceive start");
    int i = paramToServiceMsg.extraData.getInt("cmd_camera_emo_subcmd");
    if (i != 1)
    {
      if (i != 2)
      {
        Object localObject = "null";
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
          {
            a(paramObject, paramToServiceMsg.extraData.getBoolean("cmd_param_need_sync"));
            return;
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("fail to  handleDelMessage error code is ");
          if (paramFromServiceMsg != null) {
            localObject = Integer.valueOf(paramFromServiceMsg.getResultCode());
          }
          paramToServiceMsg.append(localObject);
          QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
          if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
          {
            EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
            return;
          }
          EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("3003", 2);
          return;
        }
        if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
        {
          a(paramObject, paramToServiceMsg.extraData.getString("cmd_param_data_version", ""));
          return;
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("fail to  handleUserInfoGet error code is ");
        if (paramFromServiceMsg != null) {
          localObject = Integer.valueOf(paramFromServiceMsg.getResultCode());
        }
        paramToServiceMsg.append(localObject);
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg.toString());
        if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
        {
          EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
          return;
        }
        EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("3002", 2);
        return;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler
 * JD-Core Version:    0.7.0.1
 */