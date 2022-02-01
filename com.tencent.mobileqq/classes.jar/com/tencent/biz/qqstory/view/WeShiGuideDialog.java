package com.tencent.biz.qqstory.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeShiGuideDialog
  extends ReportDialog
  implements View.OnClickListener
{
  protected boolean a = false;
  protected Button b;
  protected int c = 0;
  protected String d;
  private ImageView e;
  private View f;
  private TextView g;
  private String h;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = null;
  private WeShiGuideDialog.OnWsDialogDismissListener m;
  private Context n;
  private String o;
  
  public WeShiGuideDialog(@NonNull Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.n = paramContext;
    this.o = paramString;
  }
  
  public WeShiGuideDialog(@NonNull Context paramContext, String paramString)
  {
    this(paramContext, 2131953338, paramString);
    this.n = paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (WeishiGuideUtils.a(paramContext))
    {
      WeishiGuideUtils.a(paramContext, "biz_src_jc_hyws", paramString4);
      return null;
    }
    paramContext = new WeShiGuideDialog(paramContext, "biz_src_jc_hyws").a(paramString1, paramString2, paramString3).a(paramInt, paramString4);
    paramContext.show();
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    WeShiGuideDialog.OnWsDialogDismissListener localOnWsDialogDismissListener = this.m;
    if (localOnWsDialogDismissListener != null) {
      localOnWsDialogDismissListener.a(this, paramInt);
    }
  }
  
  private void b()
  {
    this.b = ((Button)findViewById(2131429868));
    this.e = ((ImageView)findViewById(2131436318));
    this.f = findViewById(2131437419);
    this.g = ((TextView)findViewById(2131448569));
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.b.setText(HardCodeUtil.a(2131913850));
    a();
    if (TextUtils.isEmpty(this.h)) {
      this.h = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
    }
    this.g.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable(this.h, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new WeShiGuideDialog.WeakViewDownloadListener(this.g));
    this.f.setBackgroundDrawable((Drawable)localObject);
    int i1 = ((URLDrawable)localObject).getStatus();
    if (i1 != 1)
    {
      if (i1 == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else {
      this.g.setVisibility(8);
    }
  }
  
  public WeShiGuideDialog a(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
    return this;
  }
  
  public WeShiGuideDialog a(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public WeShiGuideDialog a(String paramString1, String paramString2, String paramString3)
  {
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramString3;
    return this;
  }
  
  public void a()
  {
    boolean bool = WeishiGuideUtils.a(getContext());
    if (this.a != bool)
    {
      this.a = bool;
      if (this.a)
      {
        this.b.setText(HardCodeUtil.a(2131913851));
        return;
      }
      this.b.setText(HardCodeUtil.a(2131913854));
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a(-1);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    int i5 = 1;
    Object localObject;
    int i3;
    int i2;
    int i4;
    JSONObject localJSONObject;
    if (i1 != 2131429868)
    {
      if (i1 == 2131436318)
      {
        dismiss();
        a(-1);
        if (TextUtils.isEmpty(this.l)) {
          StoryReportor.a("weishi_share", "cover_close", 0, 0, new String[] { this.j, this.i, "weishi", this.k });
        }
      }
    }
    else
    {
      a();
      if (TextUtils.isEmpty(this.l))
      {
        if (this.a)
        {
          WeishiGuideUtils.a(getContext(), this.o, this.d);
          i1 = 0;
        }
        else
        {
          QQToast.makeText(getContext(), HardCodeUtil.a(2131913852), 0).show();
          WeishiGuideUtils.a(getContext(), this.o);
          i1 = 1;
        }
        StoryReportor.a("weishi_share", "cover_clk", 0, 0, new String[] { this.j, this.i, "weishi", this.k });
      }
      else
      {
        if (this.a)
        {
          ((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).openWeishi(getContext(), this.l);
          i1 = 0;
        }
        else
        {
          QQToast.makeText(getContext(), -1, HardCodeUtil.a(2131913853), 0).show(getContext().getResources().getDimensionPixelSize(2131299920));
          ((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).gotoWeishiDownload(getContext(), this.l);
          i1 = 1;
        }
        localObject = this.n;
        if ((localObject instanceof Activity))
        {
          i3 = ((Activity)localObject).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          i2 = ((Activity)this.n).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
          if ((i2 != 9) && (i2 != 12)) {
            i2 = 0;
          } else {
            i2 = 1;
          }
          i4 = i2;
          i2 = i3;
        }
        else
        {
          i4 = 0;
          i2 = 0;
        }
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!this.a) {
          break label599;
        }
        localObject = "0";
        localJSONObject.put("download", localObject);
        localObject = (IVideoReporter)QRoute.api(IVideoReporter.class);
        if (i4 == 0) {
          break label607;
        }
        i3 = i5;
        ((IVideoReporter)localObject).addKanDianTagForWeishiReport(localJSONObject, i3);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (((IVideoFeedsWeiShiUtils)QRoute.api(IVideoFeedsWeiShiUtils.class)).isWeishi(this.l)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(i2), "", "", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", localJSONObject), false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(i2), "", "", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", localJSONObject), false);
      }
      dismiss();
      a(i1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label599:
      String str = "1";
      continue;
      label607:
      i3 = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628216);
    b();
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    if (TextUtils.isEmpty(this.l)) {
      StoryReportor.a("weishi_share", "cover_exp", 0, 0, new String[] { this.j, this.i, "weishi", this.k });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.WeShiGuideDialog
 * JD-Core Version:    0.7.0.1
 */