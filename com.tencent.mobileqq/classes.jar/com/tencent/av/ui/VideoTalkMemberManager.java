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
  implements VideoMemmberChangeListener
{
  public static final String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoTalkMemberManager.class.getSimpleName();
  }
  
  public VideoTalkMemberManager(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    return String.valueOf(paramLong) + String.valueOf(paramInt);
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
    int i = 0;
    long l = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        i = 1;
      }
    }
    Object localObject11;
    Object localObject13;
    Object localObject14;
    synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        i = 1;
      }
      if ((i == 0) && (!paramBoolean)) {
        break label702;
      }
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        localObject11 = new HashMap();
        synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().d)
        {
          Iterator localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().d.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject13 = (VideoViewInfo)localIterator.next();
            ??? = new VideoMemberInfo();
            ((VideoMemberInfo)???).jdField_a_of_type_Long = ((VideoViewInfo)localObject13).jdField_a_of_type_Long;
            ((VideoMemberInfo)???).jdField_b_of_type_Int = ((VideoViewInfo)localObject13).jdField_a_of_type_Int;
            ((VideoMemberInfo)???).h = ((VideoViewInfo)localObject13).e;
            ((VideoMemberInfo)???).g = ((VideoViewInfo)localObject13).jdField_a_of_type_Boolean;
            ((VideoMemberInfo)???).f = true;
            ((VideoMemberInfo)???).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(???);
            localObject13 = a(((VideoMemberInfo)???).jdField_a_of_type_Long, ((VideoMemberInfo)???).jdField_b_of_type_Int);
            localObject14 = (VideoMemberInfo)((HashMap)localObject11).put(localObject13, ???);
          } while (localObject14 == null);
          if (((VideoMemberInfo)???).b()) {
            ((HashMap)localObject11).put(localObject13, localObject14);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((VideoMemberInfo)localObject14).toString());
        }
      }
      localObject7 = finally;
      throw localObject7;
    }
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilArrayList.size();
    Object localObject9;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        localObject13 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject13).hasNext()) {
          break;
        }
        localObject14 = (VideoController.GAudioFriends)((Iterator)localObject13).next();
        localObject9 = (VideoMemberInfo)((HashMap)localObject11).get(a(((VideoController.GAudioFriends)localObject14).jdField_a_of_type_Long, 1));
        Object localObject3 = localObject9;
        if (localObject9 == null) {
          localObject3 = (VideoMemberInfo)((HashMap)localObject11).get(a(((VideoController.GAudioFriends)localObject14).jdField_a_of_type_Long, 2));
        }
        if (localObject3 == null) {
          break label519;
        }
        if (((VideoMemberInfo)localObject3).b() != 2)
        {
          ((VideoMemberInfo)localObject3).jdField_b_of_type_Boolean = ((VideoController.GAudioFriends)localObject14).jdField_a_of_type_Boolean;
          ((VideoMemberInfo)localObject3).jdField_a_of_type_Int = ((VideoController.GAudioFriends)localObject14).d;
          ((VideoMemberInfo)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((VideoController.GAudioFriends)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((VideoMemberInfo)localObject3).d = ((VideoController.GAudioFriends)localObject14).e;
          ((VideoMemberInfo)localObject3).e = ((VideoController.GAudioFriends)localObject14).f;
        }
      }
      localObject4.jdField_b_of_type_Boolean = false;
      continue;
      label519:
      ??? = new VideoMemberInfo();
      ((VideoMemberInfo)???).jdField_a_of_type_Long = ((VideoController.GAudioFriends)localObject14).jdField_a_of_type_Long;
      ((VideoMemberInfo)???).jdField_b_of_type_Int = 0;
      ((VideoMemberInfo)???).f = false;
      ((VideoMemberInfo)???).jdField_a_of_type_Boolean = ((VideoController.GAudioFriends)localObject14).h;
      ((VideoMemberInfo)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((VideoController.GAudioFriends)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((VideoMemberInfo)???).jdField_b_of_type_Boolean = ((VideoController.GAudioFriends)localObject14).jdField_a_of_type_Boolean;
      ((VideoMemberInfo)???).jdField_a_of_type_Int = ((VideoController.GAudioFriends)localObject14).d;
      ((VideoMemberInfo)???).d = ((VideoController.GAudioFriends)localObject14).e;
      ((VideoMemberInfo)???).e = ((VideoController.GAudioFriends)localObject14).f;
      this.jdField_b_of_type_JavaUtilArrayList.add(???);
    }
    ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject9 = (VideoMemberInfo)((Iterator)???).next();
      localObject11 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((VideoMemberInfo)localObject9).jdField_a_of_type_Long);
      if (localObject11 != null)
      {
        ((VideoMemberInfo)localObject9).jdField_b_of_type_Boolean = ((VideoMemberInfo)localObject11).jdField_b_of_type_Boolean;
        ((VideoMemberInfo)localObject9).d = ((VideoMemberInfo)localObject11).d;
      }
    }
    label702:
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      localObject9 = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "getVideoViewList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l));
      }
      return localObject9;
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
    }
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.d = true;
      return;
      localObject1 = finally;
      throw localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoTalkMemberManager
 * JD-Core Version:    0.7.0.1
 */