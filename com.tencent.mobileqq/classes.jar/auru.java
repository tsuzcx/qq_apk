import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyProxy.5;
import com.tencent.mobileqq.nearby.NearbyProxy.6;
import com.tencent.mobileqq.nearby.NearbyProxy.9;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class auru
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  allj jdField_a_of_type_Allj;
  alln jdField_a_of_type_Alln;
  alsi jdField_a_of_type_Alsi = new aurw(this);
  alxx jdField_a_of_type_Alxx = new aurv(this);
  auqf jdField_a_of_type_Auqf;
  protected bcws a;
  bcxz jdField_a_of_type_Bcxz;
  bcya jdField_a_of_type_Bcya;
  public QQAppInterface a;
  public ArrayList<String> a;
  protected HashSet<String> a;
  List<auxg> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = -2147483648;
  List<auxg> jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public auru(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new NearbyProxy.9(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      ausq.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v6.0.recomm").delete();
    aush.a(paramString, "history_valid", Boolean.valueOf(false));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt2 == 3)
    {
      bool1 = bool2;
      if (paramInt1 == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Object[] a(int paramInt)
  {
    return ConnectNearbyProcService.a(paramInt);
  }
  
  private Object[] a(int paramInt, Object... paramVarArgs)
  {
    return ConnectNearbyProcService.a(paramInt, paramVarArgs);
  }
  
  public static void c()
  {
    if (ConnectNearbyProcService.a()) {
      ConnectNearbyProcService.a(4126);
    }
  }
  
  public Message a(Context arg1, Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    ??? = paramMessage.getData();
    Object localObject;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return null;
    case 4118: 
      if (??? == null) {
        return null;
      }
      ??? = a().a(???);
      paramMessage = Message.obtain();
      paramMessage.setData(???);
      return paramMessage;
    case 4133: 
      ??? = ???.getString("key");
      ??? = a(true).a(???);
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("setting", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4134: 
      ???.setClassLoader(Setting.class.getClassLoader());
      ??? = (Setting)???.getParcelable("setting");
      a(true).a(???);
      return null;
    case 4135: 
      paramMessage = ???.getStringArrayList("faceKeyList");
      long l = ???.getLong("faceTimestamp", 0L);
      a(true).a(paramMessage, l);
      return null;
    case 4137: 
      ??? = a(true).a();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4138: 
      ??? = a(true).b();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4143: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get dynamic_avatar_info.");
      }
      ??? = Message.obtain();
      paramMessage = paramMessage.getData();
      i = paramMessage.getInt("type");
      localObject = paramMessage.getString("id");
      localObject = ((anpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).b(i, (String)localObject);
      if (localObject == null) {
        return null;
      }
      Bundle localBundle = new Bundle();
      paramMessage.putParcelable("avatarInfo", (Parcelable)localObject);
      ???.setData(localBundle);
      return ???;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get face bitmap");
    }
    try
    {
      ??? = Message.obtain();
      localObject = paramMessage.getData();
      paramMessage = ((Bundle)localObject).getString("uin");
      i = ((Bundle)localObject).getInt("headType");
      ((Bundle)localObject).getBoolean("appendToTail");
      if (this.jdField_a_of_type_Bcws == null)
      {
        this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Bcws.a(new aury(this));
      }
      localObject = this.jdField_a_of_type_Bcws.a(i, paramMessage, 200);
      if (localObject == null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramMessage);
          this.jdField_a_of_type_Bcws.a(paramMessage, i, true);
          return null;
        }
      }
      paramMessage = new Bundle();
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyProxy", 2, "MSG_GET_FACE_BITMAP exception:" + ???);
      }
      return null;
    }
    paramMessage.putParcelable("faceBmp", (Parcelable)localObject);
    ???.setData(paramMessage);
    return ???;
  }
  
  public auqf a()
  {
    try
    {
      if (this.jdField_a_of_type_Auqf == null) {
        this.jdField_a_of_type_Auqf = new auqf();
      }
      auqf localauqf = this.jdField_a_of_type_Auqf;
      return localauqf;
    }
    finally {}
  }
  
  public bcxz a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bcxz == null) && (paramBoolean)) {
        this.jdField_a_of_type_Bcxz = new bcxz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bcxz localbcxz = this.jdField_a_of_type_Bcxz;
      return localbcxz;
    }
    finally {}
  }
  
  public bcya a()
  {
    try
    {
      if (this.jdField_a_of_type_Bcya == null) {
        this.jdField_a_of_type_Bcya = new bcya(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bcya localbcya = this.jdField_a_of_type_Bcya;
      return localbcya;
    }
    finally {}
  }
  
  public String a()
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelProfileSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131699196);
    }
    return localObject;
  }
  
  public String a(String paramString)
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioFirstTips;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = BaseApplication.getContext().getResources().getString(2131699046);
      }
      return ((String)localObject).replace("%", paramString);
      apds.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
    }
  }
  
  public void a()
  {
    a(4124, null);
  }
  
  public void a(int paramInt)
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ausq.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      aurt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      aurz localaurz = new aurz(this, paramInt);
      localaurz.a = true;
      a(localaurz);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    Object localObject;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (auxg)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new NearbyProxy.5(this, (auxg)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          auxg localauxg = (auxg)((Iterator)localObject).next();
          if ((localauxg != null) && (localauxg.a)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    finally {}
    localList = this.jdField_b_of_type_JavaUtilList;
    i = j;
    try
    {
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (auxg)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new NearbyProxy.6(this, (auxg)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (auxg)paramVarArgs.next();
          if ((localObject != null) && (((auxg)localObject).a)) {
            paramVarArgs.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "updateNearbyProfileCardRecord,tinyID = " + paramLong + ",visitDuration = " + paramInt1 + ",visitPicCount = " + paramInt2 + ",opflag = " + paramInt3 + "|" + Integer.toBinaryString(paramInt3));
    }
    a(4142, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(auxg paramauxg)
  {
    a(paramauxg, false);
  }
  
  public void a(auxg paramauxg, boolean paramBoolean)
  {
    if (paramauxg == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramauxg)) {
          this.jdField_b_of_type_JavaUtilList.add(paramauxg);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramauxg)) {
        this.jdField_a_of_type_JavaUtilList.add(paramauxg);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    auqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
    int i;
    if (paramCharmEvent != null) {
      i = paramCharmEvent.uint32_new_charm_level.get();
    }
    for (;;)
    {
      if (ConnectNearbyProcService.a())
      {
        if (paramNearbyRankConfig != null) {
          break label96;
        }
        paramString = null;
        label42:
        if (paramNearbyFeedConfig != null) {
          break label104;
        }
      }
      label96:
      label104:
      for (paramNearbyRankConfig = localObject;; paramNearbyRankConfig = paramNearbyFeedConfig.toByteArray())
      {
        a(4122, new Object[] { Integer.valueOf(i), paramString, paramNearbyRankConfig });
        return;
        if (paramNearbyCharmNotify == null) {
          break label112;
        }
        i = paramNearbyCharmNotify.uint32_new_charm_level.get();
        break;
        paramString = paramNearbyRankConfig.toByteArray();
        break label42;
      }
      label112:
      i = 0;
    }
  }
  
  public void a(cmd0x9c7.RspBody paramRspBody)
  {
    ausq.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
    if (paramRspBody == null) {}
    Object localObject1;
    awbw localawbw;
    do
    {
      return;
      if (paramRspBody.rpt_msg_tags.has()) {}
      for (paramRspBody = paramRspBody.rpt_msg_tags.get();; paramRspBody = null)
      {
        localObject1 = new ArrayList();
        if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
          break;
        }
        int i = 0;
        while (i < paramRspBody.size())
        {
          localObject2 = auwl.a((appoint_define.InterestTag)paramRspBody.get(i));
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
      }
      localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      Object localObject2 = (NearbyPeopleCard)localawbw.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramRspBody);
      if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
      {
        localawbw.b((awbv)localObject1);
        return;
      }
    } while ((((NearbyPeopleCard)localObject1).getStatus() != 1001) && (((NearbyPeopleCard)localObject1).getStatus() != 1002));
    localawbw.a((awbv)localObject1);
  }
  
  public void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {
      return;
    }
    if (paramAppointmentNotify.uint32_notifytype.get() == 6) {}
    for (boolean bool = b();; bool = true)
    {
      if (bool)
      {
        if (!ConnectNearbyProcService.a()) {
          break label97;
        }
        a(4101, new Object[] { paramAppointmentNotify.toByteArray() });
      }
      while (QLog.isColorLevel())
      {
        ausq.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        aurt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        ausa localausa = new ausa(this, paramAppointmentNotify);
        localausa.a = true;
        a(localausa);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    apds.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      aush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      i = 2;
    }
  }
  
  void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEventRuntime((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!aush.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label45;
      }
    }
    label45:
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public Object[] a(Context paramContext, int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload_2
    //   4: tableswitch	default:+288 -> 292, 4098:+350->354, 4099:+358->362, 4100:+288->292, 4101:+288->292, 4102:+366->370, 4103:+456->460, 4104:+417->421, 4105:+381->385, 4106:+288->292, 4107:+290->294, 4108:+1022->1026, 4109:+1080->1084, 4110:+682->686, 4111:+760->764, 4112:+826->830, 4113:+288->292, 4114:+288->292, 4115:+288->292, 4116:+288->292, 4117:+288->292, 4118:+288->292, 4119:+542->546, 4120:+572->576, 4121:+640->644, 4122:+868->872, 4123:+971->975, 4124:+288->292, 4125:+288->292, 4126:+288->292, 4127:+1064->1068, 4128:+1163->1167, 4129:+1219->1223, 4130:+1265->1269, 4131:+288->292, 4132:+1300->1304, 4133:+288->292, 4134:+288->292, 4135:+288->292, 4136:+288->292, 4137:+288->292, 4138:+288->292, 4139:+288->292, 4140:+288->292, 4141:+1318->1322, 4142:+1481->1485, 4143:+288->292, 4144:+288->292, 4145:+1536->1540, 4146:+288->292, 4147:+1606->1610, 4148:+288->292, 4149:+288->292, 4150:+288->292, 4151:+288->292, 4152:+288->292, 4153:+288->292, 4154:+288->292, 4155:+288->292, 4156:+1646->1650, 4157:+1715->1719, 4158:+1974->1978, 4159:+288->292, 4160:+288->292, 4161:+288->292, 4162:+288->292, 4163:+2002->2006, 4164:+288->292, 4165:+1909->1913
    //   293: areturn
    //   294: aload_3
    //   295: ifnull -3 -> 292
    //   298: aload_3
    //   299: arraylength
    //   300: iconst_3
    //   301: if_icmpne -9 -> 292
    //   304: iconst_1
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload_0
    //   311: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: bipush 71
    //   316: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   319: checkcast 662	apdq
    //   322: invokevirtual 665	apdq:a	()Lapeo;
    //   325: aload_3
    //   326: iconst_0
    //   327: aaload
    //   328: checkcast 403	java/lang/String
    //   331: aload_3
    //   332: iconst_1
    //   333: aaload
    //   334: checkcast 424	java/lang/Integer
    //   337: invokevirtual 648	java/lang/Integer:intValue	()I
    //   340: aload_3
    //   341: iconst_2
    //   342: aaload
    //   343: checkcast 159	java/lang/Boolean
    //   346: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   349: invokevirtual 673	apeo:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   352: aastore
    //   353: areturn
    //   354: aload_0
    //   355: iconst_0
    //   356: aload_3
    //   357: invokevirtual 675	auru:a	(Z[Ljava/lang/Object;)V
    //   360: aconst_null
    //   361: areturn
    //   362: aload_0
    //   363: iconst_1
    //   364: aload_3
    //   365: invokevirtual 675	auru:a	(Z[Ljava/lang/Object;)V
    //   368: aconst_null
    //   369: areturn
    //   370: new 677	com/tencent/mobileqq/nearby/NearbyProxy$1
    //   373: dup
    //   374: aload_0
    //   375: invokespecial 678	com/tencent/mobileqq/nearby/NearbyProxy$1:<init>	(Lauru;)V
    //   378: aconst_null
    //   379: iconst_1
    //   380: invokestatic 682	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   383: aconst_null
    //   384: areturn
    //   385: aload_3
    //   386: ifnull -94 -> 292
    //   389: iconst_1
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload_0
    //   396: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   399: bipush 36
    //   401: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   404: checkcast 684	axho
    //   407: aload_3
    //   408: iconst_0
    //   409: aaload
    //   410: checkcast 403	java/lang/String
    //   413: invokevirtual 687	axho:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   416: invokevirtual 690	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   419: aastore
    //   420: areturn
    //   421: aload_3
    //   422: ifnull -130 -> 292
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload_0
    //   432: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: bipush 36
    //   437: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   440: checkcast 684	axho
    //   443: aload_3
    //   444: iconst_0
    //   445: aaload
    //   446: checkcast 424	java/lang/Integer
    //   449: invokevirtual 648	java/lang/Integer:intValue	()I
    //   452: invokevirtual 693	axho:b	(I)Z
    //   455: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   458: aastore
    //   459: areturn
    //   460: aload_3
    //   461: ifnull -169 -> 292
    //   464: aload_3
    //   465: arraylength
    //   466: bipush 6
    //   468: if_icmplt +1597 -> 2065
    //   471: aload_3
    //   472: iconst_5
    //   473: aaload
    //   474: checkcast 159	java/lang/Boolean
    //   477: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   480: istore 4
    //   482: aload_0
    //   483: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   486: aload_3
    //   487: iconst_0
    //   488: aaload
    //   489: checkcast 424	java/lang/Integer
    //   492: invokevirtual 648	java/lang/Integer:intValue	()I
    //   495: aload_3
    //   496: iconst_1
    //   497: aaload
    //   498: checkcast 424	java/lang/Integer
    //   501: invokevirtual 648	java/lang/Integer:intValue	()I
    //   504: aload_3
    //   505: iconst_2
    //   506: aaload
    //   507: checkcast 403	java/lang/String
    //   510: aload_3
    //   511: iconst_3
    //   512: aaload
    //   513: checkcast 403	java/lang/String
    //   516: aload_3
    //   517: iconst_4
    //   518: aaload
    //   519: checkcast 159	java/lang/Boolean
    //   522: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   525: invokestatic 698	avpw:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   528: astore_1
    //   529: iload 4
    //   531: ifeq -239 -> 292
    //   534: iconst_1
    //   535: anewarray 4	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: aload_1
    //   541: invokevirtual 690	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   544: aastore
    //   545: areturn
    //   546: aload_3
    //   547: ifnull -255 -> 292
    //   550: aload_3
    //   551: iconst_0
    //   552: aaload
    //   553: checkcast 403	java/lang/String
    //   556: astore_1
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_0
    //   564: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: aload_1
    //   568: invokestatic 703	ajgm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   571: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   574: aastore
    //   575: areturn
    //   576: aload_3
    //   577: ifnull -285 -> 292
    //   580: aload_3
    //   581: iconst_0
    //   582: aaload
    //   583: checkcast 403	java/lang/String
    //   586: astore_1
    //   587: aload_3
    //   588: iconst_1
    //   589: aaload
    //   590: checkcast 403	java/lang/String
    //   593: astore 6
    //   595: aload_3
    //   596: iconst_2
    //   597: aaload
    //   598: checkcast 424	java/lang/Integer
    //   601: invokevirtual 648	java/lang/Integer:intValue	()I
    //   604: istore_2
    //   605: aload_3
    //   606: iconst_3
    //   607: aaload
    //   608: checkcast 159	java/lang/Boolean
    //   611: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   614: istore 4
    //   616: aload_3
    //   617: iconst_4
    //   618: aaload
    //   619: checkcast 159	java/lang/Boolean
    //   622: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   625: istore 5
    //   627: aload_0
    //   628: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   631: aload_1
    //   632: aload 6
    //   634: iload_2
    //   635: iload 4
    //   637: iload 5
    //   639: invokestatic 708	amfw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   642: aconst_null
    //   643: areturn
    //   644: aload_3
    //   645: ifnull -353 -> 292
    //   648: aload_3
    //   649: iconst_0
    //   650: aaload
    //   651: checkcast 403	java/lang/String
    //   654: astore_1
    //   655: aload_3
    //   656: iconst_1
    //   657: aaload
    //   658: checkcast 403	java/lang/String
    //   661: astore 6
    //   663: aload_3
    //   664: iconst_2
    //   665: aaload
    //   666: checkcast 424	java/lang/Integer
    //   669: invokevirtual 648	java/lang/Integer:intValue	()I
    //   672: istore_2
    //   673: aload_0
    //   674: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   677: aload_1
    //   678: aload 6
    //   680: iload_2
    //   681: invokestatic 711	amfw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   684: aconst_null
    //   685: areturn
    //   686: aload_3
    //   687: ifnull +9 -> 696
    //   690: aload_3
    //   691: arraylength
    //   692: iconst_2
    //   693: if_icmpge +15 -> 708
    //   696: iconst_1
    //   697: anewarray 4	java/lang/Object
    //   700: dup
    //   701: iconst_0
    //   702: iconst_0
    //   703: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   706: aastore
    //   707: areturn
    //   708: aload_0
    //   709: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   712: aload_0
    //   713: getfield 59	auru:jdField_a_of_type_Alsi	Lalsi;
    //   716: invokevirtual 715	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lalkr;)V
    //   719: aload_0
    //   720: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   723: iconst_0
    //   724: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   727: checkcast 720	com/tencent/mobileqq/app/MessageHandler
    //   730: aload_3
    //   731: iconst_0
    //   732: aaload
    //   733: checkcast 514	java/lang/Long
    //   736: invokevirtual 724	java/lang/Long:longValue	()J
    //   739: aload_3
    //   740: iconst_1
    //   741: aaload
    //   742: checkcast 424	java/lang/Integer
    //   745: invokevirtual 648	java/lang/Integer:intValue	()I
    //   748: iconst_1
    //   749: invokevirtual 727	com/tencent/mobileqq/app/MessageHandler:c	(JII)V
    //   752: iconst_1
    //   753: anewarray 4	java/lang/Object
    //   756: dup
    //   757: iconst_0
    //   758: iconst_1
    //   759: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   762: aastore
    //   763: areturn
    //   764: aload_3
    //   765: ifnull +9 -> 774
    //   768: aload_3
    //   769: arraylength
    //   770: iconst_1
    //   771: if_icmpge +15 -> 786
    //   774: iconst_1
    //   775: anewarray 4	java/lang/Object
    //   778: dup
    //   779: iconst_0
    //   780: iconst_0
    //   781: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   784: aastore
    //   785: areturn
    //   786: aload_0
    //   787: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   790: aload_0
    //   791: getfield 59	auru:jdField_a_of_type_Alsi	Lalsi;
    //   794: invokevirtual 715	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lalkr;)V
    //   797: aload_0
    //   798: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   801: iconst_0
    //   802: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   805: checkcast 720	com/tencent/mobileqq/app/MessageHandler
    //   808: aload_3
    //   809: iconst_0
    //   810: aaload
    //   811: checkcast 403	java/lang/String
    //   814: iconst_1
    //   815: invokevirtual 729	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/lang/String;I)V
    //   818: iconst_1
    //   819: anewarray 4	java/lang/Object
    //   822: dup
    //   823: iconst_0
    //   824: iconst_1
    //   825: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   828: aastore
    //   829: areturn
    //   830: aload_3
    //   831: ifnull -539 -> 292
    //   834: aload_3
    //   835: arraylength
    //   836: iconst_1
    //   837: if_icmplt -545 -> 292
    //   840: iconst_1
    //   841: anewarray 4	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: aload_0
    //   847: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   850: bipush 16
    //   852: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   855: checkcast 731	atvt
    //   858: aload_3
    //   859: iconst_0
    //   860: aaload
    //   861: checkcast 403	java/lang/String
    //   864: invokevirtual 733	atvt:a	(Ljava/lang/String;)Z
    //   867: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   870: aastore
    //   871: areturn
    //   872: aload_3
    //   873: ifnull -581 -> 292
    //   876: aload_3
    //   877: arraylength
    //   878: iconst_3
    //   879: if_icmplt -587 -> 292
    //   882: aload_3
    //   883: iconst_0
    //   884: aaload
    //   885: checkcast 403	java/lang/String
    //   888: astore 7
    //   890: aload_3
    //   891: iconst_1
    //   892: aaload
    //   893: ifnull +1166 -> 2059
    //   896: aload_3
    //   897: iconst_1
    //   898: aaload
    //   899: checkcast 735	[B
    //   902: checkcast 735	[B
    //   905: astore_1
    //   906: new 532	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   909: dup
    //   910: invokespecial 736	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   913: astore 6
    //   915: aload 6
    //   917: aload_1
    //   918: invokevirtual 740	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   921: pop
    //   922: aload_3
    //   923: iconst_2
    //   924: aaload
    //   925: ifnull +1129 -> 2054
    //   928: aload_3
    //   929: iconst_2
    //   930: aaload
    //   931: checkcast 735	[B
    //   934: checkcast 735	[B
    //   937: astore_3
    //   938: new 542	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   941: dup
    //   942: invokespecial 741	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   945: astore_1
    //   946: aload_1
    //   947: aload_3
    //   948: invokevirtual 742	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   951: pop
    //   952: aload_0
    //   953: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   956: aload 7
    //   958: aload 6
    //   960: aload_1
    //   961: invokestatic 530	auqc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   964: aconst_null
    //   965: areturn
    //   966: astore_1
    //   967: aconst_null
    //   968: astore_1
    //   969: aload_1
    //   970: astore 6
    //   972: goto -50 -> 922
    //   975: aload_3
    //   976: ifnull -684 -> 292
    //   979: aload_3
    //   980: arraylength
    //   981: iconst_1
    //   982: if_icmplt -690 -> 292
    //   985: aload_3
    //   986: iconst_0
    //   987: aaload
    //   988: checkcast 735	[B
    //   991: checkcast 735	[B
    //   994: astore_3
    //   995: new 562	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   998: dup
    //   999: invokespecial 743	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   1002: astore_1
    //   1003: aload_1
    //   1004: aload_3
    //   1005: invokevirtual 744	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1008: pop
    //   1009: aload_0
    //   1010: aload_1
    //   1011: invokevirtual 746	auru:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   1014: aconst_null
    //   1015: areturn
    //   1016: astore_3
    //   1017: aconst_null
    //   1018: astore_1
    //   1019: aload_3
    //   1020: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   1023: goto -14 -> 1009
    //   1026: aload_3
    //   1027: ifnull -735 -> 292
    //   1030: aload_3
    //   1031: arraylength
    //   1032: iconst_1
    //   1033: if_icmplt -741 -> 292
    //   1036: aload_3
    //   1037: iconst_0
    //   1038: aaload
    //   1039: instanceof 751
    //   1042: ifeq -750 -> 292
    //   1045: aload_3
    //   1046: iconst_0
    //   1047: aaload
    //   1048: checkcast 751	java/lang/Byte
    //   1051: invokevirtual 755	java/lang/Byte:byteValue	()B
    //   1054: ifne +6 -> 1060
    //   1057: iconst_1
    //   1058: istore 4
    //   1060: aload_0
    //   1061: iload 4
    //   1063: invokevirtual 757	auru:a	(Z)V
    //   1066: aconst_null
    //   1067: areturn
    //   1068: aload_0
    //   1069: getfield 358	auru:jdField_a_of_type_Auqf	Lauqf;
    //   1072: ifnull -780 -> 292
    //   1075: aload_0
    //   1076: getfield 358	auru:jdField_a_of_type_Auqf	Lauqf;
    //   1079: invokevirtual 759	auqf:a	()V
    //   1082: aconst_null
    //   1083: areturn
    //   1084: aload_3
    //   1085: ifnull -793 -> 292
    //   1088: aload_3
    //   1089: arraylength
    //   1090: iconst_1
    //   1091: if_icmpne -799 -> 292
    //   1094: aload_3
    //   1095: iconst_0
    //   1096: aaload
    //   1097: instanceof 735
    //   1100: ifeq -808 -> 292
    //   1103: aload_3
    //   1104: iconst_0
    //   1105: aaload
    //   1106: checkcast 735	[B
    //   1109: checkcast 735	[B
    //   1112: astore_3
    //   1113: aload_3
    //   1114: ifnull -822 -> 292
    //   1117: aload_3
    //   1118: arraylength
    //   1119: ifle -827 -> 292
    //   1122: new 761	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo
    //   1125: dup
    //   1126: invokespecial 762	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:<init>	()V
    //   1129: astore_1
    //   1130: aload_1
    //   1131: aload_3
    //   1132: invokevirtual 763	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1135: pop
    //   1136: aload_0
    //   1137: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1140: bipush 106
    //   1142: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1145: checkcast 527	auqc
    //   1148: astore_3
    //   1149: aload_3
    //   1150: ifnull -858 -> 292
    //   1153: aload_3
    //   1154: aload_1
    //   1155: invokevirtual 766	auqc:a	(Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;)V
    //   1158: aconst_null
    //   1159: areturn
    //   1160: astore_1
    //   1161: aload_1
    //   1162: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   1165: aconst_null
    //   1166: areturn
    //   1167: aload_0
    //   1168: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1171: ifnonnull +19 -> 1190
    //   1174: aload_0
    //   1175: aload_0
    //   1176: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1179: bipush 59
    //   1181: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1184: checkcast 770	allj
    //   1187: putfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1190: aload_0
    //   1191: new 772	aurx
    //   1194: dup
    //   1195: aload_0
    //   1196: invokespecial 773	aurx:<init>	(Lauru;)V
    //   1199: putfield 775	auru:jdField_a_of_type_Alln	Lalln;
    //   1202: aload_0
    //   1203: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1206: aload_0
    //   1207: invokevirtual 778	allj:a	(Ljava/lang/Object;)V
    //   1210: aload_0
    //   1211: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1214: aload_0
    //   1215: getfield 775	auru:jdField_a_of_type_Alln	Lalln;
    //   1218: invokevirtual 780	allj:c	(Ljava/lang/Object;)V
    //   1221: aconst_null
    //   1222: areturn
    //   1223: aload_3
    //   1224: ifnull -932 -> 292
    //   1227: aload_3
    //   1228: arraylength
    //   1229: iconst_1
    //   1230: if_icmpne -938 -> 292
    //   1233: aload_3
    //   1234: iconst_0
    //   1235: aaload
    //   1236: checkcast 403	java/lang/String
    //   1239: astore_1
    //   1240: aload_0
    //   1241: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1244: ifnull +25 -> 1269
    //   1247: iconst_1
    //   1248: anewarray 4	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: aload_0
    //   1254: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1257: aload_1
    //   1258: ldc_w 782
    //   1261: invokevirtual 786	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1264: invokevirtual 789	allj:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1267: aastore
    //   1268: areturn
    //   1269: aload_0
    //   1270: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1273: ifnull -981 -> 292
    //   1276: aload_0
    //   1277: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1280: aload_0
    //   1281: invokevirtual 791	allj:b	(Ljava/lang/Object;)V
    //   1284: aload_0
    //   1285: getfield 775	auru:jdField_a_of_type_Alln	Lalln;
    //   1288: ifnull -996 -> 292
    //   1291: aload_0
    //   1292: getfield 768	auru:jdField_a_of_type_Allj	Lallj;
    //   1295: aload_0
    //   1296: getfield 775	auru:jdField_a_of_type_Alln	Lalln;
    //   1299: invokevirtual 793	allj:d	(Ljava/lang/Object;)V
    //   1302: aconst_null
    //   1303: areturn
    //   1304: aload_0
    //   1305: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1308: bipush 106
    //   1310: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1313: checkcast 527	auqc
    //   1316: iconst_1
    //   1317: putfield 794	auqc:a	Z
    //   1320: aconst_null
    //   1321: areturn
    //   1322: aload_3
    //   1323: ifnull -1031 -> 292
    //   1326: aload_3
    //   1327: arraylength
    //   1328: iconst_1
    //   1329: if_icmpne -1037 -> 292
    //   1332: aload_0
    //   1333: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1336: sipush 160
    //   1339: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1342: checkcast 796	avod
    //   1345: aload_3
    //   1346: iconst_0
    //   1347: aaload
    //   1348: checkcast 424	java/lang/Integer
    //   1351: invokevirtual 648	java/lang/Integer:intValue	()I
    //   1354: invokevirtual 799	avod:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1357: astore_1
    //   1358: aload_1
    //   1359: ifnull -1067 -> 292
    //   1362: bipush 12
    //   1364: anewarray 4	java/lang/Object
    //   1367: dup
    //   1368: iconst_0
    //   1369: aload_1
    //   1370: getfield 804	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1373: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1376: aastore
    //   1377: dup
    //   1378: iconst_1
    //   1379: aload_1
    //   1380: getfield 807	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1383: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1386: aastore
    //   1387: dup
    //   1388: iconst_2
    //   1389: aload_1
    //   1390: getfield 810	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1393: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1396: aastore
    //   1397: dup
    //   1398: iconst_3
    //   1399: aload_1
    //   1400: getfield 813	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1403: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1406: aastore
    //   1407: dup
    //   1408: iconst_4
    //   1409: aload_1
    //   1410: getfield 816	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1413: aastore
    //   1414: dup
    //   1415: iconst_5
    //   1416: aload_1
    //   1417: getfield 819	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1420: aastore
    //   1421: dup
    //   1422: bipush 6
    //   1424: aload_1
    //   1425: getfield 822	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1428: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1431: aastore
    //   1432: dup
    //   1433: bipush 7
    //   1435: aload_1
    //   1436: getfield 825	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1439: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1442: aastore
    //   1443: dup
    //   1444: bipush 8
    //   1446: aload_1
    //   1447: getfield 828	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1450: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1453: aastore
    //   1454: dup
    //   1455: bipush 9
    //   1457: aload_1
    //   1458: getfield 831	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1461: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1464: aastore
    //   1465: dup
    //   1466: bipush 10
    //   1468: aload_1
    //   1469: getfield 834	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1472: aastore
    //   1473: dup
    //   1474: bipush 11
    //   1476: aload_1
    //   1477: getfield 837	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:isClosed	Z
    //   1480: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1483: aastore
    //   1484: areturn
    //   1485: aload_3
    //   1486: ifnull -1194 -> 292
    //   1489: aload_3
    //   1490: arraylength
    //   1491: iconst_1
    //   1492: if_icmpne -1200 -> 292
    //   1495: aload_3
    //   1496: iconst_0
    //   1497: aaload
    //   1498: checkcast 735	[B
    //   1501: checkcast 735	[B
    //   1504: astore_1
    //   1505: aload_0
    //   1506: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1509: sipush 180
    //   1512: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1515: checkcast 303	anpx
    //   1518: aload_1
    //   1519: invokevirtual 840	anpx:a	([B)V
    //   1522: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq -1233 -> 292
    //   1528: ldc_w 281
    //   1531: iconst_2
    //   1532: ldc_w 842
    //   1535: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1538: aconst_null
    //   1539: areturn
    //   1540: aload_3
    //   1541: ifnull -1249 -> 292
    //   1544: aload_3
    //   1545: iconst_0
    //   1546: aaload
    //   1547: checkcast 403	java/lang/String
    //   1550: astore_1
    //   1551: aload_0
    //   1552: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1555: bipush 106
    //   1557: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1560: checkcast 527	auqc
    //   1563: getfield 845	auqc:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   1566: aload_1
    //   1567: iconst_1
    //   1568: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1571: invokevirtual 851	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1574: pop
    //   1575: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1578: ifeq -1286 -> 292
    //   1581: ldc_w 853
    //   1584: iconst_2
    //   1585: new 105	java/lang/StringBuilder
    //   1588: dup
    //   1589: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1592: ldc_w 855
    //   1595: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: aload_1
    //   1599: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1608: aconst_null
    //   1609: areturn
    //   1610: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1613: ifeq +13 -> 1626
    //   1616: ldc_w 345
    //   1619: iconst_2
    //   1620: ldc_w 857
    //   1623: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1626: new 859	android/os/Handler
    //   1629: dup
    //   1630: invokestatic 865	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1633: invokespecial 868	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1636: new 870	com/tencent/mobileqq/nearby/NearbyProxy$3
    //   1639: dup
    //   1640: aload_0
    //   1641: invokespecial 871	com/tencent/mobileqq/nearby/NearbyProxy$3:<init>	(Lauru;)V
    //   1644: invokevirtual 872	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1647: pop
    //   1648: aconst_null
    //   1649: areturn
    //   1650: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1653: ifeq +13 -> 1666
    //   1656: ldc_w 345
    //   1659: iconst_2
    //   1660: ldc_w 874
    //   1663: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1666: aload_0
    //   1667: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1670: bipush 51
    //   1672: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1675: checkcast 876	aloz
    //   1678: astore_1
    //   1679: aload_1
    //   1680: ifnonnull +24 -> 1704
    //   1683: aconst_null
    //   1684: astore_1
    //   1685: aload_1
    //   1686: ifnull -1394 -> 292
    //   1689: iconst_1
    //   1690: anewarray 4	java/lang/Object
    //   1693: dup
    //   1694: iconst_0
    //   1695: aload_1
    //   1696: getfield 882	com/tencent/mobileqq/data/Card:shGender	S
    //   1699: invokestatic 887	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   1702: aastore
    //   1703: areturn
    //   1704: aload_1
    //   1705: aload_0
    //   1706: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1709: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1712: invokevirtual 890	aloz:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1715: astore_1
    //   1716: goto -31 -> 1685
    //   1719: aload_3
    //   1720: iconst_0
    //   1721: aaload
    //   1722: checkcast 424	java/lang/Integer
    //   1725: astore_1
    //   1726: aload_0
    //   1727: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1730: bipush 70
    //   1732: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1735: checkcast 892	nan
    //   1738: astore_3
    //   1739: aload_1
    //   1740: invokevirtual 648	java/lang/Integer:intValue	()I
    //   1743: tableswitch	default:+61 -> 1804, 1:+84->1827, 2:+92->1835, 3:+110->1853, 4:+61->1804, 5:+118->1861, 6:+79->1822, 7:+100->1843, 8:+105->1848, 9:+141->1884, 10:+149->1892, 11:+157->1900, 12:+162->1905
    //   1805: astore_1
    //   1806: aload_1
    //   1807: ifnull -1515 -> 292
    //   1810: iconst_1
    //   1811: anewarray 4	java/lang/Object
    //   1814: dup
    //   1815: iconst_0
    //   1816: aload_1
    //   1817: invokevirtual 895	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:toByteArray	()[B
    //   1820: aastore
    //   1821: areturn
    //   1822: aconst_null
    //   1823: astore_1
    //   1824: goto -18 -> 1806
    //   1827: aload_3
    //   1828: invokevirtual 898	nan:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1831: astore_1
    //   1832: goto -26 -> 1806
    //   1835: aload_3
    //   1836: invokevirtual 900	nan:b	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1839: astore_1
    //   1840: goto -34 -> 1806
    //   1843: aconst_null
    //   1844: astore_1
    //   1845: goto -39 -> 1806
    //   1848: aconst_null
    //   1849: astore_1
    //   1850: goto -44 -> 1806
    //   1853: aload_3
    //   1854: invokevirtual 902	nan:c	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1857: astore_1
    //   1858: goto -52 -> 1806
    //   1861: aload_3
    //   1862: invokevirtual 903	nan:a	()Z
    //   1865: ifeq +14 -> 1879
    //   1868: new 894	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1871: dup
    //   1872: invokespecial 904	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   1875: astore_1
    //   1876: goto -70 -> 1806
    //   1879: aconst_null
    //   1880: astore_1
    //   1881: goto -75 -> 1806
    //   1884: aload_3
    //   1885: invokevirtual 907	nan:j	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1888: astore_1
    //   1889: goto -83 -> 1806
    //   1892: aload_3
    //   1893: invokevirtual 909	nan:i	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1896: astore_1
    //   1897: goto -91 -> 1806
    //   1900: aconst_null
    //   1901: astore_1
    //   1902: goto -96 -> 1806
    //   1905: aload_3
    //   1906: invokevirtual 911	nan:e	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1909: astore_1
    //   1910: goto -104 -> 1806
    //   1913: aload_0
    //   1914: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1917: bipush 70
    //   1919: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1922: checkcast 892	nan
    //   1925: invokevirtual 914	nan:a	()Lavoi;
    //   1928: astore_1
    //   1929: aload_1
    //   1930: ifnull -1638 -> 292
    //   1933: iconst_4
    //   1934: anewarray 4	java/lang/Object
    //   1937: dup
    //   1938: iconst_0
    //   1939: aload_1
    //   1940: getfield 917	avoi:jdField_a_of_type_Int	I
    //   1943: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1946: aastore
    //   1947: dup
    //   1948: iconst_1
    //   1949: aload_1
    //   1950: getfield 918	avoi:jdField_b_of_type_Int	I
    //   1953: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1956: aastore
    //   1957: dup
    //   1958: iconst_2
    //   1959: aload_1
    //   1960: getfield 920	avoi:c	I
    //   1963: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1966: aastore
    //   1967: dup
    //   1968: iconst_3
    //   1969: aload_1
    //   1970: getfield 922	avoi:d	I
    //   1973: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1976: aastore
    //   1977: areturn
    //   1978: aload_3
    //   1979: iconst_0
    //   1980: aaload
    //   1981: checkcast 424	java/lang/Integer
    //   1984: astore_1
    //   1985: aload_0
    //   1986: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1989: bipush 70
    //   1991: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1994: checkcast 892	nan
    //   1997: aload_1
    //   1998: invokevirtual 648	java/lang/Integer:intValue	()I
    //   2001: invokevirtual 924	nan:a	(I)V
    //   2004: aconst_null
    //   2005: areturn
    //   2006: aload_3
    //   2007: iconst_0
    //   2008: aaload
    //   2009: checkcast 403	java/lang/String
    //   2012: astore_1
    //   2013: iconst_1
    //   2014: anewarray 4	java/lang/Object
    //   2017: dup
    //   2018: iconst_0
    //   2019: aload_0
    //   2020: getfield 61	auru:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2023: aload_1
    //   2024: iconst_0
    //   2025: invokestatic 929	com/tencent/mobileqq/dating/MsgBoxListActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)I
    //   2028: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2031: aastore
    //   2032: areturn
    //   2033: astore_3
    //   2034: goto -1015 -> 1019
    //   2037: astore_1
    //   2038: aconst_null
    //   2039: astore_1
    //   2040: goto -1088 -> 952
    //   2043: astore_3
    //   2044: goto -1092 -> 952
    //   2047: astore_1
    //   2048: aload 6
    //   2050: astore_1
    //   2051: goto -1082 -> 969
    //   2054: aconst_null
    //   2055: astore_1
    //   2056: goto -1104 -> 952
    //   2059: aconst_null
    //   2060: astore 6
    //   2062: goto -1140 -> 922
    //   2065: iconst_0
    //   2066: istore 4
    //   2068: goto -1586 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2071	0	this	auru
    //   0	2071	1	paramContext	Context
    //   0	2071	2	paramInt	int
    //   0	2071	3	paramVarArgs	Object[]
    //   1	2066	4	bool1	boolean
    //   625	13	5	bool2	boolean
    //   593	1468	6	localObject	Object
    //   888	69	7	str	String
    // Exception table:
    //   from	to	target	type
    //   896	915	966	java/lang/Throwable
    //   985	1003	1016	java/lang/Exception
    //   1122	1149	1160	java/lang/Exception
    //   1153	1158	1160	java/lang/Exception
    //   1003	1009	2033	java/lang/Exception
    //   928	946	2037	java/lang/Throwable
    //   946	952	2043	java/lang/Throwable
    //   915	922	2047	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ausq.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      ausd localausd = (ausd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
      if (localausd != null) {
        localausd.a();
      }
    }
  }
  
  public void b(int paramInt)
  {
    a(4164, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Int == -2147483648) {
      if (!aush.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void d()
  {
    a(4140);
  }
  
  public void e()
  {
    a(4159);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auru
 * JD-Core Version:    0.7.0.1
 */