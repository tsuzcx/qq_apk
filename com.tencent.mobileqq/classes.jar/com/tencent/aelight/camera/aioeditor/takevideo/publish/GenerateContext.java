package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.view.View;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.tribe.data.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

public class GenerateContext
{
  public final int a;
  public long a;
  public GeneratePicArgs a;
  public GenerateThumbArgs a;
  public PublishParam a;
  public final PublishVideoEntry a;
  public final EditVideoParams.EditSource a;
  public final EditVideoParams a;
  public TribeVideoPublishParams a;
  public LpReportInfo_pf00064 a;
  public String a;
  public WeakReference<View> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  
  public GenerateContext(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = new PublishVideoEntry();
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    this.jdField_a_of_type_ComTencentMobileqqTribeDataTribeVideoPublishParams = new TribeVideoPublishParams();
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_Int = paramEditVideoParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource = paramEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public View a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
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
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_a_of_type_Int > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GenerateContext{, businessId='");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext
 * JD-Core Version:    0.7.0.1
 */