import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class avdt
  extends aved
{
  avdt(avds paramavds) {}
  
  protected void b(Object paramObject)
  {
    super.b(paramObject);
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      int j = paramObject.size();
      int i = 0;
      if (i < j)
      {
        Object localObject;
        GameCenterSessionInfo localGameCenterSessionInfo;
        if ((paramObject.get(i) instanceof avdr))
        {
          localObject = (avdr)paramObject.get(i);
          localGameCenterSessionInfo = this.a.b(((avdr)localObject).jdField_b_of_type_JavaLangString);
          if (localGameCenterSessionInfo != null)
          {
            localGameCenterSessionInfo.f(((avdr)localObject).c);
            localGameCenterSessionInfo.g(((avdr)localObject).i);
            localGameCenterSessionInfo.i(((avdr)localObject).e);
            localGameCenterSessionInfo.e(((avdr)localObject).jdField_b_of_type_Int);
            localGameCenterSessionInfo.c(((avdr)localObject).k);
            localGameCenterSessionInfo.h(((avdr)localObject).d);
            localGameCenterSessionInfo.a(((avdr)localObject).j);
            if (j <= 30) {
              break label178;
            }
            if (i == j - 1) {
              this.a.a("action_qgame_messgae_change", localGameCenterSessionInfo, 3, this.a.a());
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          if (localGameCenterSessionInfo.a() == 0)
          {
            localObject = this.a.c(localGameCenterSessionInfo.e());
            if (QLog.isColorLevel()) {
              QLog.d(avds.e(), 2, "[onGameUserInfoChangedNotify] folder session:" + localObject);
            }
            if ((localObject != null) && (((GameCenterSessionInfo)localObject).d().equals(localGameCenterSessionInfo.d()))) {
              this.a.a("action_qgame_messgae_change", (GameCenterSessionInfo)localObject, 2, this.a.a());
            }
          }
          else
          {
            this.a.a("action_qgame_messgae_change", localGameCenterSessionInfo, 2, this.a.a());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdt
 * JD-Core Version:    0.7.0.1
 */