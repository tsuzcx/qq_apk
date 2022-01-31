import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class biug
  implements bjos<bist>
{
  biug(biua parambiua) {}
  
  public void a(@Nullable bist parambist)
  {
    int i = 0;
    biua.a(this.a).a().a(biua.a(this.a));
    if (parambist != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambist });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambist.jdField_a_of_type_JavaLangString + "text ===" + parambist.jdField_a_of_type_Int + "material ====" + parambist.jdField_b_of_type_Int);
      if (parambist.jdField_a_of_type_JavaLangString == null)
      {
        parambist.jdField_a_of_type_Int = 0;
        parambist.jdField_b_of_type_Int = 6;
        parambist.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambist.jdField_a_of_type_JavaUtilList != null) && (parambist.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambist.jdField_a_of_type_JavaUtilList.addAll(bitf.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambist.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = ajya.a(2131699976);
        biua.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambist.jdField_a_of_type_Int)
        {
          localObject = new bita();
          ((bita)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bita)localObject).jdField_a_of_type_JavaLangString = ((String)parambist.jdField_a_of_type_JavaUtilList.get(i % parambist.jdField_a_of_type_JavaUtilList.size()));
          ((bita)localObject).jdField_b_of_type_Int = 2;
          if (biua.a(this.a).size() < biua.a(this.a)) {}
        }
        else
        {
          biua.a(this.a).a(biua.a(this.a), parambist.jdField_a_of_type_JavaLangString);
          biua.a(this.a).b().a(biua.a(this.a), new biuh(this, parambist));
          biua.a(this.a).a().a(biua.a(this.a), new biui(this, parambist));
          return;
          localObject = (String)biua.a(this.a).get(parambist.jdField_a_of_type_JavaLangString);
          localObject = ajya.a(2131699971) + (String)localObject + ajya.a(2131699978);
          break;
        }
        biua.a(this.a).add(localObject);
        biua.a(this.a).notifyItemInserted(biua.a(this.a).size() - 1);
        bivq localbivq = new bivq();
        localbivq.jdField_b_of_type_JavaLangString = ((bita)localObject).jdField_a_of_type_JavaLangString;
        localbivq.jdField_a_of_type_Int = (i + 1);
        biua.a(this.a).a(localbivq);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambist = new bita();
    parambist.jdField_b_of_type_JavaLangString = "";
    parambist.jdField_a_of_type_JavaLangString = "";
    parambist.jdField_b_of_type_Int = 2;
    parambist.jdField_a_of_type_Int = 11;
    biua.a(this.a).add(parambist);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biug
 * JD-Core Version:    0.7.0.1
 */