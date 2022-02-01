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
      Object localObject = this.mCurrent;
      if (localObject != null)
      {
        this.mChildren = traversal(localObject, this.mCurrentConverted);
        this.mCurrent = null;
      }
      localObject = this.mChildren;
      if (localObject != null)
      {
        if (((Iterator)localObject).hasNext())
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
      if (!this.mSource.hasNext())
      {
        this.mCurrentConverted = null;
        return false;
      }
      this.mCurrent = this.mSource.next();
      localObject = this.mCurrent;
      if (localObject != null)
      {
        this.mCurrentConverted = convert(localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSUtils.CascadeIterator
 * JD-Core Version:    0.7.0.1
 */