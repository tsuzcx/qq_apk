import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bimk
  implements bimn
{
  public void a(boolean paramBoolean, Context paramContext, bimp parambimp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bimg.e(paramContext, parambimp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimk
 * JD-Core Version:    0.7.0.1
 */