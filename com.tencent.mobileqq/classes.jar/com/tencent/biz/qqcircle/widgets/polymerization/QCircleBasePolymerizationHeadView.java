package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class QCircleBasePolymerizationHeadView
  extends QCircleBaseWidgetView
{
  private LinearLayout a;
  
  public QCircleBasePolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected SpannableStringBuilder a(List<FeedCloudCommon.Entry> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i = 0;
      while (i < paramList.size())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.get(i);
        if (i != 0)
        {
          localSpannableStringBuilder.append("  /  ");
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167085)), localSpannableStringBuilder.length() - 5, localSpannableStringBuilder.length(), 17);
        }
        localSpannableStringBuilder.append(localEntry.value.get());
        localSpannableStringBuilder.setSpan(new QCircleBasePolymerizationHeadView.BoldStyleSpan(1), localSpannableStringBuilder.length() - localEntry.value.get().length(), localSpannableStringBuilder.length(), 17);
        localSpannableStringBuilder.append(localEntry.key.get());
        i += 1;
      }
      return localSpannableStringBuilder;
    }
    return new SpannableStringBuilder();
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleBasePolymerizationHeadView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131437585));
    paramContext = this.a;
    if (paramContext != null)
    {
      paramContext = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramContext.topMargin = ViewUtils.a(24.0F);
      this.a.setLayoutParams(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */