package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFeed;
import UserGrowth.stLive;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WSFeedUtils
{
  public static int a = 1;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[@#]\\w+", 2);
  public static boolean a = false;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "[em]e212[/em]", "[em]e219[/em]", "[em]e226[/em]", "[em]e233[/em]", "[em]e234[/em]", "[em]e221[/em]", "[em]e228[/em]", "[em]e208[/em]", "[em]e222[/em]", "[em]e229[/em]", "[em]e223[/em]", "[em]e230[/em]", "[em]e240[/em]", "[em]e224[/em]", "[em]e231[/em]", "[em]e211[/em]", "[em]e218[/em]", "[em]e225[/em]", "[em]e232[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e256[/em]", "[em]e261[/em]", "[em]e259[/em]", "[em]e235[/em]", "[em]e236[/em]", "[em]e239[/em]" };
  
  public static int a(float paramFloat)
  {
    return ScreenUtil.dip2px(paramFloat);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      return 2130851267;
    case 5: 
      return 2130851265;
    case 3: 
      return 2130851264;
    }
    return 2130851266;
  }
  
  public static int a(int paramInt, stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    if ((paramstMetaUgcVideoSeg != null) && (paramstMetaUgcVideoSeg.width != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getClippedVideoHeight] width: ");
      localStringBuilder.append(paramstMetaUgcVideoSeg.width);
      localStringBuilder.append(", height: ");
      localStringBuilder.append(paramstMetaUgcVideoSeg.height);
      WSLog.b("WSFeedUtils", localStringBuilder.toString());
      if (paramstMetaUgcVideoSeg.height > paramstMetaUgcVideoSeg.width) {
        return paramInt * 4 / 3;
      }
      return paramInt * paramstMetaUgcVideoSeg.height / paramstMetaUgcVideoSeg.width;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getClippedVideoHeight] ");
    if (paramstMetaUgcVideoSeg == null) {
      paramstMetaUgcVideoSeg = "video is null";
    } else {
      paramstMetaUgcVideoSeg = "video width is zero";
    }
    localStringBuilder.append(paramstMetaUgcVideoSeg);
    WSLog.d("WSFeedUtils", localStringBuilder.toString());
    return paramInt * 4 / 3;
  }
  
  public static int a(View paramView)
  {
    Rect localRect = new Rect();
    if (paramView.getLocalVisibleRect(localRect)) {
      return localRect.height() * 100 / paramView.getHeight();
    }
    return -1;
  }
  
  public static stSimpleMetaFeed a(List<stSimpleMetaFeed> paramList)
  {
    int i = paramList.size() - 1;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i < 0) {
        break;
      }
      localObject2 = (stSimpleMetaFeed)paramList.get(i);
      if (((stSimpleMetaFeed)localObject2).video_type != 2)
      {
        if (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject2).feed_desc)) {
          break;
        }
        localObject1 = localObject2;
      }
      i -= 1;
    }
    return localObject2;
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static Drawable a(int paramInt)
  {
    return a().getResources().getDrawable(paramInt);
  }
  
  public static SpannableStringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SpannableStringBuilder(paramString1).append("：").append(a(paramString2));
    new WSFeedUtils.3(paramString3);
    paramString3 = new StyleSpan(1);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-16777216);
    paramString2.setSpan(paramString3, 0, paramString1.length() + 1, 33);
    paramString2.setSpan(localForegroundColorSpan, 0, paramString1.length() + 1, 33);
    a(paramString2);
    return paramString2;
  }
  
  public static WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 9;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(1);
    localWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      paramCharSequence = paramCharSequence.toString().replace(str, "");
      i += 1;
    }
    return paramCharSequence;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feed create time: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", corresponding date: ");
    localStringBuilder.append(new Date(paramInt * 1000));
    WSLog.b("WSFeedUtils", localStringBuilder.toString());
    long l = System.currentTimeMillis() / 1000L - paramInt;
    localStringBuilder = new StringBuilder();
    if ((l >= 0L) && (l < 60L)) {
      return b(2131693499);
    }
    if ((l >= 60L) && (l < 3600L))
    {
      localStringBuilder.append(l / 60L);
      localStringBuilder.append(b(2131693500));
      return localStringBuilder.toString();
    }
    if ((l >= 3600L) && (l < 86400L))
    {
      localStringBuilder.append(l / 3600L);
      localStringBuilder.append(b(2131693498));
      return localStringBuilder.toString();
    }
    if ((l >= 86400L) && (l < 2592000L))
    {
      localStringBuilder.append(l / 86400L);
      localStringBuilder.append(b(2131693494));
      return localStringBuilder.toString();
    }
    localStringBuilder.append(30);
    localStringBuilder.append(b(2131693494));
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(BaseApplicationImpl.getApplication().getString(paramInt), paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(2131693501);
    }
    return str;
  }
  
  public static List<WSVideoPreDownloadManager.VideoPreDownloadParam> a(List<stFeed> paramList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    if (paramBoolean)
    {
      i = paramInt + 1;
      paramInt = i;
      while (paramInt < i + 3)
      {
        a(localArrayList, paramList, paramInt);
        paramInt += 1;
      }
    }
    int i = paramInt - 1;
    paramInt = i;
    while (paramInt > i - 3)
    {
      a(localArrayList, paramList, paramInt);
      paramInt -= 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    WSSharePreferencesUtil.a("key_player_mute_guide_show", true);
  }
  
  public static void a(int paramInt, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView.getVisibility() != paramInt) {
        localView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt)
  {
    a(paramActivity, paramstSchema, paramInt, 0, "");
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt1, int paramInt2, String paramString)
  {
    if (paramstSchema == null) {
      return;
    }
    int i = paramstSchema.type;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        WeishiActivityHelper.a(paramActivity, paramstSchema.H5Url);
        return;
      }
      a(paramActivity, paramstSchema.schema, paramInt1, paramInt2, paramString);
      return;
    }
    WeishiActivityHelper.a(paramActivity, paramstSchema.miniAppSchema, null);
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt, String paramString)
  {
    a(paramActivity, paramstSchema, paramInt);
    if (paramstSchema.type == 1)
    {
      if (TextUtils.equals(paramString, WeishiUtils.d()))
      {
        WeishiUtils.c("homepage_main");
        return;
      }
      WeishiUtils.c("homepage_guest");
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[openWeishiViaScheme] scheme: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", eventId: ");
    ((StringBuilder)localObject).append(paramInt1);
    WSLog.b("WSFeedUtils", ((StringBuilder)localObject).toString());
    if (paramActivity == null) {
      return;
    }
    localObject = a(paramString1, paramInt1);
    if (WeishiGuideUtils.a(paramActivity))
    {
      OuterInterceptManager.a(paramActivity, new WSFeedUtils.4(paramActivity, paramString1, (WSDownloadParams)localObject, paramString2, paramInt2));
      return;
    }
    WeishiDownloadUtil.a(paramActivity, (WSDownloadParams)localObject, true);
  }
  
  public static void a(Context paramContext, ActionSheet.OnButtonClickListener paramOnButtonClickListener, ActionSheet.OnDismissListener paramOnDismissListener)
  {
    paramContext = ActionSheet.create(paramContext);
    paramContext.addButton("取消关注", 3);
    paramContext.addCancelButton("取消");
    paramContext.setOnButtonClickListener(new WSFeedUtils.1(paramOnButtonClickListener, paramContext));
    paramContext.setOnDismissListener(new WSFeedUtils.2(paramOnDismissListener));
    paramContext.show();
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramSpannableStringBuilder);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      String str = paramSpannableStringBuilder.subSequence(i, j).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("subStr:");
      localStringBuilder.append(str);
      WSLog.c("WSFeedUtils", localStringBuilder.toString());
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
    }
  }
  
  public static void a(View.OnClickListener paramOnClickListener, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(paramOnClickListener);
      }
      i += 1;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    if (paramTextView != null)
    {
      if (paramBoolean) {
        return;
      }
      paramTextView.setVisibility(0);
      paramInt = a(paramInt);
      if (paramInt == -1)
      {
        paramTextView.setVisibility(8);
        return;
      }
      paramTextView.setBackgroundResource(paramInt);
    }
  }
  
  private static void a(List<WSVideoPreDownloadManager.VideoPreDownloadParam> paramList, List<stFeed> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (stFeed)paramList1.get(paramInt);
      if (paramList1.feed == null) {
        return;
      }
      paramList.add(WSVerticalUtils.a(paramList1.feed));
    }
  }
  
  public static boolean a()
  {
    return WSSharePreferencesUtil.a("key_player_mute_guide_show", false);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramstSimpleMetaPerson != null)
    {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.live;
      if (paramstSimpleMetaPerson == null) {
        return false;
      }
      bool1 = bool2;
      if (paramstSimpleMetaPerson.status == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static int b(int paramInt)
  {
    return a().getResources().getColor(paramInt);
  }
  
  public static String b(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getString(paramInt);
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils
 * JD-Core Version:    0.7.0.1
 */