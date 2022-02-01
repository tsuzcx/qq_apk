package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import java.util.List;

public abstract interface SelectableEditTextHelper$OnMenuCallback
{
  public abstract void onMenuInit(List<SelectableEditTextHelper.MenuItem> paramList, int paramInt);
  
  public abstract void onMenuItemClicked(View paramView, SelectableEditTextHelper.MenuItem paramMenuItem, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.OnMenuCallback
 * JD-Core Version:    0.7.0.1
 */