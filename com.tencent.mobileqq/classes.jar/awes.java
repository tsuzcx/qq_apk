import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class awes
  extends ajuf
{
  awes(aweq paramaweq) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    aweq.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        aweq.b(this.a, System.currentTimeMillis());
        aweq.a(this.a).edit().putLong("k_update_time", aweq.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (aweq.a(this.a) != null)
    {
      Iterator localIterator = aweq.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        awcd localawcd = (awcd)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localawcd.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awes
 * JD-Core Version:    0.7.0.1
 */