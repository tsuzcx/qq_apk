package com.tencent.device.msg.data;

import ablc;
import android.os.Parcelable.Creator;
import anvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new ablc();
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
      return anvx.a(2131706065);
    case 1003: 
      return ((QQAppInterface)localObject).getApp().getString(2131691259);
    case 1005: 
      return ((QQAppInterface)localObject).getApp().getString(2131691259);
    }
    return anvx.a(2131706060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevShortVideo
 * JD-Core Version:    0.7.0.1
 */