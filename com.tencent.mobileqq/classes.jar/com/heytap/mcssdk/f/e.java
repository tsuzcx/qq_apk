package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.d;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class e
{
  public static void a(Context paramContext, MessageStat paramMessageStat)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramMessageStat);
    a(paramContext, localLinkedList);
  }
  
  public static void a(Context paramContext, List<MessageStat> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramList);
    paramList = new StringBuilder();
    paramList.append("isSupportStatisticByMcs:");
    paramList.append(a(paramContext));
    paramList.append(",list size:");
    paramList.append(localLinkedList.size());
    c.a(paramList.toString());
    if ((localLinkedList.size() > 0) && (a(paramContext))) {
      b(paramContext, localLinkedList);
    }
  }
  
  private static boolean a(Context paramContext)
  {
    String str = d.a().b();
    return (g.a(paramContext, str)) && (g.b(paramContext, str) >= 1017);
  }
  
  private static void b(Context paramContext, List<MessageStat> paramList)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction(d.a().c());
      localIntent.setPackage(d.a().b());
      localIntent.putExtra("appPackage", paramContext.getPackageName());
      localIntent.putExtra("type", 12291);
      localIntent.putExtra("count", paramList.size());
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((MessageStat)paramList.next()).toJsonObject());
      }
      localIntent.putStringArrayListExtra("list", localArrayList);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramList = new StringBuilder();
      paramList.append("statisticMessage--Exception");
      paramList.append(paramContext.getMessage());
      c.b(paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.e
 * JD-Core Version:    0.7.0.1
 */