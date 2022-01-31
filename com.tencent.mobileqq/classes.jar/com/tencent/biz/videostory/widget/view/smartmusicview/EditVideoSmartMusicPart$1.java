package com.tencent.biz.videostory.widget.view.smartmusicview;

import baub;
import baue;
import bavg;
import bdin;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import zby;
import zbz;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(zby paramzby) {}
  
  public void run()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = new zbz(this);
    localbaub.jdField_a_of_type_JavaLangString = zby.a(this.this$0);
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_c_of_type_JavaLangString = zby.a(this.this$0).getPath();
    localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localbaub);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + zby.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */