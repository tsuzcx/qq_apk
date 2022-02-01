import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.actionContext.1;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.render.1;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "", "()V", "cacheActionContext", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "getTextureView", "Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "context", "Landroid/content/Context;", "playAction", "", "width", "", "height", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "container", "Landroid/widget/FrameLayout;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "playActionReal", "actionContext", "callSurfaceReady", "", "recordAction", "Lcom/tencent/mobileqq/apollo/script/SpriteBridge;", "CMSActionContext", "CMSApolloRender", "CMSRecordListener", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvq
{
  private static final long jdField_a_of_type_Long = anmk.a();
  public static final amvx a;
  private amvr jdField_a_of_type_Amvr;
  
  static
  {
    jdField_a_of_type_Amvx = new amvx(null);
  }
  
  private final ApolloTextureView a(Context paramContext)
  {
    paramContext = new ApolloTextureView(paramContext, null);
    paramContext.setDestroyOnAsync(true);
    paramContext.setDispatchEvent2Native(true);
    paramContext.disableTouchEvent(true);
    paramContext.setDumplicateCreateRenderThread(amme.q);
    return paramContext;
  }
  
  private final void a(amvr paramamvr, boolean paramBoolean)
  {
    Object localObject1 = paramamvr.a().a();
    Object localObject2 = paramamvr.a();
    ((ancc)localObject1).a((ampv)localObject2);
    Object localObject3 = ApolloCmdChannel.getChannel(amve.a.a());
    ((ApolloCmdChannel)localObject3).addRenderRunner((amqs)localObject2);
    ((ApolloCmdChannel)localObject3).addCmdHandler(paramamvr.a());
    paramamvr.a();
    localObject3 = anbo.a;
    localObject2 = ((ApolloTextureView)localObject2).getRender();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "textureView.render");
    ((anbo)localObject3).a(((ApolloRender)localObject2).getSavaWrapper().jdField_a_of_type_Long, paramamvr.a());
    ((ancc)localObject1).a = true;
    if (paramBoolean) {
      paramamvr.a().a("", 1, true);
    }
    paramamvr.b();
    localObject1 = paramamvr.a().a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "actionContext.ssm.spriteBridge");
    a((anbz)localObject1, paramamvr);
  }
  
  private final void a(@NotNull anbz paramanbz, amvr paramamvr)
  {
    boolean bool = false;
    Object localObject = null;
    CMSAction localCMSAction = paramamvr.a();
    SpriteTaskParam localSpriteTaskParam = localCMSAction.a();
    paramanbz = paramamvr.a();
    ancd localancd = paramanbz.a();
    ancc localancc = paramanbz.a();
    if ((localSpriteTaskParam == null) || (localancd == null) || (localancc == null) || (!localancc.c())) {
      amvx.a(jdField_a_of_type_Amvx, paramamvr, CMSActionStatus.ERROR_SURFACE_NOT_READY);
    }
    do
    {
      return;
      anis.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4);
      if (localancd.a(localSpriteTaskParam)) {
        break;
      }
      paramanbz = localancc.a();
    } while (paramanbz == null);
    paramanbz = paramanbz.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    if (paramanbz == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.utils.ApolloDaoManager");
    }
    if (((ankc)paramanbz).a(localSpriteTaskParam.f) == null) {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, can not found action in ApolloDaoManager.");
    }
    for (paramanbz = new Pair(CMSActionStatus.ERROR_ACTION_JSON_OUT_DATE, "action_json out date for action(" + localCMSAction.a() + ')');; paramanbz = new Pair(CMSActionStatus.ERROR_ACTION_RES_MISS, "res missing for action(" + localCMSAction.a() + ')'))
    {
      localObject = (CMSActionStatus)paramanbz.component1();
      paramanbz = (String)paramanbz.component2();
      anis.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, ((CMSActionStatus)localObject).toReportErrorCode(), new Object[] { paramanbz });
      amvx.a(jdField_a_of_type_Amvx, paramamvr, (CMSActionStatus)localObject);
      return;
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, action res missing.");
    }
    if ((localCMSAction.a() == CMSAction.Companion.MODE.ACTION_MODE_FRAME) && (!ApolloUtil.b(localSpriteTaskParam.f, localSpriteTaskParam.e)))
    {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, panelAction res missing.");
      anis.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS.toReportErrorCode(), new Object[] { "action(" + localCMSAction.a() + ") panel res missing" });
      amvx.a(jdField_a_of_type_Amvx, paramamvr, CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS);
      return;
    }
    anis.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, 0, new Object[0]);
    anbu localanbu = paramanbz.a().a(localSpriteTaskParam.jdField_c_of_type_Int, localSpriteTaskParam.f);
    paramanbz = (anbz)localObject;
    if (localanbu != null)
    {
      String str = localanbu.a();
      paramanbz = (anbz)localObject;
      if (str != null) {
        paramanbz = StringsKt.replace$default(str, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "", false, 4, null);
      }
    }
    if (localanbu != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail to load script. " + paramanbz);
      localSpriteTaskParam.jdField_b_of_type_Int = 4;
      amvx.a(jdField_a_of_type_Amvx, paramamvr, CMSActionStatus.ERROR_SCRIPT_MISS);
      return;
    }
    localObject = localancd.a(localSpriteTaskParam);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rscBuilder.getActionJsParam(task)");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localSpriteTaskParam.jdField_b_of_type_Int = 4;
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail to build actionJs.");
      amvx.a(jdField_a_of_type_Amvx, paramamvr, CMSActionStatus.ERROR_BUILD_ACTION_JS);
      return;
    }
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], ready to play, script:" + paramanbz + ", " + localCMSAction.d() + ", actionJs:" + (String)localObject);
    localSpriteTaskParam.jdField_b_of_type_Int = 2;
    paramanbz = new StringBuilder();
    paramanbz.append("playAction('").append((String)localObject).append("');");
    if (localSpriteTaskParam.jdField_c_of_type_Boolean) {
      paramanbz.append("startFrameRecord(").append(localSpriteTaskParam.jdField_a_of_type_Int).append(", ").append(localSpriteTaskParam.jdField_b_of_type_Float).append(");");
    }
    localanbu.a(paramanbz.toString());
    localanbu.a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localanbu.a(localSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    paramanbz = localancc.a();
    if (!TextUtils.isEmpty((CharSequence)localSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    anhm.a(paramanbz, localSpriteTaskParam, bool, localSpriteTaskParam.jdField_b_of_type_Boolean);
    ThreadManager.getSubThreadHandler().postDelayed(paramamvr.a(), jdField_a_of_type_Long);
  }
  
  public final void a(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @NotNull amvk paramamvk)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramamvk, "listener");
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "recordAction, " + paramCMSAction.d() + ", width:" + paramInt1 + ", height:" + paramInt2);
    if (this.jdField_a_of_type_Amvr == null)
    {
      QQAppInterface localQQAppInterface = amve.a.a();
      Object localObject = paramContext.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
      float f = ((Resources)localObject).getDisplayMetrics().density;
      localObject = new anch(localQQAppInterface);
      ((anch)localObject).a().jdField_c_of_type_Boolean = true;
      paramContext = a(paramContext);
      paramContext.setOffscreenSize(paramInt1, paramInt2);
      paramCMSAction = new amvr(paramCMSAction, (anch)localObject, paramContext, paramamvk, (Function1)new CMSBornPlayer.recordAction.actionContext.1(this));
      paramamvk = new amvv(f, paramCMSAction.a(), (Function0)new CMSBornPlayer.recordAction.render.1(localQQAppInterface, paramCMSAction));
      paramamvk.setUseGlobalTimer(true);
      paramContext.init(paramCMSAction.a(), 0, (ApolloRender)paramamvk, true);
      if (localQQAppInterface != null) {
        localQQAppInterface.addObserver((BusinessObserver)paramCMSAction.a());
      }
      this.jdField_a_of_type_Amvr = paramCMSAction;
      return;
    }
    paramContext = this.jdField_a_of_type_Amvr;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    paramContext.a(paramCMSAction);
    paramContext.a(paramamvk);
    a(paramContext, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvq
 * JD-Core Version:    0.7.0.1
 */