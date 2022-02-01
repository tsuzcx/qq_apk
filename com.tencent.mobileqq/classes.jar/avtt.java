import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class avtt
  implements avtm
{
  avtt(avtq paramavtq) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      avwt.a("total_transport_cost", null);
      avwt.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    avtq.a(this.a, paramInt2);
    avtq.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (avtq.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690472);
        str2 = i + "/" + avtq.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, avwu.a(avtq.a(this.a)) + "B/s" });
        i = avtf.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        avtq.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (avtq.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690474);
          str2 = i + "/" + avtq.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690474);
          str2 = i + "/" + avtq.b;
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
    avtq.a(this.a, paramLong);
    int j = avtq.b(this.a);
    int i = j;
    if (j != avtq.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (avtq.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690472);
      str2 = i + "/" + avtq.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, avwu.a(avtq.a(this.a)) + "B/S" });
      this.a.b(avtf.a().a(), str1);
      return;
      if (avtq.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690474);
        str2 = i + "/" + avtq.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690474);
        str2 = i + "/" + avtq.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    avwu.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    avwt.b();
    avwt.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtt
 * JD-Core Version:    0.7.0.1
 */