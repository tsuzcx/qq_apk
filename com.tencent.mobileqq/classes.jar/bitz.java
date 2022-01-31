import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.lang.ref.WeakReference;

public class bitz
{
  public final int a;
  public long a;
  public biuf a;
  public biuh a;
  public final PublishVideoEntry a;
  public TribeVideoPublishParams a;
  public LpReportInfo_pf00064 a;
  public final EditVideoParams.EditSource a;
  public final EditVideoParams a;
  public PublishParam a;
  public String a;
  public WeakReference<View> a;
  public boolean a;
  public int b = 1;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public bitz(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = new PublishVideoEntry();
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    this.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams = new TribeVideoPublishParams();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_Int = paramEditVideoParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLabel = paramEditVideoParams.a("story_default_label");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
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
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Biuf.jdField_a_of_type_Int > 0);
  }
  
  public String toString()
  {
    return "GenerateContext{, businessId='" + this.jdField_a_of_type_Int + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitz
 * JD-Core Version:    0.7.0.1
 */