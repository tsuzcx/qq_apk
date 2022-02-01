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
  protected Handler a;
  public BaseQQAppInterface a;
  public MessageRecord a;
  public ShortVideoReq a;
  protected UiCallBack a;
  public String a;
  public String b;
  
  public DevLittleVideoSendOperator() {}
  
  public DevLittleVideoSendOperator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramQQAppInterface;
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = MessageRecordFactory.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.b);
    localMessageForDevLittleVideo.videoFileName = paramShortVideoUploadInfo.h;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_d_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramShortVideoUploadInfo.f;
    localMessageForDevLittleVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramShortVideoUploadInfo.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.l == null) {
      paramShortVideoUploadInfo.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramShortVideoUploadInfo.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = HardCodeUtil.a(2131703404);
    localMessageForDevLittleVideo.serial();
    paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    paramShortVideoUploadInfo = this.b;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, str, "packmsg", localStringBuilder.toString());
    paramShortVideoUploadInfo = this.b;
    str = this.jdField_a_of_type_JavaLangString;
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
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
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
    localShortVideoUploadInfo.jdField_c_of_type_JavaLangString = str2;
    localShortVideoUploadInfo.h = ((String)localObject1);
    localShortVideoUploadInfo.j = ((String)localObject2);
    localShortVideoUploadInfo.b = j;
    localShortVideoUploadInfo.jdField_d_of_type_JavaLangString = str4;
    localShortVideoUploadInfo.jdField_e_of_type_Int = ((int)l);
    localShortVideoUploadInfo.f = i;
    localShortVideoUploadInfo.jdField_e_of_type_JavaLangString = ((String)localObject3);
    localShortVideoUploadInfo.jdField_d_of_type_Boolean = bool;
    localShortVideoUploadInfo.jdField_c_of_type_Int = k;
    localShortVideoUploadInfo.jdField_d_of_type_Int = m;
    localShortVideoUploadInfo.jdField_g_of_type_Int = paramShortVideoReq.jdField_a_of_type_Int;
    localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject = paramObject;
    localShortVideoUploadInfo.jdField_g_of_type_JavaLangString = str1;
    localShortVideoUploadInfo.l = str3;
    localShortVideoUploadInfo.k = ((String)localObject4);
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "");
    return localShortVideoUploadInfo;
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localShortVideoResult.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.b, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.b);
      return;
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    Object localObject = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localObject = new ShortVideoResult();
    }
    ((ShortVideoResult)localObject).jdField_a_of_type_Int = 0;
    ((ShortVideoResult)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    a(paramInt, 0, localObject);
    paramShortVideoResult = this.b;
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo) {}
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoSendOperator.1(this, paramShortVideoUploadInfo));
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList) {}
  
  boolean a(String paramString)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = localSmartDeviceProxyMgr.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localSmartDeviceProxyMgr.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!StringUtil.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).jdField_a_of_type_Int = 0;
      ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.jdField_a_of_type_JavaLangString;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoSendOperator
 * JD-Core Version:    0.7.0.1
 */