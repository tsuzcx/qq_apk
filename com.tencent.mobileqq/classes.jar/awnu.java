import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class awnu
  implements awnn
{
  awnu(awnr paramawnr) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      awqt.a("total_transport_cost", null);
      awqt.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    awnr.a(this.a, paramInt2);
    awnr.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (awnr.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690437);
        str2 = i + "/" + awnr.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, awqu.a(awnr.a(this.a)) + "B/s" });
        i = awng.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        awnr.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (awnr.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690439);
          str2 = i + "/" + awnr.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690439);
          str2 = i + "/" + awnr.b;
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
    awnr.a(this.a, paramLong);
    int j = awnr.b(this.a);
    int i = j;
    if (j != awnr.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (awnr.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690437);
      str2 = i + "/" + awnr.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, awqu.a(awnr.a(this.a)) + "B/S" });
      this.a.b(awng.a().a(), str1);
      return;
      if (awnr.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690439);
        str2 = i + "/" + awnr.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690439);
        str2 = i + "/" + awnr.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    awqu.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    awqt.b();
    awqt.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnu
 * JD-Core Version:    0.7.0.1
 */