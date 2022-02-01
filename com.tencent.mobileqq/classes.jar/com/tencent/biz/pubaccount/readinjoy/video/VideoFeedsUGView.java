package com.tencent.biz.pubaccount.readinjoy.video;

import afur;
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
import bgnw;
import bgsg;
import bisa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;
import ocb;
import ogc;
import ryx;
import seh;
import sei;
import sej;

public class VideoFeedsUGView
  extends RelativeLayout
  implements View.OnClickListener, DownloadListener
{
  public static seh a;
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String a;
  public ocb a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  ImageView c;
  
  static
  {
    jdField_a_of_type_Seh = new seh();
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
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(afur.a(24.0F, getResources()), afur.a(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = afur.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(afur.a(95.0F, getResources()), afur.a(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = afur.a(4.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(3);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = afur.a(6.0F, getResources());
    localLayoutParams.leftMargin = afur.a(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.c = new ImageView(paramContext);
    this.c.setPadding(afur.a(4.0F, getResources()), afur.a(4.0F, getResources()), afur.a(4.0F, getResources()), afur.a(4.0F, getResources()));
    this.c.setOnClickListener(new sej(this));
    paramContext = new RelativeLayout.LayoutParams(afur.a(16.0F, getResources()), afur.a(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = afur.a(4.0F, getResources());
    this.c.setLayoutParams(paramContext);
    addView(this.c, paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ocb == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(bgsg.b("ug_prefix_ug_1get3_ug_show_time")))
    {
      bgsg.a("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n, 0);
      bgsg.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Ocb.n, 0);
    }
    if (DateUtils.isToday(bgsg.b("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    if (bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n) >= this.jdField_a_of_type_Ocb.jdField_a_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if (bgsg.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Ocb.n) >= this.jdField_a_of_type_Ocb.jdField_b_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 1) && (bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ocb.j)))
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 2) && (!bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ocb.j)))
    {
      setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      bgsg.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Ocb.n, bgsg.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Ocb.n) + 1);
      ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "2", this.jdField_a_of_type_JavaLangString));
    }
    setVisibility(0);
    if (this.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 2)
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
      localDownloadInfo = bisa.a().b(this.jdField_a_of_type_Ocb.f);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.m);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = localDownloadInfo.f;
      break;
      if ((localDownloadInfo.a() == 20) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.k + localDownloadInfo.f + "%");
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.l);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Ocb == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_Ocb.e));
      label25:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_Ocb.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Ocb.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Ocb.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Ocb.d, (URLDrawable.URLDrawableOptions)localObject);
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
    this.jdField_a_of_type_Ocb = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ocb == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Ocb.jdField_c_of_type_Int == 2)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_kandian_videos");
        ((Intent)localObject).setData(Uri.parse(this.jdField_a_of_type_Ocb.g));
        if (ryx.a(getContext(), (Intent)localObject)) {
          getContext().startActivity((Intent)localObject);
        }
        ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "7", this.jdField_a_of_type_JavaLangString));
        bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n, bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n) + 1);
        continue;
      }
      Object localObject = new sei();
      ((sei)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Ocb.f;
      ((sei)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ocb.i;
      ((sei)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      jdField_a_of_type_Seh.a(this.jdField_a_of_type_Ocb.j, (sei)localObject);
      bisa.a().a(jdField_a_of_type_Seh);
      localObject = this.jdField_a_of_type_Ocb.h;
      try
      {
        ((ClipboardManager)getContext().getSystemService("clipboard")).setText((CharSequence)localObject);
        label254:
        ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "3", this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = bisa.a().b(this.jdField_a_of_type_Ocb.f);
        if (localObject == null)
        {
          localObject = new DownloadInfo();
          ((DownloadInfo)localObject).d = this.jdField_a_of_type_Ocb.f;
          ((DownloadInfo)localObject).m = "biz_src_kandian_videos";
          ((DownloadInfo)localObject).e = this.jdField_a_of_type_Ocb.j;
          bisa.a().b((DownloadInfo)localObject);
          bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n, bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n) + 1);
          ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "9", this.jdField_a_of_type_JavaLangString));
          ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "10", this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.k + "0%");
          this.jdField_a_of_type_Int = 0;
          continue;
        }
        if (((DownloadInfo)localObject).a() == 4)
        {
          ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "102", this.jdField_a_of_type_JavaLangString));
          ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "20", this.jdField_a_of_type_JavaLangString));
          if (!bisa.a().a((DownloadInfo)localObject)) {
            bisa.a().b((DownloadInfo)localObject);
          }
          bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n, bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n) + 1);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.m);
          continue;
        }
        if ((((DownloadInfo)localObject).a() == 30) || (((DownloadInfo)localObject).a() == 10) || (((DownloadInfo)localObject).a() == 20) || (((DownloadInfo)localObject).a() == 1) || (((DownloadInfo)localObject).a() == 2))
        {
          ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "22", this.jdField_a_of_type_JavaLangString));
          bisa.a().a(this.jdField_a_of_type_Ocb.f);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.l);
          continue;
        }
        bisa.a().b((DownloadInfo)localObject);
        bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n, bgsg.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Ocb.n) + 1);
        ogc.a(ogc.b(this.jdField_a_of_type_Ocb.i, "10", this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ocb.k + ((DownloadInfo)localObject).f + "%");
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Ocb != null) && (this.jdField_a_of_type_Int != 0))
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), afur.a(14.0F, getResources()), afur.a(14.0F, getResources()), Path.Direction.CW);
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
      bisa.a().a(this);
      a(true);
      return;
    }
    bisa.a().b(this);
  }
  
  public void setInfo(ocb paramocb, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Ocb = paramocb;
    a(false);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.9(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */