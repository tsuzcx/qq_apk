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
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Boolean jdField_a_of_type_JavaLangBoolean = null;
  private WeakReference<PhoneContactFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
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
    LayoutInflater.from(getContext()).inflate(2131559217, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365110));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370360));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365111));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365109));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    c();
  }
  
  private void c()
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.1(this), 16, null, true);
  }
  
  public void a()
  {
    this.c = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(PermissionChecker.a().c());
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
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(PermissionChecker.a().b());
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)localObject).getSelfBindInfo();
    int j = ((IPhoneContactService)localObject).getSelfBindState();
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      i = 4;
    }
    else
    {
      if (j >= 9) {
        if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.isStopFindMatch))
        {
          i = 3;
          break label194;
        }
      }
      label103:
      do
      {
        i = 0;
        break label194;
        if (j != 8) {
          break;
        }
      } while (!((IPhoneContactService)localObject).isBindNoneFriendListEmpty());
      for (;;)
      {
        i = 5;
        break label194;
        if (j == 7)
        {
          i = 2;
          break label194;
        }
        if ((j == 6) && (((IPhoneContactService)localObject).getSelfBindInfo().lastUsedFlag == 3L)) {
          break;
        }
        if (j == 2) {
          break label103;
        }
        if (j != 4) {
          break label192;
        }
        if (!((IPhoneContactService)localObject).isBindNoneFriendListEmpty()) {
          break label103;
        }
      }
      label192:
      i = 1;
    }
    label194:
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactStatusCheckView", 2, String.format("checkPhoneStatus [%s, %s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), this.jdField_a_of_type_JavaLangBoolean, localRespondQueryQQBindingStat }));
    }
    localObject = ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).getConfBean();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                setVisibility(8);
                b(false);
              }
              else
              {
                setVisibility(0);
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                b(true);
                this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131708000));
                this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              }
            }
            else
            {
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              b(false);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendContactGuideConfBean)localObject).c.a);
              this.jdField_a_of_type_AndroidWidgetButton.setText(((NewFriendContactGuideConfBean)localObject).c.c);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            }
          }
          else
          {
            setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            b(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendContactGuideConfBean)localObject).f.a);
            this.jdField_a_of_type_AndroidWidgetButton.setText(((NewFriendContactGuideConfBean)localObject).f.c);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          }
        }
        else
        {
          setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          b(false);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendContactGuideConfBean)localObject).e.a);
          this.jdField_a_of_type_AndroidWidgetButton.setText(((NewFriendContactGuideConfBean)localObject).e.c);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
      }
      else
      {
        setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        b(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendContactGuideConfBean)localObject).d.a);
        this.jdField_a_of_type_AndroidWidgetButton.setText(((NewFriendContactGuideConfBean)localObject).d.c);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    else
    {
      setVisibility(8);
      b(false);
    }
    if (this.jdField_a_of_type_Int != i) {
      this.jdField_a_of_type_Int = i;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
          }
        }
        else if (!this.c)
        {
          this.c = true;
          a(paramQQAppInterface, "dc00898", "0X8009F23", 0);
        }
      }
      else if (!this.c)
      {
        this.c = true;
        a(paramQQAppInterface, "dc00898", "0X8009F25", 0);
      }
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).start();
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable instanceof AnimationDrawable)) {
        ((AnimationDrawable)localDrawable).stop();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
            QQToast.a((Context)localObject, 1, 2131694475, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299168));
          }
          else
          {
            int i = this.jdField_a_of_type_Int;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
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
            i = localIPhoneContactService.getSelfBindState();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onClick phone contact state = ");
              localStringBuilder.append(i);
              localStringBuilder.append(", has = ");
              localStringBuilder.append(this.jdField_a_of_type_JavaLangBoolean);
              QLog.d("PhoneContactStatusCheckView", 2, localStringBuilder.toString());
            }
            if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPhoneContactFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView
 * JD-Core Version:    0.7.0.1
 */