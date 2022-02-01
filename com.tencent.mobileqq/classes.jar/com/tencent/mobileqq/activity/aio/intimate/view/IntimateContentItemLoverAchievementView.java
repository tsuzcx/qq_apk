package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class IntimateContentItemLoverAchievementView
  extends IntimateContentItemBaseView
{
  private RelativeLayout i;
  private TextView j;
  private RecyclerView k;
  private IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter l;
  private IntimateContentItemLoverAchievementView.CoupleAchievementItemListener m = new IntimateContentItemLoverAchievementView.1(this);
  
  public IntimateContentItemLoverAchievementView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = new SpannableString(paramString);
      localObject = new StyleSpan(0);
      paramInt2 += paramInt1;
      paramString.setSpan(localObject, paramInt1, paramInt2, 33);
      paramString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(14.0F)), paramInt1, paramInt2, 33);
      paramString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, 2131167769)), paramInt1, paramInt2, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getUnBoldContent fail:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("IntimateContentItemLoverAchievementView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void n()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B567", "0X800B567", 0, 0, "", "", "", "");
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131431453) {
      return;
    }
    paramView = FriendIntimateRelationshipConfProcessor.a().aa;
    if (!TextUtils.isEmpty(paramView))
    {
      n();
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, paramView, 2064, null);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo != null) && (paramIntimateInfo.loveAchievementInfo != null) && (paramIntimateInfo.loveAchievementInfo.c != null) && (paramIntimateInfo.loveAchievementInfo.c.size() > 0))
    {
      setVisibility(0);
      SpannableString localSpannableString = a(String.format(this.a.getResources().getString(2131890967), new Object[] { Integer.valueOf(paramIntimateInfo.loveAchievementInfo.b), Integer.valueOf(paramIntimateInfo.loveAchievementInfo.a) }), 0, 3);
      if (localSpannableString != null) {
        this.j.setText(localSpannableString);
      }
      if (this.l != null) {
        if (paramIntimateInfo.loveAchievementInfo.c.size() > 3) {
          this.l.a(paramIntimateInfo.loveAchievementInfo.c.subList(0, 3));
        } else {
          this.l.a(paramIntimateInfo.loveAchievementInfo.c);
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B566", "0X800B566", 0, 0, "", "", "", "");
      return;
    }
    setVisibility(8);
  }
  
  protected boolean a()
  {
    boolean bool3 = FriendIntimateRelationshipConfProcessor.a().X;
    IntimateInfo localIntimateInfo = this.d;
    boolean bool2 = false;
    int n;
    if ((localIntimateInfo != null) && (this.d.loveAchievementInfo != null) && (this.d.loveAchievementInfo.c != null) && (this.d.loveAchievementInfo.c.size() > 0)) {
      n = 1;
    } else {
      n = 0;
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.e == 1)
      {
        bool1 = bool2;
        if (n != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void b()
  {
    Object localObject = LayoutInflater.from(this.a).inflate(2131625177, this, true);
    this.i = ((RelativeLayout)((View)localObject).findViewById(2131431453));
    this.j = ((TextView)((View)localObject).findViewById(2131431455));
    this.k = ((RecyclerView)((View)localObject).findViewById(2131431454));
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(this);
    this.l = new IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter(this, null);
    localObject = new IntimateContentItemLoverAchievementView.2(this, this.h.l(), 3);
    this.k.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.k.setAdapter(this.l);
  }
  
  protected void g()
  {
    RecyclerView localRecyclerView = this.k;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(null);
      this.k.removeAllViews();
      this.k.setAdapter(null);
      this.k = null;
      this.k = null;
      removeAllViews();
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView
 * JD-Core Version:    0.7.0.1
 */