import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterFontInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public class aqxj
  implements Manager
{
  public static int a;
  public static aqxc a;
  public static final String a;
  private static boolean jdField_a_of_type_Boolean;
  public static aqxc b;
  public static AtomicBoolean b;
  public static AtomicBoolean c;
  public Handler a;
  aqxq jdField_a_of_type_Aqxq = null;
  private bbxa jdField_a_of_type_Bbxa;
  public QQAppInterface a;
  public final Object a;
  public Vector<Integer> a;
  public ConcurrentHashMap<Integer, aqxi> a;
  public AtomicBoolean a;
  public Handler b;
  public Vector<Integer> b;
  ConcurrentHashMap<Integer, String> b;
  public Vector<Integer> c;
  private AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "hiboom_list_cache";
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 300;
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Aqxc = new aqxm();
    jdField_b_of_type_Aqxc = new aqxn();
  }
  
  public aqxj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_c_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public static int a(int paramInt)
  {
    aqxd localaqxd = aqxb.a().a(paramInt, 0, jdField_a_of_type_Aqxc);
    if ((localaqxd.jdField_a_of_type_Int != 2) && (localaqxd.jdField_a_of_type_Int != 1) && (localaqxd.jdField_a_of_type_Int != 4) && (localaqxd.jdField_a_of_type_Int != 3)) {
      localaqxd.a(false);
    }
    return localaqxd.jdField_a_of_type_Int;
  }
  
  public static aqxj a(QQAppInterface paramQQAppInterface)
  {
    return (aqxj)paramQQAppInterface.getManager(219);
  }
  
  public static bcqf a(Context paramContext)
  {
    if ((((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      if (((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bcqf == null) {
        ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bcqf = new bcqf(paramContext);
      }
      return ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bcqf;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      hiboom_auth.TTipsInfo localTTipsInfo = new hiboom_auth.TTipsInfo();
      label332:
      for (;;)
      {
        try
        {
          localTTipsInfo.mergeFrom(paramArrayOfByte);
          int i = localTTipsInfo.i32_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult tipsType = " + i);
          }
          String str2 = localTTipsInfo.str_title.get();
          if (TextUtils.isEmpty(str2))
          {
            str2 = ajya.a(2131705471);
            paramArrayOfByte = localTTipsInfo.str_msg.get();
            if (TextUtils.isEmpty(paramArrayOfByte))
            {
              String str3;
              if (i == 1)
              {
                paramArrayOfByte = ajya.a(2131705475);
                str3 = localTTipsInfo.str_button.get();
                str1 = str3;
                if (TextUtils.isEmpty(str3))
                {
                  if (i == 1) {
                    str1 = ajya.a(2131705476);
                  }
                }
                else
                {
                  str3 = localTTipsInfo.str_url.get();
                  bbdj.a(paramContext, 230, str2, paramArrayOfByte, ajya.a(2131705479), str1, new aqxk(i, str3, paramContext, localTTipsInfo, paramInt), new aqxl()).show();
                  if (!(paramContext instanceof FragmentActivity)) {
                    break;
                  }
                  paramContext = (FragmentActivity)paramContext;
                  if ((paramContext.getChatFragment() == null) || (paramContext.getChatFragment().a() == null)) {
                    break;
                  }
                  ((aqxj)paramContext.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219)).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                }
              }
              else
              {
                if (i != 2) {
                  break label332;
                }
                paramArrayOfByte = ajya.a(2131705480);
                continue;
              }
              String str1 = str3;
              if (i != 2) {
                continue;
              }
              str1 = ajya.a(2131705473);
              continue;
            }
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("HiBoomFont.HiBoomManager", 1, "onHiBoomAuthResult merge error: " + paramContext.getLocalizedMessage() + " trace: " + Log.getStackTraceString(paramContext));
          return;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4);
  }
  
  private static boolean a(long paramLong)
  {
    return NetConnInfoCenter.getServerTime() > paramLong;
  }
  
  private void b(int paramInt)
  {
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).downloadItem(5L, "font.hiFontQQ.json." + paramInt, "HiBoomManager");
  }
  
  public static boolean b()
  {
    long l = Runtime.getRuntime().maxMemory();
    if (l > 134217728L) {}
    for (boolean bool = true;; bool = false)
    {
      if ((QLog.isColorLevel()) || (!bool)) {
        QLog.d("HiBoomFont.HiBoomManager", 1, "isMemorySupport: " + bool + " maxHeap=" + l);
      }
      return bool;
    }
  }
  
  private void e()
  {
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    ArrayList localArrayList = new ArrayList();
    int i = 2000;
    if (i < 2005)
    {
      VipFontUpdate.TPosterFontInfo localTPosterFontInfo = new VipFontUpdate.TPosterFontInfo();
      localTPosterFontInfo.i32_font_id.set(i);
      if (i % 2 == 0) {}
      for (long l = System.currentTimeMillis() / 1000L + 86400L;; l = System.currentTimeMillis() / 1000L - i)
      {
        localTPosterFontInfo.u64_ts.set(l);
        localArrayList.add(localTPosterFontInfo);
        i += 1;
        break;
      }
    }
    localTGetPosterFontRsp.rpt_using_list.set(localArrayList);
    a(localTGetPosterFontRsp, true);
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aqxi localaqxi = (aqxi)localIterator.next();
      if (!localaqxi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(localaqxi.jdField_a_of_type_Int, true, false, false);
      }
    }
  }
  
  public aqxi a(int paramInt)
  {
    try
    {
      aqxi localaqxi2 = (aqxi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      aqxi localaqxi1 = localaqxi2;
      if (localaqxi2 == null)
      {
        localaqxi1 = new aqxi();
        localaqxi1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localaqxi1);
      }
      return localaqxi1;
    }
    finally {}
  }
  
  public JSONObject a(int paramInt)
  {
    i = 1;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localaqxi = a(paramInt);
        if (!aqxb.a(paramInt)) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", ajya.a(2131705482));
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        aqxi localaqxi;
        localException.printStackTrace();
        continue;
        if (localaqxi.c != -1) {
          continue;
        }
        localException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", ajya.a(2131705472));
        continue;
        localException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", ajya.a(2131705477));
        continue;
        i = 0;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "queryInfo hiboomId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      if (!localaqxi.jdField_a_of_type_Boolean) {
        continue;
      }
      localJSONObject2.put("status", 3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", ajya.a(2131705470));
      if (localaqxi.c != -3) {
        continue;
      }
      localJSONObject2.put("canceling", i);
      localJSONObject2.put("progress", localaqxi.c);
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    aqxi localaqxi = a(paramInt);
    localaqxi.c = -3;
    localaqxi.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).cancelDwonloadItem(5L, "font.hifont.android." + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "updateHiBoomItemProgress id = " + paramInt1 + " progress = " + paramInt2);
    }
    a(paramInt1).c = paramInt2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localMessage.arg1 = paramInt1;
        localMessage.arg2 = paramInt2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "downloadHiBoomFont id = " + paramInt + " is downloading");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    jdField_a_of_type_Aqxc.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    aqxi localaqxi = a(paramInt);
    Object localObject = new File(aqxb.c + localaqxi.jdField_a_of_type_Int + File.separator + "hifont.json");
    if (((File)localObject).exists())
    {
      localObject = bbdx.a((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            localaqxi.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
            localaqxi.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("engine");
            localaqxi.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
            if (!TextUtils.isEmpty(localaqxi.jdField_b_of_type_JavaLangString)) {
              localaqxi.jdField_b_of_type_JavaLangString = localaqxi.jdField_b_of_type_JavaLangString.toLowerCase();
            }
            localaqxi.jdField_a_of_type_Boolean = aqxb.a(paramInt);
            if (!localaqxi.jdField_a_of_type_Boolean)
            {
              localObject = new File(aqxb.c + localaqxi.jdField_a_of_type_Int + File.separator + "panelImg.png");
              if (((File)localObject).exists()) {
                localaqxi.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a(((File)localObject).getAbsolutePath(), null);
              }
            }
            else
            {
              if (paramBoolean3)
              {
                localObject = new File(aqxb.c + paramInt + File.separator + "aiodbclick.png");
                if (!((File)localObject).exists()) {
                  break label450;
                }
                localaqxi.jdField_b_of_type_AndroidGraphicsBitmap = bbef.a(((File)localObject).getAbsolutePath(), null);
              }
              localaqxi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              if (paramBoolean2) {
                a();
              }
              if ((!paramBoolean3) || (this.jdField_b_of_type_AndroidOsHandler == null)) {
                break;
              }
              localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(19);
              ((Message)localObject).obj = localaqxi.jdField_b_of_type_AndroidGraphicsBitmap;
              this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " preview not exists");
            }
            if (!paramBoolean1) {
              continue;
            }
            b(localaqxi.jdField_a_of_type_Int);
            continue;
            if (!QLog.isColorLevel()) {
              break label488;
            }
          }
          catch (Exception localException)
          {
            QLog.e("HiBoomFont.HiBoomManager", 1, "loadHiBoomConfig: " + Log.getStackTraceString(localException));
            return;
          }
          label450:
          QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " aio preview not exists");
          label488:
          if (paramBoolean1) {
            b(localException.jdField_a_of_type_Int);
          }
        }
      }
    }
    else if (paramBoolean1)
    {
      b(localException.jdField_a_of_type_Int);
    }
  }
  
  public void a(aqxq paramaqxq)
  {
    this.jdField_a_of_type_Aqxq = paramaqxq;
  }
  
  public void a(bbxa parambbxa)
  {
    this.jdField_a_of_type_Bbxa = parambbxa;
  }
  
  public void a(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_c_of_type_JavaUtilVector.clear();
    Object localObject = paramTGetPosterFontRsp.rpt_using_list.get();
    int i;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList size = " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipFontUpdate.TPosterFontInfo localTPosterFontInfo = (VipFontUpdate.TPosterFontInfo)((Iterator)localObject).next();
        i = localTPosterFontInfo.i32_font_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList id = " + i);
        }
        aqxi localaqxi = a(i);
        localaqxi.jdField_a_of_type_Int = i;
        localaqxi.jdField_a_of_type_Long = localTPosterFontInfo.u64_ts.get();
        if (a(localaqxi.jdField_a_of_type_Long)) {
          this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(i));
        } else {
          this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(i));
        }
      }
      Collections.reverse(this.jdField_a_of_type_JavaUtilVector);
    }
    localObject = paramTGetPosterFontRsp.i32_recommend_font_id.get();
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand size = " + ((List)localObject).size());
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i = ((Integer)((Iterator)localObject).next()).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand id = " + i);
        }
        a(i);
        this.jdField_c_of_type_JavaUtilVector.add(Integer.valueOf(i));
      }
    }
    f();
    a();
    if (paramBoolean) {
      bbdx.a(paramTGetPosterFontRsp.toByteArray(), jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.set(paramBoolean);
  }
  
  public boolean a()
  {
    apzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (this.d.get()) && (b());
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "sendHiBoomMessage hiBoomId = " + paramInt1);
    }
    int i;
    if ((paramBaseChatPie.b() != 1008) && (paramBaseChatPie.b() != 7200))
    {
      i = 1;
      if (i != 0)
      {
        localObject = a(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      return false;
      i = 0;
      break;
      if (((String)localObject).length() > 20) {
        break label373;
      }
      if (!aylc.a((String)localObject)) {
        break label165;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false));
    bcql.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, ajya.a(2131705474), 0).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
    return false;
    label165:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt1;
    localHiBoomMessage.text = ((String)localObject);
    localHiBoomMessage.type = paramInt2;
    aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHiBoomMessage, null);
    Object localObject = "99";
    switch (a(paramInt1).a())
    {
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "HighFont", "Send", "", 1, 0, 0, "", "" + paramInt1, (String)localObject);
      localObject = new aaog();
      paramBaseChatPie.a((aaog)localObject);
      ((aaog)localObject).i = paramBaseChatPie.J;
      paramBaseChatPie.J = false;
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (adiw)paramBaseChatPie.a(27);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.a(paramString, (aaog)localObject, 0);
        }
      }
      return true;
      localObject = "2";
      continue;
      localObject = "3";
      continue;
      localObject = "1";
    }
    label373:
    bcql.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体不能超过20字", 0).a();
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (jdField_a_of_type_Boolean) {
        e();
      }
    }
    else {
      return;
    }
    ((akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int j = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str = "" + paramInt1;
    int i;
    if (paramInt2 == 0)
    {
      ??? = "0";
      VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickDown", "", 1, 0, 0, "", str, (String)???);
      ??? = a(paramInt1);
      ((aqxi)???).jdField_b_of_type_Boolean = false;
      if (paramInt2 != 0) {
        break label267;
      }
      i = 100;
      label87:
      ((aqxi)???).c = i;
      if (paramInt2 != 0) {
        break label272;
      }
      ((aqxi)???).jdField_a_of_type_Boolean = bool;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          ((Message)localObject2).arg1 = paramInt1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        }
        localObject2 = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt1));
          if ((!((String)localObject2).equals("0")) && (this.jdField_a_of_type_Bbxa != null))
          {
            ??? = new Bundle();
            ((Bundle)???).putString("callbackId", (String)localObject2);
            ((Bundle)???).putInt("srcType", 2);
            localObject2 = this.jdField_a_of_type_Bbxa;
            long l = paramInt1;
            if (paramInt2 != 0) {
              break label286;
            }
            paramInt1 = j;
            ((bbxa)localObject2).a(l, paramInt1, (Bundle)???);
          }
        }
        return;
        ??? = "1";
        break;
        label267:
        i = -1;
        break label87;
        label272:
        bool = false;
      }
      label286:
      paramInt1 = -1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    if (paramBoolean) {
      a();
    }
    if (this.jdField_a_of_type_Aqxq != null) {
      this.jdField_a_of_type_Aqxq.a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getHiBoomListFromLocal");
    }
    byte[] arrayOfByte = bbdx.a(jdField_a_of_type_JavaLangString);
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp;
    if (arrayOfByte != null) {
      localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    }
    try
    {
      localTGetPosterFontRsp.mergeFrom(arrayOfByte);
      a(localTGetPosterFontRsp, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("HiBoomFont.HiBoomManager", 1, "getHiBoomListFromLocal error: " + Log.getStackTraceString(localException));
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_Aqxq = null;
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxj
 * JD-Core Version:    0.7.0.1
 */