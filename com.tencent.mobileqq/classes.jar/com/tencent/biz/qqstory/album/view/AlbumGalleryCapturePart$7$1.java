package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import uef;
import ugk;
import ugr;
import ugu;
import wsv;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(ugr paramugr, List paramList, uef paramuef) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ugk.a(this.jdField_a_of_type_Ugr.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((ugk.c(this.jdField_a_of_type_Ugr.a) != -1) || (ugk.a(this.jdField_a_of_type_Ugr.a) != -1L)) {
        ugk.a(this.jdField_a_of_type_Ugr.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Uef.d();
      wsv.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    ugk.a(this.jdField_a_of_type_Ugr.a).b();
    this.jdField_a_of_type_Uef.d();
    if (ugk.c(this.jdField_a_of_type_Ugr.a) != -1) {
      ugk.a(this.jdField_a_of_type_Ugr.a).sendEmptyMessage(1004);
    }
    ugk.a(this.jdField_a_of_type_Ugr.a).sendEmptyMessageDelayed(1005, 180000L);
    wsv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */