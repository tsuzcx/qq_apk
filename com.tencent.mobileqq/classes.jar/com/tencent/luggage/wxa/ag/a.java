package com.tencent.luggage.wxa.ag;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.ao.h;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.luggage.wxa.ad.b
{
  private static final Pattern a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
  private final boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public a()
  {
    this(null);
  }
  
  public a(List<byte[]> paramList)
  {
    super("SsaDecoder");
    if (paramList != null)
    {
      this.b = true;
      String str = new String((byte[])paramList.get(0));
      com.tencent.luggage.wxa.ao.a.a(str.startsWith("Format: "));
      b(str);
      a(new m((byte[])paramList.get(1)));
      return;
    }
    this.b = false;
  }
  
  public static long a(String paramString)
  {
    paramString = a.matcher(paramString);
    if (!paramString.matches()) {
      return -9223372036854775807L;
    }
    return Long.parseLong(paramString.group(1)) * 60L * 60L * 1000000L + Long.parseLong(paramString.group(2)) * 60L * 1000000L + Long.parseLong(paramString.group(3)) * 1000000L + Long.parseLong(paramString.group(4)) * 10000L;
  }
  
  private void a(m paramm)
  {
    String str;
    do
    {
      str = paramm.y();
    } while ((str != null) && (!str.startsWith("[Events]")));
  }
  
  private void a(m paramm, List<com.tencent.luggage.wxa.ad.a> paramList, h paramh)
  {
    for (;;)
    {
      String str = paramm.y();
      if (str == null) {
        break;
      }
      if ((!this.b) && (str.startsWith("Format: "))) {
        b(str);
      } else if (str.startsWith("Dialogue: ")) {
        a(str, paramList, paramh);
      }
    }
  }
  
  private void a(String paramString, List<com.tencent.luggage.wxa.ad.a> paramList, h paramh)
  {
    if (this.c == 0)
    {
      paramList = new StringBuilder();
      paramList.append("Skipping dialogue line before format: ");
      paramList.append(paramString);
      Log.w("SsaDecoder", paramList.toString());
      return;
    }
    String[] arrayOfString = paramString.substring(10).split(",", this.c);
    long l3 = a(arrayOfString[this.d]);
    if (l3 == -9223372036854775807L)
    {
      paramList = new StringBuilder();
      paramList.append("Skipping invalid timing: ");
      paramList.append(paramString);
      Log.w("SsaDecoder", paramList.toString());
      return;
    }
    String str = arrayOfString[this.e];
    long l1;
    if (!str.trim().isEmpty())
    {
      long l2 = a(str);
      l1 = l2;
      if (l2 == -9223372036854775807L)
      {
        paramList = new StringBuilder();
        paramList.append("Skipping invalid timing: ");
        paramList.append(paramString);
        Log.w("SsaDecoder", paramList.toString());
      }
    }
    else
    {
      l1 = -9223372036854775807L;
    }
    paramList.add(new com.tencent.luggage.wxa.ad.a(arrayOfString[this.f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
    paramh.a(l3);
    if (l1 != -9223372036854775807L)
    {
      paramList.add(null);
      paramh.a(l1);
    }
  }
  
  private void b(String paramString)
  {
    paramString = TextUtils.split(paramString.substring(8), ",");
    this.c = paramString.length;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    int j = 0;
    while (j < this.c)
    {
      String str = x.d(paramString[j].trim());
      int i = str.hashCode();
      if (i != 100571)
      {
        if (i != 3556653)
        {
          if ((i == 109757538) && (str.equals("start")))
          {
            i = 0;
            break label128;
          }
        }
        else if (str.equals("text"))
        {
          i = 2;
          break label128;
        }
      }
      else if (str.equals("end"))
      {
        i = 1;
        break label128;
      }
      i = -1;
      label128:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.f = j;
          }
        }
        else {
          this.e = j;
        }
      }
      else {
        this.d = j;
      }
      j += 1;
    }
  }
  
  protected b b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    h localh = new h();
    paramArrayOfByte = new m(paramArrayOfByte, paramInt);
    if (!this.b) {
      a(paramArrayOfByte);
    }
    a(paramArrayOfByte, localArrayList, localh);
    paramArrayOfByte = new com.tencent.luggage.wxa.ad.a[localArrayList.size()];
    localArrayList.toArray(paramArrayOfByte);
    return new b(paramArrayOfByte, localh.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ag.a
 * JD-Core Version:    0.7.0.1
 */