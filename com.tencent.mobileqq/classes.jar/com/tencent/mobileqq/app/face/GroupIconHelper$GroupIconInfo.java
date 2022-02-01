package com.tencent.mobileqq.app.face;

import java.util.ArrayList;

class GroupIconHelper$GroupIconInfo
{
  public byte a;
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  
  private GroupIconHelper$GroupIconInfo(GroupIconHelper paramGroupIconHelper)
  {
    this.jdField_a_of_type_Byte = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(byte paramByte)
  {
    if (paramByte == 3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Byte = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.c = false;
      this.d = false;
      this.e = false;
      return;
    }
    if (paramByte == 2)
    {
      this.jdField_b_of_type_Boolean = false;
      this.e = true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nGroupIconInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isChanged:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("state:");
    localStringBuilder.append(this.jdField_a_of_type_Byte);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isSyncFace:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("startTime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("faceUinSet:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("faceCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("crateIconCount:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("lastCreatedFaceUinSet:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isPstnIcon:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("hasRealPstnUser:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isFromCreate:");
    localStringBuilder.append(this.e);
    try
    {
      localStringBuilder.append("\n |-");
      localStringBuilder.append("memberFaceList:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
      label291:
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      break label291;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.GroupIconInfo
 * JD-Core Version:    0.7.0.1
 */