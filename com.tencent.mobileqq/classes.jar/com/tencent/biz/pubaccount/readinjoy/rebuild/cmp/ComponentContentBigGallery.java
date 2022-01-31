package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pgd;

public class ComponentContentBigGallery
  extends ComponentContentBig
{
  TextView b;
  
  public ComponentContentBigGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559945, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131367013));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pgd))
    {
      paramObject = ((pgd)paramObject).a();
      this.b.setText(String.valueOf(paramObject.mGalleryPicNumber));
    }
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigGallery
 * JD-Core Version:    0.7.0.1
 */