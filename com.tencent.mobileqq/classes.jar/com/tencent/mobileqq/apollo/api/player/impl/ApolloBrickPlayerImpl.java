package com.tencent.mobileqq.apollo.api.player.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.player.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.api.player.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.api.player.action.CMSAIOAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  private static final String TAG = "ApolloBrickPlayer";
  private static final boolean USE_RECORD_ACTION = true;
  private static ConcurrentHashMap<String, String> mActionKey2FilePathMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, FrameData> mActionKey2FrameData = new ConcurrentHashMap();
  private int mActionId = -1;
  public CMSAction mCMSAIOAction;
  public CMSPlayer mCMSPlayer = null;
  private ApolloBrickPlayerImpl.BrickCMSPlayerListener mCMSPlayerListener = null;
  private Map<String, URLDrawable.URLDrawableOptions> mCacheDrawwable = new HashMap();
  private IGetGifFrameCallback mCallback = null;
  private Context mContext;
  public int mHeight;
  private ImageView mImageView = null;
  private String mLastActionKey;
  private RelativeLayout mLayout = null;
  private Handler mMainHandler = null;
  public MessageForApollo mMessageForApollo;
  private View mPlayerView = null;
  private ImageView mPreview;
  private int mRoundCorner;
  public int mWidth;
  
  private static URLDrawable decodeApngDrawable(String paramString, Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseApngImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
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
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    localURLDrawableOptions.mUseMemoryCache = true;
    URLDrawable localURLDrawable = URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    if (paramMap != null) {
      paramMap.put(paramString, localURLDrawableOptions);
    }
    return localURLDrawable;
  }
  
  private ApngDrawable getApngDrawable()
  {
    if (this.mImageView != null)
    {
      Drawable localDrawable = this.mImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable))
      {
        localDrawable = ((URLDrawable)localDrawable).getCurrDrawable();
        if ((localDrawable instanceof ApngDrawable)) {
          return (ApngDrawable)localDrawable;
        }
      }
    }
    return null;
  }
  
  private void onActionLoaded()
  {
    if (this.mPreview != null) {
      this.mPreview.setVisibility(8);
    }
  }
  
  private void onActionLoading(boolean paramBoolean)
  {
    if (this.mPreview != null)
    {
      if (paramBoolean) {
        this.mPreview.setImageResource(2130838121);
      }
      this.mPreview.setVisibility(0);
    }
  }
  
  public void destroy()
  {
    Iterator localIterator = this.mCacheDrawwable.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
        URLDrawable.removeMemoryCacheByUrl((String)localEntry.getKey(), (URLDrawable.URLDrawableOptions)localEntry.getValue());
      }
    }
    if (this.mLayout != null) {
      this.mLayout.setVisibility(8);
    }
  }
  
  public View getView()
  {
    return this.mLayout;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void setAction(CMSAction paramCMSAction)
  {
    this.mCMSAIOAction = paramCMSAction;
    this.mActionId = this.mCMSAIOAction.d();
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
  
  public void setMessageForApollo(MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.mMessageForApollo = paramMessageForApollo;
    this.mCMSAIOAction = new CMSAIOAction(paramMessageForApollo, paramInt);
    if ((this.mMessageForApollo != null) && (this.mMessageForApollo.mApolloMessage != null)) {
      if (!this.mMessageForApollo.is3dAction()) {
        break label62;
      }
    }
    label62:
    for (paramInt = this.mMessageForApollo.mApollo3DMessage.actionID_3D;; paramInt = this.mMessageForApollo.mApolloMessage.id)
    {
      this.mActionId = paramInt;
      return;
    }
  }
  
  public void setParams(ApolloPlayerParams paramApolloPlayerParams)
  {
    if (paramApolloPlayerParams != null)
    {
      this.mWidth = paramApolloPlayerParams.jdField_a_of_type_Int;
      this.mHeight = paramApolloPlayerParams.b;
      this.mContext = paramApolloPlayerParams.jdField_a_of_type_AndroidContentContext.getApplicationContext();
      this.mRoundCorner = paramApolloPlayerParams.c;
    }
    if (this.mContext == null) {
      return;
    }
    this.mCMSPlayer = new CMSPlayer(this.mWidth, this.mHeight);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mLayout = new RelativeLayout(this.mContext);
    this.mImageView = new ImageView(this.mContext);
    paramApolloPlayerParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
    paramApolloPlayerParams.addRule(13);
    this.mImageView.setBackgroundColor(0);
    this.mLayout.addView(this.mImageView, paramApolloPlayerParams);
    this.mPreview = new ImageView(this.mContext);
    this.mPreview.setImageResource(2130838121);
    this.mPreview.setVisibility(8);
    int i = ViewUtils.b(70.0F);
    paramApolloPlayerParams = new RelativeLayout.LayoutParams(i, i);
    paramApolloPlayerParams.addRule(13, -1);
    this.mLayout.addView(this.mPreview, paramApolloPlayerParams);
  }
  
  public void start()
  {
    if (this.mCMSPlayer != null)
    {
      if (this.mLayout != null) {
        this.mLayout.setVisibility(0);
      }
      ThreadManager.excute(new ApolloBrickPlayerImpl.1(this), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl
 * JD-Core Version:    0.7.0.1
 */