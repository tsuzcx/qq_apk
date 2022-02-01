package com.tencent.mobileqq.activity;

import Override;
import aezi;
import aezk;
import aezl;
import aezm;
import aezn;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import anyz;
import aoef;
import bdxi;
import bdxj;
import bdxs;
import bheg;
import bkzi;
import bkzz;
import blfw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  anyz jdField_a_of_type_Anyz = new aezm(this);
  aoef jdField_a_of_type_Aoef = new aezi(this);
  public String a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aezl(this);
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  boolean c = false;
  
  public SubAccountUgActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(bdxj parambdxj, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((parambdxj == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (bdxj.a(this.app, paramString)))
      {
        e();
        paramString = parambdxj.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          parambdxj.a(this.app, this, localPair, new aezk(this, parambdxj, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = findViewById(2131378234);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (paramBoolean) {
        localView.setPadding(localView.getPaddingLeft(), AIOUtils.dp2px(260.0F, getResources()), localView.getPaddingRight(), localView.getPaddingBottom());
      }
    }
    else
    {
      return;
    }
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    View localView = findViewById(2131378234);
    TextView localTextView1 = (TextView)findViewById(2131378238);
    TextView localTextView2 = (TextView)findViewById(2131378239);
    ImageView localImageView = (ImageView)findViewById(2131378237);
    ((Button)findViewById(2131378235)).setText(2131719081);
    localView.setVisibility(8);
    localTextView1.setText(2131719089);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130850511);
  }
  
  void b()
  {
    StringBuilder localStringBuilder;
    if ((this.leftView != null) && (!this.c))
    {
      Object localObject = this.app.getMessageFacade();
      localStringBuilder = new StringBuilder(anvx.a(2131714004)).append(getString(2131719161));
      if (localObject == null) {
        break label164;
      }
      int i = ((QQMessageFacade)localObject).getUnreadMsgsNum();
      if (i <= 0) {
        break label143;
      }
      localObject = Integer.toString(i);
      if (i > 99) {
        localObject = "99+";
      }
      this.leftView.setText("");
      this.mLeftBackIcon.setVisibility(4);
      this.mLeftBackText.setVisibility(0);
      this.mLeftBackText.setText((CharSequence)localObject);
      this.leftView.setContentDescription("");
      this.leftView.bringToFront();
      localStringBuilder.append(i).append("条未读");
    }
    for (;;)
    {
      this.leftView.setContentDescription(localStringBuilder.toString());
      return;
      label143:
      this.leftView.setText("");
      this.mLeftBackText.setVisibility(8);
      continue;
      label164:
      this.leftView.setText("");
      this.mLeftBackText.setVisibility(8);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("subAccount");
    this.c = getIntent().getBooleanExtra("from_associated_activity", false);
    bdxs localbdxs = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    this.jdField_a_of_type_Boolean = localbdxs.a(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = false;
    paramBundle = bdxj.a(this.app, this.jdField_a_of_type_JavaLangString);
    boolean bool2;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    for (;;)
    {
      if (bool1)
      {
        bdxi.a(this.app, this, this.jdField_a_of_type_JavaLangString);
        finish();
        return false;
      }
      super.setContentView(2131562920);
      setTitle(2131719045);
      findViewById(2131376947).setOnClickListener(this);
      ImageView localImageView2 = (ImageView)findViewById(2131378236);
      ImageView localImageView1 = (ImageView)findViewById(2131378237);
      ((ThemeImageView)findViewById(2131378233)).setMaskShape(blfw.c);
      TextView localTextView1 = (TextView)findViewById(2131378238);
      TextView localTextView2 = (TextView)findViewById(2131378239);
      Button localButton = (Button)findViewById(2131378235);
      View localView = findViewById(2131378234);
      Object localObject = this.app.getFaceBitmap(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = bheg.a();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131167026));
      localTextView2.setVisibility(8);
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!bool2) {
          break label677;
        }
        paramBundle = localbdxs.a(this.jdField_a_of_type_JavaLangString);
        if (paramBundle == null) {
          break label672;
        }
        i = ((Integer)paramBundle.first).intValue();
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        int j = i;
        if (i == 0) {
          j = 2131719087;
        }
        localTextView1.setTextColor(getResources().getColor(2131167026));
        paramBundle = this.app.getFaceBitmap(this.jdField_a_of_type_JavaLangString, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = ContactUtils.getBuddyNickName(this.app, this.jdField_a_of_type_JavaLangString, true);
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
        }
        localTextView1.setText(getString(j, new Object[] { paramBundle }));
        if (j == 2131719087)
        {
          localTextView2.setVisibility(0);
          label500:
          localButton.setText(2131719080);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131378228)).setOnClickListener(this);
          ((Button)localView.findViewById(2131378227)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.jdField_a_of_type_Aoef);
          addObserver(this.jdField_a_of_type_Anyz);
          b();
          this.app.getMessageFacade().addObserver(this);
          this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          if (isInMultiWindow()) {
            a(true);
          }
          return true;
          i = 2131719084;
          break;
          i = 2131719085;
          break;
          i = 2131719083;
          break;
          i = 2131719084;
          break;
          i = 2131719084;
          break;
          i = 2131719087;
          break;
          localTextView2.setVisibility(8);
          break label500;
          localImageView1.setImageResource(2130850511);
        }
        label672:
        i = 0;
        break;
        label677:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Aoef);
    removeObserver(this.jdField_a_of_type_Anyz);
    this.app.removeHandler(getClass());
    this.app.getMessageFacade().deleteObserver(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = new Intent();
      if (this.jdField_a_of_type_Boolean)
      {
        ((Intent)localObject1).putExtra("is_need_bind", false);
        ((Intent)localObject1).putExtra("subuin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).setClass(this, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.b);
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).setClass(paramView.getContext(), SubAccountBindActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.b);
        startActivity((Intent)localObject1);
        continue;
        localObject1 = (bkzi)bkzz.a(getActivity(), null);
        ((bkzi)localObject1).a(2131719082);
        ((bkzi)localObject1).a(getResources().getString(2131719779), 3);
        ((bkzi)localObject1).c(2131690697);
        ((bkzi)localObject1).a(new aezn(this, (bkzi)localObject1));
        ((bkzi)localObject1).show();
        continue;
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject1 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject2 });
        }
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("reqType", 3);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    a(paramBoolean);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new SubAccountUgActivity.6(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */