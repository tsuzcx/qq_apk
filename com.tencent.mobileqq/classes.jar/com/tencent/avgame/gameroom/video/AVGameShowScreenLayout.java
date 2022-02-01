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
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MemberVideoDisplayInfo localMemberVideoDisplayInfo = (MemberVideoDisplayInfo)localIterator.next();
        Object localObject;
        if ((!localMemberVideoDisplayInfo.jdField_a_of_type_Boolean) && (!localMemberVideoDisplayInfo.jdField_c_of_type_Boolean))
        {
          paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
          if (paramInt1 >= 0) {
            paramArrayOfAVGameVideoView1[paramInt1].a(0, 0, 0, 0);
          }
          paramInt1 = a(paramArrayOfAVGameVideoView2, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
          if (paramInt1 >= 0)
          {
            localObject = paramArrayOfAVGameVideoView2[paramInt1];
            ((AVGameVideoView)localObject).a(localMemberVideoDisplayInfo.jdField_a_of_type_Int, localMemberVideoDisplayInfo.b, localMemberVideoDisplayInfo.jdField_a_of_type_Int + localMemberVideoDisplayInfo.jdField_c_of_type_Int, localMemberVideoDisplayInfo.b + localMemberVideoDisplayInfo.d);
            ((AVGameVideoView)localObject).a(0, 0, 0, 0);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("layout AudioView fail uin:=");
            ((StringBuilder)localObject).append(localMemberVideoDisplayInfo.jdField_a_of_type_Long);
            AVLog.d("AVGameShowScreenLayout", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          if (localMemberVideoDisplayInfo.jdField_a_of_type_Boolean)
          {
            paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), localMemberVideoDisplayInfo.e);
            if (paramInt1 >= 0)
            {
              localObject = paramArrayOfAVGameVideoView1[paramInt1];
              ((AVGameVideoView)localObject).a(localMemberVideoDisplayInfo.jdField_a_of_type_Int, localMemberVideoDisplayInfo.b, localMemberVideoDisplayInfo.jdField_a_of_type_Int + localMemberVideoDisplayInfo.jdField_c_of_type_Int, localMemberVideoDisplayInfo.b + localMemberVideoDisplayInfo.d);
              ((AVGameVideoView)localObject).a(0, 0, 0, 0);
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("layout VideoView fail uin:=");
              ((StringBuilder)localObject).append(localMemberVideoDisplayInfo.jdField_a_of_type_Long);
              AVLog.d("AVGameShowScreenLayout", ((StringBuilder)localObject).toString());
            }
          }
          if (localMemberVideoDisplayInfo.jdField_c_of_type_Boolean)
          {
            paramInt1 = a(paramArrayOfAVGameVideoView1, String.valueOf(localMemberVideoDisplayInfo.jdField_a_of_type_Long), 2);
            if (paramInt1 >= 0)
            {
              localObject = paramArrayOfAVGameVideoView1[paramInt1];
              ((AVGameVideoView)localObject).g(false);
              ((AVGameVideoView)localObject).a(localMemberVideoDisplayInfo.f, localMemberVideoDisplayInfo.g, localMemberVideoDisplayInfo.f + localMemberVideoDisplayInfo.h, localMemberVideoDisplayInfo.g + localMemberVideoDisplayInfo.i);
              ((AVGameVideoView)localObject).a(0, 0, 0, 0);
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("layout VideoView fail uin:=");
              ((StringBuilder)localObject).append(localMemberVideoDisplayInfo.jdField_a_of_type_Long);
              AVLog.d("AVGameShowScreenLayout", ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfAVGameVideoView1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameShowScreenLayout
 * JD-Core Version:    0.7.0.1
 */