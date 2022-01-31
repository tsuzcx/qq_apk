import android.os.Bundle;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bekm
  implements bekl<Boolean>
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  public static bekm a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bekm a(int paramInt, Bundle paramBundle)
  {
    bekm localbekm = new bekm();
    localbekm.jdField_a_of_type_Int = paramInt;
    localbekm.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return localbekm;
  }
  
  private void a(behn parambehn, besl parambesl, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", paramInt);
      if ((!parambehn.e()) && (parambehn.a().a() != null)) {
        localJSONObject.put("webViewUrl", parambehn.a().a());
      }
      if (parambehn.e())
      {
        parambesl.b = paramInt;
        if (parambehn.a() != null) {
          parambehn.a().a("onShareAppMessage", localJSONObject.toString(), -1);
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        betc.d("RuntimeMessage", "on forward wechat moment exception ", localJSONException);
      }
      betc.d("RuntimeMessage", "on forward wechat moments click exception js service==null");
    }
  }
  
  private void a(behn parambehn, CapsuleButton paramCapsuleButton, besl parambesl)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambesl.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexQQ"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!parambehn.e())
        {
          localObject2 = localObject1;
          if (parambehn.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambehn.a().a());
            localObject2 = localObject1;
          }
        }
        parambesl.b = 0;
        if ((parambehn.e()) && (parambehn.a() != null))
        {
          if (parambesl.jdField_a_of_type_Int != 1) {
            break;
          }
          parambesl = bekx.a((String)localObject2, localJSONObject);
          if (parambesl == null) {
            break label227;
          }
          parambesl = parambesl.toString();
          parambehn.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambesl);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label211;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 0);
      localObject1 = localObject2;
      continue;
      label211:
      betc.d("RuntimeMessage", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambesl = "";
    }
    parambehn.a().a(localObject3, localJSONObject.toString(), -1);
  }
  
  private void b(behn parambehn, CapsuleButton paramCapsuleButton, besl parambesl)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambesl.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexQZONE"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!parambehn.e())
        {
          localObject2 = localObject1;
          if (parambehn.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambehn.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambehn.e())
        {
          parambesl.b = 1;
          if (parambehn.a() == null) {
            break label251;
          }
          if (parambesl.jdField_a_of_type_Int != 1) {
            break;
          }
          parambesl = bekx.a((String)localObject2, localJSONObject);
          if (parambesl == null) {
            break label227;
          }
          parambesl = parambesl.toString();
          parambehn.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambesl);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label211;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 1);
      localObject1 = localObject2;
      continue;
      label211:
      betc.d("RuntimeMessage", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambesl = "";
    }
    parambehn.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    betc.d("RuntimeMessage", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void c(behn parambehn, CapsuleButton paramCapsuleButton, besl parambesl)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "onShareAppMessage";
    label183:
    for (;;)
    {
      try
      {
        if (parambesl.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap != null)
          {
            localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexWX"));
            localObject = str;
          }
          if ((!parambehn.e()) && (parambehn.a().a() != null)) {
            localJSONObject.put("webViewUrl", parambehn.a().a());
          }
          if (parambehn.e())
          {
            parambesl.b = 3;
            if (parambehn.a() == null) {
              break label207;
            }
            if (parambesl.jdField_a_of_type_Int != 1) {
              break;
            }
            parambesl = bekx.a((String)localObject, localJSONObject);
            if (parambesl == null) {
              break label183;
            }
            parambesl = parambesl.toString();
            parambehn.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambesl);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
          continue;
        }
        parambesl = "";
      }
      catch (JSONException parambehn)
      {
        betc.d("RuntimeMessage", "on forward wechat friends click exception ", parambehn);
        return;
      }
    }
    parambehn.a().a((String)localObject, localJSONObject.toString(), -1);
    return;
    label207:
    betc.d("RuntimeMessage", "on forward wx friends click exception js service==null");
  }
  
  private void d(behn parambehn, CapsuleButton paramCapsuleButton, besl parambesl)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("key_mini_app_share_chat_uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_mini_app_share_chat_type");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("key_mini_app_share_chat_name");
    long l2 = -1L;
    long l1 = l2;
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject2).longValue();
        localShareChatModel = new ShareChatModel(i, l1, (String)localObject1);
        localJSONObject = new JSONObject();
        localObject2 = "onShareAppMessage";
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ShareChatModel localShareChatModel;
          JSONObject localJSONObject;
          try
          {
            if (parambesl.jdField_a_of_type_Int == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", -1);
              localObject1 = "showActionSheet";
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if ((!parambehn.e()) && (parambehn.a().a() != null)) {
              localJSONObject.put("webViewUrl", parambehn.a().a());
            }
            localJSONObject.put("chatDataHash", localShareChatModel.a());
            if (!parambehn.e()) {
              break;
            }
            parambesl.b = 0;
            parambesl.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = localShareChatModel;
            if (parambehn.a() == null) {
              break label344;
            }
            if (parambesl.jdField_a_of_type_Int != 1) {
              break label326;
            }
            parambesl = bekx.a((String)localObject1, localJSONObject);
            if (parambesl == null) {
              break label320;
            }
            parambesl = parambesl.toString();
            parambehn.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambesl);
            return;
          }
          catch (JSONException localJSONException2)
          {
            break label308;
          }
        }
        localThrowable = localThrowable;
        betc.d("RuntimeMessage", "handleShareChatDirectly get an exception ", localThrowable);
        l1 = l2;
        continue;
        localObject1 = localThrowable;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localThrowable;
        localJSONObject.put("shareTarget", 5);
        localObject1 = localThrowable;
        continue;
      }
      label308:
      betc.d("RuntimeMessage", "on forward directly click exception ", localJSONException1);
      continue;
      label320:
      parambesl = "";
    }
    label326:
    parambehn.a().a((String)localObject1, localJSONObject.toString(), -1);
    return;
    label344:
    betc.d("RuntimeMessage", "on forward directly click exception js service==null");
  }
  
  private void e(behn parambehn, CapsuleButton paramCapsuleButton, besl parambesl)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambesl.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject2 = str;
          localObject1 = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap == null) {
            continue;
          }
          localObject1 = str;
          localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexWXMoments"));
          localObject1 = "showActionSheet";
          localObject2 = localObject1;
        }
      }
      catch (JSONException localJSONException1) {}
      try
      {
        if (!parambehn.e())
        {
          localObject2 = localObject1;
          if (parambehn.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambehn.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambehn.e())
        {
          parambesl.b = 4;
          if (parambehn.a() == null) {
            break label251;
          }
          if (parambesl.jdField_a_of_type_Int != 1) {
            break;
          }
          parambesl = bekx.a((String)localObject2, localJSONObject);
          if (parambesl == null) {
            break label227;
          }
          parambesl = parambesl.toString();
          parambehn.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambesl);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label211;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 4);
      localObject1 = localObject2;
      continue;
      label211:
      betc.d("RuntimeMessage", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambesl = "";
    }
    parambehn.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    betc.d("RuntimeMessage", "on forward wechat moments click exception js service==null");
  }
  
  public Boolean a(behn parambehn)
  {
    besl localbesl = parambehn.a();
    if (localbesl == null) {
      return Boolean.valueOf(false);
    }
    CapsuleButton localCapsuleButton = parambehn.a();
    if (localCapsuleButton == null) {
      return Boolean.valueOf(false);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      a(parambehn, localCapsuleButton, localbesl);
      continue;
      b(parambehn, localCapsuleButton, localbesl);
      continue;
      c(parambehn, localCapsuleButton, localbesl);
      continue;
      e(parambehn, localCapsuleButton, localbesl);
      continue;
      d(parambehn, localCapsuleButton, localbesl);
      continue;
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        betc.d("RuntimeMessage", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      a(parambehn, localbesl, this.jdField_a_of_type_AndroidOsBundle.getInt("id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekm
 * JD-Core Version:    0.7.0.1
 */