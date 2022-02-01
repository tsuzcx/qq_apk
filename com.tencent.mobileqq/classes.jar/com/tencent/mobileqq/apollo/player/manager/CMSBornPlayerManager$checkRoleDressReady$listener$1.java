package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$checkRoleDressReady$listener$1", "Lcom/tencent/mobileqq/apollo/api/res/IApolloResDownloader$OnApolloDownLoadListener;", "needDownloadUinList", "", "", "getNeedDownloadUinList", "()Ljava/util/List;", "onDownLoadFinish", "", "sucess", "", "uin", "roleId", "", "dressIds", "", "actionId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    QLog.i("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "checkRoleDressReady onDownloadFinish " + this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d() + ", " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      if (CollectionsKt.contains((Iterable)this.jdField_a_of_type_JavaUtilList, paramString))
      {
        paramArrayOfInt = (Collection)this.jdField_a_of_type_JavaUtilList;
        if (paramArrayOfInt == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        TypeIntrinsics.asMutableCollection(paramArrayOfInt).remove(paramString);
      }
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (CMSBornPlayerManager.a(CMSBornPlayerManager.a).containsKey(this.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "checkRoleDressReady resume record " + this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d());
        paramString = CMSBornPlayerManager.a;
        paramArrayOfInt = CMSBornPlayerManager.a(CMSBornPlayerManager.a).remove(this.jdField_a_of_type_JavaLangString);
        if (paramArrayOfInt == null) {
          Intrinsics.throwNpe();
        }
        CMSBornPlayerManager.b(paramString, (CMSBornPlayerManager.ActionItem)paramArrayOfInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.checkRoleDressReady.listener.1
 * JD-Core Version:    0.7.0.1
 */