package com.google.protobuf;

class GeneratedMessageInfoFactory
  implements MessageInfoFactory
{
  private static final GeneratedMessageInfoFactory a = new GeneratedMessageInfoFactory();
  
  public static GeneratedMessageInfoFactory a()
  {
    return a;
  }
  
  public boolean a(Class<?> paramClass)
  {
    return GeneratedMessageLite.class.isAssignableFrom(paramClass);
  }
  
  public MessageInfo b(Class<?> paramClass)
  {
    if (GeneratedMessageLite.class.isAssignableFrom(paramClass)) {
      try
      {
        MessageInfo localMessageInfo = (MessageInfo)GeneratedMessageLite.a(paramClass.asSubclass(GeneratedMessageLite.class)).d();
        return localMessageInfo;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Unable to get message info for ");
        localStringBuilder2.append(paramClass.getName());
        throw new RuntimeException(localStringBuilder2.toString(), localException);
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Unsupported message type: ");
    localStringBuilder1.append(paramClass.getName());
    throw new IllegalArgumentException(localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageInfoFactory
 * JD-Core Version:    0.7.0.1
 */