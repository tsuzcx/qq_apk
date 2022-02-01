import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public class bjcw
  implements Handler.Callback, bjcv
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  bjcx jdField_a_of_type_Bjcx = null;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 10;
  boolean jdField_b_of_type_Boolean = false;
  
  public bjcw(bjcx parambjcx, Context paramContext)
  {
    this.jdField_a_of_type_Bjcx = parambjcx;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  void a(int paramInt)
  {
    int i;
    if (paramInt != this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Bjcx != null) {
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
          break label47;
        }
      }
    }
    label47:
    for (View localView = null;; localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.jdField_a_of_type_Bjcx.a(localView, i, paramInt);
      return;
    }
  }
  
  void a(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (View localView = null;; localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (localView != paramView) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
      }
      return;
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
  }
  
  public void a(View paramView, int paramInt)
  {
    a(paramView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    a(2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    paramInt3 = Math.abs(paramInt2 - paramInt4);
    if ((paramInt3 == 0) || (paramInt2 == 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if ((paramInt1 == 0) || (this.jdField_b_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      a(0);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt3 <= this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
      }
      a(2);
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramInt3 <= this.jdField_b_of_type_Int)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
    }
    a(1);
  }
  
  public void b(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_Boolean = false;
      a(0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcw
 * JD-Core Version:    0.7.0.1
 */