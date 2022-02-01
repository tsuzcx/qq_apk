package com.tencent.mobileqq.apollo.api.impl.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.api.impl.model.App3DConfig;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class BubbleProducer
  implements ApolloStatusUpdateListener
{
  private int jdField_a_of_type_Int;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  private final ApolloManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public BubbleProducer(ApolloManagerServiceImpl paramApolloManagerServiceImpl, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl = paramApolloManagerServiceImpl;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    SharedPreferences localSharedPreferences;
    if (paramQQAppInterface != null)
    {
      localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0);
      if ((localSharedPreferences == null) || (localSharedPreferences.getInt("key_panel_meet_3d_action", 0) != 1)) {
        break label152;
      }
      bool1 = true;
      label78:
      this.jdField_a_of_type_Boolean = bool1;
      if ((localSharedPreferences == null) || (localSharedPreferences.getInt("key_panel_shown_guide_for_action", 0) != 1)) {
        break label157;
      }
      bool1 = true;
      label104:
      this.c = bool1;
      if ((localSharedPreferences == null) || (localSharedPreferences.getInt("key_panel_shown_guide_for_json", 0) != 1)) {
        break label162;
      }
    }
    label152:
    label157:
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      paramApolloManagerServiceImpl.addApolloStatusUpdateListener(this);
      ApolloBubbleLogic.a(paramQQAppInterface);
      return;
      localSharedPreferences = null;
      break;
      bool1 = false;
      break label78;
      bool1 = false;
      break label104;
    }
  }
  
  private void a()
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.is3dAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloUserStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      a();
      return;
    }
    finally {}
  }
  
  public void a(Map<String, String> paramMap, int paramInt, String paramString)
  {
    int i = 0;
    label449:
    for (;;)
    {
      try
      {
        if (!App3DConfig.jdField_a_of_type_Boolean)
        {
          QLog.d("ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv show: ", Boolean.valueOf(App3DConfig.jdField_a_of_type_Boolean) });
          return;
        }
        try
        {
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localQQAppInterface == null) {
            break label449;
          }
          localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("apollo_sp" + localQQAppInterface.getCurrentUin(), 0);
          if (localSharedPreferences != null) {
            i = localSharedPreferences.getInt("key_3d_bubble_ad_id", 0);
          }
          QLog.d("ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv oldAdId=", Integer.valueOf(i), ", newAdId=", Integer.valueOf(paramInt) });
          if (paramInt == i) {
            continue;
          }
          DrawerPushItem localDrawerPushItem = new DrawerPushItem();
          localDrawerPushItem.is_reddot = 0;
          localDrawerPushItem.msg_id = "aio_panel_bubble_guide3d_push";
          localDrawerPushItem.msg_type = 10;
          localDrawerPushItem.priority = 900;
          i = (int)Long.parseLong((String)paramMap.get("startTime")) / 1000;
          localDrawerPushItem.start_ts = i;
          int j = (int)NetConnInfoCenter.getServerTime();
          localDrawerPushItem.end_ts = ((int)Long.parseLong((String)paramMap.get("endTime")) / 1000 - i + j);
          localDrawerPushItem.send_time = i;
          localDrawerPushItem.content = ((String)paramMap.get("bubbleText"));
          localDrawerPushItem.tianshuAdId = paramInt;
          localDrawerPushItem.tianshuTraceInfo = paramString;
          localDrawerPushItem.show_counts = Integer.parseInt((String)paramMap.get("showCount"));
          if (localDrawerPushItem.show_counts == 0) {
            localDrawerPushItem.show_counts = 1;
          }
          i = Integer.parseInt((String)paramMap.get("packageId"));
          this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.addPushItem(localDrawerPushItem);
          localSharedPreferences.edit().putInt("key_3d_bubble_ad_id", paramInt).commit();
          b(true);
          if ((this.e) && (localQQAppInterface != null)) {
            ((ApolloGameManager)localQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a.a(localQQAppInterface);
          }
          QLog.d("ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv push bubble:", localDrawerPushItem.toString(), " ,packageId", Integer.valueOf(i) });
        }
        catch (Exception paramMap)
        {
          QLog.e("ApolloManager", 1, "parseGuide3DBubbleAdv Exception:", paramMap);
        }
        continue;
        SharedPreferences localSharedPreferences = null;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.c = paramBoolean;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null)
      {
        localObject1 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        ((SharedPreferences.Editor)localObject1).putInt("key_panel_shown_guide_for_action", i).commit();
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      this.d = paramBoolean;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null)
      {
        localObject1 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        ((SharedPreferences.Editor)localObject1).putInt("key_panel_shown_guide_for_json", i).commit();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:d	Z
    //   6: ifeq +17 -> 23
    //   9: getstatic 256	com/tencent/mobileqq/apollo/task/ApolloBubbleLogic:jdField_a_of_type_Boolean	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +9 -> 23
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_1
    //   25: goto -6 -> 19
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BubbleProducer
    //   12	13	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
  
  /* Error */
  public void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 226	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:e	Z
    //   7: iload_1
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokespecial 27	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:a	()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 258	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   22: ifnull -7 -> 15
    //   25: aload_0
    //   26: getfield 23	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   29: aload_0
    //   30: getfield 258	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   33: invokevirtual 261	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:removePushItem	(Lcom/tencent/mobileqq/DrawerPushItem;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 258	com/tencent/mobileqq/apollo/api/impl/aio/BubbleProducer:jdField_a_of_type_ComTencentMobileqqDrawerPushItem	Lcom/tencent/mobileqq/DrawerPushItem;
    //   41: goto -26 -> 15
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BubbleProducer
    //   0	49	1	paramBoolean	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	15	44	finally
    //   18	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.aio.BubbleProducer
 * JD-Core Version:    0.7.0.1
 */