package com.tencent.av.mediacodec.config;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qphone.base.util.QLog;

public class CodecConfigParser
  extends ConfigBaseParser
{
  public static String B = b + h + j;
  public static String C = b + h + k;
  public static String D = b + i + l;
  public static String E = b + i + m;
  public static String F = b + i + n;
  public static String G = b + i + o;
  public static String H = b + i + p;
  public static String I = c + h + j;
  public static String J = c + h + k;
  public static String K = c + i + l;
  public static String L = c + i + m;
  public static String M = c + i + n;
  public static String N = c + i + o;
  public static String O = c + i + p;
  public static String P = d + h + j;
  public static String Q = d + h + k;
  public static String R = d + i + l;
  public static String S = d + i + m;
  public static String T = d + i + n;
  public static String U = d + i + o;
  public static String V = d + i + p;
  public static String W = e + h + j;
  public static String X = e + h + k;
  public static String Y = e + i + l;
  public static String Z = e + i + m;
  public static String a = "sharp/hwcodec_new/";
  public static String aa = e + i + n;
  public static String ab = e + i + o;
  public static String ac = e + i + p;
  public static String ad = a + s + t;
  public static String ae = a + s + u;
  public static String b = a + "avc_decoder/";
  public static String c = a + "avc_encoder/";
  public static String d = a + "hevc_decoder/";
  public static String e = a + "hevc_encoder/";
  public static String f = a + "async/";
  public static String g = a + "test/";
  public static String h = "white_list/";
  public static String i = "black_list/";
  public static String j = "min_sdk";
  public static String k = "min_version";
  public static String l = "model";
  public static String m = "product";
  public static String n = "fingerprint";
  public static String o = "sdk";
  public static String p = "version";
  public static String q = "codec";
  public static String r = "disable_sdk";
  public static String s = "async/";
  public static String t = "min_sdk";
  public static String u = "codec";
  public static String v = "async_min_sdk";
  public static String w = g + j;
  public static String x = g + r;
  public static String y = g + q;
  public static String z = g + v;
  
  public CodecConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 2, "getAVCDecoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = a(y);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x1) == 1))
        {
          arrayOfInt = a(w);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.a(a(x), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = a(z);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i1 = Build.VERSION.SDK_INT;
              int i2 = arrayOfInt[0];
              if (i1 >= i2) {
                return 2;
              }
            }
            return 1;
          }
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(P);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = a(U);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label67;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label67:
        localObject = a(R);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label106;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label106:
        localObject = a(S);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label145;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label145:
        localObject = a(T);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label193;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
            if (bool) {
              break;
            }
            i1 += 1;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      int[] arrayOfInt = a(ad);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        arrayOfInt = a(ae);
        if (arrayOfInt != null)
        {
          boolean bool = ArrayUtils.a(arrayOfInt, paramInt);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public int[] a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.a(paramString);
  }
  
  public String[] a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return super.a(paramString);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CodecConfigParser", 2, "getAVCEncoderTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return 0;
      try
      {
        int[] arrayOfInt = a(y);
        if ((arrayOfInt != null) && ((arrayOfInt[0] & 0x2) == 2))
        {
          arrayOfInt = a(w);
          if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]) && (!ArrayUtils.a(a(x), Build.VERSION.SDK_INT)))
          {
            arrayOfInt = a(z);
            if ((Build.VERSION.SDK_INT >= 21) && (arrayOfInt != null))
            {
              int i1 = Build.VERSION.SDK_INT;
              int i2 = arrayOfInt[0];
              if (i1 >= i2) {
                return 2;
              }
            }
            return 1;
          }
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(W);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = a(ab);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label67;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label67:
        localObject = a(Y);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label106;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label106:
        localObject = a(Z);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label145;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label145:
        localObject = a(aa);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label193;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
            if (bool) {
              break;
            }
            i1 += 1;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(B);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(G);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label67;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label67:
          localObject = a(D);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label106;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label106:
          localObject = a(E);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label145;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label145:
          localObject = a(F);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label186;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label186:
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public boolean d()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(I);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(N);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label67;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label67:
          localObject = a(K);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label106;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label106:
          localObject = a(L);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label145;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label145:
          localObject = a(M);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label186;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(localObject[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label186:
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.mediacodec.config.CodecConfigParser
 * JD-Core Version:    0.7.0.1
 */