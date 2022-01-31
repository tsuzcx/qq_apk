import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class blrq
  implements utp
{
  blrq(blro paramblro, String paramString) {}
  
  public void a(int paramInt, utq paramutq, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Blro.jdField_a_of_type_Utq = paramutq;
    if (paramInt == 0) {
      if (paramutq.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Blro.d.setVisibility(0);
      this.jdField_a_of_type_Blro.a(bool);
      if (this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Blro.jdField_a_of_type_Utq.b()) {
        this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Blro.jdField_a_of_type_Bmwj != null)
      {
        this.jdField_a_of_type_Blro.jdField_a_of_type_Bmwj.a(this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Blro.jdField_a_of_type_Bmwj.notifyDataSetChanged();
        if (this.jdField_a_of_type_Blro.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Blro.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Blro.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      wta.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrq
 * JD-Core Version:    0.7.0.1
 */