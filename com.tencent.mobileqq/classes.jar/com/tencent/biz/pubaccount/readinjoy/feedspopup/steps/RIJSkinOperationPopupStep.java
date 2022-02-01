package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler.ReadInJoySkinObserver;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class RIJSkinOperationPopupStep
  extends BasePopupStep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new RIJSkinOperationPopupStep.7(this);
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver = new RIJSkinOperationPopupStep.5(this);
  @Nullable
  private ReadInJoySkinGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView;
  @Nullable
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJSkinOperationPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJSkinOperationPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @UiThread
  private void a(GuideData paramGuideData, String paramString, int paramInt)
  {
    if (!a()) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131365297);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = new ReadInJoySkinGuideView(0, this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface, paramGuideData.id, paramString, paramInt, new RIJSkinOperationPopupStep.3(this, localFrameLayout, paramInt, localQQAppInterface), new RIJSkinOperationPopupStep.4(this, localQQAppInterface, localFrameLayout, paramGuideData));
    } while (a() != 0);
    localFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView, -1, -1);
  }
  
  private void a(oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2)
  {
    boolean bool1 = a(paramGuideInfo1, paramInt);
    a(paramRefreshInfo, paramInt);
    boolean bool2 = a(paramInt, paramSkinInfo, paramGuideInfo2);
    ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.6(this, bool1 | bool2));
  }
  
  private void a(oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    RefreshData localRefreshData;
    if (paramRefreshInfo.has())
    {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
      localRefreshData = localReadInJoyRefreshManager.a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (paramRefreshInfo != null) {
          break label225;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo);
        label104:
        if (localRefreshData != null) {
          break label256;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData);
      }
      label135:
      if (paramRefreshInfo != null) {
        break label288;
      }
      if (localRefreshData != null)
      {
        SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null, paramInt);
        FileUtils.b(RefreshRes.a());
        localReadInJoyRefreshManager.a(0, "", -1L, paramInt);
      }
    }
    for (;;)
    {
      if (paramRefreshInfo != null)
      {
        paramRefreshInfo.showInFeeds = true;
        if (localRefreshData != null) {
          paramRefreshInfo.isShown = localRefreshData.isShown;
        }
        SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt);
      }
      return;
      paramRefreshInfo = null;
      break;
      label225:
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo.toString());
      break label104;
      label256:
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData.toString());
      break label135;
      label288:
      if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (i <= paramRefreshInfo.endTime))
      {
        localReadInJoyRefreshManager.a(0, "", -1L, paramInt);
        FileUtils.b(RefreshRes.a());
        localReadInJoyRefreshManager.a(paramRefreshInfo, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "setRefreshType none and downloadRefreshRes");
        }
      }
    }
  }
  
  private boolean a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)localQQAppInterface.getManager(paramInt);
    if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
    {
      String str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (localReadInJoyBaseResManager.c(paramString, paramBaseResData))
      {
        if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt)
        {
          if (SharedPreUtils.g(this.jdField_a_of_type_AndroidAppActivity, paramBaseResData.id) != paramBaseResData.seq)
          {
            FileUtils.a(str);
            localReadInJoyBaseResManager.a(paramString, paramBaseResData);
            return false;
          }
          SharedPreUtils.t(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
          SharedPreUtils.B(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin());
        }
        localReadInJoyBaseResManager.b(paramString, paramBaseResData);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "checkAndSkinGuide：real: " + paramBaseResData.id);
        }
        if ((paramBaseResData instanceof GuideData))
        {
          paramString = (GuideData)paramBaseResData;
          ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.2(this, paramString, str, paramInt));
          return true;
        }
      }
      else
      {
        localReadInJoyBaseResManager.a(paramString, paramBaseResData);
      }
    }
    return false;
  }
  
  private boolean a(int paramInt, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = false;
    RefreshData localRefreshData = ((ReadInJoyRefreshManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    int i = (int)(System.currentTimeMillis() / 1000L);
    Object localObject;
    boolean bool1;
    if (paramSkinInfo.has())
    {
      paramSkinInfo = new SkinData(paramSkinInfo);
      localObject = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject);
      }
      paramGuideInfo = (ReadInJoySkinManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((this.jdField_a_of_type_Boolean) || (i < ((GuideData)localObject).beginTime) || (i > ((GuideData)localObject).endTime)) {
        break label258;
      }
      bool1 = bool2;
      if (a(QQManagerFactory.READ_INJOY_SKIN_MANAGER, "", (BaseResData)localObject)) {
        bool1 = true;
      }
      label165:
      localObject = paramGuideInfo.a(this.jdField_a_of_type_AndroidAppActivity);
      if ((paramSkinInfo != null) || (paramGuideInfo.a() != 1)) {
        break label310;
      }
      this.jdField_a_of_type_JavaLangString = paramGuideInfo.a();
      SharedPreUtils.s(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null);
      if ((localRefreshData != null) && (i <= localRefreshData.endTime))
      {
        localRefreshData.isShown = true;
        SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), localRefreshData.toJson().toString(), paramInt);
      }
    }
    label258:
    label310:
    while ((paramSkinInfo == null) || (localObject == null) || (!((SkinData)localObject).id.equals(paramSkinInfo.id)) || (((SkinData)localObject).seq == paramSkinInfo.seq))
    {
      return bool1;
      paramSkinInfo = null;
      break;
      bool1 = bool2;
      if (i > ((GuideData)localObject).endTime) {
        break label165;
      }
      bool1 = bool2;
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label165;
      }
      paramGuideInfo.a((GuideData)localObject);
      paramGuideInfo.a(((GuideData)localObject).skinData);
      bool1 = bool2;
      break label165;
    }
    SharedPreUtils.s(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
    if (paramSkinInfo.id.equals(paramGuideInfo.a()))
    {
      this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
      return bool1;
    }
    FileUtils.a(CommonSkinRes.a(paramSkinInfo.id));
    return bool1;
  }
  
  private boolean a(oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = (int)(System.currentTimeMillis() / 1000L);
    ReadInJoyOperationManager localReadInJoyOperationManager = (ReadInJoyOperationManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    int i;
    if (paramGuideInfo.has())
    {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("RIJSkinOperationPopupStep", 2, "guideData = " + paramGuideInfo);
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (paramGuideInfo == null) {
        break label338;
      }
      paramGuideInfo.business = "operation_guide";
      GuideData localGuideData = (GuideData)((EntityManager)localObject).find(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localGuideData == null) || (localGuideData.showTime == 0)) {
        ((EntityManager)localObject).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localReadInJoyOperationManager.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo == null) {
        break label345;
      }
      paramGuideInfo = paramGuideInfo.iterator();
      i = 0;
      label192:
      bool2 = bool1;
      if (!paramGuideInfo.hasNext()) {
        break label345;
      }
      localObject = (GuideData)paramGuideInfo.next();
      if ((i != 0) || (((GuideData)localObject).source != paramInt) || (j < ((GuideData)localObject).beginTime) || (j > ((GuideData)localObject).endTime)) {
        break label292;
      }
      if (a(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER, "operation_guide", (BaseResData)localObject)) {
        bool1 = true;
      }
      this.jdField_a_of_type_Boolean = true;
      bool2 = bool1;
    }
    for (;;)
    {
      i += 1;
      bool1 = bool2;
      break label192;
      paramGuideInfo = null;
      break;
      label292:
      bool2 = bool1;
      if (j <= ((GuideData)localObject).endTime)
      {
        bool2 = bool1;
        if (NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity))
        {
          localReadInJoyOperationManager.a("operation_guide", (BaseResData)localObject);
          bool2 = bool1;
        }
      }
    }
    label338:
    localReadInJoyOperationManager.a(paramInt);
    label345:
    return bool2;
  }
  
  private void i()
  {
    ThreadManager.excute(new RIJSkinOperationPopupStep.1(this), 16, null, true);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131365297)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = null;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      FileUtils.a(CommonSkinRes.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void g() {}
  
  public void h()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep
 * JD-Core Version:    0.7.0.1
 */