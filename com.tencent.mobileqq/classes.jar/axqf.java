import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class axqf
  extends BaseTransFileController
{
  private NearbyAppInterface a;
  
  public axqf(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public void destroy() {}
  
  public BaseTransProcessor getProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {}
    do
    {
      return null;
      if ((paramTransferRequest.mFileType == 8) || (paramTransferRequest.mFileType == 64) || (paramTransferRequest.mFileType == 21)) {
        return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqf
 * JD-Core Version:    0.7.0.1
 */