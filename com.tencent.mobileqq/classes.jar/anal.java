import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;
import com.tencent.qphone.base.util.QLog;

public class anal
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e = 2000;
  int f;
  int g;
  int h;
  int i;
  
  public anal(QzoneGameFloatView paramQzoneGameFloatView, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView) {
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = true;
      }
    }
    label204:
    do
    {
      return bool;
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.c.setVisibility(8);
      int j = (int)paramMotionEvent.getRawX();
      this.jdField_a_of_type_Int = j;
      this.c = j;
      j = (int)paramMotionEvent.getRawY();
      this.jdField_b_of_type_Int = j;
      this.d = j;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        break;
      }
      j = (int)paramMotionEvent.getRawX() - this.jdField_a_of_type_Int;
      int k = (int)paramMotionEvent.getRawY() - this.jdField_b_of_type_Int;
      this.e = (paramView.getLeft() + j);
      this.f = (paramView.getTop() + k);
      this.g = (j + paramView.getRight());
      this.h = (paramView.getBottom() + k);
      if (this.e < 0)
      {
        this.e = 0;
        this.g = (this.e + paramView.getWidth());
        if (this.f >= 0) {
          break label416;
        }
        this.f = 0;
        this.h = (this.f + paramView.getHeight());
      }
      for (;;)
      {
        paramView.layout(this.e, this.f, this.g, this.h);
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
        this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
        if ((this.jdField_a_of_type_Boolean) || ((Math.abs(paramMotionEvent.getRawX() - this.c) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.d) <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 5.0F))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i.setVisibility(8);
        this.jdField_a_of_type_Boolean = true;
        break;
        if (this.g <= this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int) {
          break label204;
        }
        this.g = this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int;
        this.e = (this.g - paramView.getWidth());
        break label204;
        if (this.h > this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_Int)
        {
          this.h = this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_Int;
          this.f = (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_Int - paramView.getHeight());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, true);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i.setVisibility(8);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, false);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i.setVisibility(0);
        j = paramView.getTop();
        k = paramView.getWidth() / 2;
        if (this.e + k < this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int / 2) {
          if (Build.VERSION.SDK_INT < 11) {}
        }
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.setRotationY(180.0F);
            paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = (k + this.e);
            paramView.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getPaddingBottom());
            if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
              break;
            }
            amwn.a(amwn.a(), amta.a(0, 0, 3, 901003001, this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
          }
          catch (Throwable paramView)
          {
            QLog.e("cmframe_QzoneGameFloatView", 1, "floatbtn.setrotationy error!", paramView);
            continue;
          }
          if (Build.VERSION.SDK_INT >= 11) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.setRotationY(0.0F);
            paramMotionEvent = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (k + (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int - paramView.getRight()));
            paramMotionEvent.topMargin = j;
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setLayoutParams(paramMotionEvent);
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setPadding((int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 20.0F), this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getPaddingTop(), (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 35.0F), this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.getPaddingBottom());
          }
          catch (Throwable paramMotionEvent)
          {
            for (;;)
            {
              QLog.e("cmframe_QzoneGameFloatView", 1, "floatbtn.setrotationy error!", paramMotionEvent);
            }
          }
        }
      }
      this.i = Math.min(this.e, this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int - this.g);
      if (this.i == this.e)
      {
        paramMotionEvent = new TranslateAnimation(0.0F, -this.e, 0.0F, 0.0F);
        this.e = 0;
        this.g = (this.e + paramView.getWidth());
      }
      for (;;)
      {
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new anam(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        break;
        paramMotionEvent = new TranslateAnimation(0.0F, this.i, 0.0F, 0.0F);
        this.g = this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_Int;
        this.e = (this.g - paramView.getWidth());
      }
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i.setVisibility(8);
        return true;
      }
    } while (paramView != this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i);
    label416:
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.setFloatBtnBackground(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView, true);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.i.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anal
 * JD-Core Version:    0.7.0.1
 */