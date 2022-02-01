package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.relateemo.IAIORelatedEmotionExpandHelper;
import com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmotionPanel;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class AIORelatedEmotionHelper
  implements IHelper, ILifeCycleHelper, IAIORelatedEmotionExpandHelper
{
  protected IRelatedEmotionPanel a;
  private Context b;
  private BaseChatPie c;
  private View d;
  private int e = 0;
  private int f;
  private int g;
  private int h;
  private boolean i = true;
  
  public AIORelatedEmotionHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.e;
    this.c = paramBaseChatPie;
    double d1 = this.b.getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    this.h = ((int)(d1 * 0.6D));
  }
  
  private void d()
  {
    this.d = null;
    b();
    this.a = null;
  }
  
  public int a()
  {
    int j = 0;
    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
      j = ViewUtils.dip2px(15.0F);
    }
    return this.c.W.getHeight() + this.c.X.getHeight() - this.c.X.getPaddingTop() + j;
  }
  
  public void a(ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " showSearchRelatedEmotionPanel ");
    }
    Object localObject = this.c;
    if ((localObject != null) && (((BaseChatPie)localObject).bm() != null) && (this.c.W != null))
    {
      if (this.c.X == null) {
        return;
      }
      if (this.a == null) {
        this.a = ((IRelatedEmotionPanel)View.inflate(this.b, 2131624130, null));
      }
      this.g = ((Integer)SharedPreUtils.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
      if (this.g == 0) {
        this.g = ((int)(XPanelContainer.getDefaultExternalPanelHeighy() * this.b.getResources().getDisplayMetrics().density));
      }
      this.f = XPanelContainer.a;
      localObject = (AIOEmoticonPanelHelper)this.c.q(104);
      this.a.init(this.c.d, (EmoticonCallback)localObject, this);
      this.e = this.c.aR();
      int j = this.h;
      int k = a();
      this.a.showEmotionSearchWindow(paramChatMessage, paramURLDrawable, j + k);
      this.i = true;
      j = this.e;
      if (j == 1)
      {
        this.c.bm().a(37);
        return;
      }
      if (j == 0)
      {
        XPanelContainer.a = this.h;
        this.c.bm().postDelayed(new AIORelatedEmotionHelper.2(this), 150L);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " resetLastStatus ");
    }
    if (this.a == null) {
      return;
    }
    int j = this.f;
    if ((j >= this.h) || (j <= this.g)) {
      this.f = this.g;
    }
    XPanelContainer.a = this.f;
    j = this.e;
    if (j == 0)
    {
      this.c.bm().a(false);
      return;
    }
    if (j == 1) {
      this.c.bm().a(false);
    }
  }
  
  public View c()
  {
    if (this.d == null) {
      this.d = new View(this.b);
    }
    return this.d;
  }
  
  public String getTag()
  {
    return "AIORelatedEmotionHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 8 };
  }
  
  public void onClosePanel()
  {
    b();
    this.a = null;
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 8)
    {
      ThreadManager.getFileThreadHandler().post(new AIORelatedEmotionHelper.1(this));
      return;
    }
    if (paramInt == 15) {
      d();
    }
  }
  
  public void updatePanelDistance(float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    int j = this.h;
    int k = (int)(j - paramFloat);
    if (k < j)
    {
      j = k;
      if (k <= 0) {
        j = 0;
      }
    }
    if (this.i)
    {
      if ((this.e != 0) && (j >= this.f) && (XPanelContainer.a <= this.h))
      {
        XPanelContainer.a = j;
        this.c.bm().requestLayout();
      }
    }
    else
    {
      k = this.e;
      if ((k != 0) && (k != 1))
      {
        if (j <= this.g)
        {
          k = XPanelContainer.a;
          int m = this.g;
          if (k != m)
          {
            XPanelContainer.a = m;
            this.c.bm().requestLayout();
          }
        }
        else
        {
          XPanelContainer.a = j;
          this.c.bm().requestLayout();
        }
      }
      else
      {
        XPanelContainer.a = j;
        this.c.bm().requestLayout();
      }
    }
    if (j >= this.h) {
      this.i = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper
 * JD-Core Version:    0.7.0.1
 */