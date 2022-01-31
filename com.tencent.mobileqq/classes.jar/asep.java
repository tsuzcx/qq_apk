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

public class asep
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  ajfw jdField_a_of_type_Ajfw;
  ajga jdField_a_of_type_Ajga;
  ajmm jdField_a_of_type_Ajmm = new aser(this);
  ajry jdField_a_of_type_Ajry = new aseq(this);
  asdc jdField_a_of_type_Asdc;
  protected azwg a;
  azxn jdField_a_of_type_Azxn;
  azxo jdField_a_of_type_Azxo;
  public QQAppInterface a;
  public ArrayList<String> a;
  protected HashSet<String> a;
  List<askb> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = -2147483648;
  List<askb> jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public asep(QQAppInterface paramQQAppInterface)
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
      asfl.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v6.0.recomm").delete();
    asfc.a(paramString, "history_valid", Boolean.valueOf(false));
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
      localObject = ((alkl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).b(i, (String)localObject);
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
      if (this.jdField_a_of_type_Azwg == null)
      {
        this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Azwg.a(new aset(this));
      }
      localObject = this.jdField_a_of_type_Azwg.a(i, paramMessage, 200);
      if (localObject == null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramMessage);
          this.jdField_a_of_type_Azwg.a(paramMessage, i, true);
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
  
  public asdc a()
  {
    try
    {
      if (this.jdField_a_of_type_Asdc == null) {
        this.jdField_a_of_type_Asdc = new asdc();
      }
      asdc localasdc = this.jdField_a_of_type_Asdc;
      return localasdc;
    }
    finally {}
  }
  
  public azxn a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Azxn == null) && (paramBoolean)) {
        this.jdField_a_of_type_Azxn = new azxn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      azxn localazxn = this.jdField_a_of_type_Azxn;
      return localazxn;
    }
    finally {}
  }
  
  public azxo a()
  {
    try
    {
      if (this.jdField_a_of_type_Azxo == null) {
        this.jdField_a_of_type_Azxo = new azxo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      azxo localazxo = this.jdField_a_of_type_Azxo;
      return localazxo;
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
      localObject = BaseApplication.getContext().getResources().getString(2131633152);
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
        localObject = BaseApplication.getContext().getResources().getString(2131633002);
      }
      return ((String)localObject).replace("%", paramString);
      amvy.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
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
        asfl.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      aseo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      aseu localaseu = new aseu(this, paramInt);
      localaseu.a = true;
      a(localaseu);
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
        localObject = (askb)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new NearbyProxy.5(this, (askb)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          askb localaskb = (askb)((Iterator)localObject).next();
          if ((localaskb != null) && (localaskb.a)) {
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
        localObject = (askb)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new NearbyProxy.6(this, (askb)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (askb)paramVarArgs.next();
          if ((localObject != null) && (((askb)localObject).a)) {
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
  
  public void a(askb paramaskb)
  {
    a(paramaskb, false);
  }
  
  public void a(askb paramaskb, boolean paramBoolean)
  {
    if (paramaskb == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramaskb)) {
          this.jdField_b_of_type_JavaUtilList.add(paramaskb);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramaskb)) {
        this.jdField_a_of_type_JavaUtilList.add(paramaskb);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    ascz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
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
    asfl.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
    if (paramRspBody == null) {}
    Object localObject1;
    atmp localatmp;
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
          localObject2 = asjg.a((appoint_define.InterestTag)paramRspBody.get(i));
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
      }
      localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      Object localObject2 = (NearbyPeopleCard)localatmp.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramRspBody);
      if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
      {
        localatmp.b((atmo)localObject1);
        return;
      }
    } while ((((NearbyPeopleCard)localObject1).getStatus() != 1001) && (((NearbyPeopleCard)localObject1).getStatus() != 1002));
    localatmp.a((atmo)localObject1);
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
        asfl.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        aseo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        asev localasev = new asev(this, paramAppointmentNotify);
        localasev.a = true;
        a(localasev);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    amvy.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      asfc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
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
      if (!asfc.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    //   4: tableswitch	default:+280 -> 284, 4098:+342->346, 4099:+350->354, 4100:+280->284, 4101:+280->284, 4102:+358->362, 4103:+448->452, 4104:+409->413, 4105:+373->377, 4106:+280->284, 4107:+282->286, 4108:+1014->1018, 4109:+1072->1076, 4110:+674->678, 4111:+752->756, 4112:+818->822, 4113:+280->284, 4114:+280->284, 4115:+280->284, 4116:+280->284, 4117:+280->284, 4118:+280->284, 4119:+534->538, 4120:+564->568, 4121:+632->636, 4122:+860->864, 4123:+963->967, 4124:+280->284, 4125:+280->284, 4126:+280->284, 4127:+1056->1060, 4128:+1155->1159, 4129:+1211->1215, 4130:+1257->1261, 4131:+280->284, 4132:+1292->1296, 4133:+280->284, 4134:+280->284, 4135:+280->284, 4136:+280->284, 4137:+280->284, 4138:+280->284, 4139:+280->284, 4140:+280->284, 4141:+1310->1314, 4142:+1473->1477, 4143:+280->284, 4144:+280->284, 4145:+1528->1532, 4146:+280->284, 4147:+1598->1602, 4148:+280->284, 4149:+280->284, 4150:+280->284, 4151:+280->284, 4152:+280->284, 4153:+280->284, 4154:+280->284, 4155:+280->284, 4156:+1638->1642, 4157:+1707->1711, 4158:+1901->1905, 4159:+280->284, 4160:+280->284, 4161:+280->284, 4162:+280->284, 4163:+1929->1933
    //   285: areturn
    //   286: aload_3
    //   287: ifnull -3 -> 284
    //   290: aload_3
    //   291: arraylength
    //   292: iconst_3
    //   293: if_icmpne -9 -> 284
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_0
    //   303: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: bipush 71
    //   308: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   311: checkcast 662	amvw
    //   314: invokevirtual 665	amvw:a	()Lamwu;
    //   317: aload_3
    //   318: iconst_0
    //   319: aaload
    //   320: checkcast 403	java/lang/String
    //   323: aload_3
    //   324: iconst_1
    //   325: aaload
    //   326: checkcast 424	java/lang/Integer
    //   329: invokevirtual 648	java/lang/Integer:intValue	()I
    //   332: aload_3
    //   333: iconst_2
    //   334: aaload
    //   335: checkcast 159	java/lang/Boolean
    //   338: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   341: invokevirtual 673	amwu:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   344: aastore
    //   345: areturn
    //   346: aload_0
    //   347: iconst_0
    //   348: aload_3
    //   349: invokevirtual 675	asep:a	(Z[Ljava/lang/Object;)V
    //   352: aconst_null
    //   353: areturn
    //   354: aload_0
    //   355: iconst_1
    //   356: aload_3
    //   357: invokevirtual 675	asep:a	(Z[Ljava/lang/Object;)V
    //   360: aconst_null
    //   361: areturn
    //   362: new 677	com/tencent/mobileqq/nearby/NearbyProxy$1
    //   365: dup
    //   366: aload_0
    //   367: invokespecial 678	com/tencent/mobileqq/nearby/NearbyProxy$1:<init>	(Lasep;)V
    //   370: aconst_null
    //   371: iconst_1
    //   372: invokestatic 682	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   375: aconst_null
    //   376: areturn
    //   377: aload_3
    //   378: ifnull -94 -> 284
    //   381: iconst_1
    //   382: anewarray 4	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload_0
    //   388: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   391: bipush 36
    //   393: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   396: checkcast 684	auqh
    //   399: aload_3
    //   400: iconst_0
    //   401: aaload
    //   402: checkcast 403	java/lang/String
    //   405: invokevirtual 687	auqh:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   408: invokevirtual 690	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   411: aastore
    //   412: areturn
    //   413: aload_3
    //   414: ifnull -130 -> 284
    //   417: iconst_1
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: aload_0
    //   424: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: bipush 36
    //   429: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   432: checkcast 684	auqh
    //   435: aload_3
    //   436: iconst_0
    //   437: aaload
    //   438: checkcast 424	java/lang/Integer
    //   441: invokevirtual 648	java/lang/Integer:intValue	()I
    //   444: invokevirtual 693	auqh:b	(I)Z
    //   447: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   450: aastore
    //   451: areturn
    //   452: aload_3
    //   453: ifnull -169 -> 284
    //   456: aload_3
    //   457: arraylength
    //   458: bipush 6
    //   460: if_icmplt +1531 -> 1991
    //   463: aload_3
    //   464: iconst_5
    //   465: aaload
    //   466: checkcast 159	java/lang/Boolean
    //   469: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   472: istore 4
    //   474: aload_0
    //   475: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   478: aload_3
    //   479: iconst_0
    //   480: aaload
    //   481: checkcast 424	java/lang/Integer
    //   484: invokevirtual 648	java/lang/Integer:intValue	()I
    //   487: aload_3
    //   488: iconst_1
    //   489: aaload
    //   490: checkcast 424	java/lang/Integer
    //   493: invokevirtual 648	java/lang/Integer:intValue	()I
    //   496: aload_3
    //   497: iconst_2
    //   498: aaload
    //   499: checkcast 403	java/lang/String
    //   502: aload_3
    //   503: iconst_3
    //   504: aaload
    //   505: checkcast 403	java/lang/String
    //   508: aload_3
    //   509: iconst_4
    //   510: aaload
    //   511: checkcast 159	java/lang/Boolean
    //   514: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   517: invokestatic 698	atcm:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   520: astore_1
    //   521: iload 4
    //   523: ifeq -239 -> 284
    //   526: iconst_1
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload_1
    //   533: invokevirtual 690	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   536: aastore
    //   537: areturn
    //   538: aload_3
    //   539: ifnull -255 -> 284
    //   542: aload_3
    //   543: iconst_0
    //   544: aaload
    //   545: checkcast 403	java/lang/String
    //   548: astore_1
    //   549: iconst_1
    //   550: anewarray 4	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: aload_0
    //   556: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   559: aload_1
    //   560: invokestatic 703	ahcq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   563: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   566: aastore
    //   567: areturn
    //   568: aload_3
    //   569: ifnull -285 -> 284
    //   572: aload_3
    //   573: iconst_0
    //   574: aaload
    //   575: checkcast 403	java/lang/String
    //   578: astore_1
    //   579: aload_3
    //   580: iconst_1
    //   581: aaload
    //   582: checkcast 403	java/lang/String
    //   585: astore 6
    //   587: aload_3
    //   588: iconst_2
    //   589: aaload
    //   590: checkcast 424	java/lang/Integer
    //   593: invokevirtual 648	java/lang/Integer:intValue	()I
    //   596: istore_2
    //   597: aload_3
    //   598: iconst_3
    //   599: aaload
    //   600: checkcast 159	java/lang/Boolean
    //   603: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   606: istore 4
    //   608: aload_3
    //   609: iconst_4
    //   610: aaload
    //   611: checkcast 159	java/lang/Boolean
    //   614: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   617: istore 5
    //   619: aload_0
    //   620: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   623: aload_1
    //   624: aload 6
    //   626: iload_2
    //   627: iload 4
    //   629: iload 5
    //   631: invokestatic 708	ajzx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   634: aconst_null
    //   635: areturn
    //   636: aload_3
    //   637: ifnull -353 -> 284
    //   640: aload_3
    //   641: iconst_0
    //   642: aaload
    //   643: checkcast 403	java/lang/String
    //   646: astore_1
    //   647: aload_3
    //   648: iconst_1
    //   649: aaload
    //   650: checkcast 403	java/lang/String
    //   653: astore 6
    //   655: aload_3
    //   656: iconst_2
    //   657: aaload
    //   658: checkcast 424	java/lang/Integer
    //   661: invokevirtual 648	java/lang/Integer:intValue	()I
    //   664: istore_2
    //   665: aload_0
    //   666: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   669: aload_1
    //   670: aload 6
    //   672: iload_2
    //   673: invokestatic 711	ajzx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   676: aconst_null
    //   677: areturn
    //   678: aload_3
    //   679: ifnull +9 -> 688
    //   682: aload_3
    //   683: arraylength
    //   684: iconst_2
    //   685: if_icmpge +15 -> 700
    //   688: iconst_1
    //   689: anewarray 4	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: iconst_0
    //   695: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   698: aastore
    //   699: areturn
    //   700: aload_0
    //   701: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   704: aload_0
    //   705: getfield 59	asep:jdField_a_of_type_Ajmm	Lajmm;
    //   708: invokevirtual 715	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lajfe;)V
    //   711: aload_0
    //   712: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   715: iconst_0
    //   716: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   719: checkcast 720	com/tencent/mobileqq/app/MessageHandler
    //   722: aload_3
    //   723: iconst_0
    //   724: aaload
    //   725: checkcast 514	java/lang/Long
    //   728: invokevirtual 724	java/lang/Long:longValue	()J
    //   731: aload_3
    //   732: iconst_1
    //   733: aaload
    //   734: checkcast 424	java/lang/Integer
    //   737: invokevirtual 648	java/lang/Integer:intValue	()I
    //   740: iconst_1
    //   741: invokevirtual 727	com/tencent/mobileqq/app/MessageHandler:c	(JII)V
    //   744: iconst_1
    //   745: anewarray 4	java/lang/Object
    //   748: dup
    //   749: iconst_0
    //   750: iconst_1
    //   751: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   754: aastore
    //   755: areturn
    //   756: aload_3
    //   757: ifnull +9 -> 766
    //   760: aload_3
    //   761: arraylength
    //   762: iconst_1
    //   763: if_icmpge +15 -> 778
    //   766: iconst_1
    //   767: anewarray 4	java/lang/Object
    //   770: dup
    //   771: iconst_0
    //   772: iconst_0
    //   773: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   776: aastore
    //   777: areturn
    //   778: aload_0
    //   779: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   782: aload_0
    //   783: getfield 59	asep:jdField_a_of_type_Ajmm	Lajmm;
    //   786: invokevirtual 715	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lajfe;)V
    //   789: aload_0
    //   790: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: iconst_0
    //   794: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   797: checkcast 720	com/tencent/mobileqq/app/MessageHandler
    //   800: aload_3
    //   801: iconst_0
    //   802: aaload
    //   803: checkcast 403	java/lang/String
    //   806: iconst_1
    //   807: invokevirtual 729	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/lang/String;I)V
    //   810: iconst_1
    //   811: anewarray 4	java/lang/Object
    //   814: dup
    //   815: iconst_0
    //   816: iconst_1
    //   817: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   820: aastore
    //   821: areturn
    //   822: aload_3
    //   823: ifnull -539 -> 284
    //   826: aload_3
    //   827: arraylength
    //   828: iconst_1
    //   829: if_icmplt -545 -> 284
    //   832: iconst_1
    //   833: anewarray 4	java/lang/Object
    //   836: dup
    //   837: iconst_0
    //   838: aload_0
    //   839: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   842: bipush 16
    //   844: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   847: checkcast 731	arip
    //   850: aload_3
    //   851: iconst_0
    //   852: aaload
    //   853: checkcast 403	java/lang/String
    //   856: invokevirtual 733	arip:a	(Ljava/lang/String;)Z
    //   859: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   862: aastore
    //   863: areturn
    //   864: aload_3
    //   865: ifnull -581 -> 284
    //   868: aload_3
    //   869: arraylength
    //   870: iconst_3
    //   871: if_icmplt -587 -> 284
    //   874: aload_3
    //   875: iconst_0
    //   876: aaload
    //   877: checkcast 403	java/lang/String
    //   880: astore 7
    //   882: aload_3
    //   883: iconst_1
    //   884: aaload
    //   885: ifnull +1100 -> 1985
    //   888: aload_3
    //   889: iconst_1
    //   890: aaload
    //   891: checkcast 735	[B
    //   894: checkcast 735	[B
    //   897: astore_1
    //   898: new 532	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   901: dup
    //   902: invokespecial 736	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   905: astore 6
    //   907: aload 6
    //   909: aload_1
    //   910: invokevirtual 740	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   913: pop
    //   914: aload_3
    //   915: iconst_2
    //   916: aaload
    //   917: ifnull +1063 -> 1980
    //   920: aload_3
    //   921: iconst_2
    //   922: aaload
    //   923: checkcast 735	[B
    //   926: checkcast 735	[B
    //   929: astore_3
    //   930: new 542	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   933: dup
    //   934: invokespecial 741	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   937: astore_1
    //   938: aload_1
    //   939: aload_3
    //   940: invokevirtual 742	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   943: pop
    //   944: aload_0
    //   945: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   948: aload 7
    //   950: aload 6
    //   952: aload_1
    //   953: invokestatic 530	ascz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   956: aconst_null
    //   957: areturn
    //   958: astore_1
    //   959: aconst_null
    //   960: astore_1
    //   961: aload_1
    //   962: astore 6
    //   964: goto -50 -> 914
    //   967: aload_3
    //   968: ifnull -684 -> 284
    //   971: aload_3
    //   972: arraylength
    //   973: iconst_1
    //   974: if_icmplt -690 -> 284
    //   977: aload_3
    //   978: iconst_0
    //   979: aaload
    //   980: checkcast 735	[B
    //   983: checkcast 735	[B
    //   986: astore_3
    //   987: new 562	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   990: dup
    //   991: invokespecial 743	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   994: astore_1
    //   995: aload_1
    //   996: aload_3
    //   997: invokevirtual 744	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1000: pop
    //   1001: aload_0
    //   1002: aload_1
    //   1003: invokevirtual 746	asep:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   1006: aconst_null
    //   1007: areturn
    //   1008: astore_3
    //   1009: aconst_null
    //   1010: astore_1
    //   1011: aload_3
    //   1012: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   1015: goto -14 -> 1001
    //   1018: aload_3
    //   1019: ifnull -735 -> 284
    //   1022: aload_3
    //   1023: arraylength
    //   1024: iconst_1
    //   1025: if_icmplt -741 -> 284
    //   1028: aload_3
    //   1029: iconst_0
    //   1030: aaload
    //   1031: instanceof 751
    //   1034: ifeq -750 -> 284
    //   1037: aload_3
    //   1038: iconst_0
    //   1039: aaload
    //   1040: checkcast 751	java/lang/Byte
    //   1043: invokevirtual 755	java/lang/Byte:byteValue	()B
    //   1046: ifne +6 -> 1052
    //   1049: iconst_1
    //   1050: istore 4
    //   1052: aload_0
    //   1053: iload 4
    //   1055: invokevirtual 757	asep:a	(Z)V
    //   1058: aconst_null
    //   1059: areturn
    //   1060: aload_0
    //   1061: getfield 358	asep:jdField_a_of_type_Asdc	Lasdc;
    //   1064: ifnull -780 -> 284
    //   1067: aload_0
    //   1068: getfield 358	asep:jdField_a_of_type_Asdc	Lasdc;
    //   1071: invokevirtual 759	asdc:a	()V
    //   1074: aconst_null
    //   1075: areturn
    //   1076: aload_3
    //   1077: ifnull -793 -> 284
    //   1080: aload_3
    //   1081: arraylength
    //   1082: iconst_1
    //   1083: if_icmpne -799 -> 284
    //   1086: aload_3
    //   1087: iconst_0
    //   1088: aaload
    //   1089: instanceof 735
    //   1092: ifeq -808 -> 284
    //   1095: aload_3
    //   1096: iconst_0
    //   1097: aaload
    //   1098: checkcast 735	[B
    //   1101: checkcast 735	[B
    //   1104: astore_3
    //   1105: aload_3
    //   1106: ifnull -822 -> 284
    //   1109: aload_3
    //   1110: arraylength
    //   1111: ifle -827 -> 284
    //   1114: new 761	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo
    //   1117: dup
    //   1118: invokespecial 762	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:<init>	()V
    //   1121: astore_1
    //   1122: aload_1
    //   1123: aload_3
    //   1124: invokevirtual 763	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1127: pop
    //   1128: aload_0
    //   1129: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1132: bipush 106
    //   1134: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1137: checkcast 527	ascz
    //   1140: astore_3
    //   1141: aload_3
    //   1142: ifnull -858 -> 284
    //   1145: aload_3
    //   1146: aload_1
    //   1147: invokevirtual 766	ascz:a	(Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;)V
    //   1150: aconst_null
    //   1151: areturn
    //   1152: astore_1
    //   1153: aload_1
    //   1154: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   1157: aconst_null
    //   1158: areturn
    //   1159: aload_0
    //   1160: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1163: ifnonnull +19 -> 1182
    //   1166: aload_0
    //   1167: aload_0
    //   1168: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1171: bipush 59
    //   1173: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1176: checkcast 770	ajfw
    //   1179: putfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1182: aload_0
    //   1183: new 772	ases
    //   1186: dup
    //   1187: aload_0
    //   1188: invokespecial 773	ases:<init>	(Lasep;)V
    //   1191: putfield 775	asep:jdField_a_of_type_Ajga	Lajga;
    //   1194: aload_0
    //   1195: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1198: aload_0
    //   1199: invokevirtual 778	ajfw:a	(Ljava/lang/Object;)V
    //   1202: aload_0
    //   1203: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1206: aload_0
    //   1207: getfield 775	asep:jdField_a_of_type_Ajga	Lajga;
    //   1210: invokevirtual 780	ajfw:c	(Ljava/lang/Object;)V
    //   1213: aconst_null
    //   1214: areturn
    //   1215: aload_3
    //   1216: ifnull -932 -> 284
    //   1219: aload_3
    //   1220: arraylength
    //   1221: iconst_1
    //   1222: if_icmpne -938 -> 284
    //   1225: aload_3
    //   1226: iconst_0
    //   1227: aaload
    //   1228: checkcast 403	java/lang/String
    //   1231: astore_1
    //   1232: aload_0
    //   1233: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1236: ifnull +25 -> 1261
    //   1239: iconst_1
    //   1240: anewarray 4	java/lang/Object
    //   1243: dup
    //   1244: iconst_0
    //   1245: aload_0
    //   1246: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1249: aload_1
    //   1250: ldc_w 782
    //   1253: invokevirtual 786	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1256: invokevirtual 789	ajfw:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1259: aastore
    //   1260: areturn
    //   1261: aload_0
    //   1262: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1265: ifnull -981 -> 284
    //   1268: aload_0
    //   1269: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1272: aload_0
    //   1273: invokevirtual 791	ajfw:b	(Ljava/lang/Object;)V
    //   1276: aload_0
    //   1277: getfield 775	asep:jdField_a_of_type_Ajga	Lajga;
    //   1280: ifnull -996 -> 284
    //   1283: aload_0
    //   1284: getfield 768	asep:jdField_a_of_type_Ajfw	Lajfw;
    //   1287: aload_0
    //   1288: getfield 775	asep:jdField_a_of_type_Ajga	Lajga;
    //   1291: invokevirtual 793	ajfw:d	(Ljava/lang/Object;)V
    //   1294: aconst_null
    //   1295: areturn
    //   1296: aload_0
    //   1297: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1300: bipush 106
    //   1302: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1305: checkcast 527	ascz
    //   1308: iconst_1
    //   1309: putfield 794	ascz:a	Z
    //   1312: aconst_null
    //   1313: areturn
    //   1314: aload_3
    //   1315: ifnull -1031 -> 284
    //   1318: aload_3
    //   1319: arraylength
    //   1320: iconst_1
    //   1321: if_icmpne -1037 -> 284
    //   1324: aload_0
    //   1325: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1328: sipush 160
    //   1331: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 796	atax
    //   1337: aload_3
    //   1338: iconst_0
    //   1339: aaload
    //   1340: checkcast 424	java/lang/Integer
    //   1343: invokevirtual 648	java/lang/Integer:intValue	()I
    //   1346: invokevirtual 799	atax:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1349: astore_1
    //   1350: aload_1
    //   1351: ifnull -1067 -> 284
    //   1354: bipush 12
    //   1356: anewarray 4	java/lang/Object
    //   1359: dup
    //   1360: iconst_0
    //   1361: aload_1
    //   1362: getfield 804	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1365: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_1
    //   1371: aload_1
    //   1372: getfield 807	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1375: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1378: aastore
    //   1379: dup
    //   1380: iconst_2
    //   1381: aload_1
    //   1382: getfield 810	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1385: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1388: aastore
    //   1389: dup
    //   1390: iconst_3
    //   1391: aload_1
    //   1392: getfield 813	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1395: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1398: aastore
    //   1399: dup
    //   1400: iconst_4
    //   1401: aload_1
    //   1402: getfield 816	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_5
    //   1408: aload_1
    //   1409: getfield 819	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1412: aastore
    //   1413: dup
    //   1414: bipush 6
    //   1416: aload_1
    //   1417: getfield 822	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1420: invokestatic 517	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1423: aastore
    //   1424: dup
    //   1425: bipush 7
    //   1427: aload_1
    //   1428: getfield 825	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1431: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1434: aastore
    //   1435: dup
    //   1436: bipush 8
    //   1438: aload_1
    //   1439: getfield 828	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1442: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1445: aastore
    //   1446: dup
    //   1447: bipush 9
    //   1449: aload_1
    //   1450: getfield 831	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1453: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1456: aastore
    //   1457: dup
    //   1458: bipush 10
    //   1460: aload_1
    //   1461: getfield 834	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1464: aastore
    //   1465: dup
    //   1466: bipush 11
    //   1468: aload_1
    //   1469: getfield 837	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:isClosed	Z
    //   1472: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1475: aastore
    //   1476: areturn
    //   1477: aload_3
    //   1478: ifnull -1194 -> 284
    //   1481: aload_3
    //   1482: arraylength
    //   1483: iconst_1
    //   1484: if_icmpne -1200 -> 284
    //   1487: aload_3
    //   1488: iconst_0
    //   1489: aaload
    //   1490: checkcast 735	[B
    //   1493: checkcast 735	[B
    //   1496: astore_1
    //   1497: aload_0
    //   1498: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1501: sipush 180
    //   1504: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1507: checkcast 303	alkl
    //   1510: aload_1
    //   1511: invokevirtual 840	alkl:a	([B)V
    //   1514: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1517: ifeq -1233 -> 284
    //   1520: ldc_w 281
    //   1523: iconst_2
    //   1524: ldc_w 842
    //   1527: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1530: aconst_null
    //   1531: areturn
    //   1532: aload_3
    //   1533: ifnull -1249 -> 284
    //   1536: aload_3
    //   1537: iconst_0
    //   1538: aaload
    //   1539: checkcast 403	java/lang/String
    //   1542: astore_1
    //   1543: aload_0
    //   1544: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1547: bipush 106
    //   1549: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1552: checkcast 527	ascz
    //   1555: getfield 845	ascz:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   1558: aload_1
    //   1559: iconst_1
    //   1560: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1563: invokevirtual 851	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1566: pop
    //   1567: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1570: ifeq -1286 -> 284
    //   1573: ldc_w 853
    //   1576: iconst_2
    //   1577: new 105	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1584: ldc_w 855
    //   1587: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: aload_1
    //   1591: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1597: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1600: aconst_null
    //   1601: areturn
    //   1602: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1605: ifeq +13 -> 1618
    //   1608: ldc_w 345
    //   1611: iconst_2
    //   1612: ldc_w 857
    //   1615: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1618: new 859	android/os/Handler
    //   1621: dup
    //   1622: invokestatic 865	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1625: invokespecial 868	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1628: new 870	com/tencent/mobileqq/nearby/NearbyProxy$3
    //   1631: dup
    //   1632: aload_0
    //   1633: invokespecial 871	com/tencent/mobileqq/nearby/NearbyProxy$3:<init>	(Lasep;)V
    //   1636: invokevirtual 872	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1639: pop
    //   1640: aconst_null
    //   1641: areturn
    //   1642: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1645: ifeq +13 -> 1658
    //   1648: ldc_w 345
    //   1651: iconst_2
    //   1652: ldc_w 874
    //   1655: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1658: aload_0
    //   1659: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1662: bipush 51
    //   1664: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1667: checkcast 876	ajjj
    //   1670: astore_1
    //   1671: aload_1
    //   1672: ifnonnull +24 -> 1696
    //   1675: aconst_null
    //   1676: astore_1
    //   1677: aload_1
    //   1678: ifnull -1394 -> 284
    //   1681: iconst_1
    //   1682: anewarray 4	java/lang/Object
    //   1685: dup
    //   1686: iconst_0
    //   1687: aload_1
    //   1688: getfield 882	com/tencent/mobileqq/data/Card:shGender	S
    //   1691: invokestatic 887	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   1694: aastore
    //   1695: areturn
    //   1696: aload_1
    //   1697: aload_0
    //   1698: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1701: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1704: invokevirtual 890	ajjj:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1707: astore_1
    //   1708: goto -31 -> 1677
    //   1711: aload_3
    //   1712: iconst_0
    //   1713: aaload
    //   1714: checkcast 424	java/lang/Integer
    //   1717: astore_1
    //   1718: aload_0
    //   1719: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1722: bipush 70
    //   1724: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1727: checkcast 892	mmy
    //   1730: astore_3
    //   1731: aload_1
    //   1732: invokevirtual 648	java/lang/Integer:intValue	()I
    //   1735: tableswitch	default:+61 -> 1796, 1:+84->1819, 2:+92->1827, 3:+110->1845, 4:+61->1796, 5:+118->1853, 6:+79->1814, 7:+100->1835, 8:+105->1840, 9:+141->1876, 10:+149->1884, 11:+157->1892, 12:+162->1897
    //   1797: astore_1
    //   1798: aload_1
    //   1799: ifnull -1515 -> 284
    //   1802: iconst_1
    //   1803: anewarray 4	java/lang/Object
    //   1806: dup
    //   1807: iconst_0
    //   1808: aload_1
    //   1809: invokevirtual 895	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:toByteArray	()[B
    //   1812: aastore
    //   1813: areturn
    //   1814: aconst_null
    //   1815: astore_1
    //   1816: goto -18 -> 1798
    //   1819: aload_3
    //   1820: invokevirtual 898	mmy:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1823: astore_1
    //   1824: goto -26 -> 1798
    //   1827: aload_3
    //   1828: invokevirtual 900	mmy:b	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1831: astore_1
    //   1832: goto -34 -> 1798
    //   1835: aconst_null
    //   1836: astore_1
    //   1837: goto -39 -> 1798
    //   1840: aconst_null
    //   1841: astore_1
    //   1842: goto -44 -> 1798
    //   1845: aload_3
    //   1846: invokevirtual 902	mmy:c	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1849: astore_1
    //   1850: goto -52 -> 1798
    //   1853: aload_3
    //   1854: invokevirtual 903	mmy:a	()Z
    //   1857: ifeq +14 -> 1871
    //   1860: new 894	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1863: dup
    //   1864: invokespecial 904	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   1867: astore_1
    //   1868: goto -70 -> 1798
    //   1871: aconst_null
    //   1872: astore_1
    //   1873: goto -75 -> 1798
    //   1876: aload_3
    //   1877: invokevirtual 907	mmy:h	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1880: astore_1
    //   1881: goto -83 -> 1798
    //   1884: aload_3
    //   1885: invokevirtual 910	mmy:g	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1888: astore_1
    //   1889: goto -91 -> 1798
    //   1892: aconst_null
    //   1893: astore_1
    //   1894: goto -96 -> 1798
    //   1897: aload_3
    //   1898: invokevirtual 912	mmy:e	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1901: astore_1
    //   1902: goto -104 -> 1798
    //   1905: aload_3
    //   1906: iconst_0
    //   1907: aaload
    //   1908: checkcast 424	java/lang/Integer
    //   1911: astore_1
    //   1912: aload_0
    //   1913: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1916: bipush 70
    //   1918: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1921: checkcast 892	mmy
    //   1924: aload_1
    //   1925: invokevirtual 648	java/lang/Integer:intValue	()I
    //   1928: invokevirtual 914	mmy:a	(I)V
    //   1931: aconst_null
    //   1932: areturn
    //   1933: aload_3
    //   1934: iconst_0
    //   1935: aaload
    //   1936: checkcast 403	java/lang/String
    //   1939: astore_1
    //   1940: iconst_1
    //   1941: anewarray 4	java/lang/Object
    //   1944: dup
    //   1945: iconst_0
    //   1946: aload_0
    //   1947: getfield 61	asep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1950: aload_1
    //   1951: invokestatic 919	com/tencent/mobileqq/dating/MsgBoxListActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   1954: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1957: aastore
    //   1958: areturn
    //   1959: astore_3
    //   1960: goto -949 -> 1011
    //   1963: astore_1
    //   1964: aconst_null
    //   1965: astore_1
    //   1966: goto -1022 -> 944
    //   1969: astore_3
    //   1970: goto -1026 -> 944
    //   1973: astore_1
    //   1974: aload 6
    //   1976: astore_1
    //   1977: goto -1016 -> 961
    //   1980: aconst_null
    //   1981: astore_1
    //   1982: goto -1038 -> 944
    //   1985: aconst_null
    //   1986: astore 6
    //   1988: goto -1074 -> 914
    //   1991: iconst_0
    //   1992: istore 4
    //   1994: goto -1520 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1997	0	this	asep
    //   0	1997	1	paramContext	Context
    //   0	1997	2	paramInt	int
    //   0	1997	3	paramVarArgs	Object[]
    //   1	1992	4	bool1	boolean
    //   617	13	5	bool2	boolean
    //   585	1402	6	localObject	Object
    //   880	69	7	str	String
    // Exception table:
    //   from	to	target	type
    //   888	907	958	java/lang/Throwable
    //   977	995	1008	java/lang/Exception
    //   1114	1141	1152	java/lang/Exception
    //   1145	1150	1152	java/lang/Exception
    //   995	1001	1959	java/lang/Exception
    //   920	938	1963	java/lang/Throwable
    //   938	944	1969	java/lang/Throwable
    //   907	914	1973	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        asfl.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      asey localasey = (asey)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
      if (localasey != null) {
        localasey.a();
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
      if (!asfc.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajry);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asep
 * JD-Core Version:    0.7.0.1
 */