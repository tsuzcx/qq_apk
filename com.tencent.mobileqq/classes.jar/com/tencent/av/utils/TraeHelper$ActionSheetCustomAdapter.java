package com.tencent.av.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class TraeHelper$ActionSheetCustomAdapter
  extends BaseAdapter
{
  TraeHelper.SoundOutputRes a;
  private WeakReference<Context> b;
  private int c;
  private String[] d = null;
  
  TraeHelper$ActionSheetCustomAdapter(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    this.b = new WeakReference(paramContext);
    this.c = 0;
    this.a = paramSoundOutputRes;
    this.d = paramSoundOutputRes.b();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    if (paramContext != null) {
      this.b = new WeakReference(paramContext);
    }
    this.d = paramSoundOutputRes.b();
    this.a = paramSoundOutputRes;
    notifyDataSetInvalidated();
  }
  
  public void a(String paramString)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)getItem(i);
      if ((localIconAndName != null) && (localIconAndName.a != null) && (localIconAndName.a.equals(paramString)))
      {
        a(i);
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    TraeHelper.SoundOutputRes localSoundOutputRes = this.a;
    if (localSoundOutputRes != null) {
      return localSoundOutputRes.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a(this.d[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)getItem(paramInt);
    Object localObject = paramView;
    if (localIconAndName != null) {
      if (paramView == null)
      {
        localObject = new TraeHelper.ActionSheetCustomView((Context)this.b.get(), localIconAndName.b, localIconAndName.c);
      }
      else
      {
        localObject = (TraeHelper.ActionSheetCustomView)paramView;
        ((TraeHelper.ActionSheetCustomView)localObject).a(localIconAndName.c);
        paramView.setContentDescription(localIconAndName.c);
        ((TraeHelper.ActionSheetCustomView)localObject).a(localIconAndName.b);
        localObject = paramView;
      }
    }
    paramView = (TraeHelper.ActionSheetCustomView)localObject;
    boolean bool;
    if (paramInt == this.c) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.a(bool);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.ActionSheetCustomAdapter
 * JD-Core Version:    0.7.0.1
 */