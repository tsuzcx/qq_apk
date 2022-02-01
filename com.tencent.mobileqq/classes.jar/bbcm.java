import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class bbcm
  extends anjq
{
  bbcm(bbck parambbck) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    bbck.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        bbck.b(this.a, System.currentTimeMillis());
        bbck.a(this.a).edit().putLong("k_update_time", bbck.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (bbck.a(this.a) != null)
    {
      Iterator localIterator = bbck.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        bazy localbazy = (bazy)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localbazy.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcm
 * JD-Core Version:    0.7.0.1
 */