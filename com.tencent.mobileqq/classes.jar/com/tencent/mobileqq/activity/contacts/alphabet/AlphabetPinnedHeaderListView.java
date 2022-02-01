package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;

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
    PinnedDividerListView.DividerAdapter localDividerAdapter = getDividerAdapter();
    if ((localDividerAdapter instanceof AlphabetFriendAdapter)) {
      ((AlphabetFriendAdapter)localDividerAdapter).a(paramBoolean);
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetPinnedHeaderListView
 * JD-Core Version:    0.7.0.1
 */