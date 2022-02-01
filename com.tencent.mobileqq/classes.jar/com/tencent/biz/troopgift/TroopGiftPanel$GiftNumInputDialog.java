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
  protected TextView b;
  protected TextView c;
  protected EditText d;
  
  @TargetApi(11)
  public TroopGiftPanel$GiftNumInputDialog(TroopGiftPanel paramTroopGiftPanel, Context paramContext)
  {
    this.a = new Dialog(paramContext, 2131952026);
    Window localWindow = this.a.getWindow();
    localWindow.setSoftInputMode(16);
    View localView = localWindow.getDecorView();
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -2);
    paramContext = LayoutInflater.from(paramContext).inflate(2131626701, null);
    this.a.setContentView(paramContext);
    this.a.setCancelable(true);
    paramContext = (InputMethodLinearLayout)this.a.findViewById(2131434255);
    paramContext.setOnSizeChangedListenner(this);
    this.c = ((TextView)this.a.findViewById(2131431227));
    this.b = ((TextView)this.a.findViewById(2131430281));
    this.d = ((EditText)this.a.findViewById(2131434264));
    if (Build.VERSION.SDK_INT >= 11) {
      this.d.setCustomSelectionActionModeCallback(new TroopGiftPanel.GiftNumInputDialog.1(this, paramTroopGiftPanel));
    }
    this.d.setOnEditorActionListener(new TroopGiftPanel.GiftNumInputDialog.2(this, paramTroopGiftPanel));
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramContext.setOnClickListener(new TroopGiftPanel.GiftNumInputDialog.3(this, paramTroopGiftPanel));
  }
  
  public void a()
  {
    this.a.setOnShowListener(new TroopGiftPanel.GiftNumInputDialog.4(this));
    this.d.setFilters(new InputFilter[] { new TroopGiftPanel.GiftInputFilter(this.e, 5) });
    this.a.show();
  }
  
  public void b()
  {
    if (this.e.F) {
      this.e.G.a();
    } else {
      ((GiftPanelHelper)((BaseChatPie)this.e.C.get()).q(136)).b(false);
    }
    this.a.dismiss();
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.e.getContext().getSystemService("input_method");
    View localView = this.a.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (AnonymousChatHelper.a().a(this.e.getTroopUin())) {
      i = 2;
    } else {
      i = 1;
    }
    int j = paramView.getId();
    String str;
    Object localObject;
    StringBuilder localStringBuilder;
    if (j != 2131430281)
    {
      if (j == 2131431227)
      {
        c();
        str = this.d.getEditableText().toString();
        if (!TextUtils.isEmpty(str)) {
          this.e.a(str);
        }
        this.e.postDelayed(new TroopGiftPanel.GiftNumInputDialog.6(this), 100L);
        if (this.e.V >= 4)
        {
          str = this.e.getTroopUin();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.e.getComeFrom());
          ((StringBuilder)localObject).append("");
          NearbyFlowerManager.a("gift_store", "sure_num", str, ((StringBuilder)localObject).toString(), "", "");
        }
        else
        {
          str = this.e.getTroopUin();
          localObject = this.e.H;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.e.l.get(), ((AppInterface)this.e.l.get()).getCurrentAccountUin(), this.e.getTroopUin()));
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, str, "", (String)localObject, localStringBuilder.toString());
        }
      }
    }
    else
    {
      c();
      this.e.postDelayed(new TroopGiftPanel.GiftNumInputDialog.5(this), 100L);
      if (this.e.V >= 4)
      {
        str = this.e.getTroopUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e.getComeFrom());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "cancel_num", str, ((StringBuilder)localObject).toString(), "", "");
      }
      else
      {
        str = this.e.getTroopUin();
        localObject = this.e.H;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.e.l.get(), ((AppInterface)this.e.l.get()).getCurrentAccountUin(), this.e.getTroopUin()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog
 * JD-Core Version:    0.7.0.1
 */