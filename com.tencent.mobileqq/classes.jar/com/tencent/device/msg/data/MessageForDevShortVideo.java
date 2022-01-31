package com.tencent.device.msg.data;

import ajya;
import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;
import yex;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new yex();
  public long fileSessionId;
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    }
    switch (this.videoFileStatus)
    {
    default: 
      return null;
    case 2003: 
      return ajya.a(2131706602);
    case 1003: 
      return ((QQAppInterface)localObject).getApp().getString(2131691300);
    case 1005: 
      return ((QQAppInterface)localObject).getApp().getString(2131691300);
    }
    return ajya.a(2131706597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevShortVideo
 * JD-Core Version:    0.7.0.1
 */