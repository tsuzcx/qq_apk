import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bibq
  implements View.OnClickListener
{
  bibq(bibp parambibp) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131366991))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localbibh = new bibh((Activity)bibp.a(this.a));
      localObject = new bibn();
      localbibn = new bibn();
      if ((bibp.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bibp.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bibp.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bibn();
        ((bibn)localObject).jdField_a_of_type_Int = ((bhzi)bibp.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bibn)localObject).b = ((bhzi)bibp.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bibn)localObject).c = ((bhzi)bibp.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bibn)localObject).jdField_a_of_type_JavaLangString = ((bhzi)bibp.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbibh.a((bibn)localObject);
        i += 1;
        continue;
        ((bibn)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bibn)localObject).jdField_a_of_type_Int = 0;
        ((bibn)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131716766);
        localbibn.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbibn.jdField_a_of_type_Int = 1;
        localbibn.jdField_a_of_type_JavaLangString = ajya.a(2131716767);
        localbibn.c = "https://www.qq.com";
        localbibh.a((bibn)localObject);
        localbibh.a(localbibn);
      }
      localbibh.e();
      localbibh.a(new bibr(this, localbibh));
      localObject = new bibg(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bibf.a((Activity)bibp.a(this.a), paramView, (bibg)localObject, localbibh);
    }
    while (bibp.a(this.a) == null)
    {
      bibh localbibh;
      Object localObject;
      bibn localbibn;
      int i;
      return;
    }
    this.a.a(2, bibp.a(this.a).jdField_a_of_type_JavaLangString, bibp.a(this.a) + 1);
    this.a.a(new WeakReference((Activity)bibp.a(this.a)), bibp.b(this.a), this.a.a(bibp.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibq
 * JD-Core Version:    0.7.0.1
 */