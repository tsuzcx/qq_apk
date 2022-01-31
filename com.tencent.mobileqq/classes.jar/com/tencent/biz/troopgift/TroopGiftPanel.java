package com.tencent.biz.troopgift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import oxe;
import oxf;
import oxh;
import oxi;
import oxj;
import oxk;
import oxl;
import oxm;

public class TroopGiftPanel
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, TabBarView.OnTabChangeListener
{
  public int a;
  public Context a;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public TroopGiftAioItemData a;
  public TroopGiftAioPanelData a;
  public TroopGiftPanel.OnShowOrHideListerner a;
  public SessionInfo a;
  public TabBarView a;
  public String a;
  public WeakReference a;
  public boolean a;
  public GridListViewPager[] a;
  protected RadioViewPager[] a;
  public String[] a;
  public int b;
  public View b;
  public TextView b;
  public String b;
  public WeakReference b;
  protected boolean b;
  public int c;
  public View c;
  public TextView c;
  public String c;
  public boolean c;
  public int d;
  public View d;
  public TextView d;
  protected boolean d;
  public int e;
  
  public TroopGiftPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "选择对象赠送 ", "立即赠送" };
    this.jdField_a_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_a_of_type_Int = 1731;
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.e = 1;
  }
  
  public TroopGiftPanel(Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner)
  {
    this(paramContext, paramOnShowOrHideListerner, true);
  }
  
  public TroopGiftPanel(Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "选择对象赠送 ", "立即赠送" };
    this.jdField_a_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_a_of_type_Int = 1731;
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner = paramOnShowOrHideListerner;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "赠送", "赠送" };
    this.e = 1;
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this(paramContext, paramBaseChatPie, 1, 0);
  }
  
  public TroopGiftPanel(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "选择对象赠送 ", "立即赠送" };
    this.jdField_a_of_type_JavaLangString = "OidbSvc.0x6c3";
    this.jdField_a_of_type_Int = 1731;
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.e = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if ((paramInt2 == 2) || (paramInt2 == 7)) {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "赠送", "赠送" };
    }
  }
  
  public int a()
  {
    int j = 0;
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    int i = j;
    try
    {
      if (!TextUtils.isEmpty(localCharSequence)) {
        i = Integer.parseInt(localCharSequence.toString().substring(1));
      }
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("zivonchen", 2, "error sendNum = " + localCharSequence);
    }
    return 0;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_AndroidContentContext;
  }
  
  public TabBarView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  }
  
  public String a()
  {
    if (this.jdField_d_of_type_Int == 2) {
      return null;
    }
    if (this.jdField_d_of_type_Int == 7) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    AppInterface localAppInterface;
    do
    {
      do
      {
        return paramString;
      } while ((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 7));
      localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localAppInterface == null);
    Object localObject = (TroopManager)localAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(a());
      if (localObject != null) {
        if (((TroopInfo)localObject).isTroopOwner(localAppInterface.getCurrentAccountUin())) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      return paramString.replace("$GCODE$", a()).replace("$CLIENTVER$", "android7.6.0").replace("$UIN$", localAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$ROLE$", (CharSequence)localObject);
      if (((TroopInfo)localObject).isAdmin())
      {
        localObject = "1";
      }
      else
      {
        localObject = "2";
        continue;
        localObject = "2";
      }
    }
  }
  
  public void a()
  {
    inflate(getContext(), 2130969883, this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "setLeftCoinDrawable param illegal");
      }
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setDownloadListener(new oxe(this, paramTextView));
    paramString.setBounds(0, 0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 14.0F));
    paramTextView.setCompoundDrawables(paramString, null, null, null);
    paramTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
    paramString.startDownload();
  }
  
  public void a(TroopGiftPanel.OnGetGiveGiftCallback paramOnGetGiveGiftCallback)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(112);
    String str1 = this.jdField_a_of_type_JavaLangString;
    int j = this.jdField_a_of_type_Int;
    int k = this.e;
    String str2 = a();
    if (this.e >= 4) {}
    for (int i = 2;; i = 0)
    {
      ((TroopGiftManager)localObject).a(str1, j, k, str2, 2, i, new oxf(this, paramOnGetGiveGiftCallback));
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo)
  {
    a(paramAppInterface, paramSessionInfo, true);
  }
  
  public void a(AppInterface paramAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362709);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368328);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131368325));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getResources().getString(2131430732));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getResources().getString(2131430733));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight((int)getResources().getDimension(2131559209));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#ff5984"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setWidth((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setWidth((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager = new RadioViewPager[2];
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager = new GridListViewPager[2];
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[0] = ((RadioViewPager)findViewById(2131368329));
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[1] = ((RadioViewPager)findViewById(2131368330));
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[0].setGiftPanel(this);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[1].setGiftPanel(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setBackgroundColor(0);
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).getParent()).setVisibility(8);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i] = ((GridListViewPager)this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[i].a());
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[i].setOnItemClickListener(this);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[i].setVisibility(8);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[this.jdField_b_of_type_Int].setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366682));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int]);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366683));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364035);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366679));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366680));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131366681).setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131368326);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368327));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    findViewById(2131366674).setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("x" + paramString);
  }
  
  public boolean a(int paramInt, TroopGiftManager.GiveGift paramGiveGift)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Int < paramInt) {
      if (paramGiveGift != null)
      {
        bool1 = bool2;
        if (paramGiveGift.jdField_b_of_type_Int + paramGiveGift.jdField_c_of_type_Int != 0) {}
      }
      else
      {
        if (!AnonymousChatHelper.a().a(a())) {
          break label122;
        }
      }
    }
    label122:
    for (paramInt = 2;; paramInt = 1)
    {
      paramGiveGift = this.jdField_a_of_type_AndroidContentContext.getResources();
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, paramGiveGift.getString(2131430738), paramGiveGift.getString(2131430739), paramGiveGift.getString(2131432998), paramGiveGift.getString(2131430740), new oxl(this, paramInt), new oxm(this)).show();
      e();
      bool1 = false;
      return bool1;
    }
  }
  
  public int b()
  {
    switch (this.e)
    {
    case 7: 
    default: 
      return this.e;
    case 6: 
      return 504;
    case 4: 
      if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof HotChatPie))
      {
        HotChatPie localHotChatPie = (HotChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if ((localHotChatPie.a != null) && (localHotChatPie.a.isBuLuoHotChat())) {
          return 507;
        }
        return 503;
      }
      return -1;
    case 5: 
      return 2;
    }
    return 508;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString + "?_bid=2204&_wvSb=1&from=7&troopUin=%s";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      str = String.format((String)localObject, new Object[] { str });
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("selfSet_leftViewText", "返回");
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("url", a(str));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2131034134, 0);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    a("1");
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_b_of_type_Int == 0))
    {
      a(0);
      if (this.e >= 4) {
        NearbyFlowerManager.a("gift_store", "exp_chose", a(), b() + "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList == null)) {
        this.jdField_b_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_b_of_type_Int, false);
      return;
      if (AnonymousChatHelper.a().a(a())) {}
      for (int i = 2;; i = 1)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      a(8);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(112);
    TroopGiftAioItemData localTroopGiftAioItemData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
    int k = localTroopGiftAioItemData.jdField_b_of_type_Int;
    if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {
      k = a();
    }
    int i = 0;
    int m = 0;
    int j;
    label100:
    int i1;
    String str;
    long l;
    int i2;
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      i = 6;
      j = m;
      if (!AnonymousChatHelper.a().a(a())) {
        break label300;
      }
      m = 2;
      i1 = this.e;
      str = a();
      l = Long.parseLong(paramString);
      i2 = localTroopGiftAioItemData.jdField_c_of_type_Int;
      if (localTroopGiftAioItemData.jdField_b_of_type_Int != 0) {
        break label306;
      }
    }
    label300:
    label306:
    for (int n = 1;; n = 0)
    {
      ((TroopGiftManager)localObject).a("OidbSvc.0x6b6", 1718, i, i1, str, 2, k, l, i2, n, localTroopGiftAioItemData.jdField_a_of_type_Int, j, new oxk(this, m, localTroopGiftAioItemData), localTroopGiftAioItemData.e);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = null;
      return;
      if (this.jdField_d_of_type_Int == 2)
      {
        i = 9;
        j = 1;
        break;
      }
      if (this.jdField_d_of_type_Int == 6)
      {
        i = 10;
        j = m;
        break;
      }
      j = m;
      if (this.jdField_d_of_type_Int != 7) {
        break;
      }
      i = 11;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        j = m;
        break;
      case 1000: 
        j = 512;
        break;
      case 1004: 
        j = 513;
        break;
        m = 1;
        break label100;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", "返回");
    localIntent.putExtra("url", a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_b_of_type_JavaLangString));
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2131034134, 2131034169);
    if (this.jdField_d_of_type_Int == 2)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_d_of_type_Int == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_d_of_type_Int == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_opr", 0, 0, "", "", "", "");
      return;
    }
    if (this.e >= 4)
    {
      NearbyFlowerManager.a("clk_oper", "clk_oper", a(), b() + "", "", "");
      return;
    }
    if (AnonymousChatHelper.a().a(a())) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_opr", i, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    Intent localIntent;
    if (this.jdField_d_of_type_Int == 6)
    {
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 16);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131430729));
      localIntent.setFlags(603979776);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
    }
    do
    {
      return;
      localIntent = TroopMemberListActivity.a(BaseApplication.getContext(), a(), 14);
      localIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(2131430729));
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        localIntent.putExtra("troop_gift_from", ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
      }
    } while (this.jdField_c_of_type_Boolean);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 12006);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    if (AnonymousChatHelper.a().a(a())) {}
    for (int i = 2; this.jdField_d_of_type_Int == 2; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_d_of_type_Int == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_d_of_type_Int == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_payremind", 0, 0, "", "", "", "");
      return;
    }
    if (this.e >= 4)
    {
      NearbyFlowerManager.a("gift_store", "exp_tip", a(), b() + "", "", "");
      return;
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_payremind", i, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j;
    if (AnonymousChatHelper.a().a(a())) {
      j = 2;
    }
    switch (paramView.getId())
    {
    case 2131364035: 
    default: 
    case 2131366682: 
    case 2131366681: 
    case 2131368326: 
    case 2131368327: 
      do
      {
        Object localObject1;
        for (;;)
        {
          return;
          j = 1;
          break;
          int i;
          Object localObject2;
          if (1 == this.jdField_b_of_type_Int) {
            if (this.e >= 4)
            {
              NearbyFlowerManager.a("gift_store", "clk_now", a(), b() + "", "", "");
              paramView = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              if ((paramView == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData == null)) {
                continue;
              }
              localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
              i = ((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int;
              if (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int == 0) {
                i = a();
              }
              localObject2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_AndroidUtilSparseArray;
              if (((TroopGiftAioItemData)localObject1).e == 0) {
                break label703;
              }
            }
          }
          for (int k = ((TroopGiftAioItemData)localObject1).e;; k = ((TroopGiftAioItemData)localObject1).jdField_a_of_type_Int)
          {
            if (a(i, (TroopGiftManager.GiveGift)((SparseArray)localObject2).get(k))) {
              break label713;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TroopGiftPanel", 2, "isStorageEnough: false");
            return;
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forall_send", j, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            break label156;
            if (this.jdField_b_of_type_Int != 0) {
              break label156;
            }
            if (this.jdField_d_of_type_Int == 2)
            {
              ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_send", 0, 0, "", "", "", "");
              break label156;
            }
            if (this.jdField_d_of_type_Int == 6)
            {
              ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_send", 0, 0, "", "", "", "");
              break label156;
            }
            if (this.jdField_d_of_type_Int == 7)
            {
              ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_send", 0, 0, "", "", "", "");
              break label156;
            }
            if (this.e >= 4)
            {
              NearbyFlowerManager.a("gift_store", "clk_send", a(), b() + "", "", "");
              break label156;
            }
            ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_forone_send", j, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
            ReportController.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_addpage", j, 0, a(), "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()), "", "");
            break label156;
          }
          if (1 == this.jdField_b_of_type_Int)
          {
            localObject2 = (TroopGiftManager)paramView.getManager(112);
            if (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Boolean)
            {
              int m = this.e;
              paramView = a();
              int n = ((TroopGiftAioItemData)localObject1).jdField_c_of_type_Int;
              if (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int == 0) {}
              for (k = 1;; k = 0)
              {
                ((TroopGiftManager)localObject2).a("OidbSvc.0x6b6", 1718, 8, m, paramView, 2, i, 0L, n, k, ((TroopGiftAioItemData)localObject1).jdField_a_of_type_Int, 0, new oxi(this, j, (TroopGiftAioItemData)localObject1), ((TroopGiftAioItemData)localObject1).e);
                if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
                return;
              }
            }
            if (this.jdField_a_of_type_Boolean)
            {
              j = 3;
              if (!this.jdField_a_of_type_Boolean) {
                break label912;
              }
              paramView = "OidbSvc.0x7f6";
              if (!this.jdField_a_of_type_Boolean) {
                break label919;
              }
            }
            for (k = 2038;; k = 1718)
            {
              ((TroopGiftManager)localObject2).a(paramView, k, j, this.e, a(), 2, i, 1, ((TroopGiftAioItemData)localObject1).jdField_a_of_type_Int, new oxj(this, (TroopGiftAioItemData)localObject1));
              break;
              j = 1;
              break label846;
              paramView = "OidbSvc.0x6b6";
              break label857;
            }
          }
          if (this.jdField_b_of_type_Int == 0)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
              b(this.jdField_c_of_type_JavaLangString);
              return;
            }
            if ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 7)) {
              break label1020;
            }
            b(((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          while (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
          {
            ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aH();
            return;
            d();
          }
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_c_of_type_JavaLangString + "?_bid=2204&_wvSb=1&from=7&troopUin=%s";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) {
            break label1252;
          }
        }
        for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
        {
          paramView = String.format((String)localObject1, new Object[] { paramView });
          localObject1 = new Intent(a(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("selfSet_leftViewText", "返回");
          ((Intent)localObject1).putExtra("hide_more_button", true);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("url", a(paramView));
          a().startActivityForResult((Intent)localObject1, 12007);
          a().overridePendingTransition(2131034134, 2131034169);
          if (this.jdField_d_of_type_Int != 2) {
            break;
          }
          ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_d_of_type_Int == 6)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_d_of_type_Int == 7)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_pay", 0, 0, "", "", "", "");
          return;
        }
        if (this.e >= 4)
        {
          NearbyFlowerManager.a("gift_store", "clk_pay", a(), b() + "", "", "");
          return;
        }
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_pay", j, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        return;
      } while ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.jdField_b_of_type_JavaLangString)));
      c();
      return;
    case 2131366683: 
    case 2131368332: 
      label156:
      label703:
      label713:
      label846:
      label857:
      label1020:
      new TroopGiftPanel.GiftNumInputDialog(this, a()).a();
      label912:
      label919:
      label1252:
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
      }
      try
      {
        for (;;)
        {
          Settings.System.putInt(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "accelerometer_rotation", 0);
          if (this.e < 4) {
            break;
          }
          NearbyFlowerManager.a("gift_store", "clk_chose", a(), b() + "", "", "");
          return;
          ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).aH();
        }
      }
      catch (SecurityException paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopGiftPanel", 2, "SecurityException ");
          }
        }
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_num", j, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        return;
      }
    }
    d();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof GridListAdapter.Holder))
    {
      paramView = ((GridListAdapter.Holder)paramView.getTag()).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      if ((!paramView.jdField_a_of_type_Boolean) && ((paramAdapterView.getAdapter() instanceof GridListAdapter)))
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = paramView;
        paramView.jdField_a_of_type_Boolean = true;
        if (this.jdField_b_of_type_Int != 0) {
          break label200;
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.size())) {
          ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int)).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int = paramView.g;
        this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].a();
      }
    }
    while (paramView.jdField_b_of_type_Int == 0)
    {
      a(0);
      if (this.e >= 4)
      {
        NearbyFlowerManager.a("gift_store", "exp_chose", a(), b() + "", "", "");
        return;
        label200:
        if (this.jdField_b_of_type_Int == 1)
        {
          if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int < this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size())) {
            ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int = paramView.g;
          this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].a();
        }
      }
      else
      {
        if (AnonymousChatHelper.a().a(a())) {}
        for (paramInt = 2;; paramInt = 1)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
      }
    }
    a(8);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[paramInt1].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftRadioViewPager[paramInt2].setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt2]);
    Object localObject;
    if ((paramInt2 == 0) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int != -1)) {
      localObject = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_c_of_type_Int);
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((TroopGiftAioItemData)localObject).jdField_b_of_type_Int != 0) {
          break label374;
        }
        a(0);
        if (this.e >= 4) {
          NearbyFlowerManager.a("gift_store", "exp_chose", a(), b() + "", "", "");
        }
      }
      else
      {
        label148:
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)localObject);
        if (!AnonymousChatHelper.a().a(a())) {
          break label383;
        }
        paramInt1 = 2;
      }
      for (;;)
      {
        if (paramInt2 == 0)
        {
          if (this.e >= 4)
          {
            NearbyFlowerManager.a("gift_store", "exp_one", a(), b() + "", "", "");
            return;
            if ((paramInt2 != 1) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int == -1)) {
              break label665;
            }
            localObject = (TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int);
            break;
            if (AnonymousChatHelper.a().a(a())) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", paramInt1, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
              break;
            }
            label374:
            a(8);
            break label148;
            label383:
            paramInt1 = 1;
            continue;
          }
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", paramInt1, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
          return;
        }
      }
      if (this.e >= 4)
      {
        NearbyFlowerManager.a("gift_store", "exp_all", a(), b() + "", "", "");
        ((TroopGiftManager)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(112)).a(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(false, false);
        return;
      }
      String str = a();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a()) {}
      for (localObject = "1";; localObject = "0")
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forall", paramInt1, 0, str, (String)localObject, this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
        break;
      }
      label665:
      localObject = null;
    }
  }
  
  public void setGiftData(TroopGiftAioPanelData paramTroopGiftAioPanelData, boolean paramBoolean)
  {
    if (paramTroopGiftAioPanelData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = paramTroopGiftAioPanelData;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString))
    {
      paramTroopGiftAioPanelData = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].setGridGiftIcon(paramTroopGiftAioPanelData);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setGridGiftIcon(paramTroopGiftAioPanelData);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_Int;
      ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setVisibility(0);
      ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).getParent()).setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(false, false);
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Boolean) && (l1 >= this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Long) && (l1 <= l2 + 2592000000L) && (!((TroopGiftManager)((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(112)).a())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(true, false);
      }
      a(new oxh(this, paramBoolean));
      return;
      this.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[1].setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).getParent()).setVisibility(8);
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Int == 2) {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "half_mall_exp", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (this.jdField_d_of_type_Int == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_d_of_type_Int == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "half_mall_exp", 0, 0, "", "", "", "");
      return;
    }
    if (this.e >= 4)
    {
      NearbyFlowerManager.a("gift_store", "exp_one", a(), b() + "", "", "");
      return;
    }
    if (AnonymousChatHelper.a().a(a())) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_forone", i, 0, a(), "", this.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), a()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel
 * JD-Core Version:    0.7.0.1
 */