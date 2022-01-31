package com.tencent.biz.videostory.widget.view.smartmusicview;

import java.util.List;
import xio;
import xiy;
import xiz;
import xjb;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(xjb paramxjb) {}
  
  public void run()
  {
    if ((xiz.a(this.a.jdField_a_of_type_Xiz) != null) && (xiz.a(this.a.jdField_a_of_type_Xiz) != null))
    {
      int i = xiz.a(this.a.jdField_a_of_type_Xiz).a() % this.a.jdField_a_of_type_Xiz.a();
      xiz.a(this.a.jdField_a_of_type_Xiz).a((VsMusicItemInfo)xiz.a(this.a.jdField_a_of_type_Xiz).get(i), i, this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */