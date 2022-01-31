import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aslh
  implements asla
{
  aslh(asle paramasle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      asof.a("total_transport_cost", null);
      asof.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    asle.a(this.a, paramInt2);
    asle.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (asle.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690390);
        str2 = i + "/" + asle.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, asog.a(asle.a(this.a)) + "B/s" });
        i = askt.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        asle.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (asle.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
          str2 = i + "/" + asle.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
          str2 = i + "/" + asle.b;
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
    asle.a(this.a, paramLong);
    int j = asle.b(this.a);
    int i = j;
    if (j != asle.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (asle.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690390);
      str2 = i + "/" + asle.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, asog.a(asle.a(this.a)) + "B/S" });
      this.a.b(askt.a().a(), str1);
      return;
      if (asle.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
        str2 = i + "/" + asle.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
        str2 = i + "/" + asle.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    asog.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    asof.b();
    asof.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aslh
 * JD-Core Version:    0.7.0.1
 */