package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Map.Entry;

class SafeIterableMap$Entry<K, V>
  implements Map.Entry<K, V>
{
  @NonNull
  final K mKey;
  Entry<K, V> mNext;
  Entry<K, V> mPrevious;
  @NonNull
  final V mValue;
  
  SafeIterableMap$Entry(@NonNull K paramK, @NonNull V paramV)
  {
    this.mKey = paramK;
    this.mValue = paramV;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Entry)) {
        return false;
      }
      paramObject = (Entry)paramObject;
    } while ((this.mKey.equals(paramObject.mKey)) && (this.mValue.equals(paramObject.mValue)));
    return false;
  }
  
  @NonNull
  public K getKey()
  {
    return this.mKey;
  }
  
  @NonNull
  public V getValue()
  {
    return this.mValue;
  }
  
  public V setValue(V paramV)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mKey);
    localStringBuilder.append("=");
    localStringBuilder.append(this.mValue);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.Entry
 * JD-Core Version:    0.7.0.1
 */