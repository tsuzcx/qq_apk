package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class VideoFeedsUGView
  extends RelativeLayout
  implements View.OnClickListener, DownloadListener
{
  public static VideoFeedsUGDownloadListener a;
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoInfo.UGDownloadInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo;
  String jdField_a_of_type_JavaLangString;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  ImageView c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGDownloadListener = new VideoFeedsUGDownloadListener();
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    setOnClickListener(this);
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setOnClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, getResources()), AIOUtils.a(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(95.0F, getResources()), AIOUtils.a(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = AIOUtils.a(4.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(3);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = AIOUtils.a(6.0F, getResources());
    localLayoutParams.leftMargin = AIOUtils.a(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.c = new ImageView(paramContext);
    this.c.setPadding(AIOUtils.a(4.0F, getResources()), AIOUtils.a(4.0F, getResources()), AIOUtils.a(4.0F, getResources()), AIOUtils.a(4.0F, getResources()));
    this.c.setOnClickListener(new VideoFeedsUGView.1(this));
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(16.0F, getResources()), AIOUtils.a(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = AIOUtils.a(4.0F, getResources());
    this.c.setLayoutParams(paramContext);
    addView(this.c, paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(SharedPreUtils.b("ug_prefix_ug_1get3_ug_show_time")))
    {
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, 0);
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, 0);
    }
    if (DateUtils.isToday(SharedPreUtils.b("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    if (SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if (SharedPreUtils.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 1) && (PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j)))
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 2) && (!PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j)))
    {
      setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, SharedPreUtils.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) + 1);
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "2", this.jdField_a_of_type_JavaLangString));
    }
    setVisibility(0);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 2)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    DownloadInfo localDownloadInfo;
    for (;;)
    {
      b();
      invalidate();
      return;
      localDownloadInfo = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f);
      if (localDownloadInfo != null) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (localDownloadInfo.a() == 4) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.m);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = localDownloadInfo.f;
      break;
      if ((localDownloadInfo.a() == 20) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.k + localDownloadInfo.f + "%");
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.l);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.e));
      label25:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.d, (URLDrawable.URLDrawableOptions)localObject);
      this.c.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.jdField_c_of_type_Int == 2)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_kandian_videos");
        ((Intent)localObject).setData(Uri.parse(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.g));
        if (VideoFeedsHelper.a(getContext(), (Intent)localObject)) {
          getContext().startActivity((Intent)localObject);
        }
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "7", this.jdField_a_of_type_JavaLangString));
        SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) + 1);
        continue;
      }
      Object localObject = new VideoFeedsUGDownloadListener.UGClickData();
      ((VideoFeedsUGDownloadListener.UGClickData)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f;
      ((VideoFeedsUGDownloadListener.UGClickData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i;
      ((VideoFeedsUGDownloadListener.UGClickData)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGDownloadListener.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j, (VideoFeedsUGDownloadListener.UGClickData)localObject);
      DownloadManagerV2.a().a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGDownloadListener);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.h;
      try
      {
        ((ClipboardManager)getContext().getSystemService("clipboard")).setText((CharSequence)localObject);
        label254:
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "3", this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f);
        if (localObject == null)
        {
          localObject = new DownloadInfo();
          ((DownloadInfo)localObject).d = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f;
          ((DownloadInfo)localObject).m = "biz_src_kandian_videos";
          ((DownloadInfo)localObject).e = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j;
          DownloadManagerV2.a().b((DownloadInfo)localObject);
          SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) + 1);
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "9", this.jdField_a_of_type_JavaLangString));
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "10", this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.k + "0%");
          this.jdField_a_of_type_Int = 0;
          continue;
        }
        if (((DownloadInfo)localObject).a() == 4)
        {
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "102", this.jdField_a_of_type_JavaLangString));
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "20", this.jdField_a_of_type_JavaLangString));
          if (!DownloadManagerV2.a().a((DownloadInfo)localObject)) {
            DownloadManagerV2.a().b((DownloadInfo)localObject);
          }
          SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) + 1);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.m);
          continue;
        }
        if ((((DownloadInfo)localObject).a() == 30) || (((DownloadInfo)localObject).a() == 10) || (((DownloadInfo)localObject).a() == 20) || (((DownloadInfo)localObject).a() == 1) || (((DownloadInfo)localObject).a() == 2))
        {
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "22", this.jdField_a_of_type_JavaLangString));
          DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.l);
          continue;
        }
        DownloadManagerV2.a().b((DownloadInfo)localObject);
        SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n, SharedPreUtils.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.n) + 1);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "10", this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.k + ((DownloadInfo)localObject).f + "%");
        this.jdField_a_of_type_Int = ((DownloadInfo)localObject).f;
      }
      catch (Throwable localThrowable)
      {
        break label254;
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.5(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.7(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.4(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.2(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.6(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.3(this, paramDownloadInfo));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo != null) && (this.jdField_a_of_type_Int != 0))
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), AIOUtils.a(14.0F, getResources()), AIOUtils.a(14.0F, getResources()), Path.Direction.CW);
      }
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth() * this.jdField_a_of_type_Int / 100.0F, getHeight());
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845631);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadManagerV2.a().a(this);
      a(true);
      return;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public void setInfo(VideoInfo.UGDownloadInfo paramUGDownloadInfo, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo = paramUGDownloadInfo;
    a(false);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.9(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */