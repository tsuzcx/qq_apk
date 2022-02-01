import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aslt
  implements assu
{
  aslt(aslo paramaslo) {}
  
  public void a(boolean paramBoolean, asmo paramasmo)
  {
    if (aslo.a(this.a) == null)
    {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc");
    }
    if (this.a.k())
    {
      ((aslm)aslo.a(this.a).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramasmo);
      QLog.i("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc:" + paramBoolean);
      return;
    }
    QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT In extendfriend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslt
 * JD-Core Version:    0.7.0.1
 */