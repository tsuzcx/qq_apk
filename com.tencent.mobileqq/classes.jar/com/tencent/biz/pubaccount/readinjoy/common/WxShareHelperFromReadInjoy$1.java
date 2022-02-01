package com.tencent.biz.pubaccount.readinjoy.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.qphone.base.util.QLog;
import zdr;

class WxShareHelperFromReadInjoy$1
  implements Runnable
{
  WxShareHelperFromReadInjoy$1(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap, String paramString6) {}
  
  public void run()
  {
    Object localObject1 = new WXMiniProgramObject();
    ((WXMiniProgramObject)localObject1).withShareTicket = true;
    ((WXMiniProgramObject)localObject1).webpageUrl = this.jdField_a_of_type_JavaLangString;
    ((WXMiniProgramObject)localObject1).userName = this.b;
    ((WXMiniProgramObject)localObject1).path = this.c;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = this.d;
    localWXMediaMessage.description = this.e;
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      j = Math.min(i / 5, j / 4);
      i = j * 5;
      j *= 4;
      if (this.c.startsWith("/pages/index/index?share=1&share_type=1"))
      {
        localObject1 = zdr.a(zdr.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, j, false, true), BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841784), true);
        if (localObject1 != null)
        {
          i = ((Bitmap)localObject1).getWidth();
          j = ((Bitmap)localObject1).getHeight();
          Object localObject2 = localObject1;
          if (((Bitmap)localObject1).getByteCount() > 128000)
          {
            localObject1 = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
            double d1 = Math.sqrt(64000.0D / (i * j));
            localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(i * d1), (int)(d1 * j), true);
          }
          localWXMediaMessage.thumbData = WxShareHelperFromReadInjoy.a((Bitmap)localObject2);
        }
      }
    }
    for (;;)
    {
      localObject1 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject1).transaction = this.f;
      ((SendMessageToWX.Req)localObject1).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject1).scene = 0;
      WxShareHelperFromReadInjoy.a(this.this$0, (SendMessageToWX.Req)localObject1);
      return;
      localObject1 = zdr.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, j, false, true);
      break;
      if (QLog.isColorLevel()) {
        QLog.e("WxShareHelperFromReadInjoy", 2, "shareToMiniProgramWithPathAndId, error icon == null! title" + this.d + ", description = " + this.e + ", path = " + this.c + ", webPageUrl = " + this.jdField_a_of_type_JavaLangString + ", id = " + this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.1
 * JD-Core Version:    0.7.0.1
 */