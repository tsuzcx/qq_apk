package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import py;
import pz;
import qa;
import qb;
import qc;
import qd;
import qe;
import qf;
import qg;

public class FontManager
  implements Manager
{
  public static float a;
  public static long a;
  public static final String a;
  public static ConcurrentHashMap a;
  public static float b;
  public static int b;
  public static long b;
  public static final String b;
  public static float c;
  public static long c;
  public static volatile boolean c;
  public static float d;
  private static int jdField_d_of_type_Int;
  public static AtomicBoolean d;
  public static float e;
  private static int jdField_e_of_type_Int;
  public static boolean e;
  public static float f;
  public static final String f;
  public static boolean f;
  public static final String g;
  public static final String j;
  static boolean j;
  public static final String k;
  public static final String l;
  public static final String m;
  public int a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public ETEngine a;
  public QQAppInterface a;
  public IPCDownloadListener a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  List jdField_a_of_type_JavaUtilList = new LinkedList();
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public AtomicBoolean a;
  public boolean a;
  Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean b;
  public volatile boolean b;
  public int c;
  public String c;
  private Map jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean c;
  long jdField_d_of_type_Long = 0L;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  long jdField_e_of_type_Long = 0L;
  public String e;
  AtomicBoolean jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int f;
  public float g;
  public volatile boolean g;
  public float h;
  public String h;
  public boolean h;
  public float i;
  public String i;
  boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aK + ".font_info";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "fz2.0/";
    jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_e_of_type_Boolean = true;
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_Float = 0.3F;
    jdField_b_of_type_Float = 0.3F;
    jdField_c_of_type_Float = 1.5F;
    jdField_d_of_type_Float = 0.7F;
    jdField_e_of_type_Float = 1.3F;
    jdField_f_of_type_Float = 0.7F;
    jdField_b_of_type_Int = 4;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
    jdField_f_of_type_JavaLangString = AppConstants.aK + ".font_effect";
    jdField_g_of_type_JavaLangString = jdField_f_of_type_JavaLangString + File.separator + "magicFontConfig.json";
    jdField_j_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/FontTest" + "/hanyifont/";
    k = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengfont/";
    l = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengcolorfont2/";
    m = Environment.getExternalStorageDirectory() + "/FontTest" + "/diyfont/";
    jdField_j_of_type_Boolean = true;
  }
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_g_of_type_Float = 1.5F;
    this.jdField_h_of_type_Float = 1.3F;
    this.jdField_i_of_type_Float = 1.5F;
    this.jdField_h_of_type_JavaLangString = "超大字体";
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.jdField_d_of_type_Boolean) {
      paramQQAppInterface.append(DeviceInfoUtil.j()).append("; CPU number: ").append(DeviceInfoUtil.b()).append("; CPU frequency: ").append(DeviceInfoUtil.a()).append("; RAM: ").append(DeviceInfoUtil.e());
    }
    this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
    this.jdField_a_of_type_Boolean = c();
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 8);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong >> 24) & 0x1;
  }
  
  public static int a(ExtensionInfo paramExtensionInfo)
  {
    int n = 0;
    if (paramExtensionInfo != null) {
      n = (int)(((paramExtensionInfo.uVipFont & 0xFF) << 8) + (paramExtensionInfo.uVipFont >> 8 & 0xFF)) + (paramExtensionInfo.vipFontType << 16) + (paramExtensionInfo.magicFont << 24);
    }
    return n;
  }
  
  public static long a(long paramLong)
  {
    return ((paramLong & 0xFF) << 8) + (paramLong >> 8 & 0xFF);
  }
  
  private FontInfo a()
  {
    ??? = (FontInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_c_of_type_JavaLangString);
    Object localObject3;
    if (??? != null)
    {
      localObject3 = ???;
      return localObject3;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        b();
        return null;
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(jdField_j_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString.hashCode(), true);
        ??? = new FontInfo(this.jdField_c_of_type_JavaLangString.hashCode(), jdField_j_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString);
        ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        localObject3 = ???;
        if (??? == null) {
          break;
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_c_of_type_JavaLangString, ???);
        return ???;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        ??? = new FontInfo(this.jdField_c_of_type_JavaLangString.hashCode(), k + this.jdField_c_of_type_JavaLangString);
        ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        ((FontInfo)???).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(k + this.jdField_c_of_type_JavaLangString);
        continue;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        if (!FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          a();
        }
        if (!FastColorFontHelper.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (FastColorFontHelper.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            FastColorFontHelper.a().a().a();
            FastColorFontHelper.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          }
        }
        else
        {
          ??? = new FontInfo(this.jdField_c_of_type_JavaLangString.hashCode(), l + this.jdField_c_of_type_JavaLangString);
          ((FontInfo)???).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          FastColorFontHelper.a().a(((FontInfo)???).jdField_a_of_type_Int, ((FontInfo)???).jdField_a_of_type_JavaLangString);
          continue;
        }
        return null;
      }
      if (this.jdField_a_of_type_Int != 99) {
        continue;
      }
      if (!ETEngine.getInstance().isEngineInited.get()) {
        b();
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      ??? = new FontInfo(1000, m + this.jdField_c_of_type_JavaLangString);
      ((FontInfo)???).jdField_b_of_type_Int = 1;
      ??? = new File(m + "config.json");
      if (((File)???).exists()) {
        ((FontInfo)???).jdField_b_of_type_JavaLangString = ETDIYConfig.a((File)???);
      }
      ((FontInfo)???).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(((FontInfo)???).jdField_a_of_type_Int, ((FontInfo)???).jdField_a_of_type_JavaLangString, 16.0F, ((FontInfo)???).jdField_b_of_type_Int, ((FontInfo)???).jdField_a_of_type_AndroidGraphicsTypeface);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(jdField_j_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString, ((FontInfo)???).jdField_a_of_type_Int, true);
        ((FontInfo)???).jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString(((FontInfo)???).jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private FontInfo a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (((paramInt2 == 4) || (paramInt2 == 3)) && (!FastColorFontHelper.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      if (!FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        a();
        localObject = null;
      }
    }
    FontInfo localFontInfo;
    do
    {
      return localObject;
      if (FastColorFontHelper.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        FastColorFontHelper.a().a().a();
        FastColorFontHelper.a().jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localFontInfo = (FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (localFontInfo == null)
        {
          a(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
          return localFontInfo;
        }
      }
      else
      {
        return null;
      }
      if (localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt1, localFontInfo.jdField_a_of_type_JavaLangString, 16.0F, localFontInfo.jdField_b_of_type_Int, localFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      localObject = localFontInfo;
    } while (!localFontInfo.jdField_a_of_type_Boolean);
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (FontInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt1));
      this.jdField_a_of_type_AndroidOsHandler.post(new qc(this, paramString, paramInt1, paramInt3));
      return localObject;
    }
    a(paramString, localFontInfo, paramInt3);
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3) {
      return jdField_b_of_type_JavaLangString + paramInt1 + File.separator + paramInt1 + ".ttf";
    }
    return jdField_a_of_type_JavaLangString + File.separator + paramInt1 + File.separator + paramInt1 + ".ttf";
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    switch (paramMessageRecord.istroop)
    {
    default: 
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1025: 
    case 1029: 
    case 10002: 
    case 10004: 
    case 1: 
      do
      {
        return null;
        if (paramMessageRecord.isSend()) {
          return paramMessageRecord.selfuin;
        }
        return paramMessageRecord.frienduin;
      } while (AnonymousChatHelper.a(paramMessageRecord));
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.senderuin;
    }
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.senderuin;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qd(this, paramInt1, paramInt2, paramString, paramInt3, paramBoolean));
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.a != null)
    {
      int i1 = paramBaseChatPie.a.getFirstVisiblePosition();
      int i2 = paramBaseChatPie.a.getLastVisiblePosition();
      int i3 = paramBaseChatPie.a.getHeaderViewsCount();
      int n = i1 - 1;
      if (n <= i2)
      {
        Object localObject = paramBaseChatPie.a.getChildAt(i3 + n - i1);
        if ((localObject != null) && ((AIOUtils.a((View)localObject) instanceof TextItemBuilder.Holder)))
        {
          localObject = (TextItemBuilder.Holder)AIOUtils.a((View)localObject);
          if ((((TextItemBuilder.Holder)localObject).e instanceof ETTextView))
          {
            localObject = (ETTextView)((TextItemBuilder.Holder)localObject).e;
            if (!((ETTextView)localObject).c()) {
              break label124;
            }
            ((ETTextView)localObject).a(false);
          }
        }
        for (;;)
        {
          n += 1;
          break;
          label124:
          if (((ETTextView)localObject).d()) {
            ((ETTextView)localObject).b(false);
          }
        }
      }
    }
  }
  
  private void a(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qg(this, paramString, paramFontInfo, paramInt));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return new File(a(paramInt1, paramInt2)).exists();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
    }
    if (localExtensionInfo.diyFontTimestampMap == null) {
      localExtensionInfo.diyFontTimestampMap = new ConcurrentHashMap();
    }
    if ((localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) == null) || (((Integer)localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1))).intValue() < paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "checkUpdateDIYConfig uin = " + paramString + " fontId = " + paramInt1 + " oldTime = " + localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) + " newTime = " + paramInt2);
      }
      paramQQAppInterface = (SVIPHandler)paramQQAppInterface.a(13);
      paramExtensionInfo = new HashMap();
      paramExtensionInfo.put(paramString, Integer.valueOf(paramInt1));
      paramQQAppInterface.a(paramExtensionInfo);
      localExtensionInfo.diyFontTimestampMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      localFriendsManager.a(localExtensionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(a(paramChatMessage)));
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    } while ((TextUtils.isEmpty(paramChatMessage)) || (!TextUtils.isDigitsOnly(paramChatMessage)) || ((Long.parseLong(paramChatMessage) >> 24 & 1L) != 1L));
    return true;
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_f_of_type_Int == -1)
    {
      if (((DeviceInfoUtil.b() < 2) || (DeviceInfoUtil.a() <= 1000L)) && ((DeviceInfoUtil.b() < 4) || (DeviceInfoUtil.e() <= 838860800L))) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
      }
      this.jdField_f_of_type_Int = 1;
    }
    for (;;)
    {
      VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_font_dpc_fail", "font_dpc_fail", this.jdField_d_of_type_JavaLangString, paramString, 0.0F);
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      return true;
      label92:
      this.jdField_f_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return false. CPU number = " + DeviceInfoUtil.b() + " CPU Frequency = " + DeviceInfoUtil.a() + " Memory = " + DeviceInfoUtil.e());
      }
    }
    return false;
  }
  
  private boolean a(String paramString, FontInfo paramFontInfo, int paramInt)
  {
    if (paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localConcurrentHashMap == null) {
      localConcurrentHashMap = new ConcurrentHashMap();
    }
    for (;;)
    {
      if (ETEngine.getInstance().native_diyFontIsDIYFont(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont))
      {
        paramFontInfo.jdField_a_of_type_Boolean = true;
        Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = paramString;
        }
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (ExtensionInfo)localObject1, paramFontInfo.jdField_a_of_type_Int, paramInt))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isDIYFont fontId = " + paramFontInfo.jdField_a_of_type_Int + " uin = " + paramString + " needUpdateDiyConfig");
          }
          if (!localConcurrentHashMap.containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int)))
          {
            localObject1 = new FontInfo(0, "");
            localConcurrentHashMap.put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject1);
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
          }
          return false;
        }
        if (localConcurrentHashMap.containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int)))
        {
          if (paramFontInfo.jdField_a_of_type_Int != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontid = " + paramFontInfo.jdField_a_of_type_Int + " is diy font handle = " + paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle);
            }
            paramFontInfo.jdField_a_of_type_Boolean = true;
            return true;
          }
        }
        else
        {
          if ((((ExtensionInfo)localObject1).diyFontConfigMap != null) && (((ExtensionInfo)localObject1).diyFontConfigMap.containsKey(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int))))
          {
            localObject1 = (String)((ExtensionInfo)localObject1).diyFontConfigMap.get(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int));
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontId = " + paramFontInfo.jdField_a_of_type_Int + " uin = " + paramString + " config = " + (String)localObject1);
            }
            paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.parseDIYJsonString((String)localObject1);
            localObject1 = new FontInfo(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString);
            ((FontInfo)localObject1).jdField_b_of_type_Int = paramFontInfo.jdField_b_of_type_Int;
            ((FontInfo)localObject1).jdField_a_of_type_Boolean = true;
            localObject2 = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, null);
            ((ETFont)localObject2).copy(paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            ((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont = ((ETFont)localObject2);
            localConcurrentHashMap.put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject1);
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
            return true;
          }
          localObject1 = new FontInfo(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString);
          ((FontInfo)localObject1).jdField_b_of_type_Int = paramFontInfo.jdField_b_of_type_Int;
          ((FontInfo)localObject1).jdField_a_of_type_Boolean = true;
          ((FontInfo)localObject1).jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, 16.0F, paramFontInfo.jdField_b_of_type_Int, null);
          localConcurrentHashMap.put(Integer.valueOf(paramFontInfo.jdField_a_of_type_Int), localObject1);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap);
          return true;
        }
      }
      return false;
    }
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 16 & 0xF);
  }
  
  public int a(int paramInt)
  {
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).a(5L, "font.main.android." + paramInt);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "stopDownload font " + paramInt + " complete remove from list");
        }
        this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
      }
      return 0;
    }
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        localObject1 = BitmapFactory.decodeStream(new FileInputStream((File)localObject1));
        if (localObject1 == null) {
          continue;
        }
        return new BitmapDrawable((Bitmap)localObject1);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, localFileNotFoundException.toString());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public FontInfo a(int paramInt1, int paramInt2)
  {
    FontInfo localFontInfo = (FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    Object localObject = localFontInfo;
    if (localFontInfo == null)
    {
      localObject = new File(a(paramInt1, paramInt2));
      boolean bool = ((File)localObject).exists();
      if (bool) {
        localFontInfo = new FontInfo(paramInt1, ((File)localObject).getAbsolutePath());
      }
      localObject = localFontInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("VasFont", 2, "findFontInfo|find from local|fontExists=" + bool);
        localObject = localFontInfo;
      }
    }
    return localObject;
  }
  
  public FontInfo a(ChatMessage paramChatMessage)
  {
    boolean bool = false;
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    String str = paramChatMessage.getExtInfoFromExtStr("diy_timestamp");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {}
    for (int i2 = Integer.parseInt(str);; i2 = 0)
    {
      int n;
      int i1;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject)) && (!((String)localObject).equals("0")))
      {
        long l1 = Long.parseLong((String)localObject);
        n = (int)a(l1);
        i1 = b(l1);
      }
      for (;;)
      {
        localObject = a(paramChatMessage);
        if (i1 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "doGetUserFont msg do not has font id");
          }
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a((String)localObject, false);
          if (localObject != null)
          {
            n = (int)((ExtensionInfo)localObject).uVipFont;
            i1 = ((ExtensionInfo)localObject).vipFontType;
          }
        }
        for (;;)
        {
          if (n != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "doGetUserFont fontID = " + n + " type = " + i1);
            }
            if (((i1 == 4) || (i1 == 3)) && (!a()))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont Founder Color Font not supported");
              }
              return null;
              QLog.e("VasFont", 1, "doGetUserFont extensionInfo not in cache");
              return null;
            }
            if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
              bool = true;
            }
            paramChatMessage = a(n, i1, bool, a(paramChatMessage), i2);
            if (paramChatMessage != null)
            {
              if (paramChatMessage.jdField_b_of_type_Int == 4) {
                FastColorFontHelper.a().a(n, paramChatMessage.jdField_a_of_type_JavaLangString);
              }
              jdField_c_of_type_Boolean = true;
              return paramChatMessage;
            }
            if (QLog.isColorLevel()) {
              QLog.e("VasFont", 2, "doGetUserFont no font fontid = " + n + " fontType = " + i1);
            }
            return null;
          }
          return new FontInfo(0, null);
        }
        i1 = 0;
        n = 0;
      }
    }
  }
  
  public File a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt1, paramInt2) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "本地已存在");
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt1);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "queryInfo fontId=" + paramInt1 + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        if (!this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {
          break label332;
        }
        f1 = ((Float)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).floatValue();
        if (f1 != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载完毕");
        break label377;
        localJSONObject2.put("canceling", paramInt2);
        localJSONObject2.put("progress", 100.0F * f1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1;
        localException.printStackTrace();
        continue;
        if (f1 == 2.0F)
        {
          localException.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", "下载失败");
        }
        else
        {
          localException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "下载中");
          break label377;
          label332:
          localException.put("status", 1);
          localException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "未知状态");
          continue;
        }
        label377:
        if (f1 == 3.0F) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
      }
    }
  }
  
  void a()
  {
    if (FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.post(new py(this));
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.jdField_a_of_type_AndroidOsHandler.post(new qb(this, paramInt1));
    }
    while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackId", this.jdField_e_of_type_JavaLangString);
    localBundle.putInt("srcType", 9);
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(0L, -1, localBundle);
    this.jdField_e_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt1, int paramInt2, String arg3)
  {
    label220:
    do
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "onDownloadComplete font " + paramInt1 + " complete remove from list");
            }
            this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt1));
          }
          if (paramInt2 == 0)
          {
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(1.0F));
            Object localObject1 = (String)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
            if ((localObject1 == null) || (((String)localObject1).equals("0")) || (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null)) {
              break;
            }
            ??? = new Bundle();
            ???.putString("callbackId", (String)localObject1);
            ???.putInt("srcType", 2);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
            long l1 = paramInt1;
            if (paramInt2 != 0) {
              break label220;
            }
            paramInt1 = 0;
            ((IPCDownloadListener)localObject1).a(l1, paramInt1, ???);
            return;
          }
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(2.0F));
        continue;
        paramInt1 = -1;
      }
    } while (paramInt2 != 0);
    VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " is downloading");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " start download");
        }
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
        Map localMap = this.jdField_c_of_type_JavaUtilMap;
        ??? = paramString;
        if (paramString == null) {
          ??? = "0";
        }
        localMap.put(Integer.valueOf(paramInt1), ???);
        paramString = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
        if (paramInt2 == 3)
        {
          paramString.a(5L, "font.fzfont.android." + paramInt1, "FontManager");
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Float.valueOf(0.0F));
          return;
        }
      }
      paramString.a(5L, "font.main.android." + paramInt1, "FontManager");
    }
  }
  
  public void a(TextView paramTextView)
  {
    FontManager localFontManager = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
    float f1 = localFontManager.jdField_g_of_type_Float;
    if (FontSettingManager.a() == 18.0F) {
      f1 = localFontManager.jdField_h_of_type_Float;
    }
    for (;;)
    {
      paramTextView.setTextSize(2, Math.round(f1 / this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().density * ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())));
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      Object localObject = (MessageForText)paramChatMessage;
      paramChatMessage = null;
      if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        if (TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          break label128;
        }
      }
      label128:
      for (paramChatMessage = ((MessageForText)localObject).sb2; paramChatMessage != null; paramChatMessage = ((MessageForText)localObject).sb)
      {
        localObject = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
        if (!(paramChatMessage instanceof QQText)) {
          break;
        }
        paramChatMessage = (QQText.EmoticonSpan[])((QQText)paramChatMessage).getSpans(0, paramChatMessage.length(), QQText.EmoticonSpan.class);
        int i1 = paramChatMessage.length;
        int n = 0;
        while (n < i1)
        {
          paramChatMessage[n].a(ScreenUtil.a(Math.round(((FontManager)localObject).jdField_i_of_type_Float * 32.0F)));
          n += 1;
        }
      }
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
      int n;
      try
      {
        paramFile = new JSONObject(FileUtils.a(paramFile));
        Object localObject = paramFile.optJSONArray("defaultEffect");
        if (1 == ((JSONArray)localObject).length()) {
          this.jdField_c_of_type_Int = ((JSONObject)((JSONArray)localObject).get(0)).optInt("effectID", 1);
        }
        paramFile = paramFile.optJSONArray("magicFontConfig");
        n = 0;
        if (n < paramFile.length())
        {
          localObject = (JSONObject)paramFile.get(n);
          if (2 == ((JSONObject)localObject).optInt("platformId", 0))
          {
            this.jdField_g_of_type_Float = ((float)((JSONObject)localObject).optDouble("fontEnlargeFactor"));
            this.jdField_h_of_type_Float = ((float)((JSONObject)localObject).optDouble("maxEnlargeFactor"));
            this.jdField_i_of_type_Float = ((float)((JSONObject)localObject).optDouble("emotionEnlargeFactor"));
            if (((JSONObject)localObject).optInt("switch", 1) != 1) {
              break label335;
            }
            bool = true;
            this.jdField_h_of_type_Boolean = bool;
            this.jdField_h_of_type_JavaLangString = ((JSONObject)localObject).optString("description");
            this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject).optString("magic");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("VasFont", 2, "fontEffectPrefer = " + this.jdField_c_of_type_Int + " enlargeFontText = " + this.jdField_g_of_type_Float + " enlargeFontTextMax = " + this.jdField_h_of_type_Float + " enlargeFontEmo = " + this.jdField_i_of_type_Float + " enlargeFontSwitch = " + this.jdField_h_of_type_Boolean + " enlargeFontDesc = " + this.jdField_h_of_type_JavaLangString + " enlargeFontImgURL = " + this.jdField_i_of_type_JavaLangString);
          }
          this.jdField_i_of_type_Boolean = true;
          VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      }
      catch (Exception paramFile)
      {
        QLog.e("VasFont", 1, "parse fontEffect json config fail", paramFile);
        return;
      }
      n += 1;
      continue;
      label335:
      boolean bool = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i1 = 1;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo2 = localFriendsManager.a(paramString);
    int n = 0;
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
      localExtensionInfo1.fontEffect = -1;
      n = 1;
    }
    if (localExtensionInfo1.fontEffect != paramInt)
    {
      localExtensionInfo1.fontEffect = paramInt;
      localExtensionInfo1.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      c();
    }
    for (paramInt = i1;; paramInt = n)
    {
      if (paramInt != 0) {
        localFriendsManager.a(localExtensionInfo1);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = c();
        if (!this.jdField_a_of_type_Boolean) {
          break label507;
        }
        localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
          break label496;
        }
        int i1 = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        n = i1 * i1 * 240 * 20 * 2;
        if (n <= 1048576) {
          break label508;
        }
        try
        {
          boolean bool = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(20, n);
          if (paramBoolean)
          {
            if (!bool) {
              break label488;
            }
            String str1 = "1";
            localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            if ((localObject == null) || (0L == ((ExtensionInfo)localObject).uVipFont) || (((ExtensionInfo)localObject).vipFontType != 1)) {
              break label515;
            }
            localObject = "0";
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072CB", 0, 0, str1, (String)localObject, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "VipFontReport: AIO engine status, status=" + str1 + ", hgType=" + (String)localObject);
            }
          }
          if (!bool) {
            break label507;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "start init font engine fontsize=" + i1 + ",num=" + 20 + ",cache=" + n);
          }
          ETEngine.getInstance().isEngineReady.set(true);
          if (paramBoolean) {
            break label507;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C9", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break label507;
          }
          QLog.d("VasFont", 2, "VipFontReport: AioRefreshed");
          return;
        }
        catch (Exception localException)
        {
          QLog.e("VasFont", 1, "init font engine fail " + localException.getMessage());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
          return;
        }
        String str2 = "0";
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VasFont", 1, "init font engine fail " + localThrowable.getMessage());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
        return;
      }
      label488:
      continue;
      label496:
      throw new Exception("create font engine Instance fail");
      label507:
      return;
      label508:
      int n = 1048576;
      continue;
      label515:
      Object localObject = "1";
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (jdField_d_of_type_Int == -1)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 4)
        {
          QLog.d("VasFont", 1, "FounderFont DPC value = " + localObject[3]);
          if (!"0".equals(localObject[3])) {
            break label106;
          }
        }
      }
    }
    label106:
    for (jdField_d_of_type_Int = 0;; jdField_d_of_type_Int = 1)
    {
      if ((jdField_d_of_type_Int == 1) || (jdField_d_of_type_Int == -1)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (!ETEngine.getInstance().isEngineReady.get()) {
      return false;
    }
    return this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(paramInt);
  }
  
  public boolean a(FontInfo paramFontInfo, String paramString, int paramInt)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString);
        try
        {
          ??? = new File(paramFontInfo.jdField_a_of_type_JavaLangString);
          if (!((File)???).exists())
          {
            a(paramFontInfo.jdField_a_of_type_Int, null, 1);
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail file not exist font id=" + paramFontInfo.jdField_a_of_type_Int);
            }
            bool1 = false;
            return bool1;
          }
          if (FileUtils.a((File)???) == null)
          {
            b(paramFontInfo.jdField_a_of_type_Int, 1);
            VasWebviewUtil.reportVasStatus("Font", "FontMd5Check", "0", 0, 0, paramFontInfo.jdField_a_of_type_Int, 1, "", "");
            bool1 = false;
            continue;
          }
          QLog.d("VasFont", 1, "ET load font start id = " + paramFontInfo.jdField_a_of_type_Int + " time = " + System.currentTimeMillis());
        }
        catch (Throwable paramFontInfo)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VasFont", 2, "load font fail", paramFontInfo);
          continue;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(paramFontInfo.jdField_a_of_type_JavaLangString, paramFontInfo.jdField_a_of_type_Int, bool1);
          QLog.d("VasFont", 1, "ET load font end id = " + paramFontInfo.jdField_a_of_type_Int + " time = " + System.currentTimeMillis());
          if (!bool1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail font id=" + paramFontInfo.jdField_a_of_type_Int);
            }
            bool1 = false;
          }
        }
        if (!QLog.isColorLevel()) {
          break label351;
        }
      }
      finally {}
      QLog.d("VasFont", 2, "setActiveFonts refreshAIO");
      label351:
      boolean bool1 = bool2;
      if (a(paramString, paramFontInfo, paramInt))
      {
        VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bool1 = bool2;
      }
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    if ((paramViewHolder instanceof TextItemBuilder.Holder))
    {
      paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
      if ((paramViewHolder.e instanceof ETTextView))
      {
        if (((ETTextView)paramViewHolder.e).jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has no font yet");
          }
          return true;
        }
        FontInfo localFontInfo = b(paramChatMessage);
        if ((localFontInfo != null) && ((paramViewHolder.e instanceof ETTextView)))
        {
          ETTextView localETTextView = (ETTextView)paramViewHolder.e;
          if (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != localFontInfo.jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has font change");
            }
            return true;
          }
          if ((localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (localFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle != localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has diyFont change");
            }
            return true;
          }
        }
        if (a(paramChatMessage) != ((ETTextView)paramViewHolder.e).jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change");
          }
          return true;
        }
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh needRefershAIOForFontEffect.");
          }
          return true;
        }
        paramViewHolder = (ETTextView)paramViewHolder.e;
        if ((paramViewHolder.a() != null) && (paramViewHolder.jdField_a_of_type_Boolean != paramViewHolder.a().jdField_b_of_type_Boolean))
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
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
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
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(str1, false);
    String str2 = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getUserFont: message font id = " + str2 + " uin = " + str1);
    }
    long l1 = paramChatMessage.time;
    long l2;
    int n;
    if ((!TextUtils.isEmpty(str2)) && (TextUtils.isDigitsOnly(str2)) && (!str2.equals("0")))
    {
      l2 = Long.parseLong(str2);
      n = b(l2);
      if ((n == 2) || (n == 1) || (n == 4)) {
        if ((localExtensionInfo != null) && (l1 > localExtensionInfo.lastUpdateTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message time = " + l1 + " lastUpdateTime = " + localExtensionInfo.lastUpdateTime);
          }
          if (a(l2) == localExtensionInfo.uVipFont) {
            break label370;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message font not equals local uin = " + str1);
          }
          AvatarPendantUtil.a(str1);
          n = 1;
        }
      }
    }
    for (;;)
    {
      if (n != 0) {
        AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return a(paramChatMessage);
      label370:
      if (a(l2) != localExtensionInfo.magicFont)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getUserFont: message magicfont not equals local uin = " + str1);
        }
        AvatarPendantUtil.a(str1);
        n = 1;
        continue;
        if (localExtensionInfo != null) {
          return a(paramChatMessage);
        }
        ThreadManager.post(new qe(this, localFriendsManager, str1, paramChatMessage), 8, null, true);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "getUserFont extensionInfo no cache.");
        }
        return null;
      }
      else
      {
        n = 0;
      }
    }
  }
  
  public void b()
  {
    if ((ETEngine.getInstance().isEngineInited.compareAndSet(false, true)) && (FontSoLoader.c())) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new qa(this), 2000L);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownloadFont start");
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
      localObject = new File(((FontInfo)localObject).jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        break label242;
      }
      localObject = new File(((File)localObject).getParent());
      File[] arrayOfFile = ((File)localObject).listFiles();
      if (arrayOfFile != null)
      {
        int n = 0;
        while (n < arrayOfFile.length)
        {
          bool = arrayOfFile[n].delete();
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reDownloadFont delete " + arrayOfFile[n].getName() + " ret = " + bool);
          }
          n += 1;
        }
      }
      boolean bool = ((File)localObject).delete();
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont delete " + ((File)localObject).getName() + " ret = " + bool);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownload startDownload");
      }
      a(paramInt1, null, paramInt2);
      return;
      label242:
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont fontFile not exist");
      }
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    Object localObject;
    if (NetConnInfoCenter.getServerTimeMillis() - jdField_c_of_type_Long > 86400000L)
    {
      jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis() - NetConnInfoCenter.getServerTimeMillis() % 86400000L;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QLog.d("VasFont", 2, "reportFontEffect: time = " + ((SimpleDateFormat)localObject).format(new Date(jdField_c_of_type_Long)));
      }
    }
    if (paramChatMessage.isSend())
    {
      if (0L == this.jdField_d_of_type_Long) {
        this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_last_send_report", 0L);
      }
      if (0L == this.jdField_e_of_type_Long) {
        this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("magic_font_reset_time", 0L);
      }
      if ((this.jdField_d_of_type_Long < jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > jdField_c_of_type_Long) && (paramChatMessage.time * 1000L > this.jdField_e_of_type_Long))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isDigitsOnly((CharSequence)localObject))) {
          break label353;
        }
      }
    }
    label353:
    for (int n = Integer.valueOf((String)localObject).intValue();; n = 0)
    {
      if ((n == 0) && (a(paramChatMessage))) {
        n = 1;
      }
      for (;;)
      {
        if (n != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reportFontEffect real report.");
          }
          VasWebviewUtil.reportCommercialDrainage(paramChatMessage.selfuin, "FontEffect", "SendMsg", "", 1, 0, 0, "", n + "", "");
          this.jdField_d_of_type_Long = (paramChatMessage.time * 1000L);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
          ((SharedPreferences.Editor)localObject).putLong("magic_font_last_send_report", paramChatMessage.time * 1000L);
          ((SharedPreferences.Editor)localObject).apply();
        }
        return;
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new pz(this, paramString, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramBoolean).apply();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (jdField_e_of_type_Int == -1)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          QLog.d("VasFont", 1, "FounderDynamicFont DPC value = " + localObject[8]);
          if (!"0".equals(localObject[8])) {
            break label109;
          }
        }
      }
    }
    label109:
    for (jdField_e_of_type_Int = 0;; jdField_e_of_type_Int = 1)
    {
      if ((jdField_e_of_type_Int == 1) || (jdField_e_of_type_Int == -1)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = true;
    if (a(paramChatMessage)) {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> magic font first.");
      }
    }
    String str;
    int n;
    label208:
    label238:
    do
    {
      do
      {
        do
        {
          return false;
          str = paramChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> font effect id(msg str): " + str);
          }
          if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
            break label208;
          }
          n = Integer.valueOf(str).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> font effect id(msg int): " + n);
          }
          if (n == 0) {
            break;
          }
          if (this.jdField_g_of_type_Boolean) {
            break label238;
          }
          this.jdField_g_of_type_Boolean = true;
          paramChatMessage = VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5L, "magicFontConfig.json", jdField_g_of_type_JavaLangString, true, null);
          if (paramChatMessage != null) {
            a(paramChatMessage);
          }
        } while (!QLog.isColorLevel());
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, parse Json.");
        return false;
      } while (!QLog.isColorLevel());
      QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, fontEffectId=FONT_EFFECT_NONE.");
      return false;
      QLog.e("tag.vasFont.enlarge", 1, "enableEnlargeFontEffect --> error effect id: " + str);
      return false;
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> disable enlarge font, enlargeFontSwitch close.");
    return false;
    FriendsManager localFriendsManager;
    if (paramChatMessage.isSend())
    {
      str = paramChatMessage.selfuin;
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localFriendsManager != null)
      {
        ExtensionInfo localExtensionInfo = localFriendsManager.a(str, false);
        if (localExtensionInfo == null) {
          break label489;
        }
        if (QLog.isColorLevel()) {
          QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo.fontEffectLastUpdateTime:" + localExtensionInfo.fontEffectLastUpdateTime + " msg.time:" + paramChatMessage.time);
        }
        if ((localExtensionInfo.fontEffectLastUpdateTime < paramChatMessage.time) && (n != localExtensionInfo.fontEffect))
        {
          if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> fontEffectId not equal with local.");
          }
          AvatarPendantUtil.a(str);
          AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      label410:
      if (2000 != n) {
        break label510;
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> enable enlarge font.");
      }
    }
    label489:
    label510:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        str = paramChatMessage.frienduin;
        break;
      }
      str = paramChatMessage.senderuin;
      break;
      ThreadManager.post(new qf(this, localFriendsManager, str), 5, null, true);
      break label410;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "resetLastSendReportTime.");
    }
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putLong("magic_font_last_send_report", this.jdField_d_of_type_Long);
    localEditor.putLong("magic_font_reset_time", this.jdField_e_of_type_Long);
    localEditor.apply();
  }
  
  public boolean c()
  {
    if (this.jdField_f_of_type_Int != -1) {
      return this.jdField_f_of_type_Int == 1;
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name(), "default");
    QLog.d("VasFont", 1, "fontSwitch = " + str);
    if (str.equals("1"))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.jdField_a_of_type_Boolean = a(str);
    }
    if (str.equals("0")) {
      this.jdField_f_of_type_Int = 0;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1398	com/etrump/mixlayout/FontManager:jdField_a_of_type_Long	J
    //   4: lconst_0
    //   5: putstatic 1400	com/etrump/mixlayout/FontManager:jdField_b_of_type_Long	J
    //   8: getstatic 201	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: invokevirtual 1403	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   14: aload_0
    //   15: getfield 285	com/etrump/mixlayout/FontManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   18: ifnull +11 -> 29
    //   21: aload_0
    //   22: getfield 285	com/etrump/mixlayout/FontManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   25: aconst_null
    //   26: invokevirtual 1407	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 269	com/etrump/mixlayout/FontManager:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   33: ifnull +11 -> 44
    //   36: aload_0
    //   37: getfield 269	com/etrump/mixlayout/FontManager:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   40: invokevirtual 1410	android/os/HandlerThread:quit	()Z
    //   43: pop
    //   44: aload_0
    //   45: getfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   48: ifnull +53 -> 101
    //   51: aload_0
    //   52: getfield 169	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   62: invokestatic 1416	com/etrump/mixlayout/ETDecoration:clearMap	(Lcom/etrump/mixlayout/ETEngine;)V
    //   65: aload_0
    //   66: getfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   69: invokevirtual 1419	com/etrump/mixlayout/ETEngine:native_doneEngine	()V
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_0
    //   75: getfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   78: getfield 319	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   81: iconst_0
    //   82: invokevirtual 373	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   85: aload_0
    //   86: getfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   89: getfield 326	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   92: iconst_0
    //   93: invokevirtual 373	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 328	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   101: invokestatic 537	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +13 -> 117
    //   107: ldc_w 261
    //   110: iconst_2
    //   111: ldc_w 1421
    //   114: invokestatic 548	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: return
    //   118: astore_2
    //   119: aload_1
    //   120: monitorexit
    //   121: aload_2
    //   122: athrow
    //   123: astore_1
    //   124: invokestatic 537	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -53 -> 74
    //   130: ldc_w 261
    //   133: iconst_2
    //   134: aload_1
    //   135: invokevirtual 1422	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   138: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: goto -67 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	FontManager
    //   123	12	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   118	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   58	74	118	finally
    //   119	121	118	finally
    //   51	58	123	java/lang/UnsatisfiedLinkError
    //   121	123	123	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */