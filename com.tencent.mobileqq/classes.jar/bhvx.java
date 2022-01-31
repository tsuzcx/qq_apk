class bhvx<K, V>
  extends bhwa<K, V>
{
  bhvx(bhvy<K, V> parambhvy1, bhvy<K, V> parambhvy2)
  {
    super(parambhvy1, parambhvy2);
  }
  
  bhvy<K, V> a(bhvy<K, V> parambhvy)
  {
    return parambhvy.b;
  }
  
  bhvy<K, V> b(bhvy<K, V> parambhvy)
  {
    return parambhvy.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvx
 * JD-Core Version:    0.7.0.1
 */