import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import java.util.ArrayList;

public class bmvy
  implements bcxy
{
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bmvy(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, QQAppInterface paramQQAppInterface, ResultReceiver paramResultReceiver)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("QzoneVideoSoDownloadModule", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, anzj.a(2131711388) + paramInt2 + "]");
        bcwy.b(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, new bmvz(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver));
        return;
      }
      QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, anzj.a(2131711472) + paramInt1 + "]");
      bcwy.b(1, paramInt1);
      return;
    }
    QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, anzj.a(2131711363) + paramInt2 + "]");
    bcwy.b(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvy
 * JD-Core Version:    0.7.0.1
 */