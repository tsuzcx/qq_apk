package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;

public abstract interface IReadInJoyPresenter
{
  public abstract void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt);
  
  public abstract void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.IReadInJoyPresenter
 * JD-Core Version:    0.7.0.1
 */