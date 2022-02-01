package com.tencent.biz.pubaccount.readinjoy.ipc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadInJoyIPCModule
  extends QIPCModule
{
  private static volatile ReadInJoyIPCModule a;
  
  private ReadInJoyIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ReadInJoyIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ReadInJoyIPCModule("ReadInJoyIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("uinList");
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateUserInfo] uinList: ");
      Iterator localIterator = paramBundle.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append(", ");
      }
      QLog.i("ReadInJoyIPCModule", 1, localStringBuilder.toString());
      ReadInJoyUserInfoModule.a(paramBundle);
      return;
    }
    QLog.i("ReadInJoyIPCModule", 1, "[updateUserInfo] uin list is empty.");
  }
  
  private void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_native_channel_id", 0);
    int j = paramBundle.getInt("key_native_channel_change_order", 0);
    String str = paramBundle.getString("key_native_channel_name", "");
    int k = paramBundle.getInt("key_native_channel_type", 0);
    boolean bool = paramBundle.getBoolean("key_native_channel_is_push", false);
    int m = paramBundle.getInt("key_channel_source_from", -1);
    Object localObject = paramBundle.getString("key_channel_jump_scheme", "");
    QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel] native channel jump, channelID = " + i + ", changeChannelOrder = " + j + ", channelName = " + str + ", channelType = " + k + ", isPush = " + bool + ", sourceFrom = " + m + ", scheme = " + (String)localObject);
    if (j == 1) {
      ReadInJoyLogicEngine.a().b(i, m);
    }
    if (BaseActivity.sTopActivity == null) {}
    for (paramBundle = BaseApplicationImpl.getContext(); paramBundle == null; paramBundle = BaseActivity.sTopActivity)
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], context is null.");
      return;
    }
    if (ReadInJoyDailyJumpToKDTabUtils.a(paramBundle, (String)localObject))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to recommend channel, using floating window.");
      return;
    }
    if (ReadInJoyAdUtils.a(paramBundle, (String)localObject, i))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to mini game channel");
      return;
    }
    if (bool) {}
    for (localObject = "1"; ReadInJoyChannelGuidingJumpUtils.a((String)localObject, i); localObject = "0")
    {
      ReadInJoyActivityHelper.a(paramBundle, i, str, k, 4);
      return;
    }
    localObject = ReadInJoyActivityHelper.b(paramBundle, 0, i);
    if (!(paramBundle instanceof BaseActivity)) {
      ((Intent)localObject).setFlags(268435456);
    }
    paramBundle.startActivity((Intent)localObject);
  }
  
  protected void a(Bundle paramBundle, int paramInt)
  {
    ReadInJoyUserInfoModule.a(paramBundle.getLong("uin"), new ReadInJoyIPCModule.2(this, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = true;
    if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      QLog.i("ReadInJoyIPCModule", 1, "[onCall], runtime is not QQAppInterface.");
    }
    label240:
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!"action_native_channel_jump".equals(paramString)) {
              break;
            }
          } while (paramBundle == null);
          b(paramBundle);
          return null;
          if (!"action_viola_fragment_jump".equals(paramString)) {
            break;
          }
        } while (paramBundle == null);
        String str = paramBundle.getString("key_viola_fragment_jump_url", "");
        paramInt = paramBundle.getInt("key_native_channel_id", 0);
        if (ReadInJoyChannelGuidingJumpUtils.a(Uri.parse(str).getQueryParameter("ispush"), paramInt)) {
          try
          {
            if (str.contains("v_url_base64")) {}
            for (paramString = JumpAction.c(Uri.parse(str).getQueryParameter("v_url_base64")); BaseActivity.sTopActivity == null; paramString = URLDecoder.decode(Uri.parse(str).getQueryParameter("v_url"), "utf-8"))
            {
              paramBundle = BaseApplicationImpl.getContext();
              ViolaAccessHelper.a(paramBundle, null, paramString, null);
              return null;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("ReadInJoyIPCModule", 1, "call viola page error = " + paramString.getMessage());
              paramString = null;
              continue;
              paramBundle = BaseActivity.sTopActivity;
            }
          }
        }
        paramInt = paramBundle.getInt("key_native_channel_change_order", 0);
        if (BaseActivity.sTopActivity == null)
        {
          paramString = BaseApplicationImpl.getContext();
          if (paramInt != 1) {
            break label240;
          }
        }
        for (;;)
        {
          ReadInJoyChannelGuidingJumpUtils.a(paramString, str, bool);
          return null;
          paramString = BaseActivity.sTopActivity;
          break;
          bool = false;
        }
        if ("action_update_biu_and_comment_switch_action".equals(paramString))
        {
          bool = RIJBiuAndCommentAladdinUtils.a();
          paramString = new Bundle();
          paramString.putBoolean("action_update_biu_and_comment_switch", bool);
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
        if (!"action_update_biu_and_comment_request_action".equals(paramString)) {
          break;
        }
        paramString = (Intent)paramBundle.getParcelable("action_update_biu_and_comment_request");
      } while (paramString == null);
      paramBundle = new RIJBiuAndCommentMixDataManager();
      UiApiPlugin.a(paramString, paramBundle, paramString.getStringExtra("arg_callback"), new ReadInJoyIPCModule.1(this, paramInt, paramBundle));
      return null;
      if ("action_get_user_info_action".equals(paramString))
      {
        a(paramBundle, paramInt);
        return null;
      }
      if ("action_get_app_type_action".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putInt("action_get_app_type", ReadinjoyReportUtils.c());
        callbackResult(paramInt, EIPCResult.createResult(0, paramString));
        return null;
      }
    } while (!"action_update_user_info".equals(paramString));
    a(paramBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ipc.ReadInJoyIPCModule
 * JD-Core Version:    0.7.0.1
 */