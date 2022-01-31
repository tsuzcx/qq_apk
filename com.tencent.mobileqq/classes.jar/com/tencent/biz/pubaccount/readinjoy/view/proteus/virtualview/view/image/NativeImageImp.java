package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeImageImp
  extends KandianUrlImageView
  implements IView
{
  public NativeImageImp(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void setImageSrc(String paramString)
  {
    try
    {
      a(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImageImp
 * JD-Core Version:    0.7.0.1
 */