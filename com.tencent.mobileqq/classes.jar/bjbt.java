import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.List;
import mqq.util.WeakReference;

public class bjbt
  implements View.OnClickListener
{
  final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  final List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  final WeakReference<ReaderTabBarView> jdField_a_of_type_MqqUtilWeakReference;
  
  public bjbt(ReaderTabBarView paramReaderTabBarView, int paramInt, @NonNull List<WebViewTabBarData> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReaderTabBarView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ReaderTabBarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramView == null) {
      break label15;
    }
    label15:
    int i;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int == ReaderTabBarView.a(paramView));
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 500L) {
        break;
      }
      this.jdField_a_of_type_Long = l;
      paramView.setSelectedTab(this.jdField_a_of_type_Int);
      i = ReaderTabBarView.a(paramView)[this.jdField_a_of_type_Int];
      paramView.setCurrentItemId(i);
      paramView.a();
      ReaderTabBarView.a(paramView, i);
      str1 = paramView.b();
      str2 = paramView.a();
      switch (i)
      {
      default: 
        return;
      case 0: 
        bjbo.a(str1, str2, "297", "0", "3", "", "");
      }
    } while (!paramView.a(i));
    bjbo.a(str1, str2, "69", "336", "0", "3", "", "", "");
    return;
    bjbo.a(str1, str2, "298", "0", "3", "", "");
    return;
    if (bjbj.f(paramView.getContext())) {
      bjbj.f(paramView.getContext(), false);
    }
    bjbo.a(str1, str2, "300", "0", "3", "", "");
    return;
    bjbo.a(str1, str2, "1847", "0", "3", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbt
 * JD-Core Version:    0.7.0.1
 */