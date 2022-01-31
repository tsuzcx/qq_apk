import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.EmoticonPackage;

class aobq
  implements askq<EmoticonPackage>
{
  aobq(aobp paramaobp, String paramString) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobq
 * JD-Core Version:    0.7.0.1
 */