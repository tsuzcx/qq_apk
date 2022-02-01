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
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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

public class axwf
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  anve jdField_a_of_type_Anve;
  anvi jdField_a_of_type_Anvi;
  aocj jdField_a_of_type_Aocj = new axwh(this);
  aohi jdField_a_of_type_Aohi = new axwg(this);
  protected aoof a;
  axus jdField_a_of_type_Axus;
  bhhg jdField_a_of_type_Bhhg;
  bhhh jdField_a_of_type_Bhhh;
  public QQAppInterface a;
  public ArrayList<String> a;
  protected HashSet<String> a;
  List<aybr> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = -2147483648;
  List<aybr> jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public axwf(QQAppInterface paramQQAppInterface)
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
      axxb.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v6.0.recomm").delete();
    axws.a(paramString, "history_valid", Boolean.valueOf(false));
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
      localObject = ((aqib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).b(i, (String)localObject);
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
      if (this.jdField_a_of_type_Aoof == null)
      {
        this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aoof.a(new axwj(this));
      }
      localObject = this.jdField_a_of_type_Aoof.a(i, paramMessage, 200);
      if (localObject == null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramMessage);
          this.jdField_a_of_type_Aoof.a(paramMessage, i, true);
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
  
  public axus a()
  {
    try
    {
      if (this.jdField_a_of_type_Axus == null) {
        this.jdField_a_of_type_Axus = new axus();
      }
      axus localaxus = this.jdField_a_of_type_Axus;
      return localaxus;
    }
    finally {}
  }
  
  public bhhg a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bhhg == null) && (paramBoolean)) {
        this.jdField_a_of_type_Bhhg = new bhhg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bhhg localbhhg = this.jdField_a_of_type_Bhhg;
      return localbhhg;
    }
    finally {}
  }
  
  public bhhh a()
  {
    try
    {
      if (this.jdField_a_of_type_Bhhh == null) {
        this.jdField_a_of_type_Bhhh = new bhhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bhhh localbhhh = this.jdField_a_of_type_Bhhh;
      return localbhhh;
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
      localObject = BaseApplication.getContext().getResources().getString(2131697955);
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
        localObject = BaseApplication.getContext().getResources().getString(2131697943);
      }
      return ((String)localObject).replace("%", paramString);
      asam.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
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
        axxb.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      axwe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      axwk localaxwk = new axwk(this, paramInt);
      localaxwk.a = true;
      a(localaxwk);
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
        localObject = (aybr)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new NearbyProxy.5(this, (aybr)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          aybr localaybr = (aybr)((Iterator)localObject).next();
          if ((localaybr != null) && (localaybr.a)) {
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
        localObject = (aybr)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new NearbyProxy.6(this, (aybr)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (aybr)paramVarArgs.next();
          if ((localObject != null) && (((aybr)localObject).a)) {
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
  
  public void a(aybr paramaybr)
  {
    a(paramaybr, false);
  }
  
  public void a(aybr paramaybr, boolean paramBoolean)
  {
    if (paramaybr == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramaybr)) {
          this.jdField_b_of_type_JavaUtilList.add(paramaybr);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramaybr)) {
        this.jdField_a_of_type_JavaUtilList.add(paramaybr);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    axup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
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
    axxb.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
    if (paramRspBody == null) {}
    Object localObject1;
    EntityManager localEntityManager;
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
          localObject2 = ayaw.a((appoint_define.InterestTag)paramRspBody.get(i));
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      Object localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramRspBody);
      if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
      {
        localEntityManager.persistOrReplace((Entity)localObject1);
        return;
      }
    } while ((((NearbyPeopleCard)localObject1).getStatus() != 1001) && (((NearbyPeopleCard)localObject1).getStatus() != 1002));
    localEntityManager.update((Entity)localObject1);
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
        axxb.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        axwe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        axwl localaxwl = new axwl(this, paramAppointmentNotify);
        localaxwl.a = true;
        a(localaxwl);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    asam.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      axws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
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
      if (!axws.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    //   4: tableswitch	default:+296 -> 300, 4098:+358->362, 4099:+366->370, 4100:+296->300, 4101:+296->300, 4102:+374->378, 4103:+464->468, 4104:+425->429, 4105:+389->393, 4106:+296->300, 4107:+298->302, 4108:+1030->1034, 4109:+1088->1092, 4110:+690->694, 4111:+768->772, 4112:+834->838, 4113:+296->300, 4114:+296->300, 4115:+296->300, 4116:+296->300, 4117:+296->300, 4118:+296->300, 4119:+550->554, 4120:+580->584, 4121:+648->652, 4122:+876->880, 4123:+979->983, 4124:+296->300, 4125:+296->300, 4126:+296->300, 4127:+1072->1076, 4128:+1171->1175, 4129:+1227->1231, 4130:+1273->1277, 4131:+296->300, 4132:+1308->1312, 4133:+296->300, 4134:+296->300, 4135:+296->300, 4136:+296->300, 4137:+296->300, 4138:+296->300, 4139:+296->300, 4140:+296->300, 4141:+1326->1330, 4142:+1489->1493, 4143:+296->300, 4144:+296->300, 4145:+1544->1548, 4146:+296->300, 4147:+1614->1618, 4148:+296->300, 4149:+296->300, 4150:+296->300, 4151:+296->300, 4152:+296->300, 4153:+296->300, 4154:+296->300, 4155:+296->300, 4156:+1654->1658, 4157:+1723->1727, 4158:+1982->1986, 4159:+296->300, 4160:+296->300, 4161:+296->300, 4162:+296->300, 4163:+2010->2014, 4164:+296->300, 4165:+1917->1921, 4166:+2037->2041, 4167:+2123->2127
    //   301: areturn
    //   302: aload_3
    //   303: ifnull -3 -> 300
    //   306: aload_3
    //   307: arraylength
    //   308: iconst_3
    //   309: if_icmpne -9 -> 300
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_0
    //   319: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: bipush 71
    //   324: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   327: checkcast 665	asak
    //   330: invokevirtual 668	asak:a	()Lasbi;
    //   333: aload_3
    //   334: iconst_0
    //   335: aaload
    //   336: checkcast 403	java/lang/String
    //   339: aload_3
    //   340: iconst_1
    //   341: aaload
    //   342: checkcast 424	java/lang/Integer
    //   345: invokevirtual 651	java/lang/Integer:intValue	()I
    //   348: aload_3
    //   349: iconst_2
    //   350: aaload
    //   351: checkcast 159	java/lang/Boolean
    //   354: invokevirtual 671	java/lang/Boolean:booleanValue	()Z
    //   357: invokevirtual 676	asbi:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   360: aastore
    //   361: areturn
    //   362: aload_0
    //   363: iconst_0
    //   364: aload_3
    //   365: invokevirtual 678	axwf:a	(Z[Ljava/lang/Object;)V
    //   368: aconst_null
    //   369: areturn
    //   370: aload_0
    //   371: iconst_1
    //   372: aload_3
    //   373: invokevirtual 678	axwf:a	(Z[Ljava/lang/Object;)V
    //   376: aconst_null
    //   377: areturn
    //   378: new 680	com/tencent/mobileqq/nearby/NearbyProxy$1
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 681	com/tencent/mobileqq/nearby/NearbyProxy$1:<init>	(Laxwf;)V
    //   386: aconst_null
    //   387: iconst_1
    //   388: invokestatic 685	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   391: aconst_null
    //   392: areturn
    //   393: aload_3
    //   394: ifnull -94 -> 300
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_0
    //   404: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: bipush 36
    //   409: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   412: checkcast 687	bbav
    //   415: aload_3
    //   416: iconst_0
    //   417: aaload
    //   418: checkcast 403	java/lang/String
    //   421: invokevirtual 690	bbav:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   424: invokevirtual 693	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   427: aastore
    //   428: areturn
    //   429: aload_3
    //   430: ifnull -130 -> 300
    //   433: iconst_1
    //   434: anewarray 4	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: aload_0
    //   440: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   443: bipush 36
    //   445: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   448: checkcast 687	bbav
    //   451: aload_3
    //   452: iconst_0
    //   453: aaload
    //   454: checkcast 424	java/lang/Integer
    //   457: invokevirtual 651	java/lang/Integer:intValue	()I
    //   460: invokevirtual 696	bbav:b	(I)Z
    //   463: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   466: aastore
    //   467: areturn
    //   468: aload_3
    //   469: ifnull -169 -> 300
    //   472: aload_3
    //   473: arraylength
    //   474: bipush 6
    //   476: if_icmplt +1710 -> 2186
    //   479: aload_3
    //   480: iconst_5
    //   481: aaload
    //   482: checkcast 159	java/lang/Boolean
    //   485: invokevirtual 671	java/lang/Boolean:booleanValue	()Z
    //   488: istore 4
    //   490: aload_0
    //   491: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: aload_3
    //   495: iconst_0
    //   496: aaload
    //   497: checkcast 424	java/lang/Integer
    //   500: invokevirtual 651	java/lang/Integer:intValue	()I
    //   503: aload_3
    //   504: iconst_1
    //   505: aaload
    //   506: checkcast 424	java/lang/Integer
    //   509: invokevirtual 651	java/lang/Integer:intValue	()I
    //   512: aload_3
    //   513: iconst_2
    //   514: aaload
    //   515: checkcast 403	java/lang/String
    //   518: aload_3
    //   519: iconst_3
    //   520: aaload
    //   521: checkcast 403	java/lang/String
    //   524: aload_3
    //   525: iconst_4
    //   526: aaload
    //   527: checkcast 159	java/lang/Boolean
    //   530: invokevirtual 671	java/lang/Boolean:booleanValue	()Z
    //   533: invokestatic 701	ayuo:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   536: astore_1
    //   537: iload 4
    //   539: ifeq -239 -> 300
    //   542: iconst_1
    //   543: anewarray 4	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload_1
    //   549: invokevirtual 693	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   552: aastore
    //   553: areturn
    //   554: aload_3
    //   555: ifnull -255 -> 300
    //   558: aload_3
    //   559: iconst_0
    //   560: aaload
    //   561: checkcast 403	java/lang/String
    //   564: astore_1
    //   565: iconst_1
    //   566: anewarray 4	java/lang/Object
    //   569: dup
    //   570: iconst_0
    //   571: aload_0
    //   572: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: aload_1
    //   576: invokestatic 706	alpb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   579: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   582: aastore
    //   583: areturn
    //   584: aload_3
    //   585: ifnull -285 -> 300
    //   588: aload_3
    //   589: iconst_0
    //   590: aaload
    //   591: checkcast 403	java/lang/String
    //   594: astore_1
    //   595: aload_3
    //   596: iconst_1
    //   597: aaload
    //   598: checkcast 403	java/lang/String
    //   601: astore 6
    //   603: aload_3
    //   604: iconst_2
    //   605: aaload
    //   606: checkcast 424	java/lang/Integer
    //   609: invokevirtual 651	java/lang/Integer:intValue	()I
    //   612: istore_2
    //   613: aload_3
    //   614: iconst_3
    //   615: aaload
    //   616: checkcast 159	java/lang/Boolean
    //   619: invokevirtual 671	java/lang/Boolean:booleanValue	()Z
    //   622: istore 4
    //   624: aload_3
    //   625: iconst_4
    //   626: aaload
    //   627: checkcast 159	java/lang/Boolean
    //   630: invokevirtual 671	java/lang/Boolean:booleanValue	()Z
    //   633: istore 5
    //   635: aload_0
    //   636: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   639: aload_1
    //   640: aload 6
    //   642: iload_2
    //   643: iload 4
    //   645: iload 5
    //   647: invokestatic 711	aosd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   650: aconst_null
    //   651: areturn
    //   652: aload_3
    //   653: ifnull -353 -> 300
    //   656: aload_3
    //   657: iconst_0
    //   658: aaload
    //   659: checkcast 403	java/lang/String
    //   662: astore_1
    //   663: aload_3
    //   664: iconst_1
    //   665: aaload
    //   666: checkcast 403	java/lang/String
    //   669: astore 6
    //   671: aload_3
    //   672: iconst_2
    //   673: aaload
    //   674: checkcast 424	java/lang/Integer
    //   677: invokevirtual 651	java/lang/Integer:intValue	()I
    //   680: istore_2
    //   681: aload_0
    //   682: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   685: aload_1
    //   686: aload 6
    //   688: iload_2
    //   689: invokestatic 714	aosd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   692: aconst_null
    //   693: areturn
    //   694: aload_3
    //   695: ifnull +9 -> 704
    //   698: aload_3
    //   699: arraylength
    //   700: iconst_2
    //   701: if_icmpge +15 -> 716
    //   704: iconst_1
    //   705: anewarray 4	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: iconst_0
    //   711: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   714: aastore
    //   715: areturn
    //   716: aload_0
    //   717: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   720: aload_0
    //   721: getfield 59	axwf:jdField_a_of_type_Aocj	Laocj;
    //   724: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lanui;)V
    //   727: aload_0
    //   728: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   731: iconst_0
    //   732: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   735: checkcast 723	com/tencent/mobileqq/app/MessageHandler
    //   738: aload_3
    //   739: iconst_0
    //   740: aaload
    //   741: checkcast 514	java/lang/Long
    //   744: invokevirtual 727	java/lang/Long:longValue	()J
    //   747: aload_3
    //   748: iconst_1
    //   749: aaload
    //   750: checkcast 424	java/lang/Integer
    //   753: invokevirtual 651	java/lang/Integer:intValue	()I
    //   756: iconst_1
    //   757: invokevirtual 730	com/tencent/mobileqq/app/MessageHandler:c	(JII)V
    //   760: iconst_1
    //   761: anewarray 4	java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: iconst_1
    //   767: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   770: aastore
    //   771: areturn
    //   772: aload_3
    //   773: ifnull +9 -> 782
    //   776: aload_3
    //   777: arraylength
    //   778: iconst_1
    //   779: if_icmpge +15 -> 794
    //   782: iconst_1
    //   783: anewarray 4	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: iconst_0
    //   789: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   792: aastore
    //   793: areturn
    //   794: aload_0
    //   795: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   798: aload_0
    //   799: getfield 59	axwf:jdField_a_of_type_Aocj	Laocj;
    //   802: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lanui;)V
    //   805: aload_0
    //   806: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   809: iconst_0
    //   810: invokevirtual 721	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   813: checkcast 723	com/tencent/mobileqq/app/MessageHandler
    //   816: aload_3
    //   817: iconst_0
    //   818: aaload
    //   819: checkcast 403	java/lang/String
    //   822: iconst_1
    //   823: invokevirtual 732	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/lang/String;I)V
    //   826: iconst_1
    //   827: anewarray 4	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: iconst_1
    //   833: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   836: aastore
    //   837: areturn
    //   838: aload_3
    //   839: ifnull -539 -> 300
    //   842: aload_3
    //   843: arraylength
    //   844: iconst_1
    //   845: if_icmplt -545 -> 300
    //   848: iconst_1
    //   849: anewarray 4	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload_0
    //   855: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   858: bipush 16
    //   860: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   863: checkcast 734	axad
    //   866: aload_3
    //   867: iconst_0
    //   868: aaload
    //   869: checkcast 403	java/lang/String
    //   872: invokevirtual 736	axad:a	(Ljava/lang/String;)Z
    //   875: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   878: aastore
    //   879: areturn
    //   880: aload_3
    //   881: ifnull -581 -> 300
    //   884: aload_3
    //   885: arraylength
    //   886: iconst_3
    //   887: if_icmplt -587 -> 300
    //   890: aload_3
    //   891: iconst_0
    //   892: aaload
    //   893: checkcast 403	java/lang/String
    //   896: astore 7
    //   898: aload_3
    //   899: iconst_1
    //   900: aaload
    //   901: ifnull +1279 -> 2180
    //   904: aload_3
    //   905: iconst_1
    //   906: aaload
    //   907: checkcast 738	[B
    //   910: checkcast 738	[B
    //   913: astore_1
    //   914: new 532	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   917: dup
    //   918: invokespecial 739	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   921: astore 6
    //   923: aload 6
    //   925: aload_1
    //   926: invokevirtual 743	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   929: pop
    //   930: aload_3
    //   931: iconst_2
    //   932: aaload
    //   933: ifnull +1242 -> 2175
    //   936: aload_3
    //   937: iconst_2
    //   938: aaload
    //   939: checkcast 738	[B
    //   942: checkcast 738	[B
    //   945: astore_3
    //   946: new 542	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   949: dup
    //   950: invokespecial 744	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   953: astore_1
    //   954: aload_1
    //   955: aload_3
    //   956: invokevirtual 745	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   959: pop
    //   960: aload_0
    //   961: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   964: aload 7
    //   966: aload 6
    //   968: aload_1
    //   969: invokestatic 530	axup:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   972: aconst_null
    //   973: areturn
    //   974: astore_1
    //   975: aconst_null
    //   976: astore_1
    //   977: aload_1
    //   978: astore 6
    //   980: goto -50 -> 930
    //   983: aload_3
    //   984: ifnull -684 -> 300
    //   987: aload_3
    //   988: arraylength
    //   989: iconst_1
    //   990: if_icmplt -690 -> 300
    //   993: aload_3
    //   994: iconst_0
    //   995: aaload
    //   996: checkcast 738	[B
    //   999: checkcast 738	[B
    //   1002: astore_3
    //   1003: new 562	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   1006: dup
    //   1007: invokespecial 746	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   1010: astore_1
    //   1011: aload_1
    //   1012: aload_3
    //   1013: invokevirtual 747	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1016: pop
    //   1017: aload_0
    //   1018: aload_1
    //   1019: invokevirtual 749	axwf:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   1022: aconst_null
    //   1023: areturn
    //   1024: astore_3
    //   1025: aconst_null
    //   1026: astore_1
    //   1027: aload_3
    //   1028: invokevirtual 752	java/lang/Exception:printStackTrace	()V
    //   1031: goto -14 -> 1017
    //   1034: aload_3
    //   1035: ifnull -735 -> 300
    //   1038: aload_3
    //   1039: arraylength
    //   1040: iconst_1
    //   1041: if_icmplt -741 -> 300
    //   1044: aload_3
    //   1045: iconst_0
    //   1046: aaload
    //   1047: instanceof 754
    //   1050: ifeq -750 -> 300
    //   1053: aload_3
    //   1054: iconst_0
    //   1055: aaload
    //   1056: checkcast 754	java/lang/Byte
    //   1059: invokevirtual 758	java/lang/Byte:byteValue	()B
    //   1062: ifne +6 -> 1068
    //   1065: iconst_1
    //   1066: istore 4
    //   1068: aload_0
    //   1069: iload 4
    //   1071: invokevirtual 760	axwf:a	(Z)V
    //   1074: aconst_null
    //   1075: areturn
    //   1076: aload_0
    //   1077: getfield 358	axwf:jdField_a_of_type_Axus	Laxus;
    //   1080: ifnull -780 -> 300
    //   1083: aload_0
    //   1084: getfield 358	axwf:jdField_a_of_type_Axus	Laxus;
    //   1087: invokevirtual 762	axus:a	()V
    //   1090: aconst_null
    //   1091: areturn
    //   1092: aload_3
    //   1093: ifnull -793 -> 300
    //   1096: aload_3
    //   1097: arraylength
    //   1098: iconst_1
    //   1099: if_icmpne -799 -> 300
    //   1102: aload_3
    //   1103: iconst_0
    //   1104: aaload
    //   1105: instanceof 738
    //   1108: ifeq -808 -> 300
    //   1111: aload_3
    //   1112: iconst_0
    //   1113: aaload
    //   1114: checkcast 738	[B
    //   1117: checkcast 738	[B
    //   1120: astore_3
    //   1121: aload_3
    //   1122: ifnull -822 -> 300
    //   1125: aload_3
    //   1126: arraylength
    //   1127: ifle -827 -> 300
    //   1130: new 764	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo
    //   1133: dup
    //   1134: invokespecial 765	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:<init>	()V
    //   1137: astore_1
    //   1138: aload_1
    //   1139: aload_3
    //   1140: invokevirtual 766	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1143: pop
    //   1144: aload_0
    //   1145: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1148: bipush 106
    //   1150: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1153: checkcast 527	axup
    //   1156: astore_3
    //   1157: aload_3
    //   1158: ifnull -858 -> 300
    //   1161: aload_3
    //   1162: aload_1
    //   1163: invokevirtual 769	axup:a	(Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;)V
    //   1166: aconst_null
    //   1167: areturn
    //   1168: astore_1
    //   1169: aload_1
    //   1170: invokevirtual 752	java/lang/Exception:printStackTrace	()V
    //   1173: aconst_null
    //   1174: areturn
    //   1175: aload_0
    //   1176: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1179: ifnonnull +19 -> 1198
    //   1182: aload_0
    //   1183: aload_0
    //   1184: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1187: bipush 59
    //   1189: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1192: checkcast 773	anve
    //   1195: putfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1198: aload_0
    //   1199: new 775	axwi
    //   1202: dup
    //   1203: aload_0
    //   1204: invokespecial 776	axwi:<init>	(Laxwf;)V
    //   1207: putfield 778	axwf:jdField_a_of_type_Anvi	Lanvi;
    //   1210: aload_0
    //   1211: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1214: aload_0
    //   1215: invokevirtual 781	anve:a	(Ljava/lang/Object;)V
    //   1218: aload_0
    //   1219: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1222: aload_0
    //   1223: getfield 778	axwf:jdField_a_of_type_Anvi	Lanvi;
    //   1226: invokevirtual 783	anve:c	(Ljava/lang/Object;)V
    //   1229: aconst_null
    //   1230: areturn
    //   1231: aload_3
    //   1232: ifnull -932 -> 300
    //   1235: aload_3
    //   1236: arraylength
    //   1237: iconst_1
    //   1238: if_icmpne -938 -> 300
    //   1241: aload_3
    //   1242: iconst_0
    //   1243: aaload
    //   1244: checkcast 403	java/lang/String
    //   1247: astore_1
    //   1248: aload_0
    //   1249: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1252: ifnull +25 -> 1277
    //   1255: iconst_1
    //   1256: anewarray 4	java/lang/Object
    //   1259: dup
    //   1260: iconst_0
    //   1261: aload_0
    //   1262: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1265: aload_1
    //   1266: ldc_w 785
    //   1269: invokevirtual 789	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1272: invokevirtual 792	anve:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1275: aastore
    //   1276: areturn
    //   1277: aload_0
    //   1278: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1281: ifnull -981 -> 300
    //   1284: aload_0
    //   1285: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1288: aload_0
    //   1289: invokevirtual 794	anve:b	(Ljava/lang/Object;)V
    //   1292: aload_0
    //   1293: getfield 778	axwf:jdField_a_of_type_Anvi	Lanvi;
    //   1296: ifnull -996 -> 300
    //   1299: aload_0
    //   1300: getfield 771	axwf:jdField_a_of_type_Anve	Lanve;
    //   1303: aload_0
    //   1304: getfield 778	axwf:jdField_a_of_type_Anvi	Lanvi;
    //   1307: invokevirtual 796	anve:d	(Ljava/lang/Object;)V
    //   1310: aconst_null
    //   1311: areturn
    //   1312: aload_0
    //   1313: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1316: bipush 106
    //   1318: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1321: checkcast 527	axup
    //   1324: iconst_1
    //   1325: putfield 797	axup:a	Z
    //   1328: aconst_null
    //   1329: areturn
    //   1330: aload_3
    //   1331: ifnull -1031 -> 300
    //   1334: aload_3
    //   1335: arraylength
    //   1336: iconst_1
    //   1337: if_icmpne -1037 -> 300
    //   1340: aload_0
    //   1341: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1344: sipush 160
    //   1347: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1350: checkcast 799	aysq
    //   1353: aload_3
    //   1354: iconst_0
    //   1355: aaload
    //   1356: checkcast 424	java/lang/Integer
    //   1359: invokevirtual 651	java/lang/Integer:intValue	()I
    //   1362: invokevirtual 802	aysq:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1365: astore_1
    //   1366: aload_1
    //   1367: ifnull -1067 -> 300
    //   1370: bipush 12
    //   1372: anewarray 4	java/lang/Object
    //   1375: dup
    //   1376: iconst_0
    //   1377: aload_1
    //   1378: getfield 807	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1381: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1384: aastore
    //   1385: dup
    //   1386: iconst_1
    //   1387: aload_1
    //   1388: getfield 810	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1391: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1394: aastore
    //   1395: dup
    //   1396: iconst_2
    //   1397: aload_1
    //   1398: getfield 813	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1401: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1404: aastore
    //   1405: dup
    //   1406: iconst_3
    //   1407: aload_1
    //   1408: getfield 816	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1411: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1414: aastore
    //   1415: dup
    //   1416: iconst_4
    //   1417: aload_1
    //   1418: getfield 819	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1421: aastore
    //   1422: dup
    //   1423: iconst_5
    //   1424: aload_1
    //   1425: getfield 822	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1428: aastore
    //   1429: dup
    //   1430: bipush 6
    //   1432: aload_1
    //   1433: getfield 825	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1436: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1439: aastore
    //   1440: dup
    //   1441: bipush 7
    //   1443: aload_1
    //   1444: getfield 828	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1447: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1450: aastore
    //   1451: dup
    //   1452: bipush 8
    //   1454: aload_1
    //   1455: getfield 831	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1458: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1461: aastore
    //   1462: dup
    //   1463: bipush 9
    //   1465: aload_1
    //   1466: getfield 834	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1469: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1472: aastore
    //   1473: dup
    //   1474: bipush 10
    //   1476: aload_1
    //   1477: getfield 837	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1480: aastore
    //   1481: dup
    //   1482: bipush 11
    //   1484: aload_1
    //   1485: getfield 840	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:isClosed	Z
    //   1488: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1491: aastore
    //   1492: areturn
    //   1493: aload_3
    //   1494: ifnull -1194 -> 300
    //   1497: aload_3
    //   1498: arraylength
    //   1499: iconst_1
    //   1500: if_icmpne -1200 -> 300
    //   1503: aload_3
    //   1504: iconst_0
    //   1505: aaload
    //   1506: checkcast 738	[B
    //   1509: checkcast 738	[B
    //   1512: astore_1
    //   1513: aload_0
    //   1514: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1517: sipush 180
    //   1520: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1523: checkcast 303	aqib
    //   1526: aload_1
    //   1527: invokevirtual 843	aqib:a	([B)V
    //   1530: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq -1233 -> 300
    //   1536: ldc_w 281
    //   1539: iconst_2
    //   1540: ldc_w 845
    //   1543: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1546: aconst_null
    //   1547: areturn
    //   1548: aload_3
    //   1549: ifnull -1249 -> 300
    //   1552: aload_3
    //   1553: iconst_0
    //   1554: aaload
    //   1555: checkcast 403	java/lang/String
    //   1558: astore_1
    //   1559: aload_0
    //   1560: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1563: bipush 106
    //   1565: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1568: checkcast 527	axup
    //   1571: getfield 848	axup:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   1574: aload_1
    //   1575: iconst_1
    //   1576: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1579: invokevirtual 854	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1582: pop
    //   1583: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1586: ifeq -1286 -> 300
    //   1589: ldc_w 856
    //   1592: iconst_2
    //   1593: new 105	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1600: ldc_w 858
    //   1603: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: aload_1
    //   1607: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1616: aconst_null
    //   1617: areturn
    //   1618: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1621: ifeq +13 -> 1634
    //   1624: ldc_w 345
    //   1627: iconst_2
    //   1628: ldc_w 860
    //   1631: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1634: new 862	android/os/Handler
    //   1637: dup
    //   1638: invokestatic 868	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1641: invokespecial 871	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1644: new 873	com/tencent/mobileqq/nearby/NearbyProxy$3
    //   1647: dup
    //   1648: aload_0
    //   1649: invokespecial 874	com/tencent/mobileqq/nearby/NearbyProxy$3:<init>	(Laxwf;)V
    //   1652: invokevirtual 875	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1655: pop
    //   1656: aconst_null
    //   1657: areturn
    //   1658: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1661: ifeq +13 -> 1674
    //   1664: ldc_w 345
    //   1667: iconst_2
    //   1668: ldc_w 877
    //   1671: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1674: aload_0
    //   1675: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1678: bipush 51
    //   1680: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1683: checkcast 879	anyw
    //   1686: astore_1
    //   1687: aload_1
    //   1688: ifnonnull +24 -> 1712
    //   1691: aconst_null
    //   1692: astore_1
    //   1693: aload_1
    //   1694: ifnull -1394 -> 300
    //   1697: iconst_1
    //   1698: anewarray 4	java/lang/Object
    //   1701: dup
    //   1702: iconst_0
    //   1703: aload_1
    //   1704: getfield 885	com/tencent/mobileqq/data/Card:shGender	S
    //   1707: invokestatic 890	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   1710: aastore
    //   1711: areturn
    //   1712: aload_1
    //   1713: aload_0
    //   1714: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1717: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1720: invokevirtual 893	anyw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1723: astore_1
    //   1724: goto -31 -> 1693
    //   1727: aload_3
    //   1728: iconst_0
    //   1729: aaload
    //   1730: checkcast 424	java/lang/Integer
    //   1733: astore_1
    //   1734: aload_0
    //   1735: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1738: bipush 70
    //   1740: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1743: checkcast 895	nlb
    //   1746: astore_3
    //   1747: aload_1
    //   1748: invokevirtual 651	java/lang/Integer:intValue	()I
    //   1751: tableswitch	default:+61 -> 1812, 1:+84->1835, 2:+92->1843, 3:+110->1861, 4:+61->1812, 5:+118->1869, 6:+79->1830, 7:+100->1851, 8:+105->1856, 9:+141->1892, 10:+149->1900, 11:+157->1908, 12:+162->1913
    //   1813: astore_1
    //   1814: aload_1
    //   1815: ifnull -1515 -> 300
    //   1818: iconst_1
    //   1819: anewarray 4	java/lang/Object
    //   1822: dup
    //   1823: iconst_0
    //   1824: aload_1
    //   1825: invokevirtual 898	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:toByteArray	()[B
    //   1828: aastore
    //   1829: areturn
    //   1830: aconst_null
    //   1831: astore_1
    //   1832: goto -18 -> 1814
    //   1835: aload_3
    //   1836: invokevirtual 901	nlb:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1839: astore_1
    //   1840: goto -26 -> 1814
    //   1843: aload_3
    //   1844: invokevirtual 903	nlb:b	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1847: astore_1
    //   1848: goto -34 -> 1814
    //   1851: aconst_null
    //   1852: astore_1
    //   1853: goto -39 -> 1814
    //   1856: aconst_null
    //   1857: astore_1
    //   1858: goto -44 -> 1814
    //   1861: aload_3
    //   1862: invokevirtual 905	nlb:c	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1865: astore_1
    //   1866: goto -52 -> 1814
    //   1869: aload_3
    //   1870: invokevirtual 906	nlb:a	()Z
    //   1873: ifeq +14 -> 1887
    //   1876: new 897	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1879: dup
    //   1880: invokespecial 907	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   1883: astore_1
    //   1884: goto -70 -> 1814
    //   1887: aconst_null
    //   1888: astore_1
    //   1889: goto -75 -> 1814
    //   1892: aload_3
    //   1893: invokevirtual 910	nlb:j	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1896: astore_1
    //   1897: goto -83 -> 1814
    //   1900: aload_3
    //   1901: invokevirtual 912	nlb:i	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1904: astore_1
    //   1905: goto -91 -> 1814
    //   1908: aconst_null
    //   1909: astore_1
    //   1910: goto -96 -> 1814
    //   1913: aload_3
    //   1914: invokevirtual 914	nlb:e	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1917: astore_1
    //   1918: goto -104 -> 1814
    //   1921: aload_0
    //   1922: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1925: bipush 70
    //   1927: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1930: checkcast 895	nlb
    //   1933: invokevirtual 917	nlb:a	()Laysv;
    //   1936: astore_1
    //   1937: aload_1
    //   1938: ifnull -1638 -> 300
    //   1941: iconst_4
    //   1942: anewarray 4	java/lang/Object
    //   1945: dup
    //   1946: iconst_0
    //   1947: aload_1
    //   1948: getfield 920	aysv:jdField_a_of_type_Int	I
    //   1951: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1954: aastore
    //   1955: dup
    //   1956: iconst_1
    //   1957: aload_1
    //   1958: getfield 921	aysv:jdField_b_of_type_Int	I
    //   1961: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1964: aastore
    //   1965: dup
    //   1966: iconst_2
    //   1967: aload_1
    //   1968: getfield 923	aysv:c	I
    //   1971: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1974: aastore
    //   1975: dup
    //   1976: iconst_3
    //   1977: aload_1
    //   1978: getfield 925	aysv:d	I
    //   1981: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1984: aastore
    //   1985: areturn
    //   1986: aload_3
    //   1987: iconst_0
    //   1988: aaload
    //   1989: checkcast 424	java/lang/Integer
    //   1992: astore_1
    //   1993: aload_0
    //   1994: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1997: bipush 70
    //   1999: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2002: checkcast 895	nlb
    //   2005: aload_1
    //   2006: invokevirtual 651	java/lang/Integer:intValue	()I
    //   2009: invokevirtual 927	nlb:b	(I)V
    //   2012: aconst_null
    //   2013: areturn
    //   2014: aload_3
    //   2015: iconst_0
    //   2016: aaload
    //   2017: checkcast 403	java/lang/String
    //   2020: astore_1
    //   2021: iconst_1
    //   2022: anewarray 4	java/lang/Object
    //   2025: dup
    //   2026: iconst_0
    //   2027: aload_0
    //   2028: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2031: aload_1
    //   2032: iconst_0
    //   2033: invokestatic 932	com/tencent/mobileqq/dating/MsgBoxListActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)I
    //   2036: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2039: aastore
    //   2040: areturn
    //   2041: aload_0
    //   2042: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2045: bipush 70
    //   2047: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2050: checkcast 895	nlb
    //   2053: astore_1
    //   2054: aload_1
    //   2055: bipush 70
    //   2057: invokevirtual 935	nlb:a	(I)Laysv;
    //   2060: astore_3
    //   2061: aload_3
    //   2062: aload_1
    //   2063: bipush 70
    //   2065: invokevirtual 937	nlb:a	(I)Ljava/lang/String;
    //   2068: putfield 939	aysv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2071: aload_3
    //   2072: ifnull -1772 -> 300
    //   2075: iconst_5
    //   2076: anewarray 4	java/lang/Object
    //   2079: dup
    //   2080: iconst_0
    //   2081: aload_3
    //   2082: getfield 920	aysv:jdField_a_of_type_Int	I
    //   2085: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2088: aastore
    //   2089: dup
    //   2090: iconst_1
    //   2091: aload_3
    //   2092: getfield 921	aysv:jdField_b_of_type_Int	I
    //   2095: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2098: aastore
    //   2099: dup
    //   2100: iconst_2
    //   2101: aload_3
    //   2102: getfield 923	aysv:c	I
    //   2105: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2108: aastore
    //   2109: dup
    //   2110: iconst_3
    //   2111: aload_3
    //   2112: getfield 925	aysv:d	I
    //   2115: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2118: aastore
    //   2119: dup
    //   2120: iconst_4
    //   2121: aload_3
    //   2122: getfield 939	aysv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2125: aastore
    //   2126: areturn
    //   2127: aload_0
    //   2128: getfield 61	axwf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2131: bipush 70
    //   2133: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2136: checkcast 895	nlb
    //   2139: astore_1
    //   2140: aload_1
    //   2141: bipush 70
    //   2143: invokevirtual 941	nlb:a	(I)V
    //   2146: aload_1
    //   2147: bipush 70
    //   2149: invokevirtual 927	nlb:b	(I)V
    //   2152: aconst_null
    //   2153: areturn
    //   2154: astore_3
    //   2155: goto -1128 -> 1027
    //   2158: astore_1
    //   2159: aconst_null
    //   2160: astore_1
    //   2161: goto -1201 -> 960
    //   2164: astore_3
    //   2165: goto -1205 -> 960
    //   2168: astore_1
    //   2169: aload 6
    //   2171: astore_1
    //   2172: goto -1195 -> 977
    //   2175: aconst_null
    //   2176: astore_1
    //   2177: goto -1217 -> 960
    //   2180: aconst_null
    //   2181: astore 6
    //   2183: goto -1253 -> 930
    //   2186: iconst_0
    //   2187: istore 4
    //   2189: goto -1699 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2192	0	this	axwf
    //   0	2192	1	paramContext	Context
    //   0	2192	2	paramInt	int
    //   0	2192	3	paramVarArgs	Object[]
    //   1	2187	4	bool1	boolean
    //   633	13	5	bool2	boolean
    //   601	1581	6	localObject	Object
    //   896	69	7	str	String
    // Exception table:
    //   from	to	target	type
    //   904	923	974	java/lang/Throwable
    //   993	1011	1024	java/lang/Exception
    //   1130	1157	1168	java/lang/Exception
    //   1161	1166	1168	java/lang/Exception
    //   1011	1017	2154	java/lang/Exception
    //   936	954	2158	java/lang/Throwable
    //   954	960	2164	java/lang/Throwable
    //   923	930	2168	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        axxb.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      axwo localaxwo = (axwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
      if (localaxwo != null) {
        localaxwo.a();
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
      if (!axws.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwf
 * JD-Core Version:    0.7.0.1
 */