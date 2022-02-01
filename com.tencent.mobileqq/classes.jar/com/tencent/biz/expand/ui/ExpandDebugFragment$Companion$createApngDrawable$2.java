package com.tencent.biz.expand.ui;

import android.graphics.drawable.Drawable;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandDebugFragment$Companion$createApngDrawable$2", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "p0", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "p1", "", "onLoadProgressed", "", "onLoadSuccessed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandDebugFragment$Companion$createApngDrawable$2
  implements URLDrawable.URLDrawableListener
{
  ExpandDebugFragment$Companion$createApngDrawable$2(String paramString1, String paramString2) {}
  
  public void onLoadCanceled(@Nullable URLDrawable paramURLDrawable)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onLoadCanceled! (" + this.b + ", " + paramURLDrawable + ')');
    }
  }
  
  public void onLoadFialed(@Nullable URLDrawable paramURLDrawable, @Nullable Throwable paramThrowable)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onLoadFialed! (" + this.b + ", " + paramURLDrawable + ", " + paramThrowable + ')');
    }
  }
  
  public void onLoadProgressed(@Nullable URLDrawable paramURLDrawable, int paramInt)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onLoadProgressed! (" + this.b + ", " + paramURLDrawable + ", " + paramInt + ')');
    }
  }
  
  public void onLoadSuccessed(@Nullable URLDrawable paramURLDrawable)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onLoadSuccessed! (" + this.b + ", " + paramURLDrawable + ')');
    }
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof ApngDrawable))) {
        break label85;
      }
    }
    for (;;)
    {
      return;
      label85:
      ((ApngDrawable)paramURLDrawable).getImage().setSupportGlobalPasued(false);
      ((ApngDrawable)paramURLDrawable).resume();
      paramURLDrawable.setVisible(true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandDebugFragment.Companion.createApngDrawable.2
 * JD-Core Version:    0.7.0.1
 */