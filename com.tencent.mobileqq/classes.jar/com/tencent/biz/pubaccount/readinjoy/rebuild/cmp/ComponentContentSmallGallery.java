package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ppu;

public class ComponentContentSmallGallery
  extends ComponentContentSmall
{
  TextView a;
  
  public ComponentContentSmallGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentSmallGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentSmallGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560114, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((TextView)paramView.findViewById(2131367345));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ppu))
    {
      paramObject = ((ppu)paramObject).a();
      this.a.setText(String.valueOf(paramObject.mGalleryPicNumber));
    }
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmallGallery
 * JD-Core Version:    0.7.0.1
 */