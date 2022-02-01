import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class bbvp
  extends ansi
{
  bbvp(bbvn parambbvn) {}
  
  protected void onUpdateStatusActions(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    bbvn.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        bbvn.b(this.a, System.currentTimeMillis());
        bbvn.a(this.a).edit().putLong("k_update_time", bbvn.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (bbvn.a(this.a) != null)
    {
      Iterator localIterator = bbvn.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        bbtb localbbtb = (bbtb)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localbbtb.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvp
 * JD-Core Version:    0.7.0.1
 */