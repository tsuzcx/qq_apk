package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import ahsa;
import ahse;
import ahsg;
import ahsj;
import ahsl;
import ahso;
import ahsp;
import ahsr;
import ahsv;
import ahtb;
import ahtd;
import ahte;
import ahtf;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class VoiceTextPanel
  extends RelativeLayout
{
  private ahsa jdField_a_of_type_Ahsa;
  private ahse jdField_a_of_type_Ahse;
  private ahsj jdField_a_of_type_Ahsj;
  private ahsp jdField_a_of_type_Ahsp;
  private ahsr jdField_a_of_type_Ahsr;
  private ahsv jdField_a_of_type_Ahsv;
  private ahtb jdField_a_of_type_Ahtb;
  private ahtd jdField_a_of_type_Ahtd;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  private boolean b;
  
  public VoiceTextPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ahsa.a();
    this.jdField_a_of_type_Ahtd.a(this);
    this.jdField_a_of_type_Ahsr.a(this);
    this.jdField_a_of_type_Ahtb.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ahsa.i();
    this.jdField_a_of_type_Ahsj.a();
    this.jdField_a_of_type_Ahtd.b();
    this.jdField_a_of_type_Ahsv.c();
    this.jdField_a_of_type_Ahtb.d();
    this.jdField_a_of_type_Ahsr.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Ahsa.h();
    this.jdField_a_of_type_Ahsv.a();
    this.jdField_a_of_type_Ahtd.d();
    this.jdField_a_of_type_Ahtb.e();
    this.jdField_a_of_type_Ahsa.k();
    ahte.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    agkq.b = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public ahse a()
  {
    return this.jdField_a_of_type_Ahse;
  }
  
  public ahsg a()
  {
    return this.jdField_a_of_type_Ahsp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahsv.b();
    if (this.jdField_a_of_type_Ahsv.b() != 0) {
      this.jdField_a_of_type_Ahsa.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i;
    if (!this.b)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.getBottom();
      if (paramInt2 == 0) {
        break label114;
      }
      this.jdField_a_of_type_Ahtb.a(paramInt4);
      if ((paramInt2 > i) && (getTop() == i) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Ahsv.a(getRight() - getLeft(), this.jdField_a_of_type_Ahsv.a());
      }
      if ((getTop() != paramInt2) || (paramInt4 != getBottom()) || (!paramBoolean)) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextPanel", 2, "onXContainerLayout edit state need no layout");
      }
    }
    label114:
    label122:
    do
    {
      return;
      paramInt2 += i;
      break;
      if ((this.jdField_a_of_type_Ahtb.a() <= 0) || (this.jdField_a_of_type_Ahtb.a() + getTop() - paramInt2 >= ScreenUtil.dip2px(2.0F))) {
        break label168;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextPanel", 2, "onXContainerLayout normal state need no layout");
    return;
    label168:
    measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Ahse = new ahso(this);
    this.jdField_a_of_type_Ahsp = new ahsp(this);
    this.jdField_a_of_type_Ahsj = new ahsj();
    this.jdField_a_of_type_Ahsa = new ahsa(this.jdField_a_of_type_Ahsj, paramQQAppInterface, this);
    this.jdField_a_of_type_Ahtd = new ahtd();
    this.jdField_a_of_type_Ahsr = new ahsr();
    this.jdField_a_of_type_Ahtb = new ahtb();
    this.jdField_a_of_type_Ahsv = new ahsv();
    f();
    this.jdField_a_of_type_Ahsv.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.b);
    }
    this.jdField_a_of_type_Ahsj.a().a(paramBoolean);
    if (paramBoolean)
    {
      ahtf.a("0X800A1DC", 0, 0);
      this.jdField_a_of_type_Ahtb.b();
      this.jdField_a_of_type_Ahsr.a();
    }
    for (;;)
    {
      if ((!this.b) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Ahsv.a(paramBoolean);
      }
      return;
      if (!this.b) {
        this.jdField_a_of_type_Ahsr.b();
      }
      this.jdField_a_of_type_Ahtb.c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ahtd.c();
  }
  
  public void c()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Ahsj.a().a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Ahsv.a(getRight() - getLeft(), this.jdField_a_of_type_Ahsv.a());
      return;
    }
    h();
  }
  
  public void e()
  {
    h();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setParam(String paramString1, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_Ahtd.a(paramString1, paramRecorderParam, paramInt, this);
    this.jdField_a_of_type_Ahsa.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRecorderParam, paramInt, paramString2, paramString1);
    this.jdField_a_of_type_Ahtb.a();
    g();
    ahte.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_Ahsa.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */