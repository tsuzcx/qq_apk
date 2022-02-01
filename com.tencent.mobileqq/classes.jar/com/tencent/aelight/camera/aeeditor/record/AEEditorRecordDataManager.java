package com.tencent.aelight.camera.aeeditor.record;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorRecordDataManager
{
  protected static AEEditorRecordDataManager a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, AEEditorDataModel> a;
  private ArrayList<String> b;
  public HashMap<String, AEEditorDataModel> b;
  private ArrayList<String> c = new ArrayList();
  
  private AEEditorRecordDataManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    a();
  }
  
  public static AEEditorRecordDataManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager = new AEEditorRecordDataManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager;
  }
  
  public static void e()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager != null) {
      jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager = null;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ArrayList<String> a()
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 1L) {
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
    if (l == 2L) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  public ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      if ((paramArrayList.get(i) != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramArrayList.get(i)) != null))
      {
        String str = ((AEEditorDataModel)this.jdField_a_of_type_JavaUtilHashMap.get(paramArrayList.get(i))).b;
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
      else
      {
        localArrayList.add(paramArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public JSONObject a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > paramInt))
      {
        localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        localObject = (AEEditorDataModel)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
        if (localObject != null) {
          return ((AEEditorDataModel)localObject).a;
        }
      }
    }
    else
    {
      localObject = this.c;
      if ((localObject != null) && (((ArrayList)localObject).size() > paramInt))
      {
        localObject = (String)this.c.get(paramInt);
        localObject = (AEEditorDataModel)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (localObject != null) {
          return ((AEEditorDataModel)localObject).a;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = (IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class);
    int j = 0;
    this.jdField_a_of_type_Long = ((IAECameraPrefsUtil)localObject1).getLong("key_ae_editor_record_type", 0L, 0);
    long l = this.jdField_a_of_type_Long;
    Object localObject4;
    if (l == 1L)
    {
      localObject1 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_mid_data", null, 0);
      int i;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = AEEditorDataModel.a(((JSONArray)localObject1).getJSONObject(i));
            if ((localObject4 != null) && (!TextUtils.isEmpty(((AEEditorDataModel)localObject4).b)))
            {
              this.jdField_b_of_type_JavaUtilHashMap.put(((AEEditorDataModel)localObject4).b, localObject4);
              this.jdField_b_of_type_JavaUtilArrayList.add(((AEEditorDataModel)localObject4).b);
            }
            i += 1;
          }
          localObject2 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_data", null, 0);
        }
        catch (Exception localException1)
        {
          AEQLog.a("AEEditorRecordFileManager", localException1);
        }
      }
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          i = j;
          while (i < ((JSONArray)localObject2).length())
          {
            localObject4 = AEEditorDataModel.a(((JSONArray)localObject2).getJSONObject(i));
            if ((localObject4 != null) && (!TextUtils.isEmpty(((AEEditorDataModel)localObject4).c))) {
              this.jdField_a_of_type_JavaUtilHashMap.put(((AEEditorDataModel)localObject4).c, localObject4);
            }
            i += 1;
          }
          if (l != 2L) {
            return;
          }
        }
        catch (Exception localException2)
        {
          AEQLog.a("AEEditorRecordFileManager", localException2);
          return;
        }
      }
    }
    else
    {
      Object localObject3 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_files", "", 0);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        try
        {
          localObject3 = (ArrayList)AEEditorBaseRecord.a(new JSONObject((String)localObject3), "mediaList", ArrayList.class);
          if (localObject3 != null)
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (AEAlbumMediaBaseModel)((Iterator)localObject3).next();
              this.jdField_a_of_type_JavaUtilArrayList.add(((AEAlbumMediaBaseModel)localObject4).getOriginPath());
            }
          }
          return;
        }
        catch (Exception localException3)
        {
          AEQLog.a("AEEditorRecordFileManager", "initBackEditData", localException3);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList1;
    this.c = paramArrayList2;
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, JSONArray paramJSONArray, SparseArray<Boolean> paramSparseArray, int paramInt)
  {
    if (paramInt == 1)
    {
      if (paramArrayList1 != null)
      {
        if (paramJSONArray == null) {
          return;
        }
        if (paramArrayList1.size() != paramJSONArray.length()) {
          return;
        }
        try
        {
          paramArrayList2 = new JSONArray();
          paramInt = 0;
          if (paramInt < paramArrayList1.size())
          {
            paramSparseArray = new AEEditorDataModel((String)paramArrayList1.get(paramInt), null, paramJSONArray.getJSONObject(paramInt)).a();
            if (paramSparseArray == null) {
              break label486;
            }
            paramArrayList2.put(paramSparseArray);
            break label486;
          }
          if (paramArrayList2.length() <= 0) {
            break label485;
          }
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid_data", paramArrayList2.toString(), 0);
          LocalMultiProcConfig.putInt4Uin("_qq_circle_publish_draft_from", 2, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          return;
        }
        catch (Exception paramArrayList1)
        {
          AEQLog.a("AEEditorRecordFileManager", paramArrayList1);
          return;
        }
      }
    }
    else if ((paramInt == 2) && (paramArrayList1 != null) && (paramArrayList2 != null))
    {
      if (paramJSONArray == null) {
        return;
      }
      if (paramArrayList1.size() == paramArrayList2.size()) {
        if (paramArrayList2.size() != paramJSONArray.length()) {
          return;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
          break label495;
        }
        paramInt = 0;
        if (paramInt < paramArrayList2.size())
        {
          paramSparseArray = new AEEditorDataModel((String)paramArrayList1.get(paramInt), (String)paramArrayList2.get(paramInt), paramJSONArray.getJSONObject(paramInt));
          this.jdField_a_of_type_JavaUtilHashMap.put(paramSparseArray.c, paramSparseArray);
          paramInt += 1;
          continue;
          if (paramInt < paramArrayList2.size())
          {
            if ((b()) && (!((Boolean)paramSparseArray.get(paramInt, Boolean.valueOf(false))).booleanValue())) {
              return;
            }
            AEEditorDataModel localAEEditorDataModel = new AEEditorDataModel((String)paramArrayList1.get(paramInt), (String)paramArrayList2.get(paramInt), paramJSONArray.getJSONObject(paramInt));
            this.jdField_a_of_type_JavaUtilHashMap.put(localAEEditorDataModel.c, localAEEditorDataModel);
            paramInt += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramArrayList1)
      {
        AEQLog.a("AEEditorRecordFileManager", paramArrayList1);
        paramArrayList1 = new JSONArray();
        paramArrayList2 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        if (paramArrayList2.hasNext())
        {
          paramJSONArray = (AEEditorDataModel)paramArrayList2.next();
          if (paramJSONArray == null) {
            continue;
          }
          paramJSONArray = paramJSONArray.a();
          if (paramJSONArray == null) {
            continue;
          }
          paramArrayList1.put(paramJSONArray);
          continue;
        }
        if (paramArrayList1.length() > 0)
        {
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid_data", null, 0);
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_data", paramArrayList1.toString(), 0);
          LocalMultiProcConfig.putInt4Uin("_qq_circle_publish_draft_from", 1, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        }
      }
      label485:
      label486:
      paramInt += 1;
      break;
      label495:
      paramInt = 0;
    }
  }
  
  public boolean a()
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 1L)
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0) {
        return true;
      }
    }
    else if ((l == 2L) && (!TextUtils.isEmpty(((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_mid", "", 0))) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_data", "", 0);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void c()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid_data", "", 0);
  }
  
  public void d()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager
 * JD-Core Version:    0.7.0.1
 */