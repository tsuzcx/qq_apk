import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.vip.VasGdtService.listener.2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasGdtService;", "", "()V", "gdtCallback", "Lcooperation/vip/VasGdtService$GdtCallback;", "getGdtCallback", "()Lcooperation/vip/VasGdtService$GdtCallback;", "setGdtCallback", "(Lcooperation/vip/VasGdtService$GdtCallback;)V", "listener", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "getListener", "()Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "listener$delegate", "Lkotlin/Lazy;", "createAdGetReq", "Ltencent/gdt/qq_ad_get$QQAdGet;", "createParams", "Lcooperation/vip/VasGdtService$GdtParams;", "loadAd", "", "GdtCallback", "GdtParams", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class bmkp
{
  @Nullable
  private bmkq jdField_a_of_type_Bmkq;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new VasGdtService.listener.2(this));
  
  private final acag a()
  {
    return (acag)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final qq_ad_get.QQAdGet a()
  {
    Object localObject1 = a();
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    Object localObject2 = (qq_ad_get.QQAdGet.ContextInfo)localQQAdGet.context_info.get();
    int i;
    if (localObject2 != null)
    {
      localObject3 = ((bmkr)localObject1).a();
      long l;
      if (localObject3 != null)
      {
        l = ((Number)localObject3).longValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).public_id.set(l);
      }
      localObject3 = ((bmkr)localObject1).b();
      if (localObject3 != null)
      {
        l = ((Number)localObject3).longValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).article_id.set(l);
      }
      localObject3 = ((bmkr)localObject1).a();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).tribe_tag.set(i);
      }
      localObject3 = ((bmkr)localObject1).a();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).tribe_id_tag.set(i);
      }
      localObject3 = ((bmkr)localObject1).b();
      if (localObject3 != null)
      {
        i = ((Number)localObject3).intValue();
        ((qq_ad_get.QQAdGet.ContextInfo)localObject2).source_from.set(i);
      }
    }
    localObject2 = (qq_ad_get.QQAdGet.UserInfo)localQQAdGet.user_info.get();
    if (localObject2 != null) {
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(((bmkr)localObject1).a());
    }
    localObject2 = ((bmkr)localObject1).a();
    if (localObject2 != null) {
      localQQAdGet.gdt_cookie.set((String)localObject2);
    }
    localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    Object localObject3 = ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info;
    Object localObject4 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    Object localObject5 = ((bmkr)localObject1).c();
    if (localObject5 != null)
    {
      i = ((Number)localObject5).intValue();
      ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject4).share_rate.set(i);
    }
    if ((((bmkr)localObject1).a() != null) && (((bmkr)localObject1).b() != null) && (((bmkr)localObject1).c() != null)) {
      ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject4).share_check.set(acai.a(((bmkr)localObject1).a().longValue(), ((bmkr)localObject1).b().longValue(), ((bmkr)localObject1).c().intValue()));
    }
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject3).set((MessageMicro)localObject4);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(((bmkr)localObject1).b());
    localObject4 = (Iterable)((bmkr)localObject1).a();
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (String)((Iterator)localObject4).next();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set((String)localObject5);
      localPositionInfo.ad_count.set(((bmkr)localObject1).a());
      localPositionInfo.pos_ext.set((MessageMicro)localObject2);
      ((Collection)localObject3).add(localPositionInfo);
    }
    localObject1 = (List)localObject3;
    localQQAdGet.position_info.get().addAll((Collection)localObject1);
    return localQQAdGet;
  }
  
  @Nullable
  protected final bmkq a()
  {
    return this.jdField_a_of_type_Bmkq;
  }
  
  @NotNull
  protected abstract bmkr a();
  
  public final void a()
  {
    acah localacah = new acah();
    localacah.a = a();
    WeakReference localWeakReference = new WeakReference(bmkk.a.a().a());
    new acaf(localacah, new WeakReference(a())).a(localWeakReference);
  }
  
  protected final void a(@Nullable bmkq parambmkq)
  {
    this.jdField_a_of_type_Bmkq = parambmkq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkp
 * JD-Core Version:    0.7.0.1
 */