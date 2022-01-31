package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.VipRedPkgElem;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import zcn;

public class IndividualRedPacketManager$VIPHBStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private QQAppInterface a;
  
  public IndividualRedPacketManager$VIPHBStrategy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo == null) || (TextUtils.isEmpty(paramRedPacketInfo.templateId))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(IndividualRedPacketManager.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = (IndividualRedPacketManager)this.a.getManager(130);
    if ((localObject == null) || (!((IndividualRedPacketManager)localObject).c()) || (((IndividualRedPacketManager)localObject).c.get()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = IndividualRedPacketManager.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject != null) {
          break label150;
        }
      }
      label150:
      for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((IndividualRedPacketManager)localObject).a().jdField_a_of_type_Boolean + ", PacketEnable:" + ((IndividualRedPacketManager)localObject).b() + ", mIsSDCardError:" + ((IndividualRedPacketManager)localObject).c.get())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.post(new zcn(this, (IndividualRedPacketManager)localObject, paramRedPacketInfo), 8, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramBaseRedPkgElem instanceof VipRedPkgElem)))
    {
      paramBaseRedPkgElem = (VipRedPkgElem)paramBaseRedPkgElem;
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramBaseRedPkgElem.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramBaseRedPkgElem.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig = paramBaseRedPkgElem.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig;
      paramRedPacketInfo.b = paramBaseRedPkgElem.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy
 * JD-Core Version:    0.7.0.1
 */