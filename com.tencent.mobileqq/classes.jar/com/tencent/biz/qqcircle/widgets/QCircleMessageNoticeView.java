package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

public class QCircleMessageNoticeView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  public boolean a;
  private Context b;
  private QCircleMessageNoticeInfo c;
  private QCircleAvatarListView d;
  private TextView e;
  private LinearLayout f;
  private LinearLayout g;
  private View.OnClickListener h;
  private int i = 3;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public void a()
  {
    if (this.c != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordBubbleLastExposeNum:");
      localStringBuilder.append(this.c.c());
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, localStringBuilder.toString());
      EeveeRedpointUtil.saveFolderMessageNoticeBubbleLastExposeNum(this.c.c());
    }
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof QCircleMessageNoticeInfo))
    {
      this.c = ((QCircleMessageNoticeInfo)paramObject);
      paramObject = this.c.a();
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        this.d.setVisibility(0);
        paramInt = paramObject.size();
        int j = this.i;
        if (paramInt > j) {
          this.d.setData(paramObject.subList(0, j));
        } else {
          this.d.setData(paramObject);
        }
      }
      else
      {
        this.d.setVisibility(8);
      }
      paramObject = new StringBuilder();
      paramObject.append("bindData allUnReadCount:");
      paramObject.append(this.c.c());
      paramObject.append(" messageUnReadCount:");
      paramObject.append(this.c.b());
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, paramObject.toString());
      TextView localTextView = this.e;
      if (this.c.d() == null) {
        paramObject = "";
      } else {
        paramObject = this.c.d();
      }
      localTextView.setText(paramObject);
      this.g.setVisibility(0);
      a();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626877;
  }
  
  protected String getLogTag()
  {
    return "QCircleMessage_QCircleMessageNoticeView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "onAttachedToWindow");
    this.a = true;
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437498)
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(18).setSubActionType(2));
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      if (this.c != null)
      {
        View.OnClickListener localOnClickListener = this.h;
        if (localOnClickListener != null) {
          localOnClickListener.onClick(paramView);
        }
        if (!TextUtils.isEmpty(this.c.e()))
        {
          QCircleHostLauncher.doJumpAction(paramView.getContext(), this.c.e());
          break label159;
        }
        if ((this.c.b() <= 0) && (QCircleChatBoxHelper.getInstance().getUnReadChatNum() != 0))
        {
          QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to chatList page");
          localQCircleInitBean.setLaunchTo(1);
        }
        else
        {
          QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to messageList page");
          localQCircleInitBean.setLaunchTo(0);
        }
      }
      localQCircleInitBean.setFromReportBean(getReportBean().clone());
      QCircleLauncher.f(getContext(), localQCircleInitBean);
    }
    label159:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "onDetachedFromWindow");
    this.a = false;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.g = ((LinearLayout)paramView.findViewById(2131437499));
      this.d = ((QCircleAvatarListView)paramView.findViewById(2131428292));
      this.e = ((TextView)paramView.findViewById(2131448584));
      this.f = ((LinearLayout)paramView.findViewById(2131437498));
      this.f.setOnClickListener(this);
    }
  }
  
  public void setAdapterListener(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView
 * JD-Core Version:    0.7.0.1
 */