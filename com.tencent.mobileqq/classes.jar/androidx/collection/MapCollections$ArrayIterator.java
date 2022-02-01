package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class MapCollections$ArrayIterator<T>
  implements Iterator<T>
{
  boolean mCanRemove = false;
  int mIndex;
  final int mOffset;
  int mSize;
  
  MapCollections$ArrayIterator(MapCollections paramMapCollections, int paramInt)
  {
    this.mOffset = paramInt;
    this.mSize = paramMapCollections.colGetSize();
  }
  
  public boolean hasNext()
  {
    return this.mIndex < this.mSize;
  }
  
  public T next()
  {
    if (hasNext())
    {
      Object localObject = this.this$0.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex += 1;
      this.mCanRemove = true;
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (this.mCanRemove)
    {
      this.mIndex -= 1;
      this.mSize -= 1;
      this.mCanRemove = false;
      this.this$0.colRemoveAt(this.mIndex);
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.collection.MapCollections.ArrayIterator
 * JD-Core Version:    0.7.0.1
 */