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
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
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
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.nowsummarycard.NowSummaryCard.NowSummaryCardReq;
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

public class ausy
  extends alko
{
  protected Set<String> a;
  
  public ausy(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
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
    //   1: ldc 221
    //   3: invokevirtual 225	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 10
    //   8: aload_3
    //   9: ldc 227
    //   11: invokevirtual 231	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   14: istore 8
    //   16: iload_1
    //   17: ifeq +6007 -> 6024
    //   20: aload_2
    //   21: checkcast 233	SummaryCard/RespSummaryCard
    //   24: astore 18
    //   26: aload_0
    //   27: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawbx;
    //   33: invokevirtual 249	awbx:createEntityManager	()Lawbw;
    //   36: astore 16
    //   38: aload 16
    //   40: invokevirtual 254	awbw:a	()Lawby;
    //   43: astore 17
    //   45: aload 17
    //   47: invokevirtual 258	awby:a	()V
    //   50: aload_3
    //   51: ldc_w 260
    //   54: lconst_0
    //   55: invokevirtual 264	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   58: lstore 11
    //   60: aload_3
    //   61: ldc_w 266
    //   64: invokevirtual 269	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   67: lstore 13
    //   69: aload_3
    //   70: ldc_w 271
    //   73: invokevirtual 231	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   76: istore 5
    //   78: aconst_null
    //   79: astore_2
    //   80: iload 5
    //   82: ifne +889 -> 971
    //   85: lload 11
    //   87: lconst_0
    //   88: lcmp
    //   89: ifle +30 -> 119
    //   92: aload 16
    //   94: ldc_w 273
    //   97: ldc_w 275
    //   100: iconst_1
    //   101: anewarray 277	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: lload 11
    //   108: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: aastore
    //   112: invokevirtual 283	awbw:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lawbv;
    //   115: checkcast 273	com/tencent/mobileqq/data/NearbyPeopleCard
    //   118: astore_2
    //   119: aload_2
    //   120: ifnonnull +5933 -> 6053
    //   123: aload 18
    //   125: getfield 287	SummaryCard/RespSummaryCard:lUIN	J
    //   128: lconst_0
    //   129: lcmp
    //   130: ifle +5923 -> 6053
    //   133: aload 16
    //   135: ldc_w 273
    //   138: ldc_w 289
    //   141: iconst_1
    //   142: anewarray 277	java/lang/String
    //   145: dup
    //   146: iconst_0
    //   147: aload 18
    //   149: getfield 287	SummaryCard/RespSummaryCard:lUIN	J
    //   152: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   155: aastore
    //   156: invokevirtual 283	awbw:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lawbv;
    //   159: checkcast 273	com/tencent/mobileqq/data/NearbyPeopleCard
    //   162: astore_2
    //   163: aload_2
    //   164: ifnonnull +844 -> 1008
    //   167: new 273	com/tencent/mobileqq/data/NearbyPeopleCard
    //   170: dup
    //   171: invokespecial 290	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   174: astore 15
    //   176: aload 18
    //   178: getfield 294	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   181: astore_2
    //   182: aload 15
    //   184: aload 18
    //   186: getfield 287	SummaryCard/RespSummaryCard:lUIN	J
    //   189: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: putfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   195: lload 11
    //   197: lconst_0
    //   198: lcmp
    //   199: ifle +1000 -> 1199
    //   202: aload 15
    //   204: lload 11
    //   206: putfield 300	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   209: aload 15
    //   211: aload_3
    //   212: ldc_w 266
    //   215: invokevirtual 269	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   218: putfield 302	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   221: aload 15
    //   223: aload_3
    //   224: ldc_w 271
    //   227: invokevirtual 231	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   230: putfield 305	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   233: iload 8
    //   235: ifeq +21 -> 256
    //   238: aload 15
    //   240: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   243: aload_0
    //   244: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   247: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   250: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +958 -> 1211
    //   256: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +48 -> 307
    //   262: ldc_w 313
    //   265: iconst_2
    //   266: new 55	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 315
    //   276: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 18
    //   281: getfield 318	SummaryCard/RespSummaryCard:iVoteCount	I
    //   284: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: ldc_w 320
    //   290: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 18
    //   295: getfield 323	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   298: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload 15
    //   309: aload 18
    //   311: getfield 318	SummaryCard/RespSummaryCard:iVoteCount	I
    //   314: putfield 329	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   317: aload 15
    //   319: aload 18
    //   321: getfield 323	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   324: putfield 332	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   327: aload 15
    //   329: aload 18
    //   331: getfield 336	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   334: putfield 340	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   337: aload 15
    //   339: aload 18
    //   341: getfield 343	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   344: putfield 346	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   347: aload 15
    //   349: aload 18
    //   351: getfield 350	SummaryCard/RespSummaryCard:vRichSign	[B
    //   354: putfield 353	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   357: aload 15
    //   359: aload_2
    //   360: getfield 359	SummaryCard/DateCard:bMarriage	B
    //   363: putfield 362	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   366: aload 15
    //   368: aload 18
    //   370: getfield 365	SummaryCard/RespSummaryCard:bSex	B
    //   373: putfield 368	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   376: aload 15
    //   378: aload 18
    //   380: getfield 371	SummaryCard/RespSummaryCard:bAge	B
    //   383: putfield 374	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   386: aload 15
    //   388: aload 18
    //   390: getfield 377	SummaryCard/RespSummaryCard:iBirthday	I
    //   393: putfield 380	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   396: aload 15
    //   398: aload_2
    //   399: getfield 383	SummaryCard/DateCard:uProfession	J
    //   402: l2i
    //   403: putfield 386	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   406: aload 15
    //   408: aload_2
    //   409: getfield 389	SummaryCard/DateCard:bConstellation	B
    //   412: putfield 392	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   415: aload 15
    //   417: aload_2
    //   418: getfield 395	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   421: putfield 398	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   424: aload 15
    //   426: aload_2
    //   427: getfield 401	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   430: putfield 404	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   433: aload 15
    //   435: aload 18
    //   437: getfield 407	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   440: putfield 410	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   443: aload 15
    //   445: aload_2
    //   446: getfield 413	SummaryCard/DateCard:vDateInfo	[B
    //   449: putfield 416	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   452: aload 15
    //   454: aload_2
    //   455: getfield 419	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   458: putfield 422	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   461: aload 15
    //   463: aload_2
    //   464: getfield 425	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   467: putfield 428	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   470: aload 15
    //   472: aload_2
    //   473: getfield 431	SummaryCard/DateCard:uHomeCountry	J
    //   476: invokestatic 435	allj:a	(J)Ljava/lang/String;
    //   479: putfield 438	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   482: aload 15
    //   484: aload_2
    //   485: getfield 441	SummaryCard/DateCard:uHomeProvince	J
    //   488: invokestatic 435	allj:a	(J)Ljava/lang/String;
    //   491: putfield 444	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   494: aload 15
    //   496: aload_2
    //   497: getfield 447	SummaryCard/DateCard:uHomeCity	J
    //   500: invokestatic 435	allj:a	(J)Ljava/lang/String;
    //   503: putfield 450	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   506: aload 15
    //   508: aload_2
    //   509: getfield 453	SummaryCard/DateCard:uHomeZone	J
    //   512: invokestatic 435	allj:a	(J)Ljava/lang/String;
    //   515: putfield 456	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   518: aload 15
    //   520: aload 18
    //   522: getfield 459	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   525: putfield 462	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   528: aload 15
    //   530: aload 18
    //   532: getfield 465	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   535: putfield 468	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   538: aload 15
    //   540: aload 18
    //   542: getfield 471	SummaryCard/RespSummaryCard:ulShowControl	J
    //   545: putfield 474	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   548: aload 15
    //   550: aload 18
    //   552: getfield 477	SummaryCard/RespSummaryCard:lUserFlag	J
    //   555: putfield 480	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   558: aload 15
    //   560: aload 18
    //   562: getfield 483	SummaryCard/RespSummaryCard:vSeed	[B
    //   565: putfield 484	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   568: aload 15
    //   570: aload 18
    //   572: getfield 487	SummaryCard/RespSummaryCard:lCacheControl	J
    //   575: invokevirtual 491	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   578: aload 15
    //   580: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   583: putfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   586: aload 15
    //   588: iload 8
    //   590: putfield 502	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   593: aload 15
    //   595: aload 18
    //   597: getfield 505	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   600: putfield 506	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   603: aload 15
    //   605: getfield 506	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   608: ifnull +626 -> 1234
    //   611: aload 15
    //   613: getfield 506	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   616: arraylength
    //   617: ifne +63 -> 680
    //   620: aload_0
    //   621: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   624: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   627: aload 15
    //   629: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   632: invokestatic 511	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   635: ifne +45 -> 680
    //   638: aload_0
    //   639: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   642: ldc_w 513
    //   645: ldc_w 515
    //   648: ldc_w 517
    //   651: ldc_w 519
    //   654: ldc_w 521
    //   657: iconst_0
    //   658: iconst_0
    //   659: aload_0
    //   660: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   663: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   666: aload 15
    //   668: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   671: ldc_w 517
    //   674: ldc_w 517
    //   677: invokestatic 527	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload_0
    //   681: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   684: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   687: aload 15
    //   689: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   692: invokevirtual 536	ayvc:m	(Ljava/lang/String;)[B
    //   695: ifnonnull +23 -> 718
    //   698: aload_0
    //   699: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   702: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   705: aload 15
    //   707: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   710: aload 15
    //   712: getfield 506	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   715: invokevirtual 540	ayvc:h	(Ljava/lang/String;[B)V
    //   718: aload 15
    //   720: aload_2
    //   721: getfield 543	SummaryCard/DateCard:uSchoolId	J
    //   724: putfield 546	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   727: aload 15
    //   729: aload_2
    //   730: getfield 549	SummaryCard/DateCard:vGroupList	[B
    //   733: putfield 550	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   736: aload 15
    //   738: aload_2
    //   739: getfield 553	SummaryCard/DateCard:vNearbyInfo	[B
    //   742: putfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   745: aload 15
    //   747: aload_2
    //   748: getfield 559	SummaryCard/DateCard:vActivityList	[B
    //   751: putfield 560	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   754: aload 15
    //   756: aload 18
    //   758: getfield 477	SummaryCard/RespSummaryCard:lUserFlag	J
    //   761: putfield 561	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   764: aload 15
    //   766: aload 18
    //   768: getfield 564	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   771: putfield 565	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   774: aload 18
    //   776: getfield 569	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   779: ifnull +16 -> 795
    //   782: aload 15
    //   784: aload 18
    //   786: getfield 569	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   789: getfield 574	SummaryCard/HeartInfo:iHeartCount	I
    //   792: putfield 577	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   795: aload 18
    //   797: getfield 581	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   800: ifnull +479 -> 1279
    //   803: aload 15
    //   805: aload 18
    //   807: getfield 581	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   810: getfield 586	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   813: putfield 589	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   816: aload 15
    //   818: aload 18
    //   820: getfield 581	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   823: getfield 592	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   826: putfield 593	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   829: aload 18
    //   831: getfield 596	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   834: astore_3
    //   835: aload_3
    //   836: ifnull +489 -> 1325
    //   839: aload 15
    //   841: new 148	java/util/ArrayList
    //   844: dup
    //   845: invokespecial 149	java/util/ArrayList:<init>	()V
    //   848: putfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   851: new 601	appoint/define/appoint_define$CommonLabel
    //   854: dup
    //   855: invokespecial 602	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   858: astore 19
    //   860: aload 19
    //   862: aload_3
    //   863: invokevirtual 603	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   866: pop
    //   867: aload 19
    //   869: getfield 606	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   872: invokevirtual 211	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   875: astore_3
    //   876: aload 19
    //   878: getfield 609	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   881: invokevirtual 211	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   884: astore 20
    //   886: new 611	org/json/JSONArray
    //   889: dup
    //   890: invokespecial 612	org/json/JSONArray:<init>	()V
    //   893: astore 19
    //   895: aload_3
    //   896: invokeinterface 159 1 0
    //   901: aload 20
    //   903: invokeinterface 159 1 0
    //   908: if_icmpne +407 -> 1315
    //   911: iconst_0
    //   912: istore 5
    //   914: iload 5
    //   916: aload_3
    //   917: invokeinterface 159 1 0
    //   922: if_icmpge +393 -> 1315
    //   925: aload_3
    //   926: iload 5
    //   928: invokeinterface 214 2 0
    //   933: checkcast 75	com/tencent/mobileqq/pb/ByteStringMicro
    //   936: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   939: astore 20
    //   941: aload 15
    //   943: getfield 599	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   946: aload 20
    //   948: invokeinterface 183 2 0
    //   953: pop
    //   954: aload 19
    //   956: aload 20
    //   958: invokevirtual 616	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   961: pop
    //   962: iload 5
    //   964: iconst_1
    //   965: iadd
    //   966: istore 5
    //   968: goto -54 -> 914
    //   971: lload 13
    //   973: lconst_0
    //   974: lcmp
    //   975: ifle +5073 -> 6048
    //   978: aload 16
    //   980: ldc_w 273
    //   983: ldc_w 618
    //   986: iconst_1
    //   987: anewarray 277	java/lang/String
    //   990: dup
    //   991: iconst_0
    //   992: lload 13
    //   994: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   997: aastore
    //   998: invokevirtual 283	awbw:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lawbv;
    //   1001: checkcast 273	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1004: astore_2
    //   1005: goto -842 -> 163
    //   1008: aload_2
    //   1009: invokevirtual 621	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1012: istore 5
    //   1014: aload_2
    //   1015: invokevirtual 624	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   1018: lstore 13
    //   1020: new 273	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1023: dup
    //   1024: invokespecial 290	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1027: astore 15
    //   1029: aload 15
    //   1031: aload_2
    //   1032: getfield 628	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1035: putfield 628	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1038: aload 15
    //   1040: aload_2
    //   1041: getfield 631	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1044: putfield 631	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1047: aload 15
    //   1049: aload_2
    //   1050: getfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1053: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1056: aload 15
    //   1058: aload_2
    //   1059: getfield 637	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1062: putfield 637	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1065: aload 15
    //   1067: aload_2
    //   1068: getfield 640	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1071: putfield 640	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1074: aload 15
    //   1076: aload_2
    //   1077: getfield 643	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1080: putfield 643	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1083: aload 15
    //   1085: aload_2
    //   1086: getfield 646	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1089: putfield 646	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1092: aload 15
    //   1094: aload_2
    //   1095: getfield 649	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1098: putfield 649	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1101: aload 15
    //   1103: aload_2
    //   1104: getfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1107: putfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1110: aload 15
    //   1112: aload_2
    //   1113: getfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1116: putfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1119: aload 15
    //   1121: aload_2
    //   1122: getfield 658	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1125: putfield 658	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1128: aload 15
    //   1130: aload_2
    //   1131: getfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1134: putfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1137: aload 15
    //   1139: aload_2
    //   1140: getfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1143: putfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1146: aload 15
    //   1148: aload_2
    //   1149: getfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1152: putfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1155: aload 15
    //   1157: aload_2
    //   1158: getfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1161: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1164: aload 15
    //   1166: aload_2
    //   1167: getfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1170: putfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1173: aload 15
    //   1175: aload_2
    //   1176: getfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1179: putfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1182: aload 15
    //   1184: iload 5
    //   1186: invokevirtual 677	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1189: aload 15
    //   1191: lload 13
    //   1193: invokevirtual 680	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1196: goto -1020 -> 176
    //   1199: aload 15
    //   1201: aload_2
    //   1202: getfield 683	SummaryCard/DateCard:lTinyId	J
    //   1205: putfield 300	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1208: goto -999 -> 209
    //   1211: aload 15
    //   1213: aload 18
    //   1215: getfield 318	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1218: putfield 329	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1221: aload 15
    //   1223: aload 18
    //   1225: getfield 323	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1228: putfield 332	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1231: goto -894 -> 337
    //   1234: aload_0
    //   1235: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1238: ldc_w 513
    //   1241: ldc_w 515
    //   1244: ldc_w 517
    //   1247: ldc_w 519
    //   1250: ldc_w 685
    //   1253: iconst_0
    //   1254: iconst_0
    //   1255: aload_0
    //   1256: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1259: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1262: aload 15
    //   1264: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1267: ldc_w 517
    //   1270: ldc_w 517
    //   1273: invokestatic 527	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1276: goto -558 -> 718
    //   1279: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1282: ifeq -453 -> 829
    //   1285: ldc_w 313
    //   1288: iconst_2
    //   1289: new 55	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 690
    //   1299: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aconst_null
    //   1303: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: goto -483 -> 829
    //   1315: aload 15
    //   1317: aload 19
    //   1319: invokevirtual 697	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1322: putfield 700	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1325: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1328: ifeq +33 -> 1361
    //   1331: ldc_w 313
    //   1334: iconst_4
    //   1335: new 55	java/lang/StringBuilder
    //   1338: dup
    //   1339: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1342: ldc_w 702
    //   1345: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload_2
    //   1349: getfield 543	SummaryCard/DateCard:uSchoolId	J
    //   1352: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1355: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1361: aload 15
    //   1363: aload 18
    //   1365: getfield 705	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1368: putfield 706	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1371: aload 15
    //   1373: aload 18
    //   1375: getfield 710	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1378: putfield 711	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1381: aload 15
    //   1383: aload 18
    //   1385: getfield 714	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1388: putfield 715	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1391: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1394: ifeq +61 -> 1455
    //   1397: ldc 29
    //   1399: iconst_2
    //   1400: new 55	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1407: ldc_w 717
    //   1410: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload 18
    //   1415: getfield 705	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1418: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: ldc_w 719
    //   1424: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload 18
    //   1429: getfield 710	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1432: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1435: ldc_w 721
    //   1438: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: aload 18
    //   1443: getfield 714	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1446: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1449: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1452: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1455: aload 18
    //   1457: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1460: ifnull +58 -> 1518
    //   1463: aload 15
    //   1465: aload 18
    //   1467: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1470: getfield 730	SummaryCard/PanSocialInfo:uCharm	J
    //   1473: putfield 733	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1476: aload 15
    //   1478: aload 18
    //   1480: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1483: getfield 736	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1486: l2i
    //   1487: putfield 739	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1490: aload 15
    //   1492: aload 18
    //   1494: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1497: getfield 742	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1500: l2i
    //   1501: putfield 745	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1504: aload 15
    //   1506: aload 18
    //   1508: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1511: getfield 748	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1514: l2i
    //   1515: putfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1518: iload 8
    //   1520: ifeq +21 -> 1541
    //   1523: aload 15
    //   1525: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1528: aload_0
    //   1529: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1532: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1535: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1538: ifeq +250 -> 1788
    //   1541: iconst_1
    //   1542: istore_1
    //   1543: aload 15
    //   1545: aload_2
    //   1546: getfield 754	SummaryCard/DateCard:vFaces	[B
    //   1549: aload 18
    //   1551: getfield 758	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1554: iload_1
    //   1555: invokevirtual 762	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1558: pop
    //   1559: aload 15
    //   1561: aload 18
    //   1563: getfield 766	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1566: getfield 771	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1569: putfield 772	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1572: aload 18
    //   1574: getfield 775	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1577: ifne +216 -> 1793
    //   1580: aload 15
    //   1582: iconst_1
    //   1583: putfield 778	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1586: aload 4
    //   1588: ifnull +13 -> 1601
    //   1591: aload 15
    //   1593: aload 4
    //   1595: getfield 783	SummaryCard/RespHead:vCookies	[B
    //   1598: putfield 784	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1601: aload 15
    //   1603: getfield 480	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1606: ldc2_w 785
    //   1609: land
    //   1610: lconst_0
    //   1611: lcmp
    //   1612: ifeq +190 -> 1802
    //   1615: aload 15
    //   1617: iconst_1
    //   1618: putfield 789	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1621: aload 15
    //   1623: getfield 480	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1626: ldc2_w 790
    //   1629: land
    //   1630: lconst_0
    //   1631: lcmp
    //   1632: ifeq +179 -> 1811
    //   1635: aload 15
    //   1637: iconst_1
    //   1638: putfield 794	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1641: aload 15
    //   1643: invokevirtual 797	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1646: ifne +232 -> 1878
    //   1649: aload 15
    //   1651: ldc_w 517
    //   1654: putfield 800	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1657: aload 15
    //   1659: ldc_w 517
    //   1662: putfield 803	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1665: aload 15
    //   1667: ldc_w 517
    //   1670: putfield 806	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1673: aload 18
    //   1675: getfield 810	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1678: astore_2
    //   1679: aload_2
    //   1680: ifnull +198 -> 1878
    //   1683: aload_2
    //   1684: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1687: ifnull +191 -> 1878
    //   1690: aload_2
    //   1691: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1694: invokevirtual 816	java/util/ArrayList:size	()I
    //   1697: ifle +181 -> 1878
    //   1700: iconst_0
    //   1701: istore 5
    //   1703: iload 5
    //   1705: aload_2
    //   1706: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1709: invokevirtual 816	java/util/ArrayList:size	()I
    //   1712: if_icmpge +166 -> 1878
    //   1715: iload 5
    //   1717: ifne +103 -> 1820
    //   1720: aload 15
    //   1722: aload_2
    //   1723: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1726: iload 5
    //   1728: invokevirtual 817	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1731: checkcast 819	SummaryCard/PhotoInfo
    //   1734: getfield 822	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1737: putfield 800	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1740: iload 5
    //   1742: iconst_1
    //   1743: iadd
    //   1744: istore 5
    //   1746: goto -43 -> 1703
    //   1749: astore_3
    //   1750: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1753: ifeq -428 -> 1325
    //   1756: ldc 29
    //   1758: iconst_2
    //   1759: new 55	java/lang/StringBuilder
    //   1762: dup
    //   1763: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1766: ldc_w 824
    //   1769: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: aload_3
    //   1773: invokevirtual 827	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1776: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: invokestatic 830	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1785: goto -460 -> 1325
    //   1788: iconst_0
    //   1789: istore_1
    //   1790: goto -247 -> 1543
    //   1793: aload 15
    //   1795: iconst_0
    //   1796: putfield 778	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1799: goto -213 -> 1586
    //   1802: aload 15
    //   1804: iconst_0
    //   1805: putfield 789	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1808: goto -187 -> 1621
    //   1811: aload 15
    //   1813: iconst_0
    //   1814: putfield 794	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1817: goto -176 -> 1641
    //   1820: iload 5
    //   1822: iconst_1
    //   1823: if_icmpne +26 -> 1849
    //   1826: aload 15
    //   1828: aload_2
    //   1829: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1832: iload 5
    //   1834: invokevirtual 817	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1837: checkcast 819	SummaryCard/PhotoInfo
    //   1840: getfield 822	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1843: putfield 803	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1846: goto -106 -> 1740
    //   1849: iload 5
    //   1851: iconst_2
    //   1852: if_icmpne -112 -> 1740
    //   1855: aload 15
    //   1857: aload_2
    //   1858: getfield 815	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1861: iload 5
    //   1863: invokevirtual 817	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1866: checkcast 819	SummaryCard/PhotoInfo
    //   1869: getfield 822	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1872: putfield 806	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1875: goto -135 -> 1740
    //   1878: aload 18
    //   1880: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1883: astore_2
    //   1884: aload_2
    //   1885: ifnull +27 -> 1912
    //   1888: aload_2
    //   1889: getfield 833	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1892: lconst_1
    //   1893: lcmp
    //   1894: ifne +153 -> 2047
    //   1897: aload 15
    //   1899: iconst_1
    //   1900: putfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1903: aload 15
    //   1905: aload_2
    //   1906: getfield 839	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1909: putfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1912: aload 18
    //   1914: getfield 843	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1917: ifnull +30 -> 1947
    //   1920: aload 15
    //   1922: aload_0
    //   1923: aload 18
    //   1925: getfield 843	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1928: ldc_w 845
    //   1931: new 847	GameCenter/RespLastGameInfo
    //   1934: dup
    //   1935: invokespecial 848	GameCenter/RespLastGameInfo:<init>	()V
    //   1938: invokevirtual 852	ausy:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1941: checkcast 847	GameCenter/RespLastGameInfo
    //   1944: invokevirtual 856	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1947: aload 18
    //   1949: getfield 725	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1952: astore_2
    //   1953: aload_2
    //   1954: ifnull +13 -> 1967
    //   1957: aload 15
    //   1959: aload_2
    //   1960: getfield 859	SummaryCard/PanSocialInfo:uChatflag	J
    //   1963: l2i
    //   1964: putfield 862	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1967: new 148	java/util/ArrayList
    //   1970: dup
    //   1971: invokespecial 149	java/util/ArrayList:<init>	()V
    //   1974: astore_2
    //   1975: aload 18
    //   1977: getfield 865	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1980: ifnull +747 -> 2727
    //   1983: aload 18
    //   1985: getfield 865	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1988: invokevirtual 816	java/util/ArrayList:size	()I
    //   1991: ifle +736 -> 2727
    //   1994: iconst_0
    //   1995: istore 5
    //   1997: iload 5
    //   1999: aload 18
    //   2001: getfield 865	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2004: invokevirtual 816	java/util/ArrayList:size	()I
    //   2007: if_icmpge +720 -> 2727
    //   2010: aload 18
    //   2012: getfield 865	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2015: iload 5
    //   2017: invokevirtual 817	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2020: checkcast 866	[B
    //   2023: astore_3
    //   2024: aload_3
    //   2025: ifnonnull +31 -> 2056
    //   2028: iconst_0
    //   2029: istore 6
    //   2031: iload 6
    //   2033: bipush 10
    //   2035: if_icmpgt +28 -> 2063
    //   2038: iload 5
    //   2040: iconst_1
    //   2041: iadd
    //   2042: istore 5
    //   2044: goto -47 -> 1997
    //   2047: aload 15
    //   2049: iconst_0
    //   2050: putfield 836	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   2053: goto -150 -> 1903
    //   2056: aload_3
    //   2057: arraylength
    //   2058: istore 6
    //   2060: goto -29 -> 2031
    //   2063: aload_3
    //   2064: iconst_1
    //   2065: invokestatic 871	bdlr:a	([BI)J
    //   2068: l2i
    //   2069: istore 7
    //   2071: aload_3
    //   2072: iconst_5
    //   2073: invokestatic 871	bdlr:a	([BI)J
    //   2076: l2i
    //   2077: istore 9
    //   2079: iload 7
    //   2081: ifle -43 -> 2038
    //   2084: iload 7
    //   2086: bipush 9
    //   2088: iadd
    //   2089: iload 6
    //   2091: if_icmpge -53 -> 2038
    //   2094: iload 7
    //   2096: newarray byte
    //   2098: astore 4
    //   2100: aload 4
    //   2102: iconst_0
    //   2103: aload_3
    //   2104: bipush 9
    //   2106: iload 7
    //   2108: invokestatic 874	bdlr:a	([BI[BII)V
    //   2111: new 876	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2114: dup
    //   2115: invokespecial 877	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2118: astore_3
    //   2119: aload_3
    //   2120: aload 4
    //   2122: invokevirtual 878	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2125: pop
    //   2126: aload_3
    //   2127: getfield 882	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2130: invokevirtual 885	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2133: istore 9
    //   2135: new 887	awmz
    //   2138: dup
    //   2139: invokespecial 888	awmz:<init>	()V
    //   2142: astore 4
    //   2144: iload 9
    //   2146: ifne +485 -> 2631
    //   2149: aload 4
    //   2151: aload_3
    //   2152: getfield 892	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2155: getfield 898	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2158: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2161: putfield 904	awmz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2164: aload 4
    //   2166: aload_3
    //   2167: getfield 892	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2170: getfield 907	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2173: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2176: putfield 909	awmz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2179: aload 4
    //   2181: aload_3
    //   2182: getfield 912	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2185: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2188: putfield 914	awmz:jdField_a_of_type_Int	I
    //   2191: new 148	java/util/ArrayList
    //   2194: dup
    //   2195: invokespecial 149	java/util/ArrayList:<init>	()V
    //   2198: astore 19
    //   2200: iconst_0
    //   2201: istore 6
    //   2203: iload 6
    //   2205: aload_3
    //   2206: getfield 892	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2209: getfield 917	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2212: invokevirtual 918	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2215: if_icmpge +409 -> 2624
    //   2218: aload_3
    //   2219: getfield 892	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2222: getfield 917	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2225: iload 6
    //   2227: invokevirtual 921	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2230: checkcast 923	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2233: astore 20
    //   2235: new 925	awna
    //   2238: dup
    //   2239: invokespecial 926	awna:<init>	()V
    //   2242: astore 21
    //   2244: aload 21
    //   2246: aload 20
    //   2248: getfield 929	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2251: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2254: putfield 930	awna:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2257: aload 21
    //   2259: aload 20
    //   2261: getfield 933	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2264: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2267: putfield 934	awna:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2270: aload 21
    //   2272: aload 20
    //   2274: getfield 937	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2277: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2280: putfield 940	awna:c	Ljava/lang/String;
    //   2283: aload 21
    //   2285: aload 20
    //   2287: getfield 943	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2290: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2293: putfield 945	awna:d	Ljava/lang/String;
    //   2296: aload 21
    //   2298: aload 20
    //   2300: getfield 948	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2303: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2306: putfield 950	awna:e	Ljava/lang/String;
    //   2309: aload 21
    //   2311: aload 20
    //   2313: getfield 953	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2316: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2319: putfield 956	awna:f	Ljava/lang/String;
    //   2322: aload 21
    //   2324: aload 20
    //   2326: getfield 959	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2329: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2332: putfield 961	awna:jdField_a_of_type_Long	J
    //   2335: aload 21
    //   2337: aload 4
    //   2339: getfield 914	awmz:jdField_a_of_type_Int	I
    //   2342: putfield 962	awna:jdField_a_of_type_Int	I
    //   2345: aload 20
    //   2347: getfield 965	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2350: invokevirtual 918	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2353: ifle +254 -> 2607
    //   2356: new 148	java/util/ArrayList
    //   2359: dup
    //   2360: invokespecial 149	java/util/ArrayList:<init>	()V
    //   2363: astore 22
    //   2365: iconst_0
    //   2366: istore 7
    //   2368: iload 7
    //   2370: aload 20
    //   2372: getfield 965	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2375: invokevirtual 918	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2378: if_icmpge +222 -> 2600
    //   2381: aload 20
    //   2383: getfield 965	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2386: iload 7
    //   2388: invokevirtual 921	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2391: checkcast 967	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2394: astore 23
    //   2396: new 969	awmy
    //   2399: dup
    //   2400: invokespecial 970	awmy:<init>	()V
    //   2403: astore 24
    //   2405: aload 24
    //   2407: aload 23
    //   2409: getfield 973	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2412: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2415: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2418: putfield 974	awmy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2421: aload 24
    //   2423: aload 23
    //   2425: getfield 977	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2428: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2431: i2l
    //   2432: putfield 978	awmy:jdField_a_of_type_Long	J
    //   2435: aload 24
    //   2437: aload 23
    //   2439: getfield 981	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2442: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2445: i2l
    //   2446: putfield 983	awmy:jdField_b_of_type_Long	J
    //   2449: new 985	awmw
    //   2452: dup
    //   2453: invokespecial 986	awmw:<init>	()V
    //   2456: astore 25
    //   2458: aload 25
    //   2460: aload 23
    //   2462: getfield 990	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2465: getfield 995	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2468: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2471: i2l
    //   2472: putfield 996	awmw:jdField_a_of_type_Long	J
    //   2475: aload 25
    //   2477: aload 23
    //   2479: getfield 990	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2482: getfield 999	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2485: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2488: i2l
    //   2489: putfield 1000	awmw:jdField_b_of_type_Long	J
    //   2492: aload 25
    //   2494: aload 23
    //   2496: getfield 990	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2499: getfield 1003	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2502: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2505: i2l
    //   2506: putfield 1005	awmw:c	J
    //   2509: aload 24
    //   2511: aload 25
    //   2513: putfield 1008	awmy:jdField_b_of_type_Awmw	Lawmw;
    //   2516: new 985	awmw
    //   2519: dup
    //   2520: invokespecial 986	awmw:<init>	()V
    //   2523: astore 25
    //   2525: aload 25
    //   2527: aload 23
    //   2529: getfield 1011	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2532: getfield 995	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2535: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2538: i2l
    //   2539: putfield 996	awmw:jdField_a_of_type_Long	J
    //   2542: aload 25
    //   2544: aload 23
    //   2546: getfield 1011	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2549: getfield 999	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2552: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2555: i2l
    //   2556: putfield 1000	awmw:jdField_b_of_type_Long	J
    //   2559: aload 25
    //   2561: aload 23
    //   2563: getfield 1011	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2566: getfield 1003	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2569: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2572: i2l
    //   2573: putfield 1005	awmw:c	J
    //   2576: aload 24
    //   2578: aload 25
    //   2580: putfield 1013	awmy:jdField_a_of_type_Awmw	Lawmw;
    //   2583: aload 22
    //   2585: aload 24
    //   2587: invokevirtual 1014	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2590: pop
    //   2591: iload 7
    //   2593: iconst_1
    //   2594: iadd
    //   2595: istore 7
    //   2597: goto -229 -> 2368
    //   2600: aload 21
    //   2602: aload 22
    //   2604: putfield 1016	awna:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2607: aload 19
    //   2609: aload 21
    //   2611: invokevirtual 1014	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2614: pop
    //   2615: iload 6
    //   2617: iconst_1
    //   2618: iadd
    //   2619: istore 6
    //   2621: goto -418 -> 2203
    //   2624: aload 4
    //   2626: aload 19
    //   2628: putfield 1017	awmz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2631: aload_2
    //   2632: aload 4
    //   2634: invokeinterface 183 2 0
    //   2639: pop
    //   2640: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2643: ifeq -605 -> 2038
    //   2646: ldc_w 313
    //   2649: iconst_2
    //   2650: new 55	java/lang/StringBuilder
    //   2653: dup
    //   2654: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   2657: ldc_w 1019
    //   2660: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: aload_3
    //   2664: getfield 912	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2667: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2670: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2673: ldc_w 1021
    //   2676: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2679: iload 9
    //   2681: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2684: ldc_w 1023
    //   2687: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2690: aload_3
    //   2691: getfield 1026	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2694: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2697: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2700: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2703: goto -665 -> 2038
    //   2706: astore_3
    //   2707: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2710: ifeq -672 -> 2038
    //   2713: ldc_w 313
    //   2716: iconst_2
    //   2717: aload_3
    //   2718: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   2721: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2724: goto -686 -> 2038
    //   2727: new 148	java/util/ArrayList
    //   2730: dup
    //   2731: invokespecial 149	java/util/ArrayList:<init>	()V
    //   2734: astore_2
    //   2735: aload 18
    //   2737: getfield 1030	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2740: ifnull +383 -> 3123
    //   2743: aload 18
    //   2745: getfield 1030	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2748: invokevirtual 816	java/util/ArrayList:size	()I
    //   2751: ifle +372 -> 3123
    //   2754: iconst_0
    //   2755: istore 5
    //   2757: iload 5
    //   2759: aload 18
    //   2761: getfield 1030	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2764: invokevirtual 816	java/util/ArrayList:size	()I
    //   2767: if_icmpge +356 -> 3123
    //   2770: aload 18
    //   2772: getfield 1030	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2775: iload 5
    //   2777: invokevirtual 817	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2780: checkcast 866	[B
    //   2783: astore 4
    //   2785: aload 4
    //   2787: ifnonnull +22 -> 2809
    //   2790: iconst_0
    //   2791: istore 6
    //   2793: iload 6
    //   2795: bipush 10
    //   2797: if_icmpgt +20 -> 2817
    //   2800: iload 5
    //   2802: iconst_1
    //   2803: iadd
    //   2804: istore 5
    //   2806: goto -49 -> 2757
    //   2809: aload 4
    //   2811: arraylength
    //   2812: istore 6
    //   2814: goto -21 -> 2793
    //   2817: aload 4
    //   2819: iconst_1
    //   2820: invokestatic 871	bdlr:a	([BI)J
    //   2823: l2i
    //   2824: istore 7
    //   2826: aload 4
    //   2828: iconst_5
    //   2829: invokestatic 871	bdlr:a	([BI)J
    //   2832: l2i
    //   2833: istore 9
    //   2835: iload 7
    //   2837: ifle -37 -> 2800
    //   2840: iload 7
    //   2842: bipush 9
    //   2844: iadd
    //   2845: iload 6
    //   2847: if_icmpge -47 -> 2800
    //   2850: iload 7
    //   2852: newarray byte
    //   2854: astore_3
    //   2855: aload_3
    //   2856: iconst_0
    //   2857: aload 4
    //   2859: bipush 9
    //   2861: iload 7
    //   2863: invokestatic 874	bdlr:a	([BI[BII)V
    //   2866: new 876	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2869: dup
    //   2870: invokespecial 877	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2873: astore 4
    //   2875: aload 4
    //   2877: aload_3
    //   2878: invokevirtual 878	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2881: pop
    //   2882: aload 4
    //   2884: getfield 882	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2887: invokevirtual 885	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2890: istore 6
    //   2892: iload 6
    //   2894: ifne +161 -> 3055
    //   2897: new 1032	awmh
    //   2900: dup
    //   2901: invokespecial 1033	awmh:<init>	()V
    //   2904: astore_3
    //   2905: aload_3
    //   2906: aload 4
    //   2908: getfield 912	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2911: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2914: putfield 1034	awmh:jdField_a_of_type_Int	I
    //   2917: aload 4
    //   2919: getfield 1038	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2922: ifnull +102 -> 3024
    //   2925: aload_3
    //   2926: aload 4
    //   2928: getfield 1038	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2931: getfield 1043	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2934: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2937: putfield 1044	awmh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2940: aload_3
    //   2941: aload 4
    //   2943: getfield 1038	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2946: getfield 1047	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2949: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2952: putfield 1048	awmh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2955: aload_3
    //   2956: aload 4
    //   2958: getfield 1038	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2961: getfield 1051	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2964: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2967: putfield 1052	awmh:c	Ljava/lang/String;
    //   2970: aload_3
    //   2971: aload 4
    //   2973: getfield 1038	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2976: getfield 1055	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2979: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2982: putfield 1056	awmh:d	Ljava/lang/String;
    //   2985: aload_3
    //   2986: invokevirtual 1058	awmh:a	()Z
    //   2989: ifne -189 -> 2800
    //   2992: aload_2
    //   2993: aload_3
    //   2994: invokeinterface 183 2 0
    //   2999: pop
    //   3000: goto -200 -> 2800
    //   3003: astore_3
    //   3004: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3007: ifeq -207 -> 2800
    //   3010: ldc_w 313
    //   3013: iconst_2
    //   3014: aload_3
    //   3015: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   3018: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3021: goto -221 -> 2800
    //   3024: aload_3
    //   3025: ldc_w 517
    //   3028: putfield 1044	awmh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3031: aload_3
    //   3032: ldc_w 517
    //   3035: putfield 1048	awmh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3038: aload_3
    //   3039: ldc_w 517
    //   3042: putfield 1052	awmh:c	Ljava/lang/String;
    //   3045: aload_3
    //   3046: ldc_w 517
    //   3049: putfield 1056	awmh:d	Ljava/lang/String;
    //   3052: goto -67 -> 2985
    //   3055: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3058: ifeq -258 -> 2800
    //   3061: ldc_w 313
    //   3064: iconst_4
    //   3065: new 55	java/lang/StringBuilder
    //   3068: dup
    //   3069: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3072: ldc_w 1060
    //   3075: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: aload 4
    //   3080: getfield 912	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3083: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3086: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3089: ldc_w 1062
    //   3092: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: iload 6
    //   3097: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3100: ldc_w 1062
    //   3103: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: aload 4
    //   3108: getfield 1026	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3111: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3114: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3117: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3120: goto -320 -> 2800
    //   3123: aload 15
    //   3125: aload_2
    //   3126: invokevirtual 1066	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3129: aload 18
    //   3131: getfield 1070	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3134: ifnonnull +126 -> 3260
    //   3137: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3140: ifeq +13 -> 3153
    //   3143: ldc_w 313
    //   3146: iconst_2
    //   3147: ldc_w 1072
    //   3150: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3153: aload 18
    //   3155: getfield 1075	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3158: ifnull +1668 -> 4826
    //   3161: new 1077	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   3164: dup
    //   3165: invokespecial 1078	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   3168: astore_2
    //   3169: aload_2
    //   3170: aload 18
    //   3172: getfield 1075	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3175: invokevirtual 1079	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3178: pop
    //   3179: aload_2
    //   3180: ifnull +2863 -> 6043
    //   3183: aload_2
    //   3184: getfield 1082	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3187: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3190: astore_2
    //   3191: new 148	java/util/ArrayList
    //   3194: dup
    //   3195: invokespecial 149	java/util/ArrayList:<init>	()V
    //   3198: astore_3
    //   3199: aload_2
    //   3200: ifnull +155 -> 3355
    //   3203: aload_2
    //   3204: invokeinterface 163 1 0
    //   3209: astore_2
    //   3210: aload_2
    //   3211: invokeinterface 168 1 0
    //   3216: ifeq +139 -> 3355
    //   3219: aload_2
    //   3220: invokeinterface 172 1 0
    //   3225: checkcast 1084	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   3228: astore 4
    //   3230: aload 4
    //   3232: getfield 1087	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3235: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3238: iconst_1
    //   3239: if_icmpne +111 -> 3350
    //   3242: iconst_1
    //   3243: istore_1
    //   3244: aload_3
    //   3245: aload 4
    //   3247: iload_1
    //   3248: invokestatic 1093	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   3251: invokeinterface 183 2 0
    //   3256: pop
    //   3257: goto -47 -> 3210
    //   3260: aload 18
    //   3262: getfield 1070	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3265: getfield 1098	SummaryCard/InterestTagInfo:uFlag	J
    //   3268: lstore 11
    //   3270: new 1100	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   3273: dup
    //   3274: invokespecial 1101	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   3277: astore_2
    //   3278: aload_2
    //   3279: aload 18
    //   3281: getfield 1070	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3284: getfield 1104	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   3287: invokevirtual 1105	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3290: pop
    //   3291: aload 15
    //   3293: lload 11
    //   3295: aload_2
    //   3296: getfield 1108	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3299: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3302: invokevirtual 1112	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   3305: goto -152 -> 3153
    //   3308: astore_2
    //   3309: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3312: ifeq -159 -> 3153
    //   3315: ldc_w 1114
    //   3318: iconst_2
    //   3319: aload_2
    //   3320: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   3323: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3326: goto -173 -> 3153
    //   3329: astore_3
    //   3330: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3333: ifeq -154 -> 3179
    //   3336: ldc_w 313
    //   3339: iconst_2
    //   3340: aload_3
    //   3341: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   3344: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3347: goto -168 -> 3179
    //   3350: iconst_0
    //   3351: istore_1
    //   3352: goto -108 -> 3244
    //   3355: aload_3
    //   3356: invokeinterface 159 1 0
    //   3361: ifle +2682 -> 6043
    //   3364: iconst_0
    //   3365: istore 5
    //   3367: iload 5
    //   3369: aload_3
    //   3370: invokeinterface 159 1 0
    //   3375: if_icmpge +2668 -> 6043
    //   3378: aload_3
    //   3379: iload 5
    //   3381: invokeinterface 214 2 0
    //   3386: checkcast 1089	com/tencent/mobileqq/data/HotChatInfo
    //   3389: astore_2
    //   3390: aload_2
    //   3391: ifnull +1426 -> 4817
    //   3394: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3397: ifeq +30 -> 3427
    //   3400: ldc_w 313
    //   3403: iconst_2
    //   3404: new 55	java/lang/StringBuilder
    //   3407: dup
    //   3408: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3411: ldc_w 1116
    //   3414: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3417: aload_2
    //   3418: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3421: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3424: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3427: aload_2
    //   3428: ifnull +9 -> 3437
    //   3431: aload 15
    //   3433: aload_2
    //   3434: invokevirtual 1120	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3437: aload 15
    //   3439: getfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3442: ifnull +787 -> 4229
    //   3445: new 1122	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3448: dup
    //   3449: invokespecial 1123	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3452: astore_2
    //   3453: aload_2
    //   3454: aload 15
    //   3456: getfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3459: invokevirtual 1124	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3462: pop
    //   3463: iload 8
    //   3465: bipush 51
    //   3467: if_icmpne +1388 -> 4855
    //   3470: aload_2
    //   3471: getfield 1127	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3474: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3477: iconst_1
    //   3478: if_icmpne +1367 -> 4845
    //   3481: iconst_1
    //   3482: istore_1
    //   3483: aload 15
    //   3485: iload_1
    //   3486: putfield 643	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3489: aload_2
    //   3490: getfield 1130	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3493: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3496: iconst_1
    //   3497: if_icmpne +1353 -> 4850
    //   3500: iconst_1
    //   3501: istore_1
    //   3502: aload 15
    //   3504: iload_1
    //   3505: putfield 631	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3508: aload 15
    //   3510: aload_2
    //   3511: getfield 1133	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3514: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3517: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3520: putfield 655	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3523: aload 15
    //   3525: aload_2
    //   3526: getfield 1136	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3529: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3532: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3535: putfield 649	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3538: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3541: ifeq +1424 -> 4965
    //   3544: ldc_w 1138
    //   3547: iconst_2
    //   3548: new 55	java/lang/StringBuilder
    //   3551: dup
    //   3552: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3555: ldc_w 1140
    //   3558: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: iload 8
    //   3563: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3566: ldc_w 1142
    //   3569: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3572: aload_2
    //   3573: getfield 1127	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3576: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3579: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3582: ldc_w 1144
    //   3585: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: aload_2
    //   3589: getfield 1133	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3592: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3595: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3598: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: ldc_w 1146
    //   3604: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3607: aload_0
    //   3608: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3611: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3614: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3620: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3623: aload 15
    //   3625: aload_2
    //   3626: getfield 1149	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3629: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3632: putfield 640	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3635: aload_2
    //   3636: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3639: invokevirtual 1156	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3642: ifeq +1428 -> 5070
    //   3645: aload 15
    //   3647: aload_2
    //   3648: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3651: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3654: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3657: getfield 1162	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3660: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3663: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3666: putfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3669: aload 15
    //   3671: aload_2
    //   3672: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3675: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3678: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3681: getfield 1165	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3684: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3687: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3690: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3693: aload 15
    //   3695: aload_2
    //   3696: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3699: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3702: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3705: getfield 1168	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3708: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3711: putfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3714: aload 15
    //   3716: aload_2
    //   3717: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3720: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3723: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3726: getfield 1171	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3729: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3732: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3735: putfield 658	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3738: aload 15
    //   3740: aload_2
    //   3741: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3744: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3747: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3750: getfield 1174	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3753: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3756: putfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3759: aload 15
    //   3761: aload_2
    //   3762: getfield 1153	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3765: invokevirtual 1159	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3768: checkcast 1155	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3771: getfield 1177	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3774: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3777: putfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3780: aload_2
    //   3781: getfield 1180	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3784: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3787: iconst_1
    //   3788: if_icmpne +2268 -> 6056
    //   3791: iconst_1
    //   3792: istore_1
    //   3793: aload 15
    //   3795: iload_1
    //   3796: putfield 1183	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3799: aload 15
    //   3801: aload_2
    //   3802: getfield 1186	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3805: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3808: putfield 1189	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3811: aload 15
    //   3813: aload_2
    //   3814: getfield 1192	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3817: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3820: putfield 1195	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3823: aload 15
    //   3825: aload_2
    //   3826: getfield 1198	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3829: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3832: putfield 1201	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3835: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3838: ifeq +104 -> 3942
    //   3841: ldc_w 1203
    //   3844: iconst_2
    //   3845: new 55	java/lang/StringBuilder
    //   3848: dup
    //   3849: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   3852: ldc_w 1205
    //   3855: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: aload 15
    //   3860: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3863: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: ldc_w 1207
    //   3869: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3872: aload 15
    //   3874: getfield 1183	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3877: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3880: ldc_w 1212
    //   3883: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3886: aload 15
    //   3888: invokevirtual 1215	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3891: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3894: ldc_w 1217
    //   3897: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3900: aload 15
    //   3902: getfield 1189	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3905: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3908: ldc_w 1219
    //   3911: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3914: aload 15
    //   3916: getfield 1201	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3919: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3922: ldc_w 1221
    //   3925: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3928: aload 15
    //   3930: getfield 1195	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3933: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3936: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3939: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3942: aload_2
    //   3943: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3946: invokevirtual 1228	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   3949: ifeq +1166 -> 5115
    //   3952: aload 15
    //   3954: aload_2
    //   3955: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3958: getfield 1231	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3961: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3964: putfield 1234	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3967: aload 15
    //   3969: aload_2
    //   3970: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3973: getfield 1237	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3976: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3979: putfield 1240	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3982: aload 15
    //   3984: aload_2
    //   3985: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3988: getfield 1243	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3991: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3994: putfield 1246	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3997: aload 15
    //   3999: aload_2
    //   4000: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4003: getfield 1249	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4006: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4009: putfield 1252	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   4012: aload 15
    //   4014: aload_2
    //   4015: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4018: getfield 1255	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4021: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4024: putfield 1258	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   4027: aload 15
    //   4029: aload_2
    //   4030: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4033: getfield 1261	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4036: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4039: putfield 1264	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   4042: aload 15
    //   4044: aload_2
    //   4045: getfield 1225	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4048: getfield 1267	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4051: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4054: putfield 1270	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   4057: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4060: ifeq +169 -> 4229
    //   4063: new 55	java/lang/StringBuilder
    //   4066: dup
    //   4067: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   4070: astore_2
    //   4071: aload_2
    //   4072: ldc_w 1272
    //   4075: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4078: ldc_w 1274
    //   4081: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: aload 15
    //   4086: getfield 1234	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   4089: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4092: ldc_w 1276
    //   4095: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4098: ldc_w 1278
    //   4101: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4104: aload 15
    //   4106: getfield 1240	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   4109: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4112: ldc_w 1276
    //   4115: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4118: ldc_w 1280
    //   4121: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4124: aload 15
    //   4126: getfield 1246	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   4129: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: ldc_w 1276
    //   4135: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4138: ldc_w 1282
    //   4141: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4144: aload 15
    //   4146: getfield 1252	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   4149: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4152: ldc_w 1276
    //   4155: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4158: ldc_w 1284
    //   4161: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4164: aload 15
    //   4166: getfield 1258	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   4169: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4172: ldc_w 1276
    //   4175: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4178: ldc_w 1286
    //   4181: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4184: aload 15
    //   4186: getfield 1264	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   4189: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4192: ldc_w 1276
    //   4195: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4198: ldc_w 1288
    //   4201: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4204: aload 15
    //   4206: getfield 1270	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   4209: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: ldc_w 1276
    //   4215: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4218: pop
    //   4219: ldc 29
    //   4221: iconst_2
    //   4222: aload_2
    //   4223: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4226: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4229: aload 18
    //   4231: getfield 1292	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4234: ifnull +29 -> 4263
    //   4237: aload 15
    //   4239: aload 18
    //   4241: getfield 1292	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4244: getfield 1297	SummaryCard/GiftInfo:uOpenFlag	J
    //   4247: putfield 1300	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   4250: aload 15
    //   4252: aload 18
    //   4254: getfield 1292	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4257: getfield 1301	SummaryCard/GiftInfo:vGiftInfo	[B
    //   4260: putfield 1302	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   4263: aload 18
    //   4265: getfield 1305	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4268: ifnull +162 -> 4430
    //   4271: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4274: ifeq +12 -> 4286
    //   4277: ldc 29
    //   4279: iconst_2
    //   4280: ldc_w 1307
    //   4283: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4286: new 1309	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   4289: dup
    //   4290: invokespecial 1310	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   4293: astore_2
    //   4294: aload_2
    //   4295: aload 18
    //   4297: getfield 1305	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4300: invokevirtual 1311	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4303: pop
    //   4304: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4307: ifeq +82 -> 4389
    //   4310: ldc 29
    //   4312: iconst_2
    //   4313: new 55	java/lang/StringBuilder
    //   4316: dup
    //   4317: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   4320: ldc_w 1313
    //   4323: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4326: aload_2
    //   4327: getfield 1316	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4330: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4333: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4336: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4339: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4342: aload_2
    //   4343: getfield 1319	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4346: invokevirtual 114	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4349: ifeq +40 -> 4389
    //   4352: ldc 29
    //   4354: iconst_2
    //   4355: new 55	java/lang/StringBuilder
    //   4358: dup
    //   4359: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   4362: ldc_w 1321
    //   4365: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4368: aload_2
    //   4369: getfield 1319	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4372: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4375: invokeinterface 159 1 0
    //   4380: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4383: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4386: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4389: aload_2
    //   4390: getfield 1316	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4393: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4396: iconst_1
    //   4397: if_icmpne +736 -> 5133
    //   4400: iconst_1
    //   4401: istore_1
    //   4402: aload 15
    //   4404: iload_1
    //   4405: putfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4408: aload_2
    //   4409: getfield 1319	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4412: invokevirtual 114	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4415: ifeq +15 -> 4430
    //   4418: aload 15
    //   4420: aload_2
    //   4421: getfield 1319	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4424: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4427: invokevirtual 1327	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4430: aload 18
    //   4432: getfield 1330	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4435: astore_2
    //   4436: aload_2
    //   4437: ifnull +41 -> 4478
    //   4440: new 1332	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4443: dup
    //   4444: invokespecial 1333	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4447: astore_3
    //   4448: aload_3
    //   4449: aload_2
    //   4450: invokevirtual 1334	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4453: pop
    //   4454: aload 15
    //   4456: aload_3
    //   4457: getfield 1337	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4460: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4463: putfield 1340	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4466: aload 15
    //   4468: aload_3
    //   4469: getfield 1343	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4472: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4475: putfield 1346	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4478: aload 18
    //   4480: getfield 1349	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4483: astore_2
    //   4484: aload_2
    //   4485: ifnull +705 -> 5190
    //   4488: aload 15
    //   4490: new 148	java/util/ArrayList
    //   4493: dup
    //   4494: invokespecial 149	java/util/ArrayList:<init>	()V
    //   4497: putfield 1352	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4500: new 1354	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4503: dup
    //   4504: invokespecial 1355	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4507: astore_3
    //   4508: aload_3
    //   4509: aload_2
    //   4510: invokevirtual 1356	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4513: pop
    //   4514: aload_3
    //   4515: getfield 1359	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4518: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4521: astore_2
    //   4522: aload_2
    //   4523: ifnull +667 -> 5190
    //   4526: new 611	org/json/JSONArray
    //   4529: dup
    //   4530: invokespecial 612	org/json/JSONArray:<init>	()V
    //   4533: astore_3
    //   4534: iconst_0
    //   4535: istore 5
    //   4537: iload 5
    //   4539: aload_2
    //   4540: invokeinterface 159 1 0
    //   4545: if_icmpge +632 -> 5177
    //   4548: new 1361	org/json/JSONObject
    //   4551: dup
    //   4552: invokespecial 1362	org/json/JSONObject:<init>	()V
    //   4555: astore 4
    //   4557: new 1364	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4560: dup
    //   4561: invokespecial 1365	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4564: astore 19
    //   4566: aload 19
    //   4568: aload_2
    //   4569: iload 5
    //   4571: invokeinterface 214 2 0
    //   4576: checkcast 1367	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4579: getfield 1370	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4582: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4585: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4588: putfield 1372	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4591: aload 19
    //   4593: getfield 1372	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4596: invokestatic 1376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4599: ifne +17 -> 4616
    //   4602: aload 4
    //   4604: ldc_w 1377
    //   4607: aload 19
    //   4609: getfield 1372	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4612: invokevirtual 1380	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4615: pop
    //   4616: aload 19
    //   4618: aload_2
    //   4619: iload 5
    //   4621: invokeinterface 214 2 0
    //   4626: checkcast 1367	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4629: getfield 1383	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4632: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4635: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4638: putfield 1386	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4641: aload 19
    //   4643: getfield 1386	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4646: invokestatic 1376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4649: ifne +17 -> 4666
    //   4652: aload 4
    //   4654: ldc_w 1387
    //   4657: aload 19
    //   4659: getfield 1386	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4662: invokevirtual 1380	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4665: pop
    //   4666: aload 19
    //   4668: aload_2
    //   4669: iload 5
    //   4671: invokeinterface 214 2 0
    //   4676: checkcast 1367	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4679: getfield 1390	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4682: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4685: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4688: putfield 1392	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4691: aload 19
    //   4693: getfield 1392	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4696: invokestatic 1376	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4699: ifne +17 -> 4716
    //   4702: aload 4
    //   4704: ldc_w 1393
    //   4707: aload 19
    //   4709: getfield 1392	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4712: invokevirtual 1380	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4715: pop
    //   4716: aload 19
    //   4718: aload_2
    //   4719: iload 5
    //   4721: invokeinterface 214 2 0
    //   4726: checkcast 1367	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4729: getfield 1396	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4732: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4735: putfield 1399	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4738: aload 4
    //   4740: ldc_w 1400
    //   4743: aload 19
    //   4745: getfield 1399	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4748: invokevirtual 1403	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4751: pop
    //   4752: aload 19
    //   4754: aload_2
    //   4755: iload 5
    //   4757: invokeinterface 214 2 0
    //   4762: checkcast 1367	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4765: getfield 1406	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4768: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4771: putfield 1409	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4774: aload 4
    //   4776: ldc_w 1410
    //   4779: aload 19
    //   4781: getfield 1409	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4784: invokevirtual 1403	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4787: pop
    //   4788: aload 15
    //   4790: getfield 1352	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4793: aload 19
    //   4795: invokeinterface 183 2 0
    //   4800: pop
    //   4801: aload_3
    //   4802: aload 4
    //   4804: invokevirtual 616	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4807: pop
    //   4808: iload 5
    //   4810: iconst_1
    //   4811: iadd
    //   4812: istore 5
    //   4814: goto -277 -> 4537
    //   4817: iload 5
    //   4819: iconst_1
    //   4820: iadd
    //   4821: istore 5
    //   4823: goto -1456 -> 3367
    //   4826: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4829: ifeq -1392 -> 3437
    //   4832: ldc_w 313
    //   4835: iconst_2
    //   4836: ldc_w 1412
    //   4839: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4842: goto -1405 -> 3437
    //   4845: iconst_0
    //   4846: istore_1
    //   4847: goto -1364 -> 3483
    //   4850: iconst_0
    //   4851: istore_1
    //   4852: goto -1350 -> 3502
    //   4855: aload 15
    //   4857: aload_2
    //   4858: getfield 1127	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4861: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4864: putfield 637	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4867: aload 15
    //   4869: getfield 637	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4872: iconst_1
    //   4873: if_icmpne +82 -> 4955
    //   4876: iconst_1
    //   4877: istore_1
    //   4878: aload 15
    //   4880: iload_1
    //   4881: putfield 634	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4884: aload_2
    //   4885: getfield 1130	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4888: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4891: iconst_1
    //   4892: if_icmpne +68 -> 4960
    //   4895: iconst_1
    //   4896: istore_1
    //   4897: aload 15
    //   4899: iload_1
    //   4900: putfield 628	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4903: aload 15
    //   4905: aload_2
    //   4906: getfield 1133	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4909: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4912: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4915: putfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4918: aload 15
    //   4920: aload_2
    //   4921: getfield 1136	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4924: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4927: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4930: putfield 646	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4933: goto -1395 -> 3538
    //   4936: astore_2
    //   4937: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4940: ifeq -711 -> 4229
    //   4943: ldc 29
    //   4945: iconst_2
    //   4946: ldc_w 1414
    //   4949: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4952: goto -723 -> 4229
    //   4955: iconst_0
    //   4956: istore_1
    //   4957: goto -79 -> 4878
    //   4960: iconst_0
    //   4961: istore_1
    //   4962: goto -65 -> 4897
    //   4965: ldc_w 1138
    //   4968: iconst_1
    //   4969: new 55	java/lang/StringBuilder
    //   4972: dup
    //   4973: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   4976: ldc_w 1140
    //   4979: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4982: iload 8
    //   4984: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4987: ldc_w 1142
    //   4990: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4993: aload_2
    //   4994: getfield 1127	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4997: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5000: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5003: ldc_w 1144
    //   5006: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5009: aload_2
    //   5010: getfield 1133	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5013: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5016: invokevirtual 217	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5019: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5022: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5025: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5028: goto -1405 -> 3623
    //   5031: astore_3
    //   5032: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5035: ifeq -1412 -> 3623
    //   5038: ldc 29
    //   5040: iconst_2
    //   5041: new 55	java/lang/StringBuilder
    //   5044: dup
    //   5045: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5048: ldc_w 1416
    //   5051: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5054: aload_3
    //   5055: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   5058: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5061: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5064: invokestatic 830	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5067: goto -1444 -> 3623
    //   5070: aload 15
    //   5072: ldc_w 517
    //   5075: putfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   5078: aload 15
    //   5080: ldc_w 517
    //   5083: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   5086: aload 15
    //   5088: iconst_0
    //   5089: putfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   5092: aload 15
    //   5094: ldc_w 517
    //   5097: putfield 658	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   5100: aload 15
    //   5102: iconst_0
    //   5103: putfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   5106: aload 15
    //   5108: iconst_0
    //   5109: putfield 664	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   5112: goto -1332 -> 3780
    //   5115: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5118: ifeq -889 -> 4229
    //   5121: ldc 29
    //   5123: iconst_2
    //   5124: ldc_w 1418
    //   5127: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5130: goto -901 -> 4229
    //   5133: iconst_0
    //   5134: istore_1
    //   5135: goto -733 -> 4402
    //   5138: astore_2
    //   5139: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5142: ifeq -712 -> 4430
    //   5145: ldc 29
    //   5147: iconst_2
    //   5148: new 55	java/lang/StringBuilder
    //   5151: dup
    //   5152: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5155: ldc_w 1420
    //   5158: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5161: aload_2
    //   5162: invokevirtual 1421	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   5165: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5168: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5171: invokestatic 830	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5174: goto -744 -> 4430
    //   5177: aload_3
    //   5178: ifnull +12 -> 5190
    //   5181: aload 15
    //   5183: aload_3
    //   5184: invokevirtual 697	org/json/JSONArray:toString	()Ljava/lang/String;
    //   5187: putfield 1424	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   5190: aload 15
    //   5192: aload 18
    //   5194: getfield 1349	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5197: putfield 1427	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   5200: new 1429	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   5203: dup
    //   5204: invokespecial 1430	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   5207: astore_3
    //   5208: aload_3
    //   5209: aload 18
    //   5211: getfield 1349	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5214: invokevirtual 1431	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5217: pop
    //   5218: aload_3
    //   5219: astore_2
    //   5220: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5223: ifeq +69 -> 5292
    //   5226: ldc 29
    //   5228: iconst_2
    //   5229: new 55	java/lang/StringBuilder
    //   5232: dup
    //   5233: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5236: ldc_w 1433
    //   5239: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: aload_3
    //   5243: getfield 1436	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5246: invokevirtual 1437	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   5249: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5252: ldc_w 1439
    //   5255: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5258: aload_3
    //   5259: getfield 1442	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5262: invokevirtual 114	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5265: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5268: ldc_w 1444
    //   5271: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5274: aload_3
    //   5275: getfield 1447	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5278: invokevirtual 114	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5281: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5284: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5287: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5290: aload_3
    //   5291: astore_2
    //   5292: aload 15
    //   5294: aload_2
    //   5295: putfield 1451	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   5298: aload_0
    //   5299: bipush 51
    //   5301: iconst_1
    //   5302: aload 15
    //   5304: iload 10
    //   5306: invokevirtual 1454	ausy:notifyUI	(IZLjava/lang/Object;Z)V
    //   5309: aload_0
    //   5310: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5313: bipush 106
    //   5315: invokevirtual 1458	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5318: checkcast 1460	auqc
    //   5321: astore_2
    //   5322: iload 8
    //   5324: bipush 51
    //   5326: if_icmpne +456 -> 5782
    //   5329: aload_2
    //   5330: aload 15
    //   5332: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5335: invokestatic 1465	android/os/SystemClock:elapsedRealtime	()J
    //   5338: invokevirtual 1468	auqc:b	(Ljava/lang/String;J)V
    //   5341: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5344: ifeq +46 -> 5390
    //   5347: ldc_w 1470
    //   5350: iconst_4
    //   5351: new 55	java/lang/StringBuilder
    //   5354: dup
    //   5355: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5358: ldc_w 1472
    //   5361: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5364: aload 15
    //   5366: getfield 300	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5369: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5372: ldc_w 1474
    //   5375: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5378: invokestatic 1465	android/os/SystemClock:elapsedRealtime	()J
    //   5381: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5384: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5387: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5390: aload_0
    //   5391: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5394: bipush 51
    //   5396: invokevirtual 1458	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5399: checkcast 1476	aloz
    //   5402: astore_2
    //   5403: invokestatic 1480	ausq:b	()Z
    //   5406: ifeq +55 -> 5461
    //   5409: ldc 29
    //   5411: iconst_5
    //   5412: anewarray 85	java/lang/Object
    //   5415: dup
    //   5416: iconst_0
    //   5417: ldc_w 1482
    //   5420: aastore
    //   5421: dup
    //   5422: iconst_1
    //   5423: iload 8
    //   5425: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5428: aastore
    //   5429: dup
    //   5430: iconst_2
    //   5431: aload 15
    //   5433: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5436: aastore
    //   5437: dup
    //   5438: iconst_3
    //   5439: aload_0
    //   5440: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5443: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5446: aastore
    //   5447: dup
    //   5448: iconst_4
    //   5449: aload 18
    //   5451: getfield 287	SummaryCard/RespSummaryCard:lUIN	J
    //   5454: invokestatic 1487	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5457: aastore
    //   5458: invokestatic 1490	ausq:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   5461: iload 8
    //   5463: ifeq +21 -> 5484
    //   5466: aload 15
    //   5468: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5471: aload_0
    //   5472: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5475: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5478: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5481: ifeq +76 -> 5557
    //   5484: aload_2
    //   5485: aload 15
    //   5487: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5490: invokevirtual 1493	aloz:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5493: astore_3
    //   5494: aload_3
    //   5495: aload 15
    //   5497: getfield 332	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5500: putfield 1498	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5503: aload_3
    //   5504: aload 15
    //   5506: getfield 329	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5509: i2l
    //   5510: putfield 1501	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5513: aload_0
    //   5514: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5517: invokevirtual 1504	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5520: aload_3
    //   5521: getfield 1501	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5524: aload_3
    //   5525: getfield 1498	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5528: invokestatic 1509	aush:a	(Ljava/lang/String;JI)Z
    //   5531: pop
    //   5532: aload_2
    //   5533: aload_3
    //   5534: invokevirtual 1512	aloz:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5537: pop
    //   5538: aload_0
    //   5539: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5542: invokevirtual 1504	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5545: ldc_w 1514
    //   5548: aload 15
    //   5550: getfield 428	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5553: invokestatic 1517	aush:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5556: pop
    //   5557: aload_0
    //   5558: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5561: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5564: aload 15
    //   5566: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5569: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5572: ifeq +31 -> 5603
    //   5575: aload 15
    //   5577: getfield 739	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5580: ifle +23 -> 5603
    //   5583: aload_0
    //   5584: getfield 237	ausy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5587: bipush 60
    //   5589: invokevirtual 1458	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5592: checkcast 1519	com/tencent/mobileqq/app/HotChatManager
    //   5595: aload 15
    //   5597: getfield 739	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5600: invokevirtual 1521	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   5603: aload_2
    //   5604: aload 15
    //   5606: invokevirtual 1524	aloz:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5609: aload 15
    //   5611: invokevirtual 621	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5614: sipush 1000
    //   5617: if_icmpne +347 -> 5964
    //   5620: aload 16
    //   5622: iconst_0
    //   5623: ldc_w 273
    //   5626: invokevirtual 1529	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5629: aconst_null
    //   5630: aconst_null
    //   5631: aconst_null
    //   5632: aconst_null
    //   5633: aconst_null
    //   5634: aconst_null
    //   5635: aconst_null
    //   5636: invokevirtual 1532	awbw:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5639: astore_3
    //   5640: aload_3
    //   5641: ifnull +286 -> 5927
    //   5644: aload_3
    //   5645: astore_2
    //   5646: aload_3
    //   5647: invokeinterface 1537 1 0
    //   5652: istore 5
    //   5654: aload_3
    //   5655: astore_2
    //   5656: aload_3
    //   5657: invokeinterface 1540 1 0
    //   5662: pop
    //   5663: iload 5
    //   5665: sipush 200
    //   5668: if_icmple +259 -> 5927
    //   5671: iload 5
    //   5673: bipush 100
    //   5675: if_icmple +130 -> 5805
    //   5678: aload_3
    //   5679: astore_2
    //   5680: aload_3
    //   5681: invokeinterface 1543 1 0
    //   5686: pop
    //   5687: iload 5
    //   5689: iconst_1
    //   5690: isub
    //   5691: istore 5
    //   5693: goto -22 -> 5671
    //   5696: astore_2
    //   5697: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5700: ifeq -510 -> 5190
    //   5703: ldc 29
    //   5705: iconst_2
    //   5706: new 55	java/lang/StringBuilder
    //   5709: dup
    //   5710: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5713: ldc_w 1545
    //   5716: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5719: aload_2
    //   5720: invokevirtual 827	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5723: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5726: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5729: invokestatic 830	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5732: goto -542 -> 5190
    //   5735: astore 4
    //   5737: aconst_null
    //   5738: astore_3
    //   5739: aload_3
    //   5740: astore_2
    //   5741: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5744: ifeq -452 -> 5292
    //   5747: ldc 29
    //   5749: iconst_2
    //   5750: new 55	java/lang/StringBuilder
    //   5753: dup
    //   5754: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5757: ldc_w 1547
    //   5760: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: aload 4
    //   5765: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   5768: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5771: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5774: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5777: aload_3
    //   5778: astore_2
    //   5779: goto -487 -> 5292
    //   5782: aload_2
    //   5783: aload 15
    //   5785: getfield 298	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5788: invokestatic 1465	android/os/SystemClock:elapsedRealtime	()J
    //   5791: invokevirtual 1549	auqc:a	(Ljava/lang/String;J)V
    //   5794: goto -453 -> 5341
    //   5797: astore_3
    //   5798: aload_3
    //   5799: invokevirtual 1552	java/lang/Exception:printStackTrace	()V
    //   5802: goto -245 -> 5557
    //   5805: aload_3
    //   5806: astore_2
    //   5807: aload_3
    //   5808: aload_3
    //   5809: ldc_w 1554
    //   5812: invokeinterface 1557 2 0
    //   5817: invokeinterface 1560 2 0
    //   5822: istore 5
    //   5824: aload_3
    //   5825: astore_2
    //   5826: new 55	java/lang/StringBuilder
    //   5829: dup
    //   5830: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   5833: astore 4
    //   5835: aload_3
    //   5836: astore_2
    //   5837: aload 4
    //   5839: ldc_w 1562
    //   5842: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5845: pop
    //   5846: aload_3
    //   5847: astore_2
    //   5848: aload 4
    //   5850: ldc_w 273
    //   5853: invokevirtual 1529	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5856: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5859: pop
    //   5860: aload_3
    //   5861: astore_2
    //   5862: aload 4
    //   5864: ldc_w 1564
    //   5867: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5870: pop
    //   5871: aload_3
    //   5872: astore_2
    //   5873: aload 4
    //   5875: ldc_w 1554
    //   5878: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5881: pop
    //   5882: aload_3
    //   5883: astore_2
    //   5884: aload 4
    //   5886: ldc_w 1566
    //   5889: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5892: pop
    //   5893: aload_3
    //   5894: astore_2
    //   5895: aload 4
    //   5897: iload 5
    //   5899: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5902: pop
    //   5903: aload_3
    //   5904: astore_2
    //   5905: aload 4
    //   5907: ldc_w 1568
    //   5910: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5913: pop
    //   5914: aload_3
    //   5915: astore_2
    //   5916: aload 16
    //   5918: aload 4
    //   5920: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5923: invokevirtual 1570	awbw:b	(Ljava/lang/String;)Z
    //   5926: pop
    //   5927: aload_3
    //   5928: astore_2
    //   5929: aload 16
    //   5931: aload 15
    //   5933: invokevirtual 1573	awbw:b	(Lawbv;)V
    //   5936: aload_3
    //   5937: astore_2
    //   5938: aload 17
    //   5940: invokevirtual 1575	awby:c	()V
    //   5943: aload_3
    //   5944: ifnull +9 -> 5953
    //   5947: aload_3
    //   5948: invokeinterface 1578 1 0
    //   5953: aload 17
    //   5955: invokevirtual 1580	awby:b	()V
    //   5958: aload 16
    //   5960: invokevirtual 1581	awbw:a	()V
    //   5963: return
    //   5964: aload 15
    //   5966: invokevirtual 621	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5969: sipush 1001
    //   5972: if_icmpeq +14 -> 5986
    //   5975: aload 15
    //   5977: invokevirtual 621	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5980: sipush 1002
    //   5983: if_icmpne +11 -> 5994
    //   5986: aload 16
    //   5988: aload 15
    //   5990: invokevirtual 1584	awbw:a	(Lawbv;)Z
    //   5993: pop
    //   5994: aconst_null
    //   5995: astore_3
    //   5996: goto -60 -> 5936
    //   5999: astore_3
    //   6000: aconst_null
    //   6001: astore_2
    //   6002: aload_2
    //   6003: ifnull +9 -> 6012
    //   6006: aload_2
    //   6007: invokeinterface 1578 1 0
    //   6012: aload 17
    //   6014: invokevirtual 1580	awby:b	()V
    //   6017: aload 16
    //   6019: invokevirtual 1581	awbw:a	()V
    //   6022: aload_3
    //   6023: athrow
    //   6024: aload_0
    //   6025: bipush 51
    //   6027: iconst_0
    //   6028: aconst_null
    //   6029: iload 10
    //   6031: invokevirtual 1454	ausy:notifyUI	(IZLjava/lang/Object;Z)V
    //   6034: return
    //   6035: astore_3
    //   6036: goto -34 -> 6002
    //   6039: astore_2
    //   6040: goto -1562 -> 4478
    //   6043: aconst_null
    //   6044: astore_2
    //   6045: goto -2651 -> 3394
    //   6048: aconst_null
    //   6049: astore_2
    //   6050: goto -5887 -> 163
    //   6053: goto -5890 -> 163
    //   6056: iconst_0
    //   6057: istore_1
    //   6058: goto -2265 -> 3793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6061	0	this	ausy
    //   0	6061	1	paramBoolean	boolean
    //   0	6061	2	paramObject	Object
    //   0	6061	3	paramBundle	Bundle
    //   0	6061	4	paramRespHead	SummaryCard.RespHead
    //   76	5822	5	i	int
    //   2029	1067	6	j	int
    //   2069	793	7	k	int
    //   14	5448	8	m	int
    //   2077	757	9	n	int
    //   6	6024	10	bool	boolean
    //   58	3236	11	l1	long
    //   67	1125	13	l2	long
    //   174	5815	15	localNearbyPeopleCard	NearbyPeopleCard
    //   36	5982	16	localawbw	awbw
    //   43	5970	17	localawby	awby
    //   24	5426	18	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   858	3936	19	localObject1	Object
    //   884	1498	20	localObject2	Object
    //   2242	368	21	localawna	awna
    //   2363	240	22	localArrayList	ArrayList
    //   2394	168	23	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2403	183	24	localawmy	awmy
    //   2456	123	25	localawmw	awmw
    // Exception table:
    //   from	to	target	type
    //   860	911	1749	java/lang/Exception
    //   914	962	1749	java/lang/Exception
    //   1315	1325	1749	java/lang/Exception
    //   2119	2144	2706	java/lang/Exception
    //   2149	2200	2706	java/lang/Exception
    //   2203	2365	2706	java/lang/Exception
    //   2368	2591	2706	java/lang/Exception
    //   2600	2607	2706	java/lang/Exception
    //   2607	2615	2706	java/lang/Exception
    //   2624	2631	2706	java/lang/Exception
    //   2631	2703	2706	java/lang/Exception
    //   2875	2892	3003	java/lang/Exception
    //   2897	2985	3003	java/lang/Exception
    //   2985	3000	3003	java/lang/Exception
    //   3024	3052	3003	java/lang/Exception
    //   3055	3120	3003	java/lang/Exception
    //   3270	3305	3308	java/lang/Exception
    //   3169	3179	3329	java/lang/Exception
    //   3453	3463	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3470	3481	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3483	3500	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3502	3538	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3538	3623	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3623	3780	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3780	3791	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3793	3942	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3942	4229	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4855	4876	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4878	4895	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4897	4933	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4965	5028	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5032	5067	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5070	5112	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5115	5130	4936	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3538	3623	5031	java/lang/Exception
    //   4965	5028	5031	java/lang/Exception
    //   4271	4286	5138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4286	4389	5138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4389	4400	5138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4402	4430	5138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4508	4522	5696	java/lang/Exception
    //   4526	4534	5696	java/lang/Exception
    //   4537	4616	5696	java/lang/Exception
    //   4616	4666	5696	java/lang/Exception
    //   4666	4716	5696	java/lang/Exception
    //   4716	4808	5696	java/lang/Exception
    //   5181	5190	5696	java/lang/Exception
    //   5200	5218	5735	java/lang/Exception
    //   5220	5290	5735	java/lang/Exception
    //   5538	5557	5797	java/lang/Exception
    //   5609	5640	5999	finally
    //   5964	5986	5999	finally
    //   5986	5994	5999	finally
    //   5646	5654	6035	finally
    //   5656	5663	6035	finally
    //   5680	5687	6035	finally
    //   5807	5824	6035	finally
    //   5826	5835	6035	finally
    //   5837	5846	6035	finally
    //   5848	5860	6035	finally
    //   5862	5871	6035	finally
    //   5873	5882	6035	finally
    //   5884	5893	6035	finally
    //   5895	5903	6035	finally
    //   5905	5914	6035	finally
    //   5916	5927	6035	finally
    //   5929	5936	6035	finally
    //   5938	5943	6035	finally
    //   4448	4478	6039	java/lang/Exception
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), alpo.a(2131707495) });
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
        ((awbw)localObject).b(paramObject.toString());
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
            ((awbw)localObject).a(localInterestTagInfo);
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
      ((awbw)localObject).a();
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
      ausq.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      label849:
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
        ausq.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((ausx.a) && (QLog.isColorLevel())) {
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
    awbw localawbw;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (i != 0) {
        break label1058;
      }
      localawbw = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localawbw.a(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      if (paramFromServiceMsg != null) {
        break label1097;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.app.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label1028:
    label1058:
    label1097:
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
            aush.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
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
            paramObject = (auqc)this.app.getManager(106);
            if (paramObject != null) {
              paramObject.b(paramFromServiceMsg.gender);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("birthday"))
          {
            paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
            paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
            paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
            paramObject = (auqc)this.app.getManager(106);
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
              aush.a(this.app.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
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
                  break label1010;
                }
                bool2 = true;
                paramFromServiceMsg.switchQzone = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                  break label1016;
                }
                bool2 = true;
                paramFromServiceMsg.switchHobby = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                  break label1022;
                }
                l1 = 0L;
                paramFromServiceMsg.switchGiftVisible = l1;
              }
              if (paramFromServiceMsg.getStatus() != 1000) {
                break label1028;
              }
              localawbw.b(paramFromServiceMsg);
              bool2 = true;
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = "";
              notifyUI(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), paramFromServiceMsg });
              paramObject = new HashMap();
              paramObject.put("errorCode", String.valueOf(i));
              azmz.a(BaseApplicationImpl.getContext()).a(this.mApp.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramObject, "");
              ausq.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
              return;
              bool1 = false;
              break;
              paramObject = null;
              break label231;
              paramObject = paramObject;
            } while ((!ausx.a) || (!QLog.isColorLevel()));
            QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + paramObject.getMessage());
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              paramObject.printStackTrace();
              continue;
              label1010:
              bool2 = false;
              continue;
              label1016:
              bool2 = false;
              continue;
              label1022:
              long l1 = 1L;
              continue;
              if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                localawbw.a(paramFromServiceMsg);
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
    alsw.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
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
          aush.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          aush.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
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
          this.app.a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
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
    //   1: getfield 45	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1969
    //   7: invokevirtual 225	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 45	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc_w 1971
    //   21: invokevirtual 269	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   24: lstore 8
    //   26: invokestatic 1465	android/os/SystemClock:elapsedRealtime	()J
    //   29: lstore 10
    //   31: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc_w 313
    //   40: iconst_2
    //   41: new 55	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 1973
    //   51: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 1976	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   58: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   70: ifeq +311 -> 381
    //   73: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   76: lstore 6
    //   78: aload_2
    //   79: invokevirtual 1976	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   82: istore 4
    //   84: aload_2
    //   85: invokevirtual 105	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   88: ifeq +220 -> 308
    //   91: aload_3
    //   92: instanceof 233
    //   95: ifeq +213 -> 308
    //   98: iconst_1
    //   99: istore 13
    //   101: iload 13
    //   103: ifeq +273 -> 376
    //   106: aload_0
    //   107: aload_2
    //   108: invokevirtual 1979	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   111: ldc_w 1981
    //   114: new 780	SummaryCard/RespHead
    //   117: dup
    //   118: invokespecial 1982	SummaryCard/RespHead:<init>	()V
    //   121: invokevirtual 852	ausy:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 780	SummaryCard/RespHead
    //   127: astore 14
    //   129: aload 14
    //   131: ifnull +183 -> 314
    //   134: aload 14
    //   136: getfield 1985	SummaryCard/RespHead:iResult	I
    //   139: ifne +175 -> 314
    //   142: iconst_1
    //   143: istore 12
    //   145: aload 14
    //   147: astore_2
    //   148: iload 12
    //   150: istore 13
    //   152: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +50 -> 205
    //   158: new 55	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 1987
    //   168: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: astore 15
    //   173: aload 14
    //   175: ifnonnull +145 -> 320
    //   178: ldc_w 1989
    //   181: astore_2
    //   182: ldc_w 313
    //   185: iconst_2
    //   186: aload 15
    //   188: aload_2
    //   189: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: iload 12
    //   200: istore 13
    //   202: aload 14
    //   204: astore_2
    //   205: aload_0
    //   206: iload 13
    //   208: aload_3
    //   209: aload_1
    //   210: getfield 45	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   213: aload_2
    //   214: invokespecial 16	ausy:a	(ZLjava/lang/Object;Landroid/os/Bundle;LSummaryCard/RespHead;)V
    //   217: new 1793	java/util/HashMap
    //   220: dup
    //   221: invokespecial 1794	java/util/HashMap:<init>	()V
    //   224: astore_1
    //   225: aload_1
    //   226: ldc_w 1796
    //   229: iload 4
    //   231: invokestatic 1798	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 1801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: invokestatic 1807	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   241: invokestatic 1812	azmz:a	(Landroid/content/Context;)Lazmz;
    //   244: aload_0
    //   245: getfield 1816	ausy:mApp	Lcom/tencent/common/app/AppInterface;
    //   248: invokevirtual 1819	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   251: ldc_w 1991
    //   254: iload 13
    //   256: lload 10
    //   258: lload 8
    //   260: lsub
    //   261: lconst_0
    //   262: aload_1
    //   263: ldc_w 517
    //   266: invokevirtual 1824	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   269: invokestatic 688	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   272: ifeq -259 -> 13
    //   275: ldc_w 313
    //   278: iconst_4
    //   279: new 55	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 1993
    //   289: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 496	java/lang/System:currentTimeMillis	()J
    //   295: lload 6
    //   297: lsub
    //   298: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: iconst_0
    //   309: istore 13
    //   311: goto -210 -> 101
    //   314: iconst_0
    //   315: istore 12
    //   317: goto -172 -> 145
    //   320: aload 14
    //   322: getfield 1985	SummaryCard/RespHead:iResult	I
    //   325: istore 5
    //   327: iload 5
    //   329: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: astore_2
    //   333: goto -151 -> 182
    //   336: astore 14
    //   338: aconst_null
    //   339: astore_2
    //   340: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +15 -> 358
    //   346: ldc_w 313
    //   349: iconst_2
    //   350: aload 14
    //   352: invokevirtual 1027	java/lang/Exception:toString	()Ljava/lang/String;
    //   355: invokestatic 326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	387	0	this	ausy
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
          auqc.a(this.app);
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
    //   12: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 2051
    //   21: iconst_2
    //   22: new 55	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2053
    //   32: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 105	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 1210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 105	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 1838	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 866	[B
    //   92: checkcast 866	[B
    //   95: invokevirtual 1839	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 1840	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 1602	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 1840	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 2051
    //   139: iconst_2
    //   140: new 55	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 2055
    //   150: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 1840	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 2002	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 2003	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 67	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 73	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 79	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 2004	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 2002	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 85	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 2036	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 2039	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 2042	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 2045	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 2048	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 55	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 2057
    //   283: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 156	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 159 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 214 2 0
    //   319: checkcast 2010	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 2059
    //   328: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 2062	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 2064
    //   345: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 2067	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 902	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 2069
    //   362: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 2072	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 2074
    //   379: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 2076
    //   396: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 2078
    //   408: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 2080
    //   420: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 2082
    //   432: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 2051
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 39	ausy:notifyUI	(IZLjava/lang/Object;)V
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
    //   481: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 2051
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 2012	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	539	0	this	ausy
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
        azmz.a(this.mApp.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.app.getEntityManagerFactory().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            paramObject.likeCount += j;
            paramObject.bVoted = 1;
            paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
            if (paramObject.bAvailVoteCnt < 0) {
              paramObject.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.a(paramObject);
          }
          bdam.a(this.app, l1, j);
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
      azmz.a(this.mApp.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
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
    Object localObject2 = aupw.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)aush.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)aush.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
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
    alsw.a(this, paramLong, paramInt, paramArrayOfByte);
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
  
  public void a(Bundle paramBundle, ArrayList<PicInfo> paramArrayList, auwl[] paramArrayOfauwl, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((ausx.a) && (QLog.isColorLevel())) {
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
        localObject1 = aupw.a(getClass().getSimpleName());
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
      if ((paramArrayOfauwl != null) && (paramArrayOfauwl.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        j = paramArrayOfauwl.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfauwl[i];
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((auwl)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((ausx.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < paramArrayOfauwl.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfauwl[i].toString()).append(",");
            i += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfauwl = (auwl[])localObject1;; paramArrayOfauwl = null)
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
            if (ausx.a)
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
            if (ausx.a)
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
            if (ausx.a)
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
            if (ausx.a)
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
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(bdlr.b(k)));
            i = j;
            if (ausx.a)
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
              bdlr.a((byte[])localObject2, j * 4, bdlr.b(allj.a(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = allj.a(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(bdlr.b(j)));
            if ((ausx.a) && (QLog.isColorLevel()))
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
              bdlr.a((byte[])localObject2, i * 4, bdlr.b(allj.a(localObject1[i])), 4);
              i += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            i = allj.a(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(bdlr.b(i)));
            if ((ausx.a) && (QLog.isColorLevel()))
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
            if (ausx.a)
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
            if (ausx.a)
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
            if (ausx.a)
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
            if ((ausx.a) && (QLog.isColorLevel()))
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
            if (ausx.a)
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
            if (bcyr.a(m))
            {
              k = i + 1;
              localReqBody.uint32_profession.set(m);
            }
            j = k;
            if (ausx.a)
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
            if (ausx.a)
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
            if (ausx.a)
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
            if (ausx.a)
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
        if ((ausx.a) && (QLog.isColorLevel())) {
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
          if (paramArrayOfauwl != null) {
            break label2388;
          }
        }
        label2356:
        label2388:
        for (paramBundle = null;; paramBundle = paramArrayOfauwl.toByteArray())
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
            Object localObject2 = (TroopManager)this.app.getManager(52);
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
      new auyw(this.app).a(13569).b(1).a(new autb(this)).a(new auta(this)).a(localIceReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("NearbyCardHandler", 1, "sendPoBingMsg. error=" + QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6, boolean paramBoolean3, long paramLong7, int paramInt3)
  {
    try
    {
      l1 = Long.parseLong(paramString1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramString2);
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
          if (!paramBoolean3) {
            break;
          }
          send(paramString1);
          return;
          localNumberFormatException1 = localNumberFormatException1;
          long l1 = 0L;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          long l2 = 0L;
        }
        paramString2 = new NowSummaryCard.NowSummaryCardReq();
        paramString2.id.set(paramLong7);
        paramString2.id_type.set(paramInt3);
        paramArrayOfByte1 = new UniPacket(true);
        paramArrayOfByte1.setEncodeName("utf-8");
        ayux.b(paramString1, paramArrayOfByte1);
        paramArrayOfByte1 = paramArrayOfByte1.encode();
        paramInt1 = paramArrayOfByte1.length - 4;
        paramString3 = new byte[paramInt1];
        bdlr.a(paramString3, 0, paramArrayOfByte1, 4, paramInt1);
        paramString2.jce_data.set(ByteStringMicro.copyFrom(paramString3));
        mzy.a(this.app, new ausz(this, false, paramString1), paramString2.toByteArray(), "NowSummaryCard.NowSummaryCardReq");
      }
    }
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
  
  public void a(ArrayList<aurn> paramArrayList, int paramInt)
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
        aurn localaurn = (aurn)paramArrayList.get(i);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(localaurn).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(localaurn.jdField_a_of_type_Long);
        localVoteInfo.uint32_free_vote_count.set(localaurn.jdField_a_of_type_Int);
        localVoteInfo.uint32_pay_vote_count.set(localaurn.jdField_b_of_type_Int);
        localVoteInfo.uint32_source.set(localaurn.d);
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
  
  public void a(List<auwl> paramList, int paramInt1, int paramInt2)
  {
    alsw.a(this, 4, paramList, paramInt1, paramInt2);
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
          paramToServiceMsg = new aurp();
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
            aurn localaurn = new aurn();
            l = 0L;
            if (localUserZanInfo.uint64_uin.has())
            {
              l = localUserZanInfo.uint64_uin.get();
              localaurn.jdField_a_of_type_Long = l;
              localaurn.jdField_a_of_type_Int = ((int)localUserZanInfo.uint64_free_zan.get());
              localaurn.jdField_b_of_type_Int = ((int)localUserZanInfo.uint64_pay_zan.get());
              localaurn.c = ((int)localUserZanInfo.uint64_pay_stock.get());
              if (l <= 0L) {
                continue;
              }
              paramObject.add(localaurn);
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
      ((auri)this.app.getManager(207)).a(paramToServiceMsg, paramObject, j);
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
      paramFromServiceMsg = (auri)this.app.getManager(207);
      paramObject = ((oidb_0x8e6.RspBody)localObject1).rpt_vote_result.get();
      int i1 = paramObject.size();
      i = 0;
      while (i < i1)
      {
        Object localObject2 = (oidb_0x8e6.VoteResult)paramObject.get(i);
        localObject1 = new auro();
        ((auro)localObject1).jdField_a_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_ret.get();
        ((auro)localObject1).jdField_a_of_type_JavaLangString = ((oidb_0x8e6.VoteResult)localObject2).bytes_err_msg.get().toStringUtf8();
        ((auro)localObject1).jdField_a_of_type_Long = ((oidb_0x8e6.VoteResult)localObject2).uint64_uin.get();
        ((auro)localObject1).jdField_b_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_free_vote_count.get();
        ((auro)localObject1).c = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_pay_vote_count.get();
        ((auro)localObject1).d = ((oidb_0x8e6.VoteResult)localObject2).uint32_vote_count.get();
        ((auro)localObject1).e = ((int)((oidb_0x8e6.VoteResult)localObject2).uint64_pay_stock.get());
        paramToServiceMsg.add(localObject1);
        int i2 = ((auro)localObject1).jdField_b_of_type_Int;
        i2 = ((auro)localObject1).c + i2;
        if ((((auro)localObject1).jdField_a_of_type_Int == 0) && (((auro)localObject1).jdField_a_of_type_Long > 0L) && (i2 > 0))
        {
          bdam.a(this.app, ((auro)localObject1).jdField_a_of_type_Long, i2);
          localObject2 = this.app.getEntityManagerFactory().createEntityManager();
          NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((awbw)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(((auro)localObject1).jdField_a_of_type_Long) });
          if (localNearbyPeopleCard != null)
          {
            localNearbyPeopleCard.likeCount += i2;
            localNearbyPeopleCard.bVoted = 1;
            localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
            if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
              localNearbyPeopleCard.bAvailVoteCnt = 0;
            }
            ((awbw)localObject2).a(localNearbyPeopleCard);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + localObject1);
        }
        paramFromServiceMsg.a(((auro)localObject1).jdField_a_of_type_Long + "", true);
        i += 1;
      }
      paramFromServiceMsg.a(k, m, n);
      notifyUI(17, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    notifyUI(17, false, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
  }
  
  protected boolean msgCmdFilter(String paramString)
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
  
  protected Class<? extends alkr> observerClass()
  {
    return autc.class;
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
        alsw.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausy
 * JD-Core Version:    0.7.0.1
 */