package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import nfp;

public class GetUserIconHandler
{
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  
  public GetUserIconHandler()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramString);
      jdField_a_of_type_JavaUtilSet.add(paramString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.post(new nfp(this), 5, null, true);
      }
      return;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = new GetUserIconHandler.GetUserIconListRequest(this, paramArrayList);
    GetUserIconHandler.GetUserIconListResponse localGetUserIconListResponse = new GetUserIconHandler.GetUserIconListResponse(this);
    LegoNetworkRequester.a().a(paramArrayList, localGetUserIconListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler
 * JD-Core Version:    0.7.0.1
 */