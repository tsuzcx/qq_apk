import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class bkxc
  implements bmac<bkwc>
{
  bkxc(bkwx parambkwx) {}
  
  public void a(@Nullable bkwc parambkwc)
  {
    if (parambkwc == null) {
      return;
    }
    bkvz localbkvz;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = bkwx.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localbkvz = (bkvz)localIterator.next();
      if (!localbkvz.jdField_a_of_type_JavaLangString.equals(parambkwc.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localbkvz.jdField_a_of_type_Int != parambkwc.jdField_a_of_type_Int)
      {
        localbkvz.jdField_a_of_type_Int = parambkwc.jdField_a_of_type_Int;
        bkwx.a(this.a).notifyItemChanged(bkwx.a(this.a).indexOf(localbkvz) + 1);
      }
    } while ((localbkvz.jdField_a_of_type_Int != 2) || (!localbkvz.jdField_a_of_type_JavaLangString.equals(bkwx.a(this.a))));
    bkwx.a(this.a).b(localbkvz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxc
 * JD-Core Version:    0.7.0.1
 */