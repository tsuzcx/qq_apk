import android.os.Bundle;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bejv
  implements beju<Boolean>
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  public static bejv a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bejv a(int paramInt, Bundle paramBundle)
  {
    bejv localbejv = new bejv();
    localbejv.jdField_a_of_type_Int = paramInt;
    localbejv.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return localbejv;
  }
  
  private void a(begw parambegw, beru paramberu, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", paramInt);
      if ((!parambegw.e()) && (parambegw.a().a() != null)) {
        localJSONObject.put("webViewUrl", parambegw.a().a());
      }
      if (parambegw.e())
      {
        paramberu.b = paramInt;
        if (parambegw.a() != null) {
          parambegw.a().a("onShareAppMessage", localJSONObject.toString(), -1);
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
        besl.d("RuntimeMessage", "on forward wechat moment exception ", localJSONException);
      }
      besl.d("RuntimeMessage", "on forward wechat moments click exception js service==null");
    }
  }
  
  private void a(begw parambegw, CapsuleButton paramCapsuleButton, beru paramberu)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramberu.jdField_a_of_type_Int == 1)
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
        if (!parambegw.e())
        {
          localObject2 = localObject1;
          if (parambegw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambegw.a().a());
            localObject2 = localObject1;
          }
        }
        paramberu.b = 0;
        if ((parambegw.e()) && (parambegw.a() != null))
        {
          if (paramberu.jdField_a_of_type_Int != 1) {
            break;
          }
          paramberu = bekg.a((String)localObject2, localJSONObject);
          if (paramberu == null) {
            break label227;
          }
          paramberu = paramberu.toString();
          parambegw.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramberu);
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
      besl.d("RuntimeMessage", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      paramberu = "";
    }
    parambegw.a().a(localObject3, localJSONObject.toString(), -1);
  }
  
  private void b(begw parambegw, CapsuleButton paramCapsuleButton, beru paramberu)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramberu.jdField_a_of_type_Int == 1)
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
        if (!parambegw.e())
        {
          localObject2 = localObject1;
          if (parambegw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambegw.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambegw.e())
        {
          paramberu.b = 1;
          if (parambegw.a() == null) {
            break label251;
          }
          if (paramberu.jdField_a_of_type_Int != 1) {
            break;
          }
          paramberu = bekg.a((String)localObject2, localJSONObject);
          if (paramberu == null) {
            break label227;
          }
          paramberu = paramberu.toString();
          parambegw.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramberu);
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
      besl.d("RuntimeMessage", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      paramberu = "";
    }
    parambegw.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    besl.d("RuntimeMessage", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void c(begw parambegw, CapsuleButton paramCapsuleButton, beru paramberu)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "onShareAppMessage";
    label183:
    for (;;)
    {
      try
      {
        if (paramberu.jdField_a_of_type_Int == 1)
        {
          String str = "showActionSheet";
          localObject = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap != null)
          {
            localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexWX"));
            localObject = str;
          }
          if ((!parambegw.e()) && (parambegw.a().a() != null)) {
            localJSONObject.put("webViewUrl", parambegw.a().a());
          }
          if (parambegw.e())
          {
            paramberu.b = 3;
            if (parambegw.a() == null) {
              break label207;
            }
            if (paramberu.jdField_a_of_type_Int != 1) {
              break;
            }
            paramberu = bekg.a((String)localObject, localJSONObject);
            if (paramberu == null) {
              break label183;
            }
            paramberu = paramberu.toString();
            parambegw.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramberu);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
          continue;
        }
        paramberu = "";
      }
      catch (JSONException parambegw)
      {
        besl.d("RuntimeMessage", "on forward wechat friends click exception ", parambegw);
        return;
      }
    }
    parambegw.a().a((String)localObject, localJSONObject.toString(), -1);
    return;
    label207:
    besl.d("RuntimeMessage", "on forward wx friends click exception js service==null");
  }
  
  private void d(begw parambegw, CapsuleButton paramCapsuleButton, beru paramberu)
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
            if (paramberu.jdField_a_of_type_Int == 1)
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
            if ((!parambegw.e()) && (parambegw.a().a() != null)) {
              localJSONObject.put("webViewUrl", parambegw.a().a());
            }
            localJSONObject.put("chatDataHash", localShareChatModel.a());
            if (!parambegw.e()) {
              break;
            }
            paramberu.b = 0;
            paramberu.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = localShareChatModel;
            if (parambegw.a() == null) {
              break label344;
            }
            if (paramberu.jdField_a_of_type_Int != 1) {
              break label326;
            }
            paramberu = bekg.a((String)localObject1, localJSONObject);
            if (paramberu == null) {
              break label320;
            }
            paramberu = paramberu.toString();
            parambegw.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramberu);
            return;
          }
          catch (JSONException localJSONException2)
          {
            break label308;
          }
        }
        localThrowable = localThrowable;
        besl.d("RuntimeMessage", "handleShareChatDirectly get an exception ", localThrowable);
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
      besl.d("RuntimeMessage", "on forward directly click exception ", localJSONException1);
      continue;
      label320:
      paramberu = "";
    }
    label326:
    parambegw.a().a((String)localObject1, localJSONObject.toString(), -1);
    return;
    label344:
    besl.d("RuntimeMessage", "on forward directly click exception js service==null");
  }
  
  private void e(begw parambegw, CapsuleButton paramCapsuleButton, beru paramberu)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramberu.jdField_a_of_type_Int == 1)
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
        if (!parambegw.e())
        {
          localObject2 = localObject1;
          if (parambegw.a().a() != null)
          {
            localJSONObject.put("webViewUrl", parambegw.a().a());
            localObject2 = localObject1;
          }
        }
        if (parambegw.e())
        {
          paramberu.b = 4;
          if (parambegw.a() == null) {
            break label251;
          }
          if (paramberu.jdField_a_of_type_Int != 1) {
            break;
          }
          paramberu = bekg.a((String)localObject2, localJSONObject);
          if (paramberu == null) {
            break label227;
          }
          paramberu = paramberu.toString();
          parambegw.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramberu);
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
      besl.d("RuntimeMessage", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label227:
      paramberu = "";
    }
    parambegw.a().a(localObject3, localJSONObject.toString(), -1);
    return;
    label251:
    besl.d("RuntimeMessage", "on forward wechat moments click exception js service==null");
  }
  
  public Boolean a(begw parambegw)
  {
    beru localberu = parambegw.a();
    if (localberu == null) {
      return Boolean.valueOf(false);
    }
    CapsuleButton localCapsuleButton = parambegw.a();
    if (localCapsuleButton == null) {
      return Boolean.valueOf(false);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      a(parambegw, localCapsuleButton, localberu);
      continue;
      b(parambegw, localCapsuleButton, localberu);
      continue;
      c(parambegw, localCapsuleButton, localberu);
      continue;
      e(parambegw, localCapsuleButton, localberu);
      continue;
      d(parambegw, localCapsuleButton, localberu);
      continue;
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        besl.d("RuntimeMessage", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      a(parambegw, localberu, this.jdField_a_of_type_AndroidOsBundle.getInt("id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejv
 * JD-Core Version:    0.7.0.1
 */