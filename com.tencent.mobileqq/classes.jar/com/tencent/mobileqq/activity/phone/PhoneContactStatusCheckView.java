package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aimn;
import alud;
import alxr;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aoor;
import aoos;
import aozx;
import azqs;
import bdin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private WeakReference<PhoneContactFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
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
    LayoutInflater.from(getContext()).inflate(2131559174, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364713));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369767));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364714));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364712));
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
  
  protected void a(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    ThreadManager.excute(new PhoneContactStatusCheckView.3(this, paramPhoneContactManagerImp), 16, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((PhoneContactManagerImp)paramQQAppInterface.getManager(11)).k());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    azqs.b(paramQQAppInterface, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (localObject == null) {
      QLog.e("PhoneContactStatusCheckView", 1, "checkPhoneStatus CONTACT_MANAGER get null.");
    }
    label24:
    label69:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_JavaLangBoolean == null) {
            this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((PhoneContactManagerImp)localObject).i());
          }
          RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)localObject).a();
          int j = ((PhoneContactManagerImp)localObject).d();
          int i;
          if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
          {
            i = 4;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactStatusCheckView", 2, String.format("checkPhoneStatus [%s, %s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), this.jdField_a_of_type_JavaLangBoolean, localRespondQueryQQBindingStat }));
            }
            localObject = ((alxr)paramQQAppInterface.getManager(34)).a();
            switch (i)
            {
            default: 
              setVisibility(8);
              b(false);
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Int != i) {
              this.jdField_a_of_type_Int = i;
            }
            switch (this.jdField_a_of_type_Int)
            {
            default: 
              return;
            case 1: 
              if (this.jdField_a_of_type_Boolean) {
                break label24;
              }
              this.jdField_a_of_type_Boolean = true;
              a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
              return;
              if (j >= 9)
              {
                if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.isStopFindMatch))
                {
                  i = 3;
                  break label69;
                }
                i = 0;
                break label69;
              }
              if (j == 8)
              {
                if (((PhoneContactManagerImp)localObject).b())
                {
                  i = 5;
                  break label69;
                }
                i = 0;
                break label69;
              }
              if (j == 7)
              {
                i = 2;
                break label69;
              }
              if ((j == 6) && (((PhoneContactManagerImp)localObject).a().lastUsedFlag == 3L))
              {
                i = 3;
                break label69;
              }
              if (j == 2)
              {
                i = 0;
                break label69;
              }
              if (j == 4)
              {
                if (((PhoneContactManagerImp)localObject).b())
                {
                  i = 5;
                  break label69;
                }
                i = 0;
                break label69;
              }
              i = 1;
              break label69;
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              b(false);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((aoor)localObject).d.a);
              this.jdField_a_of_type_AndroidWidgetButton.setText(((aoor)localObject).d.c);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              continue;
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              b(false);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((aoor)localObject).c.a);
              this.jdField_a_of_type_AndroidWidgetButton.setText(((aoor)localObject).c.c);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              continue;
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              b(false);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((aoor)localObject).e.a);
              this.jdField_a_of_type_AndroidWidgetButton.setText(((aoor)localObject).e.c);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              continue;
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              b(false);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(((aoor)localObject).f.a);
              this.jdField_a_of_type_AndroidWidgetButton.setText(((aoor)localObject).f.c);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              continue;
              setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              b(true);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131708389));
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              setVisibility(8);
              b(false);
            }
          }
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = true;
        a(paramQQAppInterface, "dc00898", "0X8009F21", 0);
        return;
      } while (this.c);
      this.c = true;
      a(paramQQAppInterface, "dc00898", "0X8009F25", 0);
      return;
    } while (this.c);
    this.c = true;
    a(paramQQAppInterface, "dc00898", "0X8009F23", 0);
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
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(localDrawable instanceof AnimationDrawable));
    ((AnimationDrawable)localDrawable).stop();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      paramView = null;
      if (paramView != null) {
        break label28;
      }
    }
    label28:
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        paramView = (PhoneContactFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break;
        paramView = paramView.getActivity();
      } while (paramView == null);
      localQQAppInterface = paramView.app;
    } while (localQQAppInterface == null);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)localQQAppInterface.getManager(11);
    if (localPhoneContactManagerImp == null)
    {
      QLog.i("PhoneContactStatusCheckView", 1, "onClick CONTACT_MANAGER is null");
      return;
    }
    if (!bdin.d(getContext()))
    {
      paramView = BaseApplicationImpl.getContext();
      QQToast.a(paramView, 1, 2131694831, 0).b(paramView.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int i = localPhoneContactManagerImp.d();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactStatusCheckView", 2, "onClick phone contact state = " + i + ", has = " + this.jdField_a_of_type_JavaLangBoolean);
      }
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break;
      }
      aozx.a(paramView, localQQAppInterface, new PhoneContactStatusCheckView.2(this, localPhoneContactManagerImp), new DenyRunnable(paramView, new aimn(localQQAppInterface)));
      return;
      a(localQQAppInterface, "dc00898", "0X8009F22", 0);
      continue;
      a(localQQAppInterface, "dc00898", "0X8009F22", 0);
      continue;
      a(localQQAppInterface, "dc00898", "0X8009F26", 0);
      continue;
      a(localQQAppInterface, "dc00898", "0X8009F24", 0);
    }
    a(localPhoneContactManagerImp);
  }
  
  public void setPhoneContactFragment(PhoneContactFragment paramPhoneContactFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPhoneContactFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView
 * JD-Core Version:    0.7.0.1
 */