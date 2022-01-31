package com.tencent.mobileqq.apollo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.view.ApolloBackgroundViewListener;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import ynf;
import yng;

public class ChatPieApolloViewController
{
  private int jdField_a_of_type_Int;
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  public ApolloTextureView a;
  public BarrageView a;
  private ApolloTextureView b;
  
  public ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(this.jdField_a_of_type_Int);
    }
    if (this.b != null) {
      this.b.setVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getTop() >= paramInt) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(4);
    }
    label69:
    do
    {
      for (;;)
      {
        if (this.b != null)
        {
          if (this.b.getBottom() - this.b.getTop() >= paramInt) {
            break;
          }
          this.b.setVisibility(4);
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() == 4) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
        }
      }
    } while (this.b.getVisibility() != 4);
    this.b.setVisibility(0);
  }
  
  @TargetApi(14)
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {}
    label106:
    label505:
    for (;;)
    {
      return;
      if (paramBaseChatPie.g() >= 7)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
        }
      }
      else
      {
        Object localObject = (ApolloPushManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(226);
        ((ApolloPushManager)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ((ApolloPushManager)localObject).a(((ApolloPushManager)localObject).a);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null))
        {
          QLog.e("ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
          return;
        }
        int i;
        if (Build.VERSION.SDK_INT >= 26)
        {
          i = 1;
          if (i == 0) {
            break label389;
          }
          this.b = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
          this.b.init(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
          this.b.setDispatchEvent2Native(true);
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a(this.b);
          }
          localObject = new RelativeLayout.LayoutParams(-1, -1);
          if (!paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()) {
            break label447;
          }
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            if (Build.VERSION.SDK_INT < 11) {
              break label461;
            }
            if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
            }
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
          label250:
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131363507);
          ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363494);
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)((float)DeviceInfoUtil.k() * 0.171F));
          localLayoutParams.addRule(2, 2131363494);
          paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, localLayoutParams);
          if (i == 0) {
            break label481;
          }
          this.b.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
          paramBaseChatPie.a().addView(this.b, (ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label505;
          }
          localObject = (ApolloManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          if (localObject == null) {
            break;
          }
          ((ApolloManager)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
          return;
          i = 0;
          break label106;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label172;
          }
          ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          break label172;
          ((RelativeLayout.LayoutParams)localObject).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
          break label197;
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-AIOUtils.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
          break label250;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
          paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged h:", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
    if (this.b != null) {
      this.b.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged show:", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility();
      if (!paramBoolean) {
        break label103;
      }
      if (this.jdField_a_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
      }
    }
    label103:
    do
    {
      for (;;)
      {
        if (this.b != null)
        {
          this.jdField_a_of_type_Int = this.b.getVisibility();
          if (!paramBoolean) {
            break;
          }
          if (this.jdField_a_of_type_Int != 0) {
            this.b.setVisibility(0);
          }
        }
        return;
        if (this.jdField_a_of_type_Int != 8) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
        }
      }
    } while (this.jdField_a_of_type_Int == 8);
    this.b.setVisibility(8);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null);
  }
  
  public boolean a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "ifApolloFunAvailThenInit.");
    }
    if (paramBaseChatPie == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.b != null))
                {
                  QLog.i("ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
                  return false;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ChatPieApolloViewController", 2, "[ifApolloFunAvailThenInit],mApolloSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
                }
                if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((paramBaseChatPie.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
                  ApolloGameWrapper.a(false, (Activity)paramBaseChatPie.jdField_a_of_type_AndroidContentContext, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new ynf(this));
                }
                if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  ((ApolloGameManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
                }
                ApolloActionManager.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                  ((ApolloGameManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(1, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                }
                if (!ApolloEngine.a())
                {
                  QLog.w("ChatPieApolloViewController", 1, "cmshow lib NOT ready, return.");
                  return false;
                }
                if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ChatPieApolloViewController", 2, "errInfo->NOT friend or troop or discussion, return.");
              return false;
            } while ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (Utils.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
            if (ApolloManager.a(BaseApplicationImpl.getContext())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ChatPieApolloViewController", 2, "Not in white list.");
          return false;
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a(paramBaseChatPie);
          }
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
        return false;
        if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
          break;
        }
        localObject = (HotChatManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (localObject == null) || (!((HotChatManager)localObject).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatPieApolloViewController", 2, "cmshow NOT support hot chat right now.");
      return false;
    } while (((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!SpriteUtil.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a();
      if (localObject != null) {
        ((SpriteUIHandler)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      }
    }
    ThreadManager.post(new yng(this, paramBaseChatPie), 5, null, true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().a(0L);
    }
    if ((this.b != null) && (this.b.getRenderImpl() != null)) {
      this.b.getRenderImpl().a(0L);
    }
  }
  
  public void b(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.b != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.b.requestLayout();
      }
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!ApolloManager.e()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
    if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label232;
      }
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
      }
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
      paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    for (;;)
    {
      localLayoutParams.addRule(6, 2131363507);
      localLayoutParams.addRule(2, 2131363494);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
      ApolloBackgroundViewListener localApolloBackgroundViewListener = new ApolloBackgroundViewListener(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(localApolloBackgroundViewListener);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(localApolloBackgroundViewListener);
      }
      Object localObject = (SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248);
      ((SpriteScriptManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject = ((SpriteScriptManager)localObject).a();
      if (localObject != null) {
        localApolloBackgroundViewListener.a((IRenderCallback)localObject);
      }
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      label232:
      localLayoutParams.bottomMargin = (-AIOUtils.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "onResume");
    }
    if (paramBaseChatPie == null) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ((ApolloManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(new WeakReference(paramBaseChatPie));
    } while (!a());
    ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "onPause");
    }
    if (paramBaseChatPie == null) {}
    while ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!a())) {
      return;
    }
    ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieApolloViewController", 2, "onDestroy ");
    }
    if ((paramBaseChatPie == null) || (!a()))
    {
      QLog.e("ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
      return;
    }
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = (ApolloPushManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(226);
      ((ApolloPushManager)localObject).a(null);
      ((ApolloPushManager)localObject).a(null);
      ((SpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).onDestroy();
      localObject = (ApolloGameManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210);
      if (localObject != null) {
        ((ApolloGameManager)localObject).a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
    }
    if (this.b != null)
    {
      this.b.setVisibility(8);
      paramBaseChatPie.a().removeView(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
    }
    this.jdField_a_of_type_Int = 0;
    ApolloActionManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController
 * JD-Core Version:    0.7.0.1
 */