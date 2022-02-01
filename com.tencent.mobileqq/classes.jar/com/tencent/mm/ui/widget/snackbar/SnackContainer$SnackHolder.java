package com.tencent.mm.ui.widget.snackbar;

import android.view.View;
import android.widget.TextView;

class SnackContainer$SnackHolder
{
  final View a;
  final TextView b;
  final TextView c;
  final Snack d;
  final SnackBar.OnVisibilityChangeListener e;
  
  private SnackContainer$SnackHolder(Snack paramSnack, View paramView, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.a = paramView;
    this.c = ((TextView)paramView.findViewById(2131446124));
    this.b = ((TextView)paramView.findViewById(2131446126));
    this.d = paramSnack;
    this.e = paramOnVisibilityChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.SnackHolder
 * JD-Core Version:    0.7.0.1
 */