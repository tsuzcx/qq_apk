package c.t.m.g;

import android.os.Build;

final class ad
  implements Runnable
{
  ad(String paramString) {}
  
  public final void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Print SDKBaseInfo on tag:" + this.a);
      localStringBuilder.append("\r\nPlatformProtocalType:2");
      localStringBuilder.append("\r\nappContext:" + l.k());
      localStringBuilder.append("\r\nbootSessionId:" + l.l());
      localStringBuilder.append("\r\nbootTime:" + l.m());
      localStringBuilder.append("\r\nappId:" + l.n());
      localStringBuilder.append("\r\nisSDKMode:" + l.o());
      localStringBuilder.append("\r\nbundle:" + l.p());
      localStringBuilder.append("\r\nappVersionName:" + l.a);
      localStringBuilder.append("\r\nappVersionCode:" + l.c);
      localStringBuilder.append("\r\nappLabelName:" + l.b);
      localStringBuilder.append("\r\nuuid:" + l.d);
      localStringBuilder.append("\r\nchannelId:" + l.e);
      localStringBuilder.append("\r\nsdkVersion:" + l.q());
      localStringBuilder.append("\r\nsProcessName:" + l.r());
      localStringBuilder.append("\r\npid:" + l.f);
      localStringBuilder.append("\r\nsProcessNameSubfix:" + l.s());
      localStringBuilder.append("\r\nsIsMainProcess:" + l.t());
      localStringBuilder.append("\r\npsInRemoteProcess:" + l.g);
      localStringBuilder.append("\r\nisTestMode:" + l.u());
      if (l.k() != null) {
        localStringBuilder.append("\r\ndeviceid:" + cc.a());
      }
      localStringBuilder.append("\r\nfinger:" + Build.FINGERPRINT);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ad
 * JD-Core Version:    0.7.0.1
 */