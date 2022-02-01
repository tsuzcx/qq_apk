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
  public float C;
  public float D;
  public float E;
  public float F;
  public float G;
  public float H;
  public float I;
  public float J;
  public float K;
  public float L;
  public float M = 1.0F;
  public float N;
  public float O;
  public float P;
  public float Q;
  public float R;
  public float S;
  public float T;
  public float U;
  public float V;
  public float W;
  public float X;
  public float Y;
  public float Z;
  public float a;
  public int a;
  public Context a;
  public Paint a;
  public RectF a;
  public TextPaint a;
  public String a;
  public boolean a;
  public float aA;
  public float aB;
  public float aC;
  public float aD;
  public float aE;
  public float aF;
  public float aG;
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
  public float aU;
  public float aV;
  public float aW;
  public float aX;
  public float aY;
  public float aZ;
  public float aa;
  public float ab;
  public float ac;
  public float ad;
  public float ae;
  public float af;
  public float ag;
  public float ah;
  public float ai;
  public float aj;
  public float ak;
  public float al;
  public float am;
  public float an;
  public float ao;
  public float ap;
  public float aq;
  public float ar;
  public float as;
  public float at;
  public float au;
  public float av;
  public float aw;
  public float ax;
  public float ay;
  public float az;
  public float b;
  public int b;
  public Paint b;
  public TextPaint b;
  public String b;
  public boolean b;
  public float bA;
  public float bB;
  public float bC;
  public float bD;
  public float bE;
  public float bF;
  public float bG;
  public float bH;
  public float bI;
  public float bJ;
  public float bK;
  public float bL;
  public float bM;
  public float bN;
  public float bO;
  public float bP;
  public float bQ;
  public float bR;
  public float ba;
  public float bb;
  public float bc;
  public float bd;
  public float be;
  public float bf;
  public float bg = 1.0F;
  public float bh;
  public float bi;
  public float bj;
  public float bk;
  public float bl;
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
  public float c;
  public int c;
  public Paint c;
  public String c;
  public boolean c;
  public float d;
  public int d;
  public Paint d;
  public String d;
  public boolean d;
  public float e;
  public int e;
  public Paint e;
  public String e;
  public boolean e;
  public float f;
  public int f;
  public Paint f;
  public String f;
  public boolean f;
  public float g;
  public int g;
  public Paint g;
  public String g;
  public boolean g;
  public float h;
  public int h;
  public Paint h;
  public String h;
  public boolean h;
  public float i;
  public int i;
  public Paint i;
  public String i;
  public float j;
  public int j;
  public Paint j;
  public float k;
  public int k;
  public Paint k;
  public float l;
  public int l;
  public Paint l;
  public float m;
  public int m;
  public Paint m;
  public float n;
  public int n;
  public Paint n;
  public float o;
  public int o;
  public Paint o;
  public float p;
  public int p;
  public Paint p;
  public float q;
  public int q;
  public Paint q;
  public float r;
  public int r;
  public Paint r;
  public float s;
  public int s;
  public Paint s;
  public float t;
  public int t;
  public float u;
  public int u;
  public float v;
  public int v;
  public float w;
  public float x;
  public float y;
  public float z;
  
  public ObjectBaseData(Context paramContext)
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_g_of_type_Float = 1.0F;
    this.jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131707668);
    this.jdField_g_of_type_JavaLangString = "YANG YANG";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    u();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.jdField_d_of_type_Float = localDisplayMetrics.widthPixels;
      this.jdField_e_of_type_Float = localDisplayMetrics.heightPixels;
    }
    v();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_g_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_g_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_g_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_g_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_g_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_h_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_h_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_h_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_h_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_h_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_i_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_i_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_i_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_i_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_i_of_type_AndroidGraphicsPaint.setColor(this.jdField_l_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(this.jdField_i_of_type_AndroidGraphicsPaint);
    this.jdField_j_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_j_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_j_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_j_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_j_of_type_AndroidGraphicsPaint.setColor(this.jdField_l_of_type_Int);
    this.jdField_k_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_k_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_k_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_k_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_k_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_k_of_type_AndroidGraphicsPaint.setStrokeWidth(this.bb);
    this.jdField_l_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_l_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_l_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_l_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_l_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_m_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_m_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_m_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_m_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_m_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_m_of_type_AndroidGraphicsPaint.setColor(this.jdField_o_of_type_Int);
    this.jdField_n_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_n_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_n_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_n_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_n_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_o_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_o_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_o_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_o_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_o_of_type_AndroidGraphicsPaint.setColor(this.jdField_r_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(this.jdField_o_of_type_AndroidGraphicsPaint);
    this.jdField_p_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_p_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_p_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_p_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_q_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_q_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_q_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_q_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_q_of_type_AndroidGraphicsPaint.setColor(this.t);
    this.jdField_q_of_type_AndroidGraphicsPaint.setStrokeWidth(this.bJ);
    this.jdField_r_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_r_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_r_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_r_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_r_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_r_of_type_AndroidGraphicsPaint.setColor(this.jdField_u_of_type_Int);
    this.jdField_s_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_s_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_s_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_s_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_s_of_type_AndroidGraphicsPaint.setColor(this.jdField_v_of_type_Int);
    this.jdField_s_of_type_AndroidGraphicsPaint.setStrokeWidth(this.bN);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
    this.jdField_f_of_type_Float *= paramFloat;
    this.jdField_i_of_type_Float *= paramFloat;
    this.jdField_n_of_type_Float *= paramFloat;
    this.B *= paramFloat;
    this.E *= paramFloat;
    this.L *= paramFloat;
    this.P *= paramFloat;
    this.X *= paramFloat;
    this.Y *= paramFloat;
    this.ag *= paramFloat;
    this.ai *= paramFloat;
    this.am *= paramFloat;
    this.an *= paramFloat;
    this.ay *= paramFloat;
    this.aB *= paramFloat;
    this.aH *= paramFloat;
    this.aD *= paramFloat;
    this.aE *= paramFloat;
    this.aM *= paramFloat;
    this.aN *= paramFloat;
    this.aQ *= paramFloat;
    this.aR *= paramFloat;
    this.aJ = (this.aL * paramFloat);
    this.aO = (this.aP * paramFloat);
    this.aH *= paramFloat;
    this.aS *= paramFloat;
    this.aT *= paramFloat;
    this.aU *= paramFloat;
    this.aX *= paramFloat;
    this.aY *= paramFloat;
    this.bb *= paramFloat;
    this.bd *= paramFloat;
    this.be *= paramFloat;
    this.bf *= paramFloat;
    this.bh *= paramFloat;
    this.bI *= paramFloat;
    this.bJ *= paramFloat;
    this.bK *= paramFloat;
    this.bM *= paramFloat;
    this.bN *= paramFloat;
    this.bQ *= paramFloat;
    this.bR *= paramFloat;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public void b()
  {
    this.jdField_f_of_type_Float = ObjectBaseData.Dip2PxCache.I;
    this.jdField_i_of_type_Float = ObjectBaseData.Dip2PxCache.jdField_h_of_type_Int;
    this.jdField_n_of_type_Float = ObjectBaseData.Dip2PxCache.jdField_i_of_type_Int;
    this.B = ObjectBaseData.Dip2PxCache.L;
    this.E = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.L = ObjectBaseData.Dip2PxCache.G;
    this.O = ObjectBaseData.Dip2PxCache.H;
    this.P = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.X = ObjectBaseData.Dip2PxCache.G;
    this.Y = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.ag = ObjectBaseData.Dip2PxCache.G;
    this.ai = ObjectBaseData.Dip2PxCache.jdField_u_of_type_Int;
    this.am = ObjectBaseData.Dip2PxCache.jdField_q_of_type_Int;
    this.an = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.ay = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.aB = ObjectBaseData.Dip2PxCache.jdField_k_of_type_Int;
    this.aH = ObjectBaseData.Dip2PxCache.x;
    this.aD = ObjectBaseData.Dip2PxCache.C;
    this.aE = ObjectBaseData.Dip2PxCache.jdField_u_of_type_Int;
    this.aL = ObjectBaseData.Dip2PxCache.x;
    this.aM = ObjectBaseData.Dip2PxCache.x;
    this.aN = ObjectBaseData.Dip2PxCache.jdField_p_of_type_Int;
    this.aP = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aQ = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aR = ObjectBaseData.Dip2PxCache.jdField_j_of_type_Int;
    this.aH = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aS = ObjectBaseData.Dip2PxCache.jdField_k_of_type_Int;
    this.aT = ObjectBaseData.Dip2PxCache.jdField_m_of_type_Int;
    this.aU = 0.0F;
    this.aX = ObjectBaseData.Dip2PxCache.jdField_m_of_type_Int;
    this.aY = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.bb = ObjectBaseData.Dip2PxCache.jdField_a_of_type_Int;
    this.bd = ObjectBaseData.Dip2PxCache.A;
    this.be = ObjectBaseData.Dip2PxCache.jdField_o_of_type_Int;
    this.bf = ObjectBaseData.Dip2PxCache.jdField_f_of_type_Int;
    this.bh = ObjectBaseData.Dip2PxCache.jdField_d_of_type_Int;
    this.bI = ObjectBaseData.Dip2PxCache.F;
    this.bJ = ObjectBaseData.Dip2PxCache.jdField_e_of_type_Int;
    this.bK = ObjectBaseData.Dip2PxCache.jdField_h_of_type_Int;
    this.bM = ObjectBaseData.Dip2PxCache.y;
    this.bN = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.bQ = ObjectBaseData.Dip2PxCache.jdField_v_of_type_Int;
    this.bR = ObjectBaseData.Dip2PxCache.D;
  }
  
  public void setBCAlpha(float paramFloat)
  {
    this.jdField_v_of_type_Float = paramFloat;
  }
  
  public void setBCColor(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setBCRotate(float paramFloat)
  {
    this.jdField_h_of_type_Float = paramFloat;
  }
  
  public void setBCScale(float paramFloat)
  {
    this.jdField_g_of_type_Float = paramFloat;
  }
  
  public void setBCWidth(float paramFloat)
  {
    this.jdField_i_of_type_Float = paramFloat;
  }
  
  public void setBTAlpha(float paramFloat)
  {
    this.jdField_u_of_type_Float = paramFloat;
  }
  
  public void setCenterX(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setCenterY(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setFCAlpha(float paramFloat)
  {
    this.bk = paramFloat;
  }
  
  public void setFCPositionY(float paramFloat)
  {
    this.bj = paramFloat;
  }
  
  public void setFLAlpha(float paramFloat)
  {
    this.bc = paramFloat;
  }
  
  public void setFLPAlpha(float paramFloat)
  {
    this.bi = paramFloat;
  }
  
  public void setFNCHAlpha(float paramFloat)
  {
    this.aV = paramFloat;
  }
  
  public void setFNENAlpha(float paramFloat)
  {
    this.aW = paramFloat;
  }
  
  public void setFPAlpha(float paramFloat)
  {
    this.bH = paramFloat;
  }
  
  public void setFPOutCircleAlpha(float paramFloat)
  {
    this.bO = paramFloat;
  }
  
  public void setFPOutCircleScale(float paramFloat)
  {
    this.bP = paramFloat;
  }
  
  public void setIBCAlpha(float paramFloat)
  {
    this.W = paramFloat;
  }
  
  public void setIBCRotate(float paramFloat)
  {
    this.N = paramFloat;
  }
  
  public void setIBCScale(float paramFloat)
  {
    this.M = paramFloat;
  }
  
  public void setISCAlpha(float paramFloat)
  {
    this.af = paramFloat;
  }
  
  public void setMainFace(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaskScale(float paramFloat)
  {
    this.aA = paramFloat;
  }
  
  public void setOCAlpha(float paramFloat)
  {
    this.J = paramFloat;
  }
  
  public void setOCRotate(float paramFloat)
  {
    this.D = paramFloat;
  }
  
  public void setOCScale(float paramFloat)
  {
    this.C = paramFloat;
  }
  
  public void setOtherScale(float paramFloat)
  {
    this.bg = paramFloat;
  }
  
  public void setSCAlpha(float paramFloat)
  {
    this.aw = paramFloat;
  }
  
  public void setSCRotate(float paramFloat)
  {
    this.al = paramFloat;
  }
  
  public void setSCScale(float paramFloat)
  {
    this.ak = paramFloat;
  }
  
  public void setSDAlpha(float paramFloat)
  {
    this.az = paramFloat;
  }
  
  public void setSDScale(float paramFloat)
  {
    this.ax = paramFloat;
  }
  
  public void setTCAlpha(float paramFloat)
  {
    this.aj = paramFloat;
  }
  
  public void setTCScale(float paramFloat)
  {
    this.ah = paramFloat;
  }
  
  public void u() {}
  
  public void v()
  {
    this.jdField_f_of_type_Float = ObjectBaseData.Dip2PxCache.I;
    this.jdField_i_of_type_Float = ObjectBaseData.Dip2PxCache.jdField_h_of_type_Int;
    this.jdField_j_of_type_Float = 234.0F;
    this.jdField_k_of_type_Float = 36.0F;
    this.jdField_l_of_type_Float = 54.0F;
    this.jdField_m_of_type_Float = 216.0F;
    this.jdField_a_of_type_Int = Color.argb(255, 30, 255, 236);
    this.jdField_b_of_type_Int = Color.argb(255, 0, 191, 255);
    this.jdField_n_of_type_Float = ObjectBaseData.Dip2PxCache.jdField_i_of_type_Int;
    this.jdField_o_of_type_Float = ((this.jdField_j_of_type_Float + this.jdField_m_of_type_Float) / 2.0F);
    this.jdField_p_of_type_Float = ((this.jdField_k_of_type_Float + this.jdField_l_of_type_Float) / 2.0F);
    this.jdField_c_of_type_Int = Color.argb(255, 30, 255, 236);
    this.jdField_d_of_type_Int = Color.argb(255, 0, 191, 255);
    this.jdField_e_of_type_Int = Color.argb(255, 30, 255, 236);
    this.jdField_v_of_type_Float = 0.0F;
    this.jdField_u_of_type_Float = 0.0F;
    this.B = ObjectBaseData.Dip2PxCache.L;
    this.E = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.F = 160.0F;
    this.G = 290.0F;
    this.H = 340.0F;
    this.I = 110.0F;
    this.jdField_f_of_type_Int = -1;
    this.J = 102.0F;
    this.K = ObjectBaseData.Dip2PxCache.M;
    this.L = ObjectBaseData.Dip2PxCache.G;
    this.O = ObjectBaseData.Dip2PxCache.H;
    this.P = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.Q = 32.0F;
    this.R = 138.0F;
    this.S = 272.0F;
    this.T = 18.0F;
    this.U = 152.0F;
    this.V = 258.0F;
    this.jdField_g_of_type_Int = -1;
    this.W = 0.0F;
    this.X = ObjectBaseData.Dip2PxCache.G;
    this.Y = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.Z = 60.0F;
    this.aa = 100.0F;
    this.ab = 300.0F;
    this.ac = 340.0F;
    this.ad = 180.0F;
    this.ae = 220.0F;
    this.jdField_h_of_type_Int = -1;
    this.af = 0.0F;
    this.ag = ObjectBaseData.Dip2PxCache.G;
    this.ai = ObjectBaseData.Dip2PxCache.jdField_u_of_type_Int;
    this.jdField_i_of_type_Int = -1;
    this.aj = 0.0F;
    this.am = ObjectBaseData.Dip2PxCache.jdField_q_of_type_Int;
    this.an = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.ao = 183.0F;
    this.ap = 267.0F;
    this.aq = 93.0F;
    this.ar = 177.0F;
    this.as = 273.0F;
    this.at = 357.0F;
    this.au = 3.0F;
    this.av = 87.0F;
    this.jdField_j_of_type_Int = -1;
    this.aw = 0.0F;
    this.ay = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.jdField_k_of_type_Int = -1;
    this.az = 0.0F;
    this.aB = ObjectBaseData.Dip2PxCache.jdField_k_of_type_Int;
    this.jdField_l_of_type_Int = -1;
    this.aH = ObjectBaseData.Dip2PxCache.x;
    this.aD = ObjectBaseData.Dip2PxCache.C;
    this.aE = ObjectBaseData.Dip2PxCache.jdField_u_of_type_Int;
    this.aL = ObjectBaseData.Dip2PxCache.x;
    this.aM = ObjectBaseData.Dip2PxCache.x;
    this.aN = ObjectBaseData.Dip2PxCache.jdField_p_of_type_Int;
    this.aP = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aQ = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aR = ObjectBaseData.Dip2PxCache.jdField_j_of_type_Int;
    this.aH = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.aS = ObjectBaseData.Dip2PxCache.jdField_k_of_type_Int;
    this.aT = ObjectBaseData.Dip2PxCache.jdField_m_of_type_Int;
    this.aU = 0.0F;
    this.aX = ObjectBaseData.Dip2PxCache.jdField_m_of_type_Int;
    this.aY = ObjectBaseData.Dip2PxCache.jdField_b_of_type_Int;
    this.jdField_m_of_type_Int = Color.argb(102, 0, 0, 0);
    this.aZ = 270.0F;
    this.ba = 40.0F;
    this.bb = ObjectBaseData.Dip2PxCache.jdField_a_of_type_Int;
    this.bd = ObjectBaseData.Dip2PxCache.A;
    this.be = ObjectBaseData.Dip2PxCache.jdField_o_of_type_Int;
    this.bf = ObjectBaseData.Dip2PxCache.jdField_f_of_type_Int;
    this.bh = ObjectBaseData.Dip2PxCache.jdField_d_of_type_Int;
    this.bj = 0.0F;
    this.bk = 0.0F;
    this.bl = ObjectBaseData.Dip2PxCache.K;
    this.bm = ObjectBaseData.Dip2PxCache.C;
    this.jdField_o_of_type_Int = Color.argb(229, 255, 255, 255);
    this.jdField_p_of_type_Int = Color.argb(229, 255, 255, 255);
    this.jdField_q_of_type_Int = Color.argb(127, 255, 255, 255);
    this.bn = ObjectBaseData.Dip2PxCache.jdField_i_of_type_Int;
    this.bo = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.bw = ObjectBaseData.Dip2PxCache.z;
    this.bp = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.bq = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.br = ObjectBaseData.Dip2PxCache.jdField_g_of_type_Int;
    this.bs = ObjectBaseData.Dip2PxCache.jdField_g_of_type_Int;
    this.bx = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.bt = ObjectBaseData.Dip2PxCache.jdField_j_of_type_Int;
    this.bu = ObjectBaseData.Dip2PxCache.jdField_p_of_type_Int;
    this.bv = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.by = ObjectBaseData.Dip2PxCache.jdField_s_of_type_Int;
    this.bz = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.bA = ObjectBaseData.Dip2PxCache.jdField_p_of_type_Int;
    this.bB = ObjectBaseData.Dip2PxCache.jdField_n_of_type_Int;
    this.jdField_r_of_type_Int = Color.argb(255, 119, 119, 119);
    this.bC = ObjectBaseData.Dip2PxCache.jdField_h_of_type_Int;
    this.bD = ObjectBaseData.Dip2PxCache.jdField_r_of_type_Int;
    this.bE = ObjectBaseData.Dip2PxCache.jdField_e_of_type_Int;
    this.jdField_s_of_type_Int = Color.argb(76, 0, 104, 144);
    this.bF = ObjectBaseData.Dip2PxCache.jdField_l_of_type_Int;
    this.bG = ObjectBaseData.Dip2PxCache.jdField_i_of_type_Int;
    this.bH = 0.0F;
    this.bI = ObjectBaseData.Dip2PxCache.F;
    this.bJ = ObjectBaseData.Dip2PxCache.jdField_e_of_type_Int;
    this.t = -1;
    this.bK = ObjectBaseData.Dip2PxCache.jdField_h_of_type_Int;
    this.jdField_u_of_type_Int = -1;
    this.bL = 120.0F;
    this.bM = ObjectBaseData.Dip2PxCache.y;
    this.bN = ObjectBaseData.Dip2PxCache.jdField_c_of_type_Int;
    this.jdField_v_of_type_Int = -1;
    this.bO = 0.0F;
    this.bP = 0.0F;
    this.bQ = ObjectBaseData.Dip2PxCache.jdField_v_of_type_Int;
    this.bR = ObjectBaseData.Dip2PxCache.D;
    this.w = ObjectBaseData.Dip2PxCache.jdField_k_of_type_Int;
    this.aV = 0.0F;
    this.aW = 0.0F;
    this.bc = 0.0F;
    this.bi = 0.0F;
    this.jdField_n_of_type_Int = 0;
    this.jdField_v_of_type_Float = 0.0F;
    this.jdField_u_of_type_Float = 0.0F;
    this.J = 0.0F;
    this.aw = 0.0F;
    this.az = 0.0F;
    this.aj = 0.0F;
    this.W = 0.0F;
    this.af = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectBaseData
 * JD-Core Version:    0.7.0.1
 */