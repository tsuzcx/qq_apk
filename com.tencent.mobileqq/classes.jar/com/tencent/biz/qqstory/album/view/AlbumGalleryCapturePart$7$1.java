package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import java.util.List;
import via;
import vkf;
import vki;
import vkk;
import xvv;

public class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  public AlbumGalleryCapturePart$7$1(vki paramvki, List paramList, via paramvia) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      vkf.a(this.jdField_a_of_type_Vki.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((vkf.b(this.jdField_a_of_type_Vki.a) != -1) || (vkf.a(this.jdField_a_of_type_Vki.a) != -1L)) {
        vkf.a(this.jdField_a_of_type_Vki.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_Via.c();
      xvv.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    vkf.a(this.jdField_a_of_type_Vki.a).a();
    this.jdField_a_of_type_Via.c();
    if (vkf.b(this.jdField_a_of_type_Vki.a) != -1) {
      vkf.a(this.jdField_a_of_type_Vki.a).sendEmptyMessage(1004);
    }
    vkf.a(this.jdField_a_of_type_Vki.a).sendEmptyMessageDelayed(1005, 180000L);
    xvv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */