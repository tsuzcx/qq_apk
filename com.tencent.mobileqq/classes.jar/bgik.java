import android.os.Bundle;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bgik
  implements bghv<Boolean>
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  private int a(bgho parambgho)
  {
    return bgie.a(parambgho).a();
  }
  
  public static bgik a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bgik a(int paramInt, Bundle paramBundle)
  {
    bgik localbgik = new bgik();
    localbgik.jdField_a_of_type_Int = paramInt;
    localbgik.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return localbgik;
  }
  
  private String a(bgho parambgho)
  {
    return bgie.a(parambgho).a();
  }
  
  private void a(bghl parambghl, CapsuleButton paramCapsuleButton, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
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
        if (!parambghl.b())
        {
          localObject2 = localObject1;
          if (a(parambghl) != null)
          {
            localJSONObject.put("webViewUrl", a(parambghl));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 0;
        if (parambghl.a() != null)
        {
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgki.a((String)localObject2, localJSONObject);
          if (paramShareState == null) {
            break label212;
          }
          paramShareState = paramShareState.toString();
          parambghl.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label196;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 0);
      localObject1 = localObject2;
      continue;
      label196:
      QMLog.e("Action", "on forward aio click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label212:
      paramShareState = "";
    }
    parambghl.a().a(localObject3, localJSONObject.toString(), a(parambghl));
  }
  
  private void a(bghl parambghl, ShareState paramShareState, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", paramInt);
      if ((!parambghl.b()) && (a(parambghl) != null)) {
        localJSONObject.put("webViewUrl", a(parambghl));
      }
      paramShareState.fromShareMenuBtn = paramInt;
      if (parambghl.a() != null)
      {
        parambghl.a().a("onShareAppMessage", localJSONObject.toString(), a(parambghl));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("Action", "on forward wechat moment exception ", localJSONException);
      }
      QMLog.e("Action", "on forward wechat moments click exception js service==null");
    }
  }
  
  private void b(bghl parambghl, CapsuleButton paramCapsuleButton, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
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
        if (!parambghl.b())
        {
          localObject2 = localObject1;
          if (a(parambghl) != null)
          {
            localJSONObject.put("webViewUrl", a(parambghl));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 1;
        if (parambghl.a() == null) {
          break label240;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramShareState = bgki.a((String)localObject2, localJSONObject);
        if (paramShareState == null) {
          break label212;
        }
        paramShareState = paramShareState.toString();
        parambghl.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label196;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 1);
      localObject1 = localObject2;
      continue;
      label196:
      QMLog.e("Action", "on forward qzone click exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label212:
      paramShareState = "";
    }
    parambghl.a().a(localObject3, localJSONObject.toString(), a(parambghl));
    return;
    label240:
    QMLog.e("Action", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void c(bghl parambghl, CapsuleButton paramCapsuleButton, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "onShareAppMessage";
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
        {
          String str = "showActionSheet";
          localObject = str;
          if (paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap != null)
          {
            localJSONObject.put("tapIndex", paramCapsuleButton.jdField_a_of_type_JavaUtilHashMap.get("tapIndexWX"));
            localObject = str;
          }
          if ((!parambghl.b()) && (a(parambghl) != null)) {
            localJSONObject.put("webViewUrl", a(parambghl));
          }
          paramShareState.fromShareMenuBtn = 3;
          if (parambghl.a() == null) {
            break label196;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgki.a((String)localObject, localJSONObject);
          if (paramShareState != null)
          {
            paramShareState = paramShareState.toString();
            parambghl.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
          }
        }
        else
        {
          localJSONObject.put("fromShareButton", 0);
          localJSONObject.put("shareTarget", 3);
          continue;
        }
        paramShareState = "";
      }
      catch (JSONException parambghl)
      {
        QMLog.e("Action", "on forward wechat friends click exception ", parambghl);
        return;
      }
    }
    parambghl.a().a((String)localObject, localJSONObject.toString(), a(parambghl));
    return;
    label196:
    QMLog.e("Action", "on forward wx friends click exception js service==null");
  }
  
  private void d(bghl parambghl, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
    JSONObject localJSONObject;
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
        ShareChatModel localShareChatModel;
        try
        {
          if (paramShareState.launchFrom == 1)
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
          if ((!parambghl.b()) && (a(parambghl) != null)) {
            localJSONObject.put("webViewUrl", a(parambghl));
          }
          localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
          paramShareState.fromShareMenuBtn = 0;
          paramShareState.shareChatModel = localShareChatModel;
          if (parambghl.a() == null) {
            break label333;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgki.a((String)localObject1, localJSONObject);
          if (paramShareState == null) {
            break label305;
          }
          paramShareState = paramShareState.toString();
          parambghl.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label293;
        }
        localThrowable = localThrowable;
        QMLog.e("Action", "handleShareChatDirectly get an exception ", localThrowable);
        l1 = l2;
        continue;
        localObject1 = localThrowable;
        localJSONObject.put("fromShareButton", 0);
        localObject1 = localThrowable;
        localJSONObject.put("shareTarget", 5);
        localObject1 = localThrowable;
        continue;
      }
      label293:
      QMLog.e("Action", "on forward directly click exception ", localJSONException1);
      continue;
      label305:
      paramShareState = "";
    }
    parambghl.a().a((String)localObject1, localJSONObject.toString(), a(parambghl));
    return;
    label333:
    QMLog.e("Action", "on forward directly click exception js service==null");
  }
  
  private void e(bghl parambghl, CapsuleButton paramCapsuleButton, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (paramShareState.launchFrom == 1)
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
        if (!parambghl.b())
        {
          localObject2 = localObject1;
          if (a(parambghl) != null)
          {
            localJSONObject.put("webViewUrl", a(parambghl));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 4;
        if (parambghl.a() == null) {
          break label240;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramShareState = bgki.a((String)localObject2, localJSONObject);
        if (paramShareState == null) {
          break label212;
        }
        paramShareState = paramShareState.toString();
        parambghl.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
        return;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        break label196;
      }
      localObject1 = localObject2;
      localJSONObject.put("fromShareButton", 0);
      localObject1 = localObject2;
      localJSONObject.put("shareTarget", 4);
      localObject1 = localObject2;
      continue;
      label196:
      QMLog.e("Action", "on forward wechat moment exception ", localJSONException1);
      localObject3 = localObject1;
      continue;
      label212:
      paramShareState = "";
    }
    parambghl.a().a(localObject3, localJSONObject.toString(), a(parambghl));
    return;
    label240:
    QMLog.e("Action", "on forward wechat moments click exception js service==null");
  }
  
  public Boolean a(bghl parambghl)
  {
    ShareState localShareState = parambghl.a();
    if (localShareState == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". shareState is null");
      return Boolean.valueOf(false);
    }
    Object localObject = parambghl.a();
    if (localObject == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    localObject = ((bghq)localObject).a();
    if (localObject == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". capsuleButton is null");
      return Boolean.valueOf(false);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      a(parambghl, (CapsuleButton)localObject, localShareState);
      continue;
      b(parambghl, (CapsuleButton)localObject, localShareState);
      continue;
      c(parambghl, (CapsuleButton)localObject, localShareState);
      continue;
      e(parambghl, (CapsuleButton)localObject, localShareState);
      continue;
      d(parambghl, (CapsuleButton)localObject, localShareState);
      continue;
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        QMLog.e("Action", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      a(parambghl, localShareState, this.jdField_a_of_type_AndroidOsBundle.getInt("id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgik
 * JD-Core Version:    0.7.0.1
 */