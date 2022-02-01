package com.tencent.biz.videostory.widget.view.smartmusicview;

import aayr;
import aays;
import bdvs;
import bdvu;
import bdwu;
import bgnt;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(aayr paramaayr) {}
  
  public void run()
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new aays(this);
    localbdvs.jdField_a_of_type_JavaLangString = aayr.a(this.this$0);
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = aayr.a(this.this$0).getPath();
    localbdvs.b = bgnt.a(bdwu.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localbdvs);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + aayr.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */