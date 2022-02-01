import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class avas
  extends aojs
{
  avas(avar paramavar) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((avar.a(this.a).equals(paramString)) && (avar.a(this.a) != null))
      {
        this.a.e();
        avar.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avas
 * JD-Core Version:    0.7.0.1
 */