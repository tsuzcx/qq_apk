import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class amiq
  implements Iterator
{
  int jdField_a_of_type_Int;
  amin jdField_a_of_type_Amin = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  amin jdField_b_of_type_Amin = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  amiq(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected amin a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Amin = this.jdField_a_of_type_Amin;
    this.jdField_a_of_type_Amin = amin.a(this.jdField_a_of_type_Amin);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Amin;
  }
  
  public boolean hasNext()
  {
    amin[] arrayOfamin = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      amin localamin = this.jdField_a_of_type_Amin;
      int i = this.jdField_a_of_type_Int;
      while ((localamin == null) && (i > 0))
      {
        i -= 1;
        localamin = arrayOfamin[i];
      }
      this.jdField_a_of_type_Amin = localamin;
      this.jdField_a_of_type_Int = i;
      if (localamin == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localamin.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Amin = amin.a(this.jdField_a_of_type_Amin);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Amin == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Amin = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amiq
 * JD-Core Version:    0.7.0.1
 */