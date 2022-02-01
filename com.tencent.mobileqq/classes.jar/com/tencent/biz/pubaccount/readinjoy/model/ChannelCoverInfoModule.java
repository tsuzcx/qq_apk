package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.readinjoy.channelCover.RIJMainChannelUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;>;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.RspBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.PhoneInfo;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.ReqBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.RspBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgGetChannelInfoRsp;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.PhoneInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.ReqBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.RspBody;

public class ChannelCoverInfoModule
  extends ChannelInfoModule
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<Integer, List<ChannelCoverInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<ChannelSection> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int = 0;
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public ChannelCoverInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  public static int a()
  {
    return RIJMainChannelUtil.a.a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Int;
    }
    if (paramInt == 56) {
      return this.jdField_b_of_type_Int;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      if (paramInt == 0) {
        i = paramQQAppInterface.getInt("readInJoy_mian_channel_cover_seq", 0);
      }
    }
    else {
      return i;
    }
    if (paramInt == 56) {
      return paramQQAppInterface.getInt("readInJoy_video_channel_cover_seq", 0);
    }
    return paramQQAppInterface.getInt("readInJoy_sub_channel_cover_seq" + paramInt, 0);
  }
  
  private ChannelCoverInfo a(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = null;
    localObject2 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
        return localChannelCoverInfo;
      }
      finally {}
      if (paramInt2 == 56) {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
      } else if (paramInt2 == 41402) {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
      } else if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt2))) {
        localChannelCoverInfo = a(paramInt1, (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt2)));
      }
    }
  }
  
  private ChannelCoverInfo a(int paramInt, List<ChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (localChannelCoverInfo.mChannelCoverId == paramInt) {
          return localChannelCoverInfo;
        }
      }
    }
    return null;
  }
  
  private static TabChannelCoverInfo a()
  {
    int i;
    if (a() != -1) {
      i = a();
    }
    for (;;)
    {
      Object localObject;
      String str;
      if (!TextUtils.isEmpty(a()))
      {
        localObject = a();
        localObject = new TabChannelCoverInfo(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, i, (String)localObject, 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0");
        str = b();
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        ((TabChannelCoverInfo)localObject).mChannelJumpUrl = URLDecoder.decode(str, "UTF-8");
        QLog.i("ChannelCoverInfoModule", 1, "[getMainChannelInfo], channelCoverInfo = " + localObject);
        return localObject;
        i = 0;
        continue;
        localObject = HardCodeUtil.a(2131701585);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QLog.e("ChannelCoverInfoModule", 1, "[getMainChannelInfo], e = " + localUnsupportedEncodingException);
        }
      }
    }
  }
  
  public static String a()
  {
    return RIJMainChannelUtil.a.a();
  }
  
  private List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = ((TabChannelCoverInfo)paramList.next()).clone();
        localTabChannelCoverInfo.channelConfigType = paramInt;
        localTabChannelCoverInfo.seq = i;
        localArrayList.add(localTabChannelCoverInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
    }
    if (paramInt1 == 56)
    {
      this.jdField_b_of_type_Int = paramInt2;
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (paramInt == 41402)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        ((List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).add(paramChannelCoverInfo);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramChannelCoverInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      if (paramInt2 != 0) {
        break label106;
      }
      paramQQAppInterface.putInt("readInJoy_mian_channel_cover_seq", paramInt1);
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, seq =" + paramInt1 + " ;channelId = " + paramInt2);
      }
      return;
      label106:
      if (paramInt2 == 56) {
        paramQQAppInterface.putInt("readInJoy_video_channel_cover_seq", paramInt1);
      } else {
        paramQQAppInterface.putInt("readInJoy_sub_channel_cover_seq" + paramInt2, paramInt1);
      }
    }
  }
  
  public static void a(List<TabChannelCoverInfo> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("ChannelCoverInfoModule", 1, new Object[] { paramString + " tabChannelCoverInfo [", Integer.valueOf(i), "]: ", ((TabChannelCoverInfo)paramList.get(i)).shortLogString() });
        i += 1;
      }
    }
  }
  
  private void a(List<ChannelSection> paramList1, List<ChannelSection> paramList2)
  {
    SparseArray localSparseArray = new SparseArray();
    paramList2 = paramList2.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList2.hasNext())
    {
      localObject1 = ((ChannelSection)paramList2.next()).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TabChannelCoverInfo)((Iterator)localObject1).next();
        localSparseArray.put(((TabChannelCoverInfo)localObject2).mChannelCoverId, localObject2);
      }
    }
    paramList2 = paramList1.iterator();
    if (paramList2.hasNext())
    {
      localObject1 = (ChannelSection)paramList2.next();
      localObject2 = ((ChannelSection)localObject1).jdField_a_of_type_JavaUtilList.iterator();
      label272:
      label285:
      label291:
      label296:
      label300:
      for (;;)
      {
        label120:
        TabChannelCoverInfo localTabChannelCoverInfo1;
        TabChannelCoverInfo localTabChannelCoverInfo2;
        label205:
        int i;
        if (((Iterator)localObject2).hasNext())
        {
          localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject2).next();
          localTabChannelCoverInfo2 = (TabChannelCoverInfo)localSparseArray.get(localTabChannelCoverInfo1.mChannelCoverId);
          if (localTabChannelCoverInfo2 != null)
          {
            if (localTabChannelCoverInfo1.redPoint == null) {
              break label272;
            }
            if ((!localTabChannelCoverInfo1.redPoint.a) && (localTabChannelCoverInfo2.redPoint != null)) {
              localTabChannelCoverInfo1.redPoint.a = localTabChannelCoverInfo2.redPoint.a;
            }
          }
          if (!ChannelModeConfigHandler.a()) {
            break label285;
          }
          i = 11;
          label214:
          if ((paramList1.indexOf(localObject1) != 0) || (((ChannelSection)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localTabChannelCoverInfo1) >= i)) {
            break label291;
          }
          i = 1;
          label243:
          if (RIJChannelHelper.a(localTabChannelCoverInfo1) == -1) {
            break label296;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (i != 0)) {
            break label300;
          }
          a(true);
          break label120;
          break;
          localTabChannelCoverInfo1.redPoint = localTabChannelCoverInfo2.redPoint;
          break label205;
          i = 6;
          break label214;
          i = 0;
          break label243;
        }
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_c_of_type_Int < 3)
    {
      this.jdField_c_of_type_Int += 1;
      return true;
    }
    this.jdField_c_of_type_Int = 0;
    ReadInJoyHelper.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (!((Boolean)ReadInJoyHelper.a("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, switch is off.");
      return false;
    }
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject1 != null)
    {
      localObject1 = (ReadInJoyLogicManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject1 != null)
      {
        localObject1 = ((ReadInJoyLogicManager)localObject1).a().a();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          TabChannelCoverInfo localTabChannelCoverInfo;
          do
          {
            localObject1 = ((List)localObject1).iterator();
            Object localObject2;
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = ((ChannelSection)((Iterator)localObject1).next()).jdField_a_of_type_JavaUtilList;
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
            localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject2).next();
          } while (localTabChannelCoverInfo.mChannelCoverId != paramInt);
          QLog.d("ChannelCoverInfoModule", 1, new Object[] { "isSupportChannelDynamicOrder, name = ", localTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramInt), ", dynamicSort = ", Integer.valueOf(localTabChannelCoverInfo.dynamicSort) });
          if (localTabChannelCoverInfo.dynamicSort == 1) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      }
    }
    QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, channel dynamic order is off.");
    return false;
  }
  
  private boolean a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo == null) {
      return false;
    }
    paramChannelCoverInfo = paramChannelCoverInfo.clone();
    a(paramChannelCoverInfo, paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.3(this, paramChannelCoverInfo));
    return true;
  }
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramList.size())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
        if ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != paramTabChannelCoverInfo.mChannelCoverId) || (localTabChannelCoverInfo.mChannelId != paramTabChannelCoverInfo.mChannelId)) {}
      }
      else
      {
        try
        {
          paramList.set(i, paramTabChannelCoverInfo);
          bool1 = true;
          return bool1;
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          for (;;)
          {
            QLog.e("ChannelCoverInfoModule", 1, "findAndReplaceChannel channelCoverInfoList error!!,index:" + i + " size:channelCoverInfoList.size(),msg:" + paramTabChannelCoverInfo.toString());
          }
        }
      }
      i += 1;
    }
  }
  
  private static String b()
  {
    return RIJMainChannelUtil.a.b();
  }
  
  private List<TabChannelCoverInfo> b(List<ChannelSection> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        ChannelSection localChannelSection = (ChannelSection)paramList.next();
        if ((localChannelSection.jdField_a_of_type_JavaUtilList == null) || (localChannelSection.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break label133;
        }
        Iterator localIterator = localChannelSection.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
          localTabChannelCoverInfo.channelConfigType = localChannelSection.jdField_a_of_type_Long;
          localTabChannelCoverInfo.seq = i;
          localArrayList.add(localTabChannelCoverInfo);
          i += 1;
        }
      }
    }
    label133:
    for (;;)
    {
      break;
      return localArrayList;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = a(paramInt1, paramInt2);
    if (localChannelCoverInfo != null)
    {
      QLog.i("ChannelCoverInfoModule", 1, "removeChannelCoverInfoFromDBAndCache channelID=" + paramInt2 + " ;channelCoverId = " + paramInt1);
      b(localChannelCoverInfo, paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.2(this, localChannelCoverInfo));
    }
  }
  
  private void b(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    Iterator localIterator;
    if (paramInt == 0) {
      label61:
      break label150;
    }
    for (;;)
    {
      try
      {
        localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
            break;
          }
          localIterator.remove();
        }
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (paramInt == 41402)
      {
        localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        label150:
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        ((List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).remove(paramChannelCoverInfo);
      }
    }
  }
  
  private void b(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramBoolean) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "notifyIndependentTabUIToRefresh, success = ", Integer.valueOf(i) });
    paramList = d(paramList);
    QLog.d("ChannelCoverInfoModule", 1, "notifyIndependentTabUIToRefresh, show channel list: ");
    a(paramList, "notifyIndependentTabUIToRefresh");
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ReadInJoyLogicEngineEventDispatcher.a().e(paramBoolean, paramList);
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.6(this, paramBoolean, paramList));
  }
  
  private List<ChannelCoverInfo> c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private List<ChannelSection> c(List<ChannelSection> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = (ChannelSection)paramList.next();
        ChannelSection localChannelSection = new ChannelSection(((ChannelSection)localObject).jdField_a_of_type_Long, ((ChannelSection)localObject).jdField_a_of_type_JavaLangString, ((ChannelSection)localObject).b);
        localObject = ((ChannelSection)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject).next();
          TabChannelCoverInfo localTabChannelCoverInfo2 = localTabChannelCoverInfo1.clone();
          localTabChannelCoverInfo2.channelConfigType = localTabChannelCoverInfo1.channelConfigType;
          localTabChannelCoverInfo2.seq = i;
          localChannelSection.jdField_a_of_type_JavaUtilList.add(localTabChannelCoverInfo2);
          i += 1;
        }
        localArrayList.add(localChannelSection);
      }
    }
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> d(List<TabChannelCoverInfo> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = paramList;
    if (paramList == null) {
      localObject2 = new ArrayList();
    }
    Iterator localIterator = ((List)localObject2).iterator();
    Object localObject4 = null;
    Object localObject3 = null;
    paramList = (List<TabChannelCoverInfo>)localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = (TabChannelCoverInfo)localIterator.next();
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 0) {
        localObject3 = localObject1;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 70) {
        localObject4 = localObject1;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId != a()) {
        break label178;
      }
    }
    for (;;)
    {
      paramList = (List<TabChannelCoverInfo>)localObject1;
      break;
      if (paramList != null)
      {
        QLog.d("ChannelCoverInfoModule", 1, "configMainChannel not null");
        ((List)localObject2).remove(paramList);
      }
      if (localObject3 != null)
      {
        QLog.d("ChannelCoverInfoModule", 1, "recommendChannel not null");
        ((List)localObject2).remove(localObject3);
      }
      ((List)localObject2).add(0, a());
      if (localObject4 != null)
      {
        QLog.d("ChannelCoverInfoModule", 1, "followChannel not null");
        ((List)localObject2).remove(localObject4);
        ((List)localObject2).add(0, localObject4);
      }
      return localObject2;
      label178:
      localObject1 = paramList;
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        localReqBody = new oidb_cmd0xbe6.ReqBody();
        localPhoneInfo = new oidb_cmd0xbe6.PhoneInfo();
        str = ReadInJoyUtils.b();
        if (!TextUtils.isEmpty(str))
        {
          str = MD5Utils.toMD5(str.toLowerCase()).toLowerCase();
          localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
          localPhoneInfo.uint32_muid_type.set(1);
          i = PublicAccountAdUtil.a();
          localPhoneInfo.uint32_conn.set(i);
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        oidb_cmd0xbe6.ReqBody localReqBody;
        oidb_cmd0xbe6.PhoneInfo localPhoneInfo;
        String str;
        int i;
        int j;
        QLog.e("ChannelCoverInfoModule", 2, "requestWeiShiChannelCoverListFromServer failed for param error:" + RIJAppSetting.a(localThrowable));
        return;
      }
      try
      {
        j = DeviceInfoUtil.f();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = DeviceInfoUtil.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = DeviceInfoUtil.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = DatalineMathUtil.a(DatalineMathUtil.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      localPhoneInfo.uint32_os_type.set(2);
      localReqBody.msg_phone_info.set(localPhoneInfo, true);
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localReqBody.string_channel_version.set(a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface));
      }
      a(ReadInJoyOidbHelper.a("OidbSvc.0xbe6", 3046, 1, localReqBody.toByteArray()));
      return;
      str = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(str))
      {
        str = MD5Utils.toMD5(str.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  private void g(List<ChannelSection> paramList)
  {
    if (paramList != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (ChannelSection)paramList.next();
          if (localObject != null)
          {
            localObject = ((ChannelSection)localObject).jdField_a_of_type_JavaUtilList;
            if (localObject != null)
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
                if (localTabChannelCoverInfo != null)
                {
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mIconUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mIconUrl, true).downloadImediatly();
                  }
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mChannelCoverPicUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mChannelCoverPicUrl, true).downloadImediatly();
                  }
                }
              }
            }
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("ChannelCoverInfoModule", 1, paramList.getMessage());
      }
    }
  }
  
  private List<ChannelCoverInfo> h()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> j()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<TabChannelCoverInfo> k()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(51, HardCodeUtil.a(2131701614)));
    localArrayList.add(new TabChannelCoverInfo(58, HardCodeUtil.a(2131701601)));
    localArrayList.add(new TabChannelCoverInfo(59, HardCodeUtil.a(2131701600)));
    localArrayList.add(new TabChannelCoverInfo(10, HardCodeUtil.a(2131701603)));
    localArrayList.add(new TabChannelCoverInfo(52, HardCodeUtil.a(2131701616)));
    localArrayList.add(new TabChannelCoverInfo(53, HardCodeUtil.a(2131701597)));
    localArrayList.add(new TabChannelCoverInfo(9, HardCodeUtil.a(2131701607)));
    localArrayList.add(new TabChannelCoverInfo(54, HardCodeUtil.a(2131701592)));
    localArrayList.add(new TabChannelCoverInfo(55, HardCodeUtil.a(2131701594)));
    localArrayList.add(new TabChannelCoverInfo(40007, HardCodeUtil.a(2131701596)));
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb");
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TabChannelCoverInfo.class);
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("readInJoy_weishi_channel_cover_seq", "");
  }
  
  /* Error */
  public List<TabChannelCoverInfo> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 446 1 0
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: iconst_0
    //   26: invokeinterface 298 2 0
    //   31: checkcast 311	com/tencent/biz/pubaccount/readinjoy/struct/ChannelSection
    //   34: getfield 312	com/tencent/biz/pubaccount/readinjoy/struct/ChannelSection:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ChannelCoverInfoModule
    //   37	7	1	localList	List
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  /* Error */
  public List<TabChannelCoverInfo> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 298 2 0
    //   19: checkcast 311	com/tencent/biz/pubaccount/readinjoy/struct/ChannelSection
    //   22: getfield 312	com/tencent/biz/pubaccount/readinjoy/struct/ChannelSection:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	ChannelCoverInfoModule
    //   0	40	1	paramInt	int
    //   25	7	2	localList	List
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "unInitialize!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "updateMainChannelCoverInfo, channelCoverId = " + paramInt + " ;articleTitle = " + paramString + " ;articleId = " + paramLong);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      if (localChannelCoverInfo != null)
      {
        localChannelCoverInfo.mChannelCoverSummary = paramString;
        localChannelCoverInfo.mArticleId = paramLong;
        a(localChannelCoverInfo, 0);
        f(h(), 0);
      }
      return;
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("updateChannel: ");
    if (paramTabChannelCoverInfo != null) {}
    for (Object localObject = paramTabChannelCoverInfo.toString();; localObject = "null")
    {
      QLog.d("ChannelCoverInfoModule", 2, (String)localObject);
      if (paramTabChannelCoverInfo == null) {
        return;
      }
      paramTabChannelCoverInfo = paramTabChannelCoverInfo.clone();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramTabChannelCoverInfo, ((ChannelSection)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList)) {
          QLog.d("ChannelCoverInfoModule", 2, "updateChannel found in channelCoverInfoList!");
        }
      }
    }
    ThreadManager.getFileThreadHandler().post(new ChannelCoverInfoModule.1(this, paramTabChannelCoverInfo));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("readInJoy_weishi_channel_cover_seq", paramString);
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, version =" + paramString);
      }
    }
  }
  
  public void a(List<channel_button.Section> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        QLog.d("ChannelCoverInfoModule", 1, "saveChannelSection null");
        return;
      }
      finally {}
      List localList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList.size());
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        channel_button.Section localSection = (channel_button.Section)paramList.next();
        ChannelSection localChannelSection = new ChannelSection(localSection);
        localJSONArray.put(localChannelSection.a());
        localChannelSection.jdField_a_of_type_JavaUtilList = ReadInJoyMSFHandlerUtils.b(localSection.rpt_msg_channel.get());
        this.jdField_a_of_type_JavaUtilList.add(localChannelSection);
        a(localChannelSection.jdField_a_of_type_JavaUtilList, "saveChannelSection " + localChannelSection.jdField_a_of_type_Long);
      }
      else
      {
        a(this.jdField_a_of_type_JavaUtilList, localList);
        c(this.jdField_a_of_type_JavaUtilList);
        a(localList, this.jdField_a_of_type_JavaUtilList, true);
        if (localJSONArray.length() > 0) {
          ThreadManager.executeOnFileThread(new ChannelCoverInfoModule.10(this, localJSONArray));
        }
      }
    }
  }
  
  public void a(List<ChannelSection> paramList, int paramInt)
  {
    QLog.d("ChannelCoverInfoModule", 1, "requestUpdateChannelLists. ");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.d("ChannelCoverInfoModule", 2, "mChannelSectionList is null, do not requestUpdateChannelLists.");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ChannelSection)((Iterator)localObject1).next();
        a(((ChannelSection)localObject2).jdField_a_of_type_JavaUtilList, "0xbbc update sectionId=" + ((ChannelSection)localObject2).jdField_a_of_type_Long);
      }
    }
    Object localObject1 = new oidb_cmd0xbbc.ReqBody();
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      ChannelSection localChannelSection = (ChannelSection)localIterator1.next();
      channel_button.Section localSection = new channel_button.Section();
      ArrayList localArrayList = new ArrayList();
      if (localChannelSection.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = localChannelSection.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator2.hasNext())
        {
          paramList = (TabChannelCoverInfo)localIterator2.next();
          channel_button.Channel localChannel = new channel_button.Channel();
          localChannel.uint64_channel_id.set(paramList.mChannelCoverId);
          localChannel.enum_reason.set(paramList.reason);
          PBStringField localPBStringField = localChannel.str_proxy;
          if (TextUtils.isEmpty(paramList.proxy)) {}
          for (paramList = "";; paramList = paramList.proxy)
          {
            localPBStringField.set(paramList);
            localArrayList.add(localChannel);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty())
      {
        localSection.uint64_section_id.set(localChannelSection.jdField_a_of_type_Long);
        localSection.str_section_name.set(localChannelSection.jdField_a_of_type_JavaLangString);
        localSection.str_note_text.set(localChannelSection.b);
        localSection.rpt_msg_channel.set(localArrayList);
        ((List)localObject2).add(localSection);
      }
    }
    ((oidb_cmd0xbbc.ReqBody)localObject1).rpt_msg_section.set((List)localObject2);
    paramList = new oidb_cmd0xbbc.PhoneInfo();
    localObject2 = ReadInJoyUtils.b();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = MD5Utils.toMD5(((String)localObject2).toLowerCase()).toLowerCase();
      paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = PublicAccountAdUtil.a();
      paramList.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.f();
        i = j;
      }
      catch (Exception localException)
      {
        label450:
        break label450;
      }
      paramList.uint32_carrier.set(i);
      localObject2 = DeviceInfoUtil.e();
      paramList.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = DeviceInfoUtil.c();
      paramList.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      paramList.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = DatalineMathUtil.a(DatalineMathUtil.a());
      paramList.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_os_type.set(2);
      ((oidb_cmd0xbbc.ReqBody)localObject1).msg_phone_type.set(paramList, true);
      ((oidb_cmd0xbbc.ReqBody)localObject1).uint32_set_type.set(paramInt);
      a(ReadInJoyOidbHelper.a("OidbSvc.0xbbc", 3004, 1, ((oidb_cmd0xbbc.ReqBody)localObject1).toByteArray()));
      ReadInJoyHelper.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(true));
      return;
      localObject2 = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = MD5Utils.toMD5(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
        paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        paramList.uint32_muid_type.set(3);
      }
    }
  }
  
  public void a(List<ChannelSection> paramList1, List<ChannelSection> paramList2, boolean paramBoolean)
  {
    if (paramList1 == null) {}
    try
    {
      QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] oldSectionList is null");
      if (paramList2 == null) {
        QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] sectionList is null");
      }
      paramList1 = b(paramList1);
      this.jdField_a_of_type_JavaUtilList = c(paramList2);
      paramList2 = b(this.jdField_a_of_type_JavaUtilList);
      if (paramBoolean) {
        b(true, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaUtilList);
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb remove oldList");
      localIterator = paramList1.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb save newList");
    }
    finally {}
    Iterator localIterator = paramList2.iterator();
    while (localIterator.hasNext()) {
      QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.9(this, paramList1, paramList2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.8(this, paramBoolean));
    }
  }
  
  public List<TabChannelCoverInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, 0, HardCodeUtil.a(2131701598), 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0"));
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo(56, HardCodeUtil.a(2131701609));
    localTabChannelCoverInfo.reason = 4;
    localTabChannelCoverInfo.mChannelType = 3;
    localArrayList.add(localTabChannelCoverInfo);
    localArrayList.add(new TabChannelCoverInfo(40531, HardCodeUtil.a(2131701611)));
    localArrayList.add(new TabChannelCoverInfo(14, HardCodeUtil.a(2131701595)));
    localArrayList.add(new TabChannelCoverInfo(8, HardCodeUtil.a(2131701613)));
    localArrayList.add(new TabChannelCoverInfo(1, HardCodeUtil.a(2131701602)));
    localArrayList.add(new TabChannelCoverInfo(13, HardCodeUtil.a(2131701588)));
    localArrayList.add(new TabChannelCoverInfo(5, HardCodeUtil.a(2131701618)));
    localArrayList.add(new TabChannelCoverInfo(11, HardCodeUtil.a(2131701587)));
    localArrayList.add(new TabChannelCoverInfo(40466, HardCodeUtil.a(2131701612)));
    localArrayList.add(new TabChannelCoverInfo(40013, HardCodeUtil.a(2131701610)));
    localArrayList.add(new TabChannelCoverInfo(16, HardCodeUtil.a(2131701605)));
    localArrayList.add(new TabChannelCoverInfo(15, HardCodeUtil.a(2131701591)));
    return localArrayList;
  }
  
  public List<ChannelCoverInfo> b(int paramInt)
  {
    List localList = null;
    if (paramInt == 0) {
      localList = h();
    }
    do
    {
      return localList;
      if (paramInt == 56) {
        return i();
      }
      if (paramInt == 41402) {
        return j();
      }
    } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)));
    return new ArrayList((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 65
    //   8: iconst_2
    //   9: ldc_w 989
    //   12: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: ldc_w 345
    //   18: iconst_0
    //   19: invokestatic 350	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: invokestatic 361	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 347	java/lang/Boolean
    //   28: invokevirtual 364	java/lang/Boolean:booleanValue	()Z
    //   31: ifeq +29 -> 60
    //   34: aload_0
    //   35: invokespecial 990	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:a	()Z
    //   38: ifeq +22 -> 60
    //   41: ldc 65
    //   43: iconst_2
    //   44: ldc_w 992
    //   47: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 57	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_3
    //   56: invokevirtual 994	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:a	(Ljava/util/List;I)V
    //   59: return
    //   60: getstatic 997	com/tencent/biz/pubaccount/readinjoy/ReadInJoyChannelViewPagerController:a	Z
    //   63: ifeq +13 -> 76
    //   66: ldc 65
    //   68: iconst_2
    //   69: ldc_w 999
    //   72: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: return
    //   76: invokestatic 1004	java/lang/System:currentTimeMillis	()J
    //   79: ldc2_w 1005
    //   82: ldiv
    //   83: aload_0
    //   84: getfield 52	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_Long	J
    //   87: lcmp
    //   88: iflt -29 -> 59
    //   91: new 1008	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody
    //   94: dup
    //   95: invokespecial 1009	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: getfield 1012	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: ldc_w 1014
    //   106: invokestatic 1020	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   109: checkcast 1014	com/tencent/mobileqq/soso/location/api/ILbsManagerServiceApi
    //   112: invokeinterface 1023 1 0
    //   117: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   120: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   123: aload_2
    //   124: getfield 1026	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:str_city	Lcom/tencent/mobileqq/pb/PBStringField;
    //   127: ldc_w 1014
    //   130: invokestatic 1020	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   133: checkcast 1014	com/tencent/mobileqq/soso/location/api/ILbsManagerServiceApi
    //   136: invokeinterface 1029 1 0
    //   141: invokevirtual 658	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 646	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   148: getstatic 1032	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   151: invokevirtual 1035	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   154: checkcast 1037	com/tencent/mobileqq/app/FriendsManager
    //   157: aload_0
    //   158: getfield 646	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   161: checkcast 101	com/tencent/mobileqq/app/QQAppInterface
    //   164: invokevirtual 1040	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   167: invokevirtual 1043	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   170: astore_3
    //   171: aload_3
    //   172: ifnull +25 -> 197
    //   175: aload_2
    //   176: getfield 1046	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: aload_3
    //   180: getfield 1051	com/tencent/mobileqq/data/Friends:age	I
    //   183: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   186: aload_2
    //   187: getfield 1054	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   190: aload_3
    //   191: getfield 1058	com/tencent/mobileqq/data/Friends:gender	B
    //   194: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: new 1060	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo
    //   200: dup
    //   201: invokespecial 1061	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:<init>	()V
    //   204: astore_3
    //   205: invokestatic 559	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:b	()Ljava/lang/String;
    //   208: astore 4
    //   210: aload 4
    //   212: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +330 -> 545
    //   218: aload 4
    //   220: invokevirtual 562	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   223: astore 4
    //   225: aload 4
    //   227: invokestatic 568	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokevirtual 562	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload_3
    //   236: getfield 1062	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   239: aload 4
    //   241: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   247: aload_3
    //   248: getfield 1063	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   251: iconst_1
    //   252: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   255: invokestatic 595	com/tencent/biz/pubaccount/Advertisement/util/PublicAccountAdUtil:a	()I
    //   258: istore_1
    //   259: aload_3
    //   260: getfield 1064	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_conn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   263: iload_1
    //   264: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   267: invokestatic 603	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()I
    //   270: istore_1
    //   271: aload_3
    //   272: getfield 1065	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_carrier	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   275: iload_1
    //   276: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   279: invokestatic 608	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()Ljava/lang/String;
    //   282: astore 4
    //   284: aload_3
    //   285: getfield 1066	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_os_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: aload 4
    //   290: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   293: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   296: invokestatic 613	com/tencent/mobileqq/utils/DeviceInfoUtil:c	()Ljava/lang/String;
    //   299: astore 4
    //   301: aload_3
    //   302: getfield 1067	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_qq_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   305: aload 4
    //   307: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   310: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   313: invokestatic 619	com/tencent/common/config/AppSetting:a	()I
    //   316: istore_1
    //   317: aload_3
    //   318: getfield 1068	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   321: iload_1
    //   322: invokestatic 524	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   325: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   328: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   331: invokestatic 627	com/dataline/util/DatalineMathUtil:a	()J
    //   334: invokestatic 630	com/dataline/util/DatalineMathUtil:a	(J)Ljava/lang/String;
    //   337: astore 4
    //   339: aload_3
    //   340: getfield 1069	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_client_ip	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   343: aload 4
    //   345: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   348: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   351: aload_3
    //   352: getfield 1070	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_os_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: iconst_2
    //   356: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   359: aload_2
    //   360: getfield 1073	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_phone_type	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo;
    //   363: aload_3
    //   364: iconst_1
    //   365: invokevirtual 1074	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;Z)V
    //   368: invokestatic 1075	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine;
    //   371: invokevirtual 1078	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule;
    //   374: astore_3
    //   375: aload_3
    //   376: ifnull +132 -> 508
    //   379: aload_3
    //   380: invokevirtual 1083	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData;
    //   383: astore_3
    //   384: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +29 -> 416
    //   390: ldc 65
    //   392: iconst_2
    //   393: new 107	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 1085
    //   403: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_3
    //   407: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_3
    //   417: ifnull +91 -> 508
    //   420: aload_3
    //   421: getfield 1090	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   424: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +81 -> 508
    //   430: new 1092	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo
    //   433: dup
    //   434: invokespecial 1093	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:<init>	()V
    //   437: astore 4
    //   439: aload 4
    //   441: getfield 1094	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   444: aload_3
    //   445: getfield 1090	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   448: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   451: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   454: aload 4
    //   456: getfield 1097	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_province	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   459: aload_3
    //   460: getfield 1100	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:province	Ljava/lang/String;
    //   463: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   466: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   469: aload 4
    //   471: getfield 1103	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_country	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   474: aload_3
    //   475: getfield 1106	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:country	Ljava/lang/String;
    //   478: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   481: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   484: aload 4
    //   486: getfield 1109	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city_code	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   489: aload_3
    //   490: getfield 1112	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:cityCode	Ljava/lang/String;
    //   493: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   496: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   499: aload_2
    //   500: getfield 1116	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_location_info	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo;
    //   503: aload 4
    //   505: invokevirtual 1119	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   508: aload_0
    //   509: ldc_w 1121
    //   512: sipush 3003
    //   515: iconst_1
    //   516: aload_2
    //   517: invokevirtual 1122	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:toByteArray	()[B
    //   520: invokestatic 669	com/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyOidbHelper:a	(Ljava/lang/String;II[B)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   523: invokevirtual 672	com/tencent/biz/pubaccount/readinjoy/model/ChannelCoverInfoModule:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   526: return
    //   527: astore 4
    //   529: aload_3
    //   530: getfield 1062	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   533: ldc_w 685
    //   536: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   539: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   542: goto -295 -> 247
    //   545: invokestatic 678	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   548: invokestatic 681	com/tencent/mobileqq/utils/DeviceInfoUtil:c	(Landroid/content/Context;)Ljava/lang/String;
    //   551: astore 4
    //   553: aload 4
    //   555: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifne -303 -> 255
    //   561: aload 4
    //   563: ldc_w 683
    //   566: ldc_w 685
    //   569: invokevirtual 688	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   572: invokevirtual 691	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   575: invokestatic 568	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   578: invokevirtual 562	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   581: astore 4
    //   583: aload_3
    //   584: getfield 1062	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   587: aload 4
    //   589: invokestatic 578	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   592: invokevirtual 583	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   595: aload_3
    //   596: getfield 1063	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   599: iconst_3
    //   600: invokevirtual 592	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   603: goto -348 -> 255
    //   606: astore 4
    //   608: iconst_0
    //   609: istore_1
    //   610: goto -339 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	ChannelCoverInfoModule
    //   258	352	1	i	int
    //   98	419	2	localReqBody	tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody
    //   170	426	3	localObject1	Object
    //   208	296	4	localObject2	Object
    //   527	1	4	localException1	Exception
    //   551	37	4	str	String
    //   606	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   225	247	527	java/lang/Exception
    //   267	271	606	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    if (paramInt == 41402)
    {
      e();
      return;
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramInt);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(1);
    if (paramInt == 0)
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(7L);
      int j = a(paramInt);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          i = j;
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            i = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
          }
        }
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(i);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      if (paramInt != 0) {
        break label247;
      }
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(3));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_channel_id", Integer.valueOf(paramInt));
      a((ToServiceMsg)localObject);
      return;
      if (paramInt == 56)
      {
        ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(3L);
        break;
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(4L);
      break;
      label247:
      if (paramInt == 56) {
        ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(4));
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbbb.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelCoverInfoModule", 1, "handle0xbbbGetChannelList, result=" + i);
    if (i == 0)
    {
      if ((paramToServiceMsg.uint64_next_req_time.has()) && (paramToServiceMsg.uint64_next_req_time.get() > 0L)) {
        this.jdField_a_of_type_Long = paramToServiceMsg.uint64_next_req_time.get();
      }
      if (paramToServiceMsg.rpt_msg_section.has()) {
        a(paramToServiceMsg.rpt_msg_section.get());
      }
      return;
    }
    b(false, null);
  }
  
  public void b(List<oidb_cmd0x69f.ChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo1 = ReadInJoyMSFHandlerUtils.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
        if ((localChannelCoverInfo1.mChannelCoverName == null) || ("".equals(localChannelCoverInfo1.mChannelCoverName)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverName is null, filter this info");
          }
        }
        else
        {
          a(localChannelCoverInfo1);
          if ((localChannelCoverInfo1.mChannelCoverSummary == null) || ("".equals(localChannelCoverInfo1.mChannelCoverSummary)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverSummary is null");
            }
            ChannelCoverInfo localChannelCoverInfo2 = a(localChannelCoverInfo1.mChannelCoverId, paramInt);
            if ((localChannelCoverInfo2 != null) && (localChannelCoverInfo2.mChannelCoverSummary != null) && (!"".equals(localChannelCoverInfo2.mChannelCoverSummary)))
            {
              localChannelCoverInfo1.mChannelCoverSummary = localChannelCoverInfo2.mChannelCoverSummary;
              if (QLog.isColorLevel()) {
                QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList modify coverSummary, summary is " + localChannelCoverInfo2.mChannelCoverSummary);
              }
            }
          }
          localArrayList.add(localChannelCoverInfo1);
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo1.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo1.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo1.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo1.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo1.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo1.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo1.mArticleId).append(", mChannelType=").append(localChannelCoverInfo1.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo1.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo1.externalExposureBackgroundUrl).append("]\n");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
  }
  
  public List<ChannelSection> c()
  {
    int i = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = FileUtils.a(new File(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data"));
      if (localObject2 != null) {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
            if (localJSONObject != null) {
              localArrayList.add(new ChannelSection(localJSONObject));
            }
            i += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, HardCodeUtil.a(2131701586), HardCodeUtil.a(2131701590)));
        this.jdField_a_of_type_JavaUtilList.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, HardCodeUtil.a(2131701593), HardCodeUtil.a(2131701604)));
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.4(this));
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.5(this, paramInt));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbbc.RspBody());
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "handleOxbbcUpChannelList, result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      ReadInJoyHelper.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
      return;
    }
    QLog.d("ChannelCoverInfoModule", 1, "0xbbcUpChannelList failed.");
  }
  
  public void c(List<oidb_cmd0xbe6.MsgChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = ReadInJoyMSFHandlerUtils.a((oidb_cmd0xbe6.MsgChannelInfo)paramList.next(), paramInt);
        localArrayList.add(localChannelCoverInfo);
        if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
          localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo.mArticleId).append(", mChannelType=").append(localChannelCoverInfo.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo.externalExposureBackgroundUrl).append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
  }
  
  public List<ChannelSection> d()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_channel_id", Integer.valueOf(0))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelCoverInfoModule", 1, "handleGetChannelAndSubscribeList, result=" + j);
    if (j == 0) {
      if (!paramToServiceMsg.uint32_req_channel_id.has()) {
        break label444;
      }
    }
    label444:
    for (i = paramToServiceMsg.uint32_req_channel_id.get();; i = -1)
    {
      int n;
      if (paramToServiceMsg.uint32_channel_seq.has())
      {
        n = paramToServiceMsg.uint32_channel_seq.get();
        int k = a(i);
        j = k;
        if (k == 0)
        {
          j = k;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            j = k;
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              j = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, i);
            }
          }
        }
        if (n <= j) {
          QLog.d("ChannelCoverInfoModule", 1, "handleGetChannelAndSubscribeList, seq is " + n + " ;lastseq = " + j + "; not need to update");
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            a(i, n);
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
              a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, n, i);
            }
            if ((m != 3) || (i != 0)) {
              break;
            }
          } while (!paramToServiceMsg.rpt_channel_list.has());
          b(paramToServiceMsg.rpt_channel_list.get(), 0);
          return;
          if ((m != 4) || (i != 56)) {
            break;
          }
        } while (!paramToServiceMsg.rpt_channel_list.has());
        b(paramToServiceMsg.rpt_channel_list.get(), 56);
        return;
        if (paramToServiceMsg.rpt_channel_list.has())
        {
          b(paramToServiceMsg.rpt_channel_list.get(), i);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChannelCoverInfoModule", 2, "handle0x69fGetChannelList resp.rpt_channel_list null , channelId = " + i);
      return;
      if (m == 3) {
        ReadInJoyLogicEngineEventDispatcher.a().f(false, null);
      }
      for (;;)
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(i, false, null);
        return;
        if (m == 4) {
          ReadInJoyLogicEngineEventDispatcher.a().g(false, null);
        }
      }
    }
  }
  
  void d(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)((Iterator)localObject).next();
      localLinkedHashMap.put(Integer.valueOf(localChannelCoverInfo.mChannelCoverId), localChannelCoverInfo);
    }
    localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_b_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
      }
      else if (paramInt == 41402)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList(paramList));
      }
    }
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    int j = 1;
    paramToServiceMsg = new oidb_cmd0xbe6.RspBody();
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) {
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        if (TextUtils.equals(a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface), paramToServiceMsg.string_channel_version.get())) {
          break label124;
        }
      }
    }
    label124:
    for (i = j;; i = 0)
    {
      a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg.string_channel_version.get());
      if ((i != 0) && (paramToServiceMsg.msg_get_channel_info_rsp.get() != null) && (paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get() != null)) {
        c(paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get(), 41402);
      }
      return;
    }
  }
  
  public void e(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = b(paramInt);
    if ((localObject != null) && (paramList != null)) {
      QLog.d("ChannelCoverInfoModule", 1, "saveNewAndRemoveOldChannelCoverInfo removeListSize =" + ((List)localObject).size() + " ;addListSize = " + paramList.size());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((ChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId, paramInt);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next(), paramInt);
    }
    f(b(paramInt), paramInt);
  }
  
  void f(List<ChannelCoverInfo> paramList, int paramInt)
  {
    d(paramList);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.7(this, paramInt, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule
 * JD-Core Version:    0.7.0.1
 */