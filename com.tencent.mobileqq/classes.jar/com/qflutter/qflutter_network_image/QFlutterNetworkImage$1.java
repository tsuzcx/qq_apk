package com.qflutter.qflutter_network_image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.nativebmp.NativeBitmap;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;

class QFlutterNetworkImage$1
  implements LoadBitmapCallback
{
  QFlutterNetworkImage$1(QFlutterNetworkImage paramQFlutterNetworkImage, MethodChannel.Result paramResult) {}
  
  @TargetApi(12)
  public void onLoaded(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = NativeBitmap.getBitmapPixelDataMemoryPtr(paramBitmap);
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i = paramBitmap.getAllocationByteCount();; i = paramBitmap.getByteCount())
    {
      long l3 = System.currentTimeMillis();
      paramBitmap = new StringBuilder();
      paramBitmap.append("[getNetworkImage] address=");
      paramBitmap.append(l2);
      paramBitmap.append(", length=");
      paramBitmap.append(i);
      paramBitmap.append(", width=");
      paramBitmap.append(j);
      paramBitmap.append(", height=");
      paramBitmap.append(k);
      paramBitmap.append(", cost=");
      paramBitmap.append(l3 - l1);
      Log.d("QFlutterNetworkImage", paramBitmap.toString());
      paramBitmap = new HashMap();
      paramBitmap.put("rawDataAddress", Long.valueOf(l2));
      paramBitmap.put("rawDataLength", Integer.valueOf(i));
      paramBitmap.put("width", Integer.valueOf(j));
      paramBitmap.put("height", Integer.valueOf(k));
      this.val$result.success(paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qflutter_network_image.QFlutterNetworkImage.1
 * JD-Core Version:    0.7.0.1
 */