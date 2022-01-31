import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class awox
  extends bayj
{
  public static String a;
  WeakReference<awoy> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public awox(awoy paramawoy, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramawoy);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass = (bass)paramMessage.obj;
    if (localbass.b != 56) {}
    label460:
    for (;;)
    {
      return;
      awoy localawoy = (awoy)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localawoy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localbass.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localawoy.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((awoz)localawoy.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Bayk.a().equals(localObject)) {}
        }
        for (localObject = (awoz)localawoy.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((awoz)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((awoz)localObject).b + " " + ((awoz)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((awoz)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((awoz)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localawoy.jdField_a_of_type_Awpa == null) {
              break;
            }
            localawoy.jdField_a_of_type_Awpa.a(((awoz)localObject).jdField_a_of_type_Long, (awoz)localObject);
            return;
            i += 1;
            break label93;
            ((awoz)localObject).c = 0;
            ((awoz)localObject).b = 1;
            continue;
            ((awoz)localObject).b = 4;
            ((awoz)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localbass.d;
            ((awoz)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localbass.i;
            if (((awoz)localObject).c < 100) {
              ((awoz)localObject).c = 100;
            }
            localawoy.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((awoz)localObject).b = 3;
            continue;
            ((awoz)localObject).b = 2;
            ((awoz)localObject).c = ((int)(localbass.e * 100L / localbass.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awox
 * JD-Core Version:    0.7.0.1
 */