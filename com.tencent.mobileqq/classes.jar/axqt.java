import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import QQService.RespHead;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.nowsummarycard.NowSummaryCard.ClientInfo;
import com.tencent.nowsummarycard.NowSummaryCard.LocationInfo;
import com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardReq;
import com.tencent.nowsummarycard.NowSummaryCard.ReqNearbySummaryCard;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.ReqBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.LoginSig;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.LoginSig;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.nearby.nearby_ice_break.IceReq;

public class axqt
  extends BusinessHandler
{
  protected Set<String> a;
  
  public axqt(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private NowSummaryCard.ClientInfo a()
  {
    NowSummaryCard.ClientInfo localClientInfo = new NowSummaryCard.ClientInfo();
    localClientInfo.client_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
    localClientInfo.platform.set(2);
    localClientInfo.imei.set(ByteStringMicro.copyFrom(bjls.c().getBytes()));
    return localClientInfo;
  }
  
  private NowSummaryCard.LocationInfo a()
  {
    NowSummaryCard.LocationInfo localLocationInfo = new NowSummaryCard.LocationInfo();
    Object localObject = SosoInterface.getSosoInfo();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoInterface.SosoLbsInfo)localObject).mLocation;
      long l1 = Double.valueOf(((SosoInterface.SosoLocation)localObject).mLat02 * 1000000.0D).longValue();
      long l2 = Double.valueOf(((SosoInterface.SosoLocation)localObject).mLon02 * 1000000.0D).longValue();
      localLocationInfo.latitude.set(Long.valueOf(l1).longValue());
      localLocationInfo.longitude.set(Long.valueOf(l2).longValue());
    }
    return localLocationInfo;
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString, byte paramByte, ToServiceMsg paramToServiceMsg)
  {
    NowSummaryCard.ReqNearbySummaryCard localReqNearbySummaryCard = new NowSummaryCard.ReqNearbySummaryCard();
    localReqNearbySummaryCard.tiny_id.set(paramLong2);
    try
    {
      localReqNearbySummaryCard.uin.set(Long.valueOf(paramString).longValue());
      localReqNearbySummaryCard.location.set(a());
      localReqNearbySummaryCard.client_info.set(a());
      localReqNearbySummaryCard.come_from.set(paramInt2);
      NowSummaryCard.NearbySummaryCardReq localNearbySummaryCardReq = new NowSummaryCard.NearbySummaryCardReq();
      localNearbySummaryCardReq.id.set(paramLong1);
      localNearbySummaryCardReq.id_type.set(paramInt1);
      localNearbySummaryCardReq.gender.set(1L);
      localNearbySummaryCardReq.pb_data.set(ByteStringMicro.copyFrom(localReqNearbySummaryCard.toByteArray()));
      QLog.e("NearbyCardHandler", 1, "start uin:" + paramString + ", tinyId:" + paramLong2 + ", nowId:" + paramLong1 + ", from:" + paramInt2);
      ntb.a(this.app, new axqu(this, false, paramToServiceMsg), localNearbySummaryCardReq.toByteArray(), "NowSummaryCard.NearbySummaryCardReq");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NearbyCardHandler", 1, "getNearbySummaryCard, illegal uin: " + paramString);
      }
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard paramRespNearbySummaryCard, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 239
    //   3: invokevirtual 245	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 7
    //   8: aload_3
    //   9: ldc 247
    //   11: invokevirtual 251	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   14: istore 5
    //   16: iload_1
    //   17: ifeq +7 -> 24
    //   20: aload_2
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: bipush 51
    //   27: iconst_0
    //   28: aconst_null
    //   29: iload 7
    //   31: invokevirtual 255	axqt:notifyUI	(IZLjava/lang/Object;Z)V
    //   34: return
    //   35: ldc 182
    //   37: iconst_1
    //   38: new 184	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 257
    //   48: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: getfield 260	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   55: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   58: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: ldc 193
    //   63: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_2
    //   67: getfield 264	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   70: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   73: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc_w 266
    //   79: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: getfield 270	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   86: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   89: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 280	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   105: invokevirtual 286	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: astore 15
    //   110: aload 15
    //   112: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   115: astore 16
    //   117: aload 16
    //   119: invokevirtual 297	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   122: aload_3
    //   123: ldc_w 299
    //   126: lconst_0
    //   127: invokevirtual 303	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   130: lstore 8
    //   132: aload_3
    //   133: ldc_w 305
    //   136: invokevirtual 307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   139: lstore 10
    //   141: aload_3
    //   142: ldc_w 309
    //   145: invokevirtual 251	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   148: istore 4
    //   150: iload 4
    //   152: ifne +669 -> 821
    //   155: aload 15
    //   157: ldc_w 311
    //   160: ldc_w 313
    //   163: iconst_1
    //   164: anewarray 38	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: lload 8
    //   171: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   174: aastore
    //   175: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   178: checkcast 311	com/tencent/mobileqq/data/NearbyPeopleCard
    //   181: astore_3
    //   182: aload_3
    //   183: ifnonnull +675 -> 858
    //   186: new 311	com/tencent/mobileqq/data/NearbyPeopleCard
    //   189: dup
    //   190: invokespecial 321	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   193: astore 14
    //   195: iload 5
    //   197: ifne +852 -> 1049
    //   200: iconst_1
    //   201: istore_1
    //   202: aload 14
    //   204: iload_1
    //   205: putfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   208: aload 14
    //   210: getfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   213: ifeq +841 -> 1054
    //   216: aload 14
    //   218: aload_0
    //   219: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   222: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   225: putfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   228: lload 8
    //   230: lconst_0
    //   231: lcmp
    //   232: ifle +862 -> 1094
    //   235: aload 14
    //   237: lload 8
    //   239: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   242: aload 14
    //   244: lload 10
    //   246: putfield 336	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   249: aload 14
    //   251: iload 4
    //   253: putfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   256: aload 14
    //   258: aload_2
    //   259: getfield 270	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   265: putfield 342	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   268: aload 14
    //   270: aload_2
    //   271: getfield 345	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:rich_sign	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   274: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   277: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   280: putfield 353	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   283: aload 14
    //   285: aload_2
    //   286: getfield 354	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gender	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   289: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   292: l2i
    //   293: i2b
    //   294: putfield 357	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   297: aload 14
    //   299: aload_2
    //   300: getfield 361	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:age	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   303: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   306: putfield 368	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   309: aload 14
    //   311: aload_2
    //   312: getfield 371	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:birthday	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   315: invokevirtual 372	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   318: l2i
    //   319: putfield 374	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   322: aload 14
    //   324: aload_2
    //   325: getfield 377	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:profession	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   331: putfield 381	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   334: aload 14
    //   336: aload_2
    //   337: getfield 384	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:constellation	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   340: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   343: i2b
    //   344: putfield 386	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   347: aload 14
    //   349: aload_2
    //   350: getfield 389	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:distance	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: putfield 391	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   359: aload 14
    //   361: aload_2
    //   362: getfield 394	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:elapse	Lcom/tencent/mobileqq/pb/PBStringField;
    //   365: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   368: putfield 397	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   371: aload 14
    //   373: aload_2
    //   374: getfield 400	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:company	Lcom/tencent/mobileqq/pb/PBStringField;
    //   377: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   380: putfield 402	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   383: aload 14
    //   385: aload_2
    //   386: getfield 405	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school	Lcom/tencent/mobileqq/pb/PBStringField;
    //   389: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   392: putfield 408	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   395: aload 14
    //   397: aload_2
    //   398: getfield 411	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:marriage	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   401: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   404: i2b
    //   405: putfield 414	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   408: aload 14
    //   410: aload_2
    //   411: getfield 417	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   414: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   417: putfield 420	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   420: aload 14
    //   422: aload_2
    //   423: getfield 423	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nearby_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   426: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   429: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   432: putfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   435: aload 14
    //   437: aload_2
    //   438: getfield 429	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_country	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   441: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   444: i2l
    //   445: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   448: putfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   451: aload 14
    //   453: aload_2
    //   454: getfield 439	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_province	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   457: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   460: i2l
    //   461: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   464: putfield 442	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   467: aload 14
    //   469: aload_2
    //   470: getfield 445	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_city	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   476: i2l
    //   477: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   480: putfield 448	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   483: aload 14
    //   485: aload_2
    //   486: getfield 451	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_zone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   489: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   492: i2l
    //   493: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   496: putfield 454	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   499: aload 14
    //   501: invokestatic 459	java/lang/System:currentTimeMillis	()J
    //   504: putfield 462	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   507: aload 14
    //   509: aload_2
    //   510: getfield 465	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:temp_chat_sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   513: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   516: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   519: putfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   522: aload_2
    //   523: getfield 471	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:is_friend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   526: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   529: iconst_1
    //   530: if_icmpne +595 -> 1125
    //   533: iconst_1
    //   534: istore_1
    //   535: aload 14
    //   537: iload_1
    //   538: putfield 474	com/tencent/mobileqq/data/NearbyPeopleCard:isFriend	Z
    //   541: aload 14
    //   543: aload_2
    //   544: getfield 477	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:chat_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   547: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   550: putfield 480	com/tencent/mobileqq/data/NearbyPeopleCard:chatId	J
    //   553: aload 14
    //   555: iload 5
    //   557: putfield 483	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   560: aload 14
    //   562: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   565: ifnull +565 -> 1130
    //   568: aload 14
    //   570: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   573: arraylength
    //   574: ifne +56 -> 630
    //   577: aload 14
    //   579: getfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   582: ifne +48 -> 630
    //   585: aload_0
    //   586: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   589: ldc_w 485
    //   592: ldc_w 487
    //   595: ldc_w 489
    //   598: ldc_w 491
    //   601: ldc_w 493
    //   604: iconst_0
    //   605: iconst_0
    //   606: aload_0
    //   607: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   610: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   613: aload 14
    //   615: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   618: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   621: ldc_w 489
    //   624: ldc_w 489
    //   627: invokestatic 499	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   634: invokevirtual 503	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   637: aload 14
    //   639: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   642: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   645: invokevirtual 509	bcrg:n	(Ljava/lang/String;)[B
    //   648: ifnonnull +26 -> 674
    //   651: aload_0
    //   652: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   655: invokevirtual 503	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   658: aload 14
    //   660: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   663: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   666: aload 14
    //   668: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   671: invokevirtual 513	bcrg:h	(Ljava/lang/String;[B)V
    //   674: aload_2
    //   675: getfield 516	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:common_label	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   678: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   681: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   684: astore_3
    //   685: aload_3
    //   686: ifnull +502 -> 1188
    //   689: aload 14
    //   691: new 518	java/util/ArrayList
    //   694: dup
    //   695: invokespecial 519	java/util/ArrayList:<init>	()V
    //   698: putfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   701: new 525	appoint/define/appoint_define$CommonLabel
    //   704: dup
    //   705: invokespecial 526	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   708: astore 17
    //   710: aload 17
    //   712: aload_3
    //   713: invokevirtual 530	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   716: pop
    //   717: aload 17
    //   719: getfield 534	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   722: invokevirtual 539	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   725: astore_3
    //   726: aload 17
    //   728: getfield 542	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   731: invokevirtual 539	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   734: astore 18
    //   736: new 544	org/json/JSONArray
    //   739: dup
    //   740: invokespecial 545	org/json/JSONArray:<init>	()V
    //   743: astore 17
    //   745: aload_3
    //   746: invokeinterface 550 1 0
    //   751: aload 18
    //   753: invokeinterface 550 1 0
    //   758: if_icmpne +420 -> 1178
    //   761: iconst_0
    //   762: istore 4
    //   764: iload 4
    //   766: aload_3
    //   767: invokeinterface 550 1 0
    //   772: if_icmpge +406 -> 1178
    //   775: aload_3
    //   776: iload 4
    //   778: invokeinterface 553 2 0
    //   783: checkcast 44	com/tencent/mobileqq/pb/ByteStringMicro
    //   786: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   789: astore 18
    //   791: aload 14
    //   793: getfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   796: aload 18
    //   798: invokeinterface 560 2 0
    //   803: pop
    //   804: aload 17
    //   806: aload 18
    //   808: invokevirtual 564	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   811: pop
    //   812: iload 4
    //   814: iconst_1
    //   815: iadd
    //   816: istore 4
    //   818: goto -54 -> 764
    //   821: lload 10
    //   823: lconst_0
    //   824: lcmp
    //   825: ifle +2611 -> 3436
    //   828: aload 15
    //   830: ldc_w 311
    //   833: ldc_w 566
    //   836: iconst_1
    //   837: anewarray 38	java/lang/String
    //   840: dup
    //   841: iconst_0
    //   842: lload 10
    //   844: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   847: aastore
    //   848: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   851: checkcast 311	com/tencent/mobileqq/data/NearbyPeopleCard
    //   854: astore_3
    //   855: goto -673 -> 182
    //   858: aload_3
    //   859: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   862: istore 6
    //   864: aload_3
    //   865: invokevirtual 572	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   868: lstore 12
    //   870: new 311	com/tencent/mobileqq/data/NearbyPeopleCard
    //   873: dup
    //   874: invokespecial 321	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   877: astore 14
    //   879: aload 14
    //   881: aload_3
    //   882: getfield 575	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   885: putfield 575	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   888: aload 14
    //   890: aload_3
    //   891: getfield 578	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   894: putfield 578	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   897: aload 14
    //   899: aload_3
    //   900: getfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   903: putfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   906: aload 14
    //   908: aload_3
    //   909: getfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   912: putfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   915: aload 14
    //   917: aload_3
    //   918: getfield 587	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   921: putfield 587	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   924: aload 14
    //   926: aload_3
    //   927: getfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   930: putfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   933: aload 14
    //   935: aload_3
    //   936: getfield 593	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   939: putfield 593	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   942: aload 14
    //   944: aload_3
    //   945: getfield 596	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   948: putfield 596	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   951: aload 14
    //   953: aload_3
    //   954: getfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   957: putfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   960: aload 14
    //   962: aload_3
    //   963: getfield 602	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   966: putfield 602	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   969: aload 14
    //   971: aload_3
    //   972: getfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   975: putfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   978: aload 14
    //   980: aload_3
    //   981: getfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   984: putfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   987: aload 14
    //   989: aload_3
    //   990: getfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   993: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   996: aload 14
    //   998: aload_3
    //   999: getfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1002: putfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1005: aload 14
    //   1007: aload_3
    //   1008: getfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1011: putfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1014: aload 14
    //   1016: aload_3
    //   1017: getfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1020: putfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1023: aload 14
    //   1025: aload_3
    //   1026: getfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1029: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1032: aload 14
    //   1034: iload 6
    //   1036: invokevirtual 623	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1039: aload 14
    //   1041: lload 12
    //   1043: invokevirtual 626	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1046: goto -851 -> 195
    //   1049: iconst_0
    //   1050: istore_1
    //   1051: goto -849 -> 202
    //   1054: aload_2
    //   1055: getfield 471	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:is_friend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1058: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1061: iconst_1
    //   1062: if_icmpne +21 -> 1083
    //   1065: aload 14
    //   1067: aload_2
    //   1068: getfield 260	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1071: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1074: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1077: putfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1080: goto -852 -> 228
    //   1083: aload 14
    //   1085: ldc_w 628
    //   1088: putfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1091: goto -863 -> 228
    //   1094: aload 14
    //   1096: aload_2
    //   1097: getfield 264	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1100: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1103: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1106: invokevirtual 116	java/lang/Long:longValue	()J
    //   1109: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1112: goto -870 -> 242
    //   1115: astore_3
    //   1116: aload 14
    //   1118: lconst_0
    //   1119: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1122: goto -880 -> 242
    //   1125: iconst_0
    //   1126: istore_1
    //   1127: goto -592 -> 535
    //   1130: aload_0
    //   1131: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1134: ldc_w 485
    //   1137: ldc_w 487
    //   1140: ldc_w 489
    //   1143: ldc_w 491
    //   1146: ldc_w 630
    //   1149: iconst_0
    //   1150: iconst_0
    //   1151: aload_0
    //   1152: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1155: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1158: aload 14
    //   1160: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1163: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1166: ldc_w 489
    //   1169: ldc_w 489
    //   1172: invokestatic 499	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1175: goto -501 -> 674
    //   1178: aload 14
    //   1180: aload 17
    //   1182: invokevirtual 631	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1185: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1188: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1191: ifeq +36 -> 1227
    //   1194: ldc_w 640
    //   1197: iconst_4
    //   1198: new 184	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1205: ldc_w 642
    //   1208: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: aload_2
    //   1212: getfield 417	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1215: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1218: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: aload 14
    //   1229: aload_2
    //   1230: getfield 648	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:date_face	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1233: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1236: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1239: aconst_null
    //   1240: aload 14
    //   1242: getfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   1245: invokevirtual 652	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1248: pop
    //   1249: aload 14
    //   1251: getfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1254: ldc2_w 656
    //   1257: land
    //   1258: lconst_0
    //   1259: lcmp
    //   1260: ifeq +1532 -> 2792
    //   1263: aload 14
    //   1265: iconst_1
    //   1266: putfield 660	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1269: aload 14
    //   1271: getfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1274: ldc2_w 661
    //   1277: land
    //   1278: lconst_0
    //   1279: lcmp
    //   1280: ifeq +1521 -> 2801
    //   1283: aload 14
    //   1285: iconst_1
    //   1286: putfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1289: aload 14
    //   1291: invokevirtual 668	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1294: ifne +27 -> 1321
    //   1297: aload 14
    //   1299: ldc_w 489
    //   1302: putfield 671	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1305: aload 14
    //   1307: ldc_w 489
    //   1310: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1313: aload 14
    //   1315: ldc_w 489
    //   1318: putfield 677	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1321: aload_2
    //   1322: getfield 681	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1325: invokevirtual 686	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:has	()Z
    //   1328: ifeq +1503 -> 2831
    //   1331: aload_2
    //   1332: getfield 681	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1335: getfield 689	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1338: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1341: i2l
    //   1342: lstore 8
    //   1344: new 691	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   1347: dup
    //   1348: invokespecial 692	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   1351: astore_3
    //   1352: aload_3
    //   1353: aload_2
    //   1354: getfield 681	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1357: getfield 695	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:tag_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1360: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1363: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1366: invokevirtual 696	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1369: pop
    //   1370: aload 14
    //   1372: lload 8
    //   1374: aload_3
    //   1375: getfield 700	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1378: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1381: invokevirtual 707	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   1384: aload_2
    //   1385: getfield 711	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1388: invokevirtual 714	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:has	()Z
    //   1391: ifeq +43 -> 1434
    //   1394: aload 14
    //   1396: aload_2
    //   1397: getfield 711	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1400: invokevirtual 717	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1403: checkcast 713	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo
    //   1406: getfield 720	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:open_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1409: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1412: i2l
    //   1413: putfield 723	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   1416: aload 14
    //   1418: aload_2
    //   1419: getfield 711	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1422: invokevirtual 717	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1425: checkcast 713	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo
    //   1428: invokevirtual 724	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:toByteArray	()[B
    //   1431: putfield 727	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   1434: aload_2
    //   1435: getfield 731	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:vote_info	Lcom/tencent/nowsummarycard/NowSummaryCard$VoteInfo;
    //   1438: invokevirtual 734	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:has	()Z
    //   1441: ifeq +89 -> 1530
    //   1444: aload_2
    //   1445: getfield 731	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:vote_info	Lcom/tencent/nowsummarycard/NowSummaryCard$VoteInfo;
    //   1448: invokevirtual 735	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1451: checkcast 733	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo
    //   1454: astore_3
    //   1455: aload 14
    //   1457: aload_3
    //   1458: getfield 738	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:vote_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1461: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1464: putfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1467: aload 14
    //   1469: aload_3
    //   1470: getfield 744	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:latest_vote_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1473: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1476: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1479: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1482: ifeq +48 -> 1530
    //   1485: ldc_w 640
    //   1488: iconst_2
    //   1489: new 184	java/lang/StringBuilder
    //   1492: dup
    //   1493: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1496: ldc_w 752
    //   1499: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: aload 14
    //   1504: getfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1507: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1510: ldc_w 754
    //   1513: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: aload 14
    //   1518: getfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1521: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1524: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1527: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1530: aload 14
    //   1532: getfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   1535: ifnull +787 -> 2322
    //   1538: new 756	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   1541: dup
    //   1542: invokespecial 757	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   1545: astore_3
    //   1546: aload_3
    //   1547: aload 14
    //   1549: getfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   1552: invokevirtual 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1555: pop
    //   1556: iload 5
    //   1558: bipush 51
    //   1560: if_icmpne +1300 -> 2860
    //   1563: aload_3
    //   1564: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1567: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1570: iconst_1
    //   1571: if_icmpne +1279 -> 2850
    //   1574: iconst_1
    //   1575: istore_1
    //   1576: aload 14
    //   1578: iload_1
    //   1579: putfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1582: aload_3
    //   1583: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1586: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1589: iconst_1
    //   1590: if_icmpne +1265 -> 2855
    //   1593: iconst_1
    //   1594: istore_1
    //   1595: aload 14
    //   1597: iload_1
    //   1598: putfield 578	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1601: aload 14
    //   1603: aload_3
    //   1604: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1607: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1610: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1613: putfield 602	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1616: aload 14
    //   1618: aload_3
    //   1619: getfield 770	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1622: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1625: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1628: putfield 596	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1631: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1634: ifeq +1336 -> 2970
    //   1637: ldc_w 772
    //   1640: iconst_2
    //   1641: new 184	java/lang/StringBuilder
    //   1644: dup
    //   1645: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1648: ldc_w 774
    //   1651: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: iload 5
    //   1656: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1659: ldc_w 776
    //   1662: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: aload_3
    //   1666: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1669: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1672: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1675: ldc_w 778
    //   1678: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: aload_3
    //   1682: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1685: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1688: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1691: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: ldc_w 780
    //   1697: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: aload_0
    //   1701: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1704: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1707: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1713: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1716: aload 14
    //   1718: aload_3
    //   1719: getfield 786	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1722: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1725: putfield 587	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1728: aload_3
    //   1729: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1732: invokevirtual 793	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   1735: ifeq +1342 -> 3077
    //   1738: aload 14
    //   1740: aload_3
    //   1741: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1744: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1747: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1750: getfield 797	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1753: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1756: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1759: putfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1762: aload 14
    //   1764: aload_3
    //   1765: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1768: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1771: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1774: getfield 800	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1777: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1780: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1783: putfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1786: aload 14
    //   1788: aload_3
    //   1789: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1792: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1795: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1798: getfield 803	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1801: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1804: putfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1807: aload 14
    //   1809: aload_3
    //   1810: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1813: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1816: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1819: getfield 806	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1822: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1825: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1828: putfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1831: aload 14
    //   1833: aload_3
    //   1834: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1837: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1840: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1843: getfield 809	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1846: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1849: putfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1852: aload 14
    //   1854: aload_3
    //   1855: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1858: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1861: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1864: getfield 812	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1867: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1870: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1873: aload_3
    //   1874: getfield 815	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1877: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1880: iconst_1
    //   1881: if_icmpne +1560 -> 3441
    //   1884: iconst_1
    //   1885: istore_1
    //   1886: aload 14
    //   1888: iload_1
    //   1889: putfield 818	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   1892: aload 14
    //   1894: aload_3
    //   1895: getfield 821	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1898: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1901: putfield 824	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   1904: aload 14
    //   1906: aload_3
    //   1907: getfield 827	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1910: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1913: putfield 830	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   1916: aload 14
    //   1918: aload_3
    //   1919: getfield 833	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1922: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1925: putfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   1928: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1931: ifeq +104 -> 2035
    //   1934: ldc_w 838
    //   1937: iconst_2
    //   1938: new 184	java/lang/StringBuilder
    //   1941: dup
    //   1942: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1945: ldc_w 840
    //   1948: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: aload 14
    //   1953: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1956: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: ldc_w 842
    //   1962: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: aload 14
    //   1967: getfield 818	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   1970: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1973: ldc_w 847
    //   1976: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: aload 14
    //   1981: invokevirtual 850	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   1984: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1987: ldc_w 852
    //   1990: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: aload 14
    //   1995: getfield 824	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   1998: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: ldc_w 854
    //   2004: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2007: aload 14
    //   2009: getfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   2012: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: ldc_w 856
    //   2018: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: aload 14
    //   2023: getfield 830	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   2026: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2035: aload_3
    //   2036: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2039: invokevirtual 863	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   2042: ifeq +1080 -> 3122
    //   2045: aload 14
    //   2047: aload_3
    //   2048: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2051: getfield 866	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2054: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2057: putfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   2060: aload 14
    //   2062: aload_3
    //   2063: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2066: getfield 872	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2069: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2072: putfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   2075: aload 14
    //   2077: aload_3
    //   2078: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2081: getfield 878	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2084: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2087: putfield 881	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   2090: aload 14
    //   2092: aload_3
    //   2093: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2096: getfield 884	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2099: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2102: putfield 887	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   2105: aload 14
    //   2107: aload_3
    //   2108: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2111: getfield 890	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2114: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2117: putfield 893	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   2120: aload 14
    //   2122: aload_3
    //   2123: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2126: getfield 896	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2129: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2132: putfield 899	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   2135: aload 14
    //   2137: aload_3
    //   2138: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2141: getfield 902	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2144: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2147: putfield 905	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   2150: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2153: ifeq +169 -> 2322
    //   2156: new 184	java/lang/StringBuilder
    //   2159: dup
    //   2160: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2163: astore_3
    //   2164: aload_3
    //   2165: ldc_w 907
    //   2168: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: ldc_w 909
    //   2174: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: aload 14
    //   2179: getfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   2182: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: ldc_w 911
    //   2188: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: ldc_w 913
    //   2194: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: aload 14
    //   2199: getfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   2202: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: ldc_w 911
    //   2208: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2211: ldc_w 915
    //   2214: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: aload 14
    //   2219: getfield 881	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   2222: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: ldc_w 911
    //   2228: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: ldc_w 917
    //   2234: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: aload 14
    //   2239: getfield 887	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   2242: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: ldc_w 911
    //   2248: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: ldc_w 919
    //   2254: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: aload 14
    //   2259: getfield 893	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   2262: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: ldc_w 911
    //   2268: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: ldc_w 921
    //   2274: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: aload 14
    //   2279: getfield 899	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   2282: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: ldc_w 911
    //   2288: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: ldc_w 923
    //   2294: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: aload 14
    //   2299: getfield 905	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   2302: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: ldc_w 911
    //   2308: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: pop
    //   2312: ldc 182
    //   2314: iconst_2
    //   2315: aload_3
    //   2316: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2319: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2322: aload 14
    //   2324: aload_2
    //   2325: getfield 926	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:now_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2328: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2331: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2334: putfield 929	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   2337: new 931	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   2340: dup
    //   2341: invokespecial 932	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   2344: astore_3
    //   2345: aload_3
    //   2346: aload 14
    //   2348: getfield 929	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   2351: invokevirtual 933	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2354: pop
    //   2355: aload_3
    //   2356: astore_2
    //   2357: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2360: ifeq +69 -> 2429
    //   2363: ldc 182
    //   2365: iconst_2
    //   2366: new 184	java/lang/StringBuilder
    //   2369: dup
    //   2370: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2373: ldc_w 935
    //   2376: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2379: aload_3
    //   2380: getfield 938	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2383: invokevirtual 939	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2386: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2389: ldc_w 941
    //   2392: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aload_3
    //   2396: getfield 944	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2399: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2402: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2405: ldc_w 947
    //   2408: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: aload_3
    //   2412: getfield 950	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2415: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2418: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2421: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2424: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2427: aload_3
    //   2428: astore_2
    //   2429: aload 14
    //   2431: aload_2
    //   2432: putfield 954	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   2435: aload_0
    //   2436: bipush 51
    //   2438: iconst_1
    //   2439: aload 14
    //   2441: iload 7
    //   2443: invokevirtual 255	axqt:notifyUI	(IZLjava/lang/Object;Z)V
    //   2446: aload_0
    //   2447: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2450: getstatic 959	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   2453: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2456: checkcast 965	axny
    //   2459: astore_2
    //   2460: iload 5
    //   2462: bipush 51
    //   2464: if_icmpne +723 -> 3187
    //   2467: aload_2
    //   2468: aload 14
    //   2470: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2473: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   2476: invokevirtual 973	axny:b	(Ljava/lang/String;J)V
    //   2479: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2482: ifeq +46 -> 2528
    //   2485: ldc_w 975
    //   2488: iconst_4
    //   2489: new 184	java/lang/StringBuilder
    //   2492: dup
    //   2493: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2496: ldc_w 977
    //   2499: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2502: aload 14
    //   2504: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   2507: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2510: ldc_w 979
    //   2513: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   2519: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2522: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2528: aload_0
    //   2529: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2532: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   2535: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2538: checkcast 984	anvk
    //   2541: astore_2
    //   2542: aload 14
    //   2544: getfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   2547: ifeq +76 -> 2623
    //   2550: aload_2
    //   2551: aload 14
    //   2553: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2556: invokevirtual 987	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2559: astore_3
    //   2560: aload_3
    //   2561: aload 14
    //   2563: getfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   2566: putfield 992	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2569: aload_3
    //   2570: aload 14
    //   2572: getfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   2575: i2l
    //   2576: putfield 995	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2579: aload_0
    //   2580: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2583: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2586: aload_3
    //   2587: getfield 995	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2590: aload_3
    //   2591: getfield 992	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2594: invokestatic 1003	axqc:a	(Ljava/lang/String;JI)Z
    //   2597: pop
    //   2598: aload_2
    //   2599: aload_3
    //   2600: invokevirtual 1006	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   2603: pop
    //   2604: aload_0
    //   2605: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2608: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2611: ldc_w 1008
    //   2614: aload 14
    //   2616: getfield 408	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   2619: invokestatic 1011	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   2622: pop
    //   2623: aload 14
    //   2625: getfield 325	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   2628: ifeq +32 -> 2660
    //   2631: aload 14
    //   2633: getfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2636: ifle +24 -> 2660
    //   2639: aload_0
    //   2640: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2643: getstatic 1017	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   2646: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2649: checkcast 1019	com/tencent/mobileqq/app/HotChatManager
    //   2652: aload 14
    //   2654: getfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2657: invokevirtual 1021	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   2660: aload_2
    //   2661: aload 14
    //   2663: invokevirtual 1024	anvk:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   2666: aload 14
    //   2668: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2671: sipush 1000
    //   2674: if_icmpne +698 -> 3372
    //   2677: aload 15
    //   2679: iconst_0
    //   2680: ldc_w 311
    //   2683: invokevirtual 1029	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2686: aconst_null
    //   2687: aconst_null
    //   2688: aconst_null
    //   2689: aconst_null
    //   2690: aconst_null
    //   2691: aconst_null
    //   2692: aconst_null
    //   2693: invokevirtual 1033	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2696: astore_3
    //   2697: aload_3
    //   2698: ifnull +637 -> 3335
    //   2701: aload_3
    //   2702: astore_2
    //   2703: aload_3
    //   2704: invokeinterface 1038 1 0
    //   2709: istore 4
    //   2711: aload_3
    //   2712: astore_2
    //   2713: aload_3
    //   2714: invokeinterface 1041 1 0
    //   2719: pop
    //   2720: iload 4
    //   2722: sipush 200
    //   2725: if_icmple +610 -> 3335
    //   2728: iload 4
    //   2730: bipush 100
    //   2732: if_icmple +481 -> 3213
    //   2735: aload_3
    //   2736: astore_2
    //   2737: aload_3
    //   2738: invokeinterface 1044 1 0
    //   2743: pop
    //   2744: iload 4
    //   2746: iconst_1
    //   2747: isub
    //   2748: istore 4
    //   2750: goto -22 -> 2728
    //   2753: astore_3
    //   2754: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2757: ifeq -1569 -> 1188
    //   2760: ldc 182
    //   2762: iconst_2
    //   2763: new 184	java/lang/StringBuilder
    //   2766: dup
    //   2767: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2770: ldc_w 1046
    //   2773: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: aload_3
    //   2777: invokevirtual 1049	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2780: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2783: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2786: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2789: goto -1601 -> 1188
    //   2792: aload 14
    //   2794: iconst_0
    //   2795: putfield 660	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   2798: goto -1529 -> 1269
    //   2801: aload 14
    //   2803: iconst_0
    //   2804: putfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   2807: goto -1518 -> 1289
    //   2810: astore_3
    //   2811: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2814: ifeq -1430 -> 1384
    //   2817: ldc_w 1051
    //   2820: iconst_2
    //   2821: aload_3
    //   2822: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   2825: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2828: goto -1444 -> 1384
    //   2831: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2834: ifeq -1450 -> 1384
    //   2837: ldc_w 640
    //   2840: iconst_2
    //   2841: ldc_w 1054
    //   2844: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2847: goto -1463 -> 1384
    //   2850: iconst_0
    //   2851: istore_1
    //   2852: goto -1276 -> 1576
    //   2855: iconst_0
    //   2856: istore_1
    //   2857: goto -1262 -> 1595
    //   2860: aload 14
    //   2862: aload_3
    //   2863: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2866: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2869: putfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   2872: aload 14
    //   2874: getfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   2877: iconst_1
    //   2878: if_icmpne +82 -> 2960
    //   2881: iconst_1
    //   2882: istore_1
    //   2883: aload 14
    //   2885: iload_1
    //   2886: putfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   2889: aload_3
    //   2890: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2893: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2896: iconst_1
    //   2897: if_icmpne +68 -> 2965
    //   2900: iconst_1
    //   2901: istore_1
    //   2902: aload 14
    //   2904: iload_1
    //   2905: putfield 575	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   2908: aload 14
    //   2910: aload_3
    //   2911: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2914: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2917: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2920: putfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   2923: aload 14
    //   2925: aload_3
    //   2926: getfield 770	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2929: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2932: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2935: putfield 593	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   2938: goto -1307 -> 1631
    //   2941: astore_3
    //   2942: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2945: ifeq -623 -> 2322
    //   2948: ldc 182
    //   2950: iconst_2
    //   2951: ldc_w 1056
    //   2954: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2957: goto -635 -> 2322
    //   2960: iconst_0
    //   2961: istore_1
    //   2962: goto -79 -> 2883
    //   2965: iconst_0
    //   2966: istore_1
    //   2967: goto -65 -> 2902
    //   2970: ldc_w 772
    //   2973: iconst_1
    //   2974: new 184	java/lang/StringBuilder
    //   2977: dup
    //   2978: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2981: ldc_w 774
    //   2984: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2987: iload 5
    //   2989: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2992: ldc_w 776
    //   2995: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: aload_3
    //   2999: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3002: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3005: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3008: ldc_w 778
    //   3011: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3014: aload_3
    //   3015: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3018: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3021: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3024: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3027: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3030: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3033: goto -1317 -> 1716
    //   3036: astore 17
    //   3038: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3041: ifeq -1325 -> 1716
    //   3044: ldc 182
    //   3046: iconst_2
    //   3047: new 184	java/lang/StringBuilder
    //   3050: dup
    //   3051: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3054: ldc_w 1058
    //   3057: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3060: aload 17
    //   3062: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   3065: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3068: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3071: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3074: goto -1358 -> 1716
    //   3077: aload 14
    //   3079: ldc_w 489
    //   3082: putfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3085: aload 14
    //   3087: ldc_w 489
    //   3090: putfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3093: aload 14
    //   3095: iconst_0
    //   3096: putfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3099: aload 14
    //   3101: ldc_w 489
    //   3104: putfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3107: aload 14
    //   3109: iconst_0
    //   3110: putfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3113: aload 14
    //   3115: iconst_0
    //   3116: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3119: goto -1246 -> 1873
    //   3122: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3125: ifeq -803 -> 2322
    //   3128: ldc 182
    //   3130: iconst_2
    //   3131: ldc_w 1060
    //   3134: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3137: goto -815 -> 2322
    //   3140: astore 17
    //   3142: aconst_null
    //   3143: astore_3
    //   3144: aload_3
    //   3145: astore_2
    //   3146: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3149: ifeq -720 -> 2429
    //   3152: ldc 182
    //   3154: iconst_2
    //   3155: new 184	java/lang/StringBuilder
    //   3158: dup
    //   3159: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3162: ldc_w 1062
    //   3165: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: aload 17
    //   3170: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   3173: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3176: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3179: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3182: aload_3
    //   3183: astore_2
    //   3184: goto -755 -> 2429
    //   3187: aload_2
    //   3188: aload 14
    //   3190: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   3193: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3196: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   3199: invokevirtual 1067	axny:a	(Ljava/lang/String;J)V
    //   3202: goto -723 -> 2479
    //   3205: astore_3
    //   3206: aload_3
    //   3207: invokevirtual 1070	java/lang/Exception:printStackTrace	()V
    //   3210: goto -587 -> 2623
    //   3213: aload_3
    //   3214: astore_2
    //   3215: aload_3
    //   3216: aload_3
    //   3217: ldc_w 1072
    //   3220: invokeinterface 1075 2 0
    //   3225: invokeinterface 1078 2 0
    //   3230: istore 4
    //   3232: aload_3
    //   3233: astore_2
    //   3234: new 184	java/lang/StringBuilder
    //   3237: dup
    //   3238: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3241: astore 17
    //   3243: aload_3
    //   3244: astore_2
    //   3245: aload 17
    //   3247: ldc_w 1080
    //   3250: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3253: pop
    //   3254: aload_3
    //   3255: astore_2
    //   3256: aload 17
    //   3258: ldc_w 311
    //   3261: invokevirtual 1029	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3264: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3267: pop
    //   3268: aload_3
    //   3269: astore_2
    //   3270: aload 17
    //   3272: ldc_w 1082
    //   3275: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3278: pop
    //   3279: aload_3
    //   3280: astore_2
    //   3281: aload 17
    //   3283: ldc_w 1072
    //   3286: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3289: pop
    //   3290: aload_3
    //   3291: astore_2
    //   3292: aload 17
    //   3294: ldc_w 1084
    //   3297: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3300: pop
    //   3301: aload_3
    //   3302: astore_2
    //   3303: aload 17
    //   3305: iload 4
    //   3307: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3310: pop
    //   3311: aload_3
    //   3312: astore_2
    //   3313: aload 17
    //   3315: ldc_w 1086
    //   3318: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: pop
    //   3322: aload_3
    //   3323: astore_2
    //   3324: aload 15
    //   3326: aload 17
    //   3328: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3331: invokevirtual 1089	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   3334: pop
    //   3335: aload_3
    //   3336: astore_2
    //   3337: aload 15
    //   3339: aload 14
    //   3341: invokevirtual 1093	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   3344: aload_3
    //   3345: astore_2
    //   3346: aload 16
    //   3348: invokevirtual 1096	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   3351: aload_3
    //   3352: ifnull +9 -> 3361
    //   3355: aload_3
    //   3356: invokeinterface 1099 1 0
    //   3361: aload 16
    //   3363: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   3366: aload 15
    //   3368: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   3371: return
    //   3372: aload 14
    //   3374: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3377: sipush 1001
    //   3380: if_icmpeq +14 -> 3394
    //   3383: aload 14
    //   3385: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3388: sipush 1002
    //   3391: if_icmpne +11 -> 3402
    //   3394: aload 15
    //   3396: aload 14
    //   3398: invokevirtual 1107	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   3401: pop
    //   3402: aconst_null
    //   3403: astore_3
    //   3404: goto -60 -> 3344
    //   3407: astore_3
    //   3408: aconst_null
    //   3409: astore_2
    //   3410: aload_2
    //   3411: ifnull +9 -> 3420
    //   3414: aload_2
    //   3415: invokeinterface 1099 1 0
    //   3420: aload 16
    //   3422: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   3425: aload 15
    //   3427: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   3430: aload_3
    //   3431: athrow
    //   3432: astore_3
    //   3433: goto -23 -> 3410
    //   3436: aconst_null
    //   3437: astore_3
    //   3438: goto -3256 -> 182
    //   3441: iconst_0
    //   3442: istore_1
    //   3443: goto -1557 -> 1886
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3446	0	this	axqt
    //   0	3446	1	paramBoolean	boolean
    //   0	3446	2	paramRespNearbySummaryCard	com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard
    //   0	3446	3	paramBundle	Bundle
    //   148	3158	4	i	int
    //   14	2974	5	j	int
    //   862	173	6	k	int
    //   6	2436	7	bool	boolean
    //   130	1243	8	l1	long
    //   139	704	10	l2	long
    //   868	174	12	l3	long
    //   193	3204	14	localNearbyPeopleCard	NearbyPeopleCard
    //   108	3318	15	localEntityManager	EntityManager
    //   115	3306	16	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   708	473	17	localObject1	Object
    //   3036	25	17	localException1	Exception
    //   3140	29	17	localException2	Exception
    //   3241	86	17	localStringBuilder	StringBuilder
    //   734	73	18	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1094	1112	1115	java/lang/Exception
    //   710	761	2753	java/lang/Exception
    //   764	812	2753	java/lang/Exception
    //   1178	1188	2753	java/lang/Exception
    //   1344	1384	2810	java/lang/Exception
    //   1546	1556	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1563	1574	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1576	1593	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1595	1631	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1631	1716	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1716	1873	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1873	1884	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1886	2035	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2035	2322	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2860	2881	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2883	2900	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2902	2938	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2970	3033	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3038	3074	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3077	3119	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3122	3137	2941	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1631	1716	3036	java/lang/Exception
    //   2970	3033	3036	java/lang/Exception
    //   2337	2355	3140	java/lang/Exception
    //   2357	2427	3140	java/lang/Exception
    //   2598	2623	3205	java/lang/Exception
    //   2666	2697	3407	finally
    //   3372	3394	3407	finally
    //   3394	3402	3407	finally
    //   2703	2711	3432	finally
    //   2713	2720	3432	finally
    //   2737	2744	3432	finally
    //   3215	3232	3432	finally
    //   3234	3243	3432	finally
    //   3245	3254	3432	finally
    //   3256	3268	3432	finally
    //   3270	3279	3432	finally
    //   3281	3290	3432	finally
    //   3292	3301	3432	finally
    //   3303	3311	3432	finally
    //   3313	3322	3432	finally
    //   3324	3335	3432	finally
    //   3337	3344	3432	finally
    //   3346	3351	3432	finally
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      notifyUI(57, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            notifyUI(57, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        notifyUI(57, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          notifyUI(57, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
            i += 1;
          }
          notifyUI(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          notifyUI(57, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, Object paramObject, Bundle paramBundle, SummaryCard.RespHead paramRespHead)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 239
    //   3: invokevirtual 245	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 12
    //   8: aload_3
    //   9: ldc 247
    //   11: invokevirtual 251	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   14: istore 8
    //   16: iload_1
    //   17: ifeq +5699 -> 5716
    //   20: aload_2
    //   21: checkcast 1215	SummaryCard/RespSummaryCard
    //   24: astore 16
    //   26: aload_0
    //   27: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 280	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   33: invokevirtual 286	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: astore 13
    //   38: aload 13
    //   40: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 14
    //   45: aload 14
    //   47: invokevirtual 297	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   50: aload_3
    //   51: ldc_w 299
    //   54: lconst_0
    //   55: invokevirtual 303	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   58: lstore 10
    //   60: aload_3
    //   61: ldc_w 305
    //   64: invokevirtual 307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   67: pop2
    //   68: aload_3
    //   69: ldc_w 309
    //   72: invokevirtual 251	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   75: pop
    //   76: iconst_0
    //   77: ifne +807 -> 884
    //   80: new 311	com/tencent/mobileqq/data/NearbyPeopleCard
    //   83: dup
    //   84: invokespecial 321	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   87: astore 15
    //   89: aload 16
    //   91: getfield 1219	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   94: astore_2
    //   95: aload 15
    //   97: aload 16
    //   99: getfield 1222	SummaryCard/RespSummaryCard:lUIN	J
    //   102: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   105: putfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   108: lload 10
    //   110: lconst_0
    //   111: lcmp
    //   112: ifle +780 -> 892
    //   115: aload 15
    //   117: lload 10
    //   119: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   122: aload 15
    //   124: aload_3
    //   125: ldc_w 305
    //   128: invokevirtual 307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   131: putfield 336	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   134: aload 15
    //   136: aload_3
    //   137: ldc_w 309
    //   140: invokevirtual 251	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   143: putfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   146: iload 8
    //   148: ifeq +21 -> 169
    //   151: aload 15
    //   153: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   160: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   163: invokevirtual 1225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +738 -> 904
    //   169: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +48 -> 220
    //   175: ldc_w 640
    //   178: iconst_2
    //   179: new 184	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 1227
    //   189: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 16
    //   194: getfield 1230	SummaryCard/RespSummaryCard:iVoteCount	I
    //   197: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 754
    //   203: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 16
    //   208: getfield 1233	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   211: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload 15
    //   222: aload 16
    //   224: getfield 1230	SummaryCard/RespSummaryCard:iVoteCount	I
    //   227: putfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   230: aload 15
    //   232: aload 16
    //   234: getfield 1233	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   237: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   240: aload 15
    //   242: aload 16
    //   244: getfield 1237	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   247: putfield 1240	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   250: aload 15
    //   252: aload 16
    //   254: getfield 1243	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   257: putfield 342	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   260: aload 15
    //   262: aload 16
    //   264: getfield 1246	SummaryCard/RespSummaryCard:vRichSign	[B
    //   267: putfield 353	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   270: aload 15
    //   272: aload_2
    //   273: getfield 1251	SummaryCard/DateCard:bMarriage	B
    //   276: putfield 414	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   279: aload 15
    //   281: aload 16
    //   283: getfield 1254	SummaryCard/RespSummaryCard:bSex	B
    //   286: putfield 357	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   289: aload 15
    //   291: aload 16
    //   293: getfield 1257	SummaryCard/RespSummaryCard:bAge	B
    //   296: putfield 368	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   299: aload 15
    //   301: aload 16
    //   303: getfield 1260	SummaryCard/RespSummaryCard:iBirthday	I
    //   306: putfield 374	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   309: aload 15
    //   311: aload_2
    //   312: getfield 1263	SummaryCard/DateCard:uProfession	J
    //   315: l2i
    //   316: putfield 381	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   319: aload 15
    //   321: aload_2
    //   322: getfield 1266	SummaryCard/DateCard:bConstellation	B
    //   325: putfield 386	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   328: aload 15
    //   330: aload_2
    //   331: getfield 1269	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   334: putfield 391	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   337: aload 15
    //   339: aload_2
    //   340: getfield 1272	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   343: putfield 397	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   346: aload 15
    //   348: aload 16
    //   350: getfield 1275	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   353: putfield 1278	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   356: aload 15
    //   358: aload_2
    //   359: getfield 1281	SummaryCard/DateCard:vDateInfo	[B
    //   362: putfield 1284	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   365: aload 15
    //   367: aload_2
    //   368: getfield 1287	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   371: putfield 402	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   374: aload 15
    //   376: aload_2
    //   377: getfield 1290	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   380: putfield 408	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   383: aload 15
    //   385: aload_2
    //   386: getfield 1293	SummaryCard/DateCard:uHomeCountry	J
    //   389: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   392: putfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   395: aload 15
    //   397: aload_2
    //   398: getfield 1296	SummaryCard/DateCard:uHomeProvince	J
    //   401: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   404: putfield 442	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   407: aload 15
    //   409: aload_2
    //   410: getfield 1299	SummaryCard/DateCard:uHomeCity	J
    //   413: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   416: putfield 448	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   419: aload 15
    //   421: aload_2
    //   422: getfield 1302	SummaryCard/DateCard:uHomeZone	J
    //   425: invokestatic 433	anrz:a	(J)Ljava/lang/String;
    //   428: putfield 454	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   431: aload 15
    //   433: aload 16
    //   435: getfield 1305	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   438: putfield 1308	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   441: aload 15
    //   443: aload 16
    //   445: getfield 1311	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   448: putfield 1314	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   451: aload 15
    //   453: aload 16
    //   455: getfield 1317	SummaryCard/RespSummaryCard:ulShowControl	J
    //   458: putfield 1320	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   461: aload 15
    //   463: aload 16
    //   465: getfield 1323	SummaryCard/RespSummaryCard:lUserFlag	J
    //   468: putfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   471: aload 15
    //   473: aload 16
    //   475: getfield 1326	SummaryCard/RespSummaryCard:vSeed	[B
    //   478: putfield 1327	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   481: aload 15
    //   483: aload 16
    //   485: getfield 1330	SummaryCard/RespSummaryCard:lCacheControl	J
    //   488: invokevirtual 1333	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   491: aload 15
    //   493: invokestatic 459	java/lang/System:currentTimeMillis	()J
    //   496: putfield 462	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   499: aload 15
    //   501: iload 8
    //   503: putfield 483	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   506: aload 15
    //   508: aload 16
    //   510: getfield 1334	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   513: putfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   516: aload 15
    //   518: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   521: ifnull +406 -> 927
    //   524: aload 15
    //   526: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   529: arraylength
    //   530: ifne +63 -> 593
    //   533: aload_0
    //   534: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   537: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   540: aload 15
    //   542: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   545: invokestatic 1339	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   548: ifne +45 -> 593
    //   551: aload_0
    //   552: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   555: ldc_w 485
    //   558: ldc_w 487
    //   561: ldc_w 489
    //   564: ldc_w 491
    //   567: ldc_w 493
    //   570: iconst_0
    //   571: iconst_0
    //   572: aload_0
    //   573: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   576: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   579: aload 15
    //   581: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   584: ldc_w 489
    //   587: ldc_w 489
    //   590: invokestatic 499	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload_0
    //   594: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   597: invokevirtual 503	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   600: aload 15
    //   602: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   605: invokevirtual 509	bcrg:n	(Ljava/lang/String;)[B
    //   608: ifnonnull +23 -> 631
    //   611: aload_0
    //   612: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   615: invokevirtual 503	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   618: aload 15
    //   620: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   623: aload 15
    //   625: getfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   628: invokevirtual 513	bcrg:h	(Ljava/lang/String;[B)V
    //   631: aload 15
    //   633: aload_2
    //   634: getfield 1342	SummaryCard/DateCard:uSchoolId	J
    //   637: putfield 420	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   640: aload 15
    //   642: aload_2
    //   643: getfield 1345	SummaryCard/DateCard:vGroupList	[B
    //   646: putfield 1346	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   649: aload 15
    //   651: aload_2
    //   652: getfield 1349	SummaryCard/DateCard:vNearbyInfo	[B
    //   655: putfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   658: aload 15
    //   660: aload_2
    //   661: getfield 1352	SummaryCard/DateCard:vActivityList	[B
    //   664: putfield 1353	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   667: aload 15
    //   669: aload 16
    //   671: getfield 1323	SummaryCard/RespSummaryCard:lUserFlag	J
    //   674: putfield 1354	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   677: aload 15
    //   679: aload 16
    //   681: getfield 1357	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   684: putfield 1358	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   687: aload 16
    //   689: getfield 1362	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   692: ifnull +16 -> 708
    //   695: aload 15
    //   697: aload 16
    //   699: getfield 1362	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   702: getfield 1367	SummaryCard/HeartInfo:iHeartCount	I
    //   705: putfield 1370	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   708: aload 16
    //   710: getfield 1374	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   713: ifnull +259 -> 972
    //   716: aload 15
    //   718: aload 16
    //   720: getfield 1374	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   723: getfield 1379	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   726: putfield 1382	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   729: aload 15
    //   731: aload 16
    //   733: getfield 1374	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   736: getfield 1385	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   739: putfield 1386	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   742: aload 16
    //   744: getfield 1389	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   747: astore_3
    //   748: aload_3
    //   749: ifnull +269 -> 1018
    //   752: aload 15
    //   754: new 518	java/util/ArrayList
    //   757: dup
    //   758: invokespecial 519	java/util/ArrayList:<init>	()V
    //   761: putfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   764: new 525	appoint/define/appoint_define$CommonLabel
    //   767: dup
    //   768: invokespecial 526	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   771: astore 17
    //   773: aload 17
    //   775: aload_3
    //   776: invokevirtual 530	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   779: pop
    //   780: aload 17
    //   782: getfield 534	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   785: invokevirtual 539	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   788: astore_3
    //   789: aload 17
    //   791: getfield 542	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   794: invokevirtual 539	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   797: astore 18
    //   799: new 544	org/json/JSONArray
    //   802: dup
    //   803: invokespecial 545	org/json/JSONArray:<init>	()V
    //   806: astore 17
    //   808: aload_3
    //   809: invokeinterface 550 1 0
    //   814: aload 18
    //   816: invokeinterface 550 1 0
    //   821: if_icmpne +187 -> 1008
    //   824: iconst_0
    //   825: istore 5
    //   827: iload 5
    //   829: aload_3
    //   830: invokeinterface 550 1 0
    //   835: if_icmpge +173 -> 1008
    //   838: aload_3
    //   839: iload 5
    //   841: invokeinterface 553 2 0
    //   846: checkcast 44	com/tencent/mobileqq/pb/ByteStringMicro
    //   849: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   852: astore 18
    //   854: aload 15
    //   856: getfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   859: aload 18
    //   861: invokeinterface 560 2 0
    //   866: pop
    //   867: aload 17
    //   869: aload 18
    //   871: invokevirtual 564	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   874: pop
    //   875: iload 5
    //   877: iconst_1
    //   878: iadd
    //   879: istore 5
    //   881: goto -54 -> 827
    //   884: new 1110	java/lang/NullPointerException
    //   887: dup
    //   888: invokespecial 1390	java/lang/NullPointerException:<init>	()V
    //   891: athrow
    //   892: aload 15
    //   894: aload_2
    //   895: getfield 1393	SummaryCard/DateCard:lTinyId	J
    //   898: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   901: goto -779 -> 122
    //   904: aload 15
    //   906: aload 16
    //   908: getfield 1230	SummaryCard/RespSummaryCard:iVoteCount	I
    //   911: putfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   914: aload 15
    //   916: aload 16
    //   918: getfield 1233	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   921: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   924: goto -674 -> 250
    //   927: aload_0
    //   928: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   931: ldc_w 485
    //   934: ldc_w 487
    //   937: ldc_w 489
    //   940: ldc_w 491
    //   943: ldc_w 630
    //   946: iconst_0
    //   947: iconst_0
    //   948: aload_0
    //   949: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   952: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   955: aload 15
    //   957: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   960: ldc_w 489
    //   963: ldc_w 489
    //   966: invokestatic 499	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   969: goto -338 -> 631
    //   972: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   975: ifeq -233 -> 742
    //   978: ldc_w 640
    //   981: iconst_2
    //   982: new 184	java/lang/StringBuilder
    //   985: dup
    //   986: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   989: ldc_w 1395
    //   992: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aconst_null
    //   996: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   999: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: goto -263 -> 742
    //   1008: aload 15
    //   1010: aload 17
    //   1012: invokevirtual 631	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1015: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1018: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1021: ifeq +33 -> 1054
    //   1024: ldc_w 640
    //   1027: iconst_4
    //   1028: new 184	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 642
    //   1038: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload_2
    //   1042: getfield 1342	SummaryCard/DateCard:uSchoolId	J
    //   1045: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: aload 15
    //   1056: aload 16
    //   1058: getfield 1401	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1061: putfield 1402	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1064: aload 15
    //   1066: aload 16
    //   1068: getfield 1406	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1071: putfield 1407	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1074: aload 15
    //   1076: aload 16
    //   1078: getfield 1410	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1081: putfield 1411	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1084: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +61 -> 1148
    //   1090: ldc 182
    //   1092: iconst_2
    //   1093: new 184	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1100: ldc_w 1413
    //   1103: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload 16
    //   1108: getfield 1401	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1111: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: ldc_w 1415
    //   1117: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: aload 16
    //   1122: getfield 1406	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1125: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1128: ldc_w 1417
    //   1131: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: aload 16
    //   1136: getfield 1410	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1139: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: aload 16
    //   1150: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1153: ifnull +58 -> 1211
    //   1156: aload 15
    //   1158: aload 16
    //   1160: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1163: getfield 1426	SummaryCard/PanSocialInfo:uCharm	J
    //   1166: putfield 1429	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1169: aload 15
    //   1171: aload 16
    //   1173: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1176: getfield 1432	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1179: l2i
    //   1180: putfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1183: aload 15
    //   1185: aload 16
    //   1187: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1190: getfield 1435	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1193: l2i
    //   1194: putfield 1438	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1197: aload 15
    //   1199: aload 16
    //   1201: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1204: getfield 1441	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1207: l2i
    //   1208: putfield 1444	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1211: iload 8
    //   1213: ifeq +21 -> 1234
    //   1216: aload 15
    //   1218: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1221: aload_0
    //   1222: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1228: invokevirtual 1225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1231: ifeq +250 -> 1481
    //   1234: iconst_1
    //   1235: istore_1
    //   1236: aload 15
    //   1238: aload_2
    //   1239: getfield 1447	SummaryCard/DateCard:vFaces	[B
    //   1242: aload 16
    //   1244: getfield 1451	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1247: iload_1
    //   1248: invokevirtual 652	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1251: pop
    //   1252: aload 15
    //   1254: aload 16
    //   1256: getfield 1455	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1259: getfield 1460	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1262: putfield 1461	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1265: aload 16
    //   1267: getfield 1464	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1270: ifne +216 -> 1486
    //   1273: aload 15
    //   1275: iconst_1
    //   1276: putfield 1467	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1279: aload 4
    //   1281: ifnull +13 -> 1294
    //   1284: aload 15
    //   1286: aload 4
    //   1288: getfield 1472	SummaryCard/RespHead:vCookies	[B
    //   1291: putfield 1473	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1294: aload 15
    //   1296: getfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1299: ldc2_w 656
    //   1302: land
    //   1303: lconst_0
    //   1304: lcmp
    //   1305: ifeq +190 -> 1495
    //   1308: aload 15
    //   1310: iconst_1
    //   1311: putfield 660	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1314: aload 15
    //   1316: getfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1319: ldc2_w 661
    //   1322: land
    //   1323: lconst_0
    //   1324: lcmp
    //   1325: ifeq +179 -> 1504
    //   1328: aload 15
    //   1330: iconst_1
    //   1331: putfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1334: aload 15
    //   1336: invokevirtual 668	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1339: ifne +232 -> 1571
    //   1342: aload 15
    //   1344: ldc_w 489
    //   1347: putfield 671	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1350: aload 15
    //   1352: ldc_w 489
    //   1355: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1358: aload 15
    //   1360: ldc_w 489
    //   1363: putfield 677	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1366: aload 16
    //   1368: getfield 1477	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1371: astore_2
    //   1372: aload_2
    //   1373: ifnull +198 -> 1571
    //   1376: aload_2
    //   1377: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1380: ifnull +191 -> 1571
    //   1383: aload_2
    //   1384: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1387: invokevirtual 1483	java/util/ArrayList:size	()I
    //   1390: ifle +181 -> 1571
    //   1393: iconst_0
    //   1394: istore 5
    //   1396: iload 5
    //   1398: aload_2
    //   1399: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1402: invokevirtual 1483	java/util/ArrayList:size	()I
    //   1405: if_icmpge +166 -> 1571
    //   1408: iload 5
    //   1410: ifne +103 -> 1513
    //   1413: aload 15
    //   1415: aload_2
    //   1416: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1419: iload 5
    //   1421: invokevirtual 1484	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1424: checkcast 1486	SummaryCard/PhotoInfo
    //   1427: getfield 1489	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1430: putfield 671	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1433: iload 5
    //   1435: iconst_1
    //   1436: iadd
    //   1437: istore 5
    //   1439: goto -43 -> 1396
    //   1442: astore_3
    //   1443: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1446: ifeq -428 -> 1018
    //   1449: ldc 182
    //   1451: iconst_2
    //   1452: new 184	java/lang/StringBuilder
    //   1455: dup
    //   1456: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1459: ldc_w 1046
    //   1462: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: aload_3
    //   1466: invokevirtual 1049	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1469: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1475: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1478: goto -460 -> 1018
    //   1481: iconst_0
    //   1482: istore_1
    //   1483: goto -247 -> 1236
    //   1486: aload 15
    //   1488: iconst_0
    //   1489: putfield 1467	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1492: goto -213 -> 1279
    //   1495: aload 15
    //   1497: iconst_0
    //   1498: putfield 660	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1501: goto -187 -> 1314
    //   1504: aload 15
    //   1506: iconst_0
    //   1507: putfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1510: goto -176 -> 1334
    //   1513: iload 5
    //   1515: iconst_1
    //   1516: if_icmpne +26 -> 1542
    //   1519: aload 15
    //   1521: aload_2
    //   1522: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1525: iload 5
    //   1527: invokevirtual 1484	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1530: checkcast 1486	SummaryCard/PhotoInfo
    //   1533: getfield 1489	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1536: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1539: goto -106 -> 1433
    //   1542: iload 5
    //   1544: iconst_2
    //   1545: if_icmpne -112 -> 1433
    //   1548: aload 15
    //   1550: aload_2
    //   1551: getfield 1482	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1554: iload 5
    //   1556: invokevirtual 1484	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1559: checkcast 1486	SummaryCard/PhotoInfo
    //   1562: getfield 1489	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1565: putfield 677	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1568: goto -135 -> 1433
    //   1571: aload 16
    //   1573: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1576: astore_2
    //   1577: aload_2
    //   1578: ifnull +27 -> 1605
    //   1581: aload_2
    //   1582: getfield 1492	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1585: lconst_1
    //   1586: lcmp
    //   1587: ifne +153 -> 1740
    //   1590: aload 15
    //   1592: iconst_1
    //   1593: putfield 1495	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1596: aload 15
    //   1598: aload_2
    //   1599: getfield 1498	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1602: putfield 1499	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1605: aload 16
    //   1607: getfield 1502	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1610: ifnull +30 -> 1640
    //   1613: aload 15
    //   1615: aload_0
    //   1616: aload 16
    //   1618: getfield 1502	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1621: ldc_w 1504
    //   1624: new 1506	GameCenter/RespLastGameInfo
    //   1627: dup
    //   1628: invokespecial 1507	GameCenter/RespLastGameInfo:<init>	()V
    //   1631: invokevirtual 1511	axqt:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1634: checkcast 1506	GameCenter/RespLastGameInfo
    //   1637: invokevirtual 1515	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1640: aload 16
    //   1642: getfield 1421	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1645: astore_2
    //   1646: aload_2
    //   1647: ifnull +13 -> 1660
    //   1650: aload 15
    //   1652: aload_2
    //   1653: getfield 1518	SummaryCard/PanSocialInfo:uChatflag	J
    //   1656: l2i
    //   1657: putfield 1521	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1660: new 518	java/util/ArrayList
    //   1663: dup
    //   1664: invokespecial 519	java/util/ArrayList:<init>	()V
    //   1667: astore_2
    //   1668: aload 16
    //   1670: getfield 1524	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1673: ifnull +747 -> 2420
    //   1676: aload 16
    //   1678: getfield 1524	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1681: invokevirtual 1483	java/util/ArrayList:size	()I
    //   1684: ifle +736 -> 2420
    //   1687: iconst_0
    //   1688: istore 5
    //   1690: iload 5
    //   1692: aload 16
    //   1694: getfield 1524	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1697: invokevirtual 1483	java/util/ArrayList:size	()I
    //   1700: if_icmpge +720 -> 2420
    //   1703: aload 16
    //   1705: getfield 1524	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1708: iload 5
    //   1710: invokevirtual 1484	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1713: checkcast 1525	[B
    //   1716: astore_3
    //   1717: aload_3
    //   1718: ifnonnull +31 -> 1749
    //   1721: iconst_0
    //   1722: istore 6
    //   1724: iload 6
    //   1726: bipush 10
    //   1728: if_icmpgt +28 -> 1756
    //   1731: iload 5
    //   1733: iconst_1
    //   1734: iadd
    //   1735: istore 5
    //   1737: goto -47 -> 1690
    //   1740: aload 15
    //   1742: iconst_0
    //   1743: putfield 1495	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1746: goto -150 -> 1596
    //   1749: aload_3
    //   1750: arraylength
    //   1751: istore 6
    //   1753: goto -29 -> 1724
    //   1756: aload_3
    //   1757: iconst_1
    //   1758: invokestatic 1531	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1761: l2i
    //   1762: istore 7
    //   1764: aload_3
    //   1765: iconst_5
    //   1766: invokestatic 1531	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1769: l2i
    //   1770: istore 9
    //   1772: iload 7
    //   1774: ifle -43 -> 1731
    //   1777: iload 7
    //   1779: bipush 9
    //   1781: iadd
    //   1782: iload 6
    //   1784: if_icmpge -53 -> 1731
    //   1787: iload 7
    //   1789: newarray byte
    //   1791: astore 4
    //   1793: aload 4
    //   1795: iconst_0
    //   1796: aload_3
    //   1797: bipush 9
    //   1799: iload 7
    //   1801: invokestatic 1535	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   1804: new 1537	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1807: dup
    //   1808: invokespecial 1538	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1811: astore_3
    //   1812: aload_3
    //   1813: aload 4
    //   1815: invokevirtual 1539	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1818: pop
    //   1819: aload_3
    //   1820: getfield 1542	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1823: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1826: istore 9
    //   1828: new 1544	azrp
    //   1831: dup
    //   1832: invokespecial 1545	azrp:<init>	()V
    //   1835: astore 22
    //   1837: iload 9
    //   1839: ifne +485 -> 2324
    //   1842: aload 22
    //   1844: aload_3
    //   1845: getfield 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1848: getfield 1554	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1851: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1854: putfield 1556	azrp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1857: aload 22
    //   1859: aload_3
    //   1860: getfield 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1863: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1866: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1869: putfield 1561	azrp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1872: aload 22
    //   1874: aload_3
    //   1875: getfield 1564	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1878: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1881: putfield 1566	azrp:jdField_a_of_type_Int	I
    //   1884: new 518	java/util/ArrayList
    //   1887: dup
    //   1888: invokespecial 519	java/util/ArrayList:<init>	()V
    //   1891: astore 18
    //   1893: iconst_0
    //   1894: istore 6
    //   1896: iload 6
    //   1898: aload_3
    //   1899: getfield 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1902: getfield 1569	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1905: invokevirtual 1570	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1908: if_icmpge +409 -> 2317
    //   1911: aload_3
    //   1912: getfield 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1915: getfield 1569	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1918: iload 6
    //   1920: invokevirtual 1573	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1923: checkcast 1575	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   1926: astore 19
    //   1928: new 1577	azrq
    //   1931: dup
    //   1932: invokespecial 1578	azrq:<init>	()V
    //   1935: astore 4
    //   1937: aload 4
    //   1939: aload 19
    //   1941: getfield 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1944: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1947: putfield 1582	azrq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1950: aload 4
    //   1952: aload 19
    //   1954: getfield 1585	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1957: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1960: putfield 1586	azrq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1963: aload 4
    //   1965: aload 19
    //   1967: getfield 1589	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1970: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1973: putfield 1591	azrq:c	Ljava/lang/String;
    //   1976: aload 4
    //   1978: aload 19
    //   1980: getfield 1594	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1983: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1986: putfield 1596	azrq:d	Ljava/lang/String;
    //   1989: aload 4
    //   1991: aload 19
    //   1993: getfield 1599	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1996: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1999: putfield 1601	azrq:e	Ljava/lang/String;
    //   2002: aload 4
    //   2004: aload 19
    //   2006: getfield 1604	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2009: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2012: putfield 1606	azrq:f	Ljava/lang/String;
    //   2015: aload 4
    //   2017: aload 19
    //   2019: getfield 1609	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2022: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2025: putfield 1611	azrq:jdField_a_of_type_Long	J
    //   2028: aload 4
    //   2030: aload 22
    //   2032: getfield 1566	azrp:jdField_a_of_type_Int	I
    //   2035: putfield 1612	azrq:jdField_a_of_type_Int	I
    //   2038: aload 19
    //   2040: getfield 1615	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2043: invokevirtual 1570	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2046: ifle +254 -> 2300
    //   2049: new 518	java/util/ArrayList
    //   2052: dup
    //   2053: invokespecial 519	java/util/ArrayList:<init>	()V
    //   2056: astore 21
    //   2058: iconst_0
    //   2059: istore 7
    //   2061: iload 7
    //   2063: aload 19
    //   2065: getfield 1615	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2068: invokevirtual 1570	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2071: if_icmpge +222 -> 2293
    //   2074: aload 19
    //   2076: getfield 1615	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2079: iload 7
    //   2081: invokevirtual 1573	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2084: checkcast 1617	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2087: astore 17
    //   2089: new 1619	azro
    //   2092: dup
    //   2093: invokespecial 1620	azro:<init>	()V
    //   2096: astore 20
    //   2098: aload 20
    //   2100: aload 17
    //   2102: getfield 1623	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2105: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2108: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2111: putfield 1624	azro:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2114: aload 20
    //   2116: aload 17
    //   2118: getfield 1627	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2121: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2124: i2l
    //   2125: putfield 1628	azro:jdField_a_of_type_Long	J
    //   2128: aload 20
    //   2130: aload 17
    //   2132: getfield 1631	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2135: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2138: i2l
    //   2139: putfield 1633	azro:jdField_b_of_type_Long	J
    //   2142: new 1635	azrn
    //   2145: dup
    //   2146: invokespecial 1636	azrn:<init>	()V
    //   2149: astore 23
    //   2151: aload 23
    //   2153: aload 17
    //   2155: getfield 1640	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2158: getfield 1645	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2161: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2164: i2l
    //   2165: putfield 1646	azrn:jdField_a_of_type_Long	J
    //   2168: aload 23
    //   2170: aload 17
    //   2172: getfield 1640	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2175: getfield 1649	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2178: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2181: i2l
    //   2182: putfield 1650	azrn:jdField_b_of_type_Long	J
    //   2185: aload 23
    //   2187: aload 17
    //   2189: getfield 1640	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2192: getfield 1653	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2195: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2198: i2l
    //   2199: putfield 1655	azrn:c	J
    //   2202: aload 20
    //   2204: aload 23
    //   2206: putfield 1658	azro:jdField_b_of_type_Azrn	Lazrn;
    //   2209: new 1635	azrn
    //   2212: dup
    //   2213: invokespecial 1636	azrn:<init>	()V
    //   2216: astore 23
    //   2218: aload 23
    //   2220: aload 17
    //   2222: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2225: getfield 1645	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2228: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2231: i2l
    //   2232: putfield 1646	azrn:jdField_a_of_type_Long	J
    //   2235: aload 23
    //   2237: aload 17
    //   2239: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2242: getfield 1649	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2245: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2248: i2l
    //   2249: putfield 1650	azrn:jdField_b_of_type_Long	J
    //   2252: aload 23
    //   2254: aload 17
    //   2256: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2259: getfield 1653	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2262: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2265: i2l
    //   2266: putfield 1655	azrn:c	J
    //   2269: aload 20
    //   2271: aload 23
    //   2273: putfield 1663	azro:jdField_a_of_type_Azrn	Lazrn;
    //   2276: aload 21
    //   2278: aload 20
    //   2280: invokevirtual 1664	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2283: pop
    //   2284: iload 7
    //   2286: iconst_1
    //   2287: iadd
    //   2288: istore 7
    //   2290: goto -229 -> 2061
    //   2293: aload 4
    //   2295: aload 21
    //   2297: putfield 1666	azrq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2300: aload 18
    //   2302: aload 4
    //   2304: invokevirtual 1664	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2307: pop
    //   2308: iload 6
    //   2310: iconst_1
    //   2311: iadd
    //   2312: istore 6
    //   2314: goto -418 -> 1896
    //   2317: aload 22
    //   2319: aload 18
    //   2321: putfield 1667	azrp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2324: aload_2
    //   2325: aload 22
    //   2327: invokeinterface 560 2 0
    //   2332: pop
    //   2333: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2336: ifeq -605 -> 1731
    //   2339: ldc_w 640
    //   2342: iconst_2
    //   2343: new 184	java/lang/StringBuilder
    //   2346: dup
    //   2347: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2350: ldc_w 1669
    //   2353: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2356: aload_3
    //   2357: getfield 1564	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2360: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2363: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2366: ldc_w 1671
    //   2369: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: iload 9
    //   2374: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2377: ldc_w 1673
    //   2380: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: aload_3
    //   2384: getfield 1676	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2387: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2390: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2393: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2396: goto -665 -> 1731
    //   2399: astore_3
    //   2400: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2403: ifeq -672 -> 1731
    //   2406: ldc_w 640
    //   2409: iconst_2
    //   2410: aload_3
    //   2411: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   2414: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2417: goto -686 -> 1731
    //   2420: new 518	java/util/ArrayList
    //   2423: dup
    //   2424: invokespecial 519	java/util/ArrayList:<init>	()V
    //   2427: astore_2
    //   2428: aload 16
    //   2430: getfield 1679	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2433: ifnull +383 -> 2816
    //   2436: aload 16
    //   2438: getfield 1679	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2441: invokevirtual 1483	java/util/ArrayList:size	()I
    //   2444: ifle +372 -> 2816
    //   2447: iconst_0
    //   2448: istore 5
    //   2450: iload 5
    //   2452: aload 16
    //   2454: getfield 1679	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2457: invokevirtual 1483	java/util/ArrayList:size	()I
    //   2460: if_icmpge +356 -> 2816
    //   2463: aload 16
    //   2465: getfield 1679	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2468: iload 5
    //   2470: invokevirtual 1484	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2473: checkcast 1525	[B
    //   2476: astore 4
    //   2478: aload 4
    //   2480: ifnonnull +22 -> 2502
    //   2483: iconst_0
    //   2484: istore 6
    //   2486: iload 6
    //   2488: bipush 10
    //   2490: if_icmpgt +20 -> 2510
    //   2493: iload 5
    //   2495: iconst_1
    //   2496: iadd
    //   2497: istore 5
    //   2499: goto -49 -> 2450
    //   2502: aload 4
    //   2504: arraylength
    //   2505: istore 6
    //   2507: goto -21 -> 2486
    //   2510: aload 4
    //   2512: iconst_1
    //   2513: invokestatic 1531	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   2516: l2i
    //   2517: istore 9
    //   2519: aload 4
    //   2521: iconst_5
    //   2522: invokestatic 1531	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   2525: l2i
    //   2526: istore 7
    //   2528: iload 9
    //   2530: ifle -37 -> 2493
    //   2533: iload 9
    //   2535: bipush 9
    //   2537: iadd
    //   2538: iload 6
    //   2540: if_icmpge -47 -> 2493
    //   2543: iload 9
    //   2545: newarray byte
    //   2547: astore_3
    //   2548: aload_3
    //   2549: iconst_0
    //   2550: aload 4
    //   2552: bipush 9
    //   2554: iload 9
    //   2556: invokestatic 1535	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   2559: new 1537	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2562: dup
    //   2563: invokespecial 1538	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2566: astore 4
    //   2568: aload 4
    //   2570: aload_3
    //   2571: invokevirtual 1539	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2574: pop
    //   2575: aload 4
    //   2577: getfield 1542	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2580: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2583: istore 6
    //   2585: iload 6
    //   2587: ifne +161 -> 2748
    //   2590: new 1681	azqy
    //   2593: dup
    //   2594: invokespecial 1682	azqy:<init>	()V
    //   2597: astore_3
    //   2598: aload_3
    //   2599: aload 4
    //   2601: getfield 1564	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2604: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2607: putfield 1683	azqy:jdField_a_of_type_Int	I
    //   2610: aload 4
    //   2612: getfield 1687	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2615: ifnull +102 -> 2717
    //   2618: aload_3
    //   2619: aload 4
    //   2621: getfield 1687	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2624: getfield 1692	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2627: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2630: putfield 1693	azqy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2633: aload_3
    //   2634: aload 4
    //   2636: getfield 1687	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2639: getfield 1696	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2642: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2645: putfield 1697	azqy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2648: aload_3
    //   2649: aload 4
    //   2651: getfield 1687	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2654: getfield 1700	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2657: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2660: putfield 1701	azqy:c	Ljava/lang/String;
    //   2663: aload_3
    //   2664: aload 4
    //   2666: getfield 1687	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2669: getfield 1704	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2672: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2675: putfield 1705	azqy:d	Ljava/lang/String;
    //   2678: aload_3
    //   2679: invokevirtual 1707	azqy:a	()Z
    //   2682: ifne -189 -> 2493
    //   2685: aload_2
    //   2686: aload_3
    //   2687: invokeinterface 560 2 0
    //   2692: pop
    //   2693: goto -200 -> 2493
    //   2696: astore_3
    //   2697: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2700: ifeq -207 -> 2493
    //   2703: ldc_w 640
    //   2706: iconst_2
    //   2707: aload_3
    //   2708: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   2711: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2714: goto -221 -> 2493
    //   2717: aload_3
    //   2718: ldc_w 489
    //   2721: putfield 1693	azqy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2724: aload_3
    //   2725: ldc_w 489
    //   2728: putfield 1697	azqy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2731: aload_3
    //   2732: ldc_w 489
    //   2735: putfield 1701	azqy:c	Ljava/lang/String;
    //   2738: aload_3
    //   2739: ldc_w 489
    //   2742: putfield 1705	azqy:d	Ljava/lang/String;
    //   2745: goto -67 -> 2678
    //   2748: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2751: ifeq -258 -> 2493
    //   2754: ldc_w 640
    //   2757: iconst_4
    //   2758: new 184	java/lang/StringBuilder
    //   2761: dup
    //   2762: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   2765: ldc_w 1709
    //   2768: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2771: aload 4
    //   2773: getfield 1564	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2776: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2779: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2782: ldc_w 1711
    //   2785: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: iload 6
    //   2790: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2793: ldc_w 1711
    //   2796: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2799: aload 4
    //   2801: getfield 1676	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2804: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2807: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2810: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2813: goto -320 -> 2493
    //   2816: aload 15
    //   2818: aload_2
    //   2819: invokevirtual 1715	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   2822: aload 16
    //   2824: getfield 1719	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2827: ifnonnull +126 -> 2953
    //   2830: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2833: ifeq +13 -> 2846
    //   2836: ldc_w 640
    //   2839: iconst_2
    //   2840: ldc_w 1054
    //   2843: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2846: aload 16
    //   2848: getfield 1722	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   2851: ifnull +1661 -> 4512
    //   2854: new 1724	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   2857: dup
    //   2858: invokespecial 1725	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   2861: astore_2
    //   2862: aload_2
    //   2863: aload 16
    //   2865: getfield 1722	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   2868: invokevirtual 1726	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2871: pop
    //   2872: aload_2
    //   2873: ifnull +2862 -> 5735
    //   2876: aload_2
    //   2877: getfield 1729	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2880: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2883: astore_2
    //   2884: new 518	java/util/ArrayList
    //   2887: dup
    //   2888: invokespecial 519	java/util/ArrayList:<init>	()V
    //   2891: astore_3
    //   2892: aload_2
    //   2893: ifnull +155 -> 3048
    //   2896: aload_2
    //   2897: invokeinterface 1181 1 0
    //   2902: astore_2
    //   2903: aload_2
    //   2904: invokeinterface 1186 1 0
    //   2909: ifeq +139 -> 3048
    //   2912: aload_2
    //   2913: invokeinterface 1190 1 0
    //   2918: checkcast 1731	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   2921: astore 4
    //   2923: aload 4
    //   2925: getfield 1734	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2928: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2931: iconst_1
    //   2932: if_icmpne +111 -> 3043
    //   2935: iconst_1
    //   2936: istore_1
    //   2937: aload_3
    //   2938: aload 4
    //   2940: iload_1
    //   2941: invokestatic 1740	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   2944: invokeinterface 560 2 0
    //   2949: pop
    //   2950: goto -47 -> 2903
    //   2953: aload 16
    //   2955: getfield 1719	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2958: getfield 1745	SummaryCard/InterestTagInfo:uFlag	J
    //   2961: lstore 10
    //   2963: new 691	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   2966: dup
    //   2967: invokespecial 692	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   2970: astore_2
    //   2971: aload_2
    //   2972: aload 16
    //   2974: getfield 1719	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2977: getfield 1746	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   2980: invokevirtual 696	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2983: pop
    //   2984: aload 15
    //   2986: lload 10
    //   2988: aload_2
    //   2989: getfield 700	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2992: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2995: invokevirtual 707	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   2998: goto -152 -> 2846
    //   3001: astore_2
    //   3002: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3005: ifeq -159 -> 2846
    //   3008: ldc_w 1051
    //   3011: iconst_2
    //   3012: aload_2
    //   3013: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   3016: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3019: goto -173 -> 2846
    //   3022: astore_3
    //   3023: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3026: ifeq -154 -> 2872
    //   3029: ldc_w 640
    //   3032: iconst_2
    //   3033: aload_3
    //   3034: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   3037: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3040: goto -168 -> 2872
    //   3043: iconst_0
    //   3044: istore_1
    //   3045: goto -108 -> 2937
    //   3048: aload_3
    //   3049: invokeinterface 550 1 0
    //   3054: ifle +2681 -> 5735
    //   3057: iconst_0
    //   3058: istore 5
    //   3060: iload 5
    //   3062: aload_3
    //   3063: invokeinterface 550 1 0
    //   3068: if_icmpge +2667 -> 5735
    //   3071: aload_3
    //   3072: iload 5
    //   3074: invokeinterface 553 2 0
    //   3079: checkcast 1736	com/tencent/mobileqq/data/HotChatInfo
    //   3082: astore_2
    //   3083: aload_2
    //   3084: ifnull +1419 -> 4503
    //   3087: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3090: ifeq +30 -> 3120
    //   3093: ldc_w 640
    //   3096: iconst_2
    //   3097: new 184	java/lang/StringBuilder
    //   3100: dup
    //   3101: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3104: ldc_w 1748
    //   3107: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: aload_2
    //   3111: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3114: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3117: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3120: aload_2
    //   3121: ifnull +9 -> 3130
    //   3124: aload 15
    //   3126: aload_2
    //   3127: invokevirtual 1752	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3130: aload 15
    //   3132: getfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3135: ifnull +787 -> 3922
    //   3138: new 756	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3141: dup
    //   3142: invokespecial 757	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3145: astore_3
    //   3146: aload_3
    //   3147: aload 15
    //   3149: getfield 426	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3152: invokevirtual 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3155: pop
    //   3156: iload 8
    //   3158: bipush 51
    //   3160: if_icmpne +1381 -> 4541
    //   3163: aload_3
    //   3164: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3167: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3170: iconst_1
    //   3171: if_icmpne +1360 -> 4531
    //   3174: iconst_1
    //   3175: istore_1
    //   3176: aload 15
    //   3178: iload_1
    //   3179: putfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3182: aload_3
    //   3183: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3186: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3189: iconst_1
    //   3190: if_icmpne +1346 -> 4536
    //   3193: iconst_1
    //   3194: istore_1
    //   3195: aload 15
    //   3197: iload_1
    //   3198: putfield 578	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3201: aload 15
    //   3203: aload_3
    //   3204: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3207: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3210: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3213: putfield 602	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3216: aload 15
    //   3218: aload_3
    //   3219: getfield 770	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3222: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3225: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3228: putfield 596	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3231: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3234: ifeq +1417 -> 4651
    //   3237: ldc_w 772
    //   3240: iconst_2
    //   3241: new 184	java/lang/StringBuilder
    //   3244: dup
    //   3245: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3248: ldc_w 774
    //   3251: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3254: iload 8
    //   3256: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3259: ldc_w 776
    //   3262: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: aload_3
    //   3266: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3269: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3272: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3275: ldc_w 778
    //   3278: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: aload_3
    //   3282: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3285: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3288: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3291: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3294: ldc_w 780
    //   3297: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3300: aload_0
    //   3301: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3304: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3307: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3310: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3313: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3316: aload 15
    //   3318: aload_3
    //   3319: getfield 786	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3322: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3325: putfield 587	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3328: aload_3
    //   3329: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3332: invokevirtual 793	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3335: ifeq +1421 -> 4756
    //   3338: aload 15
    //   3340: aload_3
    //   3341: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3344: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3347: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3350: getfield 797	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3353: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3356: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3359: putfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3362: aload 15
    //   3364: aload_3
    //   3365: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3368: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3371: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3374: getfield 800	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3377: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3380: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3383: putfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3386: aload 15
    //   3388: aload_3
    //   3389: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3392: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3395: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3398: getfield 803	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3401: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3404: putfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3407: aload 15
    //   3409: aload_3
    //   3410: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3413: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3416: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3419: getfield 806	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3422: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3425: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3428: putfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3431: aload 15
    //   3433: aload_3
    //   3434: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3437: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3440: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3443: getfield 809	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3446: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3449: putfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3452: aload 15
    //   3454: aload_3
    //   3455: getfield 790	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3458: invokevirtual 794	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3461: checkcast 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3464: getfield 812	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3467: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3470: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3473: aload_3
    //   3474: getfield 815	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3477: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3480: iconst_1
    //   3481: if_icmpne +2259 -> 5740
    //   3484: iconst_1
    //   3485: istore_1
    //   3486: aload 15
    //   3488: iload_1
    //   3489: putfield 818	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3492: aload 15
    //   3494: aload_3
    //   3495: getfield 821	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3498: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3501: putfield 824	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3504: aload 15
    //   3506: aload_3
    //   3507: getfield 827	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3510: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3513: putfield 830	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3516: aload 15
    //   3518: aload_3
    //   3519: getfield 833	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3522: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3525: putfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3528: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3531: ifeq +104 -> 3635
    //   3534: ldc_w 838
    //   3537: iconst_2
    //   3538: new 184	java/lang/StringBuilder
    //   3541: dup
    //   3542: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3545: ldc_w 840
    //   3548: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3551: aload 15
    //   3553: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3556: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3559: ldc_w 842
    //   3562: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: aload 15
    //   3567: getfield 818	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3570: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3573: ldc_w 847
    //   3576: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: aload 15
    //   3581: invokevirtual 850	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3584: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3587: ldc_w 852
    //   3590: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3593: aload 15
    //   3595: getfield 824	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3598: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: ldc_w 854
    //   3604: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3607: aload 15
    //   3609: getfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3612: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: ldc_w 856
    //   3618: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: aload 15
    //   3623: getfield 830	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3626: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3629: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3632: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3635: aload_3
    //   3636: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3639: invokevirtual 863	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   3642: ifeq +1159 -> 4801
    //   3645: aload 15
    //   3647: aload_3
    //   3648: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3651: getfield 866	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3654: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3657: putfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3660: aload 15
    //   3662: aload_3
    //   3663: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3666: getfield 872	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3669: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3672: putfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3675: aload 15
    //   3677: aload_3
    //   3678: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3681: getfield 878	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3684: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3687: putfield 881	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3690: aload 15
    //   3692: aload_3
    //   3693: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3696: getfield 884	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3699: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3702: putfield 887	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   3705: aload 15
    //   3707: aload_3
    //   3708: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3711: getfield 890	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3714: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3717: putfield 893	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   3720: aload 15
    //   3722: aload_3
    //   3723: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3726: getfield 896	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3729: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3732: putfield 899	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   3735: aload 15
    //   3737: aload_3
    //   3738: getfield 860	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3741: getfield 902	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3744: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3747: putfield 905	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   3750: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3753: ifeq +169 -> 3922
    //   3756: new 184	java/lang/StringBuilder
    //   3759: dup
    //   3760: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   3763: astore_2
    //   3764: aload_2
    //   3765: ldc_w 907
    //   3768: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: ldc_w 909
    //   3774: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: aload 15
    //   3779: getfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3782: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3785: ldc_w 911
    //   3788: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3791: ldc_w 913
    //   3794: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3797: aload 15
    //   3799: getfield 875	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3802: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3805: ldc_w 911
    //   3808: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: ldc_w 915
    //   3814: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3817: aload 15
    //   3819: getfield 881	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3822: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3825: ldc_w 911
    //   3828: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3831: ldc_w 917
    //   3834: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: aload 15
    //   3839: getfield 887	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   3842: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3845: ldc_w 911
    //   3848: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: ldc_w 919
    //   3854: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3857: aload 15
    //   3859: getfield 893	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   3862: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3865: ldc_w 911
    //   3868: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3871: ldc_w 921
    //   3874: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: aload 15
    //   3879: getfield 899	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   3882: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3885: ldc_w 911
    //   3888: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3891: ldc_w 923
    //   3894: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3897: aload 15
    //   3899: getfield 905	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   3902: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3905: ldc_w 911
    //   3908: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3911: pop
    //   3912: ldc 182
    //   3914: iconst_2
    //   3915: aload_2
    //   3916: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3919: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3922: aload 16
    //   3924: getfield 1756	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3927: ifnull +29 -> 3956
    //   3930: aload 15
    //   3932: aload 16
    //   3934: getfield 1756	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3937: getfield 1761	SummaryCard/GiftInfo:uOpenFlag	J
    //   3940: putfield 723	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   3943: aload 15
    //   3945: aload 16
    //   3947: getfield 1756	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3950: getfield 1762	SummaryCard/GiftInfo:vGiftInfo	[B
    //   3953: putfield 727	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   3956: aload 16
    //   3958: getfield 1765	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3961: ifnull +162 -> 4123
    //   3964: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3967: ifeq +12 -> 3979
    //   3970: ldc 182
    //   3972: iconst_2
    //   3973: ldc_w 1767
    //   3976: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3979: new 1769	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   3982: dup
    //   3983: invokespecial 1770	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   3986: astore_2
    //   3987: aload_2
    //   3988: aload 16
    //   3990: getfield 1765	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3993: invokevirtual 1771	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3996: pop
    //   3997: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4000: ifeq +82 -> 4082
    //   4003: ldc 182
    //   4005: iconst_2
    //   4006: new 184	java/lang/StringBuilder
    //   4009: dup
    //   4010: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4013: ldc_w 1773
    //   4016: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4019: aload_2
    //   4020: getfield 1774	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4023: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4026: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4029: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4032: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4035: aload_2
    //   4036: getfield 1777	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4039: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4042: ifeq +40 -> 4082
    //   4045: ldc 182
    //   4047: iconst_2
    //   4048: new 184	java/lang/StringBuilder
    //   4051: dup
    //   4052: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4055: ldc_w 1779
    //   4058: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4061: aload_2
    //   4062: getfield 1777	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4065: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4068: invokeinterface 550 1 0
    //   4073: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4076: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4079: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4082: aload_2
    //   4083: getfield 1774	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4086: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4089: iconst_1
    //   4090: if_icmpne +729 -> 4819
    //   4093: iconst_1
    //   4094: istore_1
    //   4095: aload 15
    //   4097: iload_1
    //   4098: putfield 1782	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4101: aload_2
    //   4102: getfield 1777	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4105: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4108: ifeq +15 -> 4123
    //   4111: aload 15
    //   4113: aload_2
    //   4114: getfield 1777	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4117: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4120: invokevirtual 1785	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4123: aload 16
    //   4125: getfield 1788	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4128: astore_3
    //   4129: aload_3
    //   4130: ifnull +41 -> 4171
    //   4133: new 1790	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4136: dup
    //   4137: invokespecial 1791	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4140: astore_2
    //   4141: aload_2
    //   4142: aload_3
    //   4143: invokevirtual 1792	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4146: pop
    //   4147: aload 15
    //   4149: aload_2
    //   4150: getfield 1795	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4153: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4156: putfield 1798	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4159: aload 15
    //   4161: aload_2
    //   4162: getfield 1801	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4165: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4168: putfield 1804	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4171: aload 16
    //   4173: getfield 1807	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4176: astore_2
    //   4177: aload_2
    //   4178: ifnull +698 -> 4876
    //   4181: aload 15
    //   4183: new 518	java/util/ArrayList
    //   4186: dup
    //   4187: invokespecial 519	java/util/ArrayList:<init>	()V
    //   4190: putfield 1810	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4193: new 1812	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4196: dup
    //   4197: invokespecial 1813	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4200: astore_3
    //   4201: aload_3
    //   4202: aload_2
    //   4203: invokevirtual 1814	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4206: pop
    //   4207: aload_3
    //   4208: getfield 1817	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4211: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4214: astore 4
    //   4216: aload 4
    //   4218: ifnull +658 -> 4876
    //   4221: new 544	org/json/JSONArray
    //   4224: dup
    //   4225: invokespecial 545	org/json/JSONArray:<init>	()V
    //   4228: astore_3
    //   4229: iconst_0
    //   4230: istore 5
    //   4232: iload 5
    //   4234: aload 4
    //   4236: invokeinterface 550 1 0
    //   4241: if_icmpge +622 -> 4863
    //   4244: new 1819	org/json/JSONObject
    //   4247: dup
    //   4248: invokespecial 1820	org/json/JSONObject:<init>	()V
    //   4251: astore 17
    //   4253: new 1822	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4256: dup
    //   4257: invokespecial 1823	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4260: astore_2
    //   4261: aload_2
    //   4262: aload 4
    //   4264: iload 5
    //   4266: invokeinterface 553 2 0
    //   4271: checkcast 1825	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4274: getfield 1828	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4277: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4280: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4283: putfield 1830	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4286: aload_2
    //   4287: getfield 1830	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4290: invokestatic 1834	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4293: ifne +16 -> 4309
    //   4296: aload 17
    //   4298: ldc_w 1835
    //   4301: aload_2
    //   4302: getfield 1830	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4305: invokevirtual 1838	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4308: pop
    //   4309: aload_2
    //   4310: aload 4
    //   4312: iload 5
    //   4314: invokeinterface 553 2 0
    //   4319: checkcast 1825	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4322: getfield 1841	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4325: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4328: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4331: putfield 1844	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4334: aload_2
    //   4335: getfield 1844	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4338: invokestatic 1834	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4341: ifne +16 -> 4357
    //   4344: aload 17
    //   4346: ldc_w 1845
    //   4349: aload_2
    //   4350: getfield 1844	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4353: invokevirtual 1838	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4356: pop
    //   4357: aload_2
    //   4358: aload 4
    //   4360: iload 5
    //   4362: invokeinterface 553 2 0
    //   4367: checkcast 1825	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4370: getfield 1848	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4373: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4376: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4379: putfield 1850	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4382: aload_2
    //   4383: getfield 1850	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4386: invokestatic 1834	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4389: ifne +16 -> 4405
    //   4392: aload 17
    //   4394: ldc_w 1851
    //   4397: aload_2
    //   4398: getfield 1850	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4401: invokevirtual 1838	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4404: pop
    //   4405: aload_2
    //   4406: aload 4
    //   4408: iload 5
    //   4410: invokeinterface 553 2 0
    //   4415: checkcast 1825	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4418: getfield 1854	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4421: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4424: putfield 1857	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4427: aload 17
    //   4429: ldc_w 1858
    //   4432: aload_2
    //   4433: getfield 1857	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4436: invokevirtual 1861	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4439: pop
    //   4440: aload_2
    //   4441: aload 4
    //   4443: iload 5
    //   4445: invokeinterface 553 2 0
    //   4450: checkcast 1825	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4453: getfield 1864	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4456: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4459: putfield 1867	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4462: aload 17
    //   4464: ldc_w 1868
    //   4467: aload_2
    //   4468: getfield 1867	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4471: invokevirtual 1861	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4474: pop
    //   4475: aload 15
    //   4477: getfield 1810	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4480: aload_2
    //   4481: invokeinterface 560 2 0
    //   4486: pop
    //   4487: aload_3
    //   4488: aload 17
    //   4490: invokevirtual 564	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4493: pop
    //   4494: iload 5
    //   4496: iconst_1
    //   4497: iadd
    //   4498: istore 5
    //   4500: goto -268 -> 4232
    //   4503: iload 5
    //   4505: iconst_1
    //   4506: iadd
    //   4507: istore 5
    //   4509: goto -1449 -> 3060
    //   4512: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4515: ifeq -1385 -> 3130
    //   4518: ldc_w 640
    //   4521: iconst_2
    //   4522: ldc_w 1870
    //   4525: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4528: goto -1398 -> 3130
    //   4531: iconst_0
    //   4532: istore_1
    //   4533: goto -1357 -> 3176
    //   4536: iconst_0
    //   4537: istore_1
    //   4538: goto -1343 -> 3195
    //   4541: aload 15
    //   4543: aload_3
    //   4544: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4547: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4550: putfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4553: aload 15
    //   4555: getfield 584	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4558: iconst_1
    //   4559: if_icmpne +82 -> 4641
    //   4562: iconst_1
    //   4563: istore_1
    //   4564: aload 15
    //   4566: iload_1
    //   4567: putfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4570: aload_3
    //   4571: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4574: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4577: iconst_1
    //   4578: if_icmpne +68 -> 4646
    //   4581: iconst_1
    //   4582: istore_1
    //   4583: aload 15
    //   4585: iload_1
    //   4586: putfield 575	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4589: aload 15
    //   4591: aload_3
    //   4592: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4595: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4598: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4601: putfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4604: aload 15
    //   4606: aload_3
    //   4607: getfield 770	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4610: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4613: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4616: putfield 593	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4619: goto -1388 -> 3231
    //   4622: astore_2
    //   4623: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4626: ifeq -704 -> 3922
    //   4629: ldc 182
    //   4631: iconst_2
    //   4632: ldc_w 1056
    //   4635: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4638: goto -716 -> 3922
    //   4641: iconst_0
    //   4642: istore_1
    //   4643: goto -79 -> 4564
    //   4646: iconst_0
    //   4647: istore_1
    //   4648: goto -65 -> 4583
    //   4651: ldc_w 772
    //   4654: iconst_1
    //   4655: new 184	java/lang/StringBuilder
    //   4658: dup
    //   4659: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4662: ldc_w 774
    //   4665: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4668: iload 8
    //   4670: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4673: ldc_w 776
    //   4676: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4679: aload_3
    //   4680: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4683: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4686: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4689: ldc_w 778
    //   4692: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: aload_3
    //   4696: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4699: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4702: invokevirtual 556	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4705: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4711: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4714: goto -1398 -> 3316
    //   4717: astore_2
    //   4718: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4721: ifeq -1405 -> 3316
    //   4724: ldc 182
    //   4726: iconst_2
    //   4727: new 184	java/lang/StringBuilder
    //   4730: dup
    //   4731: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4734: ldc_w 1058
    //   4737: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4740: aload_2
    //   4741: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   4744: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4747: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4750: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4753: goto -1437 -> 3316
    //   4756: aload 15
    //   4758: ldc_w 489
    //   4761: putfield 620	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4764: aload 15
    //   4766: ldc_w 489
    //   4769: putfield 617	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4772: aload 15
    //   4774: iconst_0
    //   4775: putfield 614	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4778: aload 15
    //   4780: ldc_w 489
    //   4783: putfield 605	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4786: aload 15
    //   4788: iconst_0
    //   4789: putfield 608	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4792: aload 15
    //   4794: iconst_0
    //   4795: putfield 611	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4798: goto -1325 -> 3473
    //   4801: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4804: ifeq -882 -> 3922
    //   4807: ldc 182
    //   4809: iconst_2
    //   4810: ldc_w 1060
    //   4813: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4816: goto -894 -> 3922
    //   4819: iconst_0
    //   4820: istore_1
    //   4821: goto -726 -> 4095
    //   4824: astore_2
    //   4825: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4828: ifeq -705 -> 4123
    //   4831: ldc 182
    //   4833: iconst_2
    //   4834: new 184	java/lang/StringBuilder
    //   4837: dup
    //   4838: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4841: ldc_w 1872
    //   4844: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4847: aload_2
    //   4848: invokevirtual 1873	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4851: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4854: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4857: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4860: goto -737 -> 4123
    //   4863: aload_3
    //   4864: ifnull +12 -> 4876
    //   4867: aload 15
    //   4869: aload_3
    //   4870: invokevirtual 631	org/json/JSONArray:toString	()Ljava/lang/String;
    //   4873: putfield 1876	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   4876: aload 15
    //   4878: aload 16
    //   4880: getfield 1807	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4883: putfield 929	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   4886: new 931	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   4889: dup
    //   4890: invokespecial 932	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   4893: astore_3
    //   4894: aload_3
    //   4895: aload 16
    //   4897: getfield 1807	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4900: invokevirtual 933	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4903: pop
    //   4904: aload_3
    //   4905: astore_2
    //   4906: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4909: ifeq +69 -> 4978
    //   4912: ldc 182
    //   4914: iconst_2
    //   4915: new 184	java/lang/StringBuilder
    //   4918: dup
    //   4919: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   4922: ldc_w 935
    //   4925: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4928: aload_3
    //   4929: getfield 938	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4932: invokevirtual 939	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4935: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4938: ldc_w 941
    //   4941: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4944: aload_3
    //   4945: getfield 944	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4948: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4951: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4954: ldc_w 947
    //   4957: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4960: aload_3
    //   4961: getfield 950	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4964: invokevirtual 945	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4967: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4970: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4973: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4976: aload_3
    //   4977: astore_2
    //   4978: aload 15
    //   4980: aload_2
    //   4981: putfield 954	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   4984: aload_0
    //   4985: bipush 51
    //   4987: iconst_1
    //   4988: aload 15
    //   4990: iload 12
    //   4992: invokevirtual 255	axqt:notifyUI	(IZLjava/lang/Object;Z)V
    //   4995: aload_0
    //   4996: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4999: getstatic 959	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   5002: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5005: checkcast 965	axny
    //   5008: astore_2
    //   5009: iload 8
    //   5011: bipush 51
    //   5013: if_icmpne +458 -> 5471
    //   5016: aload_2
    //   5017: aload 15
    //   5019: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5022: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   5025: invokevirtual 973	axny:b	(Ljava/lang/String;J)V
    //   5028: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5031: ifeq +46 -> 5077
    //   5034: ldc_w 975
    //   5037: iconst_4
    //   5038: new 184	java/lang/StringBuilder
    //   5041: dup
    //   5042: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   5045: ldc_w 977
    //   5048: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5051: aload 15
    //   5053: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5056: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5059: ldc_w 979
    //   5062: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5065: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   5068: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5071: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5074: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5077: aload_0
    //   5078: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5081: getstatic 982	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   5084: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5087: checkcast 984	anvk
    //   5090: astore_2
    //   5091: invokestatic 1880	axql:b	()Z
    //   5094: ifeq +55 -> 5149
    //   5097: ldc 182
    //   5099: iconst_5
    //   5100: anewarray 1138	java/lang/Object
    //   5103: dup
    //   5104: iconst_0
    //   5105: ldc_w 1882
    //   5108: aastore
    //   5109: dup
    //   5110: iconst_1
    //   5111: iload 8
    //   5113: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5116: aastore
    //   5117: dup
    //   5118: iconst_2
    //   5119: aload 15
    //   5121: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5124: aastore
    //   5125: dup
    //   5126: iconst_3
    //   5127: aload_0
    //   5128: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5131: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5134: aastore
    //   5135: dup
    //   5136: iconst_4
    //   5137: aload 16
    //   5139: getfield 1222	SummaryCard/RespSummaryCard:lUIN	J
    //   5142: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5145: aastore
    //   5146: invokestatic 1885	axql:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   5149: iload 8
    //   5151: ifeq +21 -> 5172
    //   5154: aload 15
    //   5156: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5159: aload_0
    //   5160: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5163: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5166: invokevirtual 1225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5169: ifeq +76 -> 5245
    //   5172: aload_2
    //   5173: aload 15
    //   5175: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5178: invokevirtual 987	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5181: astore_3
    //   5182: aload_3
    //   5183: aload 15
    //   5185: getfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5188: putfield 992	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5191: aload_3
    //   5192: aload 15
    //   5194: getfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5197: i2l
    //   5198: putfield 995	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5201: aload_0
    //   5202: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5205: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5208: aload_3
    //   5209: getfield 995	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5212: aload_3
    //   5213: getfield 992	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5216: invokestatic 1003	axqc:a	(Ljava/lang/String;JI)Z
    //   5219: pop
    //   5220: aload_2
    //   5221: aload_3
    //   5222: invokevirtual 1006	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5225: pop
    //   5226: aload_0
    //   5227: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5230: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5233: ldc_w 1008
    //   5236: aload 15
    //   5238: getfield 408	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5241: invokestatic 1011	axqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5244: pop
    //   5245: aload_0
    //   5246: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5249: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5252: aload 15
    //   5254: getfield 331	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5257: invokevirtual 1225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5260: ifeq +32 -> 5292
    //   5263: aload 15
    //   5265: getfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5268: ifle +24 -> 5292
    //   5271: aload_0
    //   5272: getfield 216	axqt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5275: getstatic 1017	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   5278: invokevirtual 963	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5281: checkcast 1019	com/tencent/mobileqq/app/HotChatManager
    //   5284: aload 15
    //   5286: getfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5289: invokevirtual 1021	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   5292: aload_2
    //   5293: aload 15
    //   5295: invokevirtual 1024	anvk:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5298: aload 15
    //   5300: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5303: sipush 1000
    //   5306: if_icmpne +350 -> 5656
    //   5309: aload 13
    //   5311: iconst_0
    //   5312: ldc_w 311
    //   5315: invokevirtual 1029	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5318: aconst_null
    //   5319: aconst_null
    //   5320: aconst_null
    //   5321: aconst_null
    //   5322: aconst_null
    //   5323: aconst_null
    //   5324: aconst_null
    //   5325: invokevirtual 1033	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5328: astore_3
    //   5329: aload_3
    //   5330: ifnull +289 -> 5619
    //   5333: aload_3
    //   5334: astore_2
    //   5335: aload_3
    //   5336: invokeinterface 1038 1 0
    //   5341: istore 5
    //   5343: aload_3
    //   5344: astore_2
    //   5345: aload_3
    //   5346: invokeinterface 1041 1 0
    //   5351: pop
    //   5352: iload 5
    //   5354: sipush 200
    //   5357: if_icmple +262 -> 5619
    //   5360: iload 5
    //   5362: bipush 100
    //   5364: if_icmple +133 -> 5497
    //   5367: aload_3
    //   5368: astore_2
    //   5369: aload_3
    //   5370: invokeinterface 1044 1 0
    //   5375: pop
    //   5376: iload 5
    //   5378: iconst_1
    //   5379: isub
    //   5380: istore 5
    //   5382: goto -22 -> 5360
    //   5385: astore_2
    //   5386: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5389: ifeq -513 -> 4876
    //   5392: ldc 182
    //   5394: iconst_2
    //   5395: new 184	java/lang/StringBuilder
    //   5398: dup
    //   5399: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   5402: ldc_w 1887
    //   5405: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5408: aload_2
    //   5409: invokevirtual 1049	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5412: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5415: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5418: invokestatic 212	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5421: goto -545 -> 4876
    //   5424: astore 4
    //   5426: aconst_null
    //   5427: astore_3
    //   5428: aload_3
    //   5429: astore_2
    //   5430: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5433: ifeq -455 -> 4978
    //   5436: ldc 182
    //   5438: iconst_2
    //   5439: new 184	java/lang/StringBuilder
    //   5442: dup
    //   5443: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   5446: ldc_w 1062
    //   5449: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5452: aload 4
    //   5454: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   5457: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5463: invokestatic 1065	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5466: aload_3
    //   5467: astore_2
    //   5468: goto -490 -> 4978
    //   5471: aload_2
    //   5472: aload 15
    //   5474: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5477: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5480: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   5483: invokevirtual 1067	axny:a	(Ljava/lang/String;J)V
    //   5486: goto -458 -> 5028
    //   5489: astore_3
    //   5490: aload_3
    //   5491: invokevirtual 1070	java/lang/Exception:printStackTrace	()V
    //   5494: goto -249 -> 5245
    //   5497: aload_3
    //   5498: astore_2
    //   5499: aload_3
    //   5500: aload_3
    //   5501: ldc_w 1072
    //   5504: invokeinterface 1075 2 0
    //   5509: invokeinterface 1078 2 0
    //   5514: istore 5
    //   5516: aload_3
    //   5517: astore_2
    //   5518: new 184	java/lang/StringBuilder
    //   5521: dup
    //   5522: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   5525: astore 4
    //   5527: aload_3
    //   5528: astore_2
    //   5529: aload 4
    //   5531: ldc_w 1080
    //   5534: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5537: pop
    //   5538: aload_3
    //   5539: astore_2
    //   5540: aload 4
    //   5542: ldc_w 311
    //   5545: invokevirtual 1029	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5548: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5551: pop
    //   5552: aload_3
    //   5553: astore_2
    //   5554: aload 4
    //   5556: ldc_w 1082
    //   5559: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: pop
    //   5563: aload_3
    //   5564: astore_2
    //   5565: aload 4
    //   5567: ldc_w 1072
    //   5570: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5573: pop
    //   5574: aload_3
    //   5575: astore_2
    //   5576: aload 4
    //   5578: ldc_w 1084
    //   5581: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5584: pop
    //   5585: aload_3
    //   5586: astore_2
    //   5587: aload 4
    //   5589: iload 5
    //   5591: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5594: pop
    //   5595: aload_3
    //   5596: astore_2
    //   5597: aload 4
    //   5599: ldc_w 1086
    //   5602: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5605: pop
    //   5606: aload_3
    //   5607: astore_2
    //   5608: aload 13
    //   5610: aload 4
    //   5612: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5615: invokevirtual 1089	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   5618: pop
    //   5619: aload_3
    //   5620: astore_2
    //   5621: aload 13
    //   5623: aload 15
    //   5625: invokevirtual 1093	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   5628: aload_3
    //   5629: astore_2
    //   5630: aload 14
    //   5632: invokevirtual 1096	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   5635: aload_3
    //   5636: ifnull +9 -> 5645
    //   5639: aload_3
    //   5640: invokeinterface 1099 1 0
    //   5645: aload 14
    //   5647: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   5650: aload 13
    //   5652: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   5655: return
    //   5656: aload 15
    //   5658: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5661: sipush 1001
    //   5664: if_icmpeq +14 -> 5678
    //   5667: aload 15
    //   5669: invokevirtual 569	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5672: sipush 1002
    //   5675: if_icmpne +11 -> 5686
    //   5678: aload 13
    //   5680: aload 15
    //   5682: invokevirtual 1107	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   5685: pop
    //   5686: aconst_null
    //   5687: astore_3
    //   5688: goto -60 -> 5628
    //   5691: astore_3
    //   5692: aconst_null
    //   5693: astore_2
    //   5694: aload_2
    //   5695: ifnull +9 -> 5704
    //   5698: aload_2
    //   5699: invokeinterface 1099 1 0
    //   5704: aload 14
    //   5706: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   5709: aload 13
    //   5711: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   5714: aload_3
    //   5715: athrow
    //   5716: aload_0
    //   5717: bipush 51
    //   5719: iconst_0
    //   5720: aconst_null
    //   5721: iload 12
    //   5723: invokevirtual 255	axqt:notifyUI	(IZLjava/lang/Object;Z)V
    //   5726: return
    //   5727: astore_3
    //   5728: goto -34 -> 5694
    //   5731: astore_2
    //   5732: goto -1561 -> 4171
    //   5735: aconst_null
    //   5736: astore_2
    //   5737: goto -2650 -> 3087
    //   5740: iconst_0
    //   5741: istore_1
    //   5742: goto -2256 -> 3486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5745	0	this	axqt
    //   0	5745	1	paramBoolean	boolean
    //   0	5745	2	paramObject	Object
    //   0	5745	3	paramBundle	Bundle
    //   0	5745	4	paramRespHead	SummaryCard.RespHead
    //   825	4765	5	i	int
    //   1722	1067	6	j	int
    //   1762	765	7	k	int
    //   14	5136	8	m	int
    //   1770	785	9	n	int
    //   58	2929	10	l	long
    //   6	5716	12	bool	boolean
    //   36	5674	13	localEntityManager	EntityManager
    //   43	5662	14	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   87	5594	15	localNearbyPeopleCard	NearbyPeopleCard
    //   24	5114	16	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   771	3718	17	localObject1	Object
    //   797	1523	18	localObject2	Object
    //   1926	149	19	localui_info	com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info
    //   2096	183	20	localazro	azro
    //   2056	240	21	localArrayList	ArrayList
    //   1835	491	22	localazrp	azrp
    //   2149	123	23	localazrn	azrn
    // Exception table:
    //   from	to	target	type
    //   773	824	1442	java/lang/Exception
    //   827	875	1442	java/lang/Exception
    //   1008	1018	1442	java/lang/Exception
    //   1812	1837	2399	java/lang/Exception
    //   1842	1893	2399	java/lang/Exception
    //   1896	2058	2399	java/lang/Exception
    //   2061	2284	2399	java/lang/Exception
    //   2293	2300	2399	java/lang/Exception
    //   2300	2308	2399	java/lang/Exception
    //   2317	2324	2399	java/lang/Exception
    //   2324	2396	2399	java/lang/Exception
    //   2568	2585	2696	java/lang/Exception
    //   2590	2678	2696	java/lang/Exception
    //   2678	2693	2696	java/lang/Exception
    //   2717	2745	2696	java/lang/Exception
    //   2748	2813	2696	java/lang/Exception
    //   2963	2998	3001	java/lang/Exception
    //   2862	2872	3022	java/lang/Exception
    //   3146	3156	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3163	3174	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3176	3193	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3195	3231	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3231	3316	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3316	3473	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3473	3484	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3486	3635	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3635	3922	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4541	4562	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4564	4581	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4583	4619	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4651	4714	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4718	4753	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4756	4798	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4801	4816	4622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3231	3316	4717	java/lang/Exception
    //   4651	4714	4717	java/lang/Exception
    //   3964	3979	4824	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3979	4082	4824	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4082	4093	4824	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4095	4123	4824	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4201	4216	5385	java/lang/Exception
    //   4221	4229	5385	java/lang/Exception
    //   4232	4309	5385	java/lang/Exception
    //   4309	4357	5385	java/lang/Exception
    //   4357	4405	5385	java/lang/Exception
    //   4405	4494	5385	java/lang/Exception
    //   4867	4876	5385	java/lang/Exception
    //   4886	4904	5424	java/lang/Exception
    //   4906	4976	5424	java/lang/Exception
    //   5226	5245	5489	java/lang/Exception
    //   5298	5329	5691	finally
    //   5656	5678	5691	finally
    //   5678	5686	5691	finally
    //   5335	5343	5727	finally
    //   5345	5352	5727	finally
    //   5369	5376	5727	finally
    //   5499	5516	5727	finally
    //   5518	5527	5727	finally
    //   5529	5538	5727	finally
    //   5540	5552	5727	finally
    //   5554	5563	5727	finally
    //   5565	5574	5727	finally
    //   5576	5585	5727	finally
    //   5587	5595	5727	finally
    //   5597	5606	5727	finally
    //   5608	5619	5727	finally
    //   5621	5628	5727	finally
    //   5630	5635	5727	finally
    //   4141	4171	5731	java/lang/Exception
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), anvx.a(2131706587) });
      return;
    }
    String str;
    label92:
    int i;
    label102:
    int j;
    label112:
    int i2;
    int k;
    label152:
    int m;
    label171:
    label189:
    label207:
    Object localObject;
    if (paramToServiceMsg.extraData == null)
    {
      str = "";
      if (paramToServiceMsg.extraData != null) {
        break label547;
      }
      if (paramToServiceMsg.extraData != null) {
        break label561;
      }
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label576;
      }
      j = -1;
      paramToServiceMsg = new cmd0x9c8.RspBody();
      i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i2 != 0) {
        break label849;
      }
      if (!paramToServiceMsg.uint32_tag_type.has()) {
        break label591;
      }
      k = paramToServiceMsg.uint32_tag_type.get();
      if (!paramToServiceMsg.uint32_next_pos.has()) {
        break label597;
      }
      m = paramToServiceMsg.uint32_next_pos.get();
      if (!paramToServiceMsg.rpt_msg_tag_list.has()) {
        break label603;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_tag_list.get();
      if (!paramToServiceMsg.rpt_msg_sel_list.has()) {
        break label608;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_sel_list.get();
      localObject = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
      if ((i != 0) || (!TextUtils.isEmpty(str)) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label613;
      }
    }
    label547:
    label561:
    label576:
    label591:
    label597:
    label603:
    label608:
    label613:
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        paramObject = new StringBuilder();
        paramObject.append("DELETE FROM ");
        paramObject.append(InterestTagInfo.class.getSimpleName());
        paramObject.append(" WHERE ");
        paramObject.append("tagType = ");
        paramObject.append(k);
        paramObject.append(";");
        ((EntityManager)localObject).execSQL(paramObject.toString());
        paramObject = this.app.getApplication().getSharedPreferences("dating_pref" + this.app.getCurrentAccountUin(), 0).edit();
        paramObject.putLong("list_last_update_time_" + k, NetConnInfoCenter.getServerTimeMillis());
        paramObject.putInt("list_fetch_pos_" + k, m);
        paramObject.commit();
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label967;
      }
      paramObject = new ArrayList();
      int i1 = 0;
      while (i1 < paramFromServiceMsg.size())
      {
        InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramFromServiceMsg.get(i1));
        if (localInterestTagInfo != null)
        {
          localInterestTagInfo.tagType = k;
          paramObject.add(localInterestTagInfo);
          if (n != 0) {
            ((EntityManager)localObject).persist(localInterestTagInfo);
          }
        }
        i1 += 1;
      }
      str = paramToServiceMsg.extraData.getString("key_word");
      break;
      paramToServiceMsg.extraData.getInt("tag_type");
      break label92;
      i = paramToServiceMsg.extraData.getInt("fetch_start");
      break label102;
      j = paramToServiceMsg.extraData.getInt("person_flag");
      break label112;
      k = -1;
      break label152;
      m = -1;
      break label171;
      paramFromServiceMsg = null;
      break label189;
      paramToServiceMsg = null;
      break label207;
    }
    label967:
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      ((EntityManager)localObject).close();
      localObject = null;
      paramObject = localObject;
      if (paramToServiceMsg != null)
      {
        paramObject = localObject;
        if (!paramToServiceMsg.isEmpty())
        {
          paramObject = new ArrayList();
          n = 0;
          while (n < paramToServiceMsg.size())
          {
            localObject = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramToServiceMsg.get(n));
            if (localObject != null) {
              paramObject.add(localObject);
            }
            n += 1;
          }
        }
      }
      notifyUI(1, true, new Object[] { Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j), null });
      axql.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      label849:
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
        axql.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((axqs.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(3, false, null);
      return;
    }
    Object localObject = new cmd0x9c9.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
    boolean bool1;
    EntityManager localEntityManager;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (i != 0) {
        break label1060;
      }
      localEntityManager = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      if (paramFromServiceMsg != null) {
        break label1099;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.app.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label1024:
    label1030:
    label1060:
    label1099:
    for (;;)
    {
      for (;;)
      {
        if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
          paramFromServiceMsg.godFlag = false;
        }
        if (((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.has())
        {
          paramObject = ((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.get().toByteArray();
          label231:
          paramObject = paramFromServiceMsg.updateEditPicInfos(paramObject, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
          if ((paramObject != null) && (!paramObject.isEmpty())) {
            axqc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
          }
          paramObject = paramToServiceMsg.extraData.getByteArray("9c7_body");
          if ((paramObject == null) || (paramObject.length <= 0)) {}
        }
        try
        {
          localObject = new cmd0x9c7.ReqBody();
          ((cmd0x9c7.ReqBody)localObject).mergeFrom(paramObject);
          paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject).rpt_msg_tags.get());
          if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
            paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
          }
          if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
            paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
          }
          if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
            paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
          }
          if (paramToServiceMsg.extraData.containsKey("sex"))
          {
            paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
            paramObject = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            if (paramObject != null) {
              paramObject.b(paramFromServiceMsg.gender);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("birthday"))
          {
            paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
            paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
            paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
            paramObject = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            if (paramObject != null) {
              paramObject.a(paramFromServiceMsg.age);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("profession")) {
            paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
          }
          if (paramToServiceMsg.extraData.containsKey("company")) {
            paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
          }
          if (paramToServiceMsg.extraData.containsKey("college")) {
            paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
          }
        }
        catch (Exception paramObject)
        {
          try
          {
            do
            {
              axqc.a(this.app.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                paramFromServiceMsg.hometownCountry = paramObject[0];
                paramFromServiceMsg.hometownProvice = paramObject[1];
                paramFromServiceMsg.hometownCity = paramObject[2];
                paramFromServiceMsg.hometownDistrict = paramObject[3];
              }
              if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_qzone_switch") != 0) {
                  break label1012;
                }
                bool2 = true;
                paramFromServiceMsg.switchQzone = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                  break label1018;
                }
                bool2 = true;
                paramFromServiceMsg.switchHobby = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                  break label1024;
                }
                l1 = 0L;
                paramFromServiceMsg.switchGiftVisible = l1;
              }
              if (paramFromServiceMsg.getStatus() != 1000) {
                break label1030;
              }
              localEntityManager.persistOrReplace(paramFromServiceMsg);
              bool2 = true;
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = "";
              notifyUI(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), paramFromServiceMsg });
              paramObject = new HashMap();
              paramObject.put("errorCode", String.valueOf(i));
              StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramObject, "");
              axql.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
              return;
              bool1 = false;
              break;
              paramObject = null;
              break label231;
              paramObject = paramObject;
            } while ((!axqs.a) || (!QLog.isColorLevel()));
            QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + paramObject.getMessage());
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              paramObject.printStackTrace();
              continue;
              label1012:
              bool2 = false;
              continue;
              label1018:
              bool2 = false;
              continue;
              long l1 = 1L;
              continue;
              if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                localEntityManager.update(paramFromServiceMsg);
              }
            }
          }
        }
      }
      boolean bool2 = false;
      if (((cmd0x9c9.RspBody)localObject).str_errorinfo.has()) {}
      for (paramToServiceMsg = ((cmd0x9c9.RspBody)localObject).str_errorinfo.get();; paramToServiceMsg = "")
      {
        paramObject = null;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
        break;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    anzn.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          axqc.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          axqc.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          this.app.getNearbyProxy().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          this.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i == 1)
          {
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (localRspBody.msg_notify_event.has())
            {
              localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
              localObject1 = localObject3;
            }
          }
        }
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(61, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          this.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyCardHandler", 2, paramToServiceMsg, new Object[0]);
      }
    }
  }
  
  /* Error */
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1121	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2279
    //   7: invokevirtual 245	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 1121	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc_w 2281
    //   21: invokevirtual 307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   24: lstore 8
    //   26: invokestatic 970	android/os/SystemClock:elapsedRealtime	()J
    //   29: lstore 10
    //   31: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc_w 640
    //   40: iconst_2
    //   41: new 184	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 2283
    //   51: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 2286	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   58: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   70: ifeq +311 -> 381
    //   73: invokestatic 459	java/lang/System:currentTimeMillis	()J
    //   76: lstore 6
    //   78: aload_2
    //   79: invokevirtual 2286	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   82: istore 4
    //   84: aload_2
    //   85: invokevirtual 1151	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   88: ifeq +220 -> 308
    //   91: aload_3
    //   92: instanceof 1215
    //   95: ifeq +213 -> 308
    //   98: iconst_1
    //   99: istore 13
    //   101: iload 13
    //   103: ifeq +273 -> 376
    //   106: aload_0
    //   107: aload_2
    //   108: invokevirtual 2289	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   111: ldc_w 2291
    //   114: new 1469	SummaryCard/RespHead
    //   117: dup
    //   118: invokespecial 2292	SummaryCard/RespHead:<init>	()V
    //   121: invokevirtual 1511	axqt:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 1469	SummaryCard/RespHead
    //   127: astore 14
    //   129: aload 14
    //   131: ifnull +183 -> 314
    //   134: aload 14
    //   136: getfield 2295	SummaryCard/RespHead:iResult	I
    //   139: ifne +175 -> 314
    //   142: iconst_1
    //   143: istore 12
    //   145: aload 14
    //   147: astore_2
    //   148: iload 12
    //   150: istore 13
    //   152: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +50 -> 205
    //   158: new 184	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 2297
    //   168: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: astore 15
    //   173: aload 14
    //   175: ifnonnull +145 -> 320
    //   178: ldc_w 2299
    //   181: astore_2
    //   182: ldc_w 640
    //   185: iconst_2
    //   186: aload 15
    //   188: aload_2
    //   189: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: iload 12
    //   200: istore 13
    //   202: aload 14
    //   204: astore_2
    //   205: aload_0
    //   206: iload 13
    //   208: aload_3
    //   209: aload_1
    //   210: getfield 1121	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   213: aload_2
    //   214: invokespecial 2301	axqt:a	(ZLjava/lang/Object;Landroid/os/Bundle;LSummaryCard/RespHead;)V
    //   217: new 2100	java/util/HashMap
    //   220: dup
    //   221: invokespecial 2101	java/util/HashMap:<init>	()V
    //   224: astore_1
    //   225: aload_1
    //   226: ldc_w 2103
    //   229: iload 4
    //   231: invokestatic 2105	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 2108	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: invokestatic 2114	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   241: invokestatic 2120	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   244: aload_0
    //   245: getfield 2124	axqt:mApp	Lcom/tencent/common/app/AppInterface;
    //   248: invokevirtual 2127	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   251: ldc_w 2303
    //   254: iload 13
    //   256: lload 10
    //   258: lload 8
    //   260: lsub
    //   261: lconst_0
    //   262: aload_1
    //   263: ldc_w 489
    //   266: invokevirtual 2133	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   269: invokestatic 638	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   272: ifeq -259 -> 13
    //   275: ldc_w 640
    //   278: iconst_4
    //   279: new 184	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 2305
    //   289: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 459	java/lang/System:currentTimeMillis	()J
    //   295: lload 6
    //   297: lsub
    //   298: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: iconst_0
    //   309: istore 13
    //   311: goto -210 -> 101
    //   314: iconst_0
    //   315: istore 12
    //   317: goto -172 -> 145
    //   320: aload 14
    //   322: getfield 2295	SummaryCard/RespHead:iResult	I
    //   325: istore 5
    //   327: iload 5
    //   329: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: astore_2
    //   333: goto -151 -> 182
    //   336: astore 14
    //   338: aconst_null
    //   339: astore_2
    //   340: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +15 -> 358
    //   346: ldc_w 640
    //   349: iconst_2
    //   350: aload 14
    //   352: invokevirtual 1052	java/lang/Exception:toString	()Ljava/lang/String;
    //   355: invokestatic 645	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: iconst_0
    //   359: istore 13
    //   361: goto -156 -> 205
    //   364: astore 15
    //   366: aload 14
    //   368: astore_2
    //   369: aload 15
    //   371: astore 14
    //   373: goto -33 -> 340
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -173 -> 205
    //   381: lconst_0
    //   382: lstore 6
    //   384: goto -306 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	axqt
    //   0	387	1	paramToServiceMsg	ToServiceMsg
    //   0	387	2	paramFromServiceMsg	FromServiceMsg
    //   0	387	3	paramObject	Object
    //   82	148	4	i	int
    //   325	3	5	j	int
    //   76	307	6	l1	long
    //   24	235	8	l2	long
    //   29	228	10	l3	long
    //   143	173	12	bool1	boolean
    //   99	261	13	bool2	boolean
    //   127	194	14	localRespHead	SummaryCard.RespHead
    //   336	31	14	localException1	Exception
    //   371	1	14	localObject	Object
    //   171	16	15	localStringBuilder	StringBuilder
    //   364	6	15	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   106	129	336	java/lang/Exception
    //   134	142	364	java/lang/Exception
    //   152	173	364	java/lang/Exception
    //   182	198	364	java/lang/Exception
    //   320	327	364	java/lang/Exception
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool1 = bool4;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool1 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool3 = true;
          }
          bool2 = bool3;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            bool1 = bool3;
            QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool2 = bool3;
          }
        }
        if (!bool2) {
          break label254;
        }
        bool1 = bool2;
        paramToServiceMsg = ((UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray())).msg_verify_video_info.get();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          bool2 = bool1;
          bool1 = bool2;
          paramToServiceMsg = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_auth_video", 2, paramFromServiceMsg.toString());
            bool1 = bool2;
            paramToServiceMsg = localObject;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      bool1 = bool2;
    }
    for (;;)
    {
      notifyUI(47, bool1, paramToServiceMsg);
      return;
      label254:
      bool1 = false;
      paramToServiceMsg = localObject;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    notifyUI(49, bool1, null);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool2 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool1 = true;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool3 = bool1;
          }
        }
        bool1 = bool3;
        if (bool3) {}
        bool1 = bool3;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        try
        {
          axny.a(this.app);
          bool1 = bool3;
          notifyUI(46, bool1, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          break label194;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool3 = bool2;
      }
      label194:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
        bool1 = bool3;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    notifyUI(48, bool1, localToServiceMsg);
  }
  
  /* Error */
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 2363
    //   21: iconst_2
    //   22: new 184	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2365
    //   32: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 1151	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 845	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 1151	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 1132	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 2147	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 1525	[B
    //   92: checkcast 1525	[B
    //   95: invokevirtual 2148	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1132	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 2149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 1905	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 2149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 2363
    //   139: iconst_2
    //   140: new 184	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 2367
    //   150: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 2149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 2314	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 2315	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 1135	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 348	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 349	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 2316	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 2314	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 1138	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 2348	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 703	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 2351	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 2354	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 2357	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 2360	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 1146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 184	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 2369
    //   283: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 547	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 550 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 553 2 0
    //   319: checkcast 2322	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 2371
    //   328: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 2374	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 2376
    //   345: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 2379	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 2381
    //   362: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 2384	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 378	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 2386
    //   379: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 2388
    //   396: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 2390
    //   408: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 2392
    //   420: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 2394
    //   432: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 2363
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 1115	axqt:notifyUI	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 750	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 2363
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 2324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 783	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	axqt
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i	int
    //   123	3	5	j	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp))) {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    paramFromServiceMsg = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramFromServiceMsg.putString("targetUin", Long.toString(l1));
    paramFromServiceMsg.putString("selfUin", Long.toString(l2));
    paramFromServiceMsg.putInt("favoriteSource", i);
    paramFromServiceMsg.putInt("iCount", j);
    paramFromServiceMsg.putInt("from", k);
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
      }
      for (;;)
      {
        StatisticCollector.getInstance(this.mApp.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.app.getEntityManagerFactory().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            paramObject.likeCount += j;
            paramObject.bVoted = 1;
            paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
            if (paramObject.bAvailVoteCnt < 0) {
              paramObject.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.update(paramObject);
          }
          bhby.a(this.app, l1, j);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + j);
        }
        notifyUI(32, bool1, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramObject.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (localObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label537:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (localObject == null) {
        break label614;
      }
    }
    label614:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramObject.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.getInstance(this.mApp.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label537;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() != 4) {
        break;
      }
      a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = axnr.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)axqc.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)axqc.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.f());
    localObject1 = createToServiceMsg("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "reqCharmEvent() uin=" + ((ToServiceMsg)localObject1).getUin() + ", type=" + paramInt + ", seqNum=" + i);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    anzn.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, uin=" + paramLong1 + ", tinyId=" + paramLong2 + ", from=" + paramInt);
    }
    Object localObject2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, skey==null, return");
      }
      return;
    }
    Object localObject1 = new oidb_0x8e7.ReqBody();
    ((oidb_0x8e7.ReqBody)localObject1).bool_stock.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_is_first.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_warn.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_update_url.set(true);
    if (paramLong1 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_uin.set(paramLong1);
    }
    for (;;)
    {
      oidb_0x8e7.LoginSig localLoginSig = new oidb_0x8e7.LoginSig();
      localLoginSig.uint32_type.set(1);
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      localObject2 = new oidb_0x8e7.ExtParam();
      ((oidb_0x8e7.ExtParam)localObject2).uint32_client.set(1);
      ((oidb_0x8e7.ExtParam)localObject2).uint32_portal.set(paramInt);
      ((oidb_0x8e7.ExtParam)localObject2).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
      ((oidb_0x8e7.ExtParam)localObject2).msg_login_sig.set(localLoginSig);
      ((oidb_0x8e7.ReqBody)localObject1).msg_ext_parm.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x8e7_1", 2279, 1, ((oidb_0x8e7.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("uin", paramLong1 + "");
      ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      if (paramLong2 > 0L) {
        ((oidb_0x8e7.ReqBody)localObject1).uint64_tinyid.set(paramLong2);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("nearbyPeopleLike|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle, ArrayList<PicInfo> paramArrayList, axug[] paramArrayOfaxug, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((axqs.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject2;
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject2 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      for (paramBoolean3 = false; localIterator.hasNext(); paramBoolean3 = true)
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.jdField_a_of_type_Int < 0) {
          break label2404;
        }
        localObject1 = new UpdatePhotoList.RichHead();
        ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localPicInfo.f)) {
          ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.f);
        }
        if (localObject1 == null) {
          break label2401;
        }
        ((UpdatePhotoList.ReqBody)localObject2).rpt_msg_rich_headids.add((MessageMicro)localObject1);
      }
      label154:
      if (paramBoolean3)
      {
        localObject1 = axnr.a(getClass().getSimpleName());
        if (localObject1 != null) {
          ((UpdatePhotoList.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editProfileCard, photoList = " + paramArrayList + ", isHasNearbyAvatar = " + paramBoolean3);
      }
    }
    for (;;)
    {
      int j;
      int i;
      if ((paramArrayOfaxug != null) && (paramArrayOfaxug.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        j = paramArrayOfaxug.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfaxug[i];
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((axug)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((axqs.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < paramArrayOfaxug.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfaxug[i].toString()).append(",");
            i += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfaxug = (axug[])localObject1;; paramArrayOfaxug = null)
      {
        i = 0;
        j = 0;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("nick"))
          {
            i = 1;
            localObject1 = paramBundle.getString("nick");
            localReqBody.str_nick.set((String)localObject1);
            j = i;
            if (axqs.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_nick|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("sex"))
          {
            j += 1;
            k = paramBundle.getByte("sex") + 1;
            localReqBody.uint32_gender.set(k);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gender|" + k);
                i = j;
              }
            }
          }
          int k = i;
          if (paramBundle.containsKey("college"))
          {
            i += 1;
            localObject1 = paramBundle.getString("college");
            localReqBody.str_college.set((String)localObject1);
            k = i;
            if (axqs.a)
            {
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_college|" + (String)localObject1);
                k = i;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_constellation"))
          {
            i = k + 1;
            k = paramBundle.getInt("key_constellation");
            localReqBody.uint32_constellation.set(k);
            j = i;
            if (axqs.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_constellation|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("birthday"))
          {
            j += 1;
            k = paramBundle.getInt("birthday");
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(k)));
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "bytes_birthday|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("hometown"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("hometown");
            j = 0;
            while (j < 3)
            {
              PkgTools.copyData((byte[])localObject2, j * 4, PkgTools.intToBytes2(anrz.a(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = anrz.a(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(j)));
            if ((axqs.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              j = 0;
              while (j < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[j]).append(", ");
                j += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_city_id|" + ((StringBuilder)localObject2).toString());
            }
            j = i + 2;
          }
          k = j;
          if (paramBundle.containsKey("location"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("location");
            i = 0;
            while (i < 3)
            {
              PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(anrz.a(localObject1[i])), 4);
              i += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            i = anrz.a(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(i)));
            if ((axqs.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[i]).append(", ");
                i += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_location|" + ((StringBuilder)localObject2).toString());
            }
            k = j + 2;
          }
          i = k;
          if (paramBundle.containsKey("age"))
          {
            j = k + 1;
            i = paramBundle.getInt("age");
            localReqBody.uint32_age.set(i);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "set birthday|age = " + paramBundle.getInt("age"));
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("company"))
          {
            i += 1;
            localObject1 = paramBundle.getString("company");
            localReqBody.str_company.set((String)localObject1);
            j = i;
            if (axqs.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_company|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_new_nickname"))
          {
            j += 1;
            localObject1 = paramBundle.getString("key_new_nickname");
            localReqBody.str_stranger_nick.set((String)localObject1);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_stranger_nick|" + (String)localObject1);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_xuan_yan"))
          {
            localObject1 = paramBundle.getByteArray("key_xuan_yan");
            if (localObject1 != null) {
              localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
            }
            if ((axqs.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder().append("str_stranger_declare|");
              if (localObject1 != null) {
                break label2356;
              }
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
            j = i + 1;
          }
          i = j;
          if (paramBundle.containsKey("key_marital_status"))
          {
            j += 1;
            k = paramBundle.getByte("key_marital_status");
            localReqBody.uint32_love_status.set(k);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_love_status|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("profession"))
          {
            int m = paramBundle.getInt("profession");
            k = i;
            if (bgzv.a(m))
            {
              k = i + 1;
              localReqBody.uint32_profession.set(m);
            }
            j = k;
            if (axqs.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_profession|" + m);
                j = k;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_qzone_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_qzone_switch");
            localReqBody.uint32_qzone_visible.set(k);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_qzone_visible|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_hobby_switch"))
          {
            i += 1;
            k = paramBundle.getShort("key_hobby_switch");
            localReqBody.uint32_interest_visible.set(k);
            j = i;
            if (axqs.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_interest_visible|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_flower_visible_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_flower_visible_switch");
            localReqBody.uint32_gift_visible.set(k);
            i = j;
            if (axqs.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gift_visible|" + k);
                i = j;
              }
            }
          }
        }
        localReqBody.uint32_stranger_profile_flag.set(1);
        if (paramBoolean3) {
          localReqBody.uint32_face_flag.set(1);
        }
        localReqBody.uint32_guide_flag.set(0);
        if ((axqs.a) && (QLog.isColorLevel())) {
          QLog.d("Q.nearby_people_card.", 2, "fieldCount|" + (i + 1));
        }
        if (paramBoolean4)
        {
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_1", 2505, 1, localReqBody.toByteArray());
          label2246:
          if (paramBundle != null) {
            ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
          }
          if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
            ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
          }
          paramArrayList = ((ToServiceMsg)localObject1).extraData;
          if (paramArrayOfaxug != null) {
            break label2388;
          }
        }
        label2356:
        label2388:
        for (paramBundle = null;; paramBundle = paramArrayOfaxug.toByteArray())
        {
          paramArrayList.putByteArray("9c7_body", paramBundle);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
          ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
          sendPbReq((ToServiceMsg)localObject1);
          return;
          localObject1 = Integer.valueOf(localObject1.length);
          break;
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
          break label2246;
        }
      }
      label2401:
      break label154;
      label2404:
      localObject1 = null;
      break;
      paramBoolean3 = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.now", 2, "handleNotifyFaceChange req == null || res == null");
      }
      return;
    }
    paramToServiceMsg = new cmd0xb5b.RspBody();
    parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.i("Q.nearby.now", 1, "handleNotifyFaceChange code:" + paramToServiceMsg.result.get() + "   " + paramToServiceMsg.err_msg.get());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getRandomUserInfo| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyUI(10, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = createToServiceMsg("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            sendPbReq((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyCardHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = makeOIDBPkg("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.updateNearbyPeopleAuthVideo(), videoId = " + paramString + ",photoId =" + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    if (paramBoolean)
    {
      localOIDBSSOPkg.uint32_service_type.set(6);
      localOIDBSSOPkg.uint32_result.set(0);
      UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
      UpdatePhotoList.RichHead localRichHead = new UpdatePhotoList.RichHead();
      localRichHead.uint32_headid.set(paramInt);
      localRichHead.str_video_id.set(paramString);
      localReqBody.msg_verify_video_info.set(localRichHead);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (paramString = createToServiceMsg("OidbSvc.0x5ea_6");; paramString = createToServiceMsg("OidbSvc.0x5ea_7"))
    {
      paramString.setTimeout(30000L);
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      sendPbReq(paramString);
      return;
      localOIDBSSOPkg.uint32_service_type.set(7);
      break;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    nearby_ice_break.IceReq localIceReq = new nearby_ice_break.IceReq();
    try
    {
      localIceReq.uin.set(Long.parseLong(paramString));
      localIceReq.tinyid.set(String.valueOf(paramLong));
      new axws(this.app).a(13569).b(1).a(new axqw(this)).a(new axqv(this)).a(localIceReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("NearbyCardHandler", 1, "sendPoBingMsg. error=" + QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6, boolean paramBoolean3, long paramLong7, int paramInt3)
  {
    long l1 = a(paramString1);
    long l2 = a(paramString2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean1).append(",uLikeSource = ").append(paramLong6);
      QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
    }
    paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
    paramString1.extraData.putLong("selfUin", l1);
    paramString1.extraData.putLong("targetUin", l2);
    paramString1.extraData.putInt("comeFromType", paramInt1);
    paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
    paramString1.extraData.putByte("isFriend", paramByte);
    paramString1.extraData.putLong("troopCode", paramLong2);
    paramString1.extraData.putLong("troopUin", paramLong3);
    paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
    paramString1.extraData.putString("strSearchName", paramString3);
    paramString1.extraData.putLong("lGetControl", paramLong4);
    paramString1.extraData.putInt("bReqCommLabel", 1);
    paramString1.extraData.putInt("EAddFriendSource", paramInt2);
    paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
    paramString1.extraData.putLong("tinyId", paramLong5);
    paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
    paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
    paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
    paramString1.extraData.putLong("likeSource", paramLong6);
    paramString1.extraData.putLong("nowId", paramLong7);
    paramString1.extraData.putInt("nowUserType", paramInt3);
    if (paramBoolean3)
    {
      send(paramString1);
      return;
    }
    a(paramLong7, paramInt3, paramInt1, paramLong5, paramString2, paramByte, paramString1);
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = createToServiceMsg("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    sendPbReq(paramArrayList);
  }
  
  public void a(ArrayList<axpg> paramArrayList, int paramInt)
  {
    int j = 0;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("nearbyPeopleLikeNew, reqList.size=");
      if (paramArrayList == null)
      {
        i = 0;
        QLog.d("NearbyLikeLimitManager", 2, i + ", from=" + paramInt);
      }
    }
    else
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList is empty, return");
      }
    }
    label92:
    Object localObject2;
    label142:
    do
    {
      do
      {
        return;
        i = paramArrayList.size();
        break;
        localObject2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label142;
        }
      } while (!QLog.isColorLevel());
      QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, skey is empty, return");
      return;
      localObject1 = new oidb_0x8e6.ReqBody();
      ((oidb_0x8e6.ReqBody)localObject1).uint32_portal.set(paramInt);
      ((oidb_0x8e6.ReqBody)localObject1).uint32_client.set(1);
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
      Object localObject3 = new oidb_0x8e6.LoginSig();
      ((oidb_0x8e6.LoginSig)localObject3).uint32_type.set(1);
      ((oidb_0x8e6.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      ((oidb_0x8e6.ReqBody)localObject1).msg_login_sig.set((MessageMicro)localObject3);
      localObject3 = new ArrayList();
      int k = paramArrayList.size();
      localObject2 = new StringBuilder();
      i = j;
      while (i < k)
      {
        axpg localaxpg = (axpg)paramArrayList.get(i);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(localaxpg).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(localaxpg.jdField_a_of_type_Long);
        localVoteInfo.uint32_free_vote_count.set(localaxpg.jdField_a_of_type_Int);
        localVoteInfo.uint32_pay_vote_count.set(localaxpg.jdField_b_of_type_Int);
        localVoteInfo.uint32_source.set(localaxpg.d);
        ((ArrayList)localObject3).add(localVoteInfo);
        i += 1;
      }
      ((oidb_0x8e6.ReqBody)localObject1).rpt_vote_info.set((List)localObject3);
      paramArrayList = makeOIDBPkg("OidbSvc.0x8e6_1", 2278, 1, ((oidb_0x8e6.ReqBody)localObject1).toByteArray());
      paramArrayList.extraData.putInt("from", paramInt);
      sendPbReq(paramArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList=[" + ((StringBuilder)localObject2).toString() + "]");
  }
  
  public void a(List<axug> paramList, int paramInt1, int paramInt2)
  {
    anzn.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    cmd0xb5b.ReqBody localReqBody = new cmd0xb5b.ReqBody();
    PBUInt32Field localPBUInt32Field = localReqBody.is_review;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      sendPbReq(makeOIDBPkg("OidbSvc.0xb5b", 2907, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    oidb_0x5eb.RspBody localRspBody;
    String str;
    int k;
    int m;
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      localRspBody = new oidb_0x5eb.RspBody();
      paramObject = null;
      str = "";
      k = -1;
      m = 0;
      if (paramToServiceMsg.bytes_rspbody_5eb.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg);
      int j = m;
      int i = k;
      paramFromServiceMsg = str;
      paramToServiceMsg = paramObject;
      if (localRspBody.rpt_msg_uin_data.has())
      {
        j = m;
        i = k;
        paramFromServiceMsg = str;
        paramToServiceMsg = paramObject;
        if (localRspBody.rpt_msg_uin_data.size() > 0)
        {
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0);
          paramToServiceMsg = Long.valueOf(paramObject.uint64_uin.get());
          paramFromServiceMsg = paramObject.bytes_stranger_nick.get().toStringUtf8();
          i = paramObject.uint32_gender.get();
          j = paramObject.uint32_age.get();
        }
      }
      notifyUI(13, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      if (QLog.isDevelopLevel()) {
        QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo---->uin =" + paramToServiceMsg + "nickName = " + paramFromServiceMsg + " gender = " + i + "age =" + j);
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
        }
      }
    }
    notifyUI(13, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x8e7.RspBody localRspBody = new oidb_0x8e7.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin", "");
    int j = paramToServiceMsg.extraData.getInt("from", 509);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, uin=" + paramFromServiceMsg + ", ret=" + i);
    }
    if (i == 0)
    {
      for (;;)
      {
        oidb_0x8e7.UserZanInfo localUserZanInfo;
        long l;
        try
        {
          paramToServiceMsg = new axpi();
          paramToServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.bytes_recharge_url.get().toStringUtf8();
          paramToServiceMsg.jdField_b_of_type_JavaLangString = localRspBody.bytes_update_url.get().toStringUtf8();
          if (localRspBody.msg_zan_limit.has())
          {
            Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
            paramToServiceMsg.jdField_a_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
            paramToServiceMsg.c = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
            paramToServiceMsg.d = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
            paramToServiceMsg.jdField_b_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
            paramToServiceMsg.f = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
            paramObject = new ArrayList();
            if (!((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.has()) {
              break;
            }
            localObject = ((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localUserZanInfo = (oidb_0x8e7.UserZanInfo)((Iterator)localObject).next();
            axpg localaxpg = new axpg();
            l = 0L;
            if (localUserZanInfo.uint64_uin.has())
            {
              l = localUserZanInfo.uint64_uin.get();
              localaxpg.jdField_a_of_type_Long = l;
              localaxpg.jdField_a_of_type_Int = ((int)localUserZanInfo.uint64_free_zan.get());
              localaxpg.jdField_b_of_type_Int = ((int)localUserZanInfo.uint64_pay_zan.get());
              localaxpg.c = ((int)localUserZanInfo.uint64_pay_stock.get());
              if (l <= 0L) {
                continue;
              }
              paramObject.add(localaxpg);
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(16, false, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, " + paramToServiceMsg.toString());
          }
        }
        if (localUserZanInfo.uint64_tinyid.has()) {
          l = localUserZanInfo.uint64_tinyid.get();
        }
      }
      if (localRspBody.msg_warn.has()) {
        paramToServiceMsg.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg = ((oidb_0x8e7.WarnMsg)localRspBody.msg_warn.get());
      }
      if (localRspBody.msg_stock_rsp.has()) {
        paramToServiceMsg.e = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
      }
      ((axpb)this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(paramToServiceMsg, paramObject, j);
      notifyUI(16, true, paramFromServiceMsg);
      return;
    }
    notifyUI(16, false, paramFromServiceMsg);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("from", 0);
    Object localObject1 = new oidb_0x8e6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew, ret=" + i + ", from=" + j);
    }
    paramToServiceMsg = new ArrayList();
    if (i == 0)
    {
      int k = ((oidb_0x8e6.RspBody)localObject1).uint32_level.get();
      int m = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_user_count.get();
      int n = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_count.get();
      ((oidb_0x8e6.RspBody)localObject1).uint32_remain_total.get();
      paramFromServiceMsg = (axpb)this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      paramObject = ((oidb_0x8e6.RspBody)localObject1).rpt_vote_result.get();
      int i1 = paramObject.size();
      i = 0;
      while (i < i1)
      {
        Object localObject2 = (oidb_0x8e6.VoteResult)paramObject.get(i);
        localObject1 = new axph();
        ((axph)localObject1).jdField_a_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_ret.get();
        ((axph)localObject1).jdField_a_of_type_JavaLangString = ((oidb_0x8e6.VoteResult)localObject2).bytes_err_msg.get().toStringUtf8();
        ((axph)localObject1).jdField_a_of_type_Long = ((oidb_0x8e6.VoteResult)localObject2).uint64_uin.get();
        ((axph)localObject1).jdField_b_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_free_vote_count.get();
        ((axph)localObject1).c = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_pay_vote_count.get();
        ((axph)localObject1).d = ((oidb_0x8e6.VoteResult)localObject2).uint32_vote_count.get();
        ((axph)localObject1).e = ((int)((oidb_0x8e6.VoteResult)localObject2).uint64_pay_stock.get());
        paramToServiceMsg.add(localObject1);
        int i2 = ((axph)localObject1).jdField_b_of_type_Int;
        i2 = ((axph)localObject1).c + i2;
        if ((((axph)localObject1).jdField_a_of_type_Int == 0) && (((axph)localObject1).jdField_a_of_type_Long > 0L) && (i2 > 0))
        {
          bhby.a(this.app, ((axph)localObject1).jdField_a_of_type_Long, i2);
          localObject2 = this.app.getEntityManagerFactory().createEntityManager();
          NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(((axph)localObject1).jdField_a_of_type_Long) });
          if (localNearbyPeopleCard != null)
          {
            localNearbyPeopleCard.likeCount += i2;
            localNearbyPeopleCard.bVoted = 1;
            localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
            if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
              localNearbyPeopleCard.bAvailVoteCnt = 0;
            }
            ((EntityManager)localObject2).update(localNearbyPeopleCard);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + localObject1);
        }
        paramFromServiceMsg.a(((axph)localObject1).jdField_a_of_type_Long + "", true);
        i += 1;
      }
      paramFromServiceMsg.a(k, m, n);
      notifyUI(17, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    notifyUI(17, false, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("SummaryCard.ReqSummaryCard");
      this.a.add("OidbSvc.0x9c8_0");
      this.a.add("OidbSvc.0x9c5_0");
      this.a.add("OidbSvc.0x9c9_0");
      this.a.add("OidbSvc.0x9c9_1");
      this.a.add("OidbSvc.0x9c7_0");
      this.a.add("OidbSvc.0x682");
      this.a.add("OidbSvc.0x686");
      this.a.add("OidbSvc.0x5ea_1");
      this.a.add("OidbSvc.0x5ea_3");
      this.a.add("OidbSvc.0x5ea_4");
      this.a.add("SQQzoneSvc.getCover");
      this.a.add("OidbSvc.0x8b4");
      this.a.add("OidbSvc.0x5ea_6");
      this.a.add("OidbSvc.0x5ea_7");
      this.a.add("VisitorSvc.ReqFavorite");
      this.a.add("OidbSvc.0x66b");
      this.a.add("OidbSvc.0x66b");
      this.a.add("OidbSvc.0x66b");
      this.a.add("OidbSvc.0x8e6_1");
      this.a.add("OidbSvc.0x8e7_1");
      this.a.add("OidbSvc.0xb5b");
    }
    return !this.a.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return axqx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (msgCmdFilter(paramFromServiceMsg.getServiceCmd()));
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x9c9_0".equals(str)) || ("OidbSvc.0x9c9_1".equals(str)))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c7_0".equals(str))
      {
        anzn.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e7_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e6_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb5b".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqt
 * JD-Core Version:    0.7.0.1
 */