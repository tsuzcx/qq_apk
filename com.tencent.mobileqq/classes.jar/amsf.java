import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public final class amsf
  extends AsyncTask
{
  public amsf(Intent paramIntent, int paramInt) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.a(BaseApplicationImpl.getApplication().getRuntime().getApplication()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentIntent);
      localIntent.putExtra("_inner_cmd_", this.jdField_a_of_type_Int);
      DingdongPluginProxyBroadcastReceiver.a(paramBoolean, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsf
 * JD-Core Version:    0.7.0.1
 */