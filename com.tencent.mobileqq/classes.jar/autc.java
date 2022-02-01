import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;

public final class autc
  implements beuq
{
  private final IHostInterface.IDownloadListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private autc(String paramString, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener = paramIDownloadListener;
  }
  
  public void onResp(bevm parambevm)
  {
    int i = 0;
    if (parambevm.jdField_a_of_type_Int == 3) {}
    label74:
    label80:
    for (;;)
    {
      return;
      boolean bool;
      if (parambevm.jdField_a_of_type_Int == 0)
      {
        bool = true;
        if (!bool) {
          break label74;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener == null) {
          break label80;
        }
        if (bool) {
          this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, parambevm.jdField_a_of_type_Long, 1.0F);
        }
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadFinished(this.jdField_a_of_type_JavaLangString, bool, i);
        return;
        bool = false;
        break;
        i = parambevm.b;
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L)
    {
      float f = (float)paramLong1 / (float)paramLong2;
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, paramLong2, f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autc
 * JD-Core Version:    0.7.0.1
 */