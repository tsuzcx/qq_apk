package com.tencent.mobileqq.armap.map;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$2
  implements NonMainAppHeadLoader.FaceObserver
{
  MapEngineCallback$2(MapEngineCallback paramMapEngineCallback) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramBitmap != null))
    {
      if ((paramString1.equals(this.this$0.mApp.getCurrentAccountUin())) && (this.this$0.mNeedReloadHead))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MapEngineCallback", 2, "onFaceUpdate uin:" + paramString1 + ",mNativePOIMangerHandle:" + this.this$0.mNativePOIMangerHandle);
        }
        this.this$0.mNeedReloadHead = false;
        ThreadManager.post(new MapEngineCallback.2.1(this, paramBitmap, paramString1), 5, null, false);
      }
      ((LbsPackManager)this.this$0.mApp.getManager(214)).a(paramString1, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.2
 * JD-Core Version:    0.7.0.1
 */