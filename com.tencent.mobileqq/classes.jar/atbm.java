import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyTribeAppController.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class atbm
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apwm jdField_a_of_type_Apwm = new atbo(this);
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString = "NearbyTribeAppController";
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { ajya.a(2131707397), ajya.a(2131707396), "好看的人都在用兴趣部落APP", ajya.a(2131707395), ajya.a(2131707393), "看看好友在兴趣部落APP玩什么？" };
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = { ajya.a(2131707386), ajya.a(2131707389), "好看的人都在用兴趣部落APP", ajya.a(2131707392), ajya.a(2131707391) };
  
  public atbm(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext)) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131694611), 0).a();
    }
    do
    {
      do
      {
        return;
        if ("0".equals(bbfr.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe"))) {
          break;
        }
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
      TroopBarPublishUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_call", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "invokeTribeOpenOrDownload,isActivate=false");
    return;
    ThreadManager.post(new NearbyTribeAppController.1(this), 8, null, true);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_download", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
  }
  
  public void a(TextView paramTextView)
  {
    String str = bbfr.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe");
    Random localRandom = new Random();
    int i;
    if (!"0".equals(str))
    {
      i = localRandom.nextInt(this.jdField_b_of_type_ArrayOfJavaLangString.length);
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[i];
      paramTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (paramTextView = "exp_app_call";; paramTextView = "exp_app_download")
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", paramTextView, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
      return;
      i = localRandom.nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      paramTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      apwe.a("http://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", new atbn(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131707394), 0).b(50);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbm
 * JD-Core Version:    0.7.0.1
 */