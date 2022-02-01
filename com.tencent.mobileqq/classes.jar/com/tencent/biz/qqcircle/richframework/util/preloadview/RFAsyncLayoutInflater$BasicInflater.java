package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

class RFAsyncLayoutInflater$BasicInflater
  extends LayoutInflater
{
  private static final String[] a = { "android.widget.", "android.webkit.", "android.app." };
  
  RFAsyncLayoutInflater$BasicInflater(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof AppCompatActivity))
    {
      paramContext = ((AppCompatActivity)paramContext).getDelegate();
      if ((paramContext instanceof LayoutInflater.Factory2)) {
        LayoutInflaterCompat.setFactory2(this, (LayoutInflater.Factory2)paramContext);
      }
    }
  }
  
  public LayoutInflater cloneInContext(Context paramContext)
  {
    return new BasicInflater(paramContext);
  }
  
  protected View onCreateView(String paramString, AttributeSet paramAttributeSet)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = createView(paramString, (String)localObject, paramAttributeSet);
        if (localObject != null) {
          return localObject;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label42:
        break label42;
      }
      i += 1;
    }
    return super.onCreateView(paramString, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.RFAsyncLayoutInflater.BasicInflater
 * JD-Core Version:    0.7.0.1
 */