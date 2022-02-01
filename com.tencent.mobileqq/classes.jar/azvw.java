import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class azvw
  extends beyf
{
  public static String a;
  WeakReference<azvx> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public azvw(azvx paramazvx, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazvx);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if (localbete.b != 56) {}
    label460:
    for (;;)
    {
      return;
      azvx localazvx = (azvx)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localazvx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localbete.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localazvx.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((azvy)localazvx.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Beyg.a().equals(localObject)) {}
        }
        for (localObject = (azvy)localazvx.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((azvy)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((azvy)localObject).b + " " + ((azvy)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((azvy)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((azvy)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localazvx.jdField_a_of_type_Azvz == null) {
              break;
            }
            localazvx.jdField_a_of_type_Azvz.a(((azvy)localObject).jdField_a_of_type_Long, (azvy)localObject);
            return;
            i += 1;
            break label93;
            ((azvy)localObject).c = 0;
            ((azvy)localObject).b = 1;
            continue;
            ((azvy)localObject).b = 4;
            ((azvy)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localbete.d;
            ((azvy)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localbete.i;
            if (((azvy)localObject).c < 100) {
              ((azvy)localObject).c = 100;
            }
            localazvx.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((azvy)localObject).b = 3;
            continue;
            ((azvy)localObject).b = 2;
            ((azvy)localObject).c = ((int)(localbete.e * 100L / localbete.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvw
 * JD-Core Version:    0.7.0.1
 */