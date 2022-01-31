package com.tencent.biz.videostory.widget.view.smartmusicview;

import java.util.List;
import yxh;
import yxr;
import yxs;
import yxu;

public class SmartMusicAdapter$2$1
  implements Runnable
{
  public SmartMusicAdapter$2$1(yxu paramyxu) {}
  
  public void run()
  {
    if ((yxs.a(this.a.jdField_a_of_type_Yxs) != null) && (yxs.a(this.a.jdField_a_of_type_Yxs) != null))
    {
      int i = yxs.a(this.a.jdField_a_of_type_Yxs).a() % this.a.jdField_a_of_type_Yxs.a();
      yxs.a(this.a.jdField_a_of_type_Yxs).a((VsMusicItemInfo)yxs.a(this.a.jdField_a_of_type_Yxs).get(i), i, this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */