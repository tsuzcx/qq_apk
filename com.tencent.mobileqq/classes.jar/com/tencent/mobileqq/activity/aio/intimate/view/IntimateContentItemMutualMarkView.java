package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.EmptyStatusInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class IntimateContentItemMutualMarkView
  extends IntimateContentItemBaseView
{
  private View i;
  private HorizontalListView j;
  private ImageView k;
  private IntimateContentItemMutualMarkView.FriendMaskAdapter l;
  private boolean m = false;
  private boolean n = false;
  private int o = 1;
  private ArrayList<IntimateInfo.MutualMarkInfo> p = new ArrayList();
  private int q = 0;
  private int r = 0;
  private RelativeLayout s;
  private TextView t;
  private RoundRectImageView u;
  private boolean v = false;
  
  public IntimateContentItemMutualMarkView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemMutualMarkView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemMutualMarkView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (paramPrefetchMutualMarkInfo == null) {
      return null;
    }
    Bitmap localBitmap2 = a(paramPrefetchMutualMarkInfo.iconStaticUrl);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      i1 = MutualMarkConfigHelper.b(this.h.n(), this.h.k(), paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
      if (i1 == 0) {
        return null;
      }
      localBitmap2 = BitmapFactory.decodeResource(this.a.getResources(), i1);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        return null;
      }
    }
    localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    int i2 = localBitmap1.getHeight() + 32;
    int i1 = i2;
    if (paramPrefetchMutualMarkInfo.days > 0) {
      i1 = i2 * paramPrefetchMutualMarkInfo.currentDays / paramPrefetchMutualMarkInfo.days;
    }
    i1 = localBitmap1.getHeight() + 16 - i1;
    paramPrefetchMutualMarkInfo = new Rect(0, 0, localBitmap1.getWidth(), i1);
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, localPaint);
    paramPrefetchMutualMarkInfo = new Rect(0, i1, localBitmap1.getWidth(), localBitmap1.getHeight());
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
    return localBitmap2;
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = PushUtil.a.a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("PushUtil.INSTANCE.getBitmapFromUrl() error = ");
          localStringBuilder.append(paramString);
          QLog.e("intimate_relationship", 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  private String a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("intimate_");
    localStringBuilder.append(paramPrefetchMutualMarkInfo.type);
    localStringBuilder.append(paramPrefetchMutualMarkInfo.level);
    localStringBuilder.append(paramPrefetchMutualMarkInfo.days);
    localStringBuilder.append(paramPrefetchMutualMarkInfo.currentDays);
    localStringBuilder.append(paramBoolean);
    paramPrefetchMutualMarkInfo = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cacheName");
      localStringBuilder.append(paramPrefetchMutualMarkInfo);
      QLog.d("intimate_relationship", 2, localStringBuilder.toString());
    }
    return paramPrefetchMutualMarkInfo;
  }
  
  private void a(ImageView paramImageView, String paramString, Drawable paramDrawable, int paramInt)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, null);
    paramDrawable = paramImageView.getLayoutParams();
    paramDrawable.width = paramDrawable.height;
    paramImageView.setImageDrawable(null);
    paramImageView.setImageDrawable(paramString);
    paramImageView.setLayoutParams(paramDrawable);
    if (paramInt == 17)
    {
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (paramMutualMarkInfo == null) {
      return false;
    }
    if ((paramMutualMarkInfo != null) && (!MutualMarkConfigHelper.a(this.h.n(), paramMutualMarkInfo.type))) {
      return false;
    }
    int i2 = MutualMarkConfigHelper.b(this.h.n(), this.h.k(), paramMutualMarkInfo.type, paramMutualMarkInfo.level);
    if (paramMutualMarkInfo.type == 5) {
      paramMutualMarkInfo.iconStaticUrl = MutualMarkAlienationHelper.a(this.h.n(), this.h.k(), paramMutualMarkInfo.type, paramMutualMarkInfo.level, paramMutualMarkInfo.subLevel, paramMutualMarkInfo.iconStaticUrl);
    }
    MutualMarkConfigIRType localMutualMarkConfigIRType = MutualMarkConfigHelper.c(this.h.n(), paramMutualMarkInfo.type);
    int i1 = i2;
    if (localMutualMarkConfigIRType != null)
    {
      i1 = i2;
      if (localMutualMarkConfigIRType.f) {
        i1 = 0;
      }
    }
    return (!TextUtils.isEmpty(paramMutualMarkInfo.iconStaticUrl)) || (i1 != 0);
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int i2 = AIOUtils.b(56.0F, this.a.getResources());
    Bitmap localBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas1 = new Canvas(localBitmap);
    float f1 = i2;
    Object localObject = new RectF(0.0F, 0.0F, f1, f1);
    f1 = 2;
    float f2 = i2 - 2;
    RectF localRectF = new RectF(f1, f1, f2, f2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#E8E9F3"));
    f1 = 14;
    localCanvas1.drawRoundRect((RectF)localObject, f1, f1, localPaint);
    localPaint.setColor(-1);
    f1 = 12;
    localCanvas1.drawRoundRect(localRectF, f1, f1, localPaint);
    localObject = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas2 = new Canvas((Bitmap)localObject);
    localPaint.setColor(Color.parseColor("#F2F4F9"));
    localCanvas2.drawRoundRect(localRectF, f1, f1, localPaint);
    int i1;
    if (paramPrefetchMutualMarkInfo.days > 0) {
      i1 = paramPrefetchMutualMarkInfo.currentDays * i2 / paramPrefetchMutualMarkInfo.days;
    } else {
      i1 = i2;
    }
    paramPrefetchMutualMarkInfo = new Rect(0, i2 - i1, i2, i2);
    localCanvas1.drawBitmap((Bitmap)localObject, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
    return localBitmap;
  }
  
  private void n()
  {
    if ((!TextUtils.isEmpty(this.h.k())) && (NetworkUtil.isNetworkAvailable(this.h.l()))) {
      ((IntimateInfoHandler)this.h.n().getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(this.h.k());
    }
  }
  
  private void setPrefetchBitmap(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("getPrefetchMarkIcon, type=%s, currDay=%s, day=%s", new Object[] { Integer.valueOf(paramPrefetchMutualMarkInfo.type), Integer.valueOf(paramPrefetchMutualMarkInfo.currentDays), Integer.valueOf(paramPrefetchMutualMarkInfo.days) }));
    }
    ThreadManager.getSubThreadHandler().post(new IntimateContentItemMutualMarkView.1(this, paramPrefetchMutualMarkInfo));
  }
  
  protected void a(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131433798)
    {
      if (i1 != 2131435285) {
        return;
      }
      if ((this.d != null) && (this.d.emptyStatusInfo != null) && (!TextUtils.isEmpty(this.d.emptyStatusInfo.a)))
      {
        if (WebViewComUtils.a(1000L))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B68D", "0X800B68D", 0, 0, "", "", "", "");
          paramView = new Intent(this.a, QQBrowserActivity.class);
          paramView.putExtra("url", this.d.emptyStatusInfo.a);
          paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
          this.a.startActivity(paramView);
          return;
        }
        QQToast.makeText(getContext(), 1, this.a.getString(2131890984), 0).show();
      }
    }
    else
    {
      paramView = new Intent(this.h.l(), QQBrowserActivity.class);
      String str = MutualMarkConfProcessor.a().d(this.h.k());
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("goToC2CWebPage, url: %s", new Object[] { str }));
      }
      paramView.putExtra("url", str);
      paramView.putExtra("finish_animation_out_to_right", true);
      paramView.putExtra("is_wrap_content", true);
      paramView.putExtra("hide_left_button", false);
      if (this.h.l() != null) {
        this.h.l().startActivity(paramView);
      }
      if (this.d.isShowRedPoint)
      {
        n();
        this.d.isShowRedPoint = false;
      }
      if (this.m)
      {
        this.m = false;
        MutualMarkBusinessLogicHelper.b(this.h.n());
      }
      if (this.v)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B68E", "0X800B68E", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.o, 0, "", "", "", "");
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    int i1 = 0;
    setVisibility(0);
    if (!this.p.isEmpty())
    {
      this.l.a(this.p);
      this.j.setVisibility(0);
      this.s.setVisibility(8);
      this.v = false;
    }
    else
    {
      this.j.setVisibility(8);
      this.s.setVisibility(0);
      this.v = true;
    }
    this.m = MutualMarkBusinessLogicHelper.a(this.h.n());
    ImageView localImageView = this.k;
    paramInt = i1;
    if (!paramIntimateInfo.isShowRedPoint) {
      if (this.m) {
        paramInt = i1;
      } else {
        paramInt = 8;
      }
    }
    localImageView.setVisibility(paramInt);
  }
  
  protected boolean a()
  {
    this.p.clear();
    Iterator localIterator;
    IntimateInfo.MutualMarkInfo localMutualMarkInfo;
    if ((this.d.markInfoList != null) && (this.d.markInfoList.size() > 0))
    {
      localIterator = this.d.markInfoList.iterator();
      while (localIterator.hasNext())
      {
        localMutualMarkInfo = (IntimateInfo.MutualMarkInfo)localIterator.next();
        if (a(localMutualMarkInfo))
        {
          this.p.add(localMutualMarkInfo);
          this.q += 1;
        }
      }
      if (this.n) {
        ReportController.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.o, 0, "", "", "", "");
      }
    }
    if ((this.d.prefetchMutualMarkInfoList != null) && (this.d.prefetchMutualMarkInfoList.size() > 0))
    {
      localIterator = this.d.prefetchMutualMarkInfoList.iterator();
      while (localIterator.hasNext())
      {
        localMutualMarkInfo = (IntimateInfo.MutualMarkInfo)localIterator.next();
        if (a(localMutualMarkInfo))
        {
          this.p.add(localMutualMarkInfo);
          this.r += 1;
        }
      }
      if (this.n) {
        ReportController.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.o, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  protected void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625179, this, true);
    this.i = localView.findViewById(2131433798);
    this.j = ((HorizontalListView)localView.findViewById(2131433799));
    this.k = ((ImageView)localView.findViewById(2131435886));
    this.s = ((RelativeLayout)localView.findViewById(2131435281));
    this.t = ((TextView)localView.findViewById(2131435285));
    this.u = ((RoundRectImageView)localView.findViewById(2131435286));
    this.t.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(this);
    this.j.setOnTouchListener(this);
    this.j.setTransTouchStateToParent(true);
    this.l = new IntimateContentItemMutualMarkView.FriendMaskAdapter(this, null);
    this.j.setDividerWidth(ViewUtils.dip2px(5.0F));
    this.j.setOverScrollMode(2);
    this.j.setAdapter(this.l);
    this.u.setCornerRadiusAndMode(ViewUtils.dpToPx(6.0F), 1);
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView
 * JD-Core Version:    0.7.0.1
 */