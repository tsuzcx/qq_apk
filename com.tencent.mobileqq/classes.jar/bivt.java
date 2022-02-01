import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.ksong.KSongTextView;
import com.tencent.mobileqq.widget.ksong.KSongView;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class bivt
  implements QwAdapter.IViewHolder<awqa>
{
  public KSongTextView a;
  
  public bivt(KSongView paramKSongView) {}
  
  public void a(int paramInt, View paramView, awqa paramawqa)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a();
    KSongTextView localKSongTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (TextUtils.isEmpty(paramawqa.a)) {}
    for (paramView = "";; paramView = paramawqa.a)
    {
      localKSongTextView.setText(paramView);
      return;
    }
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)paramView.findViewById(2131374787));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivt
 * JD-Core Version:    0.7.0.1
 */