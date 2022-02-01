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
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
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
  public static long A;
  public static final String a = HardCodeUtil.a(2131912194);
  private static final String ai = HardCodeUtil.a(2131912189);
  protected MotionEvent B;
  protected Rect C = null;
  protected IFontManagerService D = null;
  Handler E;
  int F = 0;
  int G = 0;
  Context H = this;
  ExtensionInfo I = null;
  protected long J = 0L;
  protected View K;
  protected View L;
  protected View M;
  TextView N;
  int O = 0;
  int P;
  URLImageView Q;
  TextView R;
  protected QQProgressDialog S;
  public ParticipleView T;
  public ParticipleBottomMenuView U;
  public View V;
  public View W;
  public View X;
  public View Y;
  public View Z;
  public MessageRecord aa;
  WordMatchManager.WordMatcher ab = null;
  int ac = 0;
  CharSequence ad = null;
  WordMatchManager.MatchCallback ae = new TextPreviewActivity.3(this);
  WordMatchManager.MatcherCallback af = new TextPreviewActivity.4(this);
  DownloadListener ag = new TextPreviewActivity.8(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private String ah = null;
  private TextPreviewMenu aj;
  private MergeForwardRevokeHelper ak;
  private ITtsController al;
  private ImageView am;
  private AnimationDrawable an;
  private boolean ao = false;
  public int b = 0;
  public String c = null;
  public String d = null;
  public int e;
  public boolean f = false;
  protected String g = null;
  protected String h;
  protected String i;
  protected int j;
  protected int k;
  protected int l = -1;
  protected String m = null;
  protected boolean n;
  public ContainerView o;
  public ScrollView p;
  protected TextView q;
  protected TextView r;
  protected URLImageView s;
  protected ImageView t;
  protected View u;
  protected View v;
  protected View w;
  protected View x;
  protected View y;
  protected long z = 0L;
  
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
  
  private void d()
  {
    LiuHaiUtils.f(this);
  }
  
  private void e()
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  private void f()
  {
    this.x.setVisibility(8);
    if (!this.n) {
      return;
    }
    Object localObject3 = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    Object localObject2 = ((BubbleManager)localObject3).c(this.j, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    localObject2 = this.g;
    boolean bool;
    if ((localObject2 != null) && (!((String)localObject2).equals(this.app.getAccount()))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((this.k > 0) && (localObject1 != BubbleUtils.a))
    {
      localObject2 = (HashMap)BubbleDiyFetcher.a().k.get(Integer.valueOf(this.j));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((DiyBubbleConfig)((Iterator)localObject2).next()).e.equalsIgnoreCase("static"))
          {
            i1 = 1;
            break label191;
          }
        }
        i1 = 0;
        label191:
        if (i1 == 0) {
          ((TextView)super.findViewById(2131430085)).setText(getResources().getText(2131886580));
        }
      }
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.q, this.g, this.k);
    }
    else
    {
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, this.q, false);
    }
    localObject3 = ((BubbleManager)localObject3).a(((BubbleInfo)localObject1).a, true);
    localObject2 = HardCodeUtil.a(2131912179);
    int i2 = Color.parseColor("#808080");
    File localFile = new File(((BubbleInfo)localObject1).b);
    localObject1 = localObject2;
    int i1 = i2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      i1 = i2;
      if (localFile.exists())
      {
        localObject1 = ((BubbleConfig)localObject3).b;
        i1 = ((BubbleConfig)localObject3).c;
      }
    }
    this.r.setText((CharSequence)localObject1);
    this.r.setTextColor(i1);
    ((ImageView)super.findViewById(2131434878)).setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.g));
    localObject1 = this.I;
    if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
    {
      localObject1 = ((AvatarPendantManager)this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.I.pendantId);
      if (AvatarPendantUtil.a(this.I.pendantId)) {
        ((PendantInfo)localObject1).a(this.s, 2, PendantInfo.h, this.g, this.I.pendantDiyId);
      } else {
        ((PendantInfo)localObject1).a(this.s, 1, PendantInfo.h, this.g, this.I.pendantDiyId);
      }
    }
    else
    {
      this.s.setImageDrawable(null);
    }
    this.D = ((IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, ""));
    this.t = ((ImageView)super.findViewById(2131433558));
    this.t.setVisibility(0);
    this.N = ((TextView)super.findViewById(2131433550));
    this.N.setText(HardCodeUtil.a(2131912188));
    localObject1 = this.D;
    if (localObject1 != null) {
      bool = ((IFontManagerService)localObject1).isSupportFont();
    } else {
      bool = false;
    }
    if (this.O > 0)
    {
      this.K.setVisibility(8);
      this.w.setVisibility(8);
      localObject1 = ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager();
      localObject2 = ((IHiBoomManager)localObject1).getHiBoomItemById(this.O);
      if (((HiBoomItem)localObject2).h != null) {
        this.t.setImageBitmap(((HiBoomItem)localObject2).h);
      } else {
        ThreadManagerV2.excute(new TextPreviewActivity.6(this, (IHiBoomManager)localObject1), 64, null, true);
      }
      this.N.setText(HardCodeUtil.a(2131912182));
      this.v.setOnClickListener(this);
    }
    else if (!bool)
    {
      this.v.setVisibility(8);
      this.L.setVisibility(8);
    }
    else
    {
      this.v.setOnClickListener(this);
      if (this.F == -1)
      {
        localObject1 = this.I;
        if (localObject1 != null)
        {
          this.F = ((int)((ExtensionInfo)localObject1).uVipFont);
          this.G = this.I.vipFontType;
        }
        else
        {
          this.F = 0;
        }
      }
      localObject1 = getResources().getDrawable(2130848944);
      if (this.F != 0) {
        ThreadManager.post(new TextPreviewActivity.7(this), 8, null, true);
      }
      this.t.setImageDrawable((Drawable)localObject1);
      if ((this.G == 1) && (ETEngine.getInstance().isEngineReady.get()))
      {
        i1 = this.F;
        localObject1 = new ETFont(i1, FontManagerConstants.getTTFPath(i1, 1), 16.0F);
        if (ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
          this.N.setText(a);
        } else if (ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1)) {
          this.N.setText("DIY字体");
        }
      }
    }
    this.y = findViewById(2131437894);
    if ((bool) && (this.O <= 0))
    {
      this.M.setVisibility(0);
      this.y.setVisibility(0);
      this.y.setOnClickListener(this);
      return;
    }
    this.y.setVisibility(8);
    this.M.setVisibility(8);
  }
  
  private void g()
  {
    this.am.setBackgroundResource(2130838344);
    this.an = ((AnimationDrawable)this.am.getBackground());
    this.an.start();
  }
  
  private void h()
  {
    this.al = ((ITtsController)QRoute.api(ITtsController.class));
    String str = this.app.getCurrentAccountUin();
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager == null)
    {
      this.al = null;
      return;
    }
    this.al.init(str, localTicketManager.getSkey(str), 0);
    this.al.setTtsListener(new TextPreviewActivity.10(this));
  }
  
  private void i()
  {
    QQAudioUtils.a(this, true);
    m();
    g();
  }
  
  private void j()
  {
    QQAudioUtils.a(this, false);
    m();
    b();
  }
  
  private void k()
  {
    QQAudioUtils.a(this, false);
    b();
    l();
  }
  
  private void l()
  {
    if (this.S == null) {
      this.S = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
    }
    if (!isFinishing()) {
      this.S.show();
    }
  }
  
  private void m()
  {
    QQProgressDialog localQQProgressDialog = this.S;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.S.dismiss();
    }
  }
  
  public int a()
  {
    return this.l;
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, "");
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = ((IFontManagerService)localObject3).getFontEffectPrefer();
    }
    Object localObject1 = getResources().getDrawable(2130849038);
    Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = getResources().getDrawable(2130849038);
    ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject2);
    if (i1 != 2000)
    {
      localObject2 = (String)getResources().getText(2131886582);
      localObject1 = getResources().getDrawable(2130849057);
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
    this.R.setText((CharSequence)localObject2);
    this.Q.setImageDrawable((Drawable)localObject1);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      l();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new TextPreviewActivity.9(this), 2000L);
      QLog.d("TextPreviewActivity", 1, "[startSpeechAndAnimation] network invalid.");
      return;
    }
    QLog.d("TextPreviewActivity", 1, new Object[] { "[startSpeechAndAnimation] attempt to play text: ", Character.valueOf(paramString.charAt(0)) });
    if (this.al == null) {
      h();
    }
    ITtsController localITtsController = this.al;
    if (localITtsController == null)
    {
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131905493), 0).show();
      return;
    }
    if (localITtsController.isWorking())
    {
      this.al.stop();
      return;
    }
    this.al.speak(paramString, this.g);
  }
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() != 0) {
      return false;
    }
    if (this.C == null) {
      this.C = new Rect();
    }
    paramView.getDrawingRect(this.C);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = this.C;
    paramView.left = arrayOfInt[0];
    paramView.top = arrayOfInt[1];
    paramView.right += arrayOfInt[0];
    paramView = this.C;
    paramView.bottom += arrayOfInt[1];
    return this.C.contains(paramInt1, paramInt2);
  }
  
  public void b()
  {
    Drawable localDrawable = this.am.getBackground();
    if ((localDrawable instanceof AnimationDrawable))
    {
      this.an = ((AnimationDrawable)localDrawable);
      this.an.stop();
      this.am.setBackgroundResource(2130838345);
    }
  }
  
  public void c()
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.J) > 2000L)
    {
      this.J = l1;
      Object localObject2 = ((ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.app.getCurrentAccountUin(), this.g);
      Object localObject1 = localObject2;
      if ("null".equals(localObject2)) {
        localObject1 = "0";
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localObject2 = this.I;
      if (localObject2 != null) {
        l1 = ((ExtensionInfo)localObject2).pendantId;
      } else {
        l1 = 0L;
      }
      String str2 = this.g;
      int i1 = this.j;
      int i2 = this.F;
      int i3 = this.P;
      String str1 = this.c;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = this.g;
      }
      localObject1 = String.format("https://zb.vip.qq.com/v2/aioPage?targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", new Object[] { str2, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), localObject1, localObject2, Integer.valueOf(this.e) });
      if (TextUtils.equals(this.g, this.app.getCurrentAccountUin())) {
        i1 = 38;
      } else {
        i1 = 37;
      }
      localIntent.putExtra("url", VasWebviewUtil.b((String)localObject1, i1));
      startActivity(localIntent);
      localObject2 = this.app.getCurrentAccountUin();
      if (TextUtils.equals(this.g, this.app.getCurrentAccountUin())) {
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
    if (this.ao)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else if (this.T.getVisibility() == 0)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else if ((!a(this.x, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.V, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.T, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.U, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (!a(this.Z, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
    {
      if (!this.o.a(this)) {
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.o.a()) {
            this.B = MotionEvent.obtain(paramMotionEvent);
          } else {
            this.B = null;
          }
        }
        else if ((this.B != null) && (paramMotionEvent.getAction() == 1)) {
          if (!this.o.a(this))
          {
            int i1 = (int)this.B.getX() - (int)paramMotionEvent.getX();
            int i2 = (int)this.B.getY() - (int)paramMotionEvent.getY();
            if ((i1 * i1 + i2 * i2 < 10000) && (paramMotionEvent.getEventTime() - this.B.getEventTime() < 200L))
            {
              this.B = null;
              finish();
            }
          }
          else
          {
            this.B = null;
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
    if (!this.aj.d()) {
      super.doOnBackPressed();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager().setAIOPreviewHandler(null);
    int i1 = Build.VERSION.SDK_INT;
    Object localObject = (WordMatchManager)this.app.getManager(QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER);
    if (localObject != null) {
      ((WordMatchManager)localObject).b(this.af);
    }
    localObject = this.ab;
    if (localObject != null) {
      ((WordMatchManager.WordMatcher)localObject).a(this.ac);
    }
    localObject = this.o;
    if (localObject != null)
    {
      this.aj.b((ContainerView)localObject);
      this.aj = null;
    }
    localObject = this.ak;
    if (localObject != null) {
      ((MergeForwardRevokeHelper)localObject).c(this);
    }
    localObject = this.al;
    if (localObject != null) {
      ((ITtsController)localObject).destroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.aj.c();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    ITtsController localITtsController = this.al;
    if (localITtsController != null) {
      localITtsController.stop();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      ContainerView localContainerView = this.o;
      if ((localContainerView != null) && (this.p != null) && (localContainerView.getHeight() < this.p.getHeight())) {
        this.o.setMinimumHeight(this.p.getHeight());
      }
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.z;
    String str = this.h;
    int i1;
    if (str != null) {
      i1 = str.length();
    } else {
      i1 = 0;
    }
    ReportController.b(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i1), "", "");
    super.finish();
    overridePendingTransition(0, 2130772025);
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
      super.setContentView(2131624138);
      Object localObject = super.getIntent();
      this.c = ((Intent)localObject).getStringExtra("peeruin");
      this.d = ((Intent)localObject).getStringExtra("senderUin");
      this.g = ((Intent)localObject).getStringExtra("real_msg_sender_uin");
      this.b = ((Intent)localObject).getIntExtra("uin_type", 0);
      this.f = ((Intent)localObject).getBooleanExtra("isMultiMsg", false);
      this.j = ((int)((Intent)localObject).getLongExtra("bubbleId", 0L));
      this.h = ((Intent)localObject).getStringExtra("content");
      this.i = ((Intent)localObject).getStringExtra("troop_at_info");
      this.K = super.findViewById(2131439956);
      this.L = super.findViewById(2131430089);
      this.M = super.findViewById(2131433557);
      this.e = ((Intent)localObject).getIntExtra("sessionType", -2);
      this.l = ((Intent)localObject).getIntExtra("anistickerLocID", -1);
      if (((Intent)localObject).hasExtra("anistickerResultID")) {
        this.m = ((Intent)localObject).getStringExtra("anistickerResultID");
      }
      this.k = ((Intent)localObject).getIntExtra("bubbleDiyId", 0);
      if (this.k == 0) {
        this.k = SVIPHandlerConstants.b(((Intent)localObject).getLongExtra("bubbleId", 0L));
      }
      this.O = ((Intent)localObject).getIntExtra("HiBoomId", 0);
      paramBundle = ((Intent)localObject).getStringExtra("fontId");
      if ((!TextUtils.isEmpty(paramBundle)) && (TextUtils.isDigitsOnly(paramBundle)))
      {
        if (FontManagerConstants.parseFontType(Long.parseLong(paramBundle)) == 0)
        {
          this.F = -1;
        }
        else
        {
          this.F = ((int)FontManagerConstants.parseFontId(Long.parseLong(paramBundle)));
          this.G = FontManagerConstants.parseFontType(Long.parseLong(paramBundle));
        }
      }
      else {
        this.F = -1;
      }
      this.Q = ((URLImageView)findViewById(2131437896));
      this.R = ((TextView)findViewById(2131437895));
      this.P = ((Intent)localObject).getIntExtra("fontEffectId", 0);
      a(this.P);
      long l1 = ((Intent)localObject).getLongExtra("uniseq", 0L);
      this.n = ((Intent)localObject).getBooleanExtra(QIMUserManager.a, true);
      this.n = (((Intent)localObject).getBooleanExtra(TIMUserManager.a, true) | this.n);
      if (SimpleUIUtil.e()) {
        this.n = false;
      }
      this.I = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.g);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previewBubble sender:");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(",bubbleId:");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(",bubbleDiyId:");
        ((StringBuilder)localObject).append(this.k);
        ((StringBuilder)localObject).append(",FontId:");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(",hiBoomId:");
        ((StringBuilder)localObject).append(this.O);
        ((StringBuilder)localObject).append(",fontEffectId:");
        ((StringBuilder)localObject).append(this.P);
        QLog.d("TextPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.E = new TextPreviewActivity.1(this, Looper.getMainLooper());
      if (this.O != 0) {
        ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager().setAIOPreviewHandler(this.E);
      }
      if (A != l1)
      {
        ContainerView.b = 0.0F;
        A = l1;
      }
      this.o = ((ContainerView)super.findViewById(2131431322));
      this.o.setMsgHandler(this.E);
      this.p = ((ScrollView)super.findViewById(2131446648));
      this.p.setOverScrollMode(2);
      this.o.setOutScrollView(this.p);
      this.x = super.findViewById(2131429654);
      this.u = super.findViewById(2131439936);
      this.u.setOnClickListener(this);
      this.v = super.findViewById(2131433540);
      this.w = super.findViewById(2131430080);
      this.w.setOnClickListener(this);
      this.T = ((ParticipleView)findViewById(2131440910));
      this.U = ((ParticipleBottomMenuView)findViewById(2131439839));
      this.V = findViewById(2131429656);
      this.W = findViewById(2131433495);
      this.X = findViewById(2131446229);
      this.am = ((ImageView)findViewById(2131435605));
      this.am.setBackgroundResource(2130838345);
      this.Y = findViewById(2131431422);
      this.Z = findViewById(2131433555);
      if (this.Z != null)
      {
        localObject = this.app.getCurrentAccountUin();
        if (TextUtils.equals(this.g, this.app.getCurrentAccountUin())) {
          paramBundle = "1";
        } else {
          paramBundle = "2";
        }
        VasWebviewUtil.a((String)localObject, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
      }
      this.q = ((TextView)super.findViewById(2131430090));
      this.r = ((TextView)super.findViewById(2131430086));
      this.s = ((URLImageView)super.findViewById(2131439957));
      this.x.setVisibility(8);
      paramBundle = (TextView)super.findViewById(2131449222);
      if (TextUtils.isEmpty(this.g)) {
        return;
      }
      if (!this.g.equals(this.app.getAccount())) {
        paramBundle.setText("TA正在使用的装扮");
      } else {
        paramBundle.setText(ai);
      }
      int i1 = Build.VERSION.SDK_INT;
      if (this.h != null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("");
        paramBundle.append(this.h);
        QLog.i("TextPreviewActivity.hotWordDebug", 1, paramBundle.toString());
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("");
          paramBundle.append(Base64Util.encodeToString(this.h.getBytes(), 0));
          QLog.i("TextPreviewActivity.hotWordDebug", 2, paramBundle.toString());
        }
      }
      if (this.f)
      {
        paramBundle = this.app.getMultiMessageProxy();
        if (paramBundle != null) {
          this.aa = paramBundle.b(A);
        }
      }
      else
      {
        this.aa = this.app.getMessageFacade().a(this.c, this.e, A);
      }
      ECommerceDataReportUtil.a(this.app, this.aa, 1);
      this.o.setAniStickerLocID(this.l);
      this.o.setAniStickerResult(this.m);
      this.o.setIsSendMsg(this.d.equalsIgnoreCase(this.app.getCurrentAccountUin()));
      paramBundle = ColorNickManager.a(this.h, this.i, 30, this.aa, 13);
      this.o.setText(paramBundle);
      this.aj = new TextPreviewMenu();
      this.aj.a(this, this.o);
      this.o.c.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      paramBundle = (WordMatchManager)this.app.getManager(QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER);
      if (paramBundle != null)
      {
        this.ab = paramBundle.a(this.af);
        paramBundle = this.ab;
        if (paramBundle != null)
        {
          i1 = this.ac;
          if (i1 != 0) {
            paramBundle.a(i1);
          }
          this.ac = this.ab.a(1, this.h, 3, this.ae);
        }
      }
      this.ak = new MergeForwardRevokeHelper();
      this.ak.a(this);
      this.mFlingHandler = new TextPreviewActivity.CustomFlingHandler(this, null);
      d();
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("TextPreviewActivity", 1, "", paramBundle);
      finish();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(0);
    AbstractGifImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    AbstractGifImage.resumeAll();
    f();
    Object localObject1 = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject1 != null) {
      ((IWebProcessManagerService)localObject1).startWebProcess(-1, null);
    }
    localObject1 = BubbleDiyFetcher.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.k);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((this.k > 0) && ((!((BubbleDiyFetcher)localObject1).c.containsKey(localObject2)) || (!((BubbleDiyFetcher)localObject1).d.containsKey(localObject2)))) {
      ThreadManager.post(new TextPreviewActivity.5(this, (BubbleDiyFetcher)localObject1, (String)localObject2), 5, null, false);
    }
    this.ak.b(this);
    this.aj.b();
    e();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.z = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */