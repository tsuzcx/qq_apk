package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StUser;

public class QCirclePersonalBottomStatusView
  extends QCircleHalfScreenStatusView
  implements View.OnClickListener
{
  private FeedCloudMeta.StUser g;
  private String h;
  private String i;
  
  public QCirclePersonalBottomStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    localBundle.putBoolean("key_qcircle_reopen_carema", true);
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    localBundle.putSerializable("key_bundle_common_init_bean", localQCircleInitBean);
    localIntent.putExtras(localBundle);
    localIntent.setClass(getContext(), QCircleTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleLoadingFragment.class.getName());
    getContext().startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    if (this.g == null) {
      return;
    }
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    if ((QCirclePluginUtil.b(this.g)) && (getContext() != null) && (getContext().getResources() != null) && (!paramString.equals(getContext().getResources().getString(2131895715))))
    {
      a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed_colorless"));
      this.c.setVisibility(8);
      this.e.setVisibility(8);
    }
    else
    {
      paramString = this.g;
      if ((paramString != null) && ((paramString.blackState.get() == 1) || (this.g.blackState.get() == 3)))
      {
        a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"));
        this.c.setVisibility(0);
        this.c.setText(QCircleConfigHelper.N());
        this.d.setText(QCircleConfigHelper.O());
      }
      else
      {
        a(this.b, QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"));
        this.c.setVisibility(0);
        this.c.setText(this.h);
        this.d.setText(this.i);
      }
    }
    if (this.g != null) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.g.id.get()).setActionType(11).setSubActionType(17).setThrActionType(1).setPageId(getPageId()));
    }
    setVisibility(0);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.e.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131626892;
  }
  
  protected String getLogTag()
  {
    return "QCirclePersonalBottomStatusView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437401)
    {
      Object localObject = this.d.getText();
      if (localObject != null) {
        if (getContext().getString(2131895822).equals(((CharSequence)localObject).toString()))
        {
          if (!QCircleBindPhoneNumberHelper.a())
          {
            QCircleBindPhoneNumberHelper.a(getContext(), 1);
          }
          else
          {
            b();
            if (this.g != null) {
              QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.g.id.get()).setActionType(11).setSubActionType(17).setThrActionType(2).setPageId(getPageId()));
            }
          }
        }
        else if (getContext().getString(2131895820).equals(((CharSequence)localObject).toString()))
        {
          localObject = new QCircleFolderBean();
          ((QCircleFolderBean)localObject).setAssignShowTabType(6);
          ((QCircleFolderBean)localObject).setFromReportBean(getReportBean().clone());
          QCircleLauncher.a(getContext(), (QCircleFolderBean)localObject);
          if (this.g != null) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.g.id.get()).setActionType(11).setSubActionType(17).setThrActionType(3).setPageId(getPageId()));
          }
        }
        else if (getContext().getString(2131895821).equals(((CharSequence)localObject).toString()))
        {
          QCircleLauncher.e(paramView.getContext(), new QCircleInitBean());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setDescAndActionText(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.h = paramString3;
    this.i = paramString4;
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    this.g = paramStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView
 * JD-Core Version:    0.7.0.1
 */