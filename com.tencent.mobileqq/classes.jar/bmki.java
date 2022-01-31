import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import java.util.HashSet;

public class bmki
  extends bmnh
  implements Handler.Callback, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private boolean jdField_a_of_type_Boolean;
  
  public bmki(bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
  }
  
  private void d()
  {
    String str;
    if (uvt.f())
    {
      this.jdField_a_of_type_Boolean = uvt.g();
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        str = "1";
        wxj.a("video_edit", "exp_qzone", 0, 0, new String[] { str });
        if (uvt.h())
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          uvt.d();
          wxj.a("video_edit", "exp_qztip", 0, 0, new String[0]);
        }
      }
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Boolean);
      return;
      str = "2";
      break;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131377340));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131377336));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377337));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    d();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    super.a(paramInt, parambnaz);
    boolean bool = this.jdField_a_of_type_Boolean;
    wxe.d("Q.qqstory.publish.edit.EditSyncQzonePart", "story_sync_qzone : %s", new Object[] { Boolean.valueOf(bool) });
    parambnaz.a.putExtra("story_sync_qzone", Boolean.valueOf(bool));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131377338: 
    case 2131377339: 
    default: 
      return;
    case 2131377340: 
      if (this.jdField_a_of_type_Bmnj.a() != null) {
        this.jdField_a_of_type_Bmnj.a().a.add(Integer.valueOf(11));
      }
      bmar.a(paramView, 200L, new bmkj(this));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        wxj.a("video_edit", "clk_qzone", 0, 0, new String[] { paramView });
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    wxj.a("video_edit", "clk_qztip", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmki
 * JD-Core Version:    0.7.0.1
 */