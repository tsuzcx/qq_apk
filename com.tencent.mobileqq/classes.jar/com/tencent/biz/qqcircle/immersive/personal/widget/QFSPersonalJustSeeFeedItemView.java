package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class QFSPersonalJustSeeFeedItemView
  extends QCircleBaseWidgetView<QFSPersonalFeedInfo>
{
  private ImageView a;
  private String b;
  
  public QFSPersonalJustSeeFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (TextUtils.equals(this.b, ((QFSPersonalFeedInfo)getData()).c())) {
      return;
    }
    this.a.setImageDrawable(null);
    this.b = ((QFSPersonalFeedInfo)getData()).c();
    Option localOption = new Option().setUrl(this.b).setTargetView(this.a);
    localOption.setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
    QCircleFeedPicLoader.g().loadImage(localOption, null);
  }
  
  private void b() {}
  
  protected void a(QFSPersonalFeedInfo paramQFSPersonalFeedInfo, int paramInt)
  {
    if (paramQFSPersonalFeedInfo != null)
    {
      if (paramQFSPersonalFeedInfo.a() == null) {
        return;
      }
      a();
    }
  }
  
  public int getLayoutId()
  {
    return 2131627158;
  }
  
  protected String getLogTag()
  {
    return "QFSPersonalFeedItemView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436371));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) * 4 / 3, 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalJustSeeFeedItemView
 * JD-Core Version:    0.7.0.1
 */