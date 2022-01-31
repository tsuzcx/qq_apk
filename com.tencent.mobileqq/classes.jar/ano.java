import com.qq.im.poi.LbsPackPoiListActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;

class ano
  implements Runnable
{
  ano(ann paramann) {}
  
  public void run()
  {
    PullRefreshHeader localPullRefreshHeader;
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      LbsPackPoiListActivity.a(this.a.a, 800L);
      localPullRefreshHeader = this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        break label54;
      }
    }
    label54:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ano
 * JD-Core Version:    0.7.0.1
 */