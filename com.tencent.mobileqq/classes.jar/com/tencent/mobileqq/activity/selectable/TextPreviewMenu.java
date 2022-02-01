package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.CancelDialogListener;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.participle.ParticipleObserver;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppRuntime;

public class TextPreviewMenu
  extends CommonSelectableMenu<TextPreviewActivity>
{
  protected Dialog f;
  protected TextPreviewMenu.ProgressView g;
  private int h = -1;
  private String i = null;
  private boolean j = false;
  private int k;
  private List<String> l;
  private ParticipleObserver m = new TextPreviewMenu.2(this);
  
  private int a(int paramInt)
  {
    int n = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1006) {
          if (paramInt != 3000)
          {
            if ((paramInt == 10008) || (paramInt == 10010) || (paramInt == 10013) || (paramInt == 1020) || (paramInt == 1021)) {}
          }
          else {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  return -2;
                  return 4;
                }
                break;
              }
              break;
            }
          }
        }
        return 3;
      }
      n = 2;
    }
    return n;
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    ECommerceDataReportUtil.a(paramQQAppInterface, paramMessageRecord, 2);
    try
    {
      MenuUtil.copy(a(), "TextPreview");
      if (paramBoolean)
      {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A356", "0X800A356", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F00", "0X8009F00", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TextPreviewMenu", 2, paramActivity.toString());
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
    if (localTextPreviewActivity != null) {
      localTextPreviewActivity.startActivityForResult(paramIntent, -1);
    }
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity)
  {
    paramTextPreviewActivity.U.a(paramTextPreviewActivity.T);
    paramTextPreviewActivity.U.setOnMenuClickListener(new TextPreviewMenu.1(this, paramTextPreviewActivity));
    paramTextPreviewActivity.W.setOnClickListener(this);
    paramTextPreviewActivity.X.setOnClickListener(this);
    paramTextPreviewActivity.Y.setOnClickListener(this);
    paramTextPreviewActivity.Z.setOnClickListener(this);
  }
  
  private void a(TextPreviewActivity paramTextPreviewActivity, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextPreviewActivity.p.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.b(paramInt1, paramTextPreviewActivity.getResources());
    float f1 = paramInt2;
    localLayoutParams.leftMargin = AIOUtils.b(f1, paramTextPreviewActivity.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(f1, paramTextPreviewActivity.getResources());
    paramTextPreviewActivity.p.setLayoutParams(localLayoutParams);
    paramTextPreviewActivity.p.post(new TextPreviewMenu.3(this, paramTextPreviewActivity));
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.l = paramList;
      TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.o.setVisibility(8);
        localTextPreviewActivity.V.setVisibility(8);
        localTextPreviewActivity.T.setParticipleItems(paramList);
        localTextPreviewActivity.T.a();
        localTextPreviewActivity.U.b();
        a(localTextPreviewActivity, 60, 10);
      }
    }
    else
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131912190), 0).show();
    }
  }
  
  private void e()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(this.l);
      return;
    }
    localObject = (TextPreviewActivity)this.d.get();
    if (localObject != null)
    {
      if (!NetworkUtil.isNetSupport((Context)localObject))
      {
        QQToast.makeText((Context)localObject, HardCodeUtil.a(2131912180), 0).show(((TextPreviewActivity)localObject).getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if (!TextUtils.isEmpty(this.e))
      {
        ((IParticipleApi)QRoute.api(IParticipleApi.class)).participleTheContent(((TextPreviewActivity)localObject).app, this.e, this.i);
        f();
      }
    }
  }
  
  private void f()
  {
    Activity localActivity = (Activity)this.d.get();
    if (localActivity != null)
    {
      Dialog localDialog = this.f;
      if (localDialog == null)
      {
        this.g = new TextPreviewMenu.ProgressView(localActivity);
        this.f = new ReportDialog(localActivity);
        if (this.f.getWindow() != null) {
          this.f.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f.setCanceledOnTouchOutside(false);
        this.f.requestWindowFeature(1);
        this.f.setContentView(this.g);
        this.f.setOnCancelListener(new CancelDialogListener(localActivity));
      }
      else
      {
        localDialog.dismiss();
      }
      this.g.setProgressText(HardCodeUtil.a(2131912191));
      this.f.show();
    }
  }
  
  private void g()
  {
    Dialog localDialog = this.f;
    if (localDialog != null)
    {
      localDialog.setOnCancelListener(null);
      this.f.dismiss();
    }
  }
  
  private void h()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
    if (localTextPreviewActivity != null)
    {
      localTextPreviewActivity.U.setVisibility(8);
      localTextPreviewActivity.T.setVisibility(8);
      localTextPreviewActivity.V.setVisibility(0);
      localTextPreviewActivity.o.setVisibility(0);
      a(localTextPreviewActivity, 135, 20);
    }
  }
  
  public void a(TextPreviewActivity paramTextPreviewActivity, ContainerView paramContainerView)
  {
    super.a(paramTextPreviewActivity, paramContainerView);
    this.h = paramTextPreviewActivity.b;
    this.i = paramTextPreviewActivity.d;
    this.j = paramTextPreviewActivity.f;
    this.k = paramTextPreviewActivity.e;
    a(paramTextPreviewActivity);
    paramTextPreviewActivity.app.addObserver(this.m);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131431492, HardCodeUtil.a(2131912185), 2130839057);
    paramQQCustomMenu.a(2131433636, HardCodeUtil.a(2131912183), 2130839066);
    int n = this.h;
    if ((n != 0) && (n != 1))
    {
      if (n == 3000)
      {
        TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
        if ((localTextPreviewActivity != null) && (localTextPreviewActivity.app != null) && (!this.i.equals(localTextPreviewActivity.app.getCurrentAccountUin()))) {
          paramQQCustomMenu.a(2131444634, HardCodeUtil.a(2131912184), 2130839072);
        }
      }
    }
    else if ((!this.j) && (this.k != -2)) {
      paramQQCustomMenu.a(2131444634, HardCodeUtil.a(2131912192), 2130839072);
    }
    paramQQCustomMenu.a(2131432813, HardCodeUtil.a(2131912186), 2130839065);
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    int n = a(this.k);
    ReportController.b((AppRuntime)this.c.get(), "dc00898", "", "", "0X8009EFF", "0X8009EFF", n, 0, "", "", "", "");
  }
  
  public void b(ContainerView paramContainerView)
  {
    super.b(paramContainerView);
    paramContainerView = (TextPreviewActivity)this.d.get();
    if ((paramContainerView != null) && (paramContainerView.app != null)) {
      paramContainerView.app.removeObserver(this.m);
    }
    g();
  }
  
  public boolean d()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
    boolean bool2 = false;
    boolean bool1 = false;
    if (localTextPreviewActivity != null)
    {
      if (localTextPreviewActivity.T.getVisibility() == 0) {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1)
      {
        h();
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.d.get();
    MessageRecord localMessageRecord;
    if (localTextPreviewActivity == null) {
      localMessageRecord = null;
    } else {
      localMessageRecord = localTextPreviewActivity.aa;
    }
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446228: 
    case 2131446229: 
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.a(a());
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 5, 0, "", "", "", "");
      }
      break;
    case 2131445511: 
      AIOSelectableDelegateImpl.a().a(null);
      break;
    case 2131444634: 
      if (localTextPreviewActivity != null)
      {
        localTextPreviewActivity.setResult(14001, localTextPreviewActivity.getIntent());
        localTextPreviewActivity.finish();
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 4, 0, "", "", "", "");
      }
      break;
    case 2131433636: 
      ECommerceDataReportUtil.a(localQQAppInterface, localMessageRecord, 3);
      int n = localTextPreviewActivity.a();
      if (n >= 0) {
        MenuUtil.a((Activity)paramView.getContext(), a(), n);
      } else {
        MenuUtil.a((Activity)paramView.getContext(), a());
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F01", "0X8009F01", 0, 0, "", "", "", "");
      break;
    case 2131433555: 
      if (localTextPreviewActivity != null) {
        localTextPreviewActivity.c();
      } else {
        QLog.e("TextPreviewMenu", 1, "activity is null, so activity.onClickFontSettingBtn not invoke");
      }
      break;
    case 2131433495: 
      e();
      if (localTextPreviewActivity != null) {
        ReportController.b(localTextPreviewActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 1, 0, "", "", "", "");
      } else {
        QLog.e("TextPreviewMenu", 1, "activity is null, so ReportController.reportClickEvent not invoke");
      }
      break;
    case 2131432813: 
      ECommerceDataReportUtil.a(localQQAppInterface, localMessageRecord, 4);
      if (localQQAppInterface != null) {
        MenuUtil.a((Activity)paramView.getContext(), localQQAppInterface, a());
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009F02", "0X8009F02", 0, 0, "", "", "", "");
      break;
    case 2131431422: 
      bool = true;
    case 2131431492: 
      a(localTextPreviewActivity, localQQAppInterface, localMessageRecord, bool);
    }
    if ((paramView.getId() != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
      AIOSelectableDelegateImpl.a().n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu
 * JD-Core Version:    0.7.0.1
 */