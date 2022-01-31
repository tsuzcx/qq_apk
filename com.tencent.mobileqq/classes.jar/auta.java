import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class auta
  extends ayvz
{
  public static String a;
  WeakReference<autb> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public auta(autb paramautb, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramautb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if (localayqm.b != 56) {}
    label460:
    for (;;)
    {
      return;
      autb localautb = (autb)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localautb == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localayqm.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localautb.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((autc)localautb.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Aywa.a().equals(localObject)) {}
        }
        for (localObject = (autc)localautb.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((autc)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((autc)localObject).b + " " + ((autc)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((autc)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((autc)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localautb.jdField_a_of_type_Autd == null) {
              break;
            }
            localautb.jdField_a_of_type_Autd.a(((autc)localObject).jdField_a_of_type_Long, (autc)localObject);
            return;
            i += 1;
            break label93;
            ((autc)localObject).c = 0;
            ((autc)localObject).b = 1;
            continue;
            ((autc)localObject).b = 4;
            ((autc)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localayqm.d;
            ((autc)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localayqm.i;
            if (((autc)localObject).c < 100) {
              ((autc)localObject).c = 100;
            }
            localautb.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((autc)localObject).b = 3;
            continue;
            ((autc)localObject).b = 2;
            ((autc)localObject).c = ((int)(localayqm.e * 100L / localayqm.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auta
 * JD-Core Version:    0.7.0.1
 */