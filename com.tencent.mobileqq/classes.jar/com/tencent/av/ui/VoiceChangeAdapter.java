package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.AVLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceChangeAdapter
  extends BaseAdapter
{
  public static String a = "VoiceChangeAdapter";
  VoiceChangeItemView1.ICallback b;
  private VoiceChangeData.VoiceInfo[] c;
  private Context d;
  private VoiceChangeAdapter.ICallback e;
  private int f;
  private VoiceChangeItemView1 g;
  private VoiceChangeItemView1 h;
  private int i;
  private int j;
  private int k;
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(VoiceChangeData.VoiceInfo[] paramArrayOfVoiceInfo)
  {
    this.c = paramArrayOfVoiceInfo;
  }
  
  public int getCount()
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = this.c;
    if (arrayOfVoiceInfo == null) {
      return 0;
    }
    return arrayOfVoiceInfo.length;
  }
  
  public Object getItem(int paramInt)
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = this.c;
    if (arrayOfVoiceInfo == null) {
      return null;
    }
    return arrayOfVoiceInfo[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getView|position=");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", view=");
    ((StringBuilder)localObject2).append(paramView);
    AVLog.printDebugLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramView;
    if (paramView == null) {
      localObject1 = new VoiceChangeItemView1(this.d);
    }
    paramView = (VoiceChangeData.VoiceInfo)getItem(paramInt);
    if (paramView != null)
    {
      if ((this.k == 0) && (paramInt == 1) && (this.i == 0)) {
        this.g = this.h;
      }
      localObject2 = (VoiceChangeItemView1)localObject1;
      boolean bool;
      if (this.j == paramView.d) {
        bool = true;
      } else {
        bool = false;
      }
      ((VoiceChangeItemView1)localObject2).a(paramInt, paramView, bool, this.f, this.b);
      if (this.j == paramView.d)
      {
        if (paramInt != 0) {
          this.g = ((VoiceChangeItemView1)localObject2);
        }
        this.k = paramInt;
      }
    }
    this.h = ((VoiceChangeItemView1)localObject1);
    this.i = paramInt;
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeAdapter
 * JD-Core Version:    0.7.0.1
 */