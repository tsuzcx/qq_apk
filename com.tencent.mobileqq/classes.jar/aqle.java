import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aqle
  extends aqlq
{
  aqle(aqlc paramaqlc) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (aqlc.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
      }
    } while (!paramBoolean);
    aqlc.a(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, List<aqla> paramList)
  {
    if (aqlc.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
      }
    } while (!paramBoolean);
    paramList = aqlp.a(aqlc.a(this.a).app).a(Long.valueOf(paramLong));
    aqlc.a(this.a).a(paramList);
    this.a.h();
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((aqlc.b(this.a) == null) || (aqlc.c(this.a).sessionInfo == null) || (TextUtils.isEmpty(aqlc.d(this.a).sessionInfo.curFriendUin))) {}
    while ((!paramBoolean1) || (!aqlc.e(this.a).sessionInfo.curFriendUin.equals(paramString))) {
      return;
    }
    if (paramBoolean2)
    {
      this.a.h();
      aqlc.a(this.a);
      return;
    }
    this.a.i();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "onSetGlobalSwitcherStatus isSuccess = " + paramBoolean1 + ",isGlobalOpen = " + paramBoolean2);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */