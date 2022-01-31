package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import ujf;
import ujg;
import ujh;
import uji;

public class SendBirthdayWishesActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, XPanelContainer.PanelCallback
{
  int jdField_a_of_type_Int = 1;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageButton a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ActivateFriendGrid jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new ujg(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public XPanelContainer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ujh(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong;
  long[] b;
  
  private void a(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Int == 2)
    {
      if (paramInt != 0) {
        break label49;
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label43;
      }
      paramInt = 2131437269;
      i = 2;
    }
    for (;;)
    {
      QQToast.a(this, i, paramInt, 1).b(getTitleBarHeight());
      return;
      label43:
      paramInt = 2131437268;
      break;
      label49:
      if (paramInt == 1)
      {
        paramInt = 2131437270;
      }
      else if (paramInt == 2)
      {
        paramInt = 2131437271;
        i = 1;
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  private void e()
  {
    setRightHighlightButton(2131433015, new ujf(this));
    Object localObject1 = "";
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_ArrayOfLong.length == 1) {
        localObject1 = getString(2131437236);
      }
    }
    for (;;)
    {
      setTitle((CharSequence)localObject1);
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131363497));
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131362840));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
      try
      {
        localObject1 = getResources().getDrawable(2130838343);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364075));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363499));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131363245);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = getResources().getDrawable(2130845782);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = getResources().getDrawable(2130845781);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject1);
        boolean bool = ((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
        localObject1 = findViewById(2131363494);
        if (bool)
        {
          localObject2 = ((View)localObject1).findViewById(2131363495);
          ((View)localObject2).setBackgroundResource(2130838353);
          ((View)localObject2).setVisibility(0);
          ((View)localObject1).getBackground().setVisible(false, false);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369419));
          localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (this.jdField_a_of_type_Int != 1) {
            break label588;
          }
          i = 2131437263;
          ((TextView)localObject1).setText(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131494206));
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)findViewById(2131369405));
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setCheckAbilityEnable(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setSkinable(true);
          localObject1 = findViewById(2131369418);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
          long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          int j = arrayOfLong.length;
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              long l = arrayOfLong[i];
              ((StringBuilder)localObject2).append(ContactUtils.l(this.app, String.valueOf(l))).append(",");
              i += 1;
              continue;
              localObject1 = getString(2131437237);
              break;
              if (this.jdField_a_of_type_Int == 3) {
                break;
              }
              localObject1 = getString(2131437238);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Drawable localDrawable;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          localDrawable = getResources().getDrawable(2130845819);
          continue;
          localDrawable.getBackground().setVisible(true, false);
          localDrawable.findViewById(2131363495).setVisibility(8);
          continue;
          label588:
          int i = 2131437264;
        }
        localDrawable.setContentDescription(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void f()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 1) {
      localObject = String.format(getString(2131437272), new Object[] { getIntent().getStringExtra("key_roam_city") });
    }
    String str;
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject).length());
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      localObject = new ArrayList(this.jdField_a_of_type_ArrayOfLong.length);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        ActivateFriendItem localActivateFriendItem = new ActivateFriendItem(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong[i]);
        if (this.jdField_a_of_type_Int == 2) {
          localActivateFriendItem.birthSendTime = this.b[i];
        }
        ((ArrayList)localObject).add(localActivateFriendItem);
        i += 1;
      }
      try
      {
        localObject = ActivateFriendsManager.a(this);
      }
      catch (Exception localException)
      {
        str = getString(2131437273);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, str);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 2)
    {
      SystemEmoticonPanel localSystemEmoticonPanel = new SystemEmoticonPanel(this, this);
      View localView = localSystemEmoticonPanel.findViewById(2131364569);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = AIOUtils.a(15.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      localSystemEmoticonPanel.setBackgroundResource(2130841540);
      return localSystemEmoticonPanel;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131437255);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new uji(this, paramInt2));
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.c(((SystemEmoticonInfo)paramEmoticonInfo).jdField_a_of_type_Int));
      }
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
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
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int j = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970177);
    getWindow().setBackgroundDrawable(null);
    getWindow().setSoftInputMode(20);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(84));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_msg_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfLong = getIntent().getLongArrayExtra("key_friend_list");
    this.b = getIntent().getLongArrayExtra("key_time_list");
    if ((this.jdField_a_of_type_ArrayOfLong == null) || (this.jdField_a_of_type_ArrayOfLong.length == 0) || ((this.jdField_a_of_type_Int == 2) && ((this.b == null) || (this.jdField_a_of_type_ArrayOfLong.length != this.b.length))))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder().append("intent data is invaild, msgType = ").append(this.jdField_a_of_type_Int).append(" | uin count = ");
        if (this.jdField_a_of_type_ArrayOfLong == null) {
          break label231;
        }
      }
      label231:
      for (int i = this.jdField_a_of_type_ArrayOfLong.length;; i = -1)
      {
        paramBundle = paramBundle.append(i).append(" | time count = ");
        i = j;
        if (this.b != null) {
          i = this.b.length;
        }
        QLog.d("ActivateFriend.SendActivity", 2, i);
        finish();
        return false;
      }
    }
    e();
    f();
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034122);
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
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton) {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break;
        }
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      } while (paramView.length() == 0);
      if (!NetworkUtil.d(this))
      {
        QQToast.a(this, 2131434811, 0).b(getTitleBarHeight());
        return;
      }
      ArrayList localArrayList = Utils.a(paramView, 560, 20, null, new ArrayList());
      if ((QLog.isColorLevel()) && (localArrayList.size() > 1)) {
        QLog.d("ActivateFriend.SendActivity", 2, "onclick | bytes = " + paramView.getBytes().length + " | partArray.size = " + localArrayList.size());
      }
      if (localArrayList.size() > 1)
      {
        QQToast.a(this, 2131433378, 0).b(getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.b, paramView);
      ReportController.b(this.app, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, this.jdField_a_of_type_ArrayOfLong.length + "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.jdField_a_of_type_ArrayOfLong.length, 0, "", "", "", "");
      a();
      return;
    } while (paramView != this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    finish();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void q() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity
 * JD-Core Version:    0.7.0.1
 */