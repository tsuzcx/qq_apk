package com.tencent.mobileqq.activity;

import abjg;
import ajti;
import ajto;
import ajxl;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import aoeu;
import axqy;
import bbfj;
import bcpn;
import bcql;
import bcqr;
import bhby;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private ajti jdField_a_of_type_Ajti;
  private ajto jdField_a_of_type_Ajto = new abjg(this);
  private View jdField_a_of_type_AndroidViewView;
  private bcpn jdField_a_of_type_Bcpn;
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
    label127:
    do
    {
      break label127;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label != 0) {
          break label172;
        }
        this.c.setChecked(true);
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) {
          break label194;
        }
        this.d.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp != 0) {
          break label215;
        }
        this.e.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) {
          break label237;
        }
        this.f.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note != 0) {
          break label259;
        }
        this.g.setChecked(true);
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
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox) {
          this.f.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note);
    label172:
    label194:
    label215:
    label237:
    this.g.setChecked(false);
    label259:
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bcqr(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!bbfj.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InterestSwitchEditActivity", 2, String.format("setDetailUserInfo bundle=%s", new Object[] { paramBundle }));
    }
    ((ajti)this.app.a(2)).a(paramBundle);
    return true;
  }
  
  private void b()
  {
    Card localCard = ((ajxl)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      aoeu localaoeu = (aoeu)this.app.getManager(264);
      if ((localCard.extendFriendEntryAddFriend == 1) && (localaoeu.b()))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.h.setChecked(localCard.isShowCard);
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
    this.h.setOnCheckedChangeListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560973);
    this.app.addObserver(this.jdField_a_of_type_Ajto);
    setTitle(getString(2131695409));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131368230));
    this.b = ((FormSwitchItem)findViewById(2131370562));
    this.c = ((FormSwitchItem)findViewById(2131371403));
    this.d = ((FormSwitchItem)findViewById(2131371893));
    this.e = ((FormSwitchItem)findViewById(2131370307));
    this.f = ((FormSwitchItem)findViewById(2131370591));
    this.g = ((FormSwitchItem)findViewById(2131376512));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365798);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.h = ((FormSwitchItem)findViewById(2131365797));
    this.jdField_a_of_type_Bcpn = new bcpn(this.app, null);
    boolean bool = this.jdField_a_of_type_Bcpn.a(5);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    int i;
    label221:
    label248:
    int j;
    label276:
    label304:
    label329:
    label340:
    int k;
    int m;
    int n;
    int i1;
    int i2;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bcpn.a(4);
      paramBundle = this.b;
      if (!bool) {
        break label710;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bcpn.a(3);
      paramBundle = this.c;
      if (!bool) {
        break label716;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bcpn.a(6);
      paramBundle = this.d;
      if (!bool) {
        break label722;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_a_of_type_Bcpn.a(7);
      paramBundle = this.e;
      if (!bool) {
        break label728;
      }
      i = 0;
      paramBundle.setVisibility(i);
      if ((!this.jdField_a_of_type_Bcpn.a(8)) || (!bhby.a())) {
        break label734;
      }
      i = 1;
      paramBundle = this.g;
      if (i == 0) {
        break label739;
      }
      i = 0;
      paramBundle.setVisibility(i);
      i = getIntent().getIntExtra("param_interest_switch", -1);
      j = getIntent().getIntExtra("param_music_switch", -1);
      k = getIntent().getIntExtra("param_personlabel_switch", -1);
      m = getIntent().getIntExtra("param_present_switch", -1);
      n = getIntent().getIntExtra("param_miniapp_switch", -1);
      i1 = getIntent().getIntExtra("param_musicbox_switch", -1);
      i2 = getIntent().getIntExtra("param_sticky_note_switch", -1);
      int i3 = getIntent().getIntExtra("param_extendfriend_switch", -1);
      if ((-1 == i) && (-1 == j) && (-1 == k) && (-1 == m) && (-1 == n) && (-1 == i1) && (-1 == i2) && (-1 == i3)) {
        break label800;
      }
      if (QLog.isColorLevel()) {
        QLog.d("InterestSwitchEditActivity", 2, String.format(Locale.getDefault(), "doOnCreate switch_interest=%s switch_music=%s switch_personality_label=%s switch_present=%s switch_miniapp=%s switch_musicbox=%s switch_sticky_note=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2) }));
      }
    }
    label800:
    for (bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)j);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label = ((short)k);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present = ((short)m);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp = ((short)n);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox = ((short)i1);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note = ((short)i2);
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
        i = 8;
        break;
        label710:
        i = 8;
        break label221;
        label716:
        i = 8;
        break label248;
        label722:
        i = 8;
        break label276;
        label728:
        i = 8;
        break label304;
        label734:
        i = 0;
        break label329;
        label739:
        i = 8;
        break label340;
        if (!bbfj.d(BaseApplication.getContext()))
        {
          bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).b(getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_Ajti = ((ajti)this.app.a(2));
          this.jdField_a_of_type_Ajti.g();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bcpn != null)
    {
      this.jdField_a_of_type_Bcpn.a();
      this.jdField_a_of_type_Bcpn = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Ajto);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    label95:
    Card localCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label593;
      }
      i = 0;
      localIntent.putExtra("param_interest_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest))
      {
        localIntent.putExtra("param_interest_switch_changed", true);
        localBundle.putShort("key_interest_switch", (short)i);
      }
      if (!this.b.a()) {
        break label598;
      }
      i = 0;
      localIntent.putExtra("param_music_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music))
      {
        localIntent.putExtra("param_music_switch_changed", true);
        localBundle.putShort("key_music_switch", (short)i);
      }
      if (!this.c.a()) {
        break label603;
      }
      i = 0;
      label156:
      localIntent.putExtra("param_personlabel_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_personality_label_switch", (short)i);
      }
      if (!this.d.a()) {
        break label608;
      }
      i = 1;
      label217:
      localIntent.putExtra("param_present_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_present))
      {
        localIntent.putExtra("param_present_switch_changed", true);
        localBundle.putShort("key_present_switch", (short)i);
      }
      if (!this.e.a()) {
        break label613;
      }
      i = 0;
      label278:
      localIntent.putExtra("param_miniapp_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_miniapp))
      {
        localIntent.putExtra("param_miniapp_switch_changed", true);
        localBundle.putShort("key_miniapp_playing_switch", (short)i);
      }
      if (!this.f.a()) {
        break label618;
      }
      i = 0;
      label339:
      localIntent.putExtra("param_musicbox_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox))
      {
        localIntent.putExtra("param_musicbox_switch_changed", true);
        localBundle.putShort("key_musicbox_switch", (short)i);
        if (!this.f.a()) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
      }
      if (!this.g.a()) {
        break label623;
      }
      i = 0;
      label416:
      localIntent.putExtra("param_sticky_note_switch", i);
      if ((i != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note) && (-1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_sticky_note))
      {
        localIntent.putExtra("param_sticky_note_switch_changed", true);
        localBundle.putShort("key_sticky_note_switch", (short)i);
      }
      localCard = ((ajxl)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localCard != null) {
        if (!this.h.a()) {
          break label628;
        }
      }
    }
    label593:
    label598:
    label603:
    label608:
    label613:
    label618:
    label623:
    label628:
    for (int i = 0;; i = 1)
    {
      localIntent.putExtra("param_extendfriend_switch", i);
      if (this.h.a() != localCard.isShowCard)
      {
        localIntent.putExtra("param_extendfriend_switch_changed", true);
        localBundle.putShort("key_extend_friend_switch", (short)i);
        localCard.isShowCard = this.h.a();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        a(localBundle, 2131694610, 0);
        this.jdField_a_of_type_Boolean = true;
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      i = 1;
      break;
      i = 1;
      break label95;
      i = 1;
      break label156;
      i = 0;
      break label217;
      i = 1;
      break label278;
      i = 1;
      break label339;
      i = 1;
      break label416;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.h.a()) {
      if (paramBoolean) {
        axqy.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      axqy.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
      int i;
      if (paramCompoundButton == this.c.a())
      {
        paramCompoundButton = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          axqy.b(paramCompoundButton, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
          return;
        }
      }
      if (paramCompoundButton == this.f.a())
      {
        paramCompoundButton = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          axqy.b(paramCompoundButton, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
          return;
        }
      }
    } while (paramCompoundButton != this.g.a());
    axqy.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */