import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class azfg
  extends AsyncTask<String, Integer, Boolean>
{
  azfg(azey paramazey) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (paramVarArgs == null) {
      paramVarArgs = Boolean.valueOf(false);
    }
    Object localObject;
    do
    {
      do
      {
        return paramVarArgs;
        localObject = new Bundle();
        ((Bundle)localObject).putString("VALUE_MSG_VIDEO_ID", paramVarArgs);
        paramVarArgs = azfj.a().a("CMD_QUERY_VIDEO_REDBAG_STAT", (Bundle)localObject);
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedBagVideoManager", 2, "QueryRewardedTask VideoPlayIPCClient.callServer value=null");
          }
          return Boolean.valueOf(false);
        }
        localObject = Boolean.valueOf(paramVarArgs.getBoolean("VALUE_MSG_REDBAG_STAT"));
        paramVarArgs = (String[])localObject;
      } while (!((Boolean)localObject).booleanValue());
      paramVarArgs = (String[])localObject;
    } while (azey.b(this.a) == null);
    azey.b(this.a).h = 1;
    return localObject;
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      azey.c(this.a);
    }
    while (azey.a(this.a)) {
      return;
    }
    azey.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfg
 * JD-Core Version:    0.7.0.1
 */