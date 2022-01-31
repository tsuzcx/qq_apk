import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aqmh
  extends aqmj
{
  int jdField_a_of_type_Int;
  public aqmg a;
  private aqnd jdField_a_of_type_Aqnd;
  List<aqmg> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public aqmg b;
  List<aqmg> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  
  public aqmh(boolean paramBoolean, aqnd paramaqnd)
  {
    this.d = paramBoolean;
    this.jdField_a_of_type_Aqnd = paramaqnd;
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
        GalleryBaseData localGalleryBaseData = ((aqmg)localIterator.next()).a;
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
        GalleryBaseData localGalleryBaseData = ((aqmg)localIterator.next()).a;
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
      if (!aqmg.class.isInstance(localObject)) {}
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
              localObject = ((aqmg)localObject).a;
              if (!AIOPicData.class.isInstance(localObject)) {
                break label116;
              }
              localObject = (AIOPicData)localObject;
            } while ((((AIOPicData)localObject).jdField_a_of_type_Long != paramLong) || (((AIOPicData)localObject).jdField_a_of_type_Int != paramInt1));
            new aqmo().a((AIOPicData)localObject, paramInt2, paramString);
            return i;
            if (!AIOShortVideoData.class.isInstance(localObject)) {
              break label162;
            }
            localObject = (AIOShortVideoData)localObject;
          } while (((AIOShortVideoData)localObject).jdField_a_of_type_Long != paramLong);
          new aqms().a((AIOShortVideoData)localObject, paramInt2, paramString);
          return i;
          if (!AIOFilePicData.class.isInstance(localObject)) {
            break label208;
          }
          localObject = (AIOFilePicData)localObject;
        } while (((AIOFilePicData)localObject).jdField_a_of_type_Long != paramLong);
        new aqmn().a((AIOFilePicData)localObject, paramInt2, paramString);
        return i;
      } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_a_of_type_Long != paramLong));
      label162:
      label208:
      return i;
    }
    return -1;
  }
  
  public aqmg a()
  {
    return this.jdField_b_of_type_Aqmg;
  }
  
  public aqmg a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (aqmg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public aqmg a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmg localaqmg = (aqmg)localIterator.next();
        if ((localaqmg.a != null) && (paramLong == localaqmg.a.jdField_a_of_type_Long)) {
          return localaqmg;
        }
      }
    }
    return null;
  }
  
  public aqmg a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aqmg localaqmg = (aqmg)localIterator.next();
        if ((localaqmg.a != null) && (paramLong1 == localaqmg.a.jdField_a_of_type_Long) && (paramLong2 == localaqmg.a.jdField_a_of_type_Int)) {
          return localaqmg;
        }
      }
    }
    return null;
  }
  
  public List<aqmg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<aqmg> a(List<aqmg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aqmg localaqmg = (aqmg)paramList.next();
        if (a(localaqmg.a)) {
          localArrayList.add(localaqmg);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Aqmg = a(paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        aqmg localaqmg = (aqmg)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localaqmg.a != null) && (paramLong == localaqmg.a.jdField_a_of_type_Long) && (paramInt1 == localaqmg.a.jdField_a_of_type_Int)) {
          ((aqmg)this.jdField_a_of_type_JavaUtilList.get(i)).a.a(paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(aqmg paramaqmg)
  {
    if ((paramaqmg != null) && (paramaqmg.a != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        aqmg localaqmg = (aqmg)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localaqmg.a != null) && (paramaqmg.a.jdField_a_of_type_Long == localaqmg.a.jdField_a_of_type_Long) && (paramaqmg.a.jdField_a_of_type_Int == localaqmg.a.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_JavaUtilList.set(i, paramaqmg);
        }
        i += 1;
      }
    }
  }
  
  public void a(aqmg paramaqmg, int paramInt)
  {
    if ((paramaqmg != null) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if ((paramInt >= 0) && (paramInt < i)) {
        this.jdField_a_of_type_JavaUtilList.set(paramInt, paramaqmg);
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
  
  public boolean a(aqmg paramaqmg)
  {
    return (paramaqmg != null) && (paramaqmg.a != null) && ((paramaqmg.a.a() == 2) || (paramaqmg.a.a() == 4));
  }
  
  public boolean a(GalleryBaseData[] paramArrayOfGalleryBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfGalleryBaseData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if ((this.jdField_a_of_type_Aqmg == null) || (this.jdField_b_of_type_Aqmg == null))
      {
        localObject = new aqmg((GalleryBaseData)localObject);
        this.jdField_b_of_type_Aqmg = ((aqmg)localObject);
        this.jdField_a_of_type_Aqmg = ((aqmg)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfGalleryBaseData.length)
    {
      localObject = paramArrayOfGalleryBaseData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new aqmg((GalleryBaseData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Aqmg.jdField_b_of_type_Boolean = true;
          if (this.jdField_a_of_type_Aqmg == this.jdField_b_of_type_Aqmg) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_Aqmg);
        }
        else if ((this.jdField_b_of_type_Aqmg.a.jdField_a_of_type_Long == ((GalleryBaseData)localObject).jdField_a_of_type_Long) && (this.jdField_b_of_type_Aqmg.a.jdField_a_of_type_Int == ((GalleryBaseData)localObject).jdField_a_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_Aqmg);
        }
        else
        {
          localArrayList.add(new aqmg((GalleryBaseData)localObject));
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
    if (this.jdField_a_of_type_Aqmg != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Aqmg);
    }
    if (a(a(this.jdField_a_of_type_Int))) {
      a(this.jdField_b_of_type_Aqmg, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqmg b()
  {
    return this.jdField_a_of_type_Aqmg;
  }
  
  public aqmg b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          aqmg localaqmg = (aqmg)localIterator.next();
          if (localaqmg.a.jdField_a_of_type_Long != paramLong) {
            continue;
          }
          if (localaqmg != null) {
            this.jdField_a_of_type_JavaUtilList.remove(localaqmg);
          }
          return localaqmg;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(aqmg paramaqmg)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Aqmg = paramaqmg;
    this.jdField_b_of_type_Aqmg.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aqmg = this.jdField_b_of_type_Aqmg;
    this.jdField_a_of_type_JavaUtilList.add(paramaqmg);
  }
  
  public void c(aqmg paramaqmg)
  {
    if (a(paramaqmg))
    {
      if (paramaqmg.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramaqmg.a).f = true;
    }
    label31:
    while (paramaqmg.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramaqmg.a).l = true;
  }
  
  public void d(aqmg paramaqmg)
  {
    if (a(paramaqmg))
    {
      if (paramaqmg.a.a() != 2) {
        break label31;
      }
      ((AIOShortVideoData)paramaqmg.a).g = true;
    }
    label31:
    while (paramaqmg.a.a() != 4) {
      return;
    }
    ((AIOFileVideoData)paramaqmg.a).m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmh
 * JD-Core Version:    0.7.0.1
 */