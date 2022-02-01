package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GAudioMemberListCtrl$GAudioMemberListAdapter
  extends BaseAdapter
{
  private GAudioMemberListCtrl$GAudioMemberListAdapter(GAudioMemberListCtrl paramGAudioMemberListCtrl) {}
  
  GAudioMemberListCtrl.ViewHolder a(View paramView, boolean paramBoolean)
  {
    GAudioMemberListCtrl.ViewHolder localViewHolder = new GAudioMemberListCtrl.ViewHolder(this.a, null);
    localViewHolder.b = ((ImageView)paramView.findViewById(2131441083));
    localViewHolder.c = ((TextView)paramView.findViewById(2131441099));
    localViewHolder.d = ((TextView)paramView.findViewById(2131441085));
    localViewHolder.e = ((ImageView)paramView.findViewById(2131441072));
    localViewHolder.h = ((TextView)paramView.findViewById(2131441104));
    localViewHolder.f = ((ImageView)paramView.findViewById(2131441101));
    if (!GAudioMemberListCtrl.a(this.a))
    {
      localViewHolder.e.setVisibility(8);
      localViewHolder.e.setEnabled(false);
      localViewHolder.e.setClickable(false);
    }
    localViewHolder.e.setOnClickListener(this.a.h);
    localViewHolder.l = paramBoolean;
    if (GAudioMemberListCtrl.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localViewHolder.c.setTextColor(Color.parseColor("#A8A8A8"));
      localViewHolder.h.setTextColor(Color.parseColor("#757575"));
      localViewHolder.g = paramView.findViewById(2131441103);
      localViewHolder.g.setBackgroundDrawable(UITools.a(10.4F, (Context)this.a.a.get()));
      paramView.findViewById(2131429675).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localViewHolder;
  }
  
  public int getCount()
  {
    return this.a.f.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.f.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = paramView;
    GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)this.a.f.get(paramInt);
    Object localObject1;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = this.a.e.inflate(2131625740, null);
      paramView = a((View)localObject1, localGAudioMemberInfo.k);
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject3 = (GAudioMemberListCtrl.ViewHolder)paramView.getTag();
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if (localObject3 == null)
      {
        paramView = a((View)localObject2, localGAudioMemberInfo.k);
        ((View)localObject2).setTag(paramView);
        localObject1 = localObject2;
      }
    }
    paramView.e.setTag(localGAudioMemberInfo);
    paramView.b.setTag(localGAudioMemberInfo);
    if ((localGAudioMemberInfo.d == null) || (localGAudioMemberInfo.f == null) || (!localGAudioMemberInfo.c)) {
      if (localGAudioMemberInfo.g == 0)
      {
        localObject2 = String.valueOf(localGAudioMemberInfo.a);
        localGAudioMemberInfo.d = this.a.d.a((String)localObject2, String.valueOf(this.a.b), this.a.c);
        if (localGAudioMemberInfo.d.compareTo((String)localObject2) != 0) {
          localGAudioMemberInfo.c = true;
        } else {
          localGAudioMemberInfo.c = false;
        }
        localObject3 = this.a.d.a((String)localObject2, String.valueOf(this.a.b), this.a.c, false, true);
        if (localGAudioMemberInfo.k)
        {
          localObject2 = localObject3;
          if (!GAudioMemberListCtrl.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = ImageUtil.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 != null)
        {
          localGAudioMemberInfo.f = ((Bitmap)localObject2);
        }
        else
        {
          localGAudioMemberInfo.f = null;
          localGAudioMemberInfo.c = false;
        }
      }
      else
      {
        long l = localGAudioMemberInfo.a;
        if (localGAudioMemberInfo.h != null) {
          localObject2 = localGAudioMemberInfo.h;
        } else {
          localObject2 = this.a.d.b(l, this.a.d.k().bm);
        }
        if ((localObject2 != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile != null))
        {
          localGAudioMemberInfo.d = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
          localObject3 = this.a.d.d(((AVPhoneUserInfo)localObject2).telInfo.mobile);
          if (localObject3 != null)
          {
            localGAudioMemberInfo.e = ContactUtils.b((String)localObject3);
            localGAudioMemberInfo.d = ((String)localObject3);
          }
          else
          {
            localGAudioMemberInfo.e = null;
            localGAudioMemberInfo.d = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
          }
        }
        else
        {
          if ((localObject2 != null) && (QLog.isColorLevel()))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getView --> can not get Open Id. PhoneInfo = ");
            ((StringBuilder)localObject3).append(((AVPhoneUserInfo)localObject2).toString());
            QLog.d("GAudioMemberListCtrl", 2, ((StringBuilder)localObject3).toString());
          }
          localGAudioMemberInfo.e = null;
          localGAudioMemberInfo.d = ((Context)this.a.a.get()).getResources().getString(2131890648);
        }
        localGAudioMemberInfo.f = ((BitmapDrawable)((Context)this.a.a.get()).getResources().getDrawable(2130843137)).getBitmap();
        localGAudioMemberInfo.c = true;
      }
    }
    paramView.j = true;
    paramView.a = localGAudioMemberInfo.a;
    if (localGAudioMemberInfo.d != null)
    {
      float f = paramView.c.getResources().getDimensionPixelSize(2131297547);
      localObject2 = UITools.a(paramView.c.getContext(), localGAudioMemberInfo.d, paramView.c, f);
      paramView.c.setText((CharSequence)localObject2);
    }
    else
    {
      paramView.c.setText(String.valueOf(localGAudioMemberInfo.a));
    }
    if (localGAudioMemberInfo.f != null)
    {
      if ((localGAudioMemberInfo.g != 0) && (localGAudioMemberInfo.e != null))
      {
        paramView.d.setVisibility(0);
        paramView.d.setText(localGAudioMemberInfo.e);
        localObject2 = ((BitmapDrawable)((Context)this.a.a.get()).getResources().getDrawable(2130843087)).getBitmap();
        paramView.b.setImageBitmap((Bitmap)localObject2);
      }
      else
      {
        paramView.d.setVisibility(8);
        paramView.b.setImageBitmap(localGAudioMemberInfo.f);
        if (localGAudioMemberInfo.g == 0) {
          paramView.b.setOnClickListener(this.a.g);
        }
      }
    }
    else
    {
      paramView.d.setVisibility(8);
      paramView.b.setImageResource(2130841060);
    }
    if (localGAudioMemberInfo.i)
    {
      if ((paramView.k == -1) || (paramView.k == 0))
      {
        this.a.a(paramView.e, localGAudioMemberInfo.i);
        paramView.k = 1;
      }
      localGAudioMemberInfo.b = false;
    }
    else if ((paramView.k == -1) || (paramView.k == 1))
    {
      this.a.a(paramView.e, localGAudioMemberInfo.i);
      paramView.k = 0;
    }
    paramView.i = localGAudioMemberInfo.b;
    if (paramView.i)
    {
      paramView.f.setVisibility(0);
      if (paramView.g != null) {
        paramView.g.setVisibility(0);
      }
    }
    else
    {
      paramView.f.setVisibility(8);
      if (paramView.g != null) {
        paramView.g.setVisibility(8);
      }
    }
    if (!localGAudioMemberInfo.k)
    {
      paramView.h.setVisibility(0);
      paramView.e.setVisibility(8);
    }
    else
    {
      if (GAudioMemberListCtrl.a(this.a)) {
        paramView.e.setVisibility(0);
      }
      paramView.h.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.GAudioMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */