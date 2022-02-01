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
  public static final String a;
  private final int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private GLViewGroup jdField_a_of_type_ComTencentAvOpenglUiGLViewGroup;
  private LongSparseArray<GLVideoView> jdField_a_of_type_ComTencentUtilLongSparseArray;
  private int jdField_b_of_type_Int = 1000;
  private LongSparseArray<GLVideoView> jdField_b_of_type_ComTencentUtilLongSparseArray;
  private LongSparseArray<GLVideoView> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoHoldViewPools.class.getSimpleName();
  }
  
  public VideoHoldViewPools(Context paramContext, VideoAppInterface paramVideoAppInterface, GLViewGroup paramGLViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLViewGroup = paramGLViewGroup;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray(15);
    this.jdField_b_of_type_ComTencentUtilLongSparseArray = new LongSparseArray(15);
    this.c = new LongSparseArray(15);
  }
  
  private boolean a(ArrayList<VideoMemberInfo> paramArrayList, long paramLong)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((VideoMemberInfo)paramArrayList.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public GLVideoView a(long paramLong)
  {
    boolean bool2 = false;
    Object localObject2 = (GLVideoView)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong);
    Object localObject1 = localObject2;
    boolean bool1;
    if (localObject2 == null)
    {
      localObject2 = (GLVideoView)this.c.a(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        int i;
        if (this.c.a() > 0)
        {
          i = this.c.a() - 1;
          localObject1 = (GLVideoView)this.c.a(i);
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, localObject1);
          this.c.a(i);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (localObject1 == null)
        {
          localObject2 = new GLVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), 0L, false);
          ((GLVideoView)localObject2).b(2130842327, 2130842326);
          ((GLVideoView)localObject2).a(String.valueOf(paramLong), 0);
          ((GLVideoView)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          ((GLVideoView)localObject2).a(true);
          ((GLVideoView)localObject2).d(false);
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((GLVideoView)localObject2).c(i);
          ((GLVideoView)localObject2).a(UITools.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((GLVideoView)localObject2).j(12);
          ((GLVideoView)localObject2).k(-1);
          ((GLVideoView)localObject2).h(true);
          ((GLVideoView)localObject2).a(1);
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, localObject2);
          this.jdField_a_of_type_ComTencentAvOpenglUiGLViewGroup.a((GLView)localObject2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      ((GLVideoView)localObject2).a(2, Boolean.valueOf(bool1));
      return localObject2;
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  public void a(ArrayList<VideoMemberInfo> paramArrayList)
  {
    int j = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    if (j <= 0) {
      return;
    }
    int i = 0;
    if (i < j)
    {
      long l = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i);
      GLVideoView localGLVideoView = (GLVideoView)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i);
      if (a(paramArrayList, l)) {
        this.jdField_b_of_type_ComTencentUtilLongSparseArray.a(l, localGLVideoView);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.c.a() + this.jdField_a_of_type_ComTencentUtilLongSparseArray.a() < 15) {
          this.c.a(l, localGLVideoView);
        } else {
          this.jdField_a_of_type_ComTencentAvOpenglUiGLViewGroup.a(localGLVideoView);
        }
      }
    }
    paramArrayList = this.jdField_a_of_type_ComTencentUtilLongSparseArray;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray = this.jdField_b_of_type_ComTencentUtilLongSparseArray;
    this.jdField_b_of_type_ComTencentUtilLongSparseArray = paramArrayList;
    this.jdField_b_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoHoldViewPools
 * JD-Core Version:    0.7.0.1
 */