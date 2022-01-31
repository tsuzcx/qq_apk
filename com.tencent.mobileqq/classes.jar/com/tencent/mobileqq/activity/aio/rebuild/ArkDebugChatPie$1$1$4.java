package com.tencent.mobileqq.activity.aio.rebuild;

import agis;
import agit;
import alpo;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import anis;
import anjs;
import anjv;
import ankt;
import bdcd;
import bdfk;
import bdfq;
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
  public ArkDebugChatPie$1$1$4(agit paramagit, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
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
              localObject2 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(agis.a(this.jdField_a_of_type_Agit.a.this$0), this.c, null, false);
              localObject3 = new ArrayList();
              anis localanis = new anis();
              localanis.jdField_a_of_type_JavaLangString = agis.a(this.jdField_a_of_type_Agit.a.this$0);
              localanis.d = ((String)localObject2);
              localanis.f = this.d;
              localanis.b = this.c;
              ((List)localObject3).add(localanis);
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
          localObject2 = bdfk.a(agis.a(this.jdField_a_of_type_Agit.a.this$0), this.c, "0.0.0.1", this.d, anjs.a(), null, null);
          agis.a(this.jdField_a_of_type_Agit.a.this$0, bdcd.a((Context)localObject1, null, (Bundle)localObject2));
          agis.a(this.jdField_a_of_type_Agit.a.this$0).setNegativeButton(2131690648, null);
          agis.a(this.jdField_a_of_type_Agit.a.this$0).setPositiveButton(2131694951, null);
          agis.a(this.jdField_a_of_type_Agit.a.this$0).show();
          return;
        }
        if (this.b.equals("card"))
        {
          localObject3 = new ArkAppMessage();
          ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
          ((ArkAppMessage)localObject3).appName = agis.a(this.jdField_a_of_type_Agit.a.this$0);
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
          ((ArkAppMessage)localObject3).promptText = String.format(alpo.a(2131701034), new Object[] { ((ArkAppMessage)localObject3).appDesc });
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
              agis.a((JSONObject)localObject1);
              ((JSONObject)localObject1).put("type", "card");
              for (;;)
              {
                for (;;)
                {
                  label505:
                  ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                  localObject1 = this.jdField_a_of_type_Agit.a.this$0.a();
                  if (localObject1 == null) {
                    break;
                  }
                  agis.a(this.jdField_a_of_type_Agit.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
                  return;
                  if (this.b.equals("fullscreen"))
                  {
                    if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
                      break;
                    }
                    localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
                    anjv.a(null, agis.a(this.jdField_a_of_type_Agit.a.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                    ArkFullScreenAppActivity.a((Context)localObject1, agis.a(this.jdField_a_of_type_Agit.a.this$0), this.c, "0.0.0.1", this.d, anjs.a(), null, 0);
                    return;
                  }
                  if (!this.b.equals("default")) {
                    break;
                  }
                  localObject3 = new ArkAppMessage();
                  ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
                  ((ArkAppMessage)localObject3).appName = agis.a(this.jdField_a_of_type_Agit.a.this$0);
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
                  ((ArkAppMessage)localObject3).promptText = String.format(alpo.a(2131701030), new Object[] { ((ArkAppMessage)localObject3).appDesc });
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
                      agis.a((JSONObject)localObject1);
                      ((JSONObject)localObject1).put("type", "normal");
                      for (;;)
                      {
                        label826:
                        ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
                        localObject1 = this.jdField_a_of_type_Agit.a.this$0.a();
                        if (localObject1 == null) {
                          break;
                        }
                        agis.a(this.jdField_a_of_type_Agit.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4
 * JD-Core Version:    0.7.0.1
 */