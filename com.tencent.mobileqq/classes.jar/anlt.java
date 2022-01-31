import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

class anlt
  extends DataReportViewer
{
  anlt(anls paramanls, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void d()
  {
    int j = bawz.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(j, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = bawz.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
      anls.a(this.jdField_a_of_type_Anls).updateViewLayout(anls.a(this.jdField_a_of_type_Anls), localLayoutParams);
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
      localLayoutParams.y = bawz.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
      anls.a(this.jdField_a_of_type_Anls).updateViewLayout(anls.a(this.jdField_a_of_type_Anls), localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlt
 * JD-Core Version:    0.7.0.1
 */