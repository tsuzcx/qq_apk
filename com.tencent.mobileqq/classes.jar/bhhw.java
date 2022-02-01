import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bhhw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bhhw(bhhv parambhhv) {}
  
  public void onGlobalLayout()
  {
    if (!bhhv.a(this.a)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      bhhv.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = bhhv.a(this.a) - ((Rect)localObject).height();
      bhhv.a(this.a, ((Rect)localObject).height());
      if (j > bhhv.b(this.a) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        bhhv.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (bhhv.a(this.a) != null) {
          bhhv.a(this.a).onShowed(j, false);
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhw
 * JD-Core Version:    0.7.0.1
 */