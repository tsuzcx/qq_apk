package com.tencent.mobileqq.activity.photo.album;

import afzz;
import agff;
import agfo;
import agfp;
import badi;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AlbumListLogicDefault$3
  implements Runnable
{
  public AlbumListLogicDefault$3(agfo paramagfo, agfp paramagfp, afzz paramafzz) {}
  
  public void run()
  {
    badi.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_Agfp.b(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_Agff.c, this.this$0.jdField_a_of_type_Agff.b, this.jdField_a_of_type_Afzz, this.this$0.jdField_a_of_type_Agff.jdField_d_of_type_Int, this.this$0.jdField_a_of_type_Agff.jdField_d_of_type_Boolean, this.this$0.jdField_a_of_type_Agff.a);
    this.jdField_a_of_type_Agfp.b(localQQAlbumInfo);
    badi.a("PEAK", "queryRecentBucket");
    badi.a();
    if ((this.jdField_a_of_type_Afzz != null) && (this.jdField_a_of_type_Afzz.b()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_Agfp.a(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Agfp.d(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    badi.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault.3
 * JD-Core Version:    0.7.0.1
 */