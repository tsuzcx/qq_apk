package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Set;

class FastAnimationDrawable$1
  extends LruCache<Integer, BitmapDrawable>
{
  protected void a(boolean paramBoolean, Integer paramInteger, BitmapDrawable paramBitmapDrawable1, BitmapDrawable paramBitmapDrawable2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      FastAnimationDrawable.a(this.a).add(new SoftReference(paramBitmapDrawable1.getBitmap()));
      if (QLog.isColorLevel())
      {
        paramBitmapDrawable2 = new StringBuilder();
        paramBitmapDrawable2.append("remove key:");
        paramBitmapDrawable2.append(paramInteger);
        paramBitmapDrawable2.append(" bitmap:");
        paramBitmapDrawable2.append(paramBitmapDrawable1.getBitmap());
        QLog.d("FastAnimationDrawable", 2, paramBitmapDrawable2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.FastAnimationDrawable.1
 * JD-Core Version:    0.7.0.1
 */