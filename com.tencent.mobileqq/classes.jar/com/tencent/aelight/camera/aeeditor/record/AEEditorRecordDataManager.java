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
  private static final byte[] e = new byte[1];
  public HashMap<String, AEEditorDataModel> b = new HashMap();
  public HashMap<String, AEEditorDataModel> c = new HashMap();
  ArrayList<String> d = new ArrayList();
  private long f = 0L;
  private int g = 0;
  private ArrayList<String> h = new ArrayList();
  private ArrayList<String> i = new ArrayList();
  
  private AEEditorRecordDataManager()
  {
    b();
  }
  
  public static AEEditorRecordDataManager a()
  {
    if (a == null) {
      synchronized (e)
      {
        if (a == null) {
          a = new AEEditorRecordDataManager();
        }
      }
    }
    return a;
  }
  
  public static void j()
  {
    if (a != null) {
      a = null;
    }
  }
  
  public ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    if (this.b == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramArrayList.size())
    {
      if ((paramArrayList.get(j) != null) && (this.b.get(paramArrayList.get(j)) != null))
      {
        String str = ((AEEditorDataModel)this.b.get(paramArrayList.get(j))).b;
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
      else
      {
        localArrayList.add(paramArrayList.get(j));
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.h = paramArrayList1;
    this.i = paramArrayList2;
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
        if (this.b.size() != 0) {
          break label495;
        }
        paramInt = 0;
        if (paramInt < paramArrayList2.size())
        {
          paramSparseArray = new AEEditorDataModel((String)paramArrayList1.get(paramInt), (String)paramArrayList2.get(paramInt), paramJSONArray.getJSONObject(paramInt));
          this.b.put(paramSparseArray.c, paramSparseArray);
          paramInt += 1;
          continue;
          if (paramInt < paramArrayList2.size())
          {
            if ((k()) && (!((Boolean)paramSparseArray.get(paramInt, Boolean.valueOf(false))).booleanValue())) {
              return;
            }
            AEEditorDataModel localAEEditorDataModel = new AEEditorDataModel((String)paramArrayList1.get(paramInt), (String)paramArrayList2.get(paramInt), paramJSONArray.getJSONObject(paramInt));
            this.b.put(localAEEditorDataModel.c, localAEEditorDataModel);
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
        paramArrayList2 = this.b.values().iterator();
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
  
  public JSONObject b(int paramInt)
  {
    Object localObject;
    if (this.g == 2)
    {
      localObject = this.h;
      if ((localObject != null) && (((ArrayList)localObject).size() > paramInt))
      {
        localObject = (String)this.h.get(paramInt);
        localObject = (AEEditorDataModel)this.c.get(localObject);
        if (localObject != null) {
          return ((AEEditorDataModel)localObject).d;
        }
      }
    }
    else
    {
      localObject = this.i;
      if ((localObject != null) && (((ArrayList)localObject).size() > paramInt))
      {
        localObject = (String)this.i.get(paramInt);
        localObject = (AEEditorDataModel)this.b.get(localObject);
        if (localObject != null) {
          return ((AEEditorDataModel)localObject).d;
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    Object localObject1 = (IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class);
    int k = 0;
    this.f = ((IAECameraPrefsUtil)localObject1).getLong("key_ae_editor_record_type", 0L, 0);
    long l = this.f;
    Object localObject4;
    if (l == 1L)
    {
      localObject1 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_mid_data", null, 0);
      int j;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localObject4 = AEEditorDataModel.a(((JSONArray)localObject1).getJSONObject(j));
            if ((localObject4 != null) && (!TextUtils.isEmpty(((AEEditorDataModel)localObject4).b)))
            {
              this.c.put(((AEEditorDataModel)localObject4).b, localObject4);
              this.h.add(((AEEditorDataModel)localObject4).b);
            }
            j += 1;
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
          j = k;
          while (j < ((JSONArray)localObject2).length())
          {
            localObject4 = AEEditorDataModel.a(((JSONArray)localObject2).getJSONObject(j));
            if ((localObject4 != null) && (!TextUtils.isEmpty(((AEEditorDataModel)localObject4).c))) {
              this.b.put(((AEEditorDataModel)localObject4).c, localObject4);
            }
            j += 1;
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
              this.d.add(((AEAlbumMediaBaseModel)localObject4).getOriginPath());
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
  
  public long c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    long l = this.f;
    if (l == 1L)
    {
      if (this.c.size() > 0) {
        return true;
      }
    }
    else if ((l == 2L) && (!TextUtils.isEmpty(((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_mid", "", 0))) && (this.d.size() > 0)) {
      return true;
    }
    return false;
  }
  
  public ArrayList<String> f()
  {
    long l = this.f;
    if (l == 1L) {
      return this.h;
    }
    if (l == 2L) {
      return this.d;
    }
    return null;
  }
  
  public void g()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_data", "", 0);
  }
  
  public void h()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid_data", "", 0);
  }
  
  public void i()
  {
    h();
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_files", "", 0);
  }
  
  public boolean k()
  {
    return this.g == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorRecordDataManager
 * JD-Core Version:    0.7.0.1
 */