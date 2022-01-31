package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
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
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.DiyBubbleConfig;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.ScrollView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
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
import tzz;
import uaa;
import uab;
import uac;
import uad;
import uae;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static long b;
  public int a;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext = this;
  protected Rect a;
  public Handler a;
  protected MotionEvent a;
  protected View a;
  public ImageView a;
  protected TextView a;
  public FontManager a;
  protected URLImageView a;
  public WordMatchManager.MatchCallback a;
  WordMatchManager.MatcherCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback = new uab(this);
  public WordMatchManager.WordMatcher a;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public QQText a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new uae(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  protected DownloaderFactory a;
  public ContainerView a;
  protected ScrollView a;
  public String a;
  protected boolean a;
  protected int b;
  protected View b;
  protected TextView b;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  protected String b;
  private boolean jdField_b_of_type_Boolean;
  protected int c;
  protected long c;
  protected View c;
  TextView c;
  public String c;
  public int d;
  protected View d;
  TextView d;
  int e;
  protected View e;
  int f;
  protected View f;
  int g;
  protected View g;
  public int h;
  protected View h;
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback = new uaa(this);
  }
  
  private void a()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    BubbleManager localBubbleManager = (BubbleManager)this.app.getManager(43);
    Object localObject2 = localBubbleManager.a(this.jdField_b_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    boolean bool;
    if (!this.jdField_b_of_type_JavaLangString.equals(this.app.getAccount()))
    {
      bool = false;
      if ((this.jdField_c_of_type_Int <= 0) || (localObject1 == BubbleUtils.a)) {
        break label595;
      }
      localObject2 = (HashMap)BubbleDiyFetcher.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_b_of_type_Int));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((DiyBubbleConfig)((Iterator)localObject2).next()).jdField_b_of_type_JavaLangString.equalsIgnoreCase("static"));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((TextView)super.findViewById(2131363074)).setText(getResources().getText(2131433429));
      }
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
      label216:
      localObject2 = localBubbleManager.a(((BubbleInfo)localObject1).jdField_a_of_type_Int, true);
      i = Color.parseColor("#808080");
      localObject1 = new File(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString);
      if ((localObject2 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((BubbleConfig)localObject2).jdField_a_of_type_JavaLangString;
        i = ((BubbleConfig)localObject2).jdField_b_of_type_Int;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
        ((ImageView)super.findViewById(2131363068)).setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_b_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
        {
          localObject1 = ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
          if (AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
          {
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_g_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label387:
            this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)this.app.getManager(41));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363078));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363079));
            this.jdField_c_of_type_AndroidWidgetTextView.setText("字体");
            if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager == null) {
              break label901;
            }
          }
        }
        label901:
        for (bool = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_Boolean;; bool = false)
        {
          if (this.jdField_f_of_type_Int > 0)
          {
            localObject1 = ((HiBoomManager)this.app.getManager(218)).a(this.jdField_f_of_type_Int);
            localObject2 = getResources().getDrawable(2130843994);
            if ((localObject1 != null) && (!TextUtils.isEmpty(((HiBoomItem)localObject1).jdField_b_of_type_JavaLangString)))
            {
              localObject1 = URLDrawable.getDrawable(((HiBoomItem)localObject1).jdField_b_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              label538:
              this.jdField_c_of_type_AndroidWidgetTextView.setText("嗨爆字体");
              label548:
              this.jdField_e_of_type_AndroidViewView = findViewById(2131363081);
              if (bool) {
                break label874;
              }
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              this.jdField_h_of_type_AndroidViewView.setVisibility(8);
            }
          }
          for (;;)
          {
            this.jdField_d_of_type_AndroidViewView.setVisibility(0);
            return;
            bool = true;
            break;
            label595:
            ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
            break label216;
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_g_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            break label387;
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
            break label387;
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break label538;
            if (!bool)
            {
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_g_of_type_AndroidViewView.setVisibility(8);
              break label548;
            }
            this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
            if (this.jdField_d_of_type_Int == -1)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
                break label843;
              }
              this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
              this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType;
            }
            for (;;)
            {
              localObject1 = getResources().getDrawable(2130843994);
              if (this.jdField_d_of_type_Int != 0) {
                ThreadManager.post(new uad(this), 8, null, true);
              }
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              if ((this.jdField_e_of_type_Int != 1) || (!ETEngine.getInstance().isEngineReady.get())) {
                break;
              }
              localObject1 = new ETFont(this.jdField_d_of_type_Int, FontManager.a(this.jdField_d_of_type_Int, 1), 16.0F);
              if (!ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
                break label851;
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setText("动态字体");
              break;
              label843:
              this.jdField_d_of_type_Int = 0;
            }
            label851:
            if (!ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1)) {
              break label548;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setText("DIY字体");
            break label548;
            label874:
            this.jdField_h_of_type_AndroidViewView.setVisibility(0);
            this.jdField_e_of_type_AndroidViewView.setVisibility(0);
            this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          }
        }
        localObject1 = "默认气泡";
      }
    }
  }
  
  public static void a(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString2 = paramQQAppInterface.a().a(paramString2, paramInt, paramLong);
    } while (paramString2 == null);
    if ((paramBoolean) && (((paramString2 instanceof MessageForMixedMsg)) || ((paramString2 instanceof MessageForLongMsg))))
    {
      QfavBuilder.b(paramString2).b(paramQQAppInterface, paramString2).a(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, 66, 8);
      return;
    }
    QfavBuilder.a(null, paramString1).b(paramQQAppInterface, paramString2).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 66, 1);
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (FontManager)this.app.getManager(41);
    int i = paramInt;
    if (paramInt == 0) {
      i = ((FontManager)localObject3).jdField_c_of_type_Int;
    }
    Object localObject2 = getResources().getDrawable(2130844056);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = getResources().getDrawable(2130844056);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    switch (i)
    {
    default: 
      localObject2 = (String)getResources().getText(2131433431);
      localObject1 = getResources().getDrawable(2130844061);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = ((FontManager)localObject3).h;
      try
      {
        localObject3 = URLDrawable.getDrawable(((FontManager)localObject3).i, localURLDrawableOptions);
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
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + i);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void b(int paramInt)
  {
    File localFile = new File(FontManager.jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = IndividuationUrlHelper.a("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    localObject1 = new DownloadTask((String)localObject1, localFile);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label90;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label82;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label82:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label90:
      if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
        {
          int i = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getX() - (int)paramMotionEvent.getX();
          int j = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getY() - (int)paramMotionEvent.getY();
          if ((i * i + j * j < 10000) && (paramMotionEvent.getEventTime() - this.jdField_a_of_type_AndroidViewMotionEvent.getEventTime() < 200L))
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (Build.VERSION.SDK_INT >= 11) {}
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(81);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_h_of_type_Int);
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
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
    if (this.jdField_c_of_type_JavaLangString != null) {}
    for (int i = this.jdField_c_of_type_JavaLangString.length();; i = 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i), "", "");
      super.finish();
      overridePendingTransition(0, 2131034141);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    int i;
    GameCenterManagerImp localGameCenterManagerImp;
    boolean bool;
    if (l - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l;
      i = paramView.getId();
      if ((i != 2131363072) && (i != 2131363073)) {
        break label922;
      }
      localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
      if (localGameCenterManagerImp == null) {
        break label2213;
      }
      if (localGameCenterManagerImp.a("100005.100003") == -1) {
        break label843;
      }
      bool = true;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject1 = IndividuationUrlHelper.a(this, "bubbleDetail", String.valueOf(this.jdField_b_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab");
      paramView = BubbleDiyFetcher.a();
      Object localObject5 = this.jdField_b_of_type_JavaLangString + "_" + this.jdField_c_of_type_Int;
      Object localObject3 = localObject1;
      Object localObject4;
      if (this.jdField_c_of_type_Int > 0)
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
              paramView = HtmlOffline.a((String)localObject1, "tl=" + (String)localObject3);
            }
            localObject3 = (String)((HashMap)localObject5).get("TR");
            localObject1 = paramView;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = HtmlOffline.a(paramView, "tr=" + (String)localObject3);
            }
            paramView = (String)((HashMap)localObject5).get("BL");
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(paramView)) {
              localObject3 = HtmlOffline.a((String)localObject1, "bl=" + paramView);
            }
            localObject1 = (String)((HashMap)localObject5).get("BR");
            paramView = (View)localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramView = HtmlOffline.a((String)localObject3, "br=" + (String)localObject1);
            }
          }
        }
        localObject3 = paramView;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {}
      }
      int j;
      int k;
      int m;
      int n;
      for (;;)
      {
        try
        {
          localObject1 = HtmlOffline.a(paramView, "diyText=" + URLEncoder.encode((String)localObject4, "UTF-8"));
          paramView = (View)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("TextPreviewActivity", 2, "TextPreviewActivity bubble url: " + Util.b(paramView, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 64L, localIntent, false, -1);
          paramView = this.jdField_b_of_type_JavaLangString;
          if (!bool) {
            break label872;
          }
          i = 1;
          VasWebviewUtil.reportCommercialDrainage(paramView, "bigtextpage", "bubble_enter", "", 1, 0, i, "", String.valueOf(this.jdField_b_of_type_Int), "");
          if (bool)
          {
            if (localGameCenterManagerImp.a("100005.100001") == -1) {
              break label877;
            }
            j = 1;
            if (localGameCenterManagerImp.a("100005.100002") == -1) {
              break label882;
            }
            k = 1;
            if (localGameCenterManagerImp.a("100005.100006") == -1) {
              break label888;
            }
            m = 1;
            if (localGameCenterManagerImp.a("100005.100018") == -1) {
              break label894;
            }
            n = 1;
            if (localGameCenterManagerImp.a("100005.100020") == -1) {
              break label900;
            }
            i1 = 1;
            if (localGameCenterManagerImp.a("100005.100021") == -1) {
              break label906;
            }
            i2 = 1;
            bool = ((FontManager)this.app.getManager(41)).jdField_a_of_type_Boolean;
            i = 0;
            if (bool)
            {
              if (localGameCenterManagerImp.a("100005.100011") == -1) {
                break label912;
              }
              i = 1;
            }
            if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0)))
            {
              if (localGameCenterManagerImp.a("100005") == -1) {
                break label917;
              }
              i = 1;
              if (i != 0) {
                ((RedTouchManager)this.app.getManager(35)).b("100005");
              }
            }
            ((RedTouchManager)this.app.getManager(35)).b("100005.100003");
          }
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label843:
          QLog.e("TextPreviewActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject3 = paramView;
        }
        bool = false;
        break;
        paramView = (View)localObject3;
        continue;
        label872:
        i = 0;
        continue;
        label877:
        j = 0;
        continue;
        label882:
        k = 0;
        continue;
        label888:
        m = 0;
        continue;
        label894:
        n = 0;
        continue;
        label900:
        int i1 = 0;
        continue;
        label906:
        int i2 = 0;
        continue;
        label912:
        i = 0;
        continue;
        label917:
        i = 0;
      }
      label922:
      if (i == 2131363077)
      {
        paramView = (GameCenterManagerImp)this.app.getManager(11);
        if (paramView == null) {
          break label2207;
        }
        if (paramView.a("100005.100011") != -1) {
          bool = true;
        }
      }
      for (;;)
      {
        Object localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("updateFlag", bool);
        ((Intent)localObject2).putExtra("fontId", this.jdField_d_of_type_Int);
        ((Intent)localObject2).putExtra("fromAIO", true);
        ((Intent)localObject2).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "fontDetail", String.valueOf(this.jdField_d_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject2, false, -1);
        localObject2 = this.jdField_b_of_type_JavaLangString;
        if (bool)
        {
          i = 1;
          label1060:
          VasWebviewUtil.reportCommercialDrainage((String)localObject2, "bigtextpage", "font_enter", "", 1, 0, i, "", String.valueOf(this.jdField_d_of_type_Int), "");
          if (!bool) {
            break;
          }
          if (paramView.a("100005.100001") == -1) {
            break label1232;
          }
          i = 1;
          label1108:
          if (paramView.a("100005.100002") == -1) {
            break label1237;
          }
          j = 1;
          label1121:
          if (paramView.a("100005.100006") == -1) {
            break label1242;
          }
          k = 1;
          label1135:
          if (paramView.a("100005.100003") == -1) {
            break label1248;
          }
          m = 1;
          label1149:
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
            if (paramView.a("100005") == -1) {
              break label1254;
            }
          }
        }
        label1232:
        label1237:
        label1242:
        label1248:
        label1254:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((RedTouchManager)this.app.getManager(35)).b("100005");
          }
          ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
          return;
          bool = false;
          break;
          i = 0;
          break label1060;
          i = 0;
          break label1108;
          j = 0;
          break label1121;
          k = 0;
          break label1135;
          m = 0;
          break label1149;
        }
        if (i == 2131363067)
        {
          localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
          if (localGameCenterManagerImp == null) {
            break label2202;
          }
          if (localGameCenterManagerImp.a("100005.100006") != -1) {
            i = 1;
          }
        }
        for (;;)
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          label1360:
          DiyPendantSticker localDiyPendantSticker;
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
          {
            l = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
            localObject3 = IndividuationUrlHelper.a(this, "pendantDetail", String.valueOf(l), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
            localObject2 = DiyPendantFetcher.a().a;
            localObject4 = new StringBuilder().append(this.jdField_b_of_type_JavaLangString).append("_");
            if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
              break label1630;
            }
            paramView = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label1425:
            paramView = (DiyPendantEntity)((LRULinkedHashMap)localObject2).get(paramView);
            if (paramView == null) {
              break label2196;
            }
            localObject4 = new ArrayList();
            localObject5 = paramView.getStickerInfoList().iterator();
            label1465:
            if (!((Iterator)localObject5).hasNext()) {
              break label1656;
            }
            localDiyPendantSticker = (DiyPendantSticker)((Iterator)localObject5).next();
            j = localDiyPendantSticker.type;
            k = localDiyPendantSticker.stickerId;
            m = localDiyPendantSticker.angle;
            if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
              break label1637;
            }
            paramView = "0";
            label1522:
            n = localDiyPendantSticker.fontId;
            if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
              break label1646;
            }
          }
          label1630:
          label1637:
          label1646:
          for (localObject2 = "0";; localObject2 = localDiyPendantSticker.fontColor)
          {
            ((List)localObject4).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), paramView, Integer.valueOf(n), localObject2, Integer.valueOf(localDiyPendantSticker.fontType) }));
            break label1465;
            i = 0;
            break;
            l = 0L;
            break label1360;
            paramView = "";
            break label1425;
            paramView = localDiyPendantSticker.text;
            break label1522;
          }
          label1656:
          paramView = TextUtils.join(";", (Iterable)localObject4);
          if (!TextUtils.isEmpty(paramView)) {
            paramView = URLEncoder.encode(paramView);
          }
          label1937:
          label2196:
          for (paramView = HtmlOffline.a((String)localObject3, "stickerInfo=" + paramView);; paramView = (View)localObject3)
          {
            localIntent.putExtra("url", paramView);
            localIntent.putExtra("business", 512L);
            localIntent.putExtra("individuation_url_type", 40301);
            localIntent.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 512L, localIntent, false, -1);
            paramView = this.jdField_b_of_type_JavaLangString;
            if (i != 0)
            {
              j = 1;
              VasWebviewUtil.reportCommercialDrainage(paramView, "bigtextpage", "pendant_enter", "", 1, 0, j, "", String.valueOf(l), "");
              if (i == 0) {
                break;
              }
              if (localGameCenterManagerImp.a("100005.100001") == -1) {
                break label1937;
              }
              i = 1;
              label1815:
              if (localGameCenterManagerImp.a("100005.100002") == -1) {
                break label1942;
              }
              j = 1;
              label1829:
              if (localGameCenterManagerImp.a("100005.100006") == -1) {
                break label1947;
              }
              k = 1;
              label1844:
              if (localGameCenterManagerImp.a("100005.100003") == -1) {
                break label1953;
              }
              m = 1;
              label1859:
              if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
                if (localGameCenterManagerImp.a("100005") == -1) {
                  break label1959;
                }
              }
            }
            label1942:
            label1947:
            label1953:
            label1959:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                ((RedTouchManager)this.app.getManager(35)).b("100005");
              }
              ((RedTouchManager)this.app.getManager(35)).b("100005.100011");
              return;
              j = 0;
              break;
              i = 0;
              break label1815;
              j = 0;
              break label1829;
              k = 0;
              break label1844;
              m = 0;
              break label1859;
            }
            if (i != 2131363081) {
              break;
            }
            localObject3 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("individuation_url_type", 40301);
            if (this.jdField_g_of_type_Int == 0)
            {
              localObject2 = IndividuationUrlHelper.a(this, "aioNoMagicFontEntrance", null);
              paramView = (View)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramView = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
              }
              if (TextUtils.isEmpty(paramView)) {
                break label2183;
              }
              paramView = paramView.replace("[id]", this.jdField_g_of_type_Int + "");
              if (QLog.isColorLevel()) {
                QLog.i("TextPreviewActivity", 2, "mFontEffectId=" + this.jdField_g_of_type_Int + " url=" + paramView);
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this, paramView, 0L, (Intent)localObject3, false, -1);
            }
            for (;;)
            {
              VasWebviewUtil.reportCommercialDrainage(this.jdField_b_of_type_JavaLangString, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.jdField_g_of_type_Int), "");
              return;
              localObject2 = IndividuationUrlHelper.a(this, "aioMagicFontEntrance", null);
              paramView = (View)localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              paramView = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
              break;
              QLog.e("TextPreviewActivity", 2, "url is empty.");
            }
          }
          label2183:
          label2202:
          i = 0;
        }
        label2207:
        bool = false;
      }
      label2213:
      bool = false;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
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
    }
    String str;
    label256:
    do
    {
      return;
      super.setContentView(2130968661);
      paramBundle = super.getIntent();
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("peeruin");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("real_msg_sender_uin");
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
      this.jdField_b_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("content");
      this.jdField_f_of_type_AndroidViewView = super.findViewById(2131363071);
      this.jdField_g_of_type_AndroidViewView = super.findViewById(2131363076);
      this.jdField_h_of_type_AndroidViewView = super.findViewById(2131363080);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("bubbleDiyId", 0);
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = SVIPHandler.b(paramBundle.getLongExtra("bubbleId", 0L));
      }
      this.jdField_f_of_type_Int = paramBundle.getIntExtra("HiBoomId", 0);
      str = paramBundle.getStringExtra("fontId");
      if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
        break label866;
      }
      if (FontManager.b(Long.parseLong(str)) != 0) {
        break;
      }
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363082));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363083));
      this.jdField_g_of_type_Int = paramBundle.getIntExtra("fontEffectId", 0);
      a(this.jdField_g_of_type_Int);
      long l = paramBundle.getLongExtra("uniseq", 0L);
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra(QIMUserManager.jdField_a_of_type_JavaLangString, true);
      this.jdField_a_of_type_Boolean = (paramBundle.getBooleanExtra(TIMUserManager.jdField_a_of_type_JavaLangString, true) | this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsHandler = new tzz(this, Looper.getMainLooper());
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.app.getManager(46));
      if (jdField_b_of_type_Long != l)
      {
        ContainerView.jdField_a_of_type_Float = 0.0F;
        jdField_b_of_type_Long = l;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131363062));
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131363061));
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
      this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363065);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363067);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131363077);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363072);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363073));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363075));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363069));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramBundle = (TextView)super.findViewById(2131363066);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    if (!this.jdField_b_of_type_JavaLangString.equals(this.app.getAccount())) {
      paramBundle.setText("TA正在使用的装扮");
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT < 11) || (this.jdField_c_of_type_JavaLangString != null))
      {
        QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + Base64Util.encodeToString(this.jdField_c_of_type_JavaLangString.getBytes(), 0));
        }
      }
      paramBundle = new QQText(this.jdField_c_of_type_JavaLangString, 13, 32, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      paramBundle = (WordMatchManager)this.app.getManager(81);
      if (paramBundle == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher == null) {
        break;
      }
      if (this.jdField_h_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_h_of_type_Int);
      }
      this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(1, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
      return;
      this.jdField_d_of_type_Int = ((int)FontManager.a(Long.parseLong(str)));
      this.jdField_e_of_type_Int = FontManager.b(Long.parseLong(str));
      break label256;
      label866:
      this.jdField_d_of_type_Int = -1;
      break label256;
      paramBundle.setText("我正在使用的装扮");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
    Object localObject = (WebProcessManager)this.app.getManager(12);
    if (localObject != null) {
      ((WebProcessManager)localObject).e();
    }
    localObject = BubbleDiyFetcher.a();
    String str = this.jdField_b_of_type_JavaLangString + "_" + this.jdField_c_of_type_Int;
    if ((this.jdField_c_of_type_Int > 0) && ((!((BubbleDiyFetcher)localObject).jdField_a_of_type_JavaUtilMap.containsKey(str)) || (!((BubbleDiyFetcher)localObject).b.containsKey(str)))) {
      ThreadManager.post(new uac(this, (BubbleDiyFetcher)localObject, str), 5, null, false);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */