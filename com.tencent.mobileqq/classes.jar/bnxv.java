import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bnxv
  implements View.OnClickListener
{
  bnxv(bnxu parambnxu) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367482))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      bnxm localbnxm = new bnxm((Activity)bnxu.a(this.a));
      Object localObject = new bnxs();
      bnxs localbnxs = new bnxs();
      int i;
      if ((bnxu.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bnxu.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bnxu.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bnxs();
        ((bnxs)localObject).jdField_a_of_type_Int = ((bnvh)bnxu.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bnxs)localObject).b = ((bnvh)bnxu.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bnxs)localObject).c = ((bnvh)bnxu.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bnxs)localObject).jdField_a_of_type_JavaLangString = ((bnvh)bnxu.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbnxm.a((bnxs)localObject);
        i += 1;
        continue;
        ((bnxs)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bnxs)localObject).jdField_a_of_type_Int = 0;
        ((bnxs)localObject).jdField_a_of_type_JavaLangString = anzj.a(2131715536);
        localbnxs.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbnxs.jdField_a_of_type_Int = 1;
        localbnxs.jdField_a_of_type_JavaLangString = anzj.a(2131715537);
        localbnxs.c = "https://www.qq.com";
        localbnxm.a((bnxs)localObject);
        localbnxm.a(localbnxs);
      }
      localbnxm.e();
      localbnxm.a(new bnxw(this, localbnxm));
      localObject = new bnxl(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bnxk.a((Activity)bnxu.a(this.a), paramView, (bnxl)localObject, localbnxm);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bnxu.a(this.a) != null)
      {
        this.a.a(2, bnxu.a(this.a).jdField_a_of_type_JavaLangString, bnxu.a(this.a) + 1);
        this.a.a(new WeakReference((Activity)bnxu.a(this.a)), bnxu.b(this.a), this.a.a(bnxu.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxv
 * JD-Core Version:    0.7.0.1
 */