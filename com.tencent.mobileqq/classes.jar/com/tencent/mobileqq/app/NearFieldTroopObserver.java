package com.tencent.mobileqq.app;

import com.tencent.mobileqq.facetoface.Face2FaceGroupProfile;
import com.tencent.mobileqq.facetoface.Face2FaceUserProfile;
import java.util.List;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class NearFieldTroopObserver
  implements BusinessObserver
{
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile) {}
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<Face2FaceGroupProfile> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            if ((paramBoolean) && (paramObject != null)) {
              a((Face2FaceUserProfile)((Object[])(Object[])paramObject)[0]);
            }
          }
          else if ((paramBoolean) && (paramObject != null))
          {
            a((Face2FaceGroupProfile)((Object[])(Object[])paramObject)[0]);
          }
        }
        else
        {
          if ((paramBoolean) && (paramObject != null))
          {
            paramObject = (Object[])paramObject;
            a((nearfield_group.BusiRespHead)paramObject[0], (String)paramObject[1]);
            return;
          }
          a(null, "");
        }
      }
      else
      {
        if ((paramBoolean) && (paramObject != null))
        {
          a((nearfield_group.BusiRespHead)((Object[])(Object[])paramObject)[0]);
          return;
        }
        a(null);
      }
    }
    else
    {
      if ((paramBoolean) && (paramObject != null))
      {
        paramObject = (Object[])paramObject;
        a((nearfield_group.BusiRespHead)paramObject[0], (List)paramObject[1]);
        return;
      }
      a(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldTroopObserver
 * JD-Core Version:    0.7.0.1
 */