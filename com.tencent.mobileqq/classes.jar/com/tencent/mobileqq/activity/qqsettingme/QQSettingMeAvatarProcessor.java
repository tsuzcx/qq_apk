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
  public MutableLiveData<QQSettingMeAvatarViewBean> a;
  private final AvatarObserver a;
  public MutableLiveData<QQSettingMeAvatarRedTouchBean> b;
  private boolean b;
  
  public QQSettingMeAvatarProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QQSettingMeAvatarProcessor.1(this);
  }
  
  public String a()
  {
    return "d_avatar";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeAvatarProcessor.2(this, paramQQSettingMe));
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeAvatarProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   4: ldc 70
    //   6: ldc 72
    //   8: invokevirtual 78	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   11: checkcast 70	com/tencent/mobileqq/tianshu/api/IRedTouchManager
    //   14: ldc 79
    //   16: invokestatic 85	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   19: invokeinterface 89 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokestatic 94	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeRedTouchUtil:a	(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V
    //   29: aload_0
    //   30: getfield 96	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_Boolean	Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: new 98	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean
    //   40: dup
    //   41: invokespecial 99	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: putfield 102	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   52: aload 5
    //   54: getfield 102	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   57: ifnull +37 -> 94
    //   60: aload 5
    //   62: getfield 102	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   65: getfield 108	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   68: invokevirtual 114	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   71: ifeq +23 -> 94
    //   74: aload 5
    //   76: getfield 102	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   79: getfield 108	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   82: invokevirtual 118	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   85: iconst_1
    //   86: if_icmpne +8 -> 94
    //   89: iconst_1
    //   90: istore_1
    //   91: goto +5 -> 96
    //   94: iconst_0
    //   95: istore_1
    //   96: aload 5
    //   98: iload_1
    //   99: putfield 119	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_Boolean	Z
    //   102: aload_0
    //   103: getfield 55	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   106: getstatic 125	com/tencent/mobileqq/app/QQManagerFactory:LOCAL_REDTOUCH_MANAGER	I
    //   109: invokevirtual 129	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   112: checkcast 131	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager
    //   115: astore_3
    //   116: aload_3
    //   117: ldc 132
    //   119: iconst_0
    //   120: invokevirtual 135	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(IZ)Z
    //   123: pop
    //   124: aload_3
    //   125: sipush 10016
    //   128: iconst_0
    //   129: invokevirtual 135	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(IZ)Z
    //   132: pop
    //   133: aload_3
    //   134: sipush 10015
    //   137: iconst_0
    //   138: invokevirtual 135	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(IZ)Z
    //   141: pop
    //   142: aload_3
    //   143: aload_3
    //   144: bipush 249
    //   146: invokevirtual 138	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   149: iconst_1
    //   150: invokevirtual 141	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;Z)Z
    //   153: istore_1
    //   154: aconst_null
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_3
    //   159: iload_1
    //   160: ifne +37 -> 197
    //   163: ldc 143
    //   165: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   168: checkcast 143	com/tencent/mobileqq/profilecard/api/IProfileCardApi
    //   171: aload_0
    //   172: getfield 55	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   175: checkcast 57	com/tencent/mobileqq/app/QQAppInterface
    //   178: invokeinterface 153 2 0
    //   183: ifeq +6 -> 189
    //   186: goto +11 -> 197
    //   189: iconst_0
    //   190: istore_2
    //   191: aload 4
    //   193: astore_3
    //   194: goto +46 -> 240
    //   197: new 155	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo
    //   200: dup
    //   201: invokespecial 156	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   204: astore 4
    //   206: aload 4
    //   208: getfield 160	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   211: iconst_0
    //   212: invokevirtual 166	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   215: aload 4
    //   217: getfield 170	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: ldc 72
    //   222: invokevirtual 175	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   225: aload 4
    //   227: getfield 178	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   230: ldc 72
    //   232: invokevirtual 175	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   235: aload 4
    //   237: astore_3
    //   238: iconst_1
    //   239: istore_2
    //   240: aload 5
    //   242: aload_3
    //   243: putfield 181	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;
    //   246: aload 5
    //   248: iload_2
    //   249: aload 5
    //   251: getfield 119	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_Boolean	Z
    //   254: ior
    //   255: putfield 119	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_Boolean	Z
    //   258: aload_0
    //   259: getfield 55	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   262: getstatic 184	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   265: invokevirtual 129	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   268: checkcast 186	com/tencent/mobileqq/app/FriendsManager
    //   271: aload_0
    //   272: getfield 55	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   275: invokevirtual 189	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   278: iconst_0
    //   279: invokevirtual 192	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   282: astore_3
    //   283: aload_3
    //   284: ifnonnull +12 -> 296
    //   287: aload 5
    //   289: iconst_1
    //   290: putfield 193	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_b_of_type_Boolean	Z
    //   293: goto +45 -> 338
    //   296: aload 5
    //   298: iconst_0
    //   299: putfield 193	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_b_of_type_Boolean	Z
    //   302: aload 5
    //   304: aload_3
    //   305: getfield 199	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   308: putfield 201	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_Long	J
    //   311: aload 5
    //   313: aload_3
    //   314: invokevirtual 204	com/tencent/mobileqq/data/ExtensionInfo:isPendantValid	()Z
    //   317: putfield 207	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:c	Z
    //   320: aload 5
    //   322: aload_3
    //   323: getfield 210	com/tencent/mobileqq/data/ExtensionInfo:pendantDiyId	I
    //   326: putfield 212	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_Int	I
    //   329: aload 5
    //   331: aload_3
    //   332: getfield 216	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   335: putfield 218	com/tencent/mobileqq/activity/qqsettingme/bean/QQSettingMeAvatarRedTouchBean:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   338: aload_0
    //   339: getfield 22	com/tencent/mobileqq/activity/qqsettingme/QQSettingMeAvatarProcessor:jdField_b_of_type_AndroidxLifecycleMutableLiveData	Landroidx/lifecycle/MutableLiveData;
    //   342: aload 5
    //   344: invokevirtual 222	androidx/lifecycle/MutableLiveData:postValue	(Ljava/lang/Object;)V
    //   347: return
    //   348: astore 4
    //   350: goto -112 -> 238
    //   353: astore_3
    //   354: goto -119 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	QQSettingMeAvatarProcessor
    //   0	357	1	paramBoolean	boolean
    //   190	65	2	i	int
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
  
  public void b()
  {
    super.b();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (localAvatarPendantManager != null) {
        localAvatarPendantManager.c();
      }
    }
    QQValueInfoManage.a().a("setting");
  }
  
  public void f()
  {
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      g();
    }
    ((DynamicAvatarManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
  }
  
  public void g()
  {
    QQSettingMeAvatarViewBean localQQSettingMeAvatarViewBean = new QQSettingMeAvatarViewBean();
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
    localQQSettingMeAvatarViewBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable = FaceDrawable.getUserFaceDrawable((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, (String)localObject, (byte)3);
    localObject = ((FriendsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), false);
    if (localObject == null)
    {
      localQQSettingMeAvatarViewBean.jdField_a_of_type_Boolean = true;
    }
    else
    {
      localQQSettingMeAvatarViewBean.jdField_a_of_type_Boolean = false;
      localQQSettingMeAvatarViewBean.jdField_a_of_type_Long = ((ExtensionInfo)localObject).pendantId;
      localQQSettingMeAvatarViewBean.jdField_b_of_type_Boolean = ((ExtensionInfo)localObject).isPendantValid();
      localQQSettingMeAvatarViewBean.jdField_a_of_type_Int = ((ExtensionInfo)localObject).pendantDiyId;
      localQQSettingMeAvatarViewBean.jdField_a_of_type_JavaLangString = ((ExtensionInfo)localObject).uin;
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localQQSettingMeAvatarViewBean);
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
    localAllInOne.lastActivity = 1;
    localAllInOne.profileEntryType = 8;
    ProfileUtils.openProfileCardForResult(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localAllInOne, 1009);
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80072D7", "0X80072D7", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.jdField_a_of_type_Int = QQSettingMe.jdField_a_of_type_Int;
    if (((Boolean)paramView.getTag()).booleanValue()) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8006726", "0X8006726", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeAvatarProcessor
 * JD-Core Version:    0.7.0.1
 */