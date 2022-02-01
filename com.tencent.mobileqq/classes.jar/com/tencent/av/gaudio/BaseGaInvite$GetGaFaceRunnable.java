package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.util.LogUtil;

public class BaseGaInvite$GetGaFaceRunnable
  implements Runnable
{
  final String a;
  int b;
  long c;
  String d;
  int e;
  VideoAppInterface f;
  WeakReference<BaseGaInvite.GetGaFaceRunnable.OnGetSink> g;
  boolean h = false;
  
  public BaseGaInvite$GetGaFaceRunnable(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, BaseGaInvite.GetGaFaceRunnable.OnGetSink paramOnGetSink)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramLong1;
    this.d = Long.toString(paramLong2);
    this.f = paramVideoAppInterface;
    this.e = paramInt2;
    this.g = new WeakReference(paramOnGetSink);
  }
  
  public void a()
  {
    this.f.a().removeCallbacks(this);
  }
  
  public void a(String paramString)
  {
    if (this.h)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUI[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], WaitDelayPost");
      QLog.w(str, 1, localStringBuilder.toString());
      return;
    }
    b(paramString);
  }
  
  void b(String paramString)
  {
    boolean bool2 = false;
    this.h = false;
    int i = this.b;
    String str1 = String.valueOf(this.c);
    Bitmap localBitmap = this.f.a(i, str1, null, true, false);
    int j = AVUtil.d(this.e);
    String str2 = this.f.a(i, str1, null);
    if ((localBitmap != null) && (!TextUtils.equals(str2, this.d)))
    {
      localObject = (BaseGaInvite.GetGaFaceRunnable.OnGetSink)this.g.get();
      if (localObject != null)
      {
        bool1 = ((BaseGaInvite.GetGaFaceRunnable.OnGetSink)localObject).a(localBitmap, str2);
        break label111;
      }
    }
    boolean bool1 = false;
    label111:
    if (!bool1)
    {
      this.h = true;
      this.f.a().postDelayed(this, 1500L);
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGaFace[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], uinType_Group[");
    localStringBuilder.append(i);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(LogUtil.getSafePrintUin(str1));
    localStringBuilder.append("], uinType_Invite[");
    localStringBuilder.append(j);
    localStringBuilder.append("], mInviterUin[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], memberName[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], faceBitmap[");
    if (localBitmap != null) {
      bool2 = true;
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append("], mWaitDelayPost[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], result[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void run()
  {
    b("Runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable
 * JD-Core Version:    0.7.0.1
 */