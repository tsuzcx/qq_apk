import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class bopg
  implements wrk
{
  bopg(bope parambope, String paramString) {}
  
  public void a(int paramInt, wrl paramwrl, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Bope.jdField_a_of_type_Wrl = paramwrl;
    if (paramInt == 0) {
      if (paramwrl.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bope.d.setVisibility(0);
      this.jdField_a_of_type_Bope.a(bool);
      if (this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Bope.jdField_a_of_type_Wrl.b()) {
        this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Bope.jdField_a_of_type_Bpsb != null)
      {
        this.jdField_a_of_type_Bope.jdField_a_of_type_Bpsb.a(this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Bope.jdField_a_of_type_Bpsb.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bope.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Bope.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bope.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      yqu.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopg
 * JD-Core Version:    0.7.0.1
 */