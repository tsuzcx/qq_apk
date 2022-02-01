package com.tencent.mobileqq.apollo;

import amje;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$3
  extends IApolloRunnableTask
{
  public ChatPieApolloViewController$3(amje paramamje, ApolloRender paramApolloRender, String paramString) {}
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "cm3d_Script";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.getSavaWrapper() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.getSavaWrapper().a(this.jdField_a_of_type_JavaLangString);
      QLog.i("sava_ChatPieApolloViewController", 1, "preLoadEngine cm3dScript");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */