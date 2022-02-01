package com.tencent.aelight.camera.aeeditor.module.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import java.util.LinkedList;
import java.util.List;

public class AEEditorMusicAdapter$AEEditorMusicInfo
{
  public static final List<AEEditorMusicInfo> a = ;
  public static final AEEditorMusicInfo b = l();
  public boolean c;
  public int d;
  public int e = 0;
  public final int f;
  public final boolean g;
  public final int h;
  private VsMusicItemInfo i;
  
  public AEEditorMusicAdapter$AEEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    this(paramVsMusicItemInfo, paramBoolean, paramInt, false, -1);
  }
  
  public AEEditorMusicAdapter$AEEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.i = paramVsMusicItemInfo;
    this.c = paramBoolean1;
    this.d = 0;
    this.f = paramInt1;
    this.g = paramBoolean2;
    this.h = paramInt2;
  }
  
  @NonNull
  private String j()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mMusicName == null) {
      return "";
    }
    return this.i.mMusicName;
  }
  
  @NonNull
  private static List<AEEditorMusicInfo> k()
  {
    LinkedList localLinkedList = new LinkedList();
    int k;
    for (int j = 0; j < 6; j = k)
    {
      Object localObject = new VsMusicItemInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeMid");
      k = j + 1;
      localStringBuilder.append(k);
      ((VsMusicItemInfo)localObject).mSongMid = localStringBuilder.toString();
      ((VsMusicItemInfo)localObject).mMusicName = "";
      ((VsMusicItemInfo)localObject).mUrl = "";
      ((VsMusicItemInfo)localObject).mAlbumUrl = "";
      if (j == 0) {
        localObject = new AEEditorMusicInfo((VsMusicItemInfo)localObject, false, 1);
      } else {
        localObject = new AEEditorMusicInfo((VsMusicItemInfo)localObject, false, 0);
      }
      localLinkedList.add(localObject);
    }
    return localLinkedList;
  }
  
  private static AEEditorMusicInfo l()
  {
    VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
    localVsMusicItemInfo.mSongMid = "fakeMid_template_bgm";
    localVsMusicItemInfo.mMusicName = "";
    localVsMusicItemInfo.mUrl = "";
    localVsMusicItemInfo.mAlbumUrl = "";
    return new AEEditorMusicInfo(localVsMusicItemInfo, false, 3);
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(c());
  }
  
  @Nullable
  public VsMusicItemInfo b()
  {
    return this.i;
  }
  
  @NonNull
  public String c()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mSongMid == null) {
      return "";
    }
    return this.i.mSongMid;
  }
  
  @NonNull
  public String d()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mUrl == null) {
      return "";
    }
    return this.i.mUrl;
  }
  
  public int e()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicStart;
  }
  
  public int f()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicDuration;
  }
  
  @NonNull
  public String g()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mAlbumUrl == null) {
      return "";
    }
    return this.i.mAlbumUrl;
  }
  
  @NonNull
  public String h()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.b == null) {
      return "";
    }
    return this.i.b;
  }
  
  @NonNull
  public String i()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.i;
    if (localVsMusicItemInfo == null) {
      return "LRC";
    }
    if (TextUtils.isEmpty(localVsMusicItemInfo.a)) {
      return "LRC";
    }
    return this.i.a;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{songMid:");
    localStringBuilder.append(c());
    localStringBuilder.append(", songName:");
    localStringBuilder.append(j());
    localStringBuilder.append(", songUrl:");
    localStringBuilder.append(d());
    localStringBuilder.append(", selected:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", downloadStatus:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", itemType:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo
 * JD-Core Version:    0.7.0.1
 */