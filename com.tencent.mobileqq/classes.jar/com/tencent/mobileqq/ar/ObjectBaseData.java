package com.tencent.mobileqq.ar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.HardCodeUtil;

public abstract class ObjectBaseData
{
  public float A;
  public float B;
  public int C;
  public int D;
  public float E;
  public float F;
  public int G;
  public float H;
  public float I;
  public float J;
  public float K;
  public float L;
  public String M;
  public String N;
  public String O;
  public boolean P;
  public boolean Q;
  public String R;
  public RectF S;
  public boolean T;
  public String U;
  public float V;
  public float W;
  public float X;
  public float Y;
  public float Z;
  public float a;
  public float aA;
  public int aB;
  public float aC;
  public float aD;
  public float aE;
  public float aF;
  public int aG;
  public float aH;
  public float aI;
  public float aJ;
  public float aK;
  public float aL;
  public float aM;
  public float aN;
  public float aO;
  public float aP;
  public float aQ;
  public float aR;
  public float aS;
  public float aT;
  public int aU;
  public float aV;
  public float aW;
  public float aX;
  public int aY;
  public float aZ;
  public float aa;
  public float ab;
  public float ac;
  public int ad;
  public float ae;
  public float af;
  public float ag;
  public float ah = 1.0F;
  public float ai;
  public float aj;
  public float ak;
  public float al;
  public float am;
  public float an;
  public float ao;
  public float ap;
  public float aq;
  public int ar;
  public float as;
  public float at;
  public float au;
  public float av;
  public float aw;
  public float ax;
  public float ay;
  public float az;
  public float b;
  public float bA;
  public float bB;
  public int bC;
  public float bD;
  public float bE;
  public float bF;
  public float bG;
  public float bH;
  public float bI;
  public int bJ;
  public float bK;
  public float bL = 1.0F;
  public float bM;
  public float bN;
  public float bO;
  public float bP;
  public float bQ;
  public float bR;
  public int bS;
  public int bT;
  public int bU;
  public float bV;
  public float bW;
  public float bX;
  public float bY;
  public float bZ;
  public float ba;
  public float bb;
  public String bc = HardCodeUtil.a(2131905506);
  public String bd = "YANG YANG";
  public float be;
  public float bf;
  public float bg;
  public float bh;
  public float bi;
  public float bj;
  public float bk;
  public int bl;
  public float bm;
  public float bn;
  public float bo;
  public float bp;
  public float bq;
  public float br;
  public float bs;
  public float bt;
  public float bu;
  public float bv;
  public float bw;
  public float bx;
  public float by;
  public float bz;
  public boolean c;
  public float cA;
  public float cB;
  public int cC;
  public float cD;
  public float cE;
  public float cF;
  public float cG;
  public Paint cH;
  public Paint cI;
  public Paint cJ;
  public Paint cK;
  public Paint cL;
  public Paint cM;
  public Paint cN;
  public Paint cO;
  public Paint cP;
  public TextPaint cQ;
  public Paint cR;
  public Paint cS;
  public Paint cT;
  public Paint cU;
  public Paint cV;
  public Paint cW;
  public TextPaint cX;
  public Paint cY;
  public Paint cZ;
  public float ca;
  public String cb;
  public String cc;
  public float cd;
  public float ce;
  public float cf;
  public float cg;
  public float ch;
  public float ci;
  public float cj;
  public float ck;
  public float cl;
  public int cm;
  public float cn;
  public float co;
  public float cp;
  public int cq;
  public float cr;
  public float cs;
  public float ct;
  public float cu;
  public float cv;
  public int cw;
  public float cx;
  public int cy;
  public float cz;
  public boolean d;
  public Paint da;
  public Paint db;
  public float e = 1.0F;
  public boolean f;
  public boolean g;
  public boolean h;
  public Context i;
  public float j;
  public float k;
  public float l;
  public float m = 1.0F;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r;
  public float s;
  public int t;
  public int u;
  public float v;
  public float w;
  public float x;
  public float y;
  public float z;
  
  public ObjectBaseData(Context paramContext)
  {
    this.i = paramContext;
    a();
    u();
  }
  
  private void a()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = (WindowManager)((Context)localObject).getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.j = localDisplayMetrics.widthPixels;
      this.k = localDisplayMetrics.heightPixels;
    }
    v();
    this.cH = new Paint();
    this.cH.setStrokeCap(Paint.Cap.ROUND);
    this.cH.setAntiAlias(true);
    this.cH.setStyle(Paint.Style.STROKE);
    this.cH.setDither(true);
    this.cI = new Paint();
    this.cI.setStrokeCap(Paint.Cap.ROUND);
    this.cI.setAntiAlias(true);
    this.cI.setStyle(Paint.Style.FILL);
    this.cI.setDither(true);
    this.cI.setStrokeWidth(ObjectBaseData.Dip2PxCache.b);
    this.cJ = new Paint();
    this.cJ.setStrokeCap(Paint.Cap.ROUND);
    this.cJ.setAntiAlias(true);
    this.cJ.setStyle(Paint.Style.STROKE);
    this.cJ.setDither(true);
    this.cK = new Paint();
    this.cK.setStrokeCap(Paint.Cap.ROUND);
    this.cK.setAntiAlias(true);
    this.cK.setStyle(Paint.Style.STROKE);
    this.cK.setDither(true);
    this.cL = new Paint();
    this.cL.setStrokeCap(Paint.Cap.ROUND);
    this.cL.setAntiAlias(true);
    this.cL.setStyle(Paint.Style.STROKE);
    this.cL.setDither(true);
    this.cM = new Paint();
    this.cM.setStrokeCap(Paint.Cap.ROUND);
    this.cM.setAntiAlias(true);
    this.cM.setStyle(Paint.Style.STROKE);
    this.cM.setDither(true);
    this.cN = new Paint();
    this.cN.setStrokeCap(Paint.Cap.ROUND);
    this.cN.setAntiAlias(true);
    this.cN.setStyle(Paint.Style.STROKE);
    this.cN.setDither(true);
    this.cO = new Paint();
    this.cO.setStrokeCap(Paint.Cap.ROUND);
    this.cO.setAntiAlias(true);
    this.cO.setStyle(Paint.Style.FILL);
    this.cO.setDither(true);
    this.cP = new Paint();
    this.cP.setStrokeCap(Paint.Cap.SQUARE);
    this.cP.setAntiAlias(true);
    this.cP.setDither(true);
    this.cP.setColor(this.bl);
    this.cQ = new TextPaint(this.cP);
    this.cR = new Paint();
    this.cR.setStrokeCap(Paint.Cap.SQUARE);
    this.cR.setAntiAlias(true);
    this.cR.setDither(true);
    this.cR.setColor(this.bl);
    this.cS = new Paint();
    this.cS.setStrokeCap(Paint.Cap.SQUARE);
    this.cS.setAntiAlias(true);
    this.cS.setDither(true);
    this.cS.setColor(-1);
    this.cS.setStrokeWidth(this.bF);
    this.cT = new Paint();
    this.cT.setStrokeCap(Paint.Cap.ROUND);
    this.cT.setAntiAlias(true);
    this.cT.setDither(true);
    this.cT.setColor(-1);
    this.cU = new Paint();
    this.cU.setStrokeCap(Paint.Cap.ROUND);
    this.cU.setAntiAlias(true);
    this.cU.setStyle(Paint.Style.FILL);
    this.cU.setDither(true);
    this.cU.setColor(this.bS);
    this.cV = new Paint();
    this.cV.setStrokeCap(Paint.Cap.SQUARE);
    this.cV.setAntiAlias(true);
    this.cV.setDither(true);
    this.cV.setColor(-16777216);
    this.cW = new Paint();
    this.cW.setStrokeCap(Paint.Cap.SQUARE);
    this.cW.setAntiAlias(true);
    this.cW.setDither(true);
    this.cW.setColor(this.cm);
    this.cX = new TextPaint(this.cW);
    this.cY = new Paint();
    this.cY.setAntiAlias(true);
    this.cY.setDither(true);
    this.cY.setColor(-1);
    this.cZ = new Paint();
    this.cZ.setAntiAlias(true);
    this.cZ.setDither(true);
    this.cZ.setStyle(Paint.Style.STROKE);
    this.cZ.setColor(this.cw);
    this.cZ.setStrokeWidth(this.cv);
    this.da = new Paint();
    this.da.setAntiAlias(true);
    this.da.setStrokeCap(Paint.Cap.ROUND);
    this.da.setDither(true);
    this.da.setStyle(Paint.Style.FILL);
    this.da.setColor(this.cy);
    this.db = new Paint();
    this.db.setAntiAlias(true);
    this.db.setDither(true);
    this.db.setStyle(Paint.Style.STROKE);
    this.db.setColor(this.cC);
    this.db.setStrokeWidth(this.cB);
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
    this.l *= paramFloat;
    this.o *= paramFloat;
    this.v *= paramFloat;
    this.V *= paramFloat;
    this.Y *= paramFloat;
    this.ag *= paramFloat;
    this.ak *= paramFloat;
    this.at *= paramFloat;
    this.au *= paramFloat;
    this.aD *= paramFloat;
    this.aF *= paramFloat;
    this.aK *= paramFloat;
    this.aL *= paramFloat;
    this.aX *= paramFloat;
    this.bb *= paramFloat;
    this.bj *= paramFloat;
    this.bf *= paramFloat;
    this.bg *= paramFloat;
    this.bp *= paramFloat;
    this.bq *= paramFloat;
    this.bt *= paramFloat;
    this.bu *= paramFloat;
    this.bm = (this.bo * paramFloat);
    this.br = (this.bs * paramFloat);
    this.bj *= paramFloat;
    this.bv *= paramFloat;
    this.bw *= paramFloat;
    this.bx *= paramFloat;
    this.bA *= paramFloat;
    this.bB *= paramFloat;
    this.bF *= paramFloat;
    this.bH *= paramFloat;
    this.bI *= paramFloat;
    this.bK *= paramFloat;
    this.bM *= paramFloat;
    this.cu *= paramFloat;
    this.cv *= paramFloat;
    this.cx *= paramFloat;
    this.cA *= paramFloat;
    this.cB *= paramFloat;
    this.cF *= paramFloat;
    this.cG *= paramFloat;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public void b()
  {
    this.l = ObjectBaseData.Dip2PxCache.I;
    this.o = ObjectBaseData.Dip2PxCache.h;
    this.v = ObjectBaseData.Dip2PxCache.i;
    this.V = ObjectBaseData.Dip2PxCache.L;
    this.Y = ObjectBaseData.Dip2PxCache.c;
    this.ag = ObjectBaseData.Dip2PxCache.G;
    this.aj = ObjectBaseData.Dip2PxCache.H;
    this.ak = ObjectBaseData.Dip2PxCache.b;
    this.at = ObjectBaseData.Dip2PxCache.G;
    this.au = ObjectBaseData.Dip2PxCache.c;
    this.aD = ObjectBaseData.Dip2PxCache.G;
    this.aF = ObjectBaseData.Dip2PxCache.u;
    this.aK = ObjectBaseData.Dip2PxCache.q;
    this.aL = ObjectBaseData.Dip2PxCache.b;
    this.aX = ObjectBaseData.Dip2PxCache.c;
    this.bb = ObjectBaseData.Dip2PxCache.k;
    this.bj = ObjectBaseData.Dip2PxCache.x;
    this.bf = ObjectBaseData.Dip2PxCache.C;
    this.bg = ObjectBaseData.Dip2PxCache.u;
    this.bo = ObjectBaseData.Dip2PxCache.x;
    this.bp = ObjectBaseData.Dip2PxCache.x;
    this.bq = ObjectBaseData.Dip2PxCache.p;
    this.bs = ObjectBaseData.Dip2PxCache.r;
    this.bt = ObjectBaseData.Dip2PxCache.r;
    this.bu = ObjectBaseData.Dip2PxCache.j;
    this.bj = ObjectBaseData.Dip2PxCache.r;
    this.bv = ObjectBaseData.Dip2PxCache.k;
    this.bw = ObjectBaseData.Dip2PxCache.m;
    this.bx = 0.0F;
    this.bA = ObjectBaseData.Dip2PxCache.m;
    this.bB = ObjectBaseData.Dip2PxCache.b;
    this.bF = ObjectBaseData.Dip2PxCache.a;
    this.bH = ObjectBaseData.Dip2PxCache.A;
    this.bI = ObjectBaseData.Dip2PxCache.o;
    this.bK = ObjectBaseData.Dip2PxCache.f;
    this.bM = ObjectBaseData.Dip2PxCache.d;
    this.cu = ObjectBaseData.Dip2PxCache.F;
    this.cv = ObjectBaseData.Dip2PxCache.e;
    this.cx = ObjectBaseData.Dip2PxCache.h;
    this.cA = ObjectBaseData.Dip2PxCache.y;
    this.cB = ObjectBaseData.Dip2PxCache.c;
    this.cF = ObjectBaseData.Dip2PxCache.v;
    this.cG = ObjectBaseData.Dip2PxCache.D;
  }
  
  public void setBCAlpha(float paramFloat)
  {
    this.F = paramFloat;
  }
  
  public void setBCColor(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setBCRotate(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void setBCScale(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  public void setBCWidth(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void setBTAlpha(float paramFloat)
  {
    this.E = paramFloat;
  }
  
  public void setCenterX(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void setCenterY(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void setFCAlpha(float paramFloat)
  {
    this.bP = paramFloat;
  }
  
  public void setFCPositionY(float paramFloat)
  {
    this.bO = paramFloat;
  }
  
  public void setFLAlpha(float paramFloat)
  {
    this.bG = paramFloat;
  }
  
  public void setFLPAlpha(float paramFloat)
  {
    this.bN = paramFloat;
  }
  
  public void setFNCHAlpha(float paramFloat)
  {
    this.by = paramFloat;
  }
  
  public void setFNENAlpha(float paramFloat)
  {
    this.bz = paramFloat;
  }
  
  public void setFPAlpha(float paramFloat)
  {
    this.ct = paramFloat;
  }
  
  public void setFPOutCircleAlpha(float paramFloat)
  {
    this.cD = paramFloat;
  }
  
  public void setFPOutCircleScale(float paramFloat)
  {
    this.cE = paramFloat;
  }
  
  public void setIBCAlpha(float paramFloat)
  {
    this.as = paramFloat;
  }
  
  public void setIBCRotate(float paramFloat)
  {
    this.ai = paramFloat;
  }
  
  public void setIBCScale(float paramFloat)
  {
    this.ah = paramFloat;
  }
  
  public void setISCAlpha(float paramFloat)
  {
    this.aC = paramFloat;
  }
  
  public void setMainFace(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setMaskScale(float paramFloat)
  {
    this.ba = paramFloat;
  }
  
  public void setOCAlpha(float paramFloat)
  {
    this.ae = paramFloat;
  }
  
  public void setOCRotate(float paramFloat)
  {
    this.X = paramFloat;
  }
  
  public void setOCScale(float paramFloat)
  {
    this.W = paramFloat;
  }
  
  public void setOtherScale(float paramFloat)
  {
    this.bL = paramFloat;
  }
  
  public void setSCAlpha(float paramFloat)
  {
    this.aV = paramFloat;
  }
  
  public void setSCRotate(float paramFloat)
  {
    this.aJ = paramFloat;
  }
  
  public void setSCScale(float paramFloat)
  {
    this.aI = paramFloat;
  }
  
  public void setSDAlpha(float paramFloat)
  {
    this.aZ = paramFloat;
  }
  
  public void setSDScale(float paramFloat)
  {
    this.aW = paramFloat;
  }
  
  public void setTCAlpha(float paramFloat)
  {
    this.aH = paramFloat;
  }
  
  public void setTCScale(float paramFloat)
  {
    this.aE = paramFloat;
  }
  
  public void u() {}
  
  public void v()
  {
    this.l = ObjectBaseData.Dip2PxCache.I;
    this.o = ObjectBaseData.Dip2PxCache.h;
    this.p = 234.0F;
    this.q = 36.0F;
    this.r = 54.0F;
    this.s = 216.0F;
    this.t = Color.argb(255, 30, 255, 236);
    this.u = Color.argb(255, 0, 191, 255);
    this.v = ObjectBaseData.Dip2PxCache.i;
    this.w = ((this.p + this.s) / 2.0F);
    this.x = ((this.q + this.r) / 2.0F);
    this.C = Color.argb(255, 30, 255, 236);
    this.D = Color.argb(255, 0, 191, 255);
    this.G = Color.argb(255, 30, 255, 236);
    this.F = 0.0F;
    this.E = 0.0F;
    this.V = ObjectBaseData.Dip2PxCache.L;
    this.Y = ObjectBaseData.Dip2PxCache.c;
    this.Z = 160.0F;
    this.aa = 290.0F;
    this.ab = 340.0F;
    this.ac = 110.0F;
    this.ad = -1;
    this.ae = 102.0F;
    this.af = ObjectBaseData.Dip2PxCache.M;
    this.ag = ObjectBaseData.Dip2PxCache.G;
    this.aj = ObjectBaseData.Dip2PxCache.H;
    this.ak = ObjectBaseData.Dip2PxCache.b;
    this.al = 32.0F;
    this.am = 138.0F;
    this.an = 272.0F;
    this.ao = 18.0F;
    this.ap = 152.0F;
    this.aq = 258.0F;
    this.ar = -1;
    this.as = 0.0F;
    this.at = ObjectBaseData.Dip2PxCache.G;
    this.au = ObjectBaseData.Dip2PxCache.c;
    this.av = 60.0F;
    this.aw = 100.0F;
    this.ax = 300.0F;
    this.ay = 340.0F;
    this.az = 180.0F;
    this.aA = 220.0F;
    this.aB = -1;
    this.aC = 0.0F;
    this.aD = ObjectBaseData.Dip2PxCache.G;
    this.aF = ObjectBaseData.Dip2PxCache.u;
    this.aG = -1;
    this.aH = 0.0F;
    this.aK = ObjectBaseData.Dip2PxCache.q;
    this.aL = ObjectBaseData.Dip2PxCache.b;
    this.aM = 183.0F;
    this.aN = 267.0F;
    this.aO = 93.0F;
    this.aP = 177.0F;
    this.aQ = 273.0F;
    this.aR = 357.0F;
    this.aS = 3.0F;
    this.aT = 87.0F;
    this.aU = -1;
    this.aV = 0.0F;
    this.aX = ObjectBaseData.Dip2PxCache.c;
    this.aY = -1;
    this.aZ = 0.0F;
    this.bb = ObjectBaseData.Dip2PxCache.k;
    this.bl = -1;
    this.bj = ObjectBaseData.Dip2PxCache.x;
    this.bf = ObjectBaseData.Dip2PxCache.C;
    this.bg = ObjectBaseData.Dip2PxCache.u;
    this.bo = ObjectBaseData.Dip2PxCache.x;
    this.bp = ObjectBaseData.Dip2PxCache.x;
    this.bq = ObjectBaseData.Dip2PxCache.p;
    this.bs = ObjectBaseData.Dip2PxCache.r;
    this.bt = ObjectBaseData.Dip2PxCache.r;
    this.bu = ObjectBaseData.Dip2PxCache.j;
    this.bj = ObjectBaseData.Dip2PxCache.r;
    this.bv = ObjectBaseData.Dip2PxCache.k;
    this.bw = ObjectBaseData.Dip2PxCache.m;
    this.bx = 0.0F;
    this.bA = ObjectBaseData.Dip2PxCache.m;
    this.bB = ObjectBaseData.Dip2PxCache.b;
    this.bC = Color.argb(102, 0, 0, 0);
    this.bD = 270.0F;
    this.bE = 40.0F;
    this.bF = ObjectBaseData.Dip2PxCache.a;
    this.bH = ObjectBaseData.Dip2PxCache.A;
    this.bI = ObjectBaseData.Dip2PxCache.o;
    this.bK = ObjectBaseData.Dip2PxCache.f;
    this.bM = ObjectBaseData.Dip2PxCache.d;
    this.bO = 0.0F;
    this.bP = 0.0F;
    this.bQ = ObjectBaseData.Dip2PxCache.K;
    this.bR = ObjectBaseData.Dip2PxCache.C;
    this.bS = Color.argb(229, 255, 255, 255);
    this.bT = Color.argb(229, 255, 255, 255);
    this.bU = Color.argb(127, 255, 255, 255);
    this.bV = ObjectBaseData.Dip2PxCache.i;
    this.bW = ObjectBaseData.Dip2PxCache.s;
    this.cg = ObjectBaseData.Dip2PxCache.z;
    this.bX = ObjectBaseData.Dip2PxCache.s;
    this.bY = ObjectBaseData.Dip2PxCache.s;
    this.bZ = ObjectBaseData.Dip2PxCache.g;
    this.ca = ObjectBaseData.Dip2PxCache.g;
    this.ch = ObjectBaseData.Dip2PxCache.s;
    this.cd = ObjectBaseData.Dip2PxCache.j;
    this.ce = ObjectBaseData.Dip2PxCache.p;
    this.cf = ObjectBaseData.Dip2PxCache.s;
    this.ci = ObjectBaseData.Dip2PxCache.s;
    this.cj = ObjectBaseData.Dip2PxCache.r;
    this.ck = ObjectBaseData.Dip2PxCache.p;
    this.cl = ObjectBaseData.Dip2PxCache.n;
    this.cm = Color.argb(255, 119, 119, 119);
    this.cn = ObjectBaseData.Dip2PxCache.h;
    this.co = ObjectBaseData.Dip2PxCache.r;
    this.cp = ObjectBaseData.Dip2PxCache.e;
    this.cq = Color.argb(76, 0, 104, 144);
    this.cr = ObjectBaseData.Dip2PxCache.l;
    this.cs = ObjectBaseData.Dip2PxCache.i;
    this.ct = 0.0F;
    this.cu = ObjectBaseData.Dip2PxCache.F;
    this.cv = ObjectBaseData.Dip2PxCache.e;
    this.cw = -1;
    this.cx = ObjectBaseData.Dip2PxCache.h;
    this.cy = -1;
    this.cz = 120.0F;
    this.cA = ObjectBaseData.Dip2PxCache.y;
    this.cB = ObjectBaseData.Dip2PxCache.c;
    this.cC = -1;
    this.cD = 0.0F;
    this.cE = 0.0F;
    this.cF = ObjectBaseData.Dip2PxCache.v;
    this.cG = ObjectBaseData.Dip2PxCache.D;
    this.H = ObjectBaseData.Dip2PxCache.k;
    this.by = 0.0F;
    this.bz = 0.0F;
    this.bG = 0.0F;
    this.bN = 0.0F;
    this.bJ = 0;
    this.F = 0.0F;
    this.E = 0.0F;
    this.ae = 0.0F;
    this.aV = 0.0F;
    this.aZ = 0.0F;
    this.aH = 0.0F;
    this.as = 0.0F;
    this.aC = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectBaseData
 * JD-Core Version:    0.7.0.1
 */