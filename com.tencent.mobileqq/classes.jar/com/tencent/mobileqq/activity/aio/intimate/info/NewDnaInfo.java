package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaDetail;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.NewDnaInfo;

public class NewDnaInfo
{
  public int a;
  public String b;
  public String c;
  public ArrayList<NewDnaInfo.DnaDetail> d;
  public String e;
  public String f;
  
  public static ArrayList<NewDnaInfo> a(List<oidb_0xcf4.NewDnaInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0xcf4.NewDnaInfo)paramList.next();
        if ((localObject != null) && (((oidb_0xcf4.NewDnaInfo)localObject).has()))
        {
          NewDnaInfo localNewDnaInfo = new NewDnaInfo();
          if (((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.has()) {
            localNewDnaInfo.a = ((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.get();
          }
          if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.has()) {
            localNewDnaInfo.b = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.get().toStringUtf8();
          }
          if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.has()) {
            localNewDnaInfo.c = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.get().toStringUtf8();
          }
          if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.has()) {
            localNewDnaInfo.e = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.get().toStringUtf8();
          }
          if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.has()) {
            localNewDnaInfo.f = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.get().toStringUtf8();
          }
          if (((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.has())
          {
            localObject = ((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.get().iterator();
            while (((Iterator)localObject).hasNext())
            {
              NewDnaInfo.DnaDetail localDnaDetail = NewDnaInfo.DnaDetail.a((oidb_0xcf4.DnaDetail)((Iterator)localObject).next());
              if (localDnaDetail != null)
              {
                if (localNewDnaInfo.d == null) {
                  localNewDnaInfo.d = new ArrayList();
                }
                localNewDnaInfo.d.add(localDnaDetail);
              }
            }
          }
          localArrayList.add(localNewDnaInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NewDnaInfo{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", coverUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", jumpMinappUrl=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", details=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo
 * JD-Core Version:    0.7.0.1
 */