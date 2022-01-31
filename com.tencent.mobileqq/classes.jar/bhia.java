import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.receiver.WebProcessReceiver;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class bhia
  implements TbsListener
{
  public bhia(WebProcessReceiver paramWebProcessReceiver, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void onDownloadFinish(int paramInt)
  {
    QMLog.d("TBS_update", "tbs download finish result=" + paramInt);
    if ((paramInt != 100) && (paramInt != 120) && (paramInt != 122))
    {
      if (WebProcessReceiver.a.compareAndSet(true, false))
      {
        QbSdk.setTbsListener(null);
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
        long l2 = System.currentTimeMillis();
        long l3 = this.jdField_a_of_type_Long;
        localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt("tbs_download_count", i + 1);
        localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
        localEditor.commit();
        if (QMLog.isColorLevel()) {
          QMLog.d("TBS_update", "tbs download aborted:" + paramInt);
        }
      }
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_complete", paramInt);
      localEditor.remove("tbs_downloading");
      localEditor.remove("tbs_download_progress");
      localEditor.commit();
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TBS_update", "tbs download progress " + paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    QMLog.d("TBS_update", "tbs download install finish result=" + paramInt);
    if (paramInt == 200) {}
    while (!WebProcessReceiver.a.compareAndSet(true, false)) {
      return;
    }
    QbSdk.setTbsListener(null);
    long l1;
    SharedPreferences.Editor localEditor;
    if ((paramInt != 232) && (paramInt != 220))
    {
      int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      long l2 = System.currentTimeMillis();
      long l3 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_count", i + 1);
      localEditor.putLong("tbs_download_cost", l1 + (l2 - l3));
      localEditor.commit();
      QMLog.d("TBS_update", "tbs install error:" + paramInt);
    }
    for (;;)
    {
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putInt("tbs_download_complete", paramInt);
      localEditor.remove("tbs_downloading");
      localEditor.remove("tbs_download_progress");
      localEditor.commit();
      return;
      this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("tbs_download_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("tbs_download_cost", 0L);
      System.currentTimeMillis();
      l1 = this.jdField_a_of_type_Long;
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.remove("tbs_download_count");
      localEditor.remove("tbs_download_cost");
      localEditor.commit();
      QMLog.d("TBS_update", "tbs install finished:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhia
 * JD-Core Version:    0.7.0.1
 */