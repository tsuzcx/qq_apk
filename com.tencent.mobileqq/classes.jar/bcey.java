import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

class bcey
  implements bcfg
{
  bcey(bcew parambcew, bcfh parambcfh) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcew.a(this.jdField_a_of_type_Bcew);
        if (this.jdField_a_of_type_Bcfh != null) {
          this.jdField_a_of_type_Bcfh.b(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(bcew.a(this.jdField_a_of_type_Bcew), localArrayList) == 0)
      {
        bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        bcew.a(this.jdField_a_of_type_Bcew).a();
        if (this.jdField_a_of_type_Bcfh != null) {
          this.jdField_a_of_type_Bcfh.b(paramInt1, paramInt2);
        }
      }
      else
      {
        bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        bcew.a(this.jdField_a_of_type_Bcew);
        if (this.jdField_a_of_type_Bcfh != null)
        {
          this.jdField_a_of_type_Bcfh.b(paramInt1, paramInt2);
          continue;
          bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          bnzb.b(bcew.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          bcew.a(this.jdField_a_of_type_Bcew);
          if (this.jdField_a_of_type_Bcfh != null) {
            this.jdField_a_of_type_Bcfh.b(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcey
 * JD-Core Version:    0.7.0.1
 */