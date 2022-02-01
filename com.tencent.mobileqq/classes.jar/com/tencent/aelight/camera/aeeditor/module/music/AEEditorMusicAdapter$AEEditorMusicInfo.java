package com.tencent.aelight.camera.aeeditor.module.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import java.util.LinkedList;
import java.util.List;

public class AEEditorMusicAdapter$AEEditorMusicInfo
{
  public static final AEEditorMusicInfo a;
  public static final List<AEEditorMusicInfo> a;
  public int a;
  private VsMusicItemInfo a;
  public boolean a;
  public int b;
  public final boolean b;
  public final int c;
  public final int d;
  
  static
  {
    jdField_a_of_type_JavaUtilList = a();
    jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = a();
  }
  
  public AEEditorMusicAdapter$AEEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    this(paramVsMusicItemInfo, paramBoolean, paramInt, false, -1);
  }
  
  public AEEditorMusicAdapter$AEEditorMusicInfo(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 0;
    this.c = paramInt1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.d = paramInt2;
  }
  
  private static AEEditorMusicInfo a()
  {
    VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
    localVsMusicItemInfo.mSongMid = "fakeMid_template_bgm";
    localVsMusicItemInfo.mMusicName = "";
    localVsMusicItemInfo.mUrl = "";
    localVsMusicItemInfo.mAlbumUrl = "";
    return new AEEditorMusicInfo(localVsMusicItemInfo, false, 3);
  }
  
  @NonNull
  private static List<AEEditorMusicInfo> a()
  {
    LinkedList localLinkedList = new LinkedList();
    int j;
    for (int i = 0; i < 6; i = j)
    {
      Object localObject = new VsMusicItemInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeMid");
      j = i + 1;
      localStringBuilder.append(j);
      ((VsMusicItemInfo)localObject).mSongMid = localStringBuilder.toString();
      ((VsMusicItemInfo)localObject).mMusicName = "";
      ((VsMusicItemInfo)localObject).mUrl = "";
      ((VsMusicItemInfo)localObject).mAlbumUrl = "";
      if (i == 0) {
        localObject = new AEEditorMusicInfo((VsMusicItemInfo)localObject, false, 1);
      } else {
        localObject = new AEEditorMusicInfo((VsMusicItemInfo)localObject, false, 0);
      }
      localLinkedList.add(localObject);
    }
    return localLinkedList;
  }
  
  @NonNull
  private String f()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mMusicName == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mMusicName;
  }
  
  public int a()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicStart;
  }
  
  @Nullable
  public VsMusicItemInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  }
  
  @NonNull
  public String a()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mSongMid == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(a());
  }
  
  public int b()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return 0;
    }
    return localVsMusicItemInfo.musicDuration;
  }
  
  @NonNull
  public String b()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mUrl == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mUrl;
  }
  
  @NonNull
  public String c()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.mAlbumUrl == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mAlbumUrl;
  }
  
  @NonNull
  public String d()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "";
    }
    if (localVsMusicItemInfo.b == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.b;
  }
  
  @NonNull
  public String e()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if (localVsMusicItemInfo == null) {
      return "LRC";
    }
    if (TextUtils.isEmpty(localVsMusicItemInfo.a)) {
      return "LRC";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{songMid:");
    localStringBuilder.append(a());
    localStringBuilder.append(", songName:");
    localStringBuilder.append(f());
    localStringBuilder.append(", songUrl:");
    localStringBuilder.append(b());
    localStringBuilder.append(", selected:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", downloadStatus:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", itemType:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo
 * JD-Core Version:    0.7.0.1
 */