package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import vow;

public class QCircleCommentOrReplyMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private vow jdField_a_of_type_Vow;
  
  public QCircleCommentOrReplyMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560748;
  }
  
  public String a()
  {
    return "QCircleCommentOrReplyMessageItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Vow = new vow(c());
    this.jdField_a_of_type_Vow.a(paramContext, paramView);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice)
  {
    a(paramStNotice, -1);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.jdField_a_of_type_Vow != null)
    {
      this.jdField_a_of_type_Vow.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Vow.a(paramStNotice, paramInt);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_Vow != null) {
      this.jdField_a_of_type_Vow.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Vow != null) {
      this.jdField_a_of_type_Vow.c();
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    if (this.jdField_a_of_type_Vow != null) {
      this.jdField_a_of_type_Vow.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleCommentOrReplyMessageItemView
 * JD-Core Version:    0.7.0.1
 */