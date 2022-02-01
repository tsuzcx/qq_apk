package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetShareGroupDateListRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class ShareGroupDateListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetShareGroupDateListRequest, GetShareGroupDateListResponse>
{
  protected final String g;
  protected final String h;
  protected final String i;
  protected ShareGroupDateListPageLoader.CacheContext j;
  protected String k = "";
  protected long l;
  protected int m;
  
  public ShareGroupDateListPageLoader(String paramString1, int paramInt, String paramString2)
  {
    this.g = paramString1;
    this.m = paramInt;
    this.h = paramString2;
    this.i = paramString1;
  }
  
  private void d()
  {
    int n = UIUtils.b();
    int i1 = this.j.c;
    long l1 = 0L;
    if (i1 != n)
    {
      SLog.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.j.c), Integer.valueOf(n) });
      localObject = (MemoryManager)SuperManager.a(19);
      MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)localObject).c(this.i);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.i);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = n;
      }
      else
      {
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.timeZone = n;
        localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      }
      this.j.a((MemoryInfoEntry)localObject);
    }
    if (b(this.k)) {
      l1 = this.j.a;
    }
    this.l = l1;
    Object localObject = new GetShareGroupDateListRequest();
    ((GetShareGroupDateListRequest)localObject).g = 10;
    ((GetShareGroupDateListRequest)localObject).h = 10;
    ((GetShareGroupDateListRequest)localObject).f = this.k;
    ((GetShareGroupDateListRequest)localObject).j = l1;
    ((GetShareGroupDateListRequest)localObject).k = this.j.c;
    ((GetShareGroupDateListRequest)localObject).e = this.g;
    ((GetShareGroupDateListRequest)localObject).i = this.m;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public void a(@NonNull GetShareGroupDateListRequest paramGetShareGroupDateListRequest, @Nullable GetShareGroupDateListResponse paramGetShareGroupDateListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new ShareGroupDateListPageLoader.1(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
  
  protected boolean b(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new ShareGroupDateListPageLoader.2(this, "Q.qqstory.shareGroup:ShareGroupDateListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader
 * JD-Core Version:    0.7.0.1
 */