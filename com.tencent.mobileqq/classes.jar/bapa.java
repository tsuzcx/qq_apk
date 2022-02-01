import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class bapa
  extends ampv
{
  bapa(baoy parambaoy) {}
  
  protected void onUpdateStatusActions(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    baoy.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        baoy.b(this.a, System.currentTimeMillis());
        baoy.a(this.a).edit().putLong("k_update_time", baoy.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (baoy.a(this.a) != null)
    {
      Iterator localIterator = baoy.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        bamm localbamm = (bamm)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localbamm.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapa
 * JD-Core Version:    0.7.0.1
 */