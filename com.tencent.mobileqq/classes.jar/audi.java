import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1;
import com.tencent.widget.BubblePopupWindow;

public class audi
{
  public static int a;
  public static int b = 2;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  bblr jdField_a_of_type_Bblr;
  private bfps jdField_a_of_type_Bfps;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Bblr == null) {
      this.jdField_a_of_type_Bblr = new bblr();
    }
    this.jdField_a_of_type_Bblr.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, b, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(bbcc.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), this.jdField_a_of_type_Bblr, this.jdField_a_of_type_AndroidViewView$OnClickListener, true));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == jdField_a_of_type_Int) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localBubblePopupWindow.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bfps);
      paramView.post(new CommonMenuPopupView.1(this, paramView, paramInt1, paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audi
 * JD-Core Version:    0.7.0.1
 */