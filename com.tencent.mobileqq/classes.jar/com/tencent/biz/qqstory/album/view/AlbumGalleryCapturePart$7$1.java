package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import wfv;
import wia;
import wih;
import wik;
import yuk;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(wih paramwih, List paramList, wfv paramwfv) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      wia.a(this.jdField_a_of_type_Wih.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((wia.c(this.jdField_a_of_type_Wih.a) != -1) || (wia.a(this.jdField_a_of_type_Wih.a) != -1L)) {
        wia.a(this.jdField_a_of_type_Wih.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Wfv.d();
      yuk.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    wia.a(this.jdField_a_of_type_Wih.a).b();
    this.jdField_a_of_type_Wfv.d();
    if (wia.c(this.jdField_a_of_type_Wih.a) != -1) {
      wia.a(this.jdField_a_of_type_Wih.a).sendEmptyMessage(1004);
    }
    wia.a(this.jdField_a_of_type_Wih.a).sendEmptyMessageDelayed(1005, 180000L);
    yuk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */