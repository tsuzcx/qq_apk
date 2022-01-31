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
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bigz
  extends bifz
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
  bbmh jdField_a_of_type_Bbmh;
  private bivl jdField_a_of_type_Bivl;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  
  public bigz(@NonNull bigb parambigb)
  {
    super(parambigb);
    this.jdField_b_of_type_Float = 3.0F;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private bbmh a()
  {
    bbmh localbbmh = new bbmh(a());
    localbbmh.a(aciy.a(50.0F, a()));
    localbbmh.a(true);
    localbbmh.c(false);
    localbbmh.f(-1);
    localbbmh.e(0);
    localbbmh.d(-15550475);
    localbbmh.g(3);
    localbbmh.jdField_f_of_type_Boolean = true;
    localbbmh.jdField_f_of_type_Int = 2;
    localbbmh.e(true);
    localbbmh.a(new biha(this));
    return localbbmh;
  }
  
  @TargetApi(16)
  private void l()
  {
    a(2131298210).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131313246));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131313248));
    if (bjeh.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131313258);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131313251).setOnClickListener(this);
    if ((!bjeg.c(this.jdField_a_of_type_Bihj.getActivity().getIntent())) && (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131313251)).setText(ajjy.a(2131638029));
    }
    Object localObject = this.jdField_a_of_type_Bihj.getActivity().getIntent();
    int i = bjeg.a((Intent)localObject);
    if ((bjeg.j((Intent)localObject)) || (i == bgww.m.a()) || (i == bgww.f.a()) || (i == bgww.p.a()) || (i == bgww.q.a()) || (i == bgww.n.a()) || (i == bgww.r.a()) || (i == bgww.u.a())) {
      ((TextView)a(2131313251)).setText(a().getText(2131651310));
    }
    if ((bjeg.a(this.jdField_a_of_type_Bihj.getActivity().getIntent(), this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bjeg.e(this.jdField_a_of_type_Bihj.getActivity().getIntent())))
    {
      a(2131313261).setVisibility(8);
      a(2131313256).setVisibility(8);
      a(2131313257).setVisibility(8);
      a(2131313250).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131313254));
      this.jdField_a_of_type_AndroidViewView = a(2131313249);
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (i > 0) {
          break label604;
        }
        ((ViewGroup.LayoutParams)localObject).height += bjeh.e;
        label402:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (i > 0) {
          break label617;
        }
        ((ViewGroup.LayoutParams)localObject).height += bjeh.e;
        label434:
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((vnb.b()) && (awmc.c(a()) / awmc.e(a()) >= 2.0F) && (bjeh.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, bjeh.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_Bigb.b()) {
        break label630;
      }
    }
    label604:
    label617:
    label630:
    for (localObject = "2";; localObject = "1")
    {
      wye.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_Bigb.a()) {
        break label637;
      }
      auts.f(this.jdField_a_of_type_Bigb);
      return;
      a(2131313256).setOnClickListener(this);
      a(2131313257).setOnClickListener(this);
      break;
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label402;
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label434;
    }
    label637:
    auts.h(this.jdField_a_of_type_Bigb);
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
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = bjeh.e;
        }
        i = (int)vms.a(a(), i);
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
    if (this.jdField_a_of_type_Bbmh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bbmh.a();
      this.jdField_a_of_type_Bbmh.c(paramInt);
      this.jdField_a_of_type_Bbmh.b(true);
      this.jdField_a_of_type_Bbmh.d(false);
      this.jdField_a_of_type_Bbmh.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_Bbmh.a() + ", progress:" + paramInt);
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
          localObject = this.jdField_a_of_type_Bivl;
          this.jdField_a_of_type_Bigb.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (bivl)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          k();
          localObject = new StringBuilder(ajjy.a(2131638104));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          bbmy.a(this.jdField_a_of_type_Bihj.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      k();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihj.a(paramInt2, paramIntent, 2130772028, 0);
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
        this.jdField_a_of_type_Bivl = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof bivl));
    this.jdField_a_of_type_Bivl = ((bivl)paramObject);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131495844);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131306298);
      this.jdField_a_of_type_Bbmh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bbmh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131304792)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bbmh.c(0);
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
        biil.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bigb.a(Message.obtain(null, 11, Long.valueOf(this.d)));
        return;
        biil.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
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
    if (this.jdField_a_of_type_Bihj == null) {
      return;
    }
    this.jdField_a_of_type_Bihj.a().postDelayed(new EditVideoStoryButton.3(this), 1000L);
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
      urk.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.d), Long.valueOf(System.currentTimeMillis()) });
    }
    label84:
    long l;
    do
    {
      return;
      urk.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      return;
      this.jdField_a_of_type_Bigb.B();
      this.jdField_a_of_type_Bigb.s();
      if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Bigb.a() != null) && (!this.jdField_a_of_type_Bigb.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131313252: 
      case 2131313253: 
      case 2131313254: 
      case 2131313255: 
      default: 
        return;
      case 2131313250: 
        this.jdField_a_of_type_Bigb.e();
        return;
      case 2131313257: 
        if (this.jdField_a_of_type_Bigb.a(5))
        {
          this.jdField_a_of_type_Bigb.a(0);
          return;
        }
        this.jdField_a_of_type_Bigb.w();
        wye.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        return;
      case 2131313256: 
        if (this.jdField_a_of_type_Bigb.a(6))
        {
          this.jdField_a_of_type_Bigb.a(0);
          return;
        }
        this.jdField_a_of_type_Bigb.a(6);
        wye.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        return;
      }
      bhci.a().c();
      bhcm.a().d();
      bhcs.a("EditVideoStoryButton", 1, "【Click】+ video_story_control_publish");
      l = SystemClock.uptimeMillis();
    } while ((l - this.jdField_b_of_type_Long < 800L) || (this.jdField_a_of_type_Bihj.getActivity().isFinishing()));
    this.jdField_b_of_type_Long = l;
    QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
    this.jdField_a_of_type_Bigb.d();
    if (this.jdField_a_of_type_Bigb.a())
    {
      auts.e(this.jdField_a_of_type_Bigb);
      return;
    }
    auts.g(this.jdField_a_of_type_Bigb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigz
 * JD-Core Version:    0.7.0.1
 */