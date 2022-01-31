import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import java.util.ArrayList;

public class bhbc
  implements axes
{
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bhbc(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, QQAppInterface paramQQAppInterface, ResultReceiver paramResultReceiver)
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
        QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, ajya.a(2131712516) + paramInt2 + "]");
        axdu.b(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, new bhbd(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver));
        return;
      }
      QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, ajya.a(2131712600) + paramInt1 + "]");
      axdu.b(1, paramInt1);
      return;
    }
    QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -2, ajya.a(2131712491) + paramInt2 + "]");
    axdu.b(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbc
 * JD-Core Version:    0.7.0.1
 */