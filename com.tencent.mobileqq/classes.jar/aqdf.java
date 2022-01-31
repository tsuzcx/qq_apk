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

public class aqdf
  implements Manager
{
  public static int a;
  public static aqcy a;
  public static final String a;
  private static boolean jdField_a_of_type_Boolean;
  public static aqcy b;
  public static AtomicBoolean b;
  public static AtomicBoolean c;
  public Handler a;
  aqdm jdField_a_of_type_Aqdm = null;
  private bats jdField_a_of_type_Bats;
  public QQAppInterface a;
  public final Object a;
  public Vector<Integer> a;
  public ConcurrentHashMap<Integer, aqde> a;
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
    jdField_a_of_type_Aqcy = new aqdi();
    jdField_b_of_type_Aqcy = new aqdj();
  }
  
  public aqdf(QQAppInterface paramQQAppInterface)
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
    aqcz localaqcz = aqcx.a().a(paramInt, 0, jdField_a_of_type_Aqcy);
    if ((localaqcz.jdField_a_of_type_Int != 2) && (localaqcz.jdField_a_of_type_Int != 1) && (localaqcz.jdField_a_of_type_Int != 4) && (localaqcz.jdField_a_of_type_Int != 3)) {
      localaqcz.a(false);
    }
    return localaqcz.jdField_a_of_type_Int;
  }
  
  public static aqdf a(QQAppInterface paramQQAppInterface)
  {
    return (aqdf)paramQQAppInterface.getManager(219);
  }
  
  public static bbms a(Context paramContext)
  {
    if ((((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      if (((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bbms == null) {
        ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bbms = new bbms(paramContext);
      }
      return ((FragmentActivity)paramContext).getChatFragment().a().jdField_a_of_type_Bbms;
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
            str2 = ajjy.a(2131639675);
            paramArrayOfByte = localTTipsInfo.str_msg.get();
            if (TextUtils.isEmpty(paramArrayOfByte))
            {
              String str3;
              if (i == 1)
              {
                paramArrayOfByte = ajjy.a(2131639679);
                str3 = localTTipsInfo.str_button.get();
                str1 = str3;
                if (TextUtils.isEmpty(str3))
                {
                  if (i == 1) {
                    str1 = ajjy.a(2131639680);
                  }
                }
                else
                {
                  str3 = localTTipsInfo.str_url.get();
                  babr.a(paramContext, 230, str2, paramArrayOfByte, ajjy.a(2131639683), str1, new aqdg(i, str3, paramContext, localTTipsInfo, paramInt), new aqdh()).show();
                  if (!(paramContext instanceof FragmentActivity)) {
                    break;
                  }
                  paramContext = (FragmentActivity)paramContext;
                  if ((paramContext.getChatFragment() == null) || (paramContext.getChatFragment().a() == null)) {
                    break;
                  }
                  ((aqdf)paramContext.getChatFragment().a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219)).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                }
              }
              else
              {
                if (i != 2) {
                  break label332;
                }
                paramArrayOfByte = ajjy.a(2131639684);
                continue;
              }
              String str1 = str3;
              if (i != 2) {
                continue;
              }
              str1 = ajjy.a(2131639677);
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
      aqde localaqde = (aqde)localIterator.next();
      if (!localaqde.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(localaqde.jdField_a_of_type_Int, true, false, false);
      }
    }
  }
  
  public aqde a(int paramInt)
  {
    try
    {
      aqde localaqde2 = (aqde)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      aqde localaqde1 = localaqde2;
      if (localaqde2 == null)
      {
        localaqde1 = new aqde();
        localaqde1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localaqde1);
      }
      return localaqde1;
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
        localaqde = a(paramInt);
        if (!aqcx.a(paramInt)) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", ajjy.a(2131639686));
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        aqde localaqde;
        localException.printStackTrace();
        continue;
        if (localaqde.c != -1) {
          continue;
        }
        localException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", ajjy.a(2131639676));
        continue;
        localException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", ajjy.a(2131639681));
        continue;
        i = 0;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "queryInfo hiboomId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      if (!localaqde.jdField_a_of_type_Boolean) {
        continue;
      }
      localJSONObject2.put("status", 3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", ajjy.a(2131639674));
      if (localaqde.c != -3) {
        continue;
      }
      localJSONObject2.put("canceling", i);
      localJSONObject2.put("progress", localaqde.c);
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
    aqde localaqde = a(paramInt);
    localaqde.c = -3;
    localaqde.jdField_b_of_type_Boolean = false;
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
    jdField_a_of_type_Aqcy.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    aqde localaqde = a(paramInt);
    Object localObject = new File(aqcx.c + localaqde.jdField_a_of_type_Int + File.separator + "hifont.json");
    if (((File)localObject).exists())
    {
      localObject = bace.a((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            localaqde.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
            localaqde.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("engine");
            localaqde.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
            if (!TextUtils.isEmpty(localaqde.jdField_b_of_type_JavaLangString)) {
              localaqde.jdField_b_of_type_JavaLangString = localaqde.jdField_b_of_type_JavaLangString.toLowerCase();
            }
            localaqde.jdField_a_of_type_Boolean = aqcx.a(paramInt);
            if (!localaqde.jdField_a_of_type_Boolean)
            {
              localObject = new File(aqcx.c + localaqde.jdField_a_of_type_Int + File.separator + "panelImg.png");
              if (((File)localObject).exists()) {
                localaqde.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a(((File)localObject).getAbsolutePath(), null);
              }
            }
            else
            {
              if (paramBoolean3)
              {
                localObject = new File(aqcx.c + paramInt + File.separator + "aiodbclick.png");
                if (!((File)localObject).exists()) {
                  break label450;
                }
                localaqde.jdField_b_of_type_AndroidGraphicsBitmap = bacm.a(((File)localObject).getAbsolutePath(), null);
              }
              localaqde.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              if (paramBoolean2) {
                a();
              }
              if ((!paramBoolean3) || (this.jdField_b_of_type_AndroidOsHandler == null)) {
                break;
              }
              localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(19);
              ((Message)localObject).obj = localaqde.jdField_b_of_type_AndroidGraphicsBitmap;
              this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " preview not exists");
            }
            if (!paramBoolean1) {
              continue;
            }
            b(localaqde.jdField_a_of_type_Int);
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
  
  public void a(aqdm paramaqdm)
  {
    this.jdField_a_of_type_Aqdm = paramaqdm;
  }
  
  public void a(bats parambats)
  {
    this.jdField_a_of_type_Bats = parambats;
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
        aqde localaqde = a(i);
        localaqde.jdField_a_of_type_Int = i;
        localaqde.jdField_a_of_type_Long = localTPosterFontInfo.u64_ts.get();
        if (a(localaqde.jdField_a_of_type_Long)) {
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
      bace.a(paramTGetPosterFontRsp.toByteArray(), jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.set(paramBoolean);
  }
  
  public boolean a()
  {
    apha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (!axku.a((String)localObject)) {
        break label165;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("HiBoom_CHN_Tips", false));
    bbmy.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, ajjy.a(2131639678), 0).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
    return false;
    label165:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt1;
    localHiBoomMessage.text = ((String)localObject);
    localHiBoomMessage.type = paramInt2;
    aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHiBoomMessage, null);
    Object localObject = "99";
    switch (a(paramInt1).a())
    {
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "HighFont", "Send", "", 1, 0, 0, "", "" + paramInt1, (String)localObject);
      localObject = new aaes();
      paramBaseChatPie.a((aaes)localObject);
      ((aaes)localObject).i = paramBaseChatPie.J;
      paramBaseChatPie.J = false;
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (acxx)paramBaseChatPie.a(27);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.a(paramString, (aaes)localObject, 0);
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
    bbmy.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, "嗨爆字体不能超过20字", 0).a();
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
    ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).b();
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
      ((aqde)???).jdField_b_of_type_Boolean = false;
      if (paramInt2 != 0) {
        break label267;
      }
      i = 100;
      label87:
      ((aqde)???).c = i;
      if (paramInt2 != 0) {
        break label272;
      }
      ((aqde)???).jdField_a_of_type_Boolean = bool;
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
          if ((!((String)localObject2).equals("0")) && (this.jdField_a_of_type_Bats != null))
          {
            ??? = new Bundle();
            ((Bundle)???).putString("callbackId", (String)localObject2);
            ((Bundle)???).putInt("srcType", 2);
            localObject2 = this.jdField_a_of_type_Bats;
            long l = paramInt1;
            if (paramInt2 != 0) {
              break label286;
            }
            paramInt1 = j;
            ((bats)localObject2).a(l, paramInt1, (Bundle)???);
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
    if (this.jdField_a_of_type_Aqdm != null) {
      this.jdField_a_of_type_Aqdm.a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getHiBoomListFromLocal");
    }
    byte[] arrayOfByte = bace.a(jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_Aqdm = null;
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqdf
 * JD-Core Version:    0.7.0.1
 */