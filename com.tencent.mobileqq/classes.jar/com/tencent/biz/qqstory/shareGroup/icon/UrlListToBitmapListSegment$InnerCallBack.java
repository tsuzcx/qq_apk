package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Arrays;

class UrlListToBitmapListSegment$InnerCallBack
  implements Handler.Callback
{
  private UrlListToBitmapListSegment$InnerCallBack(UrlListToBitmapListSegment paramUrlListToBitmapListSegment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int k = 0;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      UrlListToBitmapListSegment.a(this.a, new Error((Throwable)paramMessage.obj));
      return true;
    }
    paramMessage = (Bitmap[])paramMessage.obj;
    int m = paramMessage.length;
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (paramMessage[i] == null)
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0) {
      UrlListToBitmapListSegment.a(this.a, Arrays.asList(paramMessage));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UrlListToBitmapListSegment.InnerCallBack
 * JD-Core Version:    0.7.0.1
 */