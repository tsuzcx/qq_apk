import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bitp
  implements bjob<bisc>
{
  bitp(bitj parambitj) {}
  
  public void a(@Nullable bisc parambisc)
  {
    int i = 0;
    bitj.a(this.a).a().a(bitj.a(this.a));
    if (parambisc != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambisc });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambisc.jdField_a_of_type_JavaLangString + "text ===" + parambisc.jdField_a_of_type_Int + "material ====" + parambisc.jdField_b_of_type_Int);
      if (parambisc.jdField_a_of_type_JavaLangString == null)
      {
        parambisc.jdField_a_of_type_Int = 0;
        parambisc.jdField_b_of_type_Int = 6;
        parambisc.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambisc.jdField_a_of_type_JavaUtilList != null) && (parambisc.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambisc.jdField_a_of_type_JavaUtilList.addAll(biso.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambisc.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = ajyc.a(2131699965);
        bitj.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambisc.jdField_a_of_type_Int)
        {
          localObject = new bisj();
          ((bisj)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bisj)localObject).jdField_a_of_type_JavaLangString = ((String)parambisc.jdField_a_of_type_JavaUtilList.get(i % parambisc.jdField_a_of_type_JavaUtilList.size()));
          ((bisj)localObject).jdField_b_of_type_Int = 2;
          if (bitj.a(this.a).size() < bitj.a(this.a)) {}
        }
        else
        {
          bitj.a(this.a).a(bitj.a(this.a), parambisc.jdField_a_of_type_JavaLangString);
          bitj.a(this.a).b().a(bitj.a(this.a), new bitq(this, parambisc));
          bitj.a(this.a).a().a(bitj.a(this.a), new bitr(this, parambisc));
          return;
          localObject = (String)bitj.a(this.a).get(parambisc.jdField_a_of_type_JavaLangString);
          localObject = ajyc.a(2131699960) + (String)localObject + ajyc.a(2131699967);
          break;
        }
        bitj.a(this.a).add(localObject);
        bitj.a(this.a).notifyItemInserted(bitj.a(this.a).size() - 1);
        biuz localbiuz = new biuz();
        localbiuz.jdField_b_of_type_JavaLangString = ((bisj)localObject).jdField_a_of_type_JavaLangString;
        localbiuz.jdField_a_of_type_Int = (i + 1);
        bitj.a(this.a).a(localbiuz);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambisc = new bisj();
    parambisc.jdField_b_of_type_JavaLangString = "";
    parambisc.jdField_a_of_type_JavaLangString = "";
    parambisc.jdField_b_of_type_Int = 2;
    parambisc.jdField_a_of_type_Int = 11;
    bitj.a(this.a).add(parambisc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitp
 * JD-Core Version:    0.7.0.1
 */