package com.tencent.mobileqq.activity.aio.audiopanel;

import acex;
import acfe;
import aetw;
import aety;
import aetz;
import aeua;
import aeub;
import aeuc;
import aeud;
import aeue;
import aeuf;
import aeui;
import aeuk;
import aeum;
import aeun;
import aeuo;
import aexr;
import aklj;
import alpo;
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
import azgq;
import azmj;
import bdee;
import bdje;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.SmallPttPlayView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextEditPanel
  extends RelativeLayout
  implements aetw, aeum, aeuo
{
  private int jdField_a_of_type_Int;
  private aeui jdField_a_of_type_Aeui = new aeui();
  private aeuk jdField_a_of_type_Aeuk = new aeuk();
  private aeun jdField_a_of_type_Aeun = new aeun();
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
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aeuf(this);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367555));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370067));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new aety(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363414));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView = ((VoiceTextEditScrollerView)findViewById(2131364770));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363907));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376331));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376345));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131380083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367592));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364254));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aetz(this));
    View localView = (View)this.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    localView.post(new VoiceTextEditPanel.3(this, azgq.a(8.0F), localView));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365535));
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView = ((SmallPttPlayView)findViewById(2131376799));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369433);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aeua(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new aeub(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aeuc(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aeud(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aeue(this));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getContext().getResources().getColor(2131166932));
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
    this.jdField_a_of_type_Aeui.c();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130849388));
    w();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("businessinfo_ptt_vt_send_type_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131719770);
      setSendEnable(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131719768);
    setSendEnable(false);
  }
  
  private void q()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_Aeuk.b();
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
    {
      QQToast.a(getContext(), alpo.a(2131717236), 0).b(getContext().getResources().getDimensionPixelSize(2131298914));
      setEditSendAndeCheckEnable();
      this.jdField_a_of_type_Aeun.b();
      this.jdField_a_of_type_Aeuk.c();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr.c(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj.a(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ax();
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aexr.c(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aw();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    this.jdField_a_of_type_Aeui.a();
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSmallPttPlayView.b();
    }
    this.jdField_a_of_type_Aeun.b();
    t();
    aftg.jdField_b_of_type_Boolean = false;
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
    localLayoutParams.bottomMargin = azgq.a(75.0F);
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
        int j = 2;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.substring(0, 149);
            i = j;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_d_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
      azmj.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 1, 0, "", "", "", "");
      if (a()) {
        break label366;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(false);
      this.jdField_a_of_type_Aeui.a();
      q();
    }
    for (;;)
    {
      u();
      return;
      acfe localacfe = new acfe();
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 5) {
        acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_c_of_type_JavaLangString, localArrayList, localacfe);
      }
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label330;
        }
        azmj.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 3, 0, "", "", "", "");
        break;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) {
          acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), localArrayList, localacfe);
        }
      }
      label330:
      azmj.b(null, "dc00898", "", "", "0X800A1DA", "0X800A1DA", 2, 0, "", "", "", "");
      break;
      label366:
      this.jdField_a_of_type_Aeui.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aM();
    }
  }
  
  public void a()
  {
    if ((!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) && (!bdje.a(this.jdField_c_of_type_JavaLangString))) {
      setSendEnable(true);
    }
  }
  
  public void a(int paramInt)
  {
    QQToast.a(getContext(), alpo.a(2131717234), 0).b(getContext().getResources().getDimensionPixelSize(2131298914));
    setEditSendAndeCheckEnable();
    this.jdField_a_of_type_Aeun.b();
    this.jdField_a_of_type_Aeuk.c();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aE();
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
        this.jdField_a_of_type_Aeui.a(getRight() - getLeft(), this.jdField_a_of_type_Aeui.a());
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.getTop() + getTop() - i >= azgq.a(2.0F))) {
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
    this.jdField_a_of_type_Aeui.a(paramViewGroup2, this, paramViewGroup1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (bdje.a(paramString)) {}
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
      azmj.b(null, "dc00898", "", "", "0X800A1DC", "0X800A1DC", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setListener(this);
      v();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130839295));
    }
    for (;;)
    {
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Aeui.a(paramBoolean);
      }
      return;
      if (!this.jdField_d_of_type_Boolean) {
        w();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setSlideEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditScrollerView.setBackgroundDrawable(getContext().getResources().getDrawable(2130849388));
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
    this.jdField_a_of_type_Aeun.b();
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
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131719768);
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
    azmj.b(null, "dc00898", "", "", "0X800A1D7", "0X800A1D7", 0, 0, "", "", "", "");
    s();
    AppNetConnInfo.registerConnectionChangeReceiver(getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    p();
    aftg.jdField_b_of_type_Boolean = true;
    if (!bdee.g(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "sendRequest  net unAvailable");
      }
      QQToast.a(getContext(), alpo.a(2131717235), 0).b(getContext().getResources().getDimensionPixelSize(2131298914));
      setEditSendAndeCheckEnable();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    }
    while (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_a_of_type_Aeuk.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Aeun.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aeui.b();
    if (this.jdField_a_of_type_Aeui.b() != 0) {
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
      this.jdField_a_of_type_Aeui.a(getRight() - getLeft(), this.jdField_a_of_type_Aeui.a());
      return;
    }
    u();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.an();
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
    this.jdField_a_of_type_Aeuk.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_Aeun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getResources().getColorStateList(2131166979), this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel
 * JD-Core Version:    0.7.0.1
 */