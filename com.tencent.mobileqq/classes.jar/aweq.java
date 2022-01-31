import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class aweq
  extends ajuh
{
  aweq(aweo paramaweo) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    aweo.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        aweo.b(this.a, System.currentTimeMillis());
        aweo.a(this.a).edit().putLong("k_update_time", aweo.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (aweo.a(this.a) != null)
    {
      Iterator localIterator = aweo.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        awcb localawcb = (awcb)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localawcb.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aweq
 * JD-Core Version:    0.7.0.1
 */