import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class axzv
  extends alls
{
  axzv(axzt paramaxzt) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    axzt.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        axzt.b(this.a, System.currentTimeMillis());
        axzt.a(this.a).edit().putLong("k_update_time", axzt.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (axzt.a(this.a) != null)
    {
      Iterator localIterator = axzt.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        axxg localaxxg = (axxg)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localaxxg.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzv
 * JD-Core Version:    0.7.0.1
 */