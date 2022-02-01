import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class bgfv
  implements bggb
{
  bgfv(bgfu parambgfu) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadStart");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadProgress and percent is " + paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadReady");
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).edit().putString("resPath", paramString).commit();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 1, "onResDownloadFailed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfv
 * JD-Core Version:    0.7.0.1
 */