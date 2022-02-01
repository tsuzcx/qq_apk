package com.tencent.device.file;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.UiCallBack;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class DevLittleVideoSendOperator
  implements UpCallBack, IShortVideoOperator
{
  public BaseQQAppInterface a;
  public ShortVideoReq b;
  protected UiCallBack c;
  public String d;
  public String e;
  public MessageRecord f;
  protected Handler g;
  
  public DevLittleVideoSendOperator() {}
  
  public DevLittleVideoSendOperator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = MessageRecordFactory.d((QQAppInterface)this.a, paramShortVideoUploadInfo.e, paramShortVideoUploadInfo.f, paramShortVideoUploadInfo.c);
    localMessageForDevLittleVideo.videoFileName = paramShortVideoUploadInfo.l;
    if (paramShortVideoUploadInfo.a == null) {
      paramShortVideoUploadInfo.a = "";
    }
    localMessageForDevLittleVideo.uuid = paramShortVideoUploadInfo.a;
    if (paramShortVideoUploadInfo.i == null) {
      paramShortVideoUploadInfo.i = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramShortVideoUploadInfo.A;
    localMessageForDevLittleVideo.md5 = paramShortVideoUploadInfo.i;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramShortVideoUploadInfo.q;
    localMessageForDevLittleVideo.videoFileTime = paramShortVideoUploadInfo.r;
    localMessageForDevLittleVideo.thumbWidth = paramShortVideoUploadInfo.o;
    localMessageForDevLittleVideo.thumbHeight = paramShortVideoUploadInfo.p;
    localMessageForDevLittleVideo.mThumbFilePath = paramShortVideoUploadInfo.n;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.u;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramShortVideoUploadInfo.k;
    if (paramShortVideoUploadInfo.v == null) {
      paramShortVideoUploadInfo.v = "";
    }
    localMessageForDevLittleVideo.fileSource = paramShortVideoUploadInfo.v;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = HardCodeUtil.a(2131901363);
    localMessageForDevLittleVideo.serial();
    paramShortVideoUploadInfo.g = localMessageForDevLittleVideo.uniseq;
    paramShortVideoUploadInfo = this.e;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, str, "packmsg", localStringBuilder.toString());
    paramShortVideoUploadInfo = this.e;
    str = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mr: ");
    localStringBuilder.append(localMessageForDevLittleVideo.toLogString());
    localStringBuilder.append("-");
    localStringBuilder.append(localMessageForDevLittleVideo.toString());
    Logger.a(paramShortVideoUploadInfo, str, "packMsg", localStringBuilder.toString());
    return localMessageForDevLittleVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.f;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.e, this.d, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    boolean bool = paramObject instanceof Intent;
    long l = 0L;
    String str2 = "0";
    String str3 = "";
    int j = 0;
    Object localObject4;
    String str4;
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int k;
    int m;
    String str1;
    if (bool)
    {
      localObject4 = (Intent)paramObject;
      str2 = ((Intent)localObject4).getStringExtra("uin");
      str4 = ((Intent)localObject4).getStringExtra("troop_uin");
      j = ((Intent)localObject4).getIntExtra("uintype", 1003);
      l = ((Intent)localObject4).getLongExtra("file_send_size", 0L);
      ((Intent)localObject4).getIntExtra("file_send_business_type", -1);
      i = ((Intent)localObject4).getIntExtra("file_send_duration", -1);
      localObject1 = ((Intent)localObject4).getStringExtra("file_send_path");
      localObject2 = ((Intent)localObject4).getStringExtra("thumbfile_send_path");
      localObject3 = ((Intent)localObject4).getStringExtra("file_shortvideo_md5");
      bool = ((Intent)localObject4).getBooleanExtra("mediacodec_encode_enable", false);
      k = ((Intent)localObject4).getIntExtra("thumbfile_send_width", 0);
      m = ((Intent)localObject4).getIntExtra("thumbfile_send_height", 0);
      str1 = ((Intent)localObject4).getStringExtra("thumbfile_md5");
      str3 = ((Intent)localObject4).getStringExtra("file_source");
      localObject4 = ((Intent)localObject4).getStringExtra("file_video_source_dir");
    }
    else if ((paramObject instanceof MessageForDevLittleVideo))
    {
      localObject4 = (MessageForShortVideo)paramObject;
      str2 = ((MessageForShortVideo)localObject4).frienduin;
      str4 = ((MessageForShortVideo)localObject4).frienduin;
      j = ((MessageForShortVideo)localObject4).istroop;
      l = ((MessageForShortVideo)localObject4).videoFileSize;
      i = ((MessageForShortVideo)localObject4).videoFileTime;
      localObject1 = ((MessageForShortVideo)localObject4).videoFileName;
      localObject2 = SVUtils.a(((MessageForShortVideo)localObject4).thumbMD5, "jpg");
      localObject3 = ((MessageForShortVideo)localObject4).md5;
      bool = ((MessageForShortVideo)localObject4).mediacodecEncode;
      k = ((MessageForShortVideo)localObject4).thumbWidth;
      m = ((MessageForShortVideo)localObject4).thumbHeight;
      str1 = ((MessageForShortVideo)localObject4).thumbMD5;
      str3 = ((MessageForShortVideo)localObject4).fileSource;
      localObject4 = ((MessageForShortVideo)localObject4).mVideoFileSourceDir;
    }
    else
    {
      str4 = "0";
      str1 = "";
      localObject1 = str1;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject3;
      i = 0;
      k = 0;
      m = 0;
      bool = false;
    }
    ShortVideoUploadInfo localShortVideoUploadInfo = new ShortVideoUploadInfo();
    localShortVideoUploadInfo.e = str2;
    localShortVideoUploadInfo.l = ((String)localObject1);
    localShortVideoUploadInfo.n = ((String)localObject2);
    localShortVideoUploadInfo.c = j;
    localShortVideoUploadInfo.f = str4;
    localShortVideoUploadInfo.q = ((int)l);
    localShortVideoUploadInfo.r = i;
    localShortVideoUploadInfo.i = ((String)localObject3);
    localShortVideoUploadInfo.A = bool;
    localShortVideoUploadInfo.o = k;
    localShortVideoUploadInfo.p = m;
    localShortVideoUploadInfo.t = paramShortVideoReq.a;
    localShortVideoUploadInfo.s = paramObject;
    localShortVideoUploadInfo.k = str1;
    localShortVideoUploadInfo.v = str3;
    localShortVideoUploadInfo.u = ((String)localObject4);
    Logger.a(this.e, this.d, "createShortVideoUploadInfo", "");
    return localShortVideoUploadInfo;
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.g.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.c = this.b;
    localShortVideoResult.b = paramErrInfo;
    localShortVideoResult.a = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.e, this.d, paramErrInfo.a, paramErrInfo.b);
      return;
    }
    Logger.b(this.e, this.d, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    Object localObject = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localObject = new ShortVideoResult();
    }
    ((ShortVideoResult)localObject).a = 0;
    ((ShortVideoResult)localObject).c = this.b;
    a(paramInt, 0, localObject);
    paramShortVideoResult = this.e;
    localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((IOrderMediaMsgService)this.a.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.b = paramShortVideoReq;
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.c = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList) {}
  
  public ShortVideoForwardInfo b(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.a == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).a = 0;
      ((ShortVideoResult)localObject).d = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.c;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
  
  public void b(ShortVideoForwardInfo paramShortVideoForwardInfo) {}
  
  public void b(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.e, this.d, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoSendOperator.1(this, paramShortVideoUploadInfo));
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  boolean c(String paramString)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = localSmartDeviceProxyMgr.g(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localSmartDeviceProxyMgr.f(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!StringUtil.isEmpty(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoSendOperator
 * JD-Core Version:    0.7.0.1
 */