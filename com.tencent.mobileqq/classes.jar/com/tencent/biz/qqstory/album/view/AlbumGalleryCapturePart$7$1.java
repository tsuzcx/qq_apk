package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import wca;
import wef;
import wem;
import wep;
import yqp;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(wem paramwem, List paramList, wca paramwca) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      wef.a(this.jdField_a_of_type_Wem.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((wef.c(this.jdField_a_of_type_Wem.a) != -1) || (wef.a(this.jdField_a_of_type_Wem.a) != -1L)) {
        wef.a(this.jdField_a_of_type_Wem.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Wca.d();
      yqp.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    wef.a(this.jdField_a_of_type_Wem.a).b();
    this.jdField_a_of_type_Wca.d();
    if (wef.c(this.jdField_a_of_type_Wem.a) != -1) {
      wef.a(this.jdField_a_of_type_Wem.a).sendEmptyMessage(1004);
    }
    wef.a(this.jdField_a_of_type_Wem.a).sendEmptyMessageDelayed(1005, 180000L);
    yqp.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */