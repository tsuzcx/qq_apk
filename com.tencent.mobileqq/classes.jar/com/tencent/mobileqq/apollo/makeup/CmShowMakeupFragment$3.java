package com.tencent.mobileqq.apollo.makeup;

import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CELifeCycle;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.ViewUtils;

class CmShowMakeupFragment$3
  implements CELifeCycle
{
  CmShowMakeupFragment$3(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public void onFirstFrame()
  {
    CmShowMakeupFragment.d(this.a).runScriptFile("Contents/JS/engine.js");
    CmShowMakeupFragment.d(this.a).runScriptFile("Contents/JS/CECMShowDressUp.js");
    CmShowMakeupFragment.d(this.a).evaluateJsSync(String.format("gCEDressUp.engineBasePath='%s';", new Object[] { ApolloConstant.k }));
    CEApplication localCEApplication = CmShowMakeupFragment.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.a);
    localStringBuilder.append("/def/role/0/");
    localCEApplication.evaluateJsSync(String.format("gCEDressUp.role0Path='%s';", new Object[] { localStringBuilder.toString() }));
    localCEApplication = CmShowMakeupFragment.d(this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.a);
    localStringBuilder.append("/def/role/0/3D/ios/skeleton");
    localCEApplication.evaluateJsSync(String.format("gCEDressUp.createRole('%s');", new Object[] { localStringBuilder.toString() }));
    CmShowMakeupFragment.d(this.a).evaluateJsSync("gCEDressUp.setupDefaultDress();");
    CmShowMakeupFragment.d(this.a).evaluateJsSync(String.format("gCEDressUp.setGameCameraRatio(%f);", new Object[] { Float.valueOf(ViewUtils.getScreenWidth() * 1.0F / CmShowMakeupFragment.e(this.a)) }));
    this.a.b();
    CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.3.1(this));
    TraceReportUtil.a(126, 9, 0, new Object[0]);
  }
  
  public void onGameEnd()
  {
    QLog.i("[cmshow]CmShowMakeupFragment", 1, "cross engine life cycle: onGameEnd");
  }
  
  public void onInit()
  {
    QLog.i("[cmshow]CmShowMakeupFragment", 1, "cross engine life cycle: onInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.3
 * JD-Core Version:    0.7.0.1
 */