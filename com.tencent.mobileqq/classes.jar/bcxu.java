import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

class bcxu
  implements bcyc
{
  bcxu(bcxs parambcxs, bcyd parambcyd) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcxs.a(this.jdField_a_of_type_Bcxs);
        if (this.jdField_a_of_type_Bcyd != null) {
          this.jdField_a_of_type_Bcyd.a(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(bcxs.a(this.jdField_a_of_type_Bcxs), localArrayList) == 0)
      {
        bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        bcxs.a(this.jdField_a_of_type_Bcxs).a();
        if (this.jdField_a_of_type_Bcyd != null) {
          this.jdField_a_of_type_Bcyd.a(paramInt1, paramInt2);
        }
      }
      else
      {
        bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcxs.a(this.jdField_a_of_type_Bcxs);
        if (this.jdField_a_of_type_Bcyd != null)
        {
          this.jdField_a_of_type_Bcyd.a(paramInt1, paramInt2);
          continue;
          bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          bnrh.b(bcxs.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          bcxs.a(this.jdField_a_of_type_Bcxs);
          if (this.jdField_a_of_type_Bcyd != null) {
            this.jdField_a_of_type_Bcyd.a(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxu
 * JD-Core Version:    0.7.0.1
 */