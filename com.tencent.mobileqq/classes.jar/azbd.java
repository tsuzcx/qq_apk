import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileSettingUtils$Companion;", "", "()V", "findProfileDisplaySettingItem", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "fieldId", "", "settingItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProfileDisplaySettingItem", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "configHelper", "Lcom/tencent/mobileqq/widget/ProfileConfigHelper;", "card", "Lcom/tencent/mobileqq/data/Card;", "type", "item", "", "cache", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/widget/ProfileConfigHelper;Lcom/tencent/mobileqq/data/Card;I[Ljava/lang/Object;Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "getProfileDisplaySettingItems", "", "outItems", "getProfileDisplaySettingStateFromCard", "fieldID", "hasDisplayItemStateChanged", "", "isNeedReqGetDisplaySettingItemStateFromServer", "isSpecDefaultClosedFieldId", "setProfileDisplaySettingStateToCard", "toState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azbd
{
  public final int a(int paramInt, @NotNull Card paramCard, @Nullable QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    switch (paramInt)
    {
    default: 
      paramCard = paramCard.profileDisplaySettingStates.get(paramInt, Integer.valueOf(-1));
      Intrinsics.checkExpressionValueIsNotNull(paramCard, "card.profileDisplaySetti…gConstants.INVALID_STATE)");
      paramInt = ((Number)paramCard).intValue();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = i;
      } while (paramCard.medalSwitchDisable);
      return 0;
      return paramCard.switch_life_achievement;
      return paramCard.switch_musicbox;
      return paramCard.switch_sticky_note;
      return paramCard.switch_qqcircle;
      return paramCard.switchWeishi;
      paramInt = i;
    } while (!paramCard.isShowCard);
    return 0;
  }
  
  @Nullable
  public final azaz a(int paramInt, @NotNull ArrayList<azaz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      azaz localazaz = (azaz)paramArrayList.next();
      if (localazaz.b() == paramInt) {
        return localazaz;
      }
    }
    return null;
  }
  
  @Nullable
  public final azaz a(@NotNull QQAppInterface paramQQAppInterface, @Nullable bhha parambhha, @NotNull Card paramCard, int paramInt, @NotNull Object[] paramArrayOfObject, @Nullable azaz paramazaz)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "item");
    if ((paramArrayOfObject.length <= 1) || (parambhha == null)) {
      return null;
    }
    Object localObject = paramArrayOfObject[0];
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int j = ((Integer)localObject).intValue();
    paramArrayOfObject = paramArrayOfObject[1];
    if (paramArrayOfObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int k = ((Integer)paramArrayOfObject).intValue();
    paramArrayOfObject = (Integer)azba.a.a().get(j, Integer.valueOf(-1));
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.intValue() != -1)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfObject, "config");
      if (parambhha.a(paramArrayOfObject.intValue())) {
        break;
      }
      return null;
    }
    if ((j == 42356) && (!QZoneApiProxy.isRightAndroidVersionForStickyNote())) {
      return null;
    }
    if ((j == 42361) && (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
      return null;
    }
    if (j == 42172)
    {
      parambhha = paramQQAppInterface.getManager(264);
      if (parambhha == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
      }
      parambhha = (arhi)parambhha;
      if ((paramCard.extendFriendEntryAddFriend != 1) || (!parambhha.d())) {
        return null;
      }
    }
    if ((j == 42075) && (bfyz.X((Context)paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1)) {
      return null;
    }
    if (paramazaz != null) {}
    for (int i = 1; i == 1; i = 0)
    {
      paramazaz.c(((azbd)this).a(j, paramCard, paramQQAppInterface));
      return paramazaz;
    }
    if (i == 0) {
      return new azaz(paramInt, j, ((azbd)this).a(j, paramCard, paramQQAppInterface), k);
    }
    throw new NoWhenBranchMatchedException();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull Card paramCard, @NotNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramCard.profileDisplaySettingStates.put(paramInt1, Integer.valueOf(paramInt2));
    switch (paramInt1)
    {
    default: 
      return;
    case 42075: 
      bool2 = axgj.a(paramQQAppInterface);
      if (paramInt2 == 1) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramCard.uin, 4).edit();
        localEditor.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        localEditor.commit();
        bool1 = axgj.a(paramQQAppInterface);
        if (bool2 == bool1) {
          break;
        }
        axgj.a(paramQQAppInterface, bool1);
        return;
        bool1 = false;
      }
    case 42367: 
      paramCard.switch_life_achievement = ((short)paramInt2);
      return;
    case 42340: 
      paramCard.switch_musicbox = ((short)paramInt2);
      return;
    case 42356: 
      paramCard.switch_sticky_note = ((short)paramInt2);
      return;
    case 42361: 
      paramCard.switch_qqcircle = ((short)paramInt2);
      return;
    case 42377: 
      paramCard.switchWeishi = ((short)paramInt2);
      return;
    }
    if (paramInt2 == 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramCard.isShowCard = bool1;
      return;
    }
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Card paramCard, @Nullable bhha parambhha, @NotNull ArrayList<azaz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "outItems");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new azaz(5, 2131694629));
    Integer[][] arrayOfInteger = azba.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    Object localObject;
    azaz localazaz;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localazaz = ((azbd)this).a(localObject[0].intValue(), paramArrayList);
      localObject = ((azbd)this).a(paramQQAppInterface, parambhha, paramCard, 1, (Object[])localObject, localazaz);
      if (localObject != null) {
        switch (((azaz)localObject).b())
        {
        default: 
          ((azaz)localObject).d(2);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        ((azaz)localObject).d(1);
        continue;
        ((azaz)localObject).d(3);
      }
    }
    localArrayList.add(new azaz(5, 2131694631));
    arrayOfInteger = azba.a.b();
    j = arrayOfInteger.length;
    i = 0;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localazaz = ((azbd)this).a(localObject[0].intValue(), paramArrayList);
      localazaz = ((azbd)this).a(paramQQAppInterface, parambhha, paramCard, 2, (Object[])localObject, localazaz);
      if (localazaz != null) {
        switch (localazaz.b())
        {
        default: 
          localazaz.d(2);
          label314:
          switch (localObject[0].intValue())
          {
          }
          break;
        }
      }
      for (;;)
      {
        localArrayList.add(localazaz);
        i += 1;
        break;
        localazaz.d(1);
        break label314;
        localazaz.d(3);
        break label314;
        localArrayList.add(new azaz(4));
        localazaz.a(3);
        localazaz.b(2131709790);
        localazaz.d(0);
      }
    }
    paramArrayList.clear();
    paramArrayList.addAll((Collection)localArrayList);
    localArrayList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = azba.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final boolean a(@NotNull ArrayList<azaz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    return true;
  }
  
  public final boolean b(@NotNull ArrayList<azaz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((azaz)paramArrayList.next()).a()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbd
 * JD-Core Version:    0.7.0.1
 */