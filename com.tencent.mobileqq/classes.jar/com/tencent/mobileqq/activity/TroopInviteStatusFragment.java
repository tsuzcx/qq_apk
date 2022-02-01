package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
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
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopInviteStatusFragment.5(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopInviteStatusFragment.6(this);
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback = new TroopInviteStatusFragment.4(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new TroopInviteStatusFragment.7(this);
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
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131376809);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131379248);
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131370756);
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131377858);
    this.jdField_e_of_type_AndroidViewView = this.mContentView.findViewById(2131366365);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131362312));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377850));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131379244));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131379316));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.mContentView.findViewById(2131368948));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370760));
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
    if ((paramQQAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troopCode:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" invitedUin:");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append(" msgSeq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" senderUin:");
        ((StringBuilder)localObject).append(paramString4);
        ((StringBuilder)localObject).append(" currentUin:");
        ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
        QLog.d("TroopInviteStatusFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramString5;
      if (TextUtils.equals(paramString5, paramString4)) {
        localObject = ContactUtils.e(paramQQAppInterface, paramString4);
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("public_fragment_window_feature", 1);
      paramQQAppInterface.putExtra("troopCode", paramString1);
      paramQQAppInterface.putExtra("troopName", paramString2);
      paramQQAppInterface.putExtra("invitedUin", paramString3);
      paramQQAppInterface.putExtra("senderUin", paramString4);
      paramQQAppInterface.putExtra("senderNick", (String)localObject);
      paramQQAppInterface.putExtra("msgSeq", paramLong);
      PublicFragmentActivity.Launcher.a(paramContext, paramQQAppInterface, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("troopCode");
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      this.jdField_a_of_type_JavaLangString = str.trim();
    }
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("troopName");
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("invitedUin");
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderUin");
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderNick");
    this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("msgSeq", 0L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData troopCode:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" invitedUin:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" msgSeq:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" sendUin:");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" currentUin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append(" troopName:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("TroopInviteStatusFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
    {
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        break label422;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getBaseActivity().getString(2131694422), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight()).show();
      return true;
    }
    localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
    return true;
    label422:
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    return false;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_c_of_type_Int != 6)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isExited()))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838739);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        Object localObject3;
        switch (this.jdField_c_of_type_Int)
        {
        default: 
          break;
        case 7: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715247));
          break;
        case 5: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715244));
          break;
        case 4: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715252));
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715245));
          break;
        case 2: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715246));
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715253));
          break;
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          localObject1 = HardCodeUtil.a(2131715249);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(a(this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, 8));
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
          this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
          if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || ("0".equals(this.jdField_d_of_type_JavaLangString))) {
            this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
          }
        }
        try
        {
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_d_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_d_of_type_JavaLangString);
            this.jdField_b_of_type_Int -= 1;
          }
          if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
          {
            localObject1 = new StringBuilder();
            float f = 0.0F;
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            int i = 0;
            String str1;
            String str2;
            for (;;)
            {
              j = i;
              if (!((Iterator)localObject3).hasNext()) {
                break label638;
              }
              str1 = (String)((Iterator)localObject3).next();
              str2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 0);
              f += ContactUtils.a(str2);
              if (f >= 20) {
                break;
              }
              if (i > 0) {
                ((StringBuilder)localObject1).append("、");
              }
              ((StringBuilder)localObject1).append(str2);
              i += 1;
            }
            int j = i;
            if (i == 0)
            {
              ((StringBuilder)localObject1).append(a(str2, str1, 20));
              j = i + 1;
            }
            label638:
            if (this.jdField_b_of_type_Int > 99)
            {
              ((StringBuilder)localObject1).append("等99+人也在群聊中");
            }
            else if (j < this.jdField_b_of_type_Int)
            {
              ((StringBuilder)localObject1).append("等");
              ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
              ((StringBuilder)localObject1).append("人也在群聊中");
            }
            else
            {
              ((StringBuilder)localObject1).append("也在群聊中");
            }
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          switch (this.jdField_c_of_type_Int)
          {
          default: 
            break;
          case 7: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715248));
            break;
          case 5: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715251));
            break;
          case 4: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715240));
            break;
          case 3: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715243));
            break;
          case 2: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715241));
            break;
          case 1: 
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            break;
          case -1: 
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText("");
          }
          localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          if (localObject1 != null) {
            localObject3 = ((TroopInfo)localObject1).getTroopDisplayName();
          } else {
            localObject3 = "";
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = this.jdField_b_of_type_JavaLangString;
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject1;
            if (this.jdField_a_of_type_Int > 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("(");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
              ((StringBuilder)localObject3).append(")");
              localObject3 = ((StringBuilder)localObject3).toString();
            }
          }
          this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject3);
          return;
        }
        finally {}
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850794);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.app != null) && (this.mContentView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (a()) {
        a();
      }
      return;
    }
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("doOnCreateView error mActivity:");
    paramLayoutInflater.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater.append(" mContentView:");
    paramLayoutInflater.append(this.mContentView);
    QLog.e("TroopInviteStatusFragment", 1, paramLayoutInflater.toString());
  }
  
  protected int getContentLayoutId()
  {
    return 2131560679;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131362312)
    {
      if ((i == 2131379244) || (i == 2131379316))
      {
        TroopReportor.a("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
        localObject = TroopInfoUIUtil.a(this.jdField_a_of_type_JavaLangString, 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject, 2);
      }
    }
    else
    {
      TroopReportor.a("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
      if (!NetworkUtil.isNetSupport(getBaseActivity()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getBaseActivity().getString(2131694422), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight()).show();
      }
      else
      {
        localObject = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
        try
        {
          ((ITroopMngHandler)localObject).a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue(), null);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.d("TroopInviteStatusFragment", 2, "troopCode is null");
        }
        QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if (localQQProgressDialog != null)
        {
          localQQProgressDialog.c(2131718766);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131715242));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment
 * JD-Core Version:    0.7.0.1
 */