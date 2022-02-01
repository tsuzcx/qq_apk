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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;

public class apwh
  implements apwk
{
  public int a;
  public RecommendCommonMessage.ArkMsgAppInfo a;
  public RecommendCommonMessage a;
  public int b;
  public int c;
  
  private void a(Context paramContext)
  {
    new bisy(paramContext).a(2131718500, paramContext.getResources().getDimensionPixelSize(2131299080), 1, 0);
  }
  
  private void a(apzb paramapzb, apzf paramapzf)
  {
    paramapzb = new apwj(this, paramapzb);
    paramapzf.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramapzb);
  }
  
  public void attachArkView(apzb paramapzb, apzf paramapzf, int paramInt)
  {
    paramapzf.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844857);
    ArkAppView localArkAppView = paramapzf.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(16.0F);
    localArkAppView.setClipRadius(0.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer = new agnw();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a(paramapzb);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a.autoSize = Integer.valueOf(1);
      apyp.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null, apyp.f, 0, 0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer;
    if (this.c > 0) {
      ((agnw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, ArkAppCenterUtil.getDensity(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo, paramapzb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      ((agnw)localObject).setFixSize(ArkAppCenterUtil.sChatBubbleMaxWidth, ArkAppCenterUtil.sChatBubbleMaxWidth);
      ((agnw)localObject).setMaxSize(ArkAppCenterUtil.sChatBubbleMaxWidth, ArkAppCenterUtil.sChatBubbleMaxWidth);
      ((agnw)localObject).setMinSize(ArkAppCenterUtil.sChatBubbleMaxWidth * 7 / 10, ArkAppCenterUtil.sChatBubbleMaxWidth);
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView appName:", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.sChatBubbleMaxWidth) });
      localObject = new apwi(this, paramapzf, paramapzb, paramInt, (agnw)localObject);
      paramapzf.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer, paramapzf.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setOnTouchListener(paramapzb.jdField_a_of_type_Aftk);
      localArkAppView.setOnLongClickListener(paramapzb.jdField_a_of_type_Aftk);
      localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
      return;
      ((agnw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, ArkAppCenterUtil.getDensity(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, paramapzb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public void clickTail(apzf paramapzf, agol paramagol, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.doOnEvent(2);
  }
  
  public apwk extendArkCardByOpen(agnx paramagnx, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == paramagnx)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList;
      int i = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.size();
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = ((RecommendCommonMessage.ArkContextInfo)((ArrayList)localObject).get(0)).contextAppInfoList;
        if ((((LinkedList)localObject).size() == 1) && (i >= apzn.jdField_a_of_type_Int - 1)) {
          return null;
        }
        if ((((LinkedList)localObject).size() > 1) && (i >= apzn.c - 1)) {
          return null;
        }
      }
      else if ((((ArrayList)localObject).size() > 1) && (i >= apzn.c - 1))
      {
        return null;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        return null;
      }
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      localObject = new apwh();
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName = paramagnx.getAppName();
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appPath = ArkAppMgr.getInstance().getAppPathByNameFromLocal(((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView = paramString1;
      ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta = paramString2;
      ((apwh)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((apwh)localObject).b = this.b;
      ((apwh)localObject).c = (this.b + 1);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.add(0, ((apwh)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo);
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
 * Qualified Name:     apwh
 * JD-Core Version:    0.7.0.1
 */