import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class augr
  implements augk
{
  augr(augo paramaugo) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      aujp.a("total_transport_cost", null);
      aujp.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    augo.a(this.a, paramInt2);
    augo.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (augo.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690441);
        str2 = i + "/" + augo.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, aujq.a(augo.a(this.a)) + "B/s" });
        i = augd.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        augo.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (augo.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
          str2 = i + "/" + augo.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
          str2 = i + "/" + augo.b;
        }
      }
      this.a.b(i, str1);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "speedState!!! increment = " + paramLong);
    }
    augo.a(this.a, paramLong);
    int j = augo.b(this.a);
    int i = j;
    if (j != augo.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (augo.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690441);
      str2 = i + "/" + augo.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, aujq.a(augo.a(this.a)) + "B/S" });
      this.a.b(augd.a().a(), str1);
      return;
      if (augo.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
        str2 = i + "/" + augo.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
        str2 = i + "/" + augo.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    aujq.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    aujp.b();
    aujp.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     augr
 * JD-Core Version:    0.7.0.1
 */