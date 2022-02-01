package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.DiyBubbleConfig;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextPreviewSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  ExtensionInfo a = null;
  DownloadListener b = new TextPreviewSettingActivity.5(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private View c;
  private View d;
  private View e;
  private View f;
  private int g;
  private int h;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l;
  private String m = null;
  private Handler n;
  private IFontManagerService o;
  
  private void a()
  {
    Object localObject3 = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    Object localObject2 = ((BubbleManager)localObject3).c(this.g, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BubbleUtils.a;
    }
    localObject2 = this.m;
    boolean bool;
    if ((localObject2 != null) && (!((String)localObject2).equals(this.app.getAccount()))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject2 = (TextView)findViewById(2131430090);
    if ((this.h > 0) && (localObject1 != BubbleUtils.a))
    {
      localObject4 = (HashMap)BubbleDiyFetcher.a().k.get(Integer.valueOf(this.g));
      if ((localObject4 != null) && (((HashMap)localObject4).size() > 0))
      {
        localObject4 = ((HashMap)localObject4).values().iterator();
        while (((Iterator)localObject4).hasNext()) {
          if (((DiyBubbleConfig)((Iterator)localObject4).next()).e.equalsIgnoreCase("static"))
          {
            i1 = 1;
            break label184;
          }
        }
        i1 = 0;
        label184:
        if (i1 == 0)
        {
          localObject4 = (TextView)super.findViewById(2131430085);
          if (localObject4 != null) {
            ((TextView)localObject4).setText(getResources().getText(2131886580));
          }
        }
      }
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, (View)localObject2, this.m, this.h);
    }
    else
    {
      ((BubbleInfo)localObject1).a(this.app, bool, true, false, (View)localObject2, false);
    }
    Object localObject4 = ((BubbleManager)localObject3).a(((BubbleInfo)localObject1).a, true);
    localObject3 = HardCodeUtil.a(2131912187);
    if (bool) {
      localObject2 = "#FFFFFF";
    } else {
      localObject2 = "#808080";
    }
    int i2 = Color.parseColor((String)localObject2);
    localObject2 = new File(((BubbleInfo)localObject1).b);
    localObject1 = localObject3;
    int i1 = i2;
    if (localObject4 != null)
    {
      localObject1 = localObject3;
      i1 = i2;
      if (((File)localObject2).exists())
      {
        localObject1 = ((BubbleConfig)localObject4).b;
        i1 = ((BubbleConfig)localObject4).c;
      }
    }
    localObject2 = (TextView)findViewById(2131430086);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    ((TextView)localObject2).setTextColor(i1);
    this.o = ((IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, ""));
    localObject1 = this.o;
    if (localObject1 != null) {
      bool = ((IFontManagerService)localObject1).isSupportFont();
    } else {
      bool = false;
    }
    localObject1 = (ImageView)findViewById(2131433558);
    if (this.i > 0)
    {
      localObject2 = ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager();
      localObject3 = ((IHiBoomManager)localObject2).getHiBoomItemById(this.i);
      if (((HiBoomItem)localObject3).h != null)
      {
        ((ImageView)localObject1).setImageBitmap(((HiBoomItem)localObject3).h);
        return;
      }
      ThreadManagerV2.excute(new TextPreviewSettingActivity.3(this, (IHiBoomManager)localObject2), 64, null, true);
      return;
    }
    if (bool)
    {
      if (this.j == -1)
      {
        localObject2 = this.a;
        if (localObject2 != null)
        {
          this.j = ((int)((ExtensionInfo)localObject2).uVipFont);
          this.k = this.a.vipFontType;
        }
        else
        {
          this.j = 0;
        }
      }
      localObject2 = getResources().getDrawable(2130848944);
      if (this.j != 0) {
        ThreadManager.post(new TextPreviewSettingActivity.4(this), 8, null, true);
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
    }
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
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFontInfo fontId=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" will down ,file path=");
      ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
      com.tencent.qphone.base.util.QLog.d("TextPreviewSettingActivity", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new DownloadTask((String)localObject1, localFile);
    ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload((DownloadTask)localObject1, paramDownloadListener, (Bundle)localObject2);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(paramAppInterface, 1, 4, this.m);
      Object localObject2 = null;
      ExtensionInfo localExtensionInfo = this.a;
      Object localObject1 = localObject2;
      if (localExtensionInfo != null)
      {
        localObject1 = localObject2;
        if (localExtensionInfo.isPendantValid())
        {
          paramAppInterface = ((AvatarPendantManager)paramAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.a.pendantId);
          if (AvatarPendantUtil.a(this.a.pendantId)) {
            localObject1 = paramAppInterface.a(2, PendantInfo.h, this.m, this.a.pendantDiyId);
          } else {
            localObject1 = paramAppInterface.a(1, PendantInfo.h, this.m, this.a.pendantDiyId);
          }
        }
      }
      ((ImageView)findViewById(2131434878)).setImageDrawable(localFaceDrawable);
      ((ImageView)findViewById(2131439957)).setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.g = localIntent.getIntExtra("bubbleId", 0);
    this.h = localIntent.getIntExtra("bubbleDiyId", 0);
    if (this.h == 0) {
      this.h = SVIPHandlerConstants.b(localIntent.getLongExtra("bubbleId", 0L));
    }
    this.i = localIntent.getIntExtra("HiBoomId", 0);
    this.j = localIntent.getIntExtra("fontId", 0);
    this.l = localIntent.getIntExtra("fontEffectId", 0);
    this.m = localIntent.getStringExtra("real_msg_sender_uin");
    this.l = localIntent.getIntExtra("fontEffectId", 0);
  }
  
  private void c()
  {
    Object localObject1 = (GameCenterManagerImp)this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    int i1;
    if (localObject1 != null)
    {
      if (((GameCenterManagerImp)localObject1).a("100005.100006") != -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    else {
      i1 = 0;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localObject1 = this.a;
    long l1;
    if (localObject1 != null) {
      l1 = ((ExtensionInfo)localObject1).pendantId;
    } else {
      l1 = 0L;
    }
    String str = IndividuationUrlHelper.a(this, "pendantDetail", String.valueOf(l1), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
    Object localObject2 = DiyPendantFetcher.a().d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.m);
    ((StringBuilder)localObject3).append("_");
    localObject1 = this.a;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ExtensionInfo)localObject1).pendantDiyId);
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject3).append(localObject1);
    localObject2 = (DiyPendantEntity)((LRULinkedHashMap)localObject2).get(((StringBuilder)localObject3).toString());
    localObject1 = str;
    if (localObject2 != null)
    {
      localObject3 = new ArrayList();
      Iterator localIterator = ((DiyPendantEntity)localObject2).getStickerInfoList().iterator();
      while (localIterator.hasNext())
      {
        DiyPendantSticker localDiyPendantSticker = (DiyPendantSticker)localIterator.next();
        int i2 = localDiyPendantSticker.type;
        int i3 = localDiyPendantSticker.stickerId;
        int i4 = localDiyPendantSticker.angle;
        boolean bool = TextUtils.isEmpty(localDiyPendantSticker.text);
        localObject2 = "0";
        if (bool) {
          localObject1 = "0";
        } else {
          localObject1 = localDiyPendantSticker.text;
        }
        int i5 = localDiyPendantSticker.fontId;
        if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
          localObject2 = localDiyPendantSticker.fontColor;
        }
        ((List)localObject3).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), localObject1, Integer.valueOf(i5), localObject2, Integer.valueOf(localDiyPendantSticker.fontType) }));
      }
      localObject2 = TextUtils.join(";", (Iterable)localObject3);
      localObject1 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = URLEncoder.encode((String)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("stickerInfo=");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = HtmlOffline.a(str, ((StringBuilder)localObject2).toString());
      }
    }
    localIntent.putExtra("url", (String)localObject1);
    localIntent.putExtra("business", 512L);
    localIntent.putExtra("individuation_url_type", 40301);
    localIntent.putExtra("isShowAd", false);
    VasWebviewUtil.b(this, (String)localObject1, 512L, localIntent, false, -1);
    VasWebviewUtil.a(this.m, "bigtextpage", "pendant_enter", "", 1, 0, i1, "", String.valueOf(l1), "");
  }
  
  private void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40301);
    Object localObject2;
    Object localObject1;
    if (this.l == 0)
    {
      localObject2 = IndividuationUrlHelper.a(this, "aioNoMagicFontEntrance", null);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
      }
    }
    else
    {
      localObject2 = IndividuationUrlHelper.a(this, "aioMagicFontEntrance", null);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.l);
      ((StringBuilder)localObject2).append("");
      localObject1 = ((String)localObject1).replace("[id]", ((StringBuilder)localObject2).toString());
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mFontEffectId=");
        ((StringBuilder)localObject2).append(this.l);
        ((StringBuilder)localObject2).append(" url=");
        ((StringBuilder)localObject2).append((String)localObject1);
        com.tencent.qphone.base.util.QLog.i("TextPreviewSettingActivity", 2, ((StringBuilder)localObject2).toString());
      }
      VasWebviewUtil.b(this, (String)localObject1, 0L, localIntent, false, -1);
    }
    else
    {
      com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 2, "url is empty.");
    }
    VasWebviewUtil.a(this.m, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.l), "");
  }
  
  void a(int paramInt)
  {
    Object localObject2 = (IFontManagerService)this.app.getRuntimeService(IFontManagerService.class, "");
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = ((IFontManagerService)localObject2).getFontEffectPrefer();
    }
    Object localObject1 = getResources().getDrawable(2130849038);
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = getResources().getDrawable(2130849038);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localDrawable;
    if (i1 != 2000)
    {
      localObject1 = (String)getResources().getText(2131886582);
      localObject1 = getResources().getDrawable(2130849057);
    }
    else
    {
      ((IFontManagerService)localObject2).getEnlargeFontDesc();
      try
      {
        localObject2 = URLDrawable.getDrawable(((IFontManagerService)localObject2).getEnlargeFontImgURL(), (URLDrawable.URLDrawableOptions)localObject3);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("font effect exception, ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 1, ((StringBuilder)localObject3).toString());
      }
    }
    ((ImageView)findViewById(2131437896)).setImageDrawable((Drawable)localObject1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131624139);
    paramBundle = getAppInterface();
    if (paramBundle == null)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("TextPreviewSettingActivity", 0, "get AppInterface failed in TextPreviewSettingActivity#doOnCreate");
      }
      return false;
    }
    b();
    this.a = ((FriendsManager)paramBundle.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.m);
    setTitle(HardCodeUtil.a(2131912178));
    setContentBackgroundResource(2130838958);
    this.c = findViewById(2131439936);
    this.d = findViewById(2131430080);
    this.e = findViewById(2131433540);
    this.f = findViewById(2131437894);
    a(paramBundle);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.n = new TextPreviewSettingActivity.1(this, Looper.getMainLooper());
    this.o = ((IFontManagerService)paramBundle.getRuntimeService(IFontManagerService.class, ""));
    a(this.l);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    Object localObject1 = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject1 != null) {
      ((IWebProcessManagerService)localObject1).startWebProcess(-1, null);
    }
    localObject1 = BubbleDiyFetcher.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.m);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.h);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((this.h > 0) && ((!((BubbleDiyFetcher)localObject1).c.containsKey(localObject2)) || (!((BubbleDiyFetcher)localObject1).d.containsKey(localObject2)))) {
      ThreadManager.post(new TextPreviewSettingActivity.2(this, (BubbleDiyFetcher)localObject1, (String)localObject2), 5, null, false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439936: 
    case 2131439944: 
      c();
      break;
    case 2131437894: 
    case 2131437895: 
      f();
      break;
    case 2131433540: 
    case 2131433550: 
      e();
      break;
    case 2131430080: 
    case 2131430085: 
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity
 * JD-Core Version:    0.7.0.1
 */