package com.tencent.av.wtogether.data;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WatchTogetherInfo
{
  public final int a;
  private long a;
  public ChooseFileInfo a;
  public WTInfoFromPush a;
  public WTogetherRoom a;
  public final String a;
  public final ArrayList<Long> a;
  public boolean a;
  public int b;
  public final String b;
  private boolean b;
  public int c;
  public final String c;
  private int d;
  private int e;
  
  public WatchTogetherInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = a(paramInt);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
  
  private static int a(int paramInt)
  {
    if (paramInt == 3) {
      return 2;
    }
    if (paramInt == 1) {
      return 3;
    }
    return 0;
  }
  
  private static long a(SessionInfo paramSessionInfo)
  {
    VideoController localVideoController = VideoController.a();
    long l2 = paramSessionInfo.b();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (localVideoController != null)
      {
        if (paramSessionInfo.p()) {
          return localVideoController.b(paramSessionInfo);
        }
        l1 = localVideoController.a(paramSessionInfo);
      }
    }
    return l1;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public WTogetherRoom a()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom == null) && (a()))
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom = new WTogetherRoom(this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      if ((localObject != null) && (!((WTogetherRoom)localObject).a(this.d, this.jdField_a_of_type_Long)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkAndCreateRoom, not same come[");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append("], cur[");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom.b);
          ((StringBuilder)localObject).append("]");
          QLog.i("WatchTogetherInfo", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom = new WTogetherRoom(this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      }
    }
    return this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update, from[");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], to[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("WatchTogetherInfo", 2, localStringBuilder.toString());
    }
    if ((this.d != paramInt) || (this.jdField_a_of_type_Long != paramLong))
    {
      this.d = paramInt;
      this.jdField_a_of_type_Long = paramLong;
    }
    if (this.e == 1) {
      a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.e != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFlag, [");
        localStringBuilder.append(this.e);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WatchTogetherInfo", 2, localStringBuilder.toString());
      }
      this.e = paramInt;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo == null) {
      return;
    }
    if ((paramBoolean) || (this.d == 0)) {
      this.d = a(this.jdField_a_of_type_Int);
    }
    if ((paramBoolean) || (this.jdField_a_of_type_Long == 0L)) {
      this.jdField_a_of_type_Long = a(paramSessionInfo);
    }
    if (this.e == 1) {
      a();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateChangeFileFlag, [");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append(" --> ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("");
        QLog.i("WatchTogetherInfo", 4, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Long != 0L) && (this.d != 0);
  }
  
  public long[] a()
  {
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < arrayOfLong.length)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
        arrayOfLong[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      } else {
        arrayOfLong[i] = 0L;
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherInfo{sessionId: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", selfUin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", flag: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", relationType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", relationId: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", roomType: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", quitReason: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", isChangingFile: ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", room: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WatchTogetherInfo
 * JD-Core Version:    0.7.0.1
 */