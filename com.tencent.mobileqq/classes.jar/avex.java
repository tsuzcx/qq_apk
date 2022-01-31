import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class avex
  extends ajgf
{
  avex(avev paramavev) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    avev.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        avev.b(this.a, System.currentTimeMillis());
        avev.a(this.a).edit().putLong("k_update_time", avev.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (avev.a(this.a) != null)
    {
      Iterator localIterator = avev.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        avci localavci = (avci)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localavci.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avex
 * JD-Core Version:    0.7.0.1
 */