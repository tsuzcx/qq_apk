import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aslj
  implements aslc
{
  aslj(aslg paramaslg) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      asoh.a("total_transport_cost", null);
      asoh.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    aslg.a(this.a, paramInt2);
    aslg.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (aslg.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690390);
        str2 = i + "/" + aslg.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, asoi.a(aslg.a(this.a)) + "B/s" });
        i = askv.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        aslg.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (aslg.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
          str2 = i + "/" + aslg.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
          str2 = i + "/" + aslg.b;
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
    aslg.a(this.a, paramLong);
    int j = aslg.b(this.a);
    int i = j;
    if (j != aslg.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (aslg.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690390);
      str2 = i + "/" + aslg.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, asoi.a(aslg.a(this.a)) + "B/S" });
      this.a.b(askv.a().a(), str1);
      return;
      if (aslg.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
        str2 = i + "/" + aslg.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690392);
        str2 = i + "/" + aslg.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    asoi.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    asoh.b();
    asoh.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aslj
 * JD-Core Version:    0.7.0.1
 */