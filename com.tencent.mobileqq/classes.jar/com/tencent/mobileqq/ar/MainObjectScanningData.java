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
  private AnimatorSet jdField_A_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_A_of_type_AndroidAnimationObjectAnimator;
  private ObjectAnimator B;
  private ObjectAnimator C;
  private ObjectAnimator D;
  private ObjectAnimator E;
  private ObjectAnimator F;
  private ObjectAnimator G;
  private ObjectAnimator H;
  private ObjectAnimator I;
  private ObjectAnimator J;
  private ObjectAnimator K;
  private ObjectAnimator L;
  private ObjectAnimator M;
  private ObjectAnimator N;
  private ObjectAnimator O;
  private ObjectAnimator P;
  private ObjectAnimator Q;
  private ObjectAnimator R;
  private ObjectAnimator S;
  private ObjectAnimator T;
  private ObjectAnimator U;
  private ObjectAnimator V;
  private ObjectAnimator W;
  private ObjectAnimator X;
  private ObjectAnimator Y;
  private ObjectAnimator Z;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private ObjectAnimator aa;
  private ObjectAnimator ab;
  private ObjectAnimator ac;
  private ObjectAnimator ad;
  private ObjectAnimator ae;
  private ObjectAnimator af;
  private ObjectAnimator ag;
  private ObjectAnimator ah;
  private ObjectAnimator ai;
  private ObjectAnimator aj;
  private ObjectAnimator ak;
  private ObjectAnimator al;
  private ObjectAnimator am;
  private ObjectAnimator an;
  private ObjectAnimator ao;
  private ObjectAnimator ap;
  private ObjectAnimator aq;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_c_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_c_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_d_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_d_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_e_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_e_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_f_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_f_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_g_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_g_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_h_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_h_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_i_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_i_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_j_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_j_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_k_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_k_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_l_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_l_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_m_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_m_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_n_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_n_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_o_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_o_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_p_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_p_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_q_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_q_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_r_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_r_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_s_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_s_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_t_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_t_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_u_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_u_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_v_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_v_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_w_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_w_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_x_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_x_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_y_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_y_of_type_AndroidAnimationObjectAnimator;
  private AnimatorSet jdField_z_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_z_of_type_AndroidAnimationObjectAnimator;
  
  public MainObjectScanningData(Context paramContext)
  {
    super(paramContext);
    w();
    a();
  }
  
  private void w()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
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
    this.jdField_h_of_type_Boolean = true;
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
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_i_of_type_Float = ViewUtils.a(1.5F);
      return;
    }
    this.jdField_i_of_type_Float = ViewUtils.a(5.0F);
  }
  
  @TargetApi(11)
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 0.0F, 1.04F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.04F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_c_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 1.02F });
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_d_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_d_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.02F, 1.0F });
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_e_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_e_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 1.0F });
      this.jdField_e_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_e_of_type_AndroidAnimationObjectAnimator.setDuration(1268L);
    }
    if (this.jdField_f_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_f_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCScale", new float[] { 1.0F, 0.9F });
      this.jdField_f_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_f_of_type_AndroidAnimationObjectAnimator.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_b_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_c_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_d_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_e_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_f_of_type_AndroidAnimationObjectAnimator);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
    if (this.jdField_g_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_g_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_g_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_g_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_h_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_h_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 1.0F, 1.0F });
      this.jdField_h_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_h_of_type_AndroidAnimationObjectAnimator.setDuration(2600L);
    }
    if (this.jdField_i_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_i_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCAlpha", new float[] { 1.0F, 0.9F });
      this.jdField_i_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_i_of_type_AndroidAnimationObjectAnimator.setDuration(866L);
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_g_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_h_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_i_of_type_AndroidAnimationObjectAnimator);
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
    if (this.jdField_j_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_j_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 0.0F, 360.0F });
      this.jdField_j_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_j_of_type_AndroidAnimationObjectAnimator.setDuration(866L);
    }
    if (this.jdField_k_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_k_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 360.0F, 720.0F });
      this.jdField_k_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_k_of_type_AndroidAnimationObjectAnimator.setDuration(334L);
    }
    if (this.jdField_l_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_l_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 720.0F, 720.0F });
      this.jdField_l_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_l_of_type_AndroidAnimationObjectAnimator.setDuration(800L);
    }
    if (this.jdField_m_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_m_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bCRotate", new float[] { 720.0F, 360.0F });
      this.jdField_m_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_m_of_type_AndroidAnimationObjectAnimator.setDuration(12000L);
      this.jdField_m_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    }
    if (this.jdField_c_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_j_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_k_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_l_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_m_of_type_AndroidAnimationObjectAnimator);
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.setStartDelay(800L);
    }
    if (this.jdField_n_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_n_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 0.0F, 1.0F });
      this.jdField_n_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_n_of_type_AndroidAnimationObjectAnimator.setDuration(134L);
    }
    if (this.jdField_o_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_o_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "maskScale", new float[] { 1.0F, 0.0F });
      this.jdField_o_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_o_of_type_AndroidAnimationObjectAnimator.setDuration(400L);
    }
    if (this.jdField_d_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_n_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_o_of_type_AndroidAnimationObjectAnimator);
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.setStartDelay(1866L);
    }
    if (this.jdField_p_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_p_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofObject(this, "bCColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(Color.argb(255, 30, 255, 236)), Integer.valueOf(-1), Integer.valueOf(-1) });
      this.jdField_p_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_p_of_type_AndroidAnimationObjectAnimator.setDuration(334L);
    }
    if (this.jdField_e_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_e_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_e_of_type_AndroidAnimationAnimatorSet.play(this.jdField_p_of_type_AndroidAnimationObjectAnimator);
      this.jdField_e_of_type_AndroidAnimationAnimatorSet.setStartDelay(1666L);
    }
    if (this.jdField_q_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_q_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_q_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_q_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_r_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_r_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 1.0F, 1.0F });
      this.jdField_r_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_r_of_type_AndroidAnimationObjectAnimator.setDuration(2600L);
    }
    if (this.jdField_s_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_s_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "bTAlpha", new float[] { 1.0F, 0.9F });
      this.jdField_s_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_s_of_type_AndroidAnimationObjectAnimator.setDuration(866L);
    }
    if (this.jdField_f_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_f_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_q_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_r_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_s_of_type_AndroidAnimationObjectAnimator);
      this.jdField_f_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (this.jdField_t_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_t_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 0.0F, 1.04F });
      this.jdField_t_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_t_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_u_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_u_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.04F, 1.0F });
      this.jdField_u_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_u_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_v_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_v_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 1.02F });
      this.jdField_v_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_v_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_w_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_w_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.02F, 1.0F });
      this.jdField_w_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_w_of_type_AndroidAnimationObjectAnimator.setDuration(66L);
    }
    if (this.jdField_x_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_x_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 1.0F });
      this.jdField_x_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_x_of_type_AndroidAnimationObjectAnimator.setDuration(1234L);
    }
    if (this.jdField_y_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_y_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCScale", new float[] { 1.0F, 0.9F });
      this.jdField_y_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_y_of_type_AndroidAnimationObjectAnimator.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.jdField_g_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_g_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_t_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_u_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_v_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_w_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_x_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_y_of_type_AndroidAnimationObjectAnimator);
      this.jdField_g_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_g_of_type_AndroidAnimationAnimatorSet.setStartDelay(34L);
    }
    if (this.jdField_z_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_z_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 0.0F, 1.0F });
      this.jdField_z_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_z_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    }
    if (this.jdField_A_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_A_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 1.0F, 1.0F });
      this.jdField_A_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_A_of_type_AndroidAnimationObjectAnimator.setDuration(2566L);
    }
    if (this.B == null)
    {
      this.B = ObjectAnimator.ofFloat(this, "oCAlpha", new float[] { 1.0F, 0.0F });
      this.B.setInterpolator(new LinearInterpolator());
      this.B.setDuration(866L);
    }
    if (this.jdField_h_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_h_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_z_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.jdField_A_of_type_AndroidAnimationObjectAnimator);
      localArrayList.add(this.B);
      this.jdField_h_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_h_of_type_AndroidAnimationAnimatorSet.setStartDelay(34L);
    }
    if (this.C == null)
    {
      this.C = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { 0.0F, -180.0F });
      this.C.setInterpolator(new LinearInterpolator());
      this.C.setDuration(866L);
    }
    if (this.D == null)
    {
      this.D = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -180.0F, -540.0F });
      this.D.setInterpolator(new LinearInterpolator());
      this.D.setDuration(334L);
    }
    if (this.E == null)
    {
      this.E = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -540.0F, -540.0F });
      this.E.setInterpolator(new LinearInterpolator());
      this.E.setDuration(800L);
    }
    if (this.F == null)
    {
      this.F = ObjectAnimator.ofFloat(this, "oCRotate", new float[] { -540.0F, -180.0F });
      this.F.setInterpolator(new LinearInterpolator());
      this.F.setDuration(6000L);
      this.F.setRepeatCount(-1);
    }
    if (this.jdField_i_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_i_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.C);
      localArrayList.add(this.D);
      localArrayList.add(this.E);
      localArrayList.add(this.F);
      this.jdField_i_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_i_of_type_AndroidAnimationAnimatorSet.setStartDelay(800L);
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    if (this.G == null)
    {
      this.G = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 0.0F, 1.04F });
      this.G.setInterpolator(new LinearInterpolator());
      this.G.setDuration(200L);
    }
    if (this.H == null)
    {
      this.H = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.04F, 1.0F });
      this.H.setInterpolator(new LinearInterpolator());
      this.H.setDuration(66L);
    }
    if (this.I == null)
    {
      this.I = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 1.02F });
      this.I.setInterpolator(new LinearInterpolator());
      this.I.setDuration(66L);
    }
    if (this.J == null)
    {
      this.J = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.02F, 1.0F });
      this.J.setInterpolator(new LinearInterpolator());
      this.J.setDuration(66L);
    }
    if (this.K == null)
    {
      this.K = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 1.0F });
      this.K.setInterpolator(new LinearInterpolator());
      this.K.setDuration(1202L);
    }
    if (this.L == null)
    {
      this.L = ObjectAnimator.ofFloat(this, "iBCScale", new float[] { 1.0F, 0.9F });
      this.L.setInterpolator(new LinearInterpolator());
      this.L.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.jdField_j_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_j_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.G);
      localArrayList.add(this.H);
      localArrayList.add(this.I);
      localArrayList.add(this.J);
      localArrayList.add(this.K);
      localArrayList.add(this.L);
      this.jdField_j_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_j_of_type_AndroidAnimationAnimatorSet.setStartDelay(66L);
    }
    if (this.M == null)
    {
      this.M = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 0.0F, 1.0F });
      this.M.setInterpolator(new LinearInterpolator());
      this.M.setDuration(200L);
    }
    if (this.N == null)
    {
      this.N = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 1.0F, 1.0F });
      this.N.setInterpolator(new LinearInterpolator());
      this.N.setDuration(2534L);
    }
    if (this.O == null)
    {
      this.O = ObjectAnimator.ofFloat(this, "iBCAlpha", new float[] { 1.0F, 0.8F });
      this.O.setInterpolator(new LinearInterpolator());
      this.O.setDuration(866L);
    }
    if (this.jdField_k_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_k_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.M);
      localArrayList.add(this.N);
      localArrayList.add(this.O);
      this.jdField_k_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_k_of_type_AndroidAnimationAnimatorSet.setStartDelay(66L);
    }
    if (this.P == null)
    {
      this.P = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { 0.0F, -90.0F });
      this.P.setInterpolator(new LinearInterpolator());
      this.P.setDuration(866L);
    }
    if (this.Q == null)
    {
      this.Q = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -90.0F, -450.0F });
      this.Q.setInterpolator(new LinearInterpolator());
      this.Q.setDuration(334L);
    }
    if (this.R == null)
    {
      this.R = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -450.0F, -450.0F });
      this.R.setInterpolator(new LinearInterpolator());
      this.R.setDuration(800L);
    }
    if (this.S == null)
    {
      this.S = ObjectAnimator.ofFloat(this, "iBCRotate", new float[] { -450.0F, -90.0F });
      this.S.setInterpolator(new LinearInterpolator());
      this.S.setDuration(6000L);
      this.S.setRepeatCount(-1);
    }
    if (this.jdField_l_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_l_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.P);
      localArrayList.add(this.Q);
      localArrayList.add(this.R);
      localArrayList.add(this.S);
      this.jdField_l_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_l_of_type_AndroidAnimationAnimatorSet.setStartDelay(800L);
    }
    if (this.T == null)
    {
      this.T = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 0.0F, 1.0F });
      this.T.setInterpolator(new LinearInterpolator());
      this.T.setDuration(200L);
    }
    if (this.U == null)
    {
      this.U = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 1.0F, 1.0F });
      this.U.setInterpolator(new LinearInterpolator());
      this.U.setDuration(2534L);
    }
    if (this.V == null)
    {
      this.V = ObjectAnimator.ofFloat(this, "iSCAlpha", new float[] { 1.0F, 0.8F });
      this.V.setInterpolator(new LinearInterpolator());
      this.V.setDuration(866L);
    }
    if (this.jdField_m_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_m_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.T);
      localArrayList.add(this.U);
      localArrayList.add(this.V);
      this.jdField_m_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_m_of_type_AndroidAnimationAnimatorSet.setStartDelay(66L);
    }
  }
  
  @TargetApi(11)
  public void f()
  {
    if (this.W == null)
    {
      this.W = ObjectAnimator.ofFloat(this, "tCScale", new float[] { 1.0F, 1.0F });
      this.W.setInterpolator(new LinearInterpolator());
      this.W.setDuration(1666L);
    }
    if (this.X == null)
    {
      this.X = ObjectAnimator.ofFloat(this, "tCScale", new float[] { 1.0F, 0.9F });
      this.X.setInterpolator(new LinearInterpolator());
      this.X.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.jdField_n_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_n_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.W);
      localArrayList.add(this.X);
      this.jdField_n_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
    if (this.Y == null)
    {
      this.Y = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 0.0F, 1.0F });
      this.Y.setInterpolator(new LinearInterpolator());
      this.Y.setDuration(200L);
    }
    if (this.Z == null)
    {
      this.Z = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 1.0F, 1.0F });
      this.Z.setInterpolator(new LinearInterpolator());
      this.Z.setDuration(1566L);
    }
    if (this.aa == null)
    {
      this.aa = ObjectAnimator.ofFloat(this, "tCAlpha", new float[] { 1.0F, 0.0F });
      this.aa.setInterpolator(new LinearInterpolator());
      this.aa.setDuration(866L);
    }
    if (this.jdField_o_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_o_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.Y);
      localArrayList.add(this.Z);
      localArrayList.add(this.aa);
      this.jdField_o_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_o_of_type_AndroidAnimationAnimatorSet.setStartDelay(34L);
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.ab == null)
    {
      this.ab = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.0F, 1.0F });
      this.ab.setInterpolator(new LinearInterpolator());
      this.ab.setDuration(1666L);
    }
    if (this.ac == null)
    {
      this.ac = ObjectAnimator.ofFloat(this, "sCScale", new float[] { 1.0F, 0.9F });
      this.ac.setInterpolator(new LinearInterpolator());
      this.ac.setDuration(334L);
    }
    if (this.jdField_p_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_p_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.ab);
      localArrayList.add(this.ac);
      this.jdField_p_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
    if (this.ad == null)
    {
      this.ad = ObjectAnimator.ofFloat(this, "sCRotate", new float[] { 0.0F, 45.0F });
      this.ad.setInterpolator(new LinearInterpolator());
      this.ad.setDuration(8000L);
      this.ad.setRepeatCount(-1);
    }
    if (this.jdField_q_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_q_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_q_of_type_AndroidAnimationAnimatorSet.play(this.ad);
    }
    if (this.ae == null)
    {
      this.ae = ObjectAnimator.ofFloat(this, "sCAlpha", new float[] { 0.0F, 1.0F });
      this.ae.setInterpolator(new LinearInterpolator());
      this.ae.setDuration(200L);
    }
    if (this.jdField_r_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_r_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_r_of_type_AndroidAnimationAnimatorSet.play(this.ae);
      this.jdField_r_of_type_AndroidAnimationAnimatorSet.setStartDelay(66L);
    }
  }
  
  @TargetApi(11)
  public void h()
  {
    if (this.af == null)
    {
      this.af = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.0F, 1.0F });
      this.af.setInterpolator(new LinearInterpolator());
      this.af.setDuration(1666L);
    }
    if (this.ag == null)
    {
      this.ag = ObjectAnimator.ofFloat(this, "sDScale", new float[] { 1.0F, 0.9F });
      this.ag.setInterpolator(new LinearInterpolator());
      this.ag.setDuration(334L);
    }
    ArrayList localArrayList;
    if (this.jdField_s_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_s_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.af);
      localArrayList.add(this.ag);
      this.jdField_s_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    }
    if (this.ah == null)
    {
      this.ah = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 0.0F, 1.0F });
      this.ah.setInterpolator(new LinearInterpolator());
      this.ah.setDuration(200L);
    }
    if (this.ai == null)
    {
      this.ai = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 1.0F, 1.0F });
      this.ai.setInterpolator(new LinearInterpolator());
      this.ai.setDuration(1566L);
    }
    if (this.aj == null)
    {
      this.aj = ObjectAnimator.ofFloat(this, "sDAlpha", new float[] { 1.0F, 0.6F });
      this.aj.setInterpolator(new LinearInterpolator());
      this.aj.setDuration(866L);
    }
    if (this.jdField_t_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_t_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localArrayList = new ArrayList();
      localArrayList.add(this.ah);
      localArrayList.add(this.ai);
      localArrayList.add(this.aj);
      this.jdField_t_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
      this.jdField_t_of_type_AndroidAnimationAnimatorSet.setStartDelay(34L);
    }
  }
  
  @TargetApi(11)
  public void i()
  {
    if (this.ak == null)
    {
      this.ak = ObjectAnimator.ofFloat(this, "fNCHAlpha", new float[] { 0.0F, 1.0F });
      this.ak.setInterpolator(new LinearInterpolator());
      this.ak.setDuration(320L);
    }
    if (this.jdField_u_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_u_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_u_of_type_AndroidAnimationAnimatorSet.play(this.ak);
      this.jdField_u_of_type_AndroidAnimationAnimatorSet.setStartDelay(2000L);
    }
    if (this.al == null)
    {
      this.al = ObjectAnimator.ofFloat(this, "fLAlpha", new float[] { 0.0F, 1.0F });
      this.al.setInterpolator(new LinearInterpolator());
      this.al.setDuration(200L);
    }
    if (this.jdField_v_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_v_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_v_of_type_AndroidAnimationAnimatorSet.play(this.al);
      this.jdField_v_of_type_AndroidAnimationAnimatorSet.setStartDelay(1900L);
    }
  }
  
  @TargetApi(11)
  public void j()
  {
    if (this.am == null)
    {
      this.am = ObjectAnimator.ofFloat(this, "fCPositionY", new float[] { -ViewUtils.a(25.0F), 0.0F });
      this.am.setInterpolator(new LinearInterpolator());
      this.am.setDuration(280L);
    }
    if (this.jdField_w_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_w_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_w_of_type_AndroidAnimationAnimatorSet.play(this.am);
      this.jdField_w_of_type_AndroidAnimationAnimatorSet.setStartDelay(2200L);
    }
    if (this.an == null)
    {
      this.an = ObjectAnimator.ofFloat(this, "fCAlpha", new float[] { 0.0F, 1.0F });
      this.an.setInterpolator(new LinearInterpolator());
      this.an.setDuration(280L);
    }
    if (this.jdField_x_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_x_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_x_of_type_AndroidAnimationAnimatorSet.play(this.an);
      this.jdField_x_of_type_AndroidAnimationAnimatorSet.setStartDelay(2200L);
    }
  }
  
  @TargetApi(11)
  public void k()
  {
    if (this.ao == null)
    {
      this.ao = ObjectAnimator.ofFloat(this, "fPAlpha", new float[] { 0.0F, 1.0F });
      this.ao.setInterpolator(new LinearInterpolator());
      this.ao.setDuration(280L);
    }
    if (this.jdField_y_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_y_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_y_of_type_AndroidAnimationAnimatorSet.play(this.ao);
      this.jdField_y_of_type_AndroidAnimationAnimatorSet.setStartDelay(2200L);
    }
    if (this.ap == null)
    {
      this.ap = ObjectAnimator.ofFloat(this, "fPOutCircleAlpha", new float[] { 1.0F, 0.0F, 0.0F });
      this.ap.setInterpolator(new LinearInterpolator());
      this.ap.setDuration(1500L);
      this.ap.setRepeatCount(-1);
    }
    if (this.jdField_z_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_z_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_z_of_type_AndroidAnimationAnimatorSet.play(this.ap);
      this.jdField_z_of_type_AndroidAnimationAnimatorSet.setStartDelay(2200L);
    }
    if (this.aq == null)
    {
      this.aq = ObjectAnimator.ofFloat(this, "fPOutCircleScale", new float[] { 1.0F, 1.3F, 1.3F });
      this.aq.setInterpolator(new LinearInterpolator());
      this.aq.setRepeatCount(-1);
      this.aq.setDuration(1500L);
    }
    if (this.jdField_A_of_type_AndroidAnimationAnimatorSet == null)
    {
      this.jdField_A_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_A_of_type_AndroidAnimationAnimatorSet.play(this.aq);
      this.jdField_A_of_type_AndroidAnimationAnimatorSet.setStartDelay(2200L);
    }
  }
  
  @TargetApi(11)
  public void l()
  {
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_b_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_c_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_d_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_e_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_f_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void m()
  {
    AnimatorSet localAnimatorSet = this.jdField_g_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_h_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_i_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void n()
  {
    AnimatorSet localAnimatorSet = this.jdField_j_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_k_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_l_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_m_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void o()
  {
    AnimatorSet localAnimatorSet = this.jdField_n_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_o_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void p()
  {
    AnimatorSet localAnimatorSet = this.jdField_p_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_q_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_r_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void q()
  {
    AnimatorSet localAnimatorSet = this.jdField_s_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_t_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void r()
  {
    AnimatorSet localAnimatorSet = this.jdField_u_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_v_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void s()
  {
    AnimatorSet localAnimatorSet = this.jdField_w_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_x_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void t()
  {
    AnimatorSet localAnimatorSet = this.jdField_y_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_z_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
    localAnimatorSet = this.jdField_A_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.MainObjectScanningData
 * JD-Core Version:    0.7.0.1
 */