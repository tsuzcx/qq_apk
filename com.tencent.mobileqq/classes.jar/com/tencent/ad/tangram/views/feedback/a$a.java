package com.tencent.ad.tangram.views.feedback;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

final class a$a
{
  String iconUrl = null;
  int index = 0;
  boolean isDarkMode = false;
  boolean isLandscape = false;
  String jumpIconUrl = null;
  WeakReference<View.OnClickListener> listener = null;
  String text = null;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.iconUrl)) && (this.listener != null) && (!TextUtils.isEmpty(this.text));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */