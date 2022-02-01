package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GetUserIconHandler
{
  static boolean a = false;
  private static final ArrayList<String> b = new ArrayList();
  private static Set<String> c = new HashSet();
  
  public static void a(String paramString)
  {
    synchronized (b)
    {
      if (!c.contains(paramString))
      {
        b.add(paramString);
        c.add(paramString);
      }
      if (!a)
      {
        a = true;
        ThreadManager.post(new GetUserIconHandler.1(), 5, null, true);
      }
      return;
    }
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    paramArrayList = new GetUserIconHandler.GetUserIconListRequest(paramArrayList);
    GetUserIconHandler.GetUserIconListResponse localGetUserIconListResponse = new GetUserIconHandler.GetUserIconListResponse();
    LegoNetworkRequester.a().a(paramArrayList, localGetUserIconListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler
 * JD-Core Version:    0.7.0.1
 */