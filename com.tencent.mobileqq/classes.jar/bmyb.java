import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.1;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.2;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart.3;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;
import java.util.Iterator;
import java.util.List;

public class bmyb
  extends bmiv
  implements View.OnClickListener, bmlf, bmxo, bmxp, bmxq
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bmxs jdField_a_of_type_Bmxs;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private SlideBottomPanel jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private volatile boolean jdField_c_of_type_Boolean;
  private View d;
  
  public bmyb(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private View a()
  {
    View localView = new View(a());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, aekt.a(130.0F, a())));
    localView.setBackgroundResource(2130849679);
    return localView;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.jdField_c_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt3);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramInt1 == 1) {
      if ((paramInt2 == 0) || (paramInt2 == 1000) || (paramInt2 == 1004)) {
        bool1 = true;
      }
    }
    do
    {
      return bool1;
      if (paramInt1 == 4)
      {
        if (paramInt2 == 1) {}
        for (bool1 = bool3;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramInt1 != 101);
    if (paramInt2 == 3000) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void b(List<bmxy> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((bmxy)paramList.next()).a();
      }
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewStub)a(2131376352)).inflate();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel = ((SlideBottomPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131376775));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364800);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369501));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376364);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131363034);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378176));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(a());
    this.jdField_a_of_type_Bmxs = new bmxs(a(), this);
    this.jdField_a_of_type_Bmxs.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bmxs);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.setSlidePanelListener(this);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131376331).setOnClickListener(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bmxz.a().a(this);
    List localList = bmxz.a().a();
    if ((localList != null) && (this.jdField_a_of_type_Bmxs != null))
    {
      b(localList);
      this.jdField_a_of_type_Bmxs.a(localList);
    }
    bmld.a().a(this);
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.b()) && (this.jdField_a_of_type_Bmxs != null) && (this.jdField_a_of_type_Bmxs.a()))
    {
      this.jdField_c_of_type_Boolean = true;
      a(0, 1, 0);
      axlc.b(this.jdField_a_of_type_Bmix);
    }
  }
  
  private void n()
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3F, 0.0F), Keyframe.ofFloat(0.45F, -80.0F), Keyframe.ofFloat(0.65F, 50.0F), Keyframe.ofFloat(0.8F, -30.0F), Keyframe.ofFloat(0.9F, 10.0F), Keyframe.ofFloat(1.0F, 0.0F) });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_b_of_type_AndroidViewView, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(1600L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(1000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @NonNull
  public Context a()
  {
    return super.a();
  }
  
  public void a()
  {
    super.a();
    j();
    k();
  }
  
  public void a(int paramInt, bmxy parambmxy)
  {
    if (this.jdField_a_of_type_Bmxs != null)
    {
      this.jdField_a_of_type_Bmxs.a(paramInt, parambmxy);
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j))
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt - i);
          if ((((View)localObject).getTag() instanceof bmxx))
          {
            localObject = (bmxx)((View)localObject).getTag();
            ((bmxx)localObject).a = parambmxy;
            this.jdField_a_of_type_Bmxs.a(paramInt, (bmxx)localObject);
          }
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        l();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.i("SendPanelPart", 4, "onUpdateIcon uin is empty");
      }
    }
    label164:
    do
    {
      for (;;)
      {
        return;
        List localList = bmxz.a().a();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        int j = localList.size();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label164;
          }
          bmxy localbmxy = (bmxy)localList.get(i);
          if ((!TextUtils.isEmpty(localbmxy.jdField_a_of_type_JavaLangString)) && (localbmxy.jdField_a_of_type_JavaLangString.equals(paramString1)) && (a(paramInt, localbmxy.jdField_a_of_type_Int)))
          {
            localbmxy.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
            localbmxy.d = paramString2;
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelPart.2(this, i, localbmxy));
            return;
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
  }
  
  public void a(List<bmxy> paramList)
  {
    if (this.jdField_a_of_type_Bmxs != null) {
      this.jdField_a_of_type_Bmxs.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel != null)
    {
      if (!paramBoolean) {
        break label29;
      }
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.a()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.c();
      }
    }
    label29:
    while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.a()) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.d();
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bmxs != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelPart.3(this));
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void c() {}
  
  public void cancelAnimator()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null))
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bmxs != null) {
      this.jdField_a_of_type_Bmxs.b();
    }
  }
  
  public void displayPanel()
  {
    l();
    if (this.d != null) {
      this.d.setVisibility(0);
    }
    axlc.d(this.jdField_a_of_type_Bmix);
  }
  
  public void displayPanelFinish()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849047);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SendPanelPart", 4, "compositeFail");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelPart.1(this));
    }
  }
  
  public void f()
  {
    super.f();
    if (bmxz.a().jdField_a_of_type_Boolean)
    {
      bmxz.a().jdField_a_of_type_Boolean = false;
      n();
      bmxz.a().a(false);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (this.d != null)
    {
      this.d.setVisibility(0);
      this.d.setAlpha(paramFloat);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bmxs != null) {
      this.jdField_a_of_type_Bmxs.a();
    }
    this.jdField_c_of_type_Boolean = false;
    bmld.a().b(this);
    super.g();
  }
  
  public void hidePanel()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
      a(1, 0, 8);
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
  }
  
  public void hidePanelFinish()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849046);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Bmix.a.k()) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bmix.e();
    axlc.a(this.jdField_a_of_type_Bmix);
    bler.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyb
 * JD-Core Version:    0.7.0.1
 */