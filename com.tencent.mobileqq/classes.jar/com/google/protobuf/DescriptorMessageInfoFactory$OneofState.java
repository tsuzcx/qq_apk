package com.google.protobuf;

import java.util.Arrays;

final class DescriptorMessageInfoFactory$OneofState
{
  private OneofInfo[] a = new OneofInfo[2];
  
  private static OneofInfo b(Class<?> paramClass, Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    String str = DescriptorMessageInfoFactory.a(paramOneofDescriptor.b());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("Case_");
    str = localStringBuilder.toString();
    return new OneofInfo(paramOneofDescriptor.a(), DescriptorMessageInfoFactory.a(paramClass, str), DescriptorMessageInfoFactory.a(paramClass, (String)localObject));
  }
  
  OneofInfo a(Class<?> paramClass, Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    int i = paramOneofDescriptor.a();
    Object localObject = this.a;
    if (i >= localObject.length) {
      this.a = ((OneofInfo[])Arrays.copyOf((Object[])localObject, i * 2));
    }
    OneofInfo localOneofInfo = this.a[i];
    localObject = localOneofInfo;
    if (localOneofInfo == null)
    {
      localObject = b(paramClass, paramOneofDescriptor);
      this.a[i] = localObject;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorMessageInfoFactory.OneofState
 * JD-Core Version:    0.7.0.1
 */