package com.tencent.mobileqq.activity;

import adky;
import adzj;
import adzk;
import adzl;
import ahlb;
import alpo;
import alsi;
import amab;
import amha;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bclo;
import bcxb;
import bdaj;
import bdbt;
import bdee;
import bepp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import mwx;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopInviteStatusFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  long jdField_a_of_type_Long;
  ahlb jdField_a_of_type_Ahlb = new adzj(this);
  alsi jdField_a_of_type_Alsi = new adzk(this);
  private amab jdField_a_of_type_Amab = new adzl(this);
  public Handler a;
  public FragmentActivity a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bepp a;
  public QQAppInterface a;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  public Runnable b;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  public Runnable c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = true;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString;
  View jdField_e_of_type_AndroidViewView;
  String jdField_e_of_type_JavaLangString;
  
  public TroopInviteStatusFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new TroopInviteStatusFragment.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new TroopInviteStatusFragment.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new TroopInviteStatusFragment.3(this);
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return bdbt.a(paramString1, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131375981);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131378352);
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131370134);
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131376962);
    this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131365873);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131362228));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131376954));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131378348));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131378414));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131368418));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370138));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new mwx());
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setOnTouchListener(new mwx());
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    b();
  }
  
  private void a(int paramInt)
  {
    long l1 = this.jdField_a_of_type_Long;
    long l2 = Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue();
    structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
    localSystemMsgActionInfo.group_code.set(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
    localSystemMsgActionInfo.type.set(11);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(1, l1, l2, 1, 3, 10016, paramInt, localSystemMsgActionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "troopCode:" + paramString1 + " invitedUin:" + paramString3 + " msgSeq:" + paramLong + " senderUin:" + paramString4 + " currentUin:" + paramQQAppInterface.c());
    }
    String str = paramString5;
    if (TextUtils.equals(paramString5, paramString4)) {
      str = bdbt.h(paramQQAppInterface, paramString4);
    }
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtra("public_fragment_window_feature", 1);
    paramQQAppInterface.putExtra("troopCode", paramString1);
    paramQQAppInterface.putExtra("troopName", paramString2);
    paramQQAppInterface.putExtra("invitedUin", paramString3);
    paramQQAppInterface.putExtra("senderUin", paramString4);
    paramQQAppInterface.putExtra("senderNick", str);
    paramQQAppInterface.putExtra("msgSeq", paramLong);
    adky.a(paramContext, paramQQAppInterface, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("troopCode");
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim();
    }
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("troopName");
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("invitedUin");
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderUin");
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderNick");
    this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("msgSeq", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "initData troopCode:" + this.jdField_a_of_type_JavaLangString + " invitedUin:" + this.jdField_c_of_type_JavaLangString + " msgSeq:" + this.jdField_a_of_type_Long + " sendUin:" + this.jdField_d_of_type_JavaLangString + " currentUin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + " troopName:" + this.jdField_b_of_type_JavaLangString);
    }
    if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (bdee.d(getActivity())) {
        break label347;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, getActivity().getString(2131694764), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
      return true;
      if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        break;
      }
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    return false;
    label347:
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
    return true;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if ((this.jdField_c_of_type_Int == 6) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isExited())))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849754);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838591);
    Object localObject3;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      switch (this.jdField_c_of_type_Int)
      {
      }
      for (;;)
      {
        localObject1 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        localObject3 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = this.jdField_b_of_type_JavaLangString;
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = localObject1;
          if (this.jdField_a_of_type_Int > 0) {
            localObject3 = (String)localObject1 + "(" + this.jdField_a_of_type_Int + ")";
          }
        }
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject3);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715855));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715848));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715847));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715854));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715846));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715849));
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
    Object localObject1 = alpo.a(2131715851);
    localObject1 = a(this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, 8) + (String)localObject1;
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || ("0".equals(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
    }
    label984:
    label1127:
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_d_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_d_of_type_JavaLangString);
          this.jdField_b_of_type_Int -= 1;
        }
        if ((this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label984;
        }
        localObject1 = new StringBuilder();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        float f1 = 0.0F;
        int i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label1127;
        }
        String str1 = (String)((Iterator)localObject3).next();
        String str2 = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 0);
        float f2 = bdbt.a(str2);
        if (f1 + f2 < 20)
        {
          if (i > 0) {
            ((StringBuilder)localObject1).append("、");
          }
          ((StringBuilder)localObject1).append(str2);
          i += 1;
          f1 += f2;
          continue;
        }
        if (i != 0) {
          break label1127;
        }
        ((StringBuilder)localObject1).append(a(str2, str1, 20));
        i += 1;
        if (this.jdField_b_of_type_Int > 99)
        {
          ((StringBuilder)localObject1).append("等99+人也在群聊中");
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        switch (this.jdField_c_of_type_Int)
        {
        case 0: 
        case 6: 
        default: 
          break;
        case -1: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("");
          break;
          if (i < this.jdField_b_of_type_Int)
          {
            ((StringBuilder)localObject1).append("等").append(this.jdField_b_of_type_Int).append("人也在群聊中");
            continue;
          }
          localObject2.append("也在群聊中");
        }
      }
      finally {}
      continue;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715843));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715845));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715842));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715853));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131715850));
      break;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.mContentView == null)) {
      QLog.e("TroopInviteStatusFragment", 1, "doOnCreateView error mActivity:" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity + " mContentView:" + this.mContentView);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    } while (!a());
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560485;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      bdaj.a("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
      paramView = TroopInfoActivity.a(this.jdField_a_of_type_JavaLangString, 4);
      paramView.putInt("t_s_f", 1001);
      bclo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, 2);
      return;
      bdaj.a("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
      if (!bdee.d(getActivity()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, getActivity().getString(2131694764), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
        return;
      }
      paramView = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("TroopInviteStatusFragment", 2, "doCheckPayTroopReq start: " + paramView);
      }
      TroopRequestActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, null, this.jdField_a_of_type_Ahlb);
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.dismiss();
      }
    } while (this.jdField_a_of_type_Bepp == null);
    this.jdField_a_of_type_Bepp.c(2131719773);
    this.jdField_a_of_type_Bepp.show();
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(alpo.a(2131715844));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
    }
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_c_of_type_Boolean) {
      b();
    }
    this.jdField_c_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment
 * JD-Core Version:    0.7.0.1
 */