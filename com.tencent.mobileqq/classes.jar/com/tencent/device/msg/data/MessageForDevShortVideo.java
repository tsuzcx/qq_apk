package com.tencent.device.msg.data;

import abzh;
import android.os.Parcelable.Creator;
import anzj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new abzh();
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
      return anzj.a(2131705484);
    case 1003: 
      return ((QQAppInterface)localObject).getApp().getString(2131691135);
    case 1005: 
      return ((QQAppInterface)localObject).getApp().getString(2131691135);
    }
    return anzj.a(2131705479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevShortVideo
 * JD-Core Version:    0.7.0.1
 */