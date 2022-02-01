package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.phonecontact.data.PhoneInfo;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class NewerGuidePlugin$1
  extends OnRemoteRespObserver
{
  NewerGuidePlugin$1(NewerGuidePlugin paramNewerGuidePlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == NewerGuidePlugin.a(this.a).key) && ("ipc_newer_guide".equals(paramBundle.getString("cmd")))) {}
    for (;;)
    {
      try
      {
        localObject2 = paramBundle.getBundle("request");
        ((Bundle)localObject2).setClassLoader(RecommendedListResp.class.getClassLoader());
        paramBundle = ((Bundle)localObject2).getString("key_action");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onResponse action=");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.d("NewerGuidePlugin", 2, ((StringBuilder)localObject1).toString());
        }
        boolean bool = "uploadContacts".equals(paramBundle);
        localObject1 = null;
        if (bool)
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", ((Bundle)localObject2).getInt("result"));
          this.a.callJs("respUploadContacts", new String[] { paramBundle.toString() });
          break label1152;
        }
        if ("getRecommendedList".equals(paramBundle))
        {
          paramBundle = new JSONObject();
          localObject2 = ((Bundle)localObject2).getString("op_result");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramBundle.put("result", new JSONArray((String)localObject2));
          }
          this.a.callJs("respRecommend", new String[] { paramBundle.toString() });
          break label1152;
        }
        Object localObject3;
        int i;
        Object localObject4;
        Object localObject5;
        if ("getRecommendedListNew".equals(paramBundle))
        {
          localObject3 = (RecommendedListResp)((Bundle)localObject2).getParcelable("result");
          if (localObject3 == null) {
            i = -1;
          } else {
            i = ((RecommendedListResp)localObject3).jdField_a_of_type_Int;
          }
          paramBundle = new JSONObject();
          paramBundle.put("result", i);
          if (i == 0)
          {
            paramBundle.put("uint32_end", ((RecommendedListResp)localObject3).b);
            paramBundle.put("uint32_next_index", ((RecommendedListResp)localObject3).jdField_a_of_type_Long);
            localObject4 = ((RecommendedListResp)localObject3).jdField_a_of_type_JavaUtilList;
            if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
            {
              localObject3 = new JSONArray();
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (PhoneInfo)((Iterator)localObject4).next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("str_phone", ((PhoneInfo)localObject5).a);
                localJSONObject.put("str_nick", ((PhoneInfo)localObject5).b);
                localJSONObject.put("str_long_nick", ((PhoneInfo)localObject5).c);
                localJSONObject.put("str_head_url", ((PhoneInfo)localObject5).d);
                ((JSONArray)localObject3).put(localJSONObject);
                continue;
              }
              paramBundle.put("phoneAddrBook", localObject3);
            }
          }
          this.a.callJs(((Bundle)localObject2).getString("callback"), new String[] { paramBundle.toString() });
          break label1152;
        }
        bool = "sayHi".equals(paramBundle);
        if (bool)
        {
          paramBundle = ((Bundle)localObject2).getString("uin");
          localObject3 = ((Bundle)localObject2).getByteArray("sig");
          localObject4 = ((Bundle)localObject2).getString("nick");
          localObject2 = ((Bundle)localObject2).getString("tinyId");
          if ((!TextUtils.isEmpty(paramBundle)) && (localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            localObject5 = new Intent(this.a.mRuntime.a(), ChatActivity.class);
            ((Intent)localObject5).addFlags(67108864);
            ((Intent)localObject5).putExtra("uin", paramBundle);
            ((Intent)localObject5).putExtra("uintype", 1001);
            ((Intent)localObject5).putExtra("aio_msg_source", 999);
            ((Intent)localObject5).putExtra("rich_accost_sig", (byte[])localObject3);
            ((Intent)localObject5).putExtra("uinname", (String)localObject4);
            ((Intent)localObject5).putExtra("from_newer_guide", true);
            ((Intent)localObject5).putExtra("tinyId", (String)localObject2);
            this.a.startActivityForResult((Intent)localObject5, (byte)8);
            break label1152;
          }
          localObject1 = String.valueOf(localObject2);
          paramBundle = "respSayHi";
        }
        else
        {
          if ("joinTroop".equals(paramBundle))
          {
            paramBundle = ((Bundle)localObject2).getString("uin");
            localObject3 = ((Bundle)localObject2).getString("name");
            short s = ((Bundle)localObject2).getShort("option");
            localObject4 = ((Bundle)localObject2).getString("question");
            localObject5 = ((Bundle)localObject2).getString("answer");
            localObject2 = ((Bundle)localObject2).getString("authSig");
            if (s == 0) {
              break label1138;
            }
            paramBundle = AddFriendLogicActivity.a(this.a.mRuntime.a(), paramBundle, (String)localObject3, s, 1, (String)localObject4, (String)localObject5, null, null, (String)localObject2);
            paramBundle.putExtra("from_newer_guide", true);
            this.a.startActivityForResult(paramBundle, (byte)6);
            break label1152;
          }
          if ("joinTroopByTap".equals(paramBundle))
          {
            i = ((Bundle)localObject2).getInt("result");
            paramBundle = ((Bundle)localObject2).getString("uin");
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("uin", paramBundle);
            ((JSONObject)localObject2).put("result", i);
            this.a.callJs("respTroopByTap", new String[] { ((JSONObject)localObject2).toString() });
            break label1152;
          }
          if ("followPublicAccount".equals(paramBundle))
          {
            i = ((Bundle)localObject2).getInt("result");
            paramBundle = ((Bundle)localObject2).getString("uin");
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("uin", paramBundle);
            ((JSONObject)localObject2).put("result", i);
            this.a.callJs("respFollow", new String[] { ((JSONObject)localObject2).toString() });
            break label1152;
          }
          if (!"setAvatar".equals(paramBundle)) {
            break label1152;
          }
          if (((Bundle)localObject2).getInt("result") == 1)
          {
            paramBundle = ((Bundle)localObject2).getString("path");
            NewerGuidePlugin.a(this.a, true, paramBundle);
          }
          else
          {
            paramBundle = this.a.mRuntime.a();
            i = paramBundle.getResources().getDimensionPixelSize(2131299168);
            QQToast.a(paramBundle, 1, HardCodeUtil.a(2131707464), 0).b(i);
          }
          if (NewerGuidePlugin.a(this.a) == null) {
            break label1152;
          }
          NewerGuidePlugin.a(this.a).dismiss();
          break label1152;
        }
        if ((localObject1 != null) && (paramBundle != null))
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("uin", localObject1);
          ((JSONObject)localObject2).put("result", 0);
          this.a.callJs(paramBundle, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.d("NewerGuidePlugin", 1, "mOnRemoteResp fail", paramBundle);
      }
      return;
      label1138:
      Object localObject2 = "respTroop";
      Object localObject1 = paramBundle;
      paramBundle = (Bundle)localObject2;
      continue;
      label1152:
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.1
 * JD-Core Version:    0.7.0.1
 */