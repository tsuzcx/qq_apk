package com.tencent.biz.qqcircle.polylike;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.SpannableString;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikePayView
  extends QCirclePolyBaseLikeView
{
  private QCircleCustomDialog l;
  
  public QCirclePolyLikePayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(float paramFloat)
  {
    this.l = QCircleCustomDialog.a(getContext());
    SpannableString localSpannableString = new SpannableString(String.format(getContext().getResources().getString(2131895797), new Object[] { Float.valueOf(paramFloat) }));
    int i;
    if ((paramFloat >= 10.0F) && (paramFloat < 100.0F)) {
      i = 1;
    } else if ((paramFloat >= 100.0F) && (paramFloat < 1000.0F)) {
      i = 2;
    } else {
      i = 0;
    }
    localSpannableString.setSpan(new VerticalCenterImageSpan(getContext().getResources().getDrawable(2130845160)), i + 11, i + 12, 33);
    this.l.a(localSpannableString);
    this.l.a(getResources().getString(2131887648), new QCirclePolyLikePayView.1(this));
    this.l.b(getResources().getString(2131889652), new QCirclePolyLikePayView.2(this));
    this.l.show();
    a(95, 1, getQCircleExtraTypeInfo());
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(getFeed()).setToUin(String.valueOf(QCirclePluginUtil.c())).setActionType(95).setSubActionType(1).setIndex(this.dataPosInList).setPageId(getReportBean().getPageId())));
  }
  
  private void a(float paramFloat, int paramInt, String paramString)
  {
    if (((getContext() instanceof Activity)) && ((((Activity)getContext()).isFinishing()) || (((Activity)getContext()).isDestroyed()))) {
      return;
    }
    this.l = QCircleCustomDialog.a(getContext());
    this.l.setContentView(2131626789);
    this.l.a(getResources().getString(2131895799));
    Object localObject = new SpannableString(String.format(getContext().getResources().getString(2131895798), new Object[] { Float.valueOf(paramFloat) }));
    int i;
    if ((paramFloat >= 10.0F) && (paramFloat < 100.0F)) {
      i = 1;
    } else if ((paramFloat >= 100.0F) && (paramFloat < 1000.0F)) {
      i = 2;
    } else {
      i = 0;
    }
    ((SpannableString)localObject).setSpan(new VerticalCenterImageSpan(getContext().getResources().getDrawable(2130845160)), i + 11, i + 12, 33);
    this.l.a((CharSequence)localObject);
    this.l.a(getResources().getString(2131889652), new QCirclePolyLikePayView.3(this, paramString));
    this.l.a(String.format(getContext().getResources().getString(2131895900), new Object[] { Integer.valueOf(paramInt) }), new QCirclePolyLikePayView.4(this, paramInt, paramString));
    this.l.a(getResources().getString(2131887648), new QCirclePolyLikePayView.5(this));
    this.l.b(null, null);
    this.l.a(null, null);
    this.l.show();
    a(95, 1, getQCircleExtraTypeInfo());
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(getFeed()).setToUin(String.valueOf(QCirclePluginUtil.c())).setActionType(95).setSubActionType(1).setIndex(this.dataPosInList).setPageId(getReportBean().getPageId())));
    paramString = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(70).setSubActionType(1).setThrActionType(5).setExt7(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getPageId());
    ((StringBuilder)localObject).append("");
    QCircleLpReportDc05504.report(paramString.setvid(((StringBuilder)localObject).toString()));
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(getReportBean().getPageId()).setfpageid(getReportBean().getFromPageId()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCirclePolyLikePayView", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void b()
  {
    if (this.f != null) {
      this.f.setVisibility(0);
    }
    if (this.i != null) {
      this.i.setVisibility(4);
    }
  }
  
  protected void a()
  {
    float f = QCirclePolyLikeInfoManger.a().c();
    Context localContext = getContext();
    getContext();
    ((Vibrator)localContext.getSystemService("vibrator")).vibrate(50L);
    if (this.k != null) {
      this.k.a(this.e);
    }
    if (f < this.e.price.get())
    {
      int i = QCircleConfigHelper.af();
      if (i > 0)
      {
        a(f, i, this.e.polyLikeID.get());
        return;
      }
      a(f);
      return;
    }
    if (this.j != null)
    {
      this.j.a(this.d, this.e, 21);
      this.j.a(this.d, this.e);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    super.bindData(paramObject, paramInt);
    this.h.setText(String.valueOf(this.e.price.get()));
    RFWTypefaceUtil.a(this.h, true);
  }
  
  public int getLayoutId()
  {
    if (getParentType() == 256) {
      return 2131626914;
    }
    return 2131626913;
  }
  
  protected String getLogTag()
  {
    return "QCirclePayPolyLikeView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView
 * JD-Core Version:    0.7.0.1
 */