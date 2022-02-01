import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.anim.FullPopAnimWithLOLLIPOP.5;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;

public class avjr
  extends avjo
  implements avmj
{
  private int jdField_a_of_type_Int;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler;
  private avkj jdField_a_of_type_Avkj;
  private int b;
  
  @SuppressLint({"NewApi"})
  private void b()
  {
    if (this.jdField_a_of_type_Avkj != null)
    {
      avkj localavkj = this.jdField_a_of_type_Avkj;
      localavkj.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
      localavkj = this.jdField_a_of_type_Avkj;
      localavkj.b -= this.b;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOutlineProvider(this.jdField_a_of_type_Avkj);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setClipToOutline(true);
      if (this.jdField_a_of_type_Avkj.jdField_a_of_type_Int > this.jdField_a_of_type_Avkj.b)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.a();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 5L);
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new FullPopAnimWithLOLLIPOP.5(this));
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjr
 * JD-Core Version:    0.7.0.1
 */