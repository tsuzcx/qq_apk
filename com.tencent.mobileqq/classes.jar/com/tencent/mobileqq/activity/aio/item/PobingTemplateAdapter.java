package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeData;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class PobingTemplateAdapter
  extends RecyclerView.Adapter<PobingTemplateAdapter.Holder>
  implements View.OnClickListener, PobingDecoder.DecodeCallBack
{
  private static final int[][] a;
  private int b = 2000;
  private PobingTemplateAdapter.Callback c;
  
  static
  {
    int[] arrayOfInt1 = { 2001, 2131892661, 2130848950, 1 };
    int[] arrayOfInt2 = { 2002, 2131892660, 2130848949, 2 };
    int[] arrayOfInt3 = { 2003, 2131892658, 2130848948, 3 };
    a = new int[][] { { 2000, 2131892659, 0, 4 }, arrayOfInt1, arrayOfInt2, arrayOfInt3 };
  }
  
  public PobingTemplateAdapter(PobingTemplateAdapter.Callback paramCallback)
  {
    this.c = paramCallback;
  }
  
  public static int a(int paramInt)
  {
    int[][] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int[] arrayOfInt1 = arrayOfInt[i];
      if (arrayOfInt1[0] == paramInt) {
        return arrayOfInt1[3];
      }
      i += 1;
    }
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public PobingTemplateAdapter.Holder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new PobingTemplateAdapter.Holder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628427, paramViewGroup, false));
  }
  
  public void a(PobingTemplateAdapter.Holder paramHolder, int paramInt)
  {
    Object localObject1 = a[paramInt];
    int j = 0;
    int k = localObject1[0];
    int i = localObject1[2];
    Object localObject2 = paramHolder.b;
    boolean bool = true;
    ((TextView)localObject2).setText(localObject1[1]);
    paramHolder.c.setImageResource(i);
    localObject1 = paramHolder.c;
    if (i != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject1).setVisibility(i);
    localObject1 = PobingDecoder.a(PobingManager.b(k));
    paramHolder.a.setId(k);
    paramHolder.a.setOnClickListener(this);
    localObject2 = paramHolder.a;
    if (localObject1 == null) {
      bool = false;
    }
    ((ImageView)localObject2).setClickable(bool);
    localObject2 = paramHolder.a;
    if (k == this.b) {
      i = 2130841341;
    } else {
      i = 0;
    }
    ((ImageView)localObject2).setImageResource(i);
    localObject2 = paramHolder.d;
    if (localObject1 == null) {
      i = j;
    } else {
      i = 8;
    }
    ((ProgressBar)localObject2).setVisibility(i);
    if (localObject1 != null)
    {
      if (k == 2003)
      {
        localObject1 = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), ((PobingDecoder.BitmapsCache)localObject1).a(2131440451));
        paramHolder.a.setBackgroundDrawable((Drawable)localObject1);
      }
      else
      {
        localObject2 = paramHolder.a.getResources();
        paramHolder.a.setBackgroundDrawable(new BitmapDrawable((Resources)localObject2, (Bitmap)((PobingDecoder.BitmapsCache)localObject1).c.get(Integer.valueOf(2131440451))));
      }
    }
    else
    {
      paramHolder.a.setBackgroundDrawable(null);
      new PobingDecoder(k, TroopPobingItemView.b, this);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(PobingDecoder.DecodeData paramDecodeData)
  {
    paramDecodeData = PobingDecoder.a(paramDecodeData, true);
    if (paramDecodeData == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new PobingTemplateAdapter.1(this, paramDecodeData));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = a;
      if (i >= localObject.length) {
        break;
      }
      if (paramInt == localObject[i][0])
      {
        this.b = paramInt;
        localObject = this.c;
        if (localObject != null) {
          ((PobingTemplateAdapter.Callback)localObject).a(paramInt);
        }
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  void c(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[][] arrayOfInt = a;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i][0])
      {
        notifyItemChanged(i);
        return;
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return a.length;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    b(i);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F9", a(i), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */