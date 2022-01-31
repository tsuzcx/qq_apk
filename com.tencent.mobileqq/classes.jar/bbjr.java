import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bbjr
{
  private static int c;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private bbjt jdField_a_of_type_Bbjt;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public bbjr(View paramView, int paramInt, bbjt parambbjt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bbjt = parambbjt;
    b();
  }
  
  public static int a(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = actn.a(210.0F, BaseApplicationImpl.getContext().getResources());
    }
    do
    {
      return i;
      if (c == 0) {
        c = b();
      }
      i = paramInt;
    } while (paramInt <= c);
    return c;
  }
  
  private static int b()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (bfxo.a(localBaseApplication)) {
      i = bfxo.a(localBaseApplication);
    }
    for (int i = (int)((localBaseApplication.getResources().getDisplayMetrics().heightPixels + i) * 0.4D);; i = (int)(localBaseApplication.getResources().getDisplayMetrics().heightPixels * 0.4D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoftKeyboardHeight", 2, new Object[] { "getMaxEmotionPanelHeight, max keyboard height:", Integer.valueOf(i) });
      }
      return i;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bbjs(this);
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
    int i;
    if (localSharedPreferences.contains("key_height"))
    {
      i = localSharedPreferences.getInt("key_height", 0);
      this.jdField_a_of_type_Bbjt.a(i, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoftKeyboardHeight", 2, new Object[] { "getSoftKeyboardHeight, keyboard height:", Integer.valueOf(i) });
      }
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      return i;
      i = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjr
 * JD-Core Version:    0.7.0.1
 */