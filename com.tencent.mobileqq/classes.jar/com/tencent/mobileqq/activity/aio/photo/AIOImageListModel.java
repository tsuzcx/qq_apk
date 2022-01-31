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
  AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public AIORichMediaInfo b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  List jdField_d_of_type_JavaUtilList = new ArrayList();
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  int f;
  public boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public AIOImageListModel(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    int i;
    label14:
    Object localObject;
    if (paramBoolean)
    {
      localList = this.jdField_d_of_type_JavaUtilList;
      i = 0;
      if (i >= localList.size()) {
        break label657;
      }
      localObject = localList.get(i);
      if ((!paramBoolean) || (AIORichMediaInfo.class.isInstance(localObject))) {
        break label70;
      }
    }
    label70:
    label355:
    do
    {
      do
      {
        do
        {
          do
          {
            i += 1;
            break label14;
            localList = this.jdField_b_of_type_JavaUtilList;
            break;
            localObject = ((AIORichMediaInfo)localObject).a;
            if (!AIOImageData.class.isInstance(localObject)) {
              break label355;
            }
            localObject = (AIOImageData)localObject;
          } while ((((AIOImageData)localObject).jdField_g_of_type_Long != paramLong) || (((AIOImageData)localObject).jdField_f_of_type_Int != paramInt1));
          if ("I:E".equals(paramString)) {
            switch (paramInt2)
            {
            }
          }
          do
          {
            return i;
            ((AIOImageData)localObject).jdField_b_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_c_of_type_Boolean = true;
            return i;
            ((AIOImageData)localObject).jdField_a_of_type_Boolean = true;
            return i;
            switch (paramInt2)
            {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            default: 
              return i;
            case 1: 
              ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString;
              return i;
            case 2: 
              ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString;
            }
          } while ((((AIOImageData)localObject).jdField_g_of_type_Boolean) || (!new File(((AIOImageData)localObject).jdField_a_of_type_JavaLangString + "_hd").exists()));
          ((AIOImageData)localObject).jdField_a_of_type_JavaLangString += "_hd";
          return i;
          ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString;
          return i;
          ((AIOImageData)localObject).d = paramString;
          return i;
          if (!AIOShortVideoData.class.isInstance(localObject)) {
            break label483;
          }
          localObject = (AIOShortVideoData)localObject;
        } while (((AIOShortVideoData)localObject).jdField_g_of_type_Long != paramLong);
        if ("I:E".equals(paramString))
        {
          switch (paramInt2)
          {
          default: 
            return i;
          case 0: 
            ((AIOShortVideoData)localObject).jdField_a_of_type_Boolean = true;
            return i;
          }
          ((AIOShortVideoData)localObject).jdField_b_of_type_Boolean = true;
          return i;
        }
        switch (paramInt2)
        {
        default: 
          return i;
        case 0: 
          ((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString = paramString;
          return i;
        }
        ((AIOShortVideoData)localObject).jdField_b_of_type_JavaLangString = paramString;
        return i;
      } while (!AIOFilePicData.class.isInstance(localObject));
      localObject = (AIOFilePicData)localObject;
    } while (((AIOFilePicData)localObject).jdField_g_of_type_Long != paramLong);
    label483:
    if ("I:E".equals(paramString))
    {
      switch (paramInt2)
      {
      case 17: 
      case 19: 
      default: 
        return i;
      case 16: 
        ((AIOFilePicData)localObject).jdField_c_of_type_Boolean = true;
        return i;
      case 18: 
        ((AIOFilePicData)localObject).jdField_a_of_type_Boolean = true;
        return i;
      }
      ((AIOFilePicData)localObject).jdField_b_of_type_Boolean = true;
      return i;
    }
    switch (paramInt2)
    {
    case 17: 
    case 19: 
    default: 
      return i;
    case 16: 
      ((AIOFilePicData)localObject).jdField_b_of_type_JavaLangString = paramString;
      return i;
    case 18: 
      ((AIOFilePicData)localObject).jdField_c_of_type_JavaLangString = paramString;
      return i;
    }
    ((AIOFilePicData)localObject).d = paramString;
    return i;
    label657:
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
  
  public Object a(int paramInt)
  {
    return this.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_e_of_type_Boolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)paramList.next();
        if ((localAIORichMediaInfo.a instanceof AIOShortVideoData))
        {
          localAIOShortVideoData = (AIOShortVideoData)localAIORichMediaInfo.a;
          if ((localAIOShortVideoData.jdField_b_of_type_Int == 0) || ((localAIOShortVideoData.jdField_b_of_type_Int == 1) && (this.jdField_d_of_type_Boolean))) {}
        }
        else
        {
          while (!(localAIORichMediaInfo.a instanceof AIOFileVideoData))
          {
            AIOShortVideoData localAIOShortVideoData;
            localArrayList.add(localAIORichMediaInfo);
            break;
          }
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_d_of_type_JavaUtilList.size() == 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      a(false, this.jdField_b_of_type_JavaUtilList);
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
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
    this.jdField_a_of_type_JavaUtilList.add(paramAIORichMediaInfo);
    this.jdField_b_of_type_JavaUtilList.add(paramAIORichMediaInfo);
    a(false, this.jdField_b_of_type_JavaUtilList);
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
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (this.jdField_d_of_type_Int == 0) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_d_of_type_JavaUtilList.clear();
        this.jdField_e_of_type_Int = -1;
        if (this.jdField_f_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_a_of_type_JavaUtilCalendar == null)
      {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(MessageCache.a() * 1000L);
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)paramList.get(i);
        String str = a(this.jdField_a_of_type_JavaUtilCalendar, localAIORichMediaInfo.a.h);
        if (!str.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaLangString = str;
          if (this.jdField_e_of_type_Int != -1)
          {
            int k = this.jdField_e_of_type_Int % this.jdField_d_of_type_Int;
            if (k > 0)
            {
              j = 0;
              while (j < this.jdField_d_of_type_Int - k)
              {
                this.jdField_d_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
                j += 1;
              }
            }
          }
          this.jdField_e_of_type_Int = 0;
          this.jdField_d_of_type_JavaUtilList.add(str);
          int j = 0;
          while (j < this.jdField_d_of_type_Int - 1)
          {
            this.jdField_d_of_type_JavaUtilList.add(jdField_a_of_type_JavaLangObject);
            j += 1;
          }
        }
        this.jdField_d_of_type_JavaUtilList.add(localAIORichMediaInfo);
        this.jdField_e_of_type_Int += 1;
        i -= 1;
      }
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      i = this.jdField_c_of_type_JavaUtilList.size();
    } while (i <= 0);
    this.jdField_b_of_type_Int += i;
    this.jdField_c_of_type_Int = (i + this.jdField_c_of_type_Int);
    this.jdField_a_of_type_JavaUtilList.addAll(0, this.jdField_c_of_type_JavaUtilList);
    List localList = a(this.jdField_c_of_type_JavaUtilList);
    a(false, localList);
    if (this.jdField_b_of_type_Boolean)
    {
      Collections.reverse(localList);
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return true;
      this.jdField_a_of_type_Int += localList.size();
      this.jdField_b_of_type_JavaUtilList.addAll(0, localList);
    }
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
    if (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.jdField_a_of_type_Boolean) {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_g_of_type_Long == ((AIORichMediaData)localObject).jdField_g_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_d_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo == this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo) {
            this.jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
        }
        else if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_g_of_type_Long == ((AIORichMediaData)localObject).jdField_g_of_type_Long) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int == ((AIORichMediaData)localObject).jdField_f_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
        }
        else
        {
          localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfAIORichMediaData.length)) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_c_of_type_JavaUtilList.addAll(0, localArrayList);
    }
    while (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_b_of_type_JavaUtilList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.jdField_b_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo != null) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
    }
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_JavaUtilList.size() - 1);
    }
    a(true, this.jdField_b_of_type_JavaUtilList);
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
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
    this.jdField_b_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
    a(true, this.jdField_b_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      List localList = null;
      Object localObject = localList;
      if (this.jdField_a_of_type_Int >= 0)
      {
        localObject = localList;
        if (this.jdField_a_of_type_Int < this.jdField_b_of_type_JavaUtilList.size()) {
          localObject = (AIORichMediaInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        }
      }
      localList = a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_b_of_type_Boolean) {
        Collections.reverse(localList);
      }
      this.jdField_b_of_type_JavaUtilList = localList;
      if (localObject != null) {
        this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilList.indexOf(localObject);
      }
      if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilList.size())) {
        this.jdField_a_of_type_Int = (this.jdField_b_of_type_JavaUtilList.size() - 1);
      }
      a(true, this.jdField_b_of_type_JavaUtilList);
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public int e()
  {
    return this.jdField_f_of_type_Int;
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
    return this.jdField_d_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListModel
 * JD-Core Version:    0.7.0.1
 */