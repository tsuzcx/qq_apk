package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import njz;

public class GetUserIconHandler
{
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public static boolean a;
  
  public static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (!jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramString);
        jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
        ThreadManager.post(new njz(), 5, null, true);
      }
      return;
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    paramArrayList = new GetUserIconHandler.GetUserIconListRequest(paramArrayList);
    GetUserIconHandler.GetUserIconListResponse localGetUserIconListResponse = new GetUserIconHandler.GetUserIconListResponse();
    LegoNetworkRequester.a().a(paramArrayList, localGetUserIconListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler
 * JD-Core Version:    0.7.0.1
 */