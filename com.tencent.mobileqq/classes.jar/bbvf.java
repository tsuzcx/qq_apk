import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class bbvf
  extends anvn
{
  bbvf(bbvd parambbvd) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    bbvd.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        bbvd.b(this.a, System.currentTimeMillis());
        bbvd.a(this.a).edit().putLong("k_update_time", bbvd.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (bbvd.a(this.a) != null)
    {
      Iterator localIterator = bbvd.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        bbsr localbbsr = (bbsr)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localbbsr.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvf
 * JD-Core Version:    0.7.0.1
 */