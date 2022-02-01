package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.mobileqq.widget.MosaicEffect;

public class HeadIconProcessor
  implements IHeadIconProcessor
{
  private ImageView a;
  private BaseChatItemLayout b;
  private Context c;
  private ImageView d;
  private VasAvatar e;
  private BaseChatItemLayoutViewBasicAbility f;
  
  public HeadIconProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.b = paramBaseChatItemLayout;
    this.c = paramContext;
  }
  
  private void d()
  {
    Object localObject = AIOLongShotHelper.f();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).c()) && (((AIOLongShotHelper)localObject).d())) {
      localObject = new MosaicEffect(10);
    } else {
      localObject = null;
    }
    this.e.setMosaicEffect((MosaicEffect)localObject);
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.f == null)
    {
      VasAvatar localVasAvatar = this.e;
      if (localVasAvatar != null) {
        this.f = new BaseChatItemLayoutViewBasicAbilityImpl(localVasAvatar);
      }
    }
    return this.f;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    return null;
  }
  
  public void a(Object paramObject)
  {
    int i = this.c.getResources().getDimensionPixelSize(2131296645);
    int j = AIOUtils.b(5.0F, this.c.getResources());
    a(paramObject, i, BaseChatItemLayout.R, BaseChatItemLayout.R, j, true);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      this.e = new VasAvatar(this.c);
      this.e.setId(2131430587);
      this.e.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(paramInt2, paramInt3);
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430586);
      if (this.b.getHeadIconPosition() == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt4;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.b.ac != null) && (this.b.ac.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.c.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt4;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.b.getTopId());
      this.b.addView(this.e, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localObject = (RelativeLayout.LayoutParams)((VasAvatar)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430586);
      if (this.b.getHeadIconPosition() == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt4;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.b.ac != null) && (this.b.ac.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.c.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt4;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.b.getTopId());
    }
    if ((paramObject instanceof Drawable)) {
      this.e.setImageDrawable((Drawable)paramObject);
    } else {
      this.e.setLoader(null, (VasAvatarLoader)paramObject);
    }
    paramObject = this.d;
    if (paramObject != null) {
      paramObject.setVisibility(8);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000))
    {
      paramChatMessage.isShowQimStyleAvater = QIMUserManager.b().a(paramObject, paramQQAppInterface, paramChatMessage);
      paramChatMessage.isShowQIMStyleGroup = QIMUserManager.b().a(paramObject, paramQQAppInterface, paramChatMessage, false);
      if (paramChatMessage.isShowQimStyleAvater)
      {
        paramObject = QIMUserManager.b().b(1);
        if (paramObject == null) {
          return;
        }
        int i = this.c.getResources().getDimensionPixelSize(2131296645);
        int j = AIOUtils.b(28.0F, this.c.getResources());
        Object localObject = this.a;
        if (localObject == null)
        {
          this.a = new ImageView(this.c);
          this.a.setId(2131430600);
          this.a.setScaleType(ImageView.ScaleType.FIT_XY);
          int k = AIOUtils.b(13.0F, this.c.getResources());
          this.a.setImageDrawable(paramObject);
          paramObject = new RelativeLayout.LayoutParams(k, k);
          paramObject.topMargin = (i + j);
          paramObject.leftMargin = j;
          paramObject.addRule(7, 2131430587);
          paramObject.addRule(8, 2131430587);
          this.b.addView(this.a, paramObject);
        }
        else
        {
          localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = (i + j);
          ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131430587);
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131430587);
          this.a.setImageDrawable(paramObject);
        }
        if (paramChatMessage.istroop == 1)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 1, 0, "", "", "", "");
          return;
        }
        if (paramChatMessage.istroop == 3000) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 1, 0, "", "", "", "");
        }
      }
      else
      {
        paramChatMessage.isShowQimStyleAvater = false;
        paramObject = this.a;
        if (paramObject != null) {
          paramObject.setImageDrawable(null);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = MessageForArkApp.dp2px(1.0F);
      if (this.d == null)
      {
        this.d = new ImageView(this.c);
        this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        int j = MessageForArkApp.dp2px(42.0F);
        localObject = new RelativeLayout.LayoutParams(j, j);
        this.b.addView(this.d, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131430587);
      i = -i;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (this.b.d())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131430587);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131430587);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      }
      this.d.setBackgroundResource(2130846325);
      this.d.requestLayout();
      this.d.setVisibility(0);
      return;
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((VasAvatar)localObject).getVisibility() == 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      int i = AIOUtils.b(5.0F, this.c.getResources());
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.b.ac != null) && (this.b.ac.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.c.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramInt);
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility b()
  {
    ImageView localImageView = this.d;
    if (localImageView == null) {
      return null;
    }
    return new BaseChatItemLayoutViewBasicAbilityImpl(localImageView);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null) {
      if (paramBoolean) {
        ((VasAvatar)localObject).setVisibility(0);
      } else {
        ((VasAvatar)localObject).setVisibility(8);
      }
    }
    localObject = (NickNameLayoutViewWrapper)this.b.a(NickNameLayoutViewWrapper.class);
    if (localObject != null)
    {
      localObject = ((NickNameLayoutViewWrapper)localObject).c();
      if (localObject != null) {
        if (paramBoolean) {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(0);
        } else {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(8);
        }
      }
    }
    localObject = AIOLongShotHelper.f();
    boolean bool = paramBoolean;
    if (localObject != null)
    {
      bool = paramBoolean;
      if (((AIOLongShotHelper)localObject).h()) {
        bool = false;
      }
    }
    this.b.setPendantImageVisible(bool);
  }
  
  public VasAvatar c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconProcessor
 * JD-Core Version:    0.7.0.1
 */