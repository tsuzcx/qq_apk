package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.utils.UITools;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoHoldViewPools
{
  public static final String a = "VideoHoldViewPools";
  private VideoAppInterface b;
  private Context c;
  private GLViewGroup d;
  private final int e = 15;
  private LongSparseArray<GLVideoView> f;
  private LongSparseArray<GLVideoView> g;
  private LongSparseArray<GLVideoView> h;
  private int i = 1000;
  
  public VideoHoldViewPools(Context paramContext, VideoAppInterface paramVideoAppInterface, GLViewGroup paramGLViewGroup)
  {
    this.c = paramContext;
    this.b = paramVideoAppInterface;
    this.d = paramGLViewGroup;
    this.f = new LongSparseArray(15);
    this.g = new LongSparseArray(15);
    this.h = new LongSparseArray(15);
  }
  
  private boolean a(ArrayList<VideoMemberInfo> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((VideoMemberInfo)paramArrayList.next()).b == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public GLVideoView a(long paramLong)
  {
    Object localObject2 = (GLVideoView)this.f.a(paramLong);
    boolean bool2 = true;
    Object localObject1 = localObject2;
    boolean bool1 = bool2;
    if (localObject2 == null)
    {
      localObject2 = (GLVideoView)this.h.a(paramLong);
      localObject1 = localObject2;
      bool1 = bool2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int j;
        if (this.h.b() > 0)
        {
          j = this.h.b() - 1;
          localObject1 = (GLVideoView)this.h.c(j);
          this.f.b(paramLong, localObject1);
          this.h.a(j);
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new GLVideoView(this.c, this.b, String.format("%s_%s", new Object[] { a, Integer.valueOf(1000) }), 0L, false);
          ((GLVideoView)localObject2).b(2130843160, 2130843159);
          ((GLVideoView)localObject2).a(String.valueOf(paramLong), 0);
          ((GLVideoView)localObject2).a(this.b.getCurrentAccountUin());
          ((GLVideoView)localObject2).a(true);
          ((GLVideoView)localObject2).e(false);
          j = this.i;
          this.i = (j + 1);
          ((GLVideoView)localObject2).c(j);
          ((GLVideoView)localObject2).a(UITools.a(this.c, 12.0F));
          ((GLVideoView)localObject2).l(12);
          ((GLVideoView)localObject2).m(-1);
          ((GLVideoView)localObject2).i(true);
          ((GLVideoView)localObject2).a(1);
          this.f.b(paramLong, localObject2);
          this.d.a((GLView)localObject2);
        }
        bool1 = false;
        localObject1 = localObject2;
      }
    }
    ((GLVideoView)localObject1).a(2, Boolean.valueOf(bool1));
    return localObject1;
  }
  
  public void a(ArrayList<VideoMemberInfo> paramArrayList)
  {
    int k = this.f.b();
    if (k <= 0) {
      return;
    }
    int j = 0;
    while (j < k)
    {
      long l = this.f.b(j);
      GLVideoView localGLVideoView = (GLVideoView)this.f.c(j);
      if (a(paramArrayList, l)) {
        this.g.b(l, localGLVideoView);
      } else if (this.h.b() + this.f.b() < 15) {
        this.h.b(l, localGLVideoView);
      } else {
        this.d.b(localGLVideoView);
      }
      j += 1;
    }
    paramArrayList = this.f;
    this.f = this.g;
    this.g = paramArrayList;
    this.g.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoHoldViewPools
 * JD-Core Version:    0.7.0.1
 */