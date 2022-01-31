import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class bjgf
  implements tex
{
  bjgf(bjgd parambjgd, String paramString) {}
  
  public void a(int paramInt, tey paramtey, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Bjgd.jdField_a_of_type_Tey = paramtey;
    if (paramInt == 0) {
      if (paramtey.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bjgd.d.setVisibility(0);
      this.jdField_a_of_type_Bjgd.a(bool);
      if (this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Bjgd.jdField_a_of_type_Tey.b()) {
        this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Bjgd.jdField_a_of_type_Bkkz != null)
      {
        this.jdField_a_of_type_Bjgd.jdField_a_of_type_Bkkz.a(this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Bjgd.jdField_a_of_type_Bkkz.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bjgd.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Bjgd.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bjgd.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      vei.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgf
 * JD-Core Version:    0.7.0.1
 */