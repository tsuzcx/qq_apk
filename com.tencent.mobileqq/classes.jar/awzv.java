import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class awzv
  implements awzo
{
  awzv(awzs paramawzs) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      axcv.a("total_transport_cost", null);
      axcv.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    awzs.a(this.a, paramInt2);
    awzs.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (awzs.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690547);
        str2 = i + "/" + awzs.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, axcw.a(awzs.a(this.a)) + "B/s" });
        i = awzh.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        awzs.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (awzs.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
          str2 = i + "/" + awzs.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
          str2 = i + "/" + awzs.b;
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
    awzs.a(this.a, paramLong);
    int j = awzs.b(this.a);
    int i = j;
    if (j != awzs.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (awzs.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690547);
      str2 = i + "/" + awzs.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, axcw.a(awzs.a(this.a)) + "B/S" });
      this.a.b(awzh.a().a(), str1);
      return;
      if (awzs.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
        str2 = i + "/" + awzs.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690549);
        str2 = i + "/" + awzs.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    axcw.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    axcv.b();
    axcv.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzv
 * JD-Core Version:    0.7.0.1
 */