package com.tencent.biz.pubaccount.readinjoySearch;

import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.activity.contact.addcontact.ReadInJoySearchHistoryAdapter;
import com.tencent.mobileqq.activity.contact.addcontact.ReadInJoySearchHistoryAdapter.OnItemClickObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;

public class ReadInJoyNewSearchActivity
  extends BaseActivity
  implements View.OnClickListener, ReadInJoySearchHistoryAdapter.OnItemClickObserver
{
  protected Handler a;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ReadInJoyNewSearchActivity.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ReadInJoySearchHistoryAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private View b;
  
  public ReadInJoyNewSearchActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ReadInJoyNewSearchActivity.1(this);
  }
  
  private void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.b.setVisibility(0);
      this.b.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    }
    else
    {
      this.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter.a(paramList);
  }
  
  @TargetApi(14)
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376809);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363868));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new ReadInJoyNewSearchActivity.EditTextKeyListener(this, null));
  }
  
  private void b(String paramString)
  {
    try
    {
      String str = Uri.encode(paramString.trim());
      Object localObject = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig().d();
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (((String)localObject).contains("$KEYWORD$")) {
          paramString = ((String)localObject).replace("$KEYWORD$", str);
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("https://so.mp.qq.com/search/index?key=");
        paramString.append(str);
        paramString.append("&_wv=3&_bid=2321");
        paramString = paramString.toString();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jumpToHotWord(). jumpUrl=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ReadInJoyNewSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Intent(this, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      ((Intent)localObject).putExtra("url", paramString);
      startActivity((Intent)localObject);
      localObject = Uri.decode(str);
      paramString = (String)localObject;
      if (((String)localObject).contains("|")) {
        paramString = ((String)localObject).replaceAll("\\|", " ");
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80067C4", "0X80067C4", 0, 0, "", "", paramString, "", false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void c()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      this.mSystemBarComp.init();
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-1);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter = new ReadInJoySearchHistoryAdapter(this, null, this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131377060));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter);
    this.b = super.findViewById(2131377061);
    e();
  }
  
  private void e()
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.4(this), 10, null, true);
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new ReadInJoyNewSearchActivity.5(this);
    localQQCustomDialog.setPositiveButton(2131696022, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131696021, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131696023);
    localQQCustomDialog.setTitle(2131697265);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165473));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.show();
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramReadInJoySearchHistoryEntity.keyWord);
    if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
    }
    b(paramReadInJoySearchHistoryEntity.keyWord);
    a(paramReadInJoySearchHistoryEntity.keyWord);
    Object localObject = paramReadInJoySearchHistoryEntity.keyWord.trim();
    paramReadInJoySearchHistoryEntity = (ReadInJoySearchHistoryEntity)localObject;
    if (((String)localObject).contains("|")) {
      paramReadInJoySearchHistoryEntity = ((String)localObject).replaceAll("\\|", " ");
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity, "", "", "", false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.3(this, paramString), 10, null, true);
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
    super.setContentView(2131560268);
    c();
    b();
    d();
    RIJDtReportHelper.a.a(getActivity());
    if (VersionUtils.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    TextWatcher localTextWatcher = this.jdField_a_of_type_AndroidTextTextWatcher;
    if (localTextWatcher != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(localTextWatcher);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null) {
      localEditText.setText("");
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363868)
    {
      if (i == 2131368340) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
    }
    else {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity
 * JD-Core Version:    0.7.0.1
 */