package com.tencent.biz;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;

public class PoiMapActivity$PoiItemAdapter
  extends BaseAdapter
{
  public ArrayList<PoiMapActivity.POI> a = new ArrayList();
  public boolean b = false;
  public int c = -1;
  public int d = 0;
  public boolean e;
  protected TextView f;
  
  public PoiMapActivity$PoiItemAdapter(PoiMapActivity paramPoiMapActivity) {}
  
  public PoiMapActivity.POI a(int paramInt)
  {
    int i = paramInt;
    if (this.b) {
      i = paramInt + 1;
    }
    if ((i < this.a.size()) && (i >= 0)) {
      return (PoiMapActivity.POI)this.a.get(i);
    }
    return null;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.a.size()) {
      return;
    }
    if (paramInt != this.c)
    {
      this.c = paramInt;
      notifyDataSetChanged();
      if ((paramInt != -1) && (paramBoolean))
      {
        PoiMapActivity.POI localPOI = a(paramInt);
        if (localPOI == null) {
          return;
        }
        this.g.mCurPoiName = localPOI.a;
        this.g.mCurPoiAdr = localPOI.b;
        PoiMapActivity.a(this.g, localPOI.f);
        this.g.q = localPOI.c;
        this.g.o = localPOI.k;
        this.g.p = localPOI.l;
        PoiMapActivity.o(this.g).b();
        TencentMap localTencentMap = PoiMapActivity.p(this.g);
        double d1 = localPOI.k;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        double d2 = localPOI.l;
        Double.isNaN(d2);
        localTencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((!this.b) && (this.f != null) && (!TextUtils.isEmpty(paramString))) {
      this.f.setText(paramString);
    }
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.d)
    {
      this.a.addAll(paramArrayList);
      this.e = paramBoolean;
      this.d += 1;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (paramView == null)
    {
      localObject1 = new PoiMapActivity.PoiItemViewHolder(this.g);
      paramView = LayoutInflater.from(this.g).inflate(2131626003, null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).d = paramView.findViewById(2131445751);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).e = ((ImageView)paramView.findViewById(2131445750));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131439135));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131427833));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).i = paramView.findViewById(2131445527);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).j = paramView.findViewById(2131438871);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).a = paramView.findViewById(2131431787);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).f = ((ImageView)paramView.findViewById(2131445749));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).g = ((ImageView)paramView.findViewById(2131448140));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).h = ((ImageView)paramView.findViewById(2131442919));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    if ((paramInt != this.a.size()) && ((!this.b) || (paramInt != this.a.size() - 1)))
    {
      PoiMapActivity.POI localPOI = a(paramInt);
      if ((paramInt == 0) && (!this.b)) {
        this.f = ((PoiMapActivity.PoiItemViewHolder)localObject1).c;
      }
      if (localPOI == null)
      {
        localObject1 = localObject2;
        break label579;
      }
      ((PoiMapActivity.PoiItemViewHolder)localObject1).j.setVisibility(8);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).e.setImageDrawable(null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).d.setVisibility(8);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).a.setVisibility(0);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).a.setBackgroundDrawable(null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).a.setBackgroundResource(this.g.h);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).b.setText(localPOI.a);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).c.setText(localPOI.b);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localPOI.a);
      ((StringBuilder)localObject2).append(localPOI.b);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramInt == this.c)
      {
        ((PoiMapActivity.PoiItemViewHolder)localObject1).b.setTextColor(this.g.k);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).c.setTextColor(this.g.k);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).i.setVisibility(0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.g.getString(2131892670));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        ((PoiMapActivity.PoiItemViewHolder)localObject1).b.setTextColor(this.g.f);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).c.setTextColor(this.g.e);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).i.setVisibility(4);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.g.getString(2131892671));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramView.setContentDescription((CharSequence)localObject1);
    }
    else
    {
      ((PoiMapActivity.PoiItemViewHolder)localObject1).j.setVisibility(0);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).a.setVisibility(8);
    }
    Object localObject1 = paramView;
    label579:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiItemAdapter
 * JD-Core Version:    0.7.0.1
 */