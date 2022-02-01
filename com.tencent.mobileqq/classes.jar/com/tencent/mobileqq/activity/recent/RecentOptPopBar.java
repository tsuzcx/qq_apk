package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.extendfriend.limitchat.LimitChatUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.qlink.QQProxyForQlink;
import dov.com.qq.im.QIMShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class RecentOptPopBar
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131691344, 2130839657 };
  private static final int[] c;
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131691346, 2130839662 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131691355, 2130839661 };
  private static final int[] jdField_f_of_type_ArrayOfInt = { 2131691353, 2130839669 };
  private static final int[] jdField_g_of_type_ArrayOfInt = { 2131691347, 2130839663 };
  private static final int[] jdField_h_of_type_ArrayOfInt = { 2131691351, 2130839668 };
  private static final int[] jdField_i_of_type_ArrayOfInt = { 2131691350, 2130839667 };
  private static final int[] j = { 2131699137, 2130839670 };
  private static final int[] k = { 2131691349, 2130839665 };
  private static final int[] l = { 2131691345, 2130839658 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private String jdField_a_of_type_JavaLangString = "";
  private List<PopupMenuDialog.MenuItem> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  public boolean c;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean jdField_i_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691354, 2130839671 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131691348, 2130839643 };
  }
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131690778));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131690778));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    paramBaseActivity = new Bundle();
    paramBaseActivity.putLong("PromotionType", paramLong1);
    paramBaseActivity.putLong("RecoglizeMask", paramLong2);
    paramBaseActivity.putString("H5Source", String.valueOf(paramInt));
    localIntent.putExtra("web_invoke_params", paramBaseActivity);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.getActivity() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.getActivity();
      if (!paramIntent.getBooleanExtra("open_leba_tab_fragment", false)) {
        break label42;
      }
      paramFrameHelperActivity.openMainFragment(paramIntent);
    }
    label42:
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    RecentUtil.a(paramFrameHelperActivity, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramBaseActivity)) {
      return;
    }
    paramBaseActivity.startActivity(a(paramBaseActivity, paramLong1, paramLong2, paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_c_of_type_Boolean = paramBoolean;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = paramBoolean;
        Object localObject2 = (ViewGroup)this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getParent();
        Object localObject1 = (TextView)((ViewGroup)localObject2).findViewById(2131379262);
        if ((localObject1 != null) && ((localObject2 instanceof LinearLayout)))
        {
          this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.removeView(this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a());
          ((ViewGroup)localObject2).removeAllViews();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131298899));
          RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getContext());
          ((ViewGroup)localObject2).addView(localRelativeLayout, localLayoutParams);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getResources()), AIOUtils.a(24.0F, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getResources()));
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          localRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a(), (ViewGroup.LayoutParams)localObject2);
          localObject2 = new RelativeLayout.LayoutParams(((TextView)localObject1).getLayoutParams());
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a().getId());
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(15.0F, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a().getResources());
          localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a().getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a().getId());
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(-5.0F, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getResources());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(-5.0F, this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getResources());
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.getContext());
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850164);
          localRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("RecentOptPopBar", 1, "parseRedBagTouch, ", localException);
    }
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, HardCodeUtil.a(2131713158), 0).a();
      return false;
    }
    return true;
  }
  
  private boolean c()
  {
    boolean bool = false;
    String str = IliveDbManager.getIliveDrawerData("drawer_plus_text");
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(str))) {}
    for (int m = 1;; m = 0)
    {
      if ((IliveEntranceUtil.c() != this.jdField_f_of_type_Boolean) || (m != 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void m()
  {
    boolean bool = IliveEntranceUtil.c();
    this.jdField_f_of_type_Boolean = bool;
    if (bool)
    {
      PopupMenuDialog.MenuItem localMenuItem = a(j);
      String str2 = IliveDbManager.getIliveDrawerData("drawer_plus_text");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699137);
      }
      localMenuItem.jdField_a_of_type_JavaLangString = str1;
      this.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilList.add(localMenuItem);
    }
  }
  
  private void n()
  {
    IliveEntranceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "add");
  }
  
  private void o()
  {
    if (((this.jdField_h_of_type_Boolean) && (!QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_h_of_type_Boolean) && (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
    }
    if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165601));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839663);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131167033));
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839664);
  }
  
  private void p()
  {
    boolean bool = false;
    Object localObject1;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch == null))
    {
      localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131365294);
      m = 0;
    }
    for (;;)
    {
      if (m < ((LinearLayout)localObject1).getChildCount())
      {
        try
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(m);
          if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691344)
          {
            localObject2 = (TextView)((View)localObject2).findViewById(2131379262);
            this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).b(21).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131691355)
          {
            localObject2 = ((View)localObject2).findViewById(2131368992);
            this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).b(53).a();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (((PopupMenuDialog.MenuItem)localException.getTag()).jdField_a_of_type_Int == 2131691347)
        {
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localException.findViewById(2131379262));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localException.findViewById(2131368992));
          if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165601));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839663);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131167033));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839664);
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
        {
          localObject1 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("101210.101211");
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
        {
          if (!RedBagVideoManager.a(RedBagVideoManager.g)) {
            bool = true;
          }
          this.jdField_d_of_type_Boolean = bool;
          if (this.jdField_d_of_type_Boolean != this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_g_of_type_Boolean) {
            a(this.jdField_d_of_type_Boolean);
          }
        }
        return;
      }
      m += 1;
    }
  }
  
  public PopupMenuDialog.MenuItem a(int[] paramArrayOfInt)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramArrayOfInt[0];
    localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.b = paramArrayOfInt[1];
    return localMenuItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_f_of_type_ArrayOfInt));
    this.jdField_a_of_type_JavaUtilList.add(a(jdField_b_of_type_ArrayOfInt));
    Object localObject;
    if (LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      this.jdField_e_of_type_Boolean = true;
      localObject = a(k);
      this.jdField_a_of_type_JavaLangString = LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((PopupMenuDialog.MenuItem)localObject).c = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if (!AvGameEntranceUtil.a()) {
        break label383;
      }
      this.jdField_a_of_type_JavaUtilList.add(a(l));
    }
    label383:
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_a_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_c_of_type_ArrayOfInt));
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_d_of_type_ArrayOfInt));
      localObject = MiniAppConfProcessor.a();
      if ((localObject != null) && (((MiniAppConfBean)localObject).c())) {
        this.jdField_a_of_type_JavaUtilList.add(a(jdField_i_of_type_ArrayOfInt));
      }
      this.jdField_h_of_type_Boolean = false;
      if ((QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (b()))
      {
        this.jdField_a_of_type_JavaUtilList.add(a(jdField_g_of_type_ArrayOfInt));
        this.jdField_h_of_type_Boolean = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
      }
      m();
      if (AudioHelper.d()) {
        PstnCardTestActivity.addDebugMenu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, new RecentOptPopBar.1(this), new RecentOptPopBar.2(this));
      return;
      this.jdField_e_of_type_Boolean = false;
      break;
    }
  }
  
  protected void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l1));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
      p();
      QIMShortVideoUtils.a(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
      if (this.jdField_e_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
      }
      return;
      if (this.jdField_e_of_type_Boolean)
      {
        String str = LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        if ((str != null) && (this.jdField_a_of_type_JavaLangString != null) && (!str.equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (c()) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_e_of_type_Boolean) && (!LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_e_of_type_Boolean) && (LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_g_of_type_Boolean) && (!AvGameEntranceUtil.a())) || ((!this.jdField_g_of_type_Boolean) && (AvGameEntranceUtil.a()))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (b()) {
        o();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).getLong(paramString, 0L) != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).getBoolean(paramString, true);
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 0);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  protected void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690778));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690778));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void e() {}
  
  protected void f()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "/qwallet/redpacket/QrcodeHbGuider");
    localActivityURIRequest.extra().putLong("vacreport_key_seq", l1);
    localActivityURIRequest.extra().putString("appInfo", "");
    QRoute.startUri(localActivityURIRequest, new RecentOptPopBar.3(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("create_source", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771999, 2130772003);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void i()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      ExtendFriendLabelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1);
      ExtendFriendReport.a().b(4);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  protected void l()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVGameRoomCenterFragment.class);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar
 * JD-Core Version:    0.7.0.1
 */