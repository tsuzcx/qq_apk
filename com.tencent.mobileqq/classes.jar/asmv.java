import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class asmv
  extends asnf
{
  asmv(asmu paramasmu) {}
  
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
        if ((paramObject.get(i) instanceof asmt))
        {
          localObject = (asmt)paramObject.get(i);
          localGameCenterSessionInfo = this.a.b(((asmt)localObject).jdField_b_of_type_JavaLangString);
          if (localGameCenterSessionInfo != null)
          {
            localGameCenterSessionInfo.f(((asmt)localObject).c);
            localGameCenterSessionInfo.g(((asmt)localObject).i);
            localGameCenterSessionInfo.i(((asmt)localObject).e);
            localGameCenterSessionInfo.d(((asmt)localObject).jdField_b_of_type_Int);
            localGameCenterSessionInfo.c(((asmt)localObject).k);
            localGameCenterSessionInfo.h(((asmt)localObject).d);
            localGameCenterSessionInfo.a(((asmt)localObject).j);
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
            localObject = this.a.c(localGameCenterSessionInfo.d());
            if (QLog.isColorLevel()) {
              QLog.d(asmu.c(), 2, "[onGameUserInfoChangedNotify] folder session:" + localObject);
            }
            if ((localObject != null) && (((GameCenterSessionInfo)localObject).c().equals(localGameCenterSessionInfo.c()))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmv
 * JD-Core Version:    0.7.0.1
 */