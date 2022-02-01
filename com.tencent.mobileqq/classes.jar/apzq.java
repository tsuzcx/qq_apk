import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;

public class apzq
  implements apzt
{
  public int a;
  public RecommendCommonMessage.ArkMsgAppInfo a;
  public RecommendCommonMessage a;
  public int b;
  public int c;
  
  private void a(Context paramContext)
  {
    new bjcf(paramContext).a(2131717877, paramContext.getResources().getDimensionPixelSize(2131299011), 1, 0);
  }
  
  private void a(aqcm paramaqcm, aqcq paramaqcq)
  {
    paramaqcm = new apzs(this, paramaqcm);
    paramaqcq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramaqcm);
  }
  
  public void attachArkView(aqcm paramaqcm, aqcq paramaqcq, int paramInt)
  {
    paramaqcq.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844903);
    ArkAppView localArkAppView = paramaqcq.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(16.0F);
    localArkAppView.setClipRadius(0.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer = new agyv();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a(paramaqcm);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a.autoSize = Integer.valueOf(1);
      aqca.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null, aqca.f, 0, 0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer;
    if (this.c > 0) {
      ((agyv)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, aqbx.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo, paramaqcm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      ((agyv)localObject).setFixSize(aqbx.jdField_a_of_type_Int, aqbx.jdField_a_of_type_Int);
      ((agyv)localObject).setMaxSize(aqbx.jdField_a_of_type_Int, aqbx.jdField_a_of_type_Int);
      ((agyv)localObject).setMinSize(aqbx.jdField_a_of_type_Int * 7 / 10, aqbx.jdField_a_of_type_Int);
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView appName:", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(aqbx.jdField_a_of_type_Int) });
      localObject = new apzr(this, paramaqcq, paramaqcm, paramInt, (agyv)localObject);
      paramaqcq.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer, paramaqcq.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setOnTouchListener(paramaqcm.jdField_a_of_type_Agjk);
      localArkAppView.setOnLongClickListener(paramaqcm.jdField_a_of_type_Agjk);
      localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
      return;
      ((agyv)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, aqbx.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, paramaqcm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public void clickTail(aqcq paramaqcq, agzk paramagzk, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.doOnEvent(2);
  }
  
  public apzt extendArkCardByOpen(agyw paramagyw, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == paramagyw)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList;
      int i = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.size();
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = ((RecommendCommonMessage.ArkContextInfo)((ArrayList)localObject).get(0)).contextAppInfoList;
        if ((((LinkedList)localObject).size() == 1) && (i >= aqcy.jdField_a_of_type_Int - 1)) {
          return null;
        }
        if ((((LinkedList)localObject).size() > 1) && (i >= aqcy.c - 1)) {
          return null;
        }
      }
      else if ((((ArrayList)localObject).size() > 1) && (i >= aqcy.c - 1))
      {
        return null;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        return null;
      }
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      localObject = new apzq();
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName = paramagyw.getAppName();
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appPath = ArkAppMgr.getInstance().getAppPathByNameFromLocal(((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView = paramString1;
      ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta = paramString2;
      ((apzq)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((apzq)localObject).b = this.b;
      ((apzq)localObject).c = (this.b + 1);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.add(0, ((apzq)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo);
      return localObject;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
    arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzq
 * JD-Core Version:    0.7.0.1
 */