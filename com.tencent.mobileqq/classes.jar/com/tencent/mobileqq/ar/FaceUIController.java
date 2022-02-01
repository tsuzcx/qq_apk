package com.tencent.mobileqq.ar;

import android.content.Context;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FaceUIController
{
  public ARTipsManager a;
  public QQCustomDialog b;
  Context c;
  
  public FaceUIController(Context paramContext, ARTipsManager paramARTipsManager)
  {
    this.c = paramContext;
    this.a = paramARTipsManager;
    this.b = DialogUtil.a(this.c, 230);
    paramContext = new FaceUIController.1(this);
    this.b.setPositiveButton(2131887015, paramContext);
    this.b.setNegativeButton(2131887014, paramContext);
    this.b.setMessage(2131887017);
  }
  
  public void a()
  {
    if (!this.b.isShowing()) {
      this.b.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    ReportController.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceUIController
 * JD-Core Version:    0.7.0.1
 */