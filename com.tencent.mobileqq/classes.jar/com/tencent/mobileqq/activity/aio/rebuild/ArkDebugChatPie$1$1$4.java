package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
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
    try
    {
      localObject1 = new JSONObject(new JSONObject(this.jdField_a_of_type_JavaLangString).optString("config"));
    }
    catch (JSONException localJSONException1)
    {
      Object localObject1;
      label37:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Bundle localBundle;
      boolean bool;
      break label37;
    }
    localObject1 = null;
    if (this.b.equals("input"))
    {
      if ((BaseActivity.sTopActivity instanceof BaseActivity))
      {
        localObject1 = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if (localObject1 != null)
        {
          localObject2 = ((ChatFragment)localObject1).a();
          if (localObject2 != null)
          {
            localObject3 = ArkAppMgr.getInstance().getAppPathFromLocal(ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0));
            localObject1 = new ArrayList();
            localObject4 = new ArkAiInfo();
            ((ArkAiInfo)localObject4).jdField_a_of_type_JavaLangString = ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
            ((ArkAiInfo)localObject4).d = ((String)localObject3);
            ((ArkAiInfo)localObject4).e = this.c;
            ((ArkAiInfo)localObject4).b = this.d;
            ((List)localObject1).add(localObject4);
            localObject2 = ((ArkHelper)((BaseChatPie)localObject2).a(110)).a();
            if (localObject2 != null) {
              ((ArkRecommendController)localObject2).a((List)localObject1, 0);
            }
          }
        }
      }
    }
    else if (this.b.equals("popup"))
    {
      localObject4 = BaseActivity.sTopActivity;
      if ((localObject4 instanceof BaseActivity))
      {
        localBundle = QQCustomArkDialog.AppInfo.a(ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), this.d, "0.0.0.1", this.c, ArkAppCenterUtil.a(), null, null);
        localBundle.putString("forward_ark_app_name", ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0));
        localBundle.putString("forward_ark_app_view", this.d);
        localBundle.putString("forward_ark_app_ver", "0.0.0.1");
        bool = TextUtils.isEmpty(this.c);
        localObject3 = "{}";
        if (bool) {
          localObject2 = "{}";
        } else {
          localObject2 = this.c;
        }
        localBundle.putString("forward_ark_app_meta", (String)localObject2);
        localObject2 = localObject3;
        if (localObject1 != null) {
          localObject2 = ((JSONObject)localObject1).toString();
        }
        localBundle.putString("forward_ark_app_config", (String)localObject2);
        ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, DialogUtils.a((Context)localObject4, null, localBundle));
        ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).setNegativeButton(2131690728, null);
        ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).setPositiveButton(2131694583, null);
        ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0).show();
      }
    }
    else if (this.b.equals("card"))
    {
      localObject3 = new ArkAppMessage();
      ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
      ((ArkAppMessage)localObject3).appName = ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
      ((ArkAppMessage)localObject3).appView = this.d;
      localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
      if (localObject2 != null)
      {
        ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
        ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
      }
      if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
        ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
      }
      ((ArkAppMessage)localObject3).promptText = String.format(HardCodeUtil.a(2131700886), new Object[] { ((ArkAppMessage)localObject3).appDesc });
      ((ArkAppMessage)localObject3).metaList = this.c;
      localObject2 = localObject1;
      if (localObject1 != null) {}
    }
    try
    {
      localObject2 = new JSONObject();
      localObject1 = localObject2;
      ArkDebugChatPie.a((JSONObject)localObject2);
      localObject1 = localObject2;
      ((JSONObject)localObject2).put("type", "card");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException2)
    {
      label633:
      break label633;
    }
    ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a();
    if (localObject1 != null)
    {
      ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
      return;
      if (this.b.equals("fullscreen"))
      {
        if ((BaseActivity.sTopActivity instanceof BaseActivity))
        {
          localObject1 = BaseActivity.sTopActivity;
          ArkAppDataReport.a(null, ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
          ArkFullScreenAppActivity.a((Context)localObject1, ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0), this.d, "0.0.0.1", this.c, ArkAppCenterUtil.a(), null, 0);
        }
      }
      else if (this.b.equals("default"))
      {
        localObject3 = new ArkAppMessage();
        ((ArkAppMessage)localObject3).appMinVersion = "0.0.0.1";
        ((ArkAppMessage)localObject3).appName = ArkDebugChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0);
        ((ArkAppMessage)localObject3).appView = this.d;
        localObject2 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject3).appName, ((ArkAppMessage)localObject3).appMinVersion);
        if (localObject2 != null)
        {
          ((ArkAppMessage)localObject3).appDesc = ((String)((Map)localObject2).get("desc"));
          ((ArkAppMessage)localObject3).appMinVersion = ((String)((Map)localObject2).get("version"));
        }
        if (TextUtils.isEmpty(((ArkAppMessage)localObject3).appDesc)) {
          ((ArkAppMessage)localObject3).appDesc = ((ArkAppMessage)localObject3).appName;
        }
        ((ArkAppMessage)localObject3).promptText = String.format(HardCodeUtil.a(2131700882), new Object[] { ((ArkAppMessage)localObject3).appDesc });
        ((ArkAppMessage)localObject3).metaList = this.c;
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
    }
    try
    {
      localObject2 = new JSONObject();
      localObject1 = localObject2;
      ArkDebugChatPie.a((JSONObject)localObject2);
      localObject1 = localObject2;
      ((JSONObject)localObject2).put("type", "normal");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException3)
    {
      label973:
      break label973;
    }
    ((ArkAppMessage)localObject3).config = ((JSONObject)localObject1).toString();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0.a();
    if (localObject1 != null) {
      ArkDebugChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildArkDebugChatPie$1$1.a.this$0, (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject1, (ArkAppMessage)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4
 * JD-Core Version:    0.7.0.1
 */