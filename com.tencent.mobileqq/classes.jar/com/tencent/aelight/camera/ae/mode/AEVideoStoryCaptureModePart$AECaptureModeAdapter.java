package com.tencent.aelight.camera.ae.mode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

class AEVideoStoryCaptureModePart$AECaptureModeAdapter
  extends PagerAdapter
{
  private Context b;
  private SparseArray<AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder> c;
  
  AEVideoStoryCaptureModePart$AECaptureModeAdapter(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart, Context paramContext)
  {
    this.b = paramContext;
    this.c = new SparseArray();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (AEVideoStoryCaptureModePart.b(this.a) == null) {
      return 0;
    }
    return AEVideoStoryCaptureModePart.b(this.a).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)this.c.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.b, 2064056329, null);
      localObject1 = new AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder(this);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).a = ((View)localObject2);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).b = ((TextView)((View)localObject2).findViewById(2063991262));
      this.c.put(paramInt, localObject1);
    }
    localObject2 = AEVideoStoryCaptureModePart.b(this.a)[paramInt];
    TextView localTextView = ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).b;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (AEVideoStoryCaptureModePart.f(this.a))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.b.getResources().getColor(2131165564));
    }
    else
    {
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165579));
      localTextView.setTextColor(this.b.getResources().getColor(2131168464));
    }
    if (AEVideoStoryCaptureModePart.i(this.a) == localObject2) {
      localTextView.setAlpha(1.0F);
    } else {
      localTextView.setAlpha(0.6F);
    }
    localTextView.setOnClickListener(new AEVideoStoryCaptureModePart.AECaptureModeAdapter.1(this, (AECaptureMode)localObject2, paramInt));
    paramViewGroup.addView(((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).a);
    return ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).a;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */