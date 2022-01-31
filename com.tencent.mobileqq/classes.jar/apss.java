import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class apss
  extends apsu
{
  int jdField_a_of_type_Int;
  public apsr a;
  private apte jdField_a_of_type_Apte;
  List<apsr> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public apsr b;
  List<apsr> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  
  public apss(boolean paramBoolean, apte paramapte)
  {
    this.d = paramBoolean;
    this.jdField_a_of_type_Apte = paramapte;
  }
  
  public static boolean a(GalleryBaseData paramGalleryBaseData)
  {
    if (paramGalleryBaseData == null) {}
    while ((paramGalleryBaseData.a() != 1) && (paramGalleryBaseData.a() != 3) && (paramGalleryBaseData.a() != 2) && (paramGalleryBaseData.a() != 4)) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        GalleryBaseData localGalleryBaseData = ((apsr)localIterator.next()).a;
        if ((localGalleryBaseData != null) && (paramLong == localGalleryBaseData.jdField_a_of_type_Long)) {
          return localGalleryBaseData.a();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        GalleryBaseData localGalleryBaseData = ((apsr)localIterator.next()).a;
        if ((localGalleryBaseData != null) && (paramLong == localGalleryBaseData.jdField_a_of_type_Long) && (paramInt == localGalleryBaseData.jdField_a_of_type_Int)) {
          return localGalleryBaseData.a();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = localList.get(i);
      if (!apsr.class.isInstance(localObject)) {}
      label116:
      do
      {
        do
        {
          do
          {
            do
            {
              i += 1;
              break;
              localObject = ((apsr)localObject).a;
              if (!AIOPicData.class.isInstance(localObject)) {
                break label116;
              }
              localObject = (AIOPicData)localObject;
            } while ((((AIOPicData)localObject).jdField_a_of_type_Long != paramLong) || (((AIOPicData)localObject).jdField_a_of_type_Int != paramInt1));
            new apsz().a((AIOPicData)localObject, paramInt2, paramString);
            return i;
            if (!AIOShortVideoData.class.isInstance(localObject)) {
              break label162;
            }
            localObject = (AIOShortVideoData)localObject;
          } while (((AIOShortVideoData)localObject).jdField_a_of_type_Long != paramLong);
          new aptd().a((AIOShortVideoData)localObject, paramInt2, paramString);
          return i;
          if (!AIOFilePicData.class.isInstance(localObject)) {
            break label208;
          }
          localObject = (AIOFilePicData)localObject;
        } while (((AIOFilePicData)localObject).jdField_a_of_type_Long != paramLong);
        new apsy().a((AIOFilePicData)localObject, paramInt2, paramString);
        return i;
      } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_a_of_type_Long != paramLong));
      label162:
      label208:
      return i;
    }
    return -1;
  }
  
  public apsr a()
  {
    return this.jdField_b_of_type_Apsr;
  }
  
  public apsr a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (apsr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public apsr a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        apsr localapsr = (apsr)localIterator.next();
        if ((localapsr.a != null) && (paramLong == localapsr.a.jdField_a_of_type_Long)) {
          return localapsr;
        }
      }
    }
    return null;
  }
  
  public apsr a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        apsr localapsr = (apsr)localIterator.next();
        if ((localapsr.a != null) && (paramLong1 == localapsr.a.jdField_a_of_type_Long) && (paramLong2 == localapsr.a.jdField_a_of_type_Int)) {
          return localapsr;
        }
      }
    }
    return null;
  }
  
  public List<apsr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<apsr> a(List<apsr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        apsr localapsr = (apsr)paramList.next();
        if (a(localapsr.a)) {
          localArrayList.add(localapsr);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Apsr = a(paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        apsr localapsr = (apsr)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localapsr.a != null) && (paramLong == localapsr.a.jdField_a_of_type_Long) && (paramInt1 == localapsr.a.jdField_a_of_type_Int)) {
          ((apsr)this.jdField_a_of_type_JavaUtilList.get(i)).a.a(paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(apsr paramapsr)
  {
    if ((paramapsr != null) && (paramapsr.a != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        apsr localapsr = (apsr)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localapsr.a != null) && (paramapsr.a.jdField_a_of_type_Long == localapsr.a.jdField_a_of_type_Long) && (paramapsr.a.jdField_a_of_type_Int == localapsr.a.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_JavaUtilList.set(i, paramapsr);
        }
        i += 1;
      }
    }
  }
  
  public void a(apsr paramapsr, int paramInt)
  {
    if ((paramapsr != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if ((paramInt >= 0) && (paramInt < i)) {
        this.jdField_a_of_type_JavaUtilList.set(paramInt, paramapsr);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1 - this.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      i = this.jdField_b_of_type_JavaUtilList.size();
    } while (i <= 0);
    this.jdField_b_of_type_Int += i;
    this.jdField_c_of_type_Int = (i + this.jdField_c_of_type_Int);
    List localList = a(this.jdField_b_of_type_JavaUtilList);
    if (this.jdField_b_of_type_Boolean)
    {
      Collections.reverse(localList);
      this.jdField_a_of_type_JavaUtilList.addAll(localList);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      return true;
      this.jdField_a_of_type_Int += localList.size();
      this.jdField_a_of_type_JavaUtilList.addAll(0, localList);
    }
  }
  
  public boolean a(apsr paramapsr)
  {
    return (paramapsr != null) && (paramapsr.a != null) && ((paramapsr.a.a() == 2) || (paramapsr.a.a() == 4));
  }
  
  public boolean a(GalleryBaseData[] paramArrayOfGalleryBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfGalleryBaseData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if ((this.jdField_a_of_type_Apsr == null) || (this.jdField_b_of_type_Apsr == null))
      {
        localObject = new apsr((GalleryBaseData)localObject);
        this.jdField_b_of_type_Apsr = ((apsr)localObject);
        this.jdField_a_of_type_Apsr = ((apsr)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfGalleryBaseData.length)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new apsr((GalleryBaseData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Apsr.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_Apsr == this.jdField_b_of_type_Apsr) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_Apsr);
        }
        else if ((this.jdField_b_of_type_Apsr.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_b_of_type_Apsr.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_Apsr);
        }
        else
        {
          localArrayList.add(new apsr((GalleryBaseData)localObject));
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfGalleryBaseData.length)) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList);
    }
    while (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_Apsr != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Apsr);
    }
    if (a(a(this.jdField_a_of_type_Int))) {
      a(this.jdField_b_of_type_Apsr, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public apsr b()
  {
    return this.jdField_a_of_type_Apsr;
  }
  
  public apsr b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          apsr localapsr = (apsr)localIterator.next();
          if (localapsr.a.jdField_a_of_type_Long != paramLong) {
            continue;
          }
          if (localapsr != null) {
            this.jdField_a_of_type_JavaUtilList.remove(localapsr);
          }
          return localapsr;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(apsr paramapsr)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Apsr = paramapsr;
    this.jdField_b_of_type_Apsr.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Apsr = this.jdField_b_of_type_Apsr;
    this.jdField_a_of_type_JavaUtilList.add(paramapsr);
  }
  
  public void c(apsr paramapsr)
  {
    if (a(paramapsr))
    {
      if (paramapsr.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramapsr.a).f = true;
    }
    label31:
    while (paramapsr.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramapsr.a).l = true;
  }
  
  public void d(apsr paramapsr)
  {
    if (a(paramapsr))
    {
      if (paramapsr.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramapsr.a).g = true;
    }
    label31:
    while (paramapsr.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramapsr.a).m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apss
 * JD-Core Version:    0.7.0.1
 */