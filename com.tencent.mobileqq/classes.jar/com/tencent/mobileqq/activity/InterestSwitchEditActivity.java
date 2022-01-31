package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import taf;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new taf(this);
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    label36:
    label54:
    label72:
    label90:
    label108:
    label126:
    do
    {
      break label216;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity != 0) {
          break label261;
        }
        this.c.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop != 0) {
          break label283;
        }
        this.d.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now != 0) {
          break label305;
        }
        this.e.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv != 0) {
          break label327;
        }
        this.f.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader != 0) {
          break label349;
        }
        this.g.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio != 0) {
          break label371;
        }
        this.h.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic != 0) {
          break label393;
        }
        this.i.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_education != 0) {
          break label415;
        }
        this.j.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_using_tim != 0) {
          break label437;
        }
        this.k.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_weishi != 0) {
          break label459;
        }
        this.l.setChecked(true);
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
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
          break label54;
        }
        this.c.setChecked(false);
        break label54;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
          break label72;
        }
        this.d.setChecked(false);
        break label72;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now) {
          break label90;
        }
        this.e.setChecked(false);
        break label90;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
          break label108;
        }
        this.f.setChecked(false);
        break label108;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader) {
          break label126;
        }
        this.g.setChecked(false);
        break label126;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio) {
          break label144;
        }
        this.h.setChecked(false);
        break label144;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic) {
          break label162;
        }
        this.i.setChecked(false);
        break label162;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_education) {
          break label180;
        }
        this.j.setChecked(false);
        break label180;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_using_tim) {
          this.k.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_weishi);
    label144:
    label162:
    label180:
    label216:
    label349:
    label371:
    this.l.setChecked(false);
    label261:
    label283:
    label305:
    label327:
    label459:
    return;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970550);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    setTitle("兴趣爱好展示设置");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371024));
    this.b = ((FormSwitchItem)findViewById(2131371025));
    this.c = ((FormSwitchItem)findViewById(2131371026));
    this.d = ((FormSwitchItem)findViewById(2131371028));
    this.f = ((FormSwitchItem)findViewById(2131371029));
    this.g = ((FormSwitchItem)findViewById(2131371027));
    this.h = ((FormSwitchItem)findViewById(2131371030));
    this.e = ((FormSwitchItem)findViewById(2131364001));
    this.i = ((FormSwitchItem)findViewById(2131371031));
    this.j = ((FormSwitchItem)findViewById(2131371032));
    this.k = ((FormSwitchItem)findViewById(2131371033));
    this.l = ((FormSwitchItem)findViewById(2131371034));
    int n = getIntent().getIntExtra("param_eat_switch", -1);
    int i1 = getIntent().getIntExtra("param_interest_switch", -1);
    int i2 = getIntent().getIntExtra("param_joined_group_switch", -1);
    int i3 = getIntent().getIntExtra("param_ktv_switch", -1);
    int i4 = getIntent().getIntExtra("param_music_switch", -1);
    int i5 = getIntent().getIntExtra("param_recent_activity_switch", -1);
    int i6 = getIntent().getIntExtra("param_star_switch", -1);
    int i7 = getIntent().getIntExtra("param_reader_switch", -1);
    int i8 = getIntent().getIntExtra("param_radio_switch", -1);
    int i9 = getIntent().getIntExtra("param_now_switch", -1);
    int i10 = getIntent().getIntExtra("param_comic_switch", -1);
    int i11 = getIntent().getIntExtra("param_education_switch", -1);
    int i12 = getIntent().getIntExtra("param_using_tim_switch", -1);
    int i13 = getIntent().getIntExtra("param_weishi_switch", -1);
    int m = 0;
    if ((-1 != n) || (-1 != i1) || (-1 != i2) || (-1 != i3) || (-1 != i4) || (-1 != i5) || (-1 != i6) || (-1 != i7) || (-1 != i8) || (-1 != i9) || (-1 != i10) || (-1 != i11) || (-1 != i12) || (-1 != i13)) {
      m = 1;
    }
    if (m != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat = ((short)n);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i1);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop = ((short)i2);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv = ((short)i3);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)i4);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity = ((short)i5);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star = ((short)i6);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader = ((short)i7);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio = ((short)i8);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now = ((short)i9);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic = ((short)i10);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_education = ((short)i11);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_using_tim = ((short)i12);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_weishi = ((short)i13);
      a();
    }
    for (;;)
    {
      return true;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.sApplication, 2131433227, 0).b(getTitleBarHeight());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.i();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label693;
      }
      m = 0;
      localIntent.putExtra("param_interest_switch", m);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label698;
      }
      m = 0;
      label47:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
        localIntent.putExtra("param_interest_switch_changed", true);
      }
      if (!this.b.a()) {
        break label703;
      }
      m = 0;
      label78:
      localIntent.putExtra("param_music_switch", m);
      if (!this.b.a()) {
        break label708;
      }
      m = 0;
      label98:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
        localIntent.putExtra("param_music_switch_changed", true);
      }
      if (!this.c.a()) {
        break label713;
      }
      m = 0;
      label129:
      localIntent.putExtra("param_recent_activity_switch", m);
      if (!this.c.a()) {
        break label718;
      }
      m = 0;
      label149:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
        localIntent.putExtra("param_recent_activity_switch_changed", true);
      }
      if (!this.d.a()) {
        break label723;
      }
      m = 0;
      label180:
      localIntent.putExtra("param_joined_group_switch", m);
      if (!this.d.a()) {
        break label728;
      }
      m = 0;
      label200:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
        localIntent.putExtra("param_joined_group_switch_changed", true);
      }
      if (!this.e.a()) {
        break label733;
      }
      m = 0;
      label232:
      localIntent.putExtra("param_now_switch", m);
      if (!this.e.a()) {
        break label738;
      }
      m = 0;
      label252:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now) {
        localIntent.putExtra("param_now_switch_changed", true);
      }
      if (!this.f.a()) {
        break label743;
      }
      m = 0;
      label284:
      localIntent.putExtra("param_ktv_switch", m);
      if (!this.f.a()) {
        break label748;
      }
      m = 0;
      label304:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
        localIntent.putExtra("param_ktv_switch_changed", true);
      }
      if (!this.g.a()) {
        break label753;
      }
      m = 0;
      label336:
      localIntent.putExtra("param_reader_switch", m);
      if (!this.g.a()) {
        break label758;
      }
      m = 0;
      label356:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader) {
        localIntent.putExtra("param_reader_switch_changed", true);
      }
      if (!this.h.a()) {
        break label763;
      }
      m = 0;
      label388:
      localIntent.putExtra("param_radio_switch", m);
      if (!this.h.a()) {
        break label768;
      }
      m = 0;
      label408:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio) {
        localIntent.putExtra("param_radio_switch_changed", true);
      }
      if (!this.i.a()) {
        break label773;
      }
      m = 0;
      label440:
      localIntent.putExtra("param_comic_switch", m);
      if (!this.i.a()) {
        break label778;
      }
      m = 0;
      label460:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic) {
        localIntent.putExtra("param_comic_switch_changed", true);
      }
      if (!this.j.a()) {
        break label783;
      }
      m = 0;
      label492:
      localIntent.putExtra("param_education_switch", m);
      if (!this.j.a()) {
        break label788;
      }
      m = 0;
      label512:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_education) {
        localIntent.putExtra("param_education_switch_changed", true);
      }
      if (!this.k.a()) {
        break label793;
      }
      m = 0;
      label544:
      localIntent.putExtra("param_using_tim_switch", m);
      if (!this.k.a()) {
        break label798;
      }
      m = 0;
      label564:
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_using_tim) {
        localIntent.putExtra("param_using_tim_switch_changed", true);
      }
      if (!this.l.a()) {
        break label803;
      }
      m = 0;
      label596:
      localIntent.putExtra("param_weishi_switch", m);
      if (!this.l.a()) {
        break label808;
      }
    }
    label768:
    label773:
    label778:
    label783:
    label788:
    label793:
    label798:
    label803:
    label808:
    for (int m = 0;; m = 1)
    {
      if (m != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_weishi) {
        localIntent.putExtra("param_weishi_switch_changed", true);
      }
      localIntent.putExtra("param_eat_switch", this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat);
      localIntent.putExtra("param_eat_switch_changed", false);
      localIntent.putExtra("param_star_switch", this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star);
      localIntent.putExtra("param_star_switch_changed", false);
      setResult(-1, localIntent);
      super.finish();
      return;
      label693:
      m = 1;
      break;
      label698:
      m = 1;
      break label47;
      label703:
      m = 1;
      break label78;
      label708:
      m = 1;
      break label98;
      label713:
      m = 1;
      break label129;
      label718:
      m = 1;
      break label149;
      label723:
      m = 1;
      break label180;
      label728:
      m = 1;
      break label200;
      label733:
      m = 1;
      break label232;
      label738:
      m = 1;
      break label252;
      label743:
      m = 1;
      break label284;
      label748:
      m = 1;
      break label304;
      label753:
      m = 1;
      break label336;
      label758:
      m = 1;
      break label356;
      label763:
      m = 1;
      break label388;
      m = 1;
      break label408;
      m = 1;
      break label440;
      m = 1;
      break label460;
      m = 1;
      break label492;
      m = 1;
      break label512;
      m = 1;
      break label544;
      m = 1;
      break label564;
      m = 1;
      break label596;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */