import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.1;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class azph
  implements Manager
{
  public azpj a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new azpg(this, Looper.getMainLooper());
  Vector<azpi> jdField_a_of_type_JavaUtilVector = new Vector();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public azph(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    paramQQAppInterface.getTransFileController().addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + paramQQAppInterface + " handler:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
  
  private azpi a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L;
    l = paramInt3 | l << 4;
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramCompressInfo.c;
    localTransferRequest.mUniseq = l;
    localTransferRequest.mFileType = 56;
    Object localObject = new lkp();
    int i = 56;
    while (i >= 0)
    {
      ((lkp)localObject).a((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((lkp)localObject).a(paramInt2);
    ((lkp)localObject).a(paramInt3);
    ((lkp)localObject).a(0);
    ((lkp)localObject).a(0);
    ((lkp)localObject).a(paramInt1);
    localTransferRequest.mExtentionInfo = ((lkp)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
    localObject = new PersonalityLabelPhoto();
    ((PersonalityLabelPhoto)localObject).localThumbPath = paramCompressInfo.e;
    ((PersonalityLabelPhoto)localObject).uniseq = l;
    ((PersonalityLabelPhoto)localObject).local = true;
    azpi localazpi = new azpi(this);
    localazpi.jdField_a_of_type_Long = paramLong;
    localazpi.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = localTransferRequest;
    localazpi.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto = ((PersonalityLabelPhoto)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + paramCompressInfo.c + " uniseq:" + l);
    }
    return localazpi;
  }
  
  public int a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, boolean paramBoolean)
  {
    int k = 0;
    List localList = paramPersonalityLabelInfo.personalityLabelPhotos;
    if ((!paramBoolean) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        if (((PersonalityLabelPhoto)localList.get(i)).fileId == -1L)
        {
          localList.remove(i);
          paramPersonalityLabelInfo.photoCount -= 1;
        }
        i -= 1;
      }
    }
    int j = 0;
    int i = k;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      azpi localazpi = (azpi)this.jdField_a_of_type_JavaUtilVector.get(i);
      if (localazpi.jdField_a_of_type_Long != paramLong)
      {
        i += 1;
      }
      else
      {
        k = localazpi.jdField_a_of_type_Int;
        if (k < localList.size()) {
          localList.add(k, localazpi.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
        for (;;)
        {
          paramPersonalityLabelInfo.photoCount += 1;
          j += 1;
          break;
          localList.add(localazpi.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
      }
    }
    return j;
  }
  
  public azpi a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (azpi)this.jdField_a_of_type_JavaUtilVector.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (azpi)this.jdField_a_of_type_JavaUtilVector.get(i);; paramPersonalityLabelPhoto = null)
    {
      if (paramPersonalityLabelPhoto != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "retry " + paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(azpj paramazpj)
  {
    this.jdField_a_of_type_Azpj = paramazpj;
  }
  
  public boolean a(List<CompressInfo> paramList, long paramLong)
  {
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    int k = (int)(System.currentTimeMillis() / 1000L);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      azpi localazpi = a((CompressInfo)paramList.get(j), paramLong, k, paramList.size(), j);
      if (localazpi == null) {
        break label245;
      }
      i += 1;
      this.jdField_a_of_type_JavaUtilVector.add(0, localazpi);
      localArrayList.add(0, localazpi.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
    }
    label245:
    for (;;)
    {
      j += 1;
      break;
      if (i > 0)
      {
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          if (j < i) {
            ((azpi)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int = j;
          }
          for (;;)
          {
            j += 1;
            break;
            if (((azpi)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Long == paramLong)
            {
              paramList = (azpi)this.jdField_a_of_type_JavaUtilVector.get(j);
              paramList.jdField_a_of_type_Int += i;
            }
          }
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new PLUploadManager.1(this, localArrayList, paramLong));
      }
      if (localArrayList.size() > 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (azpi)this.jdField_a_of_type_JavaUtilVector.remove(i);; paramPersonalityLabelPhoto = null)
    {
      if (i >= 0) {
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            if (((azpi)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong)
            {
              azpi localazpi = (azpi)this.jdField_a_of_type_JavaUtilVector.get(i);
              localazpi.jdField_a_of_type_Int -= 1;
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      if (paramPersonalityLabelPhoto != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().stop(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "delete " + paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        }
      }
      return;
      i = -1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + " handler:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azph
 * JD-Core Version:    0.7.0.1
 */