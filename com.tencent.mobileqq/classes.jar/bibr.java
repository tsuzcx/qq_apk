import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class bibr
  implements AdapterView.OnItemClickListener
{
  bibr(bibq parambibq, bibh parambibh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bibh != null)
    {
      this.jdField_a_of_type_Bibh.dismiss();
      if ((this.jdField_a_of_type_Bibh.a != null) && (paramInt < this.jdField_a_of_type_Bibh.a.size()))
      {
        paramAdapterView = (bibn)this.jdField_a_of_type_Bibh.a.get(paramInt);
        if (paramAdapterView.a != 1) {
          break label130;
        }
        if ((!TextUtils.isEmpty(paramAdapterView.c)) && (bibp.a(this.jdField_a_of_type_Bibq.a) != null))
        {
          paramView = new Intent(bibp.a(this.jdField_a_of_type_Bibq.a), QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView.c);
          bibp.a(this.jdField_a_of_type_Bibq.a).startActivity(paramView);
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
      if (bibp.a(this.jdField_a_of_type_Bibq.a) != null)
      {
        if (!TextUtils.isEmpty(bibp.a(this.jdField_a_of_type_Bibq.a).f))
        {
          paramAdapterView = bibp.a(this.jdField_a_of_type_Bibq.a).f.replace("__ACT_TYPE__", "2001");
          this.jdField_a_of_type_Bibq.a.a(paramAdapterView);
        }
        if (bibp.a(this.jdField_a_of_type_Bibq.a) != null) {
          this.jdField_a_of_type_Bibq.a.a(3, bibp.a(this.jdField_a_of_type_Bibq.a).a, bibp.a(this.jdField_a_of_type_Bibq.a) + 1);
        }
      }
    } while (this.jdField_a_of_type_Bibq.a.a == null);
    this.jdField_a_of_type_Bibq.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibr
 * JD-Core Version:    0.7.0.1
 */