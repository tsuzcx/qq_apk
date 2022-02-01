package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class IndividualRedPacketManager$4
  implements Runnable
{
  IndividualRedPacketManager$4(IndividualRedPacketManager paramIndividualRedPacketManager, String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = IndividualRedPacketManager.l;
    Object localObject1 = this.this$0.a();
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    int j = 1;
    localObject1 = ((IndividualRedPacketResDownloader)localObject1).a((String)localObject2, true);
    localObject2 = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.b, 6);
    boolean bool = this.this$0.c.get();
    Object localObject5 = null;
    if (bool)
    {
      localObject1 = IndividualRedPacketManager.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getBitmapForWebView error mIsSDCardError:");
      ((StringBuilder)localObject2).append(this.this$0.c.get());
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject1 = "";
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localObject2 = null;
      Object localObject3 = localObject5;
      break label445;
      bool = TextUtils.isEmpty((CharSequence)localObject2);
      int k = 0;
      if (bool) {
        break;
      }
      try
      {
        localObject1 = new File((String)localObject2);
        localObject2 = new FileInputStream((File)localObject1);
        localObject1 = new byte[(int)((File)localObject1).length()];
        j = k;
        while (j < localObject1.length)
        {
          k = ((FileInputStream)localObject2).read((byte[])localObject1, j, localObject1.length - j);
          if (k < 0) {
            break;
          }
          j += k;
        }
        localObject1 = Base64Util.encodeToString((byte[])localObject1, 2);
        try
        {
          j = IndividualRedPacketManager.k;
          i = j;
          ((FileInputStream)localObject2).close();
          i = j;
        }
        catch (IOException localIOException1)
        {
          localObject2 = localObject1;
          j = i;
        }
        localObject1 = localObject2;
      }
      catch (IOException localIOException2)
      {
        localObject2 = "";
        j = i;
      }
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = IndividualRedPacketManager.b();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBitmapForWebView error:");
        localStringBuilder.append(localIOException2.getMessage());
        QLog.e((String)localObject1, 2, localStringBuilder.toString());
        localObject1 = localObject2;
        i = j;
      }
    }
    if ((localObject1 != null) && (new File(IndividualRedPacketManager.a(this.jdField_a_of_type_JavaLangString, "", 2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).d, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).a)).exists()))
    {
      localObject1 = this.this$0.a(this.b, 6);
      localObject2 = IndividualRedPacketManager.a(this.this$0, (IndividualRedPacketManager.FontBitmap)localObject1, this.jdField_a_of_type_JavaLangString, this.b, 6);
      j = 0;
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    if (j != 0) {
      this.this$0.a().a(16L, this.jdField_a_of_type_JavaLangString, null);
    }
    localObject5 = "";
    Object localObject4 = localObject2;
    localObject2 = localObject1;
    localObject1 = localObject5;
    label445:
    if (localObject4 != null)
    {
      localObject1 = new ByteArrayOutputStream();
      localObject4.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
      localObject1 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
      i = IndividualRedPacketManager.k;
    }
    localObject5 = new Bundle();
    ((Bundle)localObject5).putString("templateId", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject5).putString("content", this.b);
    ((Bundle)localObject5).putInt("result", i);
    ((Bundle)localObject5).putString("bitmap", (String)localObject1);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject5);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
    if (QLog.isColorLevel())
    {
      localObject5 = IndividualRedPacketManager.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapForWebView result = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" base64 length = ");
      localStringBuilder.append(((String)localObject1).length());
      QLog.d((String)localObject5, 2, localStringBuilder.toString());
    }
    if ((localObject2 != null) && (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null) && (!((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_Boolean)) {
      this.this$0.a(((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, "", this.b, 5);
    }
    if ((localObject2 != null) && (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null) && (localObject4 != null))
    {
      if (((IndividualRedPacketManager.FontBitmap)localObject2).b)
      {
        this.this$0.a(localObject4, this.jdField_a_of_type_JavaLangString, this.b, 12);
        return;
      }
      this.this$0.a(localObject4, this.jdField_a_of_type_JavaLangString, this.b, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.4
 * JD-Core Version:    0.7.0.1
 */