import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bfce
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bfce(bfcc parambfcc, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bfcc.a(this.jdField_a_of_type_Bfcc).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bfcc.b(this.jdField_a_of_type_Bfcc).setVisibility(4);
    bfcc.a(this.jdField_a_of_type_Bfcc, this.jdField_a_of_type_Boolean, bfcc.a(this.jdField_a_of_type_Bfcc), bfcc.c(this.jdField_a_of_type_Bfcc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfce
 * JD-Core Version:    0.7.0.1
 */