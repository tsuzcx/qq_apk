import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import common.config.service.QzoneConfig;
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
public final class bald
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
  public final bakz a(int paramInt, @NotNull ArrayList<bakz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bakz localbakz = (bakz)paramArrayList.next();
      if (localbakz.b() == paramInt) {
        return localbakz;
      }
    }
    return null;
  }
  
  @Nullable
  public final bakz a(@NotNull QQAppInterface paramQQAppInterface, @NotNull bjaz parambjaz, @NotNull Card paramCard, int paramInt, @NotNull Object[] paramArrayOfObject, @Nullable bakz parambakz)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(parambjaz, "configHelper");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "item");
    if (paramArrayOfObject.length <= 1) {
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
    paramArrayOfObject = (Integer)bala.a.a().get(j, Integer.valueOf(-1));
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.intValue() != -1)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfObject, "config");
      if (parambjaz.a(paramArrayOfObject.intValue())) {
        break;
      }
      return null;
    }
    if ((j == 42356) && (!bmww.b())) {
      return null;
    }
    if ((j == 42361) && (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
      return null;
    }
    if (j == 42172)
    {
      parambjaz = paramQQAppInterface.getManager(264);
      if (parambjaz == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
      }
      parambjaz = (asvi)parambjaz;
      if ((paramCard.extendFriendEntryAddFriend != 1) || (!parambjaz.d())) {
        return null;
      }
    }
    if ((j == 42075) && (bhsi.W((Context)paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1)) {
      return null;
    }
    if (parambakz != null) {}
    for (int i = 1; i == 1; i = 0)
    {
      parambakz.c(((bald)this).a(j, paramCard, paramQQAppInterface));
      return parambakz;
    }
    if (i == 0) {
      return new bakz(paramInt, j, ((bald)this).a(j, paramCard, paramQQAppInterface), k);
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
      bool2 = aytb.a(paramQQAppInterface);
      if (paramInt2 == 1) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramCard.uin, 4).edit();
        localEditor.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        localEditor.commit();
        bool1 = aytb.a(paramQQAppInterface);
        if (bool2 == bool1) {
          break;
        }
        aytb.a(paramQQAppInterface, bool1);
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
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Card paramCard, @NotNull bjaz parambjaz, @NotNull ArrayList<bakz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(parambjaz, "configHelper");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "outItems");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bakz(5, 2131694514));
    Integer[][] arrayOfInteger = bala.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    Object localObject;
    bakz localbakz;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localbakz = ((bald)this).a(localObject[0].intValue(), paramArrayList);
      localObject = ((bald)this).a(paramQQAppInterface, parambjaz, paramCard, 1, (Object[])localObject, localbakz);
      if (localObject != null) {
        switch (((bakz)localObject).b())
        {
        default: 
          ((bakz)localObject).d(2);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        ((bakz)localObject).d(1);
        continue;
        ((bakz)localObject).d(3);
      }
    }
    localArrayList.add(new bakz(5, 2131694516));
    arrayOfInteger = bala.a.b();
    j = arrayOfInteger.length;
    i = 0;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localbakz = ((bald)this).a(localObject[0].intValue(), paramArrayList);
      localbakz = ((bald)this).a(paramQQAppInterface, parambjaz, paramCard, 2, (Object[])localObject, localbakz);
      if (localbakz != null) {
        switch (localbakz.b())
        {
        default: 
          localbakz.d(2);
          label318:
          switch (localObject[0].intValue())
          {
          }
          break;
        }
      }
      for (;;)
      {
        localArrayList.add(localbakz);
        i += 1;
        break;
        localbakz.d(1);
        break label318;
        localbakz.d(3);
        break label318;
        localArrayList.add(new bakz(4));
        localbakz.a(3);
        localbakz.b(2131709558);
        localbakz.d(0);
      }
    }
    paramArrayList.clear();
    paramArrayList.addAll((Collection)localArrayList);
    localArrayList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = bala.a.a();
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
  
  public final boolean a(@NotNull ArrayList<bakz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    return true;
  }
  
  public final boolean b(@NotNull ArrayList<bakz> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((bakz)paramArrayList.next()).a()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bald
 * JD-Core Version:    0.7.0.1
 */