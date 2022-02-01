package com.tencent.aelight.camera.aioeditor.share.impl;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.HexUtil;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class AIOShareHelperImpl$2
  implements Runnable
{
  AIOShareHelperImpl$2(AIOShareHelperImpl paramAIOShareHelperImpl, AIOShareObject paramAIOShareObject, Intent paramIntent, Runnable paramRunnable) {}
  
  public void run()
  {
    Object localObject2 = this.a.b();
    Object localObject1 = new File((String)localObject2);
    if (!((File)localObject1).exists())
    {
      this.this$0.dismissLoading();
      AEQLog.d("AIOShareHelperImpl", "share video to QQ, but video file is not exist");
      return;
    }
    this.b.putExtra("forward_type", 21);
    this.b.putExtra("file_send_path", this.a.b());
    this.b.putExtra("from_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.b.putExtra("forward_need_sendmsg", true);
    int i = this.a.f();
    int j = this.a.d();
    int k = this.a.e();
    this.b.putExtra("file_send_size", (int)((File)localObject1).length());
    localObject2 = HexUtil.bytes2HexStr(FileManagerUtil.g((String)localObject2));
    this.b.putExtra("file_shortvideo_md5", (String)localObject2);
    this.b.putExtra("file_name", ((File)localObject1).getName());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video file md5 = ");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", file name = ");
    localStringBuilder.append(((File)localObject1).getName());
    AEQLog.b("AIOShareHelperImpl", localStringBuilder.toString());
    if (i > 0)
    {
      localObject1 = this.b;
      double d = i;
      Double.isNaN(d);
      ((Intent)localObject1).putExtra("file_send_duration", (int)Math.round(d / 1000.0D));
    }
    if ((j > 0) && (k > 0))
    {
      this.b.putExtra("file_width", j);
      this.b.putExtra("file_height", k);
    }
    localObject1 = this.a.c();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      AEQLog.b("AIOShareHelperImpl", "video file has thumbnail");
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      i = ((BitmapFactory.Options)localObject2).outWidth;
      j = ((BitmapFactory.Options)localObject2).outHeight;
      if ((i > 0) && (j > 0))
      {
        localObject2 = HexUtil.bytes2HexStr(FileManagerUtil.g((String)localObject1));
        this.b.putExtra("thumbfile_md5", (String)localObject2);
        this.b.putExtra("forward_thumb", (String)localObject1);
        this.b.putExtra("thumbfile_send_path", (String)localObject1);
        this.b.putExtra("thumbfile_send_width", i);
        this.b.putExtra("thumbfile_send_height", j);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decode video thumbnail success, width = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", height = ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(", md5 = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        AEQLog.b("AIOShareHelperImpl", ((StringBuilder)localObject1).toString());
      }
      else
      {
        AEQLog.d("AIOShareHelperImpl", "decode video thumbnail fail");
      }
    }
    ThreadManager.getUIHandler().post(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */