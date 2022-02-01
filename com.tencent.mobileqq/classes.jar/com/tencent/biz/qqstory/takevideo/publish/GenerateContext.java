package com.tencent.biz.qqstory.takevideo.publish;

import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

public class GenerateContext
{
  public final int a;
  public final PublishVideoEntry a;
  public final EditVideoParams.EditSource a;
  public final EditVideoParams a;
  public GeneratePicArgs a;
  public GenerateThumbArgs a;
  public PublishParam a;
  public TribeVideoPublishParams a;
  public LpReportInfo_pf00064 a;
  public String a;
  public WeakReference<View> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c = false;
  public boolean d;
  
  public GenerateContext(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = new PublishVideoEntry();
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    this.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams = new TribeVideoPublishParams();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_Int = paramEditVideoParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLabel = paramEditVideoParams.a("story_default_label");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("enable_flow_decode", Boolean.valueOf(Constants.jdField_b_of_type_Boolean));
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public String toString()
  {
    return "GenerateContext{, businessId='" + this.jdField_a_of_type_Int + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateContext
 * JD-Core Version:    0.7.0.1
 */