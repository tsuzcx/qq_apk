import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.2;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.3;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.4;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.5;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.6;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class amuy
  implements agwk
{
  private static boolean jdField_c_of_type_Boolean = true;
  private int jdField_a_of_type_Int;
  public anps a;
  public ApolloRender a;
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  public ApolloTextureView a;
  public BarrageView a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  
  public amuy()
  {
    this.jdField_a_of_type_Anps = new amuz(this);
  }
  
  private void d()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
    if (localApolloRender != null)
    {
      String str = anke.a(new File(annv.av + "cm3d.js"));
      if (!TextUtils.isEmpty(str)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.3(this, localApolloRender, str));
      }
      if (!TextUtils.isEmpty(amsx.e)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.4(this, localApolloRender));
      }
    }
  }
  
  public ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    int j;
    int i;
    if (paramInt == 0)
    {
      j = 1;
      if (j != 0) {
        break label94;
      }
      if (Build.VERSION.SDK_INT < 11) {
        break label80;
      }
      i = this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      label23:
      QLog.d("sava_ChatPieApolloViewController", 1, new Object[] { "onVisibilityChanged, visibility=", Integer.valueOf(paramInt), ", bottomMargin=", Integer.valueOf(i) });
      if (j != 0) {}
      for (paramInt = 2131377116;; paramInt = 2131368726)
      {
        c(paramInt);
        e(i);
        return;
        j = 0;
        break;
        label80:
        i = this.jdField_c_of_type_Int;
        break label23;
      }
      label94:
      i = 0;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine surfaceview is already inited, return.");
      return;
    }
    if (paramBaseChatPie.h() >= 7)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
      return;
    }
    if ((TextUtils.isEmpty(amsx.d)) || (TextUtils.isEmpty(amsx.e)))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    if (!annu.d) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil cm3dPreLoad:" + bool);
      if (!bool) {
        break;
      }
      if (angi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label178;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
      return;
    }
    label178:
    if (!amsx.a(BaseApplicationImpl.getContext()))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Not in white list.");
      return;
    }
    bgsr localbgsr = ((bgsl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localbgsr != null) && (localbgsr.jdField_a_of_type_Boolean))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
      return;
    }
    if (angi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
      return;
    }
    if (!angi.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !canUseCmShow");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine use:" + (System.currentTimeMillis() - l));
    }
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.postImmediately(new ChatPieApolloViewController.2(this, paramBaseChatPie), null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged h:", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged show:", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility();
      if (!paramBoolean) {
        break label104;
      }
      if (this.jdField_a_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
      }
    }
    label104:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility();
          if (!paramBoolean) {
            break;
          }
          if (this.jdField_a_of_type_Int != 0) {
            this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          }
        }
        return;
        if (this.jdField_a_of_type_Int != 8) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
        }
      }
    } while (this.jdField_a_of_type_Int == 8);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null);
  }
  
  public boolean a(BaseChatPie paramBaseChatPie)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, new Object[] { "ifApolloFunAvailThenInit, mApolloSurfaceView:", this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, ",mApolloTextureView:", this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView });
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "chatPie is null");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
      return false;
    }
    if (!angi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    Object localObject = (angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    ((angf)localObject).a(paramBaseChatPie);
    boolean bool = ((angf)localObject).a().g();
    if ((!amsx.a(BaseApplicationImpl.getContext())) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Not in white list.");
      }
      return false;
    }
    bgsr localbgsr = ((bgsl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localbgsr != null) && (localbgsr.jdField_a_of_type_Boolean)) {
      return false;
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start TraceReport_total isNoneApolloActionPlay:" + bool);
    if (QLog.isColorLevel())
    {
      anpx.a("exeBase");
      anpx.a("exeCmshow0");
      anpx.a("exeCommon");
    }
    anpx.b("aio_pre");
    int i = angi.b(0);
    anmq.a(i, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    anmq.a(i, 1);
    anmq.a(i, 10);
    anmq.a(i, null, new int[] { anmp.a(i, false, 0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false) });
    if (angi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
      }
      anmq.a(i, 10, 103, new Object[] { "double hidden" });
      return false;
    }
    if (!angi.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    localObject = ((angf)localObject).a();
    if (localObject != null) {
      ((SpriteUIHandler)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_Aggs);
    }
    if ((anlk.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo switch NOT open.");
      }
      paramBaseChatPie.a().obtainMessage(62).sendToTarget();
    }
    for (;;)
    {
      return true;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramBaseChatPie.g();
      } else {
        paramBaseChatPie.a().obtainMessage(65).sendToTarget();
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().a(0L);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(0L);
    }
  }
  
  public void b(int paramInt)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getBottom();
      j = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getTop();
      if ((i <= 0) || (i - j >= paramInt)) {
        break label177;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkApolloViewLayout invisible apolloBottom:" + i + ",apolloTop:" + j + ",titleHeight:" + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(4);
    }
    label177:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          i = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getBottom();
          j = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getTop();
          if ((i <= 0) || (i - j >= paramInt)) {
            break;
          }
          QLog.i("sava_ChatPieApolloViewController", 1, "checkApolloViewLayout invisible apolloBottom:" + i + ",apolloTop:" + j + ",titleHeight:" + paramInt);
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() == 4) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
        }
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 4);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
  }
  
  @TargetApi(14)
  public void b(BaseChatPie paramBaseChatPie)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {}
    int j;
    do
    {
      return;
      j = angi.b(0);
      if (paramBaseChatPie.h() < 7) {
        break;
      }
      anmq.a(j, 10, 106, new Object[] { "aio is finished" });
    } while (!QLog.isColorLevel());
    QLog.d("sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
    return;
    Object localObject1 = (amts)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
    ((amts)localObject1).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((amts)localObject1).a(((amts)localObject1).a);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
      return;
    }
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 26) || (amsx.p))
    {
      bool1 = true;
      label145:
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "initTextureViewConfig initApolloSurfaceView:" + bool1);
      }
      localObject1 = (angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      anmq.a(j, 10, 0, new Object[] { "cmshow switch done" });
      anmq.a(j, 100);
      anmq.a(j, 101);
      anpx.a("onSurfaceCreated");
      if (!bool1) {
        break label754;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDestroyOnAsync(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(paramBaseChatPie.jdField_a_of_type_Ansv, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(amsx.q);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setUseGlobalTimer(true);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          ((angf)localObject1).a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
        if (annu.jdField_b_of_type_Boolean) {
          break label848;
        }
        bool2 = true;
        this.jdField_a_of_type_Boolean = bool2;
        QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil mPreloadEngine:" + this.jdField_a_of_type_Boolean);
        if (!this.jdField_a_of_type_Boolean) {
          break label854;
        }
        anpx.a("preLoadEngine");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().preLoadDirector();
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null)) {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().preLoadDirector();
        }
        ThreadManager.postImmediately(new ChatPieApolloViewController.5(this, j, paramBaseChatPie, (angf)localObject1), null, false);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        if (!paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()) {
          break label875;
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        localObject2 = (agwg)paramBaseChatPie.a(52);
        if (localObject2 != null) {
          ((agwg)localObject2).a(this);
        }
        if ((localObject2 == null) || (!((agwg)localObject2).b())) {
          break label890;
        }
        if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label895;
          }
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131370020);
        if (i == 0) {
          break label929;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131377116);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-1, (int)((float)bhlo.j() * 0.171F));
        if (i == 0) {
          break label940;
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131377116);
        paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, (ViewGroup.LayoutParams)localObject2);
        i = angi.a();
        if (!bool1) {
          break label951;
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
        paramBaseChatPie.a().addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject1);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject1 = (amsx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if (localObject1 == null) {
          break;
        }
        ((amsx)localObject1).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        return;
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        QLog.e("sava_ChatPieApolloViewController", 1, paramBaseChatPie, new Object[0]);
        return;
      }
      bool1 = false;
      break label145;
      label754:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.jdField_a_of_type_Ansv, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((angf)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().setUseGlobalTimer(true);
      continue;
      label848:
      boolean bool2 = false;
      continue;
      label854:
      ThreadManager.excute(new ChatPieApolloViewController.6(this, paramBaseChatPie, (angf)localObject1), 16, null, false);
      continue;
      label875:
      ((RelativeLayout.LayoutParams)localObject1).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      continue;
      label890:
      i = 0;
      continue;
      label895:
      this.jdField_c_of_type_Int = agej.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources());
      if (i == 0)
      {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (-this.jdField_c_of_type_Int);
        continue;
        label929:
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368726);
        continue;
        label940:
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368726);
        continue;
        label951:
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setInitHeight(i);
        paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().b();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b();
    }
  }
  
  public void c(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.requestLayout();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!amsx.e()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
    Object localObject1 = (agwg)paramBaseChatPie.a(52);
    int i;
    if ((localObject1 != null) && (((agwg)localObject1).b()))
    {
      i = 1;
      if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        if (Build.VERSION.SDK_INT < 11) {
          break label291;
        }
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
        }
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
        if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
        }
      }
      label152:
      localLayoutParams.addRule(6, 2131370020);
      if (i == 0) {
        break label324;
      }
      localLayoutParams.addRule(2, 2131377116);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
      localObject1 = new anqd(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init((amwd)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback((amwb)localObject1);
      }
      Object localObject2 = (angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      ((angf)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject2 = ((angf)localObject2).a();
      if (localObject2 != null) {
        ((anqd)localObject1).a((amwb)localObject2);
      }
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      i = 0;
      break;
      label291:
      this.jdField_c_of_type_Int = agej.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources());
      if (i != 0) {
        break label152;
      }
      localLayoutParams.bottomMargin = (-this.jdField_c_of_type_Int);
      break label152;
      label324:
      localLayoutParams.addRule(2, 2131368726);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onResume");
    }
    if (paramBaseChatPie == null) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ((amsx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(new WeakReference(paramBaseChatPie));
    } while (!a());
    ((angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void e(int paramInt)
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
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.requestLayout();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onPause");
    }
    if (paramBaseChatPie == null) {}
    while ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!a())) {
      return;
    }
    ((angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void f(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onDestroy ");
    }
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
    }
    label103:
    label124:
    do
    {
      return;
      anpq.b(this.jdField_a_of_type_Anps);
      this.jdField_b_of_type_Boolean = true;
      Object localObject = new StringBuilder().append("onDestroy preLoad mApolloRender:");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append(" mApolloSurfaceView:");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
          break label212;
        }
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append(" mApolloTextureView:");
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null) {
          break label217;
        }
        bool = true;
        QLog.i("sava_ChatPieApolloViewController", 1, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
          break label222;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.queueDestroy();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
      }
      for (;;)
      {
        ((angf)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).onDestroy();
        if (a()) {
          break label271;
        }
        QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
        return;
        bool = false;
        break;
        bool = false;
        break label103;
        bool = false;
        break label124;
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
          if (localObject != null) {
            ((ApolloRender)localObject).queueDestroy();
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
          if (localObject != null) {
            ((ApolloRender)localObject).queueDestroy();
          }
        }
      }
      localObject = (amts)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
      ((amts)localObject).a(null);
      ((amts)localObject).a(null);
      localObject = (amst)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
      if (localObject != null) {
        ((amst)localObject).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
        paramBaseChatPie.a().removeView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
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
      anll.a().a();
      paramBaseChatPie = (agwg)paramBaseChatPie.a(52);
    } while (paramBaseChatPie == null);
    label212:
    label217:
    label222:
    paramBaseChatPie.b(this);
    label271:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuy
 * JD-Core Version:    0.7.0.1
 */