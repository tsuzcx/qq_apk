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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tts.ITtsController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a;
  public static long b;
  private static final String jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131714680);
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
  protected URLImageView a;
  private MergeForwardRevokeHelper jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper;
  private TextPreviewMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu;
  WordMatchManager.MatchCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback = new TextPreviewActivity.3(this);
  WordMatchManager.MatcherCallback jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback = new TextPreviewActivity.4(this);
  WordMatchManager.WordMatcher jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = null;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  public MessageRecord a;
  private ITtsController jdField_a_of_type_ComTencentMobileqqTtsITtsController;
  protected IFontManagerService a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new TextPreviewActivity.8(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  public ContainerView a;
  protected QQProgressDialog a;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714685);
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
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_i_of_type_Int = 0;
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, DownloadListener paramDownloadListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append("fontname.png");
    File localFile = new File(((StringBuilder)localObject1).toString());
    Object localObject2 = IndividuationUrlHelper.a("fontAioImg");
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFontInfo fontId=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" will down ,file path=");
      ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
      QLog.d("TextPreviewActivity", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new DownloadTask((String)localObject1, localFile);
    ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload((DownloadTask)localObject1, paramDownloadListener, (Bundle)localObject2);
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
    localObject2 = this.jdField_d_of_type_JavaLangString;
    boolean bool;
    if ((localObject2 != null) && (!((String)localObject2).equals(this.app.getAccount()))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((this.jdField_d_of_type_Int > 0) && (localObject1 != BubbleUtils.a))
    {
      localObject2 = (HashMap)BubbleDiyFetcher.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((DiyBubbleConfig)((Iterator)localObject2).next()).jdField_b_of_type_JavaLangString.equalsIgnoreCase("static"))
          {
            n = 1;
            break label191;
          }
        }
        n = 0;
        label191:
        if (n == 0) {
          ((TextView)super.findViewById(2131364118)).setText(getResources().getText(2131689939));
        }
      }
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
    }
    else
    {
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.jdField_a_of_type_AndroidWidgetTextView, false);
    }
    localObject3 = ((BubbleManager)localObject3).a(((BubbleInfo)localObject1).jdField_a_of_type_Int, true);
    localObject2 = HardCodeUtil.a(2131714670);
    int i1 = Color.parseColor("#808080");
    File localFile = new File(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    int n = i1;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      n = i1;
      if (localFile.exists())
      {
        localObject1 = ((BubbleConfig)localObject3).jdField_a_of_type_JavaLangString;
        n = ((BubbleConfig)localObject3).jdField_b_of_type_Int;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(n);
    ((ImageView)super.findViewById(2131368033)).setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_d_of_type_JavaLangString));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
    if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
    {
      localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId)) {
        ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      } else {
        ((PendantInfo)localObject1).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_g_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService = ((IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, ""));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367104));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367096));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714679));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService;
    if (localObject1 != null) {
      bool = ((IFontManagerService)localObject1).isSupportFont();
    } else {
      bool = false;
    }
    if (this.jdField_g_of_type_Int > 0)
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      localObject1 = ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager();
      localObject2 = ((IHiBoomManager)localObject1).getHiBoomItemById(this.jdField_g_of_type_Int);
      if (((HiBoomItem)localObject2).b != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(((HiBoomItem)localObject2).b);
      } else {
        ThreadManagerV2.excute(new TextPreviewActivity.6(this, (IHiBoomManager)localObject1), 64, null, true);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714673));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    else if (!bool)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      if (this.jdField_e_of_type_Int == -1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
        if (localObject1 != null)
        {
          this.jdField_e_of_type_Int = ((int)((ExtensionInfo)localObject1).uVipFont);
          this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType;
        }
        else
        {
          this.jdField_e_of_type_Int = 0;
        }
      }
      localObject1 = getResources().getDrawable(2130847293);
      if (this.jdField_e_of_type_Int != 0) {
        ThreadManager.post(new TextPreviewActivity.7(this), 8, null, true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      if ((this.jdField_f_of_type_Int == 1) && (ETEngine.getInstance().isEngineReady.get()))
      {
        n = this.jdField_e_of_type_Int;
        localObject1 = new ETFont(n, FontManagerConstants.getTTFPath(n, 1), 16.0F);
        if (ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
        } else if (ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1)) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText("DIY字体");
        }
      }
    }
    this.jdField_e_of_type_AndroidViewView = findViewById(2131370620);
    if ((bool) && (this.jdField_g_of_type_Int <= 0))
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_h_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838296);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getBackground());
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTtsITtsController = ((ITtsController)QRoute.api(ITtsController.class));
    String str = this.app.getCurrentAccountUin();
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTtsITtsController = null;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsITtsController.init(str, localTicketManager.getSkey(str), 0);
    this.jdField_a_of_type_ComTencentMobileqqTtsITtsController.setTtsListener(new TextPreviewActivity.10(this));
  }
  
  private void h()
  {
    QQAudioUtils.a(this, true);
    l();
    f();
  }
  
  private void i()
  {
    QQAudioUtils.a(this, false);
    l();
    a();
  }
  
  private void j()
  {
    QQAudioUtils.a(this, false);
    a();
    k();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299168));
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void l()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a()
  {
    Drawable localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getBackground();
    if ((localDrawable instanceof AnimationDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)localDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838297);
    }
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, "");
    int n = paramInt;
    if (paramInt == 0) {
      n = ((IFontManagerService)localObject3).getFontEffectPrefer();
    }
    Object localObject1 = getResources().getDrawable(2130847387);
    Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = getResources().getDrawable(2130847387);
    ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject2);
    if (n != 2000)
    {
      localObject2 = (String)getResources().getText(2131689941);
      localObject1 = getResources().getDrawable(2130847403);
    }
    else
    {
      localObject2 = ((IFontManagerService)localObject3).getEnlargeFontDesc();
      try
      {
        localObject3 = URLDrawable.getDrawable(((IFontManagerService)localObject3).getEnlargeFontImgURL(), (URLDrawable.URLDrawableOptions)localObject4);
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("font effect exception, ");
        ((StringBuilder)localObject4).append(localException.getMessage());
        QLog.e("TextPreviewActivity", 1, ((StringBuilder)localObject4).toString());
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      k();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new TextPreviewActivity.9(this), 2000L);
      QLog.d("TextPreviewActivity", 1, "[startSpeechAndAnimation] network invalid.");
      return;
    }
    QLog.d("TextPreviewActivity", 1, new Object[] { "[startSpeechAndAnimation] attempt to play text: ", Character.valueOf(paramString.charAt(0)) });
    if (this.jdField_a_of_type_ComTencentMobileqqTtsITtsController == null) {
      g();
    }
    ITtsController localITtsController = this.jdField_a_of_type_ComTencentMobileqqTtsITtsController;
    if (localITtsController == null)
    {
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131707679), 0).a();
      return;
    }
    if (localITtsController.isWorking())
    {
      this.jdField_a_of_type_ComTencentMobileqqTtsITtsController.stop();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsITtsController.speak(paramString, this.jdField_d_of_type_JavaLangString);
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
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.left = arrayOfInt[0];
    paramView.top = arrayOfInt[1];
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.bottom += arrayOfInt[1];
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) > 2000L)
    {
      this.jdField_c_of_type_Long = l1;
      Object localObject2 = ((ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.app.getCurrentAccountUin(), this.jdField_d_of_type_JavaLangString);
      Object localObject1 = localObject2;
      if ("null".equals(localObject2)) {
        localObject1 = "0";
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      if (localObject2 != null) {
        l1 = ((ExtensionInfo)localObject2).pendantId;
      } else {
        l1 = 0L;
      }
      String str2 = this.jdField_d_of_type_JavaLangString;
      int n = this.jdField_c_of_type_Int;
      int i1 = this.jdField_e_of_type_Int;
      int i2 = this.jdField_h_of_type_Int;
      String str1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = this.jdField_d_of_type_JavaLangString;
      }
      localObject1 = String.format("https://zb.vip.qq.com/v2/aioPage?targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", new Object[] { str2, Long.valueOf(l1), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1, localObject2, Integer.valueOf(this.jdField_b_of_type_Int) });
      if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
        n = 38;
      } else {
        n = 37;
      }
      localIntent.putExtra("url", VasWebviewUtil.a((String)localObject1, n));
      startActivity(localIntent);
      localObject2 = this.app.getCurrentAccountUin();
      if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      VasWebviewUtil.a((String)localObject2, "aio", "icon_click", "", 0, 0, 0, "", "", (String)localObject1, "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool;
    if (this.jdField_c_of_type_Boolean)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.getVisibility() == 0)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else if ((!a(this.jdField_d_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_i_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.m, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this)) {
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
            this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          } else {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
          }
        }
        else if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
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
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager().setAIOPreviewHandler(null);
    int n = Build.VERSION.SDK_INT;
    Object localObject = (WordMatchManager)this.app.getManager(QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER);
    if (localObject != null) {
      ((WordMatchManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher;
    if (localObject != null) {
      ((WordMatchManager.WordMatcher)localObject).a(this.jdField_i_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b((ContainerView)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper;
    if (localObject != null) {
      ((MergeForwardRevokeHelper)localObject).c(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTtsITtsController;
    if (localObject != null) {
      ((ITtsController)localObject).destroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    ITtsController localITtsController = this.jdField_a_of_type_ComTencentMobileqqTtsITtsController;
    if (localITtsController != null) {
      localITtsController.stop();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      ContainerView localContainerView = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
      if ((localContainerView != null) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null) && (localContainerView.getHeight() < this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMinimumHeight(this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight());
      }
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    String str = this.jdField_e_of_type_JavaLangString;
    int n;
    if (str != null) {
      n = str.length();
    } else {
      n = 0;
    }
    ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(n), "", "");
    super.finish();
    overridePendingTransition(0, 2130772022);
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
      return;
    }
    try
    {
      super.setContentView(2131558580);
      Object localObject = super.getIntent();
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("peeruin");
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderUin");
      this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("real_msg_sender_uin");
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uin_type", 0);
      this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isMultiMsg", false);
      this.jdField_c_of_type_Int = ((int)((Intent)localObject).getLongExtra("bubbleId", 0L));
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("content");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("troop_at_info");
      this.jdField_f_of_type_AndroidViewView = super.findViewById(2131372434);
      this.jdField_g_of_type_AndroidViewView = super.findViewById(2131364122);
      this.jdField_h_of_type_AndroidViewView = super.findViewById(2131367103);
      this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("sessionType", -2);
      this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("bubbleDiyId", 0);
      if (this.jdField_d_of_type_Int == 0) {
        this.jdField_d_of_type_Int = SVIPHandlerConstants.b(((Intent)localObject).getLongExtra("bubbleId", 0L));
      }
      this.jdField_g_of_type_Int = ((Intent)localObject).getIntExtra("HiBoomId", 0);
      paramBundle = ((Intent)localObject).getStringExtra("fontId");
      if ((!TextUtils.isEmpty(paramBundle)) && (TextUtils.isDigitsOnly(paramBundle)))
      {
        if (FontManagerConstants.parseFontType(Long.parseLong(paramBundle)) == 0)
        {
          this.jdField_e_of_type_Int = -1;
        }
        else
        {
          this.jdField_e_of_type_Int = ((int)FontManagerConstants.parseFontId(Long.parseLong(paramBundle)));
          this.jdField_f_of_type_Int = FontManagerConstants.parseFontType(Long.parseLong(paramBundle));
        }
      }
      else {
        this.jdField_e_of_type_Int = -1;
      }
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131370622));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370621));
      this.jdField_h_of_type_Int = ((Intent)localObject).getIntExtra("fontEffectId", 0);
      a(this.jdField_h_of_type_Int);
      long l1 = ((Intent)localObject).getLongExtra("uniseq", 0L);
      this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra(QIMUserManager.jdField_a_of_type_JavaLangString, true);
      this.jdField_b_of_type_Boolean = (((Intent)localObject).getBooleanExtra(TIMUserManager.jdField_a_of_type_JavaLangString, true) | this.jdField_b_of_type_Boolean);
      if (SimpleUIUtil.a()) {
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previewBubble sender:");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",bubbleId:");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(",bubbleDiyId:");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject).append(",FontId:");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(",hiBoomId:");
        ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject).append(",fontEffectId:");
        ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
        QLog.d("TextPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_AndroidOsHandler = new TextPreviewActivity.1(this, Looper.getMainLooper());
      if (this.jdField_g_of_type_Int != 0) {
        ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager().setAIOPreviewHandler(this.jdField_a_of_type_AndroidOsHandler);
      }
      if (jdField_b_of_type_Long != l1)
      {
        ContainerView.jdField_a_of_type_Float = 0.0F;
        jdField_b_of_type_Long = l1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131365169));
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131378139));
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
      this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363731);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372414);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367086);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131364113);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView = ((ParticipleView)findViewById(2131373299));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372325));
      this.jdField_i_of_type_AndroidViewView = findViewById(2131363733);
      this.j = findViewById(2131367045);
      this.k = findViewById(2131377769);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368692));
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838297);
      this.l = findViewById(2131365253);
      this.m = findViewById(2131367101);
      if (this.m != null)
      {
        localObject = this.app.getCurrentAccountUin();
        if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          paramBundle = "1";
        } else {
          paramBundle = "2";
        }
        VasWebviewUtil.a((String)localObject, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364123));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364119));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131372435));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramBundle = (TextView)super.findViewById(2131380301);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        return;
      }
      if (!this.jdField_d_of_type_JavaLangString.equals(this.app.getAccount())) {
        paramBundle.setText("TA正在使用的装扮");
      } else {
        paramBundle.setText(jdField_h_of_type_JavaLangString);
      }
      int n = Build.VERSION.SDK_INT;
      if (this.jdField_e_of_type_JavaLangString != null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("");
        paramBundle.append(this.jdField_e_of_type_JavaLangString);
        QLog.i("TextPreviewActivity.hotWordDebug", 1, paramBundle.toString());
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("");
          paramBundle.append(Base64Util.encodeToString(this.jdField_e_of_type_JavaLangString.getBytes(), 0));
          QLog.i("TextPreviewActivity.hotWordDebug", 2, paramBundle.toString());
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = this.app.getMultiMessageProxy();
        if (paramBundle != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramBundle.a(jdField_b_of_type_Long);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.app.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, jdField_b_of_type_Long);
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
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher;
        if (paramBundle != null)
        {
          n = this.jdField_i_of_type_Int;
          if (n != 0) {
            paramBundle.a(n);
          }
          this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher.a(1, this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper = new MergeForwardRevokeHelper();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.a(this);
      this.mFlingHandler = new TextPreviewActivity.CustomFlingHandler(this, null);
      c();
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("TextPreviewActivity", 1, "", paramBundle);
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
    Object localObject1 = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject1 != null) {
      ((IWebProcessManagerService)localObject1).startWebProcess(-1, null);
    }
    localObject1 = BubbleDiyFetcher.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((this.jdField_d_of_type_Int > 0) && ((!((BubbleDiyFetcher)localObject1).jdField_a_of_type_JavaUtilMap.containsKey(localObject2)) || (!((BubbleDiyFetcher)localObject1).b.containsKey(localObject2)))) {
      ThreadManager.post(new TextPreviewActivity.5(this, (BubbleDiyFetcher)localObject1, (String)localObject2), 5, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a();
    d();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */