package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import nxu;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import osb;

public class ReadInJoyLockScreenJumpDelegate
  extends IphoneTitleBarFragment
{
  private static int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("jump_content_page", 0);
  }
  
  @NonNull
  public static Intent a(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = ors.a();
    if (localObject == null)
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: app is null");
      return b(paramContext, paramInt1, paramInt2);
    }
    localObject = (KandianMergeManager)((QQAppInterface)localObject).getManager(162);
    String str = a(((KandianMergeManager)localObject).b());
    Log.i("ReadInJoyLockScreenJump", "generateIntent: extraInfo=" + str);
    if (TextUtils.isEmpty(str))
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: extraInfo is null");
      return b(paramContext, paramInt1, paramInt2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if (localJSONObject.optInt("jump_daily_channel", 0) == 1) {
        i = 1;
      }
      if (i != 0)
      {
        QLog.i("ReadInJoyLockScreenJump", 1, "getLockScreenJumpIntent: routed to daily fragment");
        return a(paramContext, paramInt1, ((KandianMergeManager)localObject).a());
      }
      i = c(localJSONObject);
      int j = b(localJSONObject);
      if ((i != 0) && (j != 0))
      {
        QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: jump to LockScreenDelegate");
        localObject = a(paramContext, str, paramInt1, paramInt2);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "getLockScreenJumpIntent: ", localJSONException);
    }
    return b(paramContext, paramInt1, paramInt2);
  }
  
  public static Intent a(Context paramContext, int paramInt, KandianRedDotInfo paramKandianRedDotInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", ReadInJoyDailyFragment.class.getName());
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    localIntent.setFlags(603979776);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("daily_lock_screen_flag", true);
    localIntent.putExtra("daily_lock_screen_param", true);
    if (paramKandianRedDotInfo == null) {
      QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent redDotInfo is null !");
    }
    do
    {
      return localIntent;
      if ((TextUtils.isEmpty(paramKandianRedDotInfo.extInfo)) && (paramKandianRedDotInfo.hasArticleID()))
      {
        QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent redDotInfo.extInfo is empty !");
        localIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
        localIntent.putExtra("daily_lock_screen_report_red_info", paramKandianRedDotInfo);
        return localIntent;
      }
      localIntent.putExtra("return_scene", 1);
      try
      {
        paramContext = new JSONObject(paramKandianRedDotInfo.extInfo);
        localIntent.putExtra("daily_lock_screen_report_red_info", paramKandianRedDotInfo);
        if (a(paramContext))
        {
          a(paramContext, paramKandianRedDotInfo, localIntent);
          a(paramContext, localIntent);
          return localIntent;
        }
      }
      catch (JSONException paramContext)
      {
        QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent parse json error: ", paramContext);
        return localIntent;
      }
    } while (a(paramContext) != 1);
    b(paramContext, paramKandianRedDotInfo, localIntent);
    return localIntent;
  }
  
  @NonNull
  private static Intent a(@NonNull Context paramContext, @NonNull String paramString, int paramInt1, int paramInt2)
  {
    paramContext = new Intent(paramContext, PublicFragmentActivity.class);
    paramContext.putExtra("public_fragment_class", ReadInJoyLockScreenJumpDelegate.class.getName());
    paramContext.setFlags(268435456);
    paramContext.setFlags(603979776);
    paramContext.putExtra("launch_from", paramInt1);
    paramContext.putExtra("arg_channel_cover_id", paramInt2);
    paramContext.putExtra("public_fragment_window_feature", 1);
    paramContext.putExtra("key_struct_msg", paramString);
    return paramContext;
  }
  
  private static String a(@Nullable MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null)) {
      return ((MessageForStructing)paramMessageRecord).structingMsg.mExtraData;
    }
    return null;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("channel_id", String.valueOf(0));
  }
  
  private void a()
  {
    QLog.i("ReadInJoyLockScreenJump", 1, "doJumpAction");
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = localFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("key_struct_msg");
    int i = localIntent.getIntExtra("launch_from", 0);
    int j = localIntent.getIntExtra("arg_channel_cover_id", 0);
    QLog.i("ReadInJoyLockScreenJump", 1, "doJumpAction: extraInfo=" + str);
    try
    {
      a(localFragmentActivity, new JSONObject(str), i, j);
      ors.g();
      getActivity().finish();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyLockScreenJump", 1, "doJumpAction: exception thrown", localJSONException);
      }
    }
  }
  
  public static void a(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("jumpType", 0))
    {
    default: 
      QLog.i("ReadInJoyLockScreenJump", 1, "handleLockScreenJumpType do nothing!");
      return;
    case 2: 
      b(paramActivity, paramIntent);
      return;
    }
    c(paramActivity, paramIntent);
  }
  
  private void a(@NonNull Context paramContext, @NonNull JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (bjxj.k())
    {
      localIntent = new Intent(paramContext, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("launch_from", 9);
      localIntent.putExtra("tab_index", MainFragment.i);
      localIntent.putExtra("open_kandian_tab_fragment", true);
      localIntent.setFlags(335544320);
      localIntent.putExtra("arg_channel_cover_id", paramInt2);
      localIntent.putExtra("kan_dian_lock_screen_flag", true);
      localIntent.putExtra("kan_dian_lock_screen_param", true);
      localIntent.putExtra("return_scene", 2);
      ors.a(true);
      osb.a(localIntent);
      a(paramJSONObject, localIntent);
      paramContext.startActivity(localIntent);
      QLog.d("ReadInJoyLockScreenJump", 1, "launchReadInJoyTab, from:" + paramInt1);
      return;
    }
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    localIntent.putExtra("tab_tab_index", 0);
    localIntent.putExtra("kan_dian_lock_screen_flag", true);
    localIntent.putExtra("launch_from", 9);
    localIntent.putExtra("kan_dian_lock_screen_flag", true);
    localIntent.putExtra("kan_dian_lock_screen_param", true);
    ors.a(true);
    osb.a(localIntent);
    a(paramJSONObject, localIntent);
    paramContext.startActivity(localIntent);
    QLog.d("ReadInJoyLockScreenJump", 1, "launch NewFeedsActivity from:" + paramInt1);
  }
  
  private static void a(@NonNull JSONObject paramJSONObject, @NonNull Intent paramIntent)
  {
    paramIntent.putExtra("jumpType", b(paramJSONObject));
    paramIntent.putExtra("contentType", c(paramJSONObject));
    paramIntent.putExtra("pushRowKey", b(paramJSONObject));
    paramIntent.putExtra("articleUrl", c(paramJSONObject));
    paramIntent.putExtra("topicId", d(paramJSONObject));
  }
  
  private static void a(@NonNull JSONObject paramJSONObject, @NonNull KandianRedDotInfo paramKandianRedDotInfo, @NonNull Intent paramIntent)
  {
    int i = b(paramJSONObject);
    if (((i == 1) || (i == 0)) && (paramKandianRedDotInfo.hasArticleID())) {
      paramIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
    }
    if ((paramKandianRedDotInfo.hasArticleID()) && (paramKandianRedDotInfo.articleIDList.size() > 0)) {
      paramIntent.putExtra("daily_lock_screen_article_report_article_id", (Serializable)paramKandianRedDotInfo.articleIDList.get(0));
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool1 = true;
    if (ors.a(paramMessageRecord))
    {
      paramMessageRecord = a(paramMessageRecord);
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord);
          int i = c(paramMessageRecord);
          int j = b(paramMessageRecord);
          if (j == 3)
          {
            if (GesturePWDUtils.isAppOnForeground(BaseApplicationImpl.getContext())) {
              break label96;
            }
            return true;
          }
          if (j == 2)
          {
            if (i == 2)
            {
              boolean bool2 = GesturePWDUtils.isAppOnForeground(BaseApplicationImpl.getContext());
              if (!bool2) {
                break label94;
              }
            }
            return false;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          QLog.e("ReadInJoyLockScreenJump", 1, "shouldBlockLockScreenRedDot: ", paramMessageRecord);
        }
      }
    }
    bool1 = false;
    label94:
    return bool1;
    label96:
    return false;
  }
  
  private static boolean a(@NonNull JSONObject paramJSONObject)
  {
    int i = b(paramJSONObject);
    int j = c(paramJSONObject);
    switch (i)
    {
    default: 
    case 2: 
      do
      {
        return false;
      } while ((j != 1) && (j != 2));
      return true;
    }
    return true;
  }
  
  private static int b(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("jumpType", 0);
  }
  
  @NonNull
  private static Intent b(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("fragment_id", 1);
    paramContext.putExtra("launch_from", paramInt1);
    paramContext.putExtra("tab_index", MainFragment.i);
    paramContext.putExtra("open_kandian_tab_fragment", true);
    paramContext.putExtra("arg_channel_cover_id", paramInt2);
    paramContext.setFlags(335544320);
    ors.a(true);
    osb.a(paramContext);
    return paramContext;
  }
  
  private static String b(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("push_rowkey", null);
  }
  
  private static void b(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("contentType", 0);
    if (i == 1)
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "doJumpAction: openVideoFeeds, rowKey=" + paramIntent.getStringExtra("pushRowKey"));
      nxu.b(paramActivity, paramIntent);
      return;
    }
    if (i == 2)
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "doJumpAction: openVideoFeeds, rowKey=" + paramIntent.getStringExtra("pushRowKey"));
      nxu.a(paramActivity, paramIntent);
      return;
    }
    QLog.d("ReadInJoyLockScreenJump", 1, "doJumpAction: contentType: " + i);
  }
  
  private static void b(@NonNull JSONObject paramJSONObject, @NonNull KandianRedDotInfo paramKandianRedDotInfo, @NonNull Intent paramIntent)
  {
    int i = Integer.parseInt(a(paramJSONObject));
    paramIntent.putExtra("arg_channel_cover_id", i);
    if (paramKandianRedDotInfo.hasArticleID())
    {
      paramIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
      if (paramKandianRedDotInfo.articleIDList.size() > 0)
      {
        paramIntent.putExtra("jump_article_param_ids", (Serializable)paramKandianRedDotInfo.articleIDList.get(0));
        paramIntent.putExtra("jump_activity_launch_from", 0);
        paramIntent.putExtra("jump_activity_launch_channel_id", i);
      }
    }
  }
  
  private static int c(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("contentType", 0);
  }
  
  private static String c(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("articleUrl", null);
  }
  
  private static void c(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    int i = 2;
    int j = paramIntent.getIntExtra("contentType", 0);
    if (j == 1) {
      i = 1;
    }
    for (;;)
    {
      nxu.a(paramActivity, paramIntent, i);
      QLog.d("ReadInJoyLockScreenJump", 1, "handle lock screen floating window   businessType=" + i);
      return;
      if (j != 2) {
        if (j == 3)
        {
          i = 3;
        }
        else if (j == 4)
        {
          i = 4;
        }
        else
        {
          QLog.d("ReadInJoyLockScreenJump", 1, "handle lock screen floating layer unknown contentType!");
          i = -1;
        }
      }
    }
  }
  
  private static String d(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("topicId", null);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate
 * JD-Core Version:    0.7.0.1
 */