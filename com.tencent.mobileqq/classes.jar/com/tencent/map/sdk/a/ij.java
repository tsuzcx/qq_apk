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
    int i1 = this.f.getMeasuredWidth();
    View localView = null;
    int i4 = paramAdapter.getCount();
    int i2 = 0;
    if (i2 < i4)
    {
      localView = paramAdapter.getView(i2, localView, this.e);
      localView.measure(0, 0);
      int i3 = localView.getMeasuredWidth();
      if (i3 <= i1) {
        break label83;
      }
      i1 = i3;
    }
    label83:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private void d()
  {
    Object localObject1;
    Object localObject2;
    byte[] arrayOfByte;
    if (this.d == null)
    {
      this.s = new ij.a(this, this.t, new ArrayList());
      this.l = this.t.getApplicationContext().getResources().getDisplayMetrics().density;
      this.q = ((int)(234.0D * this.l));
      localObject1 = this.t;
      this.j = fy.b((Context)localObject1, "indoor_background.9.png");
      this.k = fy.b((Context)localObject1, "item_selected_background.png");
      localObject1 = this.t;
      localObject2 = this.s;
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
      this.e.setDivider(null);
      this.e.setDividerHeight(0);
      this.e.setOnDataChangedListener(this);
      localObject1 = new RelativeLayout.LayoutParams((int)(30.0F * this.l), -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(6.0F * this.l));
      this.f.setId(this.f.hashCode());
      this.f.setText("楼层");
      this.f.setTextSize(12.0F);
      this.f.setGravity(17);
      this.f.setTextColor(Color.argb(200, 56, 56, 56));
      this.d.addView(this.f, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout.LayoutParams((int)(30.0F * this.l), (int)(1.0F * this.l));
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.f.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(6.0F * this.l));
      this.g.setBackgroundColor(-3355444);
      this.g.setId(this.g.hashCode());
      this.d.addView(this.g, (ViewGroup.LayoutParams)localObject1);
      if (this.j != null)
      {
        arrayOfByte = this.j.getNinePatchChunk();
        localObject2 = ByteBuffer.wrap(arrayOfByte).order(ByteOrder.nativeOrder());
        if (((ByteBuffer)localObject2).get() != 0) {
          break label677;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      localObject2 = new Rect();
      if (localObject1 != null) {
        localObject2 = ((ov)localObject1).a;
      }
      localObject1 = new NinePatchDrawable(this.t.getResources(), this.j, arrayOfByte, (Rect)localObject2, null);
      this.d.setBackgroundDrawable((Drawable)localObject1);
      localObject1 = new RelativeLayout.LayoutParams((int)(25.0F * this.l), (int)(180.0F * this.l));
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.g.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
      this.d.addView(this.e, (ViewGroup.LayoutParams)localObject1);
      a(this.a);
      this.d.measure(0, 0);
      this.d.setVisibility(8);
      if ((this.a.getMap() != null) && (this.a.getMap().getMapManager() != null) && (this.a.getMap().getMapManager().b != null)) {
        this.y = this.a.getMap().getMapManager().b.o;
      }
      return;
      label677:
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
  }
  
  private void e()
  {
    if (this.e != null)
    {
      ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).width = a(this.s);
      this.e.requestLayout();
    }
  }
  
  public final void a()
  {
    if (this.j != null) {
      this.j.recycle();
    }
    if (this.k != null) {
      this.k.recycle();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.b) && (paramInt2 < this.q + 90.0F * this.l))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public final void a(IndoorBuilding paramIndoorBuilding)
  {
    if (paramIndoorBuilding == null) {}
    do
    {
      return;
      if (this.d == null) {
        d();
      }
      this.w = paramIndoorBuilding;
      paramIndoorBuilding = paramIndoorBuilding.getLevels();
    } while (this.a == null);
    Object localObject;
    if ((paramIndoorBuilding.size() < 4) && (paramIndoorBuilding.size() != this.v))
    {
      localObject = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = ((int)(this.q - (4 - paramIndoorBuilding.size()) * 45 * this.l));
      this.a.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.v = paramIndoorBuilding.size();
      if (this.s != null)
      {
        localObject = this.s;
        ((ij.a)localObject).a = paramIndoorBuilding;
        ((ij.a)localObject).notifyDataSetChanged();
      }
      if (this.d.getVisibility() == 0) {
        break;
      }
      this.d.post(new ij.1(this));
      return;
      if ((paramIndoorBuilding.size() != this.v) && (this.v < 4))
      {
        localObject = (FrameLayout.LayoutParams)this.d.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).height = this.q;
        this.a.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.getMap() == null)) {}
    do
    {
      do
      {
        return;
        if (this.d != null) {
          break;
        }
      } while (!paramBoolean);
      d();
      BaseMap localBaseMap = this.a.getMap();
      if ((this.b) && (paramBoolean) && (this.y != null) && (this.y.h))
      {
        a(localBaseMap.getMapManager().p());
        return;
      }
    } while (this.d.getVisibility() != 0);
    this.d.setVisibility(8);
  }
  
  public final boolean a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.indexOfChild(this.d) < 0)
    {
      RelativeLayout localRelativeLayout = this.d;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, this.q);
      localLayoutParams.gravity = 83;
      localLayoutParams.leftMargin = ((int)(10.0F * this.l));
      localLayoutParams.bottomMargin = ((int)(90.0F * this.l));
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
    }
    e();
    return true;
  }
  
  public final void b()
  {
    e();
    int i1;
    List localList;
    if (this.w != null)
    {
      i1 = this.w.getActiveLevelIndex();
      localList = this.w.getLevels();
      if ((localList != null) && (i1 < localList.size()) && (i1 != -1)) {
        break label47;
      }
    }
    label47:
    while ((IndoorLevel)localList.get(i1) == null) {
      return;
    }
    if ((this.x != null) && (this.c) && (this.x.equals(this.w.getBuidlingId())))
    {
      this.e.setItemChecked(i1, true);
      this.c = false;
    }
    for (;;)
    {
      this.u = i1;
      this.x = this.w.getBuidlingId();
      return;
      this.e.setSelectionFromTop(i1, (int)(45.0F * this.l + 0.5D) * 2);
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BaseMap localBaseMap = this.a.getMap();
    if (localBaseMap == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (this.z != null)
      {
        this.z.a.setTextColor(-16777216);
        this.z.b.setVisibility(4);
      }
      ij.a.a locala = (ij.a.a)paramView.getTag();
      locala.a.setTextColor(-1);
      locala.b.setVisibility(0);
      this.z = locala;
      this.u = paramInt;
      this.c = true;
      localBaseMap.setIndoorFloor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ij
 * JD-Core Version:    0.7.0.1
 */