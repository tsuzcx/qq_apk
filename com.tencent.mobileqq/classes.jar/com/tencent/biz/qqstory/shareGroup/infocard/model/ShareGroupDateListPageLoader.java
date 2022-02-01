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
  protected int a;
  protected ShareGroupDateListPageLoader.CacheContext a;
  protected final String b;
  protected long c;
  protected final String c;
  protected final String d;
  protected String e = "";
  
  public ShareGroupDateListPageLoader(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString1;
  }
  
  private void d()
  {
    int i = UIUtils.a();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int;
    long l = 0L;
    if (j != i)
    {
      SLog.d("Q.qqstory.shareGroup:ShareGroupDateListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (MemoryManager)SuperManager.a(19);
      MemoryInfoEntry localMemoryInfoEntry = ((MemoryManager)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
      }
      else
      {
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.timeZone = i;
        localObject = ((MemoryManager)localObject).a(localMemoryInfoEntry);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.a((MemoryInfoEntry)localObject);
    }
    if (a(this.e)) {
      l = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Long;
    }
    this.jdField_c_of_type_Long = l;
    Object localObject = new GetShareGroupDateListRequest();
    ((GetShareGroupDateListRequest)localObject).c = 10;
    ((GetShareGroupDateListRequest)localObject).d = 10;
    ((GetShareGroupDateListRequest)localObject).jdField_b_of_type_JavaLangString = this.e;
    ((GetShareGroupDateListRequest)localObject).jdField_b_of_type_Long = l;
    ((GetShareGroupDateListRequest)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader$CacheContext.jdField_a_of_type_Int;
    ((GetShareGroupDateListRequest)localObject).a = this.jdField_b_of_type_JavaLangString;
    ((GetShareGroupDateListRequest)localObject).e = this.jdField_a_of_type_Int;
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
  
  protected boolean a(String paramString)
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