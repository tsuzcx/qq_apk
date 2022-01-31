package com.tencent.biz.videostory.widget.view.smartmusicview;

import ayrx;
import aysa;
import ayta;
import bbfj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import xiq;
import xir;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(xiq paramxiq) {}
  
  public void run()
  {
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = new xir(this);
    localayrx.jdField_a_of_type_JavaLangString = xiq.a(this.this$0);
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_c_of_type_JavaLangString = xiq.a(this.this$0).getPath();
    localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localayrx);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + xiq.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */