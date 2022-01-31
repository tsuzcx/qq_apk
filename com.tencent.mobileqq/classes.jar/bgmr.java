import android.os.Bundle;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bgmr
  implements bgmc<Boolean>
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  
  private int a(bglv parambglv)
  {
    return bgml.a(parambglv).a();
  }
  
  public static bgmr a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public static bgmr a(int paramInt, Bundle paramBundle)
  {
    bgmr localbgmr = new bgmr();
    localbgmr.jdField_a_of_type_Int = paramInt;
    localbgmr.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return localbgmr;
  }
  
  private String a(bglv parambglv)
  {
    return bgml.a(parambglv).a();
  }
  
  private void a(bgls parambgls, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
        if (!parambgls.b())
        {
          localObject2 = localObject1;
          if (a(parambgls) != null)
          {
            localJSONObject.put("webViewUrl", a(parambgls));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 0;
        if (parambgls.a() != null)
        {
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgop.a((String)localObject2, localJSONObject);
          if (paramShareState == null) {
            break label212;
          }
          paramShareState = paramShareState.toString();
          parambgls.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
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
    parambgls.a().a(localObject3, localJSONObject.toString(), a(parambgls));
  }
  
  private void a(bgls parambgls, ShareState paramShareState, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fromShareButton", 0);
      localJSONObject.put("shareTarget", paramInt);
      if ((!parambgls.b()) && (a(parambgls) != null)) {
        localJSONObject.put("webViewUrl", a(parambgls));
      }
      paramShareState.fromShareMenuBtn = paramInt;
      if (parambgls.a() != null)
      {
        parambgls.a().a("onShareAppMessage", localJSONObject.toString(), a(parambgls));
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
  
  private void b(bgls parambgls, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
        if (!parambgls.b())
        {
          localObject2 = localObject1;
          if (a(parambgls) != null)
          {
            localJSONObject.put("webViewUrl", a(parambgls));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 1;
        if (parambgls.a() == null) {
          break label240;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramShareState = bgop.a((String)localObject2, localJSONObject);
        if (paramShareState == null) {
          break label212;
        }
        paramShareState = paramShareState.toString();
        parambgls.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
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
    parambgls.a().a(localObject3, localJSONObject.toString(), a(parambgls));
    return;
    label240:
    QMLog.e("Action", "on forward qzone click exception mGameJsPluginEngine==null");
  }
  
  private void c(bgls parambgls, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
          if ((!parambgls.b()) && (a(parambgls) != null)) {
            localJSONObject.put("webViewUrl", a(parambgls));
          }
          paramShareState.fromShareMenuBtn = 3;
          if (parambgls.a() == null) {
            break label196;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgop.a((String)localObject, localJSONObject);
          if (paramShareState != null)
          {
            paramShareState = paramShareState.toString();
            parambgls.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
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
      catch (JSONException parambgls)
      {
        QMLog.e("Action", "on forward wechat friends click exception ", parambgls);
        return;
      }
    }
    parambgls.a().a((String)localObject, localJSONObject.toString(), a(parambgls));
    return;
    label196:
    QMLog.e("Action", "on forward wx friends click exception js service==null");
  }
  
  private void d(bgls parambgls, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
          if ((!parambgls.b()) && (a(parambgls) != null)) {
            localJSONObject.put("webViewUrl", a(parambgls));
          }
          localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
          paramShareState.fromShareMenuBtn = 0;
          paramShareState.shareChatModel = localShareChatModel;
          if (parambgls.a() == null) {
            break label333;
          }
          if (paramShareState.launchFrom != 1) {
            break;
          }
          paramShareState = bgop.a((String)localObject1, localJSONObject);
          if (paramShareState == null) {
            break label305;
          }
          paramShareState = paramShareState.toString();
          parambgls.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
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
    parambgls.a().a((String)localObject1, localJSONObject.toString(), a(parambgls));
    return;
    label333:
    QMLog.e("Action", "on forward directly click exception js service==null");
  }
  
  private void e(bgls parambgls, CapsuleButton paramCapsuleButton, ShareState paramShareState)
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
        if (!parambgls.b())
        {
          localObject2 = localObject1;
          if (a(parambgls) != null)
          {
            localJSONObject.put("webViewUrl", a(parambgls));
            localObject2 = localObject1;
          }
        }
        paramShareState.fromShareMenuBtn = 4;
        if (parambgls.a() == null) {
          break label240;
        }
        if (paramShareState.launchFrom != 1) {
          break;
        }
        paramShareState = bgop.a((String)localObject2, localJSONObject);
        if (paramShareState == null) {
          break label212;
        }
        paramShareState = paramShareState.toString();
        parambgls.a().a(paramCapsuleButton.jdField_a_of_type_Int, paramShareState);
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
    parambgls.a().a(localObject3, localJSONObject.toString(), a(parambgls));
    return;
    label240:
    QMLog.e("Action", "on forward wechat moments click exception js service==null");
  }
  
  public Boolean a(bgls parambgls)
  {
    ShareState localShareState = parambgls.a();
    if (localShareState == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". shareState is null");
      return Boolean.valueOf(false);
    }
    Object localObject = parambgls.a();
    if (localObject == null)
    {
      QMLog.e("Action", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    localObject = ((bglx)localObject).a();
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
      a(parambgls, (CapsuleButton)localObject, localShareState);
      continue;
      b(parambgls, (CapsuleButton)localObject, localShareState);
      continue;
      c(parambgls, (CapsuleButton)localObject, localShareState);
      continue;
      e(parambgls, (CapsuleButton)localObject, localShareState);
      continue;
      d(parambgls, (CapsuleButton)localObject, localShareState);
      continue;
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        QMLog.e("Action", "Failed to share to other, data is null");
        return Boolean.valueOf(false);
      }
      a(parambgls, localShareState, this.jdField_a_of_type_AndroidOsBundle.getInt("id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmr
 * JD-Core Version:    0.7.0.1
 */