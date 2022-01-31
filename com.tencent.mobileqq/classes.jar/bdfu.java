import android.os.Bundle;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bdfu
  implements bdft<Boolean>
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  public static bdfu a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bdfu a(int paramInt, Bundle paramBundle)
  {
    bdfu localbdfu = new bdfu();
    localbdfu.jdField_a_of_type_Int = paramInt;
    localbdfu.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return localbdfu;
  }
  
  private void a(bdcw parambdcw, CapsuleButton paramCapsuleButton, bdgb parambdgb)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambdgb.jdField_a_of_type_Int == 1)
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
        if (!parambdcw.e())
        {
          localObject2 = localObject1;
          if (parambdcw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambdcw.a().a());
            localObject2 = localObject1;
          }
        }
        parambdgb.b = 0;
        if ((parambdcw.e()) && (parambdcw.a() != null))
        {
          if (parambdgb.jdField_a_of_type_Int != 1) {
            break;
          }
          parambdgb = bdgg.a((String)localObject2, localJSONObject);
          if (parambdgb == null) {
            break label227;
          }
          parambdgb = parambdgb.toString();
          parambdcw.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambdgb);
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
      bdnw.d("RuntimeMessage", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambdgb = "";
    }
    parambdcw.a().a(localObject3, localJSONObject.toString(), -1);
  }
  
  private void b(bdcw parambdcw, CapsuleButton paramCapsuleButton, bdgb parambdgb)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambdgb.jdField_a_of_type_Int == 1)
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
        if (!parambdcw.e())
        {
          localObject2 = localObject1;
          if (parambdcw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambdcw.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambdcw.e())
        {
          parambdgb.b = 1;
          if (parambdcw.a() == null) {
            break label251;
          }
          if (parambdgb.jdField_a_of_type_Int != 1) {
            break;
          }
          parambdgb = bdgg.a((String)localObject2, localJSONObject);
          if (parambdgb == null) {
            break label227;
          }
          parambdgb = parambdgb.toString();
          parambdcw.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambdgb);
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
      bdnw.d("RuntimeMessage", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambdgb = "";
    }
    parambdcw.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    bdnw.d("RuntimeMessage", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void c(bdcw parambdcw, CapsuleButton paramCapsuleButton, bdgb parambdgb)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "onShareAppMessage";
    label183:
    for (;;)
    {
      try
      {
        if (parambdgb.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap != null)
          {
            localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexWX"));
            localObject = str;
          }
          if ((!parambdcw.e()) && (parambdcw.a().a() != null)) {
            localJSONObject.put("webViewUrl", parambdcw.a().a());
          }
          if (parambdcw.e())
          {
            parambdgb.b = 3;
            if (parambdcw.a() == null) {
              break label207;
            }
            if (parambdgb.jdField_a_of_type_Int != 1) {
              break;
            }
            parambdgb = bdgg.a((String)localObject, localJSONObject);
            if (parambdgb == null) {
              break label183;
            }
            parambdgb = parambdgb.toString();
            parambdcw.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambdgb);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
          continue;
        }
        parambdgb = "";
      }
      catch (JSONException parambdcw)
      {
        bdnw.d("RuntimeMessage", "on forward wechat friends click exception ", parambdcw);
        return;
      }
    }
    parambdcw.a().a((String)localObject, localJSONObject.toString(), -1);
    return;
    label207:
    bdnw.d("RuntimeMessage", "on forward wx friends click exception js service==null");
  }
  
  private void d(bdcw parambdcw, CapsuleButton paramCapsuleButton, bdgb parambdgb)
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
            if (parambdgb.jdField_a_of_type_Int == 1)
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
            if ((!parambdcw.e()) && (parambdcw.a().a() != null)) {
              localJSONObject.put("webViewUrl", parambdcw.a().a());
            }
            localJSONObject.put("chatDataHash", localShareChatModel.a());
            if (!parambdcw.e()) {
              break;
            }
            parambdgb.b = 0;
            parambdgb.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = localShareChatModel;
            if (parambdcw.a() == null) {
              break label344;
            }
            if (parambdgb.jdField_a_of_type_Int != 1) {
              break label326;
            }
            parambdgb = bdgg.a((String)localObject1, localJSONObject);
            if (parambdgb == null) {
              break label320;
            }
            parambdgb = parambdgb.toString();
            parambdcw.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambdgb);
            return;
          }
          catch (JSONException localJSONException2)
          {
            break label308;
          }
        }
        localThrowable = localThrowable;
        bdnw.d("RuntimeMessage", "handleShareChatDirectly get an exception ", localThrowable);
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
      bdnw.d("RuntimeMessage", "on forward directly click exception ", localJSONException1);
      continue;
      label320:
      parambdgb = "";
    }
    label326:
    parambdcw.a().a((String)localObject1, localJSONObject.toString(), -1);
    return;
    label344:
    bdnw.d("RuntimeMessage", "on forward directly click exception js service==null");
  }
  
  private void e(bdcw parambdcw, CapsuleButton paramCapsuleButton, bdgb parambdgb)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (parambdgb.jdField_a_of_type_Int == 1)
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
        if (!parambdcw.e())
        {
          localObject2 = localObject1;
          if (parambdcw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambdcw.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambdcw.e())
        {
          parambdgb.b = 4;
          if (parambdcw.a() == null) {
            break label251;
          }
          if (parambdgb.jdField_a_of_type_Int != 1) {
            break;
          }
          parambdgb = bdgg.a((String)localObject2, localJSONObject);
          if (parambdgb == null) {
            break label227;
          }
          parambdgb = parambdgb.toString();
          parambdcw.a().a(paramCapsuleButton.jdField_a_of_type_Int, parambdgb);
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
      bdnw.d("RuntimeMessage", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      parambdgb = "";
    }
    parambdcw.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    bdnw.d("RuntimeMessage", "on forward wechat moments click exception js service==null");
  }
  
  public Boolean a(bdcw parambdcw)
  {
    bdgb localbdgb = parambdcw.a();
    if (localbdgb == null) {
      return Boolean.valueOf(false);
    }
    CapsuleButton localCapsuleButton = parambdcw.a();
    if (localCapsuleButton == null) {
      return Boolean.valueOf(false);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      a(parambdcw, localCapsuleButton, localbdgb);
      continue;
      b(parambdcw, localCapsuleButton, localbdgb);
      continue;
      c(parambdcw, localCapsuleButton, localbdgb);
      continue;
      e(parambdcw, localCapsuleButton, localbdgb);
      continue;
      d(parambdcw, localCapsuleButton, localbdgb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfu
 * JD-Core Version:    0.7.0.1
 */