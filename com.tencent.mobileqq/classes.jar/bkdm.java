import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bkdm
  implements View.OnClickListener
{
  bkdm(bkdl parambkdl) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367118))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localbkdd = new bkdd((Activity)bkdl.a(this.a));
      localObject = new bkdj();
      localbkdj = new bkdj();
      if ((bkdl.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bkdl.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bkdl.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bkdj();
        ((bkdj)localObject).jdField_a_of_type_Int = ((bkbe)bkdl.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bkdj)localObject).b = ((bkbe)bkdl.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bkdj)localObject).c = ((bkbe)bkdl.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bkdj)localObject).jdField_a_of_type_JavaLangString = ((bkbe)bkdl.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbkdd.a((bkdj)localObject);
        i += 1;
        continue;
        ((bkdj)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bkdj)localObject).jdField_a_of_type_Int = 0;
        ((bkdj)localObject).jdField_a_of_type_JavaLangString = alpo.a(2131717138);
        localbkdj.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbkdj.jdField_a_of_type_Int = 1;
        localbkdj.jdField_a_of_type_JavaLangString = alpo.a(2131717139);
        localbkdj.c = "https://www.qq.com";
        localbkdd.a((bkdj)localObject);
        localbkdd.a(localbkdj);
      }
      localbkdd.e();
      localbkdd.a(new bkdn(this, localbkdd));
      localObject = new bkdc(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bkdb.a((Activity)bkdl.a(this.a), paramView, (bkdc)localObject, localbkdd);
    }
    while (bkdl.a(this.a) == null)
    {
      bkdd localbkdd;
      Object localObject;
      bkdj localbkdj;
      int i;
      return;
    }
    this.a.a(2, bkdl.a(this.a).jdField_a_of_type_JavaLangString, bkdl.a(this.a) + 1);
    this.a.a(new WeakReference((Activity)bkdl.a(this.a)), bkdl.b(this.a), this.a.a(bkdl.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdm
 * JD-Core Version:    0.7.0.1
 */