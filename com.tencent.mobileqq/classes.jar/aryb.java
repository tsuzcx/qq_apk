import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.4;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class aryb
  extends arwe
  implements ahqy, asag
{
  private static int jdField_a_of_type_Int;
  private float jdField_a_of_type_Float;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new arye(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private int b;
  private int c;
  private int d;
  
  public aryb(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new aryd(this, paramInt3));
    localValueAnimator.start();
  }
  
  private void b(String paramString)
  {
    asaf localasaf;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList != null) && (EmoticonPanelController.jdField_b_of_type_Int >= 0) && (EmoticonPanelController.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.size()))
    {
      localasaf = (asaf)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.get(EmoticonPanelController.jdField_b_of_type_Int);
      if (localasaf.jdField_a_of_type_Int != 7) {
        break label88;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    label88:
    do
    {
      return;
      if (localasaf.jdField_a_of_type_Int == 4)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      if (localasaf.jdField_a_of_type_Int == 11)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
        return;
      }
      if (localasaf.jdField_a_of_type_Int == 8)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
        return;
      }
      if (localasaf.jdField_a_of_type_Int == 10)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
        return;
      }
    } while ((localasaf.jdField_a_of_type_Int != 9) && (localasaf.jdField_a_of_type_Int != 6));
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
  }
  
  private boolean b()
  {
    return (jdField_a_of_type_Int > this.jdField_b_of_type_Int) && (a());
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = jdField_a_of_type_Int;
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.jdField_b_of_type_Int;
    }
    return j - i;
  }
  
  protected arwf a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList != null) && (EmoticonPanelController.jdField_b_of_type_Int >= 0) && (EmoticonPanelController.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.size()))
    {
      Object localObject = (asaf)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.get(EmoticonPanelController.jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((asaf)localObject);
      if ((localObject != null) && (((arwf)localObject).a() != null) && ((((arwf)localObject).a().getOnScrollListener() instanceof aryt))) {
        return localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    arwf localarwf = a();
    if (localarwf != null) {
      ((aryt)localarwf.a().getOnScrollListener()).a(localarwf.a());
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    List localList = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (localList != null) && (EmoticonPanelController.jdField_b_of_type_Int >= 0) && (EmoticonPanelController.jdField_b_of_type_Int < localList.size()))
    {
      localObject = ((EmotionPanelViewPagerAdapter)localObject).a(EmoticonPanelController.jdField_b_of_type_Int);
      if (localObject != null)
      {
        b(true);
        if (!TextUtils.isEmpty(paramString)) {
          break label91;
        }
      }
    }
    label91:
    for (int i = 8;; i = 0)
    {
      ((ImageButton)localObject).setVisibility(i);
      ((ImageButton)localObject).post(new EmoticonPanelExtendHelper.4(this));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onHide.");
      }
      if (paramBoolean) {
        break label75;
      }
      XPanelContainer.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      this.c = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
      }
      return;
      label75:
      if (this.c != 0) {
        XPanelContainer.jdField_a_of_type_Int = this.c;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.a) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!b()) {}
    float f;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().getParent() == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.d = XPanelContainer.jdField_a_of_type_Int;
      return false;
      f = paramMotionEvent.getY();
      i = (int)(f - this.jdField_a_of_type_Float + 0.5F);
    } while ((!a()) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i) <= this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.jdField_a_of_type_Float = f;
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 10, 9, 4, 5, 1, 3 };
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    if (jdField_a_of_type_Int > this.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow " + AppSetting.g() + " init panelH " + this.jdField_b_of_type_Int + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    arwf localarwf = a();
    if (localarwf != null) {
      ((aryt)localarwf.a().getOnScrollListener()).a(paramBoolean);
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (!b()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float + 0.5F);
      int j = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int -= i;
      if (XPanelContainer.jdField_a_of_type_Int > jdField_a_of_type_Int) {
        XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
      }
      while (XPanelContainer.jdField_a_of_type_Int != j)
      {
        AbstractGifImage.pauseAll();
        if (!(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getParent() instanceof XPanelContainer)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getParent().requestLayout();
        break;
        if (XPanelContainer.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
          XPanelContainer.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
      j = XPanelContainer.jdField_a_of_type_Int;
      if ((j != jdField_a_of_type_Int) && (j != this.jdField_b_of_type_Int))
      {
        if (j > this.d)
        {
          i = jdField_a_of_type_Int;
          label172:
          if (Math.abs(j - this.d) <= 100) {
            break label279;
          }
          j = 1;
          label188:
          if (j == 0) {
            break label284;
          }
          label192:
          if ((j == 0) || (i != this.jdField_b_of_type_Int)) {
            break label292;
          }
          b("0X800A847");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonPanelExtendHelper", 2, "report panel close");
          }
        }
        for (;;)
        {
          paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, i });
          paramMotionEvent.setDuration(150L);
          paramMotionEvent.addUpdateListener(new aryc(this, i));
          paramMotionEvent.start();
          break;
          i = this.jdField_b_of_type_Int;
          break label172;
          label279:
          j = 0;
          break label188;
          label284:
          i = this.d;
          break label192;
          label292:
          if ((j != 0) && (i == jdField_a_of_type_Int))
          {
            b("0X800A846");
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonPanelExtendHelper", 2, "report panel open");
            }
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList != null) && (EmoticonPanelController.jdField_b_of_type_Int >= 0) && (EmoticonPanelController.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.size()))
    {
      Object localObject = (asaf)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.get(EmoticonPanelController.jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((asaf)localObject);
      if ((localObject != null) && (((arwf)localObject).a() != null)) {
        ((arwf)localObject).a().abordFling();
      }
    }
  }
  
  public boolean c()
  {
    return XPanelContainer.jdField_a_of_type_Int == jdField_a_of_type_Int;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D);
  }
  
  public void f()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow.");
      }
      this.c = 0;
      b();
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      a();
    }
  }
  
  public void j()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void k()
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
  }
  
  public void m()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.jdField_b_of_type_Int);
      a(200, XPanelContainer.jdField_a_of_type_Int, jdField_a_of_type_Int);
      b("0X800A846");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullUp");
  }
  
  public void n()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != jdField_a_of_type_Int);
      a(250, XPanelContainer.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      b("0X800A847");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullDown");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryb
 * JD-Core Version:    0.7.0.1
 */