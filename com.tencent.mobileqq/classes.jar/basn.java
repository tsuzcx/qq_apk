import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

class basn
{
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private int[][] jdField_a_of_type_Array2dOfInt;
  
  basn(basl parambasl) {}
  
  private int a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = 5;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt()) % localArrayList.size())).intValue();
      }
    }
    return -1;
  }
  
  private int b(int[] paramArrayOfInt)
  {
    if (!basl.a(this.jdField_a_of_type_Basl).a()) {}
    for (int i = 2;; i = 5)
    {
      if (paramArrayOfInt != null)
      {
        int j = 0;
        while (j < paramArrayOfInt.length)
        {
          if (paramArrayOfInt[j] < i) {
            return j;
          }
          j += 1;
        }
      }
      return -1;
    }
  }
  
  FileStorageServerListInfo a()
  {
    Object localObject2 = null;
    ArrayList localArrayList = basl.c(this.jdField_a_of_type_Basl, 16);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        int i = b(basl.a(this.jdField_a_of_type_Basl).a(basl.a(this.jdField_a_of_type_Basl).b()));
        localObject1 = localObject2;
        if (i > -1)
        {
          localObject1 = localObject2;
          if (i < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(i);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject1;
  }
  
  FileStorageServerListInfo a(int paramInt)
  {
    Object localObject2 = null;
    ArrayList localArrayList = basl.c(this.jdField_a_of_type_Basl, paramInt);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        paramInt = a(a(paramInt));
        localObject1 = localObject2;
        if (paramInt > -1)
        {
          localObject1 = localObject2;
          if (paramInt < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(paramInt);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject1;
  }
  
  void a() {}
  
  void a(int paramInt, String paramString)
  {
    try
    {
      ArrayList localArrayList = basl.c(this.jdField_a_of_type_Basl, paramInt);
      int[] arrayOfInt = a(paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt < localArrayList.size())
        {
          String str = ((FileStorageServerListInfo)localArrayList.get(paramInt)).sIP;
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label116;
          }
          if (arrayOfInt.length > paramInt) {
            arrayOfInt[paramInt] += 1;
          }
        }
        return;
        label116:
        paramInt += 1;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    int k = 0;
    if (paramFileStoragePushFSSvcList != null)
    {
      this.jdField_a_of_type_Array2dOfInt = new int[18][];
      if ((paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[4] = new int[paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vGPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vGPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[2] = new int[paramFileStoragePushFSSvcList.vGPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[1] = new int[paramFileStoragePushFSSvcList.vPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vQzoneProxyServiceList != null) && (paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[3] = new int[paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vUpLoadList != null) && (paramFileStoragePushFSSvcList.vUpLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[0] = new int[paramFileStoragePushFSSvcList.vUpLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vVipEmotionList != null) && (paramFileStoragePushFSSvcList.vVipEmotionList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[5] = new int[paramFileStoragePushFSSvcList.vVipEmotionList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vC2CPicDownList != null) && (paramFileStoragePushFSSvcList.vC2CPicDownList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[11] = new int[paramFileStoragePushFSSvcList.vC2CPicDownList.size()];
      }
      int i = 6;
      int j;
      if (i <= 10)
      {
        paramFileStoragePushFSSvcList = basl.a(this.jdField_a_of_type_Basl, basl.a(this.jdField_a_of_type_Basl, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
      i = 12;
      if (i <= 15)
      {
        paramFileStoragePushFSSvcList = basl.b(this.jdField_a_of_type_Basl, basl.b(this.jdField_a_of_type_Basl, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
      paramFileStoragePushFSSvcList = basl.b(this.jdField_a_of_type_Basl, basl.b(this.jdField_a_of_type_Basl, 17));
      i = k;
      if (paramFileStoragePushFSSvcList != null) {
        i = paramFileStoragePushFSSvcList.size();
      }
      this.jdField_a_of_type_Array2dOfInt[17] = new int[i];
    }
    basl.a(this.jdField_a_of_type_Basl).a();
  }
  
  int[] a(int paramInt)
  {
    if (this.jdField_a_of_type_Array2dOfInt == null) {
      return null;
    }
    return this.jdField_a_of_type_Array2dOfInt[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basn
 * JD-Core Version:    0.7.0.1
 */