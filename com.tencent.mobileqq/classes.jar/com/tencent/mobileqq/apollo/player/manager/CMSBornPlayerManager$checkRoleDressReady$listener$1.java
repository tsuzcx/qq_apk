package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$checkRoleDressReady$listener$1", "Lcom/tencent/mobileqq/apollo/res/api/IApolloResDownloader$OnApolloDownLoadListener;", "needDownloadUinList", "", "", "getNeedDownloadUinList", "()Ljava/util/List;", "onDownLoadFinish", "", "sucess", "", "uin", "roleId", "", "dressIds", "", "actionId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$checkRoleDressReady$listener$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  @NotNull
  private final List<String> jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  
  CMSBornPlayerManager$checkRoleDressReady$listener$1(CMSBornPlayerManager.ActionItem paramActionItem, String paramString) {}
  
  @NotNull
  public final List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("checkRoleDressReady onDownloadFinish ");
    paramArrayOfInt.append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d());
    paramArrayOfInt.append(", ");
    paramArrayOfInt.append(paramBoolean);
    paramArrayOfInt.append(", ");
    paramArrayOfInt.append(paramString);
    QLog.i("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, paramArrayOfInt.toString());
    if (paramBoolean)
    {
      if (CollectionsKt.contains((Iterable)this.jdField_a_of_type_JavaUtilList, paramString))
      {
        paramArrayOfInt = (Collection)this.jdField_a_of_type_JavaUtilList;
        if (paramArrayOfInt != null) {
          TypeIntrinsics.asMutableCollection(paramArrayOfInt).remove(paramString);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (CMSBornPlayerManager.a(CMSBornPlayerManager.a).containsKey(this.jdField_a_of_type_JavaLangString)))
      {
        paramString = new StringBuilder();
        paramString.append("checkRoleDressReady resume record ");
        paramString.append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d());
        QLog.i("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, paramString.toString());
        paramString = CMSBornPlayerManager.a;
        paramArrayOfInt = CMSBornPlayerManager.a(CMSBornPlayerManager.a).remove(this.jdField_a_of_type_JavaLangString);
        if (paramArrayOfInt == null) {
          Intrinsics.throwNpe();
        }
        CMSBornPlayerManager.a(paramString, (CMSBornPlayerManager.ActionItem)paramArrayOfInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.checkRoleDressReady.listener.1
 * JD-Core Version:    0.7.0.1
 */