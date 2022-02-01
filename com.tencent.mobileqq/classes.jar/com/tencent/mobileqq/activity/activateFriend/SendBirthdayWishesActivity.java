package com.tencent.mobileqq.activity.activateFriend;

import Override;
import agdd;
import agde;
import agej;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
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
import aold;
import aole;
import asmr;
import asmu;
import assp;
import bdll;
import begz;
import behh;
import bhjx;
import bhlg;
import bhnv;
import bjbs;
import blrn;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SendBirthdayWishesActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, asmr, blrn
{
  int jdField_a_of_type_Int = 1;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aold jdField_a_of_type_Aold;
  aole jdField_a_of_type_Aole = new agde(this);
  bjbs jdField_a_of_type_Bjbs;
  ActivateFriendGrid jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  public XPanelContainer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SendBirthdayWishesActivity.3(this);
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
      paramInt = 2131689788;
      i = 2;
    }
    for (;;)
    {
      QQToast.a(this, i, paramInt, 1).b(getTitleBarHeight());
      return;
      label43:
      paramInt = 2131689786;
      break;
      label49:
      if (paramInt == 1)
      {
        paramInt = 2131689805;
      }
      else if (paramInt == 2)
      {
        paramInt = 2131689800;
        i = 1;
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  private void f()
  {
    setRightHighlightButton(2131690580, new agdd(this));
    Object localObject1 = "";
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_ArrayOfLong.length == 1) {
        localObject1 = getString(2131689803);
      }
    }
    for (;;)
    {
      setTitle((CharSequence)localObject1);
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368725));
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(begz.a);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131376925));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
      try
      {
        localObject1 = getResources().getDrawable(2130839099);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365923));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367328));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131369042);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = getResources().getDrawable(2130849992);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = getResources().getDrawable(2130849991);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject1);
        boolean bool = ((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
        localObject1 = findViewById(2131368726);
        if (bool)
        {
          localObject2 = ((View)localObject1).findViewById(2131377779);
          ((View)localObject2).setBackgroundResource(2130839109);
          ((View)localObject2).setVisibility(0);
          ((View)localObject1).getBackground().setVisible(false, false);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377340));
          localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
          if (this.jdField_a_of_type_Int != 1) {
            break label588;
          }
          i = 2131689807;
          ((TextView)localObject1).setText(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131166963));
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)findViewById(2131367231));
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setCheckAbilityEnable(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setSkinable(true);
          localObject1 = findViewById(2131367285);
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
              ((StringBuilder)localObject2).append(bhlg.j(this.app, String.valueOf(l))).append(",");
              i += 1;
              continue;
              localObject1 = getString(2131689804);
              break;
              if (this.jdField_a_of_type_Int == 3) {
                break;
              }
              localObject1 = getString(2131689802);
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
          localDrawable = getResources().getDrawable(2130850038);
          continue;
          localDrawable.getBackground().setVisible(true, false);
          localDrawable.findViewById(2131377779).setVisibility(8);
          continue;
          label588:
          int i = 2131689806;
        }
        localDrawable.setContentDescription(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void g()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 1) {
      localObject = String.format(getString(2131689801), new Object[] { getIntent().getStringExtra("key_roam_city") });
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
        localObject = aold.a(this);
      }
      catch (Exception localException)
      {
        str = getString(2131689794);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, str);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 2)
    {
      SystemEmoticonPanel localSystemEmoticonPanel = new SystemEmoticonPanel(this, this);
      View localView = localSystemEmoticonPanel.findViewById(2131376062);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = agej.a(15.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      localSystemEmoticonPanel.setBackgroundResource(2130844159);
      return localSystemEmoticonPanel;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bjbs.c(2131689527);
    this.jdField_a_of_type_Bjbs.show();
    this.jdField_a_of_type_Bjbs.setCancelable(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new SendBirthdayWishesActivity.4(this, paramInt2));
  }
  
  public void a(asmu paramasmu)
  {
    if ((paramasmu instanceof assp))
    {
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, behh.b(((assp)paramasmu).jdField_a_of_type_Int));
      }
    }
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(asmu paramasmu)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      bdll.b(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
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
        int j = TextUtils.getOffsetBefore(this.jdField_a_of_type_AndroidWidgetEditText.getText(), i);
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
  
  public void b(asmu paramasmu) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561032);
    getWindow().setBackgroundDrawable(null);
    getWindow().setSoftInputMode(20);
    this.jdField_a_of_type_Aold = ((aold)this.app.getManager(85));
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
    f();
    g();
    this.app.registObserver(this.jdField_a_of_type_Aole);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_a_of_type_Aole);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    super.doOnDestroy();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771978);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    }
    bdll.b(this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton) {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      continue;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        if (str.length() != 0) {
          if (!bhnv.d(this))
          {
            QQToast.a(this, 2131693965, 0).b(getTitleBarHeight());
          }
          else
          {
            ArrayList localArrayList = bhjx.a(str, 560, 20, null, new ArrayList());
            if ((QLog.isColorLevel()) && (localArrayList.size() > 1)) {
              QLog.d("ActivateFriend.SendActivity", 2, "onclick | bytes = " + str.getBytes().length + " | partArray.size = " + localArrayList.size());
            }
            if (localArrayList.size() > 1)
            {
              QQToast.a(this, 2131717895, 0).b(getTitleBarHeight());
            }
            else
            {
              this.jdField_a_of_type_Aold.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.b, str);
              bdll.b(this.app, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, this.jdField_a_of_type_ArrayOfLong.length + "", "", "", "");
              bdll.b(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.jdField_a_of_type_ArrayOfLong.length, 0, "", "", "", "");
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
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void s() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity
 * JD-Core Version:    0.7.0.1
 */