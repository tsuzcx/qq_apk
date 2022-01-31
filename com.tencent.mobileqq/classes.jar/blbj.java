import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class blbj
  implements bmeo<blaj>
{
  blbj(blbe paramblbe) {}
  
  public void a(@Nullable blaj paramblaj)
  {
    if (paramblaj == null) {
      return;
    }
    blag localblag;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = blbe.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localblag = (blag)localIterator.next();
      if (!localblag.jdField_a_of_type_JavaLangString.equals(paramblaj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localblag.jdField_a_of_type_Int != paramblaj.jdField_a_of_type_Int)
      {
        localblag.jdField_a_of_type_Int = paramblaj.jdField_a_of_type_Int;
        blbe.a(this.a).notifyItemChanged(blbe.a(this.a).indexOf(localblag) + 1);
      }
    } while ((localblag.jdField_a_of_type_Int != 2) || (!localblag.jdField_a_of_type_JavaLangString.equals(blbe.a(this.a))));
    blbe.a(this.a).b(localblag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbj
 * JD-Core Version:    0.7.0.1
 */