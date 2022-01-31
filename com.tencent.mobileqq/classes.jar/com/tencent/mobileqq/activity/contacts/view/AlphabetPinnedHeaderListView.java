package com.tencent.mobileqq.activity.contacts.view;

import afpe;
import android.content.Context;
import android.util.AttributeSet;
import bcod;
import com.tencent.mobileqq.widget.PinnedDividerListView;

public class AlphabetPinnedHeaderListView
  extends PinnedDividerListView
{
  private boolean a = true;
  
  public AlphabetPinnedHeaderListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphabetPinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphabetPinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    bcod localbcod = a();
    if ((localbcod instanceof afpe)) {
      ((afpe)localbcod).a(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.AlphabetPinnedHeaderListView
 * JD-Core Version:    0.7.0.1
 */