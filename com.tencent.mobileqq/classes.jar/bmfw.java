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

public class bmfw
  extends bmiv
  implements Handler.Callback, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private boolean jdField_a_of_type_Boolean;
  
  public bmfw(bmix parambmix)
  {
    super(parambmix);
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
    if (urk.f())
    {
      this.jdField_a_of_type_Boolean = urk.g();
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        str = "1";
        wta.a("video_edit", "exp_qzone", 0, 0, new String[] { str });
        if (urk.h())
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          urk.d();
          wta.a("video_edit", "exp_qztip", 0, 0, new String[0]);
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
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131377286));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131377282));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377283));
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
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    boolean bool = this.jdField_a_of_type_Boolean;
    wsv.d("Q.qqstory.publish.edit.EditSyncQzonePart", "story_sync_qzone : %s", new Object[] { Boolean.valueOf(bool) });
    parambmwn.a.putExtra("story_sync_qzone", Boolean.valueOf(bool));
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
    case 2131377284: 
    case 2131377285: 
    default: 
      return;
    case 2131377286: 
      if (this.jdField_a_of_type_Bmix.a() != null) {
        this.jdField_a_of_type_Bmix.a().a.add(Integer.valueOf(11));
      }
      blwf.a(paramView, 200L, new bmfx(this));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        wta.a("video_edit", "clk_qzone", 0, 0, new String[] { paramView });
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    wta.a("video_edit", "clk_qztip", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfw
 * JD-Core Version:    0.7.0.1
 */