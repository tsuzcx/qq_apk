package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;

public abstract interface IStickerRecViewBinder
{
  public abstract void a(ViewGroup paramViewGroup, RelativeLayout paramRelativeLayout, EditText paramEditText);
  
  public abstract void a(LifecycleOwner paramLifecycleOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewBinder
 * JD-Core Version:    0.7.0.1
 */