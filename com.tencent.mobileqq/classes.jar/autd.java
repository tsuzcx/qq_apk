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

public class autd
  implements Manager
{
  public autf a;
  private aywb jdField_a_of_type_Aywb = new autc(this, Looper.getMainLooper());
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<aute> jdField_a_of_type_JavaUtilVector = new Vector();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public autd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { aysv.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_Aywb);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + paramQQAppInterface + " handler:" + this.jdField_a_of_type_Aywb);
    }
  }
  
  private aute a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L;
    l = paramInt3 | l << 4;
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.i = paramCompressInfo.c;
    localaywc.jdField_a_of_type_Long = l;
    localaywc.b = 56;
    Object localObject = new lky();
    int i = 56;
    while (i >= 0)
    {
      ((lky)localObject).a((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((lky)localObject).a(paramInt2);
    ((lky)localObject).a(paramInt3);
    ((lky)localObject).a(0);
    ((lky)localObject).a(0);
    ((lky)localObject).a(paramInt1);
    localaywc.jdField_a_of_type_ArrayOfByte = ((lky)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
    localObject = new PersonalityLabelPhoto();
    ((PersonalityLabelPhoto)localObject).localThumbPath = paramCompressInfo.e;
    ((PersonalityLabelPhoto)localObject).uniseq = l;
    ((PersonalityLabelPhoto)localObject).local = true;
    aute localaute = new aute(this);
    localaute.jdField_a_of_type_Long = paramLong;
    localaute.jdField_a_of_type_Aywc = localaywc;
    localaute.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto = ((PersonalityLabelPhoto)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + paramCompressInfo.c + " uniseq:" + l);
    }
    return localaute;
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
      aute localaute = (aute)this.jdField_a_of_type_JavaUtilVector.get(i);
      if (localaute.jdField_a_of_type_Long != paramLong)
      {
        i += 1;
      }
      else
      {
        k = localaute.jdField_a_of_type_Int;
        if (k < localList.size()) {
          localList.add(k, localaute.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
        for (;;)
        {
          paramPersonalityLabelInfo.photoCount += 1;
          j += 1;
          break;
          localList.add(localaute.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
      }
    }
    return j;
  }
  
  public aute a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (aute)this.jdField_a_of_type_JavaUtilVector.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (aute)this.jdField_a_of_type_JavaUtilVector.get(i);; paramPersonalityLabelPhoto = null)
    {
      if (paramPersonalityLabelPhoto != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPersonalityLabelPhoto.jdField_a_of_type_Aywc);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "retry " + paramPersonalityLabelPhoto.jdField_a_of_type_Aywc.i);
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(autf paramautf)
  {
    this.jdField_a_of_type_Autf = paramautf;
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
      aute localaute = a((CompressInfo)paramList.get(j), paramLong, k, paramList.size(), j);
      if (localaute == null) {
        break label245;
      }
      i += 1;
      this.jdField_a_of_type_JavaUtilVector.add(0, localaute);
      localArrayList.add(0, localaute.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
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
            ((aute)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int = j;
          }
          for (;;)
          {
            j += 1;
            break;
            if (((aute)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Long == paramLong)
            {
              paramList = (aute)this.jdField_a_of_type_JavaUtilVector.get(j);
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
      if ((((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (aute)this.jdField_a_of_type_JavaUtilVector.remove(i);; paramPersonalityLabelPhoto = null)
    {
      if (i >= 0) {
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            if (((aute)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong)
            {
              aute localaute = (aute)this.jdField_a_of_type_JavaUtilVector.get(i);
              localaute.jdField_a_of_type_Int -= 1;
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPersonalityLabelPhoto.jdField_a_of_type_Aywc);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "delete " + paramPersonalityLabelPhoto.jdField_a_of_type_Aywc.i);
        }
      }
      return;
      i = -1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aywb);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + " handler:" + this.jdField_a_of_type_Aywb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autd
 * JD-Core Version:    0.7.0.1
 */