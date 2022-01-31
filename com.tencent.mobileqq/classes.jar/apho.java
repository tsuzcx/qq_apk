import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

class apho
  extends DataReportViewer
{
  apho(aphn paramaphn, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void d()
  {
    int j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(j, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
      aphn.a(this.jdField_a_of_type_Aphn).updateViewLayout(aphn.a(this.jdField_a_of_type_Aphn), localLayoutParams);
      return;
    }
  }
  
  public void e()
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
      aphn.a(this.jdField_a_of_type_Aphn).updateViewLayout(aphn.a(this.jdField_a_of_type_Aphn), localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apho
 * JD-Core Version:    0.7.0.1
 */