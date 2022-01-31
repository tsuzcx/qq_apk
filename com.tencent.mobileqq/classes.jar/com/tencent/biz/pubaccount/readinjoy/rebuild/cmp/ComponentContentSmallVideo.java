package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pax;
import pyp;

public class ComponentContentSmallVideo
  extends ComponentContentSmall
{
  TextView a;
  
  public ComponentContentSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559862, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((TextView)paramView.findViewById(2131365421));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pax))
    {
      paramObject = ((pax)paramObject).a();
      if (paramObject != null) {}
    }
    else
    {
      return;
    }
    this.a.setText(pyp.a(paramObject.mVideoDuration));
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmallVideo
 * JD-Core Version:    0.7.0.1
 */