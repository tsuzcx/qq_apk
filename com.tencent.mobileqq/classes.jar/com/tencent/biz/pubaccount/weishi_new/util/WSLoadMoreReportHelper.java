package com.tencent.biz.pubaccount.weishi_new.util;

import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;

public class WSLoadMoreReportHelper
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public WSLoadMoreReportHelper(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadMore() sopName = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", loadMoreTriggerCnt = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    WSLog.b("LoadMoreReportHelper", localStringBuilder.toString());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    WsBeaconReportPresenter.a().a(this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    WsBeaconReportPresenter.a().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper
 * JD-Core Version:    0.7.0.1
 */