package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IDataProvider$GroupInfo
  implements Cloneable
{
  private boolean a = true;
  public IDataProvider.GroupId b;
  public List<String> c;
  public Map<String, String> d = new HashMap();
  public int e = 0;
  @Nullable
  public String f;
  
  public IDataProvider$GroupInfo(IDataProvider.GroupId paramGroupId)
  {
    this.b = paramGroupId;
    AssertUtils.checkNotNull(paramGroupId);
    if ((paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      paramGroupId = ((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId).a;
      if ((paramGroupId != null) && (paramGroupId.b == 12)) {
        this.a = false;
      }
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.d.put(str, paramString);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public GroupInfo d()
  {
    GroupInfo localGroupInfo = new GroupInfo(this.b);
    localGroupInfo.d.putAll(this.d);
    List localList = this.c;
    if (localList != null) {
      localGroupInfo.c = new ArrayList(localList);
    }
    localGroupInfo.f = this.f;
    return localGroupInfo;
  }
  
  public boolean e()
  {
    return this.c != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    paramObject = (GroupInfo)paramObject;
    IDataProvider.GroupId localGroupId = this.b;
    if (localGroupId != null) {
      return localGroupId.equals(paramObject.b);
    }
    return paramObject.b == null;
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    IDataProvider.GroupId localGroupId = this.b;
    if (localGroupId != null) {
      return localGroupId.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gi{g=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", fv=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", vlist=");
    localStringBuilder.append(this.c);
    if (localStringBuilder.toString() != null) {
      return String.valueOf(this.c.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo
 * JD-Core Version:    0.7.0.1
 */