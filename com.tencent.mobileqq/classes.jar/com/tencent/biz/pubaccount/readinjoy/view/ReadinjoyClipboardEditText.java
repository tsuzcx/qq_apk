package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import slc;

public class ReadinjoyClipboardEditText
  extends EditText
{
  private slc a;
  
  public ReadinjoyClipboardEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onTextContextMenuItem(paramInt);
      if (this.a != null)
      {
        this.a.c();
        continue;
        if (this.a != null)
        {
          this.a.b();
          continue;
          if (this.a != null) {
            this.a.a();
          }
        }
      }
    }
  }
  
  public void setClipboardCallBack(slc paramslc)
  {
    this.a = paramslc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyClipboardEditText
 * JD-Core Version:    0.7.0.1
 */