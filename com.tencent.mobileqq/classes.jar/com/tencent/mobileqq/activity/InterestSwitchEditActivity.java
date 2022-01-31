package com.tencent.mobileqq.activity;

import aazn;
import ajfi;
import ajfo;
import ajjj;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anoe;
import awqx;
import badq;
import bbma;
import bbmy;
import bbne;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private ajfi jdField_a_of_type_Ajfi;
  private ajfo jdField_a_of_type_Ajfo = new aazn(this);
  private View jdField_a_of_type_AndroidViewView;
  private bbma jdField_a_of_type_Bbma;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, InterestSwitchEditActivity.class);
    paramContext.putExtra("param_notfromprofile", false);
    return paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    label36:
    label55:
    label91:
    do
    {
      break label91;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) {
          break label136;
        }
        this.c.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp != 0) {
          break label157;
        }
        this.d.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) {
          break label179;
        }
        this.e.setChecked(true);
        return;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
          break label36;
        }
        this.b.setChecked(false);
        break label36;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present != 0) {
          break label55;
        }
        this.c.setChecked(false);
        break label55;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp) {
          this.d.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox);
    label136:
    label157:
    label179:
    this.e.setChecked(false);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!badq.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    ((ajfi)this.app.a(2)).a(paramBundle);
    return true;
  }
  
  private void b()
  {
    Card localCard = ((ajjj)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    Object localObject;
    if (localCard != null)
    {
      localObject = (anoe)this.app.getManager(264);
      if ((localCard.extendFriendEntryAddFriend == 1) && (((anoe)localObject).b()))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.g.setChecked(localCard.isShowCard);
      }
      if (localCard.switch_disable_personality_label != -1)
      {
        localObject = this.f;
        if (localCard.switch_disable_personality_label == 1) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    new bbne(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = 8;
    super.doOnCreate(paramBundle);
    super.setContentView(2131495396);
    this.app.addObserver(this.jdField_a_of_type_Ajfo);
    setTitle(getString(2131629727));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302608));
    this.b = ((FormSwitchItem)findViewById(2131304897));
    this.c = ((FormSwitchItem)findViewById(2131306196));
    this.f = ((FormSwitchItem)findViewById(2131305707));
    this.f.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300200);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.g = ((FormSwitchItem)findViewById(2131300199));
    this.g.setOnCheckedChangeListener(this);
    this.d = ((FormSwitchItem)findViewById(2131304639));
    this.e = ((FormSwitchItem)findViewById(2131300205));
    this.e.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_Bbma = new bbma(this.app, null);
    boolean bool = this.jdField_a_of_type_Bbma.a(3);
    paramBundle = this.f;
    int i;
    label235:
    int n;
    label262:
    label290:
    int i1;
    int i2;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bbma.a(5);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool) {
        break label562;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bbma.a(4);
      paramBundle = this.b;
      if (!bool) {
        break label568;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bbma.a(6);
      paramBundle = this.c;
      if (!bool) {
        break label574;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bbma.a(7);
      paramBundle = this.d;
      i = j;
      if (bool) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      i = getIntent().getIntExtra("param_interest_switch", -1);
      j = getIntent().getIntExtra("param_music_switch", -1);
      int k = getIntent().getIntExtra("param_extendfriend_switch", -1);
      int m = getIntent().getIntExtra("param_personlabel_switch_changed", -1);
      n = getIntent().getIntExtra("param_present_switch", -1);
      i1 = getIntent().getIntExtra("param_miniapp_switch", -1);
      i2 = getIntent().getIntExtra("param_musicbox_switch", -1);
      if ((-1 == i) && (-1 == j) && (-1 == k) && (-1 == m) && (-1 == n) && (-1 == i1) && (-1 == i2)) {
        break label635;
      }
    }
    label562:
    label568:
    label574:
    label635:
    for (bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)j);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present = ((short)n);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp = ((short)i1);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox = ((short)i2);
        a();
        b();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InterestSwitchEditActivity", 2, "hasSwitchState=" + bool);
        }
        return true;
        i = 8;
        break;
        i = 8;
        break label235;
        i = 8;
        break label262;
        i = 8;
        break label290;
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(BaseApplicationImpl.sApplication, 2131628946, 0).b(getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Ajfi = ((ajfi)this.app.a(2));
          this.jdField_a_of_type_Ajfi.g();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bbma != null)
    {
      this.jdField_a_of_type_Bbma.a();
      this.jdField_a_of_type_Bbma = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Ajfo);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label549;
      }
      i = 0;
      localIntent.putExtra("param_interest_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest))
      {
        localIntent.putExtra("param_interest_switch_changed", true);
        localBundle.putShort("key_interest_switch", (short)i);
      }
      if (!this.b.a()) {
        break label554;
      }
      i = 0;
      label95:
      localIntent.putExtra("param_music_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music))
      {
        localIntent.putExtra("param_music_switch_changed", true);
        localBundle.putShort("key_music_switch", (short)i);
      }
      if (!this.c.a()) {
        break label559;
      }
      i = 1;
      label155:
      localIntent.putExtra("param_present_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present))
      {
        localIntent.putExtra("param_present_switch_changed", true);
        localBundle.putShort("key_present_switch", (short)i);
      }
      if (!this.d.a()) {
        break label564;
      }
      i = 0;
      label215:
      localIntent.putExtra("param_miniapp_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_miniapp_playing_switch", (short)i);
      }
      if (!this.e.a()) {
        break label569;
      }
      i = 0;
      label274:
      localIntent.putExtra("param_musicbox_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_musicbox_switch", (short)i);
        if (!this.e.a()) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
      }
    }
    Card localCard = ((ajjj)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      if (!this.g.a()) {
        break label574;
      }
      i = 0;
      label378:
      localIntent.putExtra("param_extendfriend_switch", i);
      if (this.g.a() != localCard.isShowCard)
      {
        localIntent.putExtra("param_extendfriend_switch_changed", true);
        localBundle.putShort("key_extend_friend_switch", (short)i);
        localCard.isShowCard = this.g.a();
      }
      if (!this.f.a()) {
        break label579;
      }
    }
    label549:
    label554:
    label559:
    label564:
    label569:
    label574:
    label579:
    for (int i = 0;; i = 1)
    {
      localIntent.putExtra("param_personlabel_switch", i);
      if ((i != localCard.switch_disable_personality_label) && (-1 != localCard.switch_disable_personality_label))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_personality_label_switch", (short)i);
      }
      QLog.i("InterestSwitchEditActivity", 1, "setDetailUserInfo,hasSyncToServer+" + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean)
      {
        a(localBundle, 2131628948, 0);
        this.jdField_a_of_type_Boolean = true;
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      i = 1;
      break;
      i = 1;
      break label95;
      i = 0;
      break label155;
      i = 1;
      break label215;
      i = 1;
      break label274;
      i = 1;
      break label378;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.g.a()) {
      if (paramBoolean) {
        awqx.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      awqx.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
      if (paramCompoundButton == this.f.a())
      {
        paramCompoundButton = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          awqx.b(paramCompoundButton, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
          return;
        }
      }
    } while (paramCompoundButton != this.e.a());
    paramCompoundButton = this.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(paramCompoundButton, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */