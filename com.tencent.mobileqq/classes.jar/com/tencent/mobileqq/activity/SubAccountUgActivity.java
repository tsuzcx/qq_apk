package com.tencent.mobileqq.activity;

import abtn;
import abtp;
import abtq;
import abtr;
import abts;
import aciy;
import ajjy;
import ajmm;
import ajss;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axal;
import axam;
import axat;
import babh;
import bacm;
import begr;
import behe;
import beog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
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
  ajmm jdField_a_of_type_Ajmm = new abtr(this);
  ajss jdField_a_of_type_Ajss = new abtn(this);
  public String a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abtq(this);
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  boolean c = false;
  
  public SubAccountUgActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(axam paramaxam, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramaxam == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (axam.a(this.app, paramString)))
      {
        c();
        paramString = paramaxam.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramaxam.a(this.app, this, localPair, new abtp(this, paramaxam, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = findViewById(2131310836);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (paramBoolean) {
        localView.setPadding(localView.getPaddingLeft(), aciy.a(260.0F, getResources()), localView.getPaddingRight(), localView.getPaddingBottom());
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
    View localView = findViewById(2131310836);
    TextView localTextView1 = (TextView)findViewById(2131310840);
    TextView localTextView2 = (TextView)findViewById(2131310841);
    ImageView localImageView = (ImageView)findViewById(2131310839);
    ((Button)findViewById(2131310837)).setText(2131654012);
    localView.setVisibility(8);
    localTextView1.setText(2131654024);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130849124);
  }
  
  void b()
  {
    StringBuilder localStringBuilder;
    if ((this.leftView != null) && (!this.c))
    {
      Object localObject = this.app.a();
      localStringBuilder = new StringBuilder(ajjy.a(2131648831)).append(getString(2131654133));
      if (localObject == null) {
        break label164;
      }
      int i = ((QQMessageFacade)localObject).b();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("subAccount");
    this.c = getIntent().getBooleanExtra("from_associated_activity", false);
    axat localaxat = (axat)this.app.getManager(61);
    this.jdField_a_of_type_Boolean = localaxat.a(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = false;
    paramBundle = axam.a(this.app, this.jdField_a_of_type_JavaLangString);
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
        axal.a(this.app, this, this.jdField_a_of_type_JavaLangString);
        finish();
        return false;
      }
      super.setContentView(2131496876);
      setTitle(2131653961);
      findViewById(2131309736).setOnClickListener(this);
      ImageView localImageView2 = (ImageView)findViewById(2131310838);
      ImageView localImageView1 = (ImageView)findViewById(2131310839);
      ((ThemeImageView)findViewById(2131310835)).setMaskShape(beog.c);
      TextView localTextView1 = (TextView)findViewById(2131310840);
      TextView localTextView2 = (TextView)findViewById(2131310841);
      Button localButton = (Button)findViewById(2131310837);
      View localView = findViewById(2131310836);
      Object localObject = this.app.a(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = bacm.a();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131101260));
      localTextView2.setVisibility(8);
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!bool2) {
          break label673;
        }
        paramBundle = localaxat.a(this.jdField_a_of_type_JavaLangString);
        if (paramBundle == null) {
          break label668;
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
          j = 2131654022;
        }
        localTextView1.setTextColor(getResources().getColor(2131101260));
        paramBundle = this.app.a(this.jdField_a_of_type_JavaLangString, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = babh.c(this.app, this.jdField_a_of_type_JavaLangString, true);
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
        if (j == 2131654022)
        {
          localTextView2.setVisibility(0);
          label496:
          localButton.setText(2131654011);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131310830)).setOnClickListener(this);
          ((Button)localView.findViewById(2131310829)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.jdField_a_of_type_Ajss);
          addObserver(this.jdField_a_of_type_Ajmm);
          b();
          this.app.a().addObserver(this);
          this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          if (isInMultiWindow()) {
            a(true);
          }
          return true;
          i = 2131654017;
          break;
          i = 2131654018;
          break;
          i = 2131654015;
          break;
          i = 2131654017;
          break;
          i = 2131654017;
          break;
          i = 2131654022;
          break;
          localTextView2.setVisibility(8);
          break label496;
          localImageView1.setImageResource(2130849124);
        }
        label668:
        i = 0;
        break;
        label673:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajss);
    removeObserver(this.jdField_a_of_type_Ajmm);
    this.app.removeHandler(getClass());
    this.app.a().deleteObserver(this);
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
    default: 
      return;
    case 2131310837: 
      localObject = new Intent();
      if (this.jdField_a_of_type_Boolean)
      {
        ((Intent)localObject).putExtra("is_need_bind", false);
        ((Intent)localObject).putExtra("subuin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).setClass(this, SubLoginActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.b);
        startActivity((Intent)localObject);
        return;
      }
      ((Intent)localObject).setClass(paramView.getContext(), SubAccountBindActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.b);
      startActivity((Intent)localObject);
      return;
    case 2131310830: 
      paramView = (begr)behe.a(getActivity(), null);
      paramView.a(2131654013);
      paramView.a(getResources().getString(2131654727), 3);
      paramView.c(2131625035);
      paramView.a(new abts(this, paramView));
      paramView.show();
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject });
    }
    localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("reqType", 3);
    ((Intent)localObject).putExtra("url", paramView);
    startActivity((Intent)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */