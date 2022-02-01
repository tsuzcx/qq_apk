package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import vwv;
import vza;
import vzd;
import vzf;
import ykq;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(vzd paramvzd, List paramList, vwv paramvwv) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      vza.a(this.jdField_a_of_type_Vzd.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((vza.b(this.jdField_a_of_type_Vzd.a) != -1) || (vza.a(this.jdField_a_of_type_Vzd.a) != -1L)) {
        vza.a(this.jdField_a_of_type_Vzd.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Vwv.c();
      ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    vza.a(this.jdField_a_of_type_Vzd.a).a();
    this.jdField_a_of_type_Vwv.c();
    if (vza.b(this.jdField_a_of_type_Vzd.a) != -1) {
      vza.a(this.jdField_a_of_type_Vzd.a).sendEmptyMessage(1004);
    }
    vza.a(this.jdField_a_of_type_Vzd.a).sendEmptyMessageDelayed(1005, 180000L);
    ykq.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */