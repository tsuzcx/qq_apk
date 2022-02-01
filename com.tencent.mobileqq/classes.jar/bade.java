import android.widget.FrameLayout;
import com.tencent.mobileqq.data.Card;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/widget/FrameLayout;", "TAG", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Ljava/lang/String;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "getTAG", "()Ljava/lang/String;", "isBackgroundShow", "", "()Z", "setBackgroundShow", "(Z)V", "buildVasProfileData", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "info", "getComponentName", "getComponentType", "", "getContainerView", "getDefaultResourceID", "onDataUpdate", "data", "onVasDataUpdate", "setAbFactor", "", "type", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class bade
  extends azwn<FrameLayout>
{
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public bade(@NotNull String paramString, @Nullable azxt paramazxt, @Nullable azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int a()
  {
    return 1003;
  }
  
  @NotNull
  public FrameLayout a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (FrameLayout)localObject;
  }
  
  @NotNull
  public final badb a(@Nullable azrb paramazrb)
  {
    if (paramazrb != null) {}
    for (Object localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard; localObject1 == null; localObject1 = null) {
      return new badb(0L, 0L, null, null, null, null, 63, null);
    }
    Card localCard = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard;
    long l1 = localCard.lCurrentStyleId;
    long l2 = localCard.lCurrentBgId;
    String str2 = localCard.backgroundUrl;
    Intrinsics.checkExpressionValueIsNotNull(str2, "backgroundUrl");
    long l3 = localCard.backgroundColor;
    int i = localCard.dynamicCardFlag;
    localObject1 = localCard.strZipUrl;
    Object localObject2;
    label108:
    String str1;
    if (localObject1 != null)
    {
      localObject2 = localCard.strActiveUrl;
      if (localObject2 == null) {
        break label274;
      }
      str1 = localCard.strDrawerCardUrl;
      if (str1 == null) {
        break label281;
      }
    }
    for (;;)
    {
      String str3 = localCard.strWzryHeroUrl;
      Intrinsics.checkExpressionValueIsNotNull(str3, "strWzryHeroUrl");
      localObject1 = new bacy(l1, l2, str2, l3, i, (String)localObject1, (String)localObject2, str1, str3, localCard.wzryHonorInfo, localCard.strExtInfo, localCard.strCurrentBgUrl);
      localObject2 = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard;
      localObject2 = new bada(((Card)localObject2).diyText, ((Card)localObject2).diyTextFontId, ((Card)localObject2).diyTextWidth, ((Card)localObject2).diyTextHeight, ((Card)localObject2).diyTextLocX, ((Card)localObject2).diyTextLocY, ((Card)localObject2).diyTextDegree, ((Card)localObject2).diyTextScale, ((Card)localObject2).diyTextTransparency, ((Card)localObject2).diyDefaultText);
      return new badb(paramazrb.jdField_a_of_type_Long, paramazrb.b, paramazrb.jdField_a_of_type_Azri, (bacy)localObject1, paramazrb.jdField_a_of_type_Bacz, (bada)localObject2);
      localObject1 = "";
      break;
      label274:
      localObject2 = "";
      break label108;
      label281:
      str1 = "";
    }
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      i = 0;
      break;
      AbProxy.Companion.setAbFactor("资料卡背景", paramString, acxt.class);
    } while (!QLog.isColorLevel());
    QLog.d("AbsVasProfileBackgroundComponent", 2, "updateTheme cardType=" + paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a(@Nullable azrb paramazrb)
  {
    badb localbadb = a(paramazrb);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "vasdata = " + localbadb);
    }
    return a(localbadb) | super.a(paramazrb);
  }
  
  public abstract boolean a(@NotNull badb parambadb);
  
  public final int b()
  {
    return 2130845755;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bade
 * JD-Core Version:    0.7.0.1
 */