package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/proteus/utils/RIJProteusDrawableHelper$getDrawableFromNet$2", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "reTry", "", "getReTry", "()I", "setReTry", "(I)V", "onLoadCanceled", "", "drawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "cause", "", "onLoadProgressed", "progress", "onLoadSuccessed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDrawableHelper$getDrawableFromNet$2
  implements URLDrawable.URLDrawableListener
{
  private int jdField_a_of_type_Int;
  
  RIJProteusDrawableHelper$getDrawableFromNet$2(String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack) {}
  
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "cause");
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 3) {
      paramURLDrawable.restartDownload();
    }
    for (;;)
    {
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadFailed :" + this.jdField_a_of_type_JavaLangString + "  reTry: " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(false, (Drawable)paramURLDrawable);
    }
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onLoadSuccessed :" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, (Drawable)paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusDrawableHelper.getDrawableFromNet.2
 * JD-Core Version:    0.7.0.1
 */