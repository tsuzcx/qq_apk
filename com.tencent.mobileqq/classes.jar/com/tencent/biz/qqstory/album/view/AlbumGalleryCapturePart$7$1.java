package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import spn;
import srs;
import srz;
import ssc;
import ved;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(srz paramsrz, List paramList, spn paramspn) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      srs.a(this.jdField_a_of_type_Srz.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((srs.c(this.jdField_a_of_type_Srz.a) != -1) || (srs.a(this.jdField_a_of_type_Srz.a) != -1L)) {
        srs.a(this.jdField_a_of_type_Srz.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Spn.d();
      ved.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    srs.a(this.jdField_a_of_type_Srz.a).b();
    this.jdField_a_of_type_Spn.d();
    if (srs.c(this.jdField_a_of_type_Srz.a) != -1) {
      srs.a(this.jdField_a_of_type_Srz.a).sendEmptyMessage(1004);
    }
    srs.a(this.jdField_a_of_type_Srz.a).sendEmptyMessageDelayed(1005, 180000L);
    ved.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */