import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

class bcxq
  implements bcxy
{
  bcxq(bcxo parambcxo, bcxz parambcxz) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcxo.a(this.jdField_a_of_type_Bcxo);
        if (this.jdField_a_of_type_Bcxz != null) {
          this.jdField_a_of_type_Bcxz.b(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(bcxo.a(this.jdField_a_of_type_Bcxo), localArrayList) == 0)
      {
        bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        bcxo.a(this.jdField_a_of_type_Bcxo).a();
        if (this.jdField_a_of_type_Bcxz != null) {
          this.jdField_a_of_type_Bcxz.b(paramInt1, paramInt2);
        }
      }
      else
      {
        bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcxo.a(this.jdField_a_of_type_Bcxo);
        if (this.jdField_a_of_type_Bcxz != null)
        {
          this.jdField_a_of_type_Bcxz.b(paramInt1, paramInt2);
          continue;
          bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          bpam.b(bcxo.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          bcxo.a(this.jdField_a_of_type_Bcxo);
          if (this.jdField_a_of_type_Bcxz != null) {
            this.jdField_a_of_type_Bcxz.b(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxq
 * JD-Core Version:    0.7.0.1
 */