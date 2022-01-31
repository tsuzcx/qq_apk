package com.tencent.av.ui;

import acgw;
import aekt;
import alpo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import azmj;
import bdcd;
import bdee;
import bdfc;
import bdfe;
import bdfq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import lfu;
import lhe;
import lid;
import lij;
import lkx;
import mir;
import mis;
import mit;
import miu;
import miv;
import miw;
import mix;
import miy;
import miz;
import mja;
import mjb;
import mjc;
import mjd;
import mqq.app.BaseActivity;
import mtq;
import muo;
import mww;
import mwx;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  int jdField_a_of_type_Int;
  public long a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  public VideoAppInterface a;
  public MultiMembersAudioUI a;
  MultiVideoEnterPageActivity.TimeoutRunnable jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public final String a;
  lhe jdField_a_of_type_Lhe = new miw(this);
  lij jdField_a_of_type_Lij = new mjd(this);
  public mjc a;
  muo jdField_a_of_type_Muo = new mir(this);
  public boolean a;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public MultiVideoEnterPageMembersControlUI[] a;
  int jdField_b_of_type_Int;
  public long b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int e = 0;
  public int f = 0;
  int g = 0;
  public int h = 0;
  public int i = 0;
  final int j = 0;
  final int k = 1;
  
  public MultiVideoEnterPageActivity()
  {
    this.jdField_a_of_type_Mjc = new mjc();
    this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = ("MultiVideoEnterPageActivity_" + AudioHelper.b());
  }
  
  private void a(int paramInt, String paramString)
  {
    int n = 0;
    int m = n;
    if (paramInt == 3000)
    {
      m = n;
      if (bdfe.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_JavaLangString)))
      {
        acgw.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, new miz(this));
        m = 1;
      }
    }
    if (m == 0) {
      d(10);
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mtq.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startMultipVideo phone is calling!");
      }
      String str = getResources().getString(2131695916);
      bdcd.a(this, 230, getResources().getString(2131696156), str, 2131690648, 2131694951, new mis(this), null).show();
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c == true)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c = false;
      lkx.e();
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131372620: 
    case 2131372627: 
      do
      {
        return;
        a(paramView);
        return;
      } while (c());
      bdfc.c();
      a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString);
      return;
    }
    e();
    if (this.jdField_b_of_type_Int == 1) {
      if (this.f == 10) {
        azmj.b(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      finish();
      super.overridePendingTransition(0, 2130772136);
      return;
      azmj.b(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_b_of_type_Int == 3000) {
        azmj.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
      }
    }
  }
  
  void a()
  {
    Object localObject;
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      findViewById(2131372749).setBackgroundColor(Color.parseColor("#181818"));
      localObject = getResources().getDrawable(2130841828);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      ((TextView)findViewById(2131372724)).setCompoundDrawables((Drawable)localObject, null, null, null);
      ((TextView)findViewById(2131372724)).setCompoundDrawablePadding(0);
      ((TextView)findViewById(2131372724)).setTextColor(Color.parseColor("#737373"));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372626));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)findViewById(2131365792));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setIsEnterpage(true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_Muo);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372624));
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365791));
    this.jdField_a_of_type_Mjc.a(this);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#737373"));
      this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841893));
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130841895));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label667;
      }
      this.jdField_a_of_type_Mjc.a(4);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = new MultiVideoEnterPageMembersControlUI[2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] = new MultiVideoEnterPageMembersControlUI(this);
      localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0], (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(MultiVideoEnterPageMembersControlUI.jdField_c_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new mit(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] = new MultiVideoEnterPageMembersControlUI(this);
      localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1], (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(MultiVideoEnterPageMembersControlUI.jdField_d_of_type_Int);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new miu(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new miv(this));
    }
    for (;;)
    {
      a(false);
      if ((this.jdField_b_of_type_Int == 1) && (this.f == 2)) {
        mww.a(this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton, getResources().getString(2131693342), this.f);
      }
      return;
      label667:
      this.jdField_a_of_type_Mjc.a(0);
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new mwx());
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 10);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 2);
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramInt)) {
      return;
    }
    QQToast.a(this, alpo.a(2131707399), 1).b(a(this).getDimensionPixelSize(2131298914));
    finish();
  }
  
  public void a(long paramLong, ArrayList<lfu> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onUserListALLUpdate, simpleData is null, flag[" + this.jdField_a_of_type_Boolean + "]");
      if (!this.jdField_a_of_type_Boolean)
      {
        b();
        finish();
      }
    }
    do
    {
      return;
      if ((paramInt1 != 2) && (paramInt1 != 10) && (paramInt1 != 12)) {
        break;
      }
      this.e = paramArrayList.size();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onUserListALLUpdate, flag[" + this.jdField_a_of_type_Boolean + "], groupId[" + paramLong + "], userCount[" + paramInt2 + "], simpleData[" + paramArrayList.size() + "], mMemberCount[" + this.e + "], multiAVType[" + paramInt1 + "]");
      if (this.e != 0) {
        break label342;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
    } while ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length != 2));
    if (paramInt1 == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_c_of_type_AndroidWidgetTextView.setText(2131696149);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.setText(2131696014);
      return;
      this.e = paramInt2;
      break;
      if (paramInt1 == 10)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_c_of_type_AndroidWidgetTextView.setText(2131696150);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
    label333:
    b();
    finish();
    return;
    label342:
    if ((paramInt1 == 10) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1))
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(paramArrayList);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
      a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
      paramArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList.size(), paramArrayList);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
      paramArrayList = String.format(super.getResources().getString(2131696147), new Object[] { Integer.valueOf(this.e) });
      this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetTextView.setText(paramArrayList);
      c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
      return;
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 0))
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(paramArrayList);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (!bdee.d(this))
    {
      QQToast.a(this, 2131694700, 1).b(super.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(this.jdField_a_of_type_Long));
    localBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6, 0, 0, localBundle, null);
    if (localBundle == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeGAudio, rsp is null");
      paramView.setVisibility(8);
      return;
    }
    boolean bool2 = localBundle.getBoolean("isAdmin");
    boolean bool1 = localBundle.getBoolean("isOwner");
    if (1 == AudioHelper.a(7))
    {
      AudioHelper.a(alpo.a(2131707397));
      bool1 = true;
    }
    if ((!bool2) && (!bool1))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeGAudio, 没有权限");
      paramView.setVisibility(8);
      QQToast.a(super.getApplicationContext(), 2131693341, 1).a();
      return;
    }
    azmj.b(null, "CliOper", "", "", "0X8009E29", "0X8009E29", 0, 0, "", "", "", "");
    mja.a(this, 230, getResources().getString(2131695973), getResources().getString(2131693338), 2131695892, 2131721323, new mix(this, paramView), new miy(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int != 1) {}
    Object localObject;
    do
    {
      boolean bool;
      do
      {
        return;
        if (paramBoolean)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("uin", String.valueOf(this.jdField_a_of_type_Long));
        }
        for (localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6, 0, 0, (Bundle)localObject, null); localObject == null; localObject = getIntent().getBundleExtra("groupInfo"))
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCloseBtn, rsp is null");
          return;
        }
        bool = ((Bundle)localObject).getBoolean("isAdmin");
        paramBoolean = ((Bundle)localObject).getBoolean("isOwner");
        if (1 == AudioHelper.a(7))
        {
          AudioHelper.a(alpo.a(2131707402));
          paramBoolean = true;
        }
      } while ((!bool) && (!paramBoolean));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length <= 1) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] == null));
    this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    return;
    int m = (ImmersiveUtils.a() - aekt.a(12.0F, getResources()) * 2 - aekt.a(11.0F, getResources())) / 2;
    if (m < aekt.a(170.0F, getResources()))
    {
      localObject = this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = m;
      this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = m;
      this.jdField_a_of_type_Mjc.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(new mwx());
    this.jdField_a_of_type_Mjc.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  boolean a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get intent");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".processExtraData", localIntent.getExtras(), true);
              this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("openClass", false);
              this.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
              this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("creator_nick");
              this.jdField_a_of_type_Int = localIntent.getIntExtra("sessionType", 0);
              if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->get the wrong sessionType,Type=" + this.jdField_a_of_type_Int);
            return false;
            this.jdField_d_of_type_Int = localIntent.getIntExtra("Type", -1);
            if (this.jdField_d_of_type_Int == 3) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->get the wrong GAudioStatus,Type=" + this.jdField_d_of_type_Int);
          return false;
          this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("uin");
          this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("GroupId");
          if (this.jdField_b_of_type_JavaLangString != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
        return false;
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get the groupuin");
      return false;
      int m = localIntent.getIntExtra("MultiAVType", 0);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Get Intent AVType : " + m);
      }
      this.f = m;
      this.jdField_b_of_type_Int = localIntent.getIntExtra("uinType", -1);
      if (this.jdField_b_of_type_Int == 3000) {}
      for (this.jdField_c_of_type_Int = 2;; this.jdField_c_of_type_Int = 1)
      {
        this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("flag", false);
        return true;
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "processExtraData-->can not get uin Type.");
    return false;
  }
  
  void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long);
    localIntent.putExtra("openClass", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("relationType", this.jdField_c_of_type_Int);
    localIntent.putExtra("MultiAVType", this.f);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length == 2) && (paramInt == 10))
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(4);
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        b();
      }
      return;
    }
    b();
    finish();
  }
  
  public boolean b()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {}
    while (isFinishing()) {
      return true;
    }
    return false;
  }
  
  void c()
  {
    int m = bdee.a(this);
    if (bdee.f(this)) {
      m = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setNetTips,netinfo=" + m);
    }
    switch (m)
    {
    default: 
      m = -1;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int i1 = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int n = 0;
      while (n < i1)
      {
        MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[n];
        if (m != -1) {
          localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(m);
        }
        localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        n += 1;
      }
      m = 2131696011;
      continue;
      m = 2131696010;
      continue;
      m = 2131721301;
      continue;
      m = -1;
    }
    if (m != -1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(m);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setNetTips-->type=" + paramInt);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RemoveTipsRunnale(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
      {
        MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        int n = arrayOfMultiVideoEnterPageMembersControlUI.length;
        int m = 0;
        while (m < n)
        {
          MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[m];
          if (paramInt != -1)
          {
            localMultiVideoEnterPageMembersControlUI.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
            localMultiVideoEnterPageMembersControlUI.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          }
          m += 1;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoEnterPageActivity.6(this), 1000L);
        paramInt = -1;
        continue;
        paramInt = 2131696406;
        continue;
        paramInt = 2131696408;
      }
    } while (paramInt == -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "quitGAudioChatDialog");
    }
    mjb localmjb1 = new mjb(this, 0);
    mjb localmjb2 = new mjb(this, 1);
    mja.a(this, 230, null, super.getResources().getString(2131695988), 2131721276, 2131695904, localmjb1, localmjb2).show();
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onEnterButtonClick --> AVType = " + paramInt);
    }
    e(paramInt);
    if (this.jdField_b_of_type_Int == 1) {
      if (paramInt == 10) {
        azmj.b(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
      }
    }
    while (this.jdField_b_of_type_Int != 3000)
    {
      return;
      azmj.b(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      return;
    }
    if (this.e <= 0)
    {
      azmj.b(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
  }
  
  void e(int paramInt)
  {
    if (!bdee.d(this))
    {
      QQToast.a(this, 2131694700, 1).b(super.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().g < 7))
    {
      QQToast.a(this, 2131696351, 1).b(super.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onClickEnterMultiVideoChat, mRelationId[" + this.jdField_a_of_type_Long + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.e + "], mGAudioGroupId[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long + "], mHaveMoreRoom[" + this.jdField_a_of_type_Boolean + "], avtype[" + paramInt + "], currentAvtype[" + this.f + "]");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.e) && (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentAvVideoController.l()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()))
    {
      d();
      return;
    }
    f(paramInt);
  }
  
  @TargetApi(9)
  public void f(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = this.jdField_a_of_type_ComTencentAvVideoController.a().C;
    }
    paramInt = m;
    if (this.jdField_b_of_type_Int == 3000)
    {
      paramInt = m;
      if (!this.jdField_a_of_type_Boolean) {
        paramInt = 1;
      }
    }
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent(this, JumpActivity.class);
      localIntent.setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
      localIntent.putExtra("MultiAVType", paramInt);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("uinType", this.jdField_b_of_type_Int);
      localIntent.putExtra("ConfAppID", this.h);
      localIntent.putExtra("MeetingConfID", this.i);
      super.startActivity(localIntent);
      finish();
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.d(1010);
      }
      return;
      localIntent = new Intent(this, AVActivity.class);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559594);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.a(true, getWindow());
    AVActivity.a(super.getWindow());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoAppInterface");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCreate-->can not get the VideoController");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lij);
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "can not processExtraData");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = new MultiVideoEnterPageActivity.TimeoutRunnable(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable, 15000L);
    a();
    azmj.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RefreshDisplayNameRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_c_of_type_JavaLangRunnable);
    bdfc.b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lij);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.n = false;
    }
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
    this.jdField_a_of_type_Mjc.a();
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, mRelationType[" + this.jdField_c_of_type_Int + "], mRelationId[" + this.jdField_a_of_type_Long + "], multiAVType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().C + "], currentAvtype[" + this.f + "]");
      a(this.f);
    }
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new MultiVideoEnterPageActivity.RefreshFaceRunnable(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity
 * JD-Core Version:    0.7.0.1
 */