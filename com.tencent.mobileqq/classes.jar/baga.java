import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class baga
  implements View.OnClickListener
{
  baga(bafx parambafx) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ProfileCircleComponent", 4, "qqCircleWriteEntrance onClick");
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    localQCircleFolderBean.setPublish(true);
    localQCircleFolderBean.setLaunchFrom("5");
    uyx.a(bafx.a(this.a), localQCircleFolderBean);
    vtq.a("", 3, 2, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baga
 * JD-Core Version:    0.7.0.1
 */