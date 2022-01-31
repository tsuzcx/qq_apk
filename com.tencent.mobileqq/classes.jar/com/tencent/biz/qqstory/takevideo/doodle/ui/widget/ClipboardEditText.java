package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import vpl;

public class ClipboardEditText
  extends EditText
{
  private vpl a;
  
  public ClipboardEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
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
  
  public void setClipboardCallBack(vpl paramvpl)
  {
    this.a = paramvpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText
 * JD-Core Version:    0.7.0.1
 */