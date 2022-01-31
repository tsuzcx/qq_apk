import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class atvc
  extends axvs
{
  public static String a;
  WeakReference<atvd> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public atvc(atvd paramatvd, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramatvd);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if (localaxqf.b != 56) {}
    label460:
    for (;;)
    {
      return;
      atvd localatvd = (atvd)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localatvd == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localaxqf.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localatvd.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((atve)localatvd.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Axvt.a().equals(localObject)) {}
        }
        for (localObject = (atve)localatvd.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((atve)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((atve)localObject).b + " " + ((atve)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((atve)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((atve)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localatvd.jdField_a_of_type_Atvf == null) {
              break;
            }
            localatvd.jdField_a_of_type_Atvf.a(((atve)localObject).jdField_a_of_type_Long, (atve)localObject);
            return;
            i += 1;
            break label93;
            ((atve)localObject).c = 0;
            ((atve)localObject).b = 1;
            continue;
            ((atve)localObject).b = 4;
            ((atve)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localaxqf.d;
            ((atve)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localaxqf.i;
            if (((atve)localObject).c < 100) {
              ((atve)localObject).c = 100;
            }
            localatvd.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((atve)localObject).b = 3;
            continue;
            ((atve)localObject).b = 2;
            ((atve)localObject).c = ((int)(localaxqf.e * 100L / localaxqf.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvc
 * JD-Core Version:    0.7.0.1
 */