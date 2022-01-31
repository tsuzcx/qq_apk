import android.content.Context;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import org.json.JSONObject;

public class beud
  implements GameLifecycle
{
  public static boolean a;
  private begz a;
  
  beud(begz parambegz)
  {
    this.jdField_a_of_type_Begz = parambegz;
  }
  
  public int a()
  {
    return bevi.a().a();
  }
  
  public String a()
  {
    return bevi.a().e();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject2 = bevi.a().a();
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
        break label311;
      }
      if (i != 2054) {}
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          localJSONObject4.put("scene", bekj.a(i));
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
              bewt.a().e("DefaultGameLifeCycle", "onForeground exception put query string :" + localException1);
              continue;
              localException2 = localException2;
              bewt.a().e("DefaultGameLifeCycle", "onForeground exception put scene string :" + localException2);
              continue;
              localException3 = localException3;
              bewt.a().e("DefaultGameLifeCycle", "onForeground exception put shareTicket string :" + localException3);
              continue;
            }
            catch (Exception localException4)
            {
              bewt.a().e("DefaultGameLifeCycle", "onForeground exception put referrerInfo string :" + localException4);
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
    this.jdField_a_of_type_Begz.a(bejw.a(paramString1, paramString2, 0));
  }
  
  public String b()
  {
    return bevi.a().b();
  }
  
  public void b()
  {
    if (!jdField_a_of_type_Boolean) {
      a("onAppEnterBackground", "");
    }
  }
  
  public String c()
  {
    return bevi.a().d();
  }
  
  public String d()
  {
    return bevi.a().g();
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
 * Qualified Name:     beud
 * JD-Core Version:    0.7.0.1
 */