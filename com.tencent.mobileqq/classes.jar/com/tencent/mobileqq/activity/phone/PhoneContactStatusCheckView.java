package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class PhoneContactStatusCheckView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView a;
  private Button b;
  private ImageView c;
  private ImageView d;
  private WeakReference<PhoneContactFragment> e;
  private Boolean f = null;
  private int g = 0;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private Handler k;
  
  public PhoneContactStatusCheckView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public PhoneContactStatusCheckView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public PhoneContactStatusCheckView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131624974, this);
    this.c = ((ImageView)findViewById(2131431257));
    this.d = ((ImageView)findViewById(2131437622));
    this.a = ((TextView)findViewById(2131431258));
    this.b = ((Button)findViewById(2131431256));
    this.b.setOnClickListener(this);
    this.k = new Handler(Looper.getMainLooper());
    c();
  }
  
  private void c()
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.1(this), 16, null, true);
  }
  
  public void a()
  {
    this.j = false;
    this.i = false;
    this.h = false;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.f = Boolean.valueOf(PermissionChecker.a().e());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(paramQQAppInterface, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  protected void a(IPhoneContactService paramIPhoneContactService)
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.3(this, paramIPhoneContactService), 16, null, false);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localObject == null)
    {
      QLog.e("PhoneContactStatusCheckView", 1, "checkPhoneStatus CONTACT_MANAGER get null.");
      return;
    }
    if (this.f == null) {
      this.f = Boolean.valueOf(PermissionChecker.a().d());
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)localObject).getSelfBindInfo();
    int n = ((IPhoneContactService)localObject).getSelfBindState();
    if (!this.f.booleanValue())
    {
      m = 4;
    }
    else
    {
      if (n >= 9) {
        if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.isStopFindMatch))
        {
          m = 3;
          break label194;
        }
      }
      label103:
      do
      {
        m = 0;
        break label194;
        if (n != 8) {
          break;
        }
      } while (!((IPhoneContactService)localObject).isBindNoneFriendListEmpty());
      for (;;)
      {
        m = 5;
        break label194;
        if (n == 7)
        {
          m = 2;
          break label194;
        }
        if ((n == 6) && (((IPhoneContactService)localObject).getSelfBindInfo().lastUsedFlag == 3L)) {
          break;
        }
        if (n == 2) {
          break label103;
        }
        if (n != 4) {
          break label192;
        }
        if (!((IPhoneContactService)localObject).isBindNoneFriendListEmpty()) {
          break label103;
        }
      }
      label192:
      m = 1;
    }
    label194:
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactStatusCheckView", 2, String.format("checkPhoneStatus [%s, %s, %s, %s]", new Object[] { Integer.valueOf(n), Integer.valueOf(m), this.f, localRespondQueryQQBindingStat }));
    }
    localObject = ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).getConfBean();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              if (m != 5)
              {
                setVisibility(8);
                b(false);
              }
              else
              {
                setVisibility(0);
                this.c.setVisibility(8);
                b(true);
                this.a.setText(HardCodeUtil.a(2131905809));
                this.b.setVisibility(8);
              }
            }
            else
            {
              setVisibility(0);
              this.c.setVisibility(0);
              b(false);
              this.a.setText(((NewFriendContactGuideConfBean)localObject).e.a);
              this.b.setText(((NewFriendContactGuideConfBean)localObject).e.c);
              this.b.setVisibility(0);
            }
          }
          else
          {
            setVisibility(0);
            this.c.setVisibility(0);
            b(false);
            this.a.setText(((NewFriendContactGuideConfBean)localObject).h.a);
            this.b.setText(((NewFriendContactGuideConfBean)localObject).h.c);
            this.b.setVisibility(0);
          }
        }
        else
        {
          setVisibility(0);
          this.c.setVisibility(0);
          b(false);
          this.a.setText(((NewFriendContactGuideConfBean)localObject).g.a);
          this.b.setText(((NewFriendContactGuideConfBean)localObject).g.c);
          this.b.setVisibility(0);
        }
      }
      else
      {
        setVisibility(0);
        this.c.setVisibility(0);
        b(false);
        this.a.setText(((NewFriendContactGuideConfBean)localObject).f.a);
        this.b.setText(((NewFriendContactGuideConfBean)localObject).f.c);
        this.b.setVisibility(0);
      }
    }
    else
    {
      setVisibility(8);
      b(false);
    }
    if (this.g != m) {
      this.g = m;
    }
    int m = this.g;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            return;
          }
          if (!this.i)
          {
            this.i = true;
            a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
          }
        }
        else if (!this.j)
        {
          this.j = true;
          a(paramQQAppInterface, "dc00898", "0X8009F23", 0);
        }
      }
      else if (!this.j)
      {
        this.j = true;
        a(paramQQAppInterface, "dc00898", "0X8009F25", 0);
      }
    }
    else if (!this.h)
    {
      this.h = true;
      a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      localDrawable = this.d.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).start();
      }
    }
    else
    {
      this.d.setVisibility(8);
      localDrawable = this.d.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).stop();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.e;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (PhoneContactFragment)((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      localObject = ((PhoneContactFragment)localObject).getBaseActivity();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((BaseActivity)localObject).app;
        if (localQQAppInterface != null)
        {
          IPhoneContactService localIPhoneContactService = (IPhoneContactService)localQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
          if (localIPhoneContactService == null)
          {
            QLog.i("PhoneContactStatusCheckView", 1, "onClick CONTACT_MANAGER is null");
          }
          else if (!NetworkUtil.isNetSupport(getContext()))
          {
            localObject = BaseApplicationImpl.getContext();
            QQToast.makeText((Context)localObject, 1, 2131892157, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299920));
          }
          else
          {
            int m = this.g;
            if (m != 1)
            {
              if (m != 2)
              {
                if (m != 3)
                {
                  if (m == 4) {
                    a(localQQAppInterface, "dc00898", "0X8009F22", 0);
                  }
                }
                else {
                  a(localQQAppInterface, "dc00898", "0X8009F24", 0);
                }
              }
              else {
                a(localQQAppInterface, "dc00898", "0X8009F26", 0);
              }
            }
            else {
              a(localQQAppInterface, "dc00898", "0X8009F22", 0);
            }
            m = localIPhoneContactService.getSelfBindState();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick phone contact state = ");
              localStringBuilder.append(m);
              localStringBuilder.append(", has = ");
              localStringBuilder.append(this.f);
              QLog.d("PhoneContactStatusCheckView", 2, localStringBuilder.toString());
            }
            if (!this.f.booleanValue()) {
              PermissionChecker.a((Activity)localObject, new PhoneContactStatusCheckView.2(this, localIPhoneContactService), new DenyRunnable((Context)localObject, new DenyRunnable.JumpSettingAction(localQQAppInterface)));
            } else {
              a(localIPhoneContactService);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setPhoneContactFragment(PhoneContactFragment paramPhoneContactFragment)
  {
    this.e = new WeakReference(paramPhoneContactFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView
 * JD-Core Version:    0.7.0.1
 */