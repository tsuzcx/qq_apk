package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.Vas.ColorFont.FastColorFontCache;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FreeTypeLib;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder.HiBoomHolder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class FontManager
  implements Handler.Callback, Manager
{
  private static int B = -1;
  private static int I;
  private static ConcurrentHashMap<String, FontInfo> t;
  private CopyOnWriteArrayList<FontLoadCallback> A = new CopyOnWriteArrayList();
  private int C = -1;
  private volatile boolean D = false;
  private boolean E = false;
  private ConcurrentHashMap<String, FontInfo> F = new ConcurrentHashMap();
  private Map<Integer, String> G = new ConcurrentHashMap();
  private Map<Integer, Long> H = new ConcurrentHashMap();
  private long J = 0L;
  private long K = 0L;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, FontInfo>> L = new ConcurrentHashMap();
  public boolean a;
  public volatile boolean b;
  protected ETEngine c = null;
  protected ETEngine d = null;
  public AtomicBoolean e = new AtomicBoolean(false);
  public int f = -1;
  public String g = null;
  public AtomicBoolean h;
  public HandlerThread i;
  public Handler j;
  public String k;
  public float l = 1.5F;
  public float m = 1.3F;
  public float n = 1.5F;
  public boolean o = false;
  public String p = HardCodeUtil.a(2131902683);
  public String q;
  public int r = 1;
  private QQAppInterface s = null;
  private IPCDownloadListener u = null;
  private boolean v = false;
  private String w;
  private Map<Integer, Float> x = new ConcurrentHashMap();
  private List<Integer> y = new LinkedList();
  private final Object z = new Object();
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.s = paramQQAppInterface;
    this.h = new AtomicBoolean(false);
    t = new ConcurrentHashMap();
    FontManagerConstants.updateFontSwitch(SharedPreUtils.s(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "vas_font_switch_config"));
    paramQQAppInterface = this.s.getApp().getSharedPreferences("font_open_switch", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUserOpenFontSwitch_");
    localStringBuilder.append(this.s.getAccount());
    this.b = paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.v)
    {
      paramQQAppInterface.append(DeviceInfoUtil.u());
      paramQQAppInterface.append("; CPU number: ");
      paramQQAppInterface.append(DeviceInfoUtil.h());
      paramQQAppInterface.append("; CPU frequency: ");
      paramQQAppInterface.append(DeviceInfoUtil.k());
      paramQQAppInterface.append("; RAM: ");
      paramQQAppInterface.append(DeviceInfoUtil.a());
    }
    this.w = paramQQAppInterface.toString();
    this.a = f();
    this.i = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.i.start();
    this.j = new Handler(this.i.getLooper(), this);
  }
  
  public static int a(long paramLong)
  {
    Object localObject = t;
    if (localObject != null) {
      localObject = (FontInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf((int)paramLong));
    } else {
      localObject = null;
    }
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = ((FontInfo)localObject).h;
    } else {
      i1 = 0;
    }
    if (i1 > 0) {
      i2 = I % i1;
    }
    I += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVariedStyleIndex: sIndex=");
      ((StringBuilder)localObject).append(I);
      ((StringBuilder)localObject).append(" fontId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" styleCount=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" index=");
      ((StringBuilder)localObject).append(i2);
      QLog.d("VasFont", 2, ((StringBuilder)localObject).toString());
    }
    return i2;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    int i1 = paramMessageRecord.istroop;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 1025) {
          break label202;
        }
        if (i1 != 3000) {
          if ((i1 == 10002) || (i1 == 10004) || (i1 == 10008) || (i1 == 10010)) {
            break label202;
          }
        }
      }
      switch (i1)
      {
      default: 
        switch (i1)
        {
        default: 
          switch (i1)
          {
          default: 
            break label200;
            if (paramMessageRecord.isSend()) {
              return paramMessageRecord.selfuin;
            }
            return paramMessageRecord.senderuin;
            if (!AnonymousChatHelper.c(paramMessageRecord))
            {
              if (paramMessageRecord.isSend()) {
                return paramMessageRecord.selfuin;
              }
              return paramMessageRecord.senderuin;
            }
            label200:
            return null;
          }
          break;
        }
        break;
      }
    }
    label202:
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.U != null)
    {
      int i2 = paramBaseChatPie.U.getFirstVisiblePosition();
      int i3 = paramBaseChatPie.U.getLastVisiblePosition();
      int i4 = paramBaseChatPie.U.getHeaderViewsCount();
      int i1 = i2 - 1;
      while (i1 <= i3)
      {
        Object localObject = paramBaseChatPie.U.getChildAt(i4 + i1 - i2);
        if (localObject != null) {
          if ((AIOUtils.b((View)localObject) instanceof TextItemBuilder.Holder))
          {
            localObject = (TextItemBuilder.Holder)AIOUtils.b((View)localObject);
            if ((((TextItemBuilder.Holder)localObject).v instanceof ETTextView)) {
              ((ETTextView)((TextItemBuilder.Holder)localObject).v).startAnimation(false, true);
            }
          }
          else if ((AIOUtils.b((View)localObject) instanceof RichStatItemBuilder.Holder))
          {
            localObject = (RichStatItemBuilder.Holder)AIOUtils.b((View)localObject);
            if ((((RichStatItemBuilder.Holder)localObject).d != null) && (((RichStatItemBuilder.Holder)localObject).d.p != null)) {
              ((RichStatItemBuilder.Holder)localObject).d.p.startAnimation(false, true);
            }
          }
          else if ((AIOUtils.b((View)localObject) instanceof HiBoomItemBuilder.HiBoomHolder))
          {
            ((HiBoomItemBuilder.HiBoomHolder)AIOUtils.b((View)localObject)).a.f();
          }
        }
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private boolean a(FontInfo paramFontInfo, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/etrump/mixlayout/FontManager:s	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 389	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9: aload_2
    //   10: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: istore 5
    //   15: new 397	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: getfield 399	com/etrump/mixlayout/FontInfo:b	Ljava/lang/String;
    //   23: invokespecial 401	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload 6
    //   30: invokevirtual 404	java/io/File:exists	()Z
    //   33: ifne +58 -> 91
    //   36: aload_0
    //   37: aload_1
    //   38: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   41: aconst_null
    //   42: iconst_1
    //   43: invokevirtual 409	com/etrump/mixlayout/FontManager:a	(ILjava/lang/String;I)V
    //   46: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +38 -> 87
    //   52: new 188	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc_w 411
    //   64: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: aload_1
    //   70: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   73: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 242
    //   79: iconst_2
    //   80: aload_2
    //   81: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_0
    //   90: ireturn
    //   91: aload 6
    //   93: invokestatic 417	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   96: ifnonnull +41 -> 137
    //   99: aload_0
    //   100: aload_1
    //   101: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   104: iconst_1
    //   105: invokevirtual 420	com/etrump/mixlayout/FontManager:d	(II)V
    //   108: ldc_w 422
    //   111: ldc_w 424
    //   114: ldc_w 426
    //   117: iconst_0
    //   118: iconst_0
    //   119: aload_1
    //   120: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   123: iconst_1
    //   124: ldc_w 428
    //   127: ldc_w 428
    //   130: invokestatic 433	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: iconst_0
    //   136: ireturn
    //   137: new 188	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   144: astore 6
    //   146: aload 6
    //   148: ldc_w 435
    //   151: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: aload_1
    //   158: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   161: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 437
    //   170: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: ldc 242
    //   185: iconst_1
    //   186: aload 6
    //   188: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_0
    //   195: getfield 108	com/etrump/mixlayout/FontManager:z	Ljava/lang/Object;
    //   198: astore 6
    //   200: aload 6
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 79	com/etrump/mixlayout/FontManager:c	Lcom/etrump/mixlayout/ETEngine;
    //   207: aload_1
    //   208: getfield 399	com/etrump/mixlayout/FontInfo:b	Ljava/lang/String;
    //   211: aload_1
    //   212: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   215: iload 5
    //   217: invokevirtual 448	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   220: istore 4
    //   222: aload_0
    //   223: getfield 81	com/etrump/mixlayout/FontManager:d	Lcom/etrump/mixlayout/ETEngine;
    //   226: aload_1
    //   227: getfield 399	com/etrump/mixlayout/FontInfo:b	Ljava/lang/String;
    //   230: aload_1
    //   231: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   234: iload 5
    //   236: invokevirtual 448	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   239: istore 5
    //   241: aload 6
    //   243: monitorexit
    //   244: new 188	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   251: astore 6
    //   253: aload 6
    //   255: ldc_w 450
    //   258: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: aload_1
    //   265: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   268: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: ldc_w 437
    //   277: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 6
    //   283: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   286: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 242
    //   292: iconst_1
    //   293: aload 6
    //   295: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: iload 4
    //   303: ifeq +47 -> 350
    //   306: iload 5
    //   308: ifne +6 -> 314
    //   311: goto +39 -> 350
    //   314: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +12 -> 329
    //   320: ldc 242
    //   322: iconst_2
    //   323: ldc_w 452
    //   326: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_0
    //   330: aload_2
    //   331: aload_1
    //   332: iload_3
    //   333: invokespecial 455	com/etrump/mixlayout/FontManager:a	(Ljava/lang/String;Lcom/etrump/mixlayout/FontInfo;I)Z
    //   336: ifeq +10 -> 346
    //   339: aload_0
    //   340: getfield 77	com/etrump/mixlayout/FontManager:s	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   343: invokestatic 460	com/tencent/mobileqq/utils/VasUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   346: aload_0
    //   347: monitorexit
    //   348: iconst_1
    //   349: ireturn
    //   350: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +94 -> 447
    //   356: new 188	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   363: astore_2
    //   364: aload_2
    //   365: ldc_w 462
    //   368: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_2
    //   373: aload_1
    //   374: getfield 406	com/etrump/mixlayout/FontInfo:a	I
    //   377: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: ldc_w 464
    //   385: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: iload 4
    //   392: invokevirtual 467	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc_w 469
    //   400: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_2
    //   405: iload 5
    //   407: invokevirtual 467	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 242
    //   413: iconst_2
    //   414: aload_2
    //   415: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto +26 -> 447
    //   424: astore_1
    //   425: aload 6
    //   427: monitorexit
    //   428: aload_1
    //   429: athrow
    //   430: astore_1
    //   431: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +13 -> 447
    //   437: ldc 242
    //   439: iconst_2
    //   440: ldc_w 471
    //   443: aload_1
    //   444: invokestatic 474	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: aload_0
    //   448: monitorexit
    //   449: iconst_0
    //   450: ireturn
    //   451: astore_1
    //   452: aload_0
    //   453: monitorexit
    //   454: aload_1
    //   455: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	FontManager
    //   0	456	1	paramFontInfo	FontInfo
    //   0	456	2	paramString	String
    //   0	456	3	paramInt	int
    //   220	171	4	bool1	boolean
    //   13	393	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   203	244	424	finally
    //   425	428	424	finally
    //   15	87	430	java/lang/Throwable
    //   91	133	430	java/lang/Throwable
    //   137	203	430	java/lang/Throwable
    //   244	301	430	java/lang/Throwable
    //   314	329	430	java/lang/Throwable
    //   329	346	430	java/lang/Throwable
    //   350	421	430	java/lang/Throwable
    //   428	430	430	java/lang/Throwable
    //   2	15	451	finally
    //   15	87	451	finally
    //   91	133	451	finally
    //   137	203	451	finally
    //   244	301	451	finally
    //   314	329	451	finally
    //   329	346	451	finally
    //   350	421	451	finally
    //   428	430	451	finally
    //   431	447	451	finally
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
    }
    if (localExtensionInfo.diyFontTimestampMap == null) {
      localExtensionInfo.diyFontTimestampMap = new ConcurrentHashMap();
    }
    if ((localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) != null) && (((Integer)localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1))).intValue() >= paramInt2)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramExtensionInfo = new StringBuilder();
      paramExtensionInfo.append("checkUpdateDIYConfig uin = ");
      paramExtensionInfo.append(paramString);
      paramExtensionInfo.append(" fontId = ");
      paramExtensionInfo.append(paramInt1);
      paramExtensionInfo.append(" oldTime = ");
      paramExtensionInfo.append(localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)));
      paramExtensionInfo.append(" newTime = ");
      paramExtensionInfo.append(paramInt2);
      QLog.d("VasFont", 2, paramExtensionInfo.toString());
    }
    paramQQAppInterface = (ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    paramExtensionInfo = new HashMap();
    paramExtensionInfo.put(paramString, Integer.valueOf(paramInt1));
    paramQQAppInterface.a(paramExtensionInfo);
    localExtensionInfo.diyFontTimestampMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    localFriendsManager.a(localExtensionInfo);
    return true;
  }
  
  private boolean a(String paramString)
  {
    int i1 = this.C;
    boolean bool = false;
    if (i1 == -1)
    {
      if (((DeviceInfoUtil.h() >= 2) && (DeviceInfoUtil.k() > 1000L)) || ((DeviceInfoUtil.h() >= 4) && (DeviceInfoUtil.a() > 838860800L)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
        }
        this.C = 1;
      }
      else
      {
        this.C = 0;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChatFontAbilityFromLocal return false. CPU number = ");
          localStringBuilder.append(DeviceInfoUtil.h());
          localStringBuilder.append(" CPU Frequency = ");
          localStringBuilder.append(DeviceInfoUtil.k());
          localStringBuilder.append(" Memory = ");
          localStringBuilder.append(DeviceInfoUtil.a());
          QLog.d("VasFont", 2, localStringBuilder.toString());
        }
      }
      VasMonitorHandler.a(this.s, "individual_v2_font_dpc_fail", "font_dpc_fail", this.w, paramString, 0.0F);
    }
    if (this.C == 1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    if (paramFontInfo.f == null) {
      paramFontInfo.f = new ETFont(paramFontInfo.a, paramFontInfo.b, 16.0F, paramFontInfo.c, paramFontInfo.d);
    }
    Object localObject2 = (ConcurrentHashMap)this.L.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap();
    }
    if (ETEngine.getInstance().native_diyFontIsDIYFont(paramFontInfo.f))
    {
      paramFontInfo.g = true;
      Object localObject3 = ((FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(paramString);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new ExtensionInfo();
        ((ExtensionInfo)localObject2).uin = paramString;
      }
      if (a(this.s, paramString, (ExtensionInfo)localObject2, paramFontInfo.a, paramInt))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isDIYFont fontId = ");
          ((StringBuilder)localObject2).append(paramFontInfo.a);
          ((StringBuilder)localObject2).append(" uin = ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" needUpdateDiyConfig");
          QLog.d("VasFont", 2, ((StringBuilder)localObject2).toString());
        }
        if (!((ConcurrentHashMap)localObject1).containsKey(Integer.valueOf(paramFontInfo.a)))
        {
          localObject2 = new FontInfo(0, "");
          ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.a), localObject2);
          this.L.put(paramString, localObject1);
        }
      }
      else if (((ConcurrentHashMap)localObject1).containsKey(Integer.valueOf(paramFontInfo.a)))
      {
        if (paramFontInfo.a != 0)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("isDIYFont fontid = ");
            paramString.append(paramFontInfo.a);
            paramString.append(" is diy font handle = ");
            paramString.append(paramFontInfo.f.mDiyHandle);
            QLog.d("VasFont", 2, paramString.toString());
          }
          paramFontInfo.g = true;
          return true;
        }
      }
      else
      {
        if ((((ExtensionInfo)localObject2).diyFontConfigMap != null) && (((ExtensionInfo)localObject2).diyFontConfigMap.containsKey(Integer.valueOf(paramFontInfo.a))))
        {
          localObject2 = (String)((ExtensionInfo)localObject2).diyFontConfigMap.get(Integer.valueOf(paramFontInfo.a));
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("isDIYFont fontId = ");
            ((StringBuilder)localObject3).append(paramFontInfo.a);
            ((StringBuilder)localObject3).append(" uin = ");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" config = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
          }
          paramFontInfo.f.parseDIYJsonString((String)localObject2);
          localObject2 = new FontInfo(paramFontInfo.a, paramFontInfo.b);
          ((FontInfo)localObject2).c = paramFontInfo.c;
          ((FontInfo)localObject2).g = true;
          localObject3 = new ETFont(paramFontInfo.a, paramFontInfo.b, 16.0F, paramFontInfo.c, null);
          ((ETFont)localObject3).copy(paramFontInfo.f);
          ((FontInfo)localObject2).f = ((ETFont)localObject3);
          ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.a), localObject2);
          this.L.put(paramString, localObject1);
          return true;
        }
        localObject2 = new FontInfo(paramFontInfo.a, paramFontInfo.b);
        ((FontInfo)localObject2).c = paramFontInfo.c;
        ((FontInfo)localObject2).g = true;
        ((FontInfo)localObject2).f = new ETFont(paramFontInfo.a, paramFontInfo.b, 16.0F, paramFontInfo.c, null);
        ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.a), localObject2);
        this.L.put(paramString, localObject1);
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    this.j.post(new FontManager.5(this, paramString, paramInt1, paramInt2, paramInt3, paramBoolean));
  }
  
  private void b(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    this.j.post(new FontManager.9(this, paramString, paramFontInfo, paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.a = f();
        if (this.a)
        {
          localObject2 = (FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER);
          this.c = ETEngine.getInstance();
          this.d = ETEngine.getInstanceForAnimation();
          if ((this.c != null) && (this.d != null))
          {
            i3 = ChatTextSizeSettingActivity.a(this.s.getApplication());
            i1 = i3 * i3 * 240 * 18 * 2;
            if (i1 <= 1048576) {
              break label674;
            }
            bool2 = this.c.isEngineReady.get();
            bool3 = this.d.isEngineReady.get();
            bool1 = bool2;
            if (bool2) {}
          }
        }
      }
      catch (Throwable localThrowable)
      {
        int i3;
        boolean bool2;
        boolean bool3;
        boolean bool1;
        Object localObject1;
        int i2;
        Object localObject3;
        ExtensionInfo localExtensionInfo;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init font engine fail ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("VasFont", 1, ((StringBuilder)localObject2).toString());
        ReportController.b(this.s, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
      }
      try
      {
        bool1 = this.c.initEngine(18, i1);
        bool2 = bool3;
        if (bool3) {
          continue;
        }
        bool2 = this.d.initEngine(10, 3145728);
      }
      catch (Exception localException)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init font engine fail ");
      ((StringBuilder)localObject1).append(((Exception)localObject2).getMessage());
      QLog.e("VasFont", 1, ((StringBuilder)localObject1).toString());
      ReportController.b(this.s, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
      return;
      if ((bool1) && (bool2)) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (paramBoolean)
      {
        localObject3 = "1";
        if (i2 != 0) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localExtensionInfo = ((FriendsManager)localObject2).x(this.s.getAccount());
        localObject2 = localObject3;
        if (localExtensionInfo != null)
        {
          localObject2 = localObject3;
          if (0L != localExtensionInfo.uVipFont)
          {
            localObject2 = localObject3;
            if (localExtensionInfo.vipFontType == 1) {
              localObject2 = "0";
            }
          }
        }
        ReportController.b(this.s, "CliOper", "", "", "Font_Mall", "0X80072CB", 0, 0, (String)localObject1, (String)localObject2, "", "");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("VipFontReport: AIO engine status, status=");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", hgType=");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
        }
      }
      if (i2 != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start init font engine fontsize=");
          ((StringBuilder)localObject1).append(i3);
          ((StringBuilder)localObject1).append(",num=");
          ((StringBuilder)localObject1).append(18);
          ((StringBuilder)localObject1).append(",cache=");
          ((StringBuilder)localObject1).append(i1);
          QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
        }
        ETEngine.getInstance().isEngineReady.set(true);
        if (!paramBoolean)
        {
          ReportController.b(this.s, "CliOper", "", "", "Font_Mall", "0X80072C9", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("VasFont", 2, "VipFontReport: AioRefreshed");
            return;
            throw new Exception("create font engine Instance fail");
          }
        }
      }
      return;
      label674:
      int i1 = 1048576;
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.A.iterator();
    while (localIterator.hasNext())
    {
      FontLoadCallback localFontLoadCallback = (FontLoadCallback)localIterator.next();
      if (localFontLoadCallback != null) {
        localFontLoadCallback.onFontLoaded();
      }
    }
  }
  
  private void l()
  {
    if (this.i != null)
    {
      Handler localHandler = ETTextView.mCreateDecorationHandler;
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
      localHandler = HiBoomTextView.j;
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
      ETTextView.mCreateDecorationHandler = null;
      HiBoomTextView.j = null;
      this.i.quit();
    }
  }
  
  private void m()
  {
    if (this.d != null) {
      try
      {
        synchronized (this.z)
        {
          ETFontUtil.clearMap(this.d);
          if (this.d != null)
          {
            this.d.native_doneEngine();
            this.d.isEngineInited.set(false);
            this.d.isEngineReady.set(false);
          }
          this.d = null;
          return;
        }
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, localUnsatisfiedLinkError.getMessage());
        }
      }
    }
  }
  
  private void n()
  {
    if (this.c != null) {
      try
      {
        synchronized (this.z)
        {
          ETFontUtil.clearMap(this.c);
          if (this.c != null)
          {
            this.c.native_doneEngine();
            this.c.isEngineInited.set(false);
            this.c.isEngineReady.set(false);
          }
          this.c = null;
          return;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  public FontInfo a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (((paramInt2 == 4) || (paramInt2 == 3)) && (!FastColorFontHelper.a().d.get()))
    {
      if (!FastColorFontHelper.a().b.get())
      {
        b();
        return null;
      }
      if (FastColorFontHelper.a().c.get())
      {
        FastColorFontHelper.a().b().a();
        FastColorFontHelper.a().d.set(true);
      }
      else
      {
        return null;
      }
    }
    Object localObject1 = t;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramInt1);
    localObject1 = (FontInfo)((ConcurrentHashMap)localObject1).get(((StringBuilder)localObject2).toString());
    if (localObject1 == null)
    {
      b(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
      return localObject1;
    }
    if (((FontInfo)localObject1).c == 4)
    {
      long l1 = System.currentTimeMillis();
      paramInt2 = FastColorFontHelper.a().a(paramInt1, ((FontInfo)localObject1).b);
      ((FontInfo)localObject1).h = FastColorFontCache.f(paramInt1);
      long l2 = System.currentTimeMillis();
      if (paramInt2 != 0) {
        FontReportUtils.a("action_load", paramInt1, 4, 0, l2 - l1);
      }
    }
    if (((FontInfo)localObject1).f == null) {
      ((FontInfo)localObject1).f = new ETFont(paramInt1, ((FontInfo)localObject1).b, 16.0F, ((FontInfo)localObject1).c, ((FontInfo)localObject1).d);
    }
    if (((FontInfo)localObject1).g)
    {
      localObject2 = (ConcurrentHashMap)this.L.get(paramString);
      if ((localObject2 != null) && (((ConcurrentHashMap)localObject2).containsKey(Integer.valueOf(paramInt1))))
      {
        localObject1 = (FontInfo)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt1));
        this.j.post(new FontManager.4(this, paramString, paramInt1, paramInt3));
        return localObject1;
      }
      b(paramString, (FontInfo)localObject1, paramInt3);
      return null;
    }
    return localObject1;
  }
  
  FontInfo a(ChatMessage paramChatMessage)
  {
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    String str = paramChatMessage.getExtInfoFromExtStr("diy_timestamp");
    int i3;
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {
      i3 = Integer.parseInt(str);
    } else {
      i3 = 0;
    }
    int i2;
    int i1;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject)) && (!((String)localObject).equals("0")))
    {
      long l1 = Long.parseLong((String)localObject);
      i2 = (int)FontManagerConstants.parseFontId(l1);
      i1 = FontManagerConstants.parseFontType(l1);
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    localObject = a(paramChatMessage);
    int i4 = i1;
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "doGetUserFont msg do not has font id");
      }
      localObject = ((FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER)).d((String)localObject, false);
      if (localObject != null)
      {
        i2 = (int)((ExtensionInfo)localObject).uVipFont;
        i4 = ((ExtensionInfo)localObject).vipFontType;
      }
      else
      {
        QLog.e("VasFont", 1, "doGetUserFont extensionInfo not in cache");
        return null;
      }
    }
    if (i2 != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doGetUserFont fontID = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(" type = ");
        ((StringBuilder)localObject).append(i4);
        QLog.d("VasFont", 2, ((StringBuilder)localObject).toString());
      }
      if (FontManagerConstants.mFontBlackList.contains(Integer.valueOf(i2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont font is in black list");
        }
        return null;
      }
      if (((i4 == 4) || (i4 == 3)) && (!d()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont Founder Color Font not supported");
        }
        return null;
      }
      if ((i4 == 1) && (!FontManagerConstants.mFontSwitchHanYi.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont HanYi Font not supported");
        }
        return null;
      }
      boolean bool;
      if ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000)) {
        bool = false;
      } else {
        bool = true;
      }
      paramChatMessage = a(i2, i4, bool, a(paramChatMessage), i3);
      if (paramChatMessage != null)
      {
        FontManagerConstants.sHasChatFont = true;
        return paramChatMessage;
      }
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("doGetUserFont no font fontid = ");
        paramChatMessage.append(i2);
        paramChatMessage.append(" fontType = ");
        paramChatMessage.append(i4);
        QLog.e("VasFont", 2, paramChatMessage.toString());
      }
      return null;
    }
    return new FontInfo(0, null);
  }
  
  public void a()
  {
    ETEngine localETEngine = this.d;
    if (localETEngine != null)
    {
      ETFontUtil.clearMap(localETEngine);
      this.d.native_resetEngine();
    }
    localETEngine = this.c;
    if (localETEngine != null)
    {
      ETFontUtil.clearMap(localETEngine);
      this.c.native_resetEngine();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.x.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.j.post(new FontManager.3(this, paramInt1));
      return;
    }
    VasFontIPCModule.a().a(paramInt1, -102);
    if ((!TextUtils.isEmpty(this.k)) && (this.u != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackId", this.k);
      localBundle.putInt("srcType", 9);
      this.u.a(0L, -1, localBundle);
      this.k = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String arg3)
  {
    ??? = new StringBuilder();
    ???.append("字体下载完成回调:");
    ???.append(paramInt1);
    ???.append(" error:");
    ???.append(paramInt2);
    QLog.e("DIYProfileTemplate.VasFont", 1, ???.toString());
    synchronized (this.y)
    {
      Object localObject1;
      if (this.y.contains(Integer.valueOf(paramInt1)))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDownloadComplete font ");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(" complete remove from list");
          QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
        }
        this.y.remove(Integer.valueOf(paramInt1));
      }
      long l1;
      if (this.H.containsKey(Integer.valueOf(paramInt1)))
      {
        l1 = ((Long)this.H.get(Integer.valueOf(paramInt1))).longValue();
        this.H.remove(Integer.valueOf(paramInt1));
      }
      else
      {
        l1 = 0L;
      }
      if (paramInt2 == 0)
      {
        if (l1 > 0L) {
          FontReportUtils.a("action_download", paramInt1, 4, 0, System.currentTimeMillis() - l1);
        }
        this.x.put(Integer.valueOf(paramInt1), Float.valueOf(1.0F));
      }
      else
      {
        this.x.put(Integer.valueOf(paramInt1), Float.valueOf(2.0F));
      }
      ??? = (String)this.G.get(Integer.valueOf(paramInt1));
      if ((??? != null) && (!???.equals("0")))
      {
        if (TextUtils.isDigitsOnly(???))
        {
          int i1 = Integer.parseInt(???);
          localObject1 = new EIPCResult();
          ((EIPCResult)localObject1).code = paramInt2;
          new Bundle().putInt("id", paramInt1);
          VasFontIPCModule.a().callbackResult(i1, (EIPCResult)localObject1);
        }
        if (this.u != null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("callbackId", ???);
          ((Bundle)localObject1).putInt("srcType", 2);
          ??? = this.u;
          l1 = paramInt1;
          if (paramInt2 == 0) {
            paramInt1 = 0;
          } else {
            paramInt1 = -1;
          }
          ???.a(l1, paramInt1, (Bundle)localObject1);
        }
      }
      if (paramInt2 == 0)
      {
        VasUtils.a(this.s);
        k();
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    synchronized (this.y)
    {
      if (this.y.contains(Integer.valueOf(paramInt1)))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("startDownload font ");
          paramString.append(paramInt1);
          paramString.append(" is downloading");
          QLog.d("VasFont", 2, paramString.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startDownload font ");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(" start download");
        QLog.d("VasFont", 2, ((StringBuilder)localObject2).toString());
      }
      this.y.add(Integer.valueOf(paramInt1));
      Object localObject2 = this.G;
      ??? = paramString;
      if (paramString == null) {
        ??? = "0";
      }
      ((Map)localObject2).put(Integer.valueOf(paramInt1), ???);
      paramString = (IVasQuickUpdateService)this.s.getRuntimeService(IVasQuickUpdateService.class, "");
      if (paramInt2 == 3)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("font.fzfont.android.");
        ((StringBuilder)???).append(paramInt1);
        paramString.downloadItem(5L, ((StringBuilder)???).toString(), "FontManager");
      }
      else
      {
        if (paramInt2 == 4) {
          this.H.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("font.main.android.");
        ((StringBuilder)???).append(paramInt1);
        paramString.downloadItem(5L, ((StringBuilder)???).toString(), "FontManager");
      }
      this.x.put(Integer.valueOf(paramInt1), Float.valueOf(0.0F));
      return;
    }
  }
  
  public void a(TextView paramTextView)
  {
    IFontManagerService localIFontManagerService = (IFontManagerService)this.s.getRuntimeService(IFontManagerService.class, "");
    float f1 = localIFontManagerService.getEnlargeFontText();
    if (FontSettingManager.getFontLevel() == 18.0F) {
      f1 = localIFontManagerService.getEnlargeFontTextMax();
    }
    paramTextView.setTextSize(2, Math.round(f1 / this.s.getApp().getResources().getDisplayMetrics().density * ChatTextSizeSettingActivity.a(this.s.getApp())));
  }
  
  public void a(ChatMessage paramChatMessage, FontInfo paramFontInfo, String paramString)
  {
    int i1 = VipUtils.a(paramChatMessage.getExtInfoFromExtStr("vip_diy_font_id"), 0);
    if ((i1 > 0) && (paramFontInfo != null) && (paramFontInfo.a != 0) && (ETEngine.isSOLoaded.get()) && (paramFontInfo.c == 1))
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(MD5Utils.encodeHexStr(paramString));
      paramChatMessage.append(File.separator);
      paramChatMessage.append(i1);
      paramChatMessage = paramChatMessage.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("");
      ETDIYUtil.a(localStringBuilder.toString(), paramString, paramChatMessage);
      if ((paramFontInfo.f != null) && (!paramFontInfo.f.mDiyFontImageId.equals(paramChatMessage)))
      {
        paramString = ETDIYConfig.a(paramFontInfo.a, paramChatMessage);
        if (!TextUtils.isEmpty(paramString))
        {
          long l1 = ETSubstitutionConfig.a(paramFontInfo.f, paramString);
          paramFontInfo.f.set_substitution(l1);
          paramFontInfo.f.mDiyFontImageId = paramChatMessage;
        }
      }
    }
  }
  
  public void a(FontLoadCallback paramFontLoadCallback)
  {
    if (paramFontLoadCallback != null)
    {
      if (this.A.contains(paramFontLoadCallback)) {
        return;
      }
      this.A.add(paramFontLoadCallback);
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.u = paramIPCDownloadListener;
  }
  
  public void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      int i1;
      try
      {
        paramFile = new JSONObject(FileUtils.readFileContent(paramFile));
        Object localObject = paramFile.optJSONArray("defaultEffect");
        if (1 == ((JSONArray)localObject).length()) {
          this.r = ((JSONObject)((JSONArray)localObject).get(0)).optInt("effectID", 1);
        }
        paramFile = paramFile.optJSONArray("magicFontConfig");
        i1 = 0;
        if (i1 < paramFile.length())
        {
          localObject = (JSONObject)paramFile.get(i1);
          if (2 != ((JSONObject)localObject).optInt("platformId", 0)) {
            break label364;
          }
          this.l = ((float)((JSONObject)localObject).optDouble("fontEnlargeFactor"));
          this.m = ((float)((JSONObject)localObject).optDouble("maxEnlargeFactor"));
          this.n = ((float)((JSONObject)localObject).optDouble("emotionEnlargeFactor"));
          if (((JSONObject)localObject).optInt("switch", 1) != 1) {
            break label359;
          }
          bool = true;
          this.o = bool;
          this.p = ((JSONObject)localObject).optString("description");
          this.q = ((JSONObject)localObject).optString("magic");
          break label364;
        }
        if (QLog.isColorLevel())
        {
          paramFile = new StringBuilder();
          paramFile.append("fontEffectPrefer = ");
          paramFile.append(this.r);
          paramFile.append(" enlargeFontText = ");
          paramFile.append(this.l);
          paramFile.append(" enlargeFontTextMax = ");
          paramFile.append(this.m);
          paramFile.append(" enlargeFontEmo = ");
          paramFile.append(this.n);
          paramFile.append(" enlargeFontSwitch = ");
          paramFile.append(this.o);
          paramFile.append(" enlargeFontDesc = ");
          paramFile.append(this.p);
          paramFile.append(" enlargeFontImgURL = ");
          paramFile.append(this.q);
          QLog.i("VasFont", 2, paramFile.toString());
        }
        this.E = true;
        VasUtils.a(this.s);
        return;
      }
      catch (Exception paramFile)
      {
        QLog.e("VasFont", 1, "parse fontEffect json config fail", paramFile);
      }
      return;
      label359:
      boolean bool = false;
      continue;
      label364:
      i1 += 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = localFriendsManager.x(paramString);
    int i1;
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
      localExtensionInfo.fontEffect = -1;
      i1 = 1;
      paramString = localExtensionInfo;
    }
    else
    {
      i1 = 0;
      paramString = localExtensionInfo;
    }
    if (paramString.fontEffect != paramInt)
    {
      paramString.fontEffect = paramInt;
      paramString.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      h();
      i1 = 1;
    }
    if (i1 != 0) {
      localFriendsManager.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("font_open_switch", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserOpenFontSwitch_");
      localStringBuilder.append(this.s.getAccount());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    }
    this.b = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.e.set(paramBoolean);
    this.f = paramInt;
    this.g = paramString;
    SharedPreferences.Editor localEditor = this.s.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.putInt("font_test_type", paramInt);
    localEditor.putString("font_test_file", paramString);
    localEditor.commit();
  }
  
  public boolean a(int paramInt)
  {
    ETEngine localETEngine = this.c;
    if ((localETEngine != null) && (localETEngine.isEngineReady.get())) {
      return this.c.native_isFontLoaded(paramInt);
    }
    return false;
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
      if ((paramViewHolder.v instanceof ETTextView))
      {
        if (((ETTextView)paramViewHolder.v).mFont == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has no font yet");
          }
          return true;
        }
        FontInfo localFontInfo = b(paramChatMessage);
        if ((localFontInfo != null) && ((paramViewHolder.v instanceof ETTextView)))
        {
          ETTextView localETTextView = (ETTextView)paramViewHolder.v;
          if (localETTextView.mFont.mFontId != localFontInfo.a)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has font change");
            }
            return true;
          }
          if ((localFontInfo.f != null) && (localFontInfo.f.mDiyHandle != localETTextView.mFont.mDiyHandle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has diyFont change");
            }
            return true;
          }
        }
        if (FontManagerConstants.parseMagicFont(paramChatMessage) != ((ETTextView)paramViewHolder.v).mMagicFont)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change");
          }
          return true;
        }
        if (this.E)
        {
          this.E = false;
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh needRefershAIOForFontEffect.");
          }
          return true;
        }
        paramViewHolder = (ETTextView)paramViewHolder.v;
        if ((paramViewHolder.getETLayout() != null) && (paramViewHolder.mMagicFont != paramViewHolder.getETLayout().h))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change 2");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    ??? = (IVasQuickUpdateService)this.s.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("font.main.android.");
    localStringBuilder.append(paramInt);
    ((IVasQuickUpdateService)???).cancelDwonloadItem(5L, localStringBuilder.toString());
    this.x.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
    synchronized (this.y)
    {
      if (this.y.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stopDownload font ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" complete remove from list");
          QLog.d("VasFont", 2, localStringBuilder.toString());
        }
        this.y.remove(Integer.valueOf(paramInt));
      }
      return 0;
    }
  }
  
  public FontInfo b(int paramInt1, int paramInt2)
  {
    FontInfo localFontInfo = (FontInfo)t.get(Integer.valueOf(paramInt1));
    Object localObject = localFontInfo;
    if (localFontInfo == null)
    {
      localObject = new File(FontManagerConstants.getTTFPath(paramInt1, paramInt2));
      boolean bool = ((File)localObject).exists();
      if (bool) {
        localFontInfo = new FontInfo(paramInt1, ((File)localObject).getAbsolutePath());
      }
      localObject = localFontInfo;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findFontInfo|find from local|fontExists=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("VasFont", 2, ((StringBuilder)localObject).toString());
        localObject = localFontInfo;
      }
    }
    return localObject;
  }
  
  public FontInfo b(ChatMessage paramChatMessage)
  {
    this.a = f();
    if (!this.a)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasFont", 2, "getUserFont fontFeatureSupported = false");
      }
      return null;
    }
    if ((this.e.get()) && (!TextUtils.isEmpty(this.g))) {
      return i();
    }
    String str1 = a(paramChatMessage);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getUserFont uin is empty");
      }
      return new FontInfo(0, null);
    }
    Object localObject2 = (FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = ((FriendsManager)localObject2).d(str1, false);
    String str2 = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUserFont: message font id = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" uin = ");
      localStringBuilder.append(str1);
      QLog.d("VasFont", 2, localStringBuilder.toString());
    }
    long l1 = paramChatMessage.time;
    if ((!TextUtils.isEmpty(str2)) && (TextUtils.isDigitsOnly(str2)) && (!str2.equals("0")))
    {
      long l2 = Long.parseLong(str2);
      int i1 = FontManagerConstants.parseFontType(l2);
      if ((i1 == 2) || (i1 == 1) || (i1 == 4))
      {
        if ((localObject1 != null) && (l1 > ((ExtensionInfo)localObject1).lastUpdateTime))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getUserFont: message time = ");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(" lastUpdateTime = ");
            ((StringBuilder)localObject2).append(((ExtensionInfo)localObject1).lastUpdateTime);
            QLog.d("VasFont", 2, ((StringBuilder)localObject2).toString());
          }
          if (FontManagerConstants.parseFontId(l2) != ((ExtensionInfo)localObject1).uVipFont)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("getUserFont: message font not equals local uin = ");
              ((StringBuilder)localObject1).append(str1);
              QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
            }
            AvatarPendantUtil.a(str1);
          }
          for (;;)
          {
            i1 = 1;
            break label460;
            if (FontManagerConstants.parseMagicFont(l2) == ((ExtensionInfo)localObject1).magicFont) {
              break;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("getUserFont: message magicfont not equals local uin = ");
              ((StringBuilder)localObject1).append(str1);
              QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
            }
            AvatarPendantUtil.a(str1);
          }
          i1 = 0;
          label460:
          if (i1 != 0) {
            AvatarPendantUtil.a(this.s);
          }
        }
        return a(paramChatMessage);
      }
    }
    if (localObject1 != null) {
      return a(paramChatMessage);
    }
    new QueryTask(new FontManager.6(this, (FriendsManager)localObject2, str1), new FontManager.7(this, paramChatMessage)).a(null);
    if (QLog.isColorLevel()) {
      QLog.i("VasFont", 2, "getUserFont extensionInfo no cache.");
    }
    return null;
  }
  
  void b()
  {
    if (FastColorFontHelper.a().b.get()) {
      return;
    }
    FastColorFontHelper.a().b.set(true);
    this.j.post(new FontManager.1(this));
  }
  
  public void b(FontLoadCallback paramFontLoadCallback)
  {
    if (paramFontLoadCallback == null) {
      return;
    }
    this.A.remove(paramFontLoadCallback);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.j.post(new FontManager.10(this, paramString, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.set(paramBoolean);
    SharedPreferences.Editor localEditor = this.s.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.commit();
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = TextUtils.isEmpty(a(paramMessageRecord));
    boolean bool1 = false;
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> get sender uin null");
      }
      return false;
    }
    if (FontManagerConstants.parseMagicFont(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> magic font first.");
      }
      return false;
    }
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("vip_font_effect_id");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("enableEnlargeFontEffect --> font effect id(msg str): ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("tag.vasFont.enlarge", 2, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isDigitsOnly((CharSequence)localObject1)))
    {
      int i1 = Integer.valueOf((String)localObject1).intValue();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enableEnlargeFontEffect --> font effect id(msg int): ");
        ((StringBuilder)localObject1).append(i1);
        QLog.i("tag.vasFont.enlarge", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 != 0)
      {
        if (!this.D)
        {
          this.D = true;
          paramMessageRecord = VasUpdateUtil.a(this.s, 5L, "magicFontConfig.json", FontManagerConstants.FONT_EFFECT_CFG, true, null);
          if (paramMessageRecord != null) {
            a(paramMessageRecord);
          }
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, parse Json.");
          }
          return false;
        }
        if (!this.o)
        {
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, enlargeFontSwitch close.");
          }
          return false;
        }
        if (paramMessageRecord.isSend()) {
          localObject1 = paramMessageRecord.selfuin;
        } else if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004)) {
          localObject1 = paramMessageRecord.senderuin;
        } else {
          localObject1 = paramMessageRecord.frienduin;
        }
        Object localObject3 = (FriendsManager)this.s.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject3 != null)
        {
          localObject2 = ((FriendsManager)localObject3).d((String)localObject1, false);
          if (localObject2 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("enableEnlargeFontEffect --> extensionInfo.fontEffectLastUpdateTime:");
              ((StringBuilder)localObject3).append(((ExtensionInfo)localObject2).fontEffectLastUpdateTime);
              ((StringBuilder)localObject3).append(" msg.time:");
              ((StringBuilder)localObject3).append(paramMessageRecord.time);
              QLog.i("tag.vasFont.enlarge", 2, ((StringBuilder)localObject3).toString());
            }
            if ((((ExtensionInfo)localObject2).fontEffectLastUpdateTime < paramMessageRecord.time) && (i1 != ((ExtensionInfo)localObject2).fontEffect))
            {
              if (QLog.isColorLevel()) {
                QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> fontEffectId not equal with local.");
              }
              AvatarPendantUtil.a((String)localObject1);
              AvatarPendantUtil.a(this.s);
            }
          }
          else
          {
            ThreadManager.post(new FontManager.8(this, (FriendsManager)localObject3, (String)localObject1), 5, null, true);
          }
        }
        if (2000 == i1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> enable enlarge font.");
          }
          bool1 = true;
        }
        return bool1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, fontEffectId=FontManagerConstants.FONT_EFFECT_NONE.");
      }
      return false;
    }
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("enableEnlargeFontEffect --> error effect id: ");
    paramMessageRecord.append((String)localObject1);
    QLog.e("tag.vasFont.enlarge", 1, paramMessageRecord.toString());
    return false;
  }
  
  public Drawable c(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append("fontname.png");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject1).exists()) {
      return null;
    }
    Object localObject3;
    try
    {
      new BitmapFactory.Options().inJustDecodeBounds = true;
      Object localObject2 = new FileInputStream((File)localObject1);
      localObject1 = BitmapFactory.decodeStream((InputStream)localObject2);
      try
      {
        ((FileInputStream)localObject2).close();
        localObject2 = localObject1;
      }
      catch (IOException localIOException1) {}catch (FileNotFoundException localFileNotFoundException1) {}
      localObject3 = localObject1;
    }
    catch (IOException localIOException2)
    {
      localObject1 = null;
      localIOException2.printStackTrace();
      localObject3 = localObject1;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("VasFont", 2, localFileNotFoundException2.toString());
      localObject3 = localObject1;
    }
    if (localObject3 != null) {
      return new BitmapDrawable(localObject3);
    }
    return null;
  }
  
  public JSONObject c(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      float f1;
      try
      {
        FontInfo localFontInfo = b(paramInt1, paramInt2);
        paramInt2 = 0;
        if (localFontInfo != null)
        {
          localJSONObject2.put("status", 3);
          localJSONObject2.put("progress", 100);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131902684));
        }
        else if (this.x.containsKey(Integer.valueOf(paramInt1)))
        {
          f1 = ((Float)this.x.get(Integer.valueOf(paramInt1))).floatValue();
          if (f1 == 1.0F)
          {
            localJSONObject2.put("status", 3);
            localJSONObject1.put("result", 0);
            localJSONObject1.put("message", HardCodeUtil.a(2131902685));
            break label413;
          }
          if (f1 == 2.0F)
          {
            localJSONObject2.put("status", 1);
            localJSONObject1.put("result", -1);
            localJSONObject1.put("message", HardCodeUtil.a(2131902682));
            break label413;
          }
          localJSONObject2.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131902680));
          break label413;
          localJSONObject2.put("canceling", paramInt2);
          localJSONObject2.put("progress", f1 * 100.0F);
        }
        else
        {
          localJSONObject2.put("status", 1);
          localJSONObject2.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131902681));
        }
        localJSONObject2.put("id", paramInt1);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryInfo fontId=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",json=");
        localStringBuilder.append(localJSONObject1.toString());
        QLog.d("VasFont", 2, localStringBuilder.toString());
      }
      return localJSONObject1;
      label413:
      if (f1 == 3.0F) {
        paramInt2 = 1;
      }
    }
  }
  
  public void c()
  {
    if ((ETEngine.getInstance().isEngineInited.compareAndSet(false, true)) && (FontSoLoader.c())) {
      this.j.postDelayed(new FontManager.2(this), 2000L);
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      Object localObject = (MessageForText)paramChatMessage;
      paramChatMessage = null;
      if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          paramChatMessage = ((MessageForText)localObject).sb2;
        } else {
          paramChatMessage = ((MessageForText)localObject).sb;
        }
      }
      if (paramChatMessage != null)
      {
        localObject = (IFontManagerService)this.s.getRuntimeService(IFontManagerService.class, "");
        if ((paramChatMessage instanceof QQText))
        {
          QQText localQQText = (QQText)paramChatMessage;
          int i2 = paramChatMessage.length();
          int i1 = 0;
          paramChatMessage = (EmoticonSpan[])localQQText.getSpans(0, i2, EmoticonSpan.class);
          i2 = paramChatMessage.length;
          while (i1 < i2)
          {
            paramChatMessage[i1].setSize(ScreenUtil.dip2px(Math.round(((IFontManagerService)localObject).getEnlargeFontEmo() * 32.0F)));
            i1 += 1;
          }
        }
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownloadFont start");
    }
    Object localObject1 = b(paramInt1, paramInt2);
    if (localObject1 != null)
    {
      t.remove(String.valueOf(paramInt1));
      Object localObject2 = t.keySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        String[] arrayOfString = ((String)localObject3).split("|");
        if ((arrayOfString.length >= 2) && (String.valueOf(paramInt1).equals(arrayOfString[1]))) {
          t.remove(localObject3);
        }
      }
      localObject1 = new File(((FontInfo)localObject1).b);
      if (((File)localObject1).exists())
      {
        localObject1 = new File(((File)localObject1).getParent());
        localObject2 = ((File)localObject1).listFiles();
        if (localObject2 != null)
        {
          int i1 = 0;
          while (i1 < localObject2.length)
          {
            bool = localObject2[i1].delete();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("reDownloadFont delete ");
              ((StringBuilder)localObject3).append(localObject2[i1].getName());
              ((StringBuilder)localObject3).append(" ret = ");
              ((StringBuilder)localObject3).append(bool);
              QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
            }
            i1 += 1;
          }
        }
        boolean bool = ((File)localObject1).delete();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reDownloadFont delete ");
          ((StringBuilder)localObject2).append(((File)localObject1).getName());
          ((StringBuilder)localObject2).append(" ret = ");
          ((StringBuilder)localObject2).append(bool);
          QLog.d("VasFont", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VasFont", 2, "reDownloadFont fontFile not exist");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownload startDownload");
    }
    a(paramInt1, null, paramInt2);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (NetConnInfoCenter.getServerTimeMillis() - FontManagerConstants.todayStartTime > 86400000L)
    {
      FontManagerConstants.todayStartTime = NetConnInfoCenter.getServerTimeMillis() - NetConnInfoCenter.getServerTimeMillis() % 86400000L;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportFontEffect: time = ");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date(FontManagerConstants.todayStartTime)));
        QLog.d("VasFont", 2, localStringBuilder.toString());
      }
    }
    if (paramChatMessage.isSend())
    {
      if (0L == this.J) {
        this.J = this.s.getPreferences().getLong("magic_font_last_send_report", 0L);
      }
      if (0L == this.K) {
        this.K = this.s.getPreferences().getLong("magic_font_reset_time", 0L);
      }
      if ((this.J < FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > this.K))
      {
        int i2 = 0;
        localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
        int i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          i1 = i2;
          if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
            i1 = Integer.valueOf((String)localObject).intValue();
          }
        }
        i2 = i1;
        if (i1 == 0)
        {
          i2 = i1;
          if (FontManagerConstants.parseMagicFont(paramChatMessage)) {
            i2 = 1;
          }
        }
        if (i2 != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reportFontEffect real report.");
          }
          localObject = paramChatMessage.selfuin;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          VasWebviewUtil.a((String)localObject, "FontEffect", "SendMsg", "", 1, 0, 0, "", localStringBuilder.toString(), "");
          this.J = (paramChatMessage.time * 1000L);
          localObject = this.s.getPreferences().edit();
          ((SharedPreferences.Editor)localObject).putLong("magic_font_last_send_report", paramChatMessage.time * 1000L);
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
  }
  
  public boolean d()
  {
    return FontManagerConstants.mFontSwitchFZ.get();
  }
  
  public boolean e()
  {
    int i1 = B;
    boolean bool = false;
    if (i1 == -1)
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FounderDynamicFont DPC value = ");
          localStringBuilder.append(localObject[8]);
          QLog.d("VasFont", 1, localStringBuilder.toString());
          if ("0".equals(localObject[8])) {
            B = 0;
          } else {
            B = 1;
          }
        }
      }
    }
    i1 = B;
    if ((i1 == 1) || (i1 == -1)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    int i1 = this.C;
    boolean bool = false;
    if (i1 != -1)
    {
      if (i1 == 1) {
        bool = true;
      }
      return bool;
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.chat_font.name(), "default");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fontSwitch = ");
    localStringBuilder.append(str);
    QLog.d("VasFont", 1, localStringBuilder.toString());
    if (str.equals("1"))
    {
      this.a = true;
      this.C = 1;
      return this.a;
    }
    if (this.b)
    {
      this.a = true;
      this.C = 1;
      return this.a;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.a = a(str);
    }
    if (str.equals("0")) {
      this.C = 0;
    }
    return this.a;
  }
  
  public File g()
  {
    File localFile = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "resetLastSendReportTime.");
    }
    this.J = 0L;
    this.K = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.s.getPreferences().edit();
    localEditor.putLong("magic_font_last_send_report", this.J);
    localEditor.putLong("magic_font_reset_time", this.K);
    localEditor.apply();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    return true;
  }
  
  public FontInfo i()
  {
    ??? = (FontInfo)this.F.get(this.g);
    if (??? != null)
    {
      if (((FontInfo)???).c == 4) {
        FastColorFontHelper.a().a(((FontInfo)???).a, ((FontInfo)???).b);
      }
      return ???;
    }
    int i1 = this.f;
    Object localObject6;
    if (i1 == 1)
    {
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        c();
        return null;
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      synchronized (this.z)
      {
        Object localObject3 = this.c;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject6).append(this.g);
        ((ETEngine)localObject3).native_loadFont(((StringBuilder)localObject6).toString(), this.g.hashCode(), true);
        localObject3 = this.d;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject6).append(this.g);
        ((ETEngine)localObject3).native_loadFont(((StringBuilder)localObject6).toString(), this.g.hashCode(), true);
        i1 = this.g.hashCode();
        ??? = new StringBuilder();
        ((StringBuilder)???).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)???).append(this.g);
        ??? = new FontInfo(i1, ((StringBuilder)???).toString());
        i1 = ((FontInfo)???).a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject3).append(this.g);
        localObject3 = new ETFont(i1, ((StringBuilder)localObject3).toString(), 1.0F);
        ((FontInfo)???).h = this.c.native_getVariantStyleComboCount((ETFont)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getTestFont: fontId=");
          ((StringBuilder)localObject3).append(((FontInfo)???).a);
          ((StringBuilder)localObject3).append(" styleCount=");
          ((StringBuilder)localObject3).append(((FontInfo)???).h);
          QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
        }
        ((FontInfo)???).c = this.f;
      }
    }
    if (i1 == 2)
    {
      i1 = this.g.hashCode();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FANGZHENG_FILE_DIR);
      ((StringBuilder)???).append(this.g);
      ??? = new FontInfo(i1, ((StringBuilder)???).toString());
      ((FontInfo)???).c = this.f;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FANGZHENG_FILE_DIR);
      ((StringBuilder)???).append(this.g);
      ((FontInfo)???).d = Typeface.createFromFile(((StringBuilder)???).toString());
    }
    else if (i1 == 4)
    {
      if (!FastColorFontHelper.a().b.get()) {
        b();
      }
      if (!FastColorFontHelper.a().d.get()) {
        if (FastColorFontHelper.a().c.get())
        {
          FastColorFontHelper.a().b().a();
          FastColorFontHelper.a().d.set(true);
        }
        else
        {
          return null;
        }
      }
      i1 = this.g.hashCode();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FZCOLOR_2_FILE_DIR);
      ((StringBuilder)???).append(this.g);
      ??? = new FontInfo((i1 & 0x3FFF) + 49152, ((StringBuilder)???).toString());
      ((FontInfo)???).c = this.f;
      FastColorFontHelper.a().a(((FontInfo)???).a, ((FontInfo)???).b);
      ((FontInfo)???).h = FastColorFontCache.f(((FontInfo)???).a);
    }
    else if (i1 == 99)
    {
      if (!ETEngine.getInstance().isEngineInited.get()) {
        c();
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.DIY_FONT_DIR);
      ((StringBuilder)???).append(this.g);
      ??? = new FontInfo(1000, ((StringBuilder)???).toString());
      ((FontInfo)???).c = 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.DIY_FONT_DIR);
      ((StringBuilder)???).append("config.json");
      ??? = new File(((StringBuilder)???).toString());
      if (((File)???).exists()) {
        ((FontInfo)???).e = ETDIYConfig.a((File)???);
      }
      ((FontInfo)???).f = new ETFont(((FontInfo)???).a, ((FontInfo)???).b, 16.0F, ((FontInfo)???).c, ((FontInfo)???).d);
      synchronized (this.z)
      {
        localObject6 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FontManagerConstants.HANYI_FILE_DIR);
        localStringBuilder.append(this.g);
        ((ETEngine)localObject6).native_loadFont(localStringBuilder.toString(), ((FontInfo)???).a, true);
        localObject6 = this.d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(FontManagerConstants.HANYI_FILE_DIR);
        localStringBuilder.append(this.g);
        ((ETEngine)localObject6).native_loadFont(localStringBuilder.toString(), ((FontInfo)???).a, true);
        ((FontInfo)???).f.parseDIYJsonString(((FontInfo)???).e);
      }
    }
    if (localObject2 != null) {
      this.F.put(this.g, localObject2);
    }
    return localObject2;
  }
  
  public void onDestroy()
  {
    FontManagerConstants.mMineLastReportTime = 0L;
    FontManagerConstants.mOthersLastReportTime = 0L;
    t.clear();
    Handler localHandler = this.j;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    l();
    n();
    m();
    HiBoomFont.a().c.set(false);
    HiBoomFont.a().d.set(false);
    this.A.clear();
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "onDestroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */