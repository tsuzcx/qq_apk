import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;

public abstract class ayht
  extends aygw
{
  public ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    ayfo localayfo = new ayfo();
    localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    localayfo.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.c = String.valueOf(localayfo.jdField_b_of_type_Int);
    localayfo.e = paramPlusPanelAppInfo.actionType;
    localayfo.d = paramPlusPanelAppInfo.action;
    localayfo.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localayfo.jdField_b_of_type_JavaLangString = (localayfo.jdField_a_of_type_JavaLangString + amtj.a(2131707412));
    localayfo.f = paramBaseChatPie.sessionInfo.troopUin;
    int i = paramPlusPanelAppInfo.getAppID();
    if ((i == 1104864062) || (i == 101761547) || (i == 101793773) || (i == 101817424)) {
      localayfo.jdField_a_of_type_Boolean = paramPlusPanelAppInfo.redPoint;
    }
    if (i == 1104874204) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    return localayfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayht
 * JD-Core Version:    0.7.0.1
 */