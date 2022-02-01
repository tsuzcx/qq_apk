package com.tencent.biz.expand.flutter.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.expand.ui.ExpandBirthPickFragment;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/router/ExpandRouter;", "Lcom/tencent/biz/expand/flutter/router/BaseRouter;", "()V", "getRouterName", "", "jumpToAnonymous", "", "jumpToFeaturePhoto", "jumpToPage", "pageName", "pageUri", "Landroid/net/Uri;", "jumpToPersonalLabel", "jumpToStickyNote", "openRouterPath", "urlParams", "", "", "exts", "showBirthDayDialog", "date", "", "(Ljava/lang/Integer;)V", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandRouter
  extends BaseRouter
{
  public static final ExpandRouter.Companion a = new ExpandRouter.Companion(null);
  
  private final void a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null)
    {
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null)
      {
        localObject1 = ((AppRuntime)localObject1).getAccount();
        if (localObject1 == null) {}
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.context;
      if (localBaseApplication != null)
      {
        Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
        Object localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = new Object[2];
        localObject2[0] = localObject1;
        localObject2[1] = Integer.valueOf(1);
        localObject1 = String.format("https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d", Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        localIntent.putExtra("url", (String)localObject1);
        localIntent.setFlags(268435456);
        localBaseApplication.startActivity(localIntent);
      }
      return;
      localObject1 = "";
    }
    localObject1 = LogUtils.a;
    QLog.e("ExpandRouter", 1, "jump photo stickynote account is null", (Throwable)null);
  }
  
  private final void a(Integer paramInteger)
  {
    Intent localIntent = new Intent();
    if (paramInteger != null) {}
    for (int i = paramInteger.intValue();; i = 0)
    {
      localIntent.putExtra("birth_date", i);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.setFlags(268435456);
      QPublicTransFragmentActivity.b((Context)BaseApplicationImpl.context, localIntent, ExpandBirthPickFragment.class);
      return;
    }
  }
  
  private final void a(String paramString, Uri paramUri)
  {
    if (paramString == null) {}
    label44:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            paramUri = LogUtils.a;
            if (QLog.isColorLevel()) {
              QLog.d("ExpandRouter", 2, "jump to " + paramString + " not notImplemented");
            }
            return;
            switch (paramString.hashCode())
            {
            }
          }
        } while (!paramString.equals("anonymous"));
        a();
        return;
      } while (!paramString.equals("personal_label"));
      d();
      return;
    } while (!paramString.equals("personal_label_edit"));
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = paramString.getRuntime();
      if (paramString != null)
      {
        paramString = paramString.getAccount();
        if (paramString == null) {}
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label304;
      }
      paramUri = BaseApplicationImpl.context;
      if (paramUri == null) {
        break label44;
      }
      Intent localIntent = new Intent((Context)paramUri, PersonalityLabelGalleryActivity.class);
      localIntent.putExtra("uin", paramString);
      localIntent.setFlags(268435456);
      paramUri.startActivity(localIntent);
      return;
      if (!paramString.equals("msg_list_setting")) {
        break;
      }
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramUri = BaseApplicationImpl.context;
      if (paramUri == null) {
        break label44;
      }
      PublicFragmentActivity.a((Context)paramUri, paramString, MatchChatSettingFragment.class);
      return;
      if (!paramString.equals("feature_photo")) {
        break;
      }
      c();
      return;
      if (!paramString.equals("stickynote")) {
        break;
      }
      b();
      return;
      paramString = "";
    }
    label304:
    paramString = LogUtils.a;
    QLog.e("ExpandRouter", 1, "jump personal_label_edit error account is null", (Throwable)null);
  }
  
  private final void b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null) {}
    }
    for (long l = ((AppRuntime)localObject).getLongAccountUin(); l != 0L; l = 0L)
    {
      localObject = BaseApplicationImpl.context;
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("key_host_uin", l);
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.putExtras(localBundle);
        PublicFragmentActivity.Launcher.a((Context)localObject, localIntent, PublicFragmentActivity.class, StickyNotePublishFragment.class);
      }
      return;
    }
    localObject = LogUtils.a;
    QLog.e("ExpandRouter", 1, "jump photo stickynote account is null", (Throwable)null);
  }
  
  private final void c()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null)
      {
        localObject = ((AppRuntime)localObject).getAccount();
        if (localObject == null) {}
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.context;
      if (localBaseApplication != null)
      {
        localObject = "https://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + (String)localObject;
        Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("url", (String)localObject);
        localIntent.setFlags(268435456);
        localBaseApplication.startActivity(localIntent);
      }
      return;
      localObject = "";
    }
    localObject = LogUtils.a;
    QLog.e("ExpandRouter", 1, "jump photo error account is null", (Throwable)null);
  }
  
  private final void d()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null)
      {
        localObject = ((AppRuntime)localObject).getAccount();
        if (localObject == null) {}
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.context;
      if (localBaseApplication != null)
      {
        Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
        localIntent.putExtra("url", Constants.c);
        localIntent.putExtra("uin", (String)localObject);
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
        localIntent.putExtra("fromProfile", false);
        localIntent.setFlags(268435456);
        localBaseApplication.startActivity(localIntent);
      }
      return;
      localObject = "";
    }
    localObject = LogUtils.a;
    QLog.e("ExpandRouter", 1, "jump personal_label error account is null", (Throwable)null);
  }
  
  @NotNull
  public String a()
  {
    return "expand";
  }
  
  public void a(@NotNull Uri paramUri, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Intrinsics.checkParameterIsNotNull(paramUri, "pageUri");
    String str = paramUri.getPath();
    if (str == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                paramMap1 = LogUtils.a;
                if (QLog.isColorLevel()) {
                  QLog.d("ExpandRouter", 2, "native router " + paramUri + " not support");
                }
                do
                {
                  return;
                  switch (str.hashCode())
                  {
                  default: 
                    break;
                  case -675666397: 
                    if (!str.equals("/edit_profile")) {
                      break;
                    }
                    paramUri = BaseApplicationImpl.context;
                  }
                } while (paramUri == null);
                paramMap1 = new Intent();
                paramMap1.setFlags(268435456);
                PublicFragmentActivity.Launcher.a((Context)paramUri, paramMap1, PublicFragmentActivity.class, ExtendFriendEditFragment.class);
                return;
              } while (!str.equals("/birth_dialog"));
              paramMap1 = paramUri.getQueryParameter("date");
              paramUri = localObject1;
              if (paramMap1 != null) {
                paramUri = Integer.valueOf(Integer.parseInt(paramMap1));
              }
              a(paramUri);
              return;
            } while (!str.equals("/main"));
            paramMap2 = (Context)BaseApplicationImpl.context;
            paramUri = localObject2;
            if (paramMap1 != null) {
              paramUri = paramMap1.get("type");
            }
            ExtendFriendPublicFragmentActivity.a(paramMap2, 4, false, (String)paramUri);
            return;
          } while (!str.equals("/jump"));
          a(paramUri.getQueryParameter("page"), paramUri);
          return;
        } while (!str.equals("/voiceMatch"));
        LimitChatUtil.a((Context)BaseApplicationImpl.context, (HashMap)paramMap2);
        return;
      } while (!str.equals("/conversation"));
      MatchChatMsgListFragment.a((Context)BaseApplicationImpl.context, 2);
      return;
    } while (!str.equals("/aio"));
    if (paramMap1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any?> /* = java.util.HashMap<kotlin.String, kotlin.Any?> */");
    }
    LimitChatUtil.a(paramUri, (Map)paramMap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.router.ExpandRouter
 * JD-Core Version:    0.7.0.1
 */