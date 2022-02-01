package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import ugf;

public class TaskDistribution
{
  private static String TAG = "kandianreport.TaskDistribution";
  
  public static List<oidb_cmd0x80a.AttributeList> getAttrList(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      int i = 1;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.get(str1).toString();
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(i);
        localAttributeList.att_name.set(str1);
        localAttributeList.att_value.set(str2);
        localArrayList.add(localAttributeList);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void report(String paramString)
  {
    paramString = getAttrList(paramString);
    ugf.a(80, TaskManager.scriptVersion, paramString);
  }
  
  public static void test()
  {
    TaskManager.scriptVersion = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskDistribution
 * JD-Core Version:    0.7.0.1
 */