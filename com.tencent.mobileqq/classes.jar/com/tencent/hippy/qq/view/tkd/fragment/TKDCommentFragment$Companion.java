package com.tencent.hippy.qq.view.tkd.fragment;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/view/tkd/fragment/TKDCommentFragment$Companion;", "", "()V", "FLAG_COMMENT_FIRST", "", "getFLAG_COMMENT_FIRST", "()I", "FLAG_COMMENT_OTHER", "getFLAG_COMMENT_OTHER", "FLAG_COMMENT_SECOND", "getFLAG_COMMENT_SECOND", "MODULE_NAME", "", "getMODULE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "create", "Lcom/tencent/hippy/qq/view/tkd/fragment/TKDCommentFragment;", "originalUrl", "configMap", "Lcom/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyChannelActivity$SerializableMap;", "hideTitle", "", "newInstance", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment$Companion
{
  @JvmStatic
  private final TKDCommentFragment newInstance(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new TKDCommentFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  @JvmStatic
  @NotNull
  public final TKDCommentFragment create(@Nullable String paramString, @Nullable ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putSerializable(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA, (Serializable)paramSerializableMap);
    if (paramBoolean) {
      localBundle.putInt(tvg.b, 1);
    }
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    return ((Companion)this).newInstance(localBundle);
  }
  
  public final int getFLAG_COMMENT_FIRST()
  {
    return TKDCommentFragment.access$getFLAG_COMMENT_FIRST$cp();
  }
  
  public final int getFLAG_COMMENT_OTHER()
  {
    return TKDCommentFragment.access$getFLAG_COMMENT_OTHER$cp();
  }
  
  public final int getFLAG_COMMENT_SECOND()
  {
    return TKDCommentFragment.access$getFLAG_COMMENT_SECOND$cp();
  }
  
  @NotNull
  public final String getMODULE_NAME()
  {
    return TKDCommentFragment.access$getMODULE_NAME$cp();
  }
  
  @NotNull
  public final String getTAG()
  {
    return TKDCommentFragment.access$getTAG$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.fragment.TKDCommentFragment.Companion
 * JD-Core Version:    0.7.0.1
 */