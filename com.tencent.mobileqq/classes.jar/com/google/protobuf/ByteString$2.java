package com.google.protobuf;

import java.util.Comparator;

final class ByteString$2
  implements Comparator<ByteString>
{
  public int a(ByteString paramByteString1, ByteString paramByteString2)
  {
    ByteString.ByteIterator localByteIterator1 = paramByteString1.iterator();
    ByteString.ByteIterator localByteIterator2 = paramByteString2.iterator();
    while ((localByteIterator1.hasNext()) && (localByteIterator2.hasNext()))
    {
      int i = Integer.compare(ByteString.access$200(localByteIterator1.a()), ByteString.access$200(localByteIterator2.a()));
      if (i != 0) {
        return i;
      }
    }
    return Integer.compare(paramByteString1.size(), paramByteString2.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.2
 * JD-Core Version:    0.7.0.1
 */