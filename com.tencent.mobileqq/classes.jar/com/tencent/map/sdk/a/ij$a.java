package com.tencent.map.sdk.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
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
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NonNull
  public final View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    if ((this.a == null) || (this.a.size() == 0)) {
      return null;
    }
    Object localObject;
    if (paramView != null)
    {
      localObject = (ij.a.a)paramView.getTag();
      paramViewGroup = ((ij.a.a)localObject).a;
      localObject = ((ij.a.a)localObject).b;
    }
    for (;;)
    {
      paramViewGroup.setText(((IndoorLevel)this.a.get(paramInt)).getName());
      if (paramInt == ij.e(this.b)) {
        break;
      }
      paramViewGroup.setTextColor(ij.c());
      ((ImageView)localObject).setVisibility(4);
      return paramView;
      paramView = new FrameLayout(this.c);
      localObject = new ImageView(this.c);
      if (ij.b(this.b) != null) {
        ((ImageView)localObject).setImageBitmap(ij.b(this.b));
      }
      paramViewGroup = new FrameLayout.LayoutParams(ij.c(this.b).getMeasuredWidth(), (int)(ij.d(this.b) * 45.0F));
      paramViewGroup.gravity = 17;
      paramView.addView((View)localObject, paramViewGroup);
      paramViewGroup = new pc(this.c);
      paramViewGroup.setGravity(17);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, (int)(ij.d(this.b) * 45.0F));
      localLayoutParams.gravity = 17;
      paramView.addView(paramViewGroup, localLayoutParams);
      paramView.setTag(new ij.a.a(this, paramViewGroup, (ImageView)localObject));
    }
    paramViewGroup.setTextColor(-1);
    ((ImageView)localObject).setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ij.a
 * JD-Core Version:    0.7.0.1
 */