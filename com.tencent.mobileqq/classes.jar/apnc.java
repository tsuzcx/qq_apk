import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class apnc
  extends ajuc
{
  apnc(apnb paramapnb) {}
  
  protected void a(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("ForwardTroopMemberControllerForMiniPie", 2, i);
      if ((apnb.a(this.a).equals(paramString)) && (apnb.a(this.a) != null))
      {
        apnb.a(this.a);
        apnb.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnc
 * JD-Core Version:    0.7.0.1
 */