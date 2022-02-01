package com.tencent.biz.expand.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandDebugFragment$onCreateView$callback$1", "Landroid/graphics/drawable/Drawable$Callback;", "count", "", "getCount", "()I", "setCount", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandDebugFragment$onCreateView$callback$1
  implements Drawable.Callback
{
  private int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString = "image3";
  
  public void invalidateDrawable(@Nullable Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizExpandUiExpandDebugFragment.getActivity() != null)
    {
      if (this.jdField_a_of_type_Int % 60 == 0)
      {
        LogUtils localLogUtils = LogUtils.a;
        if (QLog.isColorLevel()) {
          QLog.d("ExpandDebugFragment", 2, '[' + this.jdField_a_of_type_JavaLangString + "] invalidateDrawable! (" + paramDrawable + ')' + this.jdField_a_of_type_Int);
        }
      }
      this.jdField_a_of_type_Int += 1;
      if (paramDrawable != null) {
        paramDrawable.draw(this.jdField_a_of_type_ComTencentBizExpandUiExpandDebugFragment.a());
      }
    }
  }
  
  public void scheduleDrawable(@Nullable Drawable paramDrawable, @Nullable Runnable paramRunnable, long paramLong)
  {
    paramRunnable = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.jdField_a_of_type_JavaLangString + "] scheduleDrawable! (" + paramDrawable + ", " + paramLong + ')');
    }
  }
  
  public void unscheduleDrawable(@Nullable Drawable paramDrawable, @Nullable Runnable paramRunnable)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.jdField_a_of_type_JavaLangString + "] unscheduleDrawable! (" + paramDrawable + ", " + paramRunnable + ')');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandDebugFragment.onCreateView.callback.1
 * JD-Core Version:    0.7.0.1
 */