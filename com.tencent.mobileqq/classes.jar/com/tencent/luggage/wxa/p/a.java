package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.x;

abstract class a
{
  public static final int A;
  public static final int B;
  public static final int C;
  public static final int D;
  public static final int E;
  public static final int F;
  public static final int G;
  public static final int H;
  public static final int I;
  public static final int J;
  public static final int K;
  public static final int L;
  public static final int M;
  public static final int N;
  public static final int O;
  public static final int P;
  public static final int Q;
  public static final int R;
  public static final int S;
  public static final int T;
  public static final int U;
  public static final int V;
  public static final int W;
  public static final int X;
  public static final int Y;
  public static final int Z;
  public static final int a = x.f("ftyp");
  public static final int aA = x.f("udta");
  public static final int aB = x.f("meta");
  public static final int aC = x.f("ilst");
  public static final int aD = x.f("mean");
  public static final int aE = x.f("name");
  public static final int aF = x.f("data");
  public static final int aG = x.f("emsg");
  public static final int aH = x.f("st3d");
  public static final int aI = x.f("sv3d");
  public static final int aJ = x.f("proj");
  public static final int aK = x.f("vp08");
  public static final int aL = x.f("vp09");
  public static final int aM = x.f("vpcC");
  public static final int aN = x.f("camm");
  public static final int aO = x.f("alac");
  public static final int aa;
  public static final int ab;
  public static final int ac;
  public static final int ad;
  public static final int ae;
  public static final int af;
  public static final int ag;
  public static final int ah;
  public static final int ai;
  public static final int aj;
  public static final int ak;
  public static final int al;
  public static final int am;
  public static final int an;
  public static final int ao;
  public static final int ap;
  public static final int aq;
  public static final int ar;
  public static final int as;
  public static final int at;
  public static final int au;
  public static final int av;
  public static final int aw;
  public static final int ax;
  public static final int ay;
  public static final int az;
  public static final int b = x.f("avc1");
  public static final int c = x.f("avc3");
  public static final int d = x.f("hvc1");
  public static final int e = x.f("hev1");
  public static final int f = x.f("s263");
  public static final int g = x.f("d263");
  public static final int h = x.f("mdat");
  public static final int i = x.f("mp4a");
  public static final int j = x.f(".mp3");
  public static final int k = x.f("wave");
  public static final int l = x.f("lpcm");
  public static final int m = x.f("sowt");
  public static final int n = x.f("ac-3");
  public static final int o = x.f("dac3");
  public static final int p = x.f("ec-3");
  public static final int q = x.f("dec3");
  public static final int r = x.f("dtsc");
  public static final int s = x.f("dtsh");
  public static final int t = x.f("dtsl");
  public static final int u = x.f("dtse");
  public static final int v = x.f("ddts");
  public static final int w = x.f("tfdt");
  public static final int x = x.f("tfhd");
  public static final int y = x.f("trex");
  public static final int z = x.f("trun");
  public final int aP;
  
  static
  {
    A = x.f("sidx");
    B = x.f("moov");
    C = x.f("mvhd");
    D = x.f("trak");
    E = x.f("mdia");
    F = x.f("minf");
    G = x.f("stbl");
    H = x.f("avcC");
    I = x.f("hvcC");
    J = x.f("esds");
    K = x.f("moof");
    L = x.f("traf");
    M = x.f("mvex");
    N = x.f("mehd");
    O = x.f("tkhd");
    P = x.f("edts");
    Q = x.f("elst");
    R = x.f("mdhd");
    S = x.f("hdlr");
    T = x.f("stsd");
    U = x.f("pssh");
    V = x.f("sinf");
    W = x.f("schm");
    X = x.f("schi");
    Y = x.f("tenc");
    Z = x.f("encv");
    aa = x.f("enca");
    ab = x.f("frma");
    ac = x.f("saiz");
    ad = x.f("saio");
    ae = x.f("sbgp");
    af = x.f("sgpd");
    ag = x.f("uuid");
    ah = x.f("senc");
    ai = x.f("pasp");
    aj = x.f("TTML");
    ak = x.f("vmhd");
    al = x.f("mp4v");
    am = x.f("stts");
    an = x.f("stss");
    ao = x.f("ctts");
    ap = x.f("stsc");
    aq = x.f("stsz");
    ar = x.f("stz2");
    as = x.f("stco");
    at = x.f("co64");
    au = x.f("tx3g");
    av = x.f("wvtt");
    aw = x.f("stpp");
    ax = x.f("c608");
    ay = x.f("samr");
    az = x.f("sawb");
  }
  
  public a(int paramInt)
  {
    this.aP = paramInt;
  }
  
  public static int a(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int b(int paramInt)
  {
    return paramInt & 0xFFFFFF;
  }
  
  public static String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((char)(paramInt >> 24 & 0xFF));
    localStringBuilder.append((char)(paramInt >> 16 & 0xFF));
    localStringBuilder.append((char)(paramInt >> 8 & 0xFF));
    localStringBuilder.append((char)(paramInt & 0xFF));
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return c(this.aP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.a
 * JD-Core Version:    0.7.0.1
 */