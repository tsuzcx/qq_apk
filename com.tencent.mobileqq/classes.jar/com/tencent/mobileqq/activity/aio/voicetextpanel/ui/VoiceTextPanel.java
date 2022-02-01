package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import aixp;
import aixt;
import aixv;
import aixy;
import aiya;
import aiyd;
import aiye;
import aiyg;
import aiyk;
import aiyq;
import aiys;
import aiyt;
import aiyu;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import bdep;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class VoiceTextPanel
  extends RelativeLayout
{
  private aixp jdField_a_of_type_Aixp;
  private aixt jdField_a_of_type_Aixt;
  private aixy jdField_a_of_type_Aixy;
  private aiye jdField_a_of_type_Aiye;
  private aiyg jdField_a_of_type_Aiyg;
  private aiyk jdField_a_of_type_Aiyk;
  private aiyq jdField_a_of_type_Aiyq;
  private aiys jdField_a_of_type_Aiys;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
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
    this.jdField_a_of_type_Aixp.a();
    this.jdField_a_of_type_Aiys.a(this);
    this.jdField_a_of_type_Aiyg.a(this);
    this.jdField_a_of_type_Aiyq.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Aixp.i();
    this.jdField_a_of_type_Aixy.a();
    this.jdField_a_of_type_Aiys.b();
    this.jdField_a_of_type_Aiyk.c();
    this.jdField_a_of_type_Aiyq.d();
    this.jdField_a_of_type_Aiyg.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Aixp.h();
    this.jdField_a_of_type_Aiyk.a();
    this.jdField_a_of_type_Aiys.d();
    this.jdField_a_of_type_Aiyq.e();
    this.jdField_a_of_type_Aixp.k();
    aiyt.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    ahod.b = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public aixt a()
  {
    return this.jdField_a_of_type_Aixt;
  }
  
  public aixv a()
  {
    return this.jdField_a_of_type_Aiye;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aiyk.b();
    if (this.jdField_a_of_type_Aiyk.b() != 0) {
      this.jdField_a_of_type_Aixp.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i;
    if (!this.b)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getBottom();
      if (paramInt2 == 0) {
        break label114;
      }
      this.jdField_a_of_type_Aiyq.a(paramInt4);
      if ((paramInt2 > i) && (getTop() == i) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Aiyk.a(getRight() - getLeft(), this.jdField_a_of_type_Aiyk.a());
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
      if ((this.jdField_a_of_type_Aiyq.a() <= 0) || (this.jdField_a_of_type_Aiyq.a() + getTop() - paramInt2 >= bdep.a(2.0F))) {
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Aixt = new aiyd(this);
    this.jdField_a_of_type_Aiye = new aiye(this);
    this.jdField_a_of_type_Aixy = new aixy();
    this.jdField_a_of_type_Aixp = new aixp(this.jdField_a_of_type_Aixy, paramQQAppInterface, this);
    this.jdField_a_of_type_Aiys = new aiys();
    this.jdField_a_of_type_Aiyg = new aiyg();
    this.jdField_a_of_type_Aiyq = new aiyq();
    this.jdField_a_of_type_Aiyk = new aiyk();
    f();
    this.jdField_a_of_type_Aiyk.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.b);
    }
    this.jdField_a_of_type_Aixy.a().a(paramBoolean);
    if (paramBoolean)
    {
      aiyu.a("0X800A1DC", 0, 0);
      this.jdField_a_of_type_Aiyq.b();
      this.jdField_a_of_type_Aiyg.a();
    }
    for (;;)
    {
      if ((!this.b) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Aiyk.a(paramBoolean);
      }
      return;
      if (!this.b) {
        this.jdField_a_of_type_Aiyg.b();
      }
      this.jdField_a_of_type_Aiyq.c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aiys.c();
  }
  
  public void c()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Aixy.a().a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Aiyk.a(getRight() - getLeft(), this.jdField_a_of_type_Aiyk.a());
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
    this.jdField_a_of_type_Aiys.a(paramString1, paramRecorderParam, paramInt, this);
    this.jdField_a_of_type_Aixp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRecorderParam, paramInt, paramString2, paramString1);
    this.jdField_a_of_type_Aiyq.a();
    g();
    aiyt.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_Aixp.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */