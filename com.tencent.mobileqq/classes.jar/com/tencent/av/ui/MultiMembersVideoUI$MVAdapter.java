package com.tencent.av.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MultiMembersVideoUI$MVAdapter
  extends BaseAdapter
{
  MultiMembersVideoUI$MVAdapter(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.f = ((ViewGroup)paramView.findViewById(2131441086));
    localHolder.g = ((ImageView)paramView.findViewById(2131441083));
    localHolder.h = ((TextView)paramView.findViewById(2131441099));
    localHolder.c = ((ImageView)paramView.findViewById(2131441101));
    localHolder.i = ((TextView)paramView.findViewById(2131441085));
    localHolder.m = ((ImageView)paramView.findViewById(2131441098));
    localHolder.p = ((ImageView)paramView.findViewById(2131441084));
    if ((this.a.o) && (localHolder.h != null) && (localHolder.g != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localHolder.h.setTextSize(12.0F);
      double d = f;
      Double.isNaN(d);
      int i = (int)(d * 1.5D);
      localHolder.g.setPadding(i, i, i, i);
    }
    if (localHolder.h != null) {
      if (this.a.d) {
        localHolder.h.setTextColor(this.a.getResources().getColor(2131166789));
      } else {
        localHolder.h.setTextColor(this.a.getResources().getColor(2131166789));
      }
    }
    if (localHolder.f != null)
    {
      paramView = (RelativeLayout.LayoutParams)localHolder.f.getLayoutParams();
      if (this.a.d)
      {
        paramView.width = this.a.getResources().getDimensionPixelSize(2131298552);
        paramView.height = this.a.getResources().getDimensionPixelSize(2131298551);
      }
      else
      {
        paramView.width = this.a.getResources().getDimensionPixelSize(2131298558);
        paramView.height = this.a.getResources().getDimensionPixelSize(2131298556);
      }
      localHolder.f.setLayoutParams(paramView);
    }
    return localHolder;
  }
  
  public int getCount()
  {
    if (((this.a.c == 1) || (this.a.c == 2)) && (this.a.l.size() > 8)) {
      return 8;
    }
    return this.a.l.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.l.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = paramView;
    if ((paramInt != 0) || (localObject2 == null) || (paramViewGroup.getChildCount() == paramInt)) {
      for (;;)
      {
        Object localObject1;
        if (localObject2 == null)
        {
          paramView = this.a.k.inflate(2131625773, null);
          localObject1 = a(paramView);
          paramView.setTag(localObject1);
        }
        else
        {
          localObject3 = (MultiMembersUI.Holder)paramView.getTag();
          paramView = (View)localObject2;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = a((View)localObject2);
            paramView = (View)localObject2;
          }
        }
        Object localObject3 = (MultiMembersUI.MVMembersInfo)this.a.l.get(paramInt);
        if ((((MultiMembersUI.MVMembersInfo)localObject3).g == null) || (((MultiMembersUI.MVMembersInfo)localObject3).i == null) || (!((MultiMembersUI.MVMembersInfo)localObject3).f)) {
          if (((MultiMembersUI.MVMembersInfo)localObject3).j == 0)
          {
            localObject2 = String.valueOf(((MultiMembersUI.MVMembersInfo)localObject3).a);
            ((MultiMembersUI.MVMembersInfo)localObject3).g = this.a.j.a((String)localObject2, String.valueOf(this.a.b), this.a.c);
            if (((MultiMembersUI.MVMembersInfo)localObject3).g.compareTo((String)localObject2) != 0) {
              ((MultiMembersUI.MVMembersInfo)localObject3).f = true;
            } else {
              ((MultiMembersUI.MVMembersInfo)localObject3).f = false;
            }
            localObject2 = this.a.j.a((String)localObject2, String.valueOf(this.a.b), this.a.c, false, true);
            if (localObject2 != null)
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).i = ((Bitmap)localObject2);
            }
            else
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).i = null;
              ((MultiMembersUI.MVMembersInfo)localObject3).f = false;
            }
          }
          else
          {
            long l = ((MultiMembersUI.MVMembersInfo)localObject3).a;
            if (((MultiMembersUI.MVMembersInfo)localObject3).l != null) {
              localObject2 = ((MultiMembersUI.MVMembersInfo)localObject3).l;
            } else {
              localObject2 = this.a.j.b(l, this.a.j.k().bm);
            }
            Object localObject4;
            if ((localObject2 != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile != null))
            {
              ((MultiMembersUI.MVMembersInfo)localObject3).g = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
              localObject4 = this.a.j.d(((AVPhoneUserInfo)localObject2).telInfo.mobile);
              if (localObject4 != null)
              {
                ((MultiMembersUI.MVMembersInfo)localObject3).h = ContactUtils.b((String)localObject4);
                ((MultiMembersUI.MVMembersInfo)localObject3).g = ((String)localObject4);
              }
              else
              {
                ((MultiMembersUI.MVMembersInfo)localObject3).h = null;
                ((MultiMembersUI.MVMembersInfo)localObject3).g = PstnUtils.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
              }
            }
            else
            {
              if ((localObject2 != null) && (QLog.isColorLevel()))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("getView --> can not get Open Id. PhoneInfo = ");
                ((StringBuilder)localObject4).append(((AVPhoneUserInfo)localObject2).toString());
                QLog.d("MultiMembersVideoUI", 2, ((StringBuilder)localObject4).toString());
              }
              ((MultiMembersUI.MVMembersInfo)localObject3).h = null;
              ((MultiMembersUI.MVMembersInfo)localObject3).g = MultiMembersVideoUI.b(this.a).getString(2131890648);
            }
            ((MultiMembersUI.MVMembersInfo)localObject3).i = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130843137)).getBitmap();
            ((MultiMembersUI.MVMembersInfo)localObject3).f = true;
          }
        }
        if (((this.a.c == 1) || (this.a.c == 2)) && (paramInt == 7) && (this.a.l.size() > 8))
        {
          ((MultiMembersUI.Holder)localObject1).l = false;
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setShape(1);
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
          ((MultiMembersUI.Holder)localObject1).g.setImageDrawable((Drawable)localObject2);
          ((MultiMembersUI.Holder)localObject1).i = ((TextView)paramView.findViewById(2131441085));
          localObject2 = new StringBuilder("");
          ((StringBuilder)localObject2).append(this.a.l.size() - 8 + 1);
          ((StringBuilder)localObject2).append("+");
          ((MultiMembersUI.Holder)localObject1).i.setText(((StringBuilder)localObject2).toString());
          ((MultiMembersUI.Holder)localObject1).i.setTextColor(-1);
          ((MultiMembersUI.Holder)localObject1).i.setVisibility(0);
          ((MultiMembersUI.Holder)localObject1).h.setText("");
          paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131890647));
          localObject2 = paramView;
        }
        else
        {
          ((MultiMembersUI.Holder)localObject1).l = true;
          ((MultiMembersUI.Holder)localObject1).a = ((MultiMembersUI.MVMembersInfo)localObject3).a;
          if (((MultiMembersUI.MVMembersInfo)localObject3).g != null) {
            ((MultiMembersUI.Holder)localObject1).h.setText(((MultiMembersUI.MVMembersInfo)localObject3).g);
          } else {
            ((MultiMembersUI.Holder)localObject1).h.setText(String.valueOf(((MultiMembersUI.MVMembersInfo)localObject3).a));
          }
          if (((MultiMembersUI.MVMembersInfo)localObject3).i != null)
          {
            if ((((MultiMembersUI.MVMembersInfo)localObject3).j != 0) && (((MultiMembersUI.MVMembersInfo)localObject3).h != null))
            {
              ((MultiMembersUI.Holder)localObject1).i.setVisibility(0);
              ((MultiMembersUI.Holder)localObject1).i.setText(((MultiMembersUI.MVMembersInfo)localObject3).h);
              localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130843087)).getBitmap();
              ((MultiMembersUI.Holder)localObject1).g.setImageBitmap((Bitmap)localObject2);
            }
            else
            {
              ((MultiMembersUI.Holder)localObject1).i.setVisibility(8);
              ((MultiMembersUI.Holder)localObject1).g.setImageBitmap(((MultiMembersUI.MVMembersInfo)localObject3).i);
            }
          }
          else
          {
            ((MultiMembersUI.Holder)localObject1).i.setVisibility(8);
            ((MultiMembersUI.Holder)localObject1).g.setImageResource(2130841060);
          }
          if (((this.a.j.k().aQ == 1) && (this.a.j.k().o == 10)) || (this.a.j.k().aQ == 2)) {
            if (((MultiMembersUI.MVMembersInfo)localObject3).m)
            {
              if (((MultiMembersUI.Holder)localObject1).m.getVisibility() != 0) {
                ((MultiMembersUI.Holder)localObject1).m.setVisibility(0);
              }
              if (((MultiMembersUI.Holder)localObject1).c.getVisibility() == 0) {
                ((MultiMembersUI.Holder)localObject1).c.setVisibility(8);
              }
              ((MultiMembersUI.MVMembersInfo)localObject3).b = false;
            }
            else if (((MultiMembersUI.Holder)localObject1).m.getVisibility() == 0)
            {
              ((MultiMembersUI.Holder)localObject1).m.setVisibility(8);
            }
          }
          ((MultiMembersUI.Holder)localObject1).k = ((MultiMembersUI.MVMembersInfo)localObject3).b;
          if (((MultiMembersUI.Holder)localObject1).k) {
            ((MultiMembersUI.Holder)localObject1).c.setVisibility(0);
          } else {
            ((MultiMembersUI.Holder)localObject1).c.setVisibility(8);
          }
          if (((MultiMembersUI.MVMembersInfo)localObject3).d == 2) {
            ((MultiMembersUI.Holder)localObject1).b = 5;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).e) {
            ((MultiMembersUI.Holder)localObject1).b = 3;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).d == 1) {
            ((MultiMembersUI.Holder)localObject1).b = 2;
          } else if (((MultiMembersUI.MVMembersInfo)localObject3).c) {
            ((MultiMembersUI.Holder)localObject1).b = 1;
          } else {
            ((MultiMembersUI.Holder)localObject1).b = 0;
          }
          localObject2 = paramView;
          if (((MultiMembersUI.Holder)localObject1).g != null) {
            if ((this.a.j.k().aQ != 1) || (this.a.j.k().o != 10))
            {
              localObject2 = paramView;
              if (this.a.c != 2) {}
            }
            else
            {
              localObject2 = paramView;
              if (!((MultiMembersUI.MVMembersInfo)localObject3).o)
              {
                localObject3 = ((MultiMembersUI.Holder)localObject1).g.getDrawable();
                localObject2 = paramView;
                if (localObject3 != null)
                {
                  localObject2 = paramView;
                  if ((localObject3 instanceof BitmapDrawable))
                  {
                    localObject2 = ImageUtil.a(((BitmapDrawable)localObject3).getBitmap(), true);
                    ((MultiMembersUI.Holder)localObject1).g.setImageBitmap((Bitmap)localObject2);
                    localObject2 = paramView;
                  }
                }
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI.MVAdapter
 * JD-Core Version:    0.7.0.1
 */