package com.tencent.device.msg.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.ContactUtils;

public class MessageForDevLittleVideo
  extends MessageForShortVideo
{
  public String coverkey2;
  public String fileKey2;
  public String thumbFileKey;
  public String videoFileKey;
  
  public void doParse()
  {
    try
    {
      MessageForDevLittleVideo.DevLittleVideoMsgSerial localDevLittleVideoMsgSerial = (MessageForDevLittleVideo.DevLittleVideoMsgSerial)MessagePkgUtils.a(this.msgData);
      if (localDevLittleVideoMsgSerial != null)
      {
        this.thumbFileKey = localDevLittleVideoMsgSerial.thumbFileKey;
        this.videoFileKey = localDevLittleVideoMsgSerial.videoFileKey;
        this.fileKey2 = localDevLittleVideoMsgSerial.fileKey2;
        this.coverkey2 = localDevLittleVideoMsgSerial.coverKey2;
        this.videoFileSize = localDevLittleVideoMsgSerial.videoFileSize;
        this.videoFileFormat = localDevLittleVideoMsgSerial.videoFileFormat;
        this.videoFileTime = localDevLittleVideoMsgSerial.videoFileTime;
        this.uuid = localDevLittleVideoMsgSerial.uuid;
        this.md5 = localDevLittleVideoMsgSerial.md5;
        this.videoFileName = localDevLittleVideoMsgSerial.videoFileName;
        this.thumbWidth = localDevLittleVideoMsgSerial.thumbWidth;
        this.thumbHeight = localDevLittleVideoMsgSerial.thumbHeight;
        this.thumbMD5 = localDevLittleVideoMsgSerial.thumbMD5;
        this.mThumbFilePath = localDevLittleVideoMsgSerial.mThumbFilePath;
        this.mVideoFileSourceDir = localDevLittleVideoMsgSerial.mVideoFileSourceDir;
        this.videoFileStatus = localDevLittleVideoMsgSerial.videoFileStatus;
        this.videoFileProgress = localDevLittleVideoMsgSerial.videoFileProgress;
        this.fileType = localDevLittleVideoMsgSerial.fileType;
        this.fileSource = localDevLittleVideoMsgSerial.fileSource;
        this.lastModified = localDevLittleVideoMsgSerial.lastModified;
        this.thumbFileSize = localDevLittleVideoMsgSerial.thumbFileSize;
        this.busiType = localDevLittleVideoMsgSerial.busiType;
        this.fromChatType = localDevLittleVideoMsgSerial.fromChatType;
        this.toChatType = localDevLittleVideoMsgSerial.toChatType;
        this.uiOperatorFlag = localDevLittleVideoMsgSerial.uiOperatorFlag;
        this.issend = localDevLittleVideoMsgSerial.issend;
        this.senderuin = localDevLittleVideoMsgSerial.senderuin;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (isSendFromLocal()) {
        return HardCodeUtil.a(2131706592);
      }
      return ContactUtils.c((QQAppInterface)localObject, this.senderuin, true) + HardCodeUtil.a(2131706596);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevLittleVideo
 * JD-Core Version:    0.7.0.1
 */