package com.tencent.mobileqq.activity.photo.album;

import aglx;
import agrd;
import agrl;
import agro;
import bben;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AlbumListLogicBase$3
  implements Runnable
{
  public AlbumListLogicBase$3(agrl paramagrl, agro paramagro, aglx paramaglx) {}
  
  public void run()
  {
    bben.a();
    QQAlbumInfo localQQAlbumInfo = this.jdField_a_of_type_Agro.b(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.this$0.jdField_a_of_type_Agrd.c, this.this$0.jdField_a_of_type_Agrd.jdField_b_of_type_Int, this.jdField_a_of_type_Aglx, this.this$0.jdField_a_of_type_Agrd.d, this.this$0.jdField_a_of_type_Agrd.jdField_b_of_type_Boolean, this.this$0.jdField_a_of_type_Agrd.a);
    this.jdField_a_of_type_Agro.b(localQQAlbumInfo);
    bben.a("PEAK", "queryRecentBucket");
    bben.a();
    if ((this.jdField_a_of_type_Aglx != null) && (this.jdField_a_of_type_Aglx.b()))
    {
      localQQAlbumInfo = this.jdField_a_of_type_Agro.a(((AlbumListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_Agro.d(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    bben.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */