package com.tencent.ad.tangram.canvas.views.form.framework;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;

@Keep
public abstract interface AdFormCommitListener
{
  public abstract void afterCommit(AdFormError paramAdFormError);
  
  public abstract void beforeCommit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener
 * JD-Core Version:    0.7.0.1
 */