import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class anhq
  implements anco
{
  public static boolean a;
  private int jdField_a_of_type_Int = 1;
  ancc jdField_a_of_type_Ancc;
  private boolean b;
  private boolean c;
  
  public anhq(ancc paramancc)
  {
    this.jdField_a_of_type_Ancc = paramancc;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.b(), 0) >= localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3)) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void b()
  {
    if (!this.b) {}
    Object localObject;
    amma localamma;
    amme localamme;
    do
    {
      do
      {
        return;
        this.b = false;
        localObject = this.jdField_a_of_type_Ancc.a();
      } while (localObject == null);
      localamma = (amma)((QQAppInterface)localObject).getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      localamme = (amme)((QQAppInterface)localObject).getManager(QQManagerFactory.APOLLO_MANAGER);
      localObject = null;
      if (localamma.jdField_a_of_type_Anho != null) {
        localObject = localamma.jdField_a_of_type_Anho.a();
      }
    } while ((localObject == null) || ((((DrawerPushItem)localObject).msg_type != 7) && (((DrawerPushItem)localObject).msg_type != 9) && (((DrawerPushItem)localObject).msg_type != 2) && (((DrawerPushItem)localObject).msg_type != 10)));
    QLog.i("ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
    localamme.a((DrawerPushItem)localObject);
    localamma.jdField_a_of_type_Anho.a();
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_";
    String str1 = (String)localObject1 + ApolloUtil.b();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    if (((SharedPreferences)localObject2).contains(str1)) {
      localEditor.putInt(str1, ((SharedPreferences)localObject2).getInt(str1, 0) + 1);
    }
    for (;;)
    {
      localEditor.commit();
      a(paramQQAppInterface);
      return;
      Object localObject3 = ((SharedPreferences)localObject2).getAll();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith((String)localObject1))) {
            ((List)localObject2).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ancc != null)
    {
      amma localamma = (amma)this.jdField_a_of_type_Ancc.a().getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      localamma.jdField_a_of_type_Int = -1;
      localamma.a(-1, -1);
    }
    this.jdField_a_of_type_Ancc = null;
    this.c = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    label304:
    for (;;)
    {
      return;
      b();
      return;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_Ancc.a();
      if ((localQQAppInterface != null) && (this.jdField_a_of_type_Ancc.a() != null) && (anck.a(localQQAppInterface) != null))
      {
        SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        int i = localSharedPreferences.getInt(localQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.b(), 0);
        int j = localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3);
        if (i >= j)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO Bubble show count limited:", Integer.valueOf(j) });
          }
        }
        else if (this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "current AIO has play bubble, wait for next time");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "start play bubble");
          }
          if (a(localQQAppInterface)) {
            paramInt = 2;
          }
          for (;;)
          {
            if (paramInt <= 0) {
              break label304;
            }
            this.b = true;
            this.c = true;
            b(localQQAppInterface);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO bubble play type:", Integer.valueOf(paramInt), ",current count:", Integer.valueOf(i), ",maxCount:", Integer.valueOf(j) });
            return;
            if (b(localQQAppInterface)) {
              paramInt = 3;
            } else {
              paramInt = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    amma localamma = (amma)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
    if (localamma.jdField_a_of_type_Anho != null) {}
    for (DrawerPushItem localDrawerPushItem = localamma.jdField_a_of_type_Anho.a();; localDrawerPushItem = null)
    {
      if ((localDrawerPushItem != null) && (localDrawerPushItem.msg_type != 7) && (localamma.jdField_a_of_type_Anho.a(paramQQAppInterface, this.jdField_a_of_type_Ancc.jdField_a_of_type_Int)))
      {
        if (localDrawerPushItem.reddotGameId > 0)
        {
          localamma.jdField_a_of_type_Int = localDrawerPushItem.reddotGameId;
          localamma.a(localDrawerPushItem.reddotGameId, 3);
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(this.jdField_a_of_type_Ancc.jdField_a_of_type_Int), 3, new String[] { String.valueOf(localDrawerPushItem.reddotGameId), String.valueOf(localDrawerPushItem.reddotRedId) });
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(localDrawerPushItem.reddotGameId) });
          }
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    amma localamma = (amma)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
    if (localamma.jdField_a_of_type_Anho != null) {}
    for (Object localObject = localamma.jdField_a_of_type_Anho.a();; localObject = null)
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type == 7)
        {
          localObject = (amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
          bool1 = bool2;
          if (localamma.jdField_a_of_type_Anho.a(paramQQAppInterface, this.jdField_a_of_type_Ancc.jdField_a_of_type_Int))
          {
            if (localObject != null) {
              ((amme)localObject).o = true;
            }
            VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", ApolloUtil.b(this.jdField_a_of_type_Ancc.jdField_a_of_type_Int), 0, new String[] { String.valueOf(1) });
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhq
 * JD-Core Version:    0.7.0.1
 */