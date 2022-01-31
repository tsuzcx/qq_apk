import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

public class bafg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static int a;
  public static boolean a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bafh jdField_a_of_type_Bafh;
  private int b = 1;
  private int c;
  
  public bafg(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    int i = paramActivity.getHeight();
    if (a(paramActivity) > i * 3 / 4) {
      return 2;
    }
    return 1;
  }
  
  public static int a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public static void a(Activity paramActivity)
  {
    jdField_a_of_type_Int = a(paramActivity.getWindow().getDecorView());
    jdField_a_of_type_Boolean = a(paramActivity);
  }
  
  public static boolean a(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanelStatus", 2, "onGlobalLayout, top=" + localRect.top + " bottom=" + localRect.bottom);
    }
    return localRect.top == 0;
  }
  
  @RequiresApi(api=16)
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      this.b = 1;
      this.jdField_a_of_type_Bafh = null;
      this.c = 0;
      return;
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bafh parambafh)
  {
    if (parambafh != null) {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    this.b = 1;
    this.jdField_a_of_type_Bafh = parambafh;
    this.c = 0;
  }
  
  public void onGlobalLayout()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    if (localView == null) {}
    int i;
    int j;
    int k;
    do
    {
      return;
      i = localView.getHeight();
      j = a(localView);
      k = i - j;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        int m = this.jdField_a_of_type_AndroidViewView.getHeight();
        if ((m != this.c) && (this.jdField_a_of_type_Bafh != null)) {
          this.jdField_a_of_type_Bafh.b(this.b, j, this.c);
        }
        this.c = m;
      }
    } while (j == this.c);
    if (k > i / 4)
    {
      this.b = 1;
      if (this.jdField_a_of_type_Bafh != null) {
        this.jdField_a_of_type_Bafh.a(this.b, j, k);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AtPanelStatus", 2, "onGlobalLayout, screenHeight=" + i + " visibleHeight=" + j + " differHeight=" + k + " mode=" + this.b);
      }
      this.c = j;
      return;
      if (k < i * 3 / 4)
      {
        this.b = 2;
        if (this.jdField_a_of_type_Bafh != null) {
          this.jdField_a_of_type_Bafh.a(this.b, j, k);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafg
 * JD-Core Version:    0.7.0.1
 */