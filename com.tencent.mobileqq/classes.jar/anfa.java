import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class anfa
  implements amqq
{
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = StatisticCollector.getSqliteSwitchBySample(3);
    }
    for (;;)
    {
      try
      {
        QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
        if (paramBoolean) {
          continue;
        }
        FileUtils.deleteFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
        continue;
      }
      DeviceProfileManager.b(this);
      return;
      FileUtils.createFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anfa
 * JD-Core Version:    0.7.0.1
 */