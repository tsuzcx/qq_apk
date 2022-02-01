package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.cmshow.game.OpenGameBox.StBoxItem;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxRsp;
import trpc.cmshow.game.OpenGameBox.StScene;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/view/hippy/CmBattleGameDataRequest$getCmBattleGameDataFromNet$1", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "onGetCmBattleGameData", "", "isSuc", "", "data", "Ltrpc/cmshow/game/OpenGameBox$StOpenGameBoxRsp;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmBattleGameDataRequest$getCmBattleGameDataFromNet$1
  extends ApolloExtensionObserver
{
  CmBattleGameDataRequest$getCmBattleGameDataFromNet$1(AppInterface paramAppInterface, int paramInt1, int paramInt2, ICmBattleGameDataListener paramICmBattleGameDataListener) {}
  
  protected void a(boolean paramBoolean, @Nullable OpenGameBox.StOpenGameBoxRsp paramStOpenGameBoxRsp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetCmBattleGameData isSuc=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("CmBattleGameDataRequest", 2, ((StringBuilder)localObject).toString());
    }
    this.a.removeObserver((BusinessObserver)this);
    if ((paramBoolean) && (paramStOpenGameBoxRsp != null))
    {
      paramStOpenGameBoxRsp = (OpenGameBox.StScene)paramStOpenGameBoxRsp.scenes.get().get(0);
      if (this.b == paramStOpenGameBoxRsp.scene_id.get())
      {
        localObject = new ArrayList();
        Iterator localIterator = paramStOpenGameBoxRsp.items.get().iterator();
        while (localIterator.hasNext())
        {
          OpenGameBox.StBoxItem localStBoxItem = (OpenGameBox.StBoxItem)localIterator.next();
          CmBattleGameDataRequest localCmBattleGameDataRequest = CmBattleGameDataRequest.a;
          int i = this.b;
          int j = this.c;
          Intrinsics.checkExpressionValueIsNotNull(localStBoxItem, "item");
          ((ArrayList)localObject).add(CmBattleGameDataRequest.a(localCmBattleGameDataRequest, i, j, localStBoxItem));
        }
        this.d.a((List)localObject);
        CmBattleGameDataRequest.a.a(this.a, this.b, this.c, 1000L * paramStOpenGameBoxRsp.refresh_interval.get());
      }
    }
    else
    {
      this.d.a("data request error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameDataRequest.getCmBattleGameDataFromNet.1
 * JD-Core Version:    0.7.0.1
 */