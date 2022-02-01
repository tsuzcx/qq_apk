package com.google.protobuf;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class RopeByteString$PieceIterator
  implements Iterator<ByteString.LeafByteString>
{
  private final ArrayDeque<RopeByteString> a;
  private ByteString.LeafByteString b;
  
  private RopeByteString$PieceIterator(ByteString paramByteString)
  {
    if ((paramByteString instanceof RopeByteString))
    {
      paramByteString = (RopeByteString)paramByteString;
      this.a = new ArrayDeque(paramByteString.getTreeDepth());
      this.a.push(paramByteString);
      this.b = a(RopeByteString.access$400(paramByteString));
      return;
    }
    this.a = null;
    this.b = ((ByteString.LeafByteString)paramByteString);
  }
  
  private ByteString.LeafByteString a(ByteString paramByteString)
  {
    while ((paramByteString instanceof RopeByteString))
    {
      paramByteString = (RopeByteString)paramByteString;
      this.a.push(paramByteString);
      paramByteString = RopeByteString.access$400(paramByteString);
    }
    return (ByteString.LeafByteString)paramByteString;
  }
  
  private ByteString.LeafByteString b()
  {
    Object localObject;
    do
    {
      localObject = this.a;
      if ((localObject == null) || (((ArrayDeque)localObject).isEmpty())) {
        break;
      }
      localObject = a(RopeByteString.access$500((RopeByteString)this.a.pop()));
    } while (((ByteString.LeafByteString)localObject).isEmpty());
    return localObject;
    return null;
  }
  
  public ByteString.LeafByteString a()
  {
    ByteString.LeafByteString localLeafByteString = this.b;
    if (localLeafByteString != null)
    {
      this.b = b();
      return localLeafByteString;
    }
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return this.b != null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RopeByteString.PieceIterator
 * JD-Core Version:    0.7.0.1
 */