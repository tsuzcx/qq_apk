import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;

public class amoa
{
  public static awho a(Class<FTSMessage> paramClass, String paramString)
  {
    return new awho(a(paramString), paramClass, new String[] { paramString }, false, 1);
  }
  
  public static awho a(String[] paramArrayOfString1, String[] paramArrayOfString2, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramArrayOfString1 = new awho(a(paramArrayOfString1, paramArrayOfString2, paramBoolean1, paramBoolean2), paramClass, paramArrayOfString2, paramBoolean1, 1);
    paramArrayOfString1.jdField_b_of_type_Boolean = paramBoolean2;
    return paramArrayOfString1;
  }
  
  public static awho a(String[] paramArrayOfString1, String[] paramArrayOfString2, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    paramArrayOfString1 = new awho(a(paramArrayOfString1, paramArrayOfString2, paramBoolean1, paramBoolean2), paramClass, paramArrayOfString2, paramBoolean1, 1);
    paramArrayOfString1.jdField_b_of_type_Boolean = paramBoolean2;
    paramArrayOfString1.c = paramInt;
    return paramArrayOfString1;
  }
  
  public static awho a(String[] paramArrayOfString1, String[] paramArrayOfString2, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramArrayOfString1 = new awho(a(paramArrayOfString1, paramArrayOfString2, paramBoolean1, paramBoolean2, paramInt, paramString), paramClass, paramArrayOfString2, paramBoolean1, 1);
    paramArrayOfString1.jdField_b_of_type_Boolean = paramBoolean2;
    paramArrayOfString1.jdField_b_of_type_Int = paramInt;
    paramArrayOfString1.jdField_b_of_type_JavaLangString = paramString;
    return paramArrayOfString1;
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("SELECT DISTINCT type, oid, content, ext1, ext2, ext3, ext4, ext5, ext6, ext7, ext8, ext9, exts FROM IndexContent WHERE IndexContent MATCH 'type:");
    localStringBuffer.append(paramInt1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      localStringBuffer.append("';");
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append("ext1:");
      localStringBuffer.append(paramString);
      continue;
      localStringBuffer.append(" ");
      localStringBuffer.append("ext2:");
      localStringBuffer.append(paramString);
      continue;
      localStringBuffer.append(" ");
      localStringBuffer.append("ext3:");
      localStringBuffer.append(paramString);
    }
  }
  
  private static String a(String paramString)
  {
    return a(1, 2, String.valueOf(paramString));
  }
  
  private static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString)
  {
    paramArrayOfString2 = new StringBuilder(256);
    paramArrayOfString2.append("SELECT DISTINCT type, oid, content, ext1, ext2, ext3, ext4, ext5, ext6, ext7, ext8, ext9, exts FROM IndexContent WHERE contentindex MATCH '");
    paramInt1 = 0;
    if (paramInt1 < paramArrayOfString1.length - 1)
    {
      paramArrayOfString2.append("\"");
      paramString = paramArrayOfString1[paramInt1].split(" ");
      paramInt2 = 0;
      if (paramInt2 < paramString.length - 1)
      {
        if ((paramString[paramInt2].length() == 1) || ((paramString[paramInt2].charAt(0) >= '0') && (paramString[paramInt2].charAt(0) <= '9')) || ((paramString[paramInt2].charAt(0) >= 'a') && (paramString[paramInt2].charAt(0) <= 'z')))
        {
          paramArrayOfString2.append(paramString[paramInt2]);
          paramArrayOfString2.append("*");
        }
        for (;;)
        {
          paramArrayOfString2.append(" ");
          paramInt2 += 1;
          break;
          paramArrayOfString2.append(paramString[paramInt2]);
        }
      }
      if ((paramString[(paramString.length - 1)].length() == 1) || ((paramString[(paramString.length - 1)].charAt(0) >= '0') && (paramString[(paramString.length - 1)].charAt(0) <= '9')) || ((paramString[(paramString.length - 1)].charAt(0) >= 'a') && (paramString[(paramString.length - 1)].charAt(0) <= 'z')))
      {
        paramArrayOfString2.append(paramString[(paramString.length - 1)]);
        paramArrayOfString2.append("*");
      }
      for (;;)
      {
        paramArrayOfString2.append("\"");
        paramArrayOfString2.append(" OR ");
        paramInt1 += 1;
        break;
        paramArrayOfString2.append(paramString[(paramString.length - 1)]);
      }
    }
    paramArrayOfString2.append("\"");
    paramArrayOfString1 = paramArrayOfString1[(paramArrayOfString1.length - 1)].split(" ");
    paramInt1 = 0;
    if (paramInt1 < paramArrayOfString1.length - 1)
    {
      if ((paramArrayOfString1[paramInt1].length() == 1) || ((paramArrayOfString1[paramInt1].charAt(0) >= '0') && (paramArrayOfString1[paramInt1].charAt(0) <= '9')) || ((paramArrayOfString1[paramInt1].charAt(0) >= 'a') && (paramArrayOfString1[paramInt1].charAt(0) <= 'z')))
      {
        paramArrayOfString2.append(paramArrayOfString1[paramInt1]);
        paramArrayOfString2.append("*");
      }
      for (;;)
      {
        paramArrayOfString2.append(" ");
        paramInt1 += 1;
        break;
        paramArrayOfString2.append(paramArrayOfString1[paramInt1]);
      }
    }
    if ((paramArrayOfString1[(paramArrayOfString1.length - 1)].length() == 1) || ((paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) >= '0') && (paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) <= '9')) || ((paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) >= 'a') && (paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) <= 'z')))
    {
      paramArrayOfString2.append(paramArrayOfString1[(paramArrayOfString1.length - 1)]);
      paramArrayOfString2.append("*");
    }
    for (;;)
    {
      paramArrayOfString2.append("\"");
      paramArrayOfString2.append("'");
      paramArrayOfString2.append(";");
      return paramArrayOfString2.toString();
      paramArrayOfString2.append(paramArrayOfString1[(paramArrayOfString1.length - 1)]);
    }
  }
  
  private static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramArrayOfString1, paramArrayOfString2, 1, paramBoolean1, paramBoolean2, 0, null);
  }
  
  private static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    return a(paramArrayOfString1, paramArrayOfString2, 1, paramBoolean1, paramBoolean2, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoa
 * JD-Core Version:    0.7.0.1
 */