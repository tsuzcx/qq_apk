import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atqg
  extends andd
{
  atqg(atqf paramatqf) {}
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("ForwardTroopMemberControllerForMiniPie", 2, i);
      if ((atqf.a(this.a).equals(paramString)) && (atqf.a(this.a) != null))
      {
        atqf.a(this.a);
        atqf.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqg
 * JD-Core Version:    0.7.0.1
 */