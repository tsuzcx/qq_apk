class bjoj<K, V>
  extends bjom<K, V>
{
  bjoj(bjok<K, V> parambjok1, bjok<K, V> parambjok2)
  {
    super(parambjok1, parambjok2);
  }
  
  bjok<K, V> a(bjok<K, V> parambjok)
  {
    return parambjok.b;
  }
  
  bjok<K, V> b(bjok<K, V> parambjok)
  {
    return parambjok.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoj
 * JD-Core Version:    0.7.0.1
 */