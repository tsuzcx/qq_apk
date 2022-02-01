package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

public class ExtraFieldUtils
{
  private static final int WORD = 4;
  private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();
  
  static
  {
    register(AsiExtraField.class);
    register(JarMarker.class);
    register(UnicodePathExtraField.class);
    register(UnicodeCommentExtraField.class);
    register(Zip64ExtendedInformationExtraField.class);
  }
  
  public static ZipExtraField createExtraField(ZipShort paramZipShort)
  {
    Object localObject = (Class)implementations.get(paramZipShort);
    if (localObject != null) {
      return (ZipExtraField)((Class)localObject).newInstance();
    }
    localObject = new UnrecognizedExtraField();
    ((UnrecognizedExtraField)localObject).setHeaderId(paramZipShort);
    return localObject;
  }
  
  public static byte[] mergeCentralDirectoryData(ZipExtraField[] paramArrayOfZipExtraField)
  {
    int i;
    if ((paramArrayOfZipExtraField.length > 0) && ((paramArrayOfZipExtraField[(paramArrayOfZipExtraField.length - 1)] instanceof UnparseableExtraFieldData))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramArrayOfZipExtraField.length - 1;
    } else {
      j = paramArrayOfZipExtraField.length;
    }
    int n = paramArrayOfZipExtraField.length;
    int m = j * 4;
    int k = 0;
    while (k < n)
    {
      m += paramArrayOfZipExtraField[k].getCentralDirectoryLength().getValue();
      k += 1;
    }
    byte[] arrayOfByte1 = new byte[m];
    k = 0;
    m = 0;
    while (k < j)
    {
      System.arraycopy(paramArrayOfZipExtraField[k].getHeaderId().getBytes(), 0, arrayOfByte1, m, 2);
      System.arraycopy(paramArrayOfZipExtraField[k].getCentralDirectoryLength().getBytes(), 0, arrayOfByte1, m + 2, 2);
      byte[] arrayOfByte2 = paramArrayOfZipExtraField[k].getCentralDirectoryData();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, m + 4, arrayOfByte2.length);
      m += arrayOfByte2.length + 4;
      k += 1;
    }
    if (i != 0)
    {
      paramArrayOfZipExtraField = paramArrayOfZipExtraField[(paramArrayOfZipExtraField.length - 1)].getCentralDirectoryData();
      System.arraycopy(paramArrayOfZipExtraField, 0, arrayOfByte1, m, paramArrayOfZipExtraField.length);
    }
    return arrayOfByte1;
  }
  
  public static byte[] mergeLocalFileDataData(ZipExtraField[] paramArrayOfZipExtraField)
  {
    int i;
    if ((paramArrayOfZipExtraField.length > 0) && ((paramArrayOfZipExtraField[(paramArrayOfZipExtraField.length - 1)] instanceof UnparseableExtraFieldData))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramArrayOfZipExtraField.length - 1;
    } else {
      j = paramArrayOfZipExtraField.length;
    }
    int n = paramArrayOfZipExtraField.length;
    int m = j * 4;
    int k = 0;
    while (k < n)
    {
      m += paramArrayOfZipExtraField[k].getLocalFileDataLength().getValue();
      k += 1;
    }
    byte[] arrayOfByte1 = new byte[m];
    k = 0;
    m = 0;
    while (k < j)
    {
      System.arraycopy(paramArrayOfZipExtraField[k].getHeaderId().getBytes(), 0, arrayOfByte1, m, 2);
      System.arraycopy(paramArrayOfZipExtraField[k].getLocalFileDataLength().getBytes(), 0, arrayOfByte1, m + 2, 2);
      byte[] arrayOfByte2 = paramArrayOfZipExtraField[k].getLocalFileDataData();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, m + 4, arrayOfByte2.length);
      m += arrayOfByte2.length + 4;
      k += 1;
    }
    if (i != 0)
    {
      paramArrayOfZipExtraField = paramArrayOfZipExtraField[(paramArrayOfZipExtraField.length - 1)].getLocalFileDataData();
      System.arraycopy(paramArrayOfZipExtraField, 0, arrayOfByte1, m, paramArrayOfZipExtraField.length);
    }
    return arrayOfByte1;
  }
  
  public static ZipExtraField[] parse(byte[] paramArrayOfByte)
  {
    return parse(paramArrayOfByte, true, ExtraFieldUtils.UnparseableExtraField.THROW);
  }
  
  public static ZipExtraField[] parse(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return parse(paramArrayOfByte, paramBoolean, ExtraFieldUtils.UnparseableExtraField.THROW);
  }
  
  public static ZipExtraField[] parse(byte[] paramArrayOfByte, boolean paramBoolean, ExtraFieldUtils.UnparseableExtraField paramUnparseableExtraField)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= paramArrayOfByte.length - 4)
    {
      Object localObject = new ZipShort(paramArrayOfByte, i);
      int j = new ZipShort(paramArrayOfByte, i + 2).getValue();
      int k = i + 4;
      if (k + j > paramArrayOfByte.length)
      {
        k = paramUnparseableExtraField.getKey();
        if (k != 0)
        {
          if (k != 1) {
            if (k == 2)
            {
              paramUnparseableExtraField = new UnparseableExtraFieldData();
              if (paramBoolean) {
                paramUnparseableExtraField.parseFromLocalFileData(paramArrayOfByte, i, paramArrayOfByte.length - i);
              } else {
                paramUnparseableExtraField.parseFromCentralDirectoryData(paramArrayOfByte, i, paramArrayOfByte.length - i);
              }
              localArrayList.add(paramUnparseableExtraField);
            }
            else
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("unknown UnparseableExtraField key: ");
              paramArrayOfByte.append(paramUnparseableExtraField.getKey());
              throw new ZipException(paramArrayOfByte.toString());
            }
          }
        }
        else
        {
          paramUnparseableExtraField = new StringBuilder();
          paramUnparseableExtraField.append("bad extra field starting at ");
          paramUnparseableExtraField.append(i);
          paramUnparseableExtraField.append(".  Block length of ");
          paramUnparseableExtraField.append(j);
          paramUnparseableExtraField.append(" bytes exceeds remaining data of ");
          paramUnparseableExtraField.append(paramArrayOfByte.length - i - 4);
          paramUnparseableExtraField.append(" bytes.");
          throw new ZipException(paramUnparseableExtraField.toString());
        }
      }
      else
      {
        try
        {
          localObject = createExtraField((ZipShort)localObject);
          if ((!paramBoolean) && ((localObject instanceof CentralDirectoryParsingZipExtraField))) {
            ((CentralDirectoryParsingZipExtraField)localObject).parseFromCentralDirectoryData(paramArrayOfByte, k, j);
          } else {
            ((ZipExtraField)localObject).parseFromLocalFileData(paramArrayOfByte, k, j);
          }
          localArrayList.add(localObject);
          i += j + 4;
        }
        catch (IllegalAccessException paramArrayOfByte)
        {
          throw new ZipException(paramArrayOfByte.getMessage());
        }
        catch (InstantiationException paramArrayOfByte)
        {
          throw new ZipException(paramArrayOfByte.getMessage());
        }
      }
    }
    return (ZipExtraField[])localArrayList.toArray(new ZipExtraField[localArrayList.size()]);
  }
  
  public static void register(Class<?> paramClass)
  {
    try
    {
      localObject = (ZipExtraField)paramClass.newInstance();
      implementations.put(((ZipExtraField)localObject).getHeaderId(), paramClass);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      break label91;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label58;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label25:
      label58:
      label91:
      break label25;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append("'s no-arg constructor is not public");
    throw new RuntimeException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append(" is not a concrete class");
    throw new RuntimeException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append(" doesn't implement ZipExtraField");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ExtraFieldUtils
 * JD-Core Version:    0.7.0.1
 */