import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.1;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.15.2;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amxm
  extends bkjp
{
  amxm(amxj paramamxj) {}
  
  public void a()
  {
    try
    {
      amxj.c(this.a, false);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", "ok");
      if (this.a.a != null) {
        this.a.a.b();
      }
      anhw.a().a(null);
      anhw.a().a();
      amxj.a(this.a).clear();
      amwn.a().callbackFromRequest(amxj.a(this.a), 0, "cs.audioRoom_exit.local", localJSONObject.toString());
      new Handler(Looper.getMainLooper()).postDelayed(new CmGameAvHandler.15.2(this), 1000L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onExitRoomComplete error=" + localException.toString());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      QLog.d("AVManager", 2, "on connect res=" + paramInt);
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("res", 0);
      amwn.a().callbackFromRequest(amxj.a(this.a), paramInt, "cs.audioRoom_init.local", paramString.toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    JSONObject localJSONObject1;
    ArrayList localArrayList;
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    amzc localamzc;
    int i;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("lState", amxj.a(this.a));
      localJSONObject1.put("eventId", paramInt);
      localArrayList = new ArrayList();
      localJSONArray1 = new JSONArray();
      localJSONArray2 = new JSONArray();
      amwn.a();
      localamzc = amwn.a(amxj.a(this.a));
      if (localamzc != null) {
        break label488;
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      JSONObject localJSONObject2;
      QLog.e("CmGameAvHandler", 2, "requestVideo error e=" + paramArrayOfString.toString());
      return;
    }
    if (i < paramArrayOfString.length)
    {
      localObject = localamzc.b(paramArrayOfString[i]);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localArrayList.add(Long.valueOf(Long.parseLong(paramArrayOfString[i])));
        localJSONArray2.put(paramArrayOfString[i]);
      }
      else
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("openId", localObject);
        localJSONArray1.put(localJSONObject2);
      }
    }
    else
    {
      if (localJSONArray1.length() > 0)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("openIds", localJSONArray1);
        ((JSONObject)localObject).put("eventId", paramInt);
        ((JSONObject)localObject).put("userInfo", localJSONArray1);
        amwn.a().callbackFromRequest(amxj.a(this.a), 0, "cs.audioRoom_update_userinfo.local", ((JSONObject)localObject).toString());
      }
      if (localArrayList.size() > 0)
      {
        localJSONObject1.put("identifierList", localJSONArray2.toString());
        if (localamzc != null) {
          localamzc.a(1, null, localArrayList, 8, amxj.a(this.a), false, localJSONObject1.toString(), "");
        }
      }
      if (!QLog.isColorLevel()) {
        break label500;
      }
      QLog.d("CmGameAvHandler", 2, "avroom updateUserInfo data=" + localJSONObject1.toString() + " eventId=" + paramInt);
      break label500;
      label359:
      if (paramInt < paramArrayOfString.length) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < amxj.a(this.a).size())
      {
        if (((String)amxj.a(this.a).get(i)).equals(paramArrayOfString[paramInt])) {
          i = 1;
        }
      }
      else
      {
        for (;;)
        {
          if (i == 0)
          {
            amxj.a(this.a).add(paramArrayOfString[paramInt]);
            break label510;
            if (amxj.a(this.a))
            {
              paramArrayOfString = (CmGameAppInterface)amwn.a();
              amxj.a(this.a, (String[])amxj.a(this.a).toArray(new String[amxj.a(this.a).size()]), paramArrayOfString.getCurrentAccountUin());
              return;
              i = 0;
            }
            else
            {
              label488:
              label500:
              do
              {
                return;
                i = 0;
                break;
                i += 1;
                break;
              } while (paramInt != 3);
              paramInt = 0;
              break;
            }
          }
        }
        label510:
        paramInt += 1;
        break label359;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", paramInt);
      amwn.a().callbackFromRequest(amxj.a(this.a), paramInt, "cs.audioRoom_set_mic.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onMicStateChange error=" + localException.toString());
    }
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public void b(int paramInt, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameAvHandler.15.1(this, paramInt));
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("res", paramInt);
      amwn.a().callbackFromRequest(amxj.a(this.a), paramInt, "cs.audioRoom_set_speaker.local", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameAvHandler", 2, "onSpeakerStateChange error=" + localException.toString());
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    try
    {
      amxj.c(this.a, false);
      paramString = new JSONObject();
      paramString.put("res", "ok");
      amwn.a().callbackFromRequest(amxj.a(this.a), 0, "cs.audioRoom_disconnect.local", paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameAvHandler", 2, "onDisconnectRoom error=" + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxm
 * JD-Core Version:    0.7.0.1
 */