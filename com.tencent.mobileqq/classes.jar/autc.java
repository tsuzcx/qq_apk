import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class autc
  extends aywb
{
  public static String a;
  WeakReference<autd> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public autc(autd paramautd, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramautd);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if (localayqo.b != 56) {}
    label460:
    for (;;)
    {
      return;
      autd localautd = (autd)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localautd == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localayqo.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localautd.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((aute)localautd.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Aywc.a().equals(localObject)) {}
        }
        for (localObject = (aute)localautd.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((aute)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((aute)localObject).b + " " + ((aute)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((aute)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((aute)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localautd.jdField_a_of_type_Autf == null) {
              break;
            }
            localautd.jdField_a_of_type_Autf.a(((aute)localObject).jdField_a_of_type_Long, (aute)localObject);
            return;
            i += 1;
            break label93;
            ((aute)localObject).c = 0;
            ((aute)localObject).b = 1;
            continue;
            ((aute)localObject).b = 4;
            ((aute)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localayqo.d;
            ((aute)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localayqo.i;
            if (((aute)localObject).c < 100) {
              ((aute)localObject).c = 100;
            }
            localautd.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((aute)localObject).b = 3;
            continue;
            ((aute)localObject).b = 2;
            ((aute)localObject).c = ((int)(localayqo.e * 100L / localayqo.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autc
 * JD-Core Version:    0.7.0.1
 */