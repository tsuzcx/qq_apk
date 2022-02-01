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
  private static ConcurrentHashMap<String, FontInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static int jdField_c_of_type_Int = -1;
  private static int jdField_e_of_type_Int;
  public float a;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  public Handler a;
  public HandlerThread a;
  protected ETEngine a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private List<Integer> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<Integer, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<FontLoadCallback> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public AtomicBoolean a;
  public boolean a;
  public float b;
  public int b;
  private long jdField_b_of_type_Long = 0L;
  protected ETEngine b;
  public String b;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, FontInfo> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean b;
  public volatile boolean b;
  public float c;
  public String c;
  private Map<Integer, Long> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, FontInfo>> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean c;
  private int jdField_d_of_type_Int = -1;
  public String d;
  private boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
    this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_b_of_type_Float = 1.3F;
    this.jdField_c_of_type_Float = 1.5F;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131704782);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    FontManagerConstants.updateFontSwitch(SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "vas_font_switch_config"));
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUserOpenFontSwitch_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    this.jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.jdField_d_of_type_Boolean)
    {
      paramQQAppInterface.append(DeviceInfoUtil.i());
      paramQQAppInterface.append("; CPU number: ");
      paramQQAppInterface.append(DeviceInfoUtil.b());
      paramQQAppInterface.append("; CPU frequency: ");
      paramQQAppInterface.append(DeviceInfoUtil.b());
      paramQQAppInterface.append("; RAM: ");
      paramQQAppInterface.append(DeviceInfoUtil.a());
    }
    this.jdField_e_of_type_JavaLangString = paramQQAppInterface.toString();
    this.jdField_a_of_type_Boolean = c();
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public static int a(long paramLong)
  {
    Object localObject = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null) {
      localObject = (FontInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf((int)paramLong));
    } else {
      localObject = null;
    }
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((FontInfo)localObject).jdField_c_of_type_Int;
    } else {
      i = 0;
    }
    if (i > 0) {
      j = jdField_e_of_type_Int % i;
    }
    jdField_e_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVariedStyleIndex: sIndex=");
      ((StringBuilder)localObject).append(jdField_e_of_type_Int);
      ((StringBuilder)localObject).append(" fontId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" styleCount=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" index=");
      ((StringBuilder)localObject).append(j);
      QLog.d("VasFont", 2, ((StringBuilder)localObject).toString());
    }
    return j;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 1025) {
          break label214;
        }
        if (i != 3000) {
          if ((i == 10002) || (i == 10004)) {
            break label214;
          }
        }
      }
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              break label212;
              if (paramMessageRecord.isSend()) {
                return paramMessageRecord.selfuin;
              }
              return paramMessageRecord.senderuin;
              if (!AnonymousChatHelper.a(paramMessageRecord))
              {
                if (paramMessageRecord.isSend()) {
                  return paramMessageRecord.selfuin;
                }
                return paramMessageRecord.senderuin;
              }
              label212:
              return null;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    label214:
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.5(this, paramString, paramInt1, paramInt2, paramInt3, paramBoolean));
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.a != null)
    {
      int j = paramBaseChatPie.a.getFirstVisiblePosition();
      int k = paramBaseChatPie.a.getLastVisiblePosition();
      int m = paramBaseChatPie.a.getHeaderViewsCount();
      int i = j - 1;
      while (i <= k)
      {
        Object localObject = paramBaseChatPie.a.getChildAt(m + i - j);
        if (localObject != null) {
          if ((AIOUtils.a((View)localObject) instanceof TextItemBuilder.Holder))
          {
            localObject = (TextItemBuilder.Holder)AIOUtils.a((View)localObject);
            if ((((TextItemBuilder.Holder)localObject).d instanceof ETTextView)) {
              ((ETTextView)((TextItemBuilder.Holder)localObject).d).startAnimation(false, true);
            }
          }
          else if ((AIOUtils.a((View)localObject) instanceof RichStatItemBuilder.Holder))
          {
            localObject = (RichStatItemBuilder.Holder)AIOUtils.a((View)localObject);
            if ((((RichStatItemBuilder.Holder)localObject).a != null) && (((RichStatItemBuilder.Holder)localObject).a.a != null)) {
              ((RichStatItemBuilder.Holder)localObject).a.a.startAnimation(false, true);
            }
          }
          else if ((AIOUtils.a((View)localObject) instanceof HiBoomItemBuilder.HiBoomHolder))
          {
            ((HiBoomItemBuilder.HiBoomHolder)AIOUtils.a((View)localObject)).a.c();
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.9(this, paramString, paramFontInfo, paramInt));
  }
  
  /* Error */
  private boolean a(FontInfo paramFontInfo, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 382	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9: aload_2
    //   10: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: istore 5
    //   15: new 390	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: getfield 391	com/etrump/mixlayout/FontInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 393	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload 6
    //   30: invokevirtual 396	java/io/File:exists	()Z
    //   33: ifne +58 -> 91
    //   36: aload_0
    //   37: aload_1
    //   38: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   41: aconst_null
    //   42: iconst_1
    //   43: invokevirtual 400	com/etrump/mixlayout/FontManager:a	(ILjava/lang/String;I)V
    //   46: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +38 -> 87
    //   52: new 159	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc_w 402
    //   64: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: aload_1
    //   70: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   73: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 214
    //   79: iconst_2
    //   80: aload_2
    //   81: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_0
    //   90: ireturn
    //   91: aload 6
    //   93: invokestatic 408	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   96: ifnonnull +41 -> 137
    //   99: aload_0
    //   100: aload_1
    //   101: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   104: iconst_1
    //   105: invokevirtual 411	com/etrump/mixlayout/FontManager:b	(II)V
    //   108: ldc_w 413
    //   111: ldc_w 415
    //   114: ldc_w 417
    //   117: iconst_0
    //   118: iconst_0
    //   119: aload_1
    //   120: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   123: iconst_1
    //   124: ldc_w 419
    //   127: ldc_w 419
    //   130: invokestatic 424	com/tencent/mobileqq/vas/webview/util/VasWebviewUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: iconst_0
    //   136: ireturn
    //   137: new 159	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   144: astore 6
    //   146: aload 6
    //   148: ldc_w 426
    //   151: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: aload_1
    //   158: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   161: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 428
    //   170: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: invokestatic 433	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: ldc 214
    //   185: iconst_1
    //   186: aload 6
    //   188: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_0
    //   195: getfield 79	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   198: astore 6
    //   200: aload 6
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 50	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   207: aload_1
    //   208: getfield 391	com/etrump/mixlayout/FontInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   211: aload_1
    //   212: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   215: iload 5
    //   217: invokevirtual 439	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   220: istore 4
    //   222: aload_0
    //   223: getfield 52	com/etrump/mixlayout/FontManager:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   226: aload_1
    //   227: getfield 391	com/etrump/mixlayout/FontInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: aload_1
    //   231: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   234: iload 5
    //   236: invokevirtual 439	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   239: istore 5
    //   241: aload 6
    //   243: monitorexit
    //   244: new 159	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   251: astore 6
    //   253: aload 6
    //   255: ldc_w 441
    //   258: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: aload_1
    //   265: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   268: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: ldc_w 428
    //   277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 6
    //   283: invokestatic 433	java/lang/System:currentTimeMillis	()J
    //   286: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 214
    //   292: iconst_1
    //   293: aload 6
    //   295: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: iload 4
    //   303: ifeq +47 -> 350
    //   306: iload 5
    //   308: ifne +6 -> 314
    //   311: goto +39 -> 350
    //   314: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +12 -> 329
    //   320: ldc 214
    //   322: iconst_2
    //   323: ldc_w 443
    //   326: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_0
    //   330: aload_2
    //   331: aload_1
    //   332: iload_3
    //   333: invokespecial 446	com/etrump/mixlayout/FontManager:a	(Ljava/lang/String;Lcom/etrump/mixlayout/FontInfo;I)Z
    //   336: ifeq +10 -> 346
    //   339: aload_0
    //   340: getfield 48	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   343: invokestatic 451	com/tencent/mobileqq/utils/VasUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   346: aload_0
    //   347: monitorexit
    //   348: iconst_1
    //   349: ireturn
    //   350: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +94 -> 447
    //   356: new 159	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   363: astore_2
    //   364: aload_2
    //   365: ldc_w 453
    //   368: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_2
    //   373: aload_1
    //   374: getfield 397	com/etrump/mixlayout/FontInfo:jdField_a_of_type_Int	I
    //   377: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: ldc_w 455
    //   385: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: iload 4
    //   392: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc_w 460
    //   400: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_2
    //   405: iload 5
    //   407: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 214
    //   413: iconst_2
    //   414: aload_2
    //   415: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto +26 -> 447
    //   424: astore_1
    //   425: aload 6
    //   427: monitorexit
    //   428: aload_1
    //   429: athrow
    //   430: astore_1
    //   431: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +13 -> 447
    //   437: ldc 214
    //   439: iconst_2
    //   440: ldc_w 462
    //   443: aload_1
    //   444: invokestatic 465	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    int i = this.jdField_d_of_type_Int;
    boolean bool = false;
    if (i == -1)
    {
      if (((DeviceInfoUtil.b() >= 2) && (DeviceInfoUtil.b() > 1000L)) || ((DeviceInfoUtil.b() >= 4) && (DeviceInfoUtil.a() > 838860800L)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
        }
        this.jdField_d_of_type_Int = 1;
      }
      else
      {
        this.jdField_d_of_type_Int = 0;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChatFontAbilityFromLocal return false. CPU number = ");
          localStringBuilder.append(DeviceInfoUtil.b());
          localStringBuilder.append(" CPU Frequency = ");
          localStringBuilder.append(DeviceInfoUtil.b());
          localStringBuilder.append(" Memory = ");
          localStringBuilder.append(DeviceInfoUtil.a());
          QLog.d("VasFont", 2, localStringBuilder.toString());
        }
      }
      VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_font_dpc_fail", "font_dpc_fail", this.jdField_e_of_type_JavaLangString, paramString, 0.0F);
    }
    if (this.jdField_d_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    if (paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    Object localObject2 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap();
    }
    if (ETEngine.getInstance().native_diyFontIsDIYFont(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont))
    {
      paramFontInfo.jdField_a_of_type_Boolean = true;
      Object localObject3 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new ExtensionInfo();
        ((ExtensionInfo)localObject2).uin = paramString;
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (ExtensionInfo)localObject2, paramFontInfo.jdField_a_of_type_Int, paramInt))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isDIYFont fontId = ");
          ((StringBuilder)localObject2).append(paramFontInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(" uin = ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" needUpdateDiyConfig");
          QLog.d("VasFont", 2, ((StringBuilder)localObject2).toString());
        }
        if (!((ConcurrentHashMap)localObject1).containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int)))
        {
          localObject2 = new FontInfo(0, "");
          ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject2);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
      }
      else if (((ConcurrentHashMap)localObject1).containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int)))
      {
        if (paramFontInfo.jdField_a_of_type_Int != 0)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("isDIYFont fontid = ");
            paramString.append(paramFontInfo.jdField_a_of_type_Int);
            paramString.append(" is diy font handle = ");
            paramString.append(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.mDiyHandle);
            QLog.d("VasFont", 2, paramString.toString());
          }
          paramFontInfo.jdField_a_of_type_Boolean = true;
          return true;
        }
      }
      else
      {
        if ((((ExtensionInfo)localObject2).diyFontConfigMap != null) && (((ExtensionInfo)localObject2).diyFontConfigMap.containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int))))
        {
          localObject2 = (String)((ExtensionInfo)localObject2).diyFontConfigMap.get(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int));
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("isDIYFont fontId = ");
            ((StringBuilder)localObject3).append(paramFontInfo.jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(" uin = ");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" config = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
          }
          paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString((String)localObject2);
          localObject2 = new FontInfo(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString);
          ((FontInfo)localObject2).jdField_b_of_type_Int = paramFontInfo.jdField_b_of_type_Int;
          ((FontInfo)localObject2).jdField_a_of_type_Boolean = true;
          localObject3 = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, null);
          ((ETFont)localObject3).copy(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          ((FontInfo)localObject2).jdField_a_of_type_ComEtrumpMixlayoutETFont = ((ETFont)localObject3);
          ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject2);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
          return true;
        }
        localObject2 = new FontInfo(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString);
        ((FontInfo)localObject2).jdField_b_of_type_Int = paramFontInfo.jdField_b_of_type_Int;
        ((FontInfo)localObject2).jdField_a_of_type_Boolean = true;
        ((FontInfo)localObject2).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, null);
        ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject2);
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        return true;
      }
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = c();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
          this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine != null))
          {
            k = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
            i = k * k * 240 * 18 * 2;
            if (i <= 1048576) {
              break label674;
            }
            bool2 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
            bool3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
            bool1 = bool2;
            if (bool2) {}
          }
        }
      }
      catch (Throwable localThrowable)
      {
        int k;
        boolean bool2;
        boolean bool3;
        boolean bool1;
        Object localObject1;
        int j;
        Object localObject3;
        ExtensionInfo localExtensionInfo;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init font engine fail ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("VasFont", 1, ((StringBuilder)localObject2).toString());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
      }
      try
      {
        bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(18, i);
        bool2 = bool3;
        if (bool3) {
          continue;
        }
        bool2 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, 3145728);
      }
      catch (Exception localException)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init font engine fail ");
      ((StringBuilder)localObject1).append(((Exception)localObject2).getMessage());
      QLog.e("VasFont", 1, ((StringBuilder)localObject1).toString());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
      return;
      if ((bool1) && (bool2)) {
        j = 1;
      } else {
        j = 0;
      }
      if (paramBoolean)
      {
        localObject3 = "1";
        if (j != 0) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localExtensionInfo = ((FriendsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072CB", 0, 0, (String)localObject1, (String)localObject2, "", "");
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
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start init font engine fontsize=");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(",num=");
          ((StringBuilder)localObject1).append(18);
          ((StringBuilder)localObject1).append(",cache=");
          ((StringBuilder)localObject1).append(i);
          QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
        }
        ETEngine.getInstance().isEngineReady.set(true);
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C9", 0, 0, "", "", "", "");
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
      int i = 1048576;
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      FontLoadCallback localFontLoadCallback = (FontLoadCallback)localIterator.next();
      if (localFontLoadCallback != null) {
        localFontLoadCallback.onFontLoaded();
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      Handler localHandler = ETTextView.mCreateDecorationHandler;
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
      localHandler = HiBoomTextView.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
      ETTextView.mCreateDecorationHandler = null;
      HiBoomTextView.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine != null) {
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          ETFontUtil.clearMap(this.jdField_b_of_type_ComEtrumpMixlayoutETEngine);
          if (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine != null)
          {
            this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_doneEngine();
            this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineInited.set(false);
            this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(false);
          }
          this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = null;
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
  
  private void h()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          ETFontUtil.clearMap(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine);
          if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
          {
            this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_doneEngine();
            this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineInited.set(false);
            this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(false);
          }
          this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
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
  
  public int a(int paramInt)
  {
    ??? = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("font.main.android.");
    localStringBuilder.append(paramInt);
    ((IVasQuickUpdateService)???).cancelDwonloadItem(5L, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stopDownload font ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" complete remove from list");
          QLog.d("VasFont", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
      }
      return 0;
    }
  }
  
  public Drawable a(int paramInt)
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
  
  public FontInfo a()
  {
    ??? = (FontInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    if (??? != null)
    {
      if (((FontInfo)???).jdField_b_of_type_Int == 4) {
        FastColorFontHelper.a().a(((FontInfo)???).jdField_a_of_type_Int, ((FontInfo)???).jdField_a_of_type_JavaLangString);
      }
      return ???;
    }
    int i = this.jdField_a_of_type_Int;
    Object localObject6;
    if (i == 1)
    {
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        c();
        return null;
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject3 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject6).append(this.jdField_a_of_type_JavaLangString);
        ((ETEngine)localObject3).native_loadFont(((StringBuilder)localObject6).toString(), this.jdField_a_of_type_JavaLangString.hashCode(), true);
        localObject3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject6).append(this.jdField_a_of_type_JavaLangString);
        ((ETEngine)localObject3).native_loadFont(((StringBuilder)localObject6).toString(), this.jdField_a_of_type_JavaLangString.hashCode(), true);
        i = this.jdField_a_of_type_JavaLangString.hashCode();
        ??? = new StringBuilder();
        ((StringBuilder)???).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
        ??? = new FontInfo(i, ((StringBuilder)???).toString());
        i = ((FontInfo)???).jdField_a_of_type_Int;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(FontManagerConstants.HANYI_FILE_DIR);
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
        localObject3 = new ETFont(i, ((StringBuilder)localObject3).toString(), 1.0F);
        ((FontInfo)???).jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getVariantStyleComboCount((ETFont)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getTestFont: fontId=");
          ((StringBuilder)localObject3).append(((FontInfo)???).jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(" styleCount=");
          ((StringBuilder)localObject3).append(((FontInfo)???).jdField_c_of_type_Int);
          QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
        }
        ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      }
    }
    if (i == 2)
    {
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FANGZHENG_FILE_DIR);
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ??? = new FontInfo(i, ((StringBuilder)???).toString());
      ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FANGZHENG_FILE_DIR);
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ((FontInfo)???).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((StringBuilder)???).toString());
    }
    else if (i == 4)
    {
      if (!FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        b();
      }
      if (!FastColorFontHelper.a().c.get()) {
        if (FastColorFontHelper.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          FastColorFontHelper.a().a().a();
          FastColorFontHelper.a().c.set(true);
        }
        else
        {
          return null;
        }
      }
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.FZCOLOR_2_FILE_DIR);
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ??? = new FontInfo((i & 0x3FFF) + 49152, ((StringBuilder)???).toString());
      ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      FastColorFontHelper.a().a(((FontInfo)???).jdField_a_of_type_Int, ((FontInfo)???).jdField_a_of_type_JavaLangString);
      ((FontInfo)???).jdField_c_of_type_Int = FastColorFontCache.f(((FontInfo)???).jdField_a_of_type_Int);
    }
    else if (i == 99)
    {
      if (!ETEngine.getInstance().isEngineInited.get()) {
        c();
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.DIY_FONT_DIR);
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ??? = new FontInfo(1000, ((StringBuilder)???).toString());
      ((FontInfo)???).jdField_b_of_type_Int = 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FontManagerConstants.DIY_FONT_DIR);
      ((StringBuilder)???).append("config.json");
      ??? = new File(((StringBuilder)???).toString());
      if (((File)???).exists()) {
        ((FontInfo)???).jdField_b_of_type_JavaLangString = ETDIYConfig.a((File)???);
      }
      ((FontInfo)???).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(((FontInfo)???).jdField_a_of_type_Int, ((FontInfo)???).jdField_a_of_type_JavaLangString, 16.0F, ((FontInfo)???).jdField_b_of_type_Int, ((FontInfo)???).jdField_a_of_type_AndroidGraphicsTypeface);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject6 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FontManagerConstants.HANYI_FILE_DIR);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        ((ETEngine)localObject6).native_loadFont(localStringBuilder.toString(), ((FontInfo)???).jdField_a_of_type_Int, true);
        localObject6 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(FontManagerConstants.HANYI_FILE_DIR);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        ((ETEngine)localObject6).native_loadFont(localStringBuilder.toString(), ((FontInfo)???).jdField_a_of_type_Int, true);
        ((FontInfo)???).jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString(((FontInfo)???).jdField_b_of_type_JavaLangString);
      }
    }
    if (localObject2 != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, localObject2);
    }
    return localObject2;
  }
  
  public FontInfo a(int paramInt1, int paramInt2)
  {
    FontInfo localFontInfo = (FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
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
  
  public FontInfo a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (((paramInt2 == 4) || (paramInt2 == 3)) && (!FastColorFontHelper.a().c.get()))
    {
      if (!FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        b();
        return null;
      }
      if (FastColorFontHelper.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        FastColorFontHelper.a().a().a();
        FastColorFontHelper.a().c.set(true);
      }
      else
      {
        return null;
      }
    }
    Object localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramInt1);
    localObject1 = (FontInfo)((ConcurrentHashMap)localObject1).get(((StringBuilder)localObject2).toString());
    if (localObject1 == null)
    {
      a(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
      return localObject1;
    }
    if (((FontInfo)localObject1).jdField_b_of_type_Int == 4)
    {
      long l1 = System.currentTimeMillis();
      paramInt2 = FastColorFontHelper.a().a(paramInt1, ((FontInfo)localObject1).jdField_a_of_type_JavaLangString);
      ((FontInfo)localObject1).jdField_c_of_type_Int = FastColorFontCache.f(paramInt1);
      long l2 = System.currentTimeMillis();
      if (paramInt2 != 0) {
        FontReportUtils.a("action_load", paramInt1, 4, 0, l2 - l1);
      }
    }
    if (((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      ((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt1, ((FontInfo)localObject1).jdField_a_of_type_JavaLangString, 16.0F, ((FontInfo)localObject1).jdField_b_of_type_Int, ((FontInfo)localObject1).jdField_a_of_type_AndroidGraphicsTypeface);
    }
    if (((FontInfo)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localObject2 != null) && (((ConcurrentHashMap)localObject2).containsKey(Integer.valueOf(paramInt1))))
      {
        localObject1 = (FontInfo)((ConcurrentHashMap)localObject2).get(Integer.valueOf(paramInt1));
        this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.4(this, paramString, paramInt1, paramInt3));
        return localObject1;
      }
      a(paramString, (FontInfo)localObject1, paramInt3);
      return null;
    }
    return localObject1;
  }
  
  FontInfo a(ChatMessage paramChatMessage)
  {
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    String str = paramChatMessage.getExtInfoFromExtStr("diy_timestamp");
    int k;
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {
      k = Integer.parseInt(str);
    } else {
      k = 0;
    }
    int j;
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject)) && (!((String)localObject).equals("0")))
    {
      long l = Long.parseLong((String)localObject);
      j = (int)FontManagerConstants.parseFontId(l);
      i = FontManagerConstants.parseFontType(l);
    }
    else
    {
      i = 0;
      j = 0;
    }
    localObject = a(paramChatMessage);
    int m = i;
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "doGetUserFont msg do not has font id");
      }
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a((String)localObject, false);
      if (localObject != null)
      {
        j = (int)((ExtensionInfo)localObject).uVipFont;
        m = ((ExtensionInfo)localObject).vipFontType;
      }
      else
      {
        QLog.e("VasFont", 1, "doGetUserFont extensionInfo not in cache");
        return null;
      }
    }
    if (j != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doGetUserFont fontID = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" type = ");
        ((StringBuilder)localObject).append(m);
        QLog.d("VasFont", 2, ((StringBuilder)localObject).toString());
      }
      if (FontManagerConstants.mFontBlackList.contains(Integer.valueOf(j)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont font is in black list");
        }
        return null;
      }
      if (((m == 4) || (m == 3)) && (!a()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont Founder Color Font not supported");
        }
        return null;
      }
      if ((m == 1) && (!FontManagerConstants.mFontSwitchHanYi.get()))
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
      paramChatMessage = a(j, m, bool, a(paramChatMessage), k);
      if (paramChatMessage != null)
      {
        FontManagerConstants.sHasChatFont = true;
        return paramChatMessage;
      }
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("doGetUserFont no font fontid = ");
        paramChatMessage.append(j);
        paramChatMessage.append(" fontType = ");
        paramChatMessage.append(m);
        QLog.e("VasFont", 2, paramChatMessage.toString());
      }
      return null;
    }
    return new FontInfo(0, null);
  }
  
  public File a()
  {
    File localFile = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      float f1;
      try
      {
        FontInfo localFontInfo = a(paramInt1, paramInt2);
        paramInt2 = 0;
        if (localFontInfo != null)
        {
          localJSONObject2.put("status", 3);
          localJSONObject2.put("progress", 100);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131704783));
        }
        else if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1)))
        {
          f1 = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).floatValue();
          if (f1 == 1.0F)
          {
            localJSONObject2.put("status", 3);
            localJSONObject1.put("result", 0);
            localJSONObject1.put("message", HardCodeUtil.a(2131704784));
            break label413;
          }
          if (f1 == 2.0F)
          {
            localJSONObject2.put("status", 1);
            localJSONObject1.put("result", -1);
            localJSONObject1.put("message", HardCodeUtil.a(2131704781));
            break label413;
          }
          localJSONObject2.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131704779));
          break label413;
          localJSONObject2.put("canceling", paramInt2);
          localJSONObject2.put("progress", f1 * 100.0F);
        }
        else
        {
          localJSONObject2.put("status", 1);
          localJSONObject2.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131704780));
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
  
  public void a()
  {
    ETEngine localETEngine = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine;
    if (localETEngine != null)
    {
      ETFontUtil.clearMap(localETEngine);
      this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
    localETEngine = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
    if (localETEngine != null)
    {
      ETFontUtil.clearMap(localETEngine);
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.3(this, paramInt1));
      return;
    }
    VasFontIPCModule.a().a(paramInt1, -102);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackId", this.jdField_b_of_type_JavaLangString);
      localBundle.putInt("srcType", 9);
      this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(0L, -1, localBundle);
      this.jdField_b_of_type_JavaLangString = null;
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
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject1;
      if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDownloadComplete font ");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(" complete remove from list");
          QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt1));
      }
      long l;
      if (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1)))
      {
        l = ((Long)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).longValue();
        this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
      }
      else
      {
        l = 0L;
      }
      if (paramInt2 == 0)
      {
        if (l > 0L) {
          FontReportUtils.a("action_download", paramInt1, 4, 0, System.currentTimeMillis() - l);
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(1.0F));
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(2.0F));
      }
      ??? = (String)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      if ((??? != null) && (!???.equals("0")))
      {
        if (TextUtils.isDigitsOnly(???))
        {
          int i = Integer.parseInt(???);
          localObject1 = new EIPCResult();
          ((EIPCResult)localObject1).code = paramInt2;
          new Bundle().putInt("id", paramInt1);
          VasFontIPCModule.a().callbackResult(i, (EIPCResult)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("callbackId", ???);
          ((Bundle)localObject1).putInt("srcType", 2);
          ??? = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
          l = paramInt1;
          if (paramInt2 == 0) {
            paramInt1 = 0;
          } else {
            paramInt1 = -1;
          }
          ???.a(l, paramInt1, (Bundle)localObject1);
        }
      }
      if (paramInt2 == 0)
      {
        VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        e();
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
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
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
      Object localObject2 = this.jdField_b_of_type_JavaUtilMap;
      ??? = paramString;
      if (paramString == null) {
        ??? = "0";
      }
      ((Map)localObject2).put(Integer.valueOf(paramInt1), ???);
      paramString = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
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
          this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("font.main.android.");
        ((StringBuilder)???).append(paramInt1);
        paramString.downloadItem(5L, ((StringBuilder)???).toString(), "FontManager");
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(0.0F));
      return;
    }
  }
  
  public void a(TextView paramTextView)
  {
    IFontManagerService localIFontManagerService = (IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFontManagerService.class, "");
    float f1 = localIFontManagerService.getEnlargeFontText();
    if (FontSettingManager.getFontLevel() == 18.0F) {
      f1 = localIFontManagerService.getEnlargeFontTextMax();
    }
    paramTextView.setTextSize(2, Math.round(f1 / this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().density * ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())));
  }
  
  public void a(ChatMessage paramChatMessage)
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
        localObject = (IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFontManagerService.class, "");
        if ((paramChatMessage instanceof QQText))
        {
          QQText localQQText = (QQText)paramChatMessage;
          int j = paramChatMessage.length();
          int i = 0;
          paramChatMessage = (EmoticonSpan[])localQQText.getSpans(0, j, EmoticonSpan.class);
          j = paramChatMessage.length;
          while (i < j)
          {
            paramChatMessage[i].setSize(ScreenUtil.dip2px(Math.round(((IFontManagerService)localObject).getEnlargeFontEmo() * 32.0F)));
            i += 1;
          }
        }
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, FontInfo paramFontInfo, String paramString)
  {
    int i = VipUtils.a(paramChatMessage.getExtInfoFromExtStr("vip_diy_font_id"), 0);
    if ((i > 0) && (paramFontInfo != null) && (paramFontInfo.jdField_a_of_type_Int != 0) && (ETEngine.isSOLoaded.get()) && (paramFontInfo.jdField_b_of_type_Int == 1))
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(MD5Utils.encodeHexStr(paramString));
      paramChatMessage.append(File.separator);
      paramChatMessage.append(i);
      paramChatMessage = paramChatMessage.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ETDIYUtil.a(localStringBuilder.toString(), paramString, paramChatMessage);
      if ((paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.mDiyFontImageId.equals(paramChatMessage)))
      {
        paramString = ETDIYConfig.a(paramFontInfo.jdField_a_of_type_Int, paramChatMessage);
        if (!TextUtils.isEmpty(paramString))
        {
          long l = ETSubstitutionConfig.a(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont, paramString);
          paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.set_substitution(l);
          paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.mDiyFontImageId = paramChatMessage;
        }
      }
    }
  }
  
  public void a(FontLoadCallback paramFontLoadCallback)
  {
    if (paramFontLoadCallback != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramFontLoadCallback)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramFontLoadCallback);
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      int i;
      try
      {
        paramFile = new JSONObject(FileUtils.readFileContent(paramFile));
        Object localObject = paramFile.optJSONArray("defaultEffect");
        if (1 == ((JSONArray)localObject).length()) {
          this.jdField_b_of_type_Int = ((JSONObject)((JSONArray)localObject).get(0)).optInt("effectID", 1);
        }
        paramFile = paramFile.optJSONArray("magicFontConfig");
        i = 0;
        if (i < paramFile.length())
        {
          localObject = (JSONObject)paramFile.get(i);
          if (2 != ((JSONObject)localObject).optInt("platformId", 0)) {
            break label364;
          }
          this.jdField_a_of_type_Float = ((float)((JSONObject)localObject).optDouble("fontEnlargeFactor"));
          this.jdField_b_of_type_Float = ((float)((JSONObject)localObject).optDouble("maxEnlargeFactor"));
          this.jdField_c_of_type_Float = ((float)((JSONObject)localObject).optDouble("emotionEnlargeFactor"));
          if (((JSONObject)localObject).optInt("switch", 1) != 1) {
            break label359;
          }
          bool = true;
          this.jdField_c_of_type_Boolean = bool;
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("description");
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("magic");
          break label364;
        }
        if (QLog.isColorLevel())
        {
          paramFile = new StringBuilder();
          paramFile.append("fontEffectPrefer = ");
          paramFile.append(this.jdField_b_of_type_Int);
          paramFile.append(" enlargeFontText = ");
          paramFile.append(this.jdField_a_of_type_Float);
          paramFile.append(" enlargeFontTextMax = ");
          paramFile.append(this.jdField_b_of_type_Float);
          paramFile.append(" enlargeFontEmo = ");
          paramFile.append(this.jdField_c_of_type_Float);
          paramFile.append(" enlargeFontSwitch = ");
          paramFile.append(this.jdField_c_of_type_Boolean);
          paramFile.append(" enlargeFontDesc = ");
          paramFile.append(this.jdField_c_of_type_JavaLangString);
          paramFile.append(" enlargeFontImgURL = ");
          paramFile.append(this.jdField_d_of_type_JavaLangString);
          QLog.i("VasFont", 2, paramFile.toString());
        }
        this.f = true;
        VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      i += 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(paramString);
    int i;
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
      localExtensionInfo.fontEffect = -1;
      i = 1;
      paramString = localExtensionInfo;
    }
    else
    {
      i = 0;
      paramString = localExtensionInfo;
    }
    if (paramString.fontEffect != paramInt)
    {
      paramString.fontEffect = paramInt;
      paramString.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      d();
      i = 1;
    }
    if (i != 0) {
      localFriendsManager.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("font_open_switch", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserOpenFontSwitch_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.putInt("font_test_type", paramInt);
    localEditor.putString("font_test_file", paramString);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return FontManagerConstants.mFontSwitchFZ.get();
  }
  
  public boolean a(int paramInt)
  {
    ETEngine localETEngine = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
    if ((localETEngine != null) && (localETEngine.isEngineReady.get())) {
      return this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(paramInt);
    }
    return false;
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
      if ((paramViewHolder.d instanceof ETTextView))
      {
        if (((ETTextView)paramViewHolder.d).mFont == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has no font yet");
          }
          return true;
        }
        FontInfo localFontInfo = b(paramChatMessage);
        if ((localFontInfo != null) && ((paramViewHolder.d instanceof ETTextView)))
        {
          ETTextView localETTextView = (ETTextView)paramViewHolder.d;
          if (localETTextView.mFont.mFontId != localFontInfo.jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has font change");
            }
            return true;
          }
          if ((localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.mDiyHandle != localETTextView.mFont.mDiyHandle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has diyFont change");
            }
            return true;
          }
        }
        if (FontManagerConstants.parseMagicFont(paramChatMessage) != ((ETTextView)paramViewHolder.d).mMagicFont)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change");
          }
          return true;
        }
        if (this.f)
        {
          this.f = false;
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh needRefershAIOForFontEffect.");
          }
          return true;
        }
        paramViewHolder = (ETTextView)paramViewHolder.d;
        if ((paramViewHolder.getETLayout() != null) && (paramViewHolder.mMagicFont != paramViewHolder.getETLayout().jdField_b_of_type_Boolean))
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
  
  public boolean a(MessageRecord paramMessageRecord)
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
      int i = Integer.valueOf((String)localObject1).intValue();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enableEnlargeFontEffect --> font effect id(msg int): ");
        ((StringBuilder)localObject1).append(i);
        QLog.i("tag.vasFont.enlarge", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = true;
          paramMessageRecord = VasUpdateUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5L, "magicFontConfig.json", FontManagerConstants.FONT_EFFECT_CFG, true, null);
          if (paramMessageRecord != null) {
            a(paramMessageRecord);
          }
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, parse Json.");
          }
          return false;
        }
        if (!this.jdField_c_of_type_Boolean)
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
        Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject3 != null)
        {
          localObject2 = ((FriendsManager)localObject3).a((String)localObject1, false);
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
            if ((((ExtensionInfo)localObject2).fontEffectLastUpdateTime < paramMessageRecord.time) && (i != ((ExtensionInfo)localObject2).fontEffect))
            {
              if (QLog.isColorLevel()) {
                QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> fontEffectId not equal with local.");
              }
              AvatarPendantUtil.a((String)localObject1);
              AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          else
          {
            ThreadManager.post(new FontManager.8(this, (FriendsManager)localObject3, (String)localObject1), 5, null, true);
          }
        }
        if (2000 == i)
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
  
  public FontInfo b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = c();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasFont", 2, "getUserFont fontFeatureSupported = false");
      }
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return a();
    }
    String str1 = a(paramChatMessage);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getUserFont uin is empty");
      }
      return new FontInfo(0, null);
    }
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = ((FriendsManager)localObject2).a(str1, false);
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
      int i = FontManagerConstants.parseFontType(l2);
      if ((i == 2) || (i == 1) || (i == 4))
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
            i = 1;
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
          i = 0;
          label460:
          if (i != 0) {
            AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if (FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.1(this));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownloadFont start");
    }
    Object localObject1 = a(paramInt1, paramInt2);
    if (localObject1 != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramInt1));
      Object localObject2 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        String[] arrayOfString = ((String)localObject3).split("|");
        if ((arrayOfString.length >= 2) && (String.valueOf(paramInt1).equals(arrayOfString[1]))) {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject3);
        }
      }
      localObject1 = new File(((FontInfo)localObject1).jdField_a_of_type_JavaLangString);
      if (((File)localObject1).exists())
      {
        localObject1 = new File(((File)localObject1).getParent());
        localObject2 = ((File)localObject1).listFiles();
        if (localObject2 != null)
        {
          int i = 0;
          while (i < localObject2.length)
          {
            bool = localObject2[i].delete();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("reDownloadFont delete ");
              ((StringBuilder)localObject3).append(localObject2[i].getName());
              ((StringBuilder)localObject3).append(" ret = ");
              ((StringBuilder)localObject3).append(bool);
              QLog.d("VasFont", 2, ((StringBuilder)localObject3).toString());
            }
            i += 1;
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
  
  public void b(ChatMessage paramChatMessage)
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
      if (0L == this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_last_send_report", 0L);
      }
      if (0L == this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_reset_time", 0L);
      }
      if ((this.jdField_a_of_type_Long < FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > FontManagerConstants.todayStartTime) && (paramChatMessage.time * 1000L > this.jdField_b_of_type_Long))
      {
        int j = 0;
        localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
        int i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          i = j;
          if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
            i = Integer.valueOf((String)localObject).intValue();
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (FontManagerConstants.parseMagicFont(paramChatMessage)) {
            j = 1;
          }
        }
        if (j != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reportFontEffect real report.");
          }
          localObject = paramChatMessage.selfuin;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(j);
          localStringBuilder.append("");
          VasWebviewUtil.a((String)localObject, "FontEffect", "SendMsg", "", 1, 0, 0, "", localStringBuilder.toString(), "");
          this.jdField_a_of_type_Long = (paramChatMessage.time * 1000L);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          ((SharedPreferences.Editor)localObject).putLong("magic_font_last_send_report", paramChatMessage.time * 1000L);
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
  }
  
  public void b(FontLoadCallback paramFontLoadCallback)
  {
    if (paramFontLoadCallback == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramFontLoadCallback);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FontManager.10(this, paramString, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.commit();
  }
  
  public boolean b()
  {
    int i = jdField_c_of_type_Int;
    boolean bool = false;
    if (i == -1)
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
            jdField_c_of_type_Int = 0;
          } else {
            jdField_c_of_type_Int = 1;
          }
        }
      }
    }
    i = jdField_c_of_type_Int;
    if ((i == 1) || (i == -1)) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    if ((ETEngine.getInstance().isEngineInited.compareAndSet(false, true)) && (FontSoLoader.c())) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FontManager.2(this), 2000L);
    }
  }
  
  public boolean c()
  {
    int i = this.jdField_d_of_type_Int;
    boolean bool = false;
    if (i != -1)
    {
      if (i == 1) {
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
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.jdField_a_of_type_Boolean = a(str);
    }
    if (str.equals("0")) {
      this.jdField_d_of_type_Int = 0;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "resetLastSendReportTime.");
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putLong("magic_font_last_send_report", this.jdField_a_of_type_Long);
    localEditor.putLong("magic_font_reset_time", this.jdField_b_of_type_Long);
    localEditor.apply();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return true;
  }
  
  public void onDestroy()
  {
    FontManagerConstants.mMineLastReportTime = 0L;
    FontManagerConstants.mOthersLastReportTime = 0L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    f();
    h();
    g();
    HiBoomFont.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    HiBoomFont.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "onDestroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */