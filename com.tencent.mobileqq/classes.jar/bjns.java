class bjns<K, V>
  extends bjnv<K, V>
{
  bjns(bjnt<K, V> parambjnt1, bjnt<K, V> parambjnt2)
  {
    super(parambjnt1, parambjnt2);
  }
  
  bjnt<K, V> a(bjnt<K, V> parambjnt)
  {
    return parambjnt.b;
  }
  
  bjnt<K, V> b(bjnt<K, V> parambjnt)
  {
    return parambjnt.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjns
 * JD-Core Version:    0.7.0.1
 */