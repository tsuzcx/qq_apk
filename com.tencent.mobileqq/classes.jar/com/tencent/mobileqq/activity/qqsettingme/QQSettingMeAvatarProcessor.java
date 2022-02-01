package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarRedTouchBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarViewBean;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQSettingMeAvatarProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<QQSettingMeAvatarViewBean> a = new MutableLiveData();
  public MutableLiveData<QQSettingMeAvatarRedTouchBean> b = new MutableLiveData();
  private boolean i;
  private final AvatarObserver j = new QQSettingMeAvatarProcessor.1(this);
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.e, new QQSettingMeAvatarProcessor.2(this, paramQQSettingMe));
    this.a.observe(this.e, new QQSettingMeAvatarProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.i) && (this.c != null))
    {
      ((QQAppInterface)this.c).removeObserver(this.j);
      this.c = paramAppRuntime;
      ((QQAppInterface)this.c).addObserver(this.j, true);
      return;
    }
    this.c = paramAppRuntime;
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:c	Lmqq/app/AppRuntime;
    //   4: ldc 71
    //   6: ldc 73
    //   8: invokevirtual 79	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   11: checkcast 71	com/tencent/mobileqq/tianshu/api/IRedTouchManager
    //   14: ldc 80
    //   16: invokestatic 86	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   19: invokeinterface 90 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokestatic 95	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeRedTouchUtil:a	(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V
    //   29: aload_0
    //   30: getfield 98	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:g	Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: new 100	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean
    //   40: dup
    //   41: invokespecial 101	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: putfield 104	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:b	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   52: aload 5
    //   54: getfield 104	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:b	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   57: ifnull +37 -> 94
    //   60: aload 5
    //   62: getfield 104	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:b	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   65: getfield 110	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   68: invokevirtual 116	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   71: ifeq +23 -> 94
    //   74: aload 5
    //   76: getfield 104	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:b	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   79: getfield 110	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   82: invokevirtual 120	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   85: iconst_1
    //   86: if_icmpne +8 -> 94
    //   89: iconst_1
    //   90: istore_1
    //   91: goto +5 -> 96
    //   94: iconst_0
    //   95: istore_1
    //   96: aload 5
    //   98: iload_1
    //   99: putfield 122	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:a	Z
    //   102: aload_0
    //   103: getfield 56	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:c	Lmqq/app/AppRuntime;
    //   106: getstatic 128	com/tencent/mobileqq/app/QQManagerFactory:LOCAL_REDTOUCH_MANAGER	I
    //   109: invokevirtual 132	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   112: checkcast 134	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager
    //   115: astore_3
    //   116: aload_3
    //   117: ldc 135
    //   119: iconst_0
    //   120: invokevirtual 138	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:b	(IZ)Z
    //   123: pop
    //   124: aload_3
    //   125: sipush 10016
    //   128: iconst_0
    //   129: invokevirtual 138	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:b	(IZ)Z
    //   132: pop
    //   133: aload_3
    //   134: sipush 10015
    //   137: iconst_0
    //   138: invokevirtual 138	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:b	(IZ)Z
    //   141: pop
    //   142: aload_3
    //   143: aload_3
    //   144: bipush 249
    //   146: invokevirtual 141	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   149: iconst_1
    //   150: invokevirtual 144	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;Z)Z
    //   153: istore_1
    //   154: aconst_null
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_3
    //   159: iload_1
    //   160: ifne +37 -> 197
    //   163: ldc 146
    //   165: invokestatic 152	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   168: checkcast 146	com/tencent/mobileqq/profilecard/api/IProfileCardApi
    //   171: aload_0
    //   172: getfield 56	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:c	Lmqq/app/AppRuntime;
    //   175: checkcast 58	com/tencent/mobileqq/app/QQAppInterface
    //   178: invokeinterface 156 2 0
    //   183: ifeq +6 -> 189
    //   186: goto +11 -> 197
    //   189: iconst_0
    //   190: istore_2
    //   191: aload 4
    //   193: astore_3
    //   194: goto +46 -> 240
    //   197: new 158	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo
    //   200: dup
    //   201: invokespecial 159	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   204: astore 4
    //   206: aload 4
    //   208: getfield 163	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   211: iconst_0
    //   212: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   215: aload 4
    //   217: getfield 173	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: ldc 73
    //   222: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   225: aload 4
    //   227: getfield 181	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   230: ldc 73
    //   232: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   235: aload 4
    //   237: astore_3
    //   238: iconst_1
    //   239: istore_2
    //   240: aload 5
    //   242: aload_3
    //   243: putfield 184	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:c	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;
    //   246: aload 5
    //   248: iload_2
    //   249: aload 5
    //   251: getfield 122	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:a	Z
    //   254: ior
    //   255: putfield 122	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:a	Z
    //   258: aload_0
    //   259: getfield 56	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:c	Lmqq/app/AppRuntime;
    //   262: getstatic 187	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   265: invokevirtual 132	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   268: checkcast 189	com/tencent/mobileqq/app/FriendsManager
    //   271: aload_0
    //   272: getfield 56	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:c	Lmqq/app/AppRuntime;
    //   275: invokevirtual 193	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   278: iconst_0
    //   279: invokevirtual 197	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   282: astore_3
    //   283: aload_3
    //   284: ifnonnull +12 -> 296
    //   287: aload 5
    //   289: iconst_1
    //   290: putfield 199	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:d	Z
    //   293: goto +45 -> 338
    //   296: aload 5
    //   298: iconst_0
    //   299: putfield 199	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:d	Z
    //   302: aload 5
    //   304: aload_3
    //   305: getfield 205	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   308: putfield 207	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:e	J
    //   311: aload 5
    //   313: aload_3
    //   314: invokevirtual 210	com/tencent/mobileqq/data/ExtensionInfo:isPendantValid	()Z
    //   317: putfield 213	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:f	Z
    //   320: aload 5
    //   322: aload_3
    //   323: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:pendantDiyId	I
    //   326: putfield 219	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:h	I
    //   329: aload 5
    //   331: aload_3
    //   332: getfield 223	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   335: putfield 225	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:g	Ljava/lang/String;
    //   338: aload_0
    //   339: getfield 24	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:b	Landroidx/lifecycle/MutableLiveData;
    //   342: aload 5
    //   344: invokevirtual 229	androidx/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   347: return
    //   348: astore 4
    //   350: goto -112 -> 238
    //   353: astore_3
    //   354: goto -119 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	QQSettingMeAvatarProcessor
    //   0	357	1	paramBoolean	boolean
    //   190	65	2	k	int
    //   24	308	3	localObject	Object
    //   353	1	3	localException1	java.lang.Exception
    //   155	81	4	localRedTypeInfo	com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo
    //   348	1	4	localException2	java.lang.Exception
    //   44	299	5	localQQSettingMeAvatarRedTouchBean	QQSettingMeAvatarRedTouchBean
    // Exception table:
    //   from	to	target	type
    //   197	206	348	java/lang/Exception
    //   206	235	353	java/lang/Exception
  }
  
  public String b()
  {
    return "d_avatar";
  }
  
  public void d()
  {
    super.d();
    if ((!this.i) && (this.c != null))
    {
      ((QQAppInterface)this.c).addObserver(this.j, true);
      this.i = true;
    }
  }
  
  public void f()
  {
    if ((this.i) && (this.c != null)) {
      ((QQAppInterface)this.c).removeObserver(this.j);
    }
    if (this.c != null)
    {
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.c.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (localAvatarPendantManager != null) {
        localAvatarPendantManager.c();
      }
    }
    QQValueInfoManage.a().a("setting");
  }
  
  public void h()
  {
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      i();
    }
    ((DynamicAvatarManager)this.c.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b(this.c.getCurrentAccountUin());
  }
  
  public void i()
  {
    QQSettingMeAvatarViewBean localQQSettingMeAvatarViewBean = new QQSettingMeAvatarViewBean();
    Object localObject = this.c.getCurrentUin();
    localQQSettingMeAvatarViewBean.a = FaceDrawable.getUserFaceDrawable((QQAppInterface)this.c, (String)localObject, (byte)3);
    localObject = ((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.c.getCurrentAccountUin(), false);
    if (localObject == null)
    {
      localQQSettingMeAvatarViewBean.b = true;
    }
    else
    {
      localQQSettingMeAvatarViewBean.b = false;
      localQQSettingMeAvatarViewBean.c = ((ExtensionInfo)localObject).pendantId;
      localQQSettingMeAvatarViewBean.d = ((ExtensionInfo)localObject).isPendantValid();
      localQQSettingMeAvatarViewBean.f = ((ExtensionInfo)localObject).pendantDiyId;
      localQQSettingMeAvatarViewBean.e = ((ExtensionInfo)localObject).uin;
    }
    this.a.postValue(localQQSettingMeAvatarViewBean);
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    AllInOne localAllInOne = new AllInOne(this.c.getCurrentAccountUin(), 0);
    localAllInOne.lastActivity = 1;
    localAllInOne.profileEntryType = 8;
    ProfileUtils.openProfileCardForResult(this.d, localAllInOne, 1009);
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.c);
    ReportController.b(this.c, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
    ReportController.b(this.c, "CliOper", "", "", "0X80072D7", "0X80072D7", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
    if (((Boolean)paramView.getTag()).booleanValue()) {
      ReportController.b(this.c, "CliOper", "", "", "0X8006726", "0X8006726", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeAvatarProcessor
 * JD-Core Version:    0.7.0.1
 */