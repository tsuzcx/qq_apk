package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.OnRefreshLoadViewStatusListener;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QFSLayerLoadFooterView
  extends QCircleBaseWidgetView
  implements IQFSRefreshView
{
  private ChrysanthemumLoadingView a;
  private QFSPageTurnContainer.OnRefreshLoadViewStatusListener b;
  private TextView c;
  
  public QFSLayerLoadFooterView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSLayerLoadFooterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFSLayerLoadFooterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean c(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    if (paramQFSPullRefreshLayout != null)
    {
      if (paramQFSPullRefreshLayout.d()) {
        return false;
      }
      QLog.d("FSLayerLoadFooterView", 1, "checkSetIsFinishStatus  has no more data");
      this.c.setText(HardCodeUtil.a(2131895810));
      this.c.setVisibility(0);
      this.a.b();
      this.a.setVisibility(8);
      invalidate();
      return true;
    }
    return false;
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    QLog.d("FSLayerLoadFooterView", 1, "onStart");
    if (c(paramQFSPullRefreshLayout)) {
      return;
    }
    paramQFSPullRefreshLayout = this.b;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.a(true);
    }
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, float paramFloat)
  {
    if (c(paramQFSPullRefreshLayout)) {
      return;
    }
    paramQFSPullRefreshLayout = this.b;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.a(true, paramFloat);
    }
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete  hasMoreData = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("FSLayerLoadFooterView", 1, localStringBuilder.toString());
    RFThreadManager.getUIHandler().postDelayed(new QFSLayerLoadFooterView.1(this, paramQFSPullRefreshLayout), 300L);
    paramQFSPullRefreshLayout = this.b;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.b(true);
    }
  }
  
  public void b(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    QLog.d("FSLayerLoadFooterView", 1, "onRefresh");
    if (c(paramQFSPullRefreshLayout)) {
      return;
    }
    this.a.setVisibility(0);
    this.a.a();
    this.c.setVisibility(8);
    invalidate();
    paramQFSPullRefreshLayout = this.b;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.c(true);
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131627143;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getStartRefreshDistance()
  {
    return 0;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ChrysanthemumLoadingView)paramView.findViewById(2131437664));
    this.c = ((TextView)paramView.findViewById(2131448568));
  }
  
  public void setOnRefreshViewStatusListener(QFSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.b = paramOnRefreshLoadViewStatusListener;
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView
 * JD-Core Version:    0.7.0.1
 */