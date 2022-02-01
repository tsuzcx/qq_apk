package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import java.lang.ref.WeakReference;

final class ReadInJoyActivityHelper$1
  implements JumpCallback
{
  ReadInJoyActivityHelper$1(WeakReference paramWeakReference, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onJump(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (ReadInJoyActivityHelper.a() == paramInt1)
    {
      TeleScreen.a().a(paramInt1);
      ReadInJoyActivityHelper.a(-1);
      if ((2 != paramInt2) && (1 != paramInt2)) {
        break label124;
      }
    }
    label124:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Object localObject = localContext;
      if (localContext == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      if ((-1 == paramInt2) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (localObject != null)) {
        RIJJumpUtils.b((Context)localObject, this.jdField_a_of_type_JavaLangString);
      }
      localObject = this.b;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt2 = i;; paramInt2 = 0)
      {
        RIJFrameworkReportManager.a((String)localObject, paramInt1, paramInt2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */