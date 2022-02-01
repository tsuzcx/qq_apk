package com.tencent.mobileqq.activity.history.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistorySelectBottomBar
{
  private View a;
  private View b;
  private View c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private QQBlurView i;
  private Context j;
  private ChatHistorySelectBottomBar.OnActionListener k;
  private View l;
  private CustomFastOnClickListener m = new ChatHistorySelectBottomBar.2(this);
  
  public ChatHistorySelectBottomBar(Context paramContext, ViewGroup paramViewGroup)
  {
    this.j = paramContext;
    this.a = paramViewGroup;
    this.b = LayoutInflater.from(paramContext).inflate(2131627033, null, false);
    Object localObject = paramViewGroup;
    if (!(paramViewGroup instanceof RelativeLayout))
    {
      localObject = new RelativeLayout(paramContext);
      paramViewGroup.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
    }
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(12);
    ((ViewGroup)localObject).addView(this.b, paramContext);
    this.d = ((ImageView)this.b.findViewById(2131432312));
    this.e = ((ImageView)this.b.findViewById(2131432311));
    this.f = ((ImageView)this.b.findViewById(2131432316));
    this.g = ((ImageView)this.b.findViewById(2131432313));
    this.h = ((ImageView)this.b.findViewById(2131432310));
    this.c = this.b.findViewById(2131432306);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.d.setOnClickListener(this.m);
    this.e.setOnClickListener(this.m);
    this.f.setOnClickListener(this.m);
    this.g.setOnClickListener(this.m);
    this.h.setOnClickListener(this.m);
    b();
  }
  
  private void a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView);
    while (!localArrayList.isEmpty())
    {
      int n = 0;
      paramView = (View)localArrayList.remove(0);
      if ((paramView instanceof ListView))
      {
        this.l = paramView;
        return;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        while (n < paramView.getChildCount())
        {
          localArrayList.add(paramView.getChildAt(n));
          n += 1;
        }
      }
    }
  }
  
  private boolean e()
  {
    if (!NetworkUtil.isNetSupport(this.j))
    {
      FileManagerUtil.l(this.j.getString(2131890731));
      return false;
    }
    return true;
  }
  
  public void a()
  {
    if (this.l == null)
    {
      a(this.a);
      if (this.l == null) {
        this.l = this.b;
      }
    }
    this.b.setVisibility(0);
    c();
  }
  
  public void a(@DrawableRes int paramInt)
  {
    this.d.setImageResource(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            this.d.setEnabled(paramBoolean);
            return;
          }
          this.h.setEnabled(paramBoolean);
          return;
        }
        this.f.setEnabled(paramBoolean);
        return;
      }
      this.g.setEnabled(paramBoolean);
      return;
    }
    this.e.setEnabled(paramBoolean);
  }
  
  public void a(ChatHistorySelectBottomBar.OnActionListener paramOnActionListener)
  {
    this.k = paramOnActionListener;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int n = ((Integer)paramList.next()).intValue();
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4)
            {
              if (n == 5) {
                this.d.setVisibility(0);
              }
            }
            else {
              this.h.setVisibility(0);
            }
          }
          else {
            this.f.setVisibility(0);
          }
        }
        else {
          this.g.setVisibility(0);
        }
      }
      else {
        this.e.setVisibility(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(1, paramBoolean);
    a(2, paramBoolean);
    a(3, paramBoolean);
    a(4, paramBoolean);
    a(5, paramBoolean);
  }
  
  public void b()
  {
    this.b.setVisibility(8);
    QQBlurView localQQBlurView = this.i;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.i = null;
    }
  }
  
  @TargetApi(19)
  protected void c()
  {
    QQBlurView localQQBlurView = this.i;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.i = null;
    }
    if (this.l == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.c.setBackgroundResource(2130845625);
      return;
    }
    this.i = ((QQBlurView)this.b.findViewById(2131449300));
    this.i.setVisibility(0);
    this.i.a(this.l);
    localQQBlurView = this.i;
    localQQBlurView.b(localQQBlurView);
    this.i.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.i.b(0);
    this.i.c(-1);
    this.i.a(8.0F);
    this.i.a(8);
    this.i.a(new ChatHistorySelectBottomBar.1(this));
    this.i.d();
    this.i.a();
  }
  
  public int d()
  {
    return AIOUtils.b(50.0F, this.j.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar
 * JD-Core Version:    0.7.0.1
 */