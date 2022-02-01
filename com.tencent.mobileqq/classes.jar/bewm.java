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
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class bewm
{
  public int a;
  private anca jdField_a_of_type_Anca;
  private andd jdField_a_of_type_Andd = new bewr(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bevu jdField_a_of_type_Bevu;
  public bezd a;
  private bfai jdField_a_of_type_Bfai;
  private TroopPhotoController.OnGotoBigPicListener jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener = new bewp(this);
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new bewo(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopClipPic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new bewq(this);
  protected npj a;
  private boolean jdField_a_of_type_Boolean;
  private List<TroopClipPic> b = new ArrayList();
  
  public bewm()
  {
    this.jdField_a_of_type_Npj = new bewn(this);
    this.jdField_a_of_type_Bezd = new bews(this);
  }
  
  private FragmentActivity a()
  {
    if (this.jdField_a_of_type_Bevu != null) {
      return ((VisitorTroopCardFragment)this.jdField_a_of_type_Bevu).getActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment a()
  {
    if (this.jdField_a_of_type_Bevu != null) {
      return (VisitorTroopCardFragment)this.jdField_a_of_type_Bevu;
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
    //   96: goto +869 -> 965
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
    //   148: goto +817 -> 965
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
    //   173: invokespecial 84	bewm:a	()Landroid/support/v4/app/FragmentActivity;
    //   176: ifnull +696 -> 872
    //   179: aload_0
    //   180: getfield 76	bewm:jdField_a_of_type_Bevu	Lbevu;
    //   183: aload_0
    //   184: invokespecial 84	bewm:a	()Landroid/support/v4/app/FragmentActivity;
    //   187: ldc 182
    //   189: invokevirtual 188	android/support/v4/app/FragmentActivity:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 193 2 0
    //   197: goto -70 -> 127
    //   200: iload 4
    //   202: ifne +642 -> 844
    //   205: aload 8
    //   207: getfield 197	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   210: invokevirtual 200	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   213: ifeq +631 -> 844
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
    //   239: getfield 76	bewm:jdField_a_of_type_Bevu	Lbevu;
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
    //   336: getfield 98	bewm:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   339: getfield 234	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: invokespecial 95	bewm:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   349: ifnull +526 -> 875
    //   352: aload_0
    //   353: invokespecial 95	bewm:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   356: getfield 237	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:c	Z
    //   359: ifeq +516 -> 875
    //   362: aload_0
    //   363: invokespecial 95	bewm:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   366: ifnull +31 -> 397
    //   369: aload_0
    //   370: invokespecial 95	bewm:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   373: getfield 240	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   376: ifnull +21 -> 397
    //   379: aload_0
    //   380: invokespecial 95	bewm:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
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
    //   477: ifne +483 -> 960
    //   480: aload 8
    //   482: getfield 266	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   485: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   488: astore_1
    //   489: aload 8
    //   491: getfield 272	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   494: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   497: ifne +457 -> 954
    //   500: aload 8
    //   502: getfield 272	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   505: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   508: astore 7
    //   510: aload_0
    //   511: getfield 91	bewm:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   514: bipush 52
    //   516: invokevirtual 278	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   519: checkcast 280	com/tencent/mobileqq/app/TroopManager
    //   522: astore 9
    //   524: aload 8
    //   526: getfield 260	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   529: invokevirtual 283	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   532: lstore 5
    //   534: aload 9
    //   536: lload 5
    //   538: invokestatic 289	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   541: invokevirtual 292	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   544: astore 10
    //   546: aload 10
    //   548: ifnull -537 -> 11
    //   551: aload_1
    //   552: ifnull +70 -> 622
    //   555: aload 10
    //   557: aload_1
    //   558: aload 7
    //   560: invokevirtual 298	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   563: aload 8
    //   565: getfield 301	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   568: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   571: ifeq +341 -> 912
    //   574: aload 8
    //   576: getfield 301	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   579: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   582: istore_2
    //   583: aload 10
    //   585: iload_2
    //   586: i2l
    //   587: putfield 306	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   590: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   593: ifeq +29 -> 622
    //   596: ldc 247
    //   598: iconst_2
    //   599: new 308	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 311
    //   609: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: iload_2
    //   613: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   616: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: aload 10
    //   624: aload 8
    //   626: getfield 322	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   629: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   632: invokevirtual 325	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   635: putfield 328	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   638: aload 10
    //   640: aload 8
    //   642: getfield 331	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   645: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   648: invokevirtual 325	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   651: putfield 334	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   654: aload 8
    //   656: getfield 337	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   659: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   662: ifeq +287 -> 949
    //   665: aload 10
    //   667: aload 8
    //   669: getfield 337	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   672: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   675: i2b
    //   676: putfield 341	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   679: aload 10
    //   681: getfield 341	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   684: istore_2
    //   685: aload 8
    //   687: getfield 344	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   690: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   693: ifeq +251 -> 944
    //   696: aload 10
    //   698: aload 8
    //   700: getfield 344	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   703: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   706: i2b
    //   707: putfield 347	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   710: aload 10
    //   712: getfield 347	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   715: istore_3
    //   716: aload 8
    //   718: getfield 350	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   721: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   724: ifeq +214 -> 938
    //   727: aload 10
    //   729: aload 8
    //   731: getfield 350	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   734: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   737: i2b
    //   738: putfield 353	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   741: aload 10
    //   743: getfield 353	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   746: istore 4
    //   748: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq +55 -> 806
    //   754: ldc 247
    //   756: iconst_2
    //   757: new 308	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   764: lload 5
    //   766: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   769: ldc_w 358
    //   772: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: iload_2
    //   776: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   779: ldc_w 360
    //   782: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: iload_3
    //   786: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   789: ldc_w 362
    //   792: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: iload 4
    //   797: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: new 364	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7
    //   809: dup
    //   810: aload_0
    //   811: aload 9
    //   813: aload 10
    //   815: invokespecial 367	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7:<init>	(Lbewm;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   818: bipush 8
    //   820: aconst_null
    //   821: iconst_0
    //   822: invokestatic 373	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   825: return
    //   826: astore_1
    //   827: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -819 -> 11
    //   833: ldc 247
    //   835: iconst_2
    //   836: aload_1
    //   837: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokestatic 376	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: return
    //   844: ldc_w 378
    //   847: iconst_1
    //   848: new 308	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 380
    //   858: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: iload 4
    //   863: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   866: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 376	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: goto -745 -> 127
    //   875: aload_0
    //   876: aload 8
    //   878: getfield 228	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   881: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   884: invokespecial 381	bewm:a	(Ljava/util/List;)V
    //   887: goto -490 -> 397
    //   890: astore 7
    //   892: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq -498 -> 397
    //   898: ldc 213
    //   900: iconst_2
    //   901: aload 7
    //   903: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   906: invokestatic 221	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   909: goto -512 -> 397
    //   912: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   915: ifeq -293 -> 622
    //   918: ldc 247
    //   920: iconst_2
    //   921: ldc_w 383
    //   924: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: goto -305 -> 622
    //   930: astore_1
    //   931: aload_1
    //   932: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   935: goto -281 -> 654
    //   938: iconst_m1
    //   939: istore 4
    //   941: goto -193 -> 748
    //   944: iconst_m1
    //   945: istore_3
    //   946: goto -230 -> 716
    //   949: iconst_m1
    //   950: istore_2
    //   951: goto -266 -> 685
    //   954: aconst_null
    //   955: astore 7
    //   957: goto -447 -> 510
    //   960: aconst_null
    //   961: astore_1
    //   962: goto -473 -> 489
    //   965: iconst_0
    //   966: istore_3
    //   967: aconst_null
    //   968: astore 7
    //   970: goto -871 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	973	0	this	bewm
    //   0	973	1	paramBatchResponse	KQQ.BatchResponse
    //   95	856	2	i	int
    //   104	863	3	j	int
    //   159	781	4	k	int
    //   532	233	5	l	long
    //   60	192	7	localObject1	Object
    //   256	12	7	localException1	Exception
    //   305	254	7	localObject2	Object
    //   890	12	7	localException2	Exception
    //   955	14	7	localObject3	Object
    //   69	808	8	localObject4	Object
    //   19	793	9	localObject5	Object
    //   87	727	10	localObject6	Object
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
    //   844	872	256	java/lang/Exception
    //   442	489	826	java/lang/Exception
    //   489	510	826	java/lang/Exception
    //   510	546	826	java/lang/Exception
    //   555	622	826	java/lang/Exception
    //   654	685	826	java/lang/Exception
    //   685	716	826	java/lang/Exception
    //   716	748	826	java/lang/Exception
    //   748	806	826	java/lang/Exception
    //   806	825	826	java/lang/Exception
    //   912	927	826	java/lang/Exception
    //   931	935	826	java/lang/Exception
    //   307	362	890	java/lang/Exception
    //   362	397	890	java/lang/Exception
    //   875	887	890	java/lang/Exception
    //   622	654	930	java/lang/Exception
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
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
      } else if (((bfdm)localObject2).b(str)) {
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
        break label418;
      }
      localObject1 = TroopUtils.saveMemberUinStringToDB(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label418;
      }
      a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject1);
      localanca.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
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
    label418:
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
    this.jdField_a_of_type_Bezd = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Npj);
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
      paramString = bfvo.a();
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
    this.jdField_a_of_type_Anca = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.onDestroy();
    }
    if (this.jdField_a_of_type_Bfai != null)
    {
      this.jdField_a_of_type_Bfai.b(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_Bfai.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
    this.jdField_a_of_type_Bevu = null;
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
  
  public void a(bevu parambevu)
  {
    this.jdField_a_of_type_Bevu = parambevu;
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    this.jdField_a_of_type_Anca = ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Bfai = new bfai(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bfeb.class, this.jdField_a_of_type_Anca);
    this.jdField_a_of_type_Bfai.a(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new ajpw(a(), a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    e();
    g();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfai != null) {
      this.jdField_a_of_type_Bfai.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Bevu == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      anca localanca;
      do
      {
        return;
        localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
      } while (localanca == null);
      try
      {
        long l = Long.parseLong(paramString);
        this.jdField_a_of_type_Bevu.c();
        localanca.a(l, paramInt);
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
          this.jdField_a_of_type_Bevu.b();
          return;
        }
      } while (TextUtils.isEmpty(paramString2));
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString1);
      if (paramString2 == null)
      {
        this.jdField_a_of_type_Bevu.c();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Npj);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().d(paramString1);
        return;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramString2.openID));
    this.jdField_a_of_type_Bevu.b();
  }
  
  public void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_Bevu == null)) {
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
          ajpz.b((List)localObject, localTroopInfo);
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
      localArrayList.add(ajnr.a((TroopClipPic)localObject, null));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    label271:
    if (this.b.size() == 0)
    {
      paramList = new TroopClipPic();
      paramList.id = ajnr.jdField_a_of_type_JavaLangString;
      paramList.type = 1;
      this.b.add(paramList);
    }
    label314:
    this.jdField_a_of_type_Bevu.a(false, localArrayList);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (a() == null)) {}
    while (this.jdField_a_of_type_Anca == null) {
      return;
    }
    anca localanca = this.jdField_a_of_type_Anca;
    long l = amoo.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (!a().c)) {}
    for (boolean bool = true;; bool = false)
    {
      localanca.a(l, bool, 0);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
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
 * Qualified Name:     bewm
 * JD-Core Version:    0.7.0.1
 */