package com.tencent.biz.pubaccount.subscript;

import android.util.Base64;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SubscriptFeedsUtils
{
  public static final String a = HardCodeUtil.a(2131714463);
  public static final String b = HardCodeUtil.a(2131714454);
  public static final String c = HardCodeUtil.a(2131714458);
  public static final String d = HardCodeUtil.a(2131714468);
  public static final String e = HardCodeUtil.a(2131714456);
  public static final String f = HardCodeUtil.a(2131714455);
  public static final String g = HardCodeUtil.a(2131714453);
  public static final String h = HardCodeUtil.a(2131714470);
  public static final String i = HardCodeUtil.a(2131714462);
  public static final String j = HardCodeUtil.a(2131714464);
  public static final String k = HardCodeUtil.a(2131714467);
  public static final String l = HardCodeUtil.a(2131714465);
  public static final String m = HardCodeUtil.a(2131714472);
  public static final String n = HardCodeUtil.a(2131714461);
  public static final String o = HardCodeUtil.a(2131714457);
  public static final String p = HardCodeUtil.a(2131714466);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsUtils
 * JD-Core Version:    0.7.0.1
 */