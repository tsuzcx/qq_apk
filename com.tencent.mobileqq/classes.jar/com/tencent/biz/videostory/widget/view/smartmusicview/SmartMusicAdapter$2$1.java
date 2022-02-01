package com.tencent.biz.videostory.widget.view.smartmusicview;

import aaop;
import aaoz;
import aapa;
import aapc;
import java.util.List;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(aapc paramaapc) {}
  
  public void run()
  {
    if ((aapa.a(this.a.jdField_a_of_type_Aapa) != null) && (aapa.a(this.a.jdField_a_of_type_Aapa) != null))
    {
      int i = aapa.a(this.a.jdField_a_of_type_Aapa).a() % this.a.jdField_a_of_type_Aapa.a();
      aapa.a(this.a.jdField_a_of_type_Aapa).a((VsMusicItemInfo)aapa.a(this.a.jdField_a_of_type_Aapa).get(i), i, this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */