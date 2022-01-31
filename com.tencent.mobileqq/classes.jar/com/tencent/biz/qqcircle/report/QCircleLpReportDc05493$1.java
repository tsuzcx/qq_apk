package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tye;
import tym;
import typ;

public final class QCircleLpReportDc05493$1
  implements Runnable
{
  public QCircleLpReportDc05493$1(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("touin", this.jdField_a_of_type_JavaLangString), tym.a("login_time", String.valueOf(this.jdField_a_of_type_Long)), tym.a("login_entrance", String.valueOf(this.jdField_b_of_type_Long)), tym.a("sub_entrance", String.valueOf(this.jdField_c_of_type_Long)), tym.a("thr_entrance", String.valueOf(this.jdField_d_of_type_Long)), tym.a("report_from", "1"), tym.a("ext1", this.jdField_b_of_type_JavaLangString), tym.a("ext2", this.jdField_c_of_type_JavaLangString), tym.a("ext3", this.jdField_d_of_type_JavaLangString), tym.a("ext4", this.e), tym.a("ext5", this.f), tym.a("ext6", this.g) }));
    ((List)localObject).addAll(tym.a().a());
    localObject = tym.a(tye.a(), (List)localObject, null, tym.a().a(this.jdField_a_of_type_Int));
    typ.a().a((QQCircleReport.SingleDcData)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05493.1
 * JD-Core Version:    0.7.0.1
 */