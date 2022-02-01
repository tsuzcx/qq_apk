import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class ayhr
  extends ayht
{
  public ayfo a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    ayfo localayfo = new ayfo();
    if (paramPlusPanelAppInfo.getAppID() == 1104874204) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    localayfo.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localayfo.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getAppName();
    localayfo.e = paramPlusPanelAppInfo.actionType;
    localayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    if (localayfo.jdField_b_of_type_Int == 1107930043) {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localayfo.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getAppName() + amtj.a(2131707420));
      return localayfo;
      if (paramPlusPanelAppInfo.getAppID() == 101761547) {
        localayfo.jdField_a_of_type_Boolean = auzn.a(paramBaseChatPie.app, "listen_together_c2c_aio_red_dot_show", true, false);
      } else {
        localayfo.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (((HotChatManager)paramBaseChatPie.app.getManager(60)).c(paramBaseChatPie.sessionInfo.curFriendUin)) {
      a(paramBaseChatPie.sessionInfo.curType, 1200000000);
    }
    a(paramBaseChatPie.sessionInfo.curType, 1104864068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhr
 * JD-Core Version:    0.7.0.1
 */