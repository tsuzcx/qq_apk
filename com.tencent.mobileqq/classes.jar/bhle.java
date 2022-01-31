import android.os.Bundle;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class bhle
  implements InvocationHandler
{
  public bhle(bhky parambhky) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePlayerJSAdapter", "InnerTXLivePlayListenerImpl invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    for (;;)
    {
      return null;
      if ("onPlayEvent".equals(paramMethod.getName()))
      {
        if (paramArrayOfObject.length == 2)
        {
          paramMethod = (Integer)paramArrayOfObject[0];
          paramArrayOfObject = (Bundle)paramArrayOfObject[1];
          if ((paramMethod.equals(Integer.valueOf(2006))) || (paramMethod.equals(Integer.valueOf(-2301)))) {
            this.a.a("stop", null);
          }
          if ((paramMethod.intValue() == 2012) && (paramArrayOfObject != null))
          {
            paramObject = paramArrayOfObject.getByteArray("EVT_GET_MSG");
            if ((paramObject == null) || (paramObject.length <= 0)) {
              break label261;
            }
          }
          for (;;)
          {
            try
            {
              paramObject = new String(paramObject, "UTF-8");
              paramArrayOfObject.putString("EVT_MSG", paramObject);
              if ((bhky.a(this.a)) && (bhky.a(this.a) != null)) {
                bhky.a(this.a).a(paramMethod.intValue(), paramArrayOfObject);
              }
              if (paramArrayOfObject == null) {
                break;
              }
              paramObject = paramArrayOfObject.getString("EVT_MSG");
              QMLog.d("TXLivePlayerJSAdapter", "onPlayEvent: event = " + paramMethod + " message = " + paramObject);
            }
            catch (UnsupportedEncodingException paramObject)
            {
              paramObject.printStackTrace();
            }
            label261:
            paramObject = "";
          }
        }
      }
      else if (("onNetStatus".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1))
      {
        paramObject = (Bundle)paramArrayOfObject[0];
        if (bhky.a(this.a) != null) {
          bhky.a(this.a).a(paramObject);
        }
        if (QMLog.isColorLevel())
        {
          paramObject = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramObject.getString("CPU_USAGE"), "RES:" + paramObject.getInt("VIDEO_WIDTH") + "*" + paramObject.getInt("VIDEO_HEIGHT"), "SPD:" + paramObject.getInt("NET_SPEED") + "Kbps", "JIT:" + paramObject.getInt("NET_JITTER"), "FPS:" + paramObject.getInt("VIDEO_FPS"), "GOP:" + paramObject.getInt("VIDEO_GOP") + "s", "ARA:" + paramObject.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramObject.getInt("AUDIO_CACHE") + " | " + paramObject.getInt("VIDEO_CACHE") + "," + paramObject.getInt("V_SUM_CACHE_SIZE") + "," + paramObject.getInt("V_DEC_CACHE_SIZE") + " | " + paramObject.getInt("AV_RECV_INTERVAL") + "," + paramObject.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramObject.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramObject.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramObject.getInt("AUDIO_DROP") + "|" + paramObject.getInt("VIDEO_DROP"), "SVR:" + paramObject.getString("SERVER_IP"), "AUDIO:" + paramObject.getString("AUDIO_PLAY_INFO") });
          QMLog.d("TXLivePlayerJSAdapter", "onNetStatus:" + paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhle
 * JD-Core Version:    0.7.0.1
 */