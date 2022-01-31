package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tzu;
import tzy;
import uab;

public final class QCircleLpReportDc05503$1
  implements Runnable
{
  public QCircleLpReportDc05503$1(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("login_time", String.valueOf(this.jdField_a_of_type_Long)), tzy.a("stay_time", String.valueOf(this.jdField_b_of_type_Long)), tzy.a("page_id", String.valueOf(this.jdField_c_of_type_Long)), tzy.a("ext1", this.jdField_a_of_type_JavaLangString), tzy.a("ext2", this.jdField_b_of_type_JavaLangString), tzy.a("ext3", this.jdField_c_of_type_JavaLangString), tzy.a("ext4", this.d), tzy.a("ext5", this.e), tzy.a("ext6", this.f) }));
    ((List)localObject).addAll(tzy.a().a());
    localObject = tzy.a(tzu.a(), (List)localObject, null, tzy.a().a(this.jdField_a_of_type_Int));
    uab.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05503.1
 * JD-Core Version:    0.7.0.1
 */