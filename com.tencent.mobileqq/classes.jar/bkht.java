import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bkht
  implements View.OnClickListener
{
  bkht(bkhs parambkhs) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367128))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localbkhk = new bkhk((Activity)bkhs.a(this.a));
      localObject = new bkhq();
      localbkhq = new bkhq();
      if ((bkhs.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bkhs.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bkhs.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bkhq();
        ((bkhq)localObject).jdField_a_of_type_Int = ((bkfl)bkhs.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bkhq)localObject).b = ((bkfl)bkhs.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bkhq)localObject).c = ((bkfl)bkhs.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bkhq)localObject).jdField_a_of_type_JavaLangString = ((bkfl)bkhs.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbkhk.a((bkhq)localObject);
        i += 1;
        continue;
        ((bkhq)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bkhq)localObject).jdField_a_of_type_Int = 0;
        ((bkhq)localObject).jdField_a_of_type_JavaLangString = alud.a(2131717150);
        localbkhq.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbkhq.jdField_a_of_type_Int = 1;
        localbkhq.jdField_a_of_type_JavaLangString = alud.a(2131717151);
        localbkhq.c = "https://www.qq.com";
        localbkhk.a((bkhq)localObject);
        localbkhk.a(localbkhq);
      }
      localbkhk.e();
      localbkhk.a(new bkhu(this, localbkhk));
      localObject = new bkhj(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bkhi.a((Activity)bkhs.a(this.a), paramView, (bkhj)localObject, localbkhk);
    }
    while (bkhs.a(this.a) == null)
    {
      bkhk localbkhk;
      Object localObject;
      bkhq localbkhq;
      int i;
      return;
    }
    this.a.a(2, bkhs.a(this.a).jdField_a_of_type_JavaLangString, bkhs.a(this.a) + 1);
    this.a.a(new WeakReference((Activity)bkhs.a(this.a)), bkhs.b(this.a), this.a.a(bkhs.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkht
 * JD-Core Version:    0.7.0.1
 */