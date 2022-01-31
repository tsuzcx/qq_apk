import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bail
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bail(baik parambaik) {}
  
  public void onGlobalLayout()
  {
    if (!baik.a(this.a)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      baik.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = baik.a(this.a) - ((Rect)localObject).height();
      baik.a(this.a, ((Rect)localObject).height());
      if (j > baik.b(this.a) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        baik.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (baik.a(this.a) != null) {
          baik.a(this.a).a(j, false);
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bail
 * JD-Core Version:    0.7.0.1
 */