package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ArkAppItemBubbleBuilder$Holder$2$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkAppItemBubbleBuilder$Holder$2$1(ArkAppItemBubbleBuilder.Holder.2 param2) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.c.d.setVisibility(0);
      this.a.b.e.setVisibility(0);
      this.a.b.e.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder.2.1
 * JD-Core Version:    0.7.0.1
 */