package com.tencent.mobileqq.activity.contacts.view;

import ahri;
import android.content.Context;
import android.util.AttributeSet;
import besd;
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
    besd localbesd = a();
    if ((localbesd instanceof ahri)) {
      ((ahri)localbesd).a(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.AlphabetPinnedHeaderListView
 * JD-Core Version:    0.7.0.1
 */