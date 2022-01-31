package com.tencent.mobileqq.activity.aio.rebuild;

import aebe;
import aebf;
import ajjy;
import aldn;
import alem;
import alep;
import alfn;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import babr;
import baev;
import bafb;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkDebugChatPie$1$1$4
  implements Runnable
{
  public ArkDebugChatPie$1$1$4(aebf paramaebf, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      localObject1 = new JSONObject(new JSONObject(this.jdField_a_of_type_JavaLangString).optString("config"));
      Object localObject3;
      if (this.b.equals("input")) {
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (localObject1 != null)
          {
            localObject1 = ((ChatFragment)localObject1).a();
            if (localObject1 != null)
            {
              localObject2 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(aebe.a(this.jdField_a_of_type_Aebf.a.this$0), this.c, null, false);
              localObject3 = new ArrayList();
              aldn localaldn = new aldn();
              localaldn.jdField_a_of_type_JavaLangString = aebe.a(this.jdField_a_of_type_Aebf.a.this$0);
              localaldn.d = ((String)localObject2);
              localaldn.f = this.d;
              localaldn.b = this.c;
              ((List)localObject3).add(localaldn);
              ((BaseChatPie)localObject1).a.a((List)localObject3, 0);
            }
          }
        }
      }
      for (;;)
      {
        return;
        if (this.b.equals("popup"))
        {
          localObject1 = BaseActivity.sTopActivity;
          if (!(localObject1 instanceof FragmentActivity)) {
            continue;
          }
          localObject2 = baev.a(aebe.a(this.jdField_a_of_type_Aebf.a.this$0), this.c, "0.0.0.1", this.d, alem.a(), null, null);
          aebe.a(this.jdField_a_of_type_Aebf.a.this$0, babr.a((Context)localObject1, null, (Bundle)localObject2));
          aebe.a(this.jdField_a_of_type_Aebf.a.this$0).setNegativeButton(2131625035, null);
          aebe.a(this.jdField_a_of_type_Aebf.a.this$0).setPositiveButton(2131629116, null);
          aebe.a(this.jdField_a_of_type_Aebf.a.this$0).show();
          return;
        }
        if (this.b.equals("card"))
        {
          localObject3 = new ArkAppMessage();
          ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
          ((ArkAppMessage)localObject3).appName = aebe.a(this.jdField_a_of_type_Aebf.a.this$0);
          ((ArkAppMessage)localObject3).appView = this.c;
          localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
          if (localObject2 != null)
          {
            ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
            ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
          }
          if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
            ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
          }
          ((ArkAppMessage)localObject3).promptText = String.format(ajjy.a(2131634870), new Object[] { ((ArkAppMessage)localObject3).appDesc });
          ((ArkAppMessage)localObject3).metaList = this.d;
          if (localObject1 != null) {}
        }
        else
        {
          try
          {
            localObject2 = new JSONObject();
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException5)
          {
            try
            {
              aebe.a((JSONObject)localObject1);
              ((JSONObject)localObject1).put("type", "card");
              for (;;)
              {
                for (;;)
                {
                  label505:
                  ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                  localObject1 = this.jdField_a_of_type_Aebf.a.this$0.a();
                  if (localObject1 == null) {
                    break;
                  }
                  aebe.a(this.jdField_a_of_type_Aebf.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
                  return;
                  if (this.b.equals("fullscreen"))
                  {
                    if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
                      break;
                    }
                    localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
                    alep.a(null, aebe.a(this.jdField_a_of_type_Aebf.a.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                    ArkFullScreenAppActivity.a((Context)localObject1, aebe.a(this.jdField_a_of_type_Aebf.a.this$0), this.c, "0.0.0.1", this.d, alem.a(), null, 0);
                    return;
                  }
                  if (!this.b.equals("default")) {
                    break;
                  }
                  localObject3 = new ArkAppMessage();
                  ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
                  ((ArkAppMessage)localObject3).appName = aebe.a(this.jdField_a_of_type_Aebf.a.this$0);
                  ((ArkAppMessage)localObject3).appView = this.c;
                  localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
                  if (localObject2 != null)
                  {
                    ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
                    ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
                  }
                  if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
                    ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
                  }
                  ((ArkAppMessage)localObject3).promptText = String.format(ajjy.a(2131634866), new Object[] { ((ArkAppMessage)localObject3).appDesc });
                  ((ArkAppMessage)localObject3).metaList = this.d;
                  if (localObject1 != null) {
                    break label900;
                  }
                  try
                  {
                    localObject2 = new JSONObject();
                    localObject1 = localObject2;
                  }
                  catch (JSONException localJSONException3)
                  {
                    try
                    {
                      aebe.a((JSONObject)localObject1);
                      ((JSONObject)localObject1).put("type", "normal");
                      for (;;)
                      {
                        label826:
                        ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                        localObject1 = this.jdField_a_of_type_Aebf.a.this$0.a();
                        if (localObject1 == null) {
                          break;
                        }
                        aebe.a(this.jdField_a_of_type_Aebf.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
                        return;
                        localJSONException3 = localJSONException3;
                      }
                    }
                    catch (JSONException localJSONException4)
                    {
                      break label826;
                    }
                  }
                }
                localJSONException5 = localJSONException5;
              }
            }
            catch (JSONException localJSONException6)
            {
              break label505;
            }
          }
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      label900:
      for (;;)
      {
        JSONException localJSONException2 = localJSONException6;
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4
 * JD-Core Version:    0.7.0.1
 */