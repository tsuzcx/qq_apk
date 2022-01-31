package com.tencent.biz.qqcircle.report;

import android.os.Build;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tzr;
import tzy;
import uab;

public final class QCircleLpReportDc05494$1
  implements Runnable
{
  public QCircleLpReportDc05494$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("up_source", String.valueOf(this.jdField_a_of_type_Int)), tzy.a("up_type", String.valueOf(this.jdField_b_of_type_Int)), tzy.a("is_video", String.valueOf(this.jdField_c_of_type_Int)), tzy.a("txtinfo", this.jdField_a_of_type_JavaLangString), tzy.a("lloc", this.jdField_b_of_type_JavaLangString), tzy.a("vid", this.jdField_c_of_type_JavaLangString), tzy.a("photocubage", String.valueOf(this.jdField_a_of_type_Long)), tzy.a("feedid", this.jdField_d_of_type_JavaLangString), tzy.a("total_upload_num", String.valueOf(this.jdField_d_of_type_Int)), tzy.a("device_maker", Build.BRAND), tzy.a("device_model", Build.MODEL), tzy.a("shooting_time", this.jdField_e_of_type_JavaLangString), tzy.a("orig_photocubage", String.valueOf(this.jdField_b_of_type_Long)), tzy.a("place", this.jdField_f_of_type_JavaLangString), tzy.a("up_place", this.jdField_g_of_type_JavaLangString), tzy.a("shoot_product", this.jdField_h_of_type_JavaLangString), tzy.a("shoot_model", this.i), tzy.a("width", String.valueOf(this.jdField_e_of_type_Int)), tzy.a("height", String.valueOf(this.jdField_f_of_type_Int)), tzy.a("orig_width", String.valueOf(this.jdField_g_of_type_Int)), tzy.a("orig_height", String.valueOf(this.jdField_h_of_type_Int)), tzy.a("picture_format", this.j), tzy.a("feed_tag", this.k), tzy.a("author_uin", String.valueOf(this.jdField_c_of_type_Long)), tzy.a("shoot_place", this.l) }));
    ((List)localObject).addAll(tzy.a().a());
    localObject = tzy.a(tzr.a(), (List)localObject, null, tzy.a().a(tzr.b()));
    uab.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */