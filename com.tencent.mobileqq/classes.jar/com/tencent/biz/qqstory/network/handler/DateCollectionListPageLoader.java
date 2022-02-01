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
  protected DateCollectionListPageLoader.CacheContext a;
  protected String b;
  protected long c;
  protected String c;
  protected String d;
  protected final String e;
  
  public DateCollectionListPageLoader(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.d = paramString2;
    this.e = a(this.jdField_c_of_type_JavaLangString);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  private void d()
  {
    int i = UIUtils.a();
    int j = this.a.jdField_a_of_type_Int;
    boolean bool = false;
    long l = 0L;
    if (j != i)
    {
      SLog.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (MemoryManager)SuperManager.a(19);
      localMemoryInfoEntry = ((MemoryManager)localObject).a(this.e);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.e);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
      }
      else
      {
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.timeZone = i;
        localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      }
      this.a.a((MemoryInfoEntry)localObject);
    }
    if (a(this.jdField_b_of_type_JavaLangString)) {
      l = this.a.jdField_a_of_type_Long;
    }
    this.jdField_c_of_type_Long = l;
    Object localObject = new GetDateCollectionListRequest();
    ((GetDateCollectionListRequest)localObject).c = 10;
    ((GetDateCollectionListRequest)localObject).d = 10;
    ((GetDateCollectionListRequest)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((GetDateCollectionListRequest)localObject).jdField_b_of_type_Long = l;
    ((GetDateCollectionListRequest)localObject).e = this.a.jdField_a_of_type_Int;
    ((GetDateCollectionListRequest)localObject).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)SuperManager.a(19)).a(this.e);
    if (localMemoryInfoEntry != null)
    {
      if (localMemoryInfoEntry.isFriend == 1) {
        bool = true;
      }
      ((GetDateCollectionListRequest)localObject).jdField_a_of_type_Boolean = bool;
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
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new DateCollectionListPageLoader.2(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader
 * JD-Core Version:    0.7.0.1
 */