import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aqec
  extends akil
{
  aqec(aqeb paramaqeb) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((aqeb.a(this.a).equals(paramString)) && (aqeb.a(this.a) != null))
      {
        this.a.e();
        aqeb.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqec
 * JD-Core Version:    0.7.0.1
 */