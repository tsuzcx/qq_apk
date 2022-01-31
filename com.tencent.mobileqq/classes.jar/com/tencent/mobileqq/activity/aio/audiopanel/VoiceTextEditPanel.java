package com.tencent.mobileqq.activity.aio.audiopanel;

import aael;
import aaes;
import acre;
import acrg;
import acrh;
import acri;
import acrj;
import acrk;
import acrl;
import acrm;
import acrn;
import acrq;
import acrs;
import acru;
import acrv;
import acrw;
import acuz;
import aihg;
import ajjy;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awmc;
import awqx;
import badq;
import baip;
import bbmy;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.SmallPttPlayView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextEditPanel
  extends RelativeLayout
  implements acre, acru, acrw
{
  private int jdField_a_of_type_Int;
  private acrq jdField_a_of_type_Acrq = new acrq();
  private acrs jdField_a_of_type_Acrs = new acrs();
  private acrv jdField_a_of_type_Acrv = new acrv();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private VoiceTextEditScrollerView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView;
  private SmallPttPlayView jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new acrn(this);
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  public String a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private final String jdField_b_of_type_JavaLangString = "VoiceTextEditPanel";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public VoiceTextEditPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextEditPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VoiceTextEditPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301817));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131304131));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new acrg(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297830));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView = ((VoiceTextEditScrollerView)findViewById(2131299132));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298297));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131310066));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310080));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131313529));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301852));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298635));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new acrh(this));
    View localView = (View)this.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    localView.post(new VoiceTextEditPanel.3(this, awmc.a(8.0F), localView));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299872));
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView = ((SmallPttPlayView)findViewById(2131310502));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131303531);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new acri(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new acrj(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acrk(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new acrl(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new acrm(this));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getContext().getResources().getColor(2131101290));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#FF292929"));
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    q();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_Acrq.c();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130848725));
    w();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("businessinfo_ptt_vt_send_type_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131653449);
      setSendEnable(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131653447);
    setSendEnable(false);
  }
  
  private void q()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_Acrs.b();
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
    {
      bbmy.a(getContext(), ajjy.a(2131651062), 0).b(getContext().getResources().getDimensionPixelSize(2131167766));
      setEditSendAndeCheckEnable();
      this.jdField_a_of_type_Acrv.b();
      this.jdField_a_of_type_Acrs.c();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz.c(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg.a(false);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acuz.c(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aihg.a(true);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    this.jdField_a_of_type_Acrq.a();
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.b();
    }
    this.jdField_a_of_type_Acrv.b();
    t();
    adlw.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setListener(null);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "hideBottom");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "showBottom");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = awmc.a(75.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      int i = 1;
      if (this.jdField_c_of_type_Boolean)
      {
        i = 2;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_d_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
      awqx.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 1, 0, "", "", "", "");
      if (a()) {
        break label310;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(false);
      this.jdField_a_of_type_Acrq.a();
      q();
    }
    for (;;)
    {
      u();
      return;
      aaes localaaes = new aaes();
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 5) {
        aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_c_of_type_JavaLangString, localArrayList, localaaes);
      }
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label274;
        }
        awqx.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 3, 0, "", "", "", "");
        break;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) {
          aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), localArrayList, localaaes);
        }
      }
      label274:
      awqx.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 2, 0, "", "", "", "");
      break;
      label310:
      this.jdField_a_of_type_Acrq.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aI();
    }
  }
  
  public void a()
  {
    if ((!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) && (!baip.a(this.jdField_c_of_type_JavaLangString))) {
      setSendEnable(true);
    }
  }
  
  public void a(int paramInt)
  {
    bbmy.a(getContext(), ajjy.a(2131651060), 0).b(getContext().getResources().getDimensionPixelSize(2131167766));
    setEditSendAndeCheckEnable();
    this.jdField_a_of_type_Acrv.b();
    this.jdField_a_of_type_Acrs.c();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "enterEditState");
    }
    v();
    int i = getHeight();
    int j = getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.a(getTop(), paramInt2, i - paramInt1, j, 1, 100, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aA();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "enterNormalState normalStateBottom=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " top=" + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop(), paramInt1, paramInt2, paramInt3, 0, 200, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    w();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, new Object[] { "onXContainerLayout  start left=", Integer.valueOf(paramInt1), " top=", Integer.valueOf(paramInt2), " right=", Integer.valueOf(paramInt3), " bottom=", Integer.valueOf(paramInt4), " isDrag=", this.jdField_d_of_type_Boolean + " isShowEidt= " + paramBoolean + " mSlideLayout.top=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " mSlideLayout.bottom=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getBottom() + " this.top=" + getTop() + " this.bottom=" + getBottom() + "y=" + getY() });
    }
    int i;
    if (!this.jdField_d_of_type_Boolean)
    {
      if (paramInt2 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setMaxHeight(paramInt4);
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getBottom();
      i = paramInt2;
      if (paramInt2 == 0) {
        i = paramInt2 + j;
      }
      if ((i > j) && (getTop() == j)) {
        this.jdField_a_of_type_Acrq.a(getRight() - getLeft(), this.jdField_a_of_type_Acrq.a());
      }
      if ((getTop() != i) || (paramInt4 != getBottom()) || (!paramBoolean)) {
        break label305;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "onXContainerLayout edit state need no layout");
      }
    }
    label305:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + getTop() - i >= awmc.a(2.0F))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "onXContainerLayout normal state need no layout");
    return;
    measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - i, 1073741824));
    layout(paramInt1, i, paramInt3, paramInt4);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (!a())) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.onTouchEvent(paramMotionEvent);
    } while (paramMotionEvent.getAction() != 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setMaskClick(true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    o();
    this.jdField_a_of_type_Acrq.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (baip.a(paramString)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "updateText has finish");
    return;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, " onSoftInputShowing  isShow=" + paramBoolean + " isDrag=" + this.jdField_d_of_type_Boolean);
    }
    this.e = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setListener(this);
      v();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130839181));
    }
    for (;;)
    {
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Acrq.a(paramBoolean);
      }
      return;
      if (!this.jdField_d_of_type_Boolean) {
        w();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130848725));
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "vadFinishWithNoSeg state= " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    this.jdField_a_of_type_Acrv.b();
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextEditPanel.10(this));
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "onActionDown but mHeader cannot see");
      }
    }
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setPanelActionDownPos(getTop(), getBottom());
      measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt - getTop(), 1073741824));
      layout(getLeft(), getTop(), getRight(), paramInt);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(getLeft(), 0, getRight(), paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTextEditPanel", 2, "ACTION_DOWN mSlideLayout.getTop()=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + " gettop=" + getTop() + " mSlideLayout.getBottom()" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getBottom() + " getbottom=" + getBottom() + " y=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getY());
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131653447);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "forbitSendAudio");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
    l();
  }
  
  public void d()
  {
    u();
  }
  
  public void e()
  {
    awqx.b(null, "dc00898", "", "", "0X800A1D7", "0X800A1D7", 0, 0, "", "", "", "");
    s();
    AppNetConnInfo.registerConnectionChangeReceiver(getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    p();
    adlw.jdField_b_of_type_Boolean = true;
    if (!badq.g(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "sendRequest  net unAvailable");
      }
      bbmy.a(getContext(), ajjy.a(2131651061), 0).b(getContext().getResources().getDimensionPixelSize(2131167766));
      setEditSendAndeCheckEnable();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    }
    while (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_a_of_type_Acrs.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Acrv.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Acrq.b();
    if (this.jdField_a_of_type_Acrq.b() != 0) {
      q();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.a();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextEditPanel.11(this));
  }
  
  public void i()
  {
    n();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(false);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(true);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void l()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void m()
  {
    if (a())
    {
      this.jdField_a_of_type_Acrq.a(getRight() - getLeft(), this.jdField_a_of_type_Acrq.a());
      return;
    }
    u();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.al();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setEditSendAndeCheckEnable()
  {
    setSendEnable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
  }
  
  public void setParam(String paramString1, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.setDuration(this.jdField_a_of_type_Int, paramString1, paramRecorderParam);
    }
    this.jdField_a_of_type_Acrs.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_Acrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getResources().getColorStateList(2131101336), this);
  }
  
  public void setSendEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void setSttNetFinish()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    this.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel
 * JD-Core Version:    0.7.0.1
 */