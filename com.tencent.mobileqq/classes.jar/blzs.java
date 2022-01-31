class blzs<K, V>
  extends blzv<K, V>
{
  blzs(blzt<K, V> paramblzt1, blzt<K, V> paramblzt2)
  {
    super(paramblzt1, paramblzt2);
  }
  
  blzt<K, V> a(blzt<K, V> paramblzt)
  {
    return paramblzt.b;
  }
  
  blzt<K, V> b(blzt<K, V> paramblzt)
  {
    return paramblzt.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzs
 * JD-Core Version:    0.7.0.1
 */