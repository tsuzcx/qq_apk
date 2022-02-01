package com.tencent.device.msg.data;

import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new MessageForDevShortVideo.1();
  public long fileSessionId;
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      int i = this.videoFileStatus;
      if (i != 1002)
      {
        if (i != 1003)
        {
          if (i != 1005)
          {
            if (i == 2003) {
              return HardCodeUtil.a(2131706627);
            }
          }
          else {
            return ((QQAppInterface)localObject).getApp().getString(2131691289);
          }
        }
        else {
          return ((QQAppInterface)localObject).getApp().getString(2131691289);
        }
      }
      else {
        return HardCodeUtil.a(2131706622);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevShortVideo
 * JD-Core Version:    0.7.0.1
 */