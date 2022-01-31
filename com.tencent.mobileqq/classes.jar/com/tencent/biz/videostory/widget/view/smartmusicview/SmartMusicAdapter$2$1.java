package com.tencent.biz.videostory.widget.view.smartmusicview;

import java.util.List;
import xir;
import xjb;
import xjc;
import xje;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(xje paramxje) {}
  
  public void run()
  {
    if ((xjc.a(this.a.jdField_a_of_type_Xjc) != null) && (xjc.a(this.a.jdField_a_of_type_Xjc) != null))
    {
      int i = xjc.a(this.a.jdField_a_of_type_Xjc).a() % this.a.jdField_a_of_type_Xjc.a();
      xjc.a(this.a.jdField_a_of_type_Xjc).a((VsMusicItemInfo)xjc.a(this.a.jdField_a_of_type_Xjc).get(i), i, this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */