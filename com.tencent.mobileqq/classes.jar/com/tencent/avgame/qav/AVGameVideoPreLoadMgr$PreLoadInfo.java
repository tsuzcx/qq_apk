package com.tencent.avgame.qav;

class AVGameVideoPreLoadMgr$PreLoadInfo
{
  public int a;
  public String a;
  
  public AVGameVideoPreLoadMgr$PreLoadInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTaskId[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], mUrl[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameVideoPreLoadMgr.PreLoadInfo
 * JD-Core Version:    0.7.0.1
 */