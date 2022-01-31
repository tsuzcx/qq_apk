package com.tencent.mobileqq.activity.aio.item;

import addx;
import adef;
import android.text.TextPaint;
import android.widget.TextView;
import apck;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileItemBuilder$9
  implements Runnable
{
  public FileItemBuilder$9(addx paramaddx, adef paramadef, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Adef.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName;
    boolean bool = addx.a(this.this$0);
    int j = this.jdField_a_of_type_Adef.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Adef.a.getPaint();
    if (addx.a(this.this$0)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(apck.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */