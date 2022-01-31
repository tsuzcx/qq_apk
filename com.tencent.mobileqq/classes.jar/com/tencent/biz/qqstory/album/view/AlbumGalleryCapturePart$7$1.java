package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import uio;
import ukt;
import ula;
import uld;
import wxe;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(ula paramula, List paramList, uio paramuio) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ukt.a(this.jdField_a_of_type_Ula.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((ukt.c(this.jdField_a_of_type_Ula.a) != -1) || (ukt.a(this.jdField_a_of_type_Ula.a) != -1L)) {
        ukt.a(this.jdField_a_of_type_Ula.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Uio.d();
      wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    ukt.a(this.jdField_a_of_type_Ula.a).b();
    this.jdField_a_of_type_Uio.d();
    if (ukt.c(this.jdField_a_of_type_Ula.a) != -1) {
      ukt.a(this.jdField_a_of_type_Ula.a).sendEmptyMessage(1004);
    }
    ukt.a(this.jdField_a_of_type_Ula.a).sendEmptyMessageDelayed(1005, 180000L);
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */