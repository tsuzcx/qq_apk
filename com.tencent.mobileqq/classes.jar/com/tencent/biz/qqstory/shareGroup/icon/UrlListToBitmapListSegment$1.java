package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.util.List;

class UrlListToBitmapListSegment$1
  implements UrlBitmapDownloader.Listener
{
  UrlListToBitmapListSegment$1(UrlListToBitmapListSegment paramUrlListToBitmapListSegment, List paramList, Bitmap[] paramArrayOfBitmap, Handler paramHandler) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
    IconLog.b(UrlListToBitmapListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlListToBitmapListSegment), "bitmap download success index=%d, url=%s", Integer.valueOf(i), paramString);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = paramBitmap;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    paramString = this.jdField_a_of_type_AndroidOsHandler;
    paramString.sendMessageDelayed(Message.obtain(paramString, 0, this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap), 200L);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
    IconLog.c(UrlListToBitmapListSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupIconUrlListToBitmapListSegment), "bitmap download failed index=%s, error=%s", Integer.valueOf(i), paramThrowable);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramString = this.jdField_a_of_type_AndroidOsHandler;
    paramString.sendMessageDelayed(Message.obtain(paramString, 1, paramThrowable), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UrlListToBitmapListSegment.1
 * JD-Core Version:    0.7.0.1
 */