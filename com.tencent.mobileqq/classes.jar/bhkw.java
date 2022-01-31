import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class bhkw
  implements sse
{
  bhkw(bhku parambhku, String paramString) {}
  
  public void a(int paramInt, ssf paramssf, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Bhku.jdField_a_of_type_Ssf = paramssf;
    if (paramInt == 0) {
      if (paramssf.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bhku.d.setVisibility(0);
      this.jdField_a_of_type_Bhku.a(bool);
      if (this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Bhku.jdField_a_of_type_Ssf.b()) {
        this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Bhku.jdField_a_of_type_Bitv != null)
      {
        this.jdField_a_of_type_Bhku.jdField_a_of_type_Bitv.a(this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Bhku.jdField_a_of_type_Bitv.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Bhku.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bhku.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      urp.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhkw
 * JD-Core Version:    0.7.0.1
 */