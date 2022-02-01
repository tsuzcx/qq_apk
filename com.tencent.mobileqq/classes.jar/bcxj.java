import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import java.util.Map;

class bcxj
  implements ISPlayerDownloader.Listener
{
  bcxj(bcxh parambcxh, bcxn parambcxn) {}
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadError, preLoadId = " + this.jdField_a_of_type_Bcxn.f + " , uniseq = " + this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", moduleID = " + paramInt2 + ", errorCode = " + paramInt3 + ", extInfo = " + paramString);
    }
    if ((this.jdField_a_of_type_Bcxn != null) && (this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm != null)) {
      this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm.a(paramInt3);
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadFinish, preLoadId = " + this.jdField_a_of_type_Bcxn.f + " , uniseq = " + this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if ((this.jdField_a_of_type_Bcxn != null) && (this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm != null)) {
      this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm.a(0);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.jdField_a_of_type_Bcxn.f + " , uniseq = " + this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + "currentDownloadSizeByte = " + paramLong1 + ", totalFileSizeByte = " + paramLong2);
    }
    if ((this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm != null) && (this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      if (paramLong1 <= this.jdField_a_of_type_Bcxn.jdField_a_of_type_Long) {
        break label238;
      }
      this.jdField_a_of_type_Bcxn.jdField_a_of_type_Long = paramLong1;
    }
    for (;;)
    {
      paramLong2 = this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
      if ((paramLong2 > 0L) && (paramLong1 <= paramLong2))
      {
        paramInt1 = (int)(paramLong1 * 1.0D / paramLong2 * 100.0D);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.jdField_a_of_type_Bcxn.f + ", pogress = " + paramInt1 + " , uniseq = " + this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        }
        this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm.b(paramInt1);
      }
      return;
      label238:
      paramLong1 = this.jdField_a_of_type_Bcxn.jdField_a_of_type_Long;
    }
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxj
 * JD-Core Version:    0.7.0.1
 */