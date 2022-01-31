import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class arpd
  implements arow
{
  arpd(arpa paramarpa) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      arsb.a("total_transport_cost", null);
      arsb.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    arpa.a(this.a, paramInt2);
    arpa.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (arpa.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624829);
        str2 = i + "/" + arpa.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, arsc.a(arpa.a(this.a)) + "B/s" });
        i = arop.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        arpa.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (arpa.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624831);
          str2 = i + "/" + arpa.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624831);
          str2 = i + "/" + arpa.b;
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
    arpa.a(this.a, paramLong);
    int j = arpa.b(this.a);
    int i = j;
    if (j != arpa.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (arpa.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624829);
      str2 = i + "/" + arpa.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, arsc.a(arpa.a(this.a)) + "B/S" });
      this.a.b(arop.a().a(), str1);
      return;
      if (arpa.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624831);
        str2 = i + "/" + arpa.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131624831);
        str2 = i + "/" + arpa.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    arsc.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    arsb.b();
    arsb.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpd
 * JD-Core Version:    0.7.0.1
 */