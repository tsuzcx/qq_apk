import android.content.Context;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import org.json.JSONObject;

public class bdov
  implements GameLifecycle
{
  public static boolean a;
  private bdcz a;
  
  bdov(bdcz parambdcz)
  {
    this.jdField_a_of_type_Bdcz = parambdcz;
  }
  
  public int a()
  {
    return bdqa.a().a();
  }
  
  public String a()
  {
    return bdqa.a().e();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject2 = bdqa.a().a();
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null) {
      localJSONObject1 = new JSONObject();
    }
    return localJSONObject1;
  }
  
  public void a()
  {
    localJSONObject4 = new JSONObject();
    localJSONObject3 = a();
    i = a();
    str3 = a();
    str1 = b();
    str2 = c();
    String str4 = d();
    try
    {
      localJSONObject1 = new JSONObject();
      if ((i == 1007) || (i == 1008) || (i == 2003) || (i == 1044)) {
        break label308;
      }
      if (i != 2054) {}
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          localJSONObject4.put("scene", i);
        }
        catch (Exception localException3)
        {
          try
          {
            localJSONObject4.put("shareTicket", str3);
          }
          catch (Exception localException3)
          {
            try
            {
              JSONObject localJSONObject1 = new JSONObject();
              localJSONObject1.put("appId", str1);
              localJSONObject1.put("extraData", str2);
              localJSONObject4.put("referrerInfo", localJSONObject1);
              if (!jdField_a_of_type_Boolean) {
                a("onAppEnterForeground", localJSONObject4.toString());
              }
              return;
              localException1 = localException1;
              bdrb.a().e("DefaultGameLifeCycle", "onForeground exception put query string :" + localException1);
              continue;
              localException2 = localException2;
              bdrb.a().e("DefaultGameLifeCycle", "onForeground exception put scene string :" + localException2);
              continue;
              localException3 = localException3;
              bdrb.a().e("DefaultGameLifeCycle", "onForeground exception put shareTicket string :" + localException3);
              continue;
            }
            catch (Exception localException4)
            {
              bdrb.a().e("DefaultGameLifeCycle", "onForeground exception put referrerInfo string :" + localException4);
              continue;
            }
          }
        }
        JSONObject localJSONObject2 = localJSONObject3;
      }
    }
    localJSONObject4.put("query", localJSONObject1);
    localJSONObject4.put("entryDataHash", str4);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bdcz.a(bdfv.a(paramString1, paramString2, 0));
  }
  
  public String b()
  {
    return bdqa.a().b();
  }
  
  public void b()
  {
    if (!jdField_a_of_type_Boolean) {
      a("onAppEnterBackground", "");
    }
  }
  
  public String c()
  {
    return bdqa.a().d();
  }
  
  public String d()
  {
    return bdqa.a().g();
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onGameLaunched()
  {
    a();
  }
  
  public void onPause()
  {
    b();
  }
  
  public void onResume()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdov
 * JD-Core Version:    0.7.0.1
 */