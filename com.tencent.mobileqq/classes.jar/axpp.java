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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
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

public class axpp
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  anrz jdField_a_of_type_Anrz;
  ansd jdField_a_of_type_Ansd;
  anyz jdField_a_of_type_Anyz = new axpr(this);
  aodm jdField_a_of_type_Aodm = new axpq(this);
  axob jdField_a_of_type_Axob;
  bgzh jdField_a_of_type_Bgzh;
  bgzi jdField_a_of_type_Bgzi;
  public QQAppInterface a;
  protected FaceDecoder a;
  public ArrayList<String> a;
  protected HashSet<String> a;
  List<axvb> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = -2147483648;
  List<axvb> jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public axpp(QQAppInterface paramQQAppInterface)
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
      axql.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v6.0.recomm").delete();
    axqc.a(paramString, "history_valid", Boolean.valueOf(false));
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
      localObject = ((aqeq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b(i, (String)localObject);
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(new axpt(this));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(i, paramMessage, 200);
      if (localObject == null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramMessage);
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramMessage, i, true);
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
  
  public axob a()
  {
    try
    {
      if (this.jdField_a_of_type_Axob == null) {
        this.jdField_a_of_type_Axob = new axob();
      }
      axob localaxob = this.jdField_a_of_type_Axob;
      return localaxob;
    }
    finally {}
  }
  
  public bgzh a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bgzh == null) && (paramBoolean)) {
        this.jdField_a_of_type_Bgzh = new bgzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bgzh localbgzh = this.jdField_a_of_type_Bgzh;
      return localbgzh;
    }
    finally {}
  }
  
  public bgzi a()
  {
    try
    {
      if (this.jdField_a_of_type_Bgzi == null) {
        this.jdField_a_of_type_Bgzi = new bgzi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      bgzi localbgzi = this.jdField_a_of_type_Bgzi;
      return localbgzi;
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
      localObject = BaseApplication.getContext().getResources().getString(2131698398);
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
        localObject = BaseApplication.getContext().getResources().getString(2131698386);
      }
      return ((String)localObject).replace("%", paramString);
      arxx.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
    }
  }
  
  public void a()
  {
    a(4124, null);
  }
  
  public void a(int paramInt)
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(4100, new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        axql.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      axpo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      axpu localaxpu = new axpu(this, paramInt);
      localaxpu.a = true;
      a(localaxpu);
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
        localObject = (axvb)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new NearbyProxy.5(this, (axvb)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          axvb localaxvb = (axvb)((Iterator)localObject).next();
          if ((localaxvb != null) && (localaxvb.a)) {
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
        localObject = (axvb)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new NearbyProxy.6(this, (axvb)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (axvb)paramVarArgs.next();
          if ((localObject != null) && (((axvb)localObject).a)) {
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
  
  public void a(axvb paramaxvb)
  {
    a(paramaxvb, false);
  }
  
  public void a(axvb paramaxvb, boolean paramBoolean)
  {
    if (paramaxvb == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramaxvb)) {
          this.jdField_b_of_type_JavaUtilList.add(paramaxvb);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramaxvb)) {
        this.jdField_a_of_type_JavaUtilList.add(paramaxvb);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    axny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
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
    axql.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
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
          localObject2 = axug.a((appoint_define.InterestTag)paramRspBody.get(i));
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
        axql.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        axpo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        axpv localaxpv = new axpv(this, paramAppointmentNotify);
        localaxpv.a = true;
        a(localaxpv);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    arxx.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      axqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
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
      if (!axqc.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    //   4: tableswitch	default:+296 -> 300, 4098:+359->363, 4099:+367->371, 4100:+296->300, 4101:+296->300, 4102:+375->379, 4103:+467->471, 4104:+427->431, 4105:+390->394, 4106:+296->300, 4107:+298->302, 4108:+1038->1042, 4109:+1096->1100, 4110:+693->697, 4111:+773->777, 4112:+841->845, 4113:+296->300, 4114:+296->300, 4115:+296->300, 4116:+296->300, 4117:+296->300, 4118:+296->300, 4119:+553->557, 4120:+583->587, 4121:+651->655, 4122:+884->888, 4123:+987->991, 4124:+296->300, 4125:+296->300, 4126:+296->300, 4127:+1080->1084, 4128:+1180->1184, 4129:+1237->1241, 4130:+1283->1287, 4131:+296->300, 4132:+1318->1322, 4133:+296->300, 4134:+296->300, 4135:+296->300, 4136:+296->300, 4137:+296->300, 4138:+296->300, 4139:+296->300, 4140:+296->300, 4141:+1337->1341, 4142:+1500->1504, 4143:+296->300, 4144:+296->300, 4145:+1555->1559, 4146:+296->300, 4147:+1626->1630, 4148:+296->300, 4149:+296->300, 4150:+296->300, 4151:+296->300, 4152:+296->300, 4153:+296->300, 4154:+296->300, 4155:+296->300, 4156:+1666->1670, 4157:+1736->1740, 4158:+1999->2003, 4159:+296->300, 4160:+296->300, 4161:+296->300, 4162:+296->300, 4163:+2028->2032, 4164:+296->300, 4165:+1933->1937, 4166:+2055->2059, 4167:+2142->2146
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
    //   319: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: getstatic 675	com/tencent/mobileqq/app/QQManagerFactory:DATING_PROXY_MANAGER	I
    //   325: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   328: checkcast 677	arxv
    //   331: invokevirtual 680	arxv:a	()Laryu;
    //   334: aload_3
    //   335: iconst_0
    //   336: aaload
    //   337: checkcast 411	java/lang/String
    //   340: aload_3
    //   341: iconst_1
    //   342: aaload
    //   343: checkcast 433	java/lang/Integer
    //   346: invokevirtual 660	java/lang/Integer:intValue	()I
    //   349: aload_3
    //   350: iconst_2
    //   351: aaload
    //   352: checkcast 159	java/lang/Boolean
    //   355: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   358: invokevirtual 688	aryu:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   361: aastore
    //   362: areturn
    //   363: aload_0
    //   364: iconst_0
    //   365: aload_3
    //   366: invokevirtual 690	axpp:a	(Z[Ljava/lang/Object;)V
    //   369: aconst_null
    //   370: areturn
    //   371: aload_0
    //   372: iconst_1
    //   373: aload_3
    //   374: invokevirtual 690	axpp:a	(Z[Ljava/lang/Object;)V
    //   377: aconst_null
    //   378: areturn
    //   379: new 692	com/tencent/mobileqq/nearby/NearbyProxy$1
    //   382: dup
    //   383: aload_0
    //   384: invokespecial 693	com/tencent/mobileqq/nearby/NearbyProxy$1:<init>	(Laxpp;)V
    //   387: aconst_null
    //   388: iconst_1
    //   389: invokestatic 697	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   392: aconst_null
    //   393: areturn
    //   394: aload_3
    //   395: ifnull -95 -> 300
    //   398: iconst_1
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: aload_0
    //   405: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: getstatic 700	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH	I
    //   411: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   414: checkcast 702	bbbq
    //   417: aload_3
    //   418: iconst_0
    //   419: aaload
    //   420: checkcast 411	java/lang/String
    //   423: invokevirtual 705	bbbq:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   426: invokevirtual 708	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   429: aastore
    //   430: areturn
    //   431: aload_3
    //   432: ifnull -132 -> 300
    //   435: iconst_1
    //   436: anewarray 4	java/lang/Object
    //   439: dup
    //   440: iconst_0
    //   441: aload_0
    //   442: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: getstatic 700	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH	I
    //   448: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   451: checkcast 702	bbbq
    //   454: aload_3
    //   455: iconst_0
    //   456: aaload
    //   457: checkcast 433	java/lang/Integer
    //   460: invokevirtual 660	java/lang/Integer:intValue	()I
    //   463: invokevirtual 711	bbbq:b	(I)Z
    //   466: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   469: aastore
    //   470: areturn
    //   471: aload_3
    //   472: ifnull -172 -> 300
    //   475: aload_3
    //   476: arraylength
    //   477: bipush 6
    //   479: if_icmplt +1727 -> 2206
    //   482: aload_3
    //   483: iconst_5
    //   484: aaload
    //   485: checkcast 159	java/lang/Boolean
    //   488: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   491: istore 4
    //   493: aload_0
    //   494: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   497: aload_3
    //   498: iconst_0
    //   499: aaload
    //   500: checkcast 433	java/lang/Integer
    //   503: invokevirtual 660	java/lang/Integer:intValue	()I
    //   506: aload_3
    //   507: iconst_1
    //   508: aaload
    //   509: checkcast 433	java/lang/Integer
    //   512: invokevirtual 660	java/lang/Integer:intValue	()I
    //   515: aload_3
    //   516: iconst_2
    //   517: aaload
    //   518: checkcast 411	java/lang/String
    //   521: aload_3
    //   522: iconst_3
    //   523: aaload
    //   524: checkcast 411	java/lang/String
    //   527: aload_3
    //   528: iconst_4
    //   529: aaload
    //   530: checkcast 159	java/lang/Boolean
    //   533: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   536: invokestatic 716	ayob:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   539: astore_1
    //   540: iload 4
    //   542: ifeq -242 -> 300
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_1
    //   552: invokevirtual 708	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   555: aastore
    //   556: areturn
    //   557: aload_3
    //   558: ifnull -258 -> 300
    //   561: aload_3
    //   562: iconst_0
    //   563: aaload
    //   564: checkcast 411	java/lang/String
    //   567: astore_1
    //   568: iconst_1
    //   569: anewarray 4	java/lang/Object
    //   572: dup
    //   573: iconst_0
    //   574: aload_0
    //   575: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   578: aload_1
    //   579: invokestatic 721	alik:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   582: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   585: aastore
    //   586: areturn
    //   587: aload_3
    //   588: ifnull -288 -> 300
    //   591: aload_3
    //   592: iconst_0
    //   593: aaload
    //   594: checkcast 411	java/lang/String
    //   597: astore_1
    //   598: aload_3
    //   599: iconst_1
    //   600: aaload
    //   601: checkcast 411	java/lang/String
    //   604: astore 6
    //   606: aload_3
    //   607: iconst_2
    //   608: aaload
    //   609: checkcast 433	java/lang/Integer
    //   612: invokevirtual 660	java/lang/Integer:intValue	()I
    //   615: istore_2
    //   616: aload_3
    //   617: iconst_3
    //   618: aaload
    //   619: checkcast 159	java/lang/Boolean
    //   622: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   625: istore 4
    //   627: aload_3
    //   628: iconst_4
    //   629: aaload
    //   630: checkcast 159	java/lang/Boolean
    //   633: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   636: istore 5
    //   638: aload_0
    //   639: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   642: aload_1
    //   643: aload 6
    //   645: iload_2
    //   646: iload 4
    //   648: iload 5
    //   650: invokestatic 726	aonr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   653: aconst_null
    //   654: areturn
    //   655: aload_3
    //   656: ifnull -356 -> 300
    //   659: aload_3
    //   660: iconst_0
    //   661: aaload
    //   662: checkcast 411	java/lang/String
    //   665: astore_1
    //   666: aload_3
    //   667: iconst_1
    //   668: aaload
    //   669: checkcast 411	java/lang/String
    //   672: astore 6
    //   674: aload_3
    //   675: iconst_2
    //   676: aaload
    //   677: checkcast 433	java/lang/Integer
    //   680: invokevirtual 660	java/lang/Integer:intValue	()I
    //   683: istore_2
    //   684: aload_0
    //   685: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   688: aload_1
    //   689: aload 6
    //   691: iload_2
    //   692: invokestatic 729	aonr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   695: aconst_null
    //   696: areturn
    //   697: aload_3
    //   698: ifnull +9 -> 707
    //   701: aload_3
    //   702: arraylength
    //   703: iconst_2
    //   704: if_icmpge +15 -> 719
    //   707: iconst_1
    //   708: anewarray 4	java/lang/Object
    //   711: dup
    //   712: iconst_0
    //   713: iconst_0
    //   714: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   717: aastore
    //   718: areturn
    //   719: aload_0
    //   720: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   723: aload_0
    //   724: getfield 59	axpp:jdField_a_of_type_Anyz	Lanyz;
    //   727: invokevirtual 733	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   730: aload_0
    //   731: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   734: getstatic 738	com/tencent/mobileqq/app/BusinessHandlerFactory:MESSAGE_HANDLER	I
    //   737: invokevirtual 742	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   740: checkcast 744	com/tencent/mobileqq/app/MessageHandler
    //   743: aload_3
    //   744: iconst_0
    //   745: aaload
    //   746: checkcast 523	java/lang/Long
    //   749: invokevirtual 748	java/lang/Long:longValue	()J
    //   752: aload_3
    //   753: iconst_1
    //   754: aaload
    //   755: checkcast 433	java/lang/Integer
    //   758: invokevirtual 660	java/lang/Integer:intValue	()I
    //   761: iconst_1
    //   762: invokevirtual 751	com/tencent/mobileqq/app/MessageHandler:c	(JII)V
    //   765: iconst_1
    //   766: anewarray 4	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: iconst_1
    //   772: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   775: aastore
    //   776: areturn
    //   777: aload_3
    //   778: ifnull +9 -> 787
    //   781: aload_3
    //   782: arraylength
    //   783: iconst_1
    //   784: if_icmpge +15 -> 799
    //   787: iconst_1
    //   788: anewarray 4	java/lang/Object
    //   791: dup
    //   792: iconst_0
    //   793: iconst_0
    //   794: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   797: aastore
    //   798: areturn
    //   799: aload_0
    //   800: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   803: aload_0
    //   804: getfield 59	axpp:jdField_a_of_type_Anyz	Lanyz;
    //   807: invokevirtual 733	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   810: aload_0
    //   811: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   814: getstatic 738	com/tencent/mobileqq/app/BusinessHandlerFactory:MESSAGE_HANDLER	I
    //   817: invokevirtual 742	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   820: checkcast 744	com/tencent/mobileqq/app/MessageHandler
    //   823: aload_3
    //   824: iconst_0
    //   825: aaload
    //   826: checkcast 411	java/lang/String
    //   829: iconst_1
    //   830: invokevirtual 753	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/lang/String;I)V
    //   833: iconst_1
    //   834: anewarray 4	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: iconst_1
    //   840: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   843: aastore
    //   844: areturn
    //   845: aload_3
    //   846: ifnull -546 -> 300
    //   849: aload_3
    //   850: arraylength
    //   851: iconst_1
    //   852: if_icmplt -552 -> 300
    //   855: iconst_1
    //   856: anewarray 4	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload_0
    //   862: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   865: getstatic 756	com/tencent/mobileqq/app/QQManagerFactory:SHIELD_LIST_MANAGER	I
    //   868: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   871: checkcast 758	awtp
    //   874: aload_3
    //   875: iconst_0
    //   876: aaload
    //   877: checkcast 411	java/lang/String
    //   880: invokevirtual 760	awtp:a	(Ljava/lang/String;)Z
    //   883: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   886: aastore
    //   887: areturn
    //   888: aload_3
    //   889: ifnull -589 -> 300
    //   892: aload_3
    //   893: arraylength
    //   894: iconst_3
    //   895: if_icmplt -595 -> 300
    //   898: aload_3
    //   899: iconst_0
    //   900: aaload
    //   901: checkcast 411	java/lang/String
    //   904: astore 7
    //   906: aload_3
    //   907: iconst_1
    //   908: aaload
    //   909: ifnull +1291 -> 2200
    //   912: aload_3
    //   913: iconst_1
    //   914: aaload
    //   915: checkcast 762	[B
    //   918: checkcast 762	[B
    //   921: astore_1
    //   922: new 541	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   925: dup
    //   926: invokespecial 763	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   929: astore 6
    //   931: aload 6
    //   933: aload_1
    //   934: invokevirtual 767	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   937: pop
    //   938: aload_3
    //   939: iconst_2
    //   940: aaload
    //   941: ifnull +1254 -> 2195
    //   944: aload_3
    //   945: iconst_2
    //   946: aaload
    //   947: checkcast 762	[B
    //   950: checkcast 762	[B
    //   953: astore_3
    //   954: new 551	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   957: dup
    //   958: invokespecial 768	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   961: astore_1
    //   962: aload_1
    //   963: aload_3
    //   964: invokevirtual 769	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   967: pop
    //   968: aload_0
    //   969: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   972: aload 7
    //   974: aload 6
    //   976: aload_1
    //   977: invokestatic 539	axny:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   980: aconst_null
    //   981: areturn
    //   982: astore_1
    //   983: aconst_null
    //   984: astore_1
    //   985: aload_1
    //   986: astore 6
    //   988: goto -50 -> 938
    //   991: aload_3
    //   992: ifnull -692 -> 300
    //   995: aload_3
    //   996: arraylength
    //   997: iconst_1
    //   998: if_icmplt -698 -> 300
    //   1001: aload_3
    //   1002: iconst_0
    //   1003: aaload
    //   1004: checkcast 762	[B
    //   1007: checkcast 762	[B
    //   1010: astore_3
    //   1011: new 571	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   1014: dup
    //   1015: invokespecial 770	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   1018: astore_1
    //   1019: aload_1
    //   1020: aload_3
    //   1021: invokevirtual 771	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1024: pop
    //   1025: aload_0
    //   1026: aload_1
    //   1027: invokevirtual 773	axpp:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   1030: aconst_null
    //   1031: areturn
    //   1032: astore_3
    //   1033: aconst_null
    //   1034: astore_1
    //   1035: aload_3
    //   1036: invokevirtual 776	java/lang/Exception:printStackTrace	()V
    //   1039: goto -14 -> 1025
    //   1042: aload_3
    //   1043: ifnull -743 -> 300
    //   1046: aload_3
    //   1047: arraylength
    //   1048: iconst_1
    //   1049: if_icmplt -749 -> 300
    //   1052: aload_3
    //   1053: iconst_0
    //   1054: aaload
    //   1055: instanceof 778
    //   1058: ifeq -758 -> 300
    //   1061: aload_3
    //   1062: iconst_0
    //   1063: aaload
    //   1064: checkcast 778	java/lang/Byte
    //   1067: invokevirtual 782	java/lang/Byte:byteValue	()B
    //   1070: ifne +6 -> 1076
    //   1073: iconst_1
    //   1074: istore 4
    //   1076: aload_0
    //   1077: iload 4
    //   1079: invokevirtual 784	axpp:a	(Z)V
    //   1082: aconst_null
    //   1083: areturn
    //   1084: aload_0
    //   1085: getfield 366	axpp:jdField_a_of_type_Axob	Laxob;
    //   1088: ifnull -788 -> 300
    //   1091: aload_0
    //   1092: getfield 366	axpp:jdField_a_of_type_Axob	Laxob;
    //   1095: invokevirtual 786	axob:a	()V
    //   1098: aconst_null
    //   1099: areturn
    //   1100: aload_3
    //   1101: ifnull -801 -> 300
    //   1104: aload_3
    //   1105: arraylength
    //   1106: iconst_1
    //   1107: if_icmpne -807 -> 300
    //   1110: aload_3
    //   1111: iconst_0
    //   1112: aaload
    //   1113: instanceof 762
    //   1116: ifeq -816 -> 300
    //   1119: aload_3
    //   1120: iconst_0
    //   1121: aaload
    //   1122: checkcast 762	[B
    //   1125: checkcast 762	[B
    //   1128: astore_3
    //   1129: aload_3
    //   1130: ifnull -830 -> 300
    //   1133: aload_3
    //   1134: arraylength
    //   1135: ifle -835 -> 300
    //   1138: new 788	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo
    //   1141: dup
    //   1142: invokespecial 789	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:<init>	()V
    //   1145: astore_1
    //   1146: aload_1
    //   1147: aload_3
    //   1148: invokevirtual 790	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1151: pop
    //   1152: aload_0
    //   1153: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1156: getstatic 793	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   1159: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1162: checkcast 536	axny
    //   1165: astore_3
    //   1166: aload_3
    //   1167: ifnull -867 -> 300
    //   1170: aload_3
    //   1171: aload_1
    //   1172: invokevirtual 796	axny:a	(Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;)V
    //   1175: aconst_null
    //   1176: areturn
    //   1177: astore_1
    //   1178: aload_1
    //   1179: invokevirtual 776	java/lang/Exception:printStackTrace	()V
    //   1182: aconst_null
    //   1183: areturn
    //   1184: aload_0
    //   1185: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1188: ifnonnull +20 -> 1208
    //   1191: aload_0
    //   1192: aload_0
    //   1193: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1196: getstatic 801	com/tencent/mobileqq/app/QQManagerFactory:CONDITION_SEARCH_MANAGER	I
    //   1199: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1202: checkcast 803	anrz
    //   1205: putfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1208: aload_0
    //   1209: new 805	axps
    //   1212: dup
    //   1213: aload_0
    //   1214: invokespecial 806	axps:<init>	(Laxpp;)V
    //   1217: putfield 808	axpp:jdField_a_of_type_Ansd	Lansd;
    //   1220: aload_0
    //   1221: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1224: aload_0
    //   1225: invokevirtual 811	anrz:a	(Ljava/lang/Object;)V
    //   1228: aload_0
    //   1229: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1232: aload_0
    //   1233: getfield 808	axpp:jdField_a_of_type_Ansd	Lansd;
    //   1236: invokevirtual 813	anrz:c	(Ljava/lang/Object;)V
    //   1239: aconst_null
    //   1240: areturn
    //   1241: aload_3
    //   1242: ifnull -942 -> 300
    //   1245: aload_3
    //   1246: arraylength
    //   1247: iconst_1
    //   1248: if_icmpne -948 -> 300
    //   1251: aload_3
    //   1252: iconst_0
    //   1253: aaload
    //   1254: checkcast 411	java/lang/String
    //   1257: astore_1
    //   1258: aload_0
    //   1259: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1262: ifnull +25 -> 1287
    //   1265: iconst_1
    //   1266: anewarray 4	java/lang/Object
    //   1269: dup
    //   1270: iconst_0
    //   1271: aload_0
    //   1272: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1275: aload_1
    //   1276: ldc_w 815
    //   1279: invokevirtual 819	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1282: invokevirtual 822	anrz:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1285: aastore
    //   1286: areturn
    //   1287: aload_0
    //   1288: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1291: ifnull -991 -> 300
    //   1294: aload_0
    //   1295: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1298: aload_0
    //   1299: invokevirtual 824	anrz:b	(Ljava/lang/Object;)V
    //   1302: aload_0
    //   1303: getfield 808	axpp:jdField_a_of_type_Ansd	Lansd;
    //   1306: ifnull -1006 -> 300
    //   1309: aload_0
    //   1310: getfield 798	axpp:jdField_a_of_type_Anrz	Lanrz;
    //   1313: aload_0
    //   1314: getfield 808	axpp:jdField_a_of_type_Ansd	Lansd;
    //   1317: invokevirtual 826	anrz:d	(Ljava/lang/Object;)V
    //   1320: aconst_null
    //   1321: areturn
    //   1322: aload_0
    //   1323: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1326: getstatic 793	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   1329: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1332: checkcast 536	axny
    //   1335: iconst_1
    //   1336: putfield 827	axny:a	Z
    //   1339: aconst_null
    //   1340: areturn
    //   1341: aload_3
    //   1342: ifnull -1042 -> 300
    //   1345: aload_3
    //   1346: arraylength
    //   1347: iconst_1
    //   1348: if_icmpne -1048 -> 300
    //   1351: aload_0
    //   1352: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1355: getstatic 830	com/tencent/mobileqq/app/QQManagerFactory:LOCAL_REDTOUCH_MANAGER	I
    //   1358: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1361: checkcast 832	aymd
    //   1364: aload_3
    //   1365: iconst_0
    //   1366: aaload
    //   1367: checkcast 433	java/lang/Integer
    //   1370: invokevirtual 660	java/lang/Integer:intValue	()I
    //   1373: invokevirtual 835	aymd:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1376: astore_1
    //   1377: aload_1
    //   1378: ifnull -1078 -> 300
    //   1381: bipush 12
    //   1383: anewarray 4	java/lang/Object
    //   1386: dup
    //   1387: iconst_0
    //   1388: aload_1
    //   1389: getfield 840	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1392: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1395: aastore
    //   1396: dup
    //   1397: iconst_1
    //   1398: aload_1
    //   1399: getfield 843	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1402: invokestatic 526	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_2
    //   1408: aload_1
    //   1409: getfield 846	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1412: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1415: aastore
    //   1416: dup
    //   1417: iconst_3
    //   1418: aload_1
    //   1419: getfield 849	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1422: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1425: aastore
    //   1426: dup
    //   1427: iconst_4
    //   1428: aload_1
    //   1429: getfield 852	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1432: aastore
    //   1433: dup
    //   1434: iconst_5
    //   1435: aload_1
    //   1436: getfield 855	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1439: aastore
    //   1440: dup
    //   1441: bipush 6
    //   1443: aload_1
    //   1444: getfield 858	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1447: invokestatic 526	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1450: aastore
    //   1451: dup
    //   1452: bipush 7
    //   1454: aload_1
    //   1455: getfield 861	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1458: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1461: aastore
    //   1462: dup
    //   1463: bipush 8
    //   1465: aload_1
    //   1466: getfield 864	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1469: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1472: aastore
    //   1473: dup
    //   1474: bipush 9
    //   1476: aload_1
    //   1477: getfield 867	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1480: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1483: aastore
    //   1484: dup
    //   1485: bipush 10
    //   1487: aload_1
    //   1488: getfield 870	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1491: aastore
    //   1492: dup
    //   1493: bipush 11
    //   1495: aload_1
    //   1496: getfield 873	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:isClosed	Z
    //   1499: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1502: aastore
    //   1503: areturn
    //   1504: aload_3
    //   1505: ifnull -1205 -> 300
    //   1508: aload_3
    //   1509: arraylength
    //   1510: iconst_1
    //   1511: if_icmpne -1211 -> 300
    //   1514: aload_3
    //   1515: iconst_0
    //   1516: aaload
    //   1517: checkcast 762	[B
    //   1520: checkcast 762	[B
    //   1523: astore_1
    //   1524: aload_0
    //   1525: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1528: getstatic 300	com/tencent/mobileqq/app/QQManagerFactory:DYNAMIC_AVATAR_MANAGER	I
    //   1531: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1534: checkcast 308	aqeq
    //   1537: aload_1
    //   1538: invokevirtual 876	aqeq:a	([B)V
    //   1541: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1544: ifeq -1244 -> 300
    //   1547: ldc_w 281
    //   1550: iconst_2
    //   1551: ldc_w 878
    //   1554: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: aconst_null
    //   1558: areturn
    //   1559: aload_3
    //   1560: ifnull -1260 -> 300
    //   1563: aload_3
    //   1564: iconst_0
    //   1565: aaload
    //   1566: checkcast 411	java/lang/String
    //   1569: astore_1
    //   1570: aload_0
    //   1571: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1574: getstatic 793	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   1577: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1580: checkcast 536	axny
    //   1583: getfield 881	axny:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   1586: aload_1
    //   1587: iconst_1
    //   1588: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1591: invokevirtual 887	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1594: pop
    //   1595: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1598: ifeq -1298 -> 300
    //   1601: ldc_w 889
    //   1604: iconst_2
    //   1605: new 105	java/lang/StringBuilder
    //   1608: dup
    //   1609: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1612: ldc_w 891
    //   1615: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: aload_1
    //   1619: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1625: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1628: aconst_null
    //   1629: areturn
    //   1630: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1633: ifeq +13 -> 1646
    //   1636: ldc_w 353
    //   1639: iconst_2
    //   1640: ldc_w 893
    //   1643: invokestatic 521	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: new 895	android/os/Handler
    //   1649: dup
    //   1650: invokestatic 901	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1653: invokespecial 904	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1656: new 906	com/tencent/mobileqq/nearby/NearbyProxy$3
    //   1659: dup
    //   1660: aload_0
    //   1661: invokespecial 907	com/tencent/mobileqq/nearby/NearbyProxy$3:<init>	(Laxpp;)V
    //   1664: invokevirtual 908	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1667: pop
    //   1668: aconst_null
    //   1669: areturn
    //   1670: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1673: ifeq +13 -> 1686
    //   1676: ldc_w 353
    //   1679: iconst_2
    //   1680: ldc_w 910
    //   1683: invokestatic 521	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1686: aload_0
    //   1687: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1690: getstatic 913	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1693: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1696: checkcast 915	anvk
    //   1699: astore_1
    //   1700: aload_1
    //   1701: ifnonnull +24 -> 1725
    //   1704: aconst_null
    //   1705: astore_1
    //   1706: aload_1
    //   1707: ifnull -1407 -> 300
    //   1710: iconst_1
    //   1711: anewarray 4	java/lang/Object
    //   1714: dup
    //   1715: iconst_0
    //   1716: aload_1
    //   1717: getfield 921	com/tencent/mobileqq/data/Card:shGender	S
    //   1720: invokestatic 926	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   1723: aastore
    //   1724: areturn
    //   1725: aload_1
    //   1726: aload_0
    //   1727: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1730: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1733: invokevirtual 929	anvk:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1736: astore_1
    //   1737: goto -31 -> 1706
    //   1740: aload_3
    //   1741: iconst_0
    //   1742: aaload
    //   1743: checkcast 433	java/lang/Integer
    //   1746: astore_1
    //   1747: aload_0
    //   1748: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1751: getstatic 932	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   1754: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1757: checkcast 934	ntq
    //   1760: astore_3
    //   1761: aload_1
    //   1762: invokevirtual 660	java/lang/Integer:intValue	()I
    //   1765: tableswitch	default:+63 -> 1828, 1:+86->1851, 2:+94->1859, 3:+112->1877, 4:+63->1828, 5:+120->1885, 6:+81->1846, 7:+102->1867, 8:+107->1872, 9:+143->1908, 10:+151->1916, 11:+159->1924, 12:+164->1929
    //   1829: astore_1
    //   1830: aload_1
    //   1831: ifnull -1531 -> 300
    //   1834: iconst_1
    //   1835: anewarray 4	java/lang/Object
    //   1838: dup
    //   1839: iconst_0
    //   1840: aload_1
    //   1841: invokevirtual 937	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:toByteArray	()[B
    //   1844: aastore
    //   1845: areturn
    //   1846: aconst_null
    //   1847: astore_1
    //   1848: goto -18 -> 1830
    //   1851: aload_3
    //   1852: invokevirtual 940	ntq:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1855: astore_1
    //   1856: goto -26 -> 1830
    //   1859: aload_3
    //   1860: invokevirtual 942	ntq:b	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1863: astore_1
    //   1864: goto -34 -> 1830
    //   1867: aconst_null
    //   1868: astore_1
    //   1869: goto -39 -> 1830
    //   1872: aconst_null
    //   1873: astore_1
    //   1874: goto -44 -> 1830
    //   1877: aload_3
    //   1878: invokevirtual 944	ntq:c	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1881: astore_1
    //   1882: goto -52 -> 1830
    //   1885: aload_3
    //   1886: invokevirtual 945	ntq:a	()Z
    //   1889: ifeq +14 -> 1903
    //   1892: new 936	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1895: dup
    //   1896: invokespecial 946	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   1899: astore_1
    //   1900: goto -70 -> 1830
    //   1903: aconst_null
    //   1904: astore_1
    //   1905: goto -75 -> 1830
    //   1908: aload_3
    //   1909: invokevirtual 949	ntq:k	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1912: astore_1
    //   1913: goto -83 -> 1830
    //   1916: aload_3
    //   1917: invokevirtual 952	ntq:j	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1920: astore_1
    //   1921: goto -91 -> 1830
    //   1924: aconst_null
    //   1925: astore_1
    //   1926: goto -96 -> 1830
    //   1929: aload_3
    //   1930: invokevirtual 954	ntq:e	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1933: astore_1
    //   1934: goto -104 -> 1830
    //   1937: aload_0
    //   1938: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1941: getstatic 932	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   1944: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1947: checkcast 934	ntq
    //   1950: invokevirtual 957	ntq:a	()Laymi;
    //   1953: astore_1
    //   1954: aload_1
    //   1955: ifnull -1655 -> 300
    //   1958: iconst_4
    //   1959: anewarray 4	java/lang/Object
    //   1962: dup
    //   1963: iconst_0
    //   1964: aload_1
    //   1965: getfield 960	aymi:jdField_a_of_type_Int	I
    //   1968: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1971: aastore
    //   1972: dup
    //   1973: iconst_1
    //   1974: aload_1
    //   1975: getfield 961	aymi:jdField_b_of_type_Int	I
    //   1978: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1981: aastore
    //   1982: dup
    //   1983: iconst_2
    //   1984: aload_1
    //   1985: getfield 963	aymi:c	I
    //   1988: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1991: aastore
    //   1992: dup
    //   1993: iconst_3
    //   1994: aload_1
    //   1995: getfield 965	aymi:d	I
    //   1998: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2001: aastore
    //   2002: areturn
    //   2003: aload_3
    //   2004: iconst_0
    //   2005: aaload
    //   2006: checkcast 433	java/lang/Integer
    //   2009: astore_1
    //   2010: aload_0
    //   2011: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2014: getstatic 932	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   2017: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2020: checkcast 934	ntq
    //   2023: aload_1
    //   2024: invokevirtual 660	java/lang/Integer:intValue	()I
    //   2027: invokevirtual 967	ntq:b	(I)V
    //   2030: aconst_null
    //   2031: areturn
    //   2032: aload_3
    //   2033: iconst_0
    //   2034: aaload
    //   2035: checkcast 411	java/lang/String
    //   2038: astore_1
    //   2039: iconst_1
    //   2040: anewarray 4	java/lang/Object
    //   2043: dup
    //   2044: iconst_0
    //   2045: aload_0
    //   2046: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2049: aload_1
    //   2050: iconst_0
    //   2051: invokestatic 972	com/tencent/mobileqq/dating/MsgBoxListActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)I
    //   2054: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2057: aastore
    //   2058: areturn
    //   2059: aload_0
    //   2060: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2063: getstatic 932	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   2066: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2069: checkcast 934	ntq
    //   2072: astore_1
    //   2073: aload_1
    //   2074: bipush 70
    //   2076: invokevirtual 975	ntq:a	(I)Laymi;
    //   2079: astore_3
    //   2080: aload_3
    //   2081: aload_1
    //   2082: bipush 70
    //   2084: invokevirtual 977	ntq:a	(I)Ljava/lang/String;
    //   2087: putfield 979	aymi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2090: aload_3
    //   2091: ifnull -1791 -> 300
    //   2094: iconst_5
    //   2095: anewarray 4	java/lang/Object
    //   2098: dup
    //   2099: iconst_0
    //   2100: aload_3
    //   2101: getfield 960	aymi:jdField_a_of_type_Int	I
    //   2104: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2107: aastore
    //   2108: dup
    //   2109: iconst_1
    //   2110: aload_3
    //   2111: getfield 961	aymi:jdField_b_of_type_Int	I
    //   2114: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2117: aastore
    //   2118: dup
    //   2119: iconst_2
    //   2120: aload_3
    //   2121: getfield 963	aymi:c	I
    //   2124: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2127: aastore
    //   2128: dup
    //   2129: iconst_3
    //   2130: aload_3
    //   2131: getfield 965	aymi:d	I
    //   2134: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2137: aastore
    //   2138: dup
    //   2139: iconst_4
    //   2140: aload_3
    //   2141: getfield 979	aymi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2144: aastore
    //   2145: areturn
    //   2146: aload_0
    //   2147: getfield 61	axpp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2150: getstatic 932	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   2153: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2156: checkcast 934	ntq
    //   2159: astore_1
    //   2160: aload_1
    //   2161: bipush 70
    //   2163: invokevirtual 981	ntq:a	(I)V
    //   2166: aload_1
    //   2167: bipush 70
    //   2169: invokevirtual 967	ntq:b	(I)V
    //   2172: aconst_null
    //   2173: areturn
    //   2174: astore_3
    //   2175: goto -1140 -> 1035
    //   2178: astore_1
    //   2179: aconst_null
    //   2180: astore_1
    //   2181: goto -1213 -> 968
    //   2184: astore_3
    //   2185: goto -1217 -> 968
    //   2188: astore_1
    //   2189: aload 6
    //   2191: astore_1
    //   2192: goto -1207 -> 985
    //   2195: aconst_null
    //   2196: astore_1
    //   2197: goto -1229 -> 968
    //   2200: aconst_null
    //   2201: astore 6
    //   2203: goto -1265 -> 938
    //   2206: iconst_0
    //   2207: istore 4
    //   2209: goto -1716 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2212	0	this	axpp
    //   0	2212	1	paramContext	Context
    //   0	2212	2	paramInt	int
    //   0	2212	3	paramVarArgs	Object[]
    //   1	2207	4	bool1	boolean
    //   636	13	5	bool2	boolean
    //   604	1598	6	localObject	Object
    //   904	69	7	str	String
    // Exception table:
    //   from	to	target	type
    //   912	931	982	java/lang/Throwable
    //   1001	1019	1032	java/lang/Exception
    //   1138	1166	1177	java/lang/Exception
    //   1170	1175	1177	java/lang/Exception
    //   1019	1025	2174	java/lang/Exception
    //   944	962	2178	java/lang/Throwable
    //   962	968	2184	java/lang/Throwable
    //   931	938	2188	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        axql.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      axpy localaxpy = (axpy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
      if (localaxpy != null) {
        localaxpy.a();
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
      if (!axqc.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aodm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpp
 * JD-Core Version:    0.7.0.1
 */