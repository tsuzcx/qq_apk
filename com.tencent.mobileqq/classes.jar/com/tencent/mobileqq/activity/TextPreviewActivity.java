package com.tencent.mobileqq.activity;

import acez;
import acfa;
import acfb;
import acfc;
import acfd;
import acfe;
import adgb;
import adgh;
import aekr;
import aexk;
import aiqz;
import ajxn;
import ajyc;
import akfw;
import akqb;
import ambe;
import ambf;
import ambh;
import amch;
import amcm;
import amdg;
import amdi;
import amdj;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
import aqxg;
import aqxh;
import avpq;
import axbt;
import axmt;
import axqw;
import baui;
import bauk;
import baxt;
import bbby;
import bbca;
import bbev;
import bboe;
import bbpp;
import bbwf;
import bbwg;
import bbwi;
import bbwl;
import bckk;
import bcpw;
import bkur;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import ho;
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
import mze;
import nax;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a;
  public static long b;
  private static final String jdField_g_of_type_JavaLangString = ajyc.a(2131714872);
  public int a;
  protected long a;
  private adgh jdField_a_of_type_Adgh;
  public amdg a;
  amdi jdField_a_of_type_Amdi = new acfc(this);
  public amdj a;
  Context jdField_a_of_type_AndroidContentContext = this;
  protected Rect a;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public Handler a;
  protected MotionEvent a;
  protected View a;
  public ImageView a;
  protected TextView a;
  private baui jdField_a_of_type_Baui;
  private bauk jdField_a_of_type_Bauk;
  bbwf jdField_a_of_type_Bbwf = new acfd(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  protected URLImageView a;
  private TextPreviewMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public MessageRecord a;
  public ContainerView a;
  public ParticipleBottomMenuView a;
  public ParticipleView a;
  public ScrollView a;
  public ho a;
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
    jdField_a_of_type_JavaLangString = ajyc.a(2131714877);
  }
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Amdj = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Amdg = new acfb(this);
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, bbwf parambbwf)
  {
    File localFile = new File(ho.jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = bbpp.a("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new bbwg((String)localObject1, localFile);
    ((bbwi)paramQQAppInterface.getManager(47)).a(1).a((bbwg)localObject1, parambbwf, (Bundle)localObject2);
  }
  
  private void c()
  {
    bkur.a(this);
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
      localObject1 = amch.a;
    }
    boolean bool;
    if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())))
    {
      bool = false;
      if ((this.jdField_d_of_type_Int <= 0) || (localObject1 == amch.a)) {
        break label623;
      }
      localObject2 = (HashMap)ambf.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((amcm)((Iterator)localObject2).next()).jdField_b_of_type_JavaLangString.equalsIgnoreCase("static"));
      }
    }
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        ((TextView)super.findViewById(2131363710)).setText(getResources().getText(2131690003));
      }
      ((ambh)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
      label226:
      localObject3 = ((BubbleManager)localObject3).a(((ambh)localObject1).jdField_a_of_type_Int, true);
      localObject2 = ajyc.a(2131714862);
      n = Color.parseColor("#808080");
      localObject1 = new File(((ambh)localObject1).jdField_a_of_type_JavaLangString);
      if ((localObject3 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((ambe)localObject3).jdField_a_of_type_JavaLangString;
        n = ((ambe)localObject3).jdField_b_of_type_Int;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(n);
        ((ImageView)super.findViewById(2131367376)).setImageDrawable(baxt.a(this.app, 1, this.jdField_d_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
        {
          localObject1 = ((AvatarPendantManager)this.app.getManager(46)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
          if (bbby.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
          {
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label407:
            this.jdField_a_of_type_Ho = ((ho)this.app.getManager(42));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366561));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366553));
            this.jdField_c_of_type_AndroidWidgetTextView.setText(ajyc.a(2131714871));
            if (this.jdField_a_of_type_Ho == null) {
              break label934;
            }
          }
        }
        label909:
        label934:
        for (bool = this.jdField_a_of_type_Ho.jdField_a_of_type_Boolean;; bool = false)
        {
          if (this.jdField_g_of_type_Int > 0)
          {
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            localObject1 = (aqxh)this.app.getManager(219);
            localObject2 = ((aqxh)localObject1).a(this.jdField_g_of_type_Int);
            if (((aqxg)localObject2).b != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((aqxg)localObject2).b);
              label556:
              this.jdField_c_of_type_AndroidWidgetTextView.setText(ajyc.a(2131714865));
              this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
            }
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidViewView = findViewById(2131369729);
            if ((bool) && (this.jdField_g_of_type_Int <= 0)) {
              break label909;
            }
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            this.jdField_h_of_type_AndroidViewView.setVisibility(8);
            return;
            bool = true;
            break;
            label623:
            ((ambh)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
            break label226;
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            break label407;
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
            break label407;
            ThreadManagerV2.excute(new TextPreviewActivity.7(this, (aqxh)localObject1), 64, null, true);
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
                localObject1 = getResources().getDrawable(2130846149);
                if (this.jdField_e_of_type_Int != 0) {
                  ThreadManager.post(new TextPreviewActivity.8(this), 8, null, true);
                }
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                if ((this.jdField_f_of_type_Int != 1) || (!ETEngine.getInstance().isEngineReady.get())) {
                  break;
                }
                localObject1 = new ETFont(this.jdField_e_of_type_Int, ho.a(this.jdField_e_of_type_Int, 1), 16.0F);
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
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838162);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838163);
    }
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (ho)this.app.getManager(42);
    int n = paramInt;
    if (paramInt == 0) {
      n = ((ho)localObject3).jdField_c_of_type_Int;
    }
    Object localObject2 = getResources().getDrawable(2130846233);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = getResources().getDrawable(2130846233);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    switch (n)
    {
    default: 
      localObject2 = (String)getResources().getText(2131690005);
      localObject1 = getResources().getDrawable(2130846249);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = ((ho)localObject3).h;
      try
      {
        localObject3 = URLDrawable.getDrawable(((ho)localObject3).i, localURLDrawableOptions);
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
    this.jdField_a_of_type_Baui.a(paramString, this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
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
    if (!bbev.d(this))
    {
      bcpw.a(this, ajyc.a(2131714876), 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (!this.jdField_a_of_type_Baui.a())
    {
      a(paramString);
      f();
      return;
    }
    this.jdField_a_of_type_Baui.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if ((a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (a(this.jdField_i_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (a(this.m, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label190;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label182;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label182:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label190:
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
    ((aqxh)this.app.getManager(219)).b = null;
    if (Build.VERSION.SDK_INT >= 11) {}
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(82);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_Amdi);
    }
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.a(this.jdField_i_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = null;
    }
    if (this.jdField_a_of_type_Adgh != null) {
      this.jdField_a_of_type_Adgh.c(this);
    }
    if (this.jdField_a_of_type_Baui != null) {
      this.jdField_a_of_type_Baui.b();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Baui.a();
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
      axqw.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(n), "", "");
      super.finish();
      overridePendingTransition(0, 2130772009);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int n;
    axbt localaxbt;
    boolean bool;
    if (l1 - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l1;
      n = paramView.getId();
      if ((n != 2131363705) && (n != 2131363715)) {
        break label920;
      }
      localaxbt = (axbt)this.app.getManager(12);
      if (localaxbt == null) {
        break label2338;
      }
      if (localaxbt.a("100005.100003") == -1) {
        break label842;
      }
      bool = true;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject1 = bbpp.a(this, "bubbleDetail", String.valueOf(this.jdField_c_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab");
      paramView = ambf.a();
      Object localObject5 = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
      Object localObject3 = localObject1;
      Object localObject4;
      if (this.jdField_d_of_type_Int > 0)
      {
        localObject4 = (String)paramView.jdField_a_of_type_JavaUtilMap.get(localObject5);
        localObject5 = (HashMap)paramView.b.get(localObject5);
        paramView = (View)localObject1;
        if (localObject5 != null)
        {
          paramView = (View)localObject1;
          if (((HashMap)localObject5).size() > 0)
          {
            localObject3 = (String)((HashMap)localObject5).get("TL");
            paramView = (View)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              paramView = mze.a((String)localObject1, "tl=" + (String)localObject3);
            }
            localObject3 = (String)((HashMap)localObject5).get("TR");
            localObject1 = paramView;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = mze.a(paramView, "tr=" + (String)localObject3);
            }
            paramView = (String)((HashMap)localObject5).get("BL");
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(paramView)) {
              localObject3 = mze.a((String)localObject1, "bl=" + paramView);
            }
            localObject1 = (String)((HashMap)localObject5).get("BR");
            paramView = (View)localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramView = mze.a((String)localObject3, "br=" + (String)localObject1);
            }
          }
        }
        localObject3 = paramView;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {}
      }
      int i1;
      int i2;
      int i3;
      int i4;
      for (;;)
      {
        try
        {
          localObject1 = mze.a(paramView, "diyText=" + URLEncoder.encode((String)localObject4, "UTF-8"));
          paramView = (View)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("TextPreviewActivity", 2, "TextPreviewActivity bubble url: " + nax.b(paramView, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 64L, localIntent, false, -1);
          paramView = this.jdField_d_of_type_JavaLangString;
          if (!bool) {
            break label870;
          }
          n = 1;
          VasWebviewUtil.reportCommercialDrainage(paramView, "bigtextpage", "bubble_enter", "", 1, 0, n, "", String.valueOf(this.jdField_c_of_type_Int), "");
          if (bool)
          {
            if (localaxbt.a("100005.100001") == -1) {
              break label875;
            }
            i1 = 1;
            if (localaxbt.a("100005.100002") == -1) {
              break label880;
            }
            i2 = 1;
            if (localaxbt.a("100005.100006") == -1) {
              break label886;
            }
            i3 = 1;
            if (localaxbt.a("100005.100018") == -1) {
              break label892;
            }
            i4 = 1;
            if (localaxbt.a("100005.100020") == -1) {
              break label898;
            }
            i5 = 1;
            if (localaxbt.a("100005.100021") == -1) {
              break label904;
            }
            i6 = 1;
            bool = ((ho)this.app.getManager(42)).jdField_a_of_type_Boolean;
            n = 0;
            if (bool)
            {
              if (localaxbt.a("100005.100011") == -1) {
                break label910;
              }
              n = 1;
            }
            if (((bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (n == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)) || ((!bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)))
            {
              if (localaxbt.a("100005") == -1) {
                break label915;
              }
              n = 1;
              if (n != 0) {
                ((avpq)this.app.getManager(36)).b("100005");
              }
            }
            ((avpq)this.app.getManager(36)).b("100005.100003");
          }
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label842:
          QLog.e("TextPreviewActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject3 = paramView;
        }
        bool = false;
        break;
        paramView = (View)localObject3;
        continue;
        label870:
        n = 0;
        continue;
        label875:
        i1 = 0;
        continue;
        label880:
        i2 = 0;
        continue;
        label886:
        i3 = 0;
        continue;
        label892:
        i4 = 0;
        continue;
        label898:
        int i5 = 0;
        continue;
        label904:
        int i6 = 0;
        continue;
        label910:
        n = 0;
        continue;
        label915:
        n = 0;
      }
      label920:
      if (n == 2131366543)
      {
        if (this.jdField_g_of_type_Int > 0)
        {
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("fontId", this.jdField_g_of_type_Int);
          paramView.putExtra("fromAIO", true);
          paramView.putExtra("individuation_url_type", 40301);
          VasWebviewUtil.openQQBrowserWithoutAD(this, bbpp.a(this, "fontDetail", String.valueOf(this.jdField_g_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
          VasWebviewUtil.reportCommercialDrainage(this.app.c(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.jdField_g_of_type_Int, "");
          return;
        }
        paramView = (axbt)this.app.getManager(12);
        if (paramView == null) {
          break label2332;
        }
        if (paramView.a("100005.100011") != -1) {
          bool = true;
        }
      }
      for (;;)
      {
        Object localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("updateFlag", bool);
        ((Intent)localObject2).putExtra("fontId", this.jdField_e_of_type_Int);
        ((Intent)localObject2).putExtra("fromAIO", true);
        ((Intent)localObject2).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, bbpp.a(this, "fontDetail", String.valueOf(this.jdField_e_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject2, false, -1);
        localObject2 = this.jdField_d_of_type_JavaLangString;
        if (bool)
        {
          n = 1;
          label1188:
          VasWebviewUtil.reportCommercialDrainage((String)localObject2, "bigtextpage", "font_enter", "", 1, 0, n, "", String.valueOf(this.jdField_e_of_type_Int), "");
          if (!bool) {
            break;
          }
          if (paramView.a("100005.100001") == -1) {
            break label1360;
          }
          n = 1;
          label1236:
          if (paramView.a("100005.100002") == -1) {
            break label1365;
          }
          i1 = 1;
          label1249:
          if (paramView.a("100005.100006") == -1) {
            break label1370;
          }
          i2 = 1;
          label1263:
          if (paramView.a("100005.100003") == -1) {
            break label1376;
          }
          i3 = 1;
          label1277:
          if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
            if (paramView.a("100005") == -1) {
              break label1382;
            }
          }
        }
        label1360:
        label1365:
        label1370:
        label1376:
        label1382:
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            ((avpq)this.app.getManager(36)).b("100005");
          }
          ((avpq)this.app.getManager(36)).b("100005.100011");
          return;
          bool = false;
          break;
          n = 0;
          break label1188;
          n = 0;
          break label1236;
          i1 = 0;
          break label1249;
          i2 = 0;
          break label1263;
          i3 = 0;
          break label1277;
        }
        if (n == 2131371344)
        {
          localaxbt = (axbt)this.app.getManager(12);
          if (localaxbt == null) {
            break label2327;
          }
          if (localaxbt.a("100005.100006") != -1) {
            n = 1;
          }
        }
        for (;;)
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          label1488:
          DiyPendantSticker localDiyPendantSticker;
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
          {
            l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
            localObject3 = bbpp.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
            localObject2 = aiqz.a().a;
            localObject4 = new StringBuilder().append(this.jdField_d_of_type_JavaLangString).append("_");
            if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
              break label1758;
            }
            paramView = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label1553:
            paramView = (DiyPendantEntity)((LRULinkedHashMap)localObject2).get(paramView);
            if (paramView == null) {
              break label2321;
            }
            localObject4 = new ArrayList();
            localObject5 = paramView.getStickerInfoList().iterator();
            label1593:
            if (!((Iterator)localObject5).hasNext()) {
              break label1784;
            }
            localDiyPendantSticker = (DiyPendantSticker)((Iterator)localObject5).next();
            i1 = localDiyPendantSticker.type;
            i2 = localDiyPendantSticker.stickerId;
            i3 = localDiyPendantSticker.angle;
            if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
              break label1765;
            }
            paramView = "0";
            label1650:
            i4 = localDiyPendantSticker.fontId;
            if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
              break label1774;
            }
          }
          label1758:
          label1765:
          label1774:
          for (localObject2 = "0";; localObject2 = localDiyPendantSticker.fontColor)
          {
            ((List)localObject4).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramView, Integer.valueOf(i4), localObject2, Integer.valueOf(localDiyPendantSticker.fontType) }));
            break label1593;
            n = 0;
            break;
            l1 = 0L;
            break label1488;
            paramView = "";
            break label1553;
            paramView = localDiyPendantSticker.text;
            break label1650;
          }
          label1784:
          paramView = TextUtils.join(";", (Iterable)localObject4);
          if (!TextUtils.isEmpty(paramView)) {
            paramView = URLEncoder.encode(paramView);
          }
          label2309:
          label2321:
          for (paramView = mze.a((String)localObject3, "stickerInfo=" + paramView);; paramView = (View)localObject3)
          {
            localIntent.putExtra("url", paramView);
            localIntent.putExtra("business", 512L);
            localIntent.putExtra("individuation_url_type", 40301);
            localIntent.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 512L, localIntent, false, -1);
            paramView = this.jdField_d_of_type_JavaLangString;
            if (n != 0)
            {
              i1 = 1;
              VasWebviewUtil.reportCommercialDrainage(paramView, "bigtextpage", "pendant_enter", "", 1, 0, i1, "", String.valueOf(l1), "");
              if (n == 0) {
                break;
              }
              if (localaxbt.a("100005.100001") == -1) {
                break label2065;
              }
              n = 1;
              label1943:
              if (localaxbt.a("100005.100002") == -1) {
                break label2070;
              }
              i1 = 1;
              label1957:
              if (localaxbt.a("100005.100006") == -1) {
                break label2075;
              }
              i2 = 1;
              label1972:
              if (localaxbt.a("100005.100003") == -1) {
                break label2081;
              }
              i3 = 1;
              label1987:
              if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
                if (localaxbt.a("100005") == -1) {
                  break label2087;
                }
              }
            }
            label2065:
            label2070:
            label2075:
            label2081:
            label2087:
            for (n = 1;; n = 0)
            {
              if (n != 0) {
                ((avpq)this.app.getManager(36)).b("100005");
              }
              ((avpq)this.app.getManager(36)).b("100005.100011");
              return;
              i1 = 0;
              break;
              n = 0;
              break label1943;
              i1 = 0;
              break label1957;
              i2 = 0;
              break label1972;
              i3 = 0;
              break label1987;
            }
            if (n != 2131369729) {
              break;
            }
            localObject3 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("individuation_url_type", 40301);
            if (this.jdField_h_of_type_Int == 0)
            {
              localObject2 = bbpp.a(this, "aioNoMagicFontEntrance", null);
              paramView = (View)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramView = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
              }
              if (TextUtils.isEmpty(paramView)) {
                break label2309;
              }
              paramView = paramView.replace("[id]", this.jdField_h_of_type_Int + "");
              if (QLog.isColorLevel()) {
                QLog.i("TextPreviewActivity", 2, "mFontEffectId=" + this.jdField_h_of_type_Int + " url=" + paramView);
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 0L, (Intent)localObject3, false, -1);
            }
            for (;;)
            {
              VasWebviewUtil.reportCommercialDrainage(this.jdField_d_of_type_JavaLangString, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.jdField_h_of_type_Int), "");
              return;
              localObject2 = bbpp.a(this, "aioMagicFontEntrance", null);
              paramView = (View)localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              paramView = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
              break;
              QLog.e("TextPreviewActivity", 2, "url is empty.");
            }
          }
          label2327:
          n = 0;
        }
        label2332:
        bool = false;
      }
      label2338:
      bool = false;
    }
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
        super.setContentView(2131558580);
        paramBundle = super.getIntent();
        this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("peeruin");
        this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("senderUin");
        this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("real_msg_sender_uin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
        this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isMultiMsg", false);
        this.jdField_c_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
        this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("content");
        this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("troop_at_info");
        this.jdField_f_of_type_AndroidViewView = super.findViewById(2131371364);
        this.jdField_g_of_type_AndroidViewView = super.findViewById(2131363714);
        this.jdField_h_of_type_AndroidViewView = super.findViewById(2131366560);
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("sessionType", -2);
        this.jdField_d_of_type_Int = paramBundle.getIntExtra("bubbleDiyId", 0);
        if (this.jdField_d_of_type_Int == 0) {
          this.jdField_d_of_type_Int = akfw.b(paramBundle.getLongExtra("bubbleId", 0L));
        }
        this.jdField_g_of_type_Int = paramBundle.getIntExtra("HiBoomId", 0);
        str = paramBundle.getStringExtra("fontId");
        if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
          break label1373;
        }
        if (ho.b(Long.parseLong(str)) == 0)
        {
          this.jdField_e_of_type_Int = -1;
          this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369731));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369730));
          this.jdField_h_of_type_Int = paramBundle.getIntExtra("fontEffectId", 0);
          a(this.jdField_h_of_type_Int);
          long l1 = paramBundle.getLongExtra("uniseq", 0L);
          this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra(aekr.jdField_a_of_type_JavaLangString, true);
          this.jdField_b_of_type_Boolean = (paramBundle.getBooleanExtra(aexk.jdField_a_of_type_JavaLangString, true) | this.jdField_b_of_type_Boolean);
          if (axmt.b()) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((ajxn)this.app.getManager(51)).a(this.jdField_d_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("TextPreviewActivity", 2, "previewBubble sender:" + this.jdField_d_of_type_JavaLangString + ",bubbleId:" + this.jdField_c_of_type_Int + ",bubbleDiyId:" + this.jdField_d_of_type_Int + ",FontId:" + str + ",hiBoomId:" + this.jdField_g_of_type_Int + ",fontEffectId:" + this.jdField_h_of_type_Int);
          }
          this.jdField_a_of_type_Baui = new baui(this.app, this);
          this.jdField_a_of_type_AndroidOsHandler = new acez(this, Looper.getMainLooper());
          if (this.jdField_g_of_type_Int != 0) {
            ((aqxh)this.app.getManager(219)).b = this.jdField_a_of_type_AndroidOsHandler;
          }
          if (jdField_b_of_type_Long != l1)
          {
            ContainerView.jdField_a_of_type_Float = 0.0F;
            jdField_b_of_type_Long = l1;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131364692));
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
          this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131376726));
          this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363354);
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131371344);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366543);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363705);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131372169));
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131371262));
          this.jdField_i_of_type_AndroidViewView = findViewById(2131363356);
          this.j = findViewById(2131366501);
          this.k = findViewById(2131376387);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368007));
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838163);
          this.l = findViewById(2131364776);
          this.m = findViewById(2131366558);
          if (this.m != null)
          {
            str = this.app.getCurrentAccountUin();
            if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
              break label1381;
            }
            paramBundle = "1";
            VasWebviewUtil.reportCommercialDrainage(str, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363715));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363711));
          this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131371365));
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          paramBundle = (TextView)super.findViewById(2131378739);
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break;
          }
          if (this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())) {
            break label1388;
          }
          paramBundle.setText("TA正在使用的装扮");
          if ((Build.VERSION.SDK_INT < 11) || (this.jdField_e_of_type_JavaLangString != null))
          {
            QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.jdField_e_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + bbca.encodeToString(this.jdField_e_of_type_JavaLangString.getBytes(), 0));
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1398;
          }
          paramBundle = this.app.a();
          if (paramBundle != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramBundle.a(jdField_b_of_type_Long);
          }
          adgb.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1);
          paramBundle = bboe.a(this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 30, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = new TextPreviewMenu();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setMovementMethod(bckk.a());
          paramBundle = (WordMatchManager)this.app.getManager(82);
          if (paramBundle != null)
          {
            this.jdField_a_of_type_Amdj = paramBundle.a(this.jdField_a_of_type_Amdi);
            if (this.jdField_a_of_type_Amdj != null)
            {
              if (this.jdField_i_of_type_Int != 0) {
                this.jdField_a_of_type_Amdj.a(this.jdField_i_of_type_Int);
              }
              this.jdField_i_of_type_Int = this.jdField_a_of_type_Amdj.a(1, this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_Amdg);
            }
          }
          this.jdField_a_of_type_Bauk = new acfa(this);
          this.jdField_a_of_type_Baui.a(this.jdField_a_of_type_Bauk);
          this.jdField_a_of_type_Adgh = new adgh();
          this.jdField_a_of_type_Adgh.a(this);
          this.mFlingHandler = new acfe(this, null);
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
      this.jdField_e_of_type_Int = ((int)ho.a(Long.parseLong(str)));
      this.jdField_f_of_type_Int = ho.b(Long.parseLong(str));
      continue;
      label1373:
      this.jdField_e_of_type_Int = -1;
      continue;
      label1381:
      paramBundle = "2";
      continue;
      label1388:
      paramBundle.setText(jdField_g_of_type_JavaLangString);
      continue;
      label1398:
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
    localObject = ambf.a();
    String str = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
    if ((this.jdField_d_of_type_Int > 0) && ((!((ambf)localObject).jdField_a_of_type_JavaUtilMap.containsKey(str)) || (!((ambf)localObject).b.containsKey(str)))) {
      ThreadManager.post(new TextPreviewActivity.6(this, (ambf)localObject, str), 5, null, false);
    }
    this.jdField_a_of_type_Adgh.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a();
    d();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */