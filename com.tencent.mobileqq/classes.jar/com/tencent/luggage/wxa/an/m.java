package com.tencent.luggage.wxa.an;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class m
  extends g
{
  private static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
  private static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
  private static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
  
  private m(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    super(paramString, paramLong1, paramLong2, paramLong3, paramFile);
  }
  
  public static m a(File paramFile, j paramj)
  {
    String str2 = paramFile.getName();
    String str1 = str2;
    File localFile = paramFile;
    if (!str2.endsWith(".v3.exo"))
    {
      localFile = b(paramFile, paramj);
      if (localFile == null) {
        return null;
      }
      str1 = localFile.getName();
    }
    paramFile = i.matcher(str1);
    if (!paramFile.matches()) {
      return null;
    }
    long l = localFile.length();
    paramj = paramj.a(Integer.parseInt(paramFile.group(1)));
    if (paramj == null) {
      return null;
    }
    return new m(paramj, Long.parseLong(paramFile.group(2)), l, Long.parseLong(paramFile.group(3)), localFile);
  }
  
  public static m a(String paramString, long paramLong)
  {
    return new m(paramString, paramLong, -1L, -9223372036854775807L, null);
  }
  
  public static m a(String paramString, long paramLong1, long paramLong2)
  {
    return new m(paramString, paramLong1, paramLong2, -9223372036854775807L, null);
  }
  
  public static File a(File paramFile, int paramInt, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(".v3.exo");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public static m b(String paramString, long paramLong)
  {
    return new m(paramString, paramLong, -1L, -9223372036854775807L, null);
  }
  
  private static File b(File paramFile, j paramj)
  {
    Object localObject = paramFile.getName();
    Matcher localMatcher = h.matcher((CharSequence)localObject);
    if (localMatcher.matches())
    {
      String str = x.h(localMatcher.group(1));
      localObject = str;
      if (str == null) {
        return null;
      }
    }
    else
    {
      localMatcher = g.matcher((CharSequence)localObject);
      if (!localMatcher.matches()) {
        return null;
      }
      localObject = localMatcher.group(1);
    }
    paramj = a(paramFile.getParentFile(), paramj.c((String)localObject), Long.parseLong(localMatcher.group(2)), Long.parseLong(localMatcher.group(3)));
    if (!paramFile.renameTo(paramj)) {
      return null;
    }
    return paramj;
  }
  
  public m a(int paramInt)
  {
    a.b(this.d);
    long l = System.currentTimeMillis();
    File localFile = a(this.e.getParentFile(), paramInt, this.b, l);
    return new m(this.a, this.b, this.c, l, localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.m
 * JD-Core Version:    0.7.0.1
 */