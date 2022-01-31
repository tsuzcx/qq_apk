import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bldg
  implements bmeo<blbt>
{
  bldg(blda paramblda) {}
  
  public void a(@Nullable blbt paramblbt)
  {
    int i = 0;
    blda.a(this.a).a().a(blda.a(this.a));
    if (paramblbt != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + paramblbt });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + paramblbt.jdField_a_of_type_JavaLangString + "text ===" + paramblbt.jdField_a_of_type_Int + "material ====" + paramblbt.jdField_b_of_type_Int);
      if (paramblbt.jdField_a_of_type_JavaLangString == null)
      {
        paramblbt.jdField_a_of_type_Int = 0;
        paramblbt.jdField_b_of_type_Int = 6;
        paramblbt.jdField_a_of_type_JavaLangString = "default";
      }
      if ((paramblbt.jdField_a_of_type_JavaUtilList != null) && (paramblbt.jdField_a_of_type_JavaUtilList.size() == 0)) {
        paramblbt.jdField_a_of_type_JavaUtilList.addAll(blcf.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (paramblbt.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = alud.a(2131700357);
        blda.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < paramblbt.jdField_a_of_type_Int)
        {
          localObject = new blca();
          ((blca)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((blca)localObject).jdField_a_of_type_JavaLangString = ((String)paramblbt.jdField_a_of_type_JavaUtilList.get(i % paramblbt.jdField_a_of_type_JavaUtilList.size()));
          ((blca)localObject).jdField_b_of_type_Int = 2;
          if (blda.a(this.a).size() < blda.a(this.a)) {}
        }
        else
        {
          blda.a(this.a).a(blda.a(this.a), paramblbt.jdField_a_of_type_JavaLangString);
          blda.a(this.a).b().a(blda.a(this.a), new bldh(this, paramblbt));
          blda.a(this.a).a().a(blda.a(this.a), new bldi(this, paramblbt));
          return;
          localObject = (String)blda.a(this.a).get(paramblbt.jdField_a_of_type_JavaLangString);
          localObject = alud.a(2131700352) + (String)localObject + alud.a(2131700359);
          break;
        }
        blda.a(this.a).add(localObject);
        blda.a(this.a).notifyItemInserted(blda.a(this.a).size() - 1);
        bler localbler = new bler();
        localbler.jdField_b_of_type_JavaLangString = ((blca)localObject).jdField_a_of_type_JavaLangString;
        localbler.jdField_a_of_type_Int = (i + 1);
        blda.a(this.a).a(localbler);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramblbt = new blca();
    paramblbt.jdField_b_of_type_JavaLangString = "";
    paramblbt.jdField_a_of_type_JavaLangString = "";
    paramblbt.jdField_b_of_type_Int = 2;
    paramblbt.jdField_a_of_type_Int = 11;
    blda.a(this.a).add(paramblbt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldg
 * JD-Core Version:    0.7.0.1
 */