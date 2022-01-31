import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import cooperation.comic.ipc.QQComicIPCModule;
import eipc.EIPCResult;
import org.json.JSONObject;

public class amjs
  extends VasQuickUpdateManager.CallBacker
{
  int jdField_a_of_type_Int;
  
  public amjs(QQComicIPCModule paramQQComicIPCModule, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramInt1 == 0) && (paramLong == 1000L) && ("vipComic_config_v2.json".equals(paramString1)))
    {
      paramString1 = VasQuickUpdateManager.a(BaseApplicationImpl.getApplication().getRuntime(), paramString1, false, null);
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("config_json", paramString1.toString());
        this.jdField_a_of_type_CooperationComicIpcQQComicIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramString2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjs
 * JD-Core Version:    0.7.0.1
 */