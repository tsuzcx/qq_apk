import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class bgrp
  extends bcpq
{
  public bgrp(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    if (this.a.a) {
      super.onBackPressed();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IphoneTitleBarActivity", 2, "tool process has started, cancel by the tool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrp
 * JD-Core Version:    0.7.0.1
 */