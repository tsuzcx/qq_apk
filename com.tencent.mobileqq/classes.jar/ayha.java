import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pluspanel.loader.c2c.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.List;

public class ayha
  extends aygp
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.sessionInfo;
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    bily localbily = (bily)localQQAppInterface.getManager(165);
    if (localbily.f(((SessionInfo)localObject).curFriendUin))
    {
      if (localbily.c(((SessionInfo)localObject).curFriendUin))
      {
        a(paramBaseChatPie.sessionInfo.curType, 201);
        a(paramBaseChatPie.sessionInfo.curType, 202);
      }
      a(paramBaseChatPie.sessionInfo.curType, 206);
      a(paramBaseChatPie.sessionInfo.curType, 205);
      return;
    }
    if (npt.a(localQQAppInterface, ((SessionInfo)localObject).curFriendUin, ((SessionInfo)localObject).curType)) {
      a(paramBaseChatPie.sessionInfo.curType, 201);
    }
    a(paramBaseChatPie.sessionInfo.curType, 217);
    a(paramBaseChatPie.sessionInfo.curType, 218);
    if (((SessionInfo)localObject).curType == 1008)
    {
      localObject = ((amxz)localQQAppInterface.getManager(56)).b(((SessionInfo)localObject).curFriendUin);
      if ((localObject != null) && ((((PublicAccountInfo)localObject).accountFlag & 0x20000000) != 0) && (ShortVideoUtils.sSupportShortVideo) && (VideoEnvironment.supportShortVideoRecordAndPlay(localQQAppInterface))) {
        a(paramBaseChatPie.sessionInfo.curType, 1104788673);
      }
      if ((localObject != null) && ((((PublicAccountInfo)localObject).accountFlag & 0x10000000) != 0)) {
        this.a.add(0, C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(1000000005));
      }
    }
    a(paramBaseChatPie.sessionInfo.curType, 205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayha
 * JD-Core Version:    0.7.0.1
 */