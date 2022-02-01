package com.tencent.mobileqq.apollo.web.ipc;

import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/web/ipc/StoreAvatar2D$preview$1", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "onDownLoadFinish", "", "success", "", "uin", "", "roleId", "", "dressIds", "", "actionId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class StoreAvatar2D$preview$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  StoreAvatar2D$preview$1(IStoreAvatar2D.PreviewCallback paramPreviewCallback) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      this.a.a(0, paramArrayOfInt);
      return;
    }
    this.a.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D.preview.1
 * JD-Core Version:    0.7.0.1
 */