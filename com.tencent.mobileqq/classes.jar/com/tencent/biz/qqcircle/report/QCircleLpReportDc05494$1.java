package com.tencent.biz.qqcircle.report;

import android.os.Build;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vrb;
import vri;
import vrl;

public final class QCircleLpReportDc05494$1
  implements Runnable
{
  public QCircleLpReportDc05494$1(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("up_source", String.valueOf(this.jdField_a_of_type_Int)), vri.a("up_type", String.valueOf(this.jdField_b_of_type_Int)), vri.a("is_video", String.valueOf(this.jdField_c_of_type_Int)), vri.a("txtinfo", this.jdField_a_of_type_JavaLangString), vri.a("lloc", this.jdField_b_of_type_JavaLangString), vri.a("vid", this.jdField_c_of_type_JavaLangString), vri.a("photocubage", String.valueOf(this.jdField_a_of_type_Long)), vri.a("feedid", this.jdField_d_of_type_JavaLangString), vri.a("total_upload_num", String.valueOf(this.jdField_d_of_type_Int)), vri.a("device_maker", Build.BRAND), vri.a("device_model", Build.MODEL), vri.a("shooting_time", this.jdField_e_of_type_JavaLangString), vri.a("orig_photocubage", String.valueOf(this.jdField_b_of_type_Long)), vri.a("place", this.jdField_f_of_type_JavaLangString), vri.a("up_place", this.jdField_g_of_type_JavaLangString), vri.a("shoot_product", this.jdField_h_of_type_JavaLangString), vri.a("shoot_model", this.i), vri.a("width", String.valueOf(this.jdField_e_of_type_Int)), vri.a("height", String.valueOf(this.jdField_f_of_type_Int)), vri.a("orig_width", String.valueOf(this.jdField_g_of_type_Int)), vri.a("orig_height", String.valueOf(this.jdField_h_of_type_Int)), vri.a("picture_format", this.j), vri.a("feed_tag", this.k), vri.a("author_uin", String.valueOf(this.jdField_c_of_type_Long)), vri.a("shoot_place", this.l) }));
    ((List)localObject).addAll(vri.a().a());
    localObject = vri.a(vrb.a(), (List)localObject, null, vri.a().a(vrb.b()));
    vrl.a().a((QQCircleReport.SingleDcData)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05494.1
 * JD-Core Version:    0.7.0.1
 */