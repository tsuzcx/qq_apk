package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCircleGroupMoreWidget
  extends QCircleBaseWidgetView
{
  private TextView a;
  private RecyclerView b;
  private QCircleGroupMoreWidget.GroupMoreAdapter c;
  private SafeLinearLayoutManager d;
  private QQCircleDitto.StItemContainer e;
  
  public QCircleGroupMoreWidget(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    if (paramList.size() > 0)
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (FeedCloudCommon.Entry)paramList.next();
        if (((FeedCloudCommon.Entry)localObject).key.get().equals(paramString))
        {
          paramList = ((FeedCloudCommon.Entry)localObject).value.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("KEY:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" VALUE:");
          ((StringBuilder)localObject).append(paramList);
          QLog.d("QCircleGroupMoreWidget", 1, ((StringBuilder)localObject).toString());
          return paramList;
        }
      }
    }
    return "";
  }
  
  private String getGroupOwnerUin()
  {
    QQCircleDitto.StItemContainer localStItemContainer = this.e;
    if (localStItemContainer != null) {
      return a(localStItemContainer.busiInfo.get(), "opuin");
    }
    return "";
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof FeedBlockData)) {
      return;
    }
    paramObject = (FeedBlockData)paramObject;
    this.c.a(paramObject, paramInt);
    if ((paramObject.a("DITTO_GROUP_MORE_RECOMMEND") instanceof QQCircleDitto.StItemContainer))
    {
      this.e = ((QQCircleDitto.StItemContainer)paramObject.a("DITTO_GROUP_MORE_RECOMMEND"));
      this.c.a(this.e.items.get());
      this.a.setText(this.e.title.get());
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder().setActionType(121).setSubActionType(1).setPageId(getReportBean().getPageId()).setToUin(getGroupOwnerUin()));
    }
  }
  
  public int getLayoutId()
  {
    return 2131626838;
  }
  
  protected String getLogTag()
  {
    return "QCircleGroupMoreWidget";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder().setActionType(121).setSubActionType(1).setPageId(getReportBean().getPageId()).setToUin(getGroupOwnerUin()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pageId:");
    localStringBuilder.append(getReportBean().getPageId());
    QLog.d("QCircleGroupMoreWidget", 1, localStringBuilder.toString());
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.b = ((RecyclerView)paramView.findViewById(2131441693));
    this.d = new SafeLinearLayoutManager(paramContext, 0, false);
    this.b.setLayoutManager(this.d);
    this.b.setItemAnimator(new DefaultItemAnimator());
    this.a = ((TextView)paramView.findViewById(2131441696));
    this.c = new QCircleGroupMoreWidget.GroupMoreAdapter(this, this.b);
    this.b.setAdapter(this.c);
    new QCirclePagerSnapHelper(1, 100.0F).a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGroupMoreWidget
 * JD-Core Version:    0.7.0.1
 */