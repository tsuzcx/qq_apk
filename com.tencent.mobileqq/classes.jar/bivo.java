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

public class bivo
  extends bifz
  implements View.OnClickListener, biij, bivb, bivc, bivd
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bivf jdField_a_of_type_Bivf;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private SlideBottomPanel jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private volatile boolean jdField_c_of_type_Boolean;
  private View d;
  
  public bivo(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private View a()
  {
    View localView = new View(a());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, aciy.a(130.0F, a())));
    localView.setBackgroundResource(2130849004);
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
  
  private void b(List<bivl> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((bivl)paramList.next()).a();
      }
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewStub)a(2131310087)).inflate();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel = ((SlideBottomPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131310478));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299161);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303596));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131310099);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131297459);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311819));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(a());
    this.jdField_a_of_type_Bivf = new bivf(a(), this);
    this.jdField_a_of_type_Bivf.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bivf);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.setSlidePanelListener(this);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131310066).setOnClickListener(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bivm.a().a(this);
    List localList = bivm.a().a();
    if ((localList != null) && (this.jdField_a_of_type_Bivf != null))
    {
      b(localList);
      this.jdField_a_of_type_Bivf.a(localList);
    }
    biih.a().a(this);
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.b()) && (this.jdField_a_of_type_Bivf != null) && (this.jdField_a_of_type_Bivf.a()))
    {
      this.jdField_c_of_type_Boolean = true;
      a(0, 1, 0);
      auts.b(this.jdField_a_of_type_Bigb);
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
  
  public void a(int paramInt, bivl parambivl)
  {
    if (this.jdField_a_of_type_Bivf != null)
    {
      this.jdField_a_of_type_Bivf.a(paramInt, parambivl);
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j))
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt - i);
          if ((((View)localObject).getTag() instanceof bivk))
          {
            localObject = (bivk)((View)localObject).getTag();
            ((bivk)localObject).a = parambivl;
            this.jdField_a_of_type_Bivf.a(paramInt, (bivk)localObject);
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
        List localList = bivm.a().a();
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
          bivl localbivl = (bivl)localList.get(i);
          if ((!TextUtils.isEmpty(localbivl.jdField_a_of_type_JavaLangString)) && (localbivl.jdField_a_of_type_JavaLangString.equals(paramString1)) && (a(paramInt, localbivl.jdField_a_of_type_Int)))
          {
            localbivl.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
            localbivl.d = paramString2;
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelPart.2(this, i, localbivl));
            return;
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
  }
  
  public void a(List<bivl> paramList)
  {
    if (this.jdField_a_of_type_Bivf != null) {
      this.jdField_a_of_type_Bivf.a(paramList);
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
    if ((this.jdField_a_of_type_Bivf != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
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
    if (this.jdField_a_of_type_Bivf != null) {
      this.jdField_a_of_type_Bivf.b();
    }
  }
  
  public void displayPanel()
  {
    l();
    if (this.d != null) {
      this.d.setVisibility(0);
    }
    auts.d(this.jdField_a_of_type_Bigb);
  }
  
  public void displayPanelFinish()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130848379);
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
    if (bivm.a().jdField_a_of_type_Boolean)
    {
      bivm.a().jdField_a_of_type_Boolean = false;
      n();
      bivm.a().a(false);
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
    if (this.jdField_a_of_type_Bivf != null) {
      this.jdField_a_of_type_Bivf.a();
    }
    this.jdField_c_of_type_Boolean = false;
    biih.a().b(this);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130848378);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Bigb.a.k()) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bigb.e();
    auts.a(this.jdField_a_of_type_Bigb);
    bhcm.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivo
 * JD-Core Version:    0.7.0.1
 */