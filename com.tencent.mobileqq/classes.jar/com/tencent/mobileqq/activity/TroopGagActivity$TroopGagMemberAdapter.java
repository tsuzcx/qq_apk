package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class TroopGagActivity$TroopGagMemberAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  public TroopGagActivity$TroopGagMemberAdapter(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.a, 1, false);
  }
  
  protected String a(long paramLong)
  {
    String str = ((TroopGagMgr)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.a, paramLong);
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public int getCount()
  {
    int j = this.a.i.size();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.a.i.get(paramInt - 1);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt > 0)
    {
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localObject1 = (TroopGagActivity.TroopGagMemberAdapter.ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131625928, paramViewGroup, false);
        localObject1 = new TroopGagActivity.TroopGagMemberAdapter.ViewHolder(this, null);
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).A = ((ImageView)paramView.findViewById(2131427337));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131439320));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131433931));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c = ((Button)paramView.findViewById(2131445985));
        paramView.setTag(localObject1);
      }
      localObject2 = (TroopGagActivity.GagMemInfo)getItem(paramInt);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).A.setImageBitmap(a(1, ((TroopGagActivity.GagMemInfo)localObject2).a));
      if ((TextUtils.isEmpty(((TroopGagActivity.GagMemInfo)localObject2).b)) || (((TroopGagActivity.GagMemInfo)localObject2).b.equals(((TroopGagActivity.GagMemInfo)localObject2).a))) {
        ((TroopGagActivity.GagMemInfo)localObject2).b = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).e(this.a.c, ((TroopGagActivity.GagMemInfo)localObject2).a);
      }
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).a.setText(((TroopGagActivity.GagMemInfo)localObject2).b);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c.setTag(localObject2);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).b.setText(a(((TroopGagActivity.GagMemInfo)localObject2).c));
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c.setOnClickListener(this);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c.setEnabled(true);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).y = ((TroopGagActivity.GagMemInfo)localObject2).a;
      TroopGagActivity localTroopGagActivity = this.a;
      if ((!TroopGagActivity.a(localTroopGagActivity, localTroopGagActivity.app.getCurrentAccountUin())) && ((TroopGagActivity.b(this.a, ((TroopGagActivity.GagMemInfo)localObject2).a)) || (TroopGagActivity.a(this.a, ((TroopGagActivity.GagMemInfo)localObject2).a)))) {
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c.setEnabled(false);
      }
      if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
        paramView.setBackgroundResource(2130839638);
      } else {
        paramView.setBackgroundResource(2130839629);
      }
      localObject1 = paramView;
      localObject2 = paramView;
    }
    else
    {
      localObject2 = this.a.e;
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof TroopGagActivity.GagMemInfo))
    {
      Object localObject3 = (TroopGagActivity.GagMemInfo)localObject1;
      Object localObject2 = ((TroopGagActivity.GagMemInfo)localObject3).a;
      localObject1 = (TroopGagMgr)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      ((TroopGagMgr)localObject1).a(this.a.c, (String)localObject2, 0L);
      this.a.i.remove(localObject3);
      notifyDataSetChanged();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onClick cancelGag, uin=");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("TroopGagActivity", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = this.a.app;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.a.c);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, ((StringBuilder)localObject3).toString(), ((TroopGagMgr)localObject1).a(this.a.c), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.TroopGagMemberAdapter
 * JD-Core Version:    0.7.0.1
 */