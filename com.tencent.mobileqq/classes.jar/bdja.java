import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bdja
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bdja(bdiz parambdiz) {}
  
  public void onGlobalLayout()
  {
    if (!bdiz.a(this.a)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      bdiz.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = bdiz.a(this.a) - ((Rect)localObject).height();
      bdiz.a(this.a, ((Rect)localObject).height());
      if (j > bdiz.b(this.a) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        bdiz.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (bdiz.a(this.a) != null) {
          bdiz.a(this.a).a(j, false);
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdja
 * JD-Core Version:    0.7.0.1
 */