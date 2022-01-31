package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import bcdp;
import bdes;
import bdey;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;
import naj;
import shh;

public class ReadInjoyWebShareHelper$5
  implements Runnable
{
  public ReadInjoyWebShareHelper$5(shh paramshh, String paramString1, boolean paramBoolean1, Map paramMap, Runnable paramRunnable, boolean paramBoolean2, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    try
    {
      localObject1 = naj.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject1 == null) {
        break label135;
      }
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (localObject1 == null) {
        break label135;
      }
      int j = ((Bitmap)localObject1).getWidth();
      int k = ((Bitmap)localObject1).getHeight();
      if ((j * k <= 8000.0D) || (this.jdField_a_of_type_Boolean)) {
        break label374;
      }
      double d = Math.sqrt(8000.0D / (j * k));
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(j * d), (int)(k * d), true);
      ((Bitmap)localObject1).recycle();
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      Object localObject2;
      break label135;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject1);
    label135:
    if (shh.a(this.this$0).a().getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      shh.a(this.this$0).a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "96");
      localObject2 = new StringBuilder().append("");
      if (this.jdField_a_of_type_JavaUtilMap.get("image") != null) {
        break label354;
      }
      label231:
      ((Bundle)localObject1).putString("intext_1", i);
      ((Bundle)localObject1).putString("intext_4", "0");
      localObject2 = new StringBuilder().append("");
      if (!this.jdField_b_of_type_Boolean) {
        break label359;
      }
    }
    label354:
    label359:
    for (i = 3;; i = 4)
    {
      ((Bundle)localObject1).putString("intext_3", bdey.b(i));
      ((Bundle)localObject1).putString("stringext_1", this.jdField_b_of_type_JavaLangString);
      bdes.a().a((Bundle)localObject1, "", shh.a(this.this$0).a().getAccount(), false);
      return;
      shh.a(this.this$0).a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      break;
      i = 0;
      break label231;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.5
 * JD-Core Version:    0.7.0.1
 */