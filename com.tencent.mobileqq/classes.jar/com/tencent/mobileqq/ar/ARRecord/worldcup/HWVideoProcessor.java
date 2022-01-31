package com.tencent.mobileqq.ar.ARRecord.worldcup;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.mediaCodec.VideoMergeHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.HWVideoEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

@TargetApi(18)
public class HWVideoProcessor
{
  public boolean a(String paramString1, String paramString2)
  {
    if (!FileUtil.a(paramString1))
    {
      QLog.d("Q.worldcup.record", 2, String.format("picToVideo| %s is not exist", new Object[] { paramString1 }));
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("Q.worldcup.record", 2, "picToVideo| outputVideoPath is empty");
      return false;
    }
    HWVideoEncoder localHWVideoEncoder = new HWVideoEncoder();
    EncodeInputSurface localEncodeInputSurface = new EncodeInputSurface();
    try
    {
      paramString1 = BitmapFactory.decodeFile(paramString1);
      paramString2 = new EncodeConfig(paramString2, paramString1.getWidth(), paramString1.getHeight(), 1048576, 1, false, 0);
      localHWVideoEncoder.a(paramString2);
      localEncodeInputSurface.a(paramString2, localHWVideoEncoder.a());
      int j = GlUtil.a(3553, paramString1);
      int i = 0;
      while (i < paramString2.d * 1)
      {
        localHWVideoEncoder.a();
        long l = 1000000000L * i / paramString2.d;
        localEncodeInputSurface.a(3553, j, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, null, l);
        i += 1;
      }
      localHWVideoEncoder.b();
      return true;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("Q.worldcup.record", 4, "picToVideo| exp: " + paramString1.getMessage());
      return false;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("Q.worldcup.record", 4, "picToVideo| oom: " + paramString1.getMessage());
      return false;
    }
    finally
    {
      localHWVideoEncoder.c();
      localEncodeInputSurface.a();
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    long l = System.currentTimeMillis();
    try
    {
      i = VideoMergeHelper.a(paramString1, paramString2, paramString3, 0, 0L, paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("mergeAudioAndVideo, errCode: %s, cost: %s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (i == 0)
      {
        bool = true;
        if (!bool)
        {
          paramString1 = new File(paramString3);
          if (paramString1.exists()) {
            paramString1.delete();
          }
        }
        return bool;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i = -1001;
        paramString1.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.worldcup.HWVideoProcessor
 * JD-Core Version:    0.7.0.1
 */