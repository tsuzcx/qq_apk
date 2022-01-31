import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class birs
  implements bjob<biqv>
{
  birs(birn parambirn) {}
  
  public void a(@Nullable biqv parambiqv)
  {
    if (parambiqv == null) {
      return;
    }
    biqs localbiqs;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = birn.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localbiqs = (biqs)localIterator.next();
      if (!localbiqs.jdField_a_of_type_JavaLangString.equals(parambiqv.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localbiqs.jdField_a_of_type_Int != parambiqv.jdField_a_of_type_Int)
      {
        localbiqs.jdField_a_of_type_Int = parambiqv.jdField_a_of_type_Int;
        birn.a(this.a).notifyItemChanged(birn.a(this.a).indexOf(localbiqs) + 1);
      }
    } while ((localbiqs.jdField_a_of_type_Int != 2) || (!localbiqs.jdField_a_of_type_JavaLangString.equals(birn.a(this.a))));
    birn.a(this.a).b(localbiqs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birs
 * JD-Core Version:    0.7.0.1
 */