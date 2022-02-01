package com.tencent.biz.qqstory.utils.pngquant;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class PngQuantUtils$1
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpByBusinessId loaded,code=");
      localStringBuilder.append(paramInt);
      QLog.d("PngQuantUtils", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("url"))) {
      PngQuantUtils.a.set(false);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils.1
 * JD-Core Version:    0.7.0.1
 */