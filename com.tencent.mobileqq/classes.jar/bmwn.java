import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bmwn
  implements View.OnClickListener
{
  bmwn(bmwm parambmwm) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367420))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      bmwe localbmwe = new bmwe((Activity)bmwm.a(this.a));
      Object localObject = new bmwk();
      bmwk localbmwk = new bmwk();
      int i;
      if ((bmwm.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bmwm.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bmwm.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bmwk();
        ((bmwk)localObject).jdField_a_of_type_Int = ((bmtz)bmwm.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bmwk)localObject).b = ((bmtz)bmwm.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bmwk)localObject).c = ((bmtz)bmwm.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bmwk)localObject).jdField_a_of_type_JavaLangString = ((bmtz)bmwm.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbmwe.a((bmwk)localObject);
        i += 1;
        continue;
        ((bmwk)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bmwk)localObject).jdField_a_of_type_Int = 0;
        ((bmwk)localObject).jdField_a_of_type_JavaLangString = anni.a(2131715427);
        localbmwk.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbmwk.jdField_a_of_type_Int = 1;
        localbmwk.jdField_a_of_type_JavaLangString = anni.a(2131715428);
        localbmwk.c = "https://www.qq.com";
        localbmwe.a((bmwk)localObject);
        localbmwe.a(localbmwk);
      }
      localbmwe.e();
      localbmwe.a(new bmwo(this, localbmwe));
      localObject = new bmwd(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bmwc.a((Activity)bmwm.a(this.a), paramView, (bmwd)localObject, localbmwe);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bmwm.a(this.a) != null)
      {
        this.a.a(2, bmwm.a(this.a).jdField_a_of_type_JavaLangString, bmwm.a(this.a) + 1);
        this.a.a(new WeakReference((Activity)bmwm.a(this.a)), bmwm.b(this.a), this.a.a(bmwm.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwn
 * JD-Core Version:    0.7.0.1
 */