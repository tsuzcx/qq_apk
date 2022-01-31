package com.tencent.mobileqq.activity.aio.item;

import aflw;
import afme;
import android.text.TextPaint;
import android.widget.TextView;
import arrr;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileItemBuilder$8
  implements Runnable
{
  public FileItemBuilder$8(aflw paramaflw, afme paramafme, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Afme.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    boolean bool = aflw.a(this.this$0);
    int j = this.jdField_a_of_type_Afme.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Afme.a.getPaint();
    if (aflw.a(this.this$0)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(arrr.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */