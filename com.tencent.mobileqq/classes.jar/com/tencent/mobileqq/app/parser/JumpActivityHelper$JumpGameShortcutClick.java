package com.tencent.mobileqq.app.parser;

import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.GameCityShortcutClick;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.GameShortcutClick;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class JumpActivityHelper$JumpGameShortcutClick
  implements ApolloGameUtil.GameCityShortcutClick, ApolloGameUtil.GameShortcutClick
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<JumpActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public JumpActivityHelper$JumpGameShortcutClick(JumpActivity paramJumpActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramJumpActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    JumpActivity localJumpActivity = (JumpActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localJumpActivity == null) || (localJumpActivity.app == null)) {}
    IWebProcessManagerService localIWebProcessManagerService;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      ApolloGameUtil.a(localJumpActivity.app, true);
      localIWebProcessManagerService = (IWebProcessManagerService)localJumpActivity.app.getRuntimeService(IWebProcessManagerService.class, "");
    } while (localIWebProcessManagerService == null);
    localIWebProcessManagerService.startWebProcess(100, new JumpActivityHelper.JumpGameShortcutClick.1(this, localJumpActivity));
    return;
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131705935), 0).a();
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
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)localJumpActivity.app.getRuntimeService(IApolloManagerService.class, "all");
      CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "launch", 0L, 10, 0, 0, 0, "", 222, null);
      localStartCheckParam.extendJson = this.jdField_a_of_type_JavaLangString;
      localStartCheckParam.version = localIApolloManagerService.getApolloGameLocalVersion(this.jdField_a_of_type_Int);
      ApolloGameUtil.a(localJumpActivity, localStartCheckParam);
      localJumpActivity.d = true;
      localJumpActivity.b();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131705936), 0).a();
    localJumpActivity.finish();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof JumpGameShortcutClick))
    {
      paramObject = (JumpGameShortcutClick)paramObject;
      if (((this.jdField_a_of_type_JavaLangString == null) && (paramObject.jdField_a_of_type_JavaLangString == null)) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)))) {}
      for (int i = 1; (i != 0) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int); i = 0) {
        return true;
      }
      return false;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.JumpGameShortcutClick
 * JD-Core Version:    0.7.0.1
 */