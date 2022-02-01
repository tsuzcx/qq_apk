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

class bmwo
  implements AdapterView.OnItemClickListener
{
  bmwo(bmwn parambmwn, bmwe parambmwe) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bmwe != null)
    {
      this.jdField_a_of_type_Bmwe.dismiss();
      if ((this.jdField_a_of_type_Bmwe.a != null) && (paramInt < this.jdField_a_of_type_Bmwe.a.size()))
      {
        localObject = (bmwk)this.jdField_a_of_type_Bmwe.a.get(paramInt);
        if (((bmwk)localObject).a != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((bmwk)localObject).c)) && (bmwm.a(this.jdField_a_of_type_Bmwn.a) != null))
        {
          Intent localIntent = new Intent(bmwm.a(this.jdField_a_of_type_Bmwn.a), QQBrowserActivity.class);
          localIntent.putExtra("url", ((bmwk)localObject).c);
          bmwm.a(this.jdField_a_of_type_Bmwn.a).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((bmwk)localObject).a == 2)
      {
        if (bmwm.a(this.jdField_a_of_type_Bmwn.a) != null)
        {
          if (!TextUtils.isEmpty(bmwm.a(this.jdField_a_of_type_Bmwn.a).f))
          {
            localObject = bmwm.a(this.jdField_a_of_type_Bmwn.a).f.replace("__ACT_TYPE__", "2001");
            this.jdField_a_of_type_Bmwn.a.a((String)localObject);
          }
          if (bmwm.a(this.jdField_a_of_type_Bmwn.a) != null) {
            this.jdField_a_of_type_Bmwn.a.a(3, bmwm.a(this.jdField_a_of_type_Bmwn.a).a, bmwm.a(this.jdField_a_of_type_Bmwn.a) + 1);
          }
        }
        if (this.jdField_a_of_type_Bmwn.a.a != null) {
          this.jdField_a_of_type_Bmwn.a.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwo
 * JD-Core Version:    0.7.0.1
 */