package com.google.protobuf;

import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class RopeByteString
  extends ByteString
{
  static final int[] minLengthByDepth = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, 2147483647 };
  private static final long serialVersionUID = 1L;
  private final ByteString left;
  private final int leftLength;
  private final ByteString right;
  private final int totalLength;
  private final int treeDepth;
  
  private RopeByteString(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.left = paramByteString1;
    this.right = paramByteString2;
    this.leftLength = paramByteString1.size();
    this.totalLength = (this.leftLength + paramByteString2.size());
    this.treeDepth = (Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth()) + 1);
  }
  
  private static ByteString a(ByteString paramByteString1, ByteString paramByteString2)
  {
    int i = paramByteString1.size();
    int j = paramByteString2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramByteString1.copyTo(arrayOfByte, 0, 0, i);
    paramByteString2.copyTo(arrayOfByte, 0, i, j);
    return ByteString.wrap(arrayOfByte);
  }
  
  private boolean a(ByteString paramByteString)
  {
    RopeByteString.PieceIterator localPieceIterator1 = new RopeByteString.PieceIterator(this, null);
    ByteString.LeafByteString localLeafByteString = (ByteString.LeafByteString)localPieceIterator1.next();
    RopeByteString.PieceIterator localPieceIterator2 = new RopeByteString.PieceIterator(paramByteString, null);
    paramByteString = (ByteString.LeafByteString)localPieceIterator2.next();
    int j = 0;
    int i = 0;
    int k = 0;
    for (;;)
    {
      int i1 = localLeafByteString.size() - j;
      int m = paramByteString.size() - i;
      int n = Math.min(i1, m);
      boolean bool;
      if (j == 0) {
        bool = localLeafByteString.equalsRange(paramByteString, i, n);
      } else {
        bool = paramByteString.equalsRange(localLeafByteString, j, n);
      }
      if (!bool) {
        return false;
      }
      k += n;
      int i2 = this.totalLength;
      if (k >= i2)
      {
        if (k == i2) {
          return true;
        }
        throw new IllegalStateException();
      }
      if (n == i1)
      {
        localLeafByteString = (ByteString.LeafByteString)localPieceIterator1.next();
        j = 0;
      }
      else
      {
        j += n;
      }
      if (n == m)
      {
        paramByteString = (ByteString.LeafByteString)localPieceIterator2.next();
        i = 0;
      }
      else
      {
        i += n;
      }
    }
  }
  
  static ByteString concatenate(ByteString paramByteString1, ByteString paramByteString2)
  {
    if (paramByteString2.size() == 0) {
      return paramByteString1;
    }
    if (paramByteString1.size() == 0) {
      return paramByteString2;
    }
    int i = paramByteString1.size() + paramByteString2.size();
    if (i < 128) {
      return a(paramByteString1, paramByteString2);
    }
    if ((paramByteString1 instanceof RopeByteString))
    {
      RopeByteString localRopeByteString = (RopeByteString)paramByteString1;
      if (localRopeByteString.right.size() + paramByteString2.size() < 128)
      {
        paramByteString1 = a(localRopeByteString.right, paramByteString2);
        return new RopeByteString(localRopeByteString.left, paramByteString1);
      }
      if ((localRopeByteString.left.getTreeDepth() > localRopeByteString.right.getTreeDepth()) && (localRopeByteString.getTreeDepth() > paramByteString2.getTreeDepth()))
      {
        paramByteString1 = new RopeByteString(localRopeByteString.right, paramByteString2);
        return new RopeByteString(localRopeByteString.left, paramByteString1);
      }
    }
    int j = Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth());
    if (i >= minLengthByDepth[(j + 1)]) {
      return new RopeByteString(paramByteString1, paramByteString2);
    }
    return RopeByteString.Balancer.a(new RopeByteString.Balancer(null), paramByteString1, paramByteString2);
  }
  
  static RopeByteString newInstanceForTest(ByteString paramByteString1, ByteString paramByteString2)
  {
    return new RopeByteString(paramByteString1, paramByteString2);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    ArrayList localArrayList = new ArrayList();
    RopeByteString.PieceIterator localPieceIterator = new RopeByteString.PieceIterator(this, null);
    while (localPieceIterator.hasNext()) {
      localArrayList.add(localPieceIterator.a().asReadOnlyByteBuffer());
    }
    return localArrayList;
  }
  
  public byte byteAt(int paramInt)
  {
    checkIndex(paramInt, this.totalLength);
    return internalByteAt(paramInt);
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    this.left.copyTo(paramByteBuffer);
    this.right.copyTo(paramByteBuffer);
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt1 + paramInt3 <= i)
    {
      this.left.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= i)
    {
      this.right.copyToInternal(paramArrayOfByte, paramInt1 - i, paramInt2, paramInt3);
      return;
    }
    i -= paramInt1;
    this.left.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, i);
    this.right.copyToInternal(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    paramObject = (ByteString)paramObject;
    if (this.totalLength != paramObject.size()) {
      return false;
    }
    if (this.totalLength == 0) {
      return true;
    }
    int i = peekCachedHashCode();
    int j = paramObject.peekCachedHashCode();
    if ((i != 0) && (j != 0) && (i != j)) {
      return false;
    }
    return a(paramObject);
  }
  
  protected int getTreeDepth()
  {
    return this.treeDepth;
  }
  
  byte internalByteAt(int paramInt)
  {
    int i = this.leftLength;
    if (paramInt < i) {
      return this.left.internalByteAt(paramInt);
    }
    return this.right.internalByteAt(paramInt - i);
  }
  
  protected boolean isBalanced()
  {
    return this.totalLength >= minLengthByDepth[this.treeDepth];
  }
  
  public boolean isValidUtf8()
  {
    ByteString localByteString = this.left;
    int i = this.leftLength;
    boolean bool = false;
    i = localByteString.partialIsValidUtf8(0, 0, i);
    localByteString = this.right;
    if (localByteString.partialIsValidUtf8(i, 0, localByteString.size()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new RopeByteString.1(this);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.a(new RopeByteString.RopeInputStream(this));
  }
  
  public InputStream newInput()
  {
    return new RopeByteString.RopeInputStream(this);
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialHash(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialHash(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialHash(paramInt1, paramInt2, i);
    return this.right.partialHash(paramInt1, 0, paramInt3 - i);
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialIsValidUtf8(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialIsValidUtf8(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialIsValidUtf8(paramInt1, paramInt2, i);
    return this.right.partialIsValidUtf8(paramInt1, 0, paramInt3 - i);
  }
  
  public int size()
  {
    return this.totalLength;
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    int i = checkRange(paramInt1, paramInt2, this.totalLength);
    if (i == 0) {
      return ByteString.EMPTY;
    }
    if (i == this.totalLength) {
      return this;
    }
    i = this.leftLength;
    if (paramInt2 <= i) {
      return this.left.substring(paramInt1, paramInt2);
    }
    if (paramInt1 >= i) {
      return this.right.substring(paramInt1 - i, paramInt2 - i);
    }
    return new RopeByteString(this.left.substring(paramInt1), this.right.substring(0, paramInt2 - this.leftLength));
  }
  
  protected String toStringInternal(Charset paramCharset)
  {
    return new String(toByteArray(), paramCharset);
  }
  
  Object writeReplace()
  {
    return ByteString.wrap(toByteArray());
  }
  
  void writeTo(ByteOutput paramByteOutput)
  {
    this.left.writeTo(paramByteOutput);
    this.right.writeTo(paramByteOutput);
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.left.writeTo(paramOutputStream);
    this.right.writeTo(paramOutputStream);
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    int i = this.leftLength;
    if (paramInt1 + paramInt2 <= i)
    {
      this.left.writeToInternal(paramOutputStream, paramInt1, paramInt2);
      return;
    }
    if (paramInt1 >= i)
    {
      this.right.writeToInternal(paramOutputStream, paramInt1 - i, paramInt2);
      return;
    }
    i -= paramInt1;
    this.left.writeToInternal(paramOutputStream, paramInt1, i);
    this.right.writeToInternal(paramOutputStream, 0, paramInt2 - i);
  }
  
  void writeToReverse(ByteOutput paramByteOutput)
  {
    this.right.writeToReverse(paramByteOutput);
    this.left.writeToReverse(paramByteOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RopeByteString
 * JD-Core Version:    0.7.0.1
 */