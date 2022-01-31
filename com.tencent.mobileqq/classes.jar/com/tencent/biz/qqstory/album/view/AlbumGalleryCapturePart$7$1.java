package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import scu;
import sez;
import sfg;
import sfj;
import urk;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(sfg paramsfg, List paramList, scu paramscu) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      sez.a(this.jdField_a_of_type_Sfg.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((sez.c(this.jdField_a_of_type_Sfg.a) != -1) || (sez.a(this.jdField_a_of_type_Sfg.a) != -1L)) {
        sez.a(this.jdField_a_of_type_Sfg.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Scu.d();
      urk.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    sez.a(this.jdField_a_of_type_Sfg.a).b();
    this.jdField_a_of_type_Scu.d();
    if (sez.c(this.jdField_a_of_type_Sfg.a) != -1) {
      sez.a(this.jdField_a_of_type_Sfg.a).sendEmptyMessage(1004);
    }
    sez.a(this.jdField_a_of_type_Sfg.a).sendEmptyMessageDelayed(1005, 180000L);
    urk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */