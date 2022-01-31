import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class blwc
  implements uxy
{
  blwc(blwa paramblwa, String paramString) {}
  
  public void a(int paramInt, uxz paramuxz, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Blwa.jdField_a_of_type_Uxz = paramuxz;
    if (paramInt == 0) {
      if (paramuxz.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Blwa.d.setVisibility(0);
      this.jdField_a_of_type_Blwa.a(bool);
      if (this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Blwa.jdField_a_of_type_Uxz.b()) {
        this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Blwa.jdField_a_of_type_Bnav != null)
      {
        this.jdField_a_of_type_Blwa.jdField_a_of_type_Bnav.a(this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Blwa.jdField_a_of_type_Bnav.notifyDataSetChanged();
        if (this.jdField_a_of_type_Blwa.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Blwa.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Blwa.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      wxj.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwc
 * JD-Core Version:    0.7.0.1
 */