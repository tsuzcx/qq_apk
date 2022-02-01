import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bbdj
  extends aofu
{
  bbdj(bbdh parambbdh) {}
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (String.valueOf(l).equals(bbdh.a(this.a)))
        {
          QLog.i("IceBreak.HotPic", 1, " onGetTroopMemberCard last_active_time: " + paramObject.lastSpeak + " join_time: " + paramObject.joinTime);
          if (paramObject.lastSpeak > paramObject.joinTime) {
            return;
          }
          bbdh.a(this.a, String.valueOf(l));
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard:" + paramObject.toString());
      }
    }
  }
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null)
    {
      i = 0;
      QLog.i("IceBreak.HotPic", 2, i);
      if ((paramString != null) && (paramList != null) && (paramList.size() > 1)) {
        break label76;
      }
    }
    label76:
    while (!paramString.equals(bbdh.a(this.a)))
    {
      return;
      i = paramList.size();
      break;
    }
    localObject = (anvk)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str1 = this.a.a.getCurrentAccountUin();
    int k = paramList.size();
    int j = 0;
    int i = 0;
    label134:
    if (j < k)
    {
      String str2 = (String)((Pair)paramList.get(j)).first;
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1)) || (((anvk)localObject).b(str2))) {
        break label284;
      }
      i += 1;
    }
    label284:
    for (;;)
    {
      j += 1;
      break label134;
      float f = bbdh.a(this.a) / 100.0F;
      QLog.i("IceBreak.HotPic", 1, "friendCount: " + i + " total count: " + paramList.size());
      if (1.0F * i / (paramList.size() - 1) <= f) {
        break;
      }
      this.a.f(paramString);
      return;
    }
  }
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    this.a.g(paramString);
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2))) {
      this.a.g(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdj
 * JD-Core Version:    0.7.0.1
 */