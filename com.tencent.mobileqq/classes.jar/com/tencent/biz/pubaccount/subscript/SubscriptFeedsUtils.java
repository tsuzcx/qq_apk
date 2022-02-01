package com.tencent.biz.pubaccount.subscript;

import android.util.Base64;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SubscriptFeedsUtils
{
  public static final String a = HardCodeUtil.a(2131911972);
  public static final String b = HardCodeUtil.a(2131911964);
  public static final String c = HardCodeUtil.a(2131911968);
  public static final String d = HardCodeUtil.a(2131911977);
  public static final String e = HardCodeUtil.a(2131911966);
  public static final String f = HardCodeUtil.a(2131911965);
  public static final String g = HardCodeUtil.a(2131911963);
  public static final String h = HardCodeUtil.a(2131911979);
  public static final String i = HardCodeUtil.a(2131911971);
  public static final String j = HardCodeUtil.a(2131911973);
  public static final String k = HardCodeUtil.a(2131911976);
  public static final String l = HardCodeUtil.a(2131911974);
  public static final String m = HardCodeUtil.a(2131911981);
  public static final String n = HardCodeUtil.a(2131911970);
  public static final String o = HardCodeUtil.a(2131911967);
  public static final String p = HardCodeUtil.a(2131911975);
  
  public static String a(List<?> paramList)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramList);
    paramList = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
    localObjectOutputStream.close();
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsUtils
 * JD-Core Version:    0.7.0.1
 */