package com.tencent.biz.pubaccount.readinjoy.redpacket;

import alud;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.ViewGroup;
import android.view.Window;
import awgg;
import babd;
import bdgk;
import bjdt;
import bkbq;
import bkgp;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.protofile.cmd0xe19.cmd0xe19.ReqBody;
import com.tencent.protofile.cmd0xe19.cmd0xe19.RspBody;
import com.tencent.protofile.cmd0xe19.cmd0xe19.TaskRedPacket;
import com.tencent.protofile.cmd0xe23.cmd0xe23.ReqBody;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.protofile.cmd0xe40.cmd0xe40.ReqBody;
import com.tencent.protofile.oidb_0xe1f.oidb_0xe1f.ReqBody;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.ReqBody;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mzy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import ors;
import oxb;
import qfh;
import qfi;
import qfj;
import qfk;
import qfl;
import qfm;
import qfn;
import qfo;
import qfp;
import qfq;
import qfr;
import qfs;
import qft;
import qfu;
import qfz;
import qgi;
import rdm;
import yqz;

public class RIJRedPacketManager
{
  private static volatile RIJRedPacketManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketRIJRedPacketManager;
  private LruCache<String, String> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10000);
  @Nullable
  private awgg jdField_a_of_type_Awgg;
  
  private long a()
  {
    String str = Aladdin.getConfig(272).getString("request_wallet_time_interval", "60");
    try
    {
      double d = Double.valueOf(str).doubleValue();
      return (d * 60.0D * 1000.0D);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 3600000L;
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
  
  private awgg a()
  {
    Object localObject1 = ors.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_Awgg == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_Awgg).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.excute(new RIJRedPacketManager.12(this, (ReadInJoyEntityManagerFactory)localObject1), 16, null, false);
        this.jdField_a_of_type_Awgg = ((awgg)localObject1);
      }
      return this.jdField_a_of_type_Awgg;
    }
    finally {}
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
  
  private void a(boolean paramBoolean)
  {
    a().putBoolean("enableDoArticleTask_" + ors.a(), paramBoolean).apply();
  }
  
  private void a(byte[] paramArrayOfByte, @NotNull qfr paramqfr)
  {
    String str1 = null;
    try
    {
      cmd0xe19.RspBody localRspBody = new cmd0xe19.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      int i = localRspBody.ret.get();
      if (i == 0)
      {
        long l = localRspBody.money.get();
        str2 = localRspBody.detail_wording.get();
        paramArrayOfByte = str1;
        if (localRspBody.has_task.get())
        {
          paramArrayOfByte = new qfz();
          paramArrayOfByte.a = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).head.get();
          paramArrayOfByte.b = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).nick.get();
          paramArrayOfByte.c = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).wording.get();
        }
        paramqfr.a(i, l, str2, paramArrayOfByte, localRspBody.button_wording.get(), localRspBody.outcome_wording.get(), "");
        d();
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 ret = " + i + " money " + l + " detailWording " + str2);
        return;
      }
      paramArrayOfByte = "";
      String str2 = "";
      str1 = "";
      if (localRspBody.toast.has()) {
        paramArrayOfByte = localRspBody.toast.get();
      }
      if (localRspBody.button_wording.has()) {
        str1 = localRspBody.button_wording.get();
      }
      if (localRspBody.detail_wording.has()) {
        str2 = localRspBody.detail_wording.get();
      }
      paramqfr.a(i, 0L, str2, null, str1, localRspBody.outcome_wording.get(), paramArrayOfByte);
      QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 ret = " + i + " toast wording: " + paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RIJRedPacketManager", 1, QLog.getStackTraceString(paramArrayOfByte));
      }
      paramqfr.a();
    }
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1) == a(paramLong2));
  }
  
  private long b()
  {
    return a().getLong("readinjoy_red_packet_next_request_ts" + ors.a(), 0L);
  }
  
  private void b(int paramInt, @NotNull qft paramqft)
  {
    cmd0xe23.ReqBody localReqBody = new cmd0xe23.ReqBody();
    localReqBody.uin.set(ors.a());
    mzy.a(ors.a(), new qfi(this, paramInt, paramqft), localReqBody.toByteArray(), "OidbSvc.0xe23", 3619, 0, new Bundle(), 5000L);
  }
  
  private void b(boolean paramBoolean)
  {
    a().putBoolean("enableDoVideoTask_" + ors.a(), paramBoolean).apply();
  }
  
  private boolean f()
  {
    return a().getBoolean("enableDoArticleTask_" + ors.a(), false);
  }
  
  private boolean g()
  {
    return a().getBoolean("enableDoVideoTask_" + ors.a(), false);
  }
  
  public int a()
  {
    if (a(a().getLong("task_progress_last_update_time_stamp" + ors.a(), 0L), NetConnInfoCenter.getServerTimeMillis())) {}
    for (;;)
    {
      return a().getInt("global_current_task_time" + ors.a(), 0);
      a(0);
    }
  }
  
  public String a()
  {
    return Aladdin.getConfig(275).getString("video_tips_content", BaseApplicationImpl.getApplication().getString(2131719044));
  }
  
  public JSONObject a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((c()) && (e())) {
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.size() <= 0)) {
        break label93;
      }
    }
    label93:
    for (ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);; localArticleInfo = null)
    {
      if (paramBaseArticleInfo.hasWalletIcon) {
        paramJSONObject.put("red_packet_icon_path", "readinjoy_red_packet.png");
      }
      if ((localArticleInfo != null) && (localArticleInfo.hasWalletIcon)) {
        paramJSONObject.put("sub_red_packet_icon_path", "readinjoy_red_packet.png");
      }
      return paramJSONObject;
    }
  }
  
  public void a()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    a().putLong("last_fetch_red_packet_info_time" + ors.a(), l).apply();
  }
  
  public void a(int paramInt)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    a().putLong("task_progress_last_update_time_stamp" + ors.a(), l).apply();
    a().putInt("global_current_task_time" + ors.a(), paramInt).apply();
  }
  
  public void a(int paramInt, String paramString1, String paramString2, @NotNull qfr paramqfr)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 \nshareSource: " + paramInt + "\nred packetId: " + paramString1 + "\nrowkey: " + paramString2);
    cmd0xe19.ReqBody localReqBody = new cmd0xe19.ReqBody();
    localReqBody.id.set(paramString1);
    localReqBody.rowkey.set(paramString2);
    localReqBody.task_idx.setHasFlag(true);
    paramString1 = new terminal_info.TerminalInfo();
    paramString1.qimei.set(bkgp.b());
    paramString1.os_version.set(String.valueOf(bdgk.a()));
    paramString1.imsi.set(ors.g());
    paramString1.qua.set(bjdt.a());
    localReqBody.terminal_info.set(paramString1);
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 terminal info: qimei " + bkgp.b() + "\n os_version: " + bdgk.a() + "\n imsi: " + ors.g() + "\n qua: " + bjdt.a());
    paramString1 = ((TicketManager)ors.a().getManager(2)).getSkey(ors.a().getAccount());
    localReqBody.skey.set(paramString1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      mzy.a(ors.a(), new qfl(this, paramqfr), localReqBody.toByteArray(), "OidbSvc.0xe19", 3609, 1, new Bundle(), 5000L);
      return;
      localReqBody.source.set(1);
      continue;
      localReqBody.source.set(5);
      continue;
      localReqBody.source.set(4);
      continue;
      localReqBody.source.set(2);
      continue;
      localReqBody.source.set(3);
    }
  }
  
  public void a(int paramInt, @NotNull qft paramqft)
  {
    boolean bool2 = true;
    long l = NetConnInfoCenter.getServerTimeMillis();
    QLog.i("RIJRedPacketManager", 1, "requestShouldDoTaskTiming curTs: " + l + " getNextRequestCanDoTaskTs： " + b());
    if (l < b())
    {
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (f()) {}
      }
      else
      {
        if ((paramInt != 2) || (!g())) {
          break label103;
        }
      }
      label103:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        rdm.a(new RIJRedPacketManager.2(this, paramqft, bool1));
        return;
      }
    }
    b(paramInt, paramqft);
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString1, String paramString2, @NotNull qfu paramqfu, boolean paramBoolean, yqz paramyqz)
  {
    QLog.i("RIJRedPacketManager", 1, "onClickBubbleTips share source: " + paramInt + "\n encryptId: " + paramString1 + "\nrowkey: " + paramString2);
    if (!bkbq.g())
    {
      a(paramActivity, paramString1, 2, 0, paramBoolean, paramyqz);
      return;
    }
    if ("QzoneFeedsPluginProxyActivity".equals(paramActivity.getIntent().getStringExtra("SourceActivityName"))) {}
    for (int i = 3;; i = 2)
    {
      a(paramInt, paramString1, paramString2, new qfm(this, paramActivity, paramString1, paramInt, i, paramString2, paramqfu));
      return;
    }
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, yqz paramyqz)
  {
    new qgi((ViewGroup)paramActivity.getWindow().getDecorView(), paramString, paramInt1, paramInt2, paramBoolean, paramyqz).a();
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    ors.a(paramContext, String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a().putString("readinjoy_red_packet_last_timing_task_rowkey" + ors.a(), paramString).apply();
    a().putInt("readinjoy_red_packet_last_timing_task_time" + ors.a(), paramInt).apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, @Nullable qfs paramqfs)
  {
    oidb_0xe21.ReqBody localReqBody = new oidb_0xe21.ReqBody();
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 report progress rowkey: " + paramString + " type: " + paramInt1 + " taskTime: " + paramInt2);
    localReqBody.progress.set(paramInt2);
    localReqBody.rowkey.set(paramString);
    localReqBody.type.set(paramInt1);
    Object localObject = new terminal_info.TerminalInfo();
    ((terminal_info.TerminalInfo)localObject).qimei.set(bkgp.b());
    ((terminal_info.TerminalInfo)localObject).os_version.set(String.valueOf(bdgk.a()));
    ((terminal_info.TerminalInfo)localObject).imsi.set(ors.g());
    ((terminal_info.TerminalInfo)localObject).qua.set(bjdt.a());
    localReqBody.terminal_info.set((MessageMicro)localObject);
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 terminal info: qimei " + bkgp.b() + "\n os_version: " + bdgk.a() + "\n imsi: " + ors.g() + "\n qua: " + bjdt.a());
    localObject = ((TicketManager)ors.a().getManager(2)).getSkey(ors.a().getAccount());
    localReqBody.skey.set((String)localObject);
    mzy.a(ors.a(), new qfh(this, paramString, paramInt2, paramqfs), localReqBody.toByteArray(), "OidbSvc.0xe21", 3617, 1, new Bundle(), 5000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, @NotNull qfo paramqfo)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe40 rowkey: " + paramString1 + "\n");
    cmd0xe40.ReqBody localReqBody = new cmd0xe40.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.id.set(paramString2);
    localReqBody.source.set(paramInt);
    mzy.a(ors.a(), new qfn(this, paramqfo), localReqBody.toByteArray(), "OidbSvc.0xe40", 3648, 1, new Bundle(), 5000L);
  }
  
  public void a(String paramString, @NotNull qfp paramqfp)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe1f: rowkey: " + paramString);
    oidb_0xe1f.ReqBody localReqBody = new oidb_0xe1f.ReqBody();
    localReqBody.rowkey.set(paramString);
    mzy.a(ors.a(), new qfj(this, paramqfp), localReqBody.toByteArray(), "OidbSvc.0xe1f", 3615, 1, new Bundle(), 5000L);
  }
  
  public void a(@NotNull String paramString, @NotNull qfq paramqfq)
  {
    ThreadManager.excute(new RIJRedPacketManager.10(this, paramString, paramqfq), 32, null, true);
  }
  
  public void a(qft paramqft)
  {
    if ((c()) && (e()))
    {
      a(2, paramqft);
      return;
    }
    rdm.a(new RIJRedPacketManager.1(this, paramqft));
  }
  
  public void a(@NotNull qfu paramqfu)
  {
    QLog.i("RIJRedPacketManager", 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    mzy.a(ors.a(), new qfk(this, paramqfu), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    a().putLong("readinjoy_red_packet_next_request_ts" + ors.a(), paramLong).apply();
    a().putBoolean("readinjoy_red_packet_can_do_task" + ors.a(), paramBoolean).apply();
  }
  
  public boolean a()
  {
    if ((AppSetting.b()) && (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() == 2436410075L)) {}
    long l1;
    long l2;
    do
    {
      return true;
      l1 = a().getLong("last_fetch_red_packet_info_time" + ors.a(), 0L);
      l2 = NetConnInfoCenter.getServerTimeMillis();
    } while ((!a().getBoolean("readinjoy_red_packet_window_has_closed" + ors.a(), false)) && (l2 - l1 >= a()) && (e()));
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    String str3 = null;
    String str1;
    String str2;
    label66:
    int i;
    label109:
    int k;
    if (((paramChatMessage instanceof MessageForStructing)) && (((MessageForStructing)paramChatMessage).structingMsg != null))
    {
      str1 = ((MessageForStructing)paramChatMessage).structingMsg.mMsgUrl;
      str2 = ((MessageForStructing)paramChatMessage).structingMsg.getSourceName();
      str3 = ((MessageForStructing)paramChatMessage).structingMsg.mQzoneExtraMsg;
      if (TextUtils.isEmpty(str1)) {
        break label254;
      }
      j = 1;
      if ((j == 0) || ((!str1.startsWith("https://post.mp.qq.com/kan/article/")) && (!str1.startsWith("http://post.mp.qq.com/kan/article/"))) || (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 83)) {
        break label259;
      }
      i = 1;
      if ((j == 0) || ((!str1.startsWith("https://post.mp.qq.com/kan/video/")) && (!str1.startsWith("http://post.mp.qq.com/kan/video/"))) || (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 140)) {
        break label264;
      }
      k = 1;
      label154:
      if ((j == 0) || (!str1.contains("redpackid"))) {
        break label270;
      }
      j = 1;
      label171:
      if ((j == 0) || ((i == 0) && (k == 0))) {
        break label275;
      }
      i = 1;
      label186:
      if ((!alud.a(2131718269).equals(str2)) && (TextUtils.isEmpty(str3))) {
        break label280;
      }
    }
    label259:
    label264:
    label270:
    label275:
    label280:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (!e()) || (j != 0)) {
        break label285;
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("RIJRedPacketManager", 2, "((MessageForStructing) message).structingMsg is null.");
      }
      str1 = "";
      str2 = null;
      break;
      label254:
      j = 0;
      break label66;
      i = 0;
      break label109;
      k = 0;
      break label154;
      j = 0;
      break label171;
      i = 0;
      break label186;
    }
    label285:
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_AndroidUtilLruCache.get(paramString) != null;
  }
  
  public int b()
  {
    return a().getInt("readinjoy_red_packet_total_task_time_ms" + ors.a(), 300000);
  }
  
  public String b()
  {
    return a().getString("readinjoy_red_packet_last_timing_task_rowkey" + ors.a(), "");
  }
  
  public void b()
  {
    a().putBoolean("readinjoy_red_packet_window_has_closed" + ors.a(), true).apply();
  }
  
  public void b(int paramInt)
  {
    a().putInt("readinjoy_red_packet_total_task_time_ms" + ors.a(), paramInt).apply();
  }
  
  public void b(@NotNull String paramString)
  {
    ThreadManager.excute(new RIJRedPacketManager.11(this, paramString), 32, null, true);
  }
  
  public boolean b()
  {
    return a().getBoolean("readinjoy_red_packet_has_opened" + ors.a(), false);
  }
  
  public int c()
  {
    return a().getInt("readinjoy_red_packet_station_article" + ors.a(), 3000);
  }
  
  public String c()
  {
    return Aladdin.getConfig(275).getString("article_share_tips_wording_android", BaseApplicationImpl.getContext().getString(2131719003));
  }
  
  public void c()
  {
    a().putBoolean("readinjoy_red_packet_has_opened" + ors.a(), true).apply();
  }
  
  public void c(int paramInt)
  {
    a().putInt("readinjoy_red_packet_station_article" + ors.a(), paramInt).apply();
  }
  
  public boolean c()
  {
    return a().getBoolean("readinjoy_has_red_packet_permission" + ors.a(), false);
  }
  
  public int d()
  {
    return Aladdin.getConfig(275).getIntegerFromString("task_tips_duration", 3) * 1000;
  }
  
  public void d()
  {
    oxb.a().c(true);
    a().putBoolean("readinjoy_has_red_packet_permission" + ors.a(), true).apply();
  }
  
  public void d(int paramInt)
  {
    a().putInt("readinjoy_red_packet_max_task_time_for_article" + ors.a(), paramInt).apply();
  }
  
  public boolean d()
  {
    return a().getBoolean("readinjoy_red_packet_can_do_task" + ors.a(), true);
  }
  
  public int e()
  {
    return Aladdin.getConfig(275).getIntegerFromString("video_tips_duration", 3) * 1000;
  }
  
  public void e()
  {
    ThreadManager.excute(new RIJRedPacketManager.9(this), 32, null, true);
  }
  
  public void e(int paramInt)
  {
    a().putInt("readinjoy_red_packet_task_total_round" + ors.a(), paramInt).apply();
  }
  
  public boolean e()
  {
    if (Aladdin.getConfig(285).getIntegerFromString("is_highest_red_packet_authority_on", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = babd.a();
      QLog.i("RIJRedPacketManager", 1, "isHighestRedPacketAuthorityOn: " + bool1 + " ,isStudyMode=" + bool2);
      if ((!bool1) || (bool2)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int f()
  {
    return a().getInt("readinjoy_red_packet_last_timing_task_time" + ors.a(), 0);
  }
  
  public int g()
  {
    return a().getInt("readinjoy_red_packet_max_task_time_for_article" + ors.a(), 20000);
  }
  
  public int h()
  {
    return Aladdin.getConfig(275).getIntegerFromString("article_share_tips_duration_android", 5) * 1000;
  }
  
  public int i()
  {
    return a().getInt("readinjoy_red_packet_task_total_round" + ors.a(), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager
 * JD-Core Version:    0.7.0.1
 */