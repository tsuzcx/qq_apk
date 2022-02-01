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
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.apollo.view.ApolloBackgroundViewListener;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
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
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class ChatPieApolloViewController
  implements AIOShortcutBarHelper.OnVisibilityChangedListener, IChatPieApolloViewController
{
  private int jdField_a_of_type_Int;
  public BarrageView a;
  public InputGlobalLayoutListener a;
  private ICMShowEngine jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  private ICMShowView jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
  private int jdField_b_of_type_Int;
  private ICMShowEngine jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  private ICMShowView jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
  private int c;
  
  private ChatApolloViewListener a(BaseChatPie paramBaseChatPie)
  {
    Object localObject = null;
    if (paramBaseChatPie == null) {
      return null;
    }
    ApolloAIOHelperImpl localApolloAIOHelperImpl = (ApolloAIOHelperImpl)paramBaseChatPie.a(8);
    paramBaseChatPie = localObject;
    if (localApolloAIOHelperImpl != null) {
      paramBaseChatPie = localApolloAIOHelperImpl.mApolloViewObserver;
    }
    return paramBaseChatPie;
  }
  
  /* Error */
  @org.jetbrains.annotations.NotNull
  private void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 50	com/tencent/mobileqq/apollo/utils/ApolloConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_3
    //   27: new 60	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 67	java/io/File:exists	()Z
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: getstatic 73	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   45: invokevirtual 77	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnonnull +12 -> 62
    //   53: ldc 79
    //   55: iconst_1
    //   56: ldc 81
    //   58: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: aload_1
    //   63: iload_2
    //   64: invokestatic 93	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnonnull +12 -> 83
    //   74: ldc 79
    //   76: iconst_1
    //   77: ldc 95
    //   79: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: aconst_null
    //   84: astore 5
    //   86: aconst_null
    //   87: astore_1
    //   88: new 97	java/io/FileOutputStream
    //   91: dup
    //   92: aload_3
    //   93: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   96: astore_3
    //   97: aload 4
    //   99: getstatic 104	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   102: bipush 100
    //   104: aload_3
    //   105: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   108: pop
    //   109: aload_3
    //   110: invokevirtual 115	java/io/OutputStream:close	()V
    //   113: return
    //   114: astore_1
    //   115: new 44	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   122: astore_3
    //   123: aload_3
    //   124: ldc 117
    //   126: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: aload_1
    //   132: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 79
    //   141: iconst_1
    //   142: aload_3
    //   143: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   176: new 44	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   183: astore 5
    //   185: aload_3
    //   186: astore_1
    //   187: aload 5
    //   189: ldc 117
    //   191: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: astore_1
    //   197: aload 5
    //   199: aload 4
    //   201: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_3
    //   209: astore_1
    //   210: ldc 79
    //   212: iconst_1
    //   213: aload 5
    //   215: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_3
    //   222: ifnull +20 -> 242
    //   225: aload_3
    //   226: invokevirtual 115	java/io/OutputStream:close	()V
    //   229: return
    //   230: astore_1
    //   231: new 44	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   238: astore_3
    //   239: goto -116 -> 123
    //   242: return
    //   243: aload_1
    //   244: ifnull +49 -> 293
    //   247: aload_1
    //   248: invokevirtual 115	java/io/OutputStream:close	()V
    //   251: goto +42 -> 293
    //   254: astore_1
    //   255: new 44	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   262: astore 4
    //   264: aload 4
    //   266: ldc 117
    //   268: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 4
    //   274: aload_1
    //   275: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 79
    //   284: iconst_1
    //   285: aload 4
    //   287: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  private void d()
  {
    ThreadManagerV2.executeOnFileThread(new ChatPieApolloViewController.1(this));
  }
  
  private void g(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    String str = localQQAppInterface.getCurrentAccountUin();
    ThreadManager.getFileThreadHandler().post(new ChatPieApolloViewController.4(this, paramBaseChatPie, str, localApolloDaoManagerServiceImpl, localApolloManagerServiceImpl, localQQAppInterface));
  }
  
  public void a()
  {
    ICMShowView localICMShowView = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localICMShowView != null) {
      localICMShowView.getView().setVisibility(this.jdField_a_of_type_Int);
    }
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
      paramInt = this.jdField_b_of_type_Int;
    } else {
      paramInt = 0;
    }
    QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, new Object[] { "onVisibilityChanged, isVisible:", Boolean.valueOf(bool), ", bottomMargin:", Integer.valueOf(paramInt) });
    int i;
    if (bool) {
      i = 2131377004;
    } else {
      i = 2131368875;
    }
    b(i);
    d(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject != null)
    {
      localObject = ((ICMShowView)localObject).getView();
      int i = ((View)localObject).getBottom();
      int j = ((View)localObject).getTop();
      if (((i > 0) && (i - j < paramInt)) || (paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkApolloViewLayout invisible apolloBottom:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",apolloTop:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",titleHeight:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().setVisibility(4);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().getVisibility() == 4) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().setVisibility(0);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    CEEngineHelper.a.a(Scene.AIO, paramBaseChatPie.a());
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null)
      {
        QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine CMShowView is already inited, return.");
        return;
      }
      if (paramBaseChatPie.d() >= 7)
      {
        QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
        return;
      }
      if ((!TextUtils.isEmpty(ApolloManagerServiceImpl.sEngineScript)) && (!TextUtils.isEmpty(ApolloManagerServiceImpl.sBasicScript)))
      {
        boolean bool = ApolloConfigUtils.d ^ true;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TraceReport CmShowStatUtil cm3dPreLoad:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
        if (!bool) {
          return;
        }
        if (!SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
          return;
        }
        if (!((IApolloManagerService)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext()))
        {
          QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, "Not in white list.");
          return;
        }
        localObject = ((TroopGagMgr)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
        if ((localObject != null) && (((SelfGagInfo)localObject).jdField_a_of_type_Boolean))
        {
          QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
          return;
        }
        if (SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
          return;
        }
        if (!SpriteUtil.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !canUseCmShow");
          return;
        }
        if (QLog.isColorLevel())
        {
          paramBaseChatPie = new StringBuilder();
          paramBaseChatPie.append("checkNeedPreLoadEngine use:");
          paramBaseChatPie.append(System.currentTimeMillis() - l);
          QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, paramBaseChatPie.toString());
        }
        return;
      }
      QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged height:", Integer.valueOf(paramInt) });
    }
    paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      ICMShowView localICMShowView = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
      if (localICMShowView != null)
      {
        int j = localICMShowView.getRenderWidth();
        int i = paramInt;
        if (paramInt == 0) {
          i = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getRenderHeight();
        }
        paramQQAppInterface.a(j, i);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, new Object[] { "showApolloView show:", Boolean.valueOf(paramBoolean) });
    }
    ICMShowView localICMShowView = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localICMShowView != null)
    {
      this.jdField_a_of_type_Int = localICMShowView.getView().getVisibility();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Int != 0) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().setVisibility(0);
        }
      }
      else if (this.jdField_a_of_type_Int != 8) {
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().setVisibility(8);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null;
  }
  
  public boolean a(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, new Object[] { "ifApolloFunAvailThenInit, mCMShowView:", this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView });
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null)
      {
        QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
        return false;
      }
      if (!SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      Object localObject1 = (SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      ((SpriteScriptManagerImpl)localObject1).setPie(paramBaseChatPie);
      boolean bool = ((SpriteScriptManagerImpl)localObject1).getSpriteContext().d();
      if ((!((IApolloManagerService)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext())) && (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "Not in white list.");
        }
        return false;
      }
      Object localObject2 = ((TroopGagMgr)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if ((localObject2 != null) && (((SelfGagInfo)localObject2).jdField_a_of_type_Boolean)) {
        return false;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TraceReport CmShowStatUtil start TraceReport_total isNoneApolloActionPlay:");
      ((StringBuilder)localObject2).append(bool);
      QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        CmShowStatUtil.a("exeBase");
        CmShowStatUtil.a("exeCmshow0");
        CmShowStatUtil.a("exeCommon");
      }
      CmShowStatUtil.b("aio_pre");
      int i = TraceReportUtil.a(0);
      TraceReportUtil.a(i, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      TraceReportUtil.a(i, 1);
      TraceReportUtil.a(i, 10);
      TraceReportUtil.a(i, null, new int[] { TraceMappingIml.a(i, false, 0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false) });
      if (SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
        }
        TraceReportUtil.a(i, 10, 103, new Object[] { "double hidden" });
        return false;
      }
      if (!SpriteUtil.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      localObject1 = ((SpriteScriptManagerImpl)localObject1).getUIHandler();
      if (localObject1 != null) {
        ((ISpriteUIHandler)localObject1).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      }
      if ((((ApolloDaoManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).apolloAIOStatus != 1) && (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "Apollo switch NOT open.");
        }
        paramBaseChatPie.a().obtainMessage(62).sendToTarget();
        return true;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ((ApolloAIOHelperImpl)paramBaseChatPie.a(8)).initApolloSurfaceView();
        return true;
      }
      paramBaseChatPie.a().obtainMessage(65).sendToTarget();
      return true;
    }
    QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, "chatPie is null");
    return false;
  }
  
  public boolean a(AIOShortcutBarHelper paramAIOShortcutBarHelper)
  {
    boolean bool = true;
    if ((paramAIOShortcutBarHelper != null) && (paramAIOShortcutBarHelper.c() == 0))
    {
      if (paramAIOShortcutBarHelper.d() == 2) {
        return bool;
      }
      if (paramAIOShortcutBarHelper.d() == 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null)
    {
      ICMShowEngine localICMShowEngine = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
      if (localICMShowEngine != null) {
        localICMShowEngine.b();
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ICMShowView)localObject).getView().getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().requestLayout();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((BarrageView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  @TargetApi(14)
  public void b(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {
      return;
    }
    int i = TraceReportUtil.a(0);
    if (paramBaseChatPie.d() >= 7)
    {
      TraceReportUtil.a(i, 10, 106, new Object[] { "aio is finished" });
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
      }
      return;
    }
    Object localObject1;
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (IApolloPushManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloPushManager.class, "all");
      ((IApolloPushManager)localObject1).setActionPushListener(new ChatPieApolloViewController.2(this, paramBaseChatPie, (IApolloPushManager)localObject1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null)
    {
      QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, "CMShowView is already created");
      return;
    }
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      localObject1 = (SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    } else {
      localObject1 = null;
    }
    TraceReportUtil.a(i, 10, 0, new Object[] { "cmshow switch done" });
    TraceReportUtil.a(i, 100);
    CmShowStatUtil.a("onSurfaceCreated");
    for (;;)
    {
      try
      {
        localObject3 = a(paramBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = CMShowPlatform.a.a(BaseApplicationImpl.getApplication(), Scene.AIO);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
        ((IRenderService)localObject2).a((ISurfaceStateListener)localObject3);
        ((IRenderService)localObject2).a((ITouchListener)localObject3);
        localObject3 = new RenderConfig();
        localApolloManagerServiceImpl = (ApolloManagerServiceImpl)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all");
        if (Build.VERSION.SDK_INT >= 26) {
          break label834;
        }
        if (!localApolloManagerServiceImpl.isUseTextureViewConfig()) {
          break label829;
        }
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        Object localObject3;
        Object localObject2;
        ApolloManagerServiceImpl localApolloManagerServiceImpl;
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = null;
        QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, "init CMSHowView exception", paramBaseChatPie);
        return;
      }
      ((RenderConfig)localObject3).jdField_a_of_type_Boolean = bool;
      ((RenderConfig)localObject3).jdField_a_of_type_Int = SpriteUtil.a();
      ((RenderConfig)localObject3).c = localApolloManagerServiceImpl.isDisableCreateRenderThread();
      ((RenderConfig)localObject3).b = true;
      ((IRenderService)localObject2).a((RenderConfig)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = ((IRenderService)localObject2).a();
      if (localObject1 != null) {
        ((SpriteContext)((SpriteScriptManagerImpl)localObject1).getSpriteContext()).a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine);
      }
      d();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init CMSHowView:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView);
      QLog.w("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject2).toString());
      ThreadManager.excute(new ChatPieApolloViewController.3(this, paramBaseChatPie, (SpriteScriptManagerImpl)localObject1), 16, null, false);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      }
      localObject3 = (AIOShortcutBarHelper)paramBaseChatPie.a(52);
      if (localObject3 != null)
      {
        ((AIOShortcutBarHelper)localObject3).a(2, this);
        ((AIOShortcutBarHelper)localObject3).a(1, this);
      }
      boolean bool = a((AIOShortcutBarHelper)localObject3);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        else
        {
          this.c = AIOUtils.b(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources());
          if (!bool) {
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (-this.c);
          }
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131370119);
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131377004);
      } else {
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368875);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, (SpriteContext)((SpriteScriptManagerImpl)localObject1).getSpriteContext());
      localObject1 = new RelativeLayout.LayoutParams(-1, (int)((float)DeviceInfoUtil.j() * 0.171F));
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131377004);
      } else {
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368875);
      }
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("add CMShowView:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView());
      ((StringBuilder)localObject1).append(" to chatPie content view tree");
      QLog.w("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject1).toString());
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView(), (ViewGroup.LayoutParams)localObject2);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).doAfterOpenAIO(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
      label829:
      bool = false;
      continue;
      label834:
      bool = true;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView != null)
    {
      ICMShowEngine localICMShowEngine = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
      if ((localICMShowEngine != null) && (this.jdField_a_of_type_Int == 0)) {
        localICMShowEngine.a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {
      return;
    }
    if (((ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloBackgroundActionSwitchOpen())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine != null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      boolean bool = a((AIOShortcutBarHelper)paramBaseChatPie.a(52));
      if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        else
        {
          this.c = AIOUtils.b(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources());
          if (!bool) {
            localLayoutParams.bottomMargin = (-this.c);
          }
        }
      }
      localLayoutParams.addRule(6, 2131370119);
      if (bool) {
        localLayoutParams.addRule(2, 2131377004);
      } else {
        localLayoutParams.addRule(2, 2131368875);
      }
      this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = CMShowPlatform.a.a(BaseApplicationImpl.getApplication(), Scene.AIO_BACKGROUND);
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
      ApolloBackgroundViewListener localApolloBackgroundViewListener = new ApolloBackgroundViewListener(paramBaseChatPie, this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine);
      ((IRenderService)localObject).a(localApolloBackgroundViewListener);
      RenderConfig localRenderConfig = new RenderConfig();
      localRenderConfig.jdField_a_of_type_Boolean = true;
      localRenderConfig.e = false;
      ((IRenderService)localObject).a(localRenderConfig);
      this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = ((IRenderService)localObject).a();
      localObject = (SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      ((SpriteScriptManagerImpl)localObject).setBackgroundManager(this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine);
      localObject = ((SpriteScriptManagerImpl)localObject).getSpriteBackgroundManager();
      if (localObject != null) {
        localApolloBackgroundViewListener.a((IRenderCallback)localObject);
      }
      paramBaseChatPie.a().addView(this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView(), 0, localLayoutParams);
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ICMShowView)localObject).getView().getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().requestLayout();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((BarrageView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, "onResume");
    if (paramBaseChatPie == null) {
      return;
    }
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).checkUserDress(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "C2C");
      if (a()) {
        ((SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).doOnResume(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      g(paramBaseChatPie);
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.resume();
    }
    paramBaseChatPie = this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.resume();
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.a();
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, "onPause");
    if (paramBaseChatPie == null) {
      return;
    }
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (a())) {
      ((SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).doOnPause(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.pause();
    }
    paramBaseChatPie = this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.pause();
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (paramBaseChatPie != null) {
      paramBaseChatPie.b();
    }
  }
  
  public void f(BaseChatPie paramBaseChatPie)
  {
    QLog.d("[cmshow]sava_ChatPieApolloViewController", 1, "onDestroy");
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((SpriteScriptManagerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).reset();
      if (!a())
      {
        QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
        return;
      }
      ((IApolloPushManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).setActionPushListener(null);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy mCMShowView:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView);
      QLog.i("[cmshow]sava_ChatPieApolloViewController", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
      if (localObject != null)
      {
        ((ICMShowView)localObject).getView().setVisibility(8);
        paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView());
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
      if (localObject != null)
      {
        ((ICMShowEngine)localObject).c();
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = null;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
      if (localObject != null)
      {
        BKUtils.a(((ICMShowView)localObject).getView());
        this.jdField_b_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = null;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
      if (localObject != null)
      {
        ((ICMShowEngine)localObject).c();
        this.jdField_b_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
      if (localObject != null)
      {
        ((BarrageView)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
        paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
      }
      this.jdField_a_of_type_Int = 0;
      localObject = (AIOShortcutBarHelper)paramBaseChatPie.a(52);
      if (localObject != null) {
        ((AIOShortcutBarHelper)localObject).b(2, this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener != null) {
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
      }
      return;
    }
    QLog.e("[cmshow]sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController
 * JD-Core Version:    0.7.0.1
 */