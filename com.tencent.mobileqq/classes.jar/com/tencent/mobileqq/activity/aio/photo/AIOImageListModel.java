package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.service.message.MessageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AIOImageListModel
  implements AbstractImageListModel
{
  public static final Object a;
  public static final Object b;
  int jdField_a_of_type_Int;
  AIORichExpandInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo = new AIORichExpandInfo();
  AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  private String jdField_a_of_type_JavaLangString = null;
  private Calendar jdField_a_of_type_JavaUtilCalendar = null;
  List<AIORichMediaInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  AIORichMediaInfo jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  List<AIORichMediaInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List<AIORichMediaInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  List<Object> jdField_d_of_type_JavaUtilList = new ArrayList();
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  int f;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public AIOImageListModel(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 16)
      {
        if (paramInt != 18)
        {
          if (paramInt != 20) {
            return;
          }
          paramAIOFilePicData.jdField_b_of_type_Boolean = true;
          return;
        }
        paramAIOFilePicData.jdField_a_of_type_Boolean = true;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_Boolean = true;
      return;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          return;
        }
        paramAIOFilePicData.d = paramString;
        return;
      }
      paramAIOFilePicData.jdField_c_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOFilePicData.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return;
          }
          paramAIOImageData.jdField_c_of_type_Boolean = true;
          return;
        }
        paramAIOImageData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOImageData.jdField_a_of_type_Boolean = true;
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            return;
          }
          paramAIOImageData.d = paramString;
          return;
        }
        paramAIOImageData.jdField_c_of_type_JavaLangString = paramString;
        return;
      }
      paramAIOImageData.jdField_b_of_type_JavaLangString = paramString;
      if (!paramAIOImageData.g)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOImageData.jdField_a_of_type_JavaLangString);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOImageData.jdField_a_of_type_JavaLangString);
          paramString.append("_hd");
          paramAIOImageData.jdField_a_of_type_JavaLangString = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOImageData.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        paramAIOShortVideoData.jdField_b_of_type_Boolean = true;
        return;
      }
      paramAIOShortVideoData.jdField_a_of_type_Boolean = true;
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramAIOShortVideoData.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    paramAIOShortVideoData.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    if (paramBoolean) {
      localList = this.jdField_d_of_type_JavaUtilList;
    } else {
      localList = this.jdField_b_of_type_JavaUtilList;
    }
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = localList.get(i);
      if ((!paramBoolean) || (AIORichMediaInfo.class.isInstance(localObject)))
      {
        localObject = ((AIORichMediaInfo)localObject).a;
        if (AIOImageData.class.isInstance(localObject))
        {
          localObject = (AIOImageData)localObject;
          if ((((AIOImageData)localObject).jdField_f_of_type_Long == paramLong) && (((AIOImageData)localObject).jdField_f_of_type_Int == paramInt1))
          {
            a(paramInt2, paramString, (AIOImageData)localObject);
            return i;
          }
        }
        else if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).jdField_f_of_type_Long == paramLong)
          {
            a(paramInt2, paramString, (AIOShortVideoData)localObject);
            return i;
          }
        }
        else if (AIOFilePicData.class.isInstance(localObject))
        {
          localObject = (AIOFilePicData)localObject;
          if (((AIOFilePicData)localObject).jdField_f_of_type_Long == paramLong)
          {
            a(paramInt2, paramString, (AIOFilePicData)localObject);
            return i;
          }
        }
        else if ((AIOFileVideoData.class.isInstance(localObject)) && (((AIOFileVideoData)localObject).jdField_f_of_type_Long == paramLong))
        {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public AIORichMediaInfo a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if ((paramInt < this.jdField_b_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (AIORichMediaInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public AIORichMediaInfo a(long paramLong)
  {
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AIORichMediaInfo)localIterator.next();
      } while (((AIORichMediaInfo)localObject1).a.jdField_f_of_type_Long != paramLong);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        this.jdField_b_of_type_JavaUtilList.remove(localObject1);
        a(true, this.jdField_a_of_type_JavaUtilList);
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List<AIORichMediaInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<AIORichMediaInfo> a(List<AIORichMediaInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_d_of_type_Boolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)paramList.next();
        if (!AIOImageProviderService.a(localAIORichMediaInfo.a)) {
          localArrayList.add(localAIORichMediaInfo);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      a(false, this.jdField_a_of_type_JavaUtilList);
      this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = a(paramInt);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = paramAIORichMediaInfo;
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
    localAIORichMediaInfo.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = localAIORichMediaInfo;
    this.jdField_a_of_type_JavaUtilList.add(paramAIORichMediaInfo);
    this.jdField_b_of_type_JavaUtilList.add(paramAIORichMediaInfo);
    a(false, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_JavaUtilList.size() - 1 - this.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean, List<AIORichMediaInfo> paramList)
  {
    int i = this.jdField_d_of_type_Int;
    if (i == 0) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_e_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(this.jdField_d_of_type_JavaUtilList, i);
    }
    if (this.jdField_a_of_type_JavaUtilCalendar == null)
    {
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(MessageCache.a() * 1000L);
    }
    i = paramList.size();
    boolean bool2 = true;
    i -= 1;
    for (;;)
    {
      int k = 0;
      if (i < 0) {
        break;
      }
      localObject = (AIORichMediaInfo)paramList.get(i);
      String str = a(this.jdField_a_of_type_JavaUtilCalendar, ((AIORichMediaInfo)localObject).a.g);
      if (!str.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = str;
        int j = this.jdField_e_of_type_Int;
        if (j != -1)
        {
          int m = j % this.jdField_d_of_type_Int;
          if (m > 0)
          {
            j = 0;
            while (j < this.jdField_d_of_type_Int - m)
            {
              this.jdField_d_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
              j += 1;
            }
          }
        }
        this.jdField_e_of_type_Int = 0;
        this.jdField_d_of_type_JavaUtilList.add(str);
        j = k;
        while (j < this.jdField_d_of_type_Int - 1)
        {
          this.jdField_d_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangObject);
          j += 1;
        }
      }
      this.jdField_d_of_type_JavaUtilList.add(localObject);
      this.jdField_e_of_type_Int += 1;
      i -= 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo;
    boolean bool1 = bool2;
    if (!paramBoolean) {
      if (paramList.isEmpty()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    ((AIORichExpandInfo)localObject).a(bool1, this.jdField_d_of_type_Int, this.jdField_d_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(this.jdField_d_of_type_JavaUtilList, this.jdField_d_of_type_Int);
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == null))
      {
        localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
      }
    }
    i = 0;
    while (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.jdField_a_of_type_Boolean)
      {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
        ((AIORichMediaInfo)localObject).jdField_c_of_type_Boolean = true;
        if (localObject == this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo) {
          this.jdField_c_of_type_Boolean = true;
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
      }
      else if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long == ((AIORichMediaData)localObject).jdField_f_of_type_Long) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
      {
        localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
      }
      else
      {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
      }
      i += 1;
    }
    if (paramInt >= 0) {
      paramInt = paramArrayOfAIORichMediaData.length;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilList.addAll(0, localArrayList);
      return false;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_b_of_type_JavaUtilList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
    }
    paramArrayOfAIORichMediaData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
    if (paramArrayOfAIORichMediaData != null) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(paramArrayOfAIORichMediaData);
    }
    paramInt = this.jdField_a_of_type_Int;
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
    }
    a(true, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AIORichMediaInfo b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public void b()
  {
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
    this.jdField_b_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
    a(true, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    int i = this.jdField_c_of_type_JavaUtilList.size();
    if (i > 0)
    {
      this.jdField_b_of_type_Int += i;
      this.jdField_c_of_type_Int += i;
      this.jdField_a_of_type_JavaUtilList.addAll(0, this.jdField_c_of_type_JavaUtilList);
      List localList = a(this.jdField_c_of_type_JavaUtilList);
      a(false, localList);
      if (this.jdField_b_of_type_Boolean)
      {
        Collections.reverse(localList);
        this.jdField_b_of_type_JavaUtilList.addAll(localList);
      }
      else
      {
        this.jdField_a_of_type_Int += localList.size();
        this.jdField_b_of_type_JavaUtilList.addAll(0, localList);
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      return true;
    }
    return false;
  }
  
  public int c()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    Object localObject = a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)localObject);
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
  }
  
  public int f()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int g()
  {
    return this.jdField_d_of_type_JavaUtilList.size();
  }
  
  public int h()
  {
    return g() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListModel
 * JD-Core Version:    0.7.0.1
 */