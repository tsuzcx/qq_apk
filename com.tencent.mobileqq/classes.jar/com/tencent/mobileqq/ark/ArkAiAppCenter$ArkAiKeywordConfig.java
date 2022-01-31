package com.tencent.mobileqq.ark;

public class ArkAiAppCenter$ArkAiKeywordConfig
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public ArkAiAppCenter$ArkAiKeywordConfig(ArkAiAppCenter paramArkAiAppCenter) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof ArkAiKeywordConfig))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      paramObject = (ArkAiKeywordConfig)paramObject;
      if ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.b.equals(paramObject.b)) || (!this.c.equals(paramObject.c))) {
        break;
      }
      bool1 = bool2;
    } while (this.d.equals(paramObject.d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppCenter.ArkAiKeywordConfig
 * JD-Core Version:    0.7.0.1
 */