import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class biex
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String l = ajjy.a(2131637930);
  public static final String m = ajjy.a(2131637923);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private birr jdField_a_of_type_Birr;
  private spg<sqx> jdField_a_of_type_Spg;
  private SparseArray<bird> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, f, g, h, i, l, m };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 9, 10, 3, 4, 5, 6, 7, 8, 9, 10 };
  }
  
  private bird a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int i = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    bird localbird = (bird)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (i >= 0)
    {
      paramString = (bird)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i);
      return paramString;
    }
    bikm localbikm = (bikm)sqg.a(39);
    Object localObject = localbird;
    switch (paramInt1)
    {
    default: 
      localObject = localbird;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new birp(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localbird;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new birp(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localbird;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new birp(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localbird;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new birp(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localbird;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
              {
                urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new birp(paramString, paramInt2, 2130845430, 2);
                continue;
                if (!(paramEditSource instanceof EditRecordVideoSource))
                {
                  localObject = localbird;
                  if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                }
                else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
                {
                  localObject = null;
                }
                else
                {
                  bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
                  if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
                  {
                    urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else
                  {
                    localObject = new birp(paramString, paramInt2, 2130845430, 8);
                    continue;
                    localObject = localbird;
                    if (this.jdField_a_of_type_Birf != null)
                    {
                      localObject = new birf(this.jdField_a_of_type_Birf.a, paramString, paramInt2, this.jdField_a_of_type_Birf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Birf.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Birf.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Birf.f, this.jdField_a_of_type_Birf.g, this.jdField_a_of_type_Birf.h, this.jdField_a_of_type_Birf.i, this.jdField_a_of_type_Birf.jdField_c_of_type_Int, this.jdField_a_of_type_Birf.jdField_d_of_type_Int, this.jdField_a_of_type_Birf.jdField_e_of_type_Int);
                      continue;
                      if (!(paramEditSource instanceof EditRecordVideoSource))
                      {
                        localObject = localbird;
                        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (("CHE-TL00".equalsIgnoreCase(Build.MODEL)) || ("CAM-TL00".equalsIgnoreCase(Build.MODEL)) || ("MHA-AL00".equalsIgnoreCase(Build.MODEL)) || ("CHM-TL00".equalsIgnoreCase(Build.MODEL))))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else
                      {
                        bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
                        {
                          urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else
                        {
                          localObject = new birp(paramString, paramInt2, 2130845429, 1);
                          continue;
                          if (!(paramEditSource instanceof EditRecordVideoSource))
                          {
                            localObject = localbird;
                            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                          }
                          else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                          {
                            localObject = localbird;
                            if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                          }
                          else
                          {
                            localObject = localbird;
                            if (!"X9000".equalsIgnoreCase(Build.MODEL))
                            {
                              bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                              if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
                              {
                                urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                                localObject = null;
                              }
                              else
                              {
                                localObject = new birp(paramString, paramInt2, 2130845431, 3);
                                continue;
                                if (!(paramEditSource instanceof EditRecordVideoSource))
                                {
                                  localObject = localbird;
                                  if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                                }
                                else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                                {
                                  localObject = localbird;
                                  if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                                }
                                else
                                {
                                  localObject = localbird;
                                  if (!"X9000".equalsIgnoreCase(Build.MODEL))
                                  {
                                    bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                                    if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
                                    {
                                      urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                                      localObject = null;
                                    }
                                    else
                                    {
                                      localObject = new birp(paramString, paramInt2, 2130845431, 9);
                                      continue;
                                      localObject = new birm(0, paramString, paramInt2);
                                      continue;
                                      if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                                      {
                                        localObject = localbird;
                                        if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                                      }
                                      else if ((this.jdField_a_of_type_Birf == null) || (!b()))
                                      {
                                        if (this.jdField_a_of_type_Birf == null) {
                                          urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_SPEED : POI data is disable.");
                                        }
                                        localObject = localbird;
                                        if (!b())
                                        {
                                          urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_SPEED : has not open gps.");
                                          localObject = localbird;
                                        }
                                      }
                                      else
                                      {
                                        float f = localbikm.a();
                                        if (f >= 0.0F)
                                        {
                                          localObject = new birk(0, paramString, paramInt2, f);
                                        }
                                        else
                                        {
                                          urk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "speed is unavailable : %s.", Float.valueOf(f));
                                          localObject = localbird;
                                          continue;
                                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                                          {
                                            localObject = localbird;
                                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                                          }
                                          else
                                          {
                                            if ((this.jdField_a_of_type_Birf != null) && (b())) {
                                              break label1619;
                                            }
                                            if (this.jdField_a_of_type_Birf == null) {
                                              urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                                            }
                                            localObject = localbird;
                                            if (!b())
                                            {
                                              urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                                              localObject = localbird;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1619:
    paramEditSource = (squ)((sph)sqg.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Birr = new birr(0, paramString, paramInt2, ((sqx)localObject).a);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Birr;
      break;
      urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Birr = new birr(0, paramString, paramInt2, 0);
      paramEditSource.a();
    }
  }
  
  private bird a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    default: 
      return null;
    case 10: 
      paramEditSource = ((sre)sqg.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new birh(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, sre.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_Bihj.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((squ)((sph)sqg.a(20)).a(0)).a(this.jdField_a_of_type_Spg);
  }
  
  public void d()
  {
    Object localObject1 = ((sre)sqg.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[i], jdField_a_of_type_ArrayOfJavaLangString[i], jdField_b_of_type_ArrayOfInt[i], this.jdField_a_of_type_Bigb.a.a);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject2 = a(-1, jdField_a_of_type_JavaLangString, -1, this.jdField_a_of_type_Bigb.a.a);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      bird localbird = a((FilterItem)localObject2, this.jdField_a_of_type_Bigb.a.a);
      if (localbird != null)
      {
        urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localbird);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
  
  public void g()
  {
    ((squ)((sph)sqg.a(20)).a(0)).b(this.jdField_a_of_type_Spg);
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biex
 * JD-Core Version:    0.7.0.1
 */