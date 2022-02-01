package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.ColumnSubscribeChangeObserver;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager;", "", "context", "Landroid/app/Activity;", "sessionId", "", "fromType", "", "dataList", "", "Lcom/tencent/biz/pubaccount/VideoInfo;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "columnDataManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "action", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/util/List;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;)V", "getAction", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "animFlagArray", "Landroid/util/SparseBooleanArray;", "animing", "", "getColumnDataManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "getContext", "()Landroid/app/Activity;", "getDataList", "()Ljava/util/List;", "getFromType", "()I", "interval", "lightLineLottie", "Lcom/tencent/biz/pubaccount/readinjoy/drawable/ReadInJoyLottieDrawable;", "onColumnSubscribeChangeObserver", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/managecolumn/ColumnSubscribeChangeObserver;", "playingHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "getSessionId", "()Ljava/lang/String;", "targetPercent", "", "getViolaTopicVideoParam", "Lorg/json/JSONObject;", "data", "videoInfo", "playingVideoHolder", "initView", "", "videoHolder", "jumpToColumnPlay", "videoFromType", "onCenterViewChanged", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "onColumnClick", "onDestory", "onProgressChanged", "currentPosMs", "", "durationMs", "onSubscribeBtnClick", "performAnim", "refreshColumnBanner", "refreshColumnData", "refreshColumnIcon", "videoColumnInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;", "refreshColumnText", "refreshFollowState", "updateAllSubscribeData", "columnId", "subscribed", "Companion", "IVideoColumnBannerAction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager
{
  public static final VideoColumnBannerManager.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private ReadInJoyLottieDrawable jdField_a_of_type_ComTencentBizPubaccountReadinjoyDrawableReadInJoyLottieDrawable;
  private final ColumnSubscribeChangeObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver;
  @Nullable
  private final VideoColumnBannerManager.IVideoColumnBannerAction jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager$IVideoColumnBannerAction;
  @NotNull
  private final VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  @NotNull
  private final VideoColumnDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager;
  private ShortVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager$Companion = new VideoColumnBannerManager.Companion(null);
  }
  
  public VideoColumnBannerManager(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter, @NotNull VideoColumnDataManager paramVideoColumnDataManager, @Nullable VideoColumnBannerManager.IVideoColumnBannerAction paramIVideoColumnBannerAction)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager = paramVideoColumnDataManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager$IVideoColumnBannerAction = paramIVideoColumnBannerAction;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver = ((ColumnSubscribeChangeObserver)new VideoColumnBannerManager.onColumnSubscribeChangeObserver.1(this));
    this.jdField_a_of_type_Int = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.jdField_a_of_type_Float = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "interval=" + this.jdField_a_of_type_Int + ", targetPercent=" + this.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDrawableReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDrawableReadInJoyLottieDrawable;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDrawableReadInJoyLottieDrawable;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != null)
    {
      ShortVideoItemHolder localShortVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      if (localShortVideoItemHolder != null)
      {
        int i = a(paramVideoInfo, localShortVideoItemHolder, 1, this.jdField_b_of_type_Int);
        paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.a).i(paramVideoInfo.g).M(0).a("load_page", Integer.valueOf(i)).a();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)RIJQQAppInterfaceUtil.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
      }
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label128:
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.a != null) && (localVideoInfo.a.jdField_a_of_type_Int == paramInt))
      {
        localVideoInfo.a.jdField_a_of_type_Boolean = paramBoolean;
        VideoColumnInfo localVideoColumnInfo;
        if (paramBoolean) {
          localVideoColumnInfo = localVideoInfo.a;
        }
        for (localVideoColumnInfo.jdField_c_of_type_Int += 1;; localVideoColumnInfo.jdField_c_of_type_Int -= 1)
        {
          if (!(Intrinsics.areEqual(paramVideoInfo, localVideoInfo) ^ true)) {
            break label128;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(localVideoInfo);
          break;
          localVideoColumnInfo = localVideoInfo.a;
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder = paramShortVideoItemHolder.f();
    if (paramShortVideoItemHolder != null)
    {
      if (!paramVideoColumnInfo.jdField_a_of_type_Boolean) {
        break label44;
      }
      paramShortVideoItemHolder.setTextColor(-7829368);
      paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131716047));
      paramShortVideoItemHolder.setBackgroundResource(2130843275);
    }
    for (;;)
    {
      return;
      label44:
      paramShortVideoItemHolder.setTextColor(-1);
      paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131716069));
      paramShortVideoItemHolder.setBackgroundResource(2130843196);
    }
  }
  
  private final void a(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder.a().inflate();
    Object localObject = paramShortVideoItemHolder.p;
    if (localObject != null)
    {
      localObject = (ViewGroup)((ViewGroup)localObject).findViewById(2131381358);
      paramShortVideoItemHolder.a((ViewGroup)localObject);
      localObject = paramShortVideoItemHolder.p;
      if (localObject == null) {
        break label224;
      }
    }
    label224:
    for (localObject = (KandianUrlImageView)((ViewGroup)localObject).findViewById(2131381352);; localObject = null)
    {
      paramShortVideoItemHolder.a((KandianUrlImageView)localObject);
      localObject = paramShortVideoItemHolder.b();
      if (localObject != null)
      {
        paramShortVideoItemHolder.b((TextView)((ViewGroup)localObject).findViewById(2131381367));
        paramShortVideoItemHolder.a((TextView)((ViewGroup)localObject).findViewById(2131381369));
        paramShortVideoItemHolder.a((URLImageView)((ViewGroup)localObject).findViewById(2131381350));
        paramShortVideoItemHolder.b(((ViewGroup)localObject).findViewById(2131381374));
        paramShortVideoItemHolder.b((ViewGroup)((ViewGroup)localObject).findViewById(2131381331));
        paramShortVideoItemHolder.a((ImageView)((ViewGroup)localObject).findViewById(2131381347));
        paramShortVideoItemHolder.c((TextView)((ViewGroup)localObject).findViewById(2131381366));
        paramShortVideoItemHolder.d((TextView)((ViewGroup)localObject).findViewById(2131381368));
        paramShortVideoItemHolder.b((URLImageView)((ViewGroup)localObject).findViewById(2131381349));
        paramShortVideoItemHolder.e((TextView)((ViewGroup)localObject).findViewById(2131381370));
        paramShortVideoItemHolder.b((ImageView)((ViewGroup)localObject).findViewById(2131381348));
      }
      return;
      localObject = null;
      break;
    }
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    String str = paramVideoColumnInfo.jdField_c_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    int i;
    if (((CharSequence)str).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      i = ViewUtils.a(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.jdField_c_of_type_JavaLangString, i, i);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, ViewUtils.a(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(URLDrawableDecodeHandler.k);
      paramShortVideoItemHolder = paramShortVideoItemHolder.c();
      if (paramShortVideoItemHolder != null) {
        paramShortVideoItemHolder.setImageDrawable((Drawable)paramVideoColumnInfo);
      }
    }
    label115:
    do
    {
      return;
      i = 0;
      break;
      paramVideoColumnInfo = paramShortVideoItemHolder.c();
    } while (paramVideoColumnInfo == null);
    paramVideoColumnInfo.setImageDrawable(null);
  }
  
  private final void b(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject = paramShortVideoItemHolder.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
      localObject = paramShortVideoItemHolder.b();
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label67;
      }
    }
    label67:
    for (int j = 1;; j = 0)
    {
      if ((!this.jdField_a_of_type_Boolean) && (i != 0) && (j == 0)) {
        break label72;
      }
      return;
      i = 0;
      break;
    }
    label72:
    this.jdField_a_of_type_Boolean = true;
    localObject = ValueAnimator.ofInt(new int[] { ViewUtils.a(34.0F), ViewUtils.a(50.0F) }).setDuration(200L);
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.1(this, paramShortVideoItemHolder));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.2(this, paramShortVideoItemHolder));
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.a(40.0F), ViewUtils.a(58.0F) }).setDuration(400L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.3(paramShortVideoItemHolder, (ValueAnimator)localObject));
    localValueAnimator.addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.4(paramShortVideoItemHolder, (ValueAnimator)localObject));
    localValueAnimator.start();
    VideoFeedsHelper.a((View)paramShortVideoItemHolder.b(), 8, (int)400L);
    VideoFeedsHelper.a(paramShortVideoItemHolder.b(), 0, (int)500L);
  }
  
  private final void c(VideoInfo paramVideoInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    int i = 1;
    Object localObject2 = paramVideoInfo.a;
    boolean bool;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      int j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label232;
      }
      bool = true;
      localObject1 = paramVideoInfo.a;
      if (localObject1 == null) {
        break label238;
      }
      localObject1 = ((VideoColumnInfo)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject1 == null) {
        break label238;
      }
      label59:
      VideoFeedsHelper.a(localQQAppInterface, j, bool, (String)localObject1);
      j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label246;
      }
      bool = true;
      label88:
      a(paramVideoInfo, j, bool);
      a((VideoColumnInfo)localObject2, paramShortVideoItemHolder);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label252;
      }
      label112:
      ReadInJoyLogicEngineEventDispatcher.a().a(((VideoColumnInfo)localObject2).jdField_a_of_type_Int, i, ((VideoColumnInfo)localObject2).jdField_c_of_type_Int);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label257;
      }
      paramShortVideoItemHolder = "0X800A7FB";
      label141:
      localObject2 = new VideoR5.Builder(paramVideoInfo);
      localObject1 = RIJQQAppInterfaceUtil.a();
      if (localObject1 == null) {
        break label264;
      }
    }
    label257:
    label264:
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentUin();; localObject1 = null)
    {
      paramVideoInfo = ((VideoR5.Builder)localObject2).m((String)localObject1).b(paramVideoInfo.a).ab(4).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)RIJQQAppInterfaceUtil.a(), "", paramShortVideoItemHolder, paramShortVideoItemHolder, 0, 0, "", "", "", paramVideoInfo.a(), false);
      return;
      label232:
      bool = false;
      break;
      label238:
      localObject1 = "";
      break label59;
      label246:
      bool = false;
      break label88;
      label252:
      i = 2;
      break label112;
      paramShortVideoItemHolder = "0X800A7D3";
      break label141;
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject1 = paramShortVideoItemHolder.b();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.i);
    }
    localObject1 = paramShortVideoItemHolder.c();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.jdField_b_of_type_JavaLangString);
    }
    if ((paramVideoColumnInfo.jdField_a_of_type_Boolean) && (paramVideoColumnInfo.f > 0))
    {
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718109);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.f);
        paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      }
      paramVideoColumnInfo = paramShortVideoItemHolder.e();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setText((CharSequence)null);
      }
    }
    do
    {
      do
      {
        return;
        if (!paramVideoColumnInfo.jdField_a_of_type_Boolean) {
          break;
        }
        localObject1 = paramShortVideoItemHolder.d();
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)(HardCodeUtil.a(2131716047) + "  "));
        }
        paramShortVideoItemHolder = paramShortVideoItemHolder.e();
      } while (paramShortVideoItemHolder == null);
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718110);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
      paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      paramShortVideoItemHolder.setText((CharSequence)paramVideoColumnInfo);
      return;
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)null);
      }
      paramShortVideoItemHolder = paramShortVideoItemHolder.e();
    } while (paramShortVideoItemHolder == null);
    localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718111);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
    Object localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
    localObject2[1] = VideoFeedsHelper.e(paramVideoColumnInfo.jdField_c_of_type_Int);
    paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
    paramShortVideoItemHolder.setText((CharSequence)paramVideoColumnInfo);
  }
  
  public final int a(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "playingVideoHolder");
    if (paramVideoInfo.a != null)
    {
      VideoColumnBannerManager.IVideoColumnBannerAction localIVideoColumnBannerAction = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager$IVideoColumnBannerAction;
      if (localIVideoColumnBannerAction != null) {
        localIVideoColumnBannerAction.a();
      }
      if ((PlayerHelper.a.a()) && (ReadInJoyHelper.f(paramInt2)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager.a(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramShortVideoItemHolder, paramVideoInfo, paramInt1, paramInt2));
        return 2;
      }
      ViolaAccessHelper.a((Context)this.jdField_a_of_type_AndroidAppActivity, "", "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=" + paramVideoInfo.g + "&topicId=" + String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), null);
      return 1;
    }
    return 1;
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "playingVideoHolder");
    JSONObject localJSONObject = new JSONObject();
    paramString = localJSONObject.put("columnData", paramString);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager;
    VideoColumnInfo localVideoColumnInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(localVideoColumnInfo, "videoInfo.videoColumnInfo");
    paramString.put("columnInfo", ((VideoColumnDataManager)localObject).a(localVideoColumnInfo));
    int i = paramShortVideoItemHolder.d;
    localObject = VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity);
    paramString = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, i);
    float f = 750.0F / localObject[0];
    localObject = new JSONObject();
    ((JSONObject)localObject).put("x", paramString.left * f);
    ((JSONObject)localObject).put("y", paramString.top * f);
    ((JSONObject)localObject).put("width", paramString.width() * f);
    ((JSONObject)localObject).put("height", paramString.height() * f);
    localJSONObject.put("videoFromFrame", localObject);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "onFlingRToL: rect=" + paramString);
    }
    paramString = paramShortVideoItemHolder.a;
    long l;
    if (paramString != null)
    {
      paramString = paramString.a;
      if (paramString != null) {
        paramString.d();
      }
      if (paramString == null) {
        break label366;
      }
      l = paramString.a();
      label268:
      if (paramString == null) {
        break label372;
      }
      paramString = paramString.c();
      label277:
      localJSONObject.put("sessionId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("videoToken", paramString);
      if (!PlayerHelper.a.a()) {
        break label377;
      }
    }
    label366:
    label372:
    label377:
    for (i = 1;; i = 0)
    {
      localJSONObject.put("isSuperPlayer", i);
      localJSONObject.put("videoArticleModel", MultiVideoHelper.a(paramVideoInfo, null));
      localJSONObject.put("startPlayTime", l);
      localJSONObject.put("fromType", paramInt);
      return localJSONObject;
      paramString = null;
      break;
      l = 0L;
      break label268;
      paramString = null;
      break label277;
    }
  }
  
  public final void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject = paramShortVideoItemHolder.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      localObject = paramVideoInfo.a;
      if ((localObject == null) || (((VideoColumnInfo)localObject).e != 2) || (i != 0)) {
        break label71;
      }
      b(paramVideoInfo, paramShortVideoItemHolder);
    }
    label71:
    do
    {
      return;
      i = 0;
      break;
      localObject = paramVideoInfo.a;
    } while ((localObject == null) || (((VideoColumnInfo)localObject).e != 2));
    paramVideoInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
    a(paramVideoInfo, paramShortVideoItemHolder);
  }
  
  public final void a(@NotNull VideoItemHolder paramVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    if (!(paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      paramVideoItemHolder = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder = ((ShortVideoItemHolder)paramVideoItemHolder);
      paramVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      if (paramVideoItemHolder != null)
      {
        paramVideoItemHolder = paramVideoItemHolder.a();
        if (paramVideoItemHolder != null) {
          paramVideoItemHolder.setVisibility(8);
        }
      }
      paramVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsShortVideoItemHolder;
      if (paramVideoItemHolder != null)
      {
        paramVideoItemHolder = paramVideoItemHolder.a();
        if (paramVideoItemHolder != null) {
          paramVideoItemHolder.setImageDrawable((Drawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDrawableReadInJoyLottieDrawable);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public final void a(@NotNull VideoItemHolder paramVideoItemHolder, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    int i = paramVideoItemHolder.jdField_b_of_type_Int;
    if ((ReadInJoyHelper.g(this.jdField_b_of_type_Int)) && (i == 0)) {}
    for (;;)
    {
      return;
      if (!(paramVideoItemHolder instanceof ShortVideoItemHolder)) {}
      for (VideoItemHolder localVideoItemHolder = null; (ShortVideoItemHolder)localVideoItemHolder != null; localVideoItemHolder = paramVideoItemHolder)
      {
        if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i / this.jdField_a_of_type_Int)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(i / this.jdField_a_of_type_Int, true);
          b((ShortVideoItemHolder)paramVideoItemHolder);
        }
        return;
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject1 = paramVideoInfo.a;
    if ((localObject1 != null) && (((VideoColumnInfo)localObject1).e == 2))
    {
      if (paramShortVideoItemHolder.b() == null) {
        a(paramShortVideoItemHolder);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null)
      {
        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.a(40.0F);
        }
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.1(this, paramVideoInfo));
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.2(this, paramVideoInfo, paramShortVideoItemHolder));
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.c();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null)
      {
        localObject1 = ((TextView)localObject1).getLayoutParams();
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject1 != null) {
          ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ViewUtils.a(34.0F);
        }
        localObject1 = paramShortVideoItemHolder.d();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = paramShortVideoItemHolder.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = paramShortVideoItemHolder.a();
        if (localObject1 != null) {
          ((KandianUrlImageView)localObject1).setVisibility(8);
        }
        localObject1 = paramShortVideoItemHolder.c();
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = paramShortVideoItemHolder.b();
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-1186049);
        }
        localObject1 = paramShortVideoItemHolder.c();
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-1186049);
        }
        localObject1 = paramShortVideoItemHolder.b();
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(2130843307);
        }
        localObject1 = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
        c((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
        localObject1 = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
        b((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
        paramVideoInfo = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
        a(paramVideoInfo, paramShortVideoItemHolder);
        VideoFeedsHelper.a((View)paramShortVideoItemHolder.b(), 200);
      }
    }
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
      } while (paramShortVideoItemHolder.b() == null);
      paramVideoInfo = paramShortVideoItemHolder.b();
    } while (paramVideoInfo == null);
    paramVideoInfo.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager
 * JD-Core Version:    0.7.0.1
 */