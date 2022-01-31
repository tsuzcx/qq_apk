package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import spq;
import srv;
import ssc;
import ssf;
import veg;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(ssc paramssc, List paramList, spq paramspq) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      srv.a(this.jdField_a_of_type_Ssc.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((srv.c(this.jdField_a_of_type_Ssc.a) != -1) || (srv.a(this.jdField_a_of_type_Ssc.a) != -1L)) {
        srv.a(this.jdField_a_of_type_Ssc.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Spq.d();
      veg.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    srv.a(this.jdField_a_of_type_Ssc.a).b();
    this.jdField_a_of_type_Spq.d();
    if (srv.c(this.jdField_a_of_type_Ssc.a) != -1) {
      srv.a(this.jdField_a_of_type_Ssc.a).sendEmptyMessage(1004);
    }
    srv.a(this.jdField_a_of_type_Ssc.a).sendEmptyMessageDelayed(1005, 180000L);
    veg.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */