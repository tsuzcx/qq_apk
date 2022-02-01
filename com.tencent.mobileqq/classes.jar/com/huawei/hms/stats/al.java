package com.huawei.hms.stats;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public class al
{
  private String a = b.j().getFilesDir().getPath();
  
  private String a(String paramString)
  {
    paramString = new File(b(paramString), "hianalytics_" + paramString);
    if (a(paramString)) {
      return ba.a(paramString);
    }
    String str = e.a().b(e.a.b);
    ba.a(paramString, str);
    return str;
  }
  
  private void a(String paramString1, String paramString2)
  {
    File localFile = new File(b(paramString1));
    paramString1 = new File(b(paramString1), "hianalytics_" + paramString1);
    if ((!localFile.exists()) && (localFile.mkdirs())) {
      af.b("ComponentManager", "file directory is mkdirs");
    }
    if (a(paramString1))
    {
      ba.a(paramString1, paramString2);
      return;
    }
    af.c("ComponentManager", "refreshComponent():file is not found,and file is create failed");
  }
  
  private boolean a(File paramFile)
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
      af.c("ComponentManager", "create new file error!");
    }
    return false;
  }
  
  private char[] a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = e.a().b(paramString1);
    paramString2 = e.a().b(paramString2);
    paramString3 = e.a().b(paramString3);
    paramString4 = e.a().b(paramString4);
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
  
  private String b(String paramString)
  {
    return this.a + "/hms/component/".replace("component", paramString);
  }
  
  private boolean b()
  {
    long l = ap.b(b.j(), "Privacy_MY", "assemblyFlash", -1L);
    if (-1L == l) {
      af.b("ComponentManager", "First init components");
    }
    while (System.currentTimeMillis() - l > 31536000000L) {
      return true;
    }
    return false;
  }
  
  private String c()
  {
    return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
  }
  
  public String a()
  {
    String str3 = c();
    String str2;
    String str1;
    Object localObject2;
    Object localObject1;
    if (b())
    {
      af.b("ComponentManager", "refresh components");
      str2 = e.a().b(e.a.b);
      a("aprpap", str2);
      str1 = e.a().b(e.a.b);
      a("febdoc", str1);
      localObject2 = e.a().b(e.a.b);
      a("marfil", (String)localObject2);
      localObject1 = e.a().b(e.a.b);
      a("maywnj", (String)localObject1);
      ap.a(b.j(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
    }
    for (;;)
    {
      localObject2 = a(str2, str1, (String)localObject2, str3);
      localObject1 = e.a().b((String)localObject1);
      return e.a().a((char[])localObject2, (byte[])localObject1);
      str2 = a("aprpap");
      str1 = a("febdoc");
      localObject2 = a("marfil");
      localObject1 = a("maywnj");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.al
 * JD-Core Version:    0.7.0.1
 */