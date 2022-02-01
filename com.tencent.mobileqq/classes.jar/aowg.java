import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class aowg
  extends aoxg
{
  public aowg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject2 = this.jdField_a_of_type_JavaLangString.split("\\?");
        if (localObject2.length < 2) {
          break label324;
        }
        localIntent.putExtra("extra_key_url_append", localObject2[1]);
        if (localObject2[1] == null) {
          break label324;
        }
        if (localObject2[1].contains("tab=game_center"))
        {
          i = 0;
          j = 1;
          if (QLog.isColorLevel()) {
            QLog.d("CMShowAction", 2, new Object[] { "apollo_store url:", localObject1 });
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = annv.ah;
          }
          if (j != 0)
          {
            ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break;
            }
            localObject1 = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((amsx)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0, new String[] { "0" });
            break;
          }
        }
        else
        {
          if (localObject2[1].contains("tab=other_url&url="))
          {
            localObject1 = URLDecoder.decode(localObject2[1].substring(localObject2[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
            i = 1;
            j = 0;
            continue;
          }
          localObject1 = new HashMap();
          xii.a(localObject2[1], (HashMap)localObject1);
          localObject1 = amsx.b((String)((HashMap)localObject1).get("tab"), true);
          i = 0;
          j = 0;
          continue;
        }
        if (i != 0)
        {
          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
          continue;
        }
        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject2, null);
      }
      catch (Exception localException)
      {
        a("CMShowAction");
        QLog.e("CMShowAction", 1, "doAction error: " + localException.getMessage());
        return false;
      }
      continue;
      label324:
      int i = 0;
      int j = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowg
 * JD-Core Version:    0.7.0.1
 */