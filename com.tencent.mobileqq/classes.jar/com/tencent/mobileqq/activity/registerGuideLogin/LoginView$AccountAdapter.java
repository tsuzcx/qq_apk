package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

public class LoginView$AccountAdapter
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter a;
  
  public LoginView$AccountAdapter(LoginView paramLoginView, Context paramContext)
  {
    super(paramContext, 2131623976, 2131436139, paramLoginView.v);
  }
  
  public String a(int paramInt)
  {
    String str = ((SimpleAccount)this.b.v.get(paramInt)).getUin();
    if (this.b.a == null) {
      return str;
    }
    return LoginUtils.a(str);
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)this.b.v.get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (this.b.v.size() == 0) {
      this.b.q.getDropDownIcon().setVisibility(8);
    } else {
      this.b.q.getDropDownIcon().setVisibility(0);
    }
    return super.getCount();
  }
  
  public Filter getFilter()
  {
    if (this.a == null) {
      this.a = new LoginView.AccountAdapter.1(this);
    }
    return this.a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131429234);
    Object localObject1 = (ImageView)localView.findViewById(2131436047);
    String str = ((SimpleAccount)this.b.v.get(paramInt)).getUin();
    if ((this.b.E != null) && (this.b.E.get(str) != null))
    {
      Object localObject2 = this.b.E.get(str);
      LoginView.a(this.b, (ImageView)localObject1, localObject2);
    }
    else
    {
      this.b.a((ImageView)localObject1, str, false);
    }
    localObject1 = (ImageView)localView.findViewById(2131435975);
    ((ImageView)localObject1).setTag(Integer.valueOf(paramInt));
    ((ImageView)localObject1).setOnClickListener(this);
    ((ImageView)localObject1).setContentDescription(this.b.b.getString(2131917018));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b.b.getString(2131886137));
    ((StringBuilder)localObject1).append("%s");
    localView.setContentDescription(String.format(((StringBuilder)localObject1).toString(), new Object[] { str }));
    if (getCount() == 1) {
      localLinearLayout.setPadding(0, Utils.a(7.5F, this.b.getResources()), 0, Utils.a(7.5F, this.b.getResources()));
    } else if (paramInt == 0) {
      localLinearLayout.setPadding(0, Utils.a(7.5F, this.b.getResources()), 0, 0);
    } else if (paramInt == getCount() - 1) {
      localLinearLayout.setPadding(0, 0, 0, Utils.a(7.5F, this.b.getResources()));
    } else {
      localLinearLayout.setPadding(0, 0, 0, 0);
    }
    localLinearLayout.setOnClickListener(new LoginView.AccountAdapter.2(this, paramInt));
    localView.setOnTouchListener(new LoginView.AccountAdapter.3(this));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    this.b.x = ((Integer)paramView.getTag()).intValue();
    this.b.b.showDialog(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.AccountAdapter
 * JD-Core Version:    0.7.0.1
 */