import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class auci
  implements aucb
{
  auci(aucf paramaucf) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      aufg.a("total_transport_cost", null);
      aufg.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    aucf.a(this.a, paramInt2);
    aucf.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (aucf.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690441);
        str2 = i + "/" + aucf.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, aufh.a(aucf.a(this.a)) + "B/s" });
        i = aubu.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        aucf.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (aucf.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
          str2 = i + "/" + aucf.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
          str2 = i + "/" + aucf.b;
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
    aucf.a(this.a, paramLong);
    int j = aucf.b(this.a);
    int i = j;
    if (j != aucf.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (aucf.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690441);
      str2 = i + "/" + aucf.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, aufh.a(aucf.a(this.a)) + "B/S" });
      this.a.b(aubu.a().a(), str1);
      return;
      if (aucf.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
        str2 = i + "/" + aucf.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690443);
        str2 = i + "/" + aucf.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    aufh.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    aufg.b();
    aufg.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auci
 * JD-Core Version:    0.7.0.1
 */