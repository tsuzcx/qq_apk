package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

public class GameMsgBoxOpenSyncView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button a;
  private RoundCornerImageView b;
  private LinearLayout c;
  private LinearLayout d;
  private RelativeLayout e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private TextView i;
  private TextView j;
  private int k;
  private String l;
  private float m = 0.0F;
  private long n = 0L;
  
  public GameMsgBoxOpenSyncView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameMsgBoxOpenSyncView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameMsgBoxOpenSyncView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(ImageView paramImageView, Context paramContext, String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject = null;
    try
    {
      paramContext = paramContext.getResources().getDrawable(2130841060);
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("GameMsgBoxOpenSyncView", 1, "-->create color drawable oom.", paramContext);
      paramContext = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    try
    {
      paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    catch (IllegalArgumentException paramContext)
    {
      QLog.e("GameMsgBoxOpenSyncView", 1, new Object[] { "setImageUrl exception url=", paramString, ",excption=", paramContext });
      paramContext = localObject;
    }
    if (paramContext != null)
    {
      if (paramContext.getStatus() == 2) {
        paramContext.restartDownload();
      }
      if (paramContext.getStatus() != 2)
      {
        paramImageView.setImageDrawable(paramContext);
        return;
      }
      QLog.e("GameMsgBoxOpenSyncView", 1, "getImageError: ");
    }
  }
  
  private void b()
  {
    DisplayMetrics localDisplayMetrics1 = getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics2 = FontSettingManager.systemMetrics;
    float f1 = localDisplayMetrics1.density / localDisplayMetrics2.density;
    if (f1 != 1.0D)
    {
      float f2 = this.m;
      if ((f2 == 0.0F) || (f2 != f1))
      {
        this.m = f1;
        ImageUtil.a(this.c);
        ImageUtil.a(this.e);
        ImageUtil.a(this.f);
        ImageUtil.a(this.g);
        ImageUtil.a(this.h);
        ImageUtil.a(this.i);
        ImageUtil.a(this.a);
        ImageUtil.a(this.j);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameMsgBoxOpenSyncView", 2, "fontsize doenst change");
    }
  }
  
  public void a()
  {
    VideoReport.setElementId(this.a, "em_gb_authority");
    VideoReport.setElementClickPolicy(this.a, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.a, ExposurePolicy.REPORT_ALL);
    if (QLog.isColorLevel()) {
      QLog.i("GameMsgBoxOpenSyncView", 2, "initDtReport.");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433959)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.n < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgBoxOpenSyncView", 2, "click too often, please try again.");
        }
      }
      else if (TextUtils.isEmpty(this.l))
      {
        QLog.e("GameMsgBoxOpenSyncView", 2, "appId is null.");
      }
      else
      {
        this.n = l1;
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgBoxOpenSyncView", 2, "open sync.");
        }
        ThreadManagerV2.executeOnSubThread(new GameMsgBoxOpenSyncView.1(this));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((Button)findViewById(2131433959));
    this.b = ((RoundCornerImageView)findViewById(2131429245));
    this.f = ((ImageView)findViewById(2131433985));
    this.h = ((ImageView)findViewById(2131430628));
    this.g = ((ImageView)findViewById(2131450121));
    this.i = ((TextView)findViewById(2131435890));
    this.j = ((TextView)findViewById(2131433958));
    this.c = ((LinearLayout)findViewById(2131446695));
    this.d = ((LinearLayout)findViewById(2131446696));
    this.e = ((RelativeLayout)findViewById(2131446697));
    this.a.setOnClickListener(this);
    a();
  }
  
  public void setGameOpenSyncMsg(String paramString, int paramInt1, GameDetailInfo paramGameDetailInfo, int paramInt2, Drawable paramDrawable)
  {
    if (paramGameDetailInfo == null) {
      return;
    }
    paramGameDetailInfo = paramGameDetailInfo.l;
    this.k = paramInt1;
    this.l = paramString;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.a.setBackgroundDrawable(getContext().getResources().getDrawable(2130840539));
      this.b.setImageDrawable(getResources().getDrawable(2130842453));
      this.g.setImageDrawable(getResources().getDrawable(2130842459));
      this.h.setImageDrawable(getResources().getDrawable(2130842455));
      this.i.setTextColor(-1);
      this.a.setTextColor(-1);
      this.j.setTextColor(getResources().getColor(2131165215));
      ((LinearLayout.LayoutParams)this.j.getLayoutParams()).topMargin = ViewUtils.dpToPx(12.0F);
      this.d.setBackgroundResource(2130840541);
    }
    else
    {
      ((LinearLayout.LayoutParams)this.j.getLayoutParams()).topMargin = ViewUtils.dpToPx(-6.0F);
      this.b.setImageDrawable(getResources().getDrawable(2130842452));
      this.g.setImageDrawable(getResources().getDrawable(2130842460));
      this.h.setImageDrawable(getResources().getDrawable(2130842454));
      this.c.setBackgroundResource(2130840542);
    }
    this.b.setCorner(ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(8.0F), 0, 0);
    if (TextUtils.isEmpty(paramGameDetailInfo))
    {
      this.f.setImageDrawable(getResources().getDrawable(2130841060));
      return;
    }
    a(this.f, getContext(), paramGameDetailInfo);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxOpenSyncView
 * JD-Core Version:    0.7.0.1
 */