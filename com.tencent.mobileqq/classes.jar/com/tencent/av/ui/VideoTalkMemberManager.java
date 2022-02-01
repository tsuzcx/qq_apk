package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class VideoTalkMemberManager
  implements VideoMemberChangeListener
{
  public static final String a = "VideoTalkMemberManager";
  private final Object[] b = new Object[0];
  private boolean c = false;
  private ArrayList<VideoController.GAudioFriends> d = new ArrayList();
  private final Object[] e = new Object[0];
  private boolean f = true;
  private int g = 0;
  private ArrayList<VideoMemberInfo> h = new ArrayList();
  private final Object[] i = new Object[0];
  private VideoController j;
  private VideoLayerUI k;
  private int l = -1;
  private boolean m = false;
  private boolean n = false;
  
  public VideoTalkMemberManager(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.j = paramVideoController;
    this.k = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append(String.valueOf(paramInt));
    return localStringBuilder.toString();
  }
  
  public ArrayList<VideoMemberInfo> a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    synchronized (this.b)
    {
      if (this.c)
      {
        this.c = false;
        i1 = 1;
        synchronized (this.e)
        {
          if (this.f)
          {
            this.f = false;
            i1 = 1;
          }
          if ((i1 != 0) || (paramBoolean)) {}
          synchronized (this.i)
          {
            this.h.clear();
            Object localObject10 = new HashMap();
            synchronized (this.j.k().bk)
            {
              ??? = this.j.k().bk.iterator();
              Object localObject12;
              Object localObject13;
              while (((Iterator)???).hasNext())
              {
                ??? = (VideoViewInfo)((Iterator)???).next();
                localObject12 = new VideoMemberInfo();
                ((VideoMemberInfo)localObject12).b = ((VideoViewInfo)???).a;
                ((VideoMemberInfo)localObject12).m = ((VideoViewInfo)???).b;
                ((VideoMemberInfo)localObject12).n = ((VideoViewInfo)???).i;
                ((VideoMemberInfo)localObject12).l = ((VideoViewInfo)???).c;
                ((VideoMemberInfo)localObject12).k = true;
                ((VideoMemberInfo)localObject12).d = true;
                this.h.add(localObject12);
                localObject13 = a(((VideoMemberInfo)localObject12).b, ((VideoMemberInfo)localObject12).m);
                ??? = (VideoMemberInfo)((HashMap)localObject10).put(localObject13, localObject12);
                if (??? != null)
                {
                  if (((VideoMemberInfo)localObject12).d()) {
                    ((HashMap)localObject10).put(localObject13, ???);
                  }
                  localObject12 = a;
                  localObject13 = new StringBuilder();
                  ((StringBuilder)localObject13).append("getVideoViewList oldInfo:=");
                  ((StringBuilder)localObject13).append(((VideoMemberInfo)???).toString());
                  QLog.w((String)localObject12, 1, ((StringBuilder)localObject13).toString());
                }
              }
              this.g = this.h.size();
              synchronized (this.b)
              {
                localObject12 = this.d.iterator();
                while (((Iterator)localObject12).hasNext())
                {
                  localObject13 = (VideoController.GAudioFriends)((Iterator)localObject12).next();
                  ??? = (VideoMemberInfo)((HashMap)localObject10).get(a(((VideoController.GAudioFriends)localObject13).a, 1));
                  ??? = ???;
                  if (??? == null) {
                    ??? = (VideoMemberInfo)((HashMap)localObject10).get(a(((VideoController.GAudioFriends)localObject13).a, 2));
                  }
                  if (??? != null)
                  {
                    if (((VideoMemberInfo)???).c() != 2)
                    {
                      ((VideoMemberInfo)???).e = ((VideoController.GAudioFriends)localObject13).b;
                      ((VideoMemberInfo)???).a = ((VideoController.GAudioFriends)localObject13).n;
                      ((VideoMemberInfo)???).g = ((VideoController.GAudioFriends)localObject13).o;
                      ((VideoMemberInfo)???).h = ((VideoController.GAudioFriends)localObject13).p;
                      ((VideoMemberInfo)???).i = ((VideoController.GAudioFriends)localObject13).q;
                    }
                    else
                    {
                      ((VideoMemberInfo)???).e = false;
                    }
                  }
                  else
                  {
                    ??? = new VideoMemberInfo();
                    ((VideoMemberInfo)???).b = ((VideoController.GAudioFriends)localObject13).a;
                    ((VideoMemberInfo)???).m = 0;
                    ((VideoMemberInfo)???).k = false;
                    ((VideoMemberInfo)???).d = ((VideoController.GAudioFriends)localObject13).w;
                    ((VideoMemberInfo)???).g = ((VideoController.GAudioFriends)localObject13).o;
                    ((VideoMemberInfo)???).e = ((VideoController.GAudioFriends)localObject13).b;
                    ((VideoMemberInfo)???).a = ((VideoController.GAudioFriends)localObject13).n;
                    ((VideoMemberInfo)???).h = ((VideoController.GAudioFriends)localObject13).p;
                    ((VideoMemberInfo)???).i = ((VideoController.GAudioFriends)localObject13).q;
                    this.h.add(???);
                  }
                }
                ??? = this.h.iterator();
                while (((Iterator)???).hasNext())
                {
                  ??? = (VideoMemberInfo)((Iterator)???).next();
                  localObject10 = this.k.b(((VideoMemberInfo)???).b);
                  if (localObject10 != null)
                  {
                    ((VideoMemberInfo)???).e = ((VideoMemberInfo)localObject10).e;
                    ((VideoMemberInfo)???).h = ((VideoMemberInfo)localObject10).h;
                  }
                }
                synchronized (this.i)
                {
                  ??? = (ArrayList)this.h.clone();
                  if (QLog.isColorLevel())
                  {
                    ??? = a;
                    ??? = new StringBuilder();
                    ((StringBuilder)???).append("getVideoViewList listSort exceedMaxNumber cost");
                    ((StringBuilder)???).append(System.currentTimeMillis() - l1);
                    QLog.d((String)???, 1, ((StringBuilder)???).toString());
                  }
                  return ???;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.n) {
      return;
    }
    QLog.w(a, 1, "onMemmbersInOrOutChange");
    synchronized (this.e)
    {
      this.f = true;
      return;
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    QLog.w(a, 1, "updateAudioMemberListInfo");
    if (this.n) {
      return;
    }
    synchronized (this.b)
    {
      this.c = true;
      this.d.clear();
      this.d.addAll(paramArrayList);
      return;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.n) {
      return false;
    }
    synchronized (this.b)
    {
      this.c = true;
      return true;
    }
  }
  
  public ArrayList<VideoMemberInfo> b()
  {
    synchronized (this.i)
    {
      ArrayList localArrayList = (ArrayList)this.h.clone();
      return localArrayList;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean)
  {
    if (this.n) {
      return false;
    }
    synchronized (this.b)
    {
      this.c = true;
      return true;
    }
  }
  
  public void c()
  {
    synchronized (this.b)
    {
      this.c = false;
      this.d.clear();
      synchronized (this.i)
      {
        this.h.clear();
        this.n = true;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoTalkMemberManager
 * JD-Core Version:    0.7.0.1
 */