package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.ui.GLVideoView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.qav.log.AVLog;
import java.util.Iterator;
import java.util.List;

public class AVGameShowScreenLayout
  extends AVGameScreenLayoutStyle
{
  public AVGameShowScreenLayout(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.b = 2;
  }
  
  public int a(AVGameVideoView[] paramArrayOfAVGameVideoView, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfAVGameVideoView.length)
      {
        AVGameVideoView localAVGameVideoView = paramArrayOfAVGameVideoView[i];
        String str = localAVGameVideoView.c();
        if ((paramInt == localAVGameVideoView.g()) && (paramString.equals(str)) && (localAVGameVideoView.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(AVGameVideoView[] paramArrayOfAVGameVideoView1, AVGameVideoView[] paramArrayOfAVGameVideoView2, int paramInt1, int paramInt2, List<MemberVideoDisplayInfo> paramList)
  {
    for (;;)
    {
      MemberVideoDisplayInfo localMemberVideoDisplayInfo;
      AVGameVideoView localAVGameVideoView;
      int i;
      int j;
      int k;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localMemberVideoDisplayInfo = (MemberVideoDisplayInfo)localIterator.next();
        if ((!localMemberVideoDisplayInfo.jdField_a_of_type_Boolean) && (!localMemberVideoDisplayInfo.jdField_c_of_type_Boolean)) {
          break label307;
        }
        if (localMemberVideoDisplayInfo.jdField_a_of_type_Boolean)
        {
          paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
          if (paramInt1 >= 0)
          {
            localAVGameVideoView = paramArrayOfAVGameVideoView1[paramInt1];
            localAVGameVideoView.a(localMemberVideoDisplayInfo.jdField_a_of_type_Int, localMemberVideoDisplayInfo.b, localMemberVideoDisplayInfo.jdField_a_of_type_Int + localMemberVideoDisplayInfo.jdField_c_of_type_Int, localMemberVideoDisplayInfo.b + localMemberVideoDisplayInfo.d);
            localAVGameVideoView.a(0, 0, 0, 0);
          }
        }
        else
        {
          if (!localMemberVideoDisplayInfo.jdField_c_of_type_Boolean) {
            continue;
          }
          paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), 2);
          if (paramInt1 < 0) {
            break label276;
          }
          localAVGameVideoView = paramArrayOfAVGameVideoView1[paramInt1];
          localAVGameVideoView.g(false);
          paramInt1 = localMemberVideoDisplayInfo.f;
          paramInt2 = localMemberVideoDisplayInfo.g;
          i = localMemberVideoDisplayInfo.f;
          j = localMemberVideoDisplayInfo.h;
          k = localMemberVideoDisplayInfo.g;
          localAVGameVideoView.a(paramInt1, paramInt2, i + j, localMemberVideoDisplayInfo.i + k);
          localAVGameVideoView.a(0, 0, 0, 0);
          continue;
        }
        AVLog.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localMemberVideoDisplayInfo.jdField_a_of_type_Long);
      }
      finally {}
      continue;
      label276:
      AVLog.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localMemberVideoDisplayInfo.jdField_a_of_type_Long);
      continue;
      label307:
      paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
      if (paramInt1 >= 0) {
        paramArrayOfAVGameVideoView1[paramInt1].a(0, 0, 0, 0);
      }
      paramInt1 = a(paramArrayOfAVGameVideoView2, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
      if (paramInt1 >= 0)
      {
        localAVGameVideoView = paramArrayOfAVGameVideoView2[paramInt1];
        paramInt1 = localMemberVideoDisplayInfo.jdField_a_of_type_Int;
        paramInt2 = localMemberVideoDisplayInfo.b;
        i = localMemberVideoDisplayInfo.jdField_a_of_type_Int;
        j = localMemberVideoDisplayInfo.jdField_c_of_type_Int;
        k = localMemberVideoDisplayInfo.b;
        localAVGameVideoView.a(paramInt1, paramInt2, i + j, localMemberVideoDisplayInfo.d + k);
        localAVGameVideoView.a(0, 0, 0, 0);
      }
      else
      {
        AVLog.d("AVGameShowScreenLayout", "layout AudioView fail uin:=" + localMemberVideoDisplayInfo.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameShowScreenLayout
 * JD-Core Version:    0.7.0.1
 */