import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.1;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.8;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.Observer;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class bgdy
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aoep jdField_a_of_type_Aoep;
  private aofu jdField_a_of_type_Aofu = new bged(this);
  private bgdd jdField_a_of_type_Bgdd;
  public bghi a;
  private bgio jdField_a_of_type_Bgio;
  private TroopPhotoController.OnGotoBigPicListener jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener = new bgeb(this);
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new bgea(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopClipPic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new bgec(this);
  protected nwk a;
  private boolean jdField_a_of_type_Boolean;
  private List<TroopClipPic> b = new ArrayList();
  
  public bgdy()
  {
    this.jdField_a_of_type_Nwk = new bgdz(this);
    this.jdField_a_of_type_Bghi = new bgee(this);
  }
  
  private FragmentActivity a()
  {
    if (this.jdField_a_of_type_Bgdd != null) {
      return ((VisitorTroopCardFragment)this.jdField_a_of_type_Bgdd).getActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment a()
  {
    if (this.jdField_a_of_type_Bgdd != null) {
      return (VisitorTroopCardFragment)this.jdField_a_of_type_Bgdd;
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
    //   96: goto +870 -> 966
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
    //   148: goto +818 -> 966
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
    //   173: invokespecial 84	bgdy:a	()Landroid/support/v4/app/FragmentActivity;
    //   176: ifnull +697 -> 873
    //   179: aload_0
    //   180: getfield 76	bgdy:jdField_a_of_type_Bgdd	Lbgdd;
    //   183: aload_0
    //   184: invokespecial 84	bgdy:a	()Landroid/support/v4/app/FragmentActivity;
    //   187: ldc 182
    //   189: invokevirtual 188	android/support/v4/app/FragmentActivity:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 193 2 0
    //   197: goto -70 -> 127
    //   200: iload 4
    //   202: ifne +643 -> 845
    //   205: aload 8
    //   207: getfield 197	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   210: invokevirtual 200	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   213: ifeq +632 -> 845
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
    //   239: getfield 76	bgdy:jdField_a_of_type_Bgdd	Lbgdd;
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
    //   336: getfield 98	bgdy:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   339: getfield 234	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: invokespecial 95	bgdy:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   349: ifnull +527 -> 876
    //   352: aload_0
    //   353: invokespecial 95	bgdy:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   356: getfield 237	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:c	Z
    //   359: ifeq +517 -> 876
    //   362: aload_0
    //   363: invokespecial 95	bgdy:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   366: ifnull +31 -> 397
    //   369: aload_0
    //   370: invokespecial 95	bgdy:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   373: getfield 240	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   376: ifnull +21 -> 397
    //   379: aload_0
    //   380: invokespecial 95	bgdy:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
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
    //   449: astore 8
    //   451: aload 8
    //   453: aload_1
    //   454: invokevirtual 256	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: pop
    //   458: aload 8
    //   460: getfield 260	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   463: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   466: ifeq -455 -> 11
    //   469: aload 8
    //   471: getfield 266	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   474: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   477: ifne +484 -> 961
    //   480: aload 8
    //   482: getfield 266	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   485: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   488: astore_1
    //   489: aload 8
    //   491: getfield 272	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   494: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   497: ifne +458 -> 955
    //   500: aload 8
    //   502: getfield 272	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   505: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   508: astore 7
    //   510: aload_0
    //   511: getfield 91	bgdy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   514: getstatic 277	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   517: invokevirtual 283	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   520: checkcast 285	com/tencent/mobileqq/app/TroopManager
    //   523: astore 9
    //   525: aload 8
    //   527: getfield 260	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   530: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   533: lstore 5
    //   535: aload 9
    //   537: lload 5
    //   539: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   542: invokevirtual 297	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   545: astore 10
    //   547: aload 10
    //   549: ifnull -538 -> 11
    //   552: aload_1
    //   553: ifnull +70 -> 623
    //   556: aload 10
    //   558: aload_1
    //   559: aload 7
    //   561: invokevirtual 303	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   564: aload 8
    //   566: getfield 306	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   569: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   572: ifeq +341 -> 913
    //   575: aload 8
    //   577: getfield 306	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   580: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   583: istore_2
    //   584: aload 10
    //   586: iload_2
    //   587: i2l
    //   588: putfield 311	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   591: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq +29 -> 623
    //   597: ldc 247
    //   599: iconst_2
    //   600: new 313	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 316
    //   610: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: iload_2
    //   614: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload 10
    //   625: aload 8
    //   627: getfield 327	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   630: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   633: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   636: putfield 333	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   639: aload 10
    //   641: aload 8
    //   643: getfield 336	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   646: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   649: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   652: putfield 339	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   655: aload 8
    //   657: getfield 342	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   660: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   663: ifeq +287 -> 950
    //   666: aload 10
    //   668: aload 8
    //   670: getfield 342	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   673: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   676: i2b
    //   677: putfield 346	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   680: aload 10
    //   682: getfield 346	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   685: istore_2
    //   686: aload 8
    //   688: getfield 349	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   691: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   694: ifeq +251 -> 945
    //   697: aload 10
    //   699: aload 8
    //   701: getfield 349	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   704: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   707: i2b
    //   708: putfield 352	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   711: aload 10
    //   713: getfield 352	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   716: istore_3
    //   717: aload 8
    //   719: getfield 355	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   722: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   725: ifeq +214 -> 939
    //   728: aload 10
    //   730: aload 8
    //   732: getfield 355	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   735: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   738: i2b
    //   739: putfield 358	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   742: aload 10
    //   744: getfield 358	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   747: istore 4
    //   749: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +55 -> 807
    //   755: ldc 247
    //   757: iconst_2
    //   758: new 313	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   765: lload 5
    //   767: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc_w 363
    //   773: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload_2
    //   777: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: ldc_w 365
    //   783: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: iload_3
    //   787: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: ldc_w 367
    //   793: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: iload 4
    //   798: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: new 369	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7
    //   810: dup
    //   811: aload_0
    //   812: aload 9
    //   814: aload 10
    //   816: invokespecial 372	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7:<init>	(Lbgdy;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   819: bipush 8
    //   821: aconst_null
    //   822: iconst_0
    //   823: invokestatic 378	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   826: return
    //   827: astore_1
    //   828: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   831: ifeq -820 -> 11
    //   834: ldc 247
    //   836: iconst_2
    //   837: aload_1
    //   838: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   841: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: return
    //   845: ldc_w 383
    //   848: iconst_1
    //   849: new 313	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 385
    //   859: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: iload 4
    //   864: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   867: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: goto -746 -> 127
    //   876: aload_0
    //   877: aload 8
    //   879: getfield 228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   882: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   885: invokespecial 386	bgdy:a	(Ljava/util/List;)V
    //   888: goto -491 -> 397
    //   891: astore 7
    //   893: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   896: ifeq -499 -> 397
    //   899: ldc 213
    //   901: iconst_2
    //   902: aload 7
    //   904: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   907: invokestatic 221	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -513 -> 397
    //   913: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -293 -> 623
    //   919: ldc 247
    //   921: iconst_2
    //   922: ldc_w 388
    //   925: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -305 -> 623
    //   931: astore_1
    //   932: aload_1
    //   933: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   936: goto -281 -> 655
    //   939: iconst_m1
    //   940: istore 4
    //   942: goto -193 -> 749
    //   945: iconst_m1
    //   946: istore_3
    //   947: goto -230 -> 717
    //   950: iconst_m1
    //   951: istore_2
    //   952: goto -266 -> 686
    //   955: aconst_null
    //   956: astore 7
    //   958: goto -448 -> 510
    //   961: aconst_null
    //   962: astore_1
    //   963: goto -474 -> 489
    //   966: iconst_0
    //   967: istore_3
    //   968: aconst_null
    //   969: astore 7
    //   971: goto -872 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	974	0	this	bgdy
    //   0	974	1	paramBatchResponse	KQQ.BatchResponse
    //   95	857	2	i	int
    //   104	864	3	j	int
    //   159	782	4	k	int
    //   533	233	5	l	long
    //   60	192	7	localObject1	Object
    //   256	12	7	localException1	Exception
    //   305	255	7	localObject2	Object
    //   891	12	7	localException2	Exception
    //   956	14	7	localObject3	Object
    //   69	809	8	localObject4	Object
    //   19	794	9	localObject5	Object
    //   87	728	10	localObject6	Object
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
    //   845	873	256	java/lang/Exception
    //   442	489	827	java/lang/Exception
    //   489	510	827	java/lang/Exception
    //   510	547	827	java/lang/Exception
    //   556	623	827	java/lang/Exception
    //   655	686	827	java/lang/Exception
    //   686	717	827	java/lang/Exception
    //   717	749	827	java/lang/Exception
    //   749	807	827	java/lang/Exception
    //   807	826	827	java/lang/Exception
    //   913	928	827	java/lang/Exception
    //   932	936	827	java/lang/Exception
    //   307	362	891	java/lang/Exception
    //   362	397	891	java/lang/Exception
    //   876	888	891	java/lang/Exception
    //   623	655	931	java/lang/Exception
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
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
      } else if (((bgls)localObject2).b(str)) {
        localArrayList1.add(localObject1);
      } else if (TroopUtils.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
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
        break label419;
      }
      localObject1 = TroopUtils.saveMemberUinStringToDB(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label419;
      }
      a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject1);
      localaoep.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    ((List)localObject2).addAll(localArrayList2);
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)) {
      a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a((List)localObject2);
    }
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    label419:
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener = null;
    this.jdField_a_of_type_Bghi = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nwk);
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 4, true);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bheg.a();
    }
    return new BitmapDrawable(paramString);
  }
  
  public void a()
  {
    f();
    h();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Aoep = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.onDestroy();
    }
    if (this.jdField_a_of_type_Bgio != null)
    {
      this.jdField_a_of_type_Bgio.b(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_Bgio.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
    this.jdField_a_of_type_Bgdd = null;
  }
  
  public void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener.gotoBigPic(paramBundle);
    }
  }
  
  public void a(bgdd parambgdd)
  {
    this.jdField_a_of_type_Bgdd = parambgdd;
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    this.jdField_a_of_type_Aoep = ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_Bgio = new bgio(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bgmh.class, this.jdField_a_of_type_Aoep);
    this.jdField_a_of_type_Bgio.a(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new aklk(a(), a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    e();
    g();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bgio != null) {
      this.jdField_a_of_type_Bgio.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Bgdd == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      aoep localaoep;
      do
      {
        return;
        localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      } while (localaoep == null);
      try
      {
        long l = Long.parseLong(paramString);
        this.jdField_a_of_type_Bgdd.c();
        localaoep.a(l, paramInt);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramString.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPicPicked(paramString1, paramString2);
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
          this.jdField_a_of_type_Bgdd.b();
          return;
        }
      } while (TextUtils.isEmpty(paramString2));
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString1);
      if (paramString2 == null)
      {
        this.jdField_a_of_type_Bgdd.c();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nwk);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().d(paramString1);
        return;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramString2.openID));
    this.jdField_a_of_type_Bgdd.b();
  }
  
  public void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_Bgdd == null)) {
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    Object localObject;
    boolean bool;
    label72:
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        localObject = "null";
        if (localTroopInfo != null) {
          break label238;
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
          akln.b((List)localObject, localTroopInfo);
        }
      }
      if (localObject == null) {
        break label315;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.b.clear();
      paramList = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label272;
      }
      localObject = (TroopClipPic)paramList.next();
      if (((TroopClipPic)localObject).type == 1)
      {
        this.b.add(localObject);
        continue;
        localObject = Integer.valueOf(paramList.size());
        break;
        label238:
        bool = false;
        break label72;
      }
      localArrayList.add(akjf.a((TroopClipPic)localObject, null));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    label272:
    if (this.b.size() == 0)
    {
      paramList = new TroopClipPic();
      paramList.id = akjf.jdField_a_of_type_JavaLangString;
      paramList.type = 1;
      this.b.add(paramList);
    }
    label315:
    this.jdField_a_of_type_Bgdd.a(false, localArrayList);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (a() == null)) {}
    while (this.jdField_a_of_type_Aoep == null) {
      return;
    }
    aoep localaoep = this.jdField_a_of_type_Aoep;
    long l = anrb.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (!a().c)) {}
    for (boolean bool = true;; bool = false)
    {
      localaoep.a(l, bool, 0);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
  }
  
  protected void c()
  {
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      ThreadManager.post(new VisitorTroopCardPresenter.8(this), 5, null, false);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdy
 * JD-Core Version:    0.7.0.1
 */