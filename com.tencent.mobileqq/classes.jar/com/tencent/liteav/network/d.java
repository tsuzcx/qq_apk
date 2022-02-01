package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import java.util.Vector;

public class d
  implements f
{
  private f a = null;
  private d.b b = null;
  private long c = 0L;
  private long d = 0L;
  private d.b e = null;
  private d.a f;
  private long g = 0L;
  private long h = 0L;
  
  public d(d.a parama)
  {
    this.f = parama;
  }
  
  public void a()
  {
    d.b localb = this.b;
    if (localb != null) {
      localb.b(0L);
    }
    localb = this.e;
    if (localb != null) {
      localb.b(0L);
    }
  }
  
  void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(TXIStreamDownloader paramTXIStreamDownloader1, TXIStreamDownloader paramTXIStreamDownloader2, long paramLong1, long paramLong2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[SwitchStream] old downloader:");
    ((StringBuilder)localObject).append(paramTXIStreamDownloader1.hashCode());
    ((StringBuilder)localObject).append(" new downloader:");
    ((StringBuilder)localObject).append(paramTXIStreamDownloader2.hashCode());
    TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject).toString());
    this.c = paramTXIStreamDownloader1.getCurrentTS();
    this.d = paramTXIStreamDownloader1.getLastIFrameTS();
    this.b = new d.b(paramTXIStreamDownloader1, this);
    this.b.a(this);
    ((TXCFLVDownloader)paramTXIStreamDownloader1).recvData(true);
    localObject = new Vector();
    ((Vector)localObject).add(new e(paramString, false));
    paramTXIStreamDownloader2.setOriginUrl(paramString);
    ((TXCFLVDownloader)paramTXIStreamDownloader2).recvData(true);
    paramTXIStreamDownloader2.startDownload((Vector)localObject, false, false, paramTXIStreamDownloader1.mEnableMessage, paramTXIStreamDownloader1.mEnableMetaData);
    this.e = new d.b(paramTXIStreamDownloader2, this);
    this.e.a(this.c);
  }
  
  void a(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[SwitchStream] switch stream finish. result:");
    ((StringBuilder)localObject).append(paramBoolean);
    TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null) {
      ((d.a)localObject).onSwitchFinish(paramTXIStreamDownloader, paramBoolean);
    }
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public void b()
  {
    this.b.a(null);
    this.e.a(this);
    this.b = this.e;
    this.e = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[SwitchStream] end at ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" stop ts ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" start ts ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" diff ts ");
    long l1 = this.h;
    long l2 = this.g;
    if (l1 > l2) {
      l1 -= l2;
    } else {
      l1 = l2 - l1;
    }
    localStringBuilder.append(l1);
    TXCLog.w("TXCMultiStreamDownloader", localStringBuilder.toString());
  }
  
  void b(long paramLong)
  {
    this.h = paramLong;
  }
  
  long c()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((d.b)localObject).b(this.c);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[SwitchStream] stop original downloader, when video ts is");
    ((StringBuilder)localObject).append(this.c);
    TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject).toString());
    return this.c;
  }
  
  public void onPullAudio(a parama)
  {
    f localf = this.a;
    if (localf != null) {
      localf.onPullAudio(parama);
    }
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    this.c = paramTXSNALPacket.pts;
    if (paramTXSNALPacket.nalType == 0) {
      this.d = paramTXSNALPacket.pts;
    }
    f localf = this.a;
    if (localf != null) {
      localf.onPullNAL(paramTXSNALPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.d
 * JD-Core Version:    0.7.0.1
 */