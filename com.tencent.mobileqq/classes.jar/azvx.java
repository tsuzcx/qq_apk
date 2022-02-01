import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.1;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class azvx
  implements Manager
{
  public azvz a;
  private beyf jdField_a_of_type_Beyf = new azvw(this, Looper.getMainLooper());
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<azvy> jdField_a_of_type_JavaUtilVector = new Vector();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public azvx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { bevi.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_Beyf);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + paramQQAppInterface + " handler:" + this.jdField_a_of_type_Beyf);
    }
  }
  
  private azvy a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L;
    l = paramInt3 | l << 4;
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.i = paramCompressInfo.c;
    localbeyg.jdField_a_of_type_Long = l;
    localbeyg.b = 56;
    Object localObject = new lkj();
    int i = 56;
    while (i >= 0)
    {
      ((lkj)localObject).a((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((lkj)localObject).a(paramInt2);
    ((lkj)localObject).a(paramInt3);
    ((lkj)localObject).a(0);
    ((lkj)localObject).a(0);
    ((lkj)localObject).a(paramInt1);
    localbeyg.jdField_a_of_type_ArrayOfByte = ((lkj)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
    localObject = new PersonalityLabelPhoto();
    ((PersonalityLabelPhoto)localObject).localThumbPath = paramCompressInfo.e;
    ((PersonalityLabelPhoto)localObject).uniseq = l;
    ((PersonalityLabelPhoto)localObject).local = true;
    azvy localazvy = new azvy(this);
    localazvy.jdField_a_of_type_Long = paramLong;
    localazvy.jdField_a_of_type_Beyg = localbeyg;
    localazvy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto = ((PersonalityLabelPhoto)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + paramCompressInfo.c + " uniseq:" + l);
    }
    return localazvy;
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
      azvy localazvy = (azvy)this.jdField_a_of_type_JavaUtilVector.get(i);
      if (localazvy.jdField_a_of_type_Long != paramLong)
      {
        i += 1;
      }
      else
      {
        k = localazvy.jdField_a_of_type_Int;
        if (k < localList.size()) {
          localList.add(k, localazvy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
        for (;;)
        {
          paramPersonalityLabelInfo.photoCount += 1;
          j += 1;
          break;
          localList.add(localazvy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
      }
    }
    return j;
  }
  
  public azvy a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (azvy)this.jdField_a_of_type_JavaUtilVector.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (azvy)this.jdField_a_of_type_JavaUtilVector.get(i);; paramPersonalityLabelPhoto = null)
    {
      if (paramPersonalityLabelPhoto != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPersonalityLabelPhoto.jdField_a_of_type_Beyg);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "retry " + paramPersonalityLabelPhoto.jdField_a_of_type_Beyg.i);
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(azvz paramazvz)
  {
    this.jdField_a_of_type_Azvz = paramazvz;
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
      azvy localazvy = a((CompressInfo)paramList.get(j), paramLong, k, paramList.size(), j);
      if (localazvy == null) {
        break label245;
      }
      i += 1;
      this.jdField_a_of_type_JavaUtilVector.add(0, localazvy);
      localArrayList.add(0, localazvy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
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
            ((azvy)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int = j;
          }
          for (;;)
          {
            j += 1;
            break;
            if (((azvy)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Long == paramLong)
            {
              paramList = (azvy)this.jdField_a_of_type_JavaUtilVector.get(j);
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
      if ((((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (azvy)this.jdField_a_of_type_JavaUtilVector.remove(i);; paramPersonalityLabelPhoto = null)
    {
      if (i >= 0) {
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            if (((azvy)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong)
            {
              azvy localazvy = (azvy)this.jdField_a_of_type_JavaUtilVector.get(i);
              localazvy.jdField_a_of_type_Int -= 1;
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPersonalityLabelPhoto.jdField_a_of_type_Beyg);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "delete " + paramPersonalityLabelPhoto.jdField_a_of_type_Beyg.i);
        }
      }
      return;
      i = -1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Beyf);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + " handler:" + this.jdField_a_of_type_Beyf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvx
 * JD-Core Version:    0.7.0.1
 */