package com.tencent.biz.pubaccount.readinjoySearch;

import ahho;
import ahhp;
import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aoqy;
import aoqz;
import bdep;
import bdgm;
import bdjz;
import bhtb;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import nrt;
import sry;
import srz;
import ssa;
import ssb;

public class ReadInJoyNewSearchActivity
  extends FragmentActivity
  implements ahhp, View.OnClickListener
{
  private ahho jdField_a_of_type_Ahho;
  protected Handler a;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new srz(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private View b;
  
  public ReadInJoyNewSearchActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new sry(this);
  }
  
  private void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.b.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahho.a(paramList);
      return;
      this.b.setVisibility(0);
      this.b.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    }
  }
  
  @TargetApi(14)
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376034);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363522));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131367817));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new ssb(this, null));
  }
  
  private void b(String paramString)
  {
    try
    {
      String str = Uri.encode(paramString.trim());
      Object localObject = aoqz.a().d;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (!((String)localObject).contains("$KEYWORD$")) {}
      }
      for (paramString = ((String)localObject).replace("$KEYWORD$", str);; paramString = "https://so.mp.qq.com/search/index?key=" + str + "&_wv=3&_bid=2321")
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewSearchActivity", 2, "jumpToHotWord(). jumpUrl=" + paramString);
        }
        localObject = new Intent(this, PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", paramString);
        startActivity((Intent)localObject);
        localObject = Uri.decode(str);
        paramString = (String)localObject;
        if (((String)localObject).contains("|")) {
          paramString = ((String)localObject).replaceAll("\\|", " ");
        }
        nrt.a(null, null, "0X80067C4", "0X80067C4", 0, 0, "", "", paramString, "", false);
        return;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void c()
  {
    if (ThemeUtil.isInNightMode(this.app)) {}
    while (ImmersiveUtils.isSupporImmersive() != 1) {
      return;
    }
    super.getWindow().addFlags(67108864);
    if (this.mSystemBarComp == null) {
      this.mSystemBarComp = new SystemBarCompact(this, true, -1);
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    this.mSystemBarComp.init();
    if (!bdep.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ahho = new ahho(this, null, this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131376261));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahho);
    this.b = super.findViewById(2131376263);
    e();
  }
  
  private void e()
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.4(this), 10, null, true);
  }
  
  public void a()
  {
    bdjz localbdjz = bdgm.a(this, 230);
    Object localObject = new ssa(this);
    localbdjz.setPositiveButton(2131696448, (DialogInterface.OnClickListener)localObject);
    localbdjz.setNegativeButton(2131696447, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131696449);
    localbdjz.setTitle(2131697699);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165448));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localbdjz.addView(localTextView);
    localbdjz.show();
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramReadInJoySearchHistoryEntity.keyWord);
    if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    b(paramReadInJoySearchHistoryEntity.keyWord);
    a(paramReadInJoySearchHistoryEntity.keyWord);
    String str = paramReadInJoySearchHistoryEntity.keyWord.trim();
    paramReadInJoySearchHistoryEntity = str;
    if (str.contains("|")) {
      paramReadInJoySearchHistoryEntity = str.replaceAll("\\|", " ");
    }
    nrt.a(null, null, "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity, "", "", "", false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.3(this, paramString), 10, null, true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560101);
    c();
    b();
    d();
    if (bhtb.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    e();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363522: 
      finish();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity
 * JD-Core Version:    0.7.0.1
 */