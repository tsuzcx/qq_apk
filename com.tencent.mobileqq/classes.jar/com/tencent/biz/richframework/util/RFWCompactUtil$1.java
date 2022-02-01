package com.tencent.biz.richframework.util;

import android.os.Build;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.TransDispatchDelegate;

final class RFWCompactUtil$1
  implements NestScrollRecyclerView.TransDispatchDelegate
{
  public boolean a(MotionEvent paramMotionEvent, RecyclerView paramRecyclerView)
  {
    return ((Build.BRAND.equalsIgnoreCase("HUAWEI")) || (Build.BRAND.equalsIgnoreCase("HONOR"))) && (paramMotionEvent.getAction() == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.util.RFWCompactUtil.1
 * JD-Core Version:    0.7.0.1
 */