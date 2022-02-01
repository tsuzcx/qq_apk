package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StDividingLine;

public class QCircleLastSeenDividerView
  extends QCircleBaseWidgetView
{
  private TextView a;
  private Button b;
  private ImageView c;
  
  public QCircleLastSeenDividerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (getLayoutParams() != null) {
      getLayoutParams().height = 0;
    }
    setVisibility(8);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(getData() instanceof FeedBlockData)) {
      return;
    }
    if (paramInt == 0) {
      this.c.setVisibility(8);
    }
    paramObject = ((FeedBlockData)getData()).b();
    try
    {
      Object localObject = ((QQCircleDitto.StCircleDittoDataNew)new QQCircleDitto.StCircleDittoDataNew().mergeFrom(paramObject.dittoFeed.dittoDataNew.get().toByteArray())).dividingLine;
      if (localObject == null)
      {
        a();
        return;
      }
      String str1 = ((QQCircleDitto.StDividingLine)localObject).summary.get();
      String str2 = ((QQCircleDitto.StDividingLine)localObject).buttonInfo.name.get();
      localObject = ((QQCircleDitto.StDividingLine)localObject).buttonInfo.jumpUrl.get();
      if (!TextUtils.isEmpty(str1)) {
        this.a.setText(str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        this.b.setText(str2);
      }
      this.b.setOnClickListener(new QCircleLastSeenDividerView.1(this, (String)localObject, paramObject));
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramObject).setActionType(120).setSubActionType(1).setPageId(getPageId())));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      a();
      paramObject.printStackTrace();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626861;
  }
  
  protected String getLogTag()
  {
    return "QCircleLastSeenDividerView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((ImageView)paramView.findViewById(2131436351));
    this.a = ((TextView)paramView.findViewById(2131448395));
    this.a.getPaint().setFakeBoldText(true);
    this.b = ((Button)paramView.findViewById(2131448394));
    this.b.setPadding(ViewUtils.a(25.0F), ViewUtils.a(9.0F), ViewUtils.a(25.0F), ViewUtils.a(9.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLastSeenDividerView
 * JD-Core Version:    0.7.0.1
 */