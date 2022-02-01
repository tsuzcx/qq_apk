import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class apia
  extends apim
{
  apia(aphy paramaphy) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (aphy.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
      }
    } while (!paramBoolean);
    aphy.a(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, List<aphw> paramList)
  {
    if (aphy.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
      }
    } while (!paramBoolean);
    paramList = apil.a(aphy.a(this.a).app).a(Long.valueOf(paramLong));
    aphy.a(this.a).a(paramList);
    this.a.g();
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((aphy.b(this.a) == null) || (aphy.c(this.a).sessionInfo == null) || (TextUtils.isEmpty(aphy.d(this.a).sessionInfo.curFriendUin))) {}
    while ((!paramBoolean1) || (!aphy.e(this.a).sessionInfo.curFriendUin.equals(paramString))) {
      return;
    }
    if (paramBoolean2)
    {
      this.a.g();
      aphy.a(this.a);
      return;
    }
    this.a.h();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "onSetGlobalSwitcherStatus isSuccess = " + paramBoolean1 + ",isGlobalOpen = " + paramBoolean2);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apia
 * JD-Core Version:    0.7.0.1
 */