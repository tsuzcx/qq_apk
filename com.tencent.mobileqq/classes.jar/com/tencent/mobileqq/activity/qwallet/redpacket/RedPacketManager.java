package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetSkinListReq;
import Wallet.RedPackGrapInfo;
import Wallet.SetSelectedSkinReq;
import aiul;
import aivh;
import aixs;
import aizv;
import aizw;
import ajbs;
import ajbt;
import ajbw;
import ajbx;
import ajby;
import ajbz;
import ajca;
import ajcb;
import ajcc;
import ajce;
import ajeu;
import alud;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import bdgk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

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
  public static List<ajbs> CURRENT_PANEL_DATA = new ArrayList();
  public static final String FILE_SKINS = "skins";
  public static final int FLAG_DEFAULT_REDPKG = 1;
  public static final int FLAG_LOCK_TEXT_REDPKG = 4;
  public static final int FLAG_LOCK_VOICE_REDPKG = 8;
  public static final int FLAG_LUCK_REDPKG = 2;
  public static final String TAG = "RedPacketManager";
  public static final Map<Integer, Integer> TYPEHBINFOMAP;
  public static final int TYPE_CLEAR_CACHE = 1;
  public static final int TYPE_DEFAULT_REDPKG = 0;
  public static final int TYPE_DRAW_REDPKG = 10;
  public static final int TYPE_ENOJI_REDPKG = 8;
  public static final int TYPE_EXCLUSIVE_REDPKG = 11;
  public static final int TYPE_F2F_REDPKG = 5;
  public static final int TYPE_GOLD_REDPKG = 12;
  public static final int TYPE_H5_REDPKG = 4;
  public static final int TYPE_IDIOM_REDPACKET = 9;
  public static final int TYPE_KSONG_REDPKG = 7;
  public static final int TYPE_LOCK_TEXT_REDPKG = 2;
  public static final int TYPE_LOCK_VOICE_REDPKG = 6;
  public static final int TYPE_LUCK_REDPKG = 1;
  public static final int TYPE_MINIAPP_REDPKG = 13;
  public static final int TYPE_THEME_REDPKG = 3;
  static HashMap<Integer, ajbs> jdField_a_of_type_JavaUtilHashMap;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private List<BusinessObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected BusinessObserver a;
  protected HashMap<String, IRedPacket.OnGetAvailableListListener> b;
  private HashMap<String, JSONObject> c;
  private HashMap<String, JSONObject> d;
  
  static
  {
    TYPEHBINFOMAP = new RedPacketManager.1();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), new ajbs("", 0, alud.a(2131713699), "1102", "", "#5B6175"));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), new ajbs("", 1, alud.a(2131713711), "1101", "", "#5B6175"));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new ajbs("", 6, alud.a(2131713701), "1292", "", "#5B6175"));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), new ajbs("", 2, alud.a(2131713688), "1293", "", "#5B6175"));
  }
  
  public RedPacketManager()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new ajca(this);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 101;
  }
  
  private static boolean b(int paramInt)
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
  
  public static int getEnterType(int paramInt)
  {
    Iterator localIterator = TYPEHBINFOMAP.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator.next();
      Integer localInteger2 = (Integer)TYPEHBINFOMAP.get(localInteger1);
      if ((localInteger2 != null) && (localInteger2.intValue() == paramInt)) {
        return localInteger1.intValue();
      }
    }
    return 1;
  }
  
  public static IRedPacket getInstance()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return ajcb.a;
    }
    return ajcc.a;
  }
  
  public static boolean isBulletinValidDate(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    long l1 = ajeu.b(paramString1);
    long l2 = ajeu.b(paramString2);
    boolean bool1 = bool2;
    if (l1 != -1L)
    {
      bool1 = bool2;
      if (l2 != -1L)
      {
        bool1 = bool2;
        if (l1 < l2)
        {
          long l3 = NetConnInfoCenter.getServerTimeMillis();
          bool1 = bool2;
          if (l3 >= l1)
          {
            bool1 = bool2;
            if (l3 <= l2) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isValidDate(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = ajeu.b(paramString1);
    long l3 = ajeu.b(paramString2);
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
  
  public static boolean verifyDrawHbParams(ajbs paramajbs)
  {
    return (paramajbs != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subjects") != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subjects").length() > 0);
  }
  
  public static boolean verifyEmojiHbParams(ajbs paramajbs)
  {
    return (paramajbs != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList") != null) && (paramajbs.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList").length() != 0);
  }
  
  public static boolean verifyLingBySession(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo == null) || (!ChatActivityUtils.a(paramSessionInfo.jdField_a_of_type_Int));
  }
  
  public static boolean verifyLuckBySession(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo == null) || (b(paramSessionInfo.jdField_a_of_type_Int));
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, boolean paramBoolean)
  {
    if (paramOnGetAvailableListListener == null) {}
    label247:
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
      Object localObject1 = aizw.a(2);
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
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              if (localObject1 != null)
              {
                j = 0;
                for (;;)
                {
                  if (j >= ((ArrayList)localObject1).size()) {
                    break label247;
                  }
                  aizv localaizv = (aizv)((ArrayList)localObject1).get(j);
                  if ((localaizv != null) && (localaizv.jdField_a_of_type_JavaLangString != null) && (localaizv.jdField_a_of_type_JavaLangString.equals(localObject2)))
                  {
                    paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
                    break;
                  }
                  j += 1;
                }
              }
            }
            else {
              paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
            }
          }
        }
      }
      paramOnGetAvailableListListener.OnGetAvailableList(paramGetGroupRedPackListRsp.vecRedPackList);
      localObject1 = ajeu.a();
      paramOnGetAvailableListListener = null;
      if (localObject1 != null) {
        paramOnGetAvailableListListener = (aiul)((QQAppInterface)localObject1).getManager(125);
      }
      if (paramOnGetAvailableListListener != null)
      {
        int k = 0;
        if (k < paramGetGroupRedPackListRsp.vecRedPackList.size())
        {
          localObject1 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(k);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((RedPackGrapInfo)localObject1).sBiilNo)) && ((((RedPackGrapInfo)localObject1).iMsgType == 6) || (((RedPackGrapInfo)localObject1).iMsgType == 13) || (((RedPackGrapInfo)localObject1).iMsgType == 15) || (((RedPackGrapInfo)localObject1).iMsgType == 18) || (((RedPackGrapInfo)localObject1).iMsgType == 19) || (((RedPackGrapInfo)localObject1).iMsgType == 21) || (((RedPackGrapInfo)localObject1).iMsgType == 22)) && (paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo) == null))
          {
            if (paramInt != 1) {
              break label530;
            }
            j = 1;
            i = 0;
            if ((((RedPackGrapInfo)localObject1).iMsgType != 13) && (((RedPackGrapInfo)localObject1).iMsgType != 15)) {
              break label547;
            }
            i = 1;
          }
          for (;;)
          {
            paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo, ((RedPackGrapInfo)localObject1).sIndex, ((RedPackGrapInfo)localObject1).sTitle, String.valueOf(((RedPackGrapInfo)localObject1).lUin), ((RedPackGrapInfo)localObject1).lCreateTime + 90000L, String.valueOf(j), paramString2, ((RedPackGrapInfo)localObject1).sAuthKey, false, false, i);
            k += 1;
            break;
            if (paramInt == 2)
            {
              j = 2;
              break label443;
            }
            j = 3;
            break label443;
            if (((RedPackGrapInfo)localObject1).iMsgType == 18) {
              i = 2;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 19) {
              i = 3;
            } else if ((((RedPackGrapInfo)localObject1).iMsgType == 21) || (((RedPackGrapInfo)localObject1).iMsgType == 24)) {
              i = 4;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 22) {
              i = 5;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 23) {
              i = 6;
            }
          }
        }
      }
    } while (!paramBoolean);
    label443:
    ThreadManager.getFileThreadHandler().post(new RedPacketManager.8(this, paramGetGroupRedPackListRsp, paramString1, paramString2, paramInt));
    label530:
    label547:
    return;
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
        paramBundle = ajeu.a();
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
      if (this.b != null)
      {
        localObject1 = localObject2;
        if (this.b.get(paramBundle + "_" + j) != null) {
          localObject1 = (IRedPacket.OnGetAvailableListListener)this.b.get(paramBundle + "_" + j);
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
      ThreadManager.getFileThreadHandler().post(new RedPacketManager.7(this, str, paramBundle, j));
      return;
    }
    a(str, paramBundle, j, (IRedPacket.OnGetAvailableListListener)localObject1, localGetGroupRedPackListRsp, true);
  }
  
  public List<ajbs> getPanelList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int n;
    for (int j = 0;; j = n)
    {
      int m;
      for (;;)
      {
        try
        {
          Object localObject1 = ajeu.a();
          i = k;
          if (localObject1 == null) {
            continue;
          }
          Object localObject2 = (aixs)((QQAppInterface)localObject1).getManager(245);
          localObject1 = ((aixs)localObject2).a("redPackPanel", new String[] { "panelRedPkgList" });
          localObject2 = ((aixs)localObject2).a("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
          i = k;
          if (localObject1 == null) {
            continue;
          }
          j = 0;
          m = 0;
          k = j;
          i = j;
          try
          {
            if (m >= ((JSONArray)localObject1).length()) {
              continue;
            }
            k = j;
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(m);
            if (localJSONObject == null)
            {
              n = j;
            }
            else
            {
              k = j;
              localajbs = new ajbs();
              k = j;
              localajbs.jdField_a_of_type_JavaLangString = localJSONObject.optString("id", "");
              k = j;
              localajbs.jdField_a_of_type_Int = localJSONObject.optInt("type", -1);
              k = j;
              localajbs.jdField_b_of_type_JavaLangString = localJSONObject.optString("name", "");
              k = j;
              localajbs.jdField_c_of_type_JavaLangString = localJSONObject.optString("icon_pic", "");
              k = j;
              localajbs.jdField_e_of_type_JavaLangString = ((String)localObject2);
              k = j;
              localajbs.jdField_a_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("params");
              k = j;
              if (QLog.isColorLevel())
              {
                k = j;
                QLog.i("RedPacketManager", 2, "panelData: " + localajbs);
              }
              k = j;
              if (localajbs.jdField_a_of_type_Int == 0)
              {
                i = j | 0x1;
                k = i;
                if (localajbs.jdField_a_of_type_OrgJsonJSONObject != null) {
                  continue;
                }
                k = i;
                localArrayList.add(localajbs);
                n = i;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            i = k;
          }
        }
        catch (Throwable localThrowable2)
        {
          ajbs localajbs;
          int i1;
          int i = j;
          continue;
        }
        localThrowable1.printStackTrace();
        if (((i & 0x8) != 8) && (verifyLingBySession(paramSessionInfo))) {
          localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(6)));
        }
        if (((i & 0x4) != 4) && (verifyLingBySession(paramSessionInfo))) {
          localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2)));
        }
        if ((i & 0x1) != 1) {
          localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)));
        }
        if (((i & 0x2) != 2) && (verifyLuckBySession(paramSessionInfo))) {
          localArrayList.add(0, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)));
        }
        return localArrayList;
        if (paramSessionInfo != null)
        {
          k = j;
          n = j;
          if (ChatActivityUtils.a(paramSessionInfo.jdField_a_of_type_Int)) {
            break label964;
          }
        }
        k = j;
        if (localajbs.jdField_a_of_type_Int == 1)
        {
          k = j;
          n = j;
          if (!verifyLuckBySession(paramSessionInfo)) {
            break label964;
          }
          i = j | 0x2;
        }
        else
        {
          k = j;
          if (localajbs.jdField_a_of_type_Int == 2)
          {
            k = j;
            n = j;
            if (!verifyLingBySession(paramSessionInfo)) {
              break label964;
            }
            i = j | 0x4;
          }
          else
          {
            k = j;
            if (localajbs.jdField_a_of_type_Int == 6)
            {
              k = j;
              n = j;
              if (!verifyLingBySession(paramSessionInfo)) {
                break label964;
              }
              i = j | 0x8;
            }
            else
            {
              k = j;
              if (localajbs.jdField_a_of_type_Int == 3)
              {
                k = j;
                n = j;
                if (localajbs.jdField_a_of_type_OrgJsonJSONObject == null) {
                  break label964;
                }
                k = j;
                i = localajbs.jdField_a_of_type_OrgJsonJSONObject.optInt("entry", 0);
                k = j;
                i1 = localajbs.jdField_a_of_type_OrgJsonJSONObject.optInt("theme_id", 0);
                n = j;
                if (i < 0) {
                  break label964;
                }
                n = j;
                if (i > 1) {
                  break label964;
                }
                n = j;
                if (i1 < 2) {
                  break label964;
                }
                i = j;
                if (i1 > 127)
                {
                  n = j;
                  break label964;
                }
              }
              else
              {
                k = j;
                if (localajbs.jdField_a_of_type_Int == 4)
                {
                  k = j;
                  n = j;
                  if (localajbs.jdField_a_of_type_OrgJsonJSONObject == null) {
                    break label964;
                  }
                  i = j;
                  k = j;
                  if (TextUtils.isEmpty(localajbs.jdField_a_of_type_OrgJsonJSONObject.optString("url")))
                  {
                    n = j;
                    break label964;
                  }
                }
                else
                {
                  k = j;
                  if (localajbs.jdField_a_of_type_Int == 8)
                  {
                    i = j;
                    k = j;
                    if (!verifyEmojiHbParams(localajbs))
                    {
                      n = j;
                      break label964;
                    }
                  }
                  else
                  {
                    k = j;
                    if (localajbs.jdField_a_of_type_Int == 10)
                    {
                      i = j;
                      k = j;
                      if (!verifyDrawHbParams(localajbs))
                      {
                        n = j;
                        break label964;
                      }
                    }
                    else
                    {
                      k = j;
                      if (localajbs.jdField_a_of_type_Int == 11)
                      {
                        i = j;
                        if (paramSessionInfo != null)
                        {
                          i = j;
                          k = j;
                          if (!b(paramSessionInfo.jdField_a_of_type_Int))
                          {
                            n = j;
                            break label964;
                          }
                        }
                      }
                      else
                      {
                        i = j;
                        k = j;
                        if (localajbs.jdField_a_of_type_Int == 12)
                        {
                          k = j;
                          n = j;
                          if (localajbs.jdField_a_of_type_OrgJsonJSONObject == null) {
                            break label964;
                          }
                          i = j;
                          k = j;
                          if (TextUtils.isEmpty(localajbs.jdField_a_of_type_OrgJsonJSONObject.optString("schema")))
                          {
                            n = j;
                            break label964;
                            k = i;
                            n = i;
                            if (!isValidDate(localajbs.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localajbs.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", ""))) {
                              break label964;
                            }
                            k = i;
                            localArrayList.add(localajbs);
                            n = i;
                            break label964;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label964:
      m += 1;
    }
  }
  
  public List<ajbt> getPanelTabList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = b(paramSessionInfo.jdField_a_of_type_Int);
    for (;;)
    {
      int j;
      ajbt localajbt;
      int i;
      try
      {
        Object localObject1 = ajeu.a();
        if (localObject1 != null)
        {
          Object localObject2 = (aixs)((QQAppInterface)localObject1).getManager(245);
          localObject1 = ((aixs)localObject2).a("redPackPanel", new String[] { "panelTabList" });
          localObject2 = ((aixs)localObject2).a("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
          if (localObject1 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject1).length())
            {
              Object localObject3 = ((JSONArray)localObject1).getJSONObject(j);
              if ((localObject3 == null) || ((a(((JSONObject)localObject3).optInt("type", -1))) && (!bool))) {
                break label433;
              }
              localajbt = new ajbt();
              localajbt.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("id", "");
              localajbt.jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("type", -1);
              localajbt.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("name", "");
              localajbt.jdField_c_of_type_JavaLangString = ((String)localObject2);
              localajbt.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject3).optJSONObject("params");
              if ((localajbt.jdField_a_of_type_Int == 100) || (localajbt.jdField_a_of_type_Int == 102))
              {
                if (localajbt.jdField_a_of_type_OrgJsonJSONObject == null) {
                  break label433;
                }
                localObject3 = localajbt.jdField_a_of_type_OrgJsonJSONObject.optString("url");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label433;
                }
                if (localajbt.jdField_a_of_type_Int == 100)
                {
                  if (paramSessionInfo.jdField_a_of_type_Int != 1) {
                    break label368;
                  }
                  i = 1;
                  localObject3 = (String)localObject3 + "&type=" + i + "&uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
                  localajbt.jdField_a_of_type_OrgJsonJSONObject.put("url", localObject3);
                }
              }
              if (localajbt.jdField_a_of_type_OrgJsonJSONObject != null) {
                break label383;
              }
              localArrayList.add(localajbt);
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
        if (isValidDate(localajbt.jdField_a_of_type_OrgJsonJSONObject.optString("begintime", ""), localajbt.jdField_a_of_type_OrgJsonJSONObject.optString("endtime", ""))) {
          localArrayList.add(localajbt);
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
      ??? = ajeu.a();
      if (??? == null) {
        break label264;
      }
      localObject6 = (aixs)((QQAppInterface)???).getManager(245);
      if (this.d != null) {
        break label187;
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (this.d != null) {
          break label184;
        }
        localObject6 = ((aixs)localObject6).a("redPack", new String[] { "popAd" });
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
  
  public List<String> getReadyResList()
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
        Object localObject = ajeu.a();
        if (localObject != null)
        {
          WeakReference localWeakReference = new WeakReference(paramOnGetSkinListener);
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 5;
          localRedPacketInfo.skinType = paramRedPacketInfoBase.skinType;
          localRedPacketInfo.skinId = paramRedPacketInfoBase.skinId;
          localRedPacketInfo.bigAnimId = paramRedPacketInfoBase.bigAnimId;
          localRedPacketInfo.isCache = paramRedPacketInfoBase.isCache;
          localObject = CustomizeStrategyFactory.a().a((QQAppInterface)localObject, localRedPacketInfo, new ajby(this, paramRedPacketInfoBase, localWeakReference));
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
      ??? = ajeu.a();
      if (??? == null) {
        break label264;
      }
      localObject6 = (aixs)((QQAppInterface)???).getManager(245);
      if (this.c != null) {
        break label187;
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (this.c != null) {
          break label184;
        }
        localObject6 = ((aixs)localObject6).a("redPack", new String[] { "tail" });
        if (localObject6 == null) {
          break label184;
        }
        this.c = new HashMap();
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
        this.c.put(str, localJSONObject);
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
    if (this.c != null)
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
          localObject5 = (JSONObject)this.c.get(localObject5);
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
  
  public ajce getThemeRedPkgConfById(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return null;
      try
      {
        localObject1 = ajeu.a();
        if (localObject1 != null)
        {
          localObject1 = ((aixs)((QQAppInterface)localObject1).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
                localObject2 = new ajce();
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
            ((ajce)localObject2).jdField_a_of_type_Int = k;
            ((ajce)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.optString("name", "");
            ((ajce)localObject2).g = localJSONObject.optString("begintime", "");
            ((ajce)localObject2).h = localJSONObject.optString("endtime", "");
            ((ajce)localObject2).jdField_c_of_type_Int = localJSONObject.optInt("entry", 0);
            ((ajce)localObject2).jdField_b_of_type_Int = localJSONObject.optInt("resource_type", 0);
            if (!isValidDate(((ajce)localObject2).g, ((ajce)localObject2).h)) {
              break;
            }
            Object localObject4 = localJSONObject.optString("prefix", "");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
            }
            ((ajce)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1 + k);
            ((ajce)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1 + k + "_bg");
            ((ajce)localObject2).jdField_d_of_type_JavaLangString = localJSONObject.optString("tail_word", "");
            ((ajce)localObject2).jdField_e_of_type_JavaLangString = localJSONObject.optString("tail_color", "");
            ((ajce)localObject2).f = localJSONObject.optString("tail_url", "");
            localObject1 = localJSONObject.optJSONObject("c2c");
            if (localObject1 != null)
            {
              ((ajce)localObject2).jdField_a_of_type_OrgJsonJSONArray = ((JSONObject)localObject1).optJSONArray("wish_array");
              ((ajce)localObject2).jdField_b_of_type_OrgJsonJSONArray = ((JSONObject)localObject1).optJSONArray("money_array");
            }
            localObject4 = localJSONObject.optJSONObject("group");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              ((ajce)localObject2).jdField_c_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_wish_array");
              ((ajce)localObject2).jdField_d_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_money_array");
              ((ajce)localObject2).jdField_e_of_type_OrgJsonJSONArray = ((JSONObject)localObject4).optJSONArray("group_total_num_array");
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
        QQAppInterface localQQAppInterface = ajeu.a();
        if (localQQAppInterface != null)
        {
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 6;
          localRedPacketInfo.templateId = paramRedPacketInfoBase.templateId;
          paramRedPacketInfoBase = CustomizeStrategyFactory.a().a(localQQAppInterface, localRedPacketInfo, new ajbz(this, paramOnGetSkinListener));
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
      QQAppInterface localQQAppInterface = ajeu.a();
      if (localQQAppInterface != null)
      {
        if (((aixs)localQQAppInterface.getManager(245)).a("redPack", 0, new String[] { "riskSwitch" }) != 0) {}
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
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public boolean onGetThemeConfig(int paramInt)
  {
    return getThemeRedPkgConfById(paramInt) != null;
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
        if (this.c != null)
        {
          this.c.clear();
          this.c = null;
        }
        return;
      }
    }
  }
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
    }
  }
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener)
  {
    if ((paramOnGetAvailableListListener == null) || (TextUtils.isEmpty(paramString)) || ((paramInt != 1) && (paramInt != 3000))) {}
    do
    {
      return;
      localObject = ajeu.a();
    } while (localObject == null);
    String str;
    if (paramInt == 1)
    {
      paramInt = 1;
      str = ((QQAppInterface)localObject).c();
      localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (Object localObject = ((TicketManager)localObject).getSkey(str);; localObject = "")
    {
      if (this.b == null) {
        this.b = new HashMap();
      }
      this.b.put(paramString + "_" + paramInt, paramOnGetAvailableListListener);
      paramOnGetAvailableListListener = new GetGroupRedPackListReq();
      paramOnGetAvailableListListener.sGroupUin = paramString;
      paramOnGetAvailableListListener.iPlatForm = 1;
      paramOnGetAvailableListListener.sQQVersion = bdgk.a(BaseApplicationImpl.getApplication());
      paramOnGetAvailableListListener.iGroupType = paramInt;
      paramOnGetAvailableListListener.sUin = str;
      paramOnGetAvailableListListener.sSkey = ((String)localObject);
      aivh.a(paramOnGetAvailableListListener, this.jdField_a_of_type_MqqObserverBusinessObserver);
      aizw.a();
      return;
      paramInt = 2;
      break;
    }
  }
  
  public void requestRedPacketSkinList()
  {
    requestRedPacketSkinList("", "", 0);
  }
  
  public void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = ajeu.a();
      if (localQQAppInterface != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          return;
        }
        ThreadManager.post(new RedPacketManager.2(this, localQQAppInterface), 5, null, false);
        aivh.a(new GetSkinListReq(localQQAppInterface.getLongAccountUin(), 0, "8.3.5", "Android", Build.MODEL, paramString2, paramString1, paramInt), new ajbw(this, paramString1, localQQAppInterface));
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketManager", 2, "requestRedPacketSkinList");
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = ajeu.a();
    if ((localQQAppInterface == null) || (paramBusinessObserver == null)) {}
    do
    {
      return;
      aivh.a(new SetSelectedSkinReq(localQQAppInterface.getLongAccountUin(), 0, "8.3.5", "Android", Build.MODEL, paramInt), new ajbx(this, paramBusinessObserver));
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "setSelectedSkin2ServerIfChanged");
  }
  
  public void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager
 * JD-Core Version:    0.7.0.1
 */