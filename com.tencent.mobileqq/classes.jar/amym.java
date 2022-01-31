import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class amym
  extends amzt
{
  amym(amyk paramamyk) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadSuccess ");
    }
    if (amyk.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadSuccess error mHandler is null ");
      return;
    }
    amyk.a(this.a).sendMessage(amyk.a(this.a).obtainMessage(3));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadError|error= " + paramInt);
    }
    if (amyk.a(this.a) == null)
    {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadError error mHandler is null ");
      return;
    }
    amyk.a(this.a).sendMessage(amyk.a(this.a).obtainMessage(5, Integer.valueOf(paramInt)));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L)
    {
      long l = 100L * paramLong1 / paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "onDownloadProcess percent= " + l);
      }
      if (amyk.a(this.a) == null) {
        QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onDownloadProcess error mHandler is null ");
      }
    }
    else
    {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.arg1 = ((int)paramLong1);
    localMessage.arg2 = ((int)paramLong2);
    amyk.a(this.a).sendMessage(localMessage);
  }
  
  public void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onConfigChanged!");
    }
    if (amyk.a(this.a) == null) {
      QLog.d("ArConfig_RemoteArConfigManager", 1, "mArCallback onConfigChanged error mHandler is null ");
    }
    do
    {
      return;
      if (paramArConfigInfo != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = paramArConfigInfo;
        amyk.a(this.a).sendMessage(localMessage);
      }
      if (paramArEffectConfig != null)
      {
        paramArConfigInfo = Message.obtain();
        paramArConfigInfo.what = 2;
        paramArConfigInfo.obj = paramArEffectConfig;
        amyk.a(this.a).sendMessage(paramArConfigInfo);
      }
    } while (paramARCommonConfigInfo == null);
    paramArConfigInfo = Message.obtain();
    paramArConfigInfo.what = 9;
    paramArConfigInfo.obj = paramARCommonConfigInfo;
    amyk.a(this.a).sendMessage(paramArConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amym
 * JD-Core Version:    0.7.0.1
 */