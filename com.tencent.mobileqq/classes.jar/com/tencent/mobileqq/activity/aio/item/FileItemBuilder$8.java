package com.tencent.mobileqq.activity.aio.item;

import adoz;
import adph;
import android.text.TextPaint;
import android.widget.TextView;
import apue;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileItemBuilder$8
  implements Runnable
{
  public FileItemBuilder$8(adoz paramadoz, adph paramadph, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Adph.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    boolean bool = adoz.a(this.this$0);
    int j = this.jdField_a_of_type_Adph.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Adph.a.getPaint();
    if (adoz.a(this.this$0)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(apue.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */