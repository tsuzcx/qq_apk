package com.tencent.ilivesdk.coredataserviceinterface;

public class CoreDataServiceItem
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("CoreDataServiceItem:\n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemType = ");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemName = ");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemValue = ");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("isShow = ");
    localStringBuilder2.append(this.jdField_a_of_type_Boolean);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.coredataserviceinterface.CoreDataServiceItem
 * JD-Core Version:    0.7.0.1
 */