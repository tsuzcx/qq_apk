package com.tencent.biz.videostory.widget.view.smartmusicview;

import baps;
import bapv;
import baqx;
import bdee;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import yxj;
import yxk;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(yxj paramyxj) {}
  
  public void run()
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = new yxk(this);
    localbaps.jdField_a_of_type_JavaLangString = yxj.a(this.this$0);
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = yxj.a(this.this$0).getPath();
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localbaps);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + yxj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */