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
  Context a;
  List<AddContactFindTroopClassifyInfo> b;
  AddContactFindTroopClassifyInfo c;
  AddContactTroopClassifyAdapter.onItemClickListener d;
  
  public AddContactTroopClassifyAdapter(Context paramContext, List<AddContactFindTroopClassifyInfo> paramList, AddContactTroopClassifyAdapter.onItemClickListener paramonItemClickListener)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = paramonItemClickListener;
  }
  
  private void a(AddContactTroopClassifyAdapter.ViewHolder paramViewHolder, AddContactFindTroopClassifyInfo paramAddContactFindTroopClassifyInfo)
  {
    paramViewHolder.b.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject1 = URLDrawable.getDrawable(paramAddContactFindTroopClassifyInfo.c, null);
    if ((localObject1 != null) && (1 != ((URLDrawable)localObject1).getStatus()))
    {
      ((URLDrawable)localObject1).setAutoDownload(true);
      ((URLDrawable)localObject1).startDownload(true);
    }
    Object localObject2 = URLDrawable.getDrawable(paramAddContactFindTroopClassifyInfo.b, null);
    if ((localObject2 != null) && (1 != ((URLDrawable)localObject2).getStatus()))
    {
      ((URLDrawable)localObject2).setAutoDownload(true);
      ((URLDrawable)localObject2).startDownload(true);
    }
    int i = this.a.getResources().getColor(2131168212);
    int j = this.a.getResources().getColor(2131168001);
    String str;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    } else {
      str = "#F5F6FA";
    }
    StringBuilder localStringBuilder;
    if (paramAddContactFindTroopClassifyInfo.i)
    {
      paramViewHolder.a.setTextColor(i);
      localObject2 = paramViewHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAddContactFindTroopClassifyInfo.a);
      localStringBuilder.append(this.a.getString(2131887795));
      ((BubbleLayout)localObject2).setContentDescription(localStringBuilder.toString());
    }
    else
    {
      paramViewHolder.a.setTextColor(j);
      localObject1 = paramViewHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAddContactFindTroopClassifyInfo.a);
      localStringBuilder.append(this.a.getString(2131917725));
      ((BubbleLayout)localObject1).setContentDescription(localStringBuilder.toString());
      localObject1 = localObject2;
    }
    paramViewHolder.a.setText(paramAddContactFindTroopClassifyInfo.a);
    paramViewHolder.b.setImageDrawable((Drawable)localObject1);
    paramViewHolder.c.setUnselectedColor(str);
    paramViewHolder.c.setSelectedColor(paramAddContactFindTroopClassifyInfo.e);
    paramViewHolder.c.setSelected(paramAddContactFindTroopClassifyInfo.i);
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramAddContactFindTroopClassifyInfo.a, "", "");
  }
  
  public AddContactTroopClassifyAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AddContactTroopClassifyAdapter.ViewHolder(LayoutInflater.from(this.a).inflate(2131625884, null));
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
    Object localObject = (AddContactFindTroopClassifyInfo)this.b.get(paramInt);
    ((AddContactFindTroopClassifyInfo)localObject).i = true;
    AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = this.c;
    if (localAddContactFindTroopClassifyInfo == null)
    {
      this.c = ((AddContactFindTroopClassifyInfo)localObject);
    }
    else if (localAddContactFindTroopClassifyInfo != localObject)
    {
      localAddContactFindTroopClassifyInfo.i = false;
      this.c = ((AddContactFindTroopClassifyInfo)localObject);
    }
    notifyDataSetChanged();
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", ((AddContactFindTroopClassifyInfo)localObject).a, "", "");
  }
  
  public void a(AddContactTroopClassifyAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    a(paramViewHolder, (AddContactFindTroopClassifyInfo)this.b.get(paramInt));
    paramViewHolder.c.setOnClickListener(new AddContactTroopClassifyAdapter.1(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactTroopClassifyAdapter
 * JD-Core Version:    0.7.0.1
 */