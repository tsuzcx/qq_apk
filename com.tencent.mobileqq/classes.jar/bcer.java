import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import java.util.Map;

class bcer
  implements ISPlayerDownloader.Listener
{
  bcer(bcep parambcep, bcev parambcev) {}
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadError, preLoadId = " + this.jdField_a_of_type_Bcev.f + " , uniseq = " + this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", moduleID = " + paramInt1 + ", errorCode = " + paramInt2 + ", extInfo = " + paramString);
    }
    if ((this.jdField_a_of_type_Bcev != null) && (this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu != null)) {
      this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu.a(paramInt2);
    }
  }
  
  public void onDownloadFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadFinish, preLoadId = " + this.jdField_a_of_type_Bcev.f + " , uniseq = " + this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if ((this.jdField_a_of_type_Bcev != null) && (this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu != null)) {
      this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu.a(0);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.jdField_a_of_type_Bcev.f + " , uniseq = " + this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + "currentDownloadSizeByte = " + paramLong1 + ", totalFileSizeByte = " + paramLong2);
    }
    if ((this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu != null) && (this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      if (paramLong1 <= this.jdField_a_of_type_Bcev.jdField_a_of_type_Long) {
        break label233;
      }
      this.jdField_a_of_type_Bcev.jdField_a_of_type_Long = paramLong1;
    }
    for (;;)
    {
      paramLong2 = this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
      if ((paramLong2 > 0L) && (paramLong1 <= paramLong2))
      {
        paramInt1 = (int)(paramLong1 * 1.0D / paramLong2 * 100.0D);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.jdField_a_of_type_Bcev.f + ", pogress = " + paramInt1 + " , uniseq = " + this.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        }
        this.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu.b(paramInt1);
      }
      return;
      label233:
      paramLong1 = this.jdField_a_of_type_Bcev.jdField_a_of_type_Long;
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcer
 * JD-Core Version:    0.7.0.1
 */