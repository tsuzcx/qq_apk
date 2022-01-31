package com.tencent.biz.videostory.widget.view.smartmusicview;

import ayrv;
import ayry;
import aysy;
import bbev;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import xit;
import xiu;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(xit paramxit) {}
  
  public void run()
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = new xiu(this);
    localayrv.jdField_a_of_type_JavaLangString = xit.a(this.this$0);
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_c_of_type_JavaLangString = xit.a(this.this$0).getPath();
    localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localayrv);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + xit.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */