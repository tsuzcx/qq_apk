import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bmjv
  extends bmiv
  implements View.OnClickListener
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bepe jdField_a_of_type_Bepe;
  private bmxy jdField_a_of_type_Bmxy;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  
  public bmjv(@NonNull bmix parambmix)
  {
    super(parambmix);
    this.jdField_b_of_type_Float = 3.0F;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private bepe a()
  {
    bepe localbepe = new bepe(a());
    localbepe.a(aekt.a(50.0F, a()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.e(true);
    localbepe.a(new bmjw(this));
    return localbepe;
  }
  
  @TargetApi(16)
  private void l()
  {
    a(2131363820).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131379766));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379768));
    if (bngs.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131379777);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131379771).setOnClickListener(this);
    if ((!bkwm.a(this.jdField_a_of_type_Bmkf.getActivity().getIntent())) && (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131379771)).setText(alpo.a(2131704197));
    }
    Object localObject = this.jdField_a_of_type_Bmkf.getActivity().getIntent();
    int i = bkwm.a((Intent)localObject);
    if ((bkwm.e((Intent)localObject)) || (i == bkwm.n.a()) || (i == bkwm.g.a()) || (i == bkwm.q.a()) || (i == bkwm.r.a()) || (i == bkwm.o.a()) || (i == bkwm.s.a()) || (i == bkwm.v.a())) {
      ((TextView)a(2131379771)).setText(a().getText(2131717485));
    }
    if ((bkwm.a((Intent)localObject, this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bkwm.c(this.jdField_a_of_type_Bmkf.getActivity().getIntent())))
    {
      a(2131379780).setVisibility(8);
      a(2131379775).setVisibility(8);
      a(2131379776).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)a(2131378563)).setText(2131694809);
      }
      a(2131379770).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131379773));
      this.jdField_a_of_type_AndroidViewView = a(2131379769);
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (i > 0) {
          break label621;
        }
        ((ViewGroup.LayoutParams)localObject).height += bngs.e;
        label419:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (i > 0) {
          break label634;
        }
        ((ViewGroup.LayoutParams)localObject).height += bngs.e;
        label451:
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((xom.b()) && (azgq.c(a()) / azgq.e(a()) >= 2.0F) && (bngs.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, bngs.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_Bmix.b()) {
        break label647;
      }
    }
    label647:
    for (localObject = "2";; localObject = "1")
    {
      yvu.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_Bmix.a()) {
        break label654;
      }
      axlc.f(this.jdField_a_of_type_Bmix);
      return;
      a(2131379775).setOnClickListener(this);
      a(2131379776).setOnClickListener(this);
      break;
      label621:
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label419;
      label634:
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label451;
    }
    label654:
    axlc.h(this.jdField_a_of_type_Bmix);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = new StaticStickerProviderView(a());
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setTabBarPosition(1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImCaptureViewProviderView);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
      }
      return;
    }
    if (!this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d())
    {
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = bngs.e;
        }
        i = (int)xod.a(a(), i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d(i + k);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a()
  {
    super.a();
    l();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepe == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bepe.a();
      this.jdField_a_of_type_Bepe.c(paramInt);
      this.jdField_a_of_type_Bepe.b(true);
      this.jdField_a_of_type_Bepe.d(false);
      this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
        if (this.jdField_b_of_type_Int == 49) {}
        Object localObject;
        for (boolean bool = true;; bool = false)
        {
          localObject = this.jdField_a_of_type_Bmxy;
          this.jdField_a_of_type_Bmix.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (bmxy)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          k();
          localObject = new StringBuilder(alpo.a(2131704272));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bmkf.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      k();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmkf.a(paramInt2, paramIntent, 2130772028, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      d();
    }
    do
    {
      return;
      n();
      return;
      if (paramInt1 == 9) {
        a(true, true, false);
      }
      for (;;)
      {
        d();
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Bmxy = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof bmxy));
    this.jdField_a_of_type_Bmxy = ((bmxy)paramObject);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    j();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bepe.c(0);
    a().a().postDelayed(new EditVideoStoryButton.2(this), paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.d = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.d += 500L;
      }
      if (paramBoolean1) {
        bmlh.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bmix.a(Message.obtain(null, 11, Long.valueOf(this.d)));
        return;
        bmlh.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.d = 0L;
      break;
    }
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() < this.d;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void g()
  {
    k();
    super.g();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bmkf == null) {
      return;
    }
    this.jdField_a_of_type_Bmkf.a().postDelayed(new EditVideoStoryButton.3(this), 1000L);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 500L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      i = paramView.getId();
      if (this.d <= System.currentTimeMillis()) {
        break label84;
      }
      wsv.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.d), Long.valueOf(System.currentTimeMillis()) });
    }
    label84:
    long l;
    do
    {
      return;
      wsv.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      return;
      this.jdField_a_of_type_Bmix.B();
      this.jdField_a_of_type_Bmix.s();
      if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmhd != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmhd.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Bmix.a() != null) && (!this.jdField_a_of_type_Bmix.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131379772: 
      case 2131379773: 
      case 2131379774: 
      default: 
        return;
      case 2131379770: 
        this.jdField_a_of_type_Bmix.e();
        return;
      case 2131379776: 
        if (this.jdField_a_of_type_Bmix.a(5))
        {
          this.jdField_a_of_type_Bmix.a(0);
          return;
        }
        this.jdField_a_of_type_Bmix.w();
        yvu.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        return;
      case 2131379775: 
        if (this.jdField_a_of_type_Bmix.a(6))
        {
          this.jdField_a_of_type_Bmix.a(0);
          return;
        }
        this.jdField_a_of_type_Bmix.a(6);
        yvu.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        return;
      }
      blen.a().c();
      bler.a().d();
      blfg.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
      l = SystemClock.uptimeMillis();
    } while ((l - this.jdField_b_of_type_Long < 800L) || (this.jdField_a_of_type_Bmkf.getActivity().isFinishing()));
    this.jdField_b_of_type_Long = l;
    QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
    this.jdField_a_of_type_Bmix.d();
    if (this.jdField_a_of_type_Bmix.a())
    {
      axlc.e(this.jdField_a_of_type_Bmix);
      return;
    }
    axlc.g(this.jdField_a_of_type_Bmix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjv
 * JD-Core Version:    0.7.0.1
 */