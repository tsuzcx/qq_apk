import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mobileqq.utils.DialogUtil.1.1;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class bhdk
  extends QQCustomDialog
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private int b = this.jdField_a_of_type_Int;
  
  bhdk(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramInt1);
  }
  
  private Runnable a()
  {
    return new DialogUtil.1.1(this);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.b > 0)
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.b) }));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, 1000L);
      return;
    }
    this.lBtn.setText(this.jdField_a_of_type_JavaLangString);
    this.b = this.jdField_a_of_type_Int;
    this.lBtn.setEnabled(true);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onBackPressed() {}
  
  public void show()
  {
    super.show();
    if ((this.jdField_a_of_type_Boolean) && (this.b > 0))
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.b) }));
      this.lBtn.setEnabled(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(a(), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhdk
 * JD-Core Version:    0.7.0.1
 */