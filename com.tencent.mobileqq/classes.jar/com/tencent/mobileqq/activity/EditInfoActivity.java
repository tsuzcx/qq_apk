package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
import sir;
import sis;
import sit;
import siu;
import siv;
import siy;
import siz;
import sja;

public class EditInfoActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback, InputMethodLinearLayout.onSizeChangeListenner
{
  public int a;
  protected Drawable a;
  public Handler a;
  protected ViewGroup a;
  public EditText a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new sja(this);
  SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
  public EllipsizingTextView a;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  protected String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  protected boolean c;
  public int d;
  String d;
  protected boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  boolean f;
  String g;
  public boolean g;
  protected String h;
  boolean h;
  String i;
  
  public EditInfoActivity()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new sir(this);
  }
  
  public void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    }
  }
  
  public void a(Intent paramIntent) {}
  
  protected void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364464));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new siv(this));
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844421);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情");
      return;
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString.length() > 20) {
      return true;
    }
    int k = paramString.length();
    int j = 0;
    while (j < k)
    {
      int m = paramString.charAt(j);
      if ((m < 48) || (m > 57)) {
        bool = true;
      }
      j += 1;
    }
    return bool;
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131363363));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838592);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  public void c() {}
  
  public void d()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    j();
    e();
    setContentBackgroundResource(2130838210);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new sis(this), 500L);
    if (this.jdField_g_of_type_Boolean) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    return true;
  }
  
  void e()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), j);
      setTitle(this.jdField_a_of_type_JavaLangString);
      setRightButton(2131434517, new sit(this));
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        this.rightViewText.setText(this.jdField_g_of_type_JavaLangString);
        this.rightViewText.setContentDescription(getString(2131430716, new Object[] { this.jdField_g_of_type_JavaLangString }));
      }
      if (this.jdField_h_of_type_JavaLangString != null)
      {
        this.leftView.setText(this.jdField_h_of_type_JavaLangString);
        this.leftView.setContentDescription(getString(2131430716, new Object[] { this.jdField_h_of_type_JavaLangString }));
      }
      if (this.i != null)
      {
        TextView localTextView = (TextView)findViewById(2131364466);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.i);
          localTextView.setOnClickListener(new siu(this));
        }
      }
      return;
      f();
      continue;
      g();
    }
  }
  
  protected void f()
  {
    super.setContentView(2130968962);
    h();
    View localView1 = findViewById(2131364461);
    View localView2 = findViewById(2131364468);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      localView1.setVisibility(8);
      localView2.setVisibility(8);
    }
  }
  
  protected void g()
  {
    super.setContentView(2130968961);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131362822));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    h();
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)DisplayUtils.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131364462).getLayoutParams();
      localLayoutParams.height = ((int)DisplayUtils.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    if (this.jdField_f_of_type_Boolean) {
      i();
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131364463));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131362822));
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_f_of_type_Int == 0) {
          j = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8").length;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        j = 0;
      }
      try
      {
        this.jdField_c_of_type_JavaLangString = ("" + (this.jdField_c_of_type_Int - j));
        if (this.jdField_d_of_type_Int == 3) {
          break label293;
        }
        if ((!this.jdField_e_of_type_Boolean) || (j > this.jdField_c_of_type_Int)) {
          break label270;
        }
        this.rightViewText.setEnabled(true);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131364469));
        }
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        break label232;
      }
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
      continue;
      label232:
      localUnsupportedEncodingException1.printStackTrace();
      continue;
      this.jdField_c_of_type_JavaLangString = ("" + this.jdField_c_of_type_Int);
      j = 0;
      continue;
      label270:
      if ((j == 0) || (j > this.jdField_c_of_type_Int))
      {
        this.rightViewText.setEnabled(false);
        continue;
        label293:
        this.rightViewText.setEnabled(true);
      }
    }
  }
  
  void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131364467));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364465));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new siy(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new siz(this));
  }
  
  protected void j()
  {
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("options");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("title");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("defaultText");
        this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("gc");
        this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject2).optString("uin");
        this.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("maxLength");
        this.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("src");
        this.jdField_h_of_type_JavaLangString = "返回";
        this.jdField_g_of_type_JavaLangString = "提交";
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("edit_type", 0);
        this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("edit_subtype", -1);
        this.jdField_e_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("canPostNull", true);
        this.jdField_f_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("support_emotion", false);
        this.jdField_h_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("full_screen", false);
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_hint");
        this.jdField_e_of_type_Int = ((Intent)localObject1).getIntExtra("send_type", 0);
        this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("right_btn");
        this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("count_type", 0);
        this.jdField_h_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("left_btn");
        this.i = ((Intent)localObject1).getStringExtra("link_text");
        this.jdField_c_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("auto_remark", false);
        if ((this.jdField_c_of_type_Boolean) && (this.app != null) && (this.app.getCurrentAccountUin() != null) && (this.jdField_f_of_type_JavaLangString != null) && (!this.app.getCurrentAccountUin().equals(this.jdField_f_of_type_JavaLangString)) && (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          localObject1 = (TroopHandler)this.app.a(20);
          if (localObject1 != null) {
            ((TroopHandler)localObject1).u(this.jdField_f_of_type_JavaLangString);
          }
          this.jdField_d_of_type_Boolean = true;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.memberCard", 2, "EditInfoActivity.initData optionArgs parse error.", localJSONException);
        continue;
      }
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("title");
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_text");
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("troopUin");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
      this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("max_num", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("from", -1);
      this.jdField_g_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isTroopNick", false);
    }
  }
  
  public void k() {}
  
  public void l() {}
  
  public boolean onBackEvent()
  {
    d();
    return super.onBackEvent();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_g_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("IphoneTitleBarActivity", 2, "onDestroy" + localException.toString());
    }
  }
  
  protected void onPause()
  {
    d();
    super.onPause();
  }
  
  protected void onResume()
  {
    a();
    super.onResume();
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */