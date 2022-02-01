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

class bldc
  implements AdapterView.OnItemClickListener
{
  bldc(bldb parambldb, blcs paramblcs) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Blcs != null)
    {
      this.jdField_a_of_type_Blcs.dismiss();
      if ((this.jdField_a_of_type_Blcs.a != null) && (paramInt < this.jdField_a_of_type_Blcs.a.size()))
      {
        localObject = (blcy)this.jdField_a_of_type_Blcs.a.get(paramInt);
        if (((blcy)localObject).a != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((blcy)localObject).c)) && (blda.a(this.jdField_a_of_type_Bldb.a) != null))
        {
          Intent localIntent = new Intent(blda.a(this.jdField_a_of_type_Bldb.a), QQBrowserActivity.class);
          localIntent.putExtra("url", ((blcy)localObject).c);
          blda.a(this.jdField_a_of_type_Bldb.a).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((blcy)localObject).a == 2)
      {
        if (blda.a(this.jdField_a_of_type_Bldb.a) != null)
        {
          if (!TextUtils.isEmpty(blda.a(this.jdField_a_of_type_Bldb.a).f))
          {
            localObject = blda.a(this.jdField_a_of_type_Bldb.a).f.replace("__ACT_TYPE__", "2001");
            this.jdField_a_of_type_Bldb.a.a((String)localObject);
          }
          if (blda.a(this.jdField_a_of_type_Bldb.a) != null) {
            this.jdField_a_of_type_Bldb.a.a(3, blda.a(this.jdField_a_of_type_Bldb.a).a, blda.a(this.jdField_a_of_type_Bldb.a) + 1);
          }
        }
        if (this.jdField_a_of_type_Bldb.a.a != null) {
          this.jdField_a_of_type_Bldb.a.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldc
 * JD-Core Version:    0.7.0.1
 */