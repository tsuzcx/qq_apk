import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bhtn
  implements bhwg<bhso>
{
  bhtn(bhtg parambhtg) {}
  
  public void a(@Nullable bhso parambhso)
  {
    int i = 0;
    bhtg.a(this.a).a().a(bhtg.a(this.a));
    if (parambhso != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambhso });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambhso.jdField_a_of_type_JavaLangString + "text ===" + parambhso.jdField_a_of_type_Int + "material ====" + parambhso.jdField_b_of_type_Int);
      if (parambhso.jdField_a_of_type_JavaLangString == null)
      {
        parambhso.jdField_a_of_type_Int = 0;
        parambhso.jdField_b_of_type_Int = 6;
        parambhso.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambhso.jdField_a_of_type_JavaUtilList != null) && (parambhso.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambhso.jdField_a_of_type_JavaUtilList.addAll(bhsk.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambhso.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = ajjy.a(2131634177);
        bhtg.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambhso.jdField_a_of_type_Int)
        {
          localObject = new bhsf();
          ((bhsf)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bhsf)localObject).jdField_a_of_type_JavaLangString = ((String)parambhso.jdField_a_of_type_JavaUtilList.get(i % parambhso.jdField_a_of_type_JavaUtilList.size()));
          ((bhsf)localObject).jdField_b_of_type_Int = 2;
          if (bhtg.b(this.a).size() < bhtg.b(this.a)) {}
        }
        else
        {
          bhtg.a(this.a).a(bhtg.a(this.a), parambhso.jdField_a_of_type_JavaLangString);
          bhtg.a(this.a).b().a(bhtg.a(this.a), new bhto(this, parambhso));
          bhtg.a(this.a).a().a(bhtg.a(this.a), new bhtp(this, parambhso));
          return;
          localObject = (String)bhtg.a(this.a).get(parambhso.jdField_a_of_type_JavaLangString);
          localObject = ajjy.a(2131634172) + (String)localObject + ajjy.a(2131634179);
          break;
        }
        bhtg.b(this.a).add(localObject);
        bhtg.a(this.a).notifyItemInserted(bhtg.b(this.a).size() - 1);
        biaj localbiaj = new biaj();
        localbiaj.jdField_b_of_type_JavaLangString = ((bhsf)localObject).jdField_a_of_type_JavaLangString;
        localbiaj.jdField_a_of_type_Int = (i + 1);
        bhtg.b(this.a).a(localbiaj);
        bhtg.c(this.a).add(localbiaj);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambhso = new bhsf();
    parambhso.jdField_b_of_type_JavaLangString = "";
    parambhso.jdField_a_of_type_JavaLangString = "";
    parambhso.jdField_b_of_type_Int = 2;
    parambhso.jdField_a_of_type_Int = 11;
    bhtg.b(this.a).add(parambhso);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhtn
 * JD-Core Version:    0.7.0.1
 */