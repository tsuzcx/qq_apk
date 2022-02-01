package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class Face2FaceAddContactObserver
  implements BusinessObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 8) {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Boolean)paramObject[7]).booleanValue());
      }
    }
    else
    {
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        Object[] arrayOfObject = (Object[])paramObject;
        if (arrayOfObject.length >= 2)
        {
          paramObject = (String)arrayOfObject[0];
          paramBoolean = ((Boolean)arrayOfObject[1]).booleanValue();
          break label150;
        }
      }
      paramObject = null;
      paramBoolean = false;
      label150:
      a(false, paramObject, 0, null, 0, null, 60, 1200, paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      }
    }
    else
    {
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length > 0)
        {
          paramObject = (String)paramObject[0];
          break label92;
        }
      }
      paramObject = null;
      label92:
      a(false, paramObject, 0, null);
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 4) {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (List)paramObject[3]);
      }
    }
    else
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramObject != null)
      {
        localObject1 = localObject2;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          localObject1 = localObject2;
          if (paramObject.length > 0) {
            localObject1 = (String)paramObject[0];
          }
        }
      }
      a(false, (String)localObject1, 0, null, null);
    }
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a((String)paramObject[0], (String)paramObject[1], (List)paramObject[2]);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List<Face2FaceFriendInfo> paramList) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          d(paramBoolean, paramObject);
          return;
        }
        c(paramBoolean, paramObject);
        return;
      }
      b(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactObserver
 * JD-Core Version:    0.7.0.1
 */