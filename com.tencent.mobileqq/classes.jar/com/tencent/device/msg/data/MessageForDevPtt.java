package com.tencent.device.msg.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForDevPtt
  extends MessageForPtt
{
  public int channeltype = 0;
  public long fileSessionId = 0L;
  public String strFileKey2;
  
  public void doParse()
  {
    super.doParse();
    if ((this.urlAtServer != null) && (!TextUtils.isEmpty(this.urlAtServer)) && (this.msgTime != 0L)) {
      return;
    }
    Object localObject = null;
    try
    {
      MessageForDevPtt.MessageForDevPttSerial localMessageForDevPttSerial = (MessageForDevPtt.MessageForDevPttSerial)MessagePkgUtils.a(this.msgData);
      localObject = localMessageForDevPttSerial;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (localObject != null)
    {
      this.url = localObject.url;
      this.fileSize = localObject.fileSize;
      this.itemType = localObject.itemType;
      this.isReadPtt = localObject.isReadPtt;
      this.urlAtServer = localObject.urlAtServer;
      this.md5 = localObject.md5;
      this.storageSource = localObject.storageSource;
      this.subVersion = localObject.subVersion;
      this.isReport = localObject.isReport;
      this.sttAbility = localObject.sttAbility;
      this.groupFileID = localObject.groupFileID;
      this.sttText = localObject.sttText;
      this.longPttVipFlag = localObject.longPttVipFlag;
      this.expandStt = localObject.expandStt;
      this.groupFileKeyStr = localObject.groupFileKeyStr;
      this.msgTime = localObject.msgTime;
      this.msgRecTime = localObject.msgRecTime;
      this.voiceType = localObject.voiceType;
      this.voiceLength = localObject.voiceLength;
      this.voiceChangeFlag = localObject.voiceChangeFlag;
      this.busiType = localObject.busiType;
      this.directUrl = localObject.directUrl;
      this.fullLocalPath = localObject.fullLocalPath;
      this.extFlag = localObject.extFlag;
      this.channeltype = localObject.channeltype;
      this.strFileKey2 = localObject.strFileKey2;
    }
  }
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (this.fileSize > 0L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).getApp().getString(2131888237);
        }
        return HardCodeUtil.a(2131904491);
      }
      if (this.fileSize == -1L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).getApp().getString(2131888237);
        }
        return HardCodeUtil.a(2131904462);
      }
      return HardCodeUtil.a(2131904463);
    }
    return null;
  }
  
  public void serial()
  {
    MessageForDevPtt.MessageForDevPttSerial localMessageForDevPttSerial = new MessageForDevPtt.MessageForDevPttSerial(null);
    localMessageForDevPttSerial.url = this.url;
    localMessageForDevPttSerial.fileSize = this.fileSize;
    localMessageForDevPttSerial.itemType = this.itemType;
    localMessageForDevPttSerial.isReadPtt = this.isReadPtt;
    localMessageForDevPttSerial.urlAtServer = this.urlAtServer;
    localMessageForDevPttSerial.md5 = this.md5;
    localMessageForDevPttSerial.storageSource = this.storageSource;
    localMessageForDevPttSerial.subVersion = this.subVersion;
    localMessageForDevPttSerial.isReport = this.isReport;
    localMessageForDevPttSerial.sttAbility = this.sttAbility;
    localMessageForDevPttSerial.groupFileID = this.groupFileID;
    localMessageForDevPttSerial.sttText = this.sttText;
    localMessageForDevPttSerial.longPttVipFlag = this.longPttVipFlag;
    localMessageForDevPttSerial.expandStt = this.expandStt;
    localMessageForDevPttSerial.groupFileKeyStr = this.groupFileKeyStr;
    localMessageForDevPttSerial.msgTime = this.msgTime;
    localMessageForDevPttSerial.msgRecTime = this.msgRecTime;
    localMessageForDevPttSerial.voiceType = this.voiceType;
    localMessageForDevPttSerial.voiceLength = this.voiceLength;
    localMessageForDevPttSerial.voiceChangeFlag = this.voiceChangeFlag;
    localMessageForDevPttSerial.busiType = this.busiType;
    localMessageForDevPttSerial.directUrl = this.directUrl;
    localMessageForDevPttSerial.fullLocalPath = this.fullLocalPath;
    localMessageForDevPttSerial.extFlag = this.extFlag;
    localMessageForDevPttSerial.channeltype = this.channeltype;
    localMessageForDevPttSerial.strFileKey2 = this.strFileKey2;
    try
    {
      this.msgData = MessagePkgUtils.a(localMessageForDevPttSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevPtt
 * JD-Core Version:    0.7.0.1
 */