package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.util.AttributeSet;
import anwb;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;

public class WrappedArkView
  extends ArkView
{
  private anwb jdField_a_of_type_Anwb;
  ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public WrappedArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean load(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = paramLoadCallback;
    return super.load(paramString1, paramString2, paramString3, paramString4, paramString5, paramLoadCallback);
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    super.onLoadFailed(paramString, paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadFailed");
    }
    if (this.jdField_a_of_type_Anwb != null) {
      this.jdField_a_of_type_Anwb.a(paramString, paramInt, paramBoolean, this.mViewImpl.getViewModel());
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadSuccess");
    }
    if (this.jdField_a_of_type_Anwb != null) {
      this.jdField_a_of_type_Anwb.b();
    }
  }
  
  public void onLoading()
  {
    super.onLoading();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoading");
    }
    if (this.jdField_a_of_type_Anwb != null) {
      this.jdField_a_of_type_Anwb.a();
    }
  }
  
  public void setOnLoadListener(anwb paramanwb)
  {
    this.jdField_a_of_type_Anwb = paramanwb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.WrappedArkView
 * JD-Core Version:    0.7.0.1
 */