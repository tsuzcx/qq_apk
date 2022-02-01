package com.tencent.mobileqq.apollo.meme.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.meme.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.meme.FrameData;
import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAIOAction;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloBrickPlayerImpl
  implements IApolloBrickPlayer
{
  private static final int DEFAULT_PREVIEW_SIZE = ViewUtils.dpToPx(70.0F);
  private static final String TAG = "[cmshow]ApolloBrickPlayer";
  private static ConcurrentHashMap<String, String> mActionKey2FilePathMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, FrameData> mActionKey2FrameData = new ConcurrentHashMap();
  private int mActionId = -1;
  private Map<String, URLDrawable.URLDrawableOptions> mCacheDrawwable = new HashMap();
  private IGetGifFrameCallback mCallback = null;
  private Context mContext;
  private ApolloBrickPlayerImpl.CustomMemePlayerListener mCustomMemePlayerListener = null;
  public int mHeight;
  private ImageView mImageView = null;
  private String mLastActionKey;
  private RelativeLayout mLayout = null;
  private Handler mMainHandler = null;
  public MemeAction mMemeAction;
  public MessageForApollo mMessageForApollo;
  private ImageView mPreview;
  private int mRoundCorner;
  public int mWidth;
  
  private static URLDrawable decodeApngDrawable(String paramString, Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseApngImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    URLDrawable localURLDrawable = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    if (paramMap != null) {
      paramMap.put(paramString, localURLDrawableOptions);
    }
    return localURLDrawable;
  }
  
  private static URLDrawable decodeGifDrawable(String paramString, Map<String, URLDrawable.URLDrawableOptions> paramMap, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    localURLDrawableOptions.mUseMemoryCache = true;
    URLDrawable localURLDrawable = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    if (paramMap != null) {
      paramMap.put(paramString, localURLDrawableOptions);
    }
    return localURLDrawable;
  }
  
  private ApolloBrickPlayerImpl.CustomMemePlayerListener genCustomPlayerListener()
  {
    ApolloBrickPlayerImpl.CustomMemePlayerListener localCustomMemePlayerListener = new ApolloBrickPlayerImpl.CustomMemePlayerListener(this.mActionId, this.mWidth, this.mHeight);
    localCustomMemePlayerListener.a(this.mImageView);
    localCustomMemePlayerListener.b(this.mPreview);
    localCustomMemePlayerListener.a(this.mLayout);
    localCustomMemePlayerListener.a(this.mRoundCorner);
    localCustomMemePlayerListener.a(this.mMainHandler);
    localCustomMemePlayerListener.a(this.mCacheDrawwable);
    localCustomMemePlayerListener.a(this.mCallback);
    return localCustomMemePlayerListener;
  }
  
  private void onActionLoaded()
  {
    ImageView localImageView = this.mPreview;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  private void onActionLoading(boolean paramBoolean)
  {
    Object localObject = this.mPreview;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      if (paramBoolean)
      {
        int i = DEFAULT_PREVIEW_SIZE;
        localObject = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
        this.mPreview.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mPreview.setImageResource(2130837994);
      }
    }
  }
  
  public void destroy()
  {
    Object localObject = this.mCacheDrawwable.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
        URLDrawable.removeMemoryCacheByUrl((String)localEntry.getKey(), (URLDrawable.URLDrawableOptions)localEntry.getValue());
      }
    }
    localObject = this.mLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(8);
    }
  }
  
  public View getView()
  {
    return this.mLayout;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void setAction(MemeAction paramMemeAction)
  {
    this.mMemeAction = paramMemeAction;
    this.mActionId = this.mMemeAction.m();
  }
  
  public void setCallback(IGetGifFrameCallback paramIGetGifFrameCallback)
  {
    if (paramIGetGifFrameCallback != null) {
      this.mCallback = paramIGetGifFrameCallback;
    }
  }
  
  public void setGetGifFrameCallback(IGetGifFrameCallback paramIGetGifFrameCallback)
  {
    this.mCallback = paramIGetGifFrameCallback;
  }
  
  public void setLoadingView(Drawable paramDrawable)
  {
    this.mPreview.setImageDrawable(paramDrawable);
  }
  
  public void setMessageForApollo(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof MessageForApollo))
    {
      this.mMessageForApollo = ((MessageForApollo)paramObject);
      this.mMemeAction = new MemeAIOAction(this.mMessageForApollo, paramInt);
      paramObject = this.mMessageForApollo;
      if ((paramObject != null) && (paramObject.mApolloMessage != null))
      {
        if (this.mMessageForApollo.is3dAction()) {
          paramInt = this.mMessageForApollo.mApollo3DMessage.actionID3D;
        } else {
          paramInt = this.mMessageForApollo.mApolloMessage.id;
        }
        this.mActionId = paramInt;
      }
    }
  }
  
  public void setParams(ApolloPlayerParams paramApolloPlayerParams)
  {
    if (paramApolloPlayerParams != null)
    {
      this.mWidth = paramApolloPlayerParams.b;
      this.mHeight = paramApolloPlayerParams.c;
      this.mContext = paramApolloPlayerParams.a.getApplicationContext();
      this.mRoundCorner = paramApolloPlayerParams.d;
    }
    if (this.mContext == null) {
      return;
    }
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mLayout = new RelativeLayout(this.mContext);
    this.mImageView = new ImageView(this.mContext);
    this.mImageView.setId(2131442138);
    paramApolloPlayerParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
    paramApolloPlayerParams.addRule(13);
    this.mImageView.setBackgroundColor(0);
    this.mLayout.addView(this.mImageView, paramApolloPlayerParams);
    this.mPreview = new ImageView(this.mContext);
    this.mPreview.setImageResource(2130837994);
    this.mPreview.setVisibility(8);
    int i = DEFAULT_PREVIEW_SIZE;
    paramApolloPlayerParams = new RelativeLayout.LayoutParams(i, i);
    paramApolloPlayerParams.addRule(13, -1);
    this.mLayout.addView(this.mPreview, paramApolloPlayerParams);
  }
  
  public void start()
  {
    RelativeLayout localRelativeLayout = this.mLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(0);
    }
    ThreadManager.excute(new ApolloBrickPlayerImpl.1(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl
 * JD-Core Version:    0.7.0.1
 */