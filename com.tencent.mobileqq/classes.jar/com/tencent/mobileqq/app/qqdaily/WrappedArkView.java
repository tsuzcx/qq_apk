package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;

public class WrappedArkView
  extends ArkView
{
  ArkViewImplement.LoadCallback a;
  private WrappedArkView.OnArkViewLoadListener b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public WrappedArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean load(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.a = paramLoadCallback;
    return super.load(paramString1, paramString2, paramString3, paramString4, paramString5, paramLoadCallback);
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    super.onLoadFailed(paramString, paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadFailed");
    }
    WrappedArkView.OnArkViewLoadListener localOnArkViewLoadListener = this.b;
    if (localOnArkViewLoadListener != null) {
      localOnArkViewLoadListener.a(paramString, paramInt, paramBoolean, this.mViewImpl.getViewModel());
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadSuccess");
    }
    WrappedArkView.OnArkViewLoadListener localOnArkViewLoadListener = this.b;
    if (localOnArkViewLoadListener != null) {
      localOnArkViewLoadListener.b();
    }
  }
  
  public void onLoading()
  {
    super.onLoading();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoading");
    }
    WrappedArkView.OnArkViewLoadListener localOnArkViewLoadListener = this.b;
    if (localOnArkViewLoadListener != null) {
      localOnArkViewLoadListener.a();
    }
  }
  
  public void setOnLoadListener(WrappedArkView.OnArkViewLoadListener paramOnArkViewLoadListener)
  {
    this.b = paramOnArkViewLoadListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.WrappedArkView
 * JD-Core Version:    0.7.0.1
 */