package com.tencent.av.report;

import android.content.Intent;
import android.os.SystemClock;

public class AVReport
{
  static volatile AVReport a;
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public boolean J;
  public boolean K;
  public long L;
  public boolean M;
  public long N;
  public boolean O;
  public long P;
  public boolean Q;
  public long R;
  public boolean S;
  public long T;
  public boolean U;
  public long V;
  public boolean W;
  public long X;
  public boolean Y;
  public long Z;
  public boolean aa;
  public long ab;
  public boolean ac;
  public long ad;
  public boolean ae;
  public long af;
  public boolean ag;
  public long ah;
  public String ai = "";
  public boolean aj;
  public String ak = "";
  public boolean al;
  public long am;
  public int b;
  public int c;
  public boolean d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  public static AVReport a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVReport();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.ai = paramString;
    if (paramIntent != null)
    {
      this.l = SystemClock.elapsedRealtime();
      this.d = paramIntent.getBooleanExtra("isSender", false);
      if (this.d)
      {
        this.l = SystemClock.elapsedRealtime();
        this.m = 0L;
        this.e = paramIntent.getLongExtra("senderStartTime", 0L);
        return;
      }
      this.A = SystemClock.elapsedRealtime();
    }
  }
  
  public void b()
  {
    this.al = false;
    this.d = false;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.F = 0L;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.J = false;
    this.K = false;
    this.aj = false;
    this.L = 0L;
    this.M = false;
    this.N = 0L;
    this.O = false;
    this.P = 0L;
    this.Q = false;
    this.R = 0L;
    this.S = false;
    this.T = 0L;
    this.U = false;
    this.V = 0L;
    this.W = false;
    this.X = 0L;
    this.Y = false;
    this.Z = 0L;
    this.aa = false;
    this.ab = 0L;
    this.ac = false;
    this.ad = 0L;
    this.ae = false;
    this.af = 0L;
    this.ag = false;
    this.ah = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVReport
 * JD-Core Version:    0.7.0.1
 */