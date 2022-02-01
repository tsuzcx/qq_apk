package com.tencent.gdtad.basics.motivevideo.title;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;

public class GdtMvTitleHelper
  implements View.OnClickListener
{
  protected ImageView a;
  protected View b;
  protected TextView c;
  protected int d = 0;
  protected int e = 0;
  protected int f = 0;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  private GdtMvTitleHelper.MvTitleListener j;
  private ViewGroup k;
  private IGdtMvTitleFactory l;
  
  private static String a(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int m = 0;
        while (m < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(m)).key.get() == paramInt)
          {
            paramGdtAd = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(m)).value.get();
            return paramGdtAd;
          }
          m += 1;
        }
        StringBuilder localStringBuilder;
        return "";
      }
      catch (Throwable paramGdtAd)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exp_map error");
        localStringBuilder.append(paramGdtAd);
        QLog.e("GdtMvTitleHelper", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int m = this.e;
    if (m != 0) {
      this.l = new GdtMvCircleTitleFactory(m);
    } else if (this.d == 0) {
      this.l = new GdtMvOldTitleFactory();
    } else {
      this.l = new GdtMvNewTitleFactory();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initView countDownStyle =");
    localStringBuilder.append(this.l.toString());
    QLog.i("GdtMvTitleHelper", 1, localStringBuilder.toString());
    this.l.a(paramViewGroup, this);
  }
  
  private void a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.d() != null))
    {
      if (this.c == null) {
        return;
      }
      String str2 = paramGdtMotiveVideoModel.d().getExperimentParam(109756);
      boolean bool2 = false;
      this.i = false;
      String str1;
      if ("1".equals(str2))
      {
        this.i = true;
        str1 = "不感兴趣";
      }
      else if ("2".equals(str2))
      {
        this.i = this.h;
        str1 = "换一换";
      }
      else
      {
        str1 = "";
      }
      boolean bool1 = bool2;
      if (this.i)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str1))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramGdtMotiveVideoModel.d().getUrlForFeedBack()))
          {
            bool1 = bool2;
            if (this.g == 1) {
              bool1 = true;
            }
          }
        }
      }
      this.i = bool1;
      if (this.i) {
        this.c.setText(str1);
      }
      this.c.setVisibility(8);
      paramGdtMotiveVideoModel = new StringBuilder();
      paramGdtMotiveVideoModel.append("feedbackParams = ");
      paramGdtMotiveVideoModel.append(str2);
      QLog.i("GdtMvTitleHelper", 4, paramGdtMotiveVideoModel.toString());
    }
  }
  
  private static int b(GdtAd paramGdtAd)
  {
    paramGdtAd = a(paramGdtAd, 104804);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRewardVideoCloseBtnAppearSecFromExp = ");
    localStringBuilder.append(paramGdtAd);
    QLog.i("GdtMvTitleHelper", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramGdtAd)) {
      return 0;
    }
    try
    {
      int m = Integer.parseInt(paramGdtAd);
      return m;
    }
    catch (Exception paramGdtAd)
    {
      QLog.i("GdtMvTitleHelper", 1, "getRewardVideoCloseBtnAppearSecFromExp error", paramGdtAd);
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    this.k.setVisibility(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.l;
    if ((localIGdtMvTitleFactory instanceof GdtMvCircleTitleFactory)) {
      ((GdtMvCircleTitleFactory)localIGdtMvTitleFactory).a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.l;
    if (localIGdtMvTitleFactory == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "updateCountDown factory is null");
      return;
    }
    localIGdtMvTitleFactory.a(paramLong1, paramLong2, paramLong3);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramLong >= this.f))
    {
      QLog.i("GdtMvTitleHelper", 4, "set close button visible");
      View localView = this.b;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    label135:
    try
    {
      if (this.k == null)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen bar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen !isPortrait");
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
      LiuHaiUtils.f(paramActivity);
      if (!LiuHaiUtils.b()) {
        break label135;
      }
      localLayoutParams.topMargin = LiuHaiUtils.e(paramActivity);
      this.k.setLayoutParams(localLayoutParams);
      paramActivity = new StringBuilder();
      paramActivity.append("fitSpecialScreen addHeight = ");
      paramActivity.append(localLayoutParams.topMargin);
      QLog.i("GdtMvTitleHelper", 1, paramActivity.toString());
      return;
    }
    catch (Exception paramActivity)
    {
      label101:
      break label101;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("initView countDownStyle =");
    paramActivity.append(this.d);
    QLog.i("GdtMvTitleHelper", 1, paramActivity.toString());
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.l;
    if (localIGdtMvTitleFactory == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner factory is null");
      return;
    }
    localIGdtMvTitleFactory.a(paramContext, paramBoolean);
  }
  
  public void a(View paramView, GdtMvTitleHelper.MvTitleListener paramMvTitleListener, GdtMotiveVideoModel paramGdtMotiveVideoModel, GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.b() != null) && (paramGdtMotiveVideoModel.b().exp_info.has()) && (paramGdtMotiveVideoModel.b().exp_info.video_countdown_style.has())) {
      this.d = paramGdtMotiveVideoModel.b().exp_info.video_countdown_style.get();
    }
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.d() != null)) {
      this.e = paramGdtMotiveVideoModel.d().getMvCircleButtonStyle();
    }
    if (paramGdtMotiveVideoModel != null) {
      this.f = b(paramGdtMotiveVideoModel.d());
    }
    this.j = paramMvTitleListener;
    this.k = ((ViewGroup)paramView.findViewById(2131434127));
    paramView = this.k;
    if (paramView == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "bar == null");
      return;
    }
    a(paramView);
    a(paramGdtMotiveVideoModel);
    if (paramGdtMvMiniAppReportHelper != null)
    {
      paramGdtMvMiniAppReportHelper.a(this.a);
      paramGdtMvMiniAppReportHelper.a(this.b);
    }
  }
  
  public void a(GdtAd paramGdtAd)
  {
    if (paramGdtAd == null) {
      return;
    }
    if ((this.c != null) && ("2".equals(paramGdtAd.getExperimentParam(109756)))) {
      this.c.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    View localView = this.b;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void b()
  {
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      if (!this.i) {
        return;
      }
      localTextView.setVisibility(0);
      this.i = false;
    }
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    GdtMvTitleHelper.MvTitleListener localMvTitleListener;
    if ((m != 2131434366) && (m != 2131434358) && (m != 2131430731))
    {
      if ((m != 2131434369) && (m != 2131434360) && (m != 2131430733))
      {
        if (m == 2131434367)
        {
          localMvTitleListener = this.j;
          if (localMvTitleListener != null)
          {
            localMvTitleListener.e();
            this.c.setVisibility(8);
          }
        }
      }
      else
      {
        localMvTitleListener = this.j;
        if (localMvTitleListener != null) {
          localMvTitleListener.a(true);
        }
      }
    }
    else
    {
      localMvTitleListener = this.j;
      if (localMvTitleListener != null) {
        localMvTitleListener.b(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper
 * JD-Core Version:    0.7.0.1
 */