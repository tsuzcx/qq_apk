import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.1;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.8;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.Observer;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class bcjl
{
  public int a;
  private aipw jdField_a_of_type_Aipw;
  private aiqc jdField_a_of_type_Aiqc = new bcjo(this);
  private amdu jdField_a_of_type_Amdu;
  private ameq jdField_a_of_type_Ameq = new bcjq(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bciu jdField_a_of_type_Bciu;
  public bckx a;
  private bcmb jdField_a_of_type_Bcmb;
  private bdbb jdField_a_of_type_Bdbb;
  private bdbc jdField_a_of_type_Bdbc = new bcjn(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopClipPic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new bcjp(this);
  protected ndm a;
  private boolean jdField_a_of_type_Boolean;
  private List<TroopClipPic> b = new ArrayList();
  
  public bcjl()
  {
    this.jdField_a_of_type_Ndm = new bcjm(this);
    this.jdField_a_of_type_Bckx = new bcjr(this);
  }
  
  private FragmentActivity a()
  {
    if (this.jdField_a_of_type_Bciu != null) {
      return ((VisitorTroopCardFragment)this.jdField_a_of_type_Bciu).getActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment a()
  {
    if (this.jdField_a_of_type_Bciu != null) {
      return (VisitorTroopCardFragment)this.jdField_a_of_type_Bciu;
    }
    return null;
  }
  
  /* Error */
  private void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 112	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 115	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 9
    //   21: aload 9
    //   23: aload_1
    //   24: getfield 119	KQQ/BatchResponse:buffer	[B
    //   27: invokevirtual 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   30: pop
    //   31: aload_1
    //   32: getfield 126	KQQ/BatchResponse:seq	I
    //   35: ifne +240 -> 275
    //   38: aload 9
    //   40: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   43: invokevirtual 136	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   46: ifeq +229 -> 275
    //   49: aload 9
    //   51: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   57: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   60: astore 7
    //   62: new 148	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   65: dup
    //   66: invokespecial 149	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   69: astore 8
    //   71: aload 8
    //   73: aload 7
    //   75: invokevirtual 150	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload 8
    //   81: getfield 154	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: astore 10
    //   89: aload 10
    //   91: ifnonnull +49 -> 140
    //   94: iconst_0
    //   95: istore_2
    //   96: goto +791 -> 887
    //   99: aload 7
    //   101: ifnonnull +174 -> 275
    //   104: iload_3
    //   105: iload_2
    //   106: if_icmpge +169 -> 275
    //   109: aload 10
    //   111: iload_3
    //   112: invokeinterface 164 2 0
    //   117: checkcast 166	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   120: astore 8
    //   122: aload 8
    //   124: ifnonnull +27 -> 151
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -32 -> 99
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 169	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   139: return
    //   140: aload 10
    //   142: invokeinterface 173 1 0
    //   147: istore_2
    //   148: goto +739 -> 887
    //   151: aload 8
    //   153: getfield 177	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: istore 4
    //   161: iload 4
    //   163: bipush 72
    //   165: if_icmpne +35 -> 200
    //   168: iload_3
    //   169: ifne +31 -> 200
    //   172: aload_0
    //   173: invokespecial 84	bcjl:a	()Landroid/support/v4/app/FragmentActivity;
    //   176: ifnull +630 -> 806
    //   179: aload_0
    //   180: getfield 76	bcjl:jdField_a_of_type_Bciu	Lbciu;
    //   183: aload_0
    //   184: invokespecial 84	bcjl:a	()Landroid/support/v4/app/FragmentActivity;
    //   187: ldc 182
    //   189: invokevirtual 188	android/support/v4/app/FragmentActivity:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 193 2 0
    //   197: goto -70 -> 127
    //   200: iload 4
    //   202: ifne +576 -> 778
    //   205: aload 8
    //   207: getfield 197	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   210: invokevirtual 200	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   213: ifeq +565 -> 778
    //   216: aload 8
    //   218: getfield 197	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   221: invokevirtual 203	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   224: checkcast 199	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   227: astore 8
    //   229: aload 8
    //   231: astore 7
    //   233: aload 8
    //   235: ifnull -108 -> 127
    //   238: aload_0
    //   239: getfield 76	bcjl:jdField_a_of_type_Bciu	Lbciu;
    //   242: aload 8
    //   244: invokeinterface 206 2 0
    //   249: aload 8
    //   251: astore 7
    //   253: goto -126 -> 127
    //   256: astore 7
    //   258: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +14 -> 275
    //   264: ldc 213
    //   266: iconst_2
    //   267: aload 7
    //   269: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokestatic 221	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_1
    //   276: getfield 126	KQQ/BatchResponse:seq	I
    //   279: iconst_1
    //   280: if_icmpne +117 -> 397
    //   283: aload 9
    //   285: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 136	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   291: ifeq +106 -> 397
    //   294: aload 9
    //   296: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   302: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   305: astore 7
    //   307: new 223	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   310: dup
    //   311: invokespecial 224	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   314: astore 8
    //   316: aload 8
    //   318: aload 7
    //   320: invokevirtual 225	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   323: pop
    //   324: aload 8
    //   326: getfield 228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   329: invokevirtual 229	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   332: ifeq +65 -> 397
    //   335: aload_0
    //   336: getfield 98	bcjl:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   339: getfield 234	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: invokespecial 95	bcjl:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   349: ifnull +460 -> 809
    //   352: aload_0
    //   353: invokespecial 95	bcjl:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   356: getfield 237	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:c	Z
    //   359: ifeq +450 -> 809
    //   362: aload_0
    //   363: invokespecial 95	bcjl:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   366: ifnull +31 -> 397
    //   369: aload_0
    //   370: invokespecial 95	bcjl:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   373: getfield 240	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   376: ifnull +21 -> 397
    //   379: aload_0
    //   380: invokespecial 95	bcjl:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   383: getfield 240	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   386: aload 8
    //   388: getfield 228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   394: invokevirtual 245	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   397: aload_1
    //   398: getfield 126	KQQ/BatchResponse:seq	I
    //   401: iconst_2
    //   402: if_icmpne -391 -> 11
    //   405: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +11 -> 419
    //   411: ldc 247
    //   413: iconst_2
    //   414: ldc 249
    //   416: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 9
    //   421: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   424: invokevirtual 136	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   427: ifeq -416 -> 11
    //   430: aload 9
    //   432: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   438: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   441: astore_1
    //   442: new 254	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   445: dup
    //   446: invokespecial 255	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   449: astore 7
    //   451: aload 7
    //   453: aload_1
    //   454: invokevirtual 256	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: pop
    //   458: aload 7
    //   460: getfield 260	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   463: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   466: ifeq -455 -> 11
    //   469: aload 7
    //   471: getfield 266	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   474: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   477: ifne +405 -> 882
    //   480: aload 7
    //   482: getfield 266	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   485: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   488: astore_1
    //   489: aload_0
    //   490: getfield 91	bcjl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   493: bipush 52
    //   495: invokevirtual 275	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   498: checkcast 277	com/tencent/mobileqq/app/TroopManager
    //   501: astore 8
    //   503: aload 7
    //   505: getfield 260	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   508: invokevirtual 280	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   511: lstore 5
    //   513: aload 8
    //   515: lload 5
    //   517: invokestatic 286	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   520: invokevirtual 289	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   523: astore 9
    //   525: aload 9
    //   527: ifnull -516 -> 11
    //   530: aload_1
    //   531: ifnull +68 -> 599
    //   534: aload 9
    //   536: aload_1
    //   537: invokevirtual 294	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   540: aload 7
    //   542: getfield 297	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   545: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   548: ifeq +298 -> 846
    //   551: aload 7
    //   553: getfield 297	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   556: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   559: istore_2
    //   560: aload 9
    //   562: iload_2
    //   563: i2l
    //   564: putfield 302	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   567: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +29 -> 599
    //   573: ldc 247
    //   575: iconst_2
    //   576: new 304	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 307
    //   586: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload_2
    //   590: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload 9
    //   601: aload 7
    //   603: getfield 318	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   606: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   609: invokevirtual 321	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   612: putfield 324	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   615: aload 9
    //   617: aload 7
    //   619: getfield 327	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   622: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   625: invokevirtual 321	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   628: putfield 330	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   631: aload 7
    //   633: getfield 333	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   636: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   639: ifeq +238 -> 877
    //   642: aload 9
    //   644: aload 7
    //   646: getfield 333	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   649: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   652: i2b
    //   653: putfield 337	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   656: aload 9
    //   658: getfield 337	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   661: istore_2
    //   662: aload 7
    //   664: getfield 340	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   667: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   670: ifeq +202 -> 872
    //   673: aload 9
    //   675: aload 7
    //   677: getfield 340	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   680: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   683: i2b
    //   684: putfield 343	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   687: aload 9
    //   689: getfield 343	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   692: istore_3
    //   693: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +44 -> 740
    //   699: ldc 247
    //   701: iconst_2
    //   702: new 304	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   709: lload 5
    //   711: invokevirtual 346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: ldc_w 348
    //   717: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: iload_2
    //   721: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: ldc_w 350
    //   727: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: iload_3
    //   731: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: new 352	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7
    //   743: dup
    //   744: aload_0
    //   745: aload 8
    //   747: aload 9
    //   749: invokespecial 355	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7:<init>	(Lbcjl;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   752: bipush 8
    //   754: aconst_null
    //   755: iconst_0
    //   756: invokestatic 361	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   759: return
    //   760: astore_1
    //   761: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   764: ifeq -753 -> 11
    //   767: ldc 247
    //   769: iconst_2
    //   770: aload_1
    //   771: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   774: invokestatic 364	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: return
    //   778: ldc_w 366
    //   781: iconst_1
    //   782: new 304	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   789: ldc_w 368
    //   792: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: iload 4
    //   797: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 364	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: goto -679 -> 127
    //   809: aload_0
    //   810: aload 8
    //   812: getfield 228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   815: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   818: invokespecial 369	bcjl:a	(Ljava/util/List;)V
    //   821: goto -424 -> 397
    //   824: astore 7
    //   826: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   829: ifeq -432 -> 397
    //   832: ldc 213
    //   834: iconst_2
    //   835: aload 7
    //   837: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokestatic 221	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: goto -446 -> 397
    //   846: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   849: ifeq -250 -> 599
    //   852: ldc 247
    //   854: iconst_2
    //   855: ldc_w 371
    //   858: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: goto -262 -> 599
    //   864: astore_1
    //   865: aload_1
    //   866: invokevirtual 372	java/lang/Exception:printStackTrace	()V
    //   869: goto -238 -> 631
    //   872: iconst_m1
    //   873: istore_3
    //   874: goto -181 -> 693
    //   877: iconst_m1
    //   878: istore_2
    //   879: goto -217 -> 662
    //   882: aconst_null
    //   883: astore_1
    //   884: goto -395 -> 489
    //   887: iconst_0
    //   888: istore_3
    //   889: aconst_null
    //   890: astore 7
    //   892: goto -793 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	bcjl
    //   0	895	1	paramBatchResponse	KQQ.BatchResponse
    //   95	784	2	i	int
    //   104	785	3	j	int
    //   159	637	4	k	int
    //   511	199	5	l	long
    //   60	192	7	localObject1	Object
    //   256	12	7	localException1	Exception
    //   305	371	7	localObject2	Object
    //   824	12	7	localException2	Exception
    //   890	1	7	localObject3	Object
    //   69	742	8	localObject4	Object
    //   19	729	9	localObject5	Object
    //   87	54	10	localList	List
    // Exception table:
    //   from	to	target	type
    //   21	31	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   62	89	256	java/lang/Exception
    //   109	122	256	java/lang/Exception
    //   140	148	256	java/lang/Exception
    //   151	161	256	java/lang/Exception
    //   172	197	256	java/lang/Exception
    //   205	229	256	java/lang/Exception
    //   238	249	256	java/lang/Exception
    //   778	806	256	java/lang/Exception
    //   442	489	760	java/lang/Exception
    //   489	525	760	java/lang/Exception
    //   534	599	760	java/lang/Exception
    //   631	662	760	java/lang/Exception
    //   662	693	760	java/lang/Exception
    //   693	740	760	java/lang/Exception
    //   740	759	760	java/lang/Exception
    //   846	861	760	java/lang/Exception
    //   865	869	760	java/lang/Exception
    //   307	362	824	java/lang/Exception
    //   362	397	824	java/lang/Exception
    //   809	821	824	java/lang/Exception
    //   599	631	864	java/lang/Exception
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    amdu localamdu = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject1;
      } else if (((bcpg)localObject2).b(str)) {
        localArrayList1.add(localObject1);
      } else if (bcpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject1);
      } else {
        localArrayList3.add(localObject1);
      }
    }
    localObject2 = new ArrayList();
    Object localObject1 = paramList;
    if (paramList == null) {}
    try
    {
      localObject1 = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject1).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      ((List)localObject2).add(0, localObject1);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramList.toString());
        }
      }
      if (a() == null) {
        break label389;
      }
      localObject1 = bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, a().jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label389;
      }
      a().jdField_a_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = ((String)localObject1);
      localamdu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    ((List)localObject2).addAll(localArrayList2);
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    label389:
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_Aiqc);
    this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_Bdbc);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.a(null);
    }
    this.jdField_a_of_type_Bdbc = null;
    if (this.jdField_a_of_type_Aipw != null) {
      this.jdField_a_of_type_Aipw.a(null);
    }
    this.jdField_a_of_type_Aiqc = null;
    this.jdField_a_of_type_Bckx = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ndm);
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Bdbb != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bdbb.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(paramString, 4, true);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bdhj.a();
    }
    paramString = new BitmapDrawable(paramString);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return paramString;
  }
  
  public void a()
  {
    f();
    h();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Amdu = null;
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    if (this.jdField_a_of_type_Aipw != null) {
      this.jdField_a_of_type_Aipw.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.onDestroy();
    }
    if (this.jdField_a_of_type_Bcmb != null)
    {
      this.jdField_a_of_type_Bcmb.b(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_Bcmb.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
    this.jdField_a_of_type_Bciu = null;
  }
  
  public void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aiqc != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.jdField_a_of_type_Aiqc.a(paramBundle);
    }
  }
  
  public void a(bciu parambciu)
  {
    this.jdField_a_of_type_Bciu = parambciu;
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    this.jdField_a_of_type_Amdu = ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Bcmb = new bcmb(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bcpv.class, this.jdField_a_of_type_Amdu);
    this.jdField_a_of_type_Bcmb.a(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_Bdbb = new bdbb(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aipw = new aipt(a(), a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    e();
    g();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcmb != null) {
      this.jdField_a_of_type_Bcmb.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Bciu == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      amdu localamdu;
      do
      {
        return;
        localamdu = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      } while (localamdu == null);
      try
      {
        long l = Long.parseLong(paramString);
        this.jdField_a_of_type_Bciu.c();
        localamdu.a(l, paramInt);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramString.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aipw != null) {
      this.jdField_a_of_type_Aipw.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangString = paramString2;
        if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
        {
          this.jdField_a_of_type_Bciu.b();
          return;
        }
      } while (TextUtils.isEmpty(paramString2));
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
      if (paramString2 == null)
      {
        this.jdField_a_of_type_Bciu.c();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ndm);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1);
        return;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramString2.openID));
    this.jdField_a_of_type_Bciu.b();
  }
  
  public void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_Bciu == null)) {
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    Object localObject;
    boolean bool;
    label71:
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        localObject = "null";
        if (localTroopInfo != null) {
          break label237;
        }
        bool = true;
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("setAvatarList isServer=%b piclist=%s troopinfo=null %b", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(bool) }));
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = paramList;
      if (localTroopInfo != null)
      {
        localObject = paramList;
        if (paramList == null)
        {
          localObject = new ArrayList();
          aiqe.b((List)localObject, localTroopInfo);
        }
      }
      if (localObject == null) {
        break label314;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.b.clear();
      paramList = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label271;
      }
      localObject = (TroopClipPic)paramList.next();
      if (((TroopClipPic)localObject).type == 1)
      {
        this.b.add(localObject);
        continue;
        localObject = Integer.valueOf(paramList.size());
        break;
        label237:
        bool = false;
        break label71;
      }
      localArrayList.add(ainn.a((TroopClipPic)localObject, null));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    label271:
    if (this.b.size() == 0)
    {
      paramList = new TroopClipPic();
      paramList.id = ainn.jdField_a_of_type_JavaLangString;
      paramList.type = 1;
      this.b.add(paramList);
    }
    label314:
    this.jdField_a_of_type_Bciu.a(false, localArrayList);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (a() == null)) {}
    while (this.jdField_a_of_type_Amdu == null) {
      return;
    }
    amdu localamdu = this.jdField_a_of_type_Amdu;
    long l = aloz.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (!a().c)) {}
    for (boolean bool = true;; bool = false)
    {
      localamdu.a(l, bool);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
  }
  
  protected void c()
  {
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      ThreadManager.post(new VisitorTroopCardPresenter.8(this), 5, null, false);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aipw != null) {
      this.jdField_a_of_type_Aipw.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjl
 * JD-Core Version:    0.7.0.1
 */