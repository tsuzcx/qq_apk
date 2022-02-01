package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJReadWatchWordShareContract.IModel;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJReadWatchWordShareContract.IView;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordPresenter;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWatchWordTopicJumpDialog;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWatchWordVideoJumpDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/RIJWatchWordShareManager;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "()V", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "privateTopicWatchWord", "getPrivateTopicWatchWord", "()Ljava/lang/String;", "privateVideoWatchWord", "getPrivateVideoWatchWord", "publicTopicWatchWord", "getPublicTopicWatchWord", "publicVideoWatchWord", "getPublicVideoWatchWord", "readPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "watchWordCount", "", "getWatchWordCount", "()I", "watchWordObserver", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/RIJWatchWordShareManager$OnWatchWordCheck;", "Lkotlin/collections/ArrayList;", "addWatchWordObserver", "", "observer", "clearClipBoard", "getAppearCount", "pattern", "master", "getClipWording", "watchWord", "isOpen", "", "type", "title", "getJumpUrlFromWatchWord", "getTextFromClipBoard", "callback", "Lkotlin/Function1;", "getWatchWordFromText", "text", "isRIJShareWatchWord", "jumpAction", "jumpUrl", "jumpToTargetPage", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "onAppForeground", "removeWatchWordObjserver", "reportClick", "popupType", "rowkey", "columnId", "uin", "", "clickType", "reportExpose", "saveWatchWord2JumpUrl", "Companion", "OnWatchWordCheck", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWatchWordShareManager
  implements IRIJReadWatchWordShareContract.IView
{
  public static final RIJWatchWordShareManager.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJWatchWordShareManager.Companion.instance.2.INSTANCE);
  private final int jdField_a_of_type_Int = 50;
  private final RIJReadWatchWordPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordPresenter = new RIJReadWatchWordPresenter((IRIJReadWatchWordShareContract.IModel)new RIJReadWatchWordModel());
  private final ArrayList<RIJWatchWordShareManager.OnWatchWordCheck> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedHashMap<String, String> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordRIJWatchWordShareManager$Companion = new RIJWatchWordShareManager.Companion(null);
  }
  
  public RIJWatchWordShareManager()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordPresenter.a((IRIJReadWatchWordShareContract.IView)this);
  }
  
  private final String a()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_topic_text", ReadInJoyUtils.a(2131718461));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_topic_text))");
    return str;
  }
  
  private final void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.a("Popup_type", Integer.valueOf(paramInt));
    if (paramInt == 0) {
      localReportR5Builder.a("rowkey", paramString1);
    }
    for (;;)
    {
      if (paramLong != 0L) {
        localReportR5Builder.a("uin", Long.valueOf(paramLong));
      }
      paramString1 = localReportR5Builder.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder.build()");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AEC6", paramString1);
      return;
      if (paramInt == 1) {
        localReportR5Builder.a("column_id", paramString2);
      }
    }
  }
  
  private final void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.a("Popup_type", Integer.valueOf(paramInt1));
    if (paramInt1 == 0) {
      localReportR5Builder.a("rowkey", paramString1);
    }
    for (;;)
    {
      if (paramLong != 0L) {
        localReportR5Builder.a("uin", Long.valueOf(paramLong));
      }
      localReportR5Builder.a("click_type", Integer.valueOf(paramInt2));
      paramString1 = localReportR5Builder.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "builder.build()");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AEC7", paramString1);
      return;
      if (paramInt1 == 1) {
        localReportR5Builder.a("column_id", paramString2);
      }
    }
  }
  
  private final void a(String paramString)
  {
    Object localObject = RIJWatchWordShareManager.jumpAction.1.INSTANCE;
    RIJWatchWordShareManager.jumpAction.2 local2 = RIJWatchWordShareManager.jumpAction.2.INSTANCE;
    switch (paramString.hashCode())
    {
    default: 
      if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"viola.qq.com", false, 2, null))
      {
        localObject = ReadInJoyUtils.a(2131692044);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getString…etail_page_by_watch_word)");
        local2.invoke((String)localObject);
      }
      break;
    }
    for (;;)
    {
      ReadInJoyUtils.a((Context)BaseActivity.sTopActivity, paramString);
      return;
      if (!paramString.equals("expired_or_deleted")) {
        break;
      }
      ((RIJWatchWordShareManager.jumpAction.1)localObject).invoke();
      paramString = ReadInJoyUtils.a(2131720635);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "ReadInJoyUtils.getString…g.watch_word_has_expired)");
      local2.invoke(paramString);
      return;
      localObject = ReadInJoyUtils.a(2131692045);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getString…video_page_by_watch_word)");
      local2.invoke((String)localObject);
    }
  }
  
  private final boolean a(String paramString)
  {
    String str = ReadInJoyUtils.a(2131719996);
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyUtils.getString….string.topic_watch_word)");
    if (a(str, paramString) != 1)
    {
      str = ReadInJoyUtils.a(2131720569);
      Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyUtils.getString….string.video_watch_word)");
      if (a(str, paramString) != 1) {}
    }
    else
    {
      str = ReadInJoyUtils.a(2131694226);
      Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyUtils.getString(R.string.mobile_phone_QQ)");
      if (a(str, paramString) == 1) {
        return true;
      }
    }
    return false;
  }
  
  private final String b()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_topic_text", ReadInJoyUtils.a(2131718459));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_topic_text))");
    return str;
  }
  
  private final String c()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_video_text", ReadInJoyUtils.a(2131718462));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_video_text))");
    return str;
  }
  
  private final String d()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_video_text", ReadInJoyUtils.a(2131718460));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_video_text))");
    return str;
  }
  
  public final int a(@NotNull String paramString1, @NotNull String paramString2)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramString1, "pattern");
    Intrinsics.checkParameterIsNotNull(paramString2, "master");
    int[] arrayOfInt = new int[paramString1.length() + 3];
    RIJWatchWordShareManager.getAppearCount.1 local1 = new RIJWatchWordShareManager.getAppearCount.1(arrayOfInt, paramString1);
    if (((CharSequence)paramString1).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)paramString2).length() != 0) {
          break label82;
        }
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label87;
      }
      return 0;
      i = 0;
      break;
    }
    label87:
    if ((paramString1.length() == 1) && (paramString2.length() == 1))
    {
      if (paramString1.charAt(0) == paramString2.charAt(0)) {
        return 1;
      }
      return 0;
    }
    local1.invoke();
    int i1 = ((CharSequence)paramString2).length();
    int j = 0;
    int n;
    for (int m = 0; k < i1; m = n)
    {
      while ((j > 0) && (paramString2.charAt(k) != paramString1.charAt(j))) {
        j = arrayOfInt[j];
      }
      i = j;
      if (paramString2.charAt(k) == paramString1.charAt(j)) {
        i = j + 1;
      }
      j = i;
      n = m;
      if (i == paramString1.length())
      {
        n = m + 1;
        j = arrayOfInt[i];
      }
      k += 1;
    }
    return m;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Object localObject = Aladdin.getConfig(296).getString("watch_word_separate_word", "$");
    CharSequence localCharSequence = (CharSequence)paramString;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "splitSymbol");
    localObject = StringsKt.split$default(localCharSequence, new String[] { localObject }, false, 0, 6, null);
    if ((a(paramString)) && (((List)localObject).size() >= 3)) {
      return (String)((List)localObject).get(1);
    }
    return "";
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, boolean paramBoolean, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "title");
    paramString1 = new RIJWatchWordShareManager.getClipWording.1(paramString2, paramString1);
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return paramString1.invoke(c());
      }
      return paramString1.invoke(d());
    }
    if (paramBoolean) {
      return paramString1.invoke(a());
    }
    return paramString1.invoke(b());
  }
  
  public final void a()
  {
    ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, (CharSequence)""));
    }
  }
  
  public final void a(@NotNull RIJWatchWordShareManager.OnWatchWordCheck paramOnWatchWordCheck)
  {
    Intrinsics.checkParameterIsNotNull(paramOnWatchWordCheck, "observer");
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnWatchWordCheck)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnWatchWordCheck);
    }
  }
  
  public void a(@NotNull String paramString, int paramInt, @Nullable RIJReadWatchWordModel.UserInfo paramUserInfo, @Nullable RIJReadWatchWordModel.VideoInfo paramVideoInfo, @Nullable RIJReadWatchWordModel.TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jumpUrl");
    QLog.i("RIJWatchWordShareManager", 1, "jumpUrl: " + paramString + " type: " + paramInt + " user name: " + paramUserInfo + "\nvideoInfo: " + paramVideoInfo + "\ntopicInfo " + paramTopicInfo);
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((BaseActivity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if ((localObject instanceof ViewGroup))
        {
          if ((paramInt != 1) || (paramVideoInfo == null) || (!(Intrinsics.areEqual(paramString, "expired_or_deleted") ^ true))) {
            break label240;
          }
          localObject = (ViewGroup)localObject;
          if (paramUserInfo == null) {
            break label226;
          }
          paramTopicInfo = paramUserInfo.a();
          if (paramTopicInfo == null) {
            break label226;
          }
          label157:
          new RIJWatchWordVideoJumpDialog((ViewGroup)localObject, paramTopicInfo, paramVideoInfo, (Function1)new RIJWatchWordShareManager.jumpToTargetPage.1(this, paramString, paramVideoInfo, paramUserInfo)).a();
          paramString = paramVideoInfo.c();
          if (paramUserInfo == null) {
            break label234;
          }
        }
      }
    }
    label226:
    label234:
    for (long l = paramUserInfo.a();; l = 0L)
    {
      a(0, paramString, "", l);
      a();
      return;
      localObject = null;
      break;
      paramTopicInfo = "";
      break label157;
    }
    label240:
    if ((paramInt == 2) && (paramTopicInfo != null) && ((Intrinsics.areEqual(paramString, "expired_or_deleted") ^ true)))
    {
      localObject = (ViewGroup)localObject;
      if (paramUserInfo != null)
      {
        paramVideoInfo = paramUserInfo.a();
        if (paramVideoInfo != null)
        {
          new RIJWatchWordTopicJumpDialog((ViewGroup)localObject, paramVideoInfo, paramTopicInfo, (Function1)new RIJWatchWordShareManager.jumpToTargetPage.2(this, paramString, paramTopicInfo, paramUserInfo)).a();
          paramString = paramTopicInfo.c();
          if (paramUserInfo == null) {
            break label353;
          }
        }
      }
      for (l = paramUserInfo.a();; l = 0L)
      {
        a(1, "", paramString, l);
        break;
        paramVideoInfo = "";
        break label284;
      }
    }
    label284:
    label353:
    DialogUtil.a(((ViewGroup)localObject).getContext(), 230, ReadInJoyUtils.a(2131718458), (CharSequence)ReadInJoyUtils.a(2131718457), HardCodeUtil.a(2131700815), "", null, (DialogInterface.OnClickListener)new RIJWatchWordShareManager.jumpToTargetPage.dialog.1(this, paramUserInfo)).show();
    if (paramUserInfo != null) {}
    for (l = paramUserInfo.a();; l = 0L)
    {
      a(2, "", "", l);
      break;
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 50) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(((Map.Entry)((Map)this.jdField_a_of_type_JavaUtilLinkedHashMap).entrySet().iterator().next()).getKey());
    }
    ((Map)this.jdField_a_of_type_JavaUtilLinkedHashMap).put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager
 * JD-Core Version:    0.7.0.1
 */