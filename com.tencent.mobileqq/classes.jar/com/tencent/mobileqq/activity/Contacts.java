package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contacts.base.ContactsViewController;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.Map;
import mqq.os.MqqHandler;
import sct;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, CommonLoadingView.OnFirstDrawListener, NewFriendManager.INewFriendListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactsViewController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new sct(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private RedDotTextView jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView c;
  private TextView d;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.c == null) {
      return;
    }
    Object localObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    if (QLog.isColorLevel()) {
      QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", fromResume = " + paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i;
    if (paramInt == 0)
    {
      localObject = ((NewFriendManager)localObject).a();
      if ((localObject != null) && (((NewFriendMessage)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (paramBoolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(a().getString(2131433298)).append(" 有更新");
        i = 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      CustomWidgetUtil.a(this.c, i, paramInt, 0);
      if ((paramInt <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.e();
      return;
      localStringBuilder.append(a().getString(2131427445));
      do
      {
        i = 0;
        break;
      } while (paramInt <= 0);
      if (paramBoolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
      }
      i = 3;
      localStringBuilder.append(a().getString(2131433298)).append(" ");
      if (paramInt > 99) {
        localStringBuilder.append("多于99条未读");
      } else {
        localStringBuilder.append(paramInt).append("条未读");
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)DisplayUtils.a(a(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(this.jdField_a_of_type_Int);
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363786));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363810));
    P_();
    o();
  }
  
  private void o()
  {
    View localView1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363812);
    View localView2 = localView1.findViewById(2131369890);
    localView2.findViewById(2131368254).setVisibility(8);
    IphoneTitleBarActivity.setLayerType(localView2);
    EditText localEditText = (EditText)localView2.findViewById(2131368255);
    this.d = ((TextView)localView2.findViewById(2131368668));
    localView2 = localView2.findViewById(2131371103);
    localView2.setOnClickListener(this);
    if (SearchConfigManager.a()) {
      localView2.setVisibility(0);
    }
    for (;;)
    {
      localEditText.setFocusableInTouchMode(false);
      localEditText.setCursorVisible(false);
      localEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131363897);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363887));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = localView1.findViewById(2131363898);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      localView2.setVisibility(8);
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131363808));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362844));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363803));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363410));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription("添加");
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131434338);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a(21).e(10).a();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363363));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363361));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363802));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(-1);
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845743);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494205));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(a().getColorStateList(2131494205));
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(this);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).b(this);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  public void O_() {}
  
  void P_()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.h();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mThemeBackgroundView == null");
      }
    }
    label233:
    label236:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if (ThemeUtil.isNowThemeIsDIY()) {
        if ((this.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof ThemeBackground))
        {
          localObject = (ThemeBackground)this.jdField_a_of_type_AndroidWidgetImageView.getTag();
          ThemeBackground.getThemeBackground(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (ThemeBackground)localObject);
          if (("null".equals(((ThemeBackground)localObject).path)) || (((ThemeBackground)localObject).img == null)) {
            break label233;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ThemeBackground)localObject).img);
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          break label236;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838211);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
        return;
        localObject = new ThemeBackground();
        break;
        if (ThemeUtil.isNowThemeIsAnimate())
        {
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.a().getDrawable(2130845679);
          localObject = VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "-conversation-", localDrawable, VasApngUtil.a, "-contacts-", null);
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
            i = 0;
            j = 1;
            continue;
          }
        }
        i = 0;
      }
    }
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2130968803, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController = new ContactsViewController(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected String a()
  {
    return a().getString(2131433254);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      q();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    }
    else
    {
      return;
    }
    P_();
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).b();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        w();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
    }
    while ((paramInt1 != 1000000) || (paramInt2 != -1)) {
      return;
    }
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b(paramBoolean);
    a(((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).d(), true);
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131433254);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131433254));
    }
    this.d.setText(SearchEntryConfigManager.b());
    s();
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.i();
    }
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  protected void e()
  {
    super.e();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.f();
  }
  
  protected void f()
  {
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.d();
    }
  }
  
  protected void g()
  {
    super.g();
    n();
    q();
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public void i()
  {
    ApngImage.pauseByTag(3);
    super.i();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b();
  }
  
  protected void k()
  {
    super.k();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    r();
  }
  
  public void l()
  {
    P_();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(-1);
    }
    for (;;)
    {
      BuddyListItem.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845743);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494205));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(a().getColorStateList(2131494205));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
    case 2131368255: 
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Tab.Contacts", 2, "onClick() time stamp = " + (l - this.jdField_a_of_type_Long));
        }
      } while (l - this.jdField_a_of_type_Long <= 1500L);
      this.jdField_a_of_type_Long = l;
      FrameHelperActivity.b(false);
      UniteSearchActivity.a(a(), null, 2, 2);
      return;
    case 2131363410: 
      paramView = new Intent(a(), AddContactsActivity.class);
      paramView.putExtra("entrence_data_report", 1);
      paramView.putExtra("EntranceId", 3);
      a(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(101200));
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    case 2131363897: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F18", "0X8007F18", 0, 0, "", "", "", "");
      paramView = new Intent(a(), NewFriendActivity.class);
      paramView.putExtra("EntranceId", 2);
      paramView.setFlags(67108864);
      a(paramView);
      return;
    case 2131363898: 
      paramView = new Intent(a(), NewTroopCreateActivity.class);
      paramView.putExtra("param_default_tab", 1);
      paramView.putExtra("param_exit_animation", 1);
      paramView.setFlags(603979776);
      paramView.putExtra("create_source", 1);
      a().startActivity(paramView);
      a().overridePendingTransition(2131034363, 2131034363);
      return;
    }
    VADActivity.a(a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Contacts
 * JD-Core Version:    0.7.0.1
 */