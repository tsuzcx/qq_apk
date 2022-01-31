import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class bgsb
  implements AdapterView.OnItemClickListener
{
  bgsb(bgsa parambgsa, bgrr parambgrr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bgrr != null)
    {
      this.jdField_a_of_type_Bgrr.dismiss();
      if ((this.jdField_a_of_type_Bgrr.a != null) && (paramInt < this.jdField_a_of_type_Bgrr.a.size()))
      {
        paramAdapterView = (bgrx)this.jdField_a_of_type_Bgrr.a.get(paramInt);
        if (paramAdapterView.a != 1) {
          break label130;
        }
        if ((!TextUtils.isEmpty(paramAdapterView.c)) && (bgrz.a(this.jdField_a_of_type_Bgsa.a) != null))
        {
          paramView = new Intent(bgrz.a(this.jdField_a_of_type_Bgsa.a), QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView.c);
          bgrz.a(this.jdField_a_of_type_Bgsa.a).startActivity(paramView);
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
      if (bgrz.a(this.jdField_a_of_type_Bgsa.a) != null)
      {
        if (!TextUtils.isEmpty(bgrz.a(this.jdField_a_of_type_Bgsa.a).f))
        {
          paramAdapterView = bgrz.a(this.jdField_a_of_type_Bgsa.a).f.replace("__ACT_TYPE__", "2001");
          this.jdField_a_of_type_Bgsa.a.a(paramAdapterView);
        }
        if (bgrz.a(this.jdField_a_of_type_Bgsa.a) != null) {
          this.jdField_a_of_type_Bgsa.a.a(3, bgrz.a(this.jdField_a_of_type_Bgsa.a).a, bgrz.a(this.jdField_a_of_type_Bgsa.a) + 1);
        }
      }
    } while (this.jdField_a_of_type_Bgsa.a.a == null);
    this.jdField_a_of_type_Bgsa.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsb
 * JD-Core Version:    0.7.0.1
 */