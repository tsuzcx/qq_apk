import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.lang.ref.WeakReference;
import java.util.List;

class bmps
  implements View.OnClickListener
{
  bmps(bmpr parambmpr) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367643))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      bmpj localbmpj = new bmpj((Activity)bmpr.a(this.a));
      Object localObject = new bmpp();
      bmpp localbmpp = new bmpp();
      int i;
      if ((bmpr.a(this.a).jdField_a_of_type_JavaUtilList != null) && (bmpr.a(this.a).jdField_a_of_type_JavaUtilList.size() != 0)) {
        i = 0;
      }
      while (i < bmpr.a(this.a).jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new bmpp();
        ((bmpp)localObject).jdField_a_of_type_Int = ((bmmx)bmpr.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
        ((bmpp)localObject).b = ((bmmx)bmpr.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        ((bmpp)localObject).c = ((bmmx)bmpr.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).c;
        ((bmpp)localObject).jdField_a_of_type_JavaLangString = ((bmmx)bmpr.a(this.a).jdField_a_of_type_JavaUtilList.get(i)).b;
        localbmpj.a((bmpp)localObject);
        i += 1;
        continue;
        ((bmpp)localObject).b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((bmpp)localObject).jdField_a_of_type_Int = 0;
        ((bmpp)localObject).jdField_a_of_type_JavaLangString = anvx.a(2131716118);
        localbmpp.b = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localbmpp.jdField_a_of_type_Int = 1;
        localbmpp.jdField_a_of_type_JavaLangString = anvx.a(2131716119);
        localbmpp.c = "https://www.qq.com";
        localbmpj.a((bmpp)localObject);
        localbmpj.a(localbmpp);
      }
      localbmpj.e();
      localbmpj.a(new bmpt(this, localbmpj));
      localObject = new bmpi(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      bmph.a((Activity)bmpr.a(this.a), paramView, (bmpi)localObject, localbmpj);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bmpr.a(this.a) != null)
      {
        this.a.a(2, bmpr.a(this.a).jdField_a_of_type_JavaLangString, bmpr.a(this.a) + 1);
        this.a.a(new WeakReference((Activity)bmpr.a(this.a)), bmpr.b(this.a), this.a.a(bmpr.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmps
 * JD-Core Version:    0.7.0.1
 */