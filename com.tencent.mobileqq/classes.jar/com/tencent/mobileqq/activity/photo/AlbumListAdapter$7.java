package com.tencent.mobileqq.activity.photo;

import agla;
import aglv;
import bbfb;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;

public class AlbumListAdapter$7
  implements Runnable
{
  public AlbumListAdapter$7(agla paramagla) {}
  
  public void run()
  {
    
    if (agla.a(this.this$0)) {}
    for (QQAlbumInfo localQQAlbumInfo = this.this$0.b(this.this$0.jdField_a_of_type_AndroidAppActivity, agla.a(this.this$0), agla.b(this.this$0), this.this$0.jdField_a_of_type_Aglv, agla.c(this.this$0), true, agla.a(this.this$0));; localQQAlbumInfo = this.this$0.b(this.this$0.jdField_a_of_type_AndroidAppActivity, 210, 100, this.this$0.jdField_a_of_type_Aglv))
    {
      this.this$0.b(localQQAlbumInfo);
      bbfb.a("PEAK", "queryRecentBucket");
      bbfb.a();
      if ((this.this$0.jdField_a_of_type_Aglv != null) && (this.this$0.jdField_a_of_type_Aglv.b()))
      {
        localQQAlbumInfo = this.this$0.a(this.this$0.jdField_a_of_type_AndroidAppActivity);
        this.this$0.d(localQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
        }
      }
      bbfb.a("PEAK", "queryVideoBucket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListAdapter.7
 * JD-Core Version:    0.7.0.1
 */