package com.tencent.biz.troopgift;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class TroopGiftPanel$GiftNumInputDialog
  implements View.OnClickListener, InputMethodLinearLayout.onSizeChangeListenner
{
  protected Dialog a;
  protected EditText a;
  protected TextView a;
  protected TextView b;
  
  @TargetApi(11)
  public TroopGiftPanel$GiftNumInputDialog(TroopGiftPanel paramTroopGiftPanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramContext, 2131755332);
    Window localWindow = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    localWindow.setSoftInputMode(16);
    View localView = localWindow.getDecorView();
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -2);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560656, null);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramContext);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    paramContext = (InputMethodLinearLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367703);
    paramContext.setOnSizeChangedListenner(this);
    this.b = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365086));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364265));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367709));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new TroopGiftPanel.GiftNumInputDialog.1(this, paramTroopGiftPanel));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TroopGiftPanel.GiftNumInputDialog.2(this, paramTroopGiftPanel));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramContext.setOnClickListener(new TroopGiftPanel.GiftNumInputDialog.3(this, paramTroopGiftPanel));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppDialog.setOnShowListener(new TroopGiftPanel.GiftNumInputDialog.4(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new TroopGiftPanel.GiftInputFilter(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, 5) });
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.a();
    } else {
      ((GiftPanelHelper)((BaseChatPie)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.get()).a(136)).a(false);
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method");
    View localView = this.jdField_a_of_type_AndroidAppDialog.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {
      i = 2;
    } else {
      i = 1;
    }
    int j = paramView.getId();
    String str;
    Object localObject;
    StringBuilder localStringBuilder;
    if (j != 2131364265)
    {
      if (j == 2131365086)
      {
        c();
        str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(str);
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.6(this), 100L);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
        {
          str = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a());
          ((StringBuilder)localObject).append("");
          NearbyFlowerManager.a("gift_store", "sure_num", str, ((StringBuilder)localObject).toString(), "", "");
        }
        else
        {
          str = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
          localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, str, "", (String)localObject, localStringBuilder.toString());
        }
      }
    }
    else
    {
      c();
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.5(this), 100L);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
      {
        str = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "cancel_num", str, ((StringBuilder)localObject).toString(), "", "");
      }
      else
      {
        str = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
        localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numcancel", i, 0, str, "", (String)localObject, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onSizeChange(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog
 * JD-Core Version:    0.7.0.1
 */