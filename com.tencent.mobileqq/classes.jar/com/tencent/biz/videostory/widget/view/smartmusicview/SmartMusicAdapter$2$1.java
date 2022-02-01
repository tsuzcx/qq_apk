package com.tencent.biz.videostory.widget.view.smartmusicview;

import abcs;
import abdc;
import abdd;
import abdf;
import java.util.List;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(abdf paramabdf) {}
  
  public void run()
  {
    if ((abdd.a(this.a.jdField_a_of_type_Abdd) != null) && (abdd.a(this.a.jdField_a_of_type_Abdd) != null))
    {
      int i = abdd.a(this.a.jdField_a_of_type_Abdd).a() % this.a.jdField_a_of_type_Abdd.a();
      abdd.a(this.a.jdField_a_of_type_Abdd).a((VsMusicItemInfo)abdd.a(this.a.jdField_a_of_type_Abdd).get(i), i, this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */