import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class blyh
  implements Observer<blwu>
{
  blyh(blyb paramblyb) {}
  
  public void a(@Nullable blwu paramblwu)
  {
    int i = 0;
    blyb.a(this.a).a().removeObservers(blyb.a(this.a));
    if (paramblwu != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + paramblwu });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + paramblwu.jdField_a_of_type_JavaLangString + "text ===" + paramblwu.jdField_a_of_type_Int + "material ====" + paramblwu.jdField_b_of_type_Int);
      if (paramblwu.jdField_a_of_type_JavaLangString == null)
      {
        paramblwu.jdField_a_of_type_Int = 0;
        paramblwu.jdField_b_of_type_Int = 6;
        paramblwu.jdField_a_of_type_JavaLangString = "default";
      }
      if ((paramblwu.jdField_a_of_type_JavaUtilList != null) && (paramblwu.jdField_a_of_type_JavaUtilList.size() == 0)) {
        paramblwu.jdField_a_of_type_JavaUtilList.addAll(blxg.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (paramblwu.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = amtj.a(2131699125);
        blyb.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < paramblwu.jdField_a_of_type_Int)
        {
          localObject = new blxb();
          ((blxb)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((blxb)localObject).jdField_a_of_type_JavaLangString = ((String)paramblwu.jdField_a_of_type_JavaUtilList.get(i % paramblwu.jdField_a_of_type_JavaUtilList.size()));
          ((blxb)localObject).jdField_b_of_type_Int = 2;
          if (blyb.a(this.a).size() < blyb.a(this.a)) {}
        }
        else
        {
          blyb.a(this.a).a().observe(blyb.a(this.a), new blyi(this, paramblwu));
          blyb.a(this.a, paramblwu);
          return;
          localObject = (String)blyb.a(this.a).get(paramblwu.jdField_a_of_type_JavaLangString);
          localObject = amtj.a(2131699120) + (String)localObject + amtj.a(2131699127);
          break;
        }
        blyb.a(this.a).add(localObject);
        blyb.a(this.a).notifyItemInserted(blyb.a(this.a).size() - 1);
        blzq localblzq = new blzq();
        localblzq.jdField_b_of_type_JavaLangString = ((blxb)localObject).jdField_a_of_type_JavaLangString;
        localblzq.jdField_a_of_type_Int = (i + 1);
        blyb.a(this.a).a(localblzq);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramblwu = new blxb();
    paramblwu.jdField_b_of_type_JavaLangString = "";
    paramblwu.jdField_a_of_type_JavaLangString = "";
    paramblwu.jdField_b_of_type_Int = 2;
    paramblwu.jdField_a_of_type_Int = 11;
    blyb.a(this.a).add(paramblwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyh
 * JD-Core Version:    0.7.0.1
 */