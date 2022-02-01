package com.tencent.mobileqq.ar;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class MainObjectScanningData
  extends ObjectBaseData
{
  private AnimatorSet dA;
  private ObjectAnimator dB;
  private ObjectAnimator dC;
  private ObjectAnimator dD;
  private ObjectAnimator dE;
  private ObjectAnimator dF;
  private ObjectAnimator dG;
  private AnimatorSet dH;
  private ObjectAnimator dI;
  private ObjectAnimator dJ;
  private ObjectAnimator dK;
  private AnimatorSet dL;
  private ObjectAnimator dM;
  private ObjectAnimator dN;
  private ObjectAnimator dO;
  private ObjectAnimator dP;
  private AnimatorSet dQ;
  private ObjectAnimator dR;
  private ObjectAnimator dS;
  private ObjectAnimator dT;
  private ObjectAnimator dU;
  private ObjectAnimator dV;
  private ObjectAnimator dW;
  private AnimatorSet dX;
  private ObjectAnimator dY;
  private ObjectAnimator dZ;
  private ObjectAnimator dc;
  private ObjectAnimator dd;
  private ObjectAnimator de;
  private ObjectAnimator df;
  private ObjectAnimator dg;
  private ObjectAnimator dh;
  private AnimatorSet di;
  private ObjectAnimator dj;
  private ObjectAnimator dk;
  private ObjectAnimator dl;
  private AnimatorSet dm;
  private ObjectAnimator dn;
  private ObjectAnimator jdField_do;
  private ObjectAnimator dp;
  private ObjectAnimator dq;
  private AnimatorSet dr;
  private ObjectAnimator ds;
  private ObjectAnimator dt;
  private AnimatorSet du;
  private ObjectAnimator dv;
  private AnimatorSet dw;
  private ObjectAnimator dx;
  private ObjectAnimator dy;
  private ObjectAnimator dz;
  private ObjectAnimator eA;
  private AnimatorSet eB;
  private ObjectAnimator eC;
  private ObjectAnimator eD;
  private ObjectAnimator eE;
  private AnimatorSet eF;
  private ObjectAnimator eG;
  private AnimatorSet eH;
  private ObjectAnimator eI;
  private AnimatorSet eJ;
  private ObjectAnimator eK;
  private AnimatorSet eL;
  private ObjectAnimator eM;
  private AnimatorSet eN;
  private ObjectAnimator eO;
  private AnimatorSet eP;
  private ObjectAnimator eQ;
  private AnimatorSet eR;
  private ObjectAnimator eS;
  private AnimatorSet eT;
  private ObjectAnimator ea;
  private AnimatorSet eb;
  private ObjectAnimator ec;
  private ObjectAnimator ed;
  private ObjectAnimator ee;
  private ObjectAnimator ef;
  private AnimatorSet eg;
  private ObjectAnimator eh;
  private ObjectAnimator ei;
  private ObjectAnimator ej;
  private AnimatorSet ek;
  private ObjectAnimator el;
  private ObjectAnimator em;
  private AnimatorSet en;
  private ObjectAnimator eo;
  private ObjectAnimator ep;
  private ObjectAnimator eq;
  private AnimatorSet er;
  private ObjectAnimator es;
  private ObjectAnimator et;
  private AnimatorSet eu;
  private ObjectAnimator ev;
  private AnimatorSet ew;
  private ObjectAnimator ex;
  private AnimatorSet ey;
  private ObjectAnimator ez;
  
  public MainObjectScanningData(Context paramContext)
  {
    super(paramContext);
    w();
    a();
  }
  
  private void w()
  {
    this.c = true;
    this.d = false;
  }
  
  public void a()
  {
    c();
    d();
    e();
    f();
    g();
    h();
    i();
    j();
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    this.T = true;
    l();
    m();
    n();
    o();
    p();
    q();
    r();
    s();
    t();
  }
  
  public void b()
  {
    super.b();
    if ((!this.c) && (!this.f))
    {
      this.o = ViewUtils.dip2px(1.5F);
      return;
    }
    this.o = ViewUtils.dip2px(5.0F);
  }
  
  @TargetApi(11)
  public void c()
  {
    if (this.dc == null)
    {
      this.dc = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 0.0F, 1.04F });
      this.dc.setInterpolator(new LinearInterpolator());
      this.dc.setDuration(200L);
    }
    if (this.dd == null)
    {
      this.dd = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.04F, 1.0F });
      this.dd.setInterpolator(new LinearInterpolator());
      this.dd.setDuration(66L);
    }
    if (this.de == null)
    {
      this.de = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 1.02F });
      this.de.setInterpolator(new LinearInterpolator());
      this.de.setDuration(66L);
    }
    if (this.df == null)
    {
      this.df = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.02F, 1.0F });
      this.df.setInterpolator(new LinearInterpolator());
      this.df.setDuration(66L);
    }
    if (this.dg == null)
    {
      this.dg = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 1.0F });
      this.dg.setInterpolator(new LinearInterpolator());
      this.dg.setDuration(1268L);
    }
    if (this.dh == null)
    {
      this.dh = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 0.9F });
      this.dh.setInterpolator(new LinearInterpolator());
      this.dh.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.di == null)
    {
      this.di = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dc);
      localArrayList.add(this.dd);
      localArrayList.add(this.de);
      localArrayList.add(this.df);
      localArrayList.add(this.dg);
      localArrayList.add(this.dh);
      this.di.playSequentially(localArrayList);
    }
    if (this.dj == null)
    {
      this.dj = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 0.0F, 1.0F });
      this.dj.setInterpolator(new LinearInterpolator());
      this.dj.setDuration(200L);
    }
    if (this.dk == null)
    {
      this.dk = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 1.0F, 1.0F });
      this.dk.setInterpolator(new LinearInterpolator());
      this.dk.setDuration(2600L);
    }
    if (this.dl == null)
    {
      this.dl = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 1.0F, 0.9F });
      this.dl.setInterpolator(new LinearInterpolator());
      this.dl.setDuration(866L);
    }
    if (this.dm == null)
    {
      this.dm = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dj);
      localArrayList.add(this.dk);
      localArrayList.add(this.dl);
      this.dm.playSequentially(localArrayList);
    }
    if (this.dn == null)
    {
      this.dn = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, 360.0F });
      this.dn.setInterpolator(new LinearInterpolator());
      this.dn.setDuration(866L);
    }
    if (this.jdField_do == null)
    {
      this.jdField_do = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 360.0F, 720.0F });
      this.jdField_do.setInterpolator(new LinearInterpolator());
      this.jdField_do.setDuration(334L);
    }
    if (this.dp == null)
    {
      this.dp = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 720.0F, 720.0F });
      this.dp.setInterpolator(new LinearInterpolator());
      this.dp.setDuration(800L);
    }
    if (this.dq == null)
    {
      this.dq = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 720.0F, 360.0F });
      this.dq.setInterpolator(new LinearInterpolator());
      this.dq.setDuration(12000L);
      this.dq.setRepeatCount(-1);
    }
    if (this.dr == null)
    {
      this.dr = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dn);
      localArrayList.add(this.jdField_do);
      localArrayList.add(this.dp);
      localArrayList.add(this.dq);
      this.dr.playSequentially(localArrayList);
      this.dr.setStartDelay(800L);
    }
    if (this.ds == null)
    {
      this.ds = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 0.0F, 1.0F });
      this.ds.setInterpolator(new LinearInterpolator());
      this.ds.setDuration(134L);
    }
    if (this.dt == null)
    {
      this.dt = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 1.0F, 0.0F });
      this.dt.setInterpolator(new LinearInterpolator());
      this.dt.setDuration(400L);
    }
    if (this.du == null)
    {
      this.du = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.ds);
      localArrayList.add(this.dt);
      this.du.playSequentially(localArrayList);
      this.du.setStartDelay(1866L);
    }
    if (this.dv == null)
    {
      this.dv = ObjectAnimator.ofObject(this, "bCColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(Color.argb(255, 30, 255, 236)), Integer.valueOf(-1), Integer.valueOf(-1) });
      this.dv.setInterpolator(new LinearInterpolator());
      this.dv.setDuration(334L);
    }
    if (this.dw == null)
    {
      this.dw = new AnimatorSet();
      this.dw.play(this.dv);
      this.dw.setStartDelay(1666L);
    }
    if (this.dx == null)
    {
      this.dx = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 0.0F, 1.0F });
      this.dx.setInterpolator(new LinearInterpolator());
      this.dx.setDuration(200L);
    }
    if (this.dy == null)
    {
      this.dy = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 1.0F, 1.0F });
      this.dy.setInterpolator(new LinearInterpolator());
      this.dy.setDuration(2600L);
    }
    if (this.dz == null)
    {
      this.dz = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 1.0F, 0.9F });
      this.dz.setInterpolator(new LinearInterpolator());
      this.dz.setDuration(866L);
    }
    if (this.dA == null)
    {
      this.dA = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dx);
      localArrayList.add(this.dy);
      localArrayList.add(this.dz);
      this.dA.playSequentially(localArrayList);
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (this.dB == null)
    {
      this.dB = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 0.0F, 1.04F });
      this.dB.setInterpolator(new LinearInterpolator());
      this.dB.setDuration(200L);
    }
    if (this.dC == null)
    {
      this.dC = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.04F, 1.0F });
      this.dC.setInterpolator(new LinearInterpolator());
      this.dC.setDuration(66L);
    }
    if (this.dD == null)
    {
      this.dD = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 1.02F });
      this.dD.setInterpolator(new LinearInterpolator());
      this.dD.setDuration(66L);
    }
    if (this.dE == null)
    {
      this.dE = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.02F, 1.0F });
      this.dE.setInterpolator(new LinearInterpolator());
      this.dE.setDuration(66L);
    }
    if (this.dF == null)
    {
      this.dF = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 1.0F });
      this.dF.setInterpolator(new LinearInterpolator());
      this.dF.setDuration(1234L);
    }
    if (this.dG == null)
    {
      this.dG = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 0.9F });
      this.dG.setInterpolator(new LinearInterpolator());
      this.dG.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.dH == null)
    {
      this.dH = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dB);
      localArrayList.add(this.dC);
      localArrayList.add(this.dD);
      localArrayList.add(this.dE);
      localArrayList.add(this.dF);
      localArrayList.add(this.dG);
      this.dH.playSequentially(localArrayList);
      this.dH.setStartDelay(34L);
    }
    if (this.dI == null)
    {
      this.dI = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 0.0F, 1.0F });
      this.dI.setInterpolator(new LinearInterpolator());
      this.dI.setDuration(200L);
    }
    if (this.dJ == null)
    {
      this.dJ = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 1.0F, 1.0F });
      this.dJ.setInterpolator(new LinearInterpolator());
      this.dJ.setDuration(2566L);
    }
    if (this.dK == null)
    {
      this.dK = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 1.0F, 0.0F });
      this.dK.setInterpolator(new LinearInterpolator());
      this.dK.setDuration(866L);
    }
    if (this.dL == null)
    {
      this.dL = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dI);
      localArrayList.add(this.dJ);
      localArrayList.add(this.dK);
      this.dL.playSequentially(localArrayList);
      this.dL.setStartDelay(34L);
    }
    if (this.dM == null)
    {
      this.dM = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { 0.0F, -180.0F });
      this.dM.setInterpolator(new LinearInterpolator());
      this.dM.setDuration(866L);
    }
    if (this.dN == null)
    {
      this.dN = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -180.0F, -540.0F });
      this.dN.setInterpolator(new LinearInterpolator());
      this.dN.setDuration(334L);
    }
    if (this.dO == null)
    {
      this.dO = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -540.0F, -540.0F });
      this.dO.setInterpolator(new LinearInterpolator());
      this.dO.setDuration(800L);
    }
    if (this.dP == null)
    {
      this.dP = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -540.0F, -180.0F });
      this.dP.setInterpolator(new LinearInterpolator());
      this.dP.setDuration(6000L);
      this.dP.setRepeatCount(-1);
    }
    if (this.dQ == null)
    {
      this.dQ = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dM);
      localArrayList.add(this.dN);
      localArrayList.add(this.dO);
      localArrayList.add(this.dP);
      this.dQ.playSequentially(localArrayList);
      this.dQ.setStartDelay(800L);
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    if (this.dR == null)
    {
      this.dR = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 0.0F, 1.04F });
      this.dR.setInterpolator(new LinearInterpolator());
      this.dR.setDuration(200L);
    }
    if (this.dS == null)
    {
      this.dS = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.04F, 1.0F });
      this.dS.setInterpolator(new LinearInterpolator());
      this.dS.setDuration(66L);
    }
    if (this.dT == null)
    {
      this.dT = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 1.02F });
      this.dT.setInterpolator(new LinearInterpolator());
      this.dT.setDuration(66L);
    }
    if (this.dU == null)
    {
      this.dU = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.02F, 1.0F });
      this.dU.setInterpolator(new LinearInterpolator());
      this.dU.setDuration(66L);
    }
    if (this.dV == null)
    {
      this.dV = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 1.0F });
      this.dV.setInterpolator(new LinearInterpolator());
      this.dV.setDuration(1202L);
    }
    if (this.dW == null)
    {
      this.dW = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 0.9F });
      this.dW.setInterpolator(new LinearInterpolator());
      this.dW.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.dX == null)
    {
      this.dX = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dR);
      localArrayList.add(this.dS);
      localArrayList.add(this.dT);
      localArrayList.add(this.dU);
      localArrayList.add(this.dV);
      localArrayList.add(this.dW);
      this.dX.playSequentially(localArrayList);
      this.dX.setStartDelay(66L);
    }
    if (this.dY == null)
    {
      this.dY = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 0.0F, 1.0F });
      this.dY.setInterpolator(new LinearInterpolator());
      this.dY.setDuration(200L);
    }
    if (this.dZ == null)
    {
      this.dZ = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 1.0F, 1.0F });
      this.dZ.setInterpolator(new LinearInterpolator());
      this.dZ.setDuration(2534L);
    }
    if (this.ea == null)
    {
      this.ea = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 1.0F, 0.8F });
      this.ea.setInterpolator(new LinearInterpolator());
      this.ea.setDuration(866L);
    }
    if (this.eb == null)
    {
      this.eb = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.dY);
      localArrayList.add(this.dZ);
      localArrayList.add(this.ea);
      this.eb.playSequentially(localArrayList);
      this.eb.setStartDelay(66L);
    }
    if (this.ec == null)
    {
      this.ec = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, -90.0F });
      this.ec.setInterpolator(new LinearInterpolator());
      this.ec.setDuration(866L);
    }
    if (this.ed == null)
    {
      this.ed = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -90.0F, -450.0F });
      this.ed.setInterpolator(new LinearInterpolator());
      this.ed.setDuration(334L);
    }
    if (this.ee == null)
    {
      this.ee = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -450.0F, -450.0F });
      this.ee.setInterpolator(new LinearInterpolator());
      this.ee.setDuration(800L);
    }
    if (this.ef == null)
    {
      this.ef = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -450.0F, -90.0F });
      this.ef.setInterpolator(new LinearInterpolator());
      this.ef.setDuration(6000L);
      this.ef.setRepeatCount(-1);
    }
    if (this.eg == null)
    {
      this.eg = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.ec);
      localArrayList.add(this.ed);
      localArrayList.add(this.ee);
      localArrayList.add(this.ef);
      this.eg.playSequentially(localArrayList);
      this.eg.setStartDelay(800L);
    }
    if (this.eh == null)
    {
      this.eh = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 0.0F, 1.0F });
      this.eh.setInterpolator(new LinearInterpolator());
      this.eh.setDuration(200L);
    }
    if (this.ei == null)
    {
      this.ei = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 1.0F, 1.0F });
      this.ei.setInterpolator(new LinearInterpolator());
      this.ei.setDuration(2534L);
    }
    if (this.ej == null)
    {
      this.ej = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 1.0F, 0.8F });
      this.ej.setInterpolator(new LinearInterpolator());
      this.ej.setDuration(866L);
    }
    if (this.ek == null)
    {
      this.ek = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.eh);
      localArrayList.add(this.ei);
      localArrayList.add(this.ej);
      this.ek.playSequentially(localArrayList);
      this.ek.setStartDelay(66L);
    }
  }
  
  @TargetApi(11)
  public void f()
  {
    if (this.el == null)
    {
      this.el = ObjectAnimator.ofFloat(this, "tCScale", new float[] { 1.0F, 1.0F });
      this.el.setInterpolator(new LinearInterpolator());
      this.el.setDuration(1666L);
    }
    if (this.em == null)
    {
      this.em = ObjectAnimator.ofFloat(this, "tCScale", new float[] { 1.0F, 0.9F });
      this.em.setInterpolator(new LinearInterpolator());
      this.em.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.en == null)
    {
      this.en = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.el);
      localArrayList.add(this.em);
      this.en.playSequentially(localArrayList);
    }
    if (this.eo == null)
    {
      this.eo = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 0.0F, 1.0F });
      this.eo.setInterpolator(new LinearInterpolator());
      this.eo.setDuration(200L);
    }
    if (this.ep == null)
    {
      this.ep = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 1.0F, 1.0F });
      this.ep.setInterpolator(new LinearInterpolator());
      this.ep.setDuration(1566L);
    }
    if (this.eq == null)
    {
      this.eq = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 1.0F, 0.0F });
      this.eq.setInterpolator(new LinearInterpolator());
      this.eq.setDuration(866L);
    }
    if (this.er == null)
    {
      this.er = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.eo);
      localArrayList.add(this.ep);
      localArrayList.add(this.eq);
      this.er.playSequentially(localArrayList);
      this.er.setStartDelay(34L);
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.es == null)
    {
      this.es = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.0F, 1.0F });
      this.es.setInterpolator(new LinearInterpolator());
      this.es.setDuration(1666L);
    }
    if (this.et == null)
    {
      this.et = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.0F, 0.9F });
      this.et.setInterpolator(new LinearInterpolator());
      this.et.setDuration(334L);
    }
    if (this.eu == null)
    {
      this.eu = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.es);
      localArrayList.add(this.et);
      this.eu.playSequentially(localArrayList);
    }
    if (this.ev == null)
    {
      this.ev = ObjectAnimator.ofFloat(this, "sCRotate", new float[] { 0.0F, 45.0F });
      this.ev.setInterpolator(new LinearInterpolator());
      this.ev.setDuration(8000L);
      this.ev.setRepeatCount(-1);
    }
    if (this.ew == null)
    {
      this.ew = new AnimatorSet();
      this.ew.play(this.ev);
    }
    if (this.ex == null)
    {
      this.ex = ObjectAnimator.ofFloat(this, "sCAlpha", new float[] { 0.0F, 1.0F });
      this.ex.setInterpolator(new LinearInterpolator());
      this.ex.setDuration(200L);
    }
    if (this.ey == null)
    {
      this.ey = new AnimatorSet();
      this.ey.play(this.ex);
      this.ey.setStartDelay(66L);
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    if (this.ez == null)
    {
      this.ez = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.0F, 1.0F });
      this.ez.setInterpolator(new LinearInterpolator());
      this.ez.setDuration(1666L);
    }
    if (this.eA == null)
    {
      this.eA = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.0F, 0.9F });
      this.eA.setInterpolator(new LinearInterpolator());
      this.eA.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.eB == null)
    {
      this.eB = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.ez);
      localArrayList.add(this.eA);
      this.eB.playSequentially(localArrayList);
    }
    if (this.eC == null)
    {
      this.eC = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 0.0F, 1.0F });
      this.eC.setInterpolator(new LinearInterpolator());
      this.eC.setDuration(200L);
    }
    if (this.eD == null)
    {
      this.eD = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 1.0F, 1.0F });
      this.eD.setInterpolator(new LinearInterpolator());
      this.eD.setDuration(1566L);
    }
    if (this.eE == null)
    {
      this.eE = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 1.0F, 0.6F });
      this.eE.setInterpolator(new LinearInterpolator());
      this.eE.setDuration(866L);
    }
    if (this.eF == null)
    {
      this.eF = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.eC);
      localArrayList.add(this.eD);
      localArrayList.add(this.eE);
      this.eF.playSequentially(localArrayList);
      this.eF.setStartDelay(34L);
    }
  }
  
  @TargetApi(11)
  public void i()
  {
    if (this.eG == null)
    {
      this.eG = ObjectAnimator.ofFloat(this, "fNCHAlpha", new float[] { 0.0F, 1.0F });
      this.eG.setInterpolator(new LinearInterpolator());
      this.eG.setDuration(320L);
    }
    if (this.eH == null)
    {
      this.eH = new AnimatorSet();
      this.eH.play(this.eG);
      this.eH.setStartDelay(2000L);
    }
    if (this.eI == null)
    {
      this.eI = ObjectAnimator.ofFloat(this, "fLAlpha", new float[] { 0.0F, 1.0F });
      this.eI.setInterpolator(new LinearInterpolator());
      this.eI.setDuration(200L);
    }
    if (this.eJ == null)
    {
      this.eJ = new AnimatorSet();
      this.eJ.play(this.eI);
      this.eJ.setStartDelay(1900L);
    }
  }
  
  @TargetApi(11)
  public void j()
  {
    if (this.eK == null)
    {
      this.eK = ObjectAnimator.ofFloat(this, "fCPositionY", new float[] { -ViewUtils.dip2px(25.0F), 0.0F });
      this.eK.setInterpolator(new LinearInterpolator());
      this.eK.setDuration(280L);
    }
    if (this.eL == null)
    {
      this.eL = new AnimatorSet();
      this.eL.play(this.eK);
      this.eL.setStartDelay(2200L);
    }
    if (this.eM == null)
    {
      this.eM = ObjectAnimator.ofFloat(this, "fCAlpha", new float[] { 0.0F, 1.0F });
      this.eM.setInterpolator(new LinearInterpolator());
      this.eM.setDuration(280L);
    }
    if (this.eN == null)
    {
      this.eN = new AnimatorSet();
      this.eN.play(this.eM);
      this.eN.setStartDelay(2200L);
    }
  }
  
  @TargetApi(11)
  public void k()
  {
    if (this.eO == null)
    {
      this.eO = ObjectAnimator.ofFloat(this, "fPAlpha", new float[] { 0.0F, 1.0F });
      this.eO.setInterpolator(new LinearInterpolator());
      this.eO.setDuration(280L);
    }
    if (this.eP == null)
    {
      this.eP = new AnimatorSet();
      this.eP.play(this.eO);
      this.eP.setStartDelay(2200L);
    }
    if (this.eQ == null)
    {
      this.eQ = ObjectAnimator.ofFloat(this, "fPOutCircleAlpha", new float[] { 1.0F, 0.0F, 0.0F });
      this.eQ.setInterpolator(new LinearInterpolator());
      this.eQ.setDuration(1500L);
      this.eQ.setRepeatCount(-1);
    }
    if (this.eR == null)
    {
      this.eR = new AnimatorSet();
      this.eR.play(this.eQ);
      this.eR.setStartDelay(2200L);
    }
    if (this.eS == null)
    {
      this.eS = ObjectAnimator.ofFloat(this, "fPOutCircleScale", new float[] { 1.0F, 1.3F, 1.3F });
      this.eS.setInterpolator(new LinearInterpolator());
      this.eS.setRepeatCount(-1);
      this.eS.setDuration(1500L);
    }
    if (this.eT == null)
    {
      this.eT = new AnimatorSet();
      this.eT.play(this.eS);
      this.eT.setStartDelay(2200L);
    }
  }
  
  @TargetApi(11)
  public void l()
  {
    AnimatorSet localAnimatorSet = this.di;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dm;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dr;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.du;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dw;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dA;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void m()
  {
    AnimatorSet localAnimatorSet = this.dH;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dL;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.dQ;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void n()
  {
    AnimatorSet localAnimatorSet = this.dX;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eb;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eg;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.ek;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void o()
  {
    AnimatorSet localAnimatorSet = this.en;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.er;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void p()
  {
    AnimatorSet localAnimatorSet = this.eu;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.ew;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.ey;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void q()
  {
    AnimatorSet localAnimatorSet = this.eB;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eF;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void r()
  {
    AnimatorSet localAnimatorSet = this.eH;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eJ;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void s()
  {
    AnimatorSet localAnimatorSet = this.eL;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eN;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void t()
  {
    AnimatorSet localAnimatorSet = this.eP;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eR;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.eT;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.MainObjectScanningData
 * JD-Core Version:    0.7.0.1
 */