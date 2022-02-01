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
  private int jdField_a_of_type_Int = 0;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoLayerUI jdField_a_of_type_ComTencentAvUiVideoLayerUI;
  private ArrayList<VideoController.GAudioFriends> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<VideoMemberInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean = false;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean d = false;
  
  public VideoTalkMemberManager(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append(String.valueOf(paramInt));
    return localStringBuilder.toString();
  }
  
  public ArrayList<VideoMemberInfo> a()
  {
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
  }
  
  public ArrayList<VideoMemberInfo> a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int i;
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        i = 1;
        synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = false;
            i = 1;
          }
          if ((i != 0) || (paramBoolean)) {}
          synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
          {
            this.jdField_b_of_type_JavaUtilArrayList.clear();
            Object localObject10 = new HashMap();
            synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().d)
            {
              ??? = this.jdField_a_of_type_ComTencentAvVideoController.a().d.iterator();
              Object localObject12;
              Object localObject13;
              while (((Iterator)???).hasNext())
              {
                ??? = (VideoViewInfo)((Iterator)???).next();
                localObject12 = new VideoMemberInfo();
                ((VideoMemberInfo)localObject12).jdField_a_of_type_Long = ((VideoViewInfo)???).jdField_a_of_type_Long;
                ((VideoMemberInfo)localObject12).jdField_b_of_type_Int = ((VideoViewInfo)???).jdField_a_of_type_Int;
                ((VideoMemberInfo)localObject12).h = ((VideoViewInfo)???).e;
                ((VideoMemberInfo)localObject12).g = ((VideoViewInfo)???).jdField_a_of_type_Boolean;
                ((VideoMemberInfo)localObject12).f = true;
                ((VideoMemberInfo)localObject12).jdField_a_of_type_Boolean = true;
                this.jdField_b_of_type_JavaUtilArrayList.add(localObject12);
                localObject13 = a(((VideoMemberInfo)localObject12).jdField_a_of_type_Long, ((VideoMemberInfo)localObject12).jdField_b_of_type_Int);
                ??? = (VideoMemberInfo)((HashMap)localObject10).put(localObject13, localObject12);
                if (??? != null)
                {
                  if (((VideoMemberInfo)localObject12).b()) {
                    ((HashMap)localObject10).put(localObject13, ???);
                  }
                  localObject12 = jdField_a_of_type_JavaLangString;
                  localObject13 = new StringBuilder();
                  ((StringBuilder)localObject13).append("getVideoViewList oldInfo:=");
                  ((StringBuilder)localObject13).append(((VideoMemberInfo)???).toString());
                  QLog.w((String)localObject12, 1, ((StringBuilder)localObject13).toString());
                }
              }
              this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilArrayList.size();
              synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
              {
                localObject12 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject12).hasNext())
                {
                  localObject13 = (VideoController.GAudioFriends)((Iterator)localObject12).next();
                  ??? = (VideoMemberInfo)((HashMap)localObject10).get(a(((VideoController.GAudioFriends)localObject13).jdField_a_of_type_Long, 1));
                  ??? = ???;
                  if (??? == null) {
                    ??? = (VideoMemberInfo)((HashMap)localObject10).get(a(((VideoController.GAudioFriends)localObject13).jdField_a_of_type_Long, 2));
                  }
                  if (??? != null)
                  {
                    if (((VideoMemberInfo)???).b() != 2)
                    {
                      ((VideoMemberInfo)???).jdField_b_of_type_Boolean = ((VideoController.GAudioFriends)localObject13).jdField_a_of_type_Boolean;
                      ((VideoMemberInfo)???).jdField_a_of_type_Int = ((VideoController.GAudioFriends)localObject13).d;
                      ((VideoMemberInfo)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((VideoController.GAudioFriends)localObject13).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
                      ((VideoMemberInfo)???).d = ((VideoController.GAudioFriends)localObject13).e;
                      ((VideoMemberInfo)???).e = ((VideoController.GAudioFriends)localObject13).f;
                    }
                    else
                    {
                      ((VideoMemberInfo)???).jdField_b_of_type_Boolean = false;
                    }
                  }
                  else
                  {
                    ??? = new VideoMemberInfo();
                    ((VideoMemberInfo)???).jdField_a_of_type_Long = ((VideoController.GAudioFriends)localObject13).jdField_a_of_type_Long;
                    ((VideoMemberInfo)???).jdField_b_of_type_Int = 0;
                    ((VideoMemberInfo)???).f = false;
                    ((VideoMemberInfo)???).jdField_a_of_type_Boolean = ((VideoController.GAudioFriends)localObject13).h;
                    ((VideoMemberInfo)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((VideoController.GAudioFriends)localObject13).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
                    ((VideoMemberInfo)???).jdField_b_of_type_Boolean = ((VideoController.GAudioFriends)localObject13).jdField_a_of_type_Boolean;
                    ((VideoMemberInfo)???).jdField_a_of_type_Int = ((VideoController.GAudioFriends)localObject13).d;
                    ((VideoMemberInfo)???).d = ((VideoController.GAudioFriends)localObject13).e;
                    ((VideoMemberInfo)???).e = ((VideoController.GAudioFriends)localObject13).f;
                    this.jdField_b_of_type_JavaUtilArrayList.add(???);
                  }
                }
                ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)???).hasNext())
                {
                  ??? = (VideoMemberInfo)((Iterator)???).next();
                  localObject10 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((VideoMemberInfo)???).jdField_a_of_type_Long);
                  if (localObject10 != null)
                  {
                    ((VideoMemberInfo)???).jdField_b_of_type_Boolean = ((VideoMemberInfo)localObject10).jdField_b_of_type_Boolean;
                    ((VideoMemberInfo)???).d = ((VideoMemberInfo)localObject10).d;
                  }
                }
                synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
                {
                  ??? = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
                  if (QLog.isColorLevel())
                  {
                    ??? = jdField_a_of_type_JavaLangString;
                    ??? = new StringBuilder();
                    ((StringBuilder)???).append("getVideoViewList listSort exceedMaxNumber cost");
                    ((StringBuilder)???).append(System.currentTimeMillis() - l);
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
    if (this.d) {
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onMemmbersInOrOutChange");
    synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "updateAudioMemberListInfo");
    if (this.d) {
      return;
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      return;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.d) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.d = true;
        return;
      }
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean)
  {
    if (this.d) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoTalkMemberManager
 * JD-Core Version:    0.7.0.1
 */