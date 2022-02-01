package com.tencent.map.sdk.a;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

public final class fc
{
  public static final ee<StringBuffer> A = new fc.9();
  public static final ef B = a(StringBuffer.class, A);
  public static final ee<URL> C = new fc.10();
  public static final ef D = a(URL.class, C);
  public static final ee<URI> E = new fc.11();
  public static final ef F = a(URI.class, E);
  public static final ee<InetAddress> G = new fc.13();
  public static final ef H = b(InetAddress.class, G);
  public static final ee<UUID> I = new fc.14();
  public static final ef J = a(UUID.class, I);
  public static final ef K = new fc.15();
  public static final ee<Calendar> L = new fc.16();
  public static final ef M = new fc.24(Calendar.class, GregorianCalendar.class, L);
  public static final ee<Locale> N = new fc.17();
  public static final ef O = a(Locale.class, N);
  public static final ee<dt> P = new fc.18();
  public static final ef Q = b(dt.class, P);
  public static final ef R = new fc.19();
  public static final ee<Class> a = new fc.1();
  public static final ef b = a(Class.class, a);
  public static final ee<BitSet> c = new fc.12();
  public static final ef d = a(BitSet.class, c);
  public static final ee<Boolean> e = new fc.23();
  public static final ee<Boolean> f = new fc.27();
  public static final ef g = a(Boolean.TYPE, Boolean.class, e);
  public static final ee<Number> h = new fc.28();
  public static final ef i = a(Byte.TYPE, Byte.class, h);
  public static final ee<Number> j = new fc.29();
  public static final ef k = a(Short.TYPE, Short.class, j);
  public static final ee<Number> l = new fc.30();
  public static final ef m = a(Integer.TYPE, Integer.class, l);
  public static final ee<Number> n = new fc.31();
  public static final ee<Number> o = new fc.32();
  public static final ee<Number> p = new fc.2();
  public static final ee<Number> q = new fc.3();
  public static final ef r = a(Number.class, q);
  public static final ee<Character> s = new fc.4();
  public static final ef t = a(Character.TYPE, Character.class, s);
  public static final ee<String> u = new fc.5();
  public static final ee<BigDecimal> v = new fc.6();
  public static final ee<BigInteger> w = new fc.7();
  public static final ef x = a(String.class, u);
  public static final ee<StringBuilder> y = new fc.8();
  public static final ef z = a(StringBuilder.class, y);
  
  public static <TT> ef a(fd<TT> paramfd, ee<TT> paramee)
  {
    return new fc.20(paramfd, paramee);
  }
  
  public static <TT> ef a(Class<TT> paramClass, ee<TT> paramee)
  {
    return new fc.21(paramClass, paramee);
  }
  
  public static <TT> ef a(Class<TT> paramClass1, Class<TT> paramClass2, ee<? super TT> paramee)
  {
    return new fc.22(paramClass1, paramClass2, paramee);
  }
  
  private static <TT> ef b(Class<TT> paramClass, ee<TT> paramee)
  {
    return new fc.25(paramClass, paramee);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc
 * JD-Core Version:    0.7.0.1
 */