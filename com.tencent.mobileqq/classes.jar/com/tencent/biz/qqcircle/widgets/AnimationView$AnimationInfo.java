package com.tencent.biz.qqcircle.widgets;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqcircle.utils.AnimationTools;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationView$AnimationInfo
{
  public int a;
  public int b;
  public int c;
  public ArrayList<AnimationView.PlayItem> d = new ArrayList();
  public SparseArray<Drawable> e = new SparseArray();
  public ArrayList<Integer> f = new ArrayList();
  public int g = -1;
  public int h = -1;
  
  public AnimationView$AnimationInfo()
  {
    this.a = 0;
    this.b = 100;
    this.c = 100;
    this.g = -1;
    this.h = -1;
  }
  
  public AnimationView$AnimationInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    if (this.b <= 0) {
      this.b = 100;
    }
    if (this.c <= 0) {
      this.c = 100;
    }
    this.g = -1;
    this.h = -1;
  }
  
  protected static AnimationInfo a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return null;
      }
      try
      {
        paramFile = FileUtils.a(paramFile);
        if (paramFile != null) {
          paramFile = new String(paramFile, "UTF-8");
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        paramFile = null;
      }
      if (TextUtils.isEmpty(paramFile)) {
        return null;
      }
      return b(paramFile);
    }
    return null;
  }
  
  public static AnimationInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new File(paramString, "play.cfg");
    if (((File)localObject).exists()) {
      localObject = a((File)localObject);
    } else {
      localObject = null;
    }
    ArrayList localArrayList1;
    if (localObject != null) {
      localArrayList1 = ((AnimationInfo)localObject).a();
    } else {
      localArrayList1 = null;
    }
    int m = 0;
    int i = 0;
    int k = 0;
    if ((localObject != null) && (localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      paramString = new File(paramString).listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        AnimationTools.a(paramString);
        ArrayList localArrayList2 = new ArrayList();
        i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i] != null) && (paramString[i].isFile()) && (FileUtils.d(paramString[i].getAbsolutePath()))) {
            localArrayList2.add(paramString[i]);
          }
          i += 1;
        }
        SparseArray localSparseArray = new SparseArray();
        int j = 0;
        i = 0;
        while (j < localArrayList2.size())
        {
          int n = j + 1;
          if (localArrayList1.contains(Integer.valueOf(n)))
          {
            try
            {
              paramString = new BitmapDrawable(((File)localArrayList2.get(j)).getAbsolutePath());
            }
            catch (OutOfMemoryError paramString)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("decode fail - OutOfMemoryError");
                localStringBuilder.append(paramString);
                QLog.e("AnimationView", 2, localStringBuilder.toString());
              }
              i = 1;
              paramString = null;
            }
            if ((i == 0) && (paramString != null) && (paramString.getBitmap() != null)) {
              localSparseArray.append(n, paramString);
            }
          }
          else
          {
            j = n;
            continue;
          }
          i = k;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("decode fail till");
            paramString.append(((File)localArrayList2.get(j)).getAbsolutePath());
            QLog.e("AnimationView", 2, paramString.toString());
            i = k;
          }
          while (i < localSparseArray.size())
          {
            AnimationTools.a((Drawable)localSparseArray.valueAt(i));
            i += 1;
          }
          return null;
        }
        if (localArrayList1.size() != localSparseArray.size())
        {
          i = m;
          while (i < localSparseArray.size())
          {
            AnimationTools.a((Drawable)localSparseArray.valueAt(i));
            i += 1;
          }
          return null;
        }
        ((AnimationInfo)localObject).e = localSparseArray;
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AnimationView", 2, "nothing in unzip folder");
      }
      return null;
    }
    paramString = AnimationTools.a(paramString);
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return null;
      }
      localObject = new ArrayList();
      while (i < paramString.length)
      {
        ((ArrayList)localObject).add(paramString[i]);
        i += 1;
      }
      return a((ArrayList)localObject, 100, 100);
    }
    return null;
  }
  
  public static AnimationInfo a(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      AnimationInfo localAnimationInfo = new AnimationInfo(paramInt2, paramInt1, paramInt1);
      for (paramInt1 = 0; paramInt1 < paramArrayList.size(); paramInt1 = paramInt2)
      {
        ArrayList localArrayList = localAnimationInfo.d;
        paramInt2 = paramInt1 + 1;
        localArrayList.add(new AnimationView.PlayItem(paramInt2));
        localAnimationInfo.e.append(paramInt2, paramArrayList.get(paramInt1));
      }
      localAnimationInfo.b();
      return localAnimationInfo;
    }
    return null;
  }
  
  protected static AnimationInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString);
        i = 0;
        int j = ((JSONObject)localObject).optInt("cycle", 0);
        int k = ((JSONObject)localObject).optInt("interval", 100);
        int m = ((JSONObject)localObject).optInt("delay", 100);
        paramString = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("play");
        if ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          AnimationView.PlayItem localPlayItem = AnimationView.PlayItem.a(((JSONArray)localObject).getJSONObject(i));
          if (localPlayItem == null) {
            break label156;
          }
          paramString.add(localPlayItem);
          break label156;
        }
        if (paramString.size() > 0)
        {
          localObject = new AnimationInfo(j, k, m);
          ((AnimationInfo)localObject).d = paramString;
          ((AnimationInfo)localObject).b();
          return localObject;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return null;
      label156:
      i += 1;
    }
  }
  
  protected ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.d;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.d.size())
      {
        localObject = (AnimationView.PlayItem)this.d.get(i);
        if (localObject != null)
        {
          localObject = ((AnimationView.PlayItem)localObject).a();
          int j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            if (!localArrayList.contains(((ArrayList)localObject).get(j))) {
              localArrayList.add(((ArrayList)localObject).get(j));
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    this.g = -1;
    this.h = -1;
    this.f.clear();
    int i = 0;
    while (i < this.d.size())
    {
      AnimationView.PlayItem localPlayItem = (AnimationView.PlayItem)this.d.get(i);
      if (localPlayItem != null) {
        if (localPlayItem.d > 0)
        {
          this.f.add(Integer.valueOf(localPlayItem.d));
        }
        else if ((localPlayItem.b > 0) && (localPlayItem.c > 0) && (localPlayItem.c > localPlayItem.b))
        {
          int k = localPlayItem.a;
          int j = k;
          if (k <= 0) {
            j = 1;
          }
          k = 0;
          while (k < j)
          {
            int m = localPlayItem.b;
            while (m < localPlayItem.c + 1)
            {
              this.f.add(Integer.valueOf(m));
              m += 1;
            }
            k += 1;
          }
          if (localPlayItem.a == 0)
          {
            this.g = localPlayItem.b;
            this.h = localPlayItem.c;
            return;
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */