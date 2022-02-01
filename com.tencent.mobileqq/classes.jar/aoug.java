import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class aoug
  implements anlj, anlk
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<JumpActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aoug(JumpActivity paramJumpActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramJumpActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    JumpActivity localJumpActivity = (JumpActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localJumpActivity == null) || (localJumpActivity.app == null)) {}
    WebProcessManager localWebProcessManager;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      ApolloGameUtil.a(localJumpActivity.app, true);
      localWebProcessManager = (WebProcessManager)localJumpActivity.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    } while (localWebProcessManager == null);
    localWebProcessManager.a(100, new aouh(this, localJumpActivity));
    return;
    QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131705392), 0).a();
    ApolloGameUtil.a(localJumpActivity.app, false);
    localJumpActivity.finish();
  }
  
  public void b(boolean paramBoolean)
  {
    JumpActivity localJumpActivity = (JumpActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localJumpActivity == null) || (localJumpActivity.app == null)) {
      return;
    }
    if (paramBoolean)
    {
      amme localamme = (amme)localJumpActivity.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "launch", 0L, 10, 0, 0, 0, "", 222, null);
      localStartCheckParam.extendJson = this.jdField_a_of_type_JavaLangString;
      localStartCheckParam.version = localamme.a(this.jdField_a_of_type_Int);
      ApolloGameUtil.a(localJumpActivity, localStartCheckParam);
      localJumpActivity.d = true;
      localJumpActivity.b();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131705393), 0).a();
    localJumpActivity.finish();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aoug))
    {
      paramObject = (aoug)paramObject;
      if (((this.jdField_a_of_type_JavaLangString == null) && (paramObject.jdField_a_of_type_JavaLangString == null)) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)))) {}
      for (int i = 1; (i != 0) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int); i = 0) {
        return true;
      }
      return false;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */