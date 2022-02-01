package com.tencent.device.msg.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

public class MessageForDevLittleVideo
  extends MessageForShortVideo
{
  public String coverkey2;
  public String fileKey2;
  public String thumbFileKey;
  public String videoFileKey;
  
  public void doParse()
  {
    Object localObject;
    try
    {
      MessageForDevLittleVideo.DevLittleVideoMsgSerial localDevLittleVideoMsgSerial = (MessageForDevLittleVideo.DevLittleVideoMsgSerial)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.thumbFileKey = localObject.thumbFileKey;
      this.videoFileKey = localObject.videoFileKey;
      this.fileKey2 = localObject.fileKey2;
      this.coverkey2 = localObject.coverKey2;
      this.videoFileSize = localObject.videoFileSize;
      this.videoFileFormat = localObject.videoFileFormat;
      this.videoFileTime = localObject.videoFileTime;
      this.uuid = localObject.uuid;
      this.md5 = localObject.md5;
      this.videoFileName = localObject.videoFileName;
      this.thumbWidth = localObject.thumbWidth;
      this.thumbHeight = localObject.thumbHeight;
      this.thumbMD5 = localObject.thumbMD5;
      this.mThumbFilePath = localObject.mThumbFilePath;
      this.mVideoFileSourceDir = localObject.mVideoFileSourceDir;
      this.videoFileStatus = localObject.videoFileStatus;
      this.videoFileProgress = localObject.videoFileProgress;
      this.fileType = localObject.fileType;
      this.fileSource = localObject.fileSource;
      this.lastModified = localObject.lastModified;
      this.thumbFileSize = localObject.thumbFileSize;
      this.busiType = localObject.busiType;
      this.fromChatType = localObject.fromChatType;
      this.toChatType = localObject.toChatType;
      this.uiOperatorFlag = localObject.uiOperatorFlag;
      this.issend = localObject.issend;
      this.senderuin = localObject.senderuin;
    }
  }
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (isSendFromLocal()) {
        return HardCodeUtil.a(2131706614);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ContactUtils.a((AppRuntime)localObject, this.senderuin, true));
      localStringBuilder.append(HardCodeUtil.a(2131706618));
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void serial()
  {
    MessageForDevLittleVideo.DevLittleVideoMsgSerial localDevLittleVideoMsgSerial = new MessageForDevLittleVideo.DevLittleVideoMsgSerial(null);
    localDevLittleVideoMsgSerial.thumbFileKey = this.thumbFileKey;
    localDevLittleVideoMsgSerial.videoFileKey = this.videoFileKey;
    localDevLittleVideoMsgSerial.fileKey2 = this.fileKey2;
    localDevLittleVideoMsgSerial.coverKey2 = this.coverkey2;
    localDevLittleVideoMsgSerial.videoFileSize = this.videoFileSize;
    localDevLittleVideoMsgSerial.videoFileFormat = this.videoFileFormat;
    localDevLittleVideoMsgSerial.videoFileTime = this.videoFileTime;
    localDevLittleVideoMsgSerial.uuid = this.uuid;
    localDevLittleVideoMsgSerial.md5 = this.md5;
    localDevLittleVideoMsgSerial.videoFileName = this.videoFileName;
    localDevLittleVideoMsgSerial.thumbWidth = this.thumbWidth;
    localDevLittleVideoMsgSerial.thumbHeight = this.thumbHeight;
    localDevLittleVideoMsgSerial.thumbMD5 = this.thumbMD5;
    localDevLittleVideoMsgSerial.mThumbFilePath = this.mThumbFilePath;
    localDevLittleVideoMsgSerial.mVideoFileSourceDir = this.mVideoFileSourceDir;
    localDevLittleVideoMsgSerial.videoFileStatus = this.videoFileStatus;
    localDevLittleVideoMsgSerial.videoFileProgress = this.videoFileProgress;
    localDevLittleVideoMsgSerial.fileType = this.fileType;
    localDevLittleVideoMsgSerial.fileSource = this.fileSource;
    localDevLittleVideoMsgSerial.lastModified = this.lastModified;
    localDevLittleVideoMsgSerial.thumbFileSize = this.thumbFileSize;
    localDevLittleVideoMsgSerial.busiType = this.busiType;
    localDevLittleVideoMsgSerial.fromChatType = this.fromChatType;
    localDevLittleVideoMsgSerial.toChatType = this.toChatType;
    localDevLittleVideoMsgSerial.uiOperatorFlag = this.uiOperatorFlag;
    localDevLittleVideoMsgSerial.issend = this.issend;
    localDevLittleVideoMsgSerial.senderuin = this.senderuin;
    try
    {
      this.msgData = MessagePkgUtils.a(localDevLittleVideoMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevLittleVideo
 * JD-Core Version:    0.7.0.1
 */