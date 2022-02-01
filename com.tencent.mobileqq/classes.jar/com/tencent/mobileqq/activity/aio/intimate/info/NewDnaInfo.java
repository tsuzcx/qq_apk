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
  public String a;
  public ArrayList<NewDnaInfo.DnaDetail> a;
  public String b;
  public String c;
  public String d;
  
  public static ArrayList<NewDnaInfo> a(List<oidb_0xcf4.NewDnaInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_0xcf4.NewDnaInfo)paramList.next();
      if ((localObject != null) && (((oidb_0xcf4.NewDnaInfo)localObject).has()))
      {
        NewDnaInfo localNewDnaInfo = new NewDnaInfo();
        if (((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.has()) {
          localNewDnaInfo.jdField_a_of_type_Int = ((oidb_0xcf4.NewDnaInfo)localObject).eDnaType.get();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.has()) {
          localNewDnaInfo.jdField_a_of_type_JavaLangString = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_title.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.has()) {
          localNewDnaInfo.b = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.has()) {
          localNewDnaInfo.c = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_cover_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.has()) {
          localNewDnaInfo.d = ((oidb_0xcf4.NewDnaInfo)localObject).bytes_jump_minapp_url.get().toStringUtf8();
        }
        if (((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.has())
        {
          localObject = ((oidb_0xcf4.NewDnaInfo)localObject).rpt_detail.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            NewDnaInfo.DnaDetail localDnaDetail = NewDnaInfo.DnaDetail.a((oidb_0xcf4.DnaDetail)((Iterator)localObject).next());
            if (localDnaDetail != null)
            {
              if (localNewDnaInfo.jdField_a_of_type_JavaUtilArrayList == null) {
                localNewDnaInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localNewDnaInfo.jdField_a_of_type_JavaUtilArrayList.add(localDnaDetail);
            }
          }
        }
        localArrayList.add(localNewDnaInfo);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "NewDnaInfo{type=" + this.jdField_a_of_type_Int + ", title=" + this.jdField_a_of_type_JavaLangString + ", jumpUrl=" + this.b + ", coverUrl=" + this.c + ", jumpMinappUrl=" + this.d + ", details=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo
 * JD-Core Version:    0.7.0.1
 */