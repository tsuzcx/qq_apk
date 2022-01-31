package com.tencent.mobileqq.apollo.ai;

public class ApolloAIMessage
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  
  public ApolloAIMessage()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  public ApolloAIMessage a()
  {
    ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
    localApolloAIMessage.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localApolloAIMessage.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localApolloAIMessage.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    localApolloAIMessage.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localApolloAIMessage.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localApolloAIMessage.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localApolloAIMessage.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localApolloAIMessage.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
    localApolloAIMessage.g = this.g;
    localApolloAIMessage.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localApolloAIMessage.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localApolloAIMessage.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
    localApolloAIMessage.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    return localApolloAIMessage;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label186:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return bool1;
                            bool1 = bool3;
                          } while (paramObject == null);
                          bool1 = bool3;
                        } while (getClass() != paramObject.getClass());
                        paramObject = (ApolloAIMessage)paramObject;
                        bool1 = bool3;
                      } while (this.g != paramObject.g);
                      bool1 = bool3;
                    } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
                    bool1 = bool3;
                  } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
                  bool1 = bool3;
                } while (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int);
                bool1 = bool3;
              } while (this.jdField_d_of_type_Int != paramObject.jdField_d_of_type_Int);
              bool1 = bool3;
            } while (this.jdField_e_of_type_Int != paramObject.jdField_e_of_type_Int);
            bool1 = bool3;
          } while (this.f != paramObject.f);
          if (this.jdField_a_of_type_JavaLangString == null) {
            break;
          }
          bool1 = bool3;
        } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
        if (this.jdField_b_of_type_JavaLangString == null) {
          break label240;
        }
        bool1 = bool3;
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString));
      if (this.jdField_d_of_type_JavaLangString == null) {
        break label249;
      }
      bool1 = bool3;
    } while (!this.jdField_d_of_type_JavaLangString.equals(paramObject.jdField_d_of_type_JavaLangString));
    label210:
    if (this.jdField_e_of_type_JavaLangString != null) {
      bool1 = this.jdField_e_of_type_JavaLangString.equals(paramObject.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      return false;
      label240:
      if (paramObject.jdField_b_of_type_JavaLangString == null) {
        break label186;
      }
      return false;
      label249:
      if (paramObject.jdField_d_of_type_JavaLangString == null) {
        break label210;
      }
      return false;
      bool1 = bool2;
      if (paramObject.jdField_e_of_type_JavaLangString != null) {
        bool1 = false;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloAIMessage type:").append(this.jdField_a_of_type_Int).append(" mActionId:").append(this.jdField_b_of_type_Int).append(" mText:").append(this.jdField_a_of_type_JavaLangString).append(" mAudioUrl").append(this.jdField_b_of_type_JavaLangString).append(" expts:").append(this.jdField_e_of_type_Int).append(" mStatus:").append(this.jdField_c_of_type_Int).append(" mAudioPath:").append(this.jdField_d_of_type_JavaLangString).append(" mErrorMsg:").append(this.jdField_e_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ai.ApolloAIMessage
 * JD-Core Version:    0.7.0.1
 */