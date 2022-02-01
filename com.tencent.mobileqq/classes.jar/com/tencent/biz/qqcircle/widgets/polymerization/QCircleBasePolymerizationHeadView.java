package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;
import zps;

public class QCircleBasePolymerizationHeadView
  extends QCircleBaseWidgetView
{
  private LinearLayout a;
  
  public QCircleBasePolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 0;
  }
  
  protected SpannableStringBuilder a(List<FeedCloudCommon.Entry> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new SpannableStringBuilder();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.get(i);
      if (i != 0)
      {
        localSpannableStringBuilder.append("  /  ");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131166262)), localSpannableStringBuilder.length() - "  /  ".length(), localSpannableStringBuilder.length(), 17);
      }
      localSpannableStringBuilder.append(localEntry.value.get());
      localSpannableStringBuilder.setSpan(new QCircleBasePolymerizationHeadView.1(this, 1), localSpannableStringBuilder.length() - localEntry.value.get().length(), localSpannableStringBuilder.length(), 17);
      localSpannableStringBuilder.append(localEntry.key.get());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public String a()
  {
    return "QCircleBasePolymerizationHeadView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131370268));
    if (this.a != null)
    {
      paramView = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      paramView.topMargin = (zps.a(paramContext, 74.0F) + ImmersiveUtils.getStatusBarHeight(paramContext));
      this.a.setLayoutParams(paramView);
    }
  }
  
  public void a(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */