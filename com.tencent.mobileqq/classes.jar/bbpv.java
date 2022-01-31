import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class bbpv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bbpv(NavBarAIO paramNavBarAIO) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      NavBarAIO.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      int j = NavBarAIO.a(this.a).getMeasuredWidth();
      int i = j;
      if (j == 0)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)NavBarAIO.a(this.a).getLayoutParams();
        i = bajq.a();
        j = localLayoutParams.leftMargin;
        int k = localLayoutParams.rightMargin;
        if (QLog.isColorLevel()) {
          QLog.i("NavBarAIO", 2, "addOnGlobalLayoutListener leftMargin:" + localLayoutParams.leftMargin + " rightMargin:" + localLayoutParams.rightMargin + " screenWidth:" + bajq.a());
        }
        i = i - j - k;
      }
      this.a.b(i);
      return;
      NavBarAIO.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpv
 * JD-Core Version:    0.7.0.1
 */