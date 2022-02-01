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
public final class azsn
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
  public final azsj a(int paramInt, @NotNull ArrayList<azsj> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      azsj localazsj = (azsj)paramArrayList.next();
      if (localazsj.b() == paramInt) {
        return localazsj;
      }
    }
    return null;
  }
  
  @Nullable
  public final azsj a(@NotNull QQAppInterface paramQQAppInterface, @NotNull biab parambiab, @NotNull Card paramCard, int paramInt, @NotNull Object[] paramArrayOfObject, @Nullable azsj paramazsj)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(parambiab, "configHelper");
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
    paramArrayOfObject = (Integer)azsk.a.a().get(j, Integer.valueOf(-1));
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.intValue() != -1)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfObject, "config");
      if (parambiab.a(paramArrayOfObject.intValue())) {
        break;
      }
      return null;
    }
    if ((j == 42356) && (!blvu.b())) {
      return null;
    }
    if ((j == 42361) && (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
      return null;
    }
    if (j == 42172)
    {
      parambiab = paramQQAppInterface.getManager(264);
      if (parambiab == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
      }
      parambiab = (asfu)parambiab;
      if ((paramCard.extendFriendEntryAddFriend != 1) || (!parambiab.d())) {
        return null;
      }
    }
    if ((j == 42075) && (bgsg.W((Context)paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1)) {
      return null;
    }
    if (paramazsj != null) {}
    for (int i = 1; i == 1; i = 0)
    {
      paramazsj.c(((azsn)this).a(j, paramCard, paramQQAppInterface));
      return paramazsj;
    }
    if (i == 0) {
      return new azsj(paramInt, j, ((azsn)this).a(j, paramCard, paramQQAppInterface), k);
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
      bool2 = ayah.a(paramQQAppInterface);
      if (paramInt2 == 1) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramCard.uin, 4).edit();
        localEditor.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        localEditor.commit();
        bool1 = ayah.a(paramQQAppInterface);
        if (bool2 == bool1) {
          break;
        }
        ayah.a(paramQQAppInterface, bool1);
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
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Card paramCard, @NotNull biab parambiab, @NotNull ArrayList<azsj> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Intrinsics.checkParameterIsNotNull(parambiab, "configHelper");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "outItems");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new azsj(5, 2131694472));
    Integer[][] arrayOfInteger = azsk.a.a();
    int j = arrayOfInteger.length;
    int i = 0;
    Object localObject;
    azsj localazsj;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localazsj = ((azsn)this).a(localObject[0].intValue(), paramArrayList);
      localObject = ((azsn)this).a(paramQQAppInterface, parambiab, paramCard, 1, (Object[])localObject, localazsj);
      if (localObject != null) {
        switch (((azsj)localObject).b())
        {
        default: 
          ((azsj)localObject).d(2);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        ((azsj)localObject).d(1);
        continue;
        ((azsj)localObject).d(3);
      }
    }
    localArrayList.add(new azsj(5, 2131694474));
    arrayOfInteger = azsk.a.b();
    j = arrayOfInteger.length;
    i = 0;
    if (i < j)
    {
      localObject = arrayOfInteger[i];
      localazsj = ((azsn)this).a(localObject[0].intValue(), paramArrayList);
      localazsj = ((azsn)this).a(paramQQAppInterface, parambiab, paramCard, 2, (Object[])localObject, localazsj);
      if (localazsj != null) {
        switch (localazsj.b())
        {
        default: 
          localazsj.d(2);
          label318:
          switch (localObject[0].intValue())
          {
          }
          break;
        }
      }
      for (;;)
      {
        localArrayList.add(localazsj);
        i += 1;
        break;
        localazsj.d(1);
        break label318;
        localazsj.d(3);
        break label318;
        localArrayList.add(new azsj(4));
        localazsj.a(3);
        localazsj.b(2131709449);
        localazsj.d(0);
      }
    }
    paramArrayList.clear();
    paramArrayList.addAll((Collection)localArrayList);
    localArrayList.clear();
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = azsk.a.a();
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
  
  public final boolean a(@NotNull ArrayList<azsj> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    return true;
  }
  
  public final boolean b(@NotNull ArrayList<azsj> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "settingItems");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((azsj)paramArrayList.next()).a()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsn
 * JD-Core Version:    0.7.0.1
 */