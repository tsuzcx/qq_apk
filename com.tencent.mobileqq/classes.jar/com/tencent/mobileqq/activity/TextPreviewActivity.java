package com.tencent.mobileqq.activity;

import Override;
import afqj;
import afqk;
import afql;
import afqm;
import afqn;
import afqo;
import agsd;
import agsi;
import aifn;
import aiuk;
import amrx;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anyw;
import anzj;
import aogu;
import aoot;
import aost;
import aqkq;
import aqkr;
import aqkt;
import aqlt;
import aqly;
import aqmt;
import aqmv;
import aqmw;
import avrk;
import avrl;
import bbav;
import bcuy;
import bdgb;
import bdll;
import bhcj;
import bhcl;
import bhkt;
import bhkv;
import bhnv;
import bhwz;
import bhyk;
import biht;
import bihu;
import bihw;
import bihz;
import biwl;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import gc;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import nmj;
import noe;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a;
  public static long b;
  private static final String jdField_g_of_type_JavaLangString = anzj.a(2131713675);
  public int a;
  protected long a;
  private agsi jdField_a_of_type_Agsi;
  Context jdField_a_of_type_AndroidContentContext = this;
  protected Rect a;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public Handler a;
  protected MotionEvent a;
  protected View a;
  public ImageView a;
  protected TextView a;
  public aqmt a;
  aqmv jdField_a_of_type_Aqmv = new afqm(this);
  public aqmw a;
  private bhcj jdField_a_of_type_Bhcj;
  private bhcl jdField_a_of_type_Bhcl;
  biht jdField_a_of_type_Biht = new afqn(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  protected URLImageView a;
  private TextPreviewMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public MessageRecord a;
  public ContainerView a;
  public ParticipleBottomMenuView a;
  public ParticipleView a;
  public ScrollView a;
  public gc a;
  public CharSequence a;
  public boolean a;
  public int b;
  protected View b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected TextView b;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  public String b;
  protected boolean b;
  protected int c;
  protected long c;
  protected View c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  protected int d;
  protected View d;
  TextView d;
  protected String d;
  public int e;
  protected View e;
  public String e;
  int f;
  protected View f;
  public String f;
  int jdField_g_of_type_Int = 0;
  protected View g;
  int h;
  protected View h;
  public int i;
  public View i;
  public View j;
  public View k;
  public View l;
  public View m;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131713680);
  }
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Aqmw = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Aqmt = new afql(this);
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, biht parambiht)
  {
    File localFile = new File(gc.jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = bhyk.a("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new bihu((String)localObject1, localFile);
    ((bihw)paramQQAppInterface.getManager(47)).a(1).a((bihu)localObject1, parambiht, (Bundle)localObject2);
  }
  
  private void c()
  {
    LiuHaiUtils.a(this);
  }
  
  private void d()
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
      ImmersiveUtils.a(true, getWindow());
    }
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject3 = (BubbleManager)this.app.getManager(44);
    Object localObject2 = ((BubbleManager)localObject3).a(this.jdField_c_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = aqlt.a;
    }
    boolean bool;
    if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())))
    {
      bool = false;
      if ((this.jdField_d_of_type_Int <= 0) || (localObject1 == aqlt.a)) {
        break label623;
      }
      localObject2 = (HashMap)aqkr.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((aqly)((Iterator)localObject2).next()).jdField_b_of_type_JavaLangString.equalsIgnoreCase("static"));
      }
    }
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        ((TextView)super.findViewById(2131363999)).setText(getResources().getText(2131689939));
      }
      ((aqkt)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
      label226:
      localObject3 = ((BubbleManager)localObject3).a(((aqkt)localObject1).jdField_a_of_type_Int, true);
      localObject2 = anzj.a(2131713665);
      n = Color.parseColor("#808080");
      localObject1 = new File(((aqkt)localObject1).jdField_a_of_type_JavaLangString);
      if ((localObject3 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((aqkq)localObject3).jdField_a_of_type_JavaLangString;
        n = ((aqkq)localObject3).jdField_b_of_type_Int;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(n);
        ((ImageView)super.findViewById(2131367895)).setImageDrawable(aoot.a(this.app, 1, this.jdField_d_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
        {
          localObject1 = ((AvatarPendantManager)this.app.getManager(46)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
          if (bhkt.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
          {
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label407:
            this.jdField_a_of_type_Gc = ((gc)this.app.getManager(42));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366999));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366991));
            this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131713674));
            if (this.jdField_a_of_type_Gc == null) {
              break label934;
            }
          }
        }
        label909:
        label934:
        for (bool = this.jdField_a_of_type_Gc.jdField_a_of_type_Boolean;; bool = false)
        {
          if (this.jdField_g_of_type_Int > 0)
          {
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            localObject1 = (avrl)this.app.getManager(219);
            localObject2 = ((avrl)localObject1).a(this.jdField_g_of_type_Int);
            if (((avrk)localObject2).b != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((avrk)localObject2).b);
              label556:
              this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131713668));
              this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
            }
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidViewView = findViewById(2131370554);
            if ((bool) && (this.jdField_g_of_type_Int <= 0)) {
              break label909;
            }
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            this.jdField_h_of_type_AndroidViewView.setVisibility(8);
            return;
            bool = true;
            break;
            label623:
            ((aqkt)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
            break label226;
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            break label407;
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
            break label407;
            ThreadManagerV2.excute(new TextPreviewActivity.7(this, (avrl)localObject1), 64, null, true);
            break label556;
            if (!bool)
            {
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_g_of_type_AndroidViewView.setVisibility(8);
            }
            else
            {
              this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
              if (this.jdField_e_of_type_Int == -1)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
                  break label878;
                }
                this.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
                this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType;
              }
              for (;;)
              {
                localObject1 = getResources().getDrawable(2130847065);
                if (this.jdField_e_of_type_Int != 0) {
                  ThreadManager.post(new TextPreviewActivity.8(this), 8, null, true);
                }
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                if ((this.jdField_f_of_type_Int != 1) || (!ETEngine.getInstance().isEngineReady.get())) {
                  break;
                }
                localObject1 = new ETFont(this.jdField_e_of_type_Int, gc.a(this.jdField_e_of_type_Int, 1), 16.0F);
                if (!ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
                  break label886;
                }
                this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
                break;
                label878:
                this.jdField_e_of_type_Int = 0;
              }
              label886:
              if (ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1)) {
                this.jdField_c_of_type_AndroidWidgetTextView.setText("DIY字体");
              }
            }
          }
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          return;
        }
        localObject1 = localObject2;
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838342);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getBackground());
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  public void a()
  {
    Drawable localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getBackground();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable)))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)localDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838343);
    }
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (gc)this.app.getManager(42);
    int n = paramInt;
    if (paramInt == 0) {
      n = ((gc)localObject3).jdField_c_of_type_Int;
    }
    Object localObject2 = getResources().getDrawable(2130847156);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = getResources().getDrawable(2130847156);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    switch (n)
    {
    default: 
      localObject2 = (String)getResources().getText(2131689941);
      localObject1 = getResources().getDrawable(2130847172);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = ((gc)localObject3).h;
      try
      {
        localObject3 = URLDrawable.getDrawable(((gc)localObject3).i, localURLDrawableOptions);
        localObject2 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      catch (Exception localException)
      {
        QLog.e("TextPreviewActivity", 1, "font effect exception, " + localException.getMessage());
        Object localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bhcj.a(paramString, this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
  }
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() != 0) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int n = paramView.right;
    paramView.right = (arrayOfInt[0] + n);
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    n = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + n);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    String str2;
    if (Math.abs(l1 - this.jdField_c_of_type_Long) > 2000L)
    {
      this.jdField_c_of_type_Long = l1;
      str2 = ((ChatBackgroundManager)this.app.getManager(63)).a(this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
      str1 = str2;
      if ("null".equals(str2)) {
        str1 = "0";
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
        break label294;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      String str3 = this.jdField_d_of_type_JavaLangString;
      int n = this.jdField_c_of_type_Int;
      int i1 = this.jdField_e_of_type_Int;
      int i2 = this.jdField_h_of_type_Int;
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label300;
      }
      str2 = this.jdField_d_of_type_JavaLangString;
      label139:
      localIntent.putExtra("url", String.format("https://zb.vip.qq.com/v2/aioPage?targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", new Object[] { str3, Long.valueOf(l1), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str1, str2, Integer.valueOf(this.jdField_b_of_type_Int) }));
      startActivity(localIntent);
      str2 = this.app.getCurrentAccountUin();
      if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
        break label309;
      }
    }
    label294:
    label300:
    label309:
    for (String str1 = "1";; str1 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(str2, "aio", "icon_click", "", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
      return;
      l1 = 0L;
      break;
      str2 = this.jdField_b_of_type_JavaLangString;
      break label139;
    }
  }
  
  public void b(String paramString)
  {
    if (!bhnv.d(this))
    {
      QQToast.a(this, anzj.a(2131713679), 0).b(getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if (!this.jdField_a_of_type_Bhcj.a())
    {
      a(paramString);
      f();
      return;
    }
    this.jdField_a_of_type_Bhcj.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (this.jdField_c_of_type_Boolean) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.getVisibility() == 0)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      else
      {
        if ((!a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_i_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.m, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {
          break;
        }
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label216;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label208;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      break;
      label208:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label216:
      if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
        {
          int n = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getX() - (int)paramMotionEvent.getX();
          int i1 = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getY() - (int)paramMotionEvent.getY();
          if ((n * n + i1 * i1 < 10000) && (paramMotionEvent.getEventTime() - this.jdField_a_of_type_AndroidViewMotionEvent.getEventTime() < 200L))
          {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
            finish();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a()) {
      super.doOnBackPressed();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((avrl)this.app.getManager(219)).b = null;
    if (Build.VERSION.SDK_INT >= 11) {}
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(82);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_Aqmv);
    }
    if (this.jdField_a_of_type_Aqmw != null) {
      this.jdField_a_of_type_Aqmw.a(this.jdField_i_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = null;
    }
    if (this.jdField_a_of_type_Agsi != null) {
      this.jdField_a_of_type_Agsi.c(this);
    }
    if (this.jdField_a_of_type_Bhcj != null) {
      this.jdField_a_of_type_Bhcj.b();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Bhcj.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.getHeight() < this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMinimumHeight(this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight());
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.jdField_e_of_type_JavaLangString != null) {}
    for (int n = this.jdField_e_of_type_JavaLangString.length();; n = 0)
    {
      bdll.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(n), "", "");
      super.finish();
      overridePendingTransition(0, 2130772010);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int n;
    bcuy localbcuy;
    boolean bool;
    if (l1 - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l1;
      n = paramView.getId();
      if ((n != 2131363994) && (n != 2131364004)) {
        break label950;
      }
      localbcuy = (bcuy)this.app.getManager(12);
      if (localbcuy == null) {
        break label2418;
      }
      if (localbcuy.a("100005.100003") == -1) {
        break label870;
      }
      bool = true;
    }
    label900:
    label905:
    label910:
    label916:
    label922:
    label928:
    label934:
    label1830:
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject2 = bhyk.a(this, "bubbleDetail", String.valueOf(this.jdField_c_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab");
      Object localObject1 = aqkr.a();
      Object localObject6 = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
      Object localObject4 = localObject2;
      Object localObject5;
      if (this.jdField_d_of_type_Int > 0)
      {
        localObject5 = (String)((aqkr)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject6);
        localObject6 = (HashMap)((aqkr)localObject1).b.get(localObject6);
        localObject1 = localObject2;
        if (localObject6 != null)
        {
          localObject1 = localObject2;
          if (((HashMap)localObject6).size() > 0)
          {
            localObject4 = (String)((HashMap)localObject6).get("TL");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = nmj.a((String)localObject2, "tl=" + (String)localObject4);
            }
            localObject4 = (String)((HashMap)localObject6).get("TR");
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject2 = nmj.a((String)localObject1, "tr=" + (String)localObject4);
            }
            localObject1 = (String)((HashMap)localObject6).get("BL");
            localObject4 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject4 = nmj.a((String)localObject2, "bl=" + (String)localObject1);
            }
            localObject2 = (String)((HashMap)localObject6).get("BR");
            localObject1 = localObject4;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = nmj.a((String)localObject4, "br=" + (String)localObject2);
            }
          }
        }
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {}
      }
      int i1;
      int i2;
      int i3;
      int i4;
      for (;;)
      {
        try
        {
          localObject2 = nmj.a((String)localObject1, "diyText=" + URLEncoder.encode((String)localObject5, "UTF-8"));
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("TextPreviewActivity", 2, "TextPreviewActivity bubble url: " + noe.b((String)localObject1, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 64L, localIntent, false, -1);
          localObject1 = this.jdField_d_of_type_JavaLangString;
          if (!bool) {
            break label900;
          }
          n = 1;
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "bubble_enter", "", 1, 0, n, "", String.valueOf(this.jdField_c_of_type_Int), "");
          if (bool)
          {
            if (localbcuy.a("100005.100001") == -1) {
              break label905;
            }
            i1 = 1;
            if (localbcuy.a("100005.100002") == -1) {
              break label910;
            }
            i2 = 1;
            if (localbcuy.a("100005.100006") == -1) {
              break label916;
            }
            i3 = 1;
            if (localbcuy.a("100005.100018") == -1) {
              break label922;
            }
            i4 = 1;
            if (localbcuy.a("100005.100020") == -1) {
              break label928;
            }
            i5 = 1;
            if (localbcuy.a("100005.100021") == -1) {
              break label934;
            }
            i6 = 1;
            bool = ((gc)this.app.getManager(42)).jdField_a_of_type_Boolean;
            n = 0;
            if (bool)
            {
              if (localbcuy.a("100005.100011") == -1) {
                break label940;
              }
              n = 1;
            }
            if (((bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (n == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)) || ((!bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)))
            {
              if (localbcuy.a("100005") == -1) {
                break label945;
              }
              n = 1;
              if (n != 0) {
                ((bbav)this.app.getManager(36)).b("100005");
              }
            }
            ((bbav)this.app.getManager(36)).b("100005.100003");
          }
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label870:
          QLog.e("TextPreviewActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject4 = localObject1;
        }
        bool = false;
        break;
        localObject1 = localObject4;
        continue;
        n = 0;
        continue;
        i1 = 0;
        continue;
        i2 = 0;
        continue;
        i3 = 0;
        continue;
        i4 = 0;
        continue;
        int i5 = 0;
        continue;
        int i6 = 0;
        continue;
        label940:
        n = 0;
        continue;
        label945:
        n = 0;
        continue;
        label950:
        if (n != 2131366981) {
          break label1434;
        }
        if (this.jdField_g_of_type_Int <= 0) {
          break label1094;
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("fontId", this.jdField_g_of_type_Int);
        ((Intent)localObject1).putExtra("fromAIO", true);
        ((Intent)localObject1).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, bhyk.a(this, "fontDetail", String.valueOf(this.jdField_g_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject1, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.jdField_g_of_type_Int, "");
      }
      label1094:
      localObject1 = (bcuy)this.app.getManager(12);
      if (localObject1 != null) {
        if (((bcuy)localObject1).a("100005.100011") != -1) {
          bool = true;
        }
      }
      label1321:
      label1963:
      for (;;)
      {
        label1128:
        Object localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("updateFlag", bool);
        ((Intent)localObject3).putExtra("fontId", this.jdField_e_of_type_Int);
        ((Intent)localObject3).putExtra("fromAIO", true);
        ((Intent)localObject3).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, bhyk.a(this, "fontDetail", String.valueOf(this.jdField_e_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject3, false, -1);
        localObject3 = this.jdField_d_of_type_JavaLangString;
        if (bool)
        {
          n = 1;
          label1228:
          VasWebviewUtil.reportCommercialDrainage((String)localObject3, "bigtextpage", "font_enter", "", 1, 0, n, "", String.valueOf(this.jdField_e_of_type_Int), "");
          if (!bool) {
            break;
          }
          if (((bcuy)localObject1).a("100005.100001") == -1) {
            break label1407;
          }
          n = 1;
          label1277:
          if (((bcuy)localObject1).a("100005.100002") == -1) {
            break label1412;
          }
          i1 = 1;
          if (((bcuy)localObject1).a("100005.100006") == -1) {
            break label1417;
          }
          i2 = 1;
          if (((bcuy)localObject1).a("100005.100003") == -1) {
            break label1423;
          }
          i3 = 1;
          if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
            if (((bcuy)localObject1).a("100005") == -1) {
              break label1429;
            }
          }
        }
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            ((bbav)this.app.getManager(36)).b("100005");
          }
          ((bbav)this.app.getManager(36)).b("100005.100011");
          break;
          bool = false;
          break label1128;
          n = 0;
          break label1228;
          label1407:
          n = 0;
          break label1277;
          i1 = 0;
          break label1291;
          i2 = 0;
          break label1306;
          i3 = 0;
          break label1321;
        }
        if (n == 2131372368)
        {
          localbcuy = (bcuy)this.app.getManager(12);
          if (localbcuy == null) {
            break label2407;
          }
          if (localbcuy.a("100005.100006") != -1) {
            n = 1;
          }
        }
        label1601:
        label2388:
        for (;;)
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          label1535:
          DiyPendantSticker localDiyPendantSticker;
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
          {
            l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
            localObject4 = bhyk.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
            localObject3 = amrx.a().a;
            localObject5 = new StringBuilder().append(this.jdField_d_of_type_JavaLangString).append("_");
            if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
              break label1812;
            }
            localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            localObject1 = (DiyPendantEntity)((LRULinkedHashMap)localObject3).get(localObject1);
            if (localObject1 == null) {
              break label2400;
            }
            localObject5 = new ArrayList();
            localObject6 = ((DiyPendantEntity)localObject1).getStickerInfoList().iterator();
            label1645:
            if (!((Iterator)localObject6).hasNext()) {
              break label1840;
            }
            localDiyPendantSticker = (DiyPendantSticker)((Iterator)localObject6).next();
            i1 = localDiyPendantSticker.type;
            i2 = localDiyPendantSticker.stickerId;
            i3 = localDiyPendantSticker.angle;
            if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
              break label1820;
            }
            localObject1 = "0";
            i4 = localDiyPendantSticker.fontId;
            if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
              break label1830;
            }
          }
          for (localObject3 = "0";; localObject3 = localDiyPendantSticker.fontColor)
          {
            ((List)localObject5).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), localObject1, Integer.valueOf(i4), localObject3, Integer.valueOf(localDiyPendantSticker.fontType) }));
            break label1645;
            n = 0;
            break;
            l1 = 0L;
            break label1535;
            localObject1 = "";
            break label1601;
            localObject1 = localDiyPendantSticker.text;
            break label1703;
          }
          localObject1 = TextUtils.join(";", (Iterable)localObject5);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject1 = URLEncoder.encode((String)localObject1);
          }
          label2009:
          label2138:
          label2143:
          label2400:
          for (localObject1 = nmj.a((String)localObject4, "stickerInfo=" + (String)localObject1);; localObject1 = localObject4)
          {
            localIntent.putExtra("url", (String)localObject1);
            localIntent.putExtra("business", 512L);
            localIntent.putExtra("individuation_url_type", 40301);
            localIntent.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 512L, localIntent, false, -1);
            localObject1 = this.jdField_d_of_type_JavaLangString;
            if (n != 0)
            {
              i1 = 1;
              VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "pendant_enter", "", 1, 0, i1, "", String.valueOf(l1), "");
              if (n == 0) {
                break;
              }
              if (localbcuy.a("100005.100001") == -1) {
                break label2133;
              }
              n = 1;
              if (localbcuy.a("100005.100002") == -1) {
                break label2138;
              }
              i1 = 1;
              label2023:
              if (localbcuy.a("100005.100006") == -1) {
                break label2143;
              }
              i2 = 1;
              label2038:
              if (localbcuy.a("100005.100003") == -1) {
                break label2149;
              }
              i3 = 1;
              if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
                if (localbcuy.a("100005") == -1) {
                  break label2155;
                }
              }
            }
            label2149:
            label2155:
            for (n = 1;; n = 0)
            {
              if (n != 0) {
                ((bbav)this.app.getManager(36)).b("100005");
              }
              ((bbav)this.app.getManager(36)).b("100005.100011");
              break;
              i1 = 0;
              break label1963;
              n = 0;
              break label2009;
              i1 = 0;
              break label2023;
              i2 = 0;
              break label2038;
              i3 = 0;
              break label2053;
            }
            if (n != 2131370554) {
              break;
            }
            localObject4 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("individuation_url_type", 40301);
            if (this.jdField_h_of_type_Int == 0)
            {
              localObject3 = bhyk.a(this, "aioNoMagicFontEntrance", null);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label2388;
              }
              localObject1 = ((String)localObject1).replace("[id]", this.jdField_h_of_type_Int + "");
              if (QLog.isColorLevel()) {
                QLog.i("TextPreviewActivity", 2, "mFontEffectId=" + this.jdField_h_of_type_Int + " url=" + (String)localObject1);
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 0L, (Intent)localObject4, false, -1);
            }
            for (;;)
            {
              VasWebviewUtil.reportCommercialDrainage(this.jdField_d_of_type_JavaLangString, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.jdField_h_of_type_Int), "");
              break;
              localObject3 = bhyk.a(this, "aioMagicFontEntrance", null);
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2226;
              }
              localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
              break label2226;
              QLog.e("TextPreviewActivity", 2, "url is empty.");
            }
          }
          label2133:
          label2407:
          n = 0;
        }
        label1840:
        label2226:
        bool = false;
      }
      label1703:
      label2418:
      bool = false;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if ((this.app == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TextPreviewActivity", 2, "TextPreviewActivity onCreate,  the app is null");
      }
      finish();
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        super.setContentView(2131558642);
        paramBundle = super.getIntent();
        this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("peeruin");
        this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("senderUin");
        this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("real_msg_sender_uin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
        this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isMultiMsg", false);
        this.jdField_c_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
        this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("content");
        this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("troop_at_info");
        this.jdField_f_of_type_AndroidViewView = super.findViewById(2131372388);
        this.jdField_g_of_type_AndroidViewView = super.findViewById(2131364003);
        this.jdField_h_of_type_AndroidViewView = super.findViewById(2131366998);
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("sessionType", -2);
        this.jdField_d_of_type_Int = paramBundle.getIntExtra("bubbleDiyId", 0);
        if (this.jdField_d_of_type_Int == 0) {
          this.jdField_d_of_type_Int = aogu.b(paramBundle.getLongExtra("bubbleId", 0L));
        }
        this.jdField_g_of_type_Int = paramBundle.getIntExtra("HiBoomId", 0);
        str = paramBundle.getStringExtra("fontId");
        if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
          break label1372;
        }
        if (gc.b(Long.parseLong(str)) == 0)
        {
          this.jdField_e_of_type_Int = -1;
          this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131370556));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370555));
          this.jdField_h_of_type_Int = paramBundle.getIntExtra("fontEffectId", 0);
          a(this.jdField_h_of_type_Int);
          long l1 = paramBundle.getLongExtra("uniseq", 0L);
          this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra(aifn.jdField_a_of_type_JavaLangString, true);
          this.jdField_b_of_type_Boolean = (paramBundle.getBooleanExtra(aiuk.jdField_a_of_type_JavaLangString, true) | this.jdField_b_of_type_Boolean);
          if (bdgb.b()) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((anyw)this.app.getManager(51)).a(this.jdField_d_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("TextPreviewActivity", 2, "previewBubble sender:" + this.jdField_d_of_type_JavaLangString + ",bubbleId:" + this.jdField_c_of_type_Int + ",bubbleDiyId:" + this.jdField_d_of_type_Int + ",FontId:" + str + ",hiBoomId:" + this.jdField_g_of_type_Int + ",fontEffectId:" + this.jdField_h_of_type_Int);
          }
          this.jdField_a_of_type_Bhcj = new bhcj(this.app, this);
          this.jdField_a_of_type_AndroidOsHandler = new afqj(this, Looper.getMainLooper());
          if (this.jdField_g_of_type_Int != 0) {
            ((avrl)this.app.getManager(219)).b = this.jdField_a_of_type_AndroidOsHandler;
          }
          if (jdField_b_of_type_Long != l1)
          {
            ContainerView.jdField_a_of_type_Float = 0.0F;
            jdField_b_of_type_Long = l1;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131365046));
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
          this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131378260));
          this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363608);
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372368);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366981);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363994);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131373239));
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372280));
          this.jdField_i_of_type_AndroidViewView = findViewById(2131363610);
          this.j = findViewById(2131366931);
          this.k = findViewById(2131377901);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368554));
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838343);
          this.l = findViewById(2131365137);
          this.m = findViewById(2131366996);
          if (this.m != null)
          {
            str = this.app.getCurrentAccountUin();
            if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
              break label1380;
            }
            paramBundle = "1";
            VasWebviewUtil.reportCommercialDrainage(str, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364004));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364000));
          this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131372389));
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          paramBundle = (TextView)super.findViewById(2131380532);
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break;
          }
          if (this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())) {
            break label1387;
          }
          paramBundle.setText("TA正在使用的装扮");
          if ((Build.VERSION.SDK_INT < 11) || (this.jdField_e_of_type_JavaLangString != null))
          {
            QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.jdField_e_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + bhkv.encodeToString(this.jdField_e_of_type_JavaLangString.getBytes(), 0));
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1397;
          }
          paramBundle = this.app.a();
          if (paramBundle != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramBundle.a(jdField_b_of_type_Long);
          }
          agsd.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1);
          paramBundle = bhwz.a(this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 30, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = new TextPreviewMenu();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setMovementMethod(biwl.a());
          paramBundle = (WordMatchManager)this.app.getManager(82);
          if (paramBundle != null)
          {
            this.jdField_a_of_type_Aqmw = paramBundle.a(this.jdField_a_of_type_Aqmv);
            if (this.jdField_a_of_type_Aqmw != null)
            {
              if (this.jdField_i_of_type_Int != 0) {
                this.jdField_a_of_type_Aqmw.a(this.jdField_i_of_type_Int);
              }
              this.jdField_i_of_type_Int = this.jdField_a_of_type_Aqmw.a(1, this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_Aqmt);
            }
          }
          this.jdField_a_of_type_Bhcl = new afqk(this);
          this.jdField_a_of_type_Bhcj.a(this.jdField_a_of_type_Bhcl);
          this.jdField_a_of_type_Agsi = new agsi();
          this.jdField_a_of_type_Agsi.a(this);
          this.mFlingHandler = new afqo(this, null);
          c();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("TextPreviewActivity", 1, "", paramBundle);
        finish();
        return;
      }
      this.jdField_e_of_type_Int = ((int)gc.a(Long.parseLong(str)));
      this.jdField_f_of_type_Int = gc.b(Long.parseLong(str));
      continue;
      label1372:
      this.jdField_e_of_type_Int = -1;
      continue;
      label1380:
      paramBundle = "2";
      continue;
      label1387:
      paramBundle.setText(jdField_g_of_type_JavaLangString);
      continue;
      label1397:
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, jdField_b_of_type_Long);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    Object localObject = (WebProcessManager)this.app.getManager(13);
    if (localObject != null) {
      ((WebProcessManager)localObject).e();
    }
    localObject = aqkr.a();
    String str = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
    if ((this.jdField_d_of_type_Int > 0) && ((!((aqkr)localObject).jdField_a_of_type_JavaUtilMap.containsKey(str)) || (!((aqkr)localObject).b.containsKey(str)))) {
      ThreadManager.post(new TextPreviewActivity.6(this, (aqkr)localObject, str), 5, null, false);
    }
    this.jdField_a_of_type_Agsi.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a();
    d();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */