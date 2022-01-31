import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class bkyz
  implements bmac<bkxm>
{
  bkyz(bkyt parambkyt) {}
  
  public void a(@Nullable bkxm parambkxm)
  {
    int i = 0;
    bkyt.a(this.a).a().a(bkyt.a(this.a));
    if (parambkxm != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + parambkxm });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + parambkxm.jdField_a_of_type_JavaLangString + "text ===" + parambkxm.jdField_a_of_type_Int + "material ====" + parambkxm.jdField_b_of_type_Int);
      if (parambkxm.jdField_a_of_type_JavaLangString == null)
      {
        parambkxm.jdField_a_of_type_Int = 0;
        parambkxm.jdField_b_of_type_Int = 6;
        parambkxm.jdField_a_of_type_JavaLangString = "default";
      }
      if ((parambkxm.jdField_a_of_type_JavaUtilList != null) && (parambkxm.jdField_a_of_type_JavaUtilList.size() == 0)) {
        parambkxm.jdField_a_of_type_JavaUtilList.addAll(bkxy.jdField_a_of_type_JavaUtilList);
      }
      Object localObject;
      if (parambkxm.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject = alpo.a(2131700345);
        bkyt.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < parambkxm.jdField_a_of_type_Int)
        {
          localObject = new bkxt();
          ((bkxt)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
          ((bkxt)localObject).jdField_a_of_type_JavaLangString = ((String)parambkxm.jdField_a_of_type_JavaUtilList.get(i % parambkxm.jdField_a_of_type_JavaUtilList.size()));
          ((bkxt)localObject).jdField_b_of_type_Int = 2;
          if (bkyt.a(this.a).size() < bkyt.a(this.a)) {}
        }
        else
        {
          bkyt.a(this.a).a(bkyt.a(this.a), parambkxm.jdField_a_of_type_JavaLangString);
          bkyt.a(this.a).b().a(bkyt.a(this.a), new bkza(this, parambkxm));
          bkyt.a(this.a).a().a(bkyt.a(this.a), new bkzb(this, parambkxm));
          return;
          localObject = (String)bkyt.a(this.a).get(parambkxm.jdField_a_of_type_JavaLangString);
          localObject = alpo.a(2131700340) + (String)localObject + alpo.a(2131700347);
          break;
        }
        bkyt.a(this.a).add(localObject);
        bkyt.a(this.a).notifyItemInserted(bkyt.a(this.a).size() - 1);
        blak localblak = new blak();
        localblak.jdField_b_of_type_JavaLangString = ((bkxt)localObject).jdField_a_of_type_JavaLangString;
        localblak.jdField_a_of_type_Int = (i + 1);
        bkyt.a(this.a).a(localblak);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    parambkxm = new bkxt();
    parambkxm.jdField_b_of_type_JavaLangString = "";
    parambkxm.jdField_a_of_type_JavaLangString = "";
    parambkxm.jdField_b_of_type_Int = 2;
    parambkxm.jdField_a_of_type_Int = 11;
    bkyt.a(this.a).add(parambkxm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyz
 * JD-Core Version:    0.7.0.1
 */