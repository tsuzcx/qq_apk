package com.tencent.biz;

import android.content.Context;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class PoiMapActivity$PoiTab
{
  final int a = 1;
  final int b = 2;
  final int c = 3;
  final int d = 4;
  public TextView e;
  public PoiMapActivity.TabView f;
  public XListView g;
  public PoiMapActivity.PoiItemAdapter h;
  public int i;
  public int j;
  public int k;
  
  public PoiMapActivity$PoiTab(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    this.i = paramInt;
    this.e = ((TextView)((PoiMapActivity)paramContext).findViewById(2131440470));
    this.e.setTextColor(paramPoiMapActivity.e);
    this.f = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.g = new XListView(paramContext);
    this.h = new PoiMapActivity.PoiItemAdapter(paramPoiMapActivity);
    this.g.setAdapter(this.h);
    this.g.setDivider(null);
    this.g.setVisibility(4);
    this.g.setOnItemClickListener(new PoiMapActivity.PoiTab.1(this, paramPoiMapActivity));
    this.g.setOnScrollListener(new PoiMapActivity.PoiTab.2(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.e.setVisibility(8);
          return;
        }
        this.e.setVisibility(0);
        this.e.setText(this.l.getString(2131892667));
        return;
      }
      this.e.setVisibility(0);
      this.e.setText(this.l.getString(2131892665));
      return;
    }
    this.e.setVisibility(0);
    this.e.setText(this.l.getString(2131891139));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.l.x)
    {
      this.h.a(paramInt, paramBoolean);
      return;
    }
    if ((this.i == 0) && (paramInt > 0) && (!this.h.b) && (this.l.V)) {
      this.l.V = false;
    }
    this.h.a(paramInt, paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.h.a(paramString);
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(3);
      return;
    }
    if (paramArrayList == null)
    {
      a(1);
      return;
    }
    this.h.a(paramArrayList, paramBoolean1, paramInt);
    if (this.l.r == this.i)
    {
      this.g.setVisibility(0);
      a(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.h.getCount() > 0)
      {
        this.g.setVisibility(0);
        a(4);
      }
    }
    else {
      this.g.setVisibility(4);
    }
    this.f.setSelect(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("POI list update isfirst = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PoiMapActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.j != this.l.m) || (this.k != this.l.n) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.g.setVisibility(4);
        this.h.a.clear();
        localObject = this.h;
        ((PoiMapActivity.PoiItemAdapter)localObject).d = 0;
        ((PoiMapActivity.PoiItemAdapter)localObject).e = false;
        ((PoiMapActivity.PoiItemAdapter)localObject).notifyDataSetChanged();
      }
      localObject = this.l;
      ((PoiMapActivity)localObject).a(((PoiMapActivity)localObject).m, this.l.n, "", this.l.am[this.f.d], this.h.d, 20);
      this.j = this.l.m;
      this.k = this.l.n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab
 * JD-Core Version:    0.7.0.1
 */