import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;

public class asyu
  implements SlideDetectListView.OnSlideListener
{
  public asyu(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onSlideCancelled(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131377517);
    this.a.jdField_a_of_type_Atpx.a(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365464);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.a);
  }
  
  public void onSlideStarted(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Atpx.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.resetSlideStatus();
      paramView.setPressed(false);
    }
    do
    {
      return;
      paramSlideDetectListView = paramView.findViewById(2131377517);
      paramView = (FileInfo)this.a.jdField_a_of_type_Atpx.getItem(paramInt);
      this.a.jdField_a_of_type_Atpx.a(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131365464);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ShaderAnimLayout)paramSlideDetectListView).show();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyu
 * JD-Core Version:    0.7.0.1
 */