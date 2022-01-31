import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class arxk
  extends amab
{
  arxk(arxj paramarxj) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((arxj.a(this.a).equals(paramString)) && (arxj.a(this.a) != null))
      {
        this.a.e();
        arxj.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxk
 * JD-Core Version:    0.7.0.1
 */