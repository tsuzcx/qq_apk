package com.tencent.mobileqq.activity.aio.photo;

import ajjy;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import bajq;
import com.tencent.qphone.base.util.QLog;

class PhotoListPanel$3
  implements Runnable
{
  public void run()
  {
    if (ajjy.a(2131642327).equals(this.jdField_a_of_type_JavaLangString)) {
      PhotoListPanel.a(this.this$0).setText(2131629469);
    }
    for (;;)
    {
      Object localObject = PhotoListPanel.b(this.this$0).getPaint();
      int i = bajq.a((Paint)localObject, "《");
      int j = PhotoListPanel.a(this.this$0).getLeft();
      int k = PhotoListPanel.a(this.this$0).getRight();
      localObject = bajq.a((Paint)localObject, this.jdField_a_of_type_JavaLangString, j - k - i * 2);
      PhotoListPanel.b(this.this$0).setText("《" + (String)localObject + "》");
      PhotoListPanel.b(this.this$0).setContentDescription(this.jdField_a_of_type_JavaLangString);
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoListPanel", 4, "update album view. albumName=" + (String)localObject);
      }
      return;
      if (this.jdField_a_of_type_Boolean) {
        PhotoListPanel.a(this.this$0).setText(2131629472);
      } else {
        PhotoListPanel.a(this.this$0).setText(2131629468);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.3
 * JD-Core Version:    0.7.0.1
 */