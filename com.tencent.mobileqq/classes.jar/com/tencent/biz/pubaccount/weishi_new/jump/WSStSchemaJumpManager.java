package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.IWSJumpFactory;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByPriorityFactory;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByTypeFactory;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

public class WSStSchemaJumpManager
  implements IWSStSchemaJumpFactor
{
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private IJumpListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpIJumpListener;
  private IWSJumpFactory jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;
  private OuterInterceptManager.OnInterceptDialogClickListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilOuterInterceptManager$OnInterceptDialogClickListener;
  private MiniAppLaunchListener jdField_a_of_type_ComTencentMobileqqMiniApiMiniAppLaunchListener;
  private boolean jdField_a_of_type_Boolean = false;
  private IWSJumpFactory jdField_b_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;
  private boolean jdField_b_of_type_Boolean = false;
  
  public WSStSchemaJumpManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory = new WSJumpStrategyByPriorityFactory();
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory = new WSJumpStrategyByTypeFactory();
  }
  
  public stSchema a()
  {
    return this.jdField_a_of_type_UserGrowthStSchema;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public WSDownloadParams a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  }
  
  public IJumpListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpIJumpListener;
  }
  
  public WSStSchemaJumpManager a(stSchema paramstSchema)
  {
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    return this;
  }
  
  public WSStSchemaJumpManager a(WSDownloadParams paramWSDownloadParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = paramWSDownloadParams;
    return this;
  }
  
  public WSStSchemaJumpManager a(IJumpListener paramIJumpListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpIJumpListener = paramIJumpListener;
    return this;
  }
  
  public WSStSchemaJumpManager a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public OuterInterceptManager.OnInterceptDialogClickListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilOuterInterceptManager$OnInterceptDialogClickListener;
  }
  
  public MiniAppLaunchListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniApiMiniAppLaunchListener;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_UserGrowthStSchema == null))
    {
      WSLog.d("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.jdField_a_of_type_AndroidContentContext + ", mStSchema" + this.jdField_a_of_type_UserGrowthStSchema);
      return;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;; localObject = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory)
    {
      localObject = ((IWSJumpFactory)localObject).a(this);
      if (localObject == null) {
        break;
      }
      ((AbsWSJump)localObject).a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager
 * JD-Core Version:    0.7.0.1
 */