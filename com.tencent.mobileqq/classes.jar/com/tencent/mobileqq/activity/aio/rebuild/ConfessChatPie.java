package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.os.MqqHandler;
import vrv;
import vrw;
import vrx;
import vry;

public class ConfessChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  protected boolean O;
  protected MessageObserver a;
  ConfessHandler jdField_a_of_type_ComTencentMobileqqConfessConfessHandler;
  public ConfessInfo a;
  ConfessObserver jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new vrv(this);
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  MqqHandler b;
  private String f;
  
  public ConfessChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vrx(this);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    int j = 0;
    for (;;)
    {
      int i;
      byte[] arrayOfByte;
      try
      {
        localObject = paramString1.getBytes("utf-8");
        int k = localObject.length;
        i = k;
        if (k % 16 != 0) {
          i = k + (16 - k % 16);
        }
        paramString1 = new byte[i];
        System.arraycopy(localObject, 0, paramString1, 0, localObject.length);
        localObject = Cipher.getInstance("AES/ECB/NoPadding");
        paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
        arrayOfByte = new byte[16];
        i = j;
      }
      catch (Exception paramString1)
      {
        Object localObject;
        paramString1.printStackTrace();
        QLog.e("Q.aio.ConfessChatPie", 1, "encryptEvilUin error: " + paramString1.getMessage());
        return null;
      }
      ((Cipher)localObject).init(1, paramString2);
      paramString1 = Utils.a(((Cipher)localObject).doFinal(paramString1));
      return paramString1;
      while (i < 16)
      {
        arrayOfByte[i] = 0;
        i += 1;
      }
    }
  }
  
  @NonNull
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ChatMessage)paramList.get(i)).getConfessTopicId() == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)
      {
        localArrayList.add(paramList.get(i));
        if ((((ChatMessage)paramList.get(i)).msgtype == 1032) && (QLog.isColorLevel())) {
          QLog.i("Q.aio.ConfessChatPie", 2, "ConfessChatPie has illegal msgType!");
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void aY()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130841239);
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130841239);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363495).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130841245);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130841257);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494212));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841264);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_Boolean = false;
        b(true);
        this.e.setText("你的匿名身份：" + this.f);
        this.e.setTextColor(-855638017);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-855638017);
        localObject = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        ((View)localObject).setBackgroundColor(-2013265920);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 2);
        localLayoutParams.addRule(12, -1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView((View)localObject, localLayoutParams);
        label343:
        localObject = "坦白说";
        if (this.O) {
          localObject = "我收到的";
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131364000).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription((String)localObject);
        localObject = new ConfessNewsBgView(this.jdField_a_of_type_AndroidContentContext);
        ((ConfessNewsBgView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
          break label555;
        }
      }
    }
    label555:
    for (int i = 858006566;; i = 268234225)
    {
      ((ConfessNewsBgView)localObject).setBgColor(i);
      ((ConfessNewsBgView)localObject).setSize(2);
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130846265);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837562);
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.f);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842918);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      break label343;
    }
  }
  
  private void aZ()
  {
    Object localObject = a();
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.a((Context)localObject, null);
    ((ActionSheet)localObject).a(2131433404, 5);
    ((ActionSheet)localObject).a(2131433452, 5);
    ((ActionSheet)localObject).c(2131433015);
    ((ActionSheet)localObject).a(new vry(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void F()
  {
    super.F();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
      a(-16777216, false);
    }
  }
  
  protected void L()
  {
    ThreadManager.post(new vrw(this), 8, null, true);
  }
  
  protected void M()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void Q()
  {
    Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).a != null) {
        ((ChatFragment)localObject).a.setStatusBarColor(1226741);
      }
    }
  }
  
  public List a()
  {
    return a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false));
  }
  
  protected List a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return a(paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, paramBoolean));
  }
  
  protected List a(boolean paramBoolean)
  {
    return a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true, true);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  protected void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(DraftTextInfo paramDraftTextInfo) {}
  
  protected boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    aY();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessHandler = ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125));
    return paramBoolean;
  }
  
  public void aJ() {}
  
  protected void aK()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    while (ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033)
    {
      Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
      ((FragmentManager)localObject).beginTransaction();
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = (ChatFragment)localObject;
        if (((ChatFragment)localObject).a != null) {
          ((ChatFragment)localObject).a.setStatusBarDrawable(a().getResources().getDrawable(2130843344));
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.e.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845881));
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364000).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setIsDefaultTheme(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845871));
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845817));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845635));
      localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130845781);
      Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845778);
      Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845782);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(localStateListDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845677));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130841257);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
  }
  
  public void aX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void al()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > l))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131433378, 1);
      return;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    a(localSendMsgParams);
    localSendMsgParams.g = this.F;
    this.F = false;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null, localSendMsgParams);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
    }
    aL();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { str });
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ConfessChatPie", 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    this.O = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.f = str1;
    paramIntent = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268);
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ConfessChatPie", 1, "friend uin is null ,uintype = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    ConfessCache localConfessCache = paramIntent.a();
    String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {}
    for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localConfessCache.a(str3, j, k, paramIntent, str1, i, str2, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.aio.ConfessChatPie", 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e), str1, Integer.valueOf(i) }));
      return;
    }
  }
  
  public int e()
  {
    int i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000 - 200;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  protected void h() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130841239);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131363474) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
    {
      aZ();
      return;
    }
    super.onClick(paramView);
  }
  
  public void s() {}
  
  protected void z()
  {
    super.z();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    aX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie
 * JD-Core Version:    0.7.0.1
 */