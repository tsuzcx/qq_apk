import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ayee
  extends alqh
{
  ayee(ayec paramayec) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    ayec.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        ayec.b(this.a, System.currentTimeMillis());
        ayec.a(this.a).edit().putLong("k_update_time", ayec.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (ayec.a(this.a) != null)
    {
      Iterator localIterator = ayec.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        aybp localaybp = (aybp)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localaybp.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayee
 * JD-Core Version:    0.7.0.1
 */