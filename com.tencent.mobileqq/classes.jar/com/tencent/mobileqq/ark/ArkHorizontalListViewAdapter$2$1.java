package com.tencent.mobileqq.ark;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ArkHorizontalListViewAdapter$2$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkHorizontalListViewAdapter$2$1(ArkHorizontalListViewAdapter.2 param2) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.a.b.setVisibility(0);
      this.a.a.a.setVisibility(0);
      this.a.a.a.setImageBitmap(paramBitmap);
      return;
    }
    this.a.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */