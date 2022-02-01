import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atnw
  extends andd
{
  atnw(atnv paramatnv) {}
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((atnv.a(this.a).equals(paramString)) && (atnv.a(this.a) != null))
      {
        this.a.e();
        atnv.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnw
 * JD-Core Version:    0.7.0.1
 */