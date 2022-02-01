package com.tencent.mobileqq.apollo.aio;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.OnVisibilityChangedListener;
import com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl;
import com.tencent.mobileqq.apollo.aio.ui.IChatPieApolloViewController;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.brickengine.BKUtils;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.statistic.IScriptStatistic;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatPieApolloViewController
  implements AIOShortcutBarHelper.OnVisibilityChangedListener, IChatPieApolloViewController
{
  public BarrageView a;
  public InputGlobalLayoutListener b;
  private ICMShowEngine c;
  private ICMShowView d;
  private ICMShowEngine e;
  private ICMShowView f;
  private int g;
  private int h;
  private int i;
  private IScriptStatistic j = new ChatPieApolloViewController.1(this);
  
  /* Error */
  @org.jetbrains.annotations.NotNull
  private void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 47	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 53	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   12: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_3
    //   27: new 63	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 70	java/io/File:exists	()Z
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: getstatic 76	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   45: invokevirtual 80	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnonnull +12 -> 62
    //   53: ldc 82
    //   55: iconst_1
    //   56: ldc 84
    //   58: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: aload_1
    //   63: iload_2
    //   64: invokestatic 95	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnonnull +12 -> 83
    //   74: ldc 82
    //   76: iconst_1
    //   77: ldc 97
    //   79: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: aconst_null
    //   84: astore 5
    //   86: aconst_null
    //   87: astore_1
    //   88: new 99	java/io/FileOutputStream
    //   91: dup
    //   92: aload_3
    //   93: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   96: astore_3
    //   97: aload 4
    //   99: getstatic 106	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   102: bipush 100
    //   104: aload_3
    //   105: invokevirtual 112	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   108: pop
    //   109: aload_3
    //   110: invokevirtual 117	java/io/OutputStream:close	()V
    //   113: return
    //   114: astore_1
    //   115: new 47	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   122: astore_3
    //   123: aload_3
    //   124: ldc 119
    //   126: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: aload_1
    //   132: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 82
    //   141: iconst_1
    //   142: aload_3
    //   143: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: return
    //   150: astore 4
    //   152: aload_3
    //   153: astore_1
    //   154: aload 4
    //   156: astore_3
    //   157: goto +86 -> 243
    //   160: astore 4
    //   162: goto +12 -> 174
    //   165: astore_3
    //   166: goto +77 -> 243
    //   169: astore 4
    //   171: aload 5
    //   173: astore_3
    //   174: aload_3
    //   175: astore_1
    //   176: new 47	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   183: astore 5
    //   185: aload_3
    //   186: astore_1
    //   187: aload 5
    //   189: ldc 119
    //   191: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: astore_1
    //   197: aload 5
    //   199: aload 4
    //   201: invokevirtual 123	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_3
    //   209: astore_1
    //   210: ldc 82
    //   212: iconst_1
    //   213: aload 5
    //   215: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_3
    //   222: ifnull +20 -> 242
    //   225: aload_3
    //   226: invokevirtual 117	java/io/OutputStream:close	()V
    //   229: return
    //   230: astore_1
    //   231: new 47	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   238: astore_3
    //   239: goto -116 -> 123
    //   242: return
    //   243: aload_1
    //   244: ifnull +49 -> 293
    //   247: aload_1
    //   248: invokevirtual 117	java/io/OutputStream:close	()V
    //   251: goto +42 -> 293
    //   254: astore_1
    //   255: new 47	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   262: astore 4
    //   264: aload 4
    //   266: ldc 119
    //   268: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 4
    //   274: aload_1
    //   275: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 82
    //   284: iconst_1
    //   285: aload 4
    //   287: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +5 -> 298
    //   296: aload_3
    //   297: athrow
    //   298: goto -2 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	ChatPieApolloViewController
    //   0	301	1	paramString	String
    //   0	301	2	paramInt	int
    //   7	150	3	localObject1	Object
    //   165	1	3	localObject2	Object
    //   173	124	3	localObject3	Object
    //   67	31	4	localBitmap	android.graphics.Bitmap
    //   150	5	4	localObject4	Object
    //   160	1	4	localException1	java.lang.Exception
    //   169	31	4	localException2	java.lang.Exception
    //   262	24	4	localStringBuilder1	StringBuilder
    //   84	130	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   109	113	114	java/io/IOException
    //   97	109	150	finally
    //   97	109	160	java/lang/Exception
    //   88	97	165	finally
    //   176	185	165	finally
    //   187	195	165	finally
    //   197	208	165	finally
    //   210	221	165	finally
    //   88	97	169	java/lang/Exception
    //   225	229	230	java/io/IOException
    //   247	251	254	java/io/IOException
  }
  
  private void e()
  {
    ThreadManagerV2.executeOnFileThread(new ChatPieApolloViewController.2(this));
  }
  
  private ChatApolloViewListener h(BaseChatPie paramBaseChatPie)
  {
    Object localObject = null;
    if (paramBaseChatPie == null) {
      return null;
    }
    ApolloAIOHelperImpl localApolloAIOHelperImpl = (ApolloAIOHelperImpl)paramBaseChatPie.q(8);
    paramBaseChatPie = localObject;
    if (localApolloAIOHelperImpl != null) {
      paramBaseChatPie = localApolloAIOHelperImpl.mApolloViewObserver;
    }
    return paramBaseChatPie;
  }
  
  private void i(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all");
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloDaoManagerService.class, "all");
    String str = localQQAppInterface.getCurrentAccountUin();
    ThreadManager.getFileThreadHandler().post(new ChatPieApolloViewController.5(this, paramBaseChatPie, str, localApolloDaoManagerServiceImpl, localApolloManagerServiceImpl, localQQAppInterface));
  }
  
  public void a(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      paramInt = this.h;
    } else {
      paramInt = 0;
    }
    QLog.d("[cmshow]ChatPieApolloViewController", 1, new Object[] { "onVisibilityChanged, isVisible:", Boolean.valueOf(bool), ", bottomMargin:", Integer.valueOf(paramInt) });
    int k;
    if (bool) {
      k = 2131445368;
    } else {
      k = 2131435809;
    }
    b(k);
    d(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((ICMShowView)localObject).getView();
      int k = ((View)localObject).getBottom();
      int m = ((View)localObject).getTop();
      if (((k > 0) && (k - m < paramInt)) || (paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkApolloViewLayout invisible apolloBottom:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(",apolloTop:");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(",titleHeight:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
        this.d.getView().setVisibility(4);
        return;
      }
      if (this.d.getView().getVisibility() == 4) {
        this.d.getView().setVisibility(0);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    Object localObject = Arrays.asList(new Scene[] { Scene.AIO, Scene.MEME_PLAYER });
    CEEngineHelper.a.a((List)localObject, paramBaseChatPie.bl());
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null) && (paramBaseChatPie.ah != null))
    {
      if (this.d != null)
      {
        QLog.i("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine CMShowView is already inited, return.");
        return;
      }
      if (paramBaseChatPie.bb() >= 7)
      {
        QLog.i("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
        return;
      }
      if ((!TextUtils.isEmpty(ApolloManagerServiceImpl.sEngineScript)) && (!TextUtils.isEmpty(ApolloManagerServiceImpl.sBasicScript)))
      {
        boolean bool = ApolloConfigUtils.k ^ true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TraceReport CmShowStatUtil cm3dPreLoad:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
        if (!bool) {
          return;
        }
        if (!SpriteUtil.a(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b))
        {
          QLog.i("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
          return;
        }
        if (!((IApolloManagerService)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext()))
        {
          QLog.d("[cmshow]ChatPieApolloViewController", 1, "Not in white list.");
          return;
        }
        localObject = ((TroopGagMgr)paramBaseChatPie.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramBaseChatPie.ah.b, true);
        if ((localObject != null) && (((SelfGagInfo)localObject).b))
        {
          QLog.i("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
          return;
        }
        if (SpriteUtil.d(paramBaseChatPie.d))
        {
          QLog.d("[cmshow]ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
          return;
        }
        if (!SpriteUtil.b(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b))
        {
          QLog.i("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !canUseCmShow");
          return;
        }
        if (QLog.isColorLevel())
        {
          paramBaseChatPie = new StringBuilder();
          paramBaseChatPie.append("checkNeedPreLoadEngine use:");
          paramBaseChatPie.append(System.currentTimeMillis() - l);
          QLog.i("[cmshow]ChatPieApolloViewController", 1, paramBaseChatPie.toString());
        }
        return;
      }
      QLog.i("[cmshow]ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    QLog.e("[cmshow]ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged height:", Integer.valueOf(paramInt) });
    }
    paramQQAppInterface = SpriteUtil.i(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      ICMShowView localICMShowView = this.d;
      if (localICMShowView != null)
      {
        int m = localICMShowView.getRenderWidth();
        int k = paramInt;
        if (paramInt == 0) {
          k = this.d.getRenderHeight();
        }
        paramQQAppInterface.a(m, k);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatPieApolloViewController", 2, new Object[] { "showApolloView show:", Boolean.valueOf(paramBoolean) });
    }
    ICMShowView localICMShowView = this.d;
    if (localICMShowView != null)
    {
      this.g = localICMShowView.getView().getVisibility();
      if (paramBoolean)
      {
        if (this.g != 0) {
          this.d.getView().setVisibility(0);
        }
      }
      else if (this.g != 8) {
        this.d.getView().setVisibility(8);
      }
    }
  }
  
  public boolean a()
  {
    return this.d != null;
  }
  
  public boolean a(AIOShortcutBarHelper paramAIOShortcutBarHelper)
  {
    boolean bool = true;
    if ((paramAIOShortcutBarHelper != null) && (paramAIOShortcutBarHelper.v() == 0))
    {
      if (paramAIOShortcutBarHelper.x() == 2) {
        return bool;
      }
      if (paramAIOShortcutBarHelper.x() == 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public void b()
  {
    ICMShowView localICMShowView = this.d;
    if (localICMShowView != null) {
      localICMShowView.getView().setVisibility(this.g);
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ICMShowView)localObject).getView().getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramInt);
        this.d.getView().requestLayout();
      }
    }
    localObject = this.a;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((BarrageView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramInt);
        this.a.requestLayout();
      }
    }
  }
  
  public boolean b(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]ChatPieApolloViewController", 1, new Object[] { "validateCmShowFun, mCMShowView:", this.d });
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null) && (paramBaseChatPie.ah != null))
    {
      if (this.d != null)
      {
        QLog.i("[cmshow]ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
        return false;
      }
      if (!SpriteUtil.a(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b)) {
        return false;
      }
      Object localObject1 = (SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
      ((SpriteScriptManagerImpl)localObject1).setPie(paramBaseChatPie);
      boolean bool = ((SpriteScriptManagerImpl)localObject1).getSpriteContext().d();
      if ((!((IApolloManagerService)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext())) && (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ChatPieApolloViewController", 2, "Not in white list.");
        }
        return false;
      }
      Object localObject2 = ((TroopGagMgr)paramBaseChatPie.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramBaseChatPie.ah.b, true);
      if ((localObject2 != null) && (((SelfGagInfo)localObject2).b)) {
        return false;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TraceReport CmShowStatUtil start TraceReport_total isNoneApolloActionPlay:");
      ((StringBuilder)localObject2).append(bool);
      QLog.i("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        CmShowStatUtil.a("exeBase");
        CmShowStatUtil.a("exeCmshow0");
        CmShowStatUtil.a("exeCommon");
      }
      CmShowStatUtil.b("aio_pre");
      int k = TraceReportUtil.c(0);
      TraceReportUtil.a(k, paramBaseChatPie.ah.b);
      TraceReportUtil.a(k, 1);
      TraceReportUtil.a(k, 10);
      TraceReportUtil.a(k, null, new int[] { TraceMappingIml.a(k, false, 0, paramBaseChatPie.ah.a, false) });
      if (SpriteUtil.d(paramBaseChatPie.d))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
        }
        TraceReportUtil.a(k, 10, 103, new Object[] { "double hidden" });
        return false;
      }
      if (!SpriteUtil.b(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b)) {
        return false;
      }
      localObject1 = ((SpriteScriptManagerImpl)localObject1).getUIHandler();
      if (localObject1 != null) {
        ((ISpriteUIHandler)localObject1).a(paramBaseChatPie.U, paramBaseChatPie.V);
      }
      if ((((ApolloDaoManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramBaseChatPie.d.getCurrentAccountUin()).apolloAIOStatus != 1) && (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ChatPieApolloViewController", 2, "Apollo switch NOT open.");
        }
        paramBaseChatPie.j().obtainMessage(62).sendToTarget();
        return true;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ((ApolloAIOHelperImpl)paramBaseChatPie.q(8)).initApolloSurfaceView();
        return true;
      }
      paramBaseChatPie.j().obtainMessage(65).sendToTarget();
      return true;
    }
    QLog.e("[cmshow]ChatPieApolloViewController", 1, "chatPie is null");
    return false;
  }
  
  public void c()
  {
    if (this.d != null)
    {
      ICMShowEngine localICMShowEngine = this.c;
      if (localICMShowEngine != null) {
        localICMShowEngine.l();
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  @TargetApi(14)
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {
      return;
    }
    int k = TraceReportUtil.c(0);
    if (paramBaseChatPie.bb() >= 7)
    {
      TraceReportUtil.a(k, 10, 106, new Object[] { "aio is finished" });
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
      }
      return;
    }
    Object localObject1;
    if (paramBaseChatPie.d != null)
    {
      if (!ApolloResManagerFacade.a.a(Scene.AIO).a(paramBaseChatPie.d))
      {
        QLog.e("[cmshow]ChatPieApolloViewController", 1, "initApolloSurfaceView check role0 fail, download");
        TraceReportUtil.a(k, 10, 110, new Object[] { "aio role0 not ready" });
        return;
      }
      localObject1 = (IApolloPushManager)paramBaseChatPie.d.getRuntimeService(IApolloPushManager.class, "all");
      ((IApolloPushManager)localObject1).setActionPushListener(new ChatPieApolloViewController.3(this, paramBaseChatPie, (IApolloPushManager)localObject1));
    }
    if (this.d != null)
    {
      QLog.e("[cmshow]ChatPieApolloViewController", 1, "CMShowView is already created");
      return;
    }
    if (paramBaseChatPie.d != null) {
      localObject1 = (SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
    } else {
      localObject1 = null;
    }
    TraceReportUtil.a(k, 10, 0, new Object[] { "cmshow switch done" });
    TraceReportUtil.a(k, 100);
    CmShowStatUtil.a("onSurfaceCreated");
    for (;;)
    {
      try
      {
        localObject3 = h(paramBaseChatPie);
        this.c = CMShowPlatform.a.a(BaseApplicationImpl.getApplication(), Scene.AIO);
        this.c.i().a(this.j);
        localObject2 = this.c.c();
        ((IRenderService)localObject2).a((ISurfaceStateListener)localObject3);
        ((IRenderService)localObject2).a((ITouchListener)localObject3);
        localObject3 = new RenderConfig();
        localApolloManagerServiceImpl = (ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all");
        if (Build.VERSION.SDK_INT >= 26) {
          break label963;
        }
        if (!localApolloManagerServiceImpl.isUseTextureViewConfig()) {
          break label958;
        }
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        Object localObject3;
        Object localObject2;
        ApolloManagerServiceImpl localApolloManagerServiceImpl;
        this.d = null;
        QLog.e("[cmshow]ChatPieApolloViewController", 1, "init CMSHowView exception", paramBaseChatPie);
        return;
      }
      ((RenderConfig)localObject3).a = bool;
      ((RenderConfig)localObject3).b = SpriteUtil.a();
      ((RenderConfig)localObject3).d = localApolloManagerServiceImpl.isDisableCreateRenderThread();
      ((RenderConfig)localObject3).c = true;
      ((IRenderService)localObject2).a((RenderConfig)localObject3);
      this.d = ((IRenderService)localObject2).a();
      if (localObject1 != null) {
        ((SpriteContext)((SpriteScriptManagerImpl)localObject1).getSpriteContext()).a(this.c);
      }
      e();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init CMSHowView:");
      ((StringBuilder)localObject2).append(this.d);
      QLog.w("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject2).toString());
      ThreadManager.excute(new ChatPieApolloViewController.4(this, paramBaseChatPie, (SpriteScriptManagerImpl)localObject1), 16, null, false);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramBaseChatPie.f.isInMultiWindow()) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = paramBaseChatPie.p.getHeight();
      }
      localObject3 = (AIOShortcutBarHelper)paramBaseChatPie.q(52);
      if (localObject3 != null)
      {
        ((AIOShortcutBarHelper)localObject3).a(2, this);
        ((AIOShortcutBarHelper)localObject3).a(1, this);
      }
      boolean bool = a((AIOShortcutBarHelper)localObject3);
      if (paramBaseChatPie.Y != null) {
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (this.b == null) {
            this.b = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          this.b.a = 0;
          if ((paramBaseChatPie.Y.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.Y.getParent()).addOnLayoutChangeListener(this.b);
          }
        }
        else
        {
          this.i = ViewUtils.dip2px(5.0F);
          if (!bool) {
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (-this.i);
          }
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131437281);
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131445368);
      } else {
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131435809);
      }
      this.a = new BarrageView(paramBaseChatPie.e, (SpriteContext)((SpriteScriptManagerImpl)localObject1).getSpriteContext());
      localObject3 = new RelativeLayout.LayoutParams(-1, (int)((float)DeviceInfoUtil.E() * 0.171F));
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131445368);
      } else {
        ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131435809);
      }
      localObject1 = paramBaseChatPie.bl();
      ((RelativeLayout)localObject1).addView(this.a, (ViewGroup.LayoutParams)localObject3);
      localObject3 = Arrays.asList(new Scene[] { Scene.AIO, Scene.MEME_PLAYER });
      CEEngineHelper.a.a((List)localObject3, (ViewGroup)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("add CMShowView:");
      ((StringBuilder)localObject3).append(this.d.getView());
      ((StringBuilder)localObject3).append(" to chatPie content view tree");
      QLog.w("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject3).toString());
      ((RelativeLayout)localObject1).addView(this.d.getView(), (ViewGroup.LayoutParams)localObject2);
      localObject1 = this.d;
      if (localObject1 != null) {
        ((ICMShowView)localObject1).resume();
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((ICMShowEngine)localObject1).k();
      }
      if (paramBaseChatPie.d != null) {
        ((ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).doAfterOpenAIO(paramBaseChatPie.ah, paramBaseChatPie.d);
      }
      return;
      label958:
      bool = false;
      continue;
      label963:
      bool = true;
    }
  }
  
  public void d()
  {
    if (this.d != null)
    {
      ICMShowEngine localICMShowEngine = this.c;
      if ((localICMShowEngine != null) && (this.g == 0)) {
        localICMShowEngine.k();
      }
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ICMShowView)localObject).getView().getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-paramInt);
        this.d.getView().requestLayout();
      }
    }
    localObject = this.a;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((BarrageView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-paramInt);
        this.a.requestLayout();
      }
    }
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {
      return;
    }
    if (((ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen())
    {
      if (this.e != null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = paramBaseChatPie.p.getHeight();
      boolean bool = a((AIOShortcutBarHelper)paramBaseChatPie.q(52));
      if (paramBaseChatPie.Y != null) {
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (this.b == null) {
            this.b = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          this.b.a = 0;
          if ((paramBaseChatPie.Y.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.Y.getParent()).addOnLayoutChangeListener(this.b);
          }
        }
        else
        {
          this.i = ViewUtils.dip2px(5.0F);
          if (!bool) {
            localLayoutParams.bottomMargin = (-this.i);
          }
        }
      }
      localLayoutParams.addRule(6, 2131437281);
      if (bool) {
        localLayoutParams.addRule(2, 2131445368);
      } else {
        localLayoutParams.addRule(2, 2131435809);
      }
      this.e = CMShowPlatform.a.a(BaseApplicationImpl.getApplication(), Scene.AIO_BACKGROUND);
      Object localObject = this.e.c();
      ApolloBackgroundViewListener localApolloBackgroundViewListener = new ApolloBackgroundViewListener(paramBaseChatPie, this.e);
      ((IRenderService)localObject).a(localApolloBackgroundViewListener);
      RenderConfig localRenderConfig = new RenderConfig();
      localRenderConfig.a = true;
      ((IRenderService)localObject).a(localRenderConfig);
      this.f = ((IRenderService)localObject).a();
      localObject = (SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
      ((SpriteScriptManagerImpl)localObject).setBackgroundManager(this.e);
      localObject = ((SpriteScriptManagerImpl)localObject).getSpriteBackgroundManager();
      if (localObject != null) {
        localApolloBackgroundViewListener.a((IRenderCallback)localObject);
      }
      paramBaseChatPie.bl().addView(this.f.getView(), 0, localLayoutParams);
      paramBaseChatPie = this.e;
      if (paramBaseChatPie != null) {
        paramBaseChatPie.k();
      }
      paramBaseChatPie = this.f;
      if (paramBaseChatPie != null) {
        paramBaseChatPie.resume();
      }
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]ChatPieApolloViewController", 1, "onResume");
    if (paramBaseChatPie == null) {
      return;
    }
    if (paramBaseChatPie.d != null)
    {
      ApolloResManagerFacade.a.a(Scene.AIO).a(paramBaseChatPie.d, paramBaseChatPie.d.getCurrentUin(), "C2C");
      if (a()) {
        ((SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all")).doOnResume(paramBaseChatPie.ah.a, paramBaseChatPie.ah.b);
      }
      i(paramBaseChatPie);
    }
    paramBaseChatPie = this.d;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.resume();
    }
    paramBaseChatPie = this.f;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.resume();
    }
    paramBaseChatPie = this.c;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.k();
    }
    paramBaseChatPie = this.e;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.k();
    }
  }
  
  public void f(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]ChatPieApolloViewController", 1, "onPause");
    if (paramBaseChatPie == null) {
      return;
    }
    if ((paramBaseChatPie.d != null) && (a())) {
      ((SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all")).doOnPause(paramBaseChatPie.ah.a, paramBaseChatPie.ah.b);
    }
    paramBaseChatPie = this.d;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.pause();
    }
    paramBaseChatPie = this.f;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.pause();
    }
    paramBaseChatPie = this.e;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.l();
    }
    paramBaseChatPie = this.c;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.l();
    }
  }
  
  public void g(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]ChatPieApolloViewController", 1, "onDestroy");
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
    {
      ((SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all")).reset();
      if (!a())
      {
        QLog.e("[cmshow]ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
        return;
      }
      ((IApolloPushManager)paramBaseChatPie.d.getRuntimeService(IApolloPushManager.class, "all")).setActionPushListener(null);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy mCMShowView:");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("[cmshow]ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
      localObject = this.d;
      if (localObject != null)
      {
        ((ICMShowView)localObject).getView().setVisibility(8);
        paramBaseChatPie.bl().removeView(this.d.getView());
        this.d = null;
      }
      localObject = this.c;
      if (localObject != null)
      {
        ((ICMShowEngine)localObject).m();
        this.c = null;
      }
      localObject = this.f;
      if (localObject != null)
      {
        BKUtils.a(((ICMShowView)localObject).getView());
        this.f = null;
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((ICMShowEngine)localObject).m();
        this.e = null;
      }
      localObject = this.a;
      if (localObject != null)
      {
        ((BarrageView)localObject).a();
        this.a.setVisibility(8);
        paramBaseChatPie.bl().removeView(this.a);
        this.a = null;
      }
      this.g = 0;
      localObject = (AIOShortcutBarHelper)paramBaseChatPie.q(52);
      if (localObject != null) {
        ((AIOShortcutBarHelper)localObject).b(2, this);
      }
      if (this.b != null) {
        paramBaseChatPie.Y.removeOnLayoutChangeListener(this.b);
      }
      return;
    }
    QLog.e("[cmshow]ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController
 * JD-Core Version:    0.7.0.1
 */