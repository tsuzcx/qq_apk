package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$ViewHolder
{
  static final int FLAG_ADAPTER_FULLUPDATE = 1024;
  static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
  static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
  static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
  static final int FLAG_BOUND = 1;
  static final int FLAG_IGNORE = 128;
  static final int FLAG_INVALID = 4;
  static final int FLAG_MOVED = 2048;
  static final int FLAG_NOT_RECYCLABLE = 16;
  static final int FLAG_REMOVED = 8;
  static final int FLAG_RETURNED_FROM_SCRAP = 32;
  static final int FLAG_TMP_DETACHED = 256;
  static final int FLAG_UPDATE = 2;
  private static final List<Object> FULLUPDATE_PAYLOADS = ;
  static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
  @NonNull
  public final View itemView;
  int mFlags;
  boolean mInChangeScrap = false;
  private int mIsRecyclableCount = 0;
  long mItemId = -1L;
  int mItemViewType = -1;
  WeakReference<RecyclerView> mNestedRecyclerView;
  int mOldPosition = -1;
  RecyclerView mOwnerRecyclerView;
  List<Object> mPayloads = null;
  @VisibleForTesting
  int mPendingAccessibilityState = -1;
  int mPosition = -1;
  int mPreLayoutPosition = -1;
  RecyclerView.Recycler mScrapContainer = null;
  ViewHolder mShadowedHolder = null;
  ViewHolder mShadowingHolder = null;
  List<Object> mUnmodifiedPayloads = null;
  private int mWasImportantForAccessibilityBeforeHidden = 0;
  
  public RecyclerView$ViewHolder(@NonNull View paramView)
  {
    if (paramView != null)
    {
      this.itemView = paramView;
      return;
    }
    throw new IllegalArgumentException("itemView may not be null");
  }
  
  private void createPayloadsIfNeeded()
  {
    if (this.mPayloads == null)
    {
      this.mPayloads = new ArrayList();
      this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
    }
  }
  
  void addChangePayload(Object paramObject)
  {
    if (paramObject == null)
    {
      addFlags(1024);
      return;
    }
    if ((0x400 & this.mFlags) == 0)
    {
      createPayloadsIfNeeded();
      this.mPayloads.add(paramObject);
    }
  }
  
  void addFlags(int paramInt)
  {
    this.mFlags = (paramInt | this.mFlags);
  }
  
  void clearOldPosition()
  {
    this.mOldPosition = -1;
    this.mPreLayoutPosition = -1;
  }
  
  void clearPayload()
  {
    List localList = this.mPayloads;
    if (localList != null) {
      localList.clear();
    }
    this.mFlags &= 0xFFFFFBFF;
  }
  
  void clearReturnedFromScrapFlag()
  {
    this.mFlags &= 0xFFFFFFDF;
  }
  
  void clearTmpDetachFlag()
  {
    this.mFlags &= 0xFFFFFEFF;
  }
  
  boolean doesTransientStatePreventRecycling()
  {
    return ((this.mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(this.itemView));
  }
  
  void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addFlags(8);
    offsetPosition(paramInt2, paramBoolean);
    this.mPosition = paramInt1;
  }
  
  public final int getAdapterPosition()
  {
    RecyclerView localRecyclerView = this.mOwnerRecyclerView;
    if (localRecyclerView == null) {
      return -1;
    }
    return localRecyclerView.getAdapterPositionFor(this);
  }
  
  public final long getItemId()
  {
    return this.mItemId;
  }
  
  public final int getItemViewType()
  {
    return this.mItemViewType;
  }
  
  public final int getLayoutPosition()
  {
    int j = this.mPreLayoutPosition;
    int i = j;
    if (j == -1) {
      i = this.mPosition;
    }
    return i;
  }
  
  public final int getOldPosition()
  {
    return this.mOldPosition;
  }
  
  @Deprecated
  public final int getPosition()
  {
    int j = this.mPreLayoutPosition;
    int i = j;
    if (j == -1) {
      i = this.mPosition;
    }
    return i;
  }
  
  List<Object> getUnmodifiedPayloads()
  {
    if ((this.mFlags & 0x400) == 0)
    {
      List localList = this.mPayloads;
      if ((localList != null) && (localList.size() != 0)) {
        return this.mUnmodifiedPayloads;
      }
      return FULLUPDATE_PAYLOADS;
    }
    return FULLUPDATE_PAYLOADS;
  }
  
  boolean hasAnyOfTheFlags(int paramInt)
  {
    return (paramInt & this.mFlags) != 0;
  }
  
  boolean isAdapterPositionUnknown()
  {
    return ((this.mFlags & 0x200) != 0) || (isInvalid());
  }
  
  boolean isAttachedToTransitionOverlay()
  {
    return (this.itemView.getParent() != null) && (this.itemView.getParent() != this.mOwnerRecyclerView);
  }
  
  boolean isBound()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  boolean isInvalid()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  public final boolean isRecyclable()
  {
    return ((this.mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(this.itemView));
  }
  
  boolean isRemoved()
  {
    return (this.mFlags & 0x8) != 0;
  }
  
  boolean isScrap()
  {
    return this.mScrapContainer != null;
  }
  
  boolean isTmpDetached()
  {
    return (this.mFlags & 0x100) != 0;
  }
  
  boolean isUpdated()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  boolean needsUpdate()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  void offsetPosition(int paramInt, boolean paramBoolean)
  {
    if (this.mOldPosition == -1) {
      this.mOldPosition = this.mPosition;
    }
    if (this.mPreLayoutPosition == -1) {
      this.mPreLayoutPosition = this.mPosition;
    }
    if (paramBoolean) {
      this.mPreLayoutPosition += paramInt;
    }
    this.mPosition += paramInt;
    if (this.itemView.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
    }
  }
  
  void onEnteredHiddenState(RecyclerView paramRecyclerView)
  {
    int i = this.mPendingAccessibilityState;
    if (i != -1) {
      this.mWasImportantForAccessibilityBeforeHidden = i;
    } else {
      this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
    }
    paramRecyclerView.setChildImportantForAccessibilityInternal(this, 4);
  }
  
  void onLeftHiddenState(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
    this.mWasImportantForAccessibilityBeforeHidden = 0;
  }
  
  void resetInternal()
  {
    this.mFlags = 0;
    this.mPosition = -1;
    this.mOldPosition = -1;
    this.mItemId = -1L;
    this.mPreLayoutPosition = -1;
    this.mIsRecyclableCount = 0;
    this.mShadowedHolder = null;
    this.mShadowingHolder = null;
    clearPayload();
    this.mWasImportantForAccessibilityBeforeHidden = 0;
    this.mPendingAccessibilityState = -1;
    RecyclerView.clearNestedRecyclerViewIfNotNested(this);
  }
  
  void saveOldPosition()
  {
    if (this.mOldPosition == -1) {
      this.mOldPosition = this.mPosition;
    }
  }
  
  void setFlags(int paramInt1, int paramInt2)
  {
    this.mFlags = (paramInt1 & paramInt2 | this.mFlags & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public final void setIsRecyclable(boolean paramBoolean)
  {
    if (paramBoolean) {
      i = this.mIsRecyclableCount - 1;
    } else {
      i = this.mIsRecyclableCount + 1;
    }
    this.mIsRecyclableCount = i;
    int i = this.mIsRecyclableCount;
    if (i < 0)
    {
      this.mIsRecyclableCount = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
      localStringBuilder.append(this);
      Log.e("View", localStringBuilder.toString());
      return;
    }
    if ((!paramBoolean) && (i == 1))
    {
      this.mFlags |= 0x10;
      return;
    }
    if ((paramBoolean) && (this.mIsRecyclableCount == 0)) {
      this.mFlags &= 0xFFFFFFEF;
    }
  }
  
  void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
  {
    this.mScrapContainer = paramRecycler;
    this.mInChangeScrap = paramBoolean;
  }
  
  boolean shouldBeKeptAsChild()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  boolean shouldIgnore()
  {
    return (this.mFlags & 0x80) != 0;
  }
  
  void stopIgnoring()
  {
    this.mFlags &= 0xFFFFFF7F;
  }
  
  public String toString()
  {
    Object localObject;
    if (getClass().isAnonymousClass()) {
      localObject = "ViewHolder";
    } else {
      localObject = getClass().getSimpleName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("{");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.mPosition);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append(", oldPos=");
    localStringBuilder.append(this.mOldPosition);
    localStringBuilder.append(", pLpos:");
    localStringBuilder.append(this.mPreLayoutPosition);
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    if (isScrap())
    {
      localStringBuilder.append(" scrap ");
      if (this.mInChangeScrap) {
        localObject = "[changeScrap]";
      } else {
        localObject = "[attachedScrap]";
      }
      localStringBuilder.append((String)localObject);
    }
    if (isInvalid()) {
      localStringBuilder.append(" invalid");
    }
    if (!isBound()) {
      localStringBuilder.append(" unbound");
    }
    if (needsUpdate()) {
      localStringBuilder.append(" update");
    }
    if (isRemoved()) {
      localStringBuilder.append(" removed");
    }
    if (shouldIgnore()) {
      localStringBuilder.append(" ignored");
    }
    if (isTmpDetached()) {
      localStringBuilder.append(" tmpDetached");
    }
    if (!isRecyclable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" not recyclable(");
      ((StringBuilder)localObject).append(this.mIsRecyclableCount);
      ((StringBuilder)localObject).append(")");
      localStringBuilder.append(((StringBuilder)localObject).toString());
    }
    if (isAdapterPositionUnknown()) {
      localStringBuilder.append(" undefined adapter position");
    }
    if (this.itemView.getParent() == null) {
      localStringBuilder.append(" no parent");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  void unScrap()
  {
    this.mScrapContainer.unscrapView(this);
  }
  
  boolean wasReturnedFromScrap()
  {
    return (this.mFlags & 0x20) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */