package com.tencent.map.sdk.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.util.List;

final class ij$a
  extends BaseAdapter
{
  List<IndoorLevel> a;
  private Context c;
  
  public ij$a(Context paramContext, List<IndoorLevel> paramList)
  {
    this.c = paramList;
    Object localObject;
    this.a = localObject;
  }
  
  public final int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList == null) {
      return null;
    }
    return localList.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NonNull
  public final View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      Object localObject2;
      ImageView localImageView;
      if (paramView != null)
      {
        localObject1 = (ij.a.a)paramView.getTag();
        localObject2 = ((ij.a.a)localObject1).a;
        localImageView = ((ij.a.a)localObject1).b;
        localObject1 = paramView;
      }
      else
      {
        localObject1 = new FrameLayout(this.c);
        localImageView = new ImageView(this.c);
        if (ij.b(this.b) != null) {
          localImageView.setImageBitmap(ij.b(this.b));
        }
        localObject2 = new FrameLayout.LayoutParams(ij.c(this.b).getMeasuredWidth(), (int)(ij.d(this.b) * 45.0F));
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((FrameLayout)localObject1).addView(localImageView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new pc(this.c);
        ((TextView)localObject2).setGravity(17);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, (int)(ij.d(this.b) * 45.0F));
        localLayoutParams.gravity = 17;
        ((FrameLayout)localObject1).addView((View)localObject2, localLayoutParams);
        ((FrameLayout)localObject1).setTag(new ij.a.a(this, (TextView)localObject2, localImageView));
      }
      ((TextView)localObject2).setText(((IndoorLevel)this.a.get(paramInt)).getName());
      if (paramInt != ij.e(this.b))
      {
        ((TextView)localObject2).setTextColor(ij.c());
        localImageView.setVisibility(4);
      }
      else
      {
        ((TextView)localObject2).setTextColor(-1);
        localImageView.setVisibility(0);
      }
    }
    else
    {
      localObject1 = null;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ij.a
 * JD-Core Version:    0.7.0.1
 */