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
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
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
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.a.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
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
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131559885, paramViewGroup, false);
        localObject1 = new TroopGagActivity.TroopGagMemberAdapter.ViewHolder(this, null);
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c = ((ImageView)paramView.findViewById(2131361799));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131367428));
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377577));
        paramView.setTag(localObject1);
      }
      localObject2 = (TroopGagActivity.GagMemInfo)getItem(paramInt);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).c.setImageBitmap(a(1, ((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString));
      if ((TextUtils.isEmpty(((TroopGagActivity.GagMemInfo)localObject2).b)) || (((TroopGagActivity.GagMemInfo)localObject2).b.equals(((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString))) {
        ((TroopGagActivity.GagMemInfo)localObject2).b = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.a.jdField_a_of_type_JavaLangString, ((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString);
      }
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((TroopGagActivity.GagMemInfo)localObject2).b);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).b.setText(a(((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_Long));
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = ((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString;
      TroopGagActivity localTroopGagActivity = this.a;
      if ((!TroopGagActivity.a(localTroopGagActivity, localTroopGagActivity.app.getCurrentAccountUin())) && ((TroopGagActivity.b(this.a, ((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, ((TroopGagActivity.GagMemInfo)localObject2).jdField_a_of_type_JavaLangString)))) {
        ((TroopGagActivity.TroopGagMemberAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
        paramView.setBackgroundResource(2130839449);
      } else {
        paramView.setBackgroundResource(2130839440);
      }
      localObject1 = paramView;
      localObject2 = paramView;
    }
    else
    {
      localObject2 = this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
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
      Object localObject2 = ((TroopGagActivity.GagMemInfo)localObject3).jdField_a_of_type_JavaLangString;
      localObject1 = (TroopGagMgr)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      ((TroopGagMgr)localObject1).a(this.a.jdField_a_of_type_JavaLangString, (String)localObject2, 0L);
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject3);
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
      ((StringBuilder)localObject3).append(this.a.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, ((StringBuilder)localObject3).toString(), ((TroopGagMgr)localObject1).a(this.a.jdField_a_of_type_JavaLangString), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.TroopGagMemberAdapter
 * JD-Core Version:    0.7.0.1
 */