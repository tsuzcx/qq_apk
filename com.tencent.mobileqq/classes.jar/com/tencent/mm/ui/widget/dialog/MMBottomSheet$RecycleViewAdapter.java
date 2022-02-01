package com.tencent.mm.ui.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.i.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public class MMBottomSheet$RecycleViewAdapter
  extends RecyclerView.Adapter<MMBottomSheet.RecycleViewAdapter.ViewHolder>
{
  AdapterView.OnItemClickListener a;
  private g c;
  
  public MMBottomSheet$RecycleViewAdapter(MMBottomSheet paramMMBottomSheet) {}
  
  public int getItemCount()
  {
    if (MMBottomSheet.D(this.b)) {
      return this.c.size() + MMBottomSheet.e(this.b).size() + 1;
    }
    return this.c.size() + MMBottomSheet.e(this.b).size();
  }
  
  public void onBindViewHolder(MMBottomSheet.RecycleViewAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    h localh;
    if (paramInt < this.c.size())
    {
      if (MMBottomSheet.u(this.b) >= this.c.size()) {
        MMBottomSheet.a(this.b, 0);
      }
      localh = (h)this.c.getItemList().get(paramInt);
      paramViewHolder.a.setText(localh.getTitle());
      paramViewHolder.a.setEllipsize(localh.a());
      if (localh.getIcon() != null)
      {
        paramViewHolder.c.setVisibility(0);
        paramViewHolder.c.setImageDrawable(localh.getIcon());
        if (MMBottomSheet.v(this.b)) {
          paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131168376));
        } else if (localh.g() != 0) {
          paramViewHolder.c.setIconColor(localh.g());
        } else {
          paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131168376));
        }
      }
      else if (MMBottomSheet.w(this.b) != null)
      {
        paramViewHolder.c.setVisibility(0);
        paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131168376));
        MMBottomSheet.w(this.b).a(paramViewHolder.c, localh);
      }
      else if (MMBottomSheet.x(this.b))
      {
        paramViewHolder.c.setVisibility(4);
      }
      else
      {
        paramViewHolder.c.setVisibility(8);
      }
      if (MMBottomSheet.y(this.b) != null) {
        MMBottomSheet.y(this.b).a(paramViewHolder.a, localh);
      }
      if (localh.f())
      {
        if ((!MMBottomSheet.z(this.b).booleanValue()) && (!MMBottomSheet.A(this.b))) {
          paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165611));
        } else {
          paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131168472));
        }
        if (MMBottomSheet.B(this.b))
        {
          if ((!MMBottomSheet.z(this.b).booleanValue()) && (!MMBottomSheet.A(this.b)))
          {
            paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131165220));
          }
          else
          {
            paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131165221));
            if (paramViewHolder.d != null) {
              paramViewHolder.d.setBackgroundResource(2130851294);
            }
          }
          if (paramViewHolder.d != null) {
            paramViewHolder.d.setAlpha(128);
          }
        }
        else
        {
          paramViewHolder.c.setAlpha(77);
          paramViewHolder.g.setBackgroundResource(2131168376);
        }
      }
      else
      {
        paramViewHolder.c.setAlpha(255);
        if (paramViewHolder.d != null) {
          paramViewHolder.d.setAlpha(255);
        }
        if ((!MMBottomSheet.z(this.b).booleanValue()) && (!MMBottomSheet.A(this.b)))
        {
          if (MMBottomSheet.B(this.b)) {
            paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165612));
          } else {
            paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165610));
          }
        }
        else
        {
          paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165214));
          if (MMBottomSheet.B(this.b))
          {
            if (localh.g() == MMBottomSheet.t(this.b).getResources().getColor(2131165265)) {
              paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131165216));
            }
            if (paramViewHolder.d != null) {
              paramViewHolder.d.setBackgroundResource(2130851294);
            }
          }
        }
      }
      if (paramViewHolder.b != null) {
        if ((localh.b() != null) && (localh.b().length() > 0))
        {
          paramViewHolder.b.setVisibility(0);
          paramViewHolder.b.setText(localh.b());
          if (MMBottomSheet.v(this.b)) {
            paramViewHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
          }
        }
        else
        {
          paramViewHolder.b.setVisibility(8);
        }
      }
      if (MMBottomSheet.v(this.b))
      {
        if (localh.f())
        {
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.b.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165611));
        }
        else
        {
          paramViewHolder.b.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165612));
          paramViewHolder.e.setVisibility(0);
          if (MMBottomSheet.u(this.b) == paramInt) {
            paramViewHolder.e.setChecked(true);
          } else {
            paramViewHolder.e.setChecked(false);
          }
        }
        paramViewHolder.f.setVisibility(0);
      }
      if (paramViewHolder.h != null) {
        if (localh.c()) {
          paramViewHolder.h.setVisibility(0);
        } else {
          paramViewHolder.h.setVisibility(8);
        }
      }
      if (paramViewHolder.i != null) {
        if (localh.e()) {
          paramViewHolder.i.setVisibility(0);
        } else {
          paramViewHolder.i.setVisibility(8);
        }
      }
      if ((MMBottomSheet.C(this.b)) && (MMBottomSheet.A(this.b)))
      {
        if (localh.g() != 0) {
          paramViewHolder.c.setIconColor(MMBottomSheet.t(this.b).getResources().getColor(2131165216));
        }
        if (paramViewHolder.f != null) {
          paramViewHolder.f.setBackgroundColor(MMBottomSheet.t(this.b).getResources().getColor(2131165210));
        }
      }
    }
    else if ((MMBottomSheet.e(this.b).size() > 0) && (paramInt < this.c.size() + MMBottomSheet.e(this.b).size()))
    {
      localh = (h)MMBottomSheet.e(this.b).getItemList().get(paramInt - this.c.size());
      paramViewHolder.a.setText(localh.getTitle());
      if (MMBottomSheet.u(this.b) >= this.c.size() + MMBottomSheet.e(this.b).size()) {
        MMBottomSheet.a(this.b, 0);
      }
      if (localh.getIcon() != null)
      {
        paramViewHolder.c.setVisibility(0);
        paramViewHolder.c.setImageDrawable(localh.getIcon());
      }
      else
      {
        paramViewHolder.c.setVisibility(8);
      }
      if (localh.f())
      {
        if ((!MMBottomSheet.z(this.b).booleanValue()) && (!MMBottomSheet.A(this.b))) {
          paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165611));
        } else {
          paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131168472));
        }
        paramViewHolder.g.setBackgroundResource(2131168376);
      }
      else if ((!MMBottomSheet.z(this.b).booleanValue()) && (!MMBottomSheet.A(this.b)))
      {
        paramViewHolder.a.setTextColor(paramViewHolder.a.getTextColors());
        paramViewHolder.g.setBackgroundResource(2130851742);
      }
      else
      {
        paramViewHolder.a.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165214));
        paramViewHolder.g.setBackgroundResource(2130851743);
      }
      if (paramViewHolder.b != null) {
        if (localh.b() != null)
        {
          paramViewHolder.b.setVisibility(0);
          paramViewHolder.b.setText(localh.b());
        }
        else
        {
          paramViewHolder.b.setVisibility(8);
        }
      }
      if (MMBottomSheet.v(this.b))
      {
        if (localh.f())
        {
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.b.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165611));
        }
        else
        {
          paramViewHolder.b.setTextColor(MMBottomSheet.t(this.b).getResources().getColor(2131165612));
          paramViewHolder.e.setVisibility(0);
          if (MMBottomSheet.u(this.b) == paramInt) {
            paramViewHolder.e.setChecked(true);
          } else {
            paramViewHolder.e.setChecked(false);
          }
        }
        paramViewHolder.f.setVisibility(0);
      }
    }
    else if (MMBottomSheet.D(this.b))
    {
      paramViewHolder.a.setText(2131887611);
      paramViewHolder.c.setImageResource(2131230760);
    }
    if ((MMBottomSheet.C(this.b)) && (!MMBottomSheet.E(this.b))) {
      paramViewHolder.c.setVisibility(8);
    }
  }
  
  public MMBottomSheet.RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (MMBottomSheet.s(this.b) == 0) {
      paramViewGroup = LayoutInflater.from(MMBottomSheet.t(this.b)).inflate(2131625437, paramViewGroup, false);
    } else if (MMBottomSheet.s(this.b) == 2) {
      paramViewGroup = LayoutInflater.from(MMBottomSheet.t(this.b)).inflate(2131625438, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(MMBottomSheet.t(this.b)).inflate(2131625439, paramViewGroup, false);
    }
    return new MMBottomSheet.RecycleViewAdapter.ViewHolder(this, paramViewGroup);
  }
  
  public void setMenu(g paramg)
  {
    this.c = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.RecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */