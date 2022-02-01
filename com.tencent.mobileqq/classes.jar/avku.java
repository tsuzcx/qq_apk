import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class avku
  extends RecyclerView.OnScrollListener
{
  public avku(QQGamePubAccountFragment paramQQGamePubAccountFragment, LinearLayoutManager paramLinearLayoutManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {}
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        if ((this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition() < 1) || ((QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment) != null) && (QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment) != null) && (QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).getCurrentItem() < QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).size())))
        {
          paramInt = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
          QQGamePubAccountFragment.d(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).put(Long.valueOf(((MessageRecord)QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).get(QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).getCurrentItem())).uniseq), Integer.valueOf(paramInt));
        }
        if (QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment))
        {
          acik.a(anbd.a(), "769", "205029", "", "76902", "1", "160", new String[] { this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(), "", "20" });
          this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.b(true);
        }
        paramInt = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        while (paramInt <= i)
        {
          paramRecyclerView = QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(paramInt));
          if (((paramRecyclerView instanceof avjd)) && (QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).a(paramInt) != null) && (QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).a(paramInt).type != 3)) {
            ((avjd)paramRecyclerView).a.g();
          }
          paramInt += 1;
        }
      }
    }
  }
  
  @SuppressLint({"LongLogTag"})
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    QLog.d("QQGamePubAccountFragment", 1, "onScrolled y=" + paramInt2 + "the last:" + QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).getItemCount() + "," + this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition());
    paramInt1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastCompletelyVisibleItemPosition();
    if ((paramInt2 > 0) && (paramInt1 == QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).getItemCount() - 1)) {
      QQGamePubAccountFragment.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment, true);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition() == 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment)))
        {
          QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).a();
          avlb.b(4);
        }
      }
      while (!this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment.a(QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment)))
      {
        return;
        QQGamePubAccountFragment.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment, false);
        break;
      }
      QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment).b();
      return;
    }
    catch (Throwable paramRecyclerView)
    {
      paramRecyclerView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avku
 * JD-Core Version:    0.7.0.1
 */