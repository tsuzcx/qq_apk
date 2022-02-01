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

class bmpt
  implements AdapterView.OnItemClickListener
{
  bmpt(bmps parambmps, bmpj parambmpj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Bmpj != null)
    {
      this.jdField_a_of_type_Bmpj.dismiss();
      if ((this.jdField_a_of_type_Bmpj.a != null) && (paramInt < this.jdField_a_of_type_Bmpj.a.size()))
      {
        localObject = (bmpp)this.jdField_a_of_type_Bmpj.a.get(paramInt);
        if (((bmpp)localObject).a != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((bmpp)localObject).c)) && (bmpr.a(this.jdField_a_of_type_Bmps.a) != null))
        {
          Intent localIntent = new Intent(bmpr.a(this.jdField_a_of_type_Bmps.a), QQBrowserActivity.class);
          localIntent.putExtra("url", ((bmpp)localObject).c);
          bmpr.a(this.jdField_a_of_type_Bmps.a).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((bmpp)localObject).a == 2)
      {
        if (bmpr.a(this.jdField_a_of_type_Bmps.a) != null)
        {
          if (!TextUtils.isEmpty(bmpr.a(this.jdField_a_of_type_Bmps.a).f))
          {
            localObject = bmpr.a(this.jdField_a_of_type_Bmps.a).f.replace("__ACT_TYPE__", "2001");
            this.jdField_a_of_type_Bmps.a.a((String)localObject);
          }
          if (bmpr.a(this.jdField_a_of_type_Bmps.a) != null) {
            this.jdField_a_of_type_Bmps.a.a(3, bmpr.a(this.jdField_a_of_type_Bmps.a).a, bmpr.a(this.jdField_a_of_type_Bmps.a) + 1);
          }
        }
        if (this.jdField_a_of_type_Bmps.a.a != null) {
          this.jdField_a_of_type_Bmps.a.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpt
 * JD-Core Version:    0.7.0.1
 */