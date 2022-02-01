import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class axef
  extends axfg
{
  public axef(MultiAIOItemFragment paramMultiAIOItemFragment, AbsListView.OnScrollListener paramOnScrollListener, ListView paramListView) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      paramInt = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(this.jdField_a_of_type_ComTencentWidgetListView, paramInt);
      if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof ChatXListView))
      {
        ChatXListView localChatXListView = (ChatXListView)this.jdField_a_of_type_ComTencentWidgetListView;
        int[] arrayOfInt = MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment);
        localChatXListView.setDisableLayout(bool, arrayOfInt[0], arrayOfInt[1]);
      }
      return;
      bool = false;
      paramInt = 1;
      continue;
      paramInt = 2;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axef
 * JD-Core Version:    0.7.0.1
 */