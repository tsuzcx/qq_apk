import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.studyroom.utils.PluginUtils.1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class bdxc
{
  public static Future<?> a(Context paramContext, Bundle paramBundle, boolean paramBoolean, bdxd parambdxd)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBundle.putString("qqVersion", "8.4.10");
    paramBundle.putString("bizType", "StudyRoom");
    paramBundle.putString("plugin_id", "StudyRoom");
    paramBundle.putString("appid", "101854111");
    paramBundle.putInt("authtype", 1);
    paramBundle.putInt("isGroupCode", 1);
    paramBundle.putInt("roomCodeType", 1);
    paramBundle.putString("uin", localQQAppInterface.getCurrentUin());
    paramBundle.putBoolean("preload", paramBoolean);
    paramBundle.putString("fromId", "1");
    paramBundle.putLong("ts_click_millisecond", System.currentTimeMillis());
    paramBundle.putBoolean("show_status_bar", true);
    return ThreadManagerExecutor.getExecutorService(192).submit(new PluginUtils.1(paramContext, paramBundle, parambdxd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxc
 * JD-Core Version:    0.7.0.1
 */