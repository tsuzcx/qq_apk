import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aute
  extends auto
{
  aute(autd paramautd) {}
  
  protected void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      int j = paramObject.size();
      int i = 0;
      if (i < j)
      {
        Object localObject;
        GameCenterSessionInfo localGameCenterSessionInfo;
        if ((paramObject.get(i) instanceof autc))
        {
          localObject = (autc)paramObject.get(i);
          localGameCenterSessionInfo = this.a.b(((autc)localObject).jdField_b_of_type_JavaLangString);
          if (localGameCenterSessionInfo != null)
          {
            localGameCenterSessionInfo.f(((autc)localObject).c);
            localGameCenterSessionInfo.g(((autc)localObject).i);
            localGameCenterSessionInfo.i(((autc)localObject).e);
            localGameCenterSessionInfo.d(((autc)localObject).jdField_b_of_type_Int);
            localGameCenterSessionInfo.c(((autc)localObject).k);
            localGameCenterSessionInfo.h(((autc)localObject).d);
            localGameCenterSessionInfo.a(((autc)localObject).j);
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
              QLog.d(autd.e(), 2, "[onGameUserInfoChangedNotify] folder session:" + localObject);
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
 * Qualified Name:     aute
 * JD-Core Version:    0.7.0.1
 */