package com.tencent.mm.vfs;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class VFSUtils$CascadeIterator<From, To>
  implements Iterator<To>
{
  private Iterator<? extends To> mChildren;
  protected final boolean mChildrenFirst;
  private From mCurrent;
  private To mCurrentConverted;
  private To mNext;
  private final Iterator<? extends From> mSource;
  
  static
  {
    if (!VFSUtils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  VFSUtils$CascadeIterator(Iterator<? extends From> paramIterator)
  {
    this.mSource = paramIterator;
    this.mChildrenFirst = false;
  }
  
  VFSUtils$CascadeIterator(Iterator<? extends From> paramIterator, boolean paramBoolean)
  {
    this.mSource = paramIterator;
    this.mChildrenFirst = paramBoolean;
  }
  
  protected abstract To convert(From paramFrom);
  
  public boolean hasNext()
  {
    while (this.mNext == null)
    {
      if (this.mCurrent != null)
      {
        this.mChildren = traversal(this.mCurrent, this.mCurrentConverted);
        this.mCurrent = null;
      }
      if (this.mChildren != null)
      {
        if (this.mChildren.hasNext())
        {
          this.mNext = this.mChildren.next();
          continue;
        }
        this.mChildren = null;
        if (this.mChildrenFirst)
        {
          this.mNext = this.mCurrentConverted;
          continue;
        }
      }
      assert ((this.mCurrent == null) && (this.mChildren == null) && (this.mNext == null));
      if (!this.mSource.hasNext())
      {
        this.mCurrentConverted = null;
        return false;
      }
      this.mCurrent = this.mSource.next();
      if (this.mCurrent != null)
      {
        this.mCurrentConverted = convert(this.mCurrent);
        if (!this.mChildrenFirst) {
          this.mNext = this.mCurrentConverted;
        }
      }
    }
    return true;
  }
  
  public To next()
  {
    if ((this.mNext == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    Object localObject = this.mNext;
    this.mNext = null;
    return localObject;
  }
  
  protected abstract Iterator<? extends To> traversal(From paramFrom, To paramTo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSUtils.CascadeIterator
 * JD-Core Version:    0.7.0.1
 */