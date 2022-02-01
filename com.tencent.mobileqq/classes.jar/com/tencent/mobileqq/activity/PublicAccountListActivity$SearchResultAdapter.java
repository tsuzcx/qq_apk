package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PublicAccountListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<PublicAccountListActivity.InnerPAInfo> b;
  
  public PublicAccountListActivity$SearchResultAdapter(List<PublicAccountListActivity.InnerPAInfo> paramList)
  {
    super(paramList, paramList.app, paramList.l, 1, true);
    Object localObject;
    this.b = localObject;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.z.inflate(2131625647, paramViewGroup, false);
      paramView = new PublicAccountListActivity.SearchViewHolder();
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.b = ((TextView)localView.findViewById(2131439121));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (PublicAccountListActivity.SearchViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = getItem(paramInt);
    if (localObject != null)
    {
      localObject = (PublicAccountListActivity.InnerPAInfo)localObject;
      if (localObject != null)
      {
        paramView.y = ((PublicAccountListActivity.InnerPAInfo)localObject).a.getUin();
        paramView.a = ((PublicAccountListActivity.InnerPAInfo)localObject);
        paramView.A.setImageBitmap(super.a(paramView.y, 1, (byte)0));
        paramView.b.setText(((PublicAccountListActivity.InnerPAInfo)localObject).a.name);
        if (((PublicAccountListActivity.InnerPAInfo)localObject).a.certifiedGrade > 0L)
        {
          if (this.a.a == null)
          {
            localObject = this.a;
            ((PublicAccountListActivity)localObject).a = ((PublicAccountListActivity)localObject).getResources().getDrawable(2130842755);
            this.a.a.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
            ThemeUtil.setThemeFilter(this.a.a, ThemeUtil.curThemeId);
          }
          paramView.b.setCompoundDrawables(null, null, this.a.a, null);
        }
        else
        {
          paramView.b.setCompoundDrawables(null, null, null, null);
        }
        if (AppSetting.e) {
          localView.setContentDescription(paramView.b.getText());
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */