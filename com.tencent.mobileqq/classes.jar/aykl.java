import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class aykl
  extends TransProcessorHandler
{
  public static String a;
  WeakReference<aykm> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public aykl(aykm paramaykm, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaykm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.fileType != 56) {}
    label460:
    for (;;)
    {
      return;
      aykm localaykm = (aykm)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localaykm == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localFileMsg.fileKey;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localaykm.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((aykn)localaykm.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.getKeyForTransfer().equals(localObject)) {}
        }
        for (localObject = (aykn)localaykm.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((aykn)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((aykn)localObject).b + " " + ((aykn)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((aykn)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((aykn)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localaykm.jdField_a_of_type_Ayko == null) {
              break;
            }
            localaykm.jdField_a_of_type_Ayko.a(((aykn)localObject).jdField_a_of_type_Long, (aykn)localObject);
            return;
            i += 1;
            break label93;
            ((aykn)localObject).c = 0;
            ((aykn)localObject).b = 1;
            continue;
            ((aykn)localObject).b = 4;
            ((aykn)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localFileMsg.fileID;
            ((aykn)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localFileMsg.fileUrl;
            if (((aykn)localObject).c < 100) {
              ((aykn)localObject).c = 100;
            }
            localaykm.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((aykn)localObject).b = 3;
            continue;
            ((aykn)localObject).b = 2;
            ((aykn)localObject).c = ((int)(localFileMsg.transferedSize * 100L / localFileMsg.fileSize));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykl
 * JD-Core Version:    0.7.0.1
 */