package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceChangeData
{
  public static String a = "VoiceChangeData";
  private static VoiceChangeData c;
  private boolean b = false;
  private VoiceChangeData.VoiceInfo[] d = null;
  private Object e = new Object();
  private final int f = 40;
  
  public static VoiceChangeData a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new VoiceChangeData();
        }
      }
      finally {}
    }
    return c;
  }
  
  protected void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.e)
    {
      this.d = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject3;
        Object localObject4;
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          localObject3 = a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("parseConfig|voices size= ");
          ((StringBuilder)localObject4).append(((JSONArray)localObject2).length());
          AVLog.printAllUserLog((String)localObject3, ((StringBuilder)localObject4).toString());
          this.d = new VoiceChangeData.VoiceInfo[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject4 = new VoiceChangeData.VoiceInfo();
            ((VoiceChangeData.VoiceInfo)localObject4).a = ((JSONObject)localObject3).getString("name");
            ((VoiceChangeData.VoiceInfo)localObject4).b = ((JSONObject)localObject3).getString("icon1");
            ((VoiceChangeData.VoiceInfo)localObject4).c = ((JSONObject)localObject3).getString("icon2");
            ((VoiceChangeData.VoiceInfo)localObject4).d = Integer.parseInt(((JSONObject)localObject3).getString("type"));
            ((VoiceChangeData.VoiceInfo)localObject4).e = Integer.parseInt(((JSONObject)localObject3).getString("vip_level"));
            this.d[i] = localObject4;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        localObject3 = a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parseConfig, JSONException, \ncontent[");
        ((StringBuilder)localObject4).append(paramString);
        ((StringBuilder)localObject4).append("]");
        QLog.w((String)localObject3, 1, ((StringBuilder)localObject4).toString(), localJSONException);
        this.d = null;
        return;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public VoiceChangeData.VoiceInfo[] b()
  {
    if (this.d == null) {
      a(QAVConfig.b(172).b);
    }
    if ((this.d == null) && (!this.b))
    {
      VoiceChangeDataReport.a("0X8007EFD", "");
      this.b = true;
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData
 * JD-Core Version:    0.7.0.1
 */