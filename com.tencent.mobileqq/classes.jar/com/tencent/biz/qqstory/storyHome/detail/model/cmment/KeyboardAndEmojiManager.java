package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public class KeyboardAndEmojiManager
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new KeyboardAndEmojiManager.3(this);
  private SystemEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public KeyboardAndEmojiManager(Context paramContext, View paramView, KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener paramKeyboardAndEmojiStateChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener = paramKeyboardAndEmojiStateChangeListener;
    c();
    d();
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131366317));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366187));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365162);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366152));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
  }
  
  private void d()
  {
    ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131367417)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new KeyboardAndEmojiManager.1(this);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void e()
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
    this.jdField_a_of_type_Boolean = true;
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.b(this.d);
    }
    this.d = false;
  }
  
  private void f()
  {
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard down. mIsForceChange = %s.", Boolean.valueOf(this.d));
    this.jdField_a_of_type_Boolean = false;
    boolean bool;
    if (!this.c)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
    }
    else
    {
      bool = false;
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.c(bool);
    }
    this.c = false;
    this.d = false;
  }
  
  private void g()
  {
    boolean bool;
    if (!this.c)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
    }
    else
    {
      bool = false;
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.c(bool);
    }
    this.c = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = true;
      a(false);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.b(this.d);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    Object localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localObject != null) {
      if (paramBoolean)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        }
        ((InputMethodManager)localObject).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
      }
      else
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewView.getWindowToken(), 0);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setKeyBoardState: %s.");
    ((StringBuilder)localObject).append(paramBoolean);
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", ((StringBuilder)localObject).toString());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    if (this.jdField_b_of_type_Boolean) {
      g();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener;
    if (i != 2131366152)
    {
      if (i == 2131367417)
      {
        localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
        if (localKeyboardAndEmojiStateChangeListener != null) {
          localKeyboardAndEmojiStateChangeListener.d();
        }
      }
    }
    else if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localKeyboardAndEmojiStateChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager$KeyboardAndEmojiStateChangeListener;
      if ((localKeyboardAndEmojiStateChangeListener == null) || (!localKeyboardAndEmojiStateChangeListener.b()))
      {
        this.c = true;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          g();
          a(true);
        }
        else
        {
          a(false);
          new Handler().postDelayed(new KeyboardAndEmojiManager.2(this), 200L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager
 * JD-Core Version:    0.7.0.1
 */