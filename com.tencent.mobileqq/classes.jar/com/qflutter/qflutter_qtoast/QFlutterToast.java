package com.qflutter.qflutter_qtoast;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_qtoast/QFlutterToast;", "", "error", "", "msg", "", "show", "success", "qflutter_qtoast_release"}, k=1, mv={1, 1, 11})
public abstract interface QFlutterToast
{
  public abstract void error(@NotNull String paramString);
  
  public abstract void show(@NotNull String paramString);
  
  public abstract void success(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qflutter_qtoast.QFlutterToast
 * JD-Core Version:    0.7.0.1
 */