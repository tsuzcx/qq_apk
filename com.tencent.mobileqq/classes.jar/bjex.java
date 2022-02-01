import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.ksong.KSongTextView;
import com.tencent.mobileqq.widget.ksong.KSongView;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class bjex
  implements QwAdapter.IViewHolder<awwo>
{
  public KSongTextView a;
  
  public bjex(KSongView paramKSongView) {}
  
  public void a(int paramInt, View paramView, awwo paramawwo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a();
    KSongTextView localKSongTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (TextUtils.isEmpty(paramawwo.a)) {}
    for (paramView = "";; paramView = paramawwo.a)
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)paramView.findViewById(2131374781));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjex
 * JD-Core Version:    0.7.0.1
 */