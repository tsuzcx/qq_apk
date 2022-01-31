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

public class atbk
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apwk jdField_a_of_type_Apwk = new atbm(this);
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString = "NearbyTribeAppController";
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { ajyc.a(2131707386), ajyc.a(2131707385), "好看的人都在用兴趣部落APP", ajyc.a(2131707384), ajyc.a(2131707382), "看看好友在兴趣部落APP玩什么？" };
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = { ajyc.a(2131707375), ajyc.a(2131707378), "好看的人都在用兴趣部落APP", ajyc.a(2131707381), ajyc.a(2131707380) };
  
  public atbk(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext)) {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131694610), 0).a();
    }
    do
    {
      do
      {
        return;
        if ("0".equals(bbfd.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe"))) {
          break;
        }
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
      TroopBarPublishUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_call", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
      return;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "invokeTribeOpenOrDownload,isActivate=false");
    return;
    ThreadManager.post(new NearbyTribeAppController.1(this), 8, null, true);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_download", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
  }
  
  public void a(TextView paramTextView)
  {
    String str = bbfd.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe");
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", paramTextView, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
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
      apwc.a("http://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", new atbl(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131707383), 0).b(50);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbk
 * JD-Core Version:    0.7.0.1
 */