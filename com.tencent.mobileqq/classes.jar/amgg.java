import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class amgg
  extends alpq
{
  amgg(amgf paramamgf) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    amgf.a(this.a, amgf.a(this.a, paramInt));
    if ((amgf.a(this.a)) && (amgf.a(this.a) != null)) {
      this.a.b(amgf.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgg
 * JD-Core Version:    0.7.0.1
 */