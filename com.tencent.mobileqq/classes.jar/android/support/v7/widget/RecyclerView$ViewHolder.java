package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
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
  private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
  public final View itemView;
  private int mFlags;
  private boolean mInChangeScrap = false;
  private int mIsRecyclableCount = 0;
  long mItemId = -1L;
  int mItemViewType = -1;
  int mOldPosition = -1;
  public RecyclerView mOwnerRecyclerView;
  List<Object> mPayloads = null;
  int mPosition = -1;
  int mPreLayoutPosition = -1;
  private RecyclerView.Recycler mScrapContainer = null;
  ViewHolder mShadowedHolder = null;
  ViewHolder mShadowingHolder = null;
  List<Object> mUnmodifiedPayloads = null;
  private int mWasImportantForAccessibilityBeforeHidden = 0;
  
  public RecyclerView$ViewHolder(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.itemView = paramView;
  }
  
  private void createPayloadsIfNeeded()
  {
    if (this.mPayloads == null)
    {
      this.mPayloads = new ArrayList();
      this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
    }
  }
  
  private boolean doesTransientStatePreventRecycling()
  {
    return ((this.mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(this.itemView));
  }
  
  private void onEnteredHiddenState()
  {
    this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
    ViewCompat.setImportantForAccessibility(this.itemView, 4);
  }
  
  private void onLeftHiddenState()
  {
    ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
    this.mWasImportantForAccessibilityBeforeHidden = 0;
  }
  
  private boolean shouldBeKeptAsChild()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  void addChangePayload(Object paramObject)
  {
    if (paramObject == null) {
      addFlags(1024);
    }
    while ((this.mFlags & 0x400) != 0) {
      return;
    }
    createPayloadsIfNeeded();
    this.mPayloads.add(paramObject);
  }
  
  void addFlags(int paramInt)
  {
    this.mFlags |= paramInt;
  }
  
  void clearOldPosition()
  {
    this.mOldPosition = -1;
    this.mPreLayoutPosition = -1;
  }
  
  void clearPayload()
  {
    if (this.mPayloads != null) {
      this.mPayloads.clear();
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
  
  void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addFlags(8);
    offsetPosition(paramInt2, paramBoolean);
    this.mPosition = paramInt1;
  }
  
  public final int getAdapterPosition()
  {
    if (this.mOwnerRecyclerView == null) {
      return -1;
    }
    return RecyclerView.access$5800(this.mOwnerRecyclerView, this);
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
    if (this.mPreLayoutPosition == -1) {
      return this.mPosition;
    }
    return this.mPreLayoutPosition;
  }
  
  public final int getOldPosition()
  {
    return this.mOldPosition;
  }
  
  @Deprecated
  public final int getPosition()
  {
    if (this.mPreLayoutPosition == -1) {
      return this.mPosition;
    }
    return this.mPreLayoutPosition;
  }
  
  List<Object> getUnmodifiedPayloads()
  {
    if ((this.mFlags & 0x400) == 0)
    {
      if ((this.mPayloads == null) || (this.mPayloads.size() == 0)) {
        return FULLUPDATE_PAYLOADS;
      }
      return this.mUnmodifiedPayloads;
    }
    return FULLUPDATE_PAYLOADS;
  }
  
  boolean hasAnyOfTheFlags(int paramInt)
  {
    return (this.mFlags & paramInt) != 0;
  }
  
  boolean isAdapterPositionUnknown()
  {
    return ((this.mFlags & 0x200) != 0) || (isInvalid());
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
  }
  
  void saveOldPosition()
  {
    if (this.mOldPosition == -1) {
      this.mOldPosition = this.mPosition;
    }
  }
  
  void setFlags(int paramInt1, int paramInt2)
  {
    this.mFlags = (this.mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void setIsRecyclable(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.mIsRecyclableCount - 1;
      this.mIsRecyclableCount = i;
      if (this.mIsRecyclableCount >= 0) {
        break label64;
      }
      this.mIsRecyclableCount = 0;
      Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    }
    label64:
    do
    {
      return;
      i = this.mIsRecyclableCount + 1;
      break;
      if ((!paramBoolean) && (this.mIsRecyclableCount == 1))
      {
        this.mFlags |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.mIsRecyclableCount != 0));
    this.mFlags &= 0xFFFFFFEF;
  }
  
  void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
  {
    this.mScrapContainer = paramRecycler;
    this.mInChangeScrap = paramBoolean;
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
    StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
    StringBuilder localStringBuilder2;
    if (isScrap())
    {
      localStringBuilder2 = localStringBuilder1.append(" scrap ");
      if (!this.mInChangeScrap) {
        break label295;
      }
    }
    label295:
    for (String str = "[changeScrap]";; str = "[attachedScrap]")
    {
      localStringBuilder2.append(str);
      if (isInvalid()) {
        localStringBuilder1.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder1.append(" unbound");
      }
      if (needsUpdate()) {
        localStringBuilder1.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder1.append(" removed");
      }
      if (shouldIgnore()) {
        localStringBuilder1.append(" ignored");
      }
      if (isTmpDetached()) {
        localStringBuilder1.append(" tmpDetached");
      }
      if (!isRecyclable()) {
        localStringBuilder1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
      }
      if (isAdapterPositionUnknown()) {
        localStringBuilder1.append(" undefined adapter position");
      }
      if (this.itemView.getParent() == null) {
        localStringBuilder1.append(" no parent");
      }
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
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
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */