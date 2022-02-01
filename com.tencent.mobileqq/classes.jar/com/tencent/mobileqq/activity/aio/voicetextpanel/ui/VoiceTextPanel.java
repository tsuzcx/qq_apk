package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import aimz;
import aind;
import ainf;
import aini;
import aink;
import ainn;
import aino;
import ainq;
import ainu;
import aioa;
import aioc;
import aiod;
import aioe;
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
  private aimz jdField_a_of_type_Aimz;
  private aind jdField_a_of_type_Aind;
  private aini jdField_a_of_type_Aini;
  private aino jdField_a_of_type_Aino;
  private ainq jdField_a_of_type_Ainq;
  private ainu jdField_a_of_type_Ainu;
  private aioa jdField_a_of_type_Aioa;
  private aioc jdField_a_of_type_Aioc;
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
    this.jdField_a_of_type_Aimz.a();
    this.jdField_a_of_type_Aioc.a(this);
    this.jdField_a_of_type_Ainq.a(this);
    this.jdField_a_of_type_Aioa.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Aimz.i();
    this.jdField_a_of_type_Aini.a();
    this.jdField_a_of_type_Aioc.b();
    this.jdField_a_of_type_Ainu.c();
    this.jdField_a_of_type_Aioa.d();
    this.jdField_a_of_type_Ainq.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Aimz.h();
    this.jdField_a_of_type_Ainu.a();
    this.jdField_a_of_type_Aioc.d();
    this.jdField_a_of_type_Aioa.e();
    this.jdField_a_of_type_Aimz.k();
    aiod.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    ahdg.b = false;
    this.b = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public aind a()
  {
    return this.jdField_a_of_type_Aind;
  }
  
  public ainf a()
  {
    return this.jdField_a_of_type_Aino;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ainu.b();
    if (this.jdField_a_of_type_Ainu.b() != 0) {
      this.jdField_a_of_type_Aimz.g();
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
      this.jdField_a_of_type_Aioa.a(paramInt4);
      if ((paramInt2 > i) && (getTop() == i) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Ainu.a(getRight() - getLeft(), this.jdField_a_of_type_Ainu.a());
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
      if ((this.jdField_a_of_type_Aioa.a() <= 0) || (this.jdField_a_of_type_Aioa.a() + getTop() - paramInt2 >= ScreenUtil.dip2px(2.0F))) {
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
    this.jdField_a_of_type_Aind = new ainn(this);
    this.jdField_a_of_type_Aino = new aino(this);
    this.jdField_a_of_type_Aini = new aini();
    this.jdField_a_of_type_Aimz = new aimz(this.jdField_a_of_type_Aini, paramQQAppInterface, this);
    this.jdField_a_of_type_Aioc = new aioc();
    this.jdField_a_of_type_Ainq = new ainq();
    this.jdField_a_of_type_Aioa = new aioa();
    this.jdField_a_of_type_Ainu = new ainu();
    f();
    this.jdField_a_of_type_Ainu.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.b);
    }
    this.jdField_a_of_type_Aini.a().a(paramBoolean);
    if (paramBoolean)
    {
      aioe.a("0X800A1DC", 0, 0);
      this.jdField_a_of_type_Aioa.b();
      this.jdField_a_of_type_Ainq.a();
    }
    for (;;)
    {
      if ((!this.b) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Ainu.a(paramBoolean);
      }
      return;
      if (!this.b) {
        this.jdField_a_of_type_Ainq.b();
      }
      this.jdField_a_of_type_Aioa.c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aioc.c();
  }
  
  public void c()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Aini.a().a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Ainu.a(getRight() - getLeft(), this.jdField_a_of_type_Ainu.a());
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
    this.jdField_a_of_type_Aioc.a(paramString1, paramRecorderParam, paramInt, this);
    this.jdField_a_of_type_Aimz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRecorderParam, paramInt, paramString2, paramString1);
    this.jdField_a_of_type_Aioa.a();
    g();
    aiod.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_Aimz.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */