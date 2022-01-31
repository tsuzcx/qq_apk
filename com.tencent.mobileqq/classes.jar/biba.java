import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class biba
  implements AdapterView.OnItemClickListener
{
  biba(biaz parambiaz, biaq parambiaq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Biaq != null)
    {
      this.jdField_a_of_type_Biaq.dismiss();
      if ((this.jdField_a_of_type_Biaq.a != null) && (paramInt < this.jdField_a_of_type_Biaq.a.size()))
      {
        paramAdapterView = (biaw)this.jdField_a_of_type_Biaq.a.get(paramInt);
        if (paramAdapterView.a != 1) {
          break label130;
        }
        if ((!TextUtils.isEmpty(paramAdapterView.c)) && (biay.a(this.jdField_a_of_type_Biaz.a) != null))
        {
          paramView = new Intent(biay.a(this.jdField_a_of_type_Biaz.a), QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView.c);
          biay.a(this.jdField_a_of_type_Biaz.a).startActivity(paramView);
        }
      }
    }
    label130:
    do
    {
      do
      {
        return;
      } while (paramAdapterView.a != 2);
      if (biay.a(this.jdField_a_of_type_Biaz.a) != null)
      {
        if (!TextUtils.isEmpty(biay.a(this.jdField_a_of_type_Biaz.a).f))
        {
          paramAdapterView = biay.a(this.jdField_a_of_type_Biaz.a).f.replace("__ACT_TYPE__", "2001");
          this.jdField_a_of_type_Biaz.a.a(paramAdapterView);
        }
        if (biay.a(this.jdField_a_of_type_Biaz.a) != null) {
          this.jdField_a_of_type_Biaz.a.a(3, biay.a(this.jdField_a_of_type_Biaz.a).a, biay.a(this.jdField_a_of_type_Biaz.a) + 1);
        }
      }
    } while (this.jdField_a_of_type_Biaz.a.a == null);
    this.jdField_a_of_type_Biaz.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biba
 * JD-Core Version:    0.7.0.1
 */