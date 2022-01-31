import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.ksong.KSongTextView;
import com.tencent.mobileqq.widget.ksong.KSongView;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class bess
  implements QwAdapter.IViewHolder<atse>
{
  public KSongTextView a;
  
  public bess(KSongView paramKSongView) {}
  
  public void a(int paramInt, View paramView, atse paramatse)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a();
    KSongTextView localKSongTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (TextUtils.isEmpty(paramatse.a)) {}
    for (paramView = "";; paramView = paramatse.a)
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)paramView.findViewById(2131373877));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bess
 * JD-Core Version:    0.7.0.1
 */