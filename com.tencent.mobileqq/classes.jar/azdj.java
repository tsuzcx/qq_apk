import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class azdj
  extends bdzm
{
  public static String a;
  WeakReference<azdk> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public azdj(azdk paramazdk, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazdk);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if (localbduk.b != 56) {}
    label460:
    for (;;)
    {
      return;
      azdk localazdk = (azdk)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localazdk == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localbduk.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localazdk.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((azdl)localazdk.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Bdzn.a().equals(localObject)) {}
        }
        for (localObject = (azdl)localazdk.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((azdl)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((azdl)localObject).b + " " + ((azdl)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((azdl)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((azdl)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localazdk.jdField_a_of_type_Azdm == null) {
              break;
            }
            localazdk.jdField_a_of_type_Azdm.a(((azdl)localObject).jdField_a_of_type_Long, (azdl)localObject);
            return;
            i += 1;
            break label93;
            ((azdl)localObject).c = 0;
            ((azdl)localObject).b = 1;
            continue;
            ((azdl)localObject).b = 4;
            ((azdl)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localbduk.d;
            ((azdl)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localbduk.i;
            if (((azdl)localObject).c < 100) {
              ((azdl)localObject).c = 100;
            }
            localazdk.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((azdl)localObject).b = 3;
            continue;
            ((azdl)localObject).b = 2;
            ((azdl)localObject).c = ((int)(localbduk.e * 100L / localbduk.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdj
 * JD-Core Version:    0.7.0.1
 */