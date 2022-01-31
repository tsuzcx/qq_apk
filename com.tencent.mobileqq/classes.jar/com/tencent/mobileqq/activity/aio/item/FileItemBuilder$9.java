package com.tencent.mobileqq.activity.aio.item;

import adox;
import adpf;
import android.text.TextPaint;
import android.widget.TextView;
import apug;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileItemBuilder$9
  implements Runnable
{
  public FileItemBuilder$9(adox paramadox, adpf paramadpf, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Adpf.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName;
    boolean bool = adox.a(this.this$0);
    int j = this.jdField_a_of_type_Adpf.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Adpf.a.getPaint();
    if (adox.a(this.this$0)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(apug.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */