package androidx.collection;

import java.util.Map;

class ArraySet$1
  extends MapCollections<E, E>
{
  ArraySet$1(ArraySet paramArraySet) {}
  
  protected void colClear()
  {
    this.this$0.clear();
  }
  
  protected Object colGetEntry(int paramInt1, int paramInt2)
  {
    return this.this$0.mArray[paramInt1];
  }
  
  protected Map<E, E> colGetMap()
  {
    throw new UnsupportedOperationException("not a map");
  }
  
  protected int colGetSize()
  {
    return this.this$0.mSize;
  }
  
  protected int colIndexOfKey(Object paramObject)
  {
    return this.this$0.indexOf(paramObject);
  }
  
  protected int colIndexOfValue(Object paramObject)
  {
    return this.this$0.indexOf(paramObject);
  }
  
  protected void colPut(E paramE1, E paramE2)
  {
    this.this$0.add(paramE1);
  }
  
  protected void colRemoveAt(int paramInt)
  {
    this.this$0.removeAt(paramInt);
  }
  
  protected E colSetValue(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("not a map");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.collection.ArraySet.1
 * JD-Core Version:    0.7.0.1
 */