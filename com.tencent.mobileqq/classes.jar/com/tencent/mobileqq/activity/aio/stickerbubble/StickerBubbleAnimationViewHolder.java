package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StickerBubbleAnimationViewHolder
{
  private StickerBubbleAnimationView a;
  private StickerBubbleAnimationView b;
  private List<WeakReference<StickerBubbleAnimationViewHolder.AnimationViewCallback>> c = new LinkedList();
  private List<WeakReference<StickerBubbleAnimationViewHolder.AnimationViewCallback>> d = new LinkedList();
  private Context e = BaseApplicationImpl.getContext();
  private boolean f;
  private boolean g;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback h = new StickerBubbleAnimationViewHolder.1(this);
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback i = new StickerBubbleAnimationViewHolder.2(this);
  
  private void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramView.getParent() != null)
    {
      if (paramView.getParent() != paramViewGroup)
      {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
        paramViewGroup.addView(paramView);
      }
    }
    else {
      paramViewGroup.addView(paramView);
    }
    paramView.bringToFront();
  }
  
  private void a(List<WeakReference<StickerBubbleAnimationViewHolder.AnimationViewCallback>> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerBubbleAnimationViewHolder.AnimationViewCallback localAnimationViewCallback = (StickerBubbleAnimationViewHolder.AnimationViewCallback)((WeakReference)paramList.next()).get();
        if (localAnimationViewCallback != null) {
          localAnimationViewCallback.a();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public static StickerBubbleAnimationViewHolder b()
  {
    return StickerBubbleAnimationViewHolder.Holder.a();
  }
  
  private void b(List<WeakReference<StickerBubbleAnimationViewHolder.AnimationViewCallback>> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      StickerBubbleAnimationViewHolder.AnimationViewCallback localAnimationViewCallback = (StickerBubbleAnimationViewHolder.AnimationViewCallback)localWeakReference.get();
      if (localAnimationViewCallback != null) {
        localAnimationViewCallback.b();
      } else {
        paramList.remove(localWeakReference);
      }
    }
  }
  
  public StickerBubbleAnimationView a(Context paramContext)
  {
    paramContext = d(paramContext);
    if (this.g)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideSendAnimationView: ");
        localStringBuilder.append(paramContext);
        QLog.d("StickerBubbleAnimationViewHolder", 2, localStringBuilder.toString());
      }
      a(paramContext);
      this.g = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView a(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = d(paramContext);
    if (!this.g)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showSendAnimationView: ");
        localStringBuilder.append(paramContext.getParent());
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramViewGroup);
        QLog.d("StickerBubbleAnimationViewHolder", 2, localStringBuilder.toString());
      }
      a(paramViewGroup, paramContext);
      this.g = true;
    }
    return paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "cleanView");
    }
    if (this.f) {
      b(this.e);
    }
    if (this.g) {
      a(this.e);
    }
    this.a = null;
    this.b = null;
  }
  
  public void a(StickerBubbleAnimationViewHolder.AnimationViewCallback paramAnimationViewCallback)
  {
    try
    {
      this.c.add(new WeakReference(paramAnimationViewCallback));
      return;
    }
    finally
    {
      paramAnimationViewCallback = finally;
      throw paramAnimationViewCallback;
    }
  }
  
  public StickerBubbleAnimationView b(Context paramContext)
  {
    paramContext = c(paramContext);
    if (this.f)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideReceiveAnimationView: ");
        localStringBuilder.append(paramContext);
        QLog.d("StickerBubbleAnimationViewHolder", 2, localStringBuilder.toString());
      }
      a(paramContext);
      this.f = false;
    }
    return paramContext;
  }
  
  public StickerBubbleAnimationView b(ViewGroup paramViewGroup, Context paramContext)
  {
    paramContext = c(paramContext);
    if (!this.f)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showReceiveAnimationView: ");
        localStringBuilder.append(paramContext.getParent());
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramViewGroup);
        QLog.d("StickerBubbleAnimationViewHolder", 2, localStringBuilder.toString());
      }
      a(paramViewGroup, paramContext);
      this.f = true;
    }
    return paramContext;
  }
  
  public void b(StickerBubbleAnimationViewHolder.AnimationViewCallback paramAnimationViewCallback)
  {
    try
    {
      this.d.add(new WeakReference(paramAnimationViewCallback));
      return;
    }
    finally
    {
      paramAnimationViewCallback = finally;
      throw paramAnimationViewCallback;
    }
  }
  
  public StickerBubbleAnimationView c(Context paramContext)
  {
    if (this.a == null)
    {
      if (PEPanelHelper.k == null) {
        PEPanelHelper.b();
      }
      this.a = new StickerBubbleAnimationView(paramContext);
      this.a.setShowText(false, PEPanelHelper.k);
      this.a.a();
      this.a.setId(2131446389);
      this.a.setAnimationCallback(this.h);
    }
    return this.a;
  }
  
  public StickerBubbleAnimationView d(Context paramContext)
  {
    if (this.b == null)
    {
      if (PEPanelHelper.k == null) {
        PEPanelHelper.b();
      }
      this.b = new StickerBubbleAnimationView(paramContext);
      this.b.setShowText(true, PEPanelHelper.k);
      this.b.a();
      this.b.setId(2131446389);
      this.b.setAnimationCallback(this.i);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder
 * JD-Core Version:    0.7.0.1
 */