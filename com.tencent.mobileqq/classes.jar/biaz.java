import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class biaz
  implements View.OnClickListener
{
  biaz(biay parambiay) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131366991))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localbiaq = new biaq((Activity)biay.a(this.a));
      localObject = new biaw();
      localbiaw = new biaw();
      if ((biay.a(this.a).jdField_a_of_type_JavaUtilList != null) && (biay.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < biay.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new biaw();
        ((biaw)localObject).jdField_a_of_type_Int = ((bhyr)biay.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((biaw)localObject).b = ((bhyr)biay.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((biaw)localObject).c = ((bhyr)biay.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((biaw)localObject).jdField_a_of_type_JavaLangString = ((bhyr)biay.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbiaq.a((biaw)localObject);
        i += 1;
        continue;
        ((biaw)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((biaw)localObject).jdField_a_of_type_Int = 0;
        ((biaw)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131716755);
        localbiaw.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbiaw.jdField_a_of_type_Int = 1;
        localbiaw.jdField_a_of_type_JavaLangString = ajyc.a(2131716756);
        localbiaw.c = "https://www.qq.com";
        localbiaq.a((biaw)localObject);
        localbiaq.a(localbiaw);
      }
      localbiaq.e();
      localbiaq.a(new biba(this, localbiaq));
      localObject = new biap(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      biao.a((Activity)biay.a(this.a), paramView, (biap)localObject, localbiaq);
    }
    while (biay.a(this.a) == null)
    {
      biaq localbiaq;
      Object localObject;
      biaw localbiaw;
      int i;
      return;
    }
    this.a.a(2, biay.a(this.a).jdField_a_of_type_JavaLangString, biay.a(this.a) + 1);
    this.a.a(new WeakReference((Activity)biay.a(this.a)), biay.b(this.a), this.a.a(biay.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biaz
 * JD-Core Version:    0.7.0.1
 */