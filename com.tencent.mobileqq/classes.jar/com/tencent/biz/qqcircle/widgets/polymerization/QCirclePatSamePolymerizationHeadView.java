package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;

public class QCirclePatSamePolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private static RFWMultiDownloadHelper d = new RFWMultiDownloadHelper();
  private TextView a;
  private TextView b;
  private QQCircleFeedBase.StFashionCopyPageData c;
  
  public QCirclePatSamePolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StFashionCopyPageData)) {
      return;
    }
    this.c = ((QQCircleFeedBase.StFashionCopyPageData)paramObject);
    this.a.setText(this.c.pageDesc.get());
    this.b.setText(a(this.c.subTitleEntry.get()));
  }
  
  public int getLayoutId()
  {
    return 2131626890;
  }
  
  protected String getLogTag()
  {
    return "QCirclePatSamePolymerizationHeadView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    this.a = ((TextView)paramView.findViewById(2131448814));
    this.b = ((TextView)paramView.findViewById(2131448631));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePatSamePolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */