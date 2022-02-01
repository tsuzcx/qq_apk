package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ArkDebugChatPie$1$1$4
  implements Runnable
{
  ArkDebugChatPie$1$1$4(ArkDebugChatPie.1.1 param1, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(new JSONObject(this.jdField_a_of_type_JavaLangString).optString("config"));
        if (this.b.equals("input"))
        {
          if ((BaseActivity.sTopActivity instanceof FragmentActivity))
          {
            localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            if (localObject1 != null)
            {
              localObject1 = ((ChatFragment)localObject1).a();
              if (localObject1 != null)
              {
                localObject3 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), this.c, null, false);
                localObject4 = new ArrayList();
                localObject5 = new ArkAiInfo();
                ((ArkAiInfo)localObject5).jdField_a_of_type_JavaLangString = ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
                ((ArkAiInfo)localObject5).d = ((String)localObject3);
                ((ArkAiInfo)localObject5).f = this.d;
                ((ArkAiInfo)localObject5).b = this.c;
                ((List)localObject4).add(localObject5);
                ((BaseChatPie)localObject1).a.a((List)localObject4, 0);
              }
            }
          }
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        Object localObject5;
        localObject2 = null;
        continue;
        if (this.b.equals("popup"))
        {
          localObject4 = BaseActivity.sTopActivity;
          if (!(localObject4 instanceof FragmentActivity)) {
            continue;
          }
          localObject5 = QQCustomArkDialog.AppInfo.a(ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), this.c, "0.0.0.1", this.d, ArkAppCenterUtil.a(), null, null);
          ((Bundle)localObject5).putString("forward_ark_app_name", ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0));
          ((Bundle)localObject5).putString("forward_ark_app_view", this.c);
          ((Bundle)localObject5).putString("forward_ark_app_ver", "0.0.0.1");
          if (TextUtils.isEmpty(this.d))
          {
            localObject3 = "{}";
            ((Bundle)localObject5).putString("forward_ark_app_meta", (String)localObject3);
            if (localObject2 != null)
            {
              localObject2 = ((JSONObject)localObject2).toString();
              ((Bundle)localObject5).putString("forward_ark_app_config", (String)localObject2);
              ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, DialogUtils.a((Context)localObject4, null, (Bundle)localObject5));
              ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).setNegativeButton(2131690800, null);
              ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).setPositiveButton(2131694615, null);
              ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).show();
            }
          }
          else
          {
            localObject3 = this.d;
            continue;
          }
          localObject2 = "{}";
          continue;
        }
        if (!this.b.equals("card")) {
          break label653;
        }
      }
      Object localObject4 = new ArkAppMessage();
      ((ArkAppMessage)localObject4).appMinVersion = "0.0.0.1";
      ((ArkAppMessage)localObject4).appName = ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
      ((ArkAppMessage)localObject4).appView = this.c;
      Object localObject3 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject4).appName, ((ArkAppMessage)localObject4).appMinVersion);
      if (localObject3 != null)
      {
        ((ArkAppMessage)localObject4).appDesc = ((String)((Map)localObject3).get("desc"));
        ((ArkAppMessage)localObject4).appMinVersion = ((String)((Map)localObject3).get("version"));
      }
      if (TextUtils.isEmpty(((ArkAppMessage)localObject4).appDesc)) {
        ((ArkAppMessage)localObject4).appDesc = ((ArkAppMessage)localObject4).appName;
      }
      ((ArkAppMessage)localObject4).promptText = String.format(HardCodeUtil.a(2131700742), new Object[] { ((ArkAppMessage)localObject4).appDesc });
      ((ArkAppMessage)localObject4).metaList = this.d;
      if (localObject2 == null) {}
      for (;;)
      {
        try
        {
          localObject3 = new JSONObject();
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException4)
        {
          label653:
          label922:
          label990:
          try
          {
            for (;;)
            {
              ArkDebugChatPie.a((JSONObject)localObject2);
              ((JSONObject)localObject2).put("type", "card");
              ((ArkAppMessage)localObject4).config = ((JSONObject)localObject2).toString();
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a();
              if (localObject2 == null) {
                break;
              }
              ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject4);
              return;
              if (this.b.equals("fullscreen"))
              {
                if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
                  break;
                }
                localObject2 = (FragmentActivity)BaseActivity.sTopActivity;
                ArkAppDataReport.a(null, ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
                ArkFullScreenAppActivity.a((Context)localObject2, ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), this.c, "0.0.0.1", this.d, ArkAppCenterUtil.a(), null, 0);
                return;
              }
              if (!this.b.equals("default")) {
                break;
              }
              localObject4 = new ArkAppMessage();
              ((ArkAppMessage)localObject4).appMinVersion = "0.0.0.1";
              ((ArkAppMessage)localObject4).appName = ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
              ((ArkAppMessage)localObject4).appView = this.c;
              localObject3 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject4).appName, ((ArkAppMessage)localObject4).appMinVersion);
              if (localObject3 != null)
              {
                ((ArkAppMessage)localObject4).appDesc = ((String)((Map)localObject3).get("desc"));
                ((ArkAppMessage)localObject4).appMinVersion = ((String)((Map)localObject3).get("version"));
              }
              if (TextUtils.isEmpty(((ArkAppMessage)localObject4).appDesc)) {
                ((ArkAppMessage)localObject4).appDesc = ((ArkAppMessage)localObject4).appName;
              }
              ((ArkAppMessage)localObject4).promptText = String.format(HardCodeUtil.a(2131700738), new Object[] { ((ArkAppMessage)localObject4).appDesc });
              ((ArkAppMessage)localObject4).metaList = this.d;
              if (localObject2 != null) {
                break label990;
              }
              try
              {
                localObject3 = new JSONObject();
                localObject2 = localObject3;
              }
              catch (JSONException localJSONException2)
              {
                try
                {
                  ArkDebugChatPie.a((JSONObject)localObject2);
                  ((JSONObject)localObject2).put("type", "normal");
                  for (;;)
                  {
                    ((ArkAppMessage)localObject4).config = ((JSONObject)localObject2).toString();
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a();
                    if (localObject2 == null) {
                      break;
                    }
                    ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject4);
                    return;
                    localJSONException2 = localJSONException2;
                  }
                }
                catch (JSONException localJSONException3)
                {
                  break label922;
                }
              }
            }
            localJSONException4 = localJSONException4;
          }
          catch (JSONException localJSONException5)
          {
            continue;
          }
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4
 * JD-Core Version:    0.7.0.1
 */