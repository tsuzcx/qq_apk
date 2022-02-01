package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class ApolloItemBuilder$7
  implements View.OnClickListener
{
  ApolloItemBuilder$7(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    Object localObject2;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject2 = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    } while ((localObject2 == null) || (((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentImageURLImageView == null));
    int i = ((ApolloItemBuilder.Holder)localObject2).e;
    if ((paramView instanceof TextView))
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo;
      Object localObject3;
      int j;
      if (localIApolloManagerService.isApolloFuncOpen(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), null, "aio", ApolloConstant.u, null);
        localObject1 = "1";
        localApolloBaseInfo = localIApolloManagerService.getApolloBaseInfoFromCache(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
        j = ((ApolloItemBuilder.Holder)localObject2).e;
        if (localApolloBaseInfo != null) {
          break label363;
        }
      }
      label363:
      for (localObject2 = "0";; localObject2 = localApolloBaseInfo.apolloStatus + "")
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject2, localObject1, localIApolloManagerService.getWhiteListStatus(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "" });
        break;
        if (!localIApolloManagerService.isHardwareSupport(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
        for (localObject1 = ApolloConstant.h;; localObject1 = ApolloConstant.i + i)
        {
          localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject3, false, -1);
          localObject1 = "0";
          break;
        }
      }
    }
    if (new File(ApolloGifDownloaderImpl.getApolloGifFilePath(i)).exists()) {
      ApolloItemBuilder.a(this.a.jdField_a_of_type_AndroidContentContext, ((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentImageURLImageView, (MessageForApollo)((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_gif", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop), 0, new String[] { String.valueOf(i), localObject1, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      break;
      localObject1 = ((ApolloItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!NetworkUtil.g(paramView.getContext())) {
            break;
          }
          this.a.a((ApolloItemBuilder.Holder)localObject2, paramView.getResources(), true);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */