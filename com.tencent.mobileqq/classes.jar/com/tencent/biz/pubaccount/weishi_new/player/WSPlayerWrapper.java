package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerListener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class WSPlayerWrapper
  implements WSPlayerState, IWSPlayerListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private WSPlayerListenerAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
  private IWSPlayer jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
  private IWSPlayerFactory jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory;
  private IWSVideoView jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private volatile ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean = false;
  private long e;
  private long f;
  private long g;
  private long h = -1L;
  private long i;
  private long j = 0L;
  private long k;
  
  public WSPlayerWrapper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private int a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramArrayList != null) {
      try
      {
        paramInt = ((Integer)paramArrayList.get(paramInt)).intValue();
        return paramInt;
      }
      catch (Exception paramArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSPlayerWrapper.java][getSpeedFromListCache] e:");
        localStringBuilder.append(paramArrayList.getMessage());
        WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  private AbsWSPlayerInfo a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AbsWSPlayerInfo localAbsWSPlayerInfo = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a();
    localAbsWSPlayerInfo.a(paramString1, paramString2, paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, this.jdField_c_of_type_Boolean, this.jdField_b_of_type_Boolean);
    return localAbsWSPlayerInfo;
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    paramString3 = new StringBuilder();
    paramString3.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] url:");
    paramString3.append(paramString2);
    paramString3.append(", fileSize:");
    paramString3.append(paramLong2);
    paramString3.append(", videoDuration:");
    paramString3.append(paramInt2);
    paramString3.append(", mState:");
    paramString3.append(WSPlayerUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    WSLog.e("WS_VIDEO_PLAYER", paramString3.toString());
    if (h())
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] checkPlayerStartState return true.");
      return false;
    }
    paramString1 = a(paramString1, paramString2, paramInt1, paramLong2, paramInt2, paramBoolean1, paramBoolean2);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer != null))
    {
      paramString3 = new StringBuilder();
      paramString3.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] url:");
      paramString3.append(paramString2);
      paramString3.append(", fileSize:");
      paramString3.append(paramLong2);
      paramString3.append(", videoDuration:");
      paramString3.append(paramInt2);
      paramString3.append(", mState:");
      paramString3.append(WSPlayerUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      WSLog.e("WS_VIDEO_PLAYER", paramString3.toString());
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a(this.jdField_a_of_type_AndroidContentContext, paramLong1, 0, paramString1);
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[WSPlayerWrapper.java][innerPlayerStartByUrl] openMediaPlayerByUrl error:");
        paramString2.append(paramString1.getMessage());
        WSLog.d("WS_VIDEO_PLAYER", paramString2.toString());
      }
    }
    this.jdField_b_of_type_Long = paramInt2;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = paramLong1;
    return true;
  }
  
  private IWSVideoView b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory == null)
    {
      a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory == null) {
        return null;
      }
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][createVideoViewScroll]: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a(localContext, VersionUtils.d());
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
      }
    }
    ??? = this.jdField_a_of_type_JavaUtilArrayList;
    if ((??? != null) && (((ArrayList)???).size() <= 20)) {
      ((ArrayList)???).add(Integer.valueOf(paramInt));
    }
  }
  
  private void d(IWSPlayer paramIWSPlayer)
  {
    ThreadManager.post(new WSPlayerWrapper.1(this, paramIWSPlayer), 5, null, false);
  }
  
  private boolean h()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSPlayerWrapper.java][checkPlayerStartState] not idle or complete state, should't reopen media player mState:");
      localStringBuilder.append(WSPlayerUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory = WSPlayerWrapHelper.a().a();
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
    if (localObject != null)
    {
      localObject = ((IWSVideoView)localObject).a();
      if ((localObject instanceof IVideoViewBase)) {
        ((IVideoViewBase)localObject).doCacheSurfaceTexture();
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
    if (localObject != null)
    {
      localObject = ((IWSVideoView)localObject).a();
      if ((localObject instanceof IVideoViewBase)) {
        ((IVideoViewBase)localObject).doRecoverSurfaceTexture();
      }
    }
  }
  
  public int a()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      return localIWSPlayer.a();
    }
    return -1;
  }
  
  public long a()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer == null) {
      return 0L;
    }
    return localIWSPlayer.b();
  }
  
  public long a(boolean paramBoolean)
  {
    long l3 = this.jdField_c_of_type_Long;
    long l1;
    if (paramBoolean) {
      l1 = b();
    } else {
      l1 = a();
    }
    long l4 = this.e;
    long l2 = l3;
    if (l1 - l4 > 0L) {
      l2 = l3 + (l1 - l4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerWrapper.java][getTotalPlayTime] result:");
    localStringBuilder.append(l2);
    WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    return l2;
  }
  
  public IWSPlayer a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
  }
  
  public IWSVideoView a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = b();
        }
      }
      finally {}
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
    if (localObject2 != null)
    {
      localObject2 = ((IWSVideoView)localObject2).a();
      if (localObject2 != null) {
        a((View)localObject2);
      }
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    l();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][initMediaPlayer] success!");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      long l2 = this.e;
      if (l1 - l2 > 0L) {
        this.jdField_c_of_type_Long += l1 - l2;
      }
      this.e = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.b(paramInt);
      this.jdField_a_of_type_Boolean = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSPlayerWrapper.java][seekTo] mTotalPlayTime:");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append(", mLastPlayPosition:");
      localStringBuilder.append(this.e);
      WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    this.k = paramLong;
    c(paramInt);
    for (;;)
    {
      try
      {
        paramInt = new JSONObject(paramString).optInt("hitDownloaded");
        bool = true;
        if (paramInt == 1)
        {
          this.jdField_d_of_type_Boolean = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      m();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
      n();
    }
  }
  
  public void a(WSPlayerListenerAdapter paramWSPlayerListenerAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter = paramWSPlayerListenerAdapter;
  }
  
  public void a(IWSPlayer paramIWSPlayer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerWrapper.java][onVideoPrepared] streamDumpInfo:");
    ((StringBuilder)localObject).append(paramIWSPlayer.a());
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (localObject != null) {
      ((WSPlayerListenerAdapter)localObject).a(this, this.jdField_b_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localObject != null) {
      this.jdField_a_of_type_Long = ((IWSPlayer)localObject).a();
    }
    d(paramIWSPlayer);
  }
  
  public void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2)
  {
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView)
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = paramIWSVideoView;
    localIWSPlayer.a(paramIWSVideoView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a(this.jdField_a_of_type_Int);
  }
  
  public void a(IWSVideoView paramIWSVideoView, ViewGroup paramViewGroup)
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null)
    {
      if (paramViewGroup == null) {
        return;
      }
      localIWSPlayer.a(paramIWSVideoView, paramViewGroup);
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_b_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (localObject != null) {
      ((WSPlayerListenerAdapter)localObject).a(this, paramString);
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject = new JSONObject(paramString);
        long l = ((JSONObject)localObject).getLong("fileSize");
        int m = ((JSONObject)localObject).getInt("speedKBS");
        int n = ((JSONObject)localObject).getInt("offset");
        i1 = ((JSONObject)localObject).getInt("callBackType");
        if (l > 0L) {
          this.k = l;
        }
        if (i1 == 2)
        {
          c(m);
        }
        else
        {
          if (i1 != 1) {
            break label179;
          }
          this.jdField_a_of_type_JavaLangString = paramString;
          localObject = ((JSONObject)localObject).optString("contentType");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter.b(this, paramString);
            continue;
            if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter.c(this);
            }
          }
        }
        if (n > 0)
        {
          this.j = n;
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label179:
      if (i1 != 7) {
        if (i1 != 50) {}
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onError]!!");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(IWSPlayer paramIWSPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 40)
    {
      if (paramInt != 112)
      {
        if (paramInt == 113)
        {
          paramIWSPlayer = new StringBuilder();
          paramIWSPlayer.append("[WSPlayerWrapper.java][onInfo] end buffering <=== isSeeking:");
          paramIWSPlayer.append(this.jdField_a_of_type_Boolean);
          WSLog.g("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
          }
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_Int += 1;
            this.g += System.currentTimeMillis() - this.f;
          }
        }
      }
      else
      {
        paramIWSPlayer = new StringBuilder();
        paramIWSPlayer.append("[WSPlayerWrapper.java][onInfo] start buffering ===> isSeeking:");
        paramIWSPlayer.append(this.jdField_a_of_type_Boolean);
        WSLog.g("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
        }
        this.f = System.currentTimeMillis();
      }
    }
    else if ((paramObject instanceof String))
    {
      int m;
      try
      {
        m = new JSONObject((String)paramObject).optInt("skipFrameCount", 1);
      }
      catch (JSONException paramIWSPlayer)
      {
        paramIWSPlayer.printStackTrace();
        m = 0;
      }
      if (m > 0) {
        this.jdField_b_of_type_Int += m;
      }
    }
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this, paramInt, paramObject);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public int b()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      return localIWSPlayer.b();
    }
    return -1;
  }
  
  public long b()
  {
    long l = this.jdField_a_of_type_Long;
    if (l > 0L) {
      return l;
    }
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null)
    {
      if (localIWSPlayer.a() > 0L) {
        return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a();
      }
      return this.jdField_b_of_type_Long;
    }
    return -1L;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a();
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][start]");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localObject != null) {
      ((IWSPlayer)localObject).a(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerWrapper.java][setXYAxis] value:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
  }
  
  public void b(IWSPlayer paramIWSPlayer)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.a(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    ??? = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (??? != null) {
      ThreadManager.executeOnSubThread(new WSPlayerWrapper.2(this, (IWSPlayer)???));
    }
    if (paramBoolean)
    {
      ??? = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
      if (??? != null)
      {
        ??? = ((IWSVideoView)???).a();
        if ((??? != null) && (((View)???).getParent() != null))
        {
          ViewParent localViewParent = ((View)???).getParent();
          if ((localViewParent instanceof ViewGroup)) {
            ((ViewGroup)localViewParent).removeView((View)???);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter = null;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.h = 0L;
      this.j = 0L;
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][destroy]");
      return;
    }
  }
  
  public boolean b()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      return localIWSPlayer.a();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.k;
  }
  
  public String c()
  {
    int m;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Object localObject2 = new StringBuilder();
        int n = Math.min(20, this.jdField_a_of_type_JavaUtilArrayList.size());
        m = 0;
        if (m < n)
        {
          ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_JavaUtilArrayList, m));
          if (m != n - 1) {
            ((StringBuilder)localObject2).append(",");
          }
        }
        else
        {
          localObject2 = ((StringBuilder)localObject2).toString();
          return localObject2;
        }
      }
      else
      {
        return "";
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.b();
    }
  }
  
  public void c(IWSPlayer paramIWSPlayer)
  {
    paramIWSPlayer = new StringBuilder();
    paramIWSPlayer.append("[WSPlayerWrapper.java][onSeekComplete] isPause:");
    paramIWSPlayer.append(c());
    WSLog.e("WS_VIDEO_PLAYER", paramIWSPlayer.toString());
    paramIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerListenerAdapter;
    if (paramIWSPlayer != null) {
      paramIWSPlayer.b(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new WSPlayerWrapper.3(this, paramBoolean), 16, null, false);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 6) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      return localIWSPlayer.b();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long d()
  {
    return this.i;
  }
  
  @WorkerThread
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop] player had destroyed! return!");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer.c();
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop]");
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long e()
  {
    return this.g;
  }
  
  public void e()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      localIWSPlayer.e();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public long f()
  {
    return this.jdField_d_of_type_Long + a(d());
  }
  
  public void f()
  {
    IWSPlayer localIWSPlayer = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayer;
    if (localIWSPlayer != null) {
      localIWSPlayer.f();
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long g()
  {
    if (this.h == -1L) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          int i1 = Math.min(10, this.jdField_a_of_type_JavaUtilArrayList.size());
          int m = 0;
          int n = 0;
          while (m < i1)
          {
            n += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(m)).intValue();
            m += 1;
          }
          if (i1 != 0) {
            this.h = (n / i1);
          }
        }
      }
    }
    return this.h;
  }
  
  public void g()
  {
    b(true);
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public long h()
  {
    int m;
    label115:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      long l1 = -1L;
      long l2 = l1;
      if (localArrayList != null)
      {
        l2 = l1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          int n = this.jdField_a_of_type_JavaUtilArrayList.size();
          m = 0;
          l2 = l1;
          if (m < n)
          {
            int i1 = a(this.jdField_a_of_type_JavaUtilArrayList, m);
            if (m == 0)
            {
              l1 = i1;
              break label115;
            }
            l1 = Math.min(i1, l1);
            break label115;
          }
        }
      }
      return l2;
    }
  }
  
  public void h()
  {
    this.jdField_d_of_type_Long += a(d());
    this.e = a();
    this.jdField_c_of_type_Long = 0L;
  }
  
  public long i()
  {
    int m;
    label115:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      long l1 = -1L;
      long l2 = l1;
      if (localArrayList != null)
      {
        l2 = l1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          int n = this.jdField_a_of_type_JavaUtilArrayList.size();
          m = 0;
          l2 = l1;
          if (m < n)
          {
            int i1 = a(this.jdField_a_of_type_JavaUtilArrayList, m);
            if (m == 0)
            {
              l1 = i1;
              break label115;
            }
            l1 = Math.max(i1, l1);
            break label115;
          }
        }
      }
      return l2;
    }
  }
  
  public void i()
  {
    long l2 = b();
    long l3 = this.e;
    long l1 = 0L;
    if (l2 - l3 > 0L) {
      l1 = l2 - l3;
    }
    this.jdField_c_of_type_Long += l1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerWrapper.java][addTotalPlayTimeForLoop] mTotalPlayTime:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    WSLog.g("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
  }
  
  public long j()
  {
    long l1 = this.i;
    if (l1 > 0L)
    {
      long l2 = this.j;
      if (l2 > 0L) {
        return l2 / l1;
      }
    }
    return 0L;
  }
  
  public void j()
  {
    this.e = 0L;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.e = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.f = 0L;
    this.g = 0L;
    this.jdField_c_of_type_Int = 0;
    this.i = 0L;
    this.k = 0L;
    this.h = -1L;
    this.j = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */