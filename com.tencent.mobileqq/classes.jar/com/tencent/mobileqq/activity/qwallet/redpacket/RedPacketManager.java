package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetSkinListReq;
import Wallet.RedPackGrapInfo;
import Wallet.SetSelectedSkinReq;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgDBHelper.NotifyMsgRecord;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import xdn;
import xdp;
import xdr;
import xds;
import xdt;
import xdu;
import xdw;
import xdx;
import xdy;
import xdz;

public class RedPacketManager
  implements IRedPacket
{
  public static final String CONFIG_BIG_ANIM = "bigAnimMap";
  public static final String CONFIG_MODULE = "redPack";
  public static final String CONFIG_POP_AD = "popAd";
  public static final String CONFIG_POP_ANIM = "popAnimMap";
  public static final String CONFIG_SKINS = "skinMap";
  public static final String CONFIG_TAIL = "tail";
  public static final String CONFIG_URL_DETAULT_PREFIX = "http://imgcache.qq.com/channel/static/socialpay/skin/";
  public static final String CONFIG_URL_PANEL_PREFIX = "http://i.gtimg.cn/channel/imglib/201803/";
  public static final String CONFIG_URL_THEME_PREFIX = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
  public static final String CONFIG_URL_VOICE_PREFIX = "http://imgcache.qq.com/channel/static/socialpay/voice/";
  public static final String DEFAULT_TEXT_COLOR = "#000000";
  public static final String FILE_SKINS = "skins";
  public static final String TAG = "RedPacketManager";
  public static final int TYPE_CLEAR_CACHE = 1;
  public static final int TYPE_DEFAULT_REDPKG = 0;
  public static final int TYPE_F2F_REDPKG = 5;
  public static final int TYPE_H5_REDPKG = 4;
  public static final int TYPE_LOCK_TEXT_REDPKG = 2;
  public static final int TYPE_LOCK_VOICE_REDPKG = 6;
  public static final int TYPE_LUCK_REDPKG = 1;
  public static final int TYPE_THEME_REDPKG = 3;
  static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  final int jdField_a_of_type_Int = 1;
  protected BusinessObserver a;
  final int jdField_b_of_type_Int = 2;
  public HashMap b;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  final int jdField_c_of_type_Int = 4;
  private HashMap jdField_c_of_type_JavaUtilHashMap;
  private HashMap d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), new PanelData("", 0, "普通红包", "upload_f5d272e2d82c95fccfe7dfd58aceaf57", "", "#000000"));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), new PanelData("", 1, "拼手气红包", "upload_80fa2f7471c5b9991fefff4c408f4df6", "", "#000000"));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new PanelData("", 6, "口令红包", "upload_c8e94187ff62b460698226a8013bd56d", "", "#000000"));
  }
  
  public RedPacketManager()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new xdx(this);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private boolean b(int paramInt)
  {
    return paramInt == 101;
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  public static String genCacheKeyBySkin(int paramInt1, int paramInt2)
  {
    String str1 = "";
    if (paramInt1 != -1) {
      str1 = "" + "f_" + paramInt1;
    }
    String str2 = str1;
    if (paramInt2 != -1)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = str1 + "_";
      }
      str2 = str2 + "s_" + paramInt2;
    }
    return str2;
  }
  
  public static String[] genMatchKeys(int paramInt1, int paramInt2)
  {
    String str1 = "f_" + paramInt1;
    String str2 = "s_" + paramInt2;
    return new String[] { str1 + "_" + str2, str1, str2 };
  }
  
  public static IRedPacket getInstance()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return xdy.a;
    }
    return xdz.a;
  }
  
  public static boolean isValidDate(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = QWalletTools.b(paramString1);
    long l3 = QWalletTools.b(paramString2);
    boolean bool;
    if (l1 >= l2) {
      bool = true;
    }
    while (bool) {
      if ((l3 == -1L) || (l1 <= l3))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, boolean paramBoolean)
  {
    if (paramOnGetAvailableListListener == null) {}
    label487:
    do
    {
      return;
      if ((paramGetGroupRedPackListRsp == null) || (paramGetGroupRedPackListRsp.vecRedPackList == null))
      {
        paramOnGetAvailableListListener.OnGetAvailableList(null);
        return;
      }
      long l = NetConnInfoCenter.getServerTime();
      if ((!paramBoolean) && (l > paramGetGroupRedPackListRsp.lFailureTime))
      {
        paramOnGetAvailableListListener.OnGetAvailableList(null);
        return;
      }
      Object localObject1 = NotifyMsgManager.a(2);
      int i = paramGetGroupRedPackListRsp.vecRedPackList.size() - 1;
      int j;
      if (i >= 0)
      {
        Object localObject2 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(i);
        if (localObject2 == null) {
          paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((!paramBoolean) && (((RedPackGrapInfo)localObject2).lCreateTime + 864000L < l))
          {
            paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
          }
          else
          {
            localObject2 = ((RedPackGrapInfo)localObject2).sBiilNo;
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (localObject1 != null))
            {
              j = 0;
              while (j < ((ArrayList)localObject1).size())
              {
                NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgDBHelper.NotifyMsgRecord)((ArrayList)localObject1).get(j);
                if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.jdField_a_of_type_JavaLangString != null) && (localNotifyMsgRecord.jdField_a_of_type_JavaLangString.equals(localObject2))) {
                  paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
                }
                j += 1;
              }
            }
            else
            {
              paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
            }
          }
        }
      }
      paramOnGetAvailableListListener.OnGetAvailableList(paramGetGroupRedPackListRsp.vecRedPackList);
      localObject1 = QWalletTools.a();
      paramOnGetAvailableListListener = null;
      if (localObject1 != null) {
        paramOnGetAvailableListListener = (PasswdRedBagManager)((QQAppInterface)localObject1).getManager(124);
      }
      if (paramOnGetAvailableListListener != null)
      {
        j = 0;
        if (j < paramGetGroupRedPackListRsp.vecRedPackList.size())
        {
          localObject1 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(j);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((RedPackGrapInfo)localObject1).sBiilNo)) && ((((RedPackGrapInfo)localObject1).iMsgType == 6) || (((RedPackGrapInfo)localObject1).iMsgType == 13) || (((RedPackGrapInfo)localObject1).iMsgType == 15)) && (paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo) == null))
          {
            if (paramInt != 1) {
              break label487;
            }
            i = 1;
          }
          for (;;)
          {
            int k = 0;
            if ((((RedPackGrapInfo)localObject1).iMsgType == 13) || (((RedPackGrapInfo)localObject1).iMsgType == 15)) {
              k = 1;
            }
            paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo, ((RedPackGrapInfo)localObject1).sIndex, ((RedPackGrapInfo)localObject1).sTitle, String.valueOf(((RedPackGrapInfo)localObject1).lUin), ((RedPackGrapInfo)localObject1).lCreateTime + 90000L, String.valueOf(i), paramString2, ((RedPackGrapInfo)localObject1).sAuthKey, false, false, k);
            j += 1;
            break;
            if (paramInt == 2) {
              i = 2;
            } else {
              i = 3;
            }
          }
        }
      }
    } while (!paramBoolean);
    ThreadManager.getFileThreadHandler().post(new xdw(this, paramGetGroupRedPackListRsp, paramString1, paramString2, paramInt));
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    Object localObject1;
    GetGroupRedPackListRsp localGetGroupRedPackListRsp;
    int i;
    label48:
    String str;
    label65:
    int j;
    label140:
    label146:
    label152:
    do
    {
      do
      {
        return;
        localObject1 = (GetGroupRedPackListReq)paramBundle.getSerializable("req");
        localGetGroupRedPackListRsp = (GetGroupRedPackListRsp)paramBundle.getSerializable("rsp");
        paramBundle = QWalletTools.a();
      } while (paramBundle == null);
      if (localGetGroupRedPackListRsp != null)
      {
        i = localGetGroupRedPackListRsp.iRetCode;
        str = paramBundle.getCurrentAccountUin();
        if (localObject1 == null) {
          break label140;
        }
        paramBundle = ((GetGroupRedPackListReq)localObject1).sGroupUin;
        if (localObject1 == null) {
          break label146;
        }
      }
      for (j = ((GetGroupRedPackListReq)localObject1).iGroupType;; j = 0)
      {
        if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.isEmpty(str))) {
          break label152;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RedPacketManager", 2, "onGetGroupAavailableList groupUin or myUin is null, retCode:" + i + " groupUin:" + paramBundle);
        return;
        i = -1;
        break label48;
        paramBundle = "";
        break label65;
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.jdField_b_of_type_JavaUtilHashMap != null)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_JavaUtilHashMap.get(paramBundle + "_" + j) != null) {
          localObject1 = (IRedPacket.OnGetAvailableListListener)((SoftReference)this.jdField_b_of_type_JavaUtilHashMap.get(paramBundle + "_" + j)).get();
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "onGetGroupAavailableList listener is null");
    return;
    if ((!paramBoolean) || (i != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketManager", 2, "onGetGroupAavailableList error. isSuccess:" + paramBoolean + " retCode:" + i);
      }
      ThreadManager.getFileThreadHandler().post(new xdu(this, str, paramBundle, j));
      return;
    }
    a(str, paramBundle, j, (IRedPacket.OnGetAvailableListListener)localObject1, localGetGroupRedPackListRsp, true);
  }
  
  public List getPanelList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int j = 0;
    boolean bool = c(paramSessionInfo.jdField_a_of_type_Int);
    for (;;)
    {
      int i;
      int m;
      int n;
      try
      {
        paramSessionInfo = QWalletTools.a();
        i = k;
        if (paramSessionInfo == null) {
          continue;
        }
        Object localObject = (QWalletConfigManager)paramSessionInfo.getManager(244);
        paramSessionInfo = ((QWalletConfigManager)localObject).a("redPackPanel", new String[] { "panelRedPkgList" });
        localObject = ((QWalletConfigManager)localObject).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorIcon" });
        i = k;
        if (paramSessionInfo == null) {
          continue;
        }
        j = 0;
        m = 0;
        k = j;
        i = j;
        try
        {
          if (m >= paramSessionInfo.length()) {
            continue;
          }
          k = j;
          JSONObject localJSONObject = paramSessionInfo.getJSONObject(m);
          if (localJSONObject == null)
          {
            n = j;
          }
          else
          {
            k = j;
            localPanelData = new PanelData();
            k = j;
            localPanelData.jdField_a_of_type_JavaLangString = localJSONObject.optString("id", "");
            k = j;
            localPanelData.jdField_a_of_type_Int = localJSONObject.optInt("type", -1);
            k = j;
            localPanelData.jdField_b_of_type_JavaLangString = localJSONObject.optString("name", "");
            k = j;
            localPanelData.jdField_c_of_type_JavaLangString = localJSONObject.optString("icon_pic", "");
            k = j;
            localPanelData.jdField_e_of_type_JavaLangString = ((String)localObject);
            k = j;
            localPanelData.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("params");
            k = j;
            if (a(localPanelData.jdField_a_of_type_Int))
            {
              n = j;
              if (!bool) {}
            }
            else
            {
              k = j;
              if (localPanelData.jdField_a_of_type_Int == 0)
              {
                i = j | 0x1;
                k = i;
                if (localPanelData.jdField_a_of_type_OrgJsonJSONObject != null) {
                  continue;
                }
                k = i;
                localArrayList.add(localPanelData);
                n = i;
              }
            }
          }
        }
        catch (Throwable paramSessionInfo)
        {
          i = k;
        }
      }
      catch (Throwable paramSessionInfo)
      {
        PanelData localPanelData;
        int i1;
        i = j;
        continue;
      }
      paramSessionInfo.printStackTrace();
      if ((i & 0x4) != 4) {
        localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(6)));
      }
      if ((i & 0x1) != 1) {
        localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)));
      }
      if ((bool) && ((i & 0x2) != 2)) {
        localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)));
      }
      return localArrayList;
      k = j;
      if (localPanelData.jdField_a_of_type_Int == 1)
      {
        i = j | 0x2;
      }
      else
      {
        k = j;
        if (localPanelData.jdField_a_of_type_Int != 6)
        {
          k = j;
          if (localPanelData.jdField_a_of_type_Int != 2)
          {
            k = j;
            if (localPanelData.jdField_a_of_type_Int == 3)
            {
              k = j;
              n = j;
              if (localPanelData.jdField_a_of_type_OrgJsonJSONObject != null)
              {
                k = j;
                i = localPanelData.jdField_a_of_type_OrgJsonJSONObject.optInt("entry", 0);
                k = j;
                i1 = localPanelData.jdField_a_of_type_OrgJsonJSONObject.optInt("theme_id", 0);
                n = j;
                if (i >= 0)
                {
                  n = j;
                  if (i <= 1)
                  {
                    n = j;
                    if (i1 >= 2)
                    {
                      i = j;
                      if (i1 <= 127) {
                        continue;
                      }
                      n = j;
                    }
                  }
                }
              }
            }
            else
            {
              i = j;
              k = j;
              if (localPanelData.jdField_a_of_type_Int != 4) {
                continue;
              }
              k = j;
              n = j;
              if (localPanelData.jdField_a_of_type_OrgJsonJSONObject != null)
              {
                i = j;
                k = j;
                if (!TextUtils.isEmpty(localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("url"))) {
                  continue;
                }
                n = j;
                break label675;
                k = i;
                n = i;
                if (isValidDate(localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", "")))
                {
                  k = i;
                  localArrayList.add(localPanelData);
                  n = i;
                }
              }
            }
            label675:
            m += 1;
            j = n;
            continue;
          }
        }
        i = j | 0x4;
      }
    }
  }
  
  public List getPanelTabList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = c(paramSessionInfo.jdField_a_of_type_Int);
    for (;;)
    {
      int j;
      PanelTabData localPanelTabData;
      int i;
      try
      {
        Object localObject1 = QWalletTools.a();
        if (localObject1 != null)
        {
          Object localObject2 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(244);
          localObject1 = ((QWalletConfigManager)localObject2).a("redPackPanel", new String[] { "panelTabList" });
          localObject2 = ((QWalletConfigManager)localObject2).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorTab" });
          if (localObject1 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject1).length())
            {
              Object localObject3 = ((JSONArray)localObject1).getJSONObject(j);
              if ((localObject3 == null) || ((b(((JSONObject)localObject3).optInt("type", -1))) && (!bool))) {
                break label433;
              }
              localPanelTabData = new PanelTabData();
              localPanelTabData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("id", "");
              localPanelTabData.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("type", -1);
              localPanelTabData.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("name", "");
              localPanelTabData.jdField_c_of_type_JavaLangString = ((String)localObject2);
              localPanelTabData.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject3).optJSONObject("params");
              if ((localPanelTabData.jdField_a_of_type_Int == 100) || (localPanelTabData.jdField_a_of_type_Int == 102))
              {
                if (localPanelTabData.jdField_a_of_type_OrgJsonJSONObject == null) {
                  break label433;
                }
                localObject3 = localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("url");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label433;
                }
                if (localPanelTabData.jdField_a_of_type_Int == 100)
                {
                  if (paramSessionInfo.jdField_a_of_type_Int != 1) {
                    break label368;
                  }
                  i = 1;
                  localObject3 = (String)localObject3 + "&type=" + i + "&uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
                  localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.put("url", localObject3);
                }
              }
              if (localPanelTabData.jdField_a_of_type_OrgJsonJSONObject != null) {
                break label383;
              }
              localArrayList.add(localPanelTabData);
            }
          }
        }
      }
      catch (Throwable paramSessionInfo)
      {
        paramSessionInfo.printStackTrace();
      }
      return localArrayList;
      label368:
      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
      {
        i = 2;
        continue;
        label383:
        if (isValidDate(localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localPanelTabData.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", ""))) {
          localArrayList.add(localPanelTabData);
        }
      }
      else
      {
        i = 0;
        continue;
      }
      label433:
      j += 1;
    }
  }
  
  public JSONObject getPopAd(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject6;
    int i;
    Object localObject3;
    try
    {
      ??? = QWalletTools.a();
      if (??? == null) {
        break label264;
      }
      localObject6 = (QWalletConfigManager)((QQAppInterface)???).getManager(244);
      if (this.d != null) {
        break label187;
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (this.d != null) {
          break label184;
        }
        localObject6 = ((QWalletConfigManager)localObject6).a("redPack", new String[] { "popAd" });
        if (localObject6 == null) {
          break label184;
        }
        this.d = new HashMap();
        if (localObject6 == null) {
          break label184;
        }
        i = 0;
        if (i >= ((JSONArray)localObject6).length()) {
          break label184;
        }
        JSONObject localJSONObject = ((JSONArray)localObject6).getJSONObject(i);
        if (localJSONObject == null) {
          break label266;
        }
        String str = genCacheKeyBySkin(localJSONObject.optInt("skinId", -1), localJSONObject.optInt("redPackChannel", -1));
        if (TextUtils.isEmpty(str)) {
          break label266;
        }
        this.d.put(str, localJSONObject);
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      localObject3 = null;
    }
    label176:
    return localObject3;
    label184:
    label187:
    if (this.d != null)
    {
      localObject6 = genMatchKeys(paramInt1, paramInt2);
      paramInt2 = localObject6.length;
      paramInt1 = j;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject5 = localObject6[paramInt1];
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label273;
          }
          localObject5 = (JSONObject)this.d.get(localObject5);
          localObject3 = localObject5;
          if (localObject5 == null) {
            break label273;
          }
          return localObject5;
        }
        catch (Throwable localThrowable2) {}
        break label176;
      }
      return localObject3;
      label264:
      return null;
      label266:
      i += 1;
      break;
      label273:
      paramInt1 += 1;
    }
  }
  
  public List getReadyResList()
  {
    return null;
  }
  
  public void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = QWalletTools.a();
        if (localObject != null)
        {
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 5;
          localRedPacketInfo.skinType = paramRedPacketInfoBase.skinType;
          localRedPacketInfo.skinId = paramRedPacketInfoBase.skinId;
          localRedPacketInfo.bigAnimId = paramRedPacketInfoBase.bigAnimId;
          localRedPacketInfo.isCache = paramRedPacketInfoBase.isCache;
          localObject = CustomizeStrategyFactory.a().a((QQAppInterface)localObject, localRedPacketInfo, new xds(this, paramRedPacketInfoBase, paramOnGetSkinListener));
          if (localObject != null)
          {
            ((CustomizeStrategyFactory.RedPacketInfo)localObject).isCache = paramRedPacketInfoBase.isCache;
            paramOnGetSkinListener.onGetSkin((RedPacketInfoBase)localObject);
            return;
          }
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public JSONObject getTail(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject6;
    int i;
    Object localObject3;
    try
    {
      ??? = QWalletTools.a();
      if (??? == null) {
        break label264;
      }
      localObject6 = (QWalletConfigManager)((QQAppInterface)???).getManager(244);
      if (this.jdField_c_of_type_JavaUtilHashMap != null) {
        break label187;
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_c_of_type_JavaUtilHashMap != null) {
          break label184;
        }
        localObject6 = ((QWalletConfigManager)localObject6).a("redPack", new String[] { "tail" });
        if (localObject6 == null) {
          break label184;
        }
        this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
        if (localObject6 == null) {
          break label184;
        }
        i = 0;
        if (i >= ((JSONArray)localObject6).length()) {
          break label184;
        }
        JSONObject localJSONObject = ((JSONArray)localObject6).getJSONObject(i);
        if (localJSONObject == null) {
          break label266;
        }
        String str = genCacheKeyBySkin(localJSONObject.optInt("skinId", -1), localJSONObject.optInt("redPackType", -1));
        if (TextUtils.isEmpty(str)) {
          break label266;
        }
        this.jdField_c_of_type_JavaUtilHashMap.put(str, localJSONObject);
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      localObject3 = null;
    }
    label176:
    return localObject3;
    label184:
    label187:
    if (this.jdField_c_of_type_JavaUtilHashMap != null)
    {
      localObject6 = genMatchKeys(paramInt1, paramInt2);
      paramInt2 = localObject6.length;
      paramInt1 = j;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject5 = localObject6[paramInt1];
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label273;
          }
          localObject5 = (JSONObject)this.jdField_c_of_type_JavaUtilHashMap.get(localObject5);
          localObject3 = localObject5;
          if (localObject5 == null) {
            break label273;
          }
          return localObject5;
        }
        catch (Throwable localThrowable2) {}
        break label176;
      }
      return localObject3;
      label264:
      return null;
      label266:
      i += 1;
      break;
      label273:
      paramInt1 += 1;
    }
  }
  
  public ThemeRedPkgConfig getThemeRedPkgConfById(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return null;
      try
      {
        localObject1 = QWalletTools.a();
        if (localObject1 != null)
        {
          localObject1 = ((QWalletConfigManager)((QQAppInterface)localObject1).getManager(244)).a("redPackPanel", new String[] { "panelRedPkgList" });
          if (localObject1 != null)
          {
            int j = ((JSONArray)localObject1).length();
            if (j > 0)
            {
              i = 0;
              if (i < j)
              {
                localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                if ((localObject2 == null) || (((JSONObject)localObject2).optInt("type", -1) != 3)) {
                  break label501;
                }
                localJSONObject = ((JSONObject)localObject2).optJSONObject("params");
                if (localJSONObject == null) {
                  break label501;
                }
                k = localJSONObject.optInt("theme_id", -1);
                if (paramInt != k) {
                  break label501;
                }
                localObject2 = new ThemeRedPkgConfig();
              }
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          int i;
          try
          {
            Object localObject2;
            JSONObject localJSONObject;
            int k;
            ((ThemeRedPkgConfig)localObject2).jdField_a_of_type_Int = k;
            ((ThemeRedPkgConfig)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.optString("name", "");
            ((ThemeRedPkgConfig)localObject2).g = localJSONObject.optString("begintime", "");
            ((ThemeRedPkgConfig)localObject2).h = localJSONObject.optString("endtime", "");
            ((ThemeRedPkgConfig)localObject2).jdField_c_of_type_Int = localJSONObject.optInt("entry", 0);
            ((ThemeRedPkgConfig)localObject2).jdField_b_of_type_Int = localJSONObject.optInt("resource_type", 0);
            if (!isValidDate(((ThemeRedPkgConfig)localObject2).g, ((ThemeRedPkgConfig)localObject2).h)) {
              break;
            }
            Object localObject4 = localJSONObject.optString("prefix", "");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
            }
            ((ThemeRedPkgConfig)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1 + k);
            ((ThemeRedPkgConfig)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1 + k + "_bg");
            ((ThemeRedPkgConfig)localObject2).jdField_d_of_type_JavaLangString = localJSONObject.optString("tail_word", "");
            ((ThemeRedPkgConfig)localObject2).jdField_e_of_type_JavaLangString = localJSONObject.optString("tail_color", "");
            ((ThemeRedPkgConfig)localObject2).f = localJSONObject.optString("tail_url", "");
            localObject1 = localJSONObject.optJSONObject("c2c");
            if (localObject1 != null)
            {
              ((ThemeRedPkgConfig)localObject2).jdField_a_of_type_OrgJsonJSONArray = ((JSONObject)localObject1).optJSONArray("wish_array");
              ((ThemeRedPkgConfig)localObject2).jdField_b_of_type_OrgJsonJSONArray = ((JSONObject)localObject1).optJSONArray("money_array");
            }
            localObject4 = localJSONObject.optJSONObject("group");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              ((ThemeRedPkgConfig)localObject2).jdField_c_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_wish_array");
              ((ThemeRedPkgConfig)localObject2).jdField_d_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_money_array");
              ((ThemeRedPkgConfig)localObject2).jdField_e_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_total_num_array");
              localObject1 = localObject2;
            }
            return localObject1;
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localThrowable1;
            Object localObject3 = localThrowable2;
            continue;
          }
          localThrowable1 = localThrowable1;
          Object localObject1 = null;
          localThrowable1.printStackTrace();
          continue;
          localObject1 = null;
          continue;
          label501:
          i += 1;
        }
      }
    }
  }
  
  public void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {}
    for (;;)
    {
      return;
      try
      {
        QQAppInterface localQQAppInterface = QWalletTools.a();
        if (localQQAppInterface != null)
        {
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 6;
          localRedPacketInfo.templateId = paramRedPacketInfoBase.templateId;
          paramRedPacketInfoBase = CustomizeStrategyFactory.a().a(localQQAppInterface, localRedPacketInfo, new xdt(this, paramOnGetSkinListener));
          if (paramRedPacketInfoBase != null)
          {
            paramOnGetSkinListener.onGetSkin(paramRedPacketInfoBase);
            return;
          }
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public boolean isRiskSwitchOpen()
  {
    try
    {
      QQAppInterface localQQAppInterface = QWalletTools.a();
      if (localQQAppInterface != null)
      {
        if (((QWalletConfigManager)localQQAppInterface.getManager(244)).a("redPack", 0, new String[] { "riskSwitch" }) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketManager", 2, "isRiskSwitchOpen = " + bool);
          }
          return bool;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onActiveAccount()
  {
    if (this.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onUpdate(int paramInt)
  {
    if (paramInt == 1) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (this.d != null)
        {
          this.d.clear();
          this.d = null;
        }
        if (this.jdField_c_of_type_JavaUtilHashMap != null)
        {
          this.jdField_c_of_type_JavaUtilHashMap.clear();
          this.jdField_c_of_type_JavaUtilHashMap = null;
        }
        return;
      }
    }
  }
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_b_of_type_MqqObserverBusinessObserver = paramBusinessObserver;
  }
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener)
  {
    if ((paramOnGetAvailableListListener == null) || (TextUtils.isEmpty(paramString)) || ((paramInt != 1) && (paramInt != 3000))) {}
    do
    {
      return;
      localObject = QWalletTools.a();
    } while (localObject == null);
    String str;
    if (paramInt == 1)
    {
      paramInt = 1;
      str = ((QQAppInterface)localObject).c();
      localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
      if (localObject == null) {
        break label196;
      }
    }
    label196:
    for (Object localObject = ((TicketManager)localObject).getSkey(str);; localObject = "")
    {
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
      paramOnGetAvailableListListener = new SoftReference(paramOnGetAvailableListListener);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString + "_" + paramInt, paramOnGetAvailableListListener);
      paramOnGetAvailableListListener = new GetGroupRedPackListReq();
      paramOnGetAvailableListListener.sGroupUin = paramString;
      paramOnGetAvailableListListener.iPlatForm = 1;
      paramOnGetAvailableListListener.sQQVersion = DeviceInfoUtil.a(BaseApplicationImpl.getApplication());
      paramOnGetAvailableListListener.iGroupType = paramInt;
      paramOnGetAvailableListListener.sUin = str;
      paramOnGetAvailableListListener.sSkey = ((String)localObject);
      QWalletCommonServlet.a(paramOnGetAvailableListListener, this.jdField_a_of_type_MqqObserverBusinessObserver);
      NotifyMsgManager.a();
      return;
      paramInt = 2;
      break;
    }
  }
  
  public void requestRedPacketSkinList()
  {
    try
    {
      QQAppInterface localQQAppInterface = QWalletTools.a();
      if (localQQAppInterface != null)
      {
        if (this.jdField_b_of_type_MqqObserverBusinessObserver == null) {
          return;
        }
        ThreadManager.post(new xdn(this, localQQAppInterface), 5, null, false);
        QWalletCommonServlet.a(new GetSkinListReq(localQQAppInterface.getLongAccountUin(), 0, "7.6.0", "Android", Build.MODEL), new xdp(this, localQQAppInterface));
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketManager", 2, "requestRedPacketSkinList");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if ((localQQAppInterface == null) || (paramBusinessObserver == null)) {}
    do
    {
      return;
      QWalletCommonServlet.a(new SetSelectedSkinReq(localQQAppInterface.getLongAccountUin(), 0, "7.6.0", "Android", Build.MODEL, paramInt), new xdr(this, paramBusinessObserver));
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "setSelectedSkin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager
 * JD-Core Version:    0.7.0.1
 */