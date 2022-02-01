package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleAchievementInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

public class QCircleAchievementPopupWindowPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private View a;
  private View c;
  private RoundCorneredRelativeLayout d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private Button h;
  private ImageView i;
  private QCircleAchievementInfo j;
  
  private void a(QCircleAchievementInfo paramQCircleAchievementInfo)
  {
    if ((paramQCircleAchievementInfo.c != null) && (!TextUtils.isEmpty(paramQCircleAchievementInfo.c)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toast url: ");
      ((StringBuilder)localObject).append(paramQCircleAchievementInfo.c);
      QLog.d("QCircleAchievementPopupWindowPart", 1, ((StringBuilder)localObject).toString());
      if ((this.e.getTag(2131449068) instanceof String)) {
        localObject = (String)this.e.getTag(2131449068);
      } else {
        localObject = "";
      }
      this.e.setTag(2131449068, paramQCircleAchievementInfo.c);
      if (!((String)localObject).equals(paramQCircleAchievementInfo.c))
      {
        paramQCircleAchievementInfo = new Option().setUrl(paramQCircleAchievementInfo.c).setTargetView(this.e).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.e.getLayoutParams().width).setRequestHeight(this.e.getLayoutParams().height).setFailDrawable(g().getResources().getDrawable(2130845199)).setLoadingDrawable(g().getResources().getDrawable(2130848395));
        QCircleFeedPicLoader.g().loadImage(paramQCircleAchievementInfo, new QCircleAchievementPopupWindowPart.1(this));
      }
      return;
    }
    QLog.e("QCircleAchievementPopupWindowPart", 1, "toast url is null");
    this.c.setVisibility(8);
  }
  
  private void i()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    this.d = ((RoundCorneredRelativeLayout)((View)localObject).findViewById(2131445175));
    this.e = ((ImageView)this.c.findViewById(2131449068));
    this.f = ((TextView)this.c.findViewById(2131448814));
    this.g = ((TextView)this.c.findViewById(2131448374));
    this.h = ((Button)this.c.findViewById(2131429920));
    this.i = ((ImageView)this.c.findViewById(2131436318));
    int k = ViewUtils.a(12.0F);
    localObject = this.d;
    float f1 = k;
    ((RoundCorneredRelativeLayout)localObject).setRadius(f1, f1, f1, f1);
    this.i.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  public String a()
  {
    return "QCircleAchievementPopupWindowPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = paramView;
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "open_achievement_popup_window_message"))
    {
      if (!(paramObject instanceof QCircleAchievementInfo)) {
        return;
      }
      paramString = this.a;
      if (paramString == null)
      {
        QLog.e("QCircleAchievementPopupWindowPart", 1, "handleBroadcastMessage()  mRootView == null");
        return;
      }
      if (this.c == null)
      {
        this.c = ((ViewStub)paramString.findViewById(2131450010)).inflate();
        i();
      }
      this.c.setVisibility(0);
      this.j = ((QCircleAchievementInfo)paramObject);
      this.f.setText(this.j.a);
      this.g.setText(this.j.b);
      this.h.setText(this.j.d);
      a(this.j);
      paramString = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(56).setThrActionType(1);
      paramObject = new StringBuilder();
      paramObject.append(this.j.f);
      paramObject.append("");
      QCircleLpReportDc05504.report(paramString.setExt6(paramObject.toString()).setExt7(this.j.d));
    }
  }
  
  public boolean ah_()
  {
    View localView = this.c;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      return true;
    }
    return super.ah_();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131436318)
    {
      ah_();
    }
    else if (k == 2131429920)
    {
      Object localObject = this.j;
      if ((localObject != null) && (!TextUtils.isEmpty(((QCircleAchievementInfo)localObject).e)))
      {
        QCircleLauncher.a(g(), this.j.e);
        localObject = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(56).setThrActionType(2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.j.f);
        localStringBuilder.append("");
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt6(localStringBuilder.toString()).setExt7(this.j.d));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleAchievementPopupWindowPart
 * JD-Core Version:    0.7.0.1
 */