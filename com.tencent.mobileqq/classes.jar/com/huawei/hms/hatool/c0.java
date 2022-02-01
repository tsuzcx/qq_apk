package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

public class c0
{
  public String a = b.f().getFilesDir().getPath();
  
  public static boolean b(File paramFile)
  {
    int i = 0;
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return false;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        if (arrayOfFile.length == 0) {
          return false;
        }
        int j = arrayOfFile.length;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isFile())
          {
            if (!localFile.delete())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("delete file failed : ");
              localStringBuilder.append(localFile.getName());
              y.c("hmsSdk", localStringBuilder.toString());
            }
          }
          else if (localFile.isDirectory()) {
            b(localFile);
          }
          i += 1;
        }
        return paramFile.delete();
      }
    }
    return false;
  }
  
  public static boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.f().getFilesDir().getPath());
    localStringBuilder.append("/");
    localStringBuilder.append("hms");
    return b(new File(localStringBuilder.toString()));
  }
  
  public String a()
  {
    String str5 = c();
    String str4;
    String str3;
    String str2;
    String str1;
    if (b())
    {
      y.c("hmsSdk", "refresh components");
      str4 = EncryptUtil.generateSecureRandomStr(128);
      a("aprpap", str4);
      str3 = EncryptUtil.generateSecureRandomStr(128);
      a("febdoc", str3);
      str2 = EncryptUtil.generateSecureRandomStr(128);
      a("marfil", str2);
      str1 = EncryptUtil.generateSecureRandomStr(128);
      a("maywnj", str1);
      g0.b(b.f(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
    }
    else
    {
      str4 = b("aprpap");
      str3 = b("febdoc");
      str2 = b("marfil");
      str1 = b("maywnj");
    }
    return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(str4, str3, str2, str5), HexUtil.hexStr2ByteArray(str1), 10000, 16));
  }
  
  public final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("/hms/component/".replace("component", paramString));
    return localStringBuilder.toString();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    File localFile = new File(a(paramString1));
    String str = a(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_");
    localStringBuilder.append(paramString1);
    paramString1 = new File(str, localStringBuilder.toString());
    if ((!localFile.exists()) && (localFile.mkdirs())) {
      y.c("hmsSdk", "file directory is mkdirs");
    }
    if (a(paramString1))
    {
      r0.a(paramString1, paramString2);
      return;
    }
    y.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
  }
  
  public final boolean a(File paramFile)
  {
    if (paramFile.exists()) {
      return true;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      label16:
      break label16;
    }
    y.f("hmsSdk", "create new file error!");
    return false;
  }
  
  public final char[] a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = HexUtil.hexStr2ByteArray(paramString1);
    paramString2 = HexUtil.hexStr2ByteArray(paramString2);
    paramString3 = HexUtil.hexStr2ByteArray(paramString3);
    paramString4 = HexUtil.hexStr2ByteArray(paramString4);
    int j = paramString1.length;
    int i = j;
    if (j > paramString2.length) {
      i = paramString2.length;
    }
    j = i;
    if (i > paramString3.length) {
      j = paramString3.length;
    }
    i = j;
    if (j > paramString4.length) {
      i = paramString4.length;
    }
    char[] arrayOfChar = new char[i];
    j = 0;
    while (j < i)
    {
      arrayOfChar[j] = ((char)(paramString1[j] ^ paramString2[j] ^ paramString3[j] ^ paramString4[j]));
      j += 1;
    }
    return arrayOfChar;
  }
  
  public final String b(String paramString)
  {
    String str = a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_");
    localStringBuilder.append(paramString);
    paramString = new File(str, localStringBuilder.toString());
    if (a(paramString)) {
      return r0.a(paramString);
    }
    str = EncryptUtil.generateSecureRandomStr(128);
    r0.a(paramString, str);
    return str;
  }
  
  public final boolean b()
  {
    long l = g0.a(b.f(), "Privacy_MY", "assemblyFlash", -1L);
    if (-1L == l)
    {
      y.c("hmsSdk", "First init components");
      return true;
    }
    return System.currentTimeMillis() - l > 31536000000L;
  }
  
  public final String c()
  {
    return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.c0
 * JD-Core Version:    0.7.0.1
 */