import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class bkhu
  implements AdapterView.OnItemClickListener
{
  bkhu(bkht parambkht, bkhk parambkhk) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bkhk != null)
    {
      this.jdField_a_of_type_Bkhk.dismiss();
      if ((this.jdField_a_of_type_Bkhk.a != null) && (paramInt < this.jdField_a_of_type_Bkhk.a.size()))
      {
        paramAdapterView = (bkhq)this.jdField_a_of_type_Bkhk.a.get(paramInt);
        if (paramAdapterView.a != 1) {
          break label130;
        }
        if ((!TextUtils.isEmpty(paramAdapterView.c)) && (bkhs.a(this.jdField_a_of_type_Bkht.a) != null))
        {
          paramView = new Intent(bkhs.a(this.jdField_a_of_type_Bkht.a), QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView.c);
          bkhs.a(this.jdField_a_of_type_Bkht.a).startActivity(paramView);
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
      if (bkhs.a(this.jdField_a_of_type_Bkht.a) != null)
      {
        if (!TextUtils.isEmpty(bkhs.a(this.jdField_a_of_type_Bkht.a).f))
        {
          paramAdapterView = bkhs.a(this.jdField_a_of_type_Bkht.a).f.replace("__ACT_TYPE__", "2001");
          this.jdField_a_of_type_Bkht.a.a(paramAdapterView);
        }
        if (bkhs.a(this.jdField_a_of_type_Bkht.a) != null) {
          this.jdField_a_of_type_Bkht.a.a(3, bkhs.a(this.jdField_a_of_type_Bkht.a).a, bkhs.a(this.jdField_a_of_type_Bkht.a) + 1);
        }
      }
    } while (this.jdField_a_of_type_Bkht.a.a == null);
    this.jdField_a_of_type_Bkht.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhu
 * JD-Core Version:    0.7.0.1
 */