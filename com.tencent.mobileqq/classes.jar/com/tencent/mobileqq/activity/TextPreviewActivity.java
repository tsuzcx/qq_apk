package com.tencent.mobileqq.activity;

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
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tts.TTSController;
import com.tencent.mobileqq.tts.TTSController.OnTTSPlayListener;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
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

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a;
  public static long b;
  private static final String jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131714750);
  public int a;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext = this;
  protected Rect a;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected MotionEvent a;
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected FontManager a;
  protected URLImageView a;
  private MergeForwardRevokeHelper jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper;
  private TextPreviewMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu;
  WordMatchManager.MatchCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback = new TextPreviewActivity.4(this);
  WordMatchManager.MatcherCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback = new TextPreviewActivity.5(this);
  WordMatchManager.WordMatcher jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = null;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public MessageRecord a;
  private TTSController.OnTTSPlayListener jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener;
  private TTSController jdField_a_of_type_ComTencentMobileqqTtsTTSController;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new TextPreviewActivity.9(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  public ContainerView a;
  public ParticipleBottomMenuView a;
  public ParticipleView a;
  public ScrollView a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
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
  private boolean jdField_c_of_type_Boolean = false;
  protected int d;
  protected View d;
  TextView d;
  protected String d;
  int e;
  protected View e;
  protected String e;
  int f;
  protected View f;
  protected String f;
  int jdField_g_of_type_Int = 0;
  protected View g;
  private String jdField_g_of_type_JavaLangString = null;
  int jdField_h_of_type_Int;
  protected View h;
  int i;
  public View i;
  public View j;
  public View k;
  public View l;
  public View m;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714755);
  }
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_i_of_type_Int = 0;
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, DownloadListener paramDownloadListener)
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
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new DownloadTask((String)localObject1, localFile);
    ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a((DownloadTask)localObject1, paramDownloadListener, (Bundle)localObject2);
  }
  
  private void c()
  {
    LiuHaiUtils.a(this);
  }
  
  private void d()
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject3 = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    Object localObject2 = ((BubbleManager)localObject3).a(this.jdField_c_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    boolean bool;
    if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())))
    {
      bool = false;
      if ((this.jdField_d_of_type_Int <= 0) || (localObject1 == BubbleUtils.a)) {
        break label626;
      }
      localObject2 = (HashMap)BubbleDiyFetcher.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int));
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
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        ((TextView)super.findViewById(2131364201)).setText(getResources().getText(2131690024));
      }
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
      label227:
      localObject3 = ((BubbleManager)localObject3).a(((BubbleInfo)localObject1).jdField_a_of_type_Int, true);
      localObject2 = HardCodeUtil.a(2131714740);
      n = Color.parseColor("#808080");
      localObject1 = new File(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString);
      if ((localObject3 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((BubbleConfig)localObject3).jdField_a_of_type_JavaLangString;
        n = ((BubbleConfig)localObject3).jdField_b_of_type_Int;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(n);
        ((ImageView)super.findViewById(2131368281)).setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_d_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
        {
          localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
          if (AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId))
          {
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            label409:
            this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)this.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367321));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367313));
            this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714749));
            if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager == null) {
              break label937;
            }
          }
        }
        label912:
        label937:
        for (bool = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_Boolean;; bool = false)
        {
          if (this.jdField_g_of_type_Int > 0)
          {
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            localObject1 = (HiBoomManager)this.app.getManager(QQManagerFactory.HIBOOM_MANAGER);
            localObject2 = ((HiBoomManager)localObject1).a(this.jdField_g_of_type_Int);
            if (((HiBoomItem)localObject2).b != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((HiBoomItem)localObject2).b);
              label559:
              this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714743));
              this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
            }
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidViewView = findViewById(2131370986);
            if ((bool) && (this.jdField_g_of_type_Int <= 0)) {
              break label912;
            }
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            this.jdField_h_of_type_AndroidViewView.setVisibility(8);
            return;
            bool = true;
            break;
            label626:
            ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
            break label227;
            ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            break label409;
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
            break label409;
            ThreadManagerV2.excute(new TextPreviewActivity.7(this, (HiBoomManager)localObject1), 64, null, true);
            break label559;
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
                  break label881;
                }
                this.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
                this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType;
              }
              for (;;)
              {
                localObject1 = getResources().getDrawable(2130847424);
                if (this.jdField_e_of_type_Int != 0) {
                  ThreadManager.post(new TextPreviewActivity.8(this), 8, null, true);
                }
                this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                if ((this.jdField_f_of_type_Int != 1) || (!ETEngine.getInstance().isEngineReady.get())) {
                  break;
                }
                localObject1 = new ETFont(this.jdField_e_of_type_Int, FontManager.a(this.jdField_e_of_type_Int, 1), 16.0F);
                if (!ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
                  break label889;
                }
                this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
                break;
                label881:
                this.jdField_e_of_type_Int = 0;
              }
              label889:
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
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838449);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838450);
    }
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (FontManager)this.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
    int n = paramInt;
    if (paramInt == 0) {
      n = ((FontManager)localObject3).jdField_c_of_type_Int;
    }
    Object localObject2 = getResources().getDrawable(2130847519);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = getResources().getDrawable(2130847519);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    switch (n)
    {
    default: 
      localObject2 = (String)getResources().getText(2131690026);
      localObject1 = getResources().getDrawable(2130847535);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = ((FontManager)localObject3).jdField_h_of_type_JavaLangString;
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
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.a(paramString, this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
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
      str2 = ((ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
      str1 = str2;
      if ("null".equals(str2)) {
        str1 = "0";
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
        break label295;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      String str3 = this.jdField_d_of_type_JavaLangString;
      int n = this.jdField_c_of_type_Int;
      int i1 = this.jdField_e_of_type_Int;
      int i2 = this.jdField_h_of_type_Int;
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label301;
      }
      str2 = this.jdField_d_of_type_JavaLangString;
      label140:
      localIntent.putExtra("url", String.format("https://zb.vip.qq.com/v2/aioPage?targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", new Object[] { str3, Long.valueOf(l1), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str1, str2, Integer.valueOf(this.jdField_b_of_type_Int) }));
      startActivity(localIntent);
      str2 = this.app.getCurrentAccountUin();
      if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
        break label310;
      }
    }
    label295:
    label301:
    label310:
    for (String str1 = "1";; str1 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(str2, "aio", "icon_click", "", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
      return;
      l1 = 0L;
      break;
      str2 = this.jdField_b_of_type_JavaLangString;
      break label140;
    }
  }
  
  public void b(String paramString)
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, HardCodeUtil.a(2131714754), 0).b(getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.a())
    {
      a(paramString);
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool;
    if (this.jdField_c_of_type_Boolean) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
        break label227;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label219;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      break;
      label219:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label227:
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
    ((HiBoomManager)this.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).b = null;
    if (Build.VERSION.SDK_INT >= 11) {}
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_i_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.c(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTtsTTSController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.b();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.a();
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
      ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(n), "", "");
      super.finish();
      overridePendingTransition(0, 2130772013);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    int n;
    GameCenterManagerImp localGameCenterManagerImp;
    boolean bool;
    if (l1 - this.jdField_c_of_type_Long > 500L)
    {
      this.jdField_c_of_type_Long = l1;
      n = paramView.getId();
      if ((n != 2131364196) && (n != 2131364206)) {
        break label954;
      }
      localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
      if (localGameCenterManagerImp == null) {
        break label2428;
      }
      if (localGameCenterManagerImp.a("100005.100003") == -1) {
        break label874;
      }
      bool = true;
    }
    label904:
    label909:
    label914:
    label920:
    label1436:
    label1820:
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject2 = IndividuationUrlHelper.a(this, "bubbleDetail", String.valueOf(this.jdField_c_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab");
      Object localObject1 = BubbleDiyFetcher.a();
      Object localObject6 = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
      Object localObject4 = localObject2;
      Object localObject5;
      if (this.jdField_d_of_type_Int > 0)
      {
        localObject5 = (String)((BubbleDiyFetcher)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject6);
        localObject6 = (HashMap)((BubbleDiyFetcher)localObject1).b.get(localObject6);
        localObject1 = localObject2;
        if (localObject6 != null)
        {
          localObject1 = localObject2;
          if (((HashMap)localObject6).size() > 0)
          {
            localObject4 = (String)((HashMap)localObject6).get("TL");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = HtmlOffline.a((String)localObject2, "tl=" + (String)localObject4);
            }
            localObject4 = (String)((HashMap)localObject6).get("TR");
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject2 = HtmlOffline.a((String)localObject1, "tr=" + (String)localObject4);
            }
            localObject1 = (String)((HashMap)localObject6).get("BL");
            localObject4 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject4 = HtmlOffline.a((String)localObject2, "bl=" + (String)localObject1);
            }
            localObject2 = (String)((HashMap)localObject6).get("BR");
            localObject1 = localObject4;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = HtmlOffline.a((String)localObject4, "br=" + (String)localObject2);
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
          localObject2 = HtmlOffline.a((String)localObject1, "diyText=" + URLEncoder.encode((String)localObject5, "UTF-8"));
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("TextPreviewActivity", 2, "TextPreviewActivity bubble url: " + Util.b((String)localObject1, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 64L, localIntent, false, -1);
          localObject1 = this.jdField_d_of_type_JavaLangString;
          if (!bool) {
            break label904;
          }
          n = 1;
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "bubble_enter", "", 1, 0, n, "", String.valueOf(this.jdField_c_of_type_Int), "");
          if (bool)
          {
            if (localGameCenterManagerImp.a("100005.100001") == -1) {
              break label909;
            }
            i1 = 1;
            if (localGameCenterManagerImp.a("100005.100002") == -1) {
              break label914;
            }
            i2 = 1;
            if (localGameCenterManagerImp.a("100005.100006") == -1) {
              break label920;
            }
            i3 = 1;
            if (localGameCenterManagerImp.a("100005.100018") == -1) {
              break label926;
            }
            i4 = 1;
            if (localGameCenterManagerImp.a("100005.100020") == -1) {
              break label932;
            }
            i5 = 1;
            if (localGameCenterManagerImp.a("100005.100021") == -1) {
              break label938;
            }
            i6 = 1;
            bool = ((FontManager)this.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).jdField_a_of_type_Boolean;
            n = 0;
            if (bool)
            {
              if (localGameCenterManagerImp.a("100005.100011") == -1) {
                break label944;
              }
              n = 1;
            }
            if (((bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (n == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)) || ((!bool) && (i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0) && (i6 == 0)))
            {
              if (localGameCenterManagerImp.a("100005") == -1) {
                break label949;
              }
              n = 1;
              if (n != 0) {
                ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005");
              }
            }
            ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005.100003");
          }
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label874:
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
        label926:
        i4 = 0;
        continue;
        label932:
        int i5 = 0;
        continue;
        label938:
        int i6 = 0;
        continue;
        label944:
        n = 0;
        continue;
        label949:
        n = 0;
        continue;
        label954:
        if (n != 2131367303) {
          break label1441;
        }
        if (this.jdField_g_of_type_Int <= 0) {
          break label1098;
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("fontId", this.jdField_g_of_type_Int);
        ((Intent)localObject1).putExtra("fromAIO", true);
        ((Intent)localObject1).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "fontDetail", String.valueOf(this.jdField_g_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject1, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.jdField_g_of_type_Int, "");
      }
      label1098:
      localObject1 = (GameCenterManagerImp)this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
      if (localObject1 != null) {
        if (((GameCenterManagerImp)localObject1).a("100005.100011") != -1) {
          bool = true;
        }
      }
      label1311:
      label1326:
      label1711:
      label1971:
      for (;;)
      {
        label1133:
        Object localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("updateFlag", bool);
        ((Intent)localObject3).putExtra("fontId", this.jdField_e_of_type_Int);
        ((Intent)localObject3).putExtra("fromAIO", true);
        ((Intent)localObject3).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "fontDetail", String.valueOf(this.jdField_e_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject3, false, -1);
        localObject3 = this.jdField_d_of_type_JavaLangString;
        if (bool)
        {
          n = 1;
          label1233:
          VasWebviewUtil.reportCommercialDrainage((String)localObject3, "bigtextpage", "font_enter", "", 1, 0, n, "", String.valueOf(this.jdField_e_of_type_Int), "");
          if (!bool) {
            break;
          }
          if (((GameCenterManagerImp)localObject1).a("100005.100001") == -1) {
            break label1414;
          }
          n = 1;
          if (((GameCenterManagerImp)localObject1).a("100005.100002") == -1) {
            break label1419;
          }
          i1 = 1;
          if (((GameCenterManagerImp)localObject1).a("100005.100006") == -1) {
            break label1424;
          }
          i2 = 1;
          if (((GameCenterManagerImp)localObject1).a("100005.100003") == -1) {
            break label1430;
          }
          i3 = 1;
          if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
            if (((GameCenterManagerImp)localObject1).a("100005") == -1) {
              break label1436;
            }
          }
        }
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005");
          }
          ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005.100011");
          break;
          bool = false;
          break label1133;
          n = 0;
          break label1233;
          n = 0;
          break label1282;
          i1 = 0;
          break label1296;
          i2 = 0;
          break label1311;
          i3 = 0;
          break label1326;
        }
        if (n == 2131372835)
        {
          localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
          if (localGameCenterManagerImp == null) {
            break label2417;
          }
          if (localGameCenterManagerImp.a("100005.100006") != -1) {
            n = 1;
          }
        }
        label1609:
        label2398:
        for (;;)
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          label1653:
          DiyPendantSticker localDiyPendantSticker;
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
          {
            l1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
            localObject4 = IndividuationUrlHelper.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
            localObject3 = DiyPendantFetcher.a().a;
            localObject5 = new StringBuilder().append(this.jdField_d_of_type_JavaLangString).append("_");
            if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
              break label1820;
            }
            localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
            localObject1 = (DiyPendantEntity)((LRULinkedHashMap)localObject3).get(localObject1);
            if (localObject1 == null) {
              break label2410;
            }
            localObject5 = new ArrayList();
            localObject6 = ((DiyPendantEntity)localObject1).getStickerInfoList().iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break label1848;
            }
            localDiyPendantSticker = (DiyPendantSticker)((Iterator)localObject6).next();
            i1 = localDiyPendantSticker.type;
            i2 = localDiyPendantSticker.stickerId;
            i3 = localDiyPendantSticker.angle;
            if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
              break label1828;
            }
            localObject1 = "0";
            i4 = localDiyPendantSticker.fontId;
            if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
              break label1838;
            }
          }
          for (localObject3 = "0";; localObject3 = localDiyPendantSticker.fontColor)
          {
            ((List)localObject5).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), localObject1, Integer.valueOf(i4), localObject3, Integer.valueOf(localDiyPendantSticker.fontType) }));
            break label1653;
            n = 0;
            break;
            l1 = 0L;
            break label1543;
            localObject1 = "";
            break label1609;
            localObject1 = localDiyPendantSticker.text;
            break label1711;
          }
          localObject1 = TextUtils.join(";", (Iterable)localObject5);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject1 = URLEncoder.encode((String)localObject1);
          }
          label2017:
          label2148:
          label2153:
          label2410:
          for (localObject1 = HtmlOffline.a((String)localObject4, "stickerInfo=" + (String)localObject1);; localObject1 = localObject4)
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
              if (localGameCenterManagerImp.a("100005.100001") == -1) {
                break label2143;
              }
              n = 1;
              if (localGameCenterManagerImp.a("100005.100002") == -1) {
                break label2148;
              }
              i1 = 1;
              label2031:
              if (localGameCenterManagerImp.a("100005.100006") == -1) {
                break label2153;
              }
              i2 = 1;
              label2046:
              if (localGameCenterManagerImp.a("100005.100003") == -1) {
                break label2159;
              }
              i3 = 1;
              if ((n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) {
                if (localGameCenterManagerImp.a("100005") == -1) {
                  break label2165;
                }
              }
            }
            label2159:
            label2165:
            for (n = 1;; n = 0)
            {
              if (n != 0) {
                ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005");
              }
              ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005.100011");
              break;
              i1 = 0;
              break label1971;
              n = 0;
              break label2017;
              i1 = 0;
              break label2031;
              i2 = 0;
              break label2046;
              i3 = 0;
              break label2061;
            }
            if (n != 2131370986) {
              break;
            }
            localObject4 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("individuation_url_type", 40301);
            if (this.jdField_h_of_type_Int == 0)
            {
              localObject3 = IndividuationUrlHelper.a(this, "aioNoMagicFontEntrance", null);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label2398;
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
              localObject3 = IndividuationUrlHelper.a(this, "aioMagicFontEntrance", null);
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2236;
              }
              localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
              break label2236;
              QLog.e("TextPreviewActivity", 2, "url is empty.");
            }
          }
          label2143:
          label2417:
          n = 0;
        }
        label1848:
        label2236:
        bool = false;
      }
      label1441:
      label1828:
      label1838:
      label2428:
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
        super.setContentView(2131558682);
        paramBundle = super.getIntent();
        this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("peeruin");
        this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("senderUin");
        this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("real_msg_sender_uin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
        this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isMultiMsg", false);
        this.jdField_c_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
        this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("content");
        this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("troop_at_info");
        this.jdField_f_of_type_AndroidViewView = super.findViewById(2131372855);
        this.jdField_g_of_type_AndroidViewView = super.findViewById(2131364205);
        this.jdField_h_of_type_AndroidViewView = super.findViewById(2131367320);
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("sessionType", -2);
        this.jdField_d_of_type_Int = paramBundle.getIntExtra("bubbleDiyId", 0);
        if (this.jdField_d_of_type_Int == 0) {
          this.jdField_d_of_type_Int = SVIPHandler.b(paramBundle.getLongExtra("bubbleId", 0L));
        }
        this.jdField_g_of_type_Int = paramBundle.getIntExtra("HiBoomId", 0);
        str = paramBundle.getStringExtra("fontId");
        if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
          break label1374;
        }
        if (FontManager.b(Long.parseLong(str)) == 0)
        {
          this.jdField_e_of_type_Int = -1;
          this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131370988));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370987));
          this.jdField_h_of_type_Int = paramBundle.getIntExtra("fontEffectId", 0);
          a(this.jdField_h_of_type_Int);
          long l1 = paramBundle.getLongExtra("uniseq", 0L);
          this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra(QIMUserManager.jdField_a_of_type_JavaLangString, true);
          this.jdField_b_of_type_Boolean = (paramBundle.getBooleanExtra(TIMUserManager.jdField_a_of_type_JavaLangString, true) | this.jdField_b_of_type_Boolean);
          if (SimpleUIUtil.a()) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_d_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("TextPreviewActivity", 2, "previewBubble sender:" + this.jdField_d_of_type_JavaLangString + ",bubbleId:" + this.jdField_c_of_type_Int + ",bubbleDiyId:" + this.jdField_d_of_type_Int + ",FontId:" + str + ",hiBoomId:" + this.jdField_g_of_type_Int + ",fontEffectId:" + this.jdField_h_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqTtsTTSController = new TTSController(this.app, this);
          this.jdField_a_of_type_AndroidOsHandler = new TextPreviewActivity.1(this, Looper.getMainLooper());
          if (this.jdField_g_of_type_Int != 0) {
            ((HiBoomManager)this.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).b = this.jdField_a_of_type_AndroidOsHandler;
          }
          if (jdField_b_of_type_Long != l1)
          {
            ContainerView.jdField_a_of_type_Float = 0.0F;
            jdField_b_of_type_Long = l1;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131365294));
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
          this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131378744));
          this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363801);
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372835);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367303);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131364196);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131373727));
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372748));
          this.jdField_i_of_type_AndroidViewView = findViewById(2131363804);
          this.j = findViewById(2131367262);
          this.k = findViewById(2131378360);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368970));
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838450);
          this.l = findViewById(2131365388);
          this.m = findViewById(2131367318);
          if (this.m != null)
          {
            str = this.app.getCurrentAccountUin();
            if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
              break label1382;
            }
            paramBundle = "1";
            VasWebviewUtil.reportCommercialDrainage(str, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364206));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364202));
          this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131372856));
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          paramBundle = (TextView)super.findViewById(2131381035);
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break;
          }
          if (this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())) {
            break label1389;
          }
          paramBundle.setText("TA正在使用的装扮");
          if ((Build.VERSION.SDK_INT < 11) || (this.jdField_e_of_type_JavaLangString != null))
          {
            QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.jdField_e_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + Base64Util.encodeToString(this.jdField_e_of_type_JavaLangString.getBytes(), 0));
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1399;
          }
          paramBundle = this.app.getMultiMessageProxy();
          if (paramBundle != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramBundle.a(jdField_b_of_type_Long);
          }
          ECommerceDataReportUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1);
          paramBundle = ColorNickManager.a(this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 30, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = new TextPreviewMenu();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
          paramBundle = (WordMatchManager)this.app.getManager(QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER);
          if (paramBundle != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
            if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher != null)
            {
              if (this.jdField_i_of_type_Int != 0) {
                this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(this.jdField_i_of_type_Int);
              }
              this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(1, this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener = new TextPreviewActivity.3(this);
          this.jdField_a_of_type_ComTencentMobileqqTtsTTSController.a(this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper = new MergeForwardRevokeHelper();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.a(this);
          this.mFlingHandler = new TextPreviewActivity.CustomFlingHandler(this, null);
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
      this.jdField_e_of_type_Int = ((int)FontManager.a(Long.parseLong(str)));
      this.jdField_f_of_type_Int = FontManager.b(Long.parseLong(str));
      continue;
      label1374:
      this.jdField_e_of_type_Int = -1;
      continue;
      label1382:
      paramBundle = "2";
      continue;
      label1389:
      paramBundle.setText(jdField_h_of_type_JavaLangString);
      continue;
      label1399:
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.app.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, jdField_b_of_type_Long);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    Object localObject = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject != null) {
      ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
    }
    localObject = BubbleDiyFetcher.a();
    String str = this.jdField_d_of_type_JavaLangString + "_" + this.jdField_d_of_type_Int;
    if ((this.jdField_d_of_type_Int > 0) && ((!((BubbleDiyFetcher)localObject).jdField_a_of_type_JavaUtilMap.containsKey(str)) || (!((BubbleDiyFetcher)localObject).b.containsKey(str)))) {
      ThreadManager.post(new TextPreviewActivity.6(this, (BubbleDiyFetcher)localObject, str), 5, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.b(this);
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