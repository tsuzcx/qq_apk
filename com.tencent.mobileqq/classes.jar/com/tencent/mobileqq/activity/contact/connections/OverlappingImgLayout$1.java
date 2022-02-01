package com.tencent.mobileqq.activity.contact.connections;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class OverlappingImgLayout$1
  implements DecodeTaskCompletionListener
{
  OverlappingImgLayout$1(OverlappingImgLayout paramOverlappingImgLayout) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null) && (OverlappingImgLayout.a(this.a) != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      paramInt1 = 0;
      while (paramInt1 < OverlappingImgLayout.a(this.a).length)
      {
        if ((paramInt1 < 3) && (paramString.equals(OverlappingImgLayout.a(this.a)[paramInt1])))
        {
          ((ImageView)OverlappingImgLayout.b(this.a).get(paramInt1)).setImageBitmap(paramBitmap);
          if (QLog.isColorLevel()) {
            QLog.d("OverlappingImgLayout", 2, "mDecodeTaskCompletionListener update");
          }
        }
        paramInt1 += 1;
      }
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted, uin: ");
        paramBitmap.append(paramString);
        paramBitmap.append(", type: ");
        paramBitmap.append(paramInt2);
        QLog.d("OverlappingImgLayout", 2, paramBitmap.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout.1
 * JD-Core Version:    0.7.0.1
 */