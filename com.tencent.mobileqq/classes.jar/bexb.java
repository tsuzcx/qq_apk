import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.ksong.KSongTextView;
import com.tencent.mobileqq.widget.ksong.KSongView;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class bexb
  implements QwAdapter.IViewHolder<atwn>
{
  public KSongTextView a;
  
  public bexb(KSongView paramKSongView) {}
  
  public void a(int paramInt, View paramView, atwn paramatwn)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a();
    KSongTextView localKSongTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (TextUtils.isEmpty(paramatwn.a)) {}
    for (paramView = "";; paramView = paramatwn.a)
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)paramView.findViewById(2131373928));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexb
 * JD-Core Version:    0.7.0.1
 */