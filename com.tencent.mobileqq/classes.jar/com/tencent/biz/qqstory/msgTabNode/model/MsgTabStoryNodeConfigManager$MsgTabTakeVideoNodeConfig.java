package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.support.logging.SLog;

public class MsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  
  public MsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(MsgTabTakeVideoNodeConfig paramMsgTabTakeVideoNodeConfig)
  {
    if (paramMsgTabTakeVideoNodeConfig == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramMsgTabTakeVideoNodeConfig.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramMsgTabTakeVideoNodeConfig.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaLangString = paramMsgTabTakeVideoNodeConfig.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramMsgTabTakeVideoNodeConfig.jdField_b_of_type_JavaLangString;
    this.c = paramMsgTabTakeVideoNodeConfig.c;
    this.d = paramMsgTabTakeVideoNodeConfig.d;
    this.jdField_a_of_type_Boolean = paramMsgTabTakeVideoNodeConfig.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramMsgTabTakeVideoNodeConfig.jdField_b_of_type_Boolean;
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    boolean bool1;
    if ((l >= this.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_Long)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Boolean)
      {
        bool2 = bool1;
        if (this.jdField_b_of_type_Boolean) {
          bool2 = false;
        }
      }
    }
    SLog.a("Q.qqstory.config.takevideo", "isVariable=%b content=%s", Boolean.valueOf(bool2), toString());
    return bool2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MsgTabTakeVideoNodeConfig=[");
    localStringBuilder.append(" startTime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" endTime:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" imageUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" desc:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" jumpUrl:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" contentId:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" isOneTimeUse:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" hasClicked:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig
 * JD-Core Version:    0.7.0.1
 */