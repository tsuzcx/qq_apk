package com.tencent.av.mediacodec.config;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.ArrayUtils;

public class CodecConfigParser
{
  private static String jdField_a_of_type_JavaLangString = "hwcodec_new2";
  private static String b = "sharp/hwcodec_new/";
  private static String c = "sharp/hwcodec_new2/";
  private static String d = "avc_decoder/";
  private static String e = "avc_encoder/";
  private static String f = "hevc_decoder/";
  private static String g = "hevc_encoder/";
  private static String h = "test/";
  private static String i = "white_list/";
  private static String j = "black_list/";
  private static String k = "min_sdk";
  private static String l = "min_version";
  private static String m = "max_w";
  private static String n = "max_h";
  private static String o = "model";
  private static String p = "product";
  private static String q = "fingerprint";
  private static String r = "sdk";
  private static String s = "version";
  private static String t = "codec";
  private static String u = "disable_sdk";
  private static String v = "async/";
  private static String w = "min_sdk";
  private static String x = "codec";
  private static String y = "async_min_sdk";
  private String A = null;
  private String B = null;
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private String G = null;
  private String H = null;
  private String I = null;
  private String J = null;
  private String K = null;
  private String L = null;
  private String M = null;
  private String N = null;
  private String O = null;
  private String P = null;
  private String Q = null;
  private String R = null;
  private String S = null;
  private String T = null;
  private String U = null;
  private String V = null;
  private String W = null;
  private String X = null;
  private String Y = null;
  private String Z = null;
  private int jdField_a_of_type_Int = 1;
  private ConfigBaseParser jdField_a_of_type_ComTencentAvConfigConfigBaseParser = null;
  private String aa = null;
  private String ab = null;
  private String ac = null;
  private String ad = null;
  private String ae = null;
  private String af = null;
  private String ag = null;
  private String ah = null;
  private String ai = null;
  private String aj = null;
  private String ak = null;
  private String al = null;
  private String am = null;
  private String an = null;
  private String ao = null;
  private String ap = null;
  private String aq = b;
  private String z = null;
  
  public CodecConfigParser(ConfigBaseParser paramConfigBaseParser)
  {
    if ((paramConfigBaseParser != null) && (!paramConfigBaseParser.a()) && (paramConfigBaseParser.a().contains(jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser = paramConfigBaseParser;
    if (this.jdField_a_of_type_Int == 2) {}
    for (paramConfigBaseParser = c;; paramConfigBaseParser = b)
    {
      this.aq = paramConfigBaseParser;
      AVCoreLog.e("CodecConfigParser", "ver = " + this.jdField_a_of_type_Int + ", root = " + this.aq);
      this.z = (this.aq + h + k);
      this.A = (this.aq + h + u);
      this.B = (this.aq + h + t);
      this.C = (this.aq + h + y);
      this.D = (this.aq + h + l);
      this.E = (this.aq + d + i + k);
      this.F = (this.aq + d + i + l);
      this.G = (this.aq + d + j + o);
      this.H = (this.aq + d + j + p);
      this.I = (this.aq + d + j + q);
      this.J = (this.aq + d + j + r);
      this.K = (this.aq + d + j + s);
      this.L = (this.aq + d + i + m);
      this.M = (this.aq + d + i + n);
      this.N = (this.aq + e + i + k);
      this.O = (this.aq + e + i + l);
      this.P = (this.aq + e + j + o);
      this.Q = (this.aq + e + j + p);
      this.R = (this.aq + e + j + q);
      this.S = (this.aq + e + j + r);
      this.T = (this.aq + e + j + s);
      this.U = (this.aq + e + i + m);
      this.V = (this.aq + e + i + n);
      this.W = (this.aq + f + i + k);
      this.X = (this.aq + f + i + l);
      this.Y = (this.aq + f + j + o);
      this.Z = (this.aq + f + j + p);
      this.aa = (this.aq + f + j + q);
      this.ab = (this.aq + f + j + r);
      this.ac = (this.aq + f + j + s);
      this.ad = (this.aq + f + i + m);
      this.ae = (this.aq + f + i + n);
      this.af = (this.aq + g + i + k);
      this.ag = (this.aq + g + i + l);
      this.ah = (this.aq + g + j + o);
      this.ai = (this.aq + g + j + p);
      this.aj = (this.aq + g + j + q);
      this.ak = (this.aq + g + j + r);
      this.al = (this.aq + g + j + s);
      this.am = (this.aq + g + i + m);
      this.an = (this.aq + g + i + n);
      this.ao = (this.aq + v + w);
      this.ap = (this.aq + v + x);
      return;
    }
  }
  
  public HWCodecAbility a()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        HWCodecAbility localHWCodecAbility = new HWCodecAbility(4, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.W);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.X, this.ac)))
          {
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ab);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.Y);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.Z);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.aa);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ad);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxW = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ae);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxH = localObject[0];
            }
            return localHWCodecAbility;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser == null) {}
    for (;;)
    {
      return false;
      try
      {
        int[] arrayOfInt = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ao);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          arrayOfInt = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ap);
          if (arrayOfInt != null)
          {
            boolean bool = ArrayUtils.contains(arrayOfInt, paramInt);
            if (bool) {
              return true;
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  boolean a(ConfigBaseParser paramConfigBaseParser, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int != 2) {}
    for (;;)
    {
      return true;
      int i2 = AVCoreUtil.getQQVersion();
      if (AVCoreUtil.strVersionToInt(paramConfigBaseParser.a(paramString1, "")) > i2) {
        return false;
      }
      if (paramString2 != null)
      {
        paramConfigBaseParser = paramConfigBaseParser.a(paramString2);
        if (paramConfigBaseParser != null)
        {
          int i3 = paramConfigBaseParser.length;
          int i1 = 0;
          while (i1 < i3)
          {
            if (AVCoreUtil.strVersionToInt(paramConfigBaseParser[i1]) == i2) {
              return false;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  int[] a(ConfigBaseParser paramConfigBaseParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramConfigBaseParser.a(paramString);
  }
  
  String[] a(ConfigBaseParser paramConfigBaseParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramConfigBaseParser.a(paramString);
  }
  
  public HWCodecAbility b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < 19.");
      return null;
    }
    HWCodecAbility localHWCodecAbility = new HWCodecAbility(8, true);
    try
    {
      localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.af);
      if (localObject == null)
      {
        AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. minsdk == null.");
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. err msg = " + localException.getMessage());
      return null;
    }
    if (Build.VERSION.SDK_INT < localObject[0])
    {
      AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < minsdk[0]. minsdk[0] = " + localObject[0]);
      return null;
    }
    if (!a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ag, this.al))
    {
      AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. checkQQVer failed.");
      return null;
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ak);
    int i1;
    if (localObject != null)
    {
      i1 = 0;
      if (i1 < localObject.length)
      {
        if (Build.VERSION.SDK_INT != localObject[i1]) {
          break label453;
        }
        AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.VERSION.SDK_INT == disablesdk[i].");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ah);
    if (localObject != null)
    {
      i1 = 0;
      label248:
      if (i1 < localObject.length)
      {
        if (!Build.MODEL.equalsIgnoreCase(localObject[i1])) {
          break label460;
        }
        AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.MODEL.equalsIgnoreCase(models[i]).");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.ai);
    if (localObject != null)
    {
      i1 = 0;
      label300:
      if (i1 < localObject.length)
      {
        if (!Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
          break label467;
        }
        AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(products[i]).");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.aj);
    if (localObject != null) {
      i1 = i2;
    }
    for (;;)
    {
      if (i1 < localObject.length)
      {
        if (Build.PRODUCT.equalsIgnoreCase(localObject[i1]))
        {
          AVCoreLog.e("CodecConfigParser", "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(fingerprints[i].");
          return null;
        }
      }
      else
      {
        localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.am);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.maxW = localObject[0];
        }
        localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.an);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.maxH = localObject[0];
        }
        return localException;
        label453:
        i1 += 1;
        break;
        label460:
        i1 += 1;
        break label248;
        label467:
        i1 += 1;
        break label300;
      }
      i1 += 1;
    }
  }
  
  public HWCodecAbility c()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        HWCodecAbility localHWCodecAbility = new HWCodecAbility(1, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.E);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.F, this.K)))
          {
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.J);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.G);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.H);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.I);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.L);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxW = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.M);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxH = localObject[0];
            }
            return localHWCodecAbility;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  public HWCodecAbility d()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 19)
      {
        HWCodecAbility localHWCodecAbility = new HWCodecAbility(2, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.N);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.O, this.T)))
          {
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.S);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.P);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.Q);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.R);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.U);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxW = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser, this.V);
            if ((localObject != null) && (localObject[0] > 0)) {
              localHWCodecAbility.maxH = localObject[0];
            }
            return localHWCodecAbility;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.mediacodec.config.CodecConfigParser
 * JD-Core Version:    0.7.0.1
 */