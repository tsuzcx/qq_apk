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
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    boolean bool1;
    if ((l >= this.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_Long))
    {
      bool1 = true;
      if ((!bool1) || (!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break label68;
      }
      bool1 = bool2;
    }
    label68:
    for (;;)
    {
      SLog.a("Q.qqstory.config.takevideo", "isVariable=%b content=%s", Boolean.valueOf(bool1), toString());
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MsgTabTakeVideoNodeConfig=[");
    localStringBuilder.append(" startTime:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" endTime:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" imageUrl:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" desc:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" jumpUrl:").append(this.c);
    localStringBuilder.append(" contentId:").append(this.d);
    localStringBuilder.append(" isOneTimeUse:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" hasClicked:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig
 * JD-Core Version:    0.7.0.1
 */