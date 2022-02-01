package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class AddContactTroopClassifyAdapter
  extends RecyclerView.Adapter<AddContactTroopClassifyAdapter.ViewHolder>
{
  Context jdField_a_of_type_AndroidContentContext;
  AddContactFindTroopClassifyInfo jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopClassifyInfo;
  AddContactTroopClassifyAdapter.onItemClickListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter$onItemClickListener;
  List<AddContactFindTroopClassifyInfo> jdField_a_of_type_JavaUtilList;
  
  public AddContactTroopClassifyAdapter(Context paramContext, List<AddContactFindTroopClassifyInfo> paramList, AddContactTroopClassifyAdapter.onItemClickListener paramonItemClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter$onItemClickListener = paramonItemClickListener;
  }
  
  private void a(AddContactTroopClassifyAdapter.ViewHolder paramViewHolder, AddContactFindTroopClassifyInfo paramAddContactFindTroopClassifyInfo)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramAddContactFindTroopClassifyInfo.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramAddContactFindTroopClassifyInfo.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167222);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167063);
    String str;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    } else {
      str = "#F5F6FA";
    }
    if (paramAddContactFindTroopClassifyInfo.jdField_a_of_type_Boolean)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    else
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setUnselectedColor(str);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor(paramAddContactFindTroopClassifyInfo.e);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(paramAddContactFindTroopClassifyInfo.jdField_a_of_type_Boolean);
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString, "", "");
  }
  
  public AddContactTroopClassifyAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AddContactTroopClassifyAdapter.ViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559841, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bubbleLayout  clicked  position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AddContactFindTroopClassifyInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((AddContactFindTroopClassifyInfo)localObject).jdField_a_of_type_Boolean = true;
    AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopClassifyInfo;
    if (localAddContactFindTroopClassifyInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopClassifyInfo = ((AddContactFindTroopClassifyInfo)localObject);
    }
    else if (localAddContactFindTroopClassifyInfo != localObject)
    {
      localAddContactFindTroopClassifyInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopClassifyInfo = ((AddContactFindTroopClassifyInfo)localObject);
    }
    notifyDataSetChanged();
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", ((AddContactFindTroopClassifyInfo)localObject).jdField_a_of_type_JavaLangString, "", "");
  }
  
  public void a(AddContactTroopClassifyAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    a(paramViewHolder, (AddContactFindTroopClassifyInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setOnClickListener(new AddContactTroopClassifyAdapter.1(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactTroopClassifyAdapter
 * JD-Core Version:    0.7.0.1
 */