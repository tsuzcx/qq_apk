package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SendBirthdayWishesActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, XPanelContainer.PanelCallback
{
  int jdField_a_of_type_Int = 1;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ActivateFriendGrid jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new SendBirthdayWishesActivity.2(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SendBirthdayWishesActivity.3(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong;
  long[] b;
  
  private void a(int paramInt)
  {
    int j = this.jdField_a_of_type_Int;
    if (j == 2)
    {
      int i = 0;
      if (paramInt == 0)
      {
        if (j == 1) {
          paramInt = 2131689768;
        } else {
          paramInt = 2131689766;
        }
        i = 2;
      }
      else if (paramInt == 1)
      {
        paramInt = 2131689785;
      }
      else if (paramInt == 2)
      {
        paramInt = 2131689780;
        i = 1;
      }
      else
      {
        paramInt = 0;
      }
      QQToast.a(this, i, paramInt, 1).b(getTitleBarHeight());
    }
  }
  
  private void c()
  {
    setRightHighlightButton(2131690728, new SendBirthdayWishesActivity.1(this));
    int i = this.jdField_a_of_type_Int;
    Object localObject1;
    if (i == 1)
    {
      if (this.jdField_a_of_type_ArrayOfLong.length == 1) {
        i = 2131689783;
      } else {
        i = 2131689784;
      }
      localObject1 = getString(i);
    }
    else if (i == 3)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = getString(2131689782);
    }
    setTitle((CharSequence)localObject1);
    enableRightHighlight(true);
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368874));
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131376809));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
    try
    {
      localObject1 = getResources().getDrawable(2130839075);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
      localObject2 = getResources().getDrawable(2130850373);
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable((Drawable)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366114));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367417));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369202);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Object localObject2 = new StateListDrawable();
    int j = 0;
    Object localObject3 = getResources().getDrawable(2130850327);
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
    localObject3 = getResources().getDrawable(2130850326);
    ((StateListDrawable)localObject2).addState(new int[0], (Drawable)localObject3);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
    boolean bool = ((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
    localObject2 = findViewById(2131368875);
    if (bool)
    {
      localObject3 = ((View)localObject2).findViewById(2131377646);
      ((View)localObject3).setBackgroundResource(2130839086);
      ((View)localObject3).setVisibility(0);
      ((View)localObject2).getBackground().setVisible(false, false);
    }
    else
    {
      ((View)localObject2).getBackground().setVisible(true, false);
      ((View)localObject2).findViewById(2131377646).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377227));
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Int == 1) {
      i = 2131689787;
    } else {
      i = 2131689786;
    }
    ((TextView)localObject2).setText(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131167027));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)findViewById(2131367320));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setCheckAbilityEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setSkinable(true);
    localObject2 = findViewById(2131367377);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    int k = arrayOfLong.length;
    i = j;
    while (i < k)
    {
      long l = arrayOfLong[i];
      ((StringBuilder)localObject3).append(ContactUtils.d(this.app, String.valueOf(l)));
      ((StringBuilder)localObject3).append(",");
      i += 1;
    }
    ((View)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
  }
  
  private void d()
  {
    int j = this.jdField_a_of_type_Int;
    int i = 0;
    if (j == 1) {
      localObject1 = String.format(getString(2131689781), new Object[] { getIntent().getStringExtra("key_roam_city") });
    }
    try
    {
      localObject1 = ActivateFriendsManager.a(this);
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    Object localObject1 = getString(2131689774);
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    localObject1 = new ArrayList(this.jdField_a_of_type_ArrayOfLong.length);
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ArrayOfLong;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = new ActivateFriendItem(this.jdField_a_of_type_Int, localObject2[i]);
      if (this.jdField_a_of_type_Int == 2) {
        ((ActivateFriendItem)localObject2).birthSendTime = this.b[i];
      }
      ((ArrayList)localObject1).add(localObject2);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, (ArrayList)localObject1);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 2)
    {
      SystemEmoticonPanel localSystemEmoticonPanel = new SystemEmoticonPanel(this, this);
      View localView = localSystemEmoticonPanel.findViewById(2131375962);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = AIOUtils.b(15.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      localSystemEmoticonPanel.setBackgroundResource(2130844193);
      return localSystemEmoticonPanel;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131689560);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new SendBirthdayWishesActivity.4(this, paramInt2));
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      int j = android.text.TextUtils.getOffsetBefore(this.jdField_a_of_type_AndroidWidgetEditText.getText(), i);
      if (i != j)
      {
        localEditable.delete(Math.min(i, j), Math.max(i, j));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560913);
    getWindow().setBackgroundDrawable(null);
    getWindow().setSoftInputMode(20);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_msg_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfLong = getIntent().getLongArrayExtra("key_friend_list");
    this.b = getIntent().getLongArrayExtra("key_time_list");
    paramBundle = this.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong;
    if ((paramBundle != null) && (paramBundle.length != 0)) {
      if (this.jdField_a_of_type_Int == 2)
      {
        arrayOfLong = this.b;
        if ((arrayOfLong == null) || (paramBundle.length != arrayOfLong.length)) {}
      }
      else
      {
        c();
        d();
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("intent data is invaild, msgType = ");
      paramBundle.append(this.jdField_a_of_type_Int);
      paramBundle.append(" | uin count = ");
      arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      int j = -1;
      if (arrayOfLong != null) {
        i = arrayOfLong.length;
      } else {
        i = -1;
      }
      paramBundle.append(i);
      paramBundle.append(" | time count = ");
      arrayOfLong = this.b;
      int i = j;
      if (arrayOfLong != null) {
        i = arrayOfLong.length;
      }
      paramBundle.append(i);
      QLog.d("ActivateFriend.SendActivity", 2, paramBundle.toString());
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    super.doOnDestroy();
  }
  
  public void emoticonMall() {}
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771992);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      } else {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (((String)localObject1).length() != 0) {
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
        }
        else
        {
          Object localObject2 = BusinessUtils.a((String)localObject1, 560, 20, null, new ArrayList());
          if ((QLog.isColorLevel()) && (((ArrayList)localObject2).size() > 1))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onclick | bytes = ");
            localStringBuilder.append(((String)localObject1).getBytes().length);
            localStringBuilder.append(" | partArray.size = ");
            localStringBuilder.append(((ArrayList)localObject2).size());
            QLog.d("ActivateFriend.SendActivity", 2, localStringBuilder.toString());
          }
          if (((ArrayList)localObject2).size() > 1)
          {
            QQToast.a(this, 2131718759, 0).b(getTitleBarHeight());
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.b, (String)localObject1);
            localObject1 = this.app;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfLong.length);
            ((StringBuilder)localObject2).append("");
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
            ReportController.b(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.jdField_a_of_type_ArrayOfLong.length, 0, "", "", "", "");
            a();
          }
        }
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void s()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
  }
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity
 * JD-Core Version:    0.7.0.1
 */