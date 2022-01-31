import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;

public final class apjx
  implements aysc
{
  private final IHostInterface.IDownloadListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private apjx(String paramString, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener = paramIDownloadListener;
  }
  
  public void onResp(aysz paramaysz)
  {
    int i = 0;
    if (paramaysz.jdField_a_of_type_Int == 3) {}
    label74:
    label80:
    for (;;)
    {
      return;
      boolean bool;
      if (paramaysz.jdField_a_of_type_Int == 0)
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
          this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, paramaysz.jdField_a_of_type_Long, 1.0F);
        }
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IDownloadListener.onDownloadFinished(this.jdField_a_of_type_JavaLangString, bool, i);
        return;
        bool = false;
        break;
        i = paramaysz.b;
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
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
 * Qualified Name:     apjx
 * JD-Core Version:    0.7.0.1
 */