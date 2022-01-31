package com.tencent.biz.pubaccount.readinjoy.video;

import aekt;
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
import bdem;
import bdiv;
import bfgi;
import bfka;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;
import nsx;
import nwh;
import rdm;
import rit;
import riu;
import riv;

public class VideoFeedsUGView
  extends RelativeLayout
  implements View.OnClickListener, bfka
{
  public static rit a;
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String a;
  public nsx a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  ImageView c;
  
  static
  {
    jdField_a_of_type_Rit = new rit();
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
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(24.0F, getResources()), aekt.a(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = aekt.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(95.0F, getResources()), aekt.a(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = aekt.a(4.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(3);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = aekt.a(6.0F, getResources());
    localLayoutParams.leftMargin = aekt.a(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.c = new ImageView(paramContext);
    this.c.setPadding(aekt.a(4.0F, getResources()), aekt.a(4.0F, getResources()), aekt.a(4.0F, getResources()), aekt.a(4.0F, getResources()));
    this.c.setOnClickListener(new riv(this));
    paramContext = new RelativeLayout.LayoutParams(aekt.a(16.0F, getResources()), aekt.a(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = aekt.a(4.0F, getResources());
    this.c.setLayoutParams(paramContext);
    addView(this.c, paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nsx == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(bdiv.b("ug_prefix_ug_1get3_ug_show_time")))
    {
      bdiv.a("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n, 0);
      bdiv.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Nsx.n, 0);
    }
    if (DateUtils.isToday(bdiv.b("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    if (bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n) >= this.jdField_a_of_type_Nsx.jdField_a_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if (bdiv.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Nsx.n) >= this.jdField_a_of_type_Nsx.jdField_b_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 1) && (bdem.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Nsx.j)))
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 2) && (!bdem.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Nsx.j)))
    {
      setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      bdiv.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Nsx.n, bdiv.a("ug_prefix_ug_1get3_ug_exp_count" + this.jdField_a_of_type_Nsx.n) + 1);
      nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "2", this.jdField_a_of_type_JavaLangString));
    }
    setVisibility(0);
    if (this.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 2)
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
      localDownloadInfo = bfgi.a().b(this.jdField_a_of_type_Nsx.f);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.m);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = localDownloadInfo.f;
      break;
      if ((localDownloadInfo.a() == 20) || (localDownloadInfo.a() == 1) || (localDownloadInfo.a() == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.k + localDownloadInfo.f + "%");
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.l);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Nsx == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_Nsx.e));
      label25:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_Nsx.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Nsx.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Nsx.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Nsx.d, (URLDrawable.URLDrawableOptions)localObject);
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
    this.jdField_a_of_type_Nsx = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Nsx == null) {
      return;
    }
    if (this.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 2)
    {
      paramView = new Intent();
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("big_brother_source_key", "biz_src_kandian_videos");
      paramView.setData(Uri.parse(this.jdField_a_of_type_Nsx.g));
      if (rdm.a(getContext(), paramView)) {
        getContext().startActivity(paramView);
      }
      nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "7", this.jdField_a_of_type_JavaLangString));
      bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n, bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n) + 1);
      return;
    }
    paramView = new riu();
    paramView.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Nsx.f;
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nsx.i;
    paramView.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_Rit.a(this.jdField_a_of_type_Nsx.j, paramView);
    bfgi.a().a(jdField_a_of_type_Rit);
    paramView = this.jdField_a_of_type_Nsx.h;
    try
    {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setText(paramView);
      label245:
      nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "3", this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView = bfgi.a().b(this.jdField_a_of_type_Nsx.f);
      if (paramView == null)
      {
        paramView = new DownloadInfo();
        paramView.d = this.jdField_a_of_type_Nsx.f;
        paramView.m = "biz_src_kandian_videos";
        paramView.e = this.jdField_a_of_type_Nsx.j;
        bfgi.a().b(paramView);
        bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n, bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n) + 1);
        nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "9", this.jdField_a_of_type_JavaLangString));
        nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "10", this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.k + "0%");
        this.jdField_a_of_type_Int = 0;
        return;
      }
      if (paramView.a() == 4)
      {
        nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "102", this.jdField_a_of_type_JavaLangString));
        nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "20", this.jdField_a_of_type_JavaLangString));
        if (!bfgi.a().a(paramView)) {
          bfgi.a().b(paramView);
        }
        bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n, bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n) + 1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.m);
        return;
      }
      if ((paramView.a() == 30) || (paramView.a() == 10) || (paramView.a() == 20) || (paramView.a() == 1) || (paramView.a() == 2))
      {
        nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "22", this.jdField_a_of_type_JavaLangString));
        bfgi.a().a(this.jdField_a_of_type_Nsx.f);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.l);
        return;
      }
      bfgi.a().b(paramView);
      bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n, bdiv.a("ug_prefix_ug_1get3_ug_click_count" + this.jdField_a_of_type_Nsx.n) + 1);
      nwh.a(nwh.b(this.jdField_a_of_type_Nsx.i, "10", this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nsx.k + paramView.f + "%");
      this.jdField_a_of_type_Int = paramView.f;
      return;
    }
    catch (Throwable paramView)
    {
      break label245;
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
    if ((this.jdField_a_of_type_Nsx != null) && (this.jdField_a_of_type_Int != 0))
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), aekt.a(14.0F, getResources()), aekt.a(14.0F, getResources()), Path.Direction.CW);
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
      bfgi.a().a(this);
      a(true);
      return;
    }
    bfgi.a().b(this);
  }
  
  public void setInfo(nsx paramnsx, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Nsx = paramnsx;
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