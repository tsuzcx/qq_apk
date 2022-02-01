package com.tencent.mobileqq.activity;

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
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopInviteStatusFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new TroopInviteStatusFragment.4(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new TroopInviteStatusFragment.7(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopInviteStatusFragment.5(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopInviteStatusFragment.6(this);
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new TroopInviteStatusFragment.1(this);
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new TroopInviteStatusFragment.2(this);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  Runnable jdField_c_of_type_JavaLangRunnable = new TroopInviteStatusFragment.3(this);
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = true;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString;
  View jdField_e_of_type_AndroidViewView;
  String jdField_e_of_type_JavaLangString;
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return ContactUtils.a(paramString1, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131377356);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131379919);
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131371132);
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131378444);
    this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131366482);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131362351));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378436));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131379915));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131379987));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131369219));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371136));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(1, l1, l2, 1, 3, 10016, paramInt, localSystemMsgActionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "troopCode:" + paramString1 + " invitedUin:" + paramString3 + " msgSeq:" + paramLong + " senderUin:" + paramString4 + " currentUin:" + paramQQAppInterface.getCurrentUin());
    }
    String str = paramString5;
    if (TextUtils.equals(paramString5, paramString4)) {
      str = ContactUtils.h(paramQQAppInterface, paramString4);
    }
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtra("public_fragment_window_feature", 1);
    paramQQAppInterface.putExtra("troopCode", paramString1);
    paramQQAppInterface.putExtra("troopName", paramString2);
    paramQQAppInterface.putExtra("invitedUin", paramString3);
    paramQQAppInterface.putExtra("senderUin", paramString4);
    paramQQAppInterface.putExtra("senderNick", str);
    paramQQAppInterface.putExtra("msgSeq", paramLong);
    PublicFragmentActivity.Launcher.a(paramContext, paramQQAppInterface, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
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
      QLog.d("TroopInviteStatusFragment", 2, "initData troopCode:" + this.jdField_a_of_type_JavaLangString + " invitedUin:" + this.jdField_c_of_type_JavaLangString + " msgSeq:" + this.jdField_a_of_type_Long + " sendUin:" + this.jdField_d_of_type_JavaLangString + " currentUin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + " troopName:" + this.jdField_b_of_type_JavaLangString);
    }
    if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (NetworkUtil.d(getActivity())) {
        break label347;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, getActivity().getString(2131694457), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
      return true;
      if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        break;
      }
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    return false;
    label347:
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
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
    if ((this.jdField_c_of_type_Int == 6) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isExited())))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850857);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838979);
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
        localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        localObject3 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715331));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715324));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715323));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715330));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715322));
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715325));
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
    Object localObject1 = HardCodeUtil.a(2131715327);
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
        String str2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 0);
        float f2 = ContactUtils.a(str2);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715319));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715321));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715318));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715329));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715326));
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
    return 2131560806;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopReportor.a("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
      Object localObject = TroopInfoActivity.a(this.jdField_a_of_type_JavaLangString, 4);
      ((Bundle)localObject).putInt("t_s_f", 1001);
      TroopUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Bundle)localObject, 2);
      continue;
      TroopReportor.a("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
      if (!NetworkUtil.d(getActivity()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, getActivity().getString(2131694457), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
        continue;
      }
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      try
      {
        ((TroopHandler)localObject).b(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue(), null);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          QLog.d("TroopInviteStatusFragment", 2, "troopCode is null");
        }
      }
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131715320));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment
 * JD-Core Version:    0.7.0.1
 */