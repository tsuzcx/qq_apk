import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public final class aoob
  extends MqqHandler
{
  public aoob(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    label4:
    aooc localaooc;
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
          if ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
            break;
          }
          localaooc = (aooc)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localaooc == null);
        if (paramMessage.jdField_a_of_type_Boolean)
        {
          paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.b = 2;
          localaooc.a(FaceDecodeTask.a(paramMessage), paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          localaooc.a(paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        FaceDecodeTask.b.clear();
        return;
        paramMessage = (FaceDecodeTask)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      localaooc = (aooc)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localaooc == null);
    if (paramMessage.jdField_a_of_type_Boolean)
    {
      paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.b = 2;
      localaooc.a(FaceDecodeTask.a(paramMessage), paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
      return;
    }
    localaooc.a(paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoob
 * JD-Core Version:    0.7.0.1
 */