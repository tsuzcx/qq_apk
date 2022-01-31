import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashSet;

public class bmhv
  extends bmiv
  implements Handler.Callback, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bniz jdField_a_of_type_Bniz;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private boolean jdField_a_of_type_Boolean;
  private Animator jdField_b_of_type_AndroidAnimationAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  private View f;
  private View g;
  
  public bmhv(@NonNull bmix parambmix, long paramLong)
  {
    super(parambmix);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private Animator a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bmhw(this));
    }
    return this.jdField_a_of_type_AndroidAnimationAnimator;
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.jdField_b_of_type_AndroidAnimationAnimator != null) && (this.jdField_b_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    a().start();
  }
  
  private Animator b()
  {
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
      this.jdField_b_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bmhx(this));
    }
    return this.jdField_b_of_type_AndroidAnimationAnimator;
  }
  
  private void d()
  {
    String str = bllv.a().getCurrentAccountUin();
    if ((this.jdField_b_of_type_Boolean) && ((!urk.f()) || (!urk.h())) && (urk.a(str)))
    {
      s();
      urk.e(str);
    }
  }
  
  private void j()
  {
    r();
    k();
    if (this.jdField_c_of_type_Boolean)
    {
      int i = urk.e();
      if (i < 3)
      {
        urk.a(i + 1);
        this.jdField_c_of_type_Boolean = false;
        p();
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    l();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369185);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369184));
      this.jdField_a_of_type_Bniz = new bniz(a(), ThreadManager.getUIHandler());
      this.jdField_a_of_type_Bniz.a(bnlc.a().a());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)bdcq.a(a(), 271.0F));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_Bniz.a(localLayoutParams);
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, 0);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOutlineProvider(new bmhy(bdcq.a(a(), 3.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClipToOutline(true);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363590));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378055);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131368728);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378061));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378057));
    }
  }
  
  private void l()
  {
    n();
    q();
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(true);
      str = alpo.a(2131704168);
      a(str, 2130846003);
      this.jdField_a_of_type_Bmix.a(Message.obtain(null, 16, 1, 0));
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        bcvq.a(this.jdField_d_of_type_AndroidViewView, str);
      }
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      str = alpo.a(2131704263);
      a(str, 2130846002);
      this.jdField_a_of_type_Bmix.a(Message.obtain(null, 16, 0, 0));
    }
  }
  
  private void n()
  {
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 8) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void o()
  {
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 8) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    b().start();
  }
  
  private void p()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Bniz.a();
    wta.a("video_edit_new", "multishoot_cover_clk", 0, 0, new String[0]);
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bniz.e();
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private void s()
  {
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131366624));
    this.e = a(2131366622);
    this.f = a(2131366623);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131363589));
    boolean bool;
    if ((this.jdField_a_of_type_Long & 0x0) != 0L)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label150;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
      wta.a("video_edit_new", "multishoot_exp", 0, 0, new String[0]);
    }
    for (;;)
    {
      d();
      return;
      bool = false;
      break;
      label150:
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    r();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bniz.e();
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    wsv.d("EditVideoFollowCapture", "follow_capture : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      utg localutg = new utg();
      localutg.a = 3;
      parambmwn.a.setLinkInfo(localutg);
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (paramMessage.arg1 == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setAlpha(0.5F);
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setAlpha(1.0F);
    this.jdField_d_of_type_Boolean = false;
    return false;
  }
  
  public void bd_()
  {
    super.bd_();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Bniz.e();
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Bniz.f();
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Bniz != null) {
      this.jdField_a_of_type_Bniz.d();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      r();
      continue;
      o();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363590: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bmix.a() != null) {
          this.jdField_a_of_type_Bmix.a().a.add(Integer.valueOf(8));
        }
      } while (this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      l();
      wta.a("video_edit_new", "multishoot_cover_open", 0, 0, new String[0]);
      return;
    case 2131363589: 
      this.jdField_a_of_type_Bmix.a(Message.obtain(null, 19, 0, 0));
      if (this.jdField_d_of_type_Boolean)
      {
        QQToast.a(a(), alpo.a(2131704194), 0).a();
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        l();
        return;
      }
      j();
      return;
    case 2131368728: 
      q();
      wta.a("video_edit_new", "multishoot_cover_close", 0, 0, new String[0]);
    }
    r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhv
 * JD-Core Version:    0.7.0.1
 */