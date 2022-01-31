import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsReaderView;

class argl
  implements View.OnClickListener
{
  argl(argk paramargk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 5018)
    {
      paramView = this.jdField_a_of_type_Argk.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      if (paramView.getWidth() > paramView.getHeight()) {}
      for (int i = 0; i != 0; i = 1)
      {
        this.jdField_a_of_type_Argk.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
        return;
      }
      this.jdField_a_of_type_Argk.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
    }
    argj.a(this.jdField_a_of_type_Argk.jdField_a_of_type_Argj).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argl
 * JD-Core Version:    0.7.0.1
 */