package com.tencent.mobileqq.armap.map;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$4
  implements Runnable
{
  MapEngineCallback$4(MapEngineCallback paramMapEngineCallback) {}
  
  public void run()
  {
    Object localObject = this.this$0.mApp.a.a(this.this$0.mApp.getCurrentAccountUin(), true, null);
    if (localObject == null)
    {
      this.this$0.mNeedReloadHead = true;
      if (QLog.isColorLevel()) {
        QLog.i("MapEngineCallback", 4, "CB_TYPE_GET_HEAD_ICON_PATH headBitmap is null,need reload");
      }
    }
    do
    {
      return;
      localObject = this.this$0.generateHeadIcon("myPinHead.png", (Bitmap)localObject);
    } while ((this.this$0.mActivity == null) || (this.this$0.mActivity.a == null) || (TextUtils.isEmpty((CharSequence)localObject)));
    this.this$0.mActivity.a.queueEvent(new MapEngineCallback.4.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.4
 * JD-Core Version:    0.7.0.1
 */