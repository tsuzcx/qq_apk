import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

class bbra
  implements bbri
{
  bbra(bbqy parambbqy, bbrj parambbrj) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bbqy.a(this.jdField_a_of_type_Bbqy);
        if (this.jdField_a_of_type_Bbrj != null) {
          this.jdField_a_of_type_Bbrj.a(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(bbqy.a(this.jdField_a_of_type_Bbqy), localArrayList) == 0)
      {
        bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        bbqy.a(this.jdField_a_of_type_Bbqy).a();
        if (this.jdField_a_of_type_Bbrj != null) {
          this.jdField_a_of_type_Bbrj.a(paramInt1, paramInt2);
        }
      }
      else
      {
        bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bbqy.a(this.jdField_a_of_type_Bbqy);
        if (this.jdField_a_of_type_Bbrj != null)
        {
          this.jdField_a_of_type_Bbrj.a(paramInt1, paramInt2);
          continue;
          bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          bmbx.b(bbqy.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          bbqy.a(this.jdField_a_of_type_Bbqy);
          if (this.jdField_a_of_type_Bbrj != null) {
            this.jdField_a_of_type_Bbrj.a(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbra
 * JD-Core Version:    0.7.0.1
 */