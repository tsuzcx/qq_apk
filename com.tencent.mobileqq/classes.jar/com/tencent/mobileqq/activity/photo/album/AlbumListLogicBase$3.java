package com.tencent.mobileqq.activity.photo.album;

import aglv;
import agrb;
import agrj;
import agrm;
import bbfb;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AlbumListLogicBase$3
  implements Runnable
{
  public AlbumListLogicBase$3(agrj paramagrj, agrm paramagrm, aglv paramaglv) {}
  
  public void run()
  {
    bbfb.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_Agrm.b(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_Agrb.c, this.this$0.jdField_a_of_type_Agrb.jdField_b_of_type_Int, this.jdField_a_of_type_Aglv, this.this$0.jdField_a_of_type_Agrb.d, this.this$0.jdField_a_of_type_Agrb.jdField_b_of_type_Boolean, this.this$0.jdField_a_of_type_Agrb.a);
    this.jdField_a_of_type_Agrm.b(localQQAlbumInfo);
    bbfb.a("PEAK", "queryRecentBucket");
    bbfb.a();
    if ((this.jdField_a_of_type_Aglv != null) && (this.jdField_a_of_type_Aglv.b()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_Agrm.a(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Agrm.d(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    bbfb.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */