package androidx.recyclerview.widget;

import android.view.View;

class ViewBoundsCheck
{
  static final int CVE_PVE_POS = 12;
  static final int CVE_PVS_POS = 8;
  static final int CVS_PVE_POS = 4;
  static final int CVS_PVS_POS = 0;
  static final int EQ = 2;
  static final int FLAG_CVE_EQ_PVE = 8192;
  static final int FLAG_CVE_EQ_PVS = 512;
  static final int FLAG_CVE_GT_PVE = 4096;
  static final int FLAG_CVE_GT_PVS = 256;
  static final int FLAG_CVE_LT_PVE = 16384;
  static final int FLAG_CVE_LT_PVS = 1024;
  static final int FLAG_CVS_EQ_PVE = 32;
  static final int FLAG_CVS_EQ_PVS = 2;
  static final int FLAG_CVS_GT_PVE = 16;
  static final int FLAG_CVS_GT_PVS = 1;
  static final int FLAG_CVS_LT_PVE = 64;
  static final int FLAG_CVS_LT_PVS = 4;
  static final int GT = 1;
  static final int LT = 4;
  static final int MASK = 7;
  ViewBoundsCheck.BoundFlags mBoundFlags;
  final ViewBoundsCheck.Callback mCallback;
  
  ViewBoundsCheck(ViewBoundsCheck.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mBoundFlags = new ViewBoundsCheck.BoundFlags();
  }
  
  View findOneViewWithinBoundFlags(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.mCallback.getParentStart();
    int k = this.mCallback.getParentEnd();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject2;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject2)
    {
      View localView = this.mCallback.getChildAt(paramInt1);
      int m = this.mCallback.getChildStart(localView);
      int n = this.mCallback.getChildEnd(localView);
      this.mBoundFlags.setBounds(j, k, m, n);
      if (paramInt3 != 0)
      {
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(paramInt3);
        if (this.mBoundFlags.boundsMatch()) {
          return localView;
        }
      }
      localObject2 = localObject1;
      if (paramInt4 != 0)
      {
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(paramInt4);
        localObject2 = localObject1;
        if (this.mBoundFlags.boundsMatch()) {
          localObject2 = localView;
        }
      }
      paramInt1 += i;
    }
    return localObject1;
  }
  
  boolean isViewWithinBoundFlags(View paramView, int paramInt)
  {
    this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(paramView), this.mCallback.getChildEnd(paramView));
    if (paramInt != 0)
    {
      this.mBoundFlags.resetFlags();
      this.mBoundFlags.addFlags(paramInt);
      return this.mBoundFlags.boundsMatch();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ViewBoundsCheck
 * JD-Core Version:    0.7.0.1
 */