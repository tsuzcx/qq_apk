import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class bhjz
  extends bhgn
{
  private float jdField_a_of_type_Float = 0.0F;
  private bjik jdField_a_of_type_Bjik = new bhka(this);
  private bjin jdField_a_of_type_Bjin = (bjin)bhfm.a(3);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bhfm.a();
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = this.jdField_a_of_type_Bjin.a(paramString);
  private int d = 2;
  
  public bhjz(String paramString)
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
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131298277);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (paramActivity != null))
    {
      String str = bjin.a + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      paramActivity.setFaceEffect(str);
      this.jdField_a_of_type_Bjin.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_Bjin.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId, str);
      return 0;
    }
    return -1;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131298277);
    if ((paramActivity != null) && (!paramActivity.k()))
    {
      paramActivity.setFaceEffect("");
      this.jdField_a_of_type_Bjin.a("0", 0, "");
      bhfv.c = 0;
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
          this.jdField_a_of_type_Bjin.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_Bjik);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjz
 * JD-Core Version:    0.7.0.1
 */