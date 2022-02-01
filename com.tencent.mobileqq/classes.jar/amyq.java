import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amyq
  extends amyk
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static boolean d;
  long a;
  public DrawerPushItem a;
  int b;
  int c;
  
  public amyq(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_Int = 7;
    this.jdField_a_of_type_Int = paramDrawerPushItem.priority;
    jdField_a_of_type_JavaLangString = paramDrawerPushItem.content;
    this.jdField_b_of_type_Int = paramDrawerPushItem.action_id;
    jdField_b_of_type_JavaLangString = paramDrawerPushItem.ext_url;
    jdField_d_of_type_JavaLangString = paramDrawerPushItem.msg_id;
    jdField_c_of_type_JavaLangString = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.jdField_c_of_type_Int = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu) {
        this.jdField_a_of_type_Boolean = false;
      }
      if (!a())
      {
        jdField_d_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
      }
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.jdField_c_of_type_Int = 6;
      } else {
        this.jdField_c_of_type_Int = 9;
      }
    }
  }
  
  public int a(angr paramangr, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)) {
      return super.a(paramangr, paramInt, paramAppInterface, paramContext);
    }
    int i;
    boolean bool;
    if (this.jdField_b_of_type_Int > annv.jdField_a_of_type_Int)
    {
      i = 3;
      bool = ApolloUtil.c(5, this.jdField_b_of_type_Int);
      if (this.jdField_b_of_type_Int <= 0) {
        break label225;
      }
      if (!bool) {
        break label172;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = this.jdField_b_of_type_Int;
      paramAppInterface.actionType = 0;
      paramInt = 6;
      angi.a(paramangr, 6, paramAppInterface);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.jdField_b_of_type_Int), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
      }
      return 0;
      i = 2;
      break;
      label172:
      super.a(paramangr, i, paramInt, paramAppInterface, paramContext);
      aniv.a(paramAppInterface, ApolloUtil.c(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtil.d(this.jdField_b_of_type_Int));
      paramInt = 0;
      continue;
      label225:
      super.a(paramangr, i, paramInt, paramAppInterface, paramContext);
      paramInt = 0;
    }
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {}
    label31:
    label249:
    label255:
    do
    {
      return;
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu))
      {
        bool = true;
        jdField_d_of_type_Boolean = bool;
        this.jdField_b_of_type_Boolean = true;
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          angi.a(paramangr, jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.bubble_res_id);
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramangr = (amsx)paramQQAppInterface.getManager(153);
        QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, show, advId=", jdField_d_of_type_JavaLangString });
        paramContext = jdField_d_of_type_JavaLangString;
        if (!paramangr.jdField_d_of_type_Boolean) {
          break label249;
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { paramContext, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
          break;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath)) {
          break label255;
        }
        QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, show, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
        paramangr = (bbav)paramQQAppInterface.getManager(36);
        paramangr.b(paramangr.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath), "");
        return;
        bool = false;
        break label31;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId == 0);
    amsx.a(101, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
    }
    paramQQAppInterface = (amsx)paramQQAppInterface.getManager(153);
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts;
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu))
    {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {}
    label88:
    do
    {
      return;
      a(paramQQAppInterface);
      amsx localamsx = (amsx)paramQQAppInterface.getManager(153);
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId > 0)
      {
        QLog.d("AplloDrawerStatus", 1, "onBubbleClick play game id:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId);
        ApolloGameUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId, 0L, 0, null, 323, null);
        QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, click, advId=", jdField_d_of_type_JavaLangString });
        paramContext = jdField_d_of_type_JavaLangString;
        if (!localamsx.jdField_d_of_type_Boolean) {
          break label266;
        }
      }
      for (int i = 0;; i = 1)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { paramContext, String.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
          break;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath)) {
          break label271;
        }
        QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, click, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
        ((bbav)paramQQAppInterface.getManager(36)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath);
        return;
        localamsx.a(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url, "drawer");
        break label88;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId == 0);
    label266:
    label271:
    amsx.a(102, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, angr paramangr)
  {
    super.a(paramQQAppInterface, paramangr);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    do
    {
      return;
      jdField_d_of_type_Boolean = false;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L);
    a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    paramangr = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramangr.show_sum += 1;
    paramQQAppInterface = (amsx)paramQQAppInterface.getManager(153);
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts) && ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu)))
    {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum < this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts);
  }
  
  public void b(angr paramangr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyq
 * JD-Core Version:    0.7.0.1
 */