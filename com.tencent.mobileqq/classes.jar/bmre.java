import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.List;
import mqq.util.WeakReference;

public class bmre
  implements View.OnClickListener
{
  final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  final List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  final WeakReference<ReaderTabBarView> jdField_a_of_type_MqqUtilWeakReference;
  
  public bmre(ReaderTabBarView paramReaderTabBarView, int paramInt, @NonNull List<WebViewTabBarData> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReaderTabBarView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void onClick(View paramView)
  {
    ReaderTabBarView localReaderTabBarView = (ReaderTabBarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localReaderTabBarView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Int != ReaderTabBarView.a(localReaderTabBarView))
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long >= 500L)
        {
          this.jdField_a_of_type_Long = l;
          localReaderTabBarView.setSelectedTab(this.jdField_a_of_type_Int);
          int i = ReaderTabBarView.a(localReaderTabBarView)[this.jdField_a_of_type_Int];
          localReaderTabBarView.setCurrentItemId(i);
          localReaderTabBarView.a();
          ReaderTabBarView.a(localReaderTabBarView, i);
          String str1 = localReaderTabBarView.b();
          String str2 = localReaderTabBarView.a();
          switch (i)
          {
          default: 
            break;
          case 0: 
            bmqz.a(str1, str2, "297", "0", "3", "", "");
            if (localReaderTabBarView.a(i)) {
              bmqz.a(str1, str2, "69", "336", "0", "3", "", "", "");
            }
            break;
          case 1: 
            bmqz.a(str1, str2, "298", "0", "3", "", "");
            break;
          case 3: 
            if (bmqu.f(localReaderTabBarView.getContext())) {
              bmqu.f(localReaderTabBarView.getContext(), false);
            }
            bmqz.a(str1, str2, "300", "0", "3", "", "");
            break;
          case 2: 
            bmqz.a(str1, str2, "1847", "0", "3", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmre
 * JD-Core Version:    0.7.0.1
 */