import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class asfz
  implements asmh
{
  asfz(asfu paramasfu) {}
  
  public void a(boolean paramBoolean, asgr paramasgr)
  {
    if (asfu.a(this.a) == null)
    {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc");
    }
    if (this.a.k())
    {
      ((asfs)asfu.a(this.a).a(127)).a(paramasgr);
      QLog.i("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc:" + paramBoolean);
      return;
    }
    QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT In extendfriend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfz
 * JD-Core Version:    0.7.0.1
 */