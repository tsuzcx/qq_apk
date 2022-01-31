import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class bkfy
  extends SoftReference<V>
{
  private K jdField_a_of_type_JavaLangObject;
  
  public bkfy(K paramK, V paramV, ReferenceQueue<? super V> paramReferenceQueue)
  {
    super(paramReferenceQueue, localReferenceQueue);
    this.jdField_a_of_type_JavaLangObject = paramV;
  }
  
  public K a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkfy
 * JD-Core Version:    0.7.0.1
 */