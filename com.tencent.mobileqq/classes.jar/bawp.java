import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bawp
  extends MainBrowserModel
{
  int jdField_a_of_type_Int;
  private bawx jdField_a_of_type_Bawx;
  public RichMediaBrowserInfo a;
  List<RichMediaBrowserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  
  public bawp(bawx parambawx)
  {
    super(parambawx);
    this.jdField_a_of_type_Bawx = parambawx;
  }
  
  public static boolean a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    if (paramAIOBrowserBaseData == null) {}
    while ((paramAIOBrowserBaseData.getType() != 100) && (paramAIOBrowserBaseData.getType() != 101) && (paramAIOBrowserBaseData.getType() != 102) && (paramAIOBrowserBaseData.getType() != 103)) {
      return false;
    }
    return true;
  }
  
  public int a(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramInt == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.browserDataList;
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = localList.get(i);
      if (!RichMediaBrowserInfo.class.isInstance(localObject)) {}
      label119:
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
              localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
              if (!AIOPictureData.class.isInstance(localObject)) {
                break label119;
              }
              localObject = (AIOPictureData)localObject;
            } while ((((AIOPictureData)localObject).jdField_a_of_type_Long != paramLong) || (((AIOPictureData)localObject).jdField_a_of_type_Int != paramInt1));
            new bawu().a((AIOPictureData)localObject, paramInt2, paramString);
            return i;
            if (!AIOVideoData.class.isInstance(localObject)) {
              break label165;
            }
            localObject = (AIOVideoData)localObject;
          } while (((AIOVideoData)localObject).jdField_a_of_type_Long != paramLong);
          new bawv().a((AIOVideoData)localObject, paramInt2, paramString);
          return i;
          if (!AIOFilePictureData.class.isInstance(localObject)) {
            break label211;
          }
          localObject = (AIOFilePictureData)localObject;
        } while (((AIOFilePictureData)localObject).jdField_a_of_type_Long != paramLong);
        new bawq().a((AIOFilePictureData)localObject, paramInt2, paramString);
        return i;
      } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).jdField_a_of_type_Long != paramLong));
      label165:
      label211:
      return i;
    }
    return -1;
  }
  
  public RichMediaBrowserInfo a()
  {
    return this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        if (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)localRichMediaBrowserInfo.baseData;
        if ((paramLong1 == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramLong2 == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public List<RichMediaBrowserInfo> a()
  {
    return this.browserDataList;
  }
  
  public List<RichMediaBrowserInfo> a(List<RichMediaBrowserInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)paramList.next();
        if (a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData)) {
          localArrayList.add(localRichMediaBrowserInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.browserDataList != null)
    {
      int j = this.browserDataList.size();
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramInt1 == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          ((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData.updateStatus(paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.browserDataList.clear();
    this.currentIndex = 0;
    this.currentBrowserInfo = paramRichMediaBrowserInfo;
    this.currentBrowserInfo.isEnterImage = true;
    this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo = this.currentBrowserInfo;
    this.browserDataList.add(paramRichMediaBrowserInfo);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, long paramLong)
  {
    if ((a(paramRichMediaBrowserInfo)) && (paramRichMediaBrowserInfo.baseData.getType() == 101)) {
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).jdField_f_of_type_Long = paramLong;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.browserDataList);
      this.currentIndex = (this.browserDataList.size() - 1 - this.currentIndex);
    }
  }
  
  public boolean a()
  {
    if (!this.c) {}
    int i;
    do
    {
      return false;
      i = this.jdField_a_of_type_JavaUtilList.size();
    } while (i <= 0);
    this.jdField_a_of_type_Int += i;
    this.jdField_b_of_type_Int = (i + this.jdField_b_of_type_Int);
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_b_of_type_Boolean)
    {
      Collections.reverse(localList);
      this.browserDataList.addAll(localList);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return true;
      this.currentIndex += localList.size();
      this.browserDataList.addAll(0, localList);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return (paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && ((paramRichMediaBrowserInfo.baseData.getType() == 101) || (paramRichMediaBrowserInfo.baseData.getType() == 103));
  }
  
  public boolean a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIOBrowserBaseData.length - 1;
    if (i >= 0)
    {
      localAIOBrowserBaseData1 = paramArrayOfAIOBrowserBaseData[i];
      if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo == null) || (this.currentBrowserInfo == null))
      {
        localObject = new RichMediaBrowserInfo();
        ((RichMediaBrowserInfo)localObject).baseData = localAIOBrowserBaseData1;
        this.currentBrowserInfo = ((RichMediaBrowserInfo)localObject);
        this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo = ((RichMediaBrowserInfo)localObject);
      }
    }
    AIOBrowserBaseData localAIOBrowserBaseData1 = (AIOBrowserBaseData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.baseData;
    Object localObject = (AIOBrowserBaseData)this.currentBrowserInfo.baseData;
    i = 0;
    if (i < paramArrayOfAIOBrowserBaseData.length)
    {
      AIOBrowserBaseData localAIOBrowserBaseData2 = paramArrayOfAIOBrowserBaseData[i];
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      if (this.jdField_a_of_type_Boolean)
      {
        localRichMediaBrowserInfo = new RichMediaBrowserInfo();
        localRichMediaBrowserInfo.baseData = localAIOBrowserBaseData2;
        localArrayList.add(localRichMediaBrowserInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localAIOBrowserBaseData1.jdField_a_of_type_Long == localAIOBrowserBaseData2.jdField_a_of_type_Long) && (localAIOBrowserBaseData1.jdField_a_of_type_Int == localAIOBrowserBaseData2.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.isEnterImage = true;
          if (this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo == this.currentBrowserInfo) {
            this.c = true;
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
        }
        else if ((((AIOBrowserBaseData)localObject).jdField_a_of_type_Long == localAIOBrowserBaseData2.jdField_a_of_type_Long) && (((AIOBrowserBaseData)localObject).jdField_a_of_type_Int == localAIOBrowserBaseData2.jdField_a_of_type_Int))
        {
          localArrayList.add(this.currentBrowserInfo);
        }
        else
        {
          localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = localAIOBrowserBaseData2;
          localArrayList.add(localRichMediaBrowserInfo);
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfAIOBrowserBaseData.length)) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList);
    }
    while (!this.c) {
      return false;
    }
    this.browserDataList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.browserDataList);
    }
    if (this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo != null) {
      this.currentIndex = this.browserDataList.indexOf(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
    }
    if (a(getItem(this.currentIndex))) {
      updateItem(this.currentBrowserInfo, this.currentIndex);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public RichMediaBrowserInfo b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.browserDataList.iterator();
        if (localIterator.hasNext())
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
          if (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long != paramLong) {
            continue;
          }
          if (localRichMediaBrowserInfo != null) {
            this.browserDataList.remove(localRichMediaBrowserInfo);
          }
          return localRichMediaBrowserInfo;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (a(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 101) {
        break label32;
      }
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean = true;
    }
    label32:
    while (paramRichMediaBrowserInfo.baseData.getType() != 103) {
      return;
    }
    ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).h = true;
  }
  
  public void c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (a(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 101) {
        break label32;
      }
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).g = true;
    }
    label32:
    while (paramRichMediaBrowserInfo.baseData.getType() != 103) {
      return;
    }
    ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).i = true;
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (this.browserDataList != null))
    {
      int j = this.browserDataList.size();
      AIOBrowserBaseData localAIOBrowserBaseData1 = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData2 = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((localAIOBrowserBaseData1.jdField_a_of_type_Long == localAIOBrowserBaseData2.jdField_a_of_type_Long) && (localAIOBrowserBaseData1.jdField_a_of_type_Int == localAIOBrowserBaseData2.jdField_a_of_type_Int)) {
          this.browserDataList.set(i, paramRichMediaBrowserInfo);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawp
 * JD-Core Version:    0.7.0.1
 */