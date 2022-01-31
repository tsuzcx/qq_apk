package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import awkj;
import baqy;
import bayf;
import bayk;
import bdhj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import nrt;
import ors;
import owy;
import qpa;
import qpb;

class ReadInJoyDeliverUGCActivity$15
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$15(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Object paramObject, int paramInt) {}
  
  public void run()
  {
    if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {}
    label458:
    long l1;
    CompressInfo localCompressInfo;
    long l2;
    String str1;
    label1481:
    do
    {
      String str2;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic");
              }
              if (!this.jdField_a_of_type_JavaLangObject.equals(ReadInJoyDeliverUGCActivity.a(this.this$0)))
              {
                if (!(this.jdField_a_of_type_JavaLangObject instanceof HotPicData)) {
                  break;
                }
                localObject = (HotPicData)this.jdField_a_of_type_JavaLangObject;
                if (this.jdField_a_of_type_Int < 9)
                {
                  ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.jdField_a_of_type_Int, ((HotPicData)localObject).originalUrl);
                  ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.jdField_a_of_type_Int, ((HotPicData)localObject).md5);
                  ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.jdField_a_of_type_Int, Integer.valueOf(((HotPicData)localObject).height));
                  ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.jdField_a_of_type_Int, Integer.valueOf(((HotPicData)localObject).width));
                  ReadInJoyDeliverUGCActivity.f(this.this$0);
                }
                while (ReadInJoyDeliverUGCActivity.d(this.this$0) == ReadInJoyDeliverUGCActivity.a(this.this$0))
                {
                  ReadInJoyDeliverUGCActivity.d(this.this$0, true);
                  owy.a().a(this.this$0.app.c(), ReadInJoyDeliverUGCActivity.c(this.this$0), ReadInJoyDeliverUGCActivity.b(this.this$0), ReadInJoyDeliverUGCActivity.e(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0).a(), ReadInJoyDeliverUGCActivity.a(this.this$0).a(), ReadInJoyDeliverUGCActivity.a(this.this$0).b(), ReadInJoyDeliverUGCActivity.a(this.this$0).b(), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.d(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0), ReadInJoyDeliverUGCActivity.g(this.this$0));
                  return;
                  ReadInJoyDeliverUGCActivity.c(this.this$0, false);
                  this.this$0.m();
                }
              }
            }
            if (!(this.jdField_a_of_type_JavaLangObject instanceof String)) {
              break;
            }
            str2 = (String)this.jdField_a_of_type_JavaLangObject;
            if (!TextUtils.isEmpty(str2)) {
              break label458;
            }
            this.this$0.m();
            ReadInJoyDeliverUGCActivity.a(this.this$0, 1, this.this$0.getString(2131718859));
            this.this$0.j();
          } while (!QLog.isColorLevel());
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
          return;
          this.this$0.m();
          ReadInJoyDeliverUGCActivity.b(this.this$0, 1, this.this$0.getString(2131718859));
          this.this$0.j();
        } while (!QLog.isColorLevel());
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
        return;
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          break;
        }
        ReadInJoyDeliverUGCActivity.e(this.this$0, true);
        this.this$0.m();
        ReadInJoyDeliverUGCActivity.c(this.this$0, 1, this.this$0.getString(2131718859));
        this.this$0.j();
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic file not exist, path=" + str2);
      return;
      l1 = ((File)localObject).length();
      ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.jdField_a_of_type_Int, l1);
      ReadInJoyDeliverUGCActivity.a(this.this$0).c(this.jdField_a_of_type_Int, NetConnInfoCenter.getServerTimeMillis());
      localCompressInfo = new CompressInfo(str2, 0);
      localCompressInfo.f = 0;
      localCompressInfo.jdField_a_of_type_Int = 1036;
      boolean bool1 = true;
      Object localObject = new BitmapFactory.Options();
      for (;;)
      {
        try
        {
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          bdhj.a(str2, (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outHeight <= ((BitmapFactory.Options)localObject).outWidth) {
            continue;
          }
          i = ((BitmapFactory.Options)localObject).outHeight;
          if (i <= 2560) {
            bool1 = false;
          }
        }
        catch (Exception localException2)
        {
          int i;
          boolean bool2;
          bayf localbayf;
          qpb localqpb;
          bayk localbayk;
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "isNeedCompress error" + localException2.toString());
          continue;
          ReadInJoyDeliverUGCActivity.b(this.this$0).add(localCompressInfo.jdField_e_of_type_JavaLangString);
          continue;
          localCompressInfo.d = localException1.outWidth;
          localCompressInfo.jdField_e_of_type_Int = localException1.outHeight;
          continue;
          str1 = localCompressInfo.jdField_e_of_type_JavaLangString;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "beforeCompress picture: w:" + ((BitmapFactory.Options)localObject).outWidth + "  h:" + ((BitmapFactory.Options)localObject).outHeight + " size:" + l1 / 1024L + "kb isNeedCompress:" + bool1);
        }
        if (!bool1) {
          continue;
        }
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        bool2 = awkj.a(localCompressInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "compress result= " + bool2);
        }
        if (bool2) {
          continue;
        }
        ReadInJoyDeliverUGCActivity.c(this.this$0, 1001);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic compressPath=" + localCompressInfo.jdField_e_of_type_JavaLangString + ", path=" + str2 + ", width=" + localCompressInfo.d + ", height=" + localCompressInfo.jdField_e_of_type_Int);
        }
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        ReadInJoyDeliverUGCActivity.a(this.this$0).a(this.jdField_a_of_type_Int, Integer.valueOf(((BitmapFactory.Options)localObject).outWidth));
        ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.jdField_a_of_type_Int, Integer.valueOf(((BitmapFactory.Options)localObject).outHeight));
        if (!TextUtils.isEmpty(localCompressInfo.jdField_e_of_type_JavaLangString)) {
          continue;
        }
        localObject = str2;
        l2 = new File((String)localObject).length();
        ReadInJoyDeliverUGCActivity.a(this.this$0).b(this.jdField_a_of_type_Int, l2);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "afterCompress picture: w:" + localCompressInfo.d + "  h:" + localCompressInfo.jdField_e_of_type_Int + " size:" + l2 / 1024L + "kb");
        }
        ReadInJoyDeliverUGCActivity.a(this.this$0).d(this.jdField_a_of_type_Int, NetConnInfoCenter.getServerTimeMillis());
        localbayf = this.this$0.app.a();
        localqpb = new qpb(this.this$0, this.this$0.getMainLooper());
        localbayk = new bayk();
        if (!ReadInJoyDeliverUGCActivity.c(this.this$0)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "doStartUploadPicposition" + this.jdField_a_of_type_Int);
        }
        localqpb.addFilter(new Class[] { baqy.class });
        localbayf.a(localqpb);
        localbayk.jdField_a_of_type_Boolean = true;
        localbayk.jdField_c_of_type_Int = 10;
        localbayk.i = ((String)localObject);
        localbayk.jdField_a_of_type_Long = this.jdField_a_of_type_Int;
        localbayk.jdField_c_of_type_JavaLangString = "0";
        localbayk.b = 24;
        localbayk.jdField_a_of_type_JavaLangString = "KandianUGCPicUpload";
        localbayf.a(localbayk);
        localqpb.jdField_a_of_type_Boolean = true;
        ReadInJoyDeliverUGCActivity.d(this.this$0).add(localqpb);
        ReadInJoyDeliverUGCActivity.e(this.this$0).add(localbayk);
        ReadInJoyDeliverUGCActivity.a(this.this$0).e(this.jdField_a_of_type_Int, NetConnInfoCenter.getServerTimeMillis());
        if (!bool1) {
          break;
        }
        try
        {
          localObject = str2.substring(str2.lastIndexOf(".") + 1);
          if (l2 != l1) {
            break label1481;
          }
          nrt.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(localCompressInfo.d), String.valueOf(localCompressInfo.jdField_e_of_type_Int), (String)localObject, ors.a(0), false);
          return;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
        return;
        i = localException1.outWidth;
      }
    } while (l2 <= l1);
    nrt.a(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(localCompressInfo.d), String.valueOf(localCompressInfo.jdField_e_of_type_Int), str1, ors.a(1), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.15
 * JD-Core Version:    0.7.0.1
 */