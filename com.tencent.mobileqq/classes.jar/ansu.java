import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.AbsListView;

class ansu
  implements blih
{
  ansu(anst paramanst) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramInt = paramAbsListView.getFirstVisiblePosition();
      if (paramInt > anst.a(this.a)) {
        paramInt = 0;
      }
      break;
    }
    while ((paramInt >= 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "slideupdown", "", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), this.a.d, new String[] { String.valueOf(paramInt) });
      return;
      if (anst.a(this.a) > paramInt)
      {
        paramInt = 1;
        continue;
        anst.a(this.a, paramAbsListView.getFirstVisiblePosition());
      }
      else
      {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */