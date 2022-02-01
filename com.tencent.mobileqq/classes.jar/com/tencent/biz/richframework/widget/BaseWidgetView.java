package com.tencent.biz.richframework.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.IExtraInfo;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class BaseWidgetView<T>
  extends FrameLayout
  implements IExtraInfo
{
  private static final int CLICK_INTERVAL = 800;
  private T data;
  protected int dataPosInList = -1;
  private SparseArray<Long> lastClickViewArray = new SparseArray();
  private Serializable mExtraTypeInfo;
  private WeakReference<Activity> mHostActivity;
  private BaseWidgetView.IInteractor mInteractor;
  private Handler mMainHandler;
  private HashMap<Integer, BaseWidgetView.ItemPreClickListener> mPreClickCollections = new HashMap();
  protected int mViewType;
  
  public BaseWidgetView(@NonNull Context paramContext)
  {
    this(paramContext, Integer.valueOf(0));
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    handleAttr(paramContext, paramAttributeSet);
    initView(paramContext, paramInt2);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, Integer paramInteger)
  {
    this(paramContext, null, 0, paramInteger.intValue());
  }
  
  public BaseWidgetView(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  private void initView(Context paramContext, int paramInt)
  {
    this.mViewType = paramInt;
    beforeInflateView(paramContext, paramInt);
    if (getLayoutId() != 0) {
      LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
    }
    onInitView(paramContext, this);
    if (targetClickView() != null) {
      targetClickView().setOnClickListener(new BaseWidgetView.1(this));
    }
    afterInflateView(paramContext, paramInt);
  }
  
  private void registerPreClickListener(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    if (paramView != null) {
      this.mPreClickCollections.put(Integer.valueOf(paramView.getId()), paramItemPreClickListener);
    }
  }
  
  protected void afterInflateView(Context paramContext, int paramInt) {}
  
  protected void beforeInflateView(Context paramContext, int paramInt) {}
  
  protected abstract void bindData(T paramT, int paramInt);
  
  protected boolean doubleClickCheck(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - ((Long)this.lastClickViewArray.get(paramView.getId(), Long.valueOf(-1L))).longValue() > 800L)
    {
      this.lastClickViewArray.put(paramView.getId(), Long.valueOf(l));
      return false;
    }
    return true;
  }
  
  public T getData()
  {
    return this.data;
  }
  
  public int getDataPosInList()
  {
    return this.dataPosInList;
  }
  
  public Serializable getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public Activity getHostActivity()
  {
    WeakReference localWeakReference = this.mHostActivity;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  @Deprecated
  public BaseWidgetView.IInteractor getInteractor()
  {
    return this.mInteractor;
  }
  
  public abstract int getLayoutId();
  
  public Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  protected View.OnClickListener getOnClickLister()
  {
    return null;
  }
  
  public Object getViewTagData()
  {
    return RFWViewUtils.a(BasePartFragment.E, this);
  }
  
  public int getViewType()
  {
    return this.mViewType;
  }
  
  protected void handleAttr(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected void hookPreClick(View paramView)
  {
    if ((paramView != null) && (this.mPreClickCollections.get(Integer.valueOf(paramView.getId())) != null)) {
      ((BaseWidgetView.ItemPreClickListener)this.mPreClickCollections.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  protected abstract void onInitView(Context paramContext, View paramView);
  
  public void release() {}
  
  protected FrameLayout.LayoutParams restoreInflateParams()
  {
    return new FrameLayout.LayoutParams(-1, -2);
  }
  
  public void setData(T paramT)
  {
    setData(paramT, getDataPosInList());
  }
  
  public void setData(T paramT, int paramInt)
  {
    this.data = paramT;
    setDataPosInList(paramInt);
    bindData(paramT, paramInt);
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.dataPosInList = paramInt;
  }
  
  public void setExtraTypeInfo(Serializable paramSerializable)
  {
    this.mExtraTypeInfo = paramSerializable;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.mHostActivity = new WeakReference(paramActivity);
  }
  
  @Deprecated
  public void setInteractor(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.mInteractor = paramIInteractor;
  }
  
  public void setPreClickListener(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    registerPreClickListener(paramView, paramItemPreClickListener);
  }
  
  public void setPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    registerPreClickListener(targetClickView(), paramItemPreClickListener);
  }
  
  public void setViewType(int paramInt)
  {
    this.mViewType = paramInt;
  }
  
  protected View targetClickView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */