package com.tencent.biz.qqcircle.report;

import android.os.Build;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tyf;
import tym;
import typ;

public final class QCircleLpReportDc05494$1
  implements Runnable
{
  public QCircleLpReportDc05494$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("up_source", String.valueOf(this.jdField_a_of_type_Int)), tym.a("up_type", String.valueOf(this.jdField_b_of_type_Int)), tym.a("is_video", String.valueOf(this.jdField_c_of_type_Int)), tym.a("txtinfo", this.jdField_a_of_type_JavaLangString), tym.a("lloc", this.jdField_b_of_type_JavaLangString), tym.a("vid", this.jdField_c_of_type_JavaLangString), tym.a("photocubage", String.valueOf(this.jdField_a_of_type_Long)), tym.a("feedid", this.jdField_d_of_type_JavaLangString), tym.a("total_upload_num", String.valueOf(this.jdField_d_of_type_Int)), tym.a("device_maker", Build.BRAND), tym.a("device_model", Build.MODEL), tym.a("shooting_time", this.jdField_e_of_type_JavaLangString), tym.a("orig_photocubage", String.valueOf(this.jdField_b_of_type_Long)), tym.a("place", this.jdField_f_of_type_JavaLangString), tym.a("up_place", this.jdField_g_of_type_JavaLangString), tym.a("shoot_product", this.jdField_h_of_type_JavaLangString), tym.a("shoot_model", this.i), tym.a("width", String.valueOf(this.jdField_e_of_type_Int)), tym.a("height", String.valueOf(this.jdField_f_of_type_Int)), tym.a("orig_width", String.valueOf(this.jdField_g_of_type_Int)), tym.a("orig_height", String.valueOf(this.jdField_h_of_type_Int)), tym.a("picture_format", this.j), tym.a("feed_tag", this.k), tym.a("author_uin", String.valueOf(this.jdField_c_of_type_Long)), tym.a("shoot_place", this.l) }));
    ((List)localObject).addAll(tym.a().a());
    localObject = tym.a(tyf.a(), (List)localObject, null, tym.a().a(tyf.b()));
    typ.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */