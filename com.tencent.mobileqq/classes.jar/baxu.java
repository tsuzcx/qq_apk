import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.FaceDecodeTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public final class baxu
  extends MqqHandler
{
  public baxu(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    label4:
    baxv localbaxv;
    label143:
    label150:
    do
    {
      do
      {
        int i;
        do
        {
          break label4;
          do
          {
            return;
          } while (paramMessage.what != FaceDecodeTask.jdField_a_of_type_Int);
          if (FaceDecodeTask.b.size() <= 0) {
            break label150;
          }
          i = 0;
          if (i >= FaceDecodeTask.b.size()) {
            break label143;
          }
          paramMessage = (FaceDecodeTask)FaceDecodeTask.b.get(i);
          if ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
            break;
          }
          localbaxv = (baxv)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localbaxv == null);
        if (paramMessage.jdField_a_of_type_Boolean)
        {
          paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b = 2;
          localbaxv.a(FaceDecodeTask.a(paramMessage), paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          localbaxv.a(paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        FaceDecodeTask.b.clear();
        return;
        paramMessage = (FaceDecodeTask)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      localbaxv = (baxv)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbaxv == null);
    if (paramMessage.jdField_a_of_type_Boolean)
    {
      paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b = 2;
      localbaxv.a(FaceDecodeTask.a(paramMessage), paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
      return;
    }
    localbaxv.a(paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxu
 * JD-Core Version:    0.7.0.1
 */