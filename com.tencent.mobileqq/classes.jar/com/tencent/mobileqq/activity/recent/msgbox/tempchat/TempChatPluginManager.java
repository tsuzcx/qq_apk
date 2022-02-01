package com.tencent.mobileqq.activity.recent.msgbox.tempchat;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class TempChatPluginManager
  implements Manager
{
  public static ArrayList<Integer> a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, AbstractTempChatPlugin> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new TempChatPluginManager.1();
  }
  
  public TempChatPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      a();
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  /* Error */
  public AbstractTempChatPlugin a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/mobileqq/activity/recent/msgbox/tempchat/TempChatPluginManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 28	com/tencent/mobileqq/activity/recent/msgbox/tempchat/TempChatPluginManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 46 2 0
    //   22: checkcast 48	com/tencent/mobileqq/activity/recent/msgbox/tempchat/AbstractTempChatPlugin
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	TempChatPluginManager
    //   0	40	1	paramInt	int
    //   25	7	2	localAbstractTempChatPlugin	AbstractTempChatPlugin
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return false;
    }
    try
    {
      paramString = ((AbstractTempChatPlugin)localObject).a(paramString);
      if (paramString.startsWith("http"))
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramString);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject, paramString);
        paramContext.startActivity((Intent)localObject);
      }
      else if (paramString.startsWith("mqqapi"))
      {
        paramContext = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString);
        if (paramContext != null) {
          paramContext.a();
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager
 * JD-Core Version:    0.7.0.1
 */