import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class azpg
  extends TransProcessorHandler
{
  public static String a;
  WeakReference<azph> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public azpg(azph paramazph, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazph);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.fileType != 56) {}
    label460:
    for (;;)
    {
      return;
      azph localazph = (azph)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localazph == null)
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
        if (i < localazph.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((azpi)localazph.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.getKeyForTransfer().equals(localObject)) {}
        }
        for (localObject = (azpi)localazph.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((azpi)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((azpi)localObject).b + " " + ((azpi)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((azpi)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((azpi)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localazph.jdField_a_of_type_Azpj == null) {
              break;
            }
            localazph.jdField_a_of_type_Azpj.a(((azpi)localObject).jdField_a_of_type_Long, (azpi)localObject);
            return;
            i += 1;
            break label93;
            ((azpi)localObject).c = 0;
            ((azpi)localObject).b = 1;
            continue;
            ((azpi)localObject).b = 4;
            ((azpi)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localFileMsg.fileID;
            ((azpi)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localFileMsg.fileUrl;
            if (((azpi)localObject).c < 100) {
              ((azpi)localObject).c = 100;
            }
            localazph.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((azpi)localObject).b = 3;
            continue;
            ((azpi)localObject).b = 2;
            ((azpi)localObject).c = ((int)(localFileMsg.transferedSize * 100L / localFileMsg.fileSize));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpg
 * JD-Core Version:    0.7.0.1
 */