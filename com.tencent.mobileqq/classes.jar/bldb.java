import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bldb
  implements View.OnClickListener
{
  bldb(blda paramblda) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367511))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      blcs localblcs = new blcs((Activity)blda.a(this.a));
      Object localObject = new blcy();
      blcy localblcy = new blcy();
      int i;
      if ((blda.a(this.a).jdField_a_of_type_JavaUtilList != null) && (blda.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < blda.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new blcy();
        ((blcy)localObject).jdField_a_of_type_Int = ((blam)blda.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((blcy)localObject).b = ((blam)blda.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((blcy)localObject).c = ((blam)blda.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((blcy)localObject).jdField_a_of_type_JavaLangString = ((blam)blda.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localblcs.a((blcy)localObject);
        i += 1;
        continue;
        ((blcy)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((blcy)localObject).jdField_a_of_type_Int = 0;
        ((blcy)localObject).jdField_a_of_type_JavaLangString = amtj.a(2131715770);
        localblcy.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localblcy.jdField_a_of_type_Int = 1;
        localblcy.jdField_a_of_type_JavaLangString = amtj.a(2131715771);
        localblcy.c = "https://www.qq.com";
        localblcs.a((blcy)localObject);
        localblcs.a(localblcy);
      }
      localblcs.e();
      localblcs.a(new bldc(this, localblcs));
      localObject = new blcr(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      blcq.a((Activity)blda.a(this.a), paramView, (blcr)localObject, localblcs);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (blda.a(this.a) != null)
      {
        this.a.a(2, blda.a(this.a).jdField_a_of_type_JavaLangString, blda.a(this.a) + 1);
        this.a.a(new WeakReference((Activity)blda.a(this.a)), blda.b(this.a), this.a.a(blda.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldb
 * JD-Core Version:    0.7.0.1
 */