import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aqmj
  extends aqml
{
  int jdField_a_of_type_Int;
  public aqmi a;
  private aqnf jdField_a_of_type_Aqnf;
  List<aqmi> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public aqmi b;
  List<aqmi> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  
  public aqmj(boolean paramBoolean, aqnf paramaqnf)
  {
    this.d = paramBoolean;
    this.jdField_a_of_type_Aqnf = paramaqnf;
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
        GalleryBaseData localGalleryBaseData = ((aqmi)localIterator.next()).a;
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
        GalleryBaseData localGalleryBaseData = ((aqmi)localIterator.next()).a;
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
      if (!aqmi.class.isInstance(localObject)) {}
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
              localObject = ((aqmi)localObject).a;
              if (!AIOPicData.class.isInstance(localObject)) {
                break label116;
              }
              localObject = (AIOPicData)localObject;
            } while ((((AIOPicData)localObject).jdField_a_of_type_Long != paramLong) || (((AIOPicData)localObject).jdField_a_of_type_Int != paramInt1));
            new aqmq().a((AIOPicData)localObject, paramInt2, paramString);
            return i;
            if (!AIOShortVideoData.class.isInstance(localObject)) {
              break label162;
            }
            localObject = (AIOShortVideoData)localObject;
          } while (((AIOShortVideoData)localObject).jdField_a_of_type_Long != paramLong);
          new aqmu().a((AIOShortVideoData)localObject, paramInt2, paramString);
          return i;
          if (!AIOFilePicData.class.isInstance(localObject)) {
            break label208;
          }
          localObject = (AIOFilePicData)localObject;
        } while (((AIOFilePicData)localObject).jdField_a_of_type_Long != paramLong);
        new aqmp().a((AIOFilePicData)localObject, paramInt2, paramString);
        return i;
      } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_a_of_type_Long != paramLong));
      label162:
      label208:
      return i;
    }
    return -1;
  }
  
  public aqmi a()
  {
    return this.jdField_b_of_type_Aqmi;
  }
  
  public aqmi a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (aqmi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public aqmi a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmi localaqmi = (aqmi)localIterator.next();
        if ((localaqmi.a != null) && (paramLong == localaqmi.a.jdField_a_of_type_Long)) {
          return localaqmi;
        }
      }
    }
    return null;
  }
  
  public aqmi a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmi localaqmi = (aqmi)localIterator.next();
        if ((localaqmi.a != null) && (paramLong1 == localaqmi.a.jdField_a_of_type_Long) && (paramLong2 == localaqmi.a.jdField_a_of_type_Int)) {
          return localaqmi;
        }
      }
    }
    return null;
  }
  
  public List<aqmi> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<aqmi> a(List<aqmi> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aqmi localaqmi = (aqmi)paramList.next();
        if (a(localaqmi.a)) {
          localArrayList.add(localaqmi);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Aqmi = a(paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        aqmi localaqmi = (aqmi)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localaqmi.a != null) && (paramLong == localaqmi.a.jdField_a_of_type_Long) && (paramInt1 == localaqmi.a.jdField_a_of_type_Int)) {
          ((aqmi)this.jdField_a_of_type_JavaUtilList.get(i)).a.a(paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(aqmi paramaqmi)
  {
    if ((paramaqmi != null) && (paramaqmi.a != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        aqmi localaqmi = (aqmi)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localaqmi.a != null) && (paramaqmi.a.jdField_a_of_type_Long == localaqmi.a.jdField_a_of_type_Long) && (paramaqmi.a.jdField_a_of_type_Int == localaqmi.a.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_JavaUtilList.set(i, paramaqmi);
        }
        i += 1;
      }
    }
  }
  
  public void a(aqmi paramaqmi, int paramInt)
  {
    if ((paramaqmi != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if ((paramInt >= 0) && (paramInt < i)) {
        this.jdField_a_of_type_JavaUtilList.set(paramInt, paramaqmi);
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
  
  public boolean a(aqmi paramaqmi)
  {
    return (paramaqmi != null) && (paramaqmi.a != null) && ((paramaqmi.a.a() == 2) || (paramaqmi.a.a() == 4));
  }
  
  public boolean a(GalleryBaseData[] paramArrayOfGalleryBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfGalleryBaseData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if ((this.jdField_a_of_type_Aqmi == null) || (this.jdField_b_of_type_Aqmi == null))
      {
        localObject = new aqmi((GalleryBaseData)localObject);
        this.jdField_b_of_type_Aqmi = ((aqmi)localObject);
        this.jdField_a_of_type_Aqmi = ((aqmi)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfGalleryBaseData.length)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new aqmi((GalleryBaseData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Aqmi.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_Aqmi == this.jdField_b_of_type_Aqmi) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_Aqmi);
        }
        else if ((this.jdField_b_of_type_Aqmi.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_b_of_type_Aqmi.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_Aqmi);
        }
        else
        {
          localArrayList.add(new aqmi((GalleryBaseData)localObject));
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
    if (this.jdField_a_of_type_Aqmi != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Aqmi);
    }
    if (a(a(this.jdField_a_of_type_Int))) {
      a(this.jdField_b_of_type_Aqmi, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqmi b()
  {
    return this.jdField_a_of_type_Aqmi;
  }
  
  public aqmi b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          aqmi localaqmi = (aqmi)localIterator.next();
          if (localaqmi.a.jdField_a_of_type_Long != paramLong) {
            continue;
          }
          if (localaqmi != null) {
            this.jdField_a_of_type_JavaUtilList.remove(localaqmi);
          }
          return localaqmi;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(aqmi paramaqmi)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Aqmi = paramaqmi;
    this.jdField_b_of_type_Aqmi.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aqmi = this.jdField_b_of_type_Aqmi;
    this.jdField_a_of_type_JavaUtilList.add(paramaqmi);
  }
  
  public void c(aqmi paramaqmi)
  {
    if (a(paramaqmi))
    {
      if (paramaqmi.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramaqmi.a).f = true;
    }
    label31:
    while (paramaqmi.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramaqmi.a).l = true;
  }
  
  public void d(aqmi paramaqmi)
  {
    if (a(paramaqmi))
    {
      if (paramaqmi.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramaqmi.a).g = true;
    }
    label31:
    while (paramaqmi.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramaqmi.a).m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmj
 * JD-Core Version:    0.7.0.1
 */