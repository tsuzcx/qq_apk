package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;

public class QCircleDefaultFeedItemView
  extends QCircleBaseWidgetView
{
  private static final String TAG = "QCircleDefaultFeedItemView";
  
  public QCircleDefaultFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleDefaultFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleDefaultFeedItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView
 * JD-Core Version:    0.7.0.1
 */