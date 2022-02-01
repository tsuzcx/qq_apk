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
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = false;
  private IWSJumpFactory jdField_b_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
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
  
  public WSStSchemaJumpManager a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
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
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public WSStSchemaJumpManager b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_UserGrowthStSchema != null))
    {
      if (this.jdField_b_of_type_Boolean) {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;
      } else {
        localObject = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newJumpFactoryIWSJumpFactory;
      }
      localObject = ((IWSJumpFactory)localObject).a(this);
      if (localObject != null) {
        return ((AbsWSJump)localObject).a();
      }
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext);
    ((StringBuilder)localObject).append(", mStSchema");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStSchema);
    WSLog.d("WSStSchemaJumpManager", ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager
 * JD-Core Version:    0.7.0.1
 */