package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class AddContactViewPagerTroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected XListView a;
  AddContactFindTroopRTLW b;
  protected int c = -1;
  public String d;
  public String e;
  public String f = "";
  View g;
  LinearLayout h;
  ImageView i;
  TextView j;
  TextView k;
  TextView l;
  View.OnTouchListener m = new AddContactViewPagerTroopFragment.1(this);
  View.OnClickListener n = new AddContactViewPagerTroopFragment.2(this);
  AddContactFindTroopRTLW.onRefreshCallback o = new AddContactViewPagerTroopFragment.3(this);
  private boolean y;
  
  private void c(boolean paramBoolean)
  {
    this.h.setVisibility(0);
    this.a.setVisibility(8);
    Object localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115412_lWT3DV2SAk.png", null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
      ((URLDrawable)localObject).restartDownload();
    }
    this.i.setImageDrawable((Drawable)localObject);
    this.j.setText(2131886274);
    this.k.setText(2131905025);
    this.l.setText(2131886273);
    localObject = this.h.getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setBackgroundResource(2130839577);
    }
    if (paramBoolean)
    {
      this.l.setOnTouchListener(this.m);
      this.l.setOnClickListener(this.n);
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "getView");
    }
    paramBundle = this.g;
    if (paramBundle == null)
    {
      this.g = paramLayoutInflater.inflate(2131625886, null);
      this.h = ((LinearLayout)this.g.findViewById(2131447447));
      this.i = ((ImageView)this.g.findViewById(2131435494));
      this.j = ((TextView)this.g.findViewById(2131447281));
      this.k = ((TextView)this.g.findViewById(2131447282));
      this.l = ((TextView)this.g.findViewById(2131447283));
      this.a = ((XListView)this.g.findViewById(2131444469));
      this.a.setId(2131427787);
      this.a.setSelector(2131168376);
      this.a.setNeedCheckSpringback(true);
      this.a.setDivider(null);
      this.a.setClipToPadding(false);
      this.a.setScrollBarStyle(33554432);
      paramLayoutInflater = this.a;
      paramLayoutInflater.mForContacts = true;
      paramLayoutInflater.setOnScrollListener(this);
      if ((this.c == 1) && (Build.VERSION.SDK_INT >= 23))
      {
        boolean bool;
        if ((getBaseActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) && (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel())
        {
          paramLayoutInflater = new StringBuilder();
          paramLayoutInflater.append("getView  >= M, canRequestLocation = ");
          paramLayoutInflater.append(bool);
          QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, paramLayoutInflater.toString());
        }
        if (!bool)
        {
          c(true);
        }
        else
        {
          this.h.setVisibility(8);
          this.a.setVisibility(0);
          paramLayoutInflater = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("getView  >= M, canRequestLocation = ");
            paramBundle.append(bool);
            paramBundle.append(",cached info = ");
            paramBundle.append(paramLayoutInflater);
            QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, paramBundle.toString());
          }
          if (paramLayoutInflater == null) {
            ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AddContactViewPagerTroopFragment.4(this, "recommend_troop"));
          }
        }
      }
      this.b = new AddContactFindTroopRTLW(this.s, this.w, this.a, null, this.c, this.e);
      this.b.b = this.o;
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.g);
      }
    }
    return this.g;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "doOnDestroy");
    }
    e();
    AddContactFindTroopRTLW localAddContactFindTroopRTLW = this.b;
    if (localAddContactFindTroopRTLW != null) {
      localAddContactFindTroopRTLW.e();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHotTagClickChanged,keyWord = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",newKeyWord = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",newHotTagName = ");
      localStringBuilder.append(paramString2);
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    this.f = paramString2;
    if (!this.e.equals(paramString1))
    {
      this.e = paramString1;
      if (this.v)
      {
        paramString2 = this.b;
        if (paramString2 != null) {
          paramString2.a(paramString1);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume:");
      localStringBuilder.append(paramBoolean);
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    if (this.a == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if ((this.v) && (this.h.getVisibility() == 0)) {
      if (this.j.getText().equals(getResources().getString(2131886274))) {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_location_exp", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_meet_exp", 0, 0, this.f, this.d, "", "");
      }
    }
    if ((this.v) && (!this.y))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume requestData");
      }
      this.y = true;
      this.b.b(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onPause");
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void bU_()
  {
    if (this.v) {
      this.b.f();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "resetData");
    }
  }
  
  protected void d()
  {
    boolean bool = this.v;
  }
  
  protected void e() {}
  
  public View getScrollableView()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment
 * JD-Core Version:    0.7.0.1
 */