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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

public class bqfi
  extends bqgi
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
  private brfq jdField_a_of_type_Brfq;
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
  
  public bqfi(@NonNull bqgk parambqgk, long paramLong)
  {
    super(parambqgk);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private Animator a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bqfj(this));
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
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bqfk(this));
    }
    return this.jdField_b_of_type_AndroidAnimationAnimator;
  }
  
  private void d()
  {
    String str = bplg.a().getCurrentAccountUin();
    if ((this.jdField_b_of_type_Boolean) && ((!wta.f()) || (!wta.h())) && (wta.a(str)))
    {
      s();
      wta.e(str);
    }
  }
  
  private void j()
  {
    r();
    k();
    if (this.jdField_c_of_type_Boolean)
    {
      int i = wta.e();
      if (i < 3)
      {
        wta.a(i + 1);
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
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369687);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369686));
      this.jdField_a_of_type_Brfq = new brfq(a(), ThreadManager.getUIHandler());
      this.jdField_a_of_type_Brfq.a(brhq.a().a());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)bhmg.a(a(), 271.0F));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_Brfq.a(localLayoutParams);
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView, 0);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOutlineProvider(new bqfl(bhmg.a(a(), 3.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClipToOutline(true);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363814));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379118);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131369171);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379124));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379120));
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
      str = anzj.a(2131702684);
      a(str, 2130846532);
      this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 16, 1, 0));
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        bhga.a(this.jdField_d_of_type_AndroidViewView, str);
      }
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      str = anzj.a(2131702779);
      a(str, 2130846531);
      this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 16, 0, 0));
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
    this.jdField_a_of_type_Brfq.a();
    yup.a("video_edit_new", "multishoot_cover_clk", 0, 0, new String[0]);
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Brfq.e();
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
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131366950));
    this.e = a(2131366948);
    this.f = a(2131366949);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131363813));
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
      yup.a("video_edit_new", "multishoot_exp", 0, 0, new String[0]);
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
      this.jdField_a_of_type_Brfq.e();
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    yuk.d("EditVideoFollowCapture", "follow_capture : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      wuw localwuw = new wuw();
      localwuw.a = 3;
      parambqua.a.setLinkInfo(localwuw);
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
  
  public void aY_()
  {
    super.aY_();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Brfq.e();
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Brfq.f();
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Brfq != null) {
      this.jdField_a_of_type_Brfq.d();
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bqgk.a() != null) {
        this.jdField_a_of_type_Bqgk.a().a.add(Integer.valueOf(8));
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        l();
        yup.a("video_edit_new", "multishoot_cover_open", 0, 0, new String[0]);
        continue;
        this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 19, 0, 0));
        if (this.jdField_d_of_type_Boolean)
        {
          QQToast.a(a(), anzj.a(2131702710), 0).a();
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          l();
        }
        else
        {
          j();
          continue;
          q();
          yup.a("video_edit_new", "multishoot_cover_close", 0, 0, new String[0]);
          r();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfi
 * JD-Core Version:    0.7.0.1
 */