import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class bprb
  implements wvf
{
  bprb(bpqz parambpqz, String paramString) {}
  
  public void a(int paramInt, wvg paramwvg, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Bpqz.jdField_a_of_type_Wvg = paramwvg;
    if (paramInt == 0) {
      if (paramwvg.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bpqz.d.setVisibility(0);
      this.jdField_a_of_type_Bpqz.a(bool);
      if (this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Bpqz.jdField_a_of_type_Wvg.b()) {
        this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Bpqz.jdField_a_of_type_Bqtw != null)
      {
        this.jdField_a_of_type_Bpqz.jdField_a_of_type_Bqtw.a(this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Bpqz.jdField_a_of_type_Bqtw.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bpqz.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Bpqz.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bpqz.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      yup.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprb
 * JD-Core Version:    0.7.0.1
 */