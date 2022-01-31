import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class bkdn
  implements AdapterView.OnItemClickListener
{
  bkdn(bkdm parambkdm, bkdd parambkdd) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bkdd != null)
    {
      this.jdField_a_of_type_Bkdd.dismiss();
      if ((this.jdField_a_of_type_Bkdd.a != null) && (paramInt < this.jdField_a_of_type_Bkdd.a.size()))
      {
        paramAdapterView = (bkdj)this.jdField_a_of_type_Bkdd.a.get(paramInt);
        if (paramAdapterView.a != 1) {
          break label130;
        }
        if ((!TextUtils.isEmpty(paramAdapterView.c)) && (bkdl.a(this.jdField_a_of_type_Bkdm.a) != null))
        {
          paramView = new Intent(bkdl.a(this.jdField_a_of_type_Bkdm.a), QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView.c);
          bkdl.a(this.jdField_a_of_type_Bkdm.a).startActivity(paramView);
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
      if (bkdl.a(this.jdField_a_of_type_Bkdm.a) != null)
      {
        if (!TextUtils.isEmpty(bkdl.a(this.jdField_a_of_type_Bkdm.a).f))
        {
          paramAdapterView = bkdl.a(this.jdField_a_of_type_Bkdm.a).f.replace("__ACT_TYPE__", "2001");
          this.jdField_a_of_type_Bkdm.a.a(paramAdapterView);
        }
        if (bkdl.a(this.jdField_a_of_type_Bkdm.a) != null) {
          this.jdField_a_of_type_Bkdm.a.a(3, bkdl.a(this.jdField_a_of_type_Bkdm.a).a, bkdl.a(this.jdField_a_of_type_Bkdm.a) + 1);
        }
      }
    } while (this.jdField_a_of_type_Bkdm.a.a == null);
    this.jdField_a_of_type_Bkdm.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdn
 * JD-Core Version:    0.7.0.1
 */