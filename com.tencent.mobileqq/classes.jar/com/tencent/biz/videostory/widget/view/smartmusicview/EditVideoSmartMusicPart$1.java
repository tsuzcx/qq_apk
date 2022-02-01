package com.tencent.biz.videostory.widget.view.smartmusicview;

import abcu;
import abcv;
import beum;
import beuo;
import bevn;
import bhnv;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(abcu paramabcu) {}
  
  public void run()
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new abcv(this);
    localbeum.jdField_a_of_type_JavaLangString = abcu.a(this.this$0);
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = abcu.a(this.this$0).getPath();
    localbeum.b = bhnv.a(bevn.a().a());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).a(localbeum);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + abcu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */