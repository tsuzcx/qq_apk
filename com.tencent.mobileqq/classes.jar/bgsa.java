import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bgsa
  implements View.OnClickListener
{
  bgsa(bgrz parambgrz) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131301382))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      localbgrr = new bgrr((Activity)bgrz.a(this.a));
      localObject = new bgrx();
      localbgrx = new bgrx();
      if ((bgrz.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bgrz.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bgrz.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bgrx();
        ((bgrx)localObject).jdField_a_of_type_Int = ((bgpu)bgrz.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bgrx)localObject).b = ((bgpu)bgrz.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bgrx)localObject).c = ((bgpu)bgrz.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bgrx)localObject).jdField_a_of_type_JavaLangString = ((bgpu)bgrz.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbgrr.a((bgrx)localObject);
        i += 1;
        continue;
        ((bgrx)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bgrx)localObject).jdField_a_of_type_Int = 0;
        ((bgrx)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131650964);
        localbgrx.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbgrx.jdField_a_of_type_Int = 1;
        localbgrx.jdField_a_of_type_JavaLangString = ajjy.a(2131650965);
        localbgrx.c = "https://www.qq.com";
        localbgrr.a((bgrx)localObject);
        localbgrr.a(localbgrx);
      }
      localbgrr.e();
      localbgrr.a(new bgsb(this, localbgrr));
      localObject = new bgrq(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bgrp.a((Activity)bgrz.a(this.a), paramView, (bgrq)localObject, localbgrr);
    }
    while (bgrz.a(this.a) == null)
    {
      bgrr localbgrr;
      Object localObject;
      bgrx localbgrx;
      int i;
      return;
    }
    this.a.a(2, bgrz.a(this.a).jdField_a_of_type_JavaLangString, bgrz.a(this.a) + 1);
    this.a.a(new WeakReference((Activity)bgrz.a(this.a)), bgrz.b(this.a), this.a.a(bgrz.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsa
 * JD-Core Version:    0.7.0.1
 */