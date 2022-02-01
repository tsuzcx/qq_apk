package com.google.protobuf;

import java.util.ArrayDeque;
import java.util.Arrays;

class RopeByteString$Balancer
{
  private final ArrayDeque<ByteString> a = new ArrayDeque();
  
  private int a(int paramInt)
  {
    int i = Arrays.binarySearch(RopeByteString.minLengthByDepth, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    return paramInt;
  }
  
  private ByteString a(ByteString paramByteString1, ByteString paramByteString2)
  {
    a(paramByteString1);
    a(paramByteString2);
    for (paramByteString1 = (ByteString)this.a.pop(); !this.a.isEmpty(); paramByteString1 = new RopeByteString((ByteString)this.a.pop(), paramByteString1, null)) {}
    return paramByteString1;
  }
  
  private void a(ByteString paramByteString)
  {
    if (paramByteString.isBalanced())
    {
      b(paramByteString);
      return;
    }
    if ((paramByteString instanceof RopeByteString))
    {
      paramByteString = (RopeByteString)paramByteString;
      a(RopeByteString.access$400(paramByteString));
      a(RopeByteString.access$500(paramByteString));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Has a new type of ByteString been created? Found ");
    localStringBuilder.append(paramByteString.getClass());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void b(ByteString paramByteString)
  {
    int i = a(paramByteString.size());
    int j = RopeByteString.minLengthByDepth[(i + 1)];
    if ((!this.a.isEmpty()) && (((ByteString)this.a.peek()).size() < j))
    {
      i = RopeByteString.minLengthByDepth[i];
      for (Object localObject = (ByteString)this.a.pop(); (!this.a.isEmpty()) && (((ByteString)this.a.peek()).size() < i); localObject = new RopeByteString((ByteString)this.a.pop(), (ByteString)localObject, null)) {}
      for (paramByteString = new RopeByteString((ByteString)localObject, paramByteString, null); !this.a.isEmpty(); paramByteString = new RopeByteString((ByteString)this.a.pop(), paramByteString, null))
      {
        i = a(paramByteString.size());
        i = RopeByteString.minLengthByDepth[(i + 1)];
        if (((ByteString)this.a.peek()).size() >= i) {
          break;
        }
      }
      this.a.push(paramByteString);
      return;
    }
    this.a.push(paramByteString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RopeByteString.Balancer
 * JD-Core Version:    0.7.0.1
 */