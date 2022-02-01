import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class auit
  extends anxg
{
  auit(auis paramauis) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((auis.a(this.a).equals(paramString)) && (auis.a(this.a) != null))
      {
        this.a.e();
        auis.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auit
 * JD-Core Version:    0.7.0.1
 */