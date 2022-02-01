package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VideoBehaviorsReporter
{
  private static VideoBehaviorsReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsReporter = new VideoBehaviorsReporter();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private VideoBehaviorsReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsReportData;
  private VideoBehaviorsSeqReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsSeqReportData;
  private List<?> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -100;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -100;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -100;
  
  public static VideoBehaviorsReporter a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsReporter;
  }
  
  private void b()
  {
    VideoBehaviorsSeqReportData localVideoBehaviorsSeqReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsSeqReportData;
    if ((localVideoBehaviorsSeqReportData == null) || (localVideoBehaviorsSeqReportData.a())) {
      return;
    }
    localVideoBehaviorsSeqReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localVideoBehaviorsSeqReportData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviorsSeq(): " + localVideoBehaviorsSeqReportData.toString());
    }
    RIJStatisticCollectorReport.f(BaseApplication.getContext(), ReadInJoyUtils.a(), true, localVideoBehaviorsSeqReportData.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsSeqReportData.a();
  }
  
  public void a()
  {
    b();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.d = -100;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsReportData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBehaviorsSeqReportData = null;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, List<?> paramList)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = paramList;
        if ((this.jdField_c_of_type_Long == -1L) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          this.jdField_c_of_type_Long = ((BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(0)).mRecommendSeq;
          if (QLog.isColorLevel()) {
            QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 2,  mFirstVideoSeq = " + this.jdField_c_of_type_Long);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 1, mFirstVideoSeq = " + this.jdField_c_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter
 * JD-Core Version:    0.7.0.1
 */