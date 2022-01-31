import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class awko
  extends baua
{
  public static String a;
  WeakReference<awkp> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public awko(awkp paramawkp, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramawkp);
  }
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if (localbaoj.b != 56) {}
    label460:
    for (;;)
    {
      return;
      awkp localawkp = (awkp)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localawkp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localbaoj.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localawkp.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((awkq)localawkp.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Baub.a().equals(localObject)) {}
        }
        for (localObject = (awkq)localawkp.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((awkq)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((awkq)localObject).b + " " + ((awkq)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((awkq)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((awkq)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localawkp.jdField_a_of_type_Awkr == null) {
              break;
            }
            localawkp.jdField_a_of_type_Awkr.a(((awkq)localObject).jdField_a_of_type_Long, (awkq)localObject);
            return;
            i += 1;
            break label93;
            ((awkq)localObject).c = 0;
            ((awkq)localObject).b = 1;
            continue;
            ((awkq)localObject).b = 4;
            ((awkq)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localbaoj.d;
            ((awkq)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localbaoj.i;
            if (((awkq)localObject).c < 100) {
              ((awkq)localObject).c = 100;
            }
            localawkp.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((awkq)localObject).b = 3;
            continue;
            ((awkq)localObject).b = 2;
            ((awkq)localObject).c = ((int)(localbaoj.e * 100L / localbaoj.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awko
 * JD-Core Version:    0.7.0.1
 */