package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MsgTabPlayInfo
  implements Serializable
{
  public static final int PLAY_SOURCE_FRIEND_HEADER = 1;
  public static final int PLAY_SOURCE_TAB = 0;
  public HashMap<String, String> mFeedIdMap = null;
  public final String mStartVid;
  public final String mStartVideoFeedId;
  public List<String> mVids = null;
  public final String nodeUnionId;
  final int source;
  final String uin;
  
  public MsgTabPlayInfo(@NonNull String paramString1, int paramInt, @Nullable String paramString2, String paramString3, String paramString4)
  {
    this.nodeUnionId = paramString1;
    this.source = paramInt;
    this.uin = paramString2;
    this.mStartVideoFeedId = paramString3;
    this.mStartVid = paramString4;
    if ((paramInt == 1) && (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("uin can't empty for friend header play");
    }
    AssertUtils.checkNotEmpty(paramString1);
  }
  
  public MsgTabPlayInfo(@NonNull String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, HashMap<String, String> paramHashMap)
  {
    this(paramString1, paramInt, paramString2, paramString3, paramString4);
    this.mVids = paramArrayList;
    this.mFeedIdMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo
 * JD-Core Version:    0.7.0.1
 */