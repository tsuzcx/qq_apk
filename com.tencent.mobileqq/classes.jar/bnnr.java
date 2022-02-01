import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bnnr
  implements Observer<bnme>
{
  bnnr(bnnl parambnnl) {}
  
  public void a(@Nullable bnme parambnme)
  {
    int i = 0;
    bnnl.a(this.a).a().removeObservers(bnnl.a(this.a));
    if (parambnme != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambnme });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambnme.jdField_a_of_type_JavaLangString + "text ===" + parambnme.jdField_a_of_type_Int + "material ====" + parambnme.jdField_b_of_type_Int);
      if (parambnme.jdField_a_of_type_JavaLangString == null)
      {
        parambnme.jdField_a_of_type_Int = 0;
        parambnme.jdField_b_of_type_Int = 6;
        parambnme.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambnme.jdField_a_of_type_JavaUtilList != null) && (parambnme.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambnme.jdField_a_of_type_JavaUtilList.addAll(bnmq.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambnme.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = anvx.a(2131699476);
        bnnl.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambnme.jdField_a_of_type_Int)
        {
          localObject = new bnml();
          ((bnml)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bnml)localObject).jdField_a_of_type_JavaLangString = ((String)parambnme.jdField_a_of_type_JavaUtilList.get(i % parambnme.jdField_a_of_type_JavaUtilList.size()));
          ((bnml)localObject).jdField_b_of_type_Int = 2;
          if (bnnl.a(this.a).size() < bnnl.a(this.a)) {}
        }
        else
        {
          bnnl.a(this.a).a().observe(bnnl.a(this.a), new bnns(this, parambnme));
          bnnl.a(this.a, parambnme);
          return;
          localObject = (String)bnnl.a(this.a).get(parambnme.jdField_a_of_type_JavaLangString);
          localObject = anvx.a(2131699471) + (String)localObject + anvx.a(2131699478);
          break;
        }
        bnnl.a(this.a).add(localObject);
        bnnl.a(this.a).notifyItemInserted(bnnl.a(this.a).size() - 1);
        bnpa localbnpa = new bnpa();
        localbnpa.jdField_b_of_type_JavaLangString = ((bnml)localObject).jdField_a_of_type_JavaLangString;
        localbnpa.jdField_a_of_type_Int = (i + 1);
        bnnl.a(this.a).a(localbnpa);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambnme = new bnml();
    parambnme.jdField_b_of_type_JavaLangString = "";
    parambnme.jdField_a_of_type_JavaLangString = "";
    parambnme.jdField_b_of_type_Int = 2;
    parambnme.jdField_a_of_type_Int = 11;
    bnnl.a(this.a).add(parambnme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnr
 * JD-Core Version:    0.7.0.1
 */