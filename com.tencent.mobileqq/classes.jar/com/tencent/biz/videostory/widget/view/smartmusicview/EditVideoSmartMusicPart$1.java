package com.tencent.biz.videostory.widget.view.smartmusicview;

import axro;
import axrr;
import axsr;
import badq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wzt;
import wzu;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(wzt paramwzt) {}
  
  public void run()
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = new wzu(this);
    localaxro.jdField_a_of_type_JavaLangString = wzt.a(this.this$0);
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = wzt.a(this.this$0).getPath();
    localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localaxro);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + wzt.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */