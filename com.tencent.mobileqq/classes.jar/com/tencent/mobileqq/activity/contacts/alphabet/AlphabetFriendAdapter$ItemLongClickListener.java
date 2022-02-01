package com.tencent.mobileqq.activity.contacts.alphabet;

import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class AlphabetFriendAdapter$ItemLongClickListener
  implements View.OnLongClickListener
{
  private WeakReference<AlphabetFriendAdapter> a;
  
  public AlphabetFriendAdapter$ItemLongClickListener(AlphabetFriendAdapter paramAlphabetFriendAdapter)
  {
    this.a = new WeakReference(paramAlphabetFriendAdapter);
  }
  
  public boolean onLongClick(View paramView)
  {
    AlphabetFriendAdapter localAlphabetFriendAdapter = (AlphabetFriendAdapter)this.a.get();
    if (localAlphabetFriendAdapter != null) {
      return localAlphabetFriendAdapter.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.ItemLongClickListener
 * JD-Core Version:    0.7.0.1
 */