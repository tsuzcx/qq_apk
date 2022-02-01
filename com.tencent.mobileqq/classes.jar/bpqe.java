import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class bpqe
  extends bpmr
{
  private float jdField_a_of_type_Float = 0.0F;
  private brhk jdField_a_of_type_Brhk = new bpqf(this);
  private brhn jdField_a_of_type_Brhn = (brhn)bplq.a(3);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bplq.a();
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = this.jdField_a_of_type_Brhn.a(paramString);
  private int d = 2;
  
  public bpqe(String paramString)
  {
    super(null);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)) {
      this.d = 3;
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) {
      return;
    }
    this.d = 3;
  }
  
  public float a()
  {
    try
    {
      float f = this.jdField_a_of_type_Float;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131364134);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (paramActivity != null))
    {
      String str = brhn.a + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      paramActivity.setFaceEffect(str);
      this.jdField_a_of_type_Brhn.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Brhn.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId, str);
      return 0;
    }
    return -1;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131364134);
    if ((paramActivity != null) && (!paramActivity.k()))
    {
      paramActivity.setFaceEffect("");
      this.jdField_a_of_type_Brhn.a("0", 0, "");
      bplz.c = 0;
    }
  }
  
  public int b()
  {
    for (;;)
    {
      try
      {
        int i;
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null)
        {
          this.d = 3;
          i = this.d;
          return i;
        }
        if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
        {
          this.jdField_a_of_type_Brhn.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_Brhk);
          a();
          this.d = 1;
          i = this.d;
          continue;
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading)
        {
          this.d = 1;
          continue;
        }
        this.jdField_a_of_type_Float = 1.0F;
      }
      finally {}
      this.d = 3;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqe
 * JD-Core Version:    0.7.0.1
 */