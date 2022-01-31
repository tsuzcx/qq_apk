package com.tencent.mobileqq.activity.photo;

import afze;
import afzz;
import badi;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;

public class AlbumListAdapter$7
  implements Runnable
{
  public AlbumListAdapter$7(afze paramafze) {}
  
  public void run()
  {
    
    if (afze.a(this.this$0)) {}
    for (QQAlbumInfo localQQAlbumInfo = this.this$0.b(this.this$0.jdField_a_of_type_AndroidAppActivity, afze.a(this.this$0), afze.b(this.this$0), this.this$0.jdField_a_of_type_Afzz, afze.c(this.this$0), true, afze.a(this.this$0));; localQQAlbumInfo = this.this$0.b(this.this$0.jdField_a_of_type_AndroidAppActivity, 210, 100, this.this$0.jdField_a_of_type_Afzz))
    {
      this.this$0.b(localQQAlbumInfo);
      badi.a("PEAK", "queryRecentBucket");
      badi.a();
      if ((this.this$0.jdField_a_of_type_Afzz != null) && (this.this$0.jdField_a_of_type_Afzz.b()))
      {
        localQQAlbumInfo = this.this$0.a(this.this$0.jdField_a_of_type_AndroidAppActivity);
        this.this$0.d(localQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
        }
      }
      badi.a("PEAK", "queryVideoBucket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListAdapter.7
 * JD-Core Version:    0.7.0.1
 */