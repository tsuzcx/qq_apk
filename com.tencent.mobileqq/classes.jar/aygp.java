import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class aygp
  extends aygw
{
  public ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    ayfo localayfo = new ayfo();
    if (paramPlusPanelAppInfo.getAppID() == 213) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    localayfo.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getAppName();
    localayfo.e = paramPlusPanelAppInfo.actionType;
    localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    if (localayfo.jdField_b_of_type_Int == 204) {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localayfo.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getAppName() + amtj.a(2131707420));
      return localayfo;
      if (localayfo.jdField_b_of_type_Int == 209) {
        localayfo.jdField_a_of_type_Boolean = agxo.a(paramBaseChatPie.app).b();
      } else if (paramPlusPanelAppInfo.getAppID() == 101761547) {
        localayfo.jdField_a_of_type_Boolean = auzn.a(paramBaseChatPie.app, "listen_together_c2c_aio_red_dot_show", true, false);
      } else {
        localayfo.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  protected void b(BaseChatPie paramBaseChatPie) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygp
 * JD-Core Version:    0.7.0.1
 */