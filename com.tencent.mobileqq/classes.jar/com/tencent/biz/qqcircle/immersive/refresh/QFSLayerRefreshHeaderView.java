package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.OnRefreshLoadViewStatusListener;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QFSLayerRefreshHeaderView
  extends QCircleBaseWidgetView
  implements IQFSRefreshView
{
  private String a;
  private String b;
  private TextView c;
  private QFSPageTurnContainer.OnRefreshLoadViewStatusListener d;
  private ChrysanthemumLoadingView e;
  private String f;
  private String g;
  
  public QFSLayerRefreshHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.f = getResources().getString(2131896240);
    this.b = getResources().getString(2131896239);
    this.a = getResources().getString(2131896242);
    this.g = getResources().getString(2131896241);
  }
  
  public QFSLayerRefreshHeaderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.c.setText(this.f);
    invalidate();
    paramQFSPullRefreshLayout = this.d;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.a(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onStart");
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      this.c.setText(this.g);
    } else {
      this.c.setText(this.f);
    }
    if (paramFloat < 0.5D)
    {
      setVisibility(8);
    }
    else
    {
      this.c.setAlpha((paramFloat - 0.5F) * 2.0F);
      setVisibility(0);
      this.c.setVisibility(0);
    }
    invalidate();
    paramQFSPullRefreshLayout = this.d;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.a(false, paramFloat);
    }
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, boolean paramBoolean)
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSLayerRefreshHeaderView.1(this), 300L);
  }
  
  public void b(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.c.setText(this.b);
    this.e.setVisibility(0);
    this.e.a();
    invalidate();
    paramQFSPullRefreshLayout = this.d;
    if (paramQFSPullRefreshLayout != null) {
      paramQFSPullRefreshLayout.c(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onRefresh");
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131627144;
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
    return ViewUtils.a(48.0F);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((TextView)paramView.findViewById(2131448568));
    this.e = ((ChrysanthemumLoadingView)paramView.findViewById(2131437664));
  }
  
  public void setOnRefreshViewStatusListener(QFSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.d = paramOnRefreshLoadViewStatusListener;
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */