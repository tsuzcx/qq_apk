import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class bisj
  implements bjos<birm>
{
  bisj(bise parambise) {}
  
  public void a(@Nullable birm parambirm)
  {
    if (parambirm == null) {
      return;
    }
    birj localbirj;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = bise.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localbirj = (birj)localIterator.next();
      if (!localbirj.jdField_a_of_type_JavaLangString.equals(parambirm.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localbirj.jdField_a_of_type_Int != parambirm.jdField_a_of_type_Int)
      {
        localbirj.jdField_a_of_type_Int = parambirm.jdField_a_of_type_Int;
        bise.a(this.a).notifyItemChanged(bise.a(this.a).indexOf(localbirj) + 1);
      }
    } while ((localbirj.jdField_a_of_type_Int != 2) || (!localbirj.jdField_a_of_type_JavaLangString.equals(bise.a(this.a))));
    bise.a(this.a).b(localbirj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisj
 * JD-Core Version:    0.7.0.1
 */