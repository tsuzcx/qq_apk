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

public class boul
  extends botu
  implements View.OnClickListener
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bisa jdField_a_of_type_Bisa;
  private bpfr jdField_a_of_type_Bpfr;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private long c;
  
  public boul(@NonNull botw parambotw)
  {
    super(parambotw);
    this.jdField_b_of_type_Float = 3.0F;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private bisa a()
  {
    bisa localbisa = new bisa(a());
    localbisa.a(AIOUtils.dp2px(50.0F, a()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.e(true);
    localbisa.a(new boum(this));
    return localbisa;
  }
  
  @TargetApi(16)
  private void i()
  {
    a(2131364153).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131381038));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131381040));
    if (LiuHaiUtils.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131381049);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131381043).setOnClickListener(this);
    if ((!bnlb.a(this.jdField_a_of_type_Bouo.getActivity().getIntent())) && (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131381043)).setText(anvx.a(2131703296));
    }
    Object localObject = this.jdField_a_of_type_Bouo.getActivity().getIntent();
    int i = bnlb.a((Intent)localObject);
    if ((bnlb.e((Intent)localObject)) || (i == bnlb.n.a()) || (i == bnlb.g.a()) || (i == bnlb.q.a()) || (i == bnlb.r.a()) || (i == bnlb.o.a()) || (i == bnlb.s.a()) || (i == bnlb.v.a())) {
      ((TextView)a(2131381043)).setText(a().getText(2131716437));
    }
    if ((bnlb.a((Intent)localObject, this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (bnlb.c(this.jdField_a_of_type_Bouo.getActivity().getIntent())))
    {
      a(2131381052).setVisibility(8);
      a(2131381047).setVisibility(8);
      a(2131381048).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)a(2131379723)).setText(2131694295);
      }
      a(2131381042).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131381045));
      this.jdField_a_of_type_AndroidViewView = a(2131381041);
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
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
      if ((zfl.b()) && (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F) && (LiuHaiUtils.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, LiuHaiUtils.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_Botw.b()) {
        break label647;
      }
    }
    label647:
    for (localObject = "2";; localObject = "1")
    {
      aanb.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_Botw.a()) {
        break label654;
      }
      bbhl.f(this.jdField_a_of_type_Botw);
      return;
      a(2131381047).setOnClickListener(this);
      a(2131381048).setOnClickListener(this);
      break;
      label621:
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label419;
      label634:
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label451;
    }
    label654:
    bbhl.h(this.jdField_a_of_type_Botw);
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
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
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
    if (this.jdField_a_of_type_Bisa == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bisa.a();
      this.jdField_a_of_type_Bisa.c(paramInt);
      this.jdField_a_of_type_Bisa.b(true);
      this.jdField_a_of_type_Bisa.d(false);
      this.jdField_a_of_type_Bisa.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_Bisa.a() + ", progress:" + paramInt);
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
          localObject = this.jdField_a_of_type_Bpfr;
          this.jdField_a_of_type_Botw.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (bpfr)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          d();
          localObject = new StringBuilder(anvx.a(2131703371));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bouo.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      d();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_Botw.jdField_a_of_type_Bouo.a(paramInt2, paramIntent, 2130772030, 0);
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
        this.jdField_a_of_type_Bpfr = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof bpfr));
    this.jdField_a_of_type_Bpfr = ((bpfr)paramObject);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561862);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373219);
      this.jdField_a_of_type_Bisa = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bisa);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371598)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bisa.c(0);
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
        bovj.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_Botw.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
        return;
        bovj.a(this.jdField_a_of_type_AndroidViewViewGroup);
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
    if (this.jdField_a_of_type_Bouo == null) {
      return;
    }
    this.jdField_a_of_type_Bouo.a().postDelayed(new EditVideoStoryButton.3(this), 1000L);
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
  
  public boolean l_()
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
      ykq.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ykq.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      continue;
      label93:
      this.jdField_a_of_type_Botw.y();
      this.jdField_a_of_type_Botw.q();
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_Botf != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Botw.a() != null) && (!this.jdField_a_of_type_Botw.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131381044: 
      case 2131381045: 
      case 2131381046: 
      default: 
        break;
      case 2131381042: 
        this.jdField_a_of_type_Botw.e();
        break;
      case 2131381048: 
        if (this.jdField_a_of_type_Botw.a(2))
        {
          this.jdField_a_of_type_Botw.a(0);
        }
        else
        {
          this.jdField_a_of_type_Botw.t();
          aanb.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381047: 
        if (this.jdField_a_of_type_Botw.a(3))
        {
          this.jdField_a_of_type_Botw.a(0);
        }
        else
        {
          this.jdField_a_of_type_Botw.a(3);
          aanb.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381043: 
        bnqm.a().c();
        bnqq.a().d();
        bnrh.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l = SystemClock.uptimeMillis();
        if ((l - this.c >= 800L) && (!this.jdField_a_of_type_Bouo.getActivity().isFinishing()))
        {
          this.c = l;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          this.jdField_a_of_type_Botw.d();
          if (this.jdField_a_of_type_Botw.a()) {
            bbhl.e(this.jdField_a_of_type_Botw);
          } else {
            bbhl.g(this.jdField_a_of_type_Botw);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boul
 * JD-Core Version:    0.7.0.1
 */