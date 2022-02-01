package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.CaptureListener;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

class QQIdentiferActivity$2
  implements QIdentifierCaptureView.CaptureListener
{
  QQIdentiferActivity$2(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      paramString = DialogUtil.a(this.a, 230, this.a.getString(2131698445), HardCodeUtil.a(2131710326), new QQIdentiferActivity.2.1(this), null);
      paramString.setOnDismissListener(new QQIdentiferActivity.2.2(this));
      paramString.show();
      return;
    }
    QQIdentiferActivity.a(this.a).set(false);
    QQIdentiferActivity.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.2
 * JD-Core Version:    0.7.0.1
 */