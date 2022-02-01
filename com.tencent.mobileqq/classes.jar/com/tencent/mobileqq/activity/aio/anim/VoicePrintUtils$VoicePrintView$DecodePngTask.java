package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

class VoicePrintUtils$VoicePrintView$DecodePngTask
  extends AsyncTask<String, Void, Bitmap>
{
  VoicePrintUtils$VoicePrintView$DecodePngTask(VoicePrintUtils.VoicePrintView paramVoicePrintView) {}
  
  protected Bitmap a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (GlobalImageCache.a.get(paramVarArgs) == null)
    {
      Bitmap localBitmap = BubbleManager.a(paramVarArgs, this.a.a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode ");
        localStringBuilder.append(paramVarArgs);
        localStringBuilder.append("in background.");
        QLog.d("VoicePrintUtils.DecodePngTask", 2, localStringBuilder.toString());
      }
      GlobalImageCache.a.put(paramVarArgs, localBitmap);
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    VoicePrintUtils.VoicePrintView.a(this.a);
    paramBitmap = this.a;
    paramBitmap.setImageDrawable(VoicePrintUtils.VoicePrintView.a(paramBitmap));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView.DecodePngTask
 * JD-Core Version:    0.7.0.1
 */