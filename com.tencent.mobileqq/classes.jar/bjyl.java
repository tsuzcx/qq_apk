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

public class bjyl
  extends bjxl
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
  bcpu jdField_a_of_type_Bcpu;
  private bkmo jdField_a_of_type_Bkmo;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  
  public bjyl(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_b_of_type_Float = 3.0F;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private bcpu a()
  {
    bcpu localbcpu = new bcpu(a());
    localbcpu.a(actj.a(50.0F, a()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.e(true);
    localbcpu.a(new bjym(this));
    return localbcpu;
  }
  
  @TargetApi(16)
  private void l()
  {
    a(2131363764).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131379087));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379089));
    if (bkvi.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131379098);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131379092).setOnClickListener(this);
    if ((!birt.a(this.jdField_a_of_type_Bjyv.getActivity().getIntent())) && (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131379092)).setText(ajya.a(2131703825));
    }
    Object localObject = this.jdField_a_of_type_Bjyv.getActivity().getIntent();
    int i = birt.a((Intent)localObject);
    if ((birt.e((Intent)localObject)) || (i == birt.n.a()) || (i == birt.g.a()) || (i == birt.q.a()) || (i == birt.r.a()) || (i == birt.o.a()) || (i == birt.s.a()) || (i == birt.v.a())) {
      ((TextView)a(2131379092)).setText(a().getText(2131717113));
    }
    if ((birt.a((Intent)localObject, this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (birt.c(this.jdField_a_of_type_Bjyv.getActivity().getIntent())))
    {
      a(2131379101).setVisibility(8);
      a(2131379096).setVisibility(8);
      a(2131379097).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)a(2131378016)).setText(2131694653);
      }
      a(2131379091).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131379094));
      this.jdField_a_of_type_AndroidViewView = a(2131379090);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (i > 0) {
          break label621;
        }
        ((ViewGroup.LayoutParams)localObject).height += bkvi.e;
        label419:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (i > 0) {
          break label634;
        }
        ((ViewGroup.LayoutParams)localObject).height += bkvi.e;
        label451:
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((vzu.b()) && (axlk.c(a()) / axlk.e(a()) >= 2.0F) && (bkvi.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, bkvi.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_Bjxn.b()) {
        break label647;
      }
    }
    label647:
    for (localObject = "2";; localObject = "1")
    {
      xhb.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_Bjxn.a()) {
        break label654;
      }
      avtd.f(this.jdField_a_of_type_Bjxn);
      return;
      a(2131379096).setOnClickListener(this);
      a(2131379097).setOnClickListener(this);
      break;
      label621:
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label419;
      label634:
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label451;
    }
    label654:
    avtd.h(this.jdField_a_of_type_Bjxn);
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
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = bkvi.e;
        }
        i = (int)vzl.a(a(), i);
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
    if (this.jdField_a_of_type_Bcpu == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bcpu.a();
      this.jdField_a_of_type_Bcpu.c(paramInt);
      this.jdField_a_of_type_Bcpu.b(true);
      this.jdField_a_of_type_Bcpu.d(false);
      this.jdField_a_of_type_Bcpu.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpu.a() + ", progress:" + paramInt);
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
          localObject = this.jdField_a_of_type_Bkmo;
          this.jdField_a_of_type_Bjxn.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (bkmo)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          k();
          localObject = new StringBuilder(ajya.a(2131703900));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          bcql.a(this.jdField_a_of_type_Bjyv.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      k();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyv.a(paramInt2, paramIntent, 2130772028, 0);
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
        this.jdField_a_of_type_Bkmo = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof bkmo));
    this.jdField_a_of_type_Bkmo = ((bkmo)paramObject);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561434);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpu = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpu);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370452)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpu.c(0);
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
        bjzx.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 11, Long.valueOf(this.d)));
        return;
        bjzx.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
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
    if (this.jdField_a_of_type_Bjyv == null) {
      return;
    }
    this.jdField_a_of_type_Bjyv.a().postDelayed(new EditVideoStoryButton.3(this), 1000L);
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
      ved.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.d), Long.valueOf(System.currentTimeMillis()) });
    }
    label84:
    long l;
    do
    {
      return;
      ved.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      return;
      this.jdField_a_of_type_Bjxn.B();
      this.jdField_a_of_type_Bjxn.s();
      if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Bjxn.a() != null) && (!this.jdField_a_of_type_Bjxn.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131379093: 
      case 2131379094: 
      case 2131379095: 
      default: 
        return;
      case 2131379091: 
        this.jdField_a_of_type_Bjxn.e();
        return;
      case 2131379097: 
        if (this.jdField_a_of_type_Bjxn.a(5))
        {
          this.jdField_a_of_type_Bjxn.a(0);
          return;
        }
        this.jdField_a_of_type_Bjxn.w();
        xhb.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        return;
      case 2131379096: 
        if (this.jdField_a_of_type_Bjxn.a(6))
        {
          this.jdField_a_of_type_Bjxn.a(0);
          return;
        }
        this.jdField_a_of_type_Bjxn.a(6);
        xhb.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        return;
      }
      bizt.a().c();
      bizx.a().d();
      bjah.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
      l = SystemClock.uptimeMillis();
    } while ((l - this.jdField_b_of_type_Long < 800L) || (this.jdField_a_of_type_Bjyv.getActivity().isFinishing()));
    this.jdField_b_of_type_Long = l;
    QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
    this.jdField_a_of_type_Bjxn.d();
    if (this.jdField_a_of_type_Bjxn.a())
    {
      avtd.e(this.jdField_a_of_type_Bjxn);
      return;
    }
    avtd.g(this.jdField_a_of_type_Bjxn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyl
 * JD-Core Version:    0.7.0.1
 */