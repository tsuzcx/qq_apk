import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bhsn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bhsn(bhsm parambhsm) {}
  
  public void onGlobalLayout()
  {
    if (!bhsm.a(this.a)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      bhsm.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = bhsm.a(this.a) - ((Rect)localObject).height();
      bhsm.a(this.a, ((Rect)localObject).height());
      if (j > bhsm.b(this.a) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        bhsm.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (bhsm.a(this.a) != null) {
          bhsm.a(this.a).a(j, false);
        }
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsn
 * JD-Core Version:    0.7.0.1
 */