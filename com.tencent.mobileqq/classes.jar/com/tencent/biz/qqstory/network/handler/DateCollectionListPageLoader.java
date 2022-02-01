package com.tencent.biz.qqstory.network.handler;

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
import com.tencent.biz.qqstory.network.request.GetDateCollectionListRequest;
import com.tencent.biz.qqstory.network.response.GetDateCollectionListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class DateCollectionListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetDateCollectionListRequest, GetDateCollectionListResponse>
{
  protected DateCollectionListPageLoader.CacheContext g;
  protected String h = "";
  protected long i;
  protected String j;
  protected String k;
  protected final String l;
  
  public DateCollectionListPageLoader(String paramString1, String paramString2)
  {
    this.j = paramString1;
    this.k = paramString2;
    this.l = b(this.j);
  }
  
  public static String b(String paramString)
  {
    return paramString;
  }
  
  private void d()
  {
    int m = UIUtils.b();
    int n = this.g.c;
    boolean bool = false;
    long l1 = 0L;
    if (n != m)
    {
      SLog.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.g.c), Integer.valueOf(m) });
      localObject = (MemoryManager)SuperManager.a(19);
      localMemoryInfoEntry = ((MemoryManager)localObject).c(this.l);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.l);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = m;
      }
      else
      {
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.timeZone = m;
        localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      }
      this.g.a((MemoryInfoEntry)localObject);
    }
    if (c(this.h)) {
      l1 = this.g.a;
    }
    this.i = l1;
    Object localObject = new GetDateCollectionListRequest();
    ((GetDateCollectionListRequest)localObject).f = 10;
    ((GetDateCollectionListRequest)localObject).g = 10;
    ((GetDateCollectionListRequest)localObject).e = this.h;
    ((GetDateCollectionListRequest)localObject).h = l1;
    ((GetDateCollectionListRequest)localObject).i = this.g.c;
    ((GetDateCollectionListRequest)localObject).j = this.j;
    MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)SuperManager.a(19)).c(this.l);
    if (localMemoryInfoEntry != null)
    {
      if (localMemoryInfoEntry.isFriend == 1) {
        bool = true;
      }
      ((GetDateCollectionListRequest)localObject).k = bool;
    }
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public void a(@NonNull GetDateCollectionListRequest paramGetDateCollectionListRequest, @Nullable GetDateCollectionListResponse paramGetDateCollectionListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new DateCollectionListPageLoader.1(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new DateCollectionListPageLoader.2(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  protected boolean c(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader
 * JD-Core Version:    0.7.0.1
 */