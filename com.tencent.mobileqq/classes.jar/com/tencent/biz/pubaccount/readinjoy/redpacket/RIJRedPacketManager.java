package com.tencent.biz.pubaccount.readinjoy.redpacket;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.LruCache;
import bduy;
import bhlo;
import bmtd;
import bnwt;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.protofile.cmd0xe23.cmd0xe23.ReqBody;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.ReqBody;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import nkm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ozs;
import qrd;
import qre;
import qrf;
import qrg;
import qrh;
import rpt;

public class RIJRedPacketManager
{
  private static volatile RIJRedPacketManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager;
  private LruCache<String, String> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10000);
  @Nullable
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  
  private long a()
  {
    return a().getLong("readinjoy_red_packet_next_request_ts" + ozs.a(), 0L);
  }
  
  private long a(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private SharedPreferences.Editor a()
  {
    return a().edit();
  }
  
  private SharedPreferences a()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
  }
  
  public static RIJRedPacketManager a()
  {
    Object localObject = jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager;
    if (localObject == null) {
      try
      {
        RIJRedPacketManager localRIJRedPacketManager2 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager;
        localObject = localRIJRedPacketManager2;
        if (localRIJRedPacketManager2 == null)
        {
          localObject = new RIJRedPacketManager();
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager = (RIJRedPacketManager)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localRIJRedPacketManager1;
  }
  
  private EntityManagerFactory a()
  {
    Object localObject1 = ozs.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.excute(new RIJRedPacketManager.5(this, (ReadInJoyEntityManagerFactory)localObject1), 16, null, false);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    a().putBoolean("enableDoArticleTask_" + ozs.a(), paramBoolean).apply();
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1) == a(paramLong2));
  }
  
  private void b(int paramInt, @NotNull qrh paramqrh)
  {
    cmd0xe23.ReqBody localReqBody = new cmd0xe23.ReqBody();
    localReqBody.uin.set(ozs.a());
    nkm.a(ozs.a(), new qrd(this, paramInt, paramqrh), localReqBody.toByteArray(), "OidbSvc.0xe23", 3619, 0, new Bundle(), 5000L);
  }
  
  private void b(boolean paramBoolean)
  {
    a().putBoolean("enableDoVideoTask_" + ozs.a(), paramBoolean).apply();
  }
  
  private boolean d()
  {
    return a().getBoolean("enableDoArticleTask_" + ozs.a(), false);
  }
  
  private boolean e()
  {
    return a().getBoolean("enableDoVideoTask_" + ozs.a(), false);
  }
  
  public int a()
  {
    if (a(a().getLong("task_progress_last_update_time_stamp" + ozs.a(), 0L), NetConnInfoCenter.getServerTimeMillis())) {}
    for (;;)
    {
      return a().getInt("global_current_task_time" + ozs.a(), 0);
      a(0);
    }
  }
  
  public String a()
  {
    return a().getString("readinjoy_red_packet_last_timing_task_rowkey" + ozs.a(), "");
  }
  
  public void a(int paramInt)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    a().putLong("task_progress_last_update_time_stamp" + ozs.a(), l).apply();
    a().putInt("global_current_task_time" + ozs.a(), paramInt).apply();
  }
  
  public void a(int paramInt, @NotNull qrh paramqrh)
  {
    boolean bool2 = true;
    long l = NetConnInfoCenter.getServerTimeMillis();
    QLog.i("RIJRedPacketManager", 1, "requestShouldDoTaskTiming curTs: " + l + " getNextRequestCanDoTaskTs： " + a());
    if (l < a())
    {
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (d()) {}
      }
      else
      {
        if ((paramInt != 2) || (!e())) {
          break label100;
        }
      }
      label100:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        rpt.a(new RIJRedPacketManager.1(this, paramqrh, bool1));
        return;
      }
    }
    b(paramInt, paramqrh);
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a().putString("readinjoy_red_packet_last_timing_task_rowkey" + ozs.a(), paramString).apply();
    a().putInt("readinjoy_red_packet_last_timing_task_time" + ozs.a(), paramInt).apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, @Nullable qrg paramqrg)
  {
    oidb_0xe21.ReqBody localReqBody = new oidb_0xe21.ReqBody();
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 report progress rowkey: " + paramString + " type: " + paramInt1 + " taskTime: " + paramInt2);
    localReqBody.progress.set(paramInt2);
    localReqBody.rowkey.set(paramString);
    localReqBody.type.set(paramInt1);
    Object localObject = new terminal_info.TerminalInfo();
    ((terminal_info.TerminalInfo)localObject).qimei.set(bnwt.a());
    ((terminal_info.TerminalInfo)localObject).os_version.set(String.valueOf(bhlo.a()));
    ((terminal_info.TerminalInfo)localObject).imsi.set(ozs.i());
    ((terminal_info.TerminalInfo)localObject).qua.set(bmtd.a());
    localReqBody.terminal_info.set((MessageMicro)localObject);
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 terminal info: qimei " + bnwt.a() + "\n os_version: " + bhlo.a() + "\n imsi: " + ozs.i() + "\n qua: " + bmtd.a());
    localObject = ((TicketManager)ozs.a().getManager(2)).getSkey(ozs.a().getAccount());
    localReqBody.skey.set((String)localObject);
    nkm.a(ozs.a(), new qre(this, paramString, paramInt2, paramqrg), localReqBody.toByteArray(), "OidbSvc.0xe21", 3617, 1, new Bundle(), 5000L);
  }
  
  public void a(@NotNull String paramString, @NotNull qrf paramqrf)
  {
    ThreadManager.excute(new RIJRedPacketManager.3(this, paramString, paramqrf), 32, null, true);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    a().putLong("readinjoy_red_packet_next_request_ts" + ozs.a(), paramLong).apply();
    a().putBoolean("readinjoy_red_packet_can_do_task" + ozs.a(), paramBoolean).apply();
  }
  
  public boolean a()
  {
    return a().getBoolean("readinjoy_has_red_packet_permission" + ozs.a(), false);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_AndroidUtilLruCache.get(paramString) != null;
  }
  
  public int b()
  {
    return a().getInt("readinjoy_red_packet_total_task_time_ms" + ozs.a(), 300000);
  }
  
  public String b()
  {
    return Aladdin.getConfig(275).getString("article_share_tips_wording_android", BaseApplicationImpl.getContext().getString(2131717242));
  }
  
  public void b(int paramInt)
  {
    a().putInt("readinjoy_red_packet_total_task_time_ms" + ozs.a(), paramInt).apply();
  }
  
  public void b(@NotNull String paramString)
  {
    ThreadManager.excute(new RIJRedPacketManager.4(this, paramString), 32, null, true);
  }
  
  public boolean b()
  {
    return a().getBoolean("readinjoy_red_packet_can_do_task" + ozs.a(), true);
  }
  
  public int c()
  {
    return a().getInt("readinjoy_red_packet_station_article" + ozs.a(), 3000);
  }
  
  public void c(int paramInt)
  {
    a().putInt("readinjoy_red_packet_station_article" + ozs.a(), paramInt).apply();
  }
  
  public boolean c()
  {
    if (Aladdin.getConfig(285).getIntegerFromString("is_highest_red_packet_authority_on", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bduy.a();
      QLog.i("RIJRedPacketManager", 1, "isHighestRedPacketAuthorityOn: " + bool1 + " ,isStudyMode=" + bool2);
      if ((!bool1) || (bool2)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int d()
  {
    return Aladdin.getConfig(275).getIntegerFromString("task_tips_duration", 3) * 1000;
  }
  
  public void d(int paramInt)
  {
    a().putInt("readinjoy_red_packet_max_task_time_for_article" + ozs.a(), paramInt).apply();
  }
  
  public int e()
  {
    return a().getInt("readinjoy_red_packet_last_timing_task_time" + ozs.a(), 0);
  }
  
  public void e(int paramInt)
  {
    a().putInt("readinjoy_red_packet_task_total_round" + ozs.a(), paramInt).apply();
  }
  
  public int f()
  {
    return a().getInt("readinjoy_red_packet_max_task_time_for_article" + ozs.a(), 20000);
  }
  
  public int g()
  {
    return Aladdin.getConfig(275).getIntegerFromString("article_share_tips_duration_android", 5) * 1000;
  }
  
  public int h()
  {
    return a().getInt("readinjoy_red_packet_task_total_round" + ozs.a(), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager
 * JD-Core Version:    0.7.0.1
 */