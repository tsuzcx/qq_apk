package com.tencent.mobileqq.activity;

import adev;
import alpk;
import alpq;
import alto;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import aqbg;
import azqs;
import bdin;
import betg;
import beuj;
import bjho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Locale;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private alpk jdField_a_of_type_Alpk;
  private alpq jdField_a_of_type_Alpq = new adev(this);
  private View jdField_a_of_type_AndroidViewView;
  private betg jdField_a_of_type_Betg;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  
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
    label54:
    label73:
    label91:
    label109:
    label255:
    do
    {
      break label145;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label != 0) {
          break label190;
        }
        this.c.setChecked(true);
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) {
          break label212;
        }
        this.d.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp != 0) {
          break label233;
        }
        this.e.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) {
          break label255;
        }
        this.f.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note != 0) {
          break label277;
        }
        this.g.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle != 0) {
          break label299;
        }
        this.h.setChecked(true);
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
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label) {
          break label54;
        }
        this.c.setChecked(false);
        break label54;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present != 0) {
          break label73;
        }
        this.d.setChecked(false);
        break label73;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp) {
          break label91;
        }
        this.e.setChecked(false);
        break label91;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox) {
          break label109;
        }
        this.f.setChecked(false);
        break label109;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note) {
          this.g.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle);
    label145:
    label190:
    label212:
    label233:
    this.h.setChecked(false);
    label277:
    label299:
    return;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new beuj(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!bdin.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InterestSwitchEditActivity", 2, String.format("setDetailUserInfo bundle=%s", new Object[] { paramBundle }));
    }
    ((alpk)this.app.a(2)).a(paramBundle);
    return true;
  }
  
  private void b()
  {
    Card localCard = ((alto)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      aqbg localaqbg = (aqbg)this.app.getManager(264);
      if ((localCard.extendFriendEntryAddFriend == 1) && (localaqbg.c()))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.i.setChecked(localCard.isShowCard);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    this.c.setOnCheckedChangeListener(this);
    this.d.setOnCheckedChangeListener(this);
    this.e.setOnCheckedChangeListener(this);
    this.f.setOnCheckedChangeListener(this);
    this.g.setOnCheckedChangeListener(this);
    this.i.setOnCheckedChangeListener(this);
    this.h.setOnCheckedChangeListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561174);
    this.app.addObserver(this.jdField_a_of_type_Alpq);
    setTitle(getString(2131695569));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131368387));
    this.b = ((FormSwitchItem)findViewById(2131370886));
    this.c = ((FormSwitchItem)findViewById(2131371739));
    this.d = ((FormSwitchItem)findViewById(2131372232));
    this.e = ((FormSwitchItem)findViewById(2131370624));
    this.f = ((FormSwitchItem)findViewById(2131370915));
    this.g = ((FormSwitchItem)findViewById(2131377066));
    this.h = ((FormSwitchItem)findViewById(2131373645));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365887);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.i = ((FormSwitchItem)findViewById(2131365886));
    this.jdField_a_of_type_Betg = new betg(this.app, null);
    boolean bool = this.jdField_a_of_type_Betg.a(5);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    int j;
    label234:
    label378:
    int k;
    label261:
    label289:
    label317:
    label342:
    label353:
    int m;
    label389:
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    if (bool)
    {
      j = 0;
      paramBundle.setVisibility(j);
      bool = this.jdField_a_of_type_Betg.a(4);
      paramBundle = this.b;
      if (!bool) {
        break label798;
      }
      j = 0;
      paramBundle.setVisibility(j);
      bool = this.jdField_a_of_type_Betg.a(3);
      paramBundle = this.c;
      if (!bool) {
        break label804;
      }
      j = 0;
      paramBundle.setVisibility(j);
      bool = this.jdField_a_of_type_Betg.a(6);
      paramBundle = this.d;
      if (!bool) {
        break label810;
      }
      j = 0;
      paramBundle.setVisibility(j);
      bool = this.jdField_a_of_type_Betg.a(7);
      paramBundle = this.e;
      if (!bool) {
        break label816;
      }
      j = 0;
      paramBundle.setVisibility(j);
      if ((!this.jdField_a_of_type_Betg.a(8)) || (!bjho.b())) {
        break label822;
      }
      j = 1;
      paramBundle = this.g;
      if (j == 0) {
        break label827;
      }
      j = 0;
      paramBundle.setVisibility(j);
      if ((!this.jdField_a_of_type_Betg.a(9)) || (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
        break label833;
      }
      j = 1;
      paramBundle = this.h;
      if (j == 0) {
        break label838;
      }
      j = 0;
      paramBundle.setVisibility(j);
      j = getIntent().getIntExtra("param_interest_switch", -1);
      k = getIntent().getIntExtra("param_music_switch", -1);
      m = getIntent().getIntExtra("param_personlabel_switch", -1);
      n = getIntent().getIntExtra("param_present_switch", -1);
      i1 = getIntent().getIntExtra("param_miniapp_switch", -1);
      i2 = getIntent().getIntExtra("param_musicbox_switch", -1);
      i3 = getIntent().getIntExtra("param_sticky_note_switch", -1);
      i4 = getIntent().getIntExtra("param_qqcircle_switch", -1);
      int i5 = getIntent().getIntExtra("param_extendfriend_switch", -1);
      if ((-1 == j) && (-1 == k) && (-1 == m) && (-1 == n) && (-1 == i1) && (-1 == i2) && (-1 == i3) && (-1 == i4) && (-1 == i5)) {
        break label899;
      }
      if (QLog.isColorLevel()) {
        QLog.d("InterestSwitchEditActivity", 2, String.format(Locale.getDefault(), "doOnCreate switch_interest=%s switch_music=%s switch_personality_label=%s switch_present=%s switch_miniapp=%s switch_musicbox=%s switch_sticky_note=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
      }
    }
    label899:
    for (bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)j);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)k);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label = ((short)m);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present = ((short)n);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp = ((short)i1);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox = ((short)i2);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note = ((short)i3);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle = ((short)i4);
        a();
        b();
        c();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate hasSwitchState=%s", new Object[] { Boolean.valueOf(bool) }));
        }
        return true;
        j = 8;
        break;
        label798:
        j = 8;
        break label234;
        label804:
        j = 8;
        break label261;
        label810:
        j = 8;
        break label289;
        label816:
        j = 8;
        break label317;
        label822:
        j = 0;
        break label342;
        label827:
        j = 8;
        break label353;
        label833:
        j = 0;
        break label378;
        label838:
        j = 8;
        break label389;
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplicationImpl.sApplication, 2131694766, 0).b(getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Alpk = ((alpk)this.app.a(2));
          this.jdField_a_of_type_Alpk.g();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Betg != null)
    {
      this.jdField_a_of_type_Betg.a();
      this.jdField_a_of_type_Betg = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Alpq);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    label96:
    Card localCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label655;
      }
      j = 0;
      localIntent.putExtra("param_interest_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest))
      {
        localIntent.putExtra("param_interest_switch_changed", true);
        localBundle.putShort("key_interest_switch", (short)j);
      }
      if (!this.b.a()) {
        break label660;
      }
      j = 0;
      localIntent.putExtra("param_music_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music))
      {
        localIntent.putExtra("param_music_switch_changed", true);
        localBundle.putShort("key_music_switch", (short)j);
      }
      if (!this.c.a()) {
        break label665;
      }
      j = 0;
      label157:
      localIntent.putExtra("param_personlabel_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_personality_label_switch", (short)j);
      }
      if (!this.d.a()) {
        break label670;
      }
      j = 1;
      label218:
      localIntent.putExtra("param_present_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present))
      {
        localIntent.putExtra("param_present_switch_changed", true);
        localBundle.putShort("key_present_switch", (short)j);
      }
      if (!this.e.a()) {
        break label675;
      }
      j = 0;
      label279:
      localIntent.putExtra("param_miniapp_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp))
      {
        localIntent.putExtra("param_miniapp_switch_changed", true);
        localBundle.putShort("key_miniapp_playing_switch", (short)j);
      }
      if (!this.f.a()) {
        break label680;
      }
      j = 0;
      label340:
      localIntent.putExtra("param_musicbox_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox))
      {
        localIntent.putExtra("param_musicbox_switch_changed", true);
        localBundle.putShort("key_musicbox_switch", (short)j);
        if (!this.f.a()) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
      }
      if (!this.g.a()) {
        break label685;
      }
      j = 0;
      label417:
      localIntent.putExtra("param_sticky_note_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note))
      {
        localIntent.putExtra("param_sticky_note_switch_changed", true);
        localBundle.putShort("key_sticky_note_switch", (short)j);
      }
      if (!this.h.a()) {
        break label690;
      }
      j = 0;
      label478:
      localIntent.putExtra("param_qqcircle_switch", j);
      if ((j != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle))
      {
        localIntent.putExtra("param_qqcircle_switch_changed", true);
        localBundle.putShort("key_qqcircle_switch", (short)j);
      }
      localCard = ((alto)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localCard != null) {
        if (!this.i.a()) {
          break label695;
        }
      }
    }
    label655:
    label660:
    label665:
    label670:
    label675:
    label680:
    label685:
    label690:
    label695:
    for (int j = 0;; j = 1)
    {
      localIntent.putExtra("param_extendfriend_switch", j);
      if (this.i.a() != localCard.isShowCard)
      {
        localIntent.putExtra("param_extendfriend_switch_changed", true);
        localBundle.putShort("key_extend_friend_switch", (short)j);
        localCard.isShowCard = this.i.a();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        a(localBundle, 2131694768, 0);
        this.jdField_a_of_type_Boolean = true;
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      j = 1;
      break;
      j = 1;
      break label96;
      j = 1;
      break label157;
      j = 0;
      break label218;
      j = 1;
      break label279;
      j = 1;
      break label340;
      j = 1;
      break label417;
      j = 1;
      break label478;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.i.a()) {
      if (paramBoolean) {
        azqs.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      azqs.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
      int j;
      if (paramCompoundButton == this.c.a())
      {
        paramCompoundButton = this.app;
        if (paramBoolean) {}
        for (j = 1;; j = 2)
        {
          azqs.b(paramCompoundButton, "dc00898", "", "", "0X8008407", "0X8008407", j, 0, "", "", "", "");
          return;
        }
      }
      if (paramCompoundButton == this.f.a())
      {
        paramCompoundButton = this.app;
        if (paramBoolean) {}
        for (j = 1;; j = 2)
        {
          azqs.b(paramCompoundButton, "dc00898", "", "", "0X800A7DA", "qq_vip", j, 0, "", "", "", "");
          return;
        }
      }
    } while (paramCompoundButton != this.g.a());
    azqs.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */