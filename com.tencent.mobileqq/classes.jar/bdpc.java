import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import org.json.JSONObject;

class bdpc
  implements ComponentCallbacks2
{
  bdpc(bdoz parambdoz) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)this.a.a().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    bdnw.d("GameRuntime", "onLowMemory!!!!!! Meminfo:dalvikPss[" + arrayOfMemoryInfo[0].dalvikPss + "],nativePss[" + arrayOfMemoryInfo[0].nativePss + "],otherPss[" + arrayOfMemoryInfo[0].otherPss + "],total[" + arrayOfMemoryInfo[0].getTotalPss() + "]");
  }
  
  public void onTrimMemory(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("level", paramInt);
      if (this.a.a(1) != null) {
        this.a.a(1).a("onMemoryWarning", localJSONObject.toString(), -1);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpc
 * JD-Core Version:    0.7.0.1
 */