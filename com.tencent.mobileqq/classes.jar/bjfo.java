import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class bjfo
  implements tfa
{
  bjfo(bjfm parambjfm, String paramString) {}
  
  public void a(int paramInt, tfb paramtfb, List<TroopBarPOI> paramList)
  {
    this.jdField_a_of_type_Bjfm.jdField_a_of_type_Tfb = paramtfb;
    if (paramInt == 0) {
      if (paramtfb.a()) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bjfm.d.setVisibility(0);
      this.jdField_a_of_type_Bjfm.a(bool);
      if (this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Bjfm.jdField_a_of_type_Tfb.b()) {
        this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_Bjfm.jdField_a_of_type_Bkki != null)
      {
        this.jdField_a_of_type_Bjfm.jdField_a_of_type_Bkki.a(this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_Bjfm.jdField_a_of_type_Bkki.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bjfm.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_Bjfm.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bjfm.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      vel.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfo
 * JD-Core Version:    0.7.0.1
 */