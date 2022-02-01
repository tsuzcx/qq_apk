package com.google.protobuf;

class ManifestSchemaFactory$CompositeMessageInfoFactory
  implements MessageInfoFactory
{
  private MessageInfoFactory[] a;
  
  ManifestSchemaFactory$CompositeMessageInfoFactory(MessageInfoFactory... paramVarArgs)
  {
    this.a = paramVarArgs;
  }
  
  public boolean a(Class<?> paramClass)
  {
    MessageInfoFactory[] arrayOfMessageInfoFactory = this.a;
    int j = arrayOfMessageInfoFactory.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfMessageInfoFactory[i].a(paramClass)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public MessageInfo b(Class<?> paramClass)
  {
    Object localObject1 = this.a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.a(paramClass)) {
        return localObject2.b(paramClass);
      }
      i += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No factory is available for message type: ");
    ((StringBuilder)localObject1).append(paramClass.getName());
    paramClass = new UnsupportedOperationException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ManifestSchemaFactory.CompositeMessageInfoFactory
 * JD-Core Version:    0.7.0.1
 */