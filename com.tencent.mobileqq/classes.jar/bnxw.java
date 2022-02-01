import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class bnxw
  implements AdapterView.OnItemClickListener
{
  bnxw(bnxv parambnxv, bnxm parambnxm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bnxm != null)
    {
      this.jdField_a_of_type_Bnxm.dismiss();
      if ((this.jdField_a_of_type_Bnxm.a != null) && (paramInt < this.jdField_a_of_type_Bnxm.a.size()))
      {
        localObject = (bnxs)this.jdField_a_of_type_Bnxm.a.get(paramInt);
        if (((bnxs)localObject).a != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((bnxs)localObject).c)) && (bnxu.a(this.jdField_a_of_type_Bnxv.a) != null))
        {
          Intent localIntent = new Intent(bnxu.a(this.jdField_a_of_type_Bnxv.a), QQBrowserActivity.class);
          localIntent.putExtra("url", ((bnxs)localObject).c);
          bnxu.a(this.jdField_a_of_type_Bnxv.a).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((bnxs)localObject).a == 2)
      {
        if (bnxu.a(this.jdField_a_of_type_Bnxv.a) != null)
        {
          if (!TextUtils.isEmpty(bnxu.a(this.jdField_a_of_type_Bnxv.a).f))
          {
            localObject = bnxu.a(this.jdField_a_of_type_Bnxv.a).f.replace("__ACT_TYPE__", "2001");
            this.jdField_a_of_type_Bnxv.a.a((String)localObject);
          }
          if (bnxu.a(this.jdField_a_of_type_Bnxv.a) != null) {
            this.jdField_a_of_type_Bnxv.a.a(3, bnxu.a(this.jdField_a_of_type_Bnxv.a).a, bnxu.a(this.jdField_a_of_type_Bnxv.a) + 1);
          }
        }
        if (this.jdField_a_of_type_Bnxv.a.a != null) {
          this.jdField_a_of_type_Bnxv.a.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxw
 * JD-Core Version:    0.7.0.1
 */