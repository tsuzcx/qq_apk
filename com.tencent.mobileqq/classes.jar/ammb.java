import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class ammb
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public ammb(CmGameDebugView paramCmGameDebugView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == CmGameDebugView.a(this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView))
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.b = ((int)paramMotionEvent.getRawY());
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
        for (;;)
        {
          return true;
          this.c = this.jdField_a_of_type_Int;
          this.d = this.b;
        }
      case 2: 
        int i = this.jdField_a_of_type_Int - this.c;
        int j = this.b - this.d;
        this.e = (paramView.getLeft() + i);
        this.f = (paramView.getTop() + j);
        this.g = (i + paramView.getRight());
        this.h = (paramView.getBottom() + j);
        if (this.e < 0)
        {
          this.e = 0;
          this.g = (this.e + paramView.getWidth());
          label173:
          if (this.f >= 0) {
            break label355;
          }
          this.f = 0;
          this.h = (this.f + paramView.getHeight());
        }
        for (;;)
        {
          paramMotionEvent = (FrameLayout.LayoutParams)paramView.getLayoutParams();
          paramMotionEvent.setMargins(this.e, this.f, 0, 0);
          paramView.setLayoutParams(paramMotionEvent);
          if ((!this.jdField_a_of_type_Boolean) && ((Math.abs(this.jdField_a_of_type_Int - this.c) > CmGameDebugView.a(this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView).density * 2.0F) || (Math.abs(this.b - this.d) > CmGameDebugView.a(this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView).density * 2.0F))) {
            this.jdField_a_of_type_Boolean = true;
          }
          this.c = this.jdField_a_of_type_Int;
          this.d = this.b;
          break;
          if (this.g <= this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.jdField_a_of_type_Int) {
            break label173;
          }
          this.g = this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.jdField_a_of_type_Int;
          this.e = (this.g - paramView.getWidth());
          break label173;
          label355:
          if (this.h > this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.b)
          {
            this.h = this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.b;
            this.f = (this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.b - paramView.getHeight());
          }
        }
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (CmGameDebugView.a(this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView).getVisibility() == 0) {
          break label434;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.au_();
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        break;
        label434:
        this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammb
 * JD-Core Version:    0.7.0.1
 */