package com.tencent.hippy.qq.module.tkd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import bcsc;
import bhcu;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pgv;
import pgw;
import tjg;

@HippyNativeModule(name="TKDCommentBizModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/module/tkd/TKDCommentBizModule;", "Lcom/tencent/hippy/qq/module/QQBaseLifecycleModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "commentPublisherPromise", "Lcom/tencent/mtt/hippy/modules/Promise;", "extraParams", "", "hippyCommentEvent", "com/tencent/hippy/qq/module/tkd/TKDCommentBizModule$hippyCommentEvent$1", "Lcom/tencent/hippy/qq/module/tkd/TKDCommentBizModule$hippyCommentEvent$1;", "buildCallbackInfo", "Lcom/tencent/mtt/hippy/common/HippyMap;", "resultCode", "", "errorCode", "comment", "(ILjava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mtt/hippy/common/HippyMap;", "buildCommentEditorIntent", "Landroid/content/Intent;", "params", "closeComment", "", "promise", "closeSubComment", "decodeQQEmotionString", "destroy", "getCurrentFontScaleFactor", "handleError", "msg", "t", "", "handleOnActivityResult", "data", "initialize", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResult", "requestCode", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onClickLike", "onCommentViewLayout", "onCreateComment", "onDeleteComment", "openComment", "openCommentPublisher", "openSubComment", "sendEventToJs", "eventName", "hippyMap", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule
  extends QQBaseLifecycleModule
{
  private static final String ARG_ANONYMOUS = "anonymous";
  private static final String ARG_ARTICLE_ID = "articleId";
  private static final String ARG_COMMENT = "comment";
  private static final String ARG_COMMENT_INFO = "commentInfo";
  private static final String ARG_COMMENT_TYPE = "commentType";
  private static final String ARG_CONTENT_SRC = "contentSrc";
  private static final String ARG_DEFAULT_TEXT = "defaultTxt";
  private static final String ARG_ERROR_CODE = "errorCode";
  private static final String ARG_EXTRA_PARAMS = "extraParam";
  private static final String ARG_FIRST_COMMENT_ID = "firstCommentId";
  private static final String ARG_HINT = "hint";
  private static final String ARG_IS_PGC_AUTHOR = "isPgcAuthor";
  private static final String ARG_MAX_TEXT_LIMIT = "maxTextLimit";
  private static final String ARG_PUBLISHER_CONFIG = "publisherConfig";
  private static final String ARG_REPLIED_SUB_AUTHOR_ID = "repliedSubAuthorId";
  private static final String ARG_REPLIED_SUB_COMMENT_ID = "repliedSubCommentId";
  private static final String ARG_REPLY_HAS_LINK = "replyHasLink";
  private static final String ARG_RESULT_CODE = "retCode";
  private static final String ARG_ROW_KEY = "rowKey";
  private static final String ARG_SCENE = "scene";
  private static final String ARG_SHOW_AT_ICON = "showAtIcon";
  private static final String ARG_SHOW_BIU_ICON = "showBiuIcon";
  private static final String ARG_SOURCE_TYPE = "sourceType";
  public static final TKDCommentBizModule.Companion Companion = new TKDCommentBizModule.Companion(null);
  private static final String EVENT_CLOSECOMMENT = "@comment:swipe";
  private static final String EVENT_CLOSECOMMENT_DIRECTION_RIGHT = "right";
  private static final String EVENT_CLOSECOMMENT_KEY_DIRECTION = "direction";
  private static final String EVENT_FONTSCALE = "@comment:onFontScaleChange";
  private static final String EVENT_FONTSCALE_SCALEFACTOR = "scaleFactor";
  private static final String EVENT_LIFECYCLE = "@common:lifecycle";
  private static final String EVENT_LIFECYCLE_KEY = "type";
  private static final String EVENT_ONACTIVE = "onActive";
  private static final String EVENT_ONDEACTIVE = "onDeactive";
  private static final String EVENT_ONDESTROY = "onDestroy";
  private static final String EVENT_ONSTART = "onStart";
  private static final int REQ_CODE_COMMENT_EDITOR_NATIVE = 117;
  private static final int RET_CODE_CANCELED = -2;
  private static final int RET_CODE_FAILED = -1;
  private static final int RET_CODE_SUCCEED = 0;
  private static final String TAG = "TKDCommentBizModule";
  private Promise commentPublisherPromise;
  private String extraParams;
  private final TKDCommentBizModule.hippyCommentEvent.1 hippyCommentEvent = new TKDCommentBizModule.hippyCommentEvent.1(this);
  
  public TKDCommentBizModule(@Nullable HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final HippyMap buildCallbackInfo(int paramInt, Integer paramInteger, String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("retCode", paramInt);
    if (paramInteger != null) {}
    for (paramInt = paramInteger.intValue();; paramInt = 0)
    {
      localHippyMap.pushInt("errorCode", paramInt);
      localHippyMap.pushString("comment", paramString);
      return localHippyMap;
    }
  }
  
  private final Intent buildCommentEditorIntent(HippyMap paramHippyMap)
  {
    Object localObject2 = paramHippyMap.getMap("commentInfo");
    Object localObject3 = paramHippyMap.getMap("publisherConfig");
    Assert.assertNotNull("commentInfo cannot be null", localObject2);
    Assert.assertNotNull("publisherConfig cannot be null", localObject3);
    paramHippyMap = ((HippyMap)localObject2).getString("rowKey");
    String str1;
    label58:
    Object localObject1;
    label72:
    String str2;
    label86:
    long l;
    int k;
    int m;
    label136:
    label180:
    boolean bool1;
    if (paramHippyMap != null)
    {
      str1 = ((HippyMap)localObject2).getString("articleId");
      if (str1 == null) {
        break label522;
      }
      localObject1 = ((HippyMap)localObject2).getString("firstCommentId");
      if (localObject1 == null) {
        break label530;
      }
      str2 = ((HippyMap)localObject2).getString("repliedSubCommentId");
      if (str2 == null) {
        break label538;
      }
      l = ((HippyMap)localObject2).getLong("repliedSubAuthorId");
      k = ((HippyMap)localObject2).getInt("scene");
      m = ((HippyMap)localObject2).getInt("contentSrc");
      boolean bool2 = ((HippyMap)localObject3).getBoolean("anonymous");
      localObject2 = ((HippyMap)localObject3).getString("hint");
      if (localObject2 == null) {
        break label546;
      }
      localObject2 = bhcu.decode((String)localObject2, 0);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64Util.decode(publis…: \"\", Base64Util.DEFAULT)");
      String str3 = new String((byte[])localObject2, Charsets.UTF_8);
      localObject2 = ((HippyMap)localObject3).getString("defaultTxt");
      if (localObject2 == null) {
        break label554;
      }
      localObject2 = bhcu.decode((String)localObject2, 0);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64Util.decode(publis…: \"\", Base64Util.DEFAULT)");
      String str4 = new String((byte[])localObject2, Charsets.UTF_8);
      int j = ((HippyMap)localObject3).getInt("maxTextLimit");
      i = j;
      if (j == 0) {
        i = -1;
      }
      boolean bool3 = ((HippyMap)localObject3).getBoolean("showAtIcon");
      if (!((HippyMap)localObject3).containsKey("showBiuIcon")) {
        break label562;
      }
      bool1 = ((HippyMap)localObject3).getBoolean("showBiuIcon");
      label254:
      boolean bool4 = ((HippyMap)localObject3).getBoolean("isPgcAuthor");
      j = ((HippyMap)localObject3).getInt("replyHasLink");
      int n = ((HippyMap)localObject3).getInt("sourceType");
      int i1 = ((HippyMap)localObject3).getInt("commentType");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      ((Intent)localObject2).putExtra("comment_type", false);
      ((Intent)localObject2).putExtra("arg_comment_enable_anonymous", bool2);
      ((Intent)localObject2).putExtra("arg_comment_placeholder", str3);
      ((Intent)localObject2).putExtra("arg_comment_default_txt", str4);
      ((Intent)localObject2).putExtra("arg_comment_max_length", i);
      ((Intent)localObject2).putExtra("arg_comment_open_at", bool3);
      ((Intent)localObject2).putExtra("comment_can_biu", bool1);
      if (((HippyMap)localObject3).containsKey("isPgcAuthor")) {
        ((Intent)localObject2).putExtra("comment_is_pgc_author", bool4);
      }
      ((Intent)localObject2).putExtra("comment_to_reply_contain_link", j);
      ((Intent)localObject2).putExtra("arg_comment_source_type", n);
      ((Intent)localObject2).putExtra("arg_comment_comment_type", i1);
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label568;
      }
    }
    label522:
    label530:
    label538:
    label546:
    label554:
    label562:
    label568:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label573;
      }
      localObject1 = new FirstCommentCreateData(m, "");
      ((FirstCommentCreateData)localObject1).b(paramHippyMap);
      ((FirstCommentCreateData)localObject1).c(str1);
      ((FirstCommentCreateData)localObject1).b(k);
      ((Intent)localObject2).putExtra("comment_create_data", (Parcelable)localObject1);
      return localObject2;
      paramHippyMap = "";
      break;
      str1 = "";
      break label58;
      localObject1 = "";
      break label72;
      str2 = "";
      break label86;
      localObject2 = "";
      break label136;
      localObject2 = "";
      break label180;
      bool1 = true;
      break label254;
    }
    label573:
    localObject3 = new SubCommentCreateData(m, "");
    ((SubCommentCreateData)localObject3).a((String)localObject1);
    ((SubCommentCreateData)localObject3).b(paramHippyMap);
    ((SubCommentCreateData)localObject3).c(str1);
    ((SubCommentCreateData)localObject3).a(l);
    ((SubCommentCreateData)localObject3).e(str2);
    ((SubCommentCreateData)localObject3).b(k);
    ((Intent)localObject2).putExtra("comment_create_data", (Parcelable)localObject3);
    return localObject2;
  }
  
  private final void handleError(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(' ');
    if (paramThrowable != null) {}
    for (paramString = paramThrowable.getMessage();; paramString = null)
    {
      QLog.e("TKDCommentBizModule", 1, paramString);
      return;
    }
  }
  
  @HippyMethod(name="closeComment")
  public final void closeComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    TKDCommentDispatcher.INSTANCE.getEvent().closeComment();
  }
  
  @HippyMethod(name="onSubCommentClose")
  public final void closeSubComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    TKDCommentDispatcher.INSTANCE.getEvent().onSubCommentClose();
  }
  
  @HippyMethod(name="decodeQQEmotionString")
  public final void decodeQQEmotionString(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramHippyMap = paramHippyMap.getString("text");
    if (paramHippyMap != null) {}
    for (;;)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("emotionText", bcsc.b(paramHippyMap));
      paramPromise.resolve(localHippyMap);
      return;
      paramHippyMap = "";
    }
  }
  
  public void destroy()
  {
    TKDCommentDispatcher.INSTANCE.removeEventListener((TKDCommentDispatcher.HippyCommentEvent)this.hippyCommentEvent);
  }
  
  @HippyMethod(name="getCurrentFontScaleFactor")
  public final void getCurrentFontScaleFactor(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramHippyMap = new HippyMap();
    paramHippyMap.pushDouble("scaleFactor", tjg.a().floatValue());
    paramPromise.resolve(paramHippyMap);
  }
  
  public final void handleOnActivityResult(int paramInt, @Nullable Intent paramIntent)
  {
    boolean bool = true;
    if ((paramInt == -1) && (paramIntent != null))
    {
      Object localObject3 = paramIntent.getParcelableExtra("comment_create_data");
      Object localObject1 = paramIntent.getStringExtra("arg_result_json");
      QLog.d("TKDCommentBizModule", 1, "handleOnActivityResult() --> commentData:" + localObject3 + " resultJsonStr:" + (String)localObject1);
      paramIntent = (JSONObject)null;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramIntent = (Intent)localObject1;
      }
      catch (JSONException localJSONException)
      {
        label266:
        label301:
        label306:
        do
        {
          for (;;)
          {
            handleError("handleOnActivityResult() json parse error!", (Throwable)localJSONException);
          }
          localObject2 = Base64.decode(paramIntent.optString("comment"), 0);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64.decode(jsonObject…omment\"), Base64.DEFAULT)");
          localObject4 = new String((byte[])localObject2, Charsets.UTF_8);
          paramIntent.optInt("feedsType");
          paramInt = paramIntent.optInt("biuAfterComment", 0);
          paramIntent = paramIntent.optJSONArray("linkList");
          if (paramIntent != null)
          {
            localObject2 = new TKDCommentBizModule.handleOnActivityResult.linkDataList.1.type.1().getType();
            paramIntent = (List)new Gson().fromJson(paramIntent.toString(), (Type)localObject2);
            if (paramIntent != null)
            {
              localObject2 = (pgw)new TKDCommentBizModule.handleOnActivityResult.observer.1(this);
              if (!(localObject3 instanceof FirstCommentCreateData)) {
                continue;
              }
              ((FirstCommentCreateData)localObject3).a((String)localObject4);
              ((FirstCommentCreateData)localObject3).a(paramIntent);
              localObject4 = pgv.a;
              localObject3 = (FirstCommentCreateData)localObject3;
              if (paramInt != 1) {
                break label301;
              }
              bool = true;
              paramIntent = this.extraParams;
              if (paramIntent == null) {
                break label306;
              }
            }
          }
          for (;;)
          {
            ((pgv)localObject4).a((FirstCommentCreateData)localObject3, (pgw)localObject2, bool, paramIntent);
            return;
            paramIntent = (List)new ArrayList();
            break;
            bool = false;
            break label266;
            paramIntent = "";
          }
        } while (!(localObject3 instanceof SubCommentCreateData));
        ((SubCommentCreateData)localObject3).d((String)localObject4);
        ((SubCommentCreateData)localObject3).a(paramIntent);
        localObject4 = pgv.a;
        localObject3 = (SubCommentCreateData)localObject3;
        if (paramInt != 1) {
          break label378;
        }
      }
      if (paramIntent == null) {
        return;
      }
      Object localObject4;
      paramIntent = this.extraParams;
      if (paramIntent != null) {}
      for (;;)
      {
        ((pgv)localObject4).a((SubCommentCreateData)localObject3, (pgw)localObject2, bool, paramIntent);
        return;
        label378:
        bool = false;
        break;
        paramIntent = "";
      }
    }
    paramIntent = this.commentPublisherPromise;
    if (paramIntent != null) {
      paramIntent.resolve(buildCallbackInfo$default(this, -2, null, null, 6, null));
    }
    QLog.d("TKDCommentBizModule", 1, "cancel comment");
  }
  
  public void initialize()
  {
    super.initialize();
    TKDCommentDispatcher.INSTANCE.addEventListener((TKDCommentDispatcher.HippyCommentEvent)this.hippyCommentEvent);
  }
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onStart");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onDestroy");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityPaused(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onDeactive");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityResult(@Nullable Activity paramActivity, int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onActivityResult.1(this, paramInt1, paramInt2, paramIntent));
  }
  
  public void onActivityResumed(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onActive");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityStarted(@Nullable Activity paramActivity) {}
  
  public void onActivityStopped(@Nullable Activity paramActivity) {}
  
  @HippyMethod(name="onClickLike")
  public final void onClickLike(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    String str1;
    label38:
    String str2;
    if (paramPromise != null)
    {
      str1 = paramHippyMap.getString("likeType");
      if (str1 == null) {
        break label88;
      }
      str2 = paramHippyMap.getString("commentId");
      if (str2 == null) {
        break label95;
      }
      label52:
      paramHippyMap = paramHippyMap.getString("seq");
      if (paramHippyMap == null) {
        break label103;
      }
    }
    for (;;)
    {
      TKDCommentDispatcher.INSTANCE.getEvent().onClickLike(paramPromise, str2, str1, paramHippyMap);
      return;
      paramPromise = "";
      break;
      label88:
      str1 = "";
      break label38;
      label95:
      str2 = "";
      break label52;
      label103:
      paramHippyMap = "";
    }
  }
  
  @HippyMethod(name="onCommentViewLayout")
  public final void onCommentViewLayout(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    TKDCommentDispatcher.INSTANCE.getEvent().onCommentViewLayout();
  }
  
  @HippyMethod(name="onCreateComment")
  public final void onCreateComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    String str1;
    label38:
    String str2;
    label52:
    String str3;
    label66:
    String str4;
    if (paramPromise != null)
    {
      str1 = paramHippyMap.getString("commentId");
      if (str1 == null) {
        break label120;
      }
      str2 = paramHippyMap.getString("commentContent");
      if (str2 == null) {
        break label127;
      }
      str3 = paramHippyMap.getString("level");
      if (str3 == null) {
        break label135;
      }
      str4 = paramHippyMap.getString("seq");
      if (str4 == null) {
        break label143;
      }
      label80:
      paramHippyMap = paramHippyMap.getString("parentCommentId");
      if (paramHippyMap == null) {
        break label151;
      }
    }
    for (;;)
    {
      TKDCommentDispatcher.INSTANCE.getEvent().onCreateComment(paramPromise, str1, str2, str3, str4, paramHippyMap);
      return;
      paramPromise = "";
      break;
      label120:
      str1 = "";
      break label38;
      label127:
      str2 = "";
      break label52;
      label135:
      str3 = "";
      break label66;
      label143:
      str4 = "";
      break label80;
      label151:
      paramHippyMap = "";
    }
  }
  
  @HippyMethod(name="onDeleteComment")
  public final void onDeleteComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    String str1;
    label38:
    String str2;
    if (paramPromise != null)
    {
      str1 = paramHippyMap.getString("commentId");
      if (str1 == null) {
        break label88;
      }
      str2 = paramHippyMap.getString("seq");
      if (str2 == null) {
        break label95;
      }
      label52:
      paramHippyMap = paramHippyMap.getString("totalDeleteCount");
      if (paramHippyMap == null) {
        break label103;
      }
    }
    for (;;)
    {
      TKDCommentDispatcher.INSTANCE.getEvent().onDeleteComment(paramPromise, str1, str2, paramHippyMap);
      return;
      paramPromise = "";
      break;
      label88:
      str1 = "";
      break label38;
      label95:
      str2 = "";
      break label52;
      label103:
      paramHippyMap = "";
    }
  }
  
  @HippyMethod(name="openComment")
  public final void openComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    TKDCommentDispatcher.INSTANCE.getEvent().openComment();
  }
  
  @HippyMethod(name="openCommentPublisher")
  public final void openCommentPublisher(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openCommentPublisher.1(this, paramHippyMap, paramPromise));
  }
  
  @HippyMethod(name="onSubCommentOpen")
  public final void openSubComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    TKDCommentDispatcher.INSTANCE.getEvent().onSubCommentOpen();
  }
  
  public final void sendEventToJs(@NotNull String paramString, @NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "hippyMap");
    QLog.d("TKDCommentBizModule", 1, "eventName:" + paramString + ",params:" + paramHippyMap);
    Object localObject = this.mContext;
    if (localObject != null)
    {
      localObject = ((HippyEngineContext)localObject).getModuleManager();
      if (localObject != null)
      {
        localObject = (EventDispatcher)((HippyModuleManager)localObject).getJavaScriptModule(EventDispatcher.class);
        if (localObject != null) {
          ((EventDispatcher)localObject).receiveNativeEvent(paramString, paramHippyMap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule
 * JD-Core Version:    0.7.0.1
 */