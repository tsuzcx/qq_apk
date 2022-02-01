import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class axgm
  implements axgf
{
  axgm(axgj paramaxgj) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      axjm.a("total_transport_cost", null);
      axjm.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    axgj.a(this.a, paramInt2);
    axgj.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (axgj.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690432);
        str2 = i + "/" + axgj.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, axjn.a(axgj.a(this.a)) + "B/s" });
        i = axfy.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        axgj.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (axgj.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690434);
          str2 = i + "/" + axgj.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690434);
          str2 = i + "/" + axgj.b;
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
    axgj.a(this.a, paramLong);
    int j = axgj.b(this.a);
    int i = j;
    if (j != axgj.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (axgj.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690432);
      str2 = i + "/" + axgj.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, axjn.a(axgj.a(this.a)) + "B/S" });
      this.a.b(axfy.a().a(), str1);
      return;
      if (axgj.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690434);
        str2 = i + "/" + axgj.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690434);
        str2 = i + "/" + axgj.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    axjn.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    axjm.b();
    axjm.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgm
 * JD-Core Version:    0.7.0.1
 */