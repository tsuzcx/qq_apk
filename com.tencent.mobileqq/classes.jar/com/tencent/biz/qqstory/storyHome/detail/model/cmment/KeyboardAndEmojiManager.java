package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import nvb;
import nvc;
import nvd;
import nve;

public class KeyboardAndEmojiManager
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new nvd(this);
  private SystemEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private nve jdField_a_of_type_Nve;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public KeyboardAndEmojiManager(Context paramContext, View paramView, nve paramnve)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Nve = paramnve;
    b();
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131371668));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364497));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364504);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131371669));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
  }
  
  private void c()
  {
    ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363499)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new nvb(this));
  }
  
  private void d()
  {
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard up. mIsForceChange = %s.", Boolean.valueOf(this.d));
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = true;
      g();
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    }
    if (this.jdField_a_of_type_Nve != null) {
      this.jdField_a_of_type_Nve.b(this.d);
    }
    this.d = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void e()
  {
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard down. mIsForceChange = %s.", Boolean.valueOf(this.d));
    boolean bool;
    if (!this.c) {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Nve != null) {
        this.jdField_a_of_type_Nve.c(bool);
      }
      this.c = false;
      this.d = false;
      this.jdField_a_of_type_Boolean = false;
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = true;
      a(false);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    }
    if (this.jdField_a_of_type_Nve != null) {
      this.jdField_a_of_type_Nve.b(this.d);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
  }
  
  private void g()
  {
    boolean bool;
    if (!this.c) {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Nve != null) {
        this.jdField_a_of_type_Nve.c(bool);
      }
      this.c = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    if (this.jdField_b_of_type_Boolean) {
      g();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!paramBoolean) {
        break label79;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      }
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
    }
    for (;;)
    {
      SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "setKeyBoardState: %s." + paramBoolean);
      return;
      label79:
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewView.getWindowToken(), 0);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      } while ((this.jdField_a_of_type_Nve != null) && (this.jdField_a_of_type_Nve.b()));
      this.c = true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        g();
        a(true);
        return;
      }
      a(false);
      new Handler().postDelayed(new nvc(this), 200L);
      return;
    } while (this.jdField_a_of_type_Nve == null);
    this.jdField_a_of_type_Nve.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager
 * JD-Core Version:    0.7.0.1
 */