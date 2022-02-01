import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class aolp
  implements anwh
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = bdmc.a(3);
    }
    for (;;)
    {
      try
      {
        QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
        if (paramBoolean) {
          continue;
        }
        bhmi.d(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
        continue;
      }
      DeviceProfileManager.b(this);
      return;
      bhmi.a(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolp
 * JD-Core Version:    0.7.0.1
 */