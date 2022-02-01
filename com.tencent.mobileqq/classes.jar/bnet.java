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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class bnet
  extends bnec
  implements View.OnClickListener
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bhhi jdField_a_of_type_Bhhi;
  private bnpz jdField_a_of_type_Bnpz;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private long c;
  
  public bnet(@NonNull bnee parambnee)
  {
    super(parambnee);
    this.jdField_b_of_type_Float = 3.0F;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private bhhi a()
  {
    bhhi localbhhi = new bhhi(a());
    localbhhi.a(AIOUtils.dp2px(50.0F, a()));
    localbhhi.a(true);
    localbhhi.c(false);
    localbhhi.g(-1);
    localbhhi.f(0);
    localbhhi.d(-15550475);
    localbhhi.i(3);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    localbhhi.e(true);
    localbhhi.a(new bneu(this));
    return localbhhi;
  }
  
  @TargetApi(16)
  private void i()
  {
    a(2131364078).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131380686));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131380688));
    if (LiuHaiUtils.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131380697);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131380691).setOnClickListener(this);
    if ((!blvr.a(this.jdField_a_of_type_Bnew.getActivity().getIntent())) && (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131380691)).setText(amtj.a(2131702945));
    }
    Object localObject = this.jdField_a_of_type_Bnew.getActivity().getIntent();
    int i = blvr.a((Intent)localObject);
    if ((blvr.e((Intent)localObject)) || (i == blvr.n.a()) || (i == blvr.g.a()) || (i == blvr.q.a()) || (i == blvr.r.a()) || (i == blvr.o.a()) || (i == blvr.s.a()) || (i == blvr.v.a())) {
      ((TextView)a(2131380691)).setText(a().getText(2131716088));
    }
    if ((blvr.a((Intent)localObject, this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (blvr.c(this.jdField_a_of_type_Bnew.getActivity().getIntent())))
    {
      a(2131380700).setVisibility(8);
      a(2131380695).setVisibility(8);
      a(2131380696).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)a(2131379418)).setText(2131694098);
      }
      a(2131380690).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131380693));
      this.jdField_a_of_type_AndroidViewView = a(2131380689);
      if (this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (i > 0) {
          break label621;
        }
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
        label419:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (i > 0) {
          break label634;
        }
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
        label451:
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((yqs.b()) && (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F) && (LiuHaiUtils.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, LiuHaiUtils.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_Bnee.b()) {
        break label647;
      }
    }
    label647:
    for (localObject = "2";; localObject = "1")
    {
      zxp.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_Bnee.a()) {
        break label654;
      }
      babc.f(this.jdField_a_of_type_Bnee);
      return;
      a(2131380695).setOnClickListener(this);
      a(2131380696).setOnClickListener(this);
      break;
      label621:
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label419;
      label634:
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label451;
    }
    label654:
    babc.h(this.jdField_a_of_type_Bnee);
  }
  
  private void k()
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
      if (this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = LiuHaiUtils.e;
        }
        i = (int)UIUtils.px2dip(a(), i);
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
    i();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhi == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bhhi.a();
      this.jdField_a_of_type_Bhhi.c(paramInt);
      this.jdField_a_of_type_Bhhi.b(true);
      this.jdField_a_of_type_Bhhi.d(false);
      this.jdField_a_of_type_Bhhi.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_Bhhi.a() + ", progress:" + paramInt);
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
        if (this.jdField_b_of_type_Int == 20) {}
        Object localObject;
        for (boolean bool = true;; bool = false)
        {
          localObject = this.jdField_a_of_type_Bnpz;
          this.jdField_a_of_type_Bnee.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (bnpz)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          d();
          localObject = new StringBuilder(amtj.a(2131703020));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bnew.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      d();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_Bnee.jdField_a_of_type_Bnew.a(paramInt2, paramIntent, 2130772030, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      b();
    }
    do
    {
      return;
      k();
      return;
      if (paramInt1 == 6) {
        a(true, true, false);
      }
      for (;;)
      {
        b();
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Bnpz = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof bnpz));
    this.jdField_a_of_type_Bnpz = ((bnpz)paramObject);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    c();
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
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561794);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373009);
      this.jdField_a_of_type_Bhhi = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bhhi);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371413)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bhhi.c(0);
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
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_a_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        bnfr.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bnee.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
        return;
        bnfr.a(this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
      break;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bnew == null) {
      return;
    }
    this.jdField_a_of_type_Bnew.a().postDelayed(new EditVideoStoryButton.3(this), 1000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    d();
    super.g();
  }
  
  public boolean j_()
  {
    return System.currentTimeMillis() < this.jdField_a_of_type_Long;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) > 500L)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      i = paramView.getId();
      if (this.jdField_a_of_type_Long <= System.currentTimeMillis()) {
        break label93;
      }
      xvv.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      xvv.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      continue;
      label93:
      this.jdField_a_of_type_Bnee.y();
      this.jdField_a_of_type_Bnee.q();
      if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Bnee.a() != null) && (!this.jdField_a_of_type_Bnee.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131380692: 
      case 2131380693: 
      case 2131380694: 
      default: 
        break;
      case 2131380690: 
        this.jdField_a_of_type_Bnee.e();
        break;
      case 2131380696: 
        if (this.jdField_a_of_type_Bnee.a(2))
        {
          this.jdField_a_of_type_Bnee.a(0);
        }
        else
        {
          this.jdField_a_of_type_Bnee.t();
          zxp.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131380695: 
        if (this.jdField_a_of_type_Bnee.a(3))
        {
          this.jdField_a_of_type_Bnee.a(0);
        }
        else
        {
          this.jdField_a_of_type_Bnee.a(3);
          zxp.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131380691: 
        bmbc.a().c();
        bmbg.a().d();
        bmbx.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l = SystemClock.uptimeMillis();
        if ((l - this.c >= 800L) && (!this.jdField_a_of_type_Bnew.getActivity().isFinishing()))
        {
          this.c = l;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          this.jdField_a_of_type_Bnee.d();
          if (this.jdField_a_of_type_Bnee.a()) {
            babc.e(this.jdField_a_of_type_Bnee);
          } else {
            babc.g(this.jdField_a_of_type_Bnee);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnet
 * JD-Core Version:    0.7.0.1
 */