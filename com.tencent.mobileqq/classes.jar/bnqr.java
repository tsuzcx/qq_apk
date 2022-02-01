import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class bnqr
  implements Observer<bnpn>
{
  bnqr(bnqm parambnqm) {}
  
  public void a(@Nullable bnpn parambnpn)
  {
    if (parambnpn == null) {
      return;
    }
    bnpk localbnpk;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = bnqm.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localbnpk = (bnpk)localIterator.next();
      if (!localbnpk.jdField_a_of_type_JavaLangString.equals(parambnpn.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localbnpk.jdField_a_of_type_Int != parambnpn.jdField_a_of_type_Int)
      {
        localbnpk.jdField_a_of_type_Int = parambnpn.jdField_a_of_type_Int;
        bnqm.a(this.a).notifyItemChanged(bnqm.a(this.a).indexOf(localbnpk) + 1);
      }
    } while ((localbnpk.jdField_a_of_type_Int != 2) || (!localbnpk.jdField_a_of_type_JavaLangString.equals(bnqm.a(this.a))));
    bnqm.a(this.a).b(localbnpk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqr
 * JD-Core Version:    0.7.0.1
 */