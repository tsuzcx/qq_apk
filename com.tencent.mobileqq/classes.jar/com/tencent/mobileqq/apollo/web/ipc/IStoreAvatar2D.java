package com.tencent.mobileqq.apollo.web.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@ServletImpl(a=StoreAvatar2D.class)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D;", "", "addCmFace", "", "jsonArray", "Lorg/json/JSONArray;", "callback", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$AddCmFaceCallback;", "addFavAction", "actionId", "", "actionText", "", "textType", "audioId", "playOriginalAudio", "audioStartTime", "", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$AddFavActionCallback;", "changeRole", "roleId", "dressIds", "", "fromSelf", "userData", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$ChangeRoleCallback;", "checkAvatarRes", "apolloList", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$CheckAvatarResCallback;", "clearBubble", "bubbleId", "", "cmsTraceReport", "reqParam", "Landroid/os/Bundle;", "delFavList", "delJson", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$DelFavListCallback;", "downloadGame", "gameId", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$DownloadGameCallback;", "getApolloData", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$GetApolloDataCallback;", "getFavAction", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$GetFavActionCallback;", "isCmFaceAdded", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$IsCmFaceAddedCallback;", "preview", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$PreviewCallback;", "previewAction", "actionData", "Lcom/tencent/mobileqq/apollo/store/ApolloStoreViewController$PlayActionData;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$PreviewActionCallback;", "queryMineRedInfo", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$QueryMineRedInfoCallback;", "refreshAction", "setCapsule", "uin", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$SetCapsuleCallback;", "setupUser", "startApolloGame", "startCheckParam", "Lcom/tencent/mobileqq/apollo/model/StartCheckParam;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$StartApolloGameCallback;", "updateUseAvatarInfo", "avatarTs", "dressId", "writeLocal", "writeDataJson", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$WriteLocalCallback;", "AddCmFaceCallback", "AddFavActionCallback", "ChangeRoleCallback", "CheckAvatarResCallback", "DelFavListCallback", "DownloadGameCallback", "GetApolloDataCallback", "GetFavActionCallback", "IsCmFaceAddedCallback", "PreviewActionCallback", "PreviewCallback", "QueryMineRedInfoCallback", "SetCapsuleCallback", "StartApolloGameCallback", "WriteLocalCallback", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IStoreAvatar2D
{
  public abstract void a();
  
  public abstract void a(int paramInt, @NotNull @RemoteCallBack IStoreAvatar2D.DownloadGameCallback paramDownloadGameCallback);
  
  public abstract void a(int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, @NotNull @RemoteCallBack IStoreAvatar2D.AddFavActionCallback paramAddFavActionCallback);
  
  public abstract void a(int paramInt1, @NotNull int[] paramArrayOfInt, int paramInt2, @NotNull String paramString, @NotNull @RemoteCallBack IStoreAvatar2D.ChangeRoleCallback paramChangeRoleCallback);
  
  public abstract void a(long paramLong);
  
  public abstract void a(@NotNull Bundle paramBundle);
  
  public abstract void a(@NotNull StartCheckParam paramStartCheckParam, @NotNull @RemoteCallBack IStoreAvatar2D.StartApolloGameCallback paramStartApolloGameCallback);
  
  public abstract void a(@Nullable ApolloStoreViewController.PlayActionData paramPlayActionData, @Nullable @RemoteCallBack IStoreAvatar2D.PreviewActionCallback paramPreviewActionCallback);
  
  public abstract void a(@NotNull @RemoteCallBack IStoreAvatar2D.GetApolloDataCallback paramGetApolloDataCallback);
  
  public abstract void a(@NotNull @RemoteCallBack IStoreAvatar2D.GetFavActionCallback paramGetFavActionCallback);
  
  public abstract void a(@NotNull @RemoteCallBack IStoreAvatar2D.QueryMineRedInfoCallback paramQueryMineRedInfoCallback);
  
  public abstract void a(@NotNull Serializable paramSerializable, @NotNull @RemoteCallBack IStoreAvatar2D.CheckAvatarResCallback paramCheckAvatarResCallback);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@Nullable String paramString, long paramLong, @NotNull int[] paramArrayOfInt);
  
  public abstract void a(@NotNull String paramString, @NotNull @RemoteCallBack IStoreAvatar2D.SetCapsuleCallback paramSetCapsuleCallback);
  
  public abstract void a(@Nullable JSONArray paramJSONArray, @NotNull @RemoteCallBack IStoreAvatar2D.AddCmFaceCallback paramAddCmFaceCallback);
  
  public abstract void a(@Nullable JSONArray paramJSONArray, @NotNull @RemoteCallBack IStoreAvatar2D.DelFavListCallback paramDelFavListCallback);
  
  public abstract void a(@Nullable JSONArray paramJSONArray, @NotNull @RemoteCallBack IStoreAvatar2D.IsCmFaceAddedCallback paramIsCmFaceAddedCallback);
  
  public abstract void a(@NotNull JSONObject paramJSONObject, @NotNull @RemoteCallBack IStoreAvatar2D.WriteLocalCallback paramWriteLocalCallback);
  
  public abstract void a(@NotNull int[] paramArrayOfInt, @NotNull @RemoteCallBack IStoreAvatar2D.PreviewCallback paramPreviewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D
 * JD-Core Version:    0.7.0.1
 */