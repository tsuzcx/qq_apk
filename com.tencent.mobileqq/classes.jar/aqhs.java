import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.BubblePopupWindow;

public class aqhs
  implements bera
{
  public aqhs(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Aqxt.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      paramView.setPressed(false);
    }
    do
    {
      return;
      paramSlideDetectListView = paramView.findViewById(2131376497);
      paramView = (FileInfo)this.a.jdField_a_of_type_Aqxt.getItem(paramInt);
      this.a.jdField_a_of_type_Aqxt.a(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131365058);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ShaderAnimLayout)paramSlideDetectListView).a();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131376497);
    this.a.jdField_a_of_type_Aqxt.a(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365058);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhs
 * JD-Core Version:    0.7.0.1
 */