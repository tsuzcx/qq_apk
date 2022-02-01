import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bnso
  implements Observer<bnrb>
{
  bnso(bnsi parambnsi) {}
  
  public void a(@Nullable bnrb parambnrb)
  {
    int i = 0;
    bnsi.a(this.a).a().removeObservers(bnsi.a(this.a));
    if (parambnrb != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambnrb });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambnrb.jdField_a_of_type_JavaLangString + "text ===" + parambnrb.jdField_a_of_type_Int + "material ====" + parambnrb.jdField_b_of_type_Int);
      if (parambnrb.jdField_a_of_type_JavaLangString == null)
      {
        parambnrb.jdField_a_of_type_Int = 0;
        parambnrb.jdField_b_of_type_Int = 6;
        parambnrb.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambnrb.jdField_a_of_type_JavaUtilList != null) && (parambnrb.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambnrb.jdField_a_of_type_JavaUtilList.addAll(bnrn.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambnrb.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = anni.a(2131698783);
        bnsi.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambnrb.jdField_a_of_type_Int)
        {
          localObject = new bnri();
          ((bnri)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bnri)localObject).jdField_a_of_type_JavaLangString = ((String)parambnrb.jdField_a_of_type_JavaUtilList.get(i % parambnrb.jdField_a_of_type_JavaUtilList.size()));
          ((bnri)localObject).jdField_b_of_type_Int = 2;
          if (bnsi.a(this.a).size() < bnsi.a(this.a)) {}
        }
        else
        {
          bnsi.a(this.a).a(bnsi.a(this.a), parambnrb.jdField_a_of_type_JavaLangString);
          bnsi.a(this.a).b().observe(bnsi.a(this.a), new bnsp(this, parambnrb));
          bnsi.a(this.a).a().observe(bnsi.a(this.a), new bnsq(this, parambnrb));
          return;
          localObject = (String)bnsi.a(this.a).get(parambnrb.jdField_a_of_type_JavaLangString);
          localObject = anni.a(2131698778) + (String)localObject + anni.a(2131698785);
          break;
        }
        bnsi.a(this.a).add(localObject);
        bnsi.a(this.a).notifyItemInserted(bnsi.a(this.a).size() - 1);
        bntz localbntz = new bntz();
        localbntz.jdField_b_of_type_JavaLangString = ((bnri)localObject).jdField_a_of_type_JavaLangString;
        localbntz.jdField_a_of_type_Int = (i + 1);
        bnsi.a(this.a).a(localbntz);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambnrb = new bnri();
    parambnrb.jdField_b_of_type_JavaLangString = "";
    parambnrb.jdField_a_of_type_JavaLangString = "";
    parambnrb.jdField_b_of_type_Int = 2;
    parambnrb.jdField_a_of_type_Int = 11;
    bnsi.a(this.a).add(parambnrb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnso
 * JD-Core Version:    0.7.0.1
 */