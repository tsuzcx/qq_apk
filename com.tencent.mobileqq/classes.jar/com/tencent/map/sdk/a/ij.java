package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.BaseMap;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public final class ij
  implements AdapterView.OnItemClickListener, gh, ik.a
{
  private static final int r = Color.argb(200, 56, 56, 56);
  public BaseMapView a;
  public boolean b = false;
  public boolean c = false;
  private RelativeLayout d;
  private ik e;
  private TextView f;
  private View g;
  private View h;
  private View i;
  private Bitmap j;
  private Bitmap k;
  private float l = 1.0F;
  private final int m = 45;
  private final int n = 4;
  private final int o = 90;
  private final int p = 10;
  private int q = 0;
  private ij.a s;
  private Context t;
  private int u = -1;
  private int v = 0;
  private IndoorBuilding w;
  private String x;
  private kj y;
  private ij.a.a z = null;
  
  public ij(BaseMapView paramBaseMapView)
  {
    this.a = paramBaseMapView;
    this.t = paramBaseMapView.getContext().getApplicationContext();
    this.b = true;
  }
  
  private int a(Adapter paramAdapter)
  {
    this.f.measure(0, 0);
    int i2 = this.f.getMeasuredWidth();
    int i5 = paramAdapter.getCount();
    View localView = null;
    int i1 = 0;
    while (i1 < i5)
    {
      localView = paramAdapter.getView(i1, localView, this.e);
      localView.measure(0, 0);
      int i4 = localView.getMeasuredWidth();
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private void d()
  {
    if (this.d == null)
    {
      this.s = new ij.a(this, this.t, new ArrayList());
      this.l = this.t.getApplicationContext().getResources().getDisplayMetrics().density;
      double d1 = this.l;
      Double.isNaN(d1);
      this.q = ((int)(d1 * 234.0D));
      Object localObject1 = this.t;
      this.j = fy.b((Context)localObject1, "indoor_background.9.png");
      this.k = fy.b((Context)localObject1, "item_selected_background.png");
      localObject1 = this.t;
      Object localObject2 = this.s;
      this.d = new RelativeLayout((Context)localObject1);
      this.f = new pc((Context)localObject1);
      this.f.setSingleLine(true);
      this.g = new View((Context)localObject1);
      this.e = new ik((Context)localObject1);
      this.h = new View((Context)localObject1);
      this.i = new View((Context)localObject1);
      this.e.setChoiceMode(1);
      this.e.setAdapter((ListAdapter)localObject2);
      this.e.setOnItemClickListener(this);
      this.e.setVerticalScrollBarEnabled(false);
      this.e.setHorizontalScrollBarEnabled(false);
      this.e.setOverScrollMode(2);
      localObject2 = this.e;
      localObject1 = null;
      ((ik)localObject2).setDivider(null);
      this.e.setDividerHeight(0);
      this.e.setOnDataChangedListener(this);
      localObject2 = new RelativeLayout.LayoutParams((int)(this.l * 30.0F), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.l * 6.0F));
      Object localObject3 = this.f;
      ((TextView)localObject3).setId(localObject3.hashCode());
      this.f.setText("楼层");
      this.f.setTextSize(12.0F);
      this.f.setGravity(17);
      this.f.setTextColor(Color.argb(200, 56, 56, 56));
      this.d.addView(this.f, (ViewGroup.LayoutParams)localObject2);
      float f1 = this.l;
      localObject2 = new RelativeLayout.LayoutParams((int)(30.0F * f1), (int)(f1 * 1.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.f.getId());
      ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.l * 6.0F));
      this.g.setBackgroundColor(-3355444);
      localObject3 = this.g;
      ((View)localObject3).setId(localObject3.hashCode());
      this.d.addView(this.g, (ViewGroup.LayoutParams)localObject2);
      localObject2 = this.j;
      if (localObject2 != null)
      {
        localObject3 = ((Bitmap)localObject2).getNinePatchChunk();
        localObject2 = ByteBuffer.wrap((byte[])localObject3).order(ByteOrder.nativeOrder());
        if (((ByteBuffer)localObject2).get() != 0)
        {
          localObject1 = new ov();
          ((ov)localObject1).b = new int[((ByteBuffer)localObject2).get()];
          ((ov)localObject1).c = new int[((ByteBuffer)localObject2).get()];
          ((ov)localObject1).d = new int[((ByteBuffer)localObject2).get()];
          ov.a(((ov)localObject1).b.length);
          ov.a(((ov)localObject1).c.length);
          ((ByteBuffer)localObject2).getInt();
          ((ByteBuffer)localObject2).getInt();
          ((ov)localObject1).a.left = ((ByteBuffer)localObject2).getInt();
          ((ov)localObject1).a.right = ((ByteBuffer)localObject2).getInt();
          ((ov)localObject1).a.top = ((ByteBuffer)localObject2).getInt();
          ((ov)localObject1).a.bottom = ((ByteBuffer)localObject2).getInt();
          ((ByteBuffer)localObject2).getInt();
          ov.a(((ov)localObject1).b, (ByteBuffer)localObject2);
          ov.a(((ov)localObject1).c, (ByteBuffer)localObject2);
          ov.a(((ov)localObject1).d, (ByteBuffer)localObject2);
        }
        localObject2 = new Rect();
        if (localObject1 != null) {
          localObject2 = ((ov)localObject1).a;
        }
        localObject1 = new NinePatchDrawable(this.t.getResources(), this.j, (byte[])localObject3, (Rect)localObject2, null);
        this.d.setBackgroundDrawable((Drawable)localObject1);
      }
      f1 = this.l;
      localObject1 = new RelativeLayout.LayoutParams((int)(25.0F * f1), (int)(f1 * 180.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.g.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
      this.d.addView(this.e, (ViewGroup.LayoutParams)localObject1);
      a(this.a);
      this.d.measure(0, 0);
      this.d.setVisibility(8);
      if ((this.a.getMap() != null) && (this.a.getMap().getMapManager() != null) && (this.a.getMap().getMapManager().b != null)) {
        this.y = this.a.getMap().getMapManager().b.o;
      }
    }
  }
  
  private void e()
  {
    ik localik = this.e;
    if (localik != null)
    {
      ((RelativeLayout.LayoutParams)localik.getLayoutParams()).width = a(this.s);
      this.e.requestLayout();
    }
  }
  
  public final void a()
  {
    Bitmap localBitmap = this.j;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.k;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.b) && (paramInt2 < this.q + this.l * 90.0F))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public final void a(IndoorBuilding paramIndoorBuilding)
  {
    if (paramIndoorBuilding == null) {
      return;
    }
    if (this.d == null) {
      d();
    }
    this.w = paramIndoorBuilding;
    paramIndoorBuilding = paramIndoorBuilding.getLevels();
    if (this.a != null)
    {
      if ((paramIndoorBuilding.size() < 4) && (paramIndoorBuilding.size() != this.v))
      {
        localObject = (FrameLayout.LayoutParams)this.d.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).height = ((int)(this.q - (4 - paramIndoorBuilding.size()) * 45 * this.l));
        this.a.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        int i1 = paramIndoorBuilding.size();
        int i2 = this.v;
        if ((i1 != i2) && (i2 < 4))
        {
          localObject = (FrameLayout.LayoutParams)this.d.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).height = this.q;
          this.a.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject);
        }
      }
      this.v = paramIndoorBuilding.size();
      Object localObject = this.s;
      if (localObject != null)
      {
        ((ij.a)localObject).a = paramIndoorBuilding;
        ((ij.a)localObject).notifyDataSetChanged();
      }
      if (this.d.getVisibility() != 0) {
        this.d.post(new ij.1(this));
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((BaseMapView)localObject).getMap() == null) {
        return;
      }
      if (this.d == null)
      {
        if (!paramBoolean) {
          return;
        }
        d();
      }
      localObject = this.a.getMap();
      if ((this.b) && (paramBoolean))
      {
        kj localkj = this.y;
        if ((localkj != null) && (localkj.h))
        {
          a(((BaseMap)localObject).getMapManager().p());
          return;
        }
      }
      if (this.d.getVisibility() == 0) {
        this.d.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.indexOfChild(this.d) < 0)
    {
      RelativeLayout localRelativeLayout = this.d;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, this.q);
      localLayoutParams.gravity = 83;
      float f1 = this.l;
      localLayoutParams.leftMargin = ((int)(10.0F * f1));
      localLayoutParams.bottomMargin = ((int)(f1 * 90.0F));
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
    }
    e();
    return true;
  }
  
  public final void b()
  {
    e();
    Object localObject = this.w;
    if (localObject != null)
    {
      int i1 = ((IndoorBuilding)localObject).getActiveLevelIndex();
      localObject = this.w.getLevels();
      if ((localObject != null) && (i1 < ((List)localObject).size()))
      {
        if (i1 == -1) {
          return;
        }
        if ((IndoorLevel)((List)localObject).get(i1) != null)
        {
          localObject = this.x;
          if ((localObject != null) && (this.c) && (((String)localObject).equals(this.w.getBuidlingId())))
          {
            this.e.setItemChecked(i1, true);
            this.c = false;
          }
          else
          {
            localObject = this.e;
            double d1 = this.l * 45.0F;
            Double.isNaN(d1);
            ((ik)localObject).setSelectionFromTop(i1, (int)(d1 + 0.5D) * 2);
          }
          this.u = i1;
          this.x = this.w.getBuidlingId();
        }
      }
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BaseMap localBaseMap = this.a.getMap();
    if (localBaseMap != null)
    {
      ij.a.a locala = this.z;
      if (locala != null)
      {
        locala.a.setTextColor(-16777216);
        this.z.b.setVisibility(4);
      }
      locala = (ij.a.a)paramView.getTag();
      locala.a.setTextColor(-1);
      locala.b.setVisibility(0);
      this.z = locala;
      this.u = paramInt;
      this.c = true;
      localBaseMap.setIndoorFloor(paramInt);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ij
 * JD-Core Version:    0.7.0.1
 */