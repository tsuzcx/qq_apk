package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FormMultiLineItem;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

class PublicView$PublicAccountAdapter
  extends FacePreloadBaseAdapter
{
  public PublicView$PublicAccountAdapter(PublicView paramPublicView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public PublicRecommendAccountInfo a(int paramInt)
  {
    if ((PublicView.f(this.a) != null) && (paramInt >= 0) && (paramInt < PublicView.f(this.a).size())) {
      return (PublicRecommendAccountInfo)PublicView.f(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if ((PublicView.f(this.a) != null) && (PublicView.f(this.a).size() > 0)) {
      return PublicView.f(this.a).size();
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new FormMultiLineItem(this.a.F);
      ((View)localObject1).setId(2131442132);
      paramView = new PublicView.ViewHolder();
      localObject2 = (FormMultiLineItem)localObject1;
      paramView.A = ((FormMultiLineItem)localObject2).getHeaderView();
      paramView.a = ((FormMultiLineItem)localObject2).a(0);
      paramView.b = ((FormMultiLineItem)localObject2).a(1);
      ((View)localObject1).setTag(paramView);
      ((View)localObject1).setOnClickListener(this.a);
    }
    else
    {
      localObject2 = (PublicView.ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = a(paramInt);
    if (localObject2 != null)
    {
      if (((PublicRecommendAccountInfo)localObject2).mSource == 1) {
        paramView.y = ((PublicRecommendAccountInfo)localObject2).mEqqNameAccount;
      } else {
        paramView.y = String.valueOf(((PublicRecommendAccountInfo)localObject2).mPublicuin);
      }
      paramView.c = ((PublicRecommendAccountInfo)localObject2);
      paramView.a.setVisibility(0);
      paramView.b.setVisibility(0);
      paramView.A.setImageBitmap(a(1, paramView.y));
      if (((PublicRecommendAccountInfo)localObject2).mSource == 1)
      {
        paramView.a.setText(((PublicRecommendAccountInfo)localObject2).mEqqCs);
        paramView.b.setText(((PublicRecommendAccountInfo)localObject2).mEqqSi);
      }
      else
      {
        paramView.a.setText(((PublicRecommendAccountInfo)localObject2).mPublicname);
        paramView.b.setText(((PublicRecommendAccountInfo)localObject2).mPublicdesc);
      }
      if ((((PublicRecommendAccountInfo)localObject2).mIsVerified != null) && (((PublicRecommendAccountInfo)localObject2).mIsVerified.equalsIgnoreCase("1")))
      {
        localObject2 = this.a.getResources().getDrawable(2130842755);
        int i = (int)DisplayUtils.a(this.a.F, 15.0F);
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        ((MultiImageTextView)paramView.a).a(6.0F);
        ((MultiImageTextView)paramView.a).a((Drawable)localObject2, i, i);
        ((MultiImageTextView)paramView.a).c();
      }
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramView.a.getText().toString());
        ((StringBuilder)localObject2).append(paramView.b.getText().toString());
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.PublicAccountAdapter
 * JD-Core Version:    0.7.0.1
 */