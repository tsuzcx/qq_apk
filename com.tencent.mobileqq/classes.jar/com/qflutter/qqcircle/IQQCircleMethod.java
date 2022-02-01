package com.qflutter.qqcircle;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.Result;

public abstract interface IQQCircleMethod
{
  public abstract void onMethodCall(@Nullable Context paramContext, View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.IQQCircleMethod
 * JD-Core Version:    0.7.0.1
 */