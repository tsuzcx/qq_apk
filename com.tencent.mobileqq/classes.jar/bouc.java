import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bouc
  implements Observer<bosp>
{
  bouc(botw parambotw) {}
  
  public void a(@Nullable bosp parambosp)
  {
    int i = 0;
    botw.a(this.a).a().removeObservers(botw.a(this.a));
    if (parambosp != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambosp });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambosp.jdField_a_of_type_JavaLangString + "text ===" + parambosp.jdField_a_of_type_Int + "material ====" + parambosp.jdField_b_of_type_Int);
      if (parambosp.jdField_a_of_type_JavaLangString == null)
      {
        parambosp.jdField_a_of_type_Int = 0;
        parambosp.jdField_b_of_type_Int = 6;
        parambosp.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambosp.jdField_a_of_type_JavaUtilList != null) && (parambosp.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambosp.jdField_a_of_type_JavaUtilList.addAll(botb.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambosp.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = anzj.a(2131698890);
        botw.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambosp.jdField_a_of_type_Int)
        {
          localObject = new bosw();
          ((bosw)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bosw)localObject).jdField_a_of_type_JavaLangString = ((String)parambosp.jdField_a_of_type_JavaUtilList.get(i % parambosp.jdField_a_of_type_JavaUtilList.size()));
          ((bosw)localObject).jdField_b_of_type_Int = 2;
          if (botw.a(this.a).size() < botw.a(this.a)) {}
        }
        else
        {
          botw.a(this.a).a().observe(botw.a(this.a), new boud(this, parambosp));
          botw.a(this.a, parambosp);
          return;
          localObject = (String)botw.a(this.a).get(parambosp.jdField_a_of_type_JavaLangString);
          localObject = anzj.a(2131698885) + (String)localObject + anzj.a(2131698892);
          break;
        }
        botw.a(this.a).add(localObject);
        botw.a(this.a).notifyItemInserted(botw.a(this.a).size() - 1);
        bovl localbovl = new bovl();
        localbovl.jdField_b_of_type_JavaLangString = ((bosw)localObject).jdField_a_of_type_JavaLangString;
        localbovl.jdField_a_of_type_Int = (i + 1);
        botw.a(this.a).a(localbovl);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambosp = new bosw();
    parambosp.jdField_b_of_type_JavaLangString = "";
    parambosp.jdField_a_of_type_JavaLangString = "";
    parambosp.jdField_b_of_type_Int = 2;
    parambosp.jdField_a_of_type_Int = 11;
    botw.a(this.a).add(parambosp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bouc
 * JD-Core Version:    0.7.0.1
 */