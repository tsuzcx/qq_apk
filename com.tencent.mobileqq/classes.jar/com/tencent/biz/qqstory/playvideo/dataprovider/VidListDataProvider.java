package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VidListDataProvider
  implements IDataProvider
{
  public final List<String> a = new ArrayList();
  public final String b;
  private IDataProvider.GroupInfo c;
  private IDataProvider.Data d;
  private IDataProvider.StartInfo e;
  
  public VidListDataProvider(String paramString)
  {
    this.a.add(paramString);
    this.b = paramString;
    this.d = new IDataProvider.Data();
    paramString = this.d;
    paramString.d = true;
    paramString.b = true;
    paramString.c = new ArrayList();
    this.c = new IDataProvider.GroupInfo(new IDataProvider.GroupId("TROOP_GROUD_ID"));
    paramString = this.c;
    paramString.f = this.b;
    paramString.c = this.a;
    paramString.d.put(this.b, "TROOP_FEED_ID");
    this.d.c.add(this.c);
    this.e = new IDataProvider.StartInfo(new IDataProvider.GroupId("TROOP_GROUD_ID"), this.b, "TROOP_FEED_ID");
    this.e.d = this.c;
  }
  
  public IDataProvider.Data a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt)
  {
    return this.d;
  }
  
  public void a() {}
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, String paramString) {}
  
  public void a(IDataProvider.ICallBack paramICallBack) {}
  
  public void b() {}
  
  public void b(IDataProvider.ICallBack paramICallBack) {}
  
  public IDataProvider.StartInfo c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.VidListDataProvider
 * JD-Core Version:    0.7.0.1
 */