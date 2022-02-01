package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoSpreadGroupList
{
  public int a;
  public List<String> b;
  public int c;
  public List<String> d;
  
  public VideoSpreadGroupList(qqstory_struct.VideoSpreadGroupList paramVideoSpreadGroupList)
  {
    if (paramVideoSpreadGroupList == null) {
      return;
    }
    this.a = paramVideoSpreadGroupList.visibility_type.get();
    PBRepeatField localPBRepeatField = paramVideoSpreadGroupList.group_list;
    int j = 0;
    int k;
    int i;
    if ((localPBRepeatField != null) && (paramVideoSpreadGroupList.group_list.has()))
    {
      k = paramVideoSpreadGroupList.group_list.size();
      this.b = new ArrayList(k);
      i = 0;
      while (i < k)
      {
        this.b.add(String.valueOf(((Long)paramVideoSpreadGroupList.group_list.get(i)).longValue()));
        i += 1;
      }
    }
    this.c = paramVideoSpreadGroupList.visibility_sharegroup_type.get();
    if ((paramVideoSpreadGroupList.share_group_list != null) && (paramVideoSpreadGroupList.share_group_list.has()))
    {
      k = paramVideoSpreadGroupList.share_group_list.size();
      this.d = new ArrayList(k);
      i = j;
      while (i < k)
      {
        this.d.add(((ByteStringMicro)paramVideoSpreadGroupList.share_group_list.get(i)).toStringUtf8());
        i += 1;
      }
    }
  }
  
  public qqstory_struct.VideoSpreadGroupList a()
  {
    qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
    localVideoSpreadGroupList.setHasFlag(false);
    Object localObject = this.b;
    String str;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localVideoSpreadGroupList.visibility_type.set(this.a);
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localVideoSpreadGroupList.group_list.add(Long.valueOf(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    localObject = this.d;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localVideoSpreadGroupList.visibility_sharegroup_type.set(this.c);
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(str));
      }
      localVideoSpreadGroupList.setHasFlag(true);
    }
    return localVideoSpreadGroupList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoSpreadGroupList
 * JD-Core Version:    0.7.0.1
 */